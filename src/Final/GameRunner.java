package Final;

import java.lang.Math;
public class GameRunner {

	private static final double GRAVITY = 9.8;
	private double angle, velocity, distance;
	
	void calcTrajectory(){
		
	}

	public void createCannon() {
		// TODO Auto-generated method stub
		
	}

	public void createTarget(double x) {
		// TODO Auto-generated method stub
		
	}

	public double getAngle() {
		return angle;
		// TODO Auto-generated method stub
		
	}

	public void setAngle(double i) {
		angle = i;
		// TODO Auto-generated method stub
		
	}

	public void setInitialVelocity(double i) {
		velocity = i;
		
	}

	public double getInitialVelocity() {
		// TODO Auto-generated method stub
		return velocity;
	}

	public double getDistance() {
		distance = (Math.pow(velocity, 2.0)*Math.sin(2*angle*Math.PI/180))/GRAVITY;
		return distance;
	}

	public boolean targetReached() {
		// TODO Auto-generated method stub
		return false;
	}
}
