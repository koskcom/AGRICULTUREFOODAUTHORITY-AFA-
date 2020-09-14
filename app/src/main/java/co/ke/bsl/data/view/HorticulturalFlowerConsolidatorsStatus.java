package co.ke.bsl.data.view;

public class HorticulturalFlowerConsolidatorsStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getHorticulturalFLowerConsolidators_id() {
        return horticulturalFLowerConsolidators_id;
    }

    public void setHorticulturalFLowerConsolidators_id(String horticulturalFLowerConsolidators_id) {
        this.horticulturalFLowerConsolidators_id = horticulturalFLowerConsolidators_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public HorticulturalFlowerConsolidatorsStatus(boolean state, String horticulturalFLowerConsolidators_id, String remote_id) {
        this.state = state;
        this.horticulturalFLowerConsolidators_id = horticulturalFLowerConsolidators_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String horticulturalFLowerConsolidators_id;
    private String remote_id;
}
