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

/* snow rendering variables */
const float PI = 3.14159265359;
uniform int RenderSnow;
//uniform sampler2D SnowOcclMap;
//uniform float SnowMapWidth;
//uniform float SnowMapHeight;
uniform mat4 TransposeInverseViewMatrix;

//===================================================================================
//
// Description : Array and textureless GLSL 2D/3D/4D simplex 
//               noise functions.
//      Author : Ian McEwan, Ashima Arts.
//  Maintainer : ijm
//     Lastmod : 20110822 (ijm)
//     License : Copyright (C) 2011 Ashima Arts. All rights reserved.
//               Distributed under the MIT License. See LICENSE file.
//               https://github.com/ashima/webgl-noise
// 

vec3 mod289(vec3 x) {
  return x - floor(x * (1.0 / 289.0)) * 289.0;
}

vec4 mod289(vec4 x) {
  return x - floor(x * (1.0 / 289.0)) * 289.0;
}

vec4 permute(vec4 x) {
     return mod289(((x*34.0)+1.0)*x);
}

vec4 taylorInvSqrt(vec4 r)
{
  return 1.79284291400159 - 0.85373472095314 * r;
}

float snoise(vec3 v)
  { 
  const vec2  C = vec2(1.0/6.0, 1.0/3.0) ;
  const vec4  D = vec4(0.0, 0.5, 1.0, 2.0);

// First corner
  vec3 i  = floor(v + dot(v, C.yyy) );
  vec3 x0 =   v - i + dot(i, C.xxx) ;

// Other corners
  vec3 g = step(x0.yzx, x0.xyz);
  vec3 l = 1.0 - g;
  vec3 i1 = min( g.xyz, l.zxy );
  vec3 i2 = max( g.xyz, l.zxy );

  //   x0 = x0 - 0.0 + 0.0 * C.xxx;
  //   x1 = x0 - i1  + 1.0 * C.xxx;
  //   x2 = x0 - i2  + 2.0 * C.xxx;
  //   x3 = x0 - 1.0 + 3.0 * C.xxx;
  vec3 x1 = x0 - i1 + C.xxx;
  vec3 x2 = x0 - i2 + C.yyy; // 2.0*C.x = 1/3 = C.y
  vec3 x3 = x0 - D.yyy;      // -1.0+3.0*C.x = -0.5 = -D.y

// Permutations
  i = mod289(i); 
  vec4 p = permute( permute( permute( 
             i.z + vec4(0.0, i1.z, i2.z, 1.0 ))
           + i.y + vec4(0.0, i1.y, i2.y, 1.0 )) 
           + i.x + vec4(0.0, i1.x, i2.x, 1.0 ));

// Gradients: 7x7 points over a square, mapped onto an octahedron.
// The ring size 17*17 = 289 is close to a multiple of 49 (49*6 = 294)
  float n_ = 0.142857142857; // 1.0/7.0
  vec3  ns = n_ * D.wyz - D.xzx;

  vec4 j = p - 49.0 * floor(p * ns.z * ns.z);  //  mod(p,7*7)

  vec4 x_ = floor(j * ns.z);
  vec4 y_ = floor(j - 7.0 * x_ );    // mod(j,N)

  vec4 x = x_ *ns.x + ns.yyyy;
  vec4 y = y_ *ns.x + ns.yyyy;
  vec4 h = 1.0 - abs(x) - abs(y);

  vec4 b0 = vec4( x.xy, y.xy );
  vec4 b1 = vec4( x.zw, y.zw );

  //vec4 s0 = vec4(lessThan(b0,0.0))*2.0 - 1.0;
  //vec4 s1 = vec4(lessThan(b1,0.0))*2.0 - 1.0;
  vec4 s0 = floor(b0)*2.0 + 1.0;
  vec4 s1 = floor(b1)*2.0 + 1.0;
  vec4 sh = -step(h, vec4(0.0));

  vec4 a0 = b0.xzyw + s0.xzyw*sh.xxyy ;
  vec4 a1 = b1.xzyw + s1.xzyw*sh.zzww ;

  vec3 p0 = vec3(a0.xy,h.x);
  vec3 p1 = vec3(a0.zw,h.y);
  vec3 p2 = vec3(a1.xy,h.z);
  vec3 p3 = vec3(a1.zw,h.w);

//Normalise gradients
  vec4 norm = taylorInvSqrt(vec4(dot(p0,p0), dot(p1,p1), dot(p2, p2), dot(p3,p3)));
  p0 *= norm.x;
  p1 *= norm.y;
  p2 *= norm.z;
  p3 *= norm.w;

// Mix final noise value
  vec4 m = max(0.6 - vec4(dot(x0,x0), dot(x1,x1), dot(x2,x2), dot(x3,x3)), 0.0);
  m = m * m;
  return 42.0 * dot( m*m, vec4( dot(p0,x0), dot(p1,x1), 
                                dot(p2,x2), dot(p3,x3) ) );
  }
