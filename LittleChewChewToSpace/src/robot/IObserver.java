package robot;

public interface IObserver {
	void OnNotify(Event event);
	boolean IsActive();
}
