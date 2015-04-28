package Final;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Control extends JPanel implements ActionListener {

	private JTextField angle;
	private JTextField initialVelocity;
	private JTextField gameStatusField;
	private JTextField shots;
	private static JTextField targetsHit, score;
	private int totalShots;
	public static int numTargets, realScore;
	private JButton endGameButton, createCannon, fireCannon;

	private static final int NUM_TARGETS = 5;
	private static final int CONTROL_WIDTH = 720;
	private static final int CONTROL_HEIGHT = 200;

	private boolean canSetTarget = false;
	private double initVelocity;
	private GameRunner game;
	private Board board;

	public Control(GameRunner game, Board board)
	{
		this.game = game;
		this.board = board;

		setLayout(new GridLayout(4,3));

		// create buttons
		createCannon = new JButton("Move Cannon");
		endGameButton = new JButton("End Game");
		fireCannon = new JButton("Fire!");

		// create text fields
		angle = new JTextField();
		initialVelocity = new JTextField();
		gameStatusField = new JTextField();
		score = new JTextField();
		shots = new JTextField();
		targetsHit = new JTextField();
		
		score.setEditable(false);
		shots.setEditable(false);
		targetsHit.setEditable(false);
		
		score.setText("0");
		shots.setText("0");
		targetsHit.setText("0");
		
		// setup action listeners for buttons
		endGameButton.addActionListener(this);
		createCannon.addActionListener(this);
		fireCannon.addActionListener(this);
		
		//Create Panels and add to them
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		panel1.setLayout(new GridLayout(1,2));
		panel2.setLayout(new GridLayout(1,2));
		panel3.setLayout(new GridLayout(1,2));
		
		
		panel1.add(new JLabel("Total Shots"));
		panel1.add(shots);
		panel2.add(new JLabel("Targets Hit"));
		panel2.add(targetsHit);
		panel3.add(new JLabel("Score"));
		panel3.add(score);
		
		// add buttons and fields to control panel
		add(panel1);
		add(panel2);
		add(panel3);
		add(new JLabel("Angle"));
		angle.setText("0");
		add(angle);
		add(fireCannon);
		add(new JLabel("Initial Velocity:"));
		initialVelocity.setText("30");
		add(initialVelocity);
		add(createCannon);
		add(new JLabel("Game Status: "));
		add(gameStatusField);
		add(endGameButton);

		// change settings for panels
		gameStatusField.setEditable(false);
		setVisible(true);	
	}

	public void setTargetCondition(boolean b)
	{
		canSetTarget = b;
	}

	public static void setTargetsHit(){
		numTargets++;
		targetsHit.setText("" + numTargets + " / "+ NUM_TARGETS);
	}
	public static void setScore(int points){
		realScore += points;
		score.setText("" + realScore);
	}
	
	public void endGameClicked(){
		board.clearTrajectory();
		JOptionPane.showMessageDialog(null, "You completed " + numTargets + " of the " + NUM_TARGETS + " targets \nwith a score of " + realScore + ". Good Job!", "Victory!",JOptionPane.INFORMATION_MESSAGE);
		game.dispose();
	}
	
	public void drawCannonClicked(){
		gameStatusField.setText("cannon click");
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
	
	public void fireCannonClicked(){
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
		shots.setText(""+ game.getShotsTaken());
		gameStatusField.setText("Fire");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {


		if(e.getSource().equals(endGameButton)){
			endGameClicked();
			
		}
		
		if(e.getSource().equals(createCannon)) {
			drawCannonClicked();
			
		}

		if(e.getSource().equals(fireCannon))
		{	
			drawCannonClicked();
			fireCannonClicked();
			
				
		}
	}

	public void finishQuiz() {
		setScore(10);
		gameStatusField.setText("Quiz Correct! +10 points");
		
		
	}
}
