import lejos.nxt.Motor;

public class SystemDrive {
	private static final int MOVE_SPEED = 600;
	private static final int TURN_SPEED = 300;

	public SystemDrive() {
		Motor.A.setSpeed(MOVE_SPEED);
		Motor.B.setSpeed(MOVE_SPEED);
	}
	
	public void SetSpeed(int speed) {
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
	}

	public void moveForward() {
		SetSpeed(MOVE_SPEED);
		Motor.A.forward();
		Motor.B.forward();
	}

	public void moveBackward() {
		SetSpeed(MOVE_SPEED);
		Motor.A.backward();
		Motor.B.backward();
	}

	public void moveLeft() {
		SetSpeed(TURN_SPEED);
		Motor.A.forward();
		Motor.B.backward();

	}
	
	public void moveRight() {
		SetSpeed(TURN_SPEED);
		Motor.A.backward();
		Motor.B.forward();
	}
	public void stop(){
		SetSpeed(0);
		Motor.A.stop();
		Motor.B.stop();
	}
}
