/**
 * ubershader.fp
 * 
 * Fragment shader for the "ubershader" which lights the contents of the gbuffer. This shader
 * samples from the gbuffer and then computes lighting depending on the material type of this 
 * fragment.
 * 
 * Written for Cornell CS 5625 (Interactive Computer Graphics).
 * Copyright (c) 2012, Computer Science Department, Cornell University.
 * 
 * @author Asher Dunn (ad488), Sean Ryan (ser99), Ivo Boyadzhiev (iib2)
 * @date 2012-03-24
 */

/* Copy the IDs of any new materials here. */
const int UNSHADED_MATERIAL_ID = 1;
const int LAMBERTIAN_MATERIAL_ID = 2;
const int BLINNPHONG_MATERIAL_ID = 3;
const int COOKTORRANCE_MATERIAL_ID = 4;
const int ISOTROPIC_WARD_MATERIAL_ID = 5;
const int ANISOTROPIC_WARD_MATERIAL_ID = 6;

/* Some constant maximum number of lights which GLSL and Java have to agree on. */
#define MAX_LIGHTS 40

/* Samplers for each texture of the GBuffer. */
uniform sampler2DRect DiffuseBuffer;
uniform sampler2DRect PositionBuffer;
uniform sampler2DRect MaterialParams1Buffer;
uniform sampler2DRect MaterialParams2Buffer;
uniform sampler2DRect SilhouetteBuffer; // Unused in PA1.

/* Uniform specifying the sky (background) color. */
uniform vec3 SkyColor;

/* Uniforms describing the lights. */
uniform int NumLights;
uniform vec3 LightPositions[MAX_LIGHTS];
uniform vec3 LightAttenuations[MAX_LIGHTS];
uniform vec3 LightColors[MAX_LIGHTS];

/* Decodes a vec2 into a normalized vector See Renderer.java for more info. */
vec3 decode(vec2 v)
{
	vec3 n;
	n.z = 2.0 * length(v.xy) - 1.0;
	n.xy = normalize(v.xy) * sqrt(1.0 - n.z*n.z);
	return n;
}

/**
 * Performs Lambertian shading on the passed fragment data (color, normal, etc.) for a single light.
 * 
 * @param diffuse The diffuse color of the material at this fragment.
 * @param position The eyespace position of the surface at this fragment.
 * @param normal The eyespace normal of the surface at this fragment.
 * @param lightPosition The eyespace position of the light to compute lighting from.
 * @param lightColor The color of the light to apply.
 * @param lightAttenuation A vector of (constant, linear, quadratic) attenuation coefficients for this light.
 * 
 * @return The shaded fragment color; for Lambertian, this is `lightColor * diffuse * n_dot_l`.
 */
vec3 shadeLambertian(vec3 diffuse, vec3 position, vec3 normal, vec3 lightPosition, vec3 lightColor, vec3 lightAttenuation)
{
	vec3 lightDirection = normalize(lightPosition - position);
	float ndotl = max(0.0, dot(normal, lightDirection));
	
	float r = length(lightPosition - position);
	float attenuation = 1.0 / dot(lightAttenuation, vec3(1.0, r, r * r));
	
	return lightColor * attenuation * diffuse * ndotl;
}

/**
 * Performs Blinn-Phong shading on the passed fragment data (color, normal, etc.) for a single light.
 *  
 * @param diffuse The diffuse color of the material at this fragment.
 * @param specular The specular color of the material at this fragment.
 * @param exponent The Phong exponent packed into the alpha channel. 
 * @param position The eyespace position of the surface at this fragment.
 * @param normal The eyespace normal of the surface at this fragment.
 * @param lightPosition The eyespace position of the light to compute lighting from.
 * @param lightColor The color of the light to apply.
 * @param lightAttenuation A vector of (constant, linear, quadratic) attenuation coefficients for this light.
 * 
 * @return The shaded fragment color.
 */
