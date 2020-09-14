package co.ke.bsl.data.view;

public class FruitsAndVegetablesExportersStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getFruitsAndVegetablesExporters_id() {
        return fruitsAndVegetablesExporters_id;
    }

    public void setFruitsAndVegetablesExporters_id(String fruitsAndVegetablesExporters_id) {
        this.fruitsAndVegetablesExporters_id = fruitsAndVegetablesExporters_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public FruitsAndVegetablesExportersStatus(boolean state, String fruitsAndVegetablesExporters_id, String remote_id) {
        this.state = state;
        this.fruitsAndVegetablesExporters_id = fruitsAndVegetablesExporters_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String fruitsAndVegetablesExporters_id;
    private String remote_id;
}
