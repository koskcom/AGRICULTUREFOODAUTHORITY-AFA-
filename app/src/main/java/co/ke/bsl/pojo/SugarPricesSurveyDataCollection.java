package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class SugarPricesSurveyDataCollection implements java.io.Serializable
{
    private String longitude;
    private String latitude;

    private LoginRequest loginRequest;

    private String serviceType="CreateSugarPricesDataCollection";

    private String surveyType;
    private String city;
    private String document_date;
    private String document_Number;
    private String survey_Ending;


    private String AFA_SD_SugarPricesSurvey_ID;

    private String LocalID;

    public String getDocument_date() {
        return document_date;
    }

    public void setDocument_date(String document_date) {
        this.document_date = document_date;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    public void setLoginRequest(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDocument_Number() {
        return document_Number;
    }

    public void setDocument_Number(String document_Number) {
        this.document_Number = document_Number;
    }

    public String getSurvey_Ending() {
        return survey_Ending;
    }

    public void setSurvey_Ending(String survey_Ending) {
        this.survey_Ending = survey_Ending;
    }

    public String getAFA_SD_SugarPricesSurvey_ID() {
        return AFA_SD_SugarPricesSurvey_ID;
    }

    public void setAFA_SD_SugarPricesSurvey_ID(String AFA_SD_SugarPricesSurvey_ID) {
        this.AFA_SD_SugarPricesSurvey_ID = AFA_SD_SugarPricesSurvey_ID;
    }

    public String getLocalID() {
        return LocalID;
    }

    public void setLocalID(String localID) {
        LocalID = localID;
    }
}
