package co.ke.bsl.data.view;

public class MangoQualityInspectionStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMangoQualityInspection_id() {
        return mangoQualityInspection_id;
    }

    public void setMangoQualityInspection_id(String mangoQualityInspection_id) {
        this.mangoQualityInspection_id = mangoQualityInspection_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public MangoQualityInspectionStatus(boolean state, String mangoQualityInspection_id, String remote_id) {
        this.state = state;
        this.mangoQualityInspection_id = mangoQualityInspection_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String mangoQualityInspection_id;
    private String remote_id;
}
