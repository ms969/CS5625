package cs5625.deferred.custom;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import javax.vecmath.Point3f;
import javax.vecmath.Vector2f;

import com.jogamp.common.nio.Buffers;

import cs5625.deferred.materials.Material;
import cs5625.deferred.scenegraph.SceneObject;

public class Billboard extends SceneObject{
	private Point3f position;
	private Vector2f dimensions;
	private Material material;
	private FloatBuffer mVertexPositions;
	private IntBuffer mPolygonData;
	private FloatBuffer mNormalData;
	
	public Billboard(Point3f pos, Vector2f dim) {
		this.position = pos;
		this.dimensions = dim;
	}
	
	public Billboard() {
		position = new Point3f();
		dimensions = new Vector2f();
		material = new BillboardMaterial();
		mVertexPositions = null;
	}
	
	public Point3f getPosition() {
		return position;
	}
	
	public Vector2f getDimensions() {
		return dimensions;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public void setPosition(Point3f pos) {
		this.position = pos;
	}
	
	public void setDimensions(Vector2f dim) {
		this.dimensions = dim;
	}
	
	public void setMaterial(Material mat) {
		this.material = mat;
	}

	public FloatBuffer getVertexData() {
		float[] verts = {position.x + dimensions.x/2f,position.y + dimensions.y/2f, position.z, 
				position.x - dimensions.x/2f,position.y + dimensions.y/2f, position.z,
				position.x - dimensions.x/2f,position.y - dimensions.y/2f, position.z,
				position.x + dimensions.x/2f,position.y - dimensions.y/2f, position.z};
		mVertexPositions = Buffers.newDirectFloatBuffer(verts.length);
		mVertexPositions.put(verts);
		mVertexPositions.clear();
		return mVertexPositions;
	}

	public FloatBuffer getNormalData() {
			float[] norms = {0f,0f,1f,0f,0f,1f,0f,0f,1f,0f,0f,1f};
			mNormalData = Buffers.newDirectFloatBuffer(norms.length);
			mNormalData.put(norms);
			mNormalData.rewind();
		return mNormalData;
	}

	public FloatBuffer getTexCoordData() {
		// TODO Auto-generated method stub
		return null;
	}

	public IntBuffer getPolygonData() {
		int[] polyData = {0,1,2,3};
		mPolygonData = Buffers.newDirectIntBuffer(4);
		mPolygonData.put(polyData);
		mPolygonData.rewind();
		return mPolygonData;
	}
}
