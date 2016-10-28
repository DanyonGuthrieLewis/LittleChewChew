

import java.util.ArrayList;

public class StateMachine {
    private ArrayList<State> states;

    public StateMachine(){
        states = new ArrayList<>();
    }

    public void addState(State state){
        state.OnStateEnter();
        states.add(state);
    }

    public void removeState(State state){
        state.OnStateExit();
        states.remove(state);
    }
    public void removeState(String tag){
        for(State state : states){
        	if(state.getTag().equals(tag)) removeState(state);
        }
    }
    public void switchStates(State newState, State oldState){
        removeState(oldState);
        addState(newState);
    }
    public void update(float dt){
    	for(State state : states){
    		if(state.isActive()) state.OnStateUpdate(dt);
    	}
    }
    public boolean hasState(State state){
    	return states.contains(state);
    }
}