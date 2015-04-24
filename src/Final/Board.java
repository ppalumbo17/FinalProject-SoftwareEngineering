package Final;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


public class Board extends JPanel {

	private Cannon cannon;
	private Target target;
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
	
	public void changeTarget(Target target)
	{
		this.target = target;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		cannon.draw((Graphics2D) g);
		
		target.draw((Graphics2D) g);
			
		
	}
}
