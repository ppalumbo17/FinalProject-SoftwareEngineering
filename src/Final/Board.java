package Final;

import java.awt.*;

import javax.swing.*;



public class Board extends JPanel {
	
	private Cannon cannon;
	private Target target;
	
	private Graphics2D graphics;
	
	public Board(Cannon cannon, Target target)
	{
		this.cannon = cannon;
		this.target = target;
		
		setOpaque(true);
		setBackground(Color.BLUE);
			
	}
	
	public void changeCannon(Cannon cannon)
	{
		this.cannon = cannon;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		cannon.draw((Graphics2D) g);
		// target.draw((Graphics2D) g);
		
	}
}
