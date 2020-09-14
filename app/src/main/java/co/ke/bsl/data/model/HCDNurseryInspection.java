package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HCDNurseryInspection {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int hcdNurseryInspection_id;

    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String nurseryLicence;
    private String telephone;
    private String location;
    private String email;
    private String localID;
    private String ssNurseryType;
    private String hectarage;
    private String isDiseasefreeSeedling;
    private String diseasefreeSeedlingRemarks;
    private String isFreefromOrganicLitter;
    private String freefromOrganicLitterRemarks;
    private String isClearseparation;
    private String clearSeparationRemarks;
    private String isYearroundSourceOfWater;
    private String yearroundSourceOfWaterRemarks;
    private String isSoilmedia;
    private String soilMediaRemarks;
    private String isWellsecuredNurseryLayout;
    private String wellsecuredNurseryLayoutRemarks;
    private String isArestructuresInPlace;
    private String arestructuresInPlaceRemarks;
    private String isScionsource;
    private String scionSourceRemarks;
    private String isApprovedsource;
    private String approvedSourceRemarks;
    private String isWellLabeledNurseryblock;
    private String wellLabeledNurseryBlockRemarks;
    private String isReadydispatchSeedlings;
    private String readydispatchSeedlingsRemarks;
    private String isdistributionRecords;
    private String distributionRecordsRemarks;
    private String isNurserycertificateWell;
    private String nurserycertificateWellRemarks;
    private String otherRemarks;
    private String officerrecommendation;
    private String officerrecommendation_remark;

    private boolean is_synced;
    private String remote_id;

    public HCDNurseryInspection(int hcdNurseryInspection_id, String documentNumber, String documentDate, String nameOfApplicant, String nurseryLicence, String telephone, String location, String email, String localID, String ssNurseryType, String hectarage, String isDiseasefreeSeedling, String diseasefreeSeedlingRemarks, String isFreefromOrganicLitter, String freefromOrganicLitterRemarks, String isClearseparation, String clearSeparationRemarks, String isYearroundSourceOfWater, String yearroundSourceOfWaterRemarks, String isSoilmedia, String soilMediaRemarks, String isWellsecuredNurseryLayout, String wellsecuredNurseryLayoutRemarks, String isArestructuresInPlace, String arestructuresInPlaceRemarks, String isScionsource, String scionSourceRemarks, String isApprovedsource, String approvedSourceRemarks, String isWellLabeledNurseryblock, String wellLabeledNurseryBlockRemarks, String isReadydispatchSeedlings, String readydispatchSeedlingsRemarks, String isdistributionRecords, String distributionRecordsRemarks, String isNurserycertificateWell, String nurserycertificateWellRemarks, String otherRemarks, String officerrecommendation, String officerrecommendation_remark, boolean is_synced, String remote_id) {
        this.hcdNurseryInspection_id = hcdNurseryInspection_id;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.nurseryLicence = nurseryLicence;
        this.telephone = telephone;
        this.location = location;
        this.email = email;
        this.localID = localID;
        this.ssNurseryType = ssNurseryType;
        this.hectarage = hectarage;
        this.isDiseasefreeSeedling = isDiseasefreeSeedling;
        this.diseasefreeSeedlingRemarks = diseasefreeSeedlingRemarks;
        this.isFreefromOrganicLitter = isFreefromOrganicLitter;
        this.freefromOrganicLitterRemarks = freefromOrganicLitterRemarks;
        this.isClearseparation = isClearseparation;
        this.clearSeparationRemarks = clearSeparationRemarks;
        this.isYearroundSourceOfWater = isYearroundSourceOfWater;
        this.yearroundSourceOfWaterRemarks = yearroundSourceOfWaterRemarks;
        this.isSoilmedia = isSoilmedia;
        this.soilMediaRemarks = soilMediaRemarks;
        this.isWellsecuredNurseryLayout = isWellsecuredNurseryLayout;
        this.wellsecuredNurseryLayoutRemarks = wellsecuredNurseryLayoutRemarks;
        this.isArestructuresInPlace = isArestructuresInPlace;
        this.arestructuresInPlaceRemarks = arestructuresInPlaceRemarks;
        this.isScionsource = isScionsource;
        this.scionSourceRemarks = scionSourceRemarks;
        this.isApprovedsource = isApprovedsource;
        this.approvedSourceRemarks = approvedSourceRemarks;
        this.isWellLabeledNurseryblock = isWellLabeledNurseryblock;
        this.wellLabeledNurseryBlockRemarks = wellLabeledNurseryBlockRemarks;
        this.isReadydispatchSeedlings = isReadydispatchSeedlings;
        this.readydispatchSeedlingsRemarks = readydispatchSeedlingsRemarks;
        this.isdistributionRecords = isdistributionRecords;
        this.distributionRecordsRemarks = distributionRecordsRemarks;
        this.isNurserycertificateWell = isNurserycertificateWell;
        this.nurserycertificateWellRemarks = nurserycertificateWellRemarks;
        this.otherRemarks = otherRemarks;
        this.officerrecommendation = officerrecommendation;
        this.officerrecommendation_remark = officerrecommendation_remark;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
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

    public int getHcdNurseryInspection_id() {
        return hcdNurseryInspection_id;
    }

    public void setHcdNurseryInspection_id(int hcdNurseryInspection_id) {
        this.hcdNurseryInspection_id = hcdNurseryInspection_id;
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

    public String getNurseryLicence() {
        return nurseryLicence;
    }

    public void setNurseryLicence(String nurseryLicence) {
        this.nurseryLicence = nurseryLicence;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getSsNurseryType() {
        return ssNurseryType;
    }

    public void setSsNurseryType(String ssNurseryType) {
        this.ssNurseryType = ssNurseryType;
    }

    public String getHectarage() {
        return hectarage;
    }

    public void setHectarage(String hectarage) {
        this.hectarage = hectarage;
    }

    public String getIsDiseasefreeSeedling() {
        return isDiseasefreeSeedling;
    }

    public void setIsDiseasefreeSeedling(String isDiseasefreeSeedling) {
        this.isDiseasefreeSeedling = isDiseasefreeSeedling;
    }

    public String getDiseasefreeSeedlingRemarks() {
        return diseasefreeSeedlingRemarks;
    }

    public void setDiseasefreeSeedlingRemarks(String diseasefreeSeedlingRemarks) {
        this.diseasefreeSeedlingRemarks = diseasefreeSeedlingRemarks;
    }

    public String getIsFreefromOrganicLitter() {
        return isFreefromOrganicLitter;
    }

    public void setIsFreefromOrganicLitter(String isFreefromOrganicLitter) {
        this.isFreefromOrganicLitter = isFreefromOrganicLitter;
    }

    public String getFreefromOrganicLitterRemarks() {
        return freefromOrganicLitterRemarks;
    }

    public void setFreefromOrganicLitterRemarks(String freefromOrganicLitterRemarks) {
        this.freefromOrganicLitterRemarks = freefromOrganicLitterRemarks;
    }

    public String getIsClearseparation() {
        return isClearseparation;
    }

    public void setIsClearseparation(String isClearseparation) {
        this.isClearseparation = isClearseparation;
    }

    public String getClearSeparationRemarks() {
        return clearSeparationRemarks;
    }

    public void setClearSeparationRemarks(String clearSeparationRemarks) {
        this.clearSeparationRemarks = clearSeparationRemarks;
    }

    public String getIsYearroundSourceOfWater() {
        return isYearroundSourceOfWater;
    }

    public void setIsYearroundSourceOfWater(String isYearroundSourceOfWater) {
        this.isYearroundSourceOfWater = isYearroundSourceOfWater;
    }

    public String getYearroundSourceOfWaterRemarks() {
        return yearroundSourceOfWaterRemarks;
    }

    public void setYearroundSourceOfWaterRemarks(String yearroundSourceOfWaterRemarks) {
        this.yearroundSourceOfWaterRemarks = yearroundSourceOfWaterRemarks;
    }

    public String getIsSoilmedia() {
        return isSoilmedia;
    }

    public void setIsSoilmedia(String isSoilmedia) {
        this.isSoilmedia = isSoilmedia;
    }

    public String getSoilMediaRemarks() {
        return soilMediaRemarks;
    }

    public void setSoilMediaRemarks(String soilMediaRemarks) {
        this.soilMediaRemarks = soilMediaRemarks;
    }

    public String getIsWellsecuredNurseryLayout() {
        return isWellsecuredNurseryLayout;
    }

    public void setIsWellsecuredNurseryLayout(String isWellsecuredNurseryLayout) {
        this.isWellsecuredNurseryLayout = isWellsecuredNurseryLayout;
    }

    public String getWellsecuredNurseryLayoutRemarks() {
        return wellsecuredNurseryLayoutRemarks;
    }

    public void setWellsecuredNurseryLayoutRemarks(String wellsecuredNurseryLayoutRemarks) {
        this.wellsecuredNurseryLayoutRemarks = wellsecuredNurseryLayoutRemarks;
    }

    public String getIsArestructuresInPlace() {
        return isArestructuresInPlace;
    }

    public void setIsArestructuresInPlace(String isArestructuresInPlace) {
        this.isArestructuresInPlace = isArestructuresInPlace;
    }

    public String getArestructuresInPlaceRemarks() {
        return arestructuresInPlaceRemarks;
    }

    public void setArestructuresInPlaceRemarks(String arestructuresInPlaceRemarks) {
        this.arestructuresInPlaceRemarks = arestructuresInPlaceRemarks;
    }

    public String getIsScionsource() {
        return isScionsource;
    }

    public void setIsScionsource(String isScionsource) {
        this.isScionsource = isScionsource;
    }

    public String getScionSourceRemarks() {
        return scionSourceRemarks;
    }

    public void setScionSourceRemarks(String scionSourceRemarks) {
        this.scionSourceRemarks = scionSourceRemarks;
    }

    public String getIsApprovedsource() {
        return isApprovedsource;
    }

    public void setIsApprovedsource(String isApprovedsource) {
        this.isApprovedsource = isApprovedsource;
    }

    public String getApprovedSourceRemarks() {
        return approvedSourceRemarks;
    }

    public void setApprovedSourceRemarks(String approvedSourceRemarks) {
        this.approvedSourceRemarks = approvedSourceRemarks;
    }

    public String getIsWellLabeledNurseryblock() {
        return isWellLabeledNurseryblock;
    }

    public void setIsWellLabeledNurseryblock(String isWellLabeledNurseryblock) {
        this.isWellLabeledNurseryblock = isWellLabeledNurseryblock;
    }

    public String getWellLabeledNurseryBlockRemarks() {
        return wellLabeledNurseryBlockRemarks;
    }

    public void setWellLabeledNurseryBlockRemarks(String wellLabeledNurseryBlockRemarks) {
        this.wellLabeledNurseryBlockRemarks = wellLabeledNurseryBlockRemarks;
    }

    public String getIsReadydispatchSeedlings() {
        return isReadydispatchSeedlings;
    }

    public void setIsReadydispatchSeedlings(String isReadydispatchSeedlings) {
        this.isReadydispatchSeedlings = isReadydispatchSeedlings;
    }

    public String getReadydispatchSeedlingsRemarks() {
        return readydispatchSeedlingsRemarks;
    }

    public void setReadydispatchSeedlingsRemarks(String readydispatchSeedlingsRemarks) {
        this.readydispatchSeedlingsRemarks = readydispatchSeedlingsRemarks;
    }

    public String getIsdistributionRecords() {
        return isdistributionRecords;
    }

    public void setIsdistributionRecords(String isdistributionRecords) {
        this.isdistributionRecords = isdistributionRecords;
    }

    public String getDistributionRecordsRemarks() {
        return distributionRecordsRemarks;
    }

    public void setDistributionRecordsRemarks(String distributionRecordsRemarks) {
        this.distributionRecordsRemarks = distributionRecordsRemarks;
    }

    public String getIsNurserycertificateWell() {
        return isNurserycertificateWell;
    }

    public void setIsNurserycertificateWell(String isNurserycertificateWell) {
        this.isNurserycertificateWell = isNurserycertificateWell;
    }

    public String getNurserycertificateWellRemarks() {
        return nurserycertificateWellRemarks;
    }

    public void setNurserycertificateWellRemarks(String nurserycertificateWellRemarks) {
        this.nurserycertificateWellRemarks = nurserycertificateWellRemarks;
    }

    public String getOtherRemarks() {
        return otherRemarks;
    }

    public void setOtherRemarks(String otherRemarks) {
        this.otherRemarks = otherRemarks;
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
