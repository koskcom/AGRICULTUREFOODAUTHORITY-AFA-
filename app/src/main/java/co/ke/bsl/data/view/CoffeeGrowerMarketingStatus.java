package co.ke.bsl.data.view;

public class CoffeeGrowerMarketingStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCoffeeGrowerMarketing_id() {
        return coffeeGrowerMarketing_id;
    }

    public void setCoffeeGrowerMarketing_id(String coffeeGrowerMarketing_id) {
        this.coffeeGrowerMarketing_id = coffeeGrowerMarketing_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public CoffeeGrowerMarketingStatus(boolean state, String coffeeGrowerMarketing_id, String remote_id) {
        this.state = state;
        this.coffeeGrowerMarketing_id = coffeeGrowerMarketing_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String coffeeGrowerMarketing_id;
    private String remote_id;
}
