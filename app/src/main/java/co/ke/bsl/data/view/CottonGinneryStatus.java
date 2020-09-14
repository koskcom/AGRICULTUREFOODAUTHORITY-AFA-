package co.ke.bsl.data.view;

public class CottonGinneryStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCottonGinnery_id() {
        return cottonGinnery_id;
    }

    public void setCottonGinnery_id(String cottonGinnery_id) {
        this.cottonGinnery_id = cottonGinnery_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public CottonGinneryStatus(boolean state, String cottonGinnery_id, String remote_id) {
        this.state = state;
        this.cottonGinnery_id = cottonGinnery_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String cottonGinnery_id;
    private String remote_id;
}