//===============================================================================================

//
// GLSL textureless classic 3D noise "cnoise",
// with an RSL-style periodic variant "pnoise".
// Author:  Stefan Gustavson (stefan.gustavson@liu.se)
// Version: 2011-10-11
//
// Many thanks to Ian McEwan of Ashima Arts for the
// ideas for permutation and gradient selection.
//
// Copyright (c) 2011 Stefan Gustavson. All rights reserved.
// Distributed under the MIT license. See LICENSE file.
// https://github.com/ashima/webgl-noise
//

/*vec3 mod289(vec3 x)
{
  return x - floor(x * (1.0 / 289.0)) * 289.0;
}

vec4 mod289(vec4 x)
{
  return x - floor(x * (1.0 / 289.0)) * 289.0;
}

vec4 permute(vec4 x)
{
  return mod289(((x*34.0)+1.0)*x);
}

vec4 taylorInvSqrt(vec4 r)
{
  return 1.79284291400159 - 0.85373472095314 * r;
}

vec3 fade(vec3 t) {
  return t*t*t*(t*(t*6.0-15.0)+10.0);
}

// Classic Perlin noise
float cnoise(vec3 P)
{
  vec3 Pi0 = floor(P); // Integer part for indexing
  vec3 Pi1 = Pi0 + vec3(1.0); // Integer part + 1
  Pi0 = mod289(Pi0);
  Pi1 = mod289(Pi1);
  vec3 Pf0 = fract(P); // Fractional part for interpolation
  vec3 Pf1 = Pf0 - vec3(1.0); // Fractional part - 1.0
  vec4 ix = vec4(Pi0.x, Pi1.x, Pi0.x, Pi1.x);
  vec4 iy = vec4(Pi0.yy, Pi1.yy);
  vec4 iz0 = Pi0.zzzz;
  vec4 iz1 = Pi1.zzzz;

  vec4 ixy = permute(permute(ix) + iy);
  vec4 ixy0 = permute(ixy + iz0);
  vec4 ixy1 = permute(ixy + iz1);

  vec4 gx0 = ixy0 * (1.0 / 7.0);
  vec4 gy0 = fract(floor(gx0) * (1.0 / 7.0)) - 0.5;
  gx0 = fract(gx0);
  vec4 gz0 = vec4(0.5) - abs(gx0) - abs(gy0);
  vec4 sz0 = step(gz0, vec4(0.0));
  gx0 -= sz0 * (step(0.0, gx0) - 0.5);
  gy0 -= sz0 * (step(0.0, gy0) - 0.5);

  vec4 gx1 = ixy1 * (1.0 / 7.0);
  vec4 gy1 = fract(floor(gx1) * (1.0 / 7.0)) - 0.5;
  gx1 = fract(gx1);
  vec4 gz1 = vec4(0.5) - abs(gx1) - abs(gy1);
  vec4 sz1 = step(gz1, vec4(0.0));
  gx1 -= sz1 * (step(0.0, gx1) - 0.5);
  gy1 -= sz1 * (step(0.0, gy1) - 0.5);

  vec3 g000 = vec3(gx0.x,gy0.x,gz0.x);
  vec3 g100 = vec3(gx0.y,gy0.y,gz0.y);
  vec3 g010 = vec3(gx0.z,gy0.z,gz0.z);
  vec3 g110 = vec3(gx0.w,gy0.w,gz0.w);
  vec3 g001 = vec3(gx1.x,gy1.x,gz1.x);
  vec3 g101 = vec3(gx1.y,gy1.y,gz1.y);
  vec3 g011 = vec3(gx1.z,gy1.z,gz1.z);
  vec3 g111 = vec3(gx1.w,gy1.w,gz1.w);

  vec4 norm0 = taylorInvSqrt(vec4(dot(g000, g000), dot(g010, g010), dot(g100, g100), dot(g110, g110)));
  g000 *= norm0.x;
  g010 *= norm0.y;
  g100 *= norm0.z;
  g110 *= norm0.w;
  vec4 norm1 = taylorInvSqrt(vec4(dot(g001, g001), dot(g011, g011), dot(g101, g101), dot(g111, g111)));
  g001 *= norm1.x;
  g011 *= norm1.y;
  g101 *= norm1.z;
  g111 *= norm1.w;

  float n000 = dot(g000, Pf0);
  float n100 = dot(g100, vec3(Pf1.x, Pf0.yz));
  float n010 = dot(g010, vec3(Pf0.x, Pf1.y, Pf0.z));
  float n110 = dot(g110, vec3(Pf1.xy, Pf0.z));
  float n001 = dot(g001, vec3(Pf0.xy, Pf1.z));
  float n101 = dot(g101, vec3(Pf1.x, Pf0.y, Pf1.z));
  float n011 = dot(g011, vec3(Pf0.x, Pf1.yz));
  float n111 = dot(g111, Pf1);

  vec3 fade_xyz = fade(Pf0);
  vec4 n_z = mix(vec4(n000, n100, n010, n110), vec4(n001, n101, n011, n111), fade_xyz.z);
  vec2 n_yz = mix(n_z.xy, n_z.zw, fade_xyz.y);
  float n_xyz = mix(n_yz.x, n_yz.y, fade_xyz.x); 
  return 2.2 * n_xyz;
}*/

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

