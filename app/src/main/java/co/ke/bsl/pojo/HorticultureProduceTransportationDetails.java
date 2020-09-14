package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class HorticultureProduceTransportationDetails implements java.io.Serializable {
    private String longitude;
    private String latitude;

    private LoginRequest loginRequest;

    private String serviceType="QueryHorticultureProduceTransportation";

    private String c_bpartnerID;

    private String AFA_HC_Produce_Trans_Insp_ID;

    private String localID;

    private String dealerCategory;
    private String nameOfApllicant;
    private String countyID;
    private String location;
    private String documentNumber;
    private String documentDate;
    private String isAdhocInspection;
    private String telephone;
    private String subCountyID;
    private String cropOfInterest;
    private String exportLicence;

    private String companyName;
    private String companyRegistrationNumber;
    private String isOwnFarm;
    private String isContractedSources;
    private String isProduceTransportation;
    private String produceTransportationRemarks;
    private String isTransportVessel;
    private String transportVesselRemarks;
    private String isClearedDocumentation;
    private String clearedDocumentationRemarks;
    private String isIntegrityOfProduct;
    private String integrityOfProductRemarks;
    private String isProduceHandling;
    private String produceHandlingRemarks;
    private String comments;
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private String documentStatus;


    private String serverRecordID;

    public HorticultureProduceTransportationDetails() {
    }

    public HorticultureProduceTransportationDetails(String nameOfApllicant, String documentNumber, String documentDate, String exportLicence) {
        this.nameOfApllicant = nameOfApllicant;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.exportLicence = exportLicence;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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

    public String getC_bpartnerID() {
        return c_bpartnerID;
    }

    public void setC_bpartnerID(String c_bpartnerID) {
        this.c_bpartnerID = c_bpartnerID;
    }

    public String getAFA_HC_Produce_Trans_Insp_ID() {
        return AFA_HC_Produce_Trans_Insp_ID;
    }

    public void setAFA_HC_Produce_Trans_Insp_ID(String AFA_HC_Produce_Trans_Insp_ID) {
        this.AFA_HC_Produce_Trans_Insp_ID = AFA_HC_Produce_Trans_Insp_ID;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getDealerCategory() {
        return dealerCategory;
    }

    public void setDealerCategory(String dealerCategory) {
        this.dealerCategory = dealerCategory;
    }

    public String getNameOfApllicant() {
        return nameOfApllicant;
    }

    public void setNameOfApllicant(String nameOfApllicant) {
        this.nameOfApllicant = nameOfApllicant;
    }

    public String getCountyID() {
        return countyID;
    }

    public void setCountyID(String countyID) {
        this.countyID = countyID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getIsAdhocInspection() {
        return isAdhocInspection;
    }

    public void setIsAdhocInspection(String isAdhocInspection) {
        this.isAdhocInspection = isAdhocInspection;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSubCountyID() {
        return subCountyID;
    }

    public void setSubCountyID(String subCountyID) {
        this.subCountyID = subCountyID;
    }

    public String getCropOfInterest() {
        return cropOfInterest;
    }

    public void setCropOfInterest(String cropOfInterest) {
        this.cropOfInterest = cropOfInterest;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public String getIsOwnFarm() {
        return isOwnFarm;
    }

    public void setIsOwnFarm(String isOwnFarm) {
        this.isOwnFarm = isOwnFarm;
    }

    public String getIsContractedSources() {
        return isContractedSources;
    }

    public void setIsContractedSources(String isContractedSources) {
        this.isContractedSources = isContractedSources;
    }

    public String getIsProduceTransportation() {
        return isProduceTransportation;
    }

    public void setIsProduceTransportation(String isProduceTransportation) {
        this.isProduceTransportation = isProduceTransportation;
    }

    public String getProduceTransportationRemarks() {
        return produceTransportationRemarks;
    }

    public void setProduceTransportationRemarks(String produceTransportationRemarks) {
        this.produceTransportationRemarks = produceTransportationRemarks;
    }

    public String getIsTransportVessel() {
        return isTransportVessel;
    }

    public void setIsTransportVessel(String isTransportVessel) {
        this.isTransportVessel = isTransportVessel;
    }

    public String getTransportVesselRemarks() {
        return transportVesselRemarks;
    }

    public void setTransportVesselRemarks(String transportVesselRemarks) {
        this.transportVesselRemarks = transportVesselRemarks;
    }

    public String getIsClearedDocumentation() {
        return isClearedDocumentation;
    }

    public void setIsClearedDocumentation(String isClearedDocumentation) {
        this.isClearedDocumentation = isClearedDocumentation;
    }

    public String getClearedDocumentationRemarks() {
        return clearedDocumentationRemarks;
    }

    public void setClearedDocumentationRemarks(String clearedDocumentationRemarks) {
        this.clearedDocumentationRemarks = clearedDocumentationRemarks;
    }

    public String getIsIntegrityOfProduct() {
        return isIntegrityOfProduct;
    }

    public void setIsIntegrityOfProduct(String isIntegrityOfProduct) {
        this.isIntegrityOfProduct = isIntegrityOfProduct;
    }

    public String getIntegrityOfProductRemarks() {
        return integrityOfProductRemarks;
    }

    public void setIntegrityOfProductRemarks(String integrityOfProductRemarks) {
        this.integrityOfProductRemarks = integrityOfProductRemarks;
    }

    public String getIsProduceHandling() {
        return isProduceHandling;
    }

    public void setIsProduceHandling(String isProduceHandling) {
        this.isProduceHandling = isProduceHandling;
    }

    public String getProduceHandlingRemarks() {
        return produceHandlingRemarks;
    }

    public void setProduceHandlingRemarks(String produceHandlingRemarks) {
        this.produceHandlingRemarks = produceHandlingRemarks;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public String getServerRecordID() {
        return serverRecordID;
    }

    public void setServerRecordID(String serverRecordID) {
        this.serverRecordID = serverRecordID;
    }

    public String getExportLicence() {
        return exportLicence;
    }

    public void setExportLicence(String exportLicence) {
        this.exportLicence = exportLicence;
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
