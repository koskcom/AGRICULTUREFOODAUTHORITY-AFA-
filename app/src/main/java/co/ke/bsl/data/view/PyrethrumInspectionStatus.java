package co.ke.bsl.data.view;

public class PyrethrumInspectionStatus {

    private boolean state;
    private String pyrethrumInspectionStatus_id;
    private String remote_id;

    public PyrethrumInspectionStatus(boolean state, String pyrethrumInspectionStatus_id, String remote_id) {
        this.state = state;
        this.pyrethrumInspectionStatus_id = pyrethrumInspectionStatus_id;
        this.remote_id = remote_id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public String getPyrethrumInspectionStatus_id() {
        return pyrethrumInspectionStatus_id;
    }

    public void setPyrethrumInspectionStatus_id(String pyrethrumInspectionStatus_id) {
        this.pyrethrumInspectionStatus_id = pyrethrumInspectionStatus_id;
    }


}
