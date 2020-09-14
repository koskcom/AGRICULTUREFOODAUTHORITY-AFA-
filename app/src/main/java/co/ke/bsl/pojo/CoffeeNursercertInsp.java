package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;
public class CoffeeNursercertInsp implements java.io.Serializable {


    private LoginRequest loginRequest;

    private String serviceType="QueryNuserryCertificateInspection";

    private String afa_cd_inspection_id;

    private String documentNumber;
    private String documentaDate;
    private String applicantName;
    private String LocalID;
    private String certificateNumber;
    private String county;
    private String sub_county;
    private String location;
    private String sub_location;
    private String village;
    private String countyIsCorrect;
    private String sub_countyIsCorrect;
    private String locationIsCorrect;
    private String sub_locationIsCorrect;
    private String villageIsCorrect;
    private String countyRemarks;
    private String sub_countyRemarks;
    private String locationRemarks;
    private String sub_locationRemarks;
    private String villageRemarks;

    private String titleDeed;
    private String titledeedIsTitledeed;
    private String coffeeacreage;
    private String production;
    private String nurserycategory;
    private String naurseryCategoryIsNursery;
    private String titledeedRemarks;
    private String nurserycategoryRemarks;

    private String siteSuitability;
    private String siteAccessibilty;
    private String waterAvailability;
    private String technicalKnowHow;
    private String advisoryOfficers;
    private String groupReccomendations;
    private String officerrecommendation;
    private String officerrecommendation_remark;

    public CoffeeNursercertInsp() {
    }

    public CoffeeNursercertInsp(String documentNumber, String documentaDate, String applicantName, String certificateNumber, String county, String sub_county, String location, String sub_location, String village) {
        this.documentNumber = documentNumber;
        this.documentaDate = documentaDate;
        this.applicantName = applicantName;
        this.certificateNumber = certificateNumber;
        this.county = county;
        this.sub_county = sub_county;
        this.location = location;
        this.sub_location = sub_location;
        this.village = village;
    }

    public String getTitleDeed() {
        return titleDeed;
    }

