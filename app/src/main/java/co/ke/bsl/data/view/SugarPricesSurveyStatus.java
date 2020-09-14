package co.ke.bsl.data.view;

public class SugarPricesSurveyStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getSugarpricessurvey_id() {
        return sugarpricessurvey_id;
    }

    public void setSugarpricessurvey_id(String sugarpricessurvey_id) {
        this.sugarpricessurvey_id = sugarpricessurvey_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public SugarPricesSurveyStatus(boolean state, String canecensus_id, String remote_id) {
        this.state = state;
        this.sugarpricessurvey_id = sugarpricessurvey_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String sugarpricessurvey_id;
    private String remote_id;
}
