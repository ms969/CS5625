package cs5625.deferred.custom;

import javax.vecmath.AxisAngle4f;
import javax.vecmath.Matrix4f;
import javax.vecmath.Point3f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

import cs5625.deferred.custom.ParticleSystem.Particle;
import cs5625.deferred.misc.Util;

public class Gravity extends Effector {
	
	private float strength;
	private AxisAngle4f direction;
	Gravity(Point3f p, float s, AxisAngle4f dir) {
		super(p);
		this.strength = s;
		this.direction = dir;
	}
	@Override
	public Vector3f getForce(Particle p) {
		//TODO: add rotation code
		Vector4f grav = new Vector4f(0,strength,0,0);
		if(direction.angle != 0) {
			//System.out.println(direction.toString());
			Quat4f q = new Quat4f();
			q.set(direction);
			Matrix4f rot = Util.getRotationMatrix4f(q);
			rot.transform(grav);
		}
		//System.out.println("x: "+grav.x+"y: "+grav.y+"z: "+grav.z);
		return new Vector3f(grav.x,grav.y,grav.z);
	}
	
}