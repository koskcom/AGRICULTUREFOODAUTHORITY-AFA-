package co.ke.bsl.data.view;

public class CottonLintStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCottonLint_id() {
        return cottonLint_id;
    }

    public void setCottonLint_id(String cottonLint_id) {
        this.cottonLint_id = cottonLint_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public CottonLintStatus(boolean state, String cottonLint_id, String remote_id) {
        this.state = state;
        this.cottonLint_id = cottonLint_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String cottonLint_id;
    private String remote_id;
}
