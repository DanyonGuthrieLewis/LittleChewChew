package robot;

public enum RobotEventHandler implements IEventHandler{
	BOUNDARY_EVENT{
		@Override
		public Action handleEvent(Event event, Action currentState) {
			Action nextState = Action.NO_CHANGE;
			EventBoundary boundaryEvent = (EventBoundary) event;
			nextState = 
					(currentState == Action.FORWARD && boundaryEvent.getIsOutOfBoundary()) 
						? Action.BACKWARD : Action.NO_CHANGE;
			return nextState;
		}
	},
	EXIT_EVENT{
		@Override
		public Action handleEvent(Event event, Action currentState) {
			return Action.EXIT;
		}
	},
	CAN_IN_FRONT_EVENT
	{
		@Override
		public Action handleEvent(Event event, Action currentState) {
			Action nextState = Action.NO_CHANGE;
			EventCanInFront canInFrontEvent = (EventCanInFront) event;
			nextState = 
					(currentState == Action.TURN_RIGHT && canInFrontEvent.getIsCanInFront())
						? Action.FORWARD : Action.NO_CHANGE;
			return nextState;
		}
	},
	CAN_TOUCHED{
		@Override
		public Action handleEvent(Event event, Action currentState) {
			Action nextState = Action.NO_CHANGE;
			EventCanTouched canTouchedEvent = (EventCanTouched) event;
			nextState = 
						(canTouchedEvent.getIsTouchingCan())
							? Action.TOUCHING_CAN : Action.NOT_TOUCHING_CAN;
			return nextState;
		}
	},
	BUFFER_TIMER_EVENT{
		@Override
		public Action handleEvent(Event event, Action currentState) {		
			return (currentState == Action.BACKWARD) ? Action.TURN_RIGHT : Action.NO_CHANGE;
		}
	},
	FINISH_TIMER_EVENT{
		@Override
		public Action handleEvent(Event event, Action currentState) {
			return Action.FINISHED;
		}
	};


}
