package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PulpingStationLicenseApplication {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int pulping_station_inspection_id;

    private String documentNumber;
    private String documentDate;
    private String applicantName;
    private String authorityToErectNumber;
    private String localID;

    private String totalLandArea;
    private String totalNumberOfTrees;
    private String areaUnderMatureCoffee;
    private String firstYear;
    private String firstYearProduction;
    private String secondYear;
    private String secondYearProduction;
    private String thirdYear;
    private String thirdYearProduction;
    private String cropHusbandryPractices;
    private String isObjectionLetter;
    private String isObjectionLetterRemarks;
    private String isWasteDisposal;
    private String isWasteDisposalRemarks;
    private String isPollutionManagement;
    private String isPollutionManagementRemarks;
    private String isWater;
    private String isWaterRemarks;
    private String isNemaCertificate;
    private String isNemaCertificateRemarks;
    private String coffeeAdvisory;
    private String coffeeWorking;
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private String documentStatus;


    private boolean is_synced;
    private String remote_id;

    public PulpingStationLicenseApplication(int pulping_station_inspection_id, String documentNumber, String documentDate, String applicantName, String authorityToErectNumber, String localID, String totalLandArea, String totalNumberOfTrees, String areaUnderMatureCoffee, String firstYear, String firstYearProduction, String secondYear, String secondYearProduction, String thirdYear, String thirdYearProduction, String cropHusbandryPractices, String isObjectionLetter, String isObjectionLetterRemarks, String isWasteDisposal, String isWasteDisposalRemarks, String isPollutionManagement, String isPollutionManagementRemarks, String isWater, String isWaterRemarks, String isNemaCertificate, String isNemaCertificateRemarks, String coffeeAdvisory, String coffeeWorking, String officerrecommendation, String officerrecommendation_remark, String documentStatus, boolean is_synced, String remote_id) {
        this.pulping_station_inspection_id = pulping_station_inspection_id;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.applicantName = applicantName;
        this.authorityToErectNumber = authorityToErectNumber;
        this.localID = localID;
        this.totalLandArea = totalLandArea;
        this.totalNumberOfTrees = totalNumberOfTrees;
        this.areaUnderMatureCoffee = areaUnderMatureCoffee;
        this.firstYear = firstYear;
        this.firstYearProduction = firstYearProduction;
        this.secondYear = secondYear;
        this.secondYearProduction = secondYearProduction;
        this.thirdYear = thirdYear;
        this.thirdYearProduction = thirdYearProduction;
        this.cropHusbandryPractices = cropHusbandryPractices;
        this.isObjectionLetter = isObjectionLetter;
        this.isObjectionLetterRemarks = isObjectionLetterRemarks;
        this.isWasteDisposal = isWasteDisposal;
        this.isWasteDisposalRemarks = isWasteDisposalRemarks;
        this.isPollutionManagement = isPollutionManagement;
        this.isPollutionManagementRemarks = isPollutionManagementRemarks;
        this.isWater = isWater;
        this.isWaterRemarks = isWaterRemarks;
        this.isNemaCertificate = isNemaCertificate;
        this.isNemaCertificateRemarks = isNemaCertificateRemarks;
        this.coffeeAdvisory = coffeeAdvisory;
        this.coffeeWorking = coffeeWorking;
        this.officerrecommendation = officerrecommendation;
        this.officerrecommendation_remark = officerrecommendation_remark;
        this.documentStatus = documentStatus;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }



    public int getPulping_station_inspection_id() {
        return pulping_station_inspection_id;
    }

    public void setPulping_station_inspection_id(int pulping_station_inspection_id) {
        this.pulping_station_inspection_id = pulping_station_inspection_id;
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

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getAuthorityToErectNumber() {
        return authorityToErectNumber;
    }

    public void setAuthorityToErectNumber(String authorityToErectNumber) {
        this.authorityToErectNumber = authorityToErectNumber;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getTotalLandArea() {
        return totalLandArea;
    }

    public void setTotalLandArea(String totalLandArea) {
        this.totalLandArea = totalLandArea;
    }

    public String getTotalNumberOfTrees() {
        return totalNumberOfTrees;
    }

    public void setTotalNumberOfTrees(String totalNumberOfTrees) {
        this.totalNumberOfTrees = totalNumberOfTrees;
    }

    public String getAreaUnderMatureCoffee() {
        return areaUnderMatureCoffee;
    }

    public void setAreaUnderMatureCoffee(String areaUnderMatureCoffee) {
        this.areaUnderMatureCoffee = areaUnderMatureCoffee;
    }

    public String getFirstYear() {
        return firstYear;
    }

    public void setFirstYear(String firstYear) {
        this.firstYear = firstYear;
    }

    public String getFirstYearProduction() {
        return firstYearProduction;
    }

    public void setFirstYearProduction(String firstYearProduction) {
        this.firstYearProduction = firstYearProduction;
    }

    public String getSecondYear() {
        return secondYear;
    }

    public void setSecondYear(String secondYear) {
        this.secondYear = secondYear;
    }

    public String getSecondYearProduction() {
        return secondYearProduction;
    }

    public void setSecondYearProduction(String secondYearProduction) {
        this.secondYearProduction = secondYearProduction;
    }

    public String getThirdYear() {
        return thirdYear;
    }

    public void setThirdYear(String thirdYear) {
        this.thirdYear = thirdYear;
    }

    public String getThirdYearProduction() {
        return thirdYearProduction;
    }

    public void setThirdYearProduction(String thirdYearProduction) {
        this.thirdYearProduction = thirdYearProduction;
    }

    public String getCropHusbandryPractices() {
        return cropHusbandryPractices;
    }

    public void setCropHusbandryPractices(String cropHusbandryPractices) {
        this.cropHusbandryPractices = cropHusbandryPractices;
    }

    public String getIsObjectionLetter() {
        return isObjectionLetter;
    }

    public void setIsObjectionLetter(String isObjectionLetter) {
        this.isObjectionLetter = isObjectionLetter;
    }

    public String getIsObjectionLetterRemarks() {
        return isObjectionLetterRemarks;
    }

    public void setIsObjectionLetterRemarks(String isObjectionLetterRemarks) {
        this.isObjectionLetterRemarks = isObjectionLetterRemarks;
    }

    public String getIsWasteDisposal() {
        return isWasteDisposal;
    }

    public void setIsWasteDisposal(String isWasteDisposal) {
        this.isWasteDisposal = isWasteDisposal;
    }

    public String getIsWasteDisposalRemarks() {
        return isWasteDisposalRemarks;
    }

    public void setIsWasteDisposalRemarks(String isWasteDisposalRemarks) {
        this.isWasteDisposalRemarks = isWasteDisposalRemarks;
    }

    public String getIsPollutionManagement() {
        return isPollutionManagement;
    }

    public void setIsPollutionManagement(String isPollutionManagement) {
        this.isPollutionManagement = isPollutionManagement;
    }

    public String getIsPollutionManagementRemarks() {
        return isPollutionManagementRemarks;
    }

    public void setIsPollutionManagementRemarks(String isPollutionManagementRemarks) {
        this.isPollutionManagementRemarks = isPollutionManagementRemarks;
    }

    public String getIsWater() {
        return isWater;
    }

    public void setIsWater(String isWater) {
        this.isWater = isWater;
    }

    public String getIsWaterRemarks() {
        return isWaterRemarks;
    }

    public void setIsWaterRemarks(String isWaterRemarks) {
        this.isWaterRemarks = isWaterRemarks;
    }

    public String getIsNemaCertificate() {
        return isNemaCertificate;
    }

    public void setIsNemaCertificate(String isNemaCertificate) {
        this.isNemaCertificate = isNemaCertificate;
    }

    public String getIsNemaCertificateRemarks() {
        return isNemaCertificateRemarks;
    }

    public void setIsNemaCertificateRemarks(String isNemaCertificateRemarks) {
        this.isNemaCertificateRemarks = isNemaCertificateRemarks;
    }

    public String getCoffeeAdvisory() {
        return coffeeAdvisory;
    }

    public void setCoffeeAdvisory(String coffeeAdvisory) {
        this.coffeeAdvisory = coffeeAdvisory;
    }

    public String getCoffeeWorking() {
        return coffeeWorking;
    }

    public void setCoffeeWorking(String coffeeWorking) {
        this.coffeeWorking = coffeeWorking;
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
