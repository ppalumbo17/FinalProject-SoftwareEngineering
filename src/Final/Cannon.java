package Final;

import java.awt.*;
import java.awt.geom.*;

public class Cannon {

	private static double GRAVITY = 9.8;
	private double xcoor;
	private double ycoor;
	private double angle;
	private double velocity;
	private double theta; 
	
	private static final int width = 150;
	private static final int height = 15;
	
	public Cannon(){
		this.xcoor = 150;
		this.ycoor = 390;
		this.angle = 0;
		this.velocity = 0;
		theta = Math.toRadians(angle);
	}
	public Cannon(double xcoor, double ycoor, double angle, double velocity){
		this.xcoor = xcoor;
		this.ycoor = ycoor;
		this.angle = angle;
		this.velocity = velocity;
		theta = Math.toRadians(angle);
	}
	
	
	public void draw(Graphics2D g) 
	{
		g.setColor(Color.BLACK);
		g.fillOval((int)Math.round(xcoor), (int)Math.round(ycoor),30, 30);
		
		AffineTransform transform = new AffineTransform();
		transform.translate(xcoor, ycoor); 
		transform.rotate(theta);
		
		
		Rectangle2D rect = new Rectangle2D.Double(-width / 2 + 15, -height / 2, width, height);
		Shape rotatedRect = transform.createTransformedShape(rect);
		g.fill(rotatedRect);
		g.draw(rotatedRect);		
	}
	
	void fireProjectile(){
		
	}
	public double getXCoor(){
		return xcoor;
	}
	public double getYCoor(){
		return ycoor;
	}

	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
		theta = Math.toRadians(angle);
	}
	public double getVelocity() {
		return velocity;
	}
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	
}
