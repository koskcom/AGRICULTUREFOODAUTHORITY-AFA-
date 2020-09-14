package co.ke.bsl.data.view;

public class CoffeeMillerLicenceStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCoffeeMillerLicence_id() {
        return coffeeMillerLicence_id;
    }

    public void setCoffeeMillerLicence_id(String coffeeMillerLicence_id) {
        this.coffeeMillerLicence_id = coffeeMillerLicence_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public CoffeeMillerLicenceStatus(boolean state, String coffeeMillerLicence_id, String remote_id) {
        this.state = state;
        this.coffeeMillerLicence_id = coffeeMillerLicence_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String coffeeMillerLicence_id;
    private String remote_id;
}
