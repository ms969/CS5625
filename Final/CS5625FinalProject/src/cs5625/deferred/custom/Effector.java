package cs5625.deferred.custom;

import javax.vecmath.Point3f;

import cs5625.deferred.custom.ParticleSystem.Particle;

public abstract class Effector {
	protected Point3f position;
	Effector(Point3f p) {
		this.position = p;
	}
	public abstract Point3f getForce(Particle p);
	
	public Point3f getPosition() {
		return this.position;
	}
}
