package Final;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Control extends JPanel implements ActionListener {
	
	private JTextField angle;
	private JTextField initialVelocity;
	private JTextField distanceFromTarget;
	private JButton setNewTarget,createCannon;
	
	private static final int CONTROL_WIDTH = 720;
	private static final int CONTROL_HEIGHT = 200;
	
	private GameRunner game;
	
	public Control(GameRunner game)
	{
		this.game = game;
		setLayout(new GridLayout(3,3));
		createCannon=new JButton("Draw Cannon");
		angle = new JTextField();
		initialVelocity=new JTextField();
		distanceFromTarget=new JTextField();
		setNewTarget=new JButton("Create new Target!");
		setNewTarget.addActionListener(this);
		add(new JLabel("Angle"));
		add(angle);
		createCannon.addActionListener(this);
		add(new JLabel(""));
		distanceFromTarget.setEditable(false);
		add(new JLabel("Initial Velocity:"));
		add(initialVelocity);
		add(createCannon);
		add(new JLabel("Distance from Target:"));
		add(distanceFromTarget);
		add(setNewTarget);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(setNewTarget)){
			initialVelocity.setText("test");
		}
		if(e.getSource().equals(createCannon)){
			initialVelocity.setText("test");
			double atAngle = Double.parseDouble(angle.getText());
			if (atAngle > 90 || atAngle < 0) 
			{
				
				JOptionPane.showMessageDialog(null, "Please enter angle between 0 and 90 degrees.", "Error", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			game.setAngle(atAngle);
			
		}
	}
}
