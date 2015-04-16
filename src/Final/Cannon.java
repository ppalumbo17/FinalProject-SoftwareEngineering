package Final;

public class Cannon {

	private static double GRAVITY = 9.8;
	private double xcoor;
	private double ycoor;
	private double angle;
	private double velocity;
	
	public Cannon(double xcoor, double ycoor, double angle, double velocity){
		this.xcoor = xcoor;
		this.ycoor = ycoor;
		this.angle = angle;
		this.velocity = velocity;
	}
	
	private double calcXPosition(double time){
		return (velocity*Math.cos(angle)*time);
	}
	private double calcYPosition(double time){
		return ((velocity*Math.sin(angle)*time)+(GRAVITY*Math.pow(velocity,2.0)/2));
	}
	void fireProjectile(){
		
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public double getVelocity() {
		return velocity;
	}
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	
}