/*vec3 calculateColor(vec3 diffuse, vec3 specular, float exponent, vec3 position, vec3 diffuse_normal, vec3 specular_normal, vec3 lightPosition, vec3 lightColor, vec3 lightAttenuation) {
	float ndotl = max(0.0, dot(diffuse_normal, lightDirection));
	float ndoth = max(0.0, dot(specular_normal, halfDirection));
	
	float pow_ndoth = (ndotl > 0.0 && ndoth > 0.0 ? pow(ndoth, exponent) : 0.0);


	float r = length(lightPosition - position);
	float attenuation = 1.0 / dot(lightAttenuation, vec3(1.0, r, r * r));
	
	return lightColor * attenuation * (diffuse * ndotl + specular * pow_ndoth);
}*/

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
	
	// C = f_p * C_s + (1 - f_p) * C_n
	vec3 specular_normal;
	vec3 diffuse_normal;
	vec3 worldSpacePosition = vec3(0.0);
	if (RenderSnow == 1) {
		vec4 worldSpacePosition_h = InverseViewMatrix * vec4(position, 1.0);
		worldSpacePosition = (worldSpacePosition_h / worldSpacePosition_h.w).xyz;
		float n_x = snoise(worldSpacePosition);
		float n_y = snoise(worldSpacePosition);
		float n_z = snoise(worldSpacePosition);
		//N_alpha = N + alpha * n - dE
		
		specular_normal = normalize(normal + 0.8 * vec3(n_x, n_y, n_z));
		diffuse_normal = normalize(normal + 0.4 * vec3(n_x, n_y, n_z));
	} else {
		specular_normal = normal;
		diffuse_normal = normal;
	}
	
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
	
	vec3 C;
	if (RenderSnow == 1) {
		float ndotl_snow = max(0.0, dot(diffuse_normal, lightDirection));
		float ndoth_snow = max(0.0, dot(specular_normal, halfDirection));
		
		float pow_ndoth_snow = (ndotl_snow > 0.0 && ndoth_snow > 0.0 ? pow(ndoth_snow, exponent) : 0.0);
		
		
		vec3 C_n = lightColor * attenuation * (diffuse * ndotl + specular * pow_ndoth);
		vec3 C_s = lightColor * attenuation * (vec3(0.99, 0.99, 0.999) * ndotl_snow + 0.0 * pow_ndoth_snow);
		
		// angle between Up and Normal
		vec4 worldSpaceUp = vec4(0.0, 1.0, 0.0, 0.0);
		vec4 eyeSpaceUp = normalize(TransposeInverseViewMatrix * worldSpaceUp);
		float cos_theta = dot(normal, eyeSpaceUp.xyz);
		float theta = acos(cos_theta);
		float f_inc = 0.0;
		if (theta >= 0.0 && theta <= PI/2.0) {
			float n = (snoise(worldSpacePosition) + 1.0) * 0.5;
			f_inc = cos_theta * (1+n);
		}
		
		float f_p = -1.05 * f_inc / (-f_inc - 0.05);
		//float f_p = f_inc;
		// -1.2 * t / (-t-0.2)
		//C = f_p * C_s + (1.0 - f_p) * C_n;
		C = C_n;
	} else {
		C = lightColor * attenuation * (diffuse * ndotl + specular * pow_ndoth);
	}
	return C;
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
