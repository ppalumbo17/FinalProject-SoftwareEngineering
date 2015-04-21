package Final;

import java.lang.Math;
public class GameRunner {

	private static final double GRAVITY = 9.8;
	private double angle, velocity, distance;
	private Cannon cannon;
	private Target target;
	
	void calcTrajectory(){
		
	}

	public void createCannon(int xcoor, int ycoor, double angle, double velocity) {
		cannon = new Cannon(xcoor, ycoor, angle, velocity);
	}

	public void createTarget(int xcoor, int ycoor) {
		target = new Target(xcoor, ycoor);
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

	public double getXDistance() {
		return (Math.pow(velocity, 2.0)*Math.sin(2*angle*Math.PI/180))/GRAVITY;
		
	}
	
	public double distanceFromTarget(double target){
		return Math.abs(getXDistance()-target);
		
	}

	public boolean targetReached(Target target) {
		
		return (Math.abs(getXDistance()-target.getxCoor()) < 0.01);
		
	}
	private void generateTarget(){
		
	}
}
