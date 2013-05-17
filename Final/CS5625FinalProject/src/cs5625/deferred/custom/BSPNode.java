package cs5625.deferred.custom;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import cs5625.deferred.scenegraph.Geometry;
import cs5625.deferred.scenegraph.Mesh;
import cs5625.deferred.scenegraph.Quadmesh;
import cs5625.deferred.scenegraph.SceneObject;
import cs5625.deferred.scenegraph.Trimesh;

public class BSPNode {
	private int numChildren;
	private BSPNode left;
	private BSPNode right;
	private Point3f position;
	private Vector3f direction;
	private ArrayList<SceneObject> objects;
	public Point3f min;
	public Point3f max;
	
	public BSPNode() {
		left = null;
		right = null;
		min = new Point3f();
		max = new Point3f();
		position = new Point3f();
		direction = null;
	}
	
	public BSPNode traverse(Point3f pos) {
		return left;
	}
	public BSPNode getLeft() {
		return left;
	}
	
	public BSPNode getRight() {
		return right;
	}
	
	public BSPNode getLights() {
		return left;
	}
	
	public Vector3f getDirection() {
		return direction;
	}
	
	public Point3f getPosition() {
		return position;
	}
	
	public void setLeft(BSPNode l) {
		left = l;
	}
	
	public void setRight(BSPNode r) {
		right = r;
	}
	
	public void setPosition(Point3f p) {
		position = p;
	}
	
	public void setDirection(Vector3f b) {
		direction = b;
	}
	
	public void addObject(SceneObject s) {
		objects.add(s);
	}
	
	public void subdivide(int numLevels) {
		if(!objects.isEmpty() && numLevels > 0) {
			/*create left and right partitions, add appropriate objects, and subdivide meshes*/
			left = new BSPNode();
			right = new BSPNode();
			left.min = min;
			right.max = max;
			Vector3f inv = new Vector3f(1f,1f,1f);
			inv.sub(direction);
			//set left node max 
			left.max.x += max.x*inv.x;
			left.max.y += max.y*inv.y;
			left.max.z += max.z*inv.z;
			left.max.x += position.x*direction.x;
			left.max.y += position.y*direction.y;
			left.max.z += position.z*direction.z;
			//set right node min
			right.min.x += min.x*inv.x;
			right.min.y += min.y*inv.y;
			right.min.z += min.z*inv.z;
			right.min.x += position.x*direction.x;
			right.min.y += position.y*direction.y;
			right.min.z += position.z*direction.z;
			//set positions
			left.setPosition(new Point3f((left.max.x - left.min.x)/2f,(left.max.y - left.min.y)/2f,(left.max.z - left.min.z)/2f));
			right.setPosition(new Point3f((right.max.x - right.min.x)/2f,(right.max.y - right.min.y)/2f,(right.max.z - right.min.z)/2f));
			//set directions
			if(left.max.x - left.max.x > left.max.y - left.max.y && left.max.x - left.max.x > left.max.z - left.max.z) {
				left.setDirection(new Vector3f(1f,0f,0f));
			}
			else if(left.max.y - left.max.y > left.max.x - left.max.x && left.max.y - left.max.y < left.max.z - left.max.z) {
				left.setDirection(new Vector3f(0f,1f,0f));
			}
			else {
				left.setDirection(new Vector3f(0f,0f,1f));
			}
			
			if(right.max.x - right.max.x > right.max.y - right.max.y && right.max.x - right.max.x > right.max.z - right.max.z) {
				right.setDirection(new Vector3f(1f,0f,0f));
			}
			else if(right.max.y - right.max.y > right.max.x - right.max.x && right.max.y - right.max.y < right.max.z - right.max.z) {
				right.setDirection(new Vector3f(0f,1f,0f));
			}
			else {
				right.setDirection(new Vector3f(0f,0f,1f));
			}
			//add objects to left and right nodes, subdividing geometry as we go
			for(SceneObject s : objects) {
				if(!(s instanceof Geometry)) {
					if(direction.dot(new Vector3f(s.getPosition())) > direction.dot(new Vector3f(position))) {
						right.addObject(s);
					}
					else  {
						left.addObject(s);
					}
				}
				else {
					ArrayList<PartitionMesh> partitioned = partition((Geometry) s);
					left.addObject(partitioned.get(0));
					right.addObject(partitioned.get(1));
				}
			}
			left.subdivide(numLevels-1);
			right.subdivide(numLevels-1);
		}
	}
	
