package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class AvocadoQualityInspectionOilContent implements java.io.Serializable{

    private String serverRecordID;

    private LoginRequest loginRequest;

    private String serviceType="updateAvocadoQualityInspectionOilContent";
    private String AFA_HCD_Avocado_Quality_Inspection_ID;
    private String localID;
    private String source;
    private String destination;
    private String sampleVariety;
    private String sampleFruitSize;
    private String initialWT;
    private String finalWt;
    private String moistureContentIWFW;
    private String moistureContentPercetage;
    private String oilContent;
    private String remarks;

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
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

    public String getAFA_HCD_Avocado_Quality_Inspection_ID() {
        return AFA_HCD_Avocado_Quality_Inspection_ID;
    }

    public void setAFA_HCD_Avocado_Quality_Inspection_ID(String AFA_HCD_Avocado_Quality_Inspection_ID) {
        this.AFA_HCD_Avocado_Quality_Inspection_ID = AFA_HCD_Avocado_Quality_Inspection_ID;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSampleVariety() {
        return sampleVariety;
    }

    public void setSampleVariety(String sampleVariety) {
        this.sampleVariety = sampleVariety;
    }

    public String getSampleFruitSize() {
        return sampleFruitSize;
    }

    public void setSampleFruitSize(String sampleFruitSize) {
        this.sampleFruitSize = sampleFruitSize;
    }

    public String getInitialWT() {
        return initialWT;
    }

    public void setInitialWT(String initialWT) {
        this.initialWT = initialWT;
    }

    public String getFinalWt() {
        return finalWt;
    }

    public void setFinalWt(String finalWt) {
        this.finalWt = finalWt;
    }

    public String getMoistureContentIWFW() {
        return moistureContentIWFW;
    }

    public void setMoistureContentIWFW(String moistureContentIWFW) {
        this.moistureContentIWFW = moistureContentIWFW;
    }

    public String getMoistureContentPercetage() {
        return moistureContentPercetage;
    }

    public void setMoistureContentPercetage(String moistureContentPercetage) {
        this.moistureContentPercetage = moistureContentPercetage;
    }

    public String getOilContent() {
        return oilContent;
    }

    public void setOilContent(String oilContent) {
        this.oilContent = oilContent;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
