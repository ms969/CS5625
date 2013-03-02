/**
 * gaussian_blur.fp
 * 
 * 1D Gaussian blur shader, that can be used to blur a given texture.
 * 
 * Written for Cornell CS 5625 (Interactive Computer Graphics).
 * Copyright (c) 2012, Computer Science Department, Cornell University.
 * 
 * @author Ivaylo Boyadzhiev (iib2)
 * @date 2013-02-13
 */

/* Uniform inputs */
uniform sampler2D SourceTexture;
uniform float TextureSize;

/* Width and variance of the filter kernel */
uniform float KernelVariance;
uniform int KernelWidth;

/* horizontal axis is 0, vertical axis is non-zero */uniform int Axis;

// TODO PA2: Implement a 1D Gaussian blur in the given direction
// Hint: The interpolated texture coordinates can be accessed
// through  gl_TexCoord[0]. TextureSize should be set to the width,
// for horizontal, and the height, for vertical Gaussian blur. 

void main()
{
	int maxd = 2*KernelWidth + 1;
	vec3 sum;
	int weight = 0;
	
	for (int i = -maxd; i < maxd + 1; i++) {
		weight =  exp(-abs(i)*abs(i)/(2.0*KernelVariance));
		if(Axis == 0) {
			sum += weight*texture2D(SourceTexture, vec2(gl_TexCoord[0].x + float(i)/TextureSize, gl_TexCoord[0].y));
		}
		else {
			sum += weight*texture2D(SourceTexture, vec2(gl_TexCoord[0].x, gl_TexCoord[0].y + float(i)/TextureSize));
		}
	}

    gl_FragColor = vec4(vec3(1.0,0.0,0.0), 1.0);
}