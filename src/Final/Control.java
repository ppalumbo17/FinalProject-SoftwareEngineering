package Final;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Control extends JPanel implements ActionListener {

	private JTextField angle;
	private JTextField initialVelocity;
	private JTextField distanceFromTarget;
	private JButton setNewTarget, createCannon, fireCannon;

	private static final int CONTROL_WIDTH = 720;
	private static final int CONTROL_HEIGHT = 200;

	private boolean canSetTarget = false;

	private GameRunner game;
	private Board board;

	public Control(GameRunner game, Board board)
	{
		this.game = game;
		this.board = board;

		setLayout(new GridLayout(3,3));

		// create buttons
		createCannon = new JButton("Draw Cannon");
		setNewTarget = new JButton("Create new Target!");
		fireCannon = new JButton("Fire!");

		// create text fields
		angle = new JTextField();
		initialVelocity = new JTextField();
		distanceFromTarget = new JTextField();

		// setup action listeners for buttons
		setNewTarget.addActionListener(this);
		createCannon.addActionListener(this);
		fireCannon.addActionListener(this);

		// add buttons and fields to control panel
		add(new JLabel("Angle"));
		angle.setText("0");
		add(angle);
		add(fireCannon);
		add(new JLabel("Initial Velocity:"));
		initialVelocity.setText("50");
		add(initialVelocity);
		add(createCannon);
		add(new JLabel("Distance from Target:"));
		add(distanceFromTarget);
		add(setNewTarget);

		// change settings for panels
		distanceFromTarget.setEditable(false);
		setVisible(true);	
	}

	public void setTargetCondition(boolean b)
	{
		canSetTarget = b;
	}

	// public void
	
	@Override
	public void actionPerformed(ActionEvent e) {


		if(e.getSource().equals(setNewTarget)){

			distanceFromTarget.setText("target click");

			if (canSetTarget)
			{
				game.setNextTarget();
				canSetTarget = false;
			}	
		}
		
		if(e.getSource().equals(createCannon) || e.getSource().equals(fireCannon)) {

			distanceFromTarget.setText("cannon click");

			double atAngle;

			try
			{
				atAngle = Double.parseDouble(angle.getText());
			}

			catch (NumberFormatException exception)
			{
				JOptionPane.showMessageDialog(null, "Please enter an angle between 0 and 90 degrees.", "Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			}



			if (atAngle > 90 || atAngle < 0) 
			{

				JOptionPane.showMessageDialog(null, "Please enter an angle between 0 and 90 degrees.", "Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			game.setAngle(atAngle);
		}

		if(e.getSource().equals(fireCannon))
		{	

			
			double initVelocity; 
			
			try 
			{
				initVelocity = Double.parseDouble(initialVelocity.getText());
			}

			catch (NumberFormatException exception)
			{
				JOptionPane.showMessageDialog(null, "Please enter a positive number value for velocity", "Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			if (initVelocity < 0) 
			{

				JOptionPane.showMessageDialog(null, "Please enter a positive number value for velocity", "Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			game.setInitialVelocity(initVelocity);
			game.fireProjectile();
			distanceFromTarget.setText("fire cannon click");
			
		}


	}
}
