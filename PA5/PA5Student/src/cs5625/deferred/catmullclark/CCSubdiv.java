package cs5625.deferred.catmullclark;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


import javax.vecmath.Point3f;

import cs5625.deferred.datastruct.EdgeDS;
import cs5625.deferred.datastruct.EdgeData;
import cs5625.deferred.datastruct.PolygonData;
import cs5625.deferred.datastruct.VertexData;
import cs5625.deferred.scenegraph.Mesh;
import cs5625.deferred.scenegraph.Quadmesh;


public class CCSubdiv {
	
	private Mesh mMesh;
	
	public CCSubdiv(EdgeDS edgeDS)
	{
		// TODO PA5: Fill in this function to perform catmull clark subdivision
		
		Quadmesh oldMesh = (Quadmesh) edgeDS.getMesh();
		Set<Integer> vertexSet = edgeDS.getVertexIDs();
		Set<Integer> edgeSet = edgeDS.getEdgeIDs();
		Set<Integer> polygonSet = edgeDS.getPolygonIDs();
		
		int newVertexCount = vertexSet.size() + edgeSet.size() + polygonSet.size();
		int newPolygonCount = polygonSet.size() * 4;
		int newCreaseEdgesCount = oldMesh.getEdgeData().capacity(); // implicitly * 2 / 2
		
		FloatBuffer newVertices = FloatBuffer.allocate(newVertexCount*3);
		FloatBuffer newNormals = FloatBuffer.allocate(newVertexCount*3); // do not need to touch
		FloatBuffer newTexCoords = FloatBuffer.allocate(newVertexCount*2); // do not need to touch
		
		IntBuffer newCreaseEdges = IntBuffer.allocate(newCreaseEdgesCount*2);
		IntBuffer newQuads = IntBuffer.allocate(newPolygonCount*4);
		
		int newVertexIndex = 0; // -1 because we start incrementing immediately inside of setNewFaceVertexID
		//newVertices.put(oldMesh.getVertexData());
		
		for(int p : polygonSet) {
			PolygonData poly = edgeDS.getPolygonData(p);
			Point3f facePoint = new Point3f();
			for(int i : poly.getAllVertices()) {
				facePoint.add(edgeDS.getVertexData(i).mData.getPosition());
			}
			facePoint.scale(0.25f);
			poly.setNewFaceVertexID(newVertexIndex++);
			newVertices.put(facePoint.x);
			newVertices.put(facePoint.y);
			newVertices.put(facePoint.z);
		}
		for(int e : edgeSet) {
			EdgeData edge = edgeDS.getEdgeData(e);
			Point3f edgePoint = new Point3f();
			edgePoint.add(edgeDS.getVertexData(edge.getVertex0()).mData.getPosition());
			edgePoint.add(edgeDS.getVertexData(edge.getVertex1()).mData.getPosition());
			if(!edgeDS.isCreaseEdge(e)) {			
				for(int i : edge.getPolys()) {
					int index = edgeDS.getPolygonData(i).getNewFaceVertexID();
					Point3f p = new Point3f(newVertices.get(index*3),newVertices.get(index*3+1),newVertices.get(index*3+2));
					edgePoint.add(p);
				}
				edgePoint.scale(0.25f);
			}
			else { edgePoint.scale(0.5f); }
			
			edge.setVertexIDNew(newVertexIndex++);
			newVertices.put(edgePoint.x);
			newVertices.put(edgePoint.y);
			newVertices.put(edgePoint.z);
		}
		for(int v : vertexSet) {
			VertexData vert = edgeDS.getVertexData(v);
			Point3f point = new Point3f();
			ArrayList<Integer> creases = new ArrayList<Integer>();
			for(int e : vert.getConnectedEdges()) {
				if(edgeDS.isCreaseEdge(e)) {
					creases.add(e);
				}
			}
			if(creases.size() > 2) {
				point.set(vert.mData.getPosition().x, vert.mData.getPosition().y, vert.mData.getPosition().z);
			}
			else if(creases.size() == 2) {
				point.add(vert.mData.getPosition());
				point.scale(6.0f);
				for(int e : creases) {
					Point3f edgePoint = new Point3f(newVertices.get(edgeDS.getEdgeData(e).getNewVertexID()*3),newVertices.get(edgeDS.getEdgeData(e).getNewVertexID()*3+1),newVertices.get(edgeDS.getEdgeData(e).getNewVertexID()*3+2));
					point.add(edgePoint);
				}
				point.scale(0.125f);
			}
			else {
				Point3f faceSum = new Point3f();
				Point3f edgeSum = new Point3f();
				HashSet<Integer> faces = new HashSet<Integer>();
				for(int e : vert.getConnectedEdges()) {
					faces.addAll(edgeDS.getEdgeData(e).getPolys());
					int id = edgeDS.getEdgeData(e).getNewVertexID();
					Point3f edgePoint = new Point3f(newVertices.get(id*3),newVertices.get(id*3+1),newVertices.get(id*3+2));
					edgeSum.add(edgePoint);
				}
				
				for(int f : faces) {
					int id = edgeDS.getPolygonData(f).getNewFaceVertexID();
					Point3f facePoint = new Point3f(newVertices.get(id*3),newVertices.get(id*3+1),newVertices.get(id*3+2));
					faceSum.add(facePoint);
				}
				int n = (faces.size()+vert.getConnectedEdges().size() + 1);
				point.add(vert.mData.getPosition());
				point.scale((n-2.0f)/n);
				edgeSum.scale(1.0f/(n*n));
				faceSum.scale(1.0f/(n*n));
				point.add(edgeSum);
				point.add(faceSum);		
			}
			vert.setNewVertexID(newVertexIndex++);
			newVertices.put(point.x);
			newVertices.put(point.y);
			newVertices.put(point.z);
		}
		HashSet<Integer> used = new HashSet<Integer>();
		for(int p : edgeDS.getPolygonIDs()) {
			PolygonData oldFace = edgeDS.getPolygonData(p);
			for(int e : oldFace.getAllEdges()) {
				EdgeData lEdge = edgeDS.getEdgeData(e);
				newQuads.put(oldFace.getNewFaceVertexID());
				newQuads.put(lEdge.getNewVertexID());
				for(int r : oldFace.getAllEdges()) {
					if(r != e && !used.contains(lEdge.getVertex0()) &&
							(edgeDS.getEdgeData(r).getVertex0() == lEdge.getVertex0() ||
									edgeDS.getEdgeData(r).getVertex1() == lEdge.getVertex0())) {
						newQuads.put(edgeDS.getVertexData(lEdge.getVertex0()).getNewVertexID());
						newQuads.put(edgeDS.getEdgeData(r).getNewVertexID());
						used.add(lEdge.getVertex0());
						break;
					}
					else if(r != e && !used.contains(lEdge.getVertex1()) &&
							(edgeDS.getEdgeData(r).getVertex0() == lEdge.getVertex1() ||
									edgeDS.getEdgeData(r).getVertex1() == lEdge.getVertex1())) {
						newQuads.put(edgeDS.getVertexData(lEdge.getVertex1()).getNewVertexID());
						newQuads.put(edgeDS.getEdgeData(r).getNewVertexID());
						used.add(lEdge.getVertex1());
						break;
					}
				}
			}
			used.clear();
		}
		for(int e: edgeDS.getEdgeIDs()) {
			if(edgeDS.isCreaseEdge(e)) {
				newCreaseEdges.put(edgeDS.getEdgeData(e).getNewVertexID());
				newCreaseEdges.put(edgeDS.getVertexData(edgeDS.getEdgeData(e).getVertex0()).getNewVertexID());
				newCreaseEdges.put(edgeDS.getEdgeData(e).getNewVertexID());
				newCreaseEdges.put(edgeDS.getVertexData(edgeDS.getEdgeData(e).getVertex1()).getNewVertexID());
			}
		}
		
		newVertices.position(0);
		newCreaseEdges.position(0);
		newQuads.position(0);
		
		Mesh newMesh = oldMesh.clone();
		newMesh.setVertexData(newVertices);
		newMesh.setNormalData(newNormals);
		newMesh.setTexCoordData(newTexCoords);
		newMesh.setEdgeData(newCreaseEdges);
		newMesh.setPolygonData(newQuads);
		this.mMesh = newMesh;
	}
	
	public Mesh getNewMesh()
	{
		return this.mMesh;
	}
	
}

