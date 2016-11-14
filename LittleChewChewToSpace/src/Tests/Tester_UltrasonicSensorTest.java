package Tests;
import static org.junit.Assert.*;

import org.junit.Test;

//import LeJOS_UltrasonicSensor;
import lejos.nxt.SensorPort;
import robot.LeJOS_UltrasonicSensor;

public class Tester_UltrasonicSensorTest{
	private static final int MAX_DISTANCE = 170;
	private static final int MIN_DISTANCE = 0;
	private static final int NONE_FOUND = 255;
	private static final int IN_DISTANCE = 25;
	private static final int OUT_DISTANCE = 60;
	@Test
	public void test() {
		
		Tester_UltrasonicSensor testingSensor = new Tester_UltrasonicSensor(SensorPort.S1);
		LeJOS_UltrasonicSensor sensorClass = new LeJOS_UltrasonicSensor(testingSensor);
		
		testingSensor.setDistance(MAX_DISTANCE);
		assertEquals(false, sensorClass.isCanInFront());
		assertEquals(false, sensorClass.hasChanged().changed());
		
		testingSensor.setDistance(MIN_DISTANCE);
		assertEquals(true, sensorClass.isCanInFront());
		assertEquals(true, sensorClass.hasChanged().changed());
		
		testingSensor.setDistance(NONE_FOUND);
		assertEquals(false, sensorClass.isCanInFront());
		assertEquals(true, sensorClass.hasChanged().changed());
		
		testingSensor.setDistance(IN_DISTANCE);
		assertEquals(true, sensorClass.isCanInFront());
		assertEquals(true, sensorClass.hasChanged().changed());
		
		testingSensor.setDistance(OUT_DISTANCE);
		assertEquals(true, sensorClass.isCanInFront());
		assertEquals(false, sensorClass.hasChanged().changed());
		
	}

}