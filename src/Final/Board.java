package Final;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


public class Board extends JPanel {

	private Cannon cannon;
	private Target target;
	private Projectile projectile;
	private ArrayList<Point> trajectory;
	
	private Graphics2D graphics;
	
	public Board(Cannon cannon, Target target)
	{
		this.cannon = cannon;
		this.target = target;
		trajectory=new ArrayList<Point>();
		setOpaque(true);
		setBackground(new Color(56,154,224));
			
	}
	
	public void changeCannon(Cannon cannon)
	{
		this.cannon = cannon;
	}
	
	public Cannon getCannon()
	{
		return cannon;
	}
	public void drawDot(double x, double y){
		trajectory.add(new Point((int)x,(int)y));
	}
	public void changeTarget(Target target)
	{
		this.target = target;
	}
	
	public Target getTarget()
	{
		return target;
	}
	
	public void createProjectile(Projectile projectile)
	{
		this.projectile = projectile;
		
	}
	public void clearTrajectory(){
		trajectory.clear();
	}
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		graphics=(Graphics2D)g;
		cannon.draw((Graphics2D) g);
		
		target.draw((Graphics2D) g);
		if(GameRunner.cannonCount == 1)
			g.setColor(Color.RED);
		else if(GameRunner.cannonCount == 2)
			g.setColor(Color.WHITE);
		else if(GameRunner.cannonCount == 3)
			g.setColor(Color.BLUE);
		if(!trajectory.isEmpty()){
			
			
			for(Point p:trajectory){
				g.fillOval((int)p.getX(),(int)p.getY(),3,3);
			}
		}
		try {
			projectile.draw(g);
		} catch (NullPointerException e) {
			return;
		}
		
	}

	private void drawTrajectory() {
		
	}
}
