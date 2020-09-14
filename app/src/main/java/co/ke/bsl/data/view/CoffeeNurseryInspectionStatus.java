package co.ke.bsl.data.view;

public class CoffeeNurseryInspectionStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCoffeeNurseryInspection_id() {
        return coffeeNurseryInspection_id;
    }

    public void setCoffeeNurseryInspection_id(String coffeeNurseryInspection_id) {
        this.coffeeNurseryInspection_id = coffeeNurseryInspection_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public CoffeeNurseryInspectionStatus(boolean state, String coffeeNurseryInspection_id, String remote_id) {
        this.state = state;
        this.coffeeNurseryInspection_id = coffeeNurseryInspection_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String coffeeNurseryInspection_id;
    private String remote_id;
}
