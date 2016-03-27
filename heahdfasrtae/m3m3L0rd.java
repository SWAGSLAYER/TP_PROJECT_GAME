package Hue;
import robocode.*;

public class M3m3L0rd extends AdvancedRobot {
  	double previousEnergy = 100;
  	int movementDirection = 1;
  	int gunDirection = 1;
	int turnDirection = 1;
  	boolean movingForward = true;
 	public void run() {
    	setTurnGunRight(99999);
  	}
	public void onHitWall(HitWallEvent e) {
		setTurnRight(60);
		reverseDirection();
	}
	public void onBulletHit(BulletHitEvent e) {
		movementDirection =-movementDirection;
        setAhead(50);
	}
	public void reverseDirection() {
		if (movingForward) {
			setBack(400);
			movingForward = false;
		} else {
			setAhead(400);
			movingForward = true;
		}
	}
	
  	public void onScannedRobot(ScannedRobotEvent e) {
      	setTurnRight(e.getBearing()+90-
        30*movementDirection);
    	double changeInEnergy =
      	previousEnergy-e.getEnergy();
   		if (changeInEnergy>0 &&
        	changeInEnergy<=3) {
         	movementDirection =
          	-movementDirection;
         	setAhead((e.getDistance()/4+25));
     	}
		
		//gunDirection = -gunDirection;
    	//setTurnGunRight(999999*gunDirection);
		if (e.getDistance() < 100){
			fire(10);
		}
		else{
			fire(2);
		}
		if (e.getDistance() > 300){
			if (e.getBearing() >= 0) {
				turnDirection = 1;
			} else {
				turnDirection = -1;
			}

			turnRight(e.getBearing());
			ahead(e.getDistance()-150);
		}
    	previousEnergy = e.getEnergy();
  }
}
