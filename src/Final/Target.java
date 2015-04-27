package Final;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Target {

	public static final int TARGET_SIZE = 20;
	Rectangle2D rect;
	
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
		rect = new Rectangle2D.Double(xcoor, ycoor, TARGET_SIZE, TARGET_SIZE);
		//g.fill(rect);
		g.fillOval(xcoor, ycoor, TARGET_SIZE, TARGET_SIZE);
	}
	public boolean contains(double x, double y){
		//System.out.println(xcoor+"     derp    "+ycoor);
		return rect.contains(new Point2D.Double(x, y));
		
		// return(x < xcoor + TARGET_SIZE+50 && x > xcoor && y < ycoor + TARGET_SIZE+50 && y > ycoor);
	}
}
