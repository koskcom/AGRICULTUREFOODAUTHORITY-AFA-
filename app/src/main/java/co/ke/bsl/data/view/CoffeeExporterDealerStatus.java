package co.ke.bsl.data.view;

public class CoffeeExporterDealerStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCoffeeExporterDealer_id() {
        return coffeeExporterDealer_id;
    }

    public void setCoffeeExporterDealer_id(String coffeeExporterDealer_id) {
        this.coffeeExporterDealer_id = coffeeExporterDealer_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public CoffeeExporterDealerStatus(boolean state, String coffeeExporterDealer_id, String remote_id) {
        this.state = state;
        this.coffeeExporterDealer_id = coffeeExporterDealer_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String coffeeExporterDealer_id;
    private String remote_id;
}
