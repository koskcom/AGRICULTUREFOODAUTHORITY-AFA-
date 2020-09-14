package co.ke.bsl.data.view;

public class ColdRoomTemperatureStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getColdRoomTemperature_id() {
        return coldRoomTemperature_id;
    }

    public void setColdRoomTemperature_id(String coldRoomTemperature_id) {
        this.coldRoomTemperature_id = coldRoomTemperature_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public ColdRoomTemperatureStatus(boolean state, String coldRoomTemperature_id, String remote_id) {
        this.state = state;
        this.coldRoomTemperature_id = coldRoomTemperature_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String coldRoomTemperature_id;
    private String remote_id;
}
