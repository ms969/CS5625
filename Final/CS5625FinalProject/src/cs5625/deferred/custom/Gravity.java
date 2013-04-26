package cs5625.deferred.custom;

import javax.vecmath.AxisAngle4f;
import javax.vecmath.Point3f;

import cs5625.deferred.custom.ParticleSystem.Particle;

public class Gravity extends Effector {
	
	private float strength;
	private AxisAngle4f direction;
	Gravity(Point3f p, float s, AxisAngle4f dir) {
		super(p);
		this.strength = s;
		this.direction = dir;
	}
	@Override
	public Point3f getForce(Particle p) {
		//TODO: add rotation code
		return new Point3f(0,strength,0);
	}
	
}