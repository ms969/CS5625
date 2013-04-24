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
 * @author Asher Dunn (ad488), Ivaylo Boyadzhiev (iib2)
 * @date 2012-03-24
 */

/* Copy the IDs of any new materials here. */
const int UNSHADED_MATERIAL_ID = 1;
const int LAMBERTIAN_MATERIAL_ID = 2;
const int BLINNPHONG_MATERIAL_ID = 3;
const int COOKTORRANCE_MATERIAL_ID = 4;
const int ISOTROPIC_WARD_MATERIAL_ID = 5;
const int ANISOTROPIC_WARD_MATERIAL_ID = 6;
const int REFLECTION_MATERIAL_ID = 7;

/* Some constant maximum number of lights which GLSL and Java have to agree on. */
#define MAX_LIGHTS 40

/* Samplers for each texture of the GBuffer. */
uniform sampler2DRect DiffuseBuffer;
uniform sampler2DRect PositionBuffer;
uniform sampler2DRect MaterialParams1Buffer;
uniform sampler2DRect MaterialParams2Buffer;
uniform sampler2DRect SilhouetteBuffer;

/* Pass the inverse eye/camera matrix, that can transform points from eye to world space. */
uniform mat3 CameraInverseRotation;

/* Cube map textures */
uniform samplerCube StaticCubeMapTexture;

/* Some constant maximum number of dynamic cube maps which GLSL and Java have to agree on. */
#define MAX_DYNAMIC_CUBE_MAPS 3

uniform samplerCube DynamicCubeMapTexture0;
uniform samplerCube DynamicCubeMapTexture1;
uniform samplerCube DynamicCubeMapTexture2;

uniform bool EnableToonShading;

/* Uniform specifying the sky (background) color. */
uniform vec3 SkyColor;

/* Uniforms describing the lights. */
uniform int NumLights;
uniform vec3 LightPositions[MAX_LIGHTS];
uniform vec3 LightAttenuations[MAX_LIGHTS];
uniform vec3 LightColors[MAX_LIGHTS];

/* Shadow depth textures and information */
uniform int HasShadowMaps;
uniform sampler2D ShadowMap;
uniform int ShadowMode;
uniform vec3 ShadowCamPosition;
uniform float bias;
uniform float ShadowSampleWidth;
uniform float ShadowMapWidth;
uniform float ShadowMapHeight;
uniform float LightWidth;

#define DEFAULT_SHADOW_MAP 0
#define PCF_SHADOW_MAP 1
#define PCSS SHADOW_MAP 2

/* Pass the shadow camera Projection * View matrix to help transform points, as well the Camera inverse-view Matrix */
uniform mat4 LightMatrix;
uniform mat4 InverseViewMatrix;

/* Decodes a vec2 into a normalized vector See Renderer.java for more info. */
vec3 decode(vec2 v)
{
	vec3 n;
	n.z = 2.0 * dot(v.xy, v.xy) - 1.0;
	n.xy = normalize(v.xy) * sqrt(1.0 - n.z*n.z);
	return n;
}

// Converts the depth buffer value to a linear value (Normalized Device Coordinate - NDC)
// return value of this function can compare directly to z-buffer values
float DepthToLinear(float value)
{
	float near = 0.1;
	float far = 100.0;
	return (2.0 * near) / (far + near - value * (far - near));
}

/** Returns a binary value for if this location is shadowed. 0 = shadowed, 1 = not shadowed.
 * helper for reading ShadowMap texture for PCF and PCSS
 */
float getShadowVal(vec4 shadowCoord, vec2 offset) {
	// TODO PA3: Implement this function (see above).
	// shadowCoord is [0,1], need to convert to pixel
	vec2 textureCoord = vec2(shadowCoord.x*ShadowMapWidth, shadowCoord.y*ShadowMapHeight);
	textureCoord = textureCoord + offset;
	// converting back to [0,1] to read from texture
	textureCoord = vec2(textureCoord.x/ShadowMapWidth, textureCoord.y/ShadowMapHeight);
	return texture2D(ShadowMap, textureCoord).x;
}

