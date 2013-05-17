package cs5625.deferred.custom;

import java.nio.FloatBuffer;

import cs5625.deferred.scenegraph.Geometry;
import cs5625.deferred.scenegraph.Mesh;

public class PartitionMesh extends Geometry {

	private Geometry parent;
	
	public void setParent(Geometry g) {
		parent = g;
	}
	
	public Geometry getParent() {
		return parent;
	}
}
