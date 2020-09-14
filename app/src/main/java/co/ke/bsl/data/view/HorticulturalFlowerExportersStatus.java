package co.ke.bsl.data.view;

public class HorticulturalFlowerExportersStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getHorticulturalFlowerExporters_id() {
        return horticulturalFlowerExporters_id;
    }

    public void setHorticulturalFlowerExporters_id(String horticulturalFlowerExporters_id) {
        this.horticulturalFlowerExporters_id = horticulturalFlowerExporters_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public HorticulturalFlowerExportersStatus(boolean state, String horticulturalFlowerExporters_id, String remote_id) {
        this.state = state;
        this.horticulturalFlowerExporters_id = horticulturalFlowerExporters_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String horticulturalFlowerExporters_id;
    private String remote_id;
}
