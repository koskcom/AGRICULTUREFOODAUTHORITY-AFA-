package co.ke.bsl.data.view;

public class SugarWholesalePricesSurveyStatus
{
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getWholesale_prices_survey_id() {
        return wholesale_prices_survey_id;
    }

    public void setWholesale_prices_survey_id(String wholesale_prices_survey_id) {
        this.wholesale_prices_survey_id = wholesale_prices_survey_id;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
    }

    public SugarWholesalePricesSurveyStatus(boolean state, String wholesale_prices_survey_id, String remote_id) {
        this.state = state;
        this.wholesale_prices_survey_id = wholesale_prices_survey_id;
        this.remote_id = remote_id;
    }

    private boolean state;
    private String wholesale_prices_survey_id;
    private String remote_id;
}
