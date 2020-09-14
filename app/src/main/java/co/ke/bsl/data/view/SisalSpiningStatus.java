package co.ke.bsl.data.view;

public class SisalSpiningStatus {
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getSisal_spining_id() {
        return sisal_spining_id;
    }

    public void setSisal_spining_id(String sisal_spining_id) {
        this.sisal_spining_id = sisal_spining_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public SisalSpiningStatus(boolean state, String sisal_spining_id, String remote_id) {
        this.state = state;
        this.sisal_spining_id = sisal_spining_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String sisal_spining_id;
    private String remote_id;
}
