package co.ke.bsl.data.view;

public class HorticulturalProduceTransportationStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getHorticulturalProduceTransportation_id() {
        return horticulturalProduceTransportation_id;
    }

    public void setHorticulturalProduceTransportation_id(String horticulturalProduceTransportation_id) {
        this.horticulturalProduceTransportation_id = horticulturalProduceTransportation_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public HorticulturalProduceTransportationStatus(boolean state, String horticulturalProduceTransportation_id, String remote_id) {
        this.state = state;
        this.horticulturalProduceTransportation_id = horticulturalProduceTransportation_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String horticulturalProduceTransportation_id;
    private String remote_id;
}
