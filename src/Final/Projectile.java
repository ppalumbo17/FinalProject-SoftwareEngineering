package Final;

public class Projectile {

	private static double GRAVITY = 9.8;
	private double angle, velocity, xcoor, ycoor;
	
	public Projectile(int xCoor, int yCoor, double angle, double velocity) {
		
		this.xcoor = xCoor;
		this.ycoor = yCoor;
		this.angle = angle;
		this.velocity = velocity;
	}

	public Projectile() {
		this.xcoor = 0;
		this.ycoor = 0;
		this.angle = 45;
		this.velocity = 10;
	}

	private void calcXPosition(double time){
		xcoor = (velocity*Math.cos(angle*Math.PI/180)*time);
	}
	private void calcYPosition(double time){
		ycoor = ((velocity*Math.sin(angle*Math.PI/180)*time)-(GRAVITY*Math.pow(time,2.0)/2));
	}
	public double getXCoor(double time){
		calcXPosition(time);
		return xcoor;
	}
	public double getYCoor(double time){
		calcYPosition(time);
		return ycoor;
	}
	
	
	public void setVelocity(double v){
		this.velocity = v;
	}
	public void setAngle(double angle){
		this.angle = angle;
	}
	public double getXCoor() {
		return xcoor;
	}

	public void setxCoor(int xCoor) {
		this.xcoor = xCoor;
	}

	public double getYCoor() {
		return ycoor;
	}

	public void setyCoor(int yCoor) {
		this.ycoor = yCoor;
	}
	
}
