package co.ke.bsl.data.view;

public class PulpingStationATEStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getPulpingStationAte_id() {
        return pulpingStationAte_id;
    }

    public void setPulpingStationAte_id(String pulpingStationAte_id) {
        this.pulpingStationAte_id = pulpingStationAte_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public PulpingStationATEStatus(boolean state, String pulpingStationAte_id, String remote_id) {
        this.state = state;
        this.pulpingStationAte_id = pulpingStationAte_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String pulpingStationAte_id;
    private String remote_id;
}
