package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import Final.*;


public class PartITests {
	
	private static GameRunner runner;
	
	@BeforeClass
	public static void setUp(){
		runner = new GameRunner();
		runner.createCannon();
		runner.createTarget(30);
	}
	
	
	//Tests to make sure the input read in from prompt is returned properly
	@Test
	public void testInputs(){
		runner.setAngle(45);
		System.out.println(runner.getAngle());
		Assert.assertTrue(runner.getAngle()-45.0 < 0.000001);
		
		runner.setAngle(35);
		System.out.println(runner.getAngle());
		Assert.assertTrue(runner.getAngle()-35.0 < 0.000001);
		
		runner.setInitialVelocity(100);
		System.out.println(runner.getInitialVelocity());
		Assert.assertTrue(runner.getInitialVelocity()-100.0 < 0.000001);
	}
	
	//Tests to ensure the distance is calculated properly from the given inputs
	@Test
	public void testCalcInputs(){
		runner.setAngle(45);
		runner.setInitialVelocity(10);
		System.out.println(10.20408-runner.getDistance());
		Assert.assertTrue(Math.abs(10.20408 - runner.getDistance()) < 0.00001);
		
		runner.setAngle(45);
		runner.setInitialVelocity(20);
		System.out.println(40.81632-runner.getDistance());
		Assert.assertTrue(Math.abs(40.81632 - runner.getDistance()) < 0.00001);

		runner.setAngle(35);
		runner.setInitialVelocity(10);
		System.out.println(9.5887-runner.getDistance());
		Assert.assertTrue(Math.abs(9.58870 - runner.getDistance()) < 0.00001);
		
		runner.setAngle(35);
		runner.setInitialVelocity(20);
		System.out.println(38.354801-runner.getDistance());
		Assert.assertTrue(Math.abs(38.354801 - runner.getDistance()) < 0.00001);	
		
	}
	
	
	//Tests the calculation of the distance the projectile landed from the target 
	@Test
	public void testCalcDistance(){
		double distanceFromTarget;
		
		runner.setAngle(45);
		runner.setInitialVelocity(10);
		distanceFromTarget = Math.abs(runner.getDistance() - 30);
		Assert.assertTrue(Math.abs(distanceFromTarget - 19.80624) < 0.00001);
		
		runner.setAngle(45);
		runner.setInitialVelocity(20);
		distanceFromTarget = Math.abs(runner.getDistance() - 30);
		Assert.assertTrue(Math.abs(distanceFromTarget - 10.7747) < 0.00001);

		runner.setAngle(35);
		runner.setInitialVelocity(10);
		distanceFromTarget = Math.abs(runner.getDistance() - 30);
		Assert.assertTrue(Math.abs(distanceFromTarget - 20.4511) < 0.00001);
		
		runner.setAngle(35);
		runner.setInitialVelocity(20);
		distanceFromTarget = Math.abs(runner.getDistance() - 30);
		Assert.assertTrue(Math.abs(distanceFromTarget - 5.3157) < 0.00001);
		
	}
	
	//Tests whether the projectile hit the target or not
	@Test
	public void testSuccess(){
		
		runner.setAngle(45);
		runner.setInitialVelocity(17.146);
		Assert.assertTrue(runner.targetReached());
		
		
		runner.setAngle(30);
		runner.setInitialVelocity(10.6377);
		Assert.assertTrue(runner.targetReached());
		
		
		runner.setAngle(45);
		runner.setInitialVelocity(8.731);
		Assert.assertFalse(runner.targetReached());
		
	}
}