vec3 shadeBlinnPhong(vec3 diffuse, vec3 specular, float exponent, vec3 position, vec3 normal,
	vec3 lightPosition, vec3 lightColor, vec3 lightAttenuation)
{
	vec3 viewDirection = -normalize(position);
	vec3 lightDirection = normalize(lightPosition - position);
	vec3 halfDirection = normalize(lightDirection + viewDirection);
		
	float ndotl = max(0.0, dot(normal, lightDirection));
	float ndoth = max(0.0, dot(normal, halfDirection));
	
	float pow_ndoth = (ndotl > 0.0 && ndoth > 0.0 ? pow(ndoth, exponent) : 0.0);


	float r = length(lightPosition - position);
	float attenuation = 1.0 / dot(lightAttenuation, vec3(1.0, r, r * r));
	
	return lightColor * attenuation * (diffuse * ndotl + specular * pow_ndoth);
}

/**
 * Performs Cook-Torrance shading on the passed fragment data (color, normal, etc.) for a single light.
 * 
 * @param diffuse The diffuse color of the material at this fragment.
 * @param specular The specular color of the material at this fragment.
 * @param m The microfacet rms slope at this fragment.
 * @param n The index of refraction at this fragment.
 * @param position The eyespace position of the surface at this fragment.
 * @param normal The eyespace normal of the surface at this fragment.
 * @param lightPosition The eyespace position of the light to compute lighting from.
 * @param lightColor The color of the light to apply.
 * @param lightAttenuation A vector of (constant, linear, quadratic) attenuation coefficients for this light.
 * 
 * @return The shaded fragment color.
 */
vec3 shadeCookTorrance(vec3 diffuse, vec3 specular, float m, float n, vec3 position, vec3 normal,
    vec3 lightPosition, vec3 lightColor, vec3 lightAttenuation)
{
    vec3 viewDirection = -normalize(position);
    vec3 lightDirection = normalize(lightPosition - position);
    vec3 halfDirection = normalize(lightDirection + viewDirection);
    vec3 finalColor = vec3(0.0);
    
    float PI = 3.14159265358979;

    // TODO PA1: Complete the Cook-Torrance shading function.
    float n_dot_l = max(0.0, dot(normal, lightDirection));
    float n_dot_v = max(0.0, dot(normal, viewDirection));
    float n_dot_h = max(0.0, dot(normal, halfDirection));
    float v_dot_h = max(0.0, dot(viewDirection, halfDirection));
    float a = acos(n_dot_h);
    
    float R0 = pow((1.0-n)/(1.0+n),2.0);
    
    float F = R0 + (1.0-R0)*pow(1.0-cos(acos(v_dot_h)),5.0);
    float D = 1.0/(4.0*m*m*pow(cos(a),4.0))*exp(-pow(tan(a)/m,2.0));
    float G = min(1.0,min(2.0*n_dot_h*n_dot_v/v_dot_h,2.0*n_dot_h*n_dot_l/v_dot_h));
    
    float ctspec = min(1.0,F*D*G/(n_dot_l*n_dot_v*PI));
    
    finalColor = diffuse*n_dot_l + ctspec*specular*n_dot_l;
        
    return finalColor;
}


/**
 * Performs Anisotropic Ward shading on the passed fragment data (color, normal, etc.) for a single light.
 * 
 * @param diffuse The diffuse color of the material at this fragment.
 * @param specular The specular color of the material at this fragment.
 * @param alpha_x The surface roughness in x.
 * @param alpha_y The surface roughness in y. 
 * @param position The eyespace position of the surface at this fragment.
 * @param normal The eyespace normal of the surface at this fragment.
 * @param tangent The eyespace tangent vector at this fragment.
 * @param bitangent The eyespace bitangent vector at this fragment.
 * @param lightPosition The eyespace position of the light to compute lighting from.
 * @param lightColor The color of the light to apply.
 * @param lightAttenuation A vector of (constant, linear, quadratic) attenuation coefficients for this light.
 * 
 * @return The shaded fragment color.
 */
