package co.ke.bsl.data.view;

public class TeaWarehouseManStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getTeaWarehouseMan_id() {
        return teaWarehouseMan_id;
    }

    public void setTeaWarehouseMan_id(String teaWarehouseMan_id) {
        this.teaWarehouseMan_id = teaWarehouseMan_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public TeaWarehouseManStatus(boolean state, String teaWarehouseMan_id, String remote_id) {
        this.state = state;
        this.teaWarehouseMan_id = teaWarehouseMan_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String teaWarehouseMan_id;
    private String remote_id;
}
