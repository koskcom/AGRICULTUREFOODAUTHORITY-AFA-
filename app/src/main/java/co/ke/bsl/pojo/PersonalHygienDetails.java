package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

import java.io.Serializable;

public class PersonalHygienDetails implements Serializable {

    private LoginRequest loginRequest;

    private String serviceType="QueryPersanlHygiene";

    private String AFA_HCD_Persanl_Hygiene_ID;
    private String localID;
    private String names;
    private String nationalId;
    private String medicalCertNo;
    private String isdustCots;
    private String isjewels;
    private String isnailsCut;
    private String isbodyClean;
    private String isshoes;

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

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getMedicalCertNo() {
        return medicalCertNo;
    }

    public void setMedicalCertNo(String medicalCertNo) {
        this.medicalCertNo = medicalCertNo;
    }

    public String getIsdustCots() {
        return isdustCots;
    }

    public void setIsdustCots(String isdustCots) {
        this.isdustCots = isdustCots;
    }

    public String getIsjewels() {
        return isjewels;
    }

    public void setIsjewels(String isjewels) {
        this.isjewels = isjewels;
    }

    public String getIsnailsCut() {
        return isnailsCut;
    }

    public void setIsnailsCut(String isnailsCut) {
        this.isnailsCut = isnailsCut;
    }

    public String getIsbodyClean() {
        return isbodyClean;
    }

    public void setIsbodyClean(String isbodyClean) {
        this.isbodyClean = isbodyClean;
    }

    public String getIsshoes() {
        return isshoes;
    }

    public void setIsshoes(String isshoes) {
        this.isshoes = isshoes;
    }
}
