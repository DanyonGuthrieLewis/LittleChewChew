
public class MoveForwards extends ObserverState{
	private DriveSystem drive;
	private MartianSystem marty;
	private TouchSystem meToucher;
	
	boolean isTouchingCan = false;
	
	public void initialize(DriveSystem drive, MartianSystem martianSystem, TouchSystem touchSystem){
		this.drive = drive;
		this.marty = martianSystem;
		this.meToucher = touchSystem;
	}
	@Override
	public void OnStateUpdate(float dt) {
		drive.moveForward();
		if (isTouchingCan){
			marty.playTouchingSound();
		}
		else marty.playForwardSound();

	}
	@Override
	public void OnNotify(Event event) {
		CanTouchedEvent canTouchedEvent = (CanTouchedEvent) event;
		isTouchingCan = canTouchedEvent.getIsTouchingCan();
	}
}
