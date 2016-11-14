package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Result;

import robot.Event;
import robot.IObserver;
import robot.Observable;

public class ObservableTests {

	public class TestObservable extends Observable{

		int incrementor = 0;
		int toChangeOn = 5;
		@Override
		public Event HasChanged() {
			incrementor++;
			return new TestEvent(incrementor == toChangeOn);
		}
	}
	public class TestObserver implements IObserver{

		public boolean notified = false;
		private boolean active = true;
		@Override
		public void OnNotify(Event event) {
			TestEvent test = (TestEvent) event;
			if (test.changed()) 
			{
				
				synchronized (this) {
					notified = true;
				}
			}
		}

		@Override
		public boolean IsActive() {
			return active;
		}
		public void deactivate() {
			active = false;
		}
	}
	
	public class TestEvent extends Event{
		public TestEvent(boolean changed) {
			this.Tag = "test";
			this.changed = changed;
		}
	}
	

	
	@Test
	public void testOnNotify() {
		TestObservable observeable = new TestObservable();
		TestObserver observer = new TestObserver();
		
		observeable.StartObserving();
		observeable.addObserver(observer);
		
		for (int someTime = 1000; someTime > 0; --someTime){
			System.out.println("");
		}
		
		Assert.assertTrue(observer.notified);
	}
	@Test
	public void testOnNotifyWhileDeactivated() {
		TestObservable observeable = new TestObservable();
		TestObserver observer = new TestObserver();
		
		observeable.StartObserving();
		observeable.addObserver(observer);
		
		synchronized (observer) {
			observer.deactivate();
		}
		for (int someTime = 1000; someTime > 0; --someTime){
			System.out.println("");
		}
		
		Assert.assertFalse(observer.notified);
	}
}
