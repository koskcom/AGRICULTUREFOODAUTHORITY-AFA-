package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class CoffeeMillingTariffs {
    private LoginRequest loginRequest;

    private String serviceType="CreateCoffeeMillingTariffs";

    private String  brtypeofserviceand;

    private String  currency;

    private String  justification;


    private String AFA_CD_MILLING_TARIFFS_ID;

    private String milling_id="0";

    public String  localID;

    public String serverRecordID;

    public String getServerRecordID() {
        return serverRecordID;
    }

    public void setServerRecordID(String serverRecordID) {
        this.serverRecordID = serverRecordID;
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

    public String getBrtypeofserviceand() {
        return brtypeofserviceand;
    }

    public void setBrtypeofserviceand(String brtypeofserviceand) {
        this.brtypeofserviceand = brtypeofserviceand;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getAFA_CD_MILLING_TARIFFS_ID() {
        return AFA_CD_MILLING_TARIFFS_ID;
    }

    public void setAFA_CD_MILLING_TARIFFS_ID(String AFA_CD_MILLING_TARIFFS_ID) {
        this.AFA_CD_MILLING_TARIFFS_ID = AFA_CD_MILLING_TARIFFS_ID;
    }

    public String getMilling_id() {
        return milling_id;
    }

    public void setMilling_id(String milling_id) {
        this.milling_id = milling_id;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }
}
