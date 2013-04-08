/**
 * ssao.fp
 * 
 * Written for Cornell CS 5625 (Interactive Computer Graphics).
 * Copyright (c) 2013, Computer Science Department, Cornell University.
 * 
 * @author Sean Ryan (ser99)
 * @date 2013-03-23
 */

uniform sampler2DRect DiffuseBuffer;
uniform sampler2DRect PositionBuffer;

#define MAX_RAYS 100
uniform int NumRays;
uniform vec3 SampleRays[MAX_RAYS];
uniform float SampleRadius;

uniform mat4 ProjectionMatrix;
uniform vec2 ScreenSize;

/* Decodes a vec2 into a normalized vector See Renderer.java for more info. */
vec3 decode(vec2 v)
{
	vec3 n;
	n.z = 2.0 * dot(v.xy, v.xy) - 1.0;
	n.xy = normalize(v.xy) * sqrt(1.0 - n.z*n.z);
	return n;
}

void main()
{
	// TODO PA4: Implement SSAO. Your output color should be grayscale where white is unobscured and black is fully obscured.
	vec3 position = texture2DRect(PositionBuffer, gl_FragCoord.xy).xyz;
	vec3 normal = decode(vec2(texture2DRect(DiffuseBuffer, gl_FragCoord.xy).a,
	                          texture2DRect(PositionBuffer, gl_FragCoord.xy).a));
	
	if (position.z != 0.0) {
		vec3 i;
		if (dot(vec3(1.0, 0.0, 0.0), normal) != 0.0) {
			i = vec3(1.0, 0.0, 0.0);
		} else if (dot(vec3(0.0, 1.0, 0.0), normal) != 0.0) {
			i = vec3(0.0, 1.0, 0.0);
		} else {
			i = vec3(0.0, 0.0, 1.0);
		}
		vec3 x_axis = cross(normal, i);
		vec3 y_axis = cross(normal, x_axis);
		// changes from fragment space to screenspace
		mat3 fragmentToScreenspace = mat3(x_axis, y_axis, normal);
		
		// projection changes from screenspace to clipspace
		float visibility = 0.0;
		float sum = 0.0;
		for (int i = 0; i < NumRays; i++) {
			// 1. Apply the change-of-basis matrix discussed earlier to get a screen space ray.
			vec3 screenSpaceUnitRay = fragmentToScreenspace * SampleRays[i];
			// 2. Scale the transformed ray by the SampleRadius; this is the final sample ray.
			vec3 screenSpaceRay = screenSpaceUnitRay * SampleRadius;
			// 3. Offset the screen space position of the current fragment by the scaled ray and project this point 
			// into clip space using the ProjectionMatrix.
			vec3 screenSamplePoint = screenSpaceRay + position;
			vec4 clipSamplePoint = ProjectionMatrix * vec4(screenSamplePoint, 1.0);
			// 4. Convert the x and y values of the clip space point into pixel values using a bit of math and ScreenSize. 
			// Recall that clip space ranges over [-1, 1] in x and y. Since you’ve done a projection, remember to divide by w.
			clipSamplePoint = clipSamplePoint / clipSamplePoint.w;
			// shift everything up 1 to get [0, 2], and then multiply by 1/2 to get [0, 1], and then multiply by ScreenSize
			vec2 sampleCoord = (clipSamplePoint.xy + vec2(1.0)) * 0.5 * ScreenSize;
			float zValue = texture2DRect(PositionBuffer, sampleCoord).z;
			
			float weight = dot(normal, screenSpaceUnitRay);
			sum += weight;
			if (screenSamplePoint.z > zValue || zValue >= 0.0) {
				// point is visible
				visibility += weight;
			}
		}
		
		float color = visibility/sum;
		
		gl_FragColor = vec4(color, color, color, 1.0);
	} else {
		// part of the background, so return white
		gl_FragColor = vec4(1.0);
	}
}
}
