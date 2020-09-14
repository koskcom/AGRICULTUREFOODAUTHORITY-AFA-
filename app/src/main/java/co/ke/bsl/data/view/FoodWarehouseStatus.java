package co.ke.bsl.data.view;

public class FoodWarehouseStatus {
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getFood_warehouse_id() {
        return food_warehouse_id;
    }

    public void setFood_warehouse_id(String food_warehouse_id) {
        this.food_warehouse_id = food_warehouse_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public FoodWarehouseStatus(boolean state, String food_warehouse_id, String remote_id) {
        this.state = state;
        this.food_warehouse_id = food_warehouse_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String food_warehouse_id;
    private String remote_id;
}
