

public class State {
    private boolean active = true;
    protected String tag = "UN-NAMED";
    protected StateMachine machine;
    
    public void setStateMachine(StateMachine machine){
    	this.machine = machine;
    }
    
    public void OnStateEnter(){}
    public void OnStateUpdate(float dt){}
    public void OnStateExit(){}

    public boolean isActive(){
        return active;
    }
    public void activate(){
        active = true;
    }
    public void deactivate(){
        active = false;
    }
    public String getTag(){
        return tag;
    }
    public void AddToMachine(){
    	machine.addState(this);
    }
    public void AddToMachine(StateMachine machine){
    	this.machine = machine;
    	machine.addState(this);
    }
    public boolean RemoveFromMachine(){
    	return machine.removeState(this);
    }
}
