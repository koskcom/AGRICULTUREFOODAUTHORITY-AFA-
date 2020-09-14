package co.ke.bsl.data.view;

public class CoffeeManagementAgentStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCoffeeManagementAgent_id() {
        return coffeeManagementAgent_id;
    }

    public void setCoffeeManagementAgent_id(String coffeeManagementAgent_id) {
        this.coffeeManagementAgent_id = coffeeManagementAgent_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public CoffeeManagementAgentStatus(boolean state, String coffeeManagementAgent_id, String remote_id) {
        this.state = state;
        this.coffeeManagementAgent_id = coffeeManagementAgent_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String coffeeManagementAgent_id;
    private String remote_id;
}
