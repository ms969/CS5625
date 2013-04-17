package cs5625.deferred.loop;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.*;

import javax.vecmath.Point3f;

import cs5625.deferred.datastruct.*;
import cs5625.deferred.scenegraph.Mesh;
import cs5625.deferred.scenegraph.Trimesh;

/**
 * LoopSubdiv.java
 * 
 * Perform the subdivision in this class/package 
 * 
 * Written for Cornell CS 5625 (Interactive Computer Graphics).
 * Copyright (c) 2012, Computer Science Department, Cornell University.
 * 
 * @author Rohit Garg (rg534)
 * @date 2012-03-23
 */

public class LoopSubdiv {
	
	private Mesh mMesh;
	
	public LoopSubdiv(EdgeDS edgeDS) {
		// TODO PA5: Fill in this function to perform loop subdivision
		
		Trimesh oldMesh = (Trimesh) edgeDS.getMesh();
		Set<Integer> vertexSet = edgeDS.getVertexIDs();
		Set<Integer> edgeSet = edgeDS.getEdgeIDs();
		Set<Integer> polygonSet = edgeDS.getPolygonIDs();
		
		// initiate new buffers for vertices (3 floats), normals (3 floats), texCoords (2 floats), crease edges / EdgeData (2 ints), triangles (3 ints)
		int oldVertexCount = vertexSet.size();
		int oldEdgeCount = edgeSet.size();
		int oldPolygonCount = polygonSet.size();
		
		int newVertexCount = oldVertexCount + oldEdgeCount;
		int newPolygonCount = oldPolygonCount * 4;
		int newCreaseEdgesCount = oldMesh.getEdgeData().capacity(); // implicitly * 2 / 2
		
		FloatBuffer newVertices = FloatBuffer.allocate(newVertexCount*3);
		FloatBuffer newNormals = FloatBuffer.allocate(newVertexCount*3); // do not need to touch
		FloatBuffer newTexCoords = FloatBuffer.allocate(newVertexCount*2); // do not need to touch
		
		IntBuffer newCreaseEdges = IntBuffer.allocate(newCreaseEdgesCount*2);
		IntBuffer newTriangles = IntBuffer.allocate(newPolygonCount*3);
		
		// copies the old vertices into the first part of the new vertex buffer
		newVertices.put(oldMesh.getVertexData());
		
		// looping over the edges to create new vertices
		Iterator<Integer> edgeIterator = edgeSet.iterator();
		
		// new vertex buffer index needs explicit tracking, all other buffers can be tracked by their internal position
		int newVertexIndex = oldVertexCount;
		
		while (edgeIterator.hasNext()) {
			int edgeID = edgeIterator.next();
			EdgeData edge = edgeDS.getEdgeData(edgeID);
			VertexData vertex0 = edgeDS.getVertexData(edge.getVertex0());
			VertexData vertex1 = edgeDS.getVertexData(edge.getVertex1());
			
			Point3f newVertexPosition;
			if (edgeDS.isCreaseEdge(edgeID)) {
				// crease edge
				newVertexPosition = newVertexCreaseBoundaryCase(vertex0, vertex1);
				
				// update crease edge set
				int[] creaseEdges = new int[] {edge.getVertex0(), newVertexIndex, newVertexIndex, edge.getVertex1()};
				newCreaseEdges.put(creaseEdges);
			} else {
				// get position of top vertex
				ArrayList<Integer> topEdgesIDs = edgeDS.getOtherEdgesOfLeftFace(edgeID);
				EdgeData firstEdge = edgeDS.getEdgeData(topEdgesIDs.get(0));
				int topVertexIndex = (firstEdge.getVertex0() == edge.getVertex0()) ? firstEdge.getVertex0() : firstEdge.getVertex1();
				VertexData topVertex = edgeDS.getVertexData(topVertexIndex);
					
				// get position of bottom vertex
				ArrayList<Integer> bottomEdgesIDs = edgeDS.getOtherEdgesOfRightFace(edgeID);
				if (bottomEdgesIDs == null) {
					// boundary edge
					newVertexPosition = newVertexCreaseBoundaryCase(vertex0, vertex1);
				} else {
					EdgeData firstEdgeBottom = edgeDS.getEdgeData(bottomEdgesIDs.get(0));
					int bottomVertexIndex = (firstEdgeBottom.getVertex0() == edge.getVertex0()) ? firstEdgeBottom.getVertex0() : firstEdgeBottom.getVertex1();
					VertexData bottomVertex = edgeDS.getVertexData(bottomVertexIndex);
					newVertexPosition = newVertexRegularCase(vertex0, vertex1, topVertex, bottomVertex);
				}
			}
			
			// store the new vertex index for old index calculations
			edge.setVertexIDNew(newVertexIndex);
			
			// store the new vertex position into newVertices
			float[] newPositionArray = new float[3];
			newVertexPosition.get(newPositionArray);
			newVertices.put(newPositionArray, newVertexIndex*3, 3);
			newVertexIndex++;
		}
		
		// loop over the old vertices to edit their position
		Iterator<Integer> vertexIterator = vertexSet.iterator();
		newVertexIndex = 0;
		while (vertexIterator.hasNext()) {
			int vertexID = vertexIterator.next();
			VertexData vertex = edgeDS.getVertexData(vertexID);
			
			// get surrounding new vertices
			ArrayList<Integer> connectedEdges = vertex.getConnectedEdges();
			int[] connectedVertexIDs = new int[connectedEdges.size()];
			int creaseEdgeCount = 0;
			for (int i = 0; i < connectedEdges.size(); i++) {
				int edgeID = connectedEdges.get(i);
				connectedVertexIDs[i] = edgeDS.getEdgeData(edgeID).getNewVertexID();
				if (edgeDS.isCreaseEdge(edgeID)) {
					creaseEdgeCount++;
				}
			}
			
			// calculate new position
			Point3f newVertexPosition = oldVertexPositionShift(vertex, connectedVertexIDs, creaseEdgeCount);
			
			// store the new vertex index for forming polygons
			vertex.setNewVertexID(newVertexIndex);
			
			// store the new position for the current vertex into newVertices
			float[] newPositionArray = new float[3];
			newVertexPosition.get(newPositionArray);
			newVertices.put(newPositionArray, newVertexIndex*3, 3);
			newVertexIndex++;
		}
		
		// loop over polygons to form 4 new triangles
		Iterator<Integer> polygonIterator = polygonSet.iterator();
		while (polygonIterator.hasNext()) {
			int polygonID = polygonIterator.next();
			PolygonData polygon = edgeDS.getPolygonData(polygonID);
			ArrayList<Integer> edgeIDs = polygon.getAllEdges();
			EdgeData e0 = edgeDS.getEdgeData(edgeIDs.get(0));
			EdgeData e1 = edgeDS.getEdgeData(edgeIDs.get(1));
			EdgeData e2 = edgeDS.getEdgeData(edgeIDs.get(2));
			
			// v0 is common point between e0 and e2, v1 is common point between e0 and e1, v2: e1 and e2
			VertexData v0, v1, v2;
			if (e0.getVertex0() == e2.getVertex0() || e0.getVertex0() == e2.getVertex1()) {
				v0 = edgeDS.getVertexData(e0.getVertex0());
			} else {
				v0 = edgeDS.getVertexData(e0.getVertex1());
			}
			
			if (e0.getVertex0() == e1.getVertex0() || e0.getVertex0() == e1.getVertex1()) {
				v1 = edgeDS.getVertexData(e0.getVertex0());
			} else {
				v1 = edgeDS.getVertexData(e0.getVertex1());
			}
			
			if (e1.getVertex0() == e2.getVertex0() || e1.getVertex0() == e2.getVertex1()) {
				v2 = edgeDS.getVertexData(e1.getVertex0());
			} else {
				v2 = edgeDS.getVertexData(e1.getVertex1());
			}

			int[] tris = new int[] {v0.getNewVertexID(), e0.getNewVertexID(), e2.getNewVertexID(), // tri0: v0, e0, e2
									v1.getNewVertexID(), e1.getNewVertexID(), e2.getNewVertexID(), // tri1: v1, e1, e0
									v2.getNewVertexID(), e2.getNewVertexID(), e1.getNewVertexID(), // tri2: v2, e2, e1
									e0.getNewVertexID(), e1.getNewVertexID(), e2.getNewVertexID()}; // tri3: e0, e1, e1
			
			newTriangles.put(tris);
			
		}
		
		Mesh newMesh = oldMesh.clone();
		newMesh.setVertexData(newVertices);
		newMesh.setNormalData(newNormals);
		newMesh.setTexCoordData(newTexCoords);
		newMesh.setEdgeData(newCreaseEdges);
		newMesh.setPolygonData(newTriangles);
		this.mMesh = newMesh;
	}
	
	private Point3f oldVertexPositionShift(VertexData vertex,
			int[] connectedVertexIDs, int creaseEdgeCount) {
		// TODO Auto-generated method stub
		return null;
	}

	private Point3f newVertexRegularCase(VertexData vertex0,
			VertexData vertex1, VertexData topVertex, VertexData bottomVertex) {
		// TODO Auto-generated method stub
		
		return null;
	}

	private Point3f newVertexCreaseBoundaryCase(VertexData vertex0,
			VertexData vertex1) {
		Point3f v0pos = vertex0.mData.getPosition();
		Point3f v1pos = vertex1.mData.getPosition();
		v0pos.scale(0.5f);
		v1pos.scale(0.5f);
		Point3f newPosition = new Point3f();
		newPosition.add(v0pos, v1pos);
		return newPosition;
	}

	public Mesh getNewMesh()
	{
		return this.mMesh;
	}
	
}