/** Calculates regular shadow map algorithm shadow strength
 *
 * @param shadowCoord The location of the position in the light projection space
 */
 float getDefaultShadowMapVal(vec4 shadowCoord) {
 	// TODO PA3: Implement this function (see above).
	
 	// coord.z is the z-buffer value
 	float pointZValue = shadowCoord.z;
 	
 	// compare this to shadow map value with bias
 	float shadowMapZValue = texture2D(ShadowMap, shadowCoord.xy).z;
 	if (pointZValue > shadowMapZValue + bias) {
 		return 0.0;
 	} else {
		return 1.0;
	}
 }
 
/** Calculates PCF shadow map algorithm shadow strength
 *
 * @param shadowCoord The location of the position in the light projection space
 */
 float getPCFShadowMapVal(vec4 shadowCoord) {
 	// TODO PA3: Implement this function (see above).
 	// ShadowSampleWidth
 	
 	
 	// count of unoccluded pixels
 	float m = 0.0;
 	for (float i = -ShadowSampleWidth; i <= ShadowSampleWidth; i += 1.0) {
 		for (float j = -ShadowSampleWidth; j <= ShadowSampleWidth; j += 1.0) {
			float shadowMapZValue = getShadowVal(shadowCoord, vec2(i, j));
			if (shadowCoord.z <= shadowMapZValue + bias) {
		 		// unoccluded pixel
		 		m = m + 1.0;
		 	}
 		}
 	}
 	float n = pow(ShadowSampleWidth * 2.0 + 1.0, 2.0);
 	return m/n;
 }
 
 /** Calculates PCSS shadow map algorithm shadow strength
 *
 * @param shadowCoord The location of the position in the light projection space
 */
float getPCSSShadowMapVal(vec4 shadowCoord) {
 	float near = 0.1;
 	float far = 100.0;
 	
 	// TODO PA3: Implement this function (see above).
 	// find d_blocker
 	float shadow_z = DepthToLinear(shadowCoord.z);
 	float searchWidth = LightWidth * (shadow_z - near) / shadow_z;
 	float searchRadius = floor(max(1.0, searchWidth/2.0));
 	
 	float shadowTotal = 0.0;
 	float shadowCount = 0.0;
 	for (float i = -searchRadius; i <= searchRadius; i+=1.0) {
 		for (float j = -searchRadius; j <= searchRadius; j+=1.0) {
 			float shadowVal = getShadowVal(shadowCoord, vec2(i, j));
 			if (shadowVal < shadowCoord.z + bias) {
 				shadowTotal += shadowVal;
 				shadowCount += 1.0;
 			}
 		}
 	}
 	if (shadowCount <= 0.0) {
 		return 1.0;
 	}
 	float d_blocker = shadowTotal / shadowCount;
 	d_blocker = DepthToLinear(d_blocker);
 	
 	// find w_penumbra
 	float w_pen = (shadow_z - d_blocker) * LightWidth / d_blocker;
 	w_pen = floor(max(1.0, w_pen));
 	
 	// count of unoccluded pixels
 	float m = 0.0;
 	for (float i = -w_pen; i <= w_pen; i += 1.0) {
 		for (float j = -w_pen; j <= w_pen; j += 1.0) {
			float shadowMapZValue = getShadowVal(shadowCoord, vec2(i, j));
			if (shadowCoord.z < shadowMapZValue + bias) {
		 		// unoccluded pixel
		 		m = m + 1.0;
		 	}
 		}
 	}
 	float n = pow(w_pen * 2.0 + 1.0, 2.0);
 	return m/n;
}

/** Gets the shadow value based on the current shadowing mode
 *
 * @param position The eyespace position of the surface at this fragment
 *
 * @return A 0-1 value for how shadowed the object is. 0 = shadowed and 1 = lit
 */
float getShadowStrength(vec3 position) {
	// TODO PA3: Transform position to ShadowCoord
	mat4 biasMatrix = mat4(0.5, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.5, 0.5, 0.5, 1.0);
	vec4 ShadowCoord = biasMatrix * LightMatrix * InverseViewMatrix * vec4(position, 1.0);
	ShadowCoord = ShadowCoord/ShadowCoord.w;
	
	if (ShadowMode == DEFAULT_SHADOW_MAP) {
		return getDefaultShadowMapVal(ShadowCoord);
	} else if (ShadowMode == PCF_SHADOW_MAP) {
		return getPCFShadowMapVal(ShadowCoord);
	} else {
		return getPCSSShadowMapVal(ShadowCoord);
	}
}

