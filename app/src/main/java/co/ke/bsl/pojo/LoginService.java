package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class LoginService    {

    private  String c_City_ID;

    private String  typeOfSugarPricesSurvey;

    private LoginRequest loginRequest;


    public String getC_City_ID() {
        return c_City_ID;
    }

    public void setC_City_ID(String c_City_ID) {
        this.c_City_ID = c_City_ID;
    }

    public String getTypeOfSugarPricesSurvey() {
        return typeOfSugarPricesSurvey;
    }

    public void setTypeOfSugarPricesSurvey(String typeOfSugarPricesSurvey) {
        this.typeOfSugarPricesSurvey = typeOfSugarPricesSurvey;
    }


    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    public void setLoginRequest(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }
}
