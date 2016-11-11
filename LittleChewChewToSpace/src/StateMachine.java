

import java.util.ArrayList;
import java.util.Iterator;

public class StateMachine {
    private ArrayList<State> states;

    public StateMachine(){
        states = new ArrayList<>();
    }

    public void addState(State state){
    	state.AddToMachine(this);
        state.OnStateEnter();
        states.add(state);
    }

    public boolean removeState(State state){
        state.OnStateExit();
        return states.remove(state);
    }
    public boolean removeState(String tag){
        for(State state : states){
        	if(state.getTag().equals(tag)) return removeState(state);
        }
        return false;
    }
    public void switchStates(State newState, State oldState){  
        removeState(oldState);
        addState(newState);
    }
    public void update(float dt){
    	Iterator<State> iter = states.iterator();
    	while (iter.hasNext()){
    		State current = iter.next();
    		if(current.isActive()) current.OnStateUpdate(dt);
    	}
    }
    public boolean hasState(State state){
    	return states.contains(state);
    }
    public boolean hasStates(){
    	return (states.size() > 0);
    }
}