/**
 * Sample a cube map, based on a given index. If index = 1,
 * this means to sample the static cube map, otherwise we
 * will sample the corresponding dynamic cube map.
 *
 * @param reflectedDirection The reflected vector in world space.
 * @param cubeMapIndex The index, identifying the cube map.
 * 
 * @return The color of the sample.
 */
vec3 sampleCubeMap(vec3 reflectedDirection, int cubeMapIndex)
{
	/* Transform the index, so that	valid values will be within 
	   [-1, MAX_DYNAMIC_CUBE_MAPS - 1], where -1 means to sample 
	   the static cube map, and values larger than 0 will be identified 
	   with the dynamic cube maps. */
 	   
   	cubeMapIndex = cubeMapIndex - 2; 	   
 	   	
 	vec3 sampledColor = vec3(0.0);
 	
	if (cubeMapIndex == -1) { /* Sample the static cube map */
		sampledColor = textureCube(StaticCubeMapTexture, reflectedDirection).xyz;
	} else if (cubeMapIndex == 0) {
		sampledColor = textureCube(DynamicCubeMapTexture0, reflectedDirection).xyz;
	} else if (cubeMapIndex == 1) {
		sampledColor = textureCube(DynamicCubeMapTexture1, reflectedDirection).xyz;
	} else if (cubeMapIndex == 2) {
		sampledColor = textureCube(DynamicCubeMapTexture2, reflectedDirection).xyz;
	} 	 	 	 	
	
	return sampledColor;
}


/**
 * Mix the base color of a pixel (e.g. computed by Cook-Torrance) with the reflected color from an environment map.
 * The base color and reflected color are linearly mixed based on the Fresnel term at this fragment. The Fresnel term is 
 * computed based on the cosine of the angle between the view vector and the normal, using Schlick's approximation.
 *
 * @param cubeMapIndex The ID of the cube map
 * @param baseColor The base color computed so far (aka. contribution from all lights was added)
 * @param position The eyespace position of the surface at this fragment.
 * @param normal The eyespace normal of the surface at this fragment.
 * @param n The index of refraction at this fragment.
 * 
 * @return The final color, mixture of base and reflected color.
 */
vec3 mixEnvMapWithBaseColor(int cubeMapIndex, vec3 baseColor, vec3 position, vec3 normal, float n) {
	// TODO PA2: Implement the requirements of this function. 
	// Hint: You can use the GLSL command mix to linearly blend between two colors.
	vec3 view = -normalize(CameraInverseRotation*position);
	vec3 wNormal = normalize(CameraInverseRotation*normal);
	vec3 reflected = reflect(view,wNormal);
	vec3 reflectedColor = sampleCubeMap(reflected, cubeMapIndex);
	float r0 = pow((1.0-n)/(1.0+n), 2.0);
	float cos_theta = dot(wNormal, view);
	float fresnel_factor = r0 + (1.0 - r0) * pow(1.0 - cos_theta, 5.0);
	return mix(baseColor, reflectedColor, fresnel_factor);
}

/**
 * Performs the "3x3 nonlinear filter" mentioned in Decaudin 1996 to detect silhouettes
 * based on the silhouette buffer.
 */
