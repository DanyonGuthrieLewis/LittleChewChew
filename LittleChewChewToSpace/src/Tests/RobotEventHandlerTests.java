package Tests;

import org.junit.Assert;
import org.junit.Test;

import robot.EventBoundary;
import robot.EventButtonPress;
import robot.EventCanInFront;
import robot.EventCanTouched;
import robot.EventTimer;
import robot.RobotEventHandler;
import robot.Action;

public class RobotEventHandlerTests {

	private static final boolean ASSUME_CHANGE = true;
	
	//----- Boundary -----//
		//Backwards
	@Test
	public void testBackwardsBoundary() {
		boolean onBoundary = false;
		boolean outofBoundary = true;
		Action currentState = Action.FORWARD;
		EventBoundary boundaryEvent = new EventBoundary(ASSUME_CHANGE, onBoundary, outofBoundary);
		
		Action expected = Action.BACKWARD;
		Action actual = boundaryEvent.getHandler().handleEvent(boundaryEvent, currentState);
		
		Assert.assertEquals(expected, actual);
	}
		//No Change
	@Test
	public void testNoChangeBoundary() {
		boolean onBoundary = false;
		boolean outofBoundary = true;
		Action currentState = Action.TURN_RIGHT;
		EventBoundary boundaryEvent = new EventBoundary(ASSUME_CHANGE, onBoundary, outofBoundary);
		
		Action expected = Action.NO_CHANGE;
		Action actual = boundaryEvent.getHandler().handleEvent(boundaryEvent, currentState);
		
		Assert.assertEquals(expected, actual);
	}
	
	//----- Button Press -----//
		//Exit
	@Test
	public void testExitButtonPress() {
		Action currentState = Action.FORWARD;
		EventButtonPress buttonPressEvent = new EventButtonPress(ASSUME_CHANGE);
		
		Action expected = Action.EXIT;
		Action actual = buttonPressEvent.getHandler().handleEvent(buttonPressEvent, currentState);
		
		Assert.assertEquals(expected, actual);
	}
	//----- Can In Front -----//
		//Turn Right
	private static final int CAN_IN_FRONT_DISTANCE = 80;
	
	@Test
	public void testTurnRightCanInFront() {
		boolean canInFront = true;
		int distance = CAN_IN_FRONT_DISTANCE;
		Action currentState = Action.TURN_RIGHT;
		EventCanInFront canInFrontEvent = new EventCanInFront(ASSUME_CHANGE, canInFront, distance);
		
		Action expected = Action.FORWARD;
		Action actual = canInFrontEvent.getHandler().handleEvent(canInFrontEvent, currentState);
		
		Assert.assertEquals(expected, actual);
	}
		//No Change
	private static final int CAN_NOT_IN_FRONT_DISTANCE = 255;
	@Test
	public void testNoChangeCanInFront() {
		boolean canInFront = true;
		int distance = CAN_NOT_IN_FRONT_DISTANCE;
		Action currentState = Action.BACKWARD;
		EventCanInFront canInFrontEvent = new EventCanInFront(ASSUME_CHANGE, canInFront, distance);
		
		Action expected = Action.NO_CHANGE;
		Action actual = canInFrontEvent.getHandler().handleEvent(canInFrontEvent, currentState);
		
		Assert.assertEquals(expected, actual);
	}
	//----- Can Touched -----//
		//Touching Can
	@Test
	public void testTouchingCanCanTouched() {
		boolean touchingCan = true;
		Action currentState = Action.FORWARD;
		EventCanTouched canTouchedEvent = new EventCanTouched(ASSUME_CHANGE, touchingCan);
		
		Action expected = Action.TOUCHING_CAN;
		Action actual = canTouchedEvent.getHandler().handleEvent(canTouchedEvent, currentState);
		
		Assert.assertEquals(expected, actual);
	}
		//Not Touching Can
	@Test
	public void testNotTouchingCanCanTouched() {
		boolean touchingCan = false;
		Action currentState = Action.FORWARD;
		EventCanTouched canTouchedEvent = new EventCanTouched(ASSUME_CHANGE, touchingCan);
		
		Action expected = Action.NOT_TOUCHING_CAN;
		Action actual = canTouchedEvent.getHandler().handleEvent(canTouchedEvent, currentState);
		
		Assert.assertEquals(expected, actual);
	}
	//----- Buffer Timer -----//
		//Turn Right
	@Test
	public void testTurnRightBufferTimer() {
		Action currentState = Action.BACKWARD;
		EventTimer timerEvent = new EventTimer(RobotEventHandler.BUFFER_TIMER_EVENT, ASSUME_CHANGE);
		
		Action expected = Action.TURN_RIGHT;
		Action actual = timerEvent.getHandler().handleEvent(timerEvent, currentState);
		
		Assert.assertEquals(expected, actual);
	}
		//No Change
	@Test
	public void testNoChangeBufferTimer() {
		Action currentState = Action.FORWARD;
		EventTimer timerEvent = new EventTimer(RobotEventHandler.BUFFER_TIMER_EVENT, ASSUME_CHANGE);
		
		Action expected = Action.NO_CHANGE;
		Action actual = timerEvent.getHandler().handleEvent(timerEvent, currentState);
		
		Assert.assertEquals(expected, actual);
	}
	//----- Finished Timer -----//
		//Finished
	@Test
	public void testFinishedTimer() {
		Action currentState = Action.BACKWARD;
		EventTimer timerEvent = new EventTimer(RobotEventHandler.FINISH_TIMER_EVENT, ASSUME_CHANGE);
		
		Action expected = Action.FINISHED;
		Action actual = timerEvent.getHandler().handleEvent(timerEvent, currentState);
		
		Assert.assertEquals(expected, actual);
	}

}