vec3 shadeAnisotropicWard(vec3 diffuse, vec3 specular, float alphaX, float alphaY, vec3 position, vec3 normal,
	vec3 tangent, vec3 bitangent, vec3 lightPosition, vec3 lightColor, vec3 lightAttenuation)
{
	vec3 viewDirection = -normalize(position);
	vec3 lightDirection = normalize(lightPosition - position);
	vec3 halfDirection = normalize(lightDirection + viewDirection);
	vec3 finalColor = vec3(0.0);

	// TODO PA1: Complete the Anisotropic Ward shading function.
	float PI = 3.14159265359;
	
	float n_dot_l = max(0.0, dot(normal, lightDirection));
	float n_dot_v = max(0.0, dot(normal, viewDirection));
	float n_dot_h = max(0.0, dot(normal, halfDirection));
	float l_dot_v = max(0.0, dot(lightDirection, viewDirection));
	
	float specularTerm = 0.0;
	
	if (n_dot_v > 0.0) {
		//float alphaSquared = alpha * alpha;
		float tanTerm = tan(acos(n_dot_h));
		specularTerm = sqrt(n_dot_l / n_dot_v) / (4.0 * PI * alphaX * alphaY);
		float h_dot_tan_alpha = dot(halfDirection, tangent)/alphaX;
		float h_dot_tan_sqr = h_dot_tan_alpha * h_dot_tan_alpha;
		float h_dot_bitan_alpha = dot(halfDirection, bitangent)/alphaY;
		float h_dot_bitan_sqr = h_dot_bitan_alpha * h_dot_bitan_alpha;
		specularTerm *= exp(-2.0*((h_dot_tan_sqr+h_dot_bitan_sqr)/(1.0+n_dot_h)));
		specularTerm = min(1.0,specularTerm);
	}
	
	finalColor = diffuse * n_dot_l + specular * specularTerm;
	
	
	
	return finalColor;
}

/**
 * Performs Isotropic Ward shading on the passed fragment data (color, normal, etc.) for a single light.
 * 
 * @param diffuse The diffuse color of the material at this fragment.
 * @param specular The specular color of the material at this fragment.
 * @param alpha The surface roughness. 
 * @param position The eyespace position of the surface at this fragment.
 * @param normal The eyespace normal of the surface at this fragment.
 * @param lightPosition The eyespace position of the light to compute lighting from.
 * @param lightColor The color of the light to apply.
 * @param lightAttenuation A vector of (constant, linear, quadratic) attenuation coefficients for this light.
 * 
 * @return The shaded fragment color.
 */
vec3 shadeIsotropicWard(vec3 diffuse, vec3 specular, float alpha, vec3 position, vec3 normal,
	vec3 lightPosition, vec3 lightColor, vec3 lightAttenuation)
{
	vec3 viewDirection = -normalize(position);
	vec3 lightDirection = normalize(lightPosition - position);
	vec3 halfDirection = normalize(lightDirection + viewDirection);
	vec3 finalColor = vec3(0.0);

	// TODO PA1: Complete the Isotropic Ward shading function.
	float PI = 3.14159265359;
	
	float n_dot_l = max(0.0, dot(normal, lightDirection));
	float n_dot_v = max(0.0, dot(normal, viewDirection));
	float n_dot_h = max(0.0, dot(normal, halfDirection));
	float l_dot_v = max(0.0, dot(lightDirection, viewDirection));
	
	float specularTerm = 0.0;
	
	if (n_dot_v > 0.0) {
		float alphaSquared = alpha * alpha;
		float tanTerm = tan(acos(n_dot_h));
		specularTerm = sqrt(n_dot_l / n_dot_v) / (4.0 * PI * alphaSquared);
		specularTerm *= exp(-(tanTerm * tanTerm) / alphaSquared);
	}
	
	finalColor = diffuse * n_dot_l + specular * specularTerm;
	
	
	return finalColor;
}


