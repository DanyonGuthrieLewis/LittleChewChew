package robot;

public class Event {
	protected RobotEventHandler handler;
	protected boolean changed = false;
	public RobotEventHandler getHandler(){
		return handler;
	}
	public boolean changed(){
		return changed;
	}
}
