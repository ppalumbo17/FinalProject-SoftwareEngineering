package Final;

import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
public class GameRunner extends JFrame {

	private static final double GRAVITY = 9.8;
	private double angle, velocity, distance;
	private Board board;
	private Control control;
	private Cannon cannon;
	private Target target;
	private ArrayList<Target> targetList;
	private TargetGenerator generator;
	private static final int WINDOW_WIDTH = 900; 
	private static final int WINDOW_HEIGHT = 640;
	private static final int TARGET_COUNT = 5;
	private int targetCount;
	
	public GameRunner()
	{
		generator = new TargetGenerator(WINDOW_WIDTH / 2, 0, WINDOW_WIDTH / 2, WINDOW_HEIGHT);
		cannon = new Cannon();
		targetList = generateTargets(TARGET_COUNT);
		targetCount = 0;
		board = new Board(cannon, targetList.get(targetCount)); 
		control = new Control(this);
		prepareJFrame();
	}
	
	public static void main(String[] args){
		GameRunner runner = new GameRunner();
		runner.createTarget(100, 0);
		runner.setVisible(true);
		
		
		
		//runner.setAngle(15);
		
//		Scanner sc = new Scanner(System.in);
		
//		System.out.println("The target is placed at (100,0) and the cannon at (0,0)\nEnter a starting velocity:");
//		double vel = sc.nextDouble();
		
//		System.out.println("Please enter a starting angle for the cannon:");
//		double ang = sc.nextDouble();
		
//		runner.setAngle(ang);
//		runner.setInitialVelocity(vel);
//		runner.createCannon(0, 500, ang, vel);
		
//		System.out.println("The ball landed on the ground at coord (" + (double)Math.round(runner.getXDistance()*1000)/1000 + ",0)");
	}
	
	
	private void prepareJFrame()
	{
		// general
		setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setTitle("Cannon Firing Game for Victory");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		// menu 
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menu.add(createFileExitItem());
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		// add panels
		add(board, BorderLayout.CENTER);
		add(control, BorderLayout.SOUTH);
		
	}
	
//	void calcTrajectory(){
//		
//	}
	
	private JMenuItem createFileExitItem() {
		JMenuItem exitItem = new JMenuItem("Exit");

		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}

		exitItem.addActionListener(new MenuItemListener());
		return exitItem;
	}	

	public void createCannon(int xcoor, int ycoor, double angle, double velocity) {
		cannon = new Cannon(xcoor, ycoor, angle, velocity);
	}

	public void createTarget(int xcoor, int ycoor) {
		target = new Target(xcoor, ycoor);
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double i) {
		angle = i;
		cannon.setAngle(360-angle);
		board.changeCannon(cannon);
		board.repaint();
	}

	public void setInitialVelocity(double i) {
		velocity = i;
		
	}

	public double getInitialVelocity() {
		return velocity;
	}

	public double getXDistance() {
		return (Math.pow(velocity, 2.0)*Math.sin(2*angle*Math.PI/180))/GRAVITY;
	}
	
	public double distanceFromTarget(double target){
		return Math.abs(getXDistance()-target);
	}

	public boolean targetReached(Target target) {
		
		return (Math.abs(getXDistance()-target.getxCoor()) < 0.01);
		
	}
	
	public ArrayList<Target> generateTargets(int amount){
		ArrayList<Target> tempList = new ArrayList<Target>();
		
		for (int i = 0; i < amount; i++)
		{
			tempList.add(generator.createTarget());
		}
		
		return tempList;
	}

	public void setNextTarget() {
		targetCount++;
		board.changeTarget(targetList.get(targetCount));
		board.repaint();
	}
}
