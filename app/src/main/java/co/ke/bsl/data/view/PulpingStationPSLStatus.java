package co.ke.bsl.data.view;

public class PulpingStationPSLStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getPulpingStationPsl_id() {
        return pulpingStationPsl_id;
    }

    public void setPulpingStationPsl_id(String pulpingStationPsl_id) {
        this.pulpingStationPsl_id = pulpingStationPsl_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public PulpingStationPSLStatus(boolean state, String pulpingStationPsl_id, String remote_id) {
        this.state = state;
        this.pulpingStationPsl_id = pulpingStationPsl_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String pulpingStationPsl_id;
    private String remote_id;
}
