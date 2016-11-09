import lejos.nxt.Motor;

public class DriveSystem {
	private static final int DEFAULT_SPEED = 720;

	public DriveSystem() {
		Motor.A.setSpeed(DEFAULT_SPEED);
		Motor.B.setSpeed(DEFAULT_SPEED);
	}

	public void moveForward() {
		Motor.A.forward();
		Motor.B.forward();
	}

	public void moveBackward() {
		Motor.A.backward();
		Motor.B.backward();
	}

	public void moveLeft() {
		Motor.A.forward();
		Motor.B.backward();

	}
	
	public void moveRight() {
		Motor.A.backward();
		Motor.B.forward();
	}
}
