package StateMachines;

import java.util.ArrayList;

/**
 * Created by Greymoon on 10/23/2016.
 */
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
        states.stream().forEach(state -> {if (state.getTag().equals(tag)) removeState(state);});
    }
    public void switchStates(State newState, State oldState){
        removeState(oldState);
        addState(newState);
    }
    public void update(){
        states.forEach(state -> {if (state.isActive()) state.OnStateUpdate();});
    }
}
