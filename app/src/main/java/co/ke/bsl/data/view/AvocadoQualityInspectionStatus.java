package co.ke.bsl.data.view;

public class AvocadoQualityInspectionStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getAvocadoQualityInspection_id() {
        return avocadoQualityInspection_id;
    }

    public void setAvocadoQualityInspection_id(String avocadoQualityInspection_id) {
        this.avocadoQualityInspection_id = avocadoQualityInspection_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public AvocadoQualityInspectionStatus(boolean state, String avocadoQualityInspection_id, String remote_id) {
        this.state = state;
        this.avocadoQualityInspection_id = avocadoQualityInspection_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String avocadoQualityInspection_id;
    private String remote_id;
}
