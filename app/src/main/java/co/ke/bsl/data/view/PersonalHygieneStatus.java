package co.ke.bsl.data.view;

public class PersonalHygieneStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getPersonalHygiene_id() {
        return personalHygiene_id;
    }

    public void setPersonalHygiene_id(String personalHygiene_id) {
        this.personalHygiene_id = personalHygiene_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public PersonalHygieneStatus(boolean state, String personalHygiene_id, String remote_id) {
        this.state = state;
        this.personalHygiene_id = personalHygiene_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String personalHygiene_id;
    private String remote_id;
}
