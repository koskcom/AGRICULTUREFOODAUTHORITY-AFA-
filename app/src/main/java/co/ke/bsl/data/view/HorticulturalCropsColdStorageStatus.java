package co.ke.bsl.data.view;

public class HorticulturalCropsColdStorageStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getHorticulturalCropsColdStorage_id() {
        return horticulturalCropsColdStorage_id;
    }

    public void setHorticulturalCropsColdStorage_id(String horticulturalCropsColdStorage_id) {
        this.horticulturalCropsColdStorage_id = horticulturalCropsColdStorage_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public HorticulturalCropsColdStorageStatus(boolean state, String horticulturalCropsColdStorage_id, String remote_id) {
        this.state = state;
        this.horticulturalCropsColdStorage_id = horticulturalCropsColdStorage_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String horticulturalCropsColdStorage_id;
    private String remote_id;
}