void main()
{
	/* Sample gbuffer. */
	vec3 diffuse         = texture2DRect(DiffuseBuffer, gl_FragCoord.xy).xyz;
	vec3 position        = texture2DRect(PositionBuffer, gl_FragCoord.xy).xyz;
	vec4 materialParams1 = texture2DRect(MaterialParams1Buffer, gl_FragCoord.xy);
	vec4 materialParams2 = texture2DRect(MaterialParams2Buffer, gl_FragCoord.xy);
	vec3 normal          = decode(vec2(texture2DRect(DiffuseBuffer, gl_FragCoord.xy).a,
	                                   texture2DRect(PositionBuffer, gl_FragCoord.xy).a));
	
	/* Initialize fragment to black. */
	gl_FragColor = vec4(0.0, 0.0, 0.0, 1.0);

	/* Branch on material ID and shade as appropriate. */
	int materialID = int(materialParams1.x);

	if (materialID == 0)
	{
		/* Must be a fragment with no geometry, so set to sky (background) color. */
		gl_FragColor = vec4(SkyColor, 1.0);
	}
	else if (materialID == UNSHADED_MATERIAL_ID)
	{
		/* Unshaded material is just a constant color. */
		gl_FragColor.rgb = diffuse;
	}
	
	// TODO PA1: Add logic to handle all other material IDs. Remember to loop over all NumLights.
	else if (materialID == LAMBERTIAN_MATERIAL_ID) {
		for (int i = 0; i < NumLights; i++) {
		 	gl_FragColor.rgb += shadeLambertian(diffuse, position, normal, LightPositions[i], LightColors[i], LightAttenuations[i]);
		}
	} else if (materialID == BLINNPHONG_MATERIAL_ID) {
		vec3 specular = materialParams1.gba;
		float n = materialParams2.x;
		for (int i = 0; i < NumLights; i++) {
			gl_FragColor.rgb += shadeBlinnPhong(diffuse, specular, n, position, normal,
				LightPositions[i], LightColors[i], LightAttenuations[i]);
		}
	} else if (materialID == COOKTORRANCE_MATERIAL_ID) {
		vec3 specular = materialParams1.gba;
		float m = materialParams2.x;
		float n = materialParams2.y;
		for (int i = 0; i < NumLights; i++) {
			gl_FragColor.rgb += shadeCookTorrance(diffuse, specular, m, n, position, normal,
				LightPositions[i], LightColors[i], LightAttenuations[i]);
		}
	} else if (materialID == ISOTROPIC_WARD_MATERIAL_ID) {
		vec3 specular = materialParams1.gba;
		float alpha = materialParams2.x;
		for (int i = 0; i < NumLights; i++) {
			gl_FragColor.rgb += shadeIsotropicWard(diffuse, specular, alpha, position, normal,
				LightPositions[i], LightColors[i], LightAttenuations[i]);
		}
	} else if (materialID == ANISOTROPIC_WARD_MATERIAL_ID || materialID == -ANISOTROPIC_WARD_MATERIAL_ID) {
		vec3 specular = materialParams1.gba;
		float alphaX = materialParams2.x;
		float alphaY = materialParams2.y;
		vec3 tangent = normalize(decode(materialParams2.zw));
		vec3 bitangent = normalize(cross(normal, tangent)/* *float(ANISOTROPIC_WARD_MATERIAL_ID)*/);
		for (int i = 0; i < NumLights; i++) {
			gl_FragColor.rgb += shadeAnisotropicWard(diffuse, specular, alphaX, alphaY, position, normal,
				tangent, bitangent, LightPositions[i], LightColors[i], LightAttenuations[i]);
		}
	}
	
	
	else
	{
		/* Unknown material, so just use the diffuse color. */
		gl_FragColor.rgb = diffuse;
	}
}
