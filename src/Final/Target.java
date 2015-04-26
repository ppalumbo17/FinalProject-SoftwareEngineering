package Final;

import java.awt.Color;
import java.awt.Graphics2D;

public class Target {

	public static final int TARGET_SIZE = 20;
	
	private int xcoor;
	private int ycoor;
	
	public Target(int xcoor, int ycoor){
		this.xcoor = xcoor;
		this.ycoor = ycoor;
	}
	public int getxCoor() {
		return xcoor;
	}
	public void setxCoor(int xCoor) {
		this.xcoor = xCoor;
	}
	public int getyCoor() {
		return ycoor;
	}
	public void setyCoor(int yCoor) {
		this.ycoor = yCoor;
	}
	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillOval(xcoor, ycoor, TARGET_SIZE, TARGET_SIZE);
	}
	
	
}
