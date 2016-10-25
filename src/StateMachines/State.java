package StateMachines;

/**
 * Created by Greymoon on 10/23/2016.
 */
public abstract class State {
    private boolean active;
    protected String tag = "UN-NAMED";
    public abstract void OnStateEnter();
    public abstract void OnStateUpdate(float dt);
    public abstract void OnStateExit();

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
