package robot;

public class EventButtonPress extends Event{

	public EventButtonPress(boolean changed){
		handler = RobotEventHandler.EXIT_EVENT;
		this.changed = changed;
	}
}
