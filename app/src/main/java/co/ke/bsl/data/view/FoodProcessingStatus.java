package co.ke.bsl.data.view;

public class FoodProcessingStatus {
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getFoodprocessing_id() {
        return foodprocessing_id;
    }

    public void setFoodprocessing_id(String foodprocessing_id) {
        this.foodprocessing_id = foodprocessing_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public FoodProcessingStatus(boolean state, String foodprocessing_id, String remote_id) {
        this.state = state;
        this.foodprocessing_id = foodprocessing_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String foodprocessing_id;
    private String remote_id;
}