float silhouetteStrength()
{
	// TODO PA3 Prereq (Optional): Paste in your silhouetteStrength code if you like toon shading.
	// TODO PA2: Compute the silhouette strength (see page 7 of Decaudin 1996).
	//           Hint: You have to use texture2DRect to sample the silhouette buffer,
	//                 it expects pixel indices instead of texture coordinates. Use
	//                 gl_FragCoord.xy to get the current pixel.
	vec4 A = texture2DRect(SilhouetteBuffer, vec2(gl_FragCoord.x-1.0, gl_FragCoord.y+1.0));
	vec4 B = texture2DRect(SilhouetteBuffer, vec2(gl_FragCoord.x, gl_FragCoord.y+1.0));
	vec4 C = texture2DRect(SilhouetteBuffer, vec2(gl_FragCoord.x+1.0, gl_FragCoord.y+1.0));
	
	vec4 D = texture2DRect(SilhouetteBuffer, vec2(gl_FragCoord.x-1.0, gl_FragCoord.y));
	vec4 x = texture2DRect(SilhouetteBuffer, vec2(gl_FragCoord.x, gl_FragCoord.y));
	vec4 E = texture2DRect(SilhouetteBuffer, vec2(gl_FragCoord.x+1.0, gl_FragCoord.y));
	
	vec4 F = texture2DRect(SilhouetteBuffer, vec2(gl_FragCoord.x-1.0, gl_FragCoord.y-1.0));
	vec4 G = texture2DRect(SilhouetteBuffer, vec2(gl_FragCoord.x, gl_FragCoord.y-1.0));
	vec4 H = texture2DRect(SilhouetteBuffer, vec2(gl_FragCoord.x+1.0, gl_FragCoord.y-1.0));
	
	float gminx = min(A.x, min(B.x, C.x));
	gminx = min(gminx, min(D.x, min(x.x, E.x)));
	gminx = min(gminx, min(F.x, min(G.x, H.x)));
	
	float gminy = min(A.y, min(B.y, C.y));
	gminy = min(gminy, min(D.y, min(x.y, E.y)));
	gminy = min(gminy, min(F.y, min(G.y, H.y)));
	
	float gminz = min(A.z, min(B.z, C.z));
	gminz = min(gminz, min(D.z, min(x.z, E.z)));
	gminz = min(gminz, min(F.z, min(G.z, H.z)));
	
	float gminw = min(A.w, min(B.w, C.w));
	gminw = min(gminw, min(D.w, min(x.w, E.w)));
	gminw = min(gminw, min(F.w, min(G.w, H.w)));
	
	float gmaxx = max(A.x, max(B.x, C.x));
	gmaxx = max(gmaxx, max(D.x, max(x.x, E.x)));
	gmaxx = max(gmaxx, max(F.x, max(G.x, H.x)));
	
	float gmaxy = max(A.y, max(B.y, C.y));
	gmaxy = max(gmaxy, max(D.y, max(x.y, E.y)));
	gmaxy = max(gmaxy, max(F.y, max(G.y, H.y)));
	
	float gmaxz = max(A.z, max(B.z, C.z));
	gmaxz = max(gmaxz, max(D.z, max(x.z, E.z)));
	gmaxz = max(gmaxz, max(F.z, max(G.z, H.z)));
	
	float gmaxw = max(A.w, max(B.w, C.w));
	gmaxw = max(gmaxw, max(D.w, max(x.w, E.w)));
	gmaxw = max(gmaxw, max(F.w, max(G.w, H.w)));
	
	float xTerm = pow((gmaxx-gminx)/0.3, 2.0);
	float yTerm = pow((gmaxy-gminy)/0.3, 2.0);
	float zTerm = pow((gmaxz-gminz)/0.3, 2.0);
	float wTerm = pow((gmaxw-gminw)/0.3, 2.0);
	
	return min(xTerm + yTerm + zTerm + wTerm, 1.0);
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

	// TODO PA2: Update this function to threshold its n.l and n.h values if toon shading is enabled.	
	if (EnableToonShading) {
		if (ndotl < 0.1) {
			ndotl = 0.0;
		} else {
			ndotl = 1.0;
		}
	}
	
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
	
	// TODO PA2: Update this function to threshold its n.l and n.h values if toon shading is enabled.	
	if (EnableToonShading) {
		if (ndotl < 0.1) {
			ndotl = 0.0;
		} else {
			ndotl = 1.0;
		}
		if (ndoth < 0.9) {
			ndoth = 0.0;
		} else {
			ndoth = 1.0;
		}
	}
	
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
 * @param cubeMapIndex The cube map to sample from (0 means not to use environment map lighting).
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

	// TODO PA1: Complete the Cook-Torrance shading function.
	float PI = 3.14159265359;
	
	float n_dot_l = max(0.0, dot(normal, lightDirection));
    float n_dot_v = max(0.0, dot(normal, viewDirection));
    float n_dot_h = max(0.0, dot(normal, halfDirection));
    float v_dot_h = max(0.0, dot(viewDirection, halfDirection));
    
	if (EnableToonShading) {
		if (n_dot_l < 0.1) {
			n_dot_l = 0.0;
		} else {
			n_dot_l = 1.0;
		}
		if (n_dot_h < 0.9) {
			n_dot_h = 0.0;
		} else {
			n_dot_h = 1.0;
		}
	}
    
    float ctspec = 0.0;
    if (n_dot_v > 0.0 && v_dot_h > 0.0) {
	    float a = acos(n_dot_h);
	    
	    float R0 = pow((1.0-n)/(1.0+n),2.0);
	    
	    float F = R0 + (1.0-R0)*pow(1.0-cos(acos(v_dot_h)),5.0);
	    float D = 1.0/(4.0*m*m*pow(cos(a),4.0))*exp(-pow(tan(a)/m,2.0));
	    float G = min(1.0,min(2.0*n_dot_h*n_dot_v/v_dot_h,2.0*n_dot_h*n_dot_l/v_dot_h));
	    
	    ctspec = min(1.0,F*D*G/(n_dot_l*n_dot_v*PI));
	}
	
    
    finalColor = diffuse*n_dot_l + ctspec*specular*n_dot_l;
	// TODO PA2: Update this function to threshold its n.l and n.h values if toon shading is enabled.	
	
	float r = length(lightPosition - position);
	float attenuation = 1.0 / dot(lightAttenuation, vec3(1.0, r, r * r));
	
	return attenuation * finalColor;
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
	
	// T' = T-(N dot T)N
	float n_dot_t = dot(normal, tangent);
	vec3 normal_s = normal * n_dot_t;
	vec3 tan_orth = normalize(tangent - normal_s);
	
	// B' = B - (N dot B)N - (T' dot B)T'/T'^2
	float n_dot_b = dot(normal, bitangent);
	normal_s = normal * n_dot_b;
	float scalar = dot(tan_orth, bitangent)/dot(tan_orth, tan_orth);
	vec3 tangent_s = scalar * tan_orth;
	vec3 bitan_orth = bitangent - normal_s - tangent_s;
	

	// TODO PA1: Complete the Anisotropic Ward shading function.
	float PI = 3.14159265359;
	
	float n_dot_l = max(0.0, dot(normal, lightDirection));
	float n_dot_v = max(0.0, dot(normal, viewDirection));
	float n_dot_h = max(0.0, dot(normal, halfDirection));
	float l_dot_v = max(0.0, dot(lightDirection, viewDirection));
	
	if (EnableToonShading) {
		if (n_dot_l < 0.1) {
			n_dot_l = 0.0;
		} else {
			n_dot_l = 1.0;
		}
		if (n_dot_h < 0.9) {
			n_dot_h = 0.0;
		} else {
			n_dot_h = 1.0;
		}
	}
	
	float specularTerm = 0.0;
	
	if (n_dot_v > 0.0) {
		//float alphaSquared = alpha * alpha;
		float tanTerm = tan(acos(n_dot_h));
		specularTerm = sqrt(n_dot_l / n_dot_v) / (4.0 * PI * alphaX * alphaY);
		float h_dot_tan_alpha = dot(halfDirection, tan_orth)/alphaX;
		float h_dot_tan_sqr = h_dot_tan_alpha * h_dot_tan_alpha;
		float h_dot_bitan_alpha = dot(halfDirection, bitan_orth)/alphaY;
		float h_dot_bitan_sqr = h_dot_bitan_alpha * h_dot_bitan_alpha;
		specularTerm *= exp(-2.0*((h_dot_tan_sqr+h_dot_bitan_sqr)/(1.0+n_dot_h)));
		specularTerm = min(1.0,specularTerm);
	}
	
	finalColor = diffuse * n_dot_l + specular * specularTerm;
	// TODO PA2: Update this function to threshold its n.l and n.h values if toon shading is enabled.	
	
	float r = length(lightPosition - position);
	float attenuation = 1.0 / dot(lightAttenuation, vec3(1.0, r, r * r));
	
	return attenuation * finalColor;
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
	
	if (EnableToonShading) {
		if (n_dot_l < 0.1) {
			n_dot_l = 0.0;
		} else {
			n_dot_l = 1.0;
		}
		if (n_dot_h < 0.9) {
			n_dot_h = 0.0;
		} else {
			n_dot_h = 1.0;
		}
	}
	
	float specularTerm = 0.0;
	
	if (n_dot_v > 0.0) {
		float alphaSquared = alpha * alpha;
		float tanTerm = tan(acos(n_dot_h));
		specularTerm = sqrt(n_dot_l / n_dot_v) / (4.0 * PI * alphaSquared);
		specularTerm *= exp(-(tanTerm * tanTerm) / alphaSquared);
	}
	
	finalColor = diffuse * n_dot_l + specular * specularTerm;
	// TODO PA2: Update this function to threshold its n.l and n.h values if toon shading is enabled.	
	
	float r = length(lightPosition - position);
	float attenuation = 1.0 / dot(lightAttenuation, vec3(1.0, r, r * r));
	
	return attenuation * finalColor;
}

