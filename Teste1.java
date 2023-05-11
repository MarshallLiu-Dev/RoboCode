package teste1;
import robocode.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Teste1 - a robot by (your name here)
 */
public class Teste1 extends Robot
{
		int grau = 0;	
/**
	 * run: Teste1's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		
		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(10);
			if(this.grau<360)
				this.grau = grau +10;
			else
				this.grau=0;
			back(100);
			turnGunRight(10);
			if(this.grau<360)
				this.grau = grau +10;
			else
				this.grau=0;
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(this.grau);
		ahead(100);
		double distance = e.getDistance(); //get the distance of the scanned robot
  		if(distance < 20) //this conditions adjust the fire force according the distance of the scanned robot.
    		fire(5);
  		else if(distance > 20 && distance <= 100)
    		fire(4);
  		else if(distance > 100 && distance <= 200)
    		fire(3);
  		else if(distance > 200 && distance <= 400)
    		fire(2);
  		else if(distance > 400)
    		fire(1);
		}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
}
