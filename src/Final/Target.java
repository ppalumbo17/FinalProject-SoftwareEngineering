package Final;

import java.awt.Graphics2D;

public class Target {

	private static final int targetSize = 10;
	
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
		g.fillOval(xcoor, ycoor, targetSize, targetSize);
	}
	
	
}