/**
 * Performs reflective shading on the passed fragment data (normal, position).
 * 
 * @param position The eyespace position of the surface at this fragment.
 * @param normal The eyespace normal of the surface at this fragment.
 * @param cubeMapIndex The id of the cube map to use (1 = static, >2 means dynamic,
 * where the DynamicCubeMapTexture{cubeMapIndex - 2} sampeld object will be used).
 * 
 * @return The reflected color.
 */
vec3 shadeReflective(vec3 position, vec3 normal, int cubeMapIndex)
{	
	// TODO PA2: Implement a perfect mirror material using environment map lighting.
	
	vec3 view = -normalize(CameraInverseRotation*position);
	vec3 wNormal = normalize(CameraInverseRotation*normal);
	//vec3 reflected = 2.0 * dot(wNormal, view) * wNormal - view;
	vec3 reflected = reflect(view,wNormal);
	return sampleCubeMap(reflected, cubeMapIndex);
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
	else if (materialID == LAMBERTIAN_MATERIAL_ID)
	{
		/* Accumulate Lambertian shading for each light. */
		for (int i = 0; i < NumLights; ++i)
		{
			gl_FragColor.rgb += shadeLambertian(diffuse, position, normal, LightPositions[i], LightColors[i], LightAttenuations[i]);
		}
	}
	else if (materialID == BLINNPHONG_MATERIAL_ID) {
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
		int cubeMapIndex = int(materialParams2.z);
		vec3 baseColor = vec3(0.0);
		for (int i = 0; i < NumLights; i++) {
			baseColor += shadeCookTorrance(diffuse, specular, m, n, position, normal,
				LightPositions[i], LightColors[i], LightAttenuations[i]);
		}
		gl_FragColor.rgb = mixEnvMapWithBaseColor(cubeMapIndex, baseColor, position, normal, n);
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
		vec3 bitangent = normalize(cross(normal, tangent)*float(ANISOTROPIC_WARD_MATERIAL_ID));
		for (int i = 0; i < NumLights; i++) {
			gl_FragColor.rgb += shadeAnisotropicWard(diffuse, specular, alphaX, alphaY, position, normal,
				tangent, bitangent, LightPositions[i], LightColors[i], LightAttenuations[i]);
		}
	} else if (materialID == REFLECTION_MATERIAL_ID) {
		int cubeMapIndex = int(materialParams1.y);
		for (int i = 0; i < NumLights; i++) {
			gl_FragColor.rgb += shadeReflective(position, normal, cubeMapIndex);
		}
	}
	else
	{
		/* Unknown material, so just use the diffuse color. */
		gl_FragColor.rgb = diffuse;
	}

	if (EnableToonShading)
	{
		gl_FragColor.rgb = mix(gl_FragColor.rgb, vec3(0.0), silhouetteStrength()); 
	}
	
	if (HasShadowMaps == 1 && materialID != 0) {	
		gl_FragColor.rgb *= getShadowStrength(position);
	}
	
}