	private ArrayList<PartitionMesh> partition(Geometry g) {
		List<Mesh> meshes = g.getMeshes();
		PartitionMesh l = new PartitionMesh();
		PartitionMesh r = new PartitionMesh();
		
		for(Mesh m : meshes) {
			if(m instanceof Trimesh) {
				Trimesh tmpl = new Trimesh();
				Trimesh tmpr = new Trimesh();
				int lcount = 0;
				int rcount = 0;
				ArrayList<Integer> lpoly = new ArrayList<Integer>();
				ArrayList<Integer> rpoly = new ArrayList<Integer>();
				ArrayList<Float> lnorm = new ArrayList<Float>();
				ArrayList<Float> rnorm = new ArrayList<Float>();
				ArrayList<Float> lvert = new ArrayList<Float>();
				ArrayList<Float> rvert = new ArrayList<Float>();
				int[] polys = m.getPolygonData().array();
				float[] verts = m.getVertexData().array();
				float[] norms = m.getNormalData().array();
				//for every polygon, decide which side it belongs to, and add it to the appropriate array with the appropriate indexing
				for(int i = 0; i < m.getPolygonCount(); i++) {
					Vector3f tmpvec = new Vector3f(verts[polys[i*3]],verts[polys[i*3]+1],verts[polys[i*3]+2]);
					tmpvec.add(new Vector3f(verts[polys[i*3+1]],verts[polys[i*3+1]+1],verts[polys[i*3+1]+2]));
					tmpvec.add(new Vector3f(verts[polys[i*3+2]],verts[polys[i*3+2]+1],verts[polys[i*3+2]+2]));
					tmpvec.scale(1.0f/3.0f);
					if (tmpvec.dot(direction) > direction.dot(new Vector3f(position))) {
						rvert.add(verts[polys[i*3]]);
						rvert.add(verts[polys[i*3]+1]);
						rvert.add(verts[polys[i*3]+2]);
						rnorm.add(norms[polys[i*3]]);
						rnorm.add(norms[polys[i*3]+1]);
						rnorm.add(norms[polys[i*3]+2]);
						rpoly.add(rcount++);
						rvert.add(verts[polys[i*3+1]]);
						rvert.add(verts[polys[i*3+1]+1]);
						rvert.add(verts[polys[i*3+1]+2]);
						rnorm.add(norms[polys[i*3+1]]);
						rnorm.add(norms[polys[i*3+1]+1]);
						rnorm.add(norms[polys[i*3+1]+2]);
						rpoly.add(rcount++);
						rvert.add(verts[polys[i*3+2]]);
						rvert.add(verts[polys[i*3+2]+1]);
						rvert.add(verts[polys[i*3+2]+2]);
						rnorm.add(norms[polys[i*3+2]]);
						rnorm.add(norms[polys[i*3+2]+1]);
						rnorm.add(norms[polys[i*3+2]+2]);
						rpoly.add(rcount++);
					}
					else {
						lvert.add(verts[polys[i*3]]);
						lvert.add(verts[polys[i*3]+1]);
						lvert.add(verts[polys[i*3]+2]);
						lnorm.add(norms[polys[i*3]]);
						lnorm.add(norms[polys[i*3]+1]);
						lnorm.add(norms[polys[i*3]+2]);
						lpoly.add(lcount++);
						lvert.add(verts[polys[i*3+1]]);
						lvert.add(verts[polys[i*3+1]+1]);
						lvert.add(verts[polys[i*3+1]+2]);
						lnorm.add(norms[polys[i*3+1]]);
						lnorm.add(norms[polys[i*3+1]+1]);
						lnorm.add(norms[polys[i*3+1]+2]);
						lpoly.add(lcount++);
						lvert.add(verts[polys[i*3+2]]);
						lvert.add(verts[polys[i*3+2]+1]);
						lvert.add(verts[polys[i*3+2]+2]);
						lnorm.add(norms[polys[i*3+2]]);
						lnorm.add(norms[polys[i*3+2]+1]);
						lnorm.add(norms[polys[i*3+2]+2]);
						lpoly.add(lcount++);
					}
				}
				IntBuffer lpolybuffer = IntBuffer.allocate(lpoly.size());
				IntBuffer rpolybuffer = IntBuffer.allocate(rpoly.size());
				FloatBuffer lnormbuffer = FloatBuffer.allocate(lnorm.size());
				FloatBuffer rnormbuffer = FloatBuffer.allocate(rnorm.size());
				FloatBuffer lvertbuffer = FloatBuffer.allocate(lvert.size());
				FloatBuffer rvertbuffer = FloatBuffer.allocate(rvert.size());
				//left allocation
				int[] lpolyarr = new int[lpoly.size()];
				for(int i = 0; i < lpoly.size(); i++) {
					lpolyarr[i] = lpoly.get(i);
				}
				lpolybuffer.put(lpolyarr);
				float[] lvertarr = new float[lvert.size()];
				for(int i = 0; i < lvert.size(); i++) {
					lvertarr[i] = lvert.get(i);
				}
				lvertbuffer.put(lvertarr);
				float[] lnormarr = new float[lvert.size()];
				for(int i = 0; i < lnorm.size(); i++) {
					lnormarr[i] = lnorm.get(i);
				}
				lnormbuffer.put(lnormarr);
				//right allocation
				int[] rpolyarr = new int[rpoly.size()];
				for(int i = 0; i < rpoly.size(); i++) {
					rpolyarr[i] = rpoly.get(i);
				}
				rpolybuffer.put(rpolyarr);
				float[] rvertarr = new float[rvert.size()];
				for(int i = 0; i < rvert.size(); i++) {
					rvertarr[i] = rvert.get(i);
				}
				rvertbuffer.put(rvertarr);
				float[] rnormarr = new float[rvert.size()];
				for(int i = 0; i < rnorm.size(); i++) {
					rnormarr[i] = rnorm.get(i);
				}
				lnormbuffer.put(rnormarr);
				//add meshes to buffer
				tmpl.setPolygonData(lpolybuffer);
				tmpr.setPolygonData(rpolybuffer);
				tmpl.setVertexData(lvertbuffer);
				tmpr.setVertexData(rvertbuffer);
				tmpl.setNormalData(lnormbuffer);
				tmpr.setNormalData(rnormbuffer);
				//add to subdivided geometry blocks
				l.addMesh(tmpl);
				r.addMesh(tmpr);
			}
			else if(m instanceof Quadmesh) {
				Quadmesh tmpl = new Quadmesh();
				Quadmesh tmpr = new Quadmesh();
				int lcount = 0;
				int rcount = 0;
				ArrayList<Integer> lpoly = new ArrayList<Integer>();
				ArrayList<Integer> rpoly = new ArrayList<Integer>();
				ArrayList<Float> lnorm = new ArrayList<Float>();
				ArrayList<Float> rnorm = new ArrayList<Float>();
				ArrayList<Float> lvert = new ArrayList<Float>();
				ArrayList<Float> rvert = new ArrayList<Float>();
				int[] polys = m.getPolygonData().array();
				float[] verts = m.getVertexData().array();
				float[] norms = m.getNormalData().array();
				//for every polygon, decide which side it belongs to, and add it to the appropriate array with the appropriate indexing
				for(int i = 0; i < m.getPolygonCount(); i++) {
					Vector3f tmpvec = new Vector3f(verts[polys[i*3]],verts[polys[i*3]+1],verts[polys[i*3]+2]);
					tmpvec.add(new Vector3f(verts[polys[i*3+1]],verts[polys[i*3+1]+1],verts[polys[i*3+1]+2]));
					tmpvec.add(new Vector3f(verts[polys[i*3+2]],verts[polys[i*3+2]+1],verts[polys[i*3+2]+2]));
					tmpvec.scale(1.0f/3.0f);
					if (tmpvec.dot(direction) > direction.dot(new Vector3f(position))) {
						rvert.add(verts[polys[i*4]]);
						rvert.add(verts[polys[i*4]+1]);
						rvert.add(verts[polys[i*4]+2]);
						rnorm.add(norms[polys[i*4]]);
						rnorm.add(norms[polys[i*4]+1]);
						rnorm.add(norms[polys[i*4]+2]);
						rpoly.add(rcount++);
						rvert.add(verts[polys[i*4+1]]);
						rvert.add(verts[polys[i*4+1]+1]);
						rvert.add(verts[polys[i*4+1]+2]);
						rnorm.add(norms[polys[i*4+1]]);
						rnorm.add(norms[polys[i*4+1]+1]);
						rnorm.add(norms[polys[i*4+1]+2]);
						rpoly.add(rcount++);
						rvert.add(verts[polys[i*4+2]]);
						rvert.add(verts[polys[i*4+2]+1]);
						rvert.add(verts[polys[i*4+2]+2]);
						rnorm.add(norms[polys[i*4+2]]);
						rnorm.add(norms[polys[i*4+2]+1]);
						rnorm.add(norms[polys[i*4+2]+2]);
						rpoly.add(rcount++);
						rvert.add(verts[polys[i*4+3]]);
						rvert.add(verts[polys[i*4+3]+1]);
						rvert.add(verts[polys[i*4+3]+2]);
						rnorm.add(norms[polys[i*4+3]]);
						rnorm.add(norms[polys[i*4+3]+1]);
						rnorm.add(norms[polys[i*4+3]+2]);
						rpoly.add(rcount++);
					}
					else {
						lvert.add(verts[polys[i*4]]);
						lvert.add(verts[polys[i*4]+1]);
						lvert.add(verts[polys[i*4]+2]);
						lnorm.add(norms[polys[i*4]]);
						lnorm.add(norms[polys[i*4]+1]);
						lnorm.add(norms[polys[i*4]+2]);
						lpoly.add(lcount++);
						lvert.add(verts[polys[i*4+1]]);
						lvert.add(verts[polys[i*4+1]+1]);
						lvert.add(verts[polys[i*4+1]+2]);
						lnorm.add(norms[polys[i*4+1]]);
						lnorm.add(norms[polys[i*4+1]+1]);
						lnorm.add(norms[polys[i*4+1]+2]);
						lpoly.add(lcount++);
						lvert.add(verts[polys[i*4+2]]);
						lvert.add(verts[polys[i*4+2]+1]);
						lvert.add(verts[polys[i*4+2]+2]);
						lnorm.add(norms[polys[i*4+2]]);
						lnorm.add(norms[polys[i*4+2]+1]);
						lnorm.add(norms[polys[i*4+2]+2]);
						lpoly.add(lcount++);
						lvert.add(verts[polys[i*4+3]]);
						lvert.add(verts[polys[i*4+3]+1]);
						lvert.add(verts[polys[i*4+3]+2]);
						lnorm.add(norms[polys[i*4+3]]);
						lnorm.add(norms[polys[i*4+3]+1]);
						lnorm.add(norms[polys[i*4+3]+2]);
						lpoly.add(lcount++);
					}
				}
				IntBuffer lpolybuffer = IntBuffer.allocate(lpoly.size());
				IntBuffer rpolybuffer = IntBuffer.allocate(rpoly.size());
				FloatBuffer lnormbuffer = FloatBuffer.allocate(lnorm.size());
				FloatBuffer rnormbuffer = FloatBuffer.allocate(rnorm.size());
				FloatBuffer lvertbuffer = FloatBuffer.allocate(lvert.size());
				FloatBuffer rvertbuffer = FloatBuffer.allocate(rvert.size());
				//left allocation
				int[] lpolyarr = new int[lpoly.size()];
				for(int i = 0; i < lpoly.size(); i++) {
					lpolyarr[i] = lpoly.get(i);
				}
				lpolybuffer.put(lpolyarr);
				float[] lvertarr = new float[lvert.size()];
				for(int i = 0; i < lvert.size(); i++) {
					lvertarr[i] = lvert.get(i);
				}
				lvertbuffer.put(lvertarr);
				float[] lnormarr = new float[lvert.size()];
				for(int i = 0; i < lnorm.size(); i++) {
					lnormarr[i] = lnorm.get(i);
				}
				lnormbuffer.put(lnormarr);
				//right allocation
				int[] rpolyarr = new int[rpoly.size()];
				for(int i = 0; i < rpoly.size(); i++) {
					rpolyarr[i] = rpoly.get(i);
				}
				rpolybuffer.put(rpolyarr);
				float[] rvertarr = new float[rvert.size()];
				for(int i = 0; i < rvert.size(); i++) {
					rvertarr[i] = rvert.get(i);
				}
				rvertbuffer.put(rvertarr);
				float[] rnormarr = new float[rvert.size()];
				for(int i = 0; i < rnorm.size(); i++) {
					rnormarr[i] = rnorm.get(i);
				}
				lnormbuffer.put(rnormarr);
				//add meshes to buffer
				tmpl.setPolygonData(lpolybuffer);
				tmpr.setPolygonData(rpolybuffer);
				tmpl.setVertexData(lvertbuffer);
				tmpr.setVertexData(rvertbuffer);
				tmpl.setNormalData(lnormbuffer);
				tmpr.setNormalData(rnormbuffer);
				//add to subdivided geometry blocks
				l.addMesh(tmpl);
				r.addMesh(tmpr);
			}
		}
		l.setParent(g);
		r.setParent(g);
		ArrayList<PartitionMesh> output = new ArrayList<PartitionMesh>();
		output.add(l);
		output.add(r);
		return output;
	}
	
