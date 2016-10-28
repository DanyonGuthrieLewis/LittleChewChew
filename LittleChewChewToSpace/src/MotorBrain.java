

import lejos.nxt.Motor;

public class MotorBrain {
	private final int SPEED = 720;
	private final int SLEEP_TIME = 2000;
	
	public void run(){
		setSpeed(SPEED);
		moveForward();
		sleep(SLEEP_TIME);
		stop();
		moveBackward();
		sleep(SLEEP_TIME);
		stop();
		
	}
	private void setSpeed(int speed){
		Motor.A.setSpeed(speed);
	}
	private void moveForward(){
		Motor.A.forward();
	}
	private void moveBackward(){
		Motor.A.backward();
	}
	private void stop(){
		Motor.A.stop();
	}
	private void sleep(int sleepTime){
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

