package co.ke.bsl.data.view;

public class SugarRetailPricesSurveyStatus {
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getRetails_prices_survey_id() {
        return retails_prices_survey_id;
    }

    public void setRetails_prices_survey_id(String retails_prices_survey_id) {
        this.retails_prices_survey_id = retails_prices_survey_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public SugarRetailPricesSurveyStatus(boolean state, String retails_prices_survey_id, String remote_id) {
        this.state = state;
        this.retails_prices_survey_id = retails_prices_survey_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String retails_prices_survey_id;
    private String remote_id;
}
