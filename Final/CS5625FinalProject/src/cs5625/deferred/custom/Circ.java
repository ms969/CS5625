package cs5625.deferred.custom;

import javax.vecmath.AxisAngle4f;
import javax.vecmath.Matrix4f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import cs5625.deferred.custom.ParticleSystem.Particle;

public class Circ extends Effector {
	
	private float strength;
	private AxisAngle4f direction;
	Circ(Point3f p, float s, AxisAngle4f dir) {
		super(p);
		this.strength = s;
		this.direction = dir;
	}
	
	public Vector3f getForce(Particle p) {
		//TODO: add rotation code
		
		Vector3f force = new Vector3f(-p.getPosition().x/(float)Math.pow(position.distance(p.getPosition()),2),
				0,
				p.getPosition().z/(float)Math.pow(position.distance(p.getPosition()),2));
		force.scale(strength);
		Matrix4f rot = new Matrix4f();
		rot.setRotation(direction);
		rot.transform(force);
		
		return force;
	}
}
