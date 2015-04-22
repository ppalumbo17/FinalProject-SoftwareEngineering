package Final;

import java.awt.*;

import javax.swing.*;



public class Board extends JPanel {
	
	private Graphics2D graphics;
	
	public Board()
	{
		setOpaque(true);
		setBackground(Color.BLUE);
			
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
}
