package co.ke.bsl.data.view;

public class SisalFactoryStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getSisalFactory_id() {
        return sisalFactory_id;
    }

    public void setSisalFactory_id(String sisalFactory_id) {
        this.sisalFactory_id = sisalFactory_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public SisalFactoryStatus(boolean state, String sisalFactory_id, String remote_id) {
        this.state = state;
        this.sisalFactory_id = sisalFactory_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String sisalFactory_id;
    private String remote_id;
}
