package co.ke.bsl.data.view;

public class CaneCensusStatus {
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCanecensus_id() {
        return canecensus_id;
    }

    public void setCanecensus_id(String canecensus_id) {
        this.canecensus_id = canecensus_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public CaneCensusStatus(boolean state, String canecensus_id, String remote_id) {
        this.state = state;
        this.canecensus_id = canecensus_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String canecensus_id;
    private String remote_id;

}
