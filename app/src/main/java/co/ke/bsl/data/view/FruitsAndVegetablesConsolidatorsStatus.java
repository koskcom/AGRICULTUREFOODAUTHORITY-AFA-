package co.ke.bsl.data.view;

public class FruitsAndVegetablesConsolidatorsStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getFruitsAndVegetablesConsolidators_id() {
        return fruitsAndVegetablesConsolidators_id;
    }

    public void setFruitsAndVegetablesConsolidators_id(String fruitsAndVegetablesConsolidators_id) {
        this.fruitsAndVegetablesConsolidators_id = fruitsAndVegetablesConsolidators_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public FruitsAndVegetablesConsolidatorsStatus(boolean state, String fruitsAndVegetablesConsolidators_id, String remote_id) {
        this.state = state;
        this.fruitsAndVegetablesConsolidators_id = fruitsAndVegetablesConsolidators_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String fruitsAndVegetablesConsolidators_id;
    private String remote_id;
}