	public void addGeometry(SceneObject root) {
		/*fill BSP with scene objects*/
		objects.add(root);
		for(SceneObject s : root.getChildren()) {
			objects.add(s);
			addGeometry(s);
		}
		max = new Point3f(Float.MIN_VALUE,Float.MIN_VALUE,Float.MIN_VALUE);
		min = new Point3f(Float.MAX_VALUE,Float.MAX_VALUE,Float.MAX_VALUE);
		for(SceneObject s : objects) {
			max.x = Math.max(s.getPosition().x, max.x);
			max.y = Math.max(s.getPosition().y, max.y);
			max.z = Math.max(s.getPosition().z, max.z);
			min.x = Math.min(s.getPosition().x, min.x);
			min.y = Math.min(s.getPosition().y, min.y);
			min.z = Math.min(s.getPosition().z, min.z);
		}
		position = new Point3f((max.x - min.x)/2f,(max.y - min.y)/2f,(max.z - min.z)/2f);
		if(max.x - min.x > max.y - min.y && max.x - min.x > max.z - min.z) {
			direction = new Vector3f(1f,0f,0f);
		}
		else if(max.y - min.y > max.x - min.x && max.y - min.y < max.z - min.z) {
			direction = new Vector3f(0f,1f,0f);
		}
		else {
			direction = new Vector3f(0f,0f,1f);
		}
	}
}
