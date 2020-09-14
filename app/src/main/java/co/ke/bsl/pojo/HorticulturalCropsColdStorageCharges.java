package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class HorticulturalCropsColdStorageCharges implements java.io.Serializable  {
    private String serverRecordID;

    private LoginRequest loginRequest;

    private String serviceType="CreateHorticulturalCropsColdStorageRegister";



    private String AFA_HCD_Horticultural_Crops_Cold_Storage_Register_ID;
    private String balance;
    private String charges;
    public String localID;
    public String parentID;

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

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

    public String getAFA_HCD_Horticultural_Crops_Cold_Storage_Register_ID() {
        return AFA_HCD_Horticultural_Crops_Cold_Storage_Register_ID;
    }

    public void setAFA_HCD_Horticultural_Crops_Cold_Storage_Register_ID(String AFA_HCD_Horticultural_Crops_Cold_Storage_Register_ID) {
        this.AFA_HCD_Horticultural_Crops_Cold_Storage_Register_ID = AFA_HCD_Horticultural_Crops_Cold_Storage_Register_ID;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }
}
