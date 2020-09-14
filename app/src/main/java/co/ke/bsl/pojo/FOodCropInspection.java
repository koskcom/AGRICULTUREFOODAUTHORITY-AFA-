package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

import java.io.Serializable;

public class FOodCropInspection implements Serializable {
    private String serverRecordID;
    private String sentStatus;
    private LoginRequest loginRequest;
    private String serviceType="QueryFoodCrop";
    private String AFA_FD_FOOD_Crop_Inspection_ID;
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String foodCropLicence;
    private String localID;
    private String packagingAndLabelling;
    private String  conformityStandards;
    private String  sourceOfProduce;
    private String recommendation;
    private String recommendationRemarks;

    public FOodCropInspection(String documentNumber, String documentDate, String nameOfApplicant, String foodCropLicence) {
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.foodCropLicence = foodCropLicence;
    }

    public String getServerRecordID() {
        return serverRecordID;
    }

    public void setServerRecordID(String serverRecordID) {
        this.serverRecordID = serverRecordID;
    }

    public String getSentStatus() {
        return sentStatus;
    }

    public void setSentStatus(String sentStatus) {
        this.sentStatus = sentStatus;
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

    public String getAFA_FD_FOOD_Crop_Inspection_ID() {
        return AFA_FD_FOOD_Crop_Inspection_ID;
    }

    public void setAFA_FD_FOOD_Crop_Inspection_ID(String AFA_FD_FOOD_Crop_Inspection_ID) {
        this.AFA_FD_FOOD_Crop_Inspection_ID = AFA_FD_FOOD_Crop_Inspection_ID;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    public String getNameOfApplicant() {
        return nameOfApplicant;
    }

    public void setNameOfApplicant(String nameOfApplicant) {
        this.nameOfApplicant = nameOfApplicant;
    }

    public String getFoodCropLicence() {
        return foodCropLicence;
    }

    public void setFoodCropLicence(String foodCropLicence) {
        this.foodCropLicence = foodCropLicence;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getPackagingAndLabelling() {
        return packagingAndLabelling;
    }

    public void setPackagingAndLabelling(String packagingAndLabelling) {
        this.packagingAndLabelling = packagingAndLabelling;
    }

    public String getConformityStandards() {
        return conformityStandards;
    }

    public void setConformityStandards(String conformityStandards) {
        this.conformityStandards = conformityStandards;
    }

    public String getSourceOfProduce() {
        return sourceOfProduce;
    }

    public void setSourceOfProduce(String sourceOfProduce) {
        this.sourceOfProduce = sourceOfProduce;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getRecommendationRemarks() {
        return recommendationRemarks;
    }

    public void setRecommendationRemarks(String recommendationRemarks) {
        this.recommendationRemarks = recommendationRemarks;
    }

    public FOodCropInspection() {
    }
}
