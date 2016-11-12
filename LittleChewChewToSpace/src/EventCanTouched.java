
public class EventCanTouched extends Event{
	private boolean isTouchingCan;
	public EventCanTouched(boolean changed, boolean touchingCan){
		Tag = "TouchedCan";
		this.changed = changed;
		isTouchingCan = touchingCan;
	}
	public boolean getIsTouchingCan(){
		return isTouchingCan;
	}
}
