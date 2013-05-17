package cs5625.deferred.custom;

import javax.media.opengl.GL2;
import javax.vecmath.Color3f;

import cs5625.deferred.materials.Material;
import cs5625.deferred.materials.Texture2D;
import cs5625.deferred.misc.OpenGLException;
import cs5625.deferred.rendering.ShaderProgram;

public class BillboardMaterial  extends Material {
	
	private Color3f mDiffuseColor = new Color3f(1.0f, 1.0f, 1.0f);
	private Texture2D mDiffuseTexture = null;
	
	private int mDiffuseUniformLocation = -1;
	private int mHasDiffuseTextureUniformLocation = -1;
	
	public BillboardMaterial()
	{
		/* Nothing. */
	}
	
	public BillboardMaterial(Color3f color)
	{
		mDiffuseColor.set(color);
	}
	
	public Color3f getColor()
	{
		return mDiffuseColor;
	}
	
	public void setColor(Color3f color)
	{
		mDiffuseColor = color;
	}
	
	public Texture2D getDiffuseTexture()
	{
		return mDiffuseTexture;
	}
	
	public void setDiffuseTexture(Texture2D texture)
	{
		mDiffuseTexture = texture;
	}


	@Override
	public void bind(GL2 gl) throws OpenGLException
	{
		/* Bind shader, and any textures, and update uniforms. */
		getShaderProgram().bind(gl);

		// TODO PA3 Prereq: Set shader uniforms and bind any textures.
		if (mDiffuseTexture == null) {
			gl.glUniform1i(mHasDiffuseTextureUniformLocation, 0);
			gl.glUniform3f(mDiffuseUniformLocation, mDiffuseColor.x, mDiffuseColor.y, mDiffuseColor.z);
		} else {
			gl.glUniform1i(mHasDiffuseTextureUniformLocation, 1);
			mDiffuseTexture.bind(gl, 0);
		}
	}
	
	@Override
	public void unbind(GL2 gl)
	{
		/* Unbind anything bound in bind(). */
		getShaderProgram().unbind(gl);

		// TODO PA3 Prereq: Unbind any used textures.
		if (mDiffuseTexture != null)
			mDiffuseTexture.unbind(gl);
	}
	
	@Override
	protected void initializeShader(GL2 gl, ShaderProgram shader)
	{
		/* Get locations of uniforms in this shader. */
		mDiffuseUniformLocation = shader.getUniformLocation(gl, "DiffuseColor");
		mHasDiffuseTextureUniformLocation = shader.getUniformLocation(gl, "HasDiffuseTexture");

		/* This uniform won't ever change, so just set it here. */
		shader.bind(gl);
		gl.glUniform1i(shader.getUniformLocation(gl, "DiffuseTexture"), 0);
		shader.unbind(gl);
	}
	
	@Override
	public String getShaderIdentifier()
	{
		return "shaders/material_billboard";
	}

}
