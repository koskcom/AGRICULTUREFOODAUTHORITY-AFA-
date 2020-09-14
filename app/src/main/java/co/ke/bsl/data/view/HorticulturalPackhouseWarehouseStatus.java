package co.ke.bsl.data.view;

public class HorticulturalPackhouseWarehouseStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getHortuculturalPackhouseWarehouse_id() {
        return hortuculturalPackhouseWarehouse_id;
    }

    public void setHortuculturalPackhouseWarehouse_id(String hortuculturalPackhouseWarehouse_id) {
        this.hortuculturalPackhouseWarehouse_id = hortuculturalPackhouseWarehouse_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public HorticulturalPackhouseWarehouseStatus(boolean state, String hortuculturalPackhouseWarehouse_id, String remote_id) {
        this.state = state;
        this.hortuculturalPackhouseWarehouse_id = hortuculturalPackhouseWarehouse_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String hortuculturalPackhouseWarehouse_id;
    private String remote_id;
}
