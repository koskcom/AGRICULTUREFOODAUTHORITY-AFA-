package co.ke.bsl.data.view;

public class TeaPackerStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getTeaPacker_id() {
        return teaPacker_id;
    }

    public void setTeaPacker_id(String teaPacker_id) {
        this.teaPacker_id = teaPacker_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public TeaPackerStatus(boolean state, String teaPacker_id, String remote_id) {
        this.state = state;
        this.teaPacker_id = teaPacker_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String teaPacker_id;
    private String remote_id;
}
