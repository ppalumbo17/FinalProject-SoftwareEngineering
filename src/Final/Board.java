package Final;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


public class Board extends JPanel {

	private Cannon cannon;
	private Target target;
	private Projectile projectile;
	// private ArrayList<Target> targetList;
	
	private Graphics2D graphics;
	
	public Board(Cannon cannon, Target target)
	{
		this.cannon = cannon;
		this.target = target;
		
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
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		cannon.draw((Graphics2D) g);
		
		target.draw((Graphics2D) g);
		
		try {
			projectile.draw(g);
		} catch (NullPointerException e) {
			return;
		}
		
		// g.setColor(Color.black);
		//g.fillRect(100, 20, 900-100- 20, 500 - 20);
	}

	private void drawTrajectory() {
		
	}
}