    public void setTitleDeed(String titleDeed) {
        this.titleDeed = titleDeed;
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

    public String getAfa_cd_inspection_id() {
        return afa_cd_inspection_id;
    }

    public void setAfa_cd_inspection_id(String afa_cd_inspection_id) {
        this.afa_cd_inspection_id = afa_cd_inspection_id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentaDate() {
        return documentaDate;
    }

    public void setDocumentaDate(String documentaDate) {
        this.documentaDate = documentaDate;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getLocalID() {
        return LocalID;
    }

    public void setLocalID(String localID) {
        LocalID = localID;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getSub_county() {
        return sub_county;
    }

    public void setSub_county(String sub_county) {
        this.sub_county = sub_county;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSub_location() {
        return sub_location;
    }

    public void setSub_location(String sub_location) {
        this.sub_location = sub_location;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getCountyIsCorrect() {
        return countyIsCorrect;
    }

    public void setCountyIsCorrect(String countyIsCorrect) {
        this.countyIsCorrect = countyIsCorrect;
    }

    public String getSub_countyIsCorrect() {
        return sub_countyIsCorrect;
    }

    public void setSub_countyIsCorrect(String sub_countyIsCorrect) {
        this.sub_countyIsCorrect = sub_countyIsCorrect;
    }

    public String getLocationIsCorrect() {
        return locationIsCorrect;
    }

    public void setLocationIsCorrect(String locationIsCorrect) {
        this.locationIsCorrect = locationIsCorrect;
    }

    public String getSub_locationIsCorrect() {
        return sub_locationIsCorrect;
    }

    public void setSub_locationIsCorrect(String sub_locationIsCorrect) {
        this.sub_locationIsCorrect = sub_locationIsCorrect;
    }

    public String getVillageIsCorrect() {
        return villageIsCorrect;
    }

    public void setVillageIsCorrect(String villageIsCorrect) {
        this.villageIsCorrect = villageIsCorrect;
    }

    public String getCountyRemarks() {
        return countyRemarks;
    }

    public void setCountyRemarks(String countyRemarks) {
        this.countyRemarks = countyRemarks;
    }

    public String getSub_countyRemarks() {
        return sub_countyRemarks;
    }

    public void setSub_countyRemarks(String sub_countyRemarks) {
        this.sub_countyRemarks = sub_countyRemarks;
    }

    public String getLocationRemarks() {
        return locationRemarks;
    }

    public void setLocationRemarks(String locationRemarks) {
        this.locationRemarks = locationRemarks;
    }

    public String getSub_locationRemarks() {
        return sub_locationRemarks;
    }

    public void setSub_locationRemarks(String sub_locationRemarks) {
        this.sub_locationRemarks = sub_locationRemarks;
    }

    public String getVillageRemarks() {
        return villageRemarks;
    }

    public void setVillageRemarks(String villageRemarks) {
        this.villageRemarks = villageRemarks;
    }

    public String getTitledeedIsTitledeed() {
        return titledeedIsTitledeed;
    }

    public void setTitledeedIsTitledeed(String titledeedIsTitledeed) {
        this.titledeedIsTitledeed = titledeedIsTitledeed;
    }

    public String getCoffeeacreage() {
        return coffeeacreage;
    }

    public void setCoffeeacreage(String coffeeacreage) {
        this.coffeeacreage = coffeeacreage;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getNurserycategory() {
        return nurserycategory;
    }

    public void setNurserycategory(String nurserycategory) {
        this.nurserycategory = nurserycategory;
    }

    public String getNaurseryCategoryIsNursery() {
        return naurseryCategoryIsNursery;
    }

    public void setNaurseryCategoryIsNursery(String naurseryCategoryIsNursery) {
        this.naurseryCategoryIsNursery = naurseryCategoryIsNursery;
    }

    public String getTitledeedRemarks() {
        return titledeedRemarks;
    }

    public void setTitledeedRemarks(String titledeedRemarks) {
        this.titledeedRemarks = titledeedRemarks;
    }

    public String getNurserycategoryRemarks() {
        return nurserycategoryRemarks;
    }

    public void setNurserycategoryRemarks(String nurserycategoryRemarks) {
        this.nurserycategoryRemarks = nurserycategoryRemarks;
    }

    public String getSiteSuitability() {
        return siteSuitability;
    }

    public void setSiteSuitability(String siteSuitability) {
        this.siteSuitability = siteSuitability;
    }

    public String getSiteAccessibilty() {
        return siteAccessibilty;
    }

    public void setSiteAccessibilty(String siteAccessibilty) {
        this.siteAccessibilty = siteAccessibilty;
    }

    public String getWaterAvailability() {
        return waterAvailability;
    }

    public void setWaterAvailability(String waterAvailability) {
        this.waterAvailability = waterAvailability;
    }

    public String getTechnicalKnowHow() {
        return technicalKnowHow;
    }

    public void setTechnicalKnowHow(String technicalKnowHow) {
        this.technicalKnowHow = technicalKnowHow;
    }

    public String getAdvisoryOfficers() {
        return advisoryOfficers;
    }

    public void setAdvisoryOfficers(String advisoryOfficers) {
        this.advisoryOfficers = advisoryOfficers;
    }

    public String getGroupReccomendations() {
        return groupReccomendations;
    }

    public void setGroupReccomendations(String groupReccomendations) {
        this.groupReccomendations = groupReccomendations;
    }

    public String getOfficerrecommendation() {
        return officerrecommendation;
    }

    public void setOfficerrecommendation(String officerrecommendation) {
        this.officerrecommendation = officerrecommendation;
    }

    public String getOfficerrecommendation_remark() {
        return officerrecommendation_remark;
    }

    public void setOfficerrecommendation_remark(String officerrecommendation_remark) {
        this.officerrecommendation_remark = officerrecommendation_remark;
    }
}
