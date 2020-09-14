package co.ke.bsl.data.view;

public class NutsAndOilsStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getNutsAndOils_id() {
        return nutsAndOils_id;
    }

    public void setNutsAndOils_id(String nutsAndOils_id) {
        this.nutsAndOils_id = nutsAndOils_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public NutsAndOilsStatus(boolean state, String nutsAndOils_id, String remote_id) {
        this.state = state;
        this.nutsAndOils_id = nutsAndOils_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String nutsAndOils_id;
    private String remote_id;
}
