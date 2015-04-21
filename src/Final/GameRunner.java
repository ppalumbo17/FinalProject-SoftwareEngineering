package Final;

import java.lang.Math;
import java.util.Scanner;
public class GameRunner {

	private static final double GRAVITY = 9.8;
	private double angle, velocity, distance;
	private Cannon cannon;
	private Target target;
	public static void main(String[] args){
		GameRunner runner=new GameRunner();
		Scanner sc=new Scanner(System.in);
		runner.createTarget(100, 0);
		System.out.println("The target is placed at (100,0) and the cannon at (0,0)\nEnter a starting velocity:");
		double vel=sc.nextDouble();
		System.out.println("Please enter a starting angle for the cannon:");
		double ang=sc.nextDouble();
		runner.setAngle(ang);
		runner.setInitialVelocity(vel);
		runner.createCannon(0, 0, ang, vel);
		System.out.println("The ball landed on the ground at coord (" + (double)Math.round(runner.getXDistance()*1000)/1000 + ",0)");
	}
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
