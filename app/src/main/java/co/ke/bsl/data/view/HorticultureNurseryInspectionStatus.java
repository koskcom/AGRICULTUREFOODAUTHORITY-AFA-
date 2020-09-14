package co.ke.bsl.data.view;

public class HorticultureNurseryInspectionStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getHorticultureNurseryInspection_id() {
        return horticultureNurseryInspection_id;
    }

    public void setHorticultureNurseryInspection_id(String horticultureNurseryInspection_id) {
        this.horticultureNurseryInspection_id = horticultureNurseryInspection_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public HorticultureNurseryInspectionStatus(boolean state, String horticultureNurseryInspection_id, String remote_id) {
        this.state = state;
        this.horticultureNurseryInspection_id = horticultureNurseryInspection_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String horticultureNurseryInspection_id;
    private String remote_id;
}
