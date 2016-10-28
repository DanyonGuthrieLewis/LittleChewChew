

public class State {
    private boolean active = true;
    protected String tag = "UN-NAMED";
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
}
