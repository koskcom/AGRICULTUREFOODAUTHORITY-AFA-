package co.ke.bsl.data.view;

public class CoffeeCommercialMarketingStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCoffeeCommercialMarketing_id() {
        return coffeeCommercialMarketing_id;
    }

    public void setCoffeeCommercialMarketing_id(String coffeeCommercialMarketing_id) {
        this.coffeeCommercialMarketing_id = coffeeCommercialMarketing_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public CoffeeCommercialMarketingStatus(boolean state, String coffeeCommercialMarketing_id, String remote_id) {
        this.state = state;
        this.coffeeCommercialMarketing_id = coffeeCommercialMarketing_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String coffeeCommercialMarketing_id;
    private String remote_id;
}
