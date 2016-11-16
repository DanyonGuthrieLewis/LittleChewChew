package robot;

public interface IEventHandler {
	Action handleEvent(Event event, Action currentState);
}
