package co.ke.bsl.data.view;

public class FoodCropStatus {
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getFood_crop_id() {
        return food_crop_id;
    }

    public void setFood_crop_id(String food_crop_id) {
        this.food_crop_id = food_crop_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public FoodCropStatus(boolean state, String food_crop_id, String remote_id) {
        this.state = state;
        this.food_crop_id = food_crop_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String food_crop_id;
    private String remote_id;
}
