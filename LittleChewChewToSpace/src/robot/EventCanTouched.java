package robot;

public class EventCanTouched extends Event{
	private boolean isTouchingCan;
	public EventCanTouched(boolean changed, boolean touchingCan){
		handler = RobotEventHandler.CAN_TOUCHED;
		this.changed = changed;
		isTouchingCan = touchingCan;
	}
	public boolean getIsTouchingCan(){
		return isTouchingCan;
	}
}
