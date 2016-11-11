import java.util.ArrayList;
import java.util.Iterator;

public abstract class Observable implements Runnable{
	Thread observerThread;
	private ArrayList<IObserver> observers;
	private boolean isObserving = true;
	public Observable(){
		observers = new ArrayList<>();
	}
	public void addObserver(IObserver observer){
		observers.add(observer);
	}
	public void removeObserver(IObserver observer){
		observers.remove(observer);
	}
	public void StartObserving(){
		observerThread = new Thread(this);
		observerThread.start();
	}
	@Override
	public void run(){
		Observe();
	}
	public void Observe(){
		while (isObserving){
			Event event = HasChanged();
			if (event.changed){
				NotifyObservers(event);
			}
		}
	}
	public void NotifyObservers(Event event){
		Iterator<IObserver> iter = observers.iterator();
		while (iter.hasNext()) {
			IObserver next = iter.next();
			synchronized (next) {
				next.OnNotify(event);
			}

		}
	}
	public abstract Event HasChanged();
}
