package Final;

import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
public class GameRunner extends JFrame {


	private double angle, initialVelocity, distance;
	private double totalTime;
	private int timerCount, shotsTaken;
	private Board board;
	private Control control;
	private Cannon cannon;
	private Projectile projectile;
	private Target target;
	private ArrayList<Target> targetList;
	private TargetGenerator generator;
	private Timer timer;
	
	public static int cannonCount;
	private static final double GRAVITY = 9.8;
	private static final int WINDOW_WIDTH = 900; 
	private static final int WINDOW_HEIGHT = 670;
	private static final int TARGET_COUNT = 5;
	private int targetCount;

	public GameRunner()
	{
		generator = new TargetGenerator(WINDOW_WIDTH / 2, Target.TARGET_SIZE, WINDOW_WIDTH / 2 - Target.TARGET_SIZE, WINDOW_HEIGHT / 2 - Target.TARGET_SIZE);
		cannon = new Cannon();
		targetList = generateTargets(TARGET_COUNT);
		targetCount = 0;
		target =  targetList.get(targetCount);
		board = new Board(cannon, target); 
		control = new Control(this, board);
		timer = new Timer(10, new TimerListener());
		
		prepareJFrame();
	}

	public static void main(String[] args){
		GameRunner runner = new GameRunner();
		// runner.createTarget(100, 0);
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
		initialVelocity = i;
	}

	public double getInitialVelocity() {
		return initialVelocity;
	}

	public double getDistance() {
		return (Math.pow(initialVelocity, 2.0)*Math.sin(2*angle*Math.PI/180))/GRAVITY;
	}
	public int getShotsTaken(){
		return shotsTaken;
	}

	//NEEDS WORK
	public double distanceFromTarget(){
		/*System.out.println("X: " + target.getxCoor());
		System.out.println("Y: " + target.getyCoor());
		System.out.println("XP: " + projectile.getXCoor(initialVelocity/GRAVITY));
		System.out.println("YP: " + projectile.getYCoor(initialVelocity/GRAVITY));
		return (Math.abs(Math.sqrt((Math.pow(projectile.getXCoor(initialVelocity/GRAVITY)-target.getxCoor(), 2)+Math.pow(projectile.getYCoor(initialVelocity/GRAVITY) - target.getyCoor(), 2)))))/10;*/
		return 0;
	}

	public boolean targetReached(Target target) {

		return (Math.abs(getDistance() - target.getxCoor()) < 0.01);

	}

	public ArrayList<Target> generateTargets(int amount){
		ArrayList<Target> tempList = new ArrayList<Target>();

		for (int i = 0; i < amount; i++)
		{
			tempList.add(generator.createTarget());
		}

		return tempList;
	}

	//NEEDS WORK
	public void setNextTarget()  {
		targetCount++;
		if (targetCount != TARGET_COUNT){
			target=targetList.get(targetCount);
			board.changeTarget(target);
			board.repaint();
		}
		else{
			displayEndResult();
		}
	}

	void fireProjectile(){
		
		if(cannonCount < 3){
			cannonCount++;
			board.clearTrajectory();
			
		}
		else{
			JOptionPane.showMessageDialog(null, "You've fired your alotted number of shots for this target", "New Target Incoming", JOptionPane.PLAIN_MESSAGE);
			board.clearTrajectory();
			setNextTarget();
			cannonCount = 0;
			return;
		}
		calcTotalTime();
		//board.repaint();
		projectile = new Projectile(cannon.getTipX(), cannon.getTipY(), angle, initialVelocity);
		
		board.createProjectile(projectile);
		board.repaint();
		// if (timer != null) timer.stop();
		// timer = new Timer(10, new TimerListener());
		timerCount = 0;
		timer.start();
		shotsTaken++;
		
	}
	
	public Cannon getCannon() {
		return cannon;
	}

	private void calcTotalTime() {
		totalTime = 2 * initialVelocity * Math.sin(Math.toRadians(angle)) / GRAVITY;
	}

	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			timerCount++;
			
			// this is probably the only place you need a repaint
			repaint(); 
			// calls a helper to do most of the logic
			shootHelper();
		}
	}
	public void displayEndResult(){
		JOptionPane.showMessageDialog(null, "You completed " + Control.numTargets + " of the " + TARGET_COUNT + " targets \nwith a score of " + Control.realScore + " Good Job!", "Victory!",JOptionPane.INFORMATION_MESSAGE);
		dispose();
	}
	private void shootHelper() {
		double currentTime = timerCount * 0.01;
		projectile.getXCoor(currentTime);
		projectile.getYCoor(currentTime);
		
		double xcenter=(projectile.getXCoor()*10)+5;
		double ycenter=(projectile.getYCoor()*10)+5;
		if(timerCount % 5 == 0){
			board.drawDot(projectile.getXCoor() * 10,projectile.getYCoor() * 10);
		}
		if(target.contains(xcenter,ycenter)){
			JOptionPane.showMessageDialog(null, "Good Job! You hit the target in just " + (cannonCount) + " tries!", "NEXT TARGET DISPLAYED",JOptionPane.PLAIN_MESSAGE);
			timer.stop();
			board.clearTrajectory();
			Control.setTargetsHit();
			Control.setScore((40 - (10*cannonCount)));
			
			//NEEDS WORK
			if (targetCount < TARGET_COUNT && !(((Math.round(Control.realScore/20)+shotsTaken)/3) >= TARGET_COUNT)){
				setNextTarget();
				cannonCount = 0;
			}
			else{
				displayEndResult();
			}
		}
		if (projectile.getXCoor()*10 > WINDOW_WIDTH || projectile.getYCoor()*10 > WINDOW_HEIGHT) {
			JOptionPane.showMessageDialog(null, "You've gone too far!", "Out Of Bounds", JOptionPane.INFORMATION_MESSAGE);
			timer.stop();
		}
	}
	
}
