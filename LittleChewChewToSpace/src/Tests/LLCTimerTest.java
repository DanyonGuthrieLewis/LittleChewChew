package Tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class LLCTimerTest implements Runnable {
    
	private long currentTimeInMilliseconds = 200;
	private boolean running = true;
	private Thread timerThread;
	
	@Test
	public void testRun() {
		
	}

	@Test
	public void testStartTimer() {
		  currentTimeInMilliseconds = 0;
		  Assert.assertEquals(0, currentTimeInMilliseconds);
		  timerThread = new Thread(this,"Timer");
		  Assert.assertNotNull("timerThread was not initalized", timerThread);
	}

	@Test
	public void testStopTimer() {
		running = false;
		Assert.assertFalse(running);
		Assert.assertFalse("Boolean variable 'running' was not set to false", running);
	}

	@Test
	public void testGetTime() {
		Assert.assertNotNull(currentTimeInMilliseconds);
	}

	@Override
	public void run() {
		
	}

}
