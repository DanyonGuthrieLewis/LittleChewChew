import java.util.ArrayList;

public abstract class Observable implements Runnable{
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
	public void run(){
		Observe();
	}
	public void Observe(){
		while (isObserving){
			if (HasChanged()){
				NotifyObservers();
			}
		}
	}
	public void NotifyObservers(){
		for (IObserver observer : observers) {
			observer.notify();
		}
	}
	public abstract boolean HasChanged();
}
