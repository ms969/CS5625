package cs5625.deferred.custom;

import java.util.ArrayList;

import javax.vecmath.Point3f;

public class ParticleSystem {

	private ArrayList<Particle> particles;
	private ArrayList<Effector> effectors;
	private float lifetime;
	private int numParticles;
	private float birthRate;
	private float viscosity;
	
	ParticleSystem(int n, float l, float b, float v) {
		this.numParticles = n;
		this.lifetime = l;
		this.birthRate = b;
		this.viscosity = v;
	}
	
	public void setLifetime(int n) {
		this.numParticles = n;
	}
	
	public void setBirthrate(float b) {
		this.birthRate = b;
	}

	public void setNumParticles(float l) {
		this.lifetime = l;
	}
	
	public void step(float timeStep) {
		
	}
	
	private class Effector {

	}
	
	private class Particle {
		private boolean living;
		private float age;
		private float mass;
		private Point3f position;
		private Point3f speed;
		private Point3f acceleration;
	}
}
