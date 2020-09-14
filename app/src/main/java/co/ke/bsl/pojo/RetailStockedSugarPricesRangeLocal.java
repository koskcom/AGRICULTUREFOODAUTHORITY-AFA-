package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class RetailStockedSugarPricesRangeLocal {

    private LoginRequest loginRequest;

    private String serviceType="CreateStockingSugarPricesRangeLocal";
   

    private String  brand;

    private String  localSugar24kgBale;

    private String  localSugar50kgBag;
    private String  localSugar20kgBale;


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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLocalSugar24kgBale() {
        return localSugar24kgBale;
    }

    public void setLocalSugar24kgBale(String localSugar24kgBale) {
        this.localSugar24kgBale = localSugar24kgBale;
    }

    public String getLocalSugar50kgBag() {
        return localSugar50kgBag;
    }

    public void setLocalSugar50kgBag(String localSugar50kgBag) {
        this.localSugar50kgBag = localSugar50kgBag;
    }

    public String getLocalSugar20kgBale() {
        return localSugar20kgBale;
    }

    public void setLocalSugar20kgBale(String localSugar20kgBale) {
        this.localSugar20kgBale = localSugar20kgBale;
    }

    public String getAFA_SD_SGR_Surveyshops_ID() {
        return AFA_SD_SGR_Surveyshops_ID;
    }

    public void setAFA_SD_SGR_Surveyshops_ID(String AFA_SD_SGR_Surveyshops_ID) {
        this.AFA_SD_SGR_Surveyshops_ID = AFA_SD_SGR_Surveyshops_ID;
    }
}
