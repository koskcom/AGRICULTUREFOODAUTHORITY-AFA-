package co.ke.bsl.data.view;

public class SisalSpinningStatus {
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getSisalSpinning_id() {
        return sisalSpinning_id;
    }

    public void setSisalSpinning_id(String sisalFactory_id) {
        this.sisalSpinning_id = sisalFactory_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public SisalSpinningStatus(boolean state, String sisalSpinning_id, String remote_id) {
        this.state = state;
        this.sisalSpinning_id = sisalSpinning_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String sisalSpinning_id;
    private String remote_id;
}
