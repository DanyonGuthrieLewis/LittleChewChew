
public abstract class ObserverState extends State implements IObserver{
	@Override
	public abstract void OnNotify(Event event);

}
