package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class RetailSugarPricesRangeLocal {

    private LoginRequest loginRequest;

    private String serviceType="CreateLocalRetailRetailLocalSugarPrice";

    private String  brand;

    private String  looseSugarLocal1kg;

    private String  looseSugarLocal2kg;

    private String AFA_SD_SGR_Surveyshops_ID;
    
    
    private String shopID="0";
    
    public String  localID;
    
    public String getLocalID() {
        return localID;
    }
    
    public void setLocalID(String localID) {
        this.localID = localID;
    }
    
    public String getShopID() {
        return shopID;
    }
    
    public void setShopID(String shopID) {
        this.shopID = shopID;
    }
    
    
    private String serverRecordID;
    
    
    
    
    public String getServerRecordID() {
        return serverRecordID;
    }
    
    public void setServerRecordID(String serverRecordID) {
        this.serverRecordID = serverRecordID;
    }
    
    
    
    
    public String getAFA_SD_SGR_Surveyshops_ID() {
        return AFA_SD_SGR_Surveyshops_ID;
    }

    public void setAFA_SD_SGR_Surveyshops_ID(String AFA_SD_SGR_Surveyshops_ID) {
        this.AFA_SD_SGR_Surveyshops_ID = AFA_SD_SGR_Surveyshops_ID;
    }

    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    public void setLoginRequest(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }


    public String getLooseSugarLocal1kg() {
        return looseSugarLocal1kg;
    }

    public void setLooseSugarLocal1kg(String looseSugarLocal1kg) {
        this.looseSugarLocal1kg = looseSugarLocal1kg;
    }


    public String getLooseSugarLocal2kg() {
        return looseSugarLocal2kg;
    }

    public void setLooseSugarLocal2kg(String looseSugarLocal2kg) {
        this.looseSugarLocal2kg = looseSugarLocal2kg;
    }
}
