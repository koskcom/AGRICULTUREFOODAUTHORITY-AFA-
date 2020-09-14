package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HorticultureProduceTransportation {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int horticultureProduceTransportationID;

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
    private String localID;

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


    private boolean is_synced;
    private String remote_id;

    public HorticultureProduceTransportation(int horticultureProduceTransportationID, String dealerCategory, String nameOfApllicant, String countyID, String location, String documentNumber, String documentDate, String isAdhocInspection, String telephone, String subCountyID, String cropOfInterest, String exportLicence, String localID, String companyName, String companyRegistrationNumber, String isOwnFarm, String isContractedSources, String isProduceTransportation, String produceTransportationRemarks, String isTransportVessel, String transportVesselRemarks, String isClearedDocumentation, String clearedDocumentationRemarks, String isIntegrityOfProduct, String integrityOfProductRemarks, String isProduceHandling, String produceHandlingRemarks, String comments, String officerrecommendation, String officerrecommendation_remark, String documentStatus, boolean is_synced, String remote_id) {
        this.horticultureProduceTransportationID = horticultureProduceTransportationID;
        this.dealerCategory = dealerCategory;
        this.nameOfApllicant = nameOfApllicant;
        this.countyID = countyID;
        this.location = location;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.isAdhocInspection = isAdhocInspection;
        this.telephone = telephone;
        this.subCountyID = subCountyID;
        this.cropOfInterest = cropOfInterest;
        this.exportLicence = exportLicence;
        this.localID = localID;
        this.companyName = companyName;
        this.companyRegistrationNumber = companyRegistrationNumber;
        this.isOwnFarm = isOwnFarm;
        this.isContractedSources = isContractedSources;
        this.isProduceTransportation = isProduceTransportation;
        this.produceTransportationRemarks = produceTransportationRemarks;
        this.isTransportVessel = isTransportVessel;
        this.transportVesselRemarks = transportVesselRemarks;
        this.isClearedDocumentation = isClearedDocumentation;
        this.clearedDocumentationRemarks = clearedDocumentationRemarks;
        this.isIntegrityOfProduct = isIntegrityOfProduct;
        this.integrityOfProductRemarks = integrityOfProductRemarks;
        this.isProduceHandling = isProduceHandling;
        this.produceHandlingRemarks = produceHandlingRemarks;
        this.comments = comments;
        this.officerrecommendation = officerrecommendation;
        this.officerrecommendation_remark = officerrecommendation_remark;
        this.documentStatus = documentStatus;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getHorticultureProduceTransportationID() {
        return horticultureProduceTransportationID;
    }

    public void setHorticultureProduceTransportationID(int horticultureProduceTransportationID) {
        this.horticultureProduceTransportationID = horticultureProduceTransportationID;
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

    public String getExportLicence() {
        return exportLicence;
    }

    public void setExportLicence(String exportLicence) {
        this.exportLicence = exportLicence;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
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

    public boolean isIs_synced() {
        return is_synced;
    }

    public void setIs_synced(boolean is_synced) {
        this.is_synced = is_synced;
    }

    public String getRemote_id() {
        return remote_id;
    }

    public void setRemote_id(String remote_id) {
        this.remote_id = remote_id;
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
