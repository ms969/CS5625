/**
 * material_normal_map.fp
 * 
 * Vertex shader shader which writes material information needed for Normal Map shading to
 * the gbuffer.
 * 
 * Written for Cornell CS 5625 (Interactive Computer Graphics).
 * Copyright (c) 2012, Computer Science Department, Cornell University.
 * 
 * @author Asher Dunn (ad488), John DeCorato (jd537), Sean Ryan (ser99), Ivo Boyadzhiev (iib2)
 * @date 2013-02-2012
 */
 
 #version 110
 
 /* ID of Blinn-Phong material, since the normal map only effects things pre-color computation. */
const int BLINNPHONG_MATERIAL_ID = 3;

/* Material properties passed from the application. */
uniform vec3 DiffuseColor;
uniform vec3 SpecularColor;
uniform float PhongExponent;

/* Textures and flags for whether they exist. */
uniform sampler2D DiffuseTexture;
uniform sampler2D SpecularTexture;
uniform sampler2D ExponentTexture;
uniform sampler2D NormalTexture;

uniform bool HasDiffuseTexture;
uniform bool HasSpecularTexture;
uniform bool HasExponentTexture;
uniform bool HasNormalTexture;

varying vec3 EyespacePosition;
varying vec3 EyespaceNormal;
varying vec2 TexCoord;

varying vec3 EyespaceTangent;
varying vec3 EyespaceBiTangent;

/* Encodes a normalized vector as a vec2. See Renderer.java for more info. */
vec2 encode(vec3 n)
{
	return normalize(n.xy) * sqrt(0.5 * n.z + 0.5);
}

void main()
{
	// TODO PA2: Store diffuse color, position, encoded normal, material ID, and all other useful data in the g-buffer.
	//			 Use the normal map and tangent vectors to get a new normal.
	
	// get a new normal
	vec2 enc_normal;
	if (HasNormalTexture) {
		// TODO: need to re-orthogonalize tangent and bitangent
		// T' = T-(N dot T)N
		float n_dot_t = dot(EyespaceNormal, EyespaceTangent);
		vec3 normal_s = EyespaceNormal * n_dot_t;
		vec3 tan_orth = normalize(EyespaceTangent - normal_s);
		
		// B' = B - (N dot B)N - (T' dot B)T'/T'^2
		float n_dot_b = dot(EyespaceNormal, EyespaceBiTangent);
		normal_s = EyespaceNormal * n_dot_b;
		float scalar = dot(tan_orth, EyespaceBiTangent)/dot(tan_orth, tan_orth);
		vec3 tangent_s = scalar * tan_orth;
		vec3 bitan_orth = EyespaceBiTangent - normal_s - tangent_s;
		
		vec3 normalTex = normalize(texture2D(NormalTexture, TexCoord).xyz - vec3(0.5));
		mat3 TBN = mat3(tan_orth, bitan_orth, EyespaceNormal);
		vec3 new_norm = normalize(TBN * normalTex);
		enc_normal = encode(new_norm);
	} else {
		enc_normal = encode(EyespaceNormal);
	}
	
	if (HasDiffuseTexture) {
		gl_FragData[0] = vec4(texture2D(DiffuseTexture, TexCoord).rgb*DiffuseColor, enc_normal.x);
	} else {
		gl_FragData[0] = vec4(DiffuseColor, enc_normal.x);
	}
	
	gl_FragData[1] = vec4(EyespacePosition, enc_normal.y);
	
	if (HasSpecularTexture) {
		gl_FragData[2] = vec4(float(BLINNPHONG_MATERIAL_ID), texture2D(SpecularTexture, TexCoord).rgb*SpecularColor);
	} else {
		gl_FragData[2] = vec4(float(BLINNPHONG_MATERIAL_ID), SpecularColor);
	}
	
	if (HasExponentTexture) {
		gl_FragData[3] = vec4(float(texture2D(ExponentTexture, TexCoord).x*255.0), 0.0, 0.0, 0.0);
	} else {
		gl_FragData[3] = vec4(PhongExponent, 0.0, 0.0, 0.0);
	}
	
}