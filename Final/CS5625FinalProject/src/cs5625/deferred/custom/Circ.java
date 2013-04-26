package cs5625.deferred.custom;

import javax.vecmath.AxisAngle4f;
import javax.vecmath.Point3f;

import cs5625.deferred.custom.ParticleSystem.Particle;

public class Circ extends Effector {
	
	private float strength;
	private AxisAngle4f direction;
	Circ(Point3f p, float s, AxisAngle4f dir) {
		super(p);
		this.strength = s;
		this.direction = dir;
	}
	
	public Point3f getForce(Particle p) {
		//TODO: add rotation code
		
		Point3f force = new Point3f(-p.getPosition().x/(float)Math.pow(position.distance(p.getPosition()),2),
				0,
				p.getPosition().z/(float)Math.pow(position.distance(p.getPosition()),2));
		force.scale(strength);
		return force;
	}
}
