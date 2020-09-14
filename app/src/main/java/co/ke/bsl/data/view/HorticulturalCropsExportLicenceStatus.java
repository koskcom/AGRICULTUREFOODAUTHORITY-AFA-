package co.ke.bsl.data.view;

public class HorticulturalCropsExportLicenceStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getHorticulturalCropsExportLicence_id() {
        return horticulturalCropsExportLicence_id;
    }

    public void setHorticulturalCropsExportLicence_id(String horticulturalCropsExportLicence_id) {
        this.horticulturalCropsExportLicence_id = horticulturalCropsExportLicence_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public HorticulturalCropsExportLicenceStatus(boolean state, String horticulturalCropsExportLicence_id, String remote_id) {
        this.state = state;
        this.horticulturalCropsExportLicence_id = horticulturalCropsExportLicence_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String horticulturalCropsExportLicence_id;
    private String remote_id;
}
