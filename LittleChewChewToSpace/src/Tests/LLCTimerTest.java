package Tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class LLCTimerTest implements Runnable {
    
	private long currentTimeInMilliseconds = 0;
	private boolean running = true;
	private Thread timerThread;
	
	//Assert ALL boolean coverage
	//Assert ALL boundary coverage
	@Test
	public void testRun() {
		Assert.assertNotEquals(100,currentTimeInMilliseconds);
		
		
		Assert.assertTrue(running);
		timerThread = new Thread();
		while(running) {
			
			trySleep(1);
			
			timerThread.start();
			Assert.assertFalse(timerThread.isInterrupted());
			timerThread.interrupted();
			Assert.assertTrue(timerThread.isInterrupted());
			
			Assert.assertEquals(0, currentTimeInMilliseconds);
			++currentTimeInMilliseconds;
			Assert.assertEquals(1, currentTimeInMilliseconds);
			
			running = false;
		}
		Assert.assertFalse(running);
	}
	
	
	
	@Test 
	public void testSleep() {
		Thread t = new Thread() {
			public void run() {
				trySleep(1000);
			}
		};
		Assert.assertFalse(t.isInterrupted());
		t.interrupt();
		Assert.assertFalse(t.isInterrupted());
		
	}
	private void trySleep(long ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.out.println("Thread exception: " + e);
		}
	}

	@Test
	public void testStartTimer() {
		  Assert.assertEquals(0 ,currentTimeInMilliseconds);
		  currentTimeInMilliseconds = 100;
		  Assert.assertEquals(100, currentTimeInMilliseconds);
		  
		  Assert.assertNull(timerThread);
		  timerThread = new Thread(this,"Timer");
		  Assert.assertNotNull("timerThread was not initalized", timerThread);
		  currentTimeInMilliseconds = 0;
		  timerThread.start();
		   
		  
		  try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		  Assert.assertNotEquals(100, currentTimeInMilliseconds);
		  Assert.assertNotEquals(1500, currentTimeInMilliseconds);
		  
		  Assert.assertEquals(0, currentTimeInMilliseconds);
	}

	@Test
	public void testStopTimer() {
		Assert.assertTrue(running);
		running = false;
		Assert.assertFalse(running);
	}

	@Test
	public void testGetTime() {
		testStartTimer();
		Assert.assertNotNull(currentTimeInMilliseconds);
	}

	@Override
	public void run() {
		
	}
	
	

}
