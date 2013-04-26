package cs5625.deferred.custom;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

import javax.vecmath.AxisAngle4f;
import javax.vecmath.Point3f;

import cs5625.deferred.scenegraph.SceneObject;

public class ParticleSystem extends SceneObject{

	private PriorityBlockingQueue<Particle> live;
	private PriorityBlockingQueue<Particle> dead;
	private ArrayList<Effector> effectors;
	private int numParticles;
	private float birthRate;
	private float timeSinceLastBirth;
	private float dragCoefficient;
	private float lifetime;
	private float mass;
	private float emitterSize;
	private static boolean d = false;
	
	ParticleSystem(int num, float birth, float drag, float life, float mass, Point3f pos, float emitSize, ArrayList<Effector> effects) {
		this.numParticles = num;
		this.birthRate = birth;
		this.dragCoefficient = drag;
		this.mPosition = pos;
		this.lifetime = life;
		this.mass = mass;
		timeSinceLastBirth = 0;
		this.emitterSize = emitSize;
		live = new PriorityBlockingQueue<Particle>(numParticles);
		dead = new PriorityBlockingQueue<Particle>(numParticles);
		effectors = effects;
		
		for(int i = 0; i < numParticles; i++) {
			dead.add(new Particle());
		}
	}
	
	public void animate(float dt) {
		super.animate(dt);
		step(dt);
	}
	
	public void setBirthrate(float b) {
		this.birthRate = b;
	}

	public void setNumParticles(int n) {
		this.numParticles = n;
	}
	
	public int getNumParticles() {
		return numParticles;
	}
	
	public int getNumAlive() {
		return live.size();
	}
	
	public int getNumDead() {
		return dead.size();
	}
	
	public FloatBuffer getParticlePositions() {
		float[] pos = new float[live.size()*3];
		Particle[] part = new Particle[live.size()];
		part = live.toArray(part);
		for(int i = 0; i < live.size(); i++) {
			pos[3*i] = part[i].getPosition().x;
			pos[3*i+1] = part[i].getPosition().y;
			pos[3*i+2] = part[i].getPosition().z;
		}
		FloatBuffer fb = FloatBuffer.allocate(live.size()*3);
		for(float f : pos)
			fb.put(f);
		return fb;
	}
	
	public void step(float timeStep) {
		for(Particle p : live) {
			//kill particles
			if (p.getAge() > p.lifetime) {
				p.setLiving(false);
				dead.add(live.poll());
			}
			if(p.isLiving()) {
				Point3f force = new Point3f();
				//sum effector forces
				for(Effector e : effectors) {
					force.add(e.getForce(p));
				}
				//add drag
				Point3f drag = new Point3f(p.getVelocity().x*p.getVelocity().x*Math.signum(p.getVelocity().x),p.getVelocity().y*p.getVelocity().y*Math.signum(p.getVelocity().y),p.getVelocity().z*p.getVelocity().z*Math.signum(p.getVelocity().z));
				drag.negate();
				drag.scale(0.5f*dragCoefficient);
				force.add(drag);
				//calculated interpolated acceleration for timeStep
				Point3f interp = new Point3f(force);
				interp.scale(1.0f/p.getMass());
				interp.add(p.getAcceleration());
				interp.scale(0.5f);
				//set new acceleration
				Point3f acc = new Point3f(force);
				acc.scale(1.0f/p.getMass());
				p.setAcceleration(acc);
				//calculate new velocity
				Point3f vel = new Point3f(interp);
				vel.scale(timeStep);
				vel.add(p.getVelocity());
				//calculate new position
				Point3f pos = new Point3f(interp);
				pos.scale((float) (Math.pow(timeStep, 2)/2.0f));
				Point3f velComponent = new Point3f(p.getVelocity());
				velComponent.scale(timeStep);
				pos.add(velComponent);
				pos.add(p.getPosition());
				//set new velocity and position
				p.setVelocity(vel);
				p.setPosition(pos);
				//set particle age
				p.setAge(p.getAge()+timeStep);
			}
		}
		timeSinceLastBirth += timeStep;
		if(timeSinceLastBirth > birthRate) {
			int n = (int) Math.floor(timeSinceLastBirth/birthRate);
			for(int i = 0; i < n; i++) {
				if(!dead.isEmpty()) {
					Particle p = dead.poll();
					p.reset();
					p.setLifetime(lifetime);
					p.setMass(mass);
					p.position.set(((float)Math.random() - 0.5f)*emitterSize*2f, 0, ((float)Math.random() - 0.5f)*emitterSize*2f);
					live.add(p);
				}
			}
			timeSinceLastBirth = 0;
		}
	}
	
	public void addEffector(Effector e) {
		this.effectors.add(e);
	}
	
	public class Particle implements Comparable<Particle>{
		private boolean living;
		private float age;
		private float mass;
		private Point3f position;
		private Point3f velocity;
		private Point3f acceleration;
		private float lifetime;
		
		Particle() {
			age = 0;
			mass = 1;
			lifetime = 1;
			living = true;
			this.position = new Point3f();
			this.velocity = new Point3f();
			this.acceleration = new Point3f();
		}	
		
		public void reset() {
			living = true;
			position.set(0, 0, 0);
			velocity.set(0, 0, 0);
			acceleration.set(0, 0, 0);
			age = 0;
			mass = 1;
			lifetime = 1;
		}
		
		public void setAcceleration(Point3f a) { acceleration = a; }
		
		public void setVelocity(Point3f v) { velocity = v; }
		
		public void setPosition(Point3f p) { position = p; }
		
		public void setMass(float m) { mass = m; }
		
		public void setAge(float a) { age = a; }
		
		public void setLiving(boolean b) { living = b; }
		
		public void setLifetime(float l) { lifetime = l; }
		
		public Point3f getAcceleration() { return acceleration; }
		
		public Point3f getVelocity() { return velocity; }
		
		public Point3f getPosition() { return position; }
		
		public float getMass() { return mass; }
		
		public float getAge() { return age; }
		
		public boolean isLiving() { return living; }
		
		public float getLifetime() { return lifetime; }

		@Override
		public int compareTo(Particle p) {
			if(this.lifetime - this.age == p.lifetime - p.age)
				return 0;
			else if(this.lifetime - this.age < p.lifetime - p.age)
				return -1;
			else return 1;
		}
	}
}
