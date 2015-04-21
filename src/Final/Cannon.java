package Final;

public class Cannon {

	private static double GRAVITY = 9.8;
	private double xcoor;
	private double ycoor;
	private double angle;
	private double velocity;
	
	
	public Cannon(){
		this.xcoor = 0;
		this.ycoor = 0;
		this.angle = 0;
		this.velocity = 0;
	}
	public Cannon(double xcoor, double ycoor, double angle, double velocity){
		this.xcoor = xcoor;
		this.ycoor = ycoor;
		this.angle = angle;
		this.velocity = velocity;
	}
	
	private void calcXPosition(double time){
		//return (velocity*Math.cos(angle)*time);
	}
	private void calcYPosition(double time){
		//return ((velocity*Math.sin(angle)*time)+(GRAVITY*Math.pow(velocity,2.0)/2));
	}
	void fireProjectile(){
		
	}
	public double getXCoor(){
		return xcoor;
	}
	public double getYCoor(){
		return ycoor;
	}
	public double getXCoor(double time){
		return xcoor;
	}
	public double getYCoor(double time){
		return ycoor;
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
