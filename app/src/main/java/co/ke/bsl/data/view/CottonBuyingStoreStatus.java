package co.ke.bsl.data.view;

public class CottonBuyingStoreStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCottonBuyingStore_id() {
        return cottonBuyingStore_id;
    }

    public void setCottonBuyingStore_id(String cottonBuyingStore_id) {
        this.cottonBuyingStore_id = cottonBuyingStore_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public CottonBuyingStoreStatus(boolean state, String cottonBuyingStore_id, String remote_id) {
        this.state = state;
        this.cottonBuyingStore_id = cottonBuyingStore_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String cottonBuyingStore_id;
    private String remote_id;
}
