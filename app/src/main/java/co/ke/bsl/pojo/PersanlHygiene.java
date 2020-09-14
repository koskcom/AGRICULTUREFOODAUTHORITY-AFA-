package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

import java.io.Serializable;

public class PersanlHygiene implements Serializable {

    private LoginRequest loginRequest;

    private String serviceType="QueryPersanlHygiene";

    private String AFA_HCD_Persanl_Hygiene_ID;
    private String ssnameOfApplicant;
    private String localID;

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

    public String getAFA_HCD_Persanl_Hygiene_ID() {
        return AFA_HCD_Persanl_Hygiene_ID;
    }

    public void setAFA_HCD_Persanl_Hygiene_ID(String AFA_HCD_Persanl_Hygiene_ID) {
        this.AFA_HCD_Persanl_Hygiene_ID = AFA_HCD_Persanl_Hygiene_ID;
    }

    public String getSsnameOfApplicant() {
        return ssnameOfApplicant;
    }

    public void setSsnameOfApplicant(String ssnameOfApplicant) {
        this.ssnameOfApplicant = ssnameOfApplicant;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }
}
