package robot;

public class EventTimer extends Event {
	public EventTimer(RobotEventHandler tag,  boolean changed){
		this.handler = tag;
		this.changed = changed;
	}
}
