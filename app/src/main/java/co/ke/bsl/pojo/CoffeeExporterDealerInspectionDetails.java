package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

import java.io.Serializable;

public class CoffeeExporterDealerInspectionDetails  implements Serializable {

    private LoginRequest loginRequest;

    private String serviceType="QueryCoffeeExporterDealerInspection";

    private String sentStatus;

    private  String AFA_CD_DealerChecklist_ID;

    private String C_BPartner_ID;

    private String documentNumber;
    private String documentDate;
    private String applicantName;
    private String dealerLicenceNumber;
    private String localID;

    private String areMarkingsClear;
    private String areMarkingsClearRemarks;
    private String areOfficesPremisesIdeal;
    private String areOfficesPremisesIdealRemarks;
    private String isCoffeeDirectorateLicenceValid;
    private String isCoffeeDirectorateLicenceValidRemarks;
    private String hasSingleBusinessPermit;
    private String hasSingleBusinessPermitRemarks;
    private String areMarkingsClear2;
    private String areMarkingsClear2Remarks;
    private String areWasteDisposalSystems;
    private String areWasteDisposalSystemsRemarks;
    private String areFireFightingPlace;
    private String areFireFightingPlaceRemarks;
    private String areFireFightingServiced;
    private String areFireFightingServicedRemakrs;
    private String isCleanWaterAvailable;
    private String isCleanWaterAvailableRemarks;
    private String isGeneralHygieneSatisfactory;
    private String isGeneralHygieneSatisfactoryRemarks;
    private String areWashingRoomsClean;
    private String areWashingRoomsCleanRemarks;
    private String isCleanWaterSupplied;
    private String isCleanWaterSuppliedRemarks;
    private String isElectricitySupplied;
    private String isElectricitySuppliedRemarks;
    private String isSampleRoasterInPlace;
    private String isSampleRoasterInPlaceRemarks;
    private String isSampleGrinderInPlace;
    private String isSampleGrinderInPlaceRemarks;
    private String areSpittingDrumsInPlace;
    private String areSpittingDrumsInPlaceRemarks;
    private String areTestingCupsInPlace;
    private String areTestingCupsInPlaceRemarks;
    private String isSampleTraysInPlace;
    private String isSampleTraysInPlaceRemarks;
    private String areSpoonsInPlace;
    private String areSpoonsInPlaceRemarks;
    private String isWaterHeatingSystemInPlace;
    private String isWaterHeatingSystemInPlaceRemarks;
    private String isMoistureMeterInPlace;
    private String isMoistureMeterInPlaceRemarks;
    private String getIsCleanWaterSupplied2;
    private String getIsCleanWaterSupplied2Remarks;
    private String areWashingRoomsSatisfactory;
    private String areWashingRoomsSatisfactoryRemarks;
    private String areReturnsToCoffee;
    private String areReturnsToCoffeeRemarks;
    private String isLicencedLiquorerHired;
    private String isLicencedLiquorerHiredRemarks;
    private String isTraceabilitySystem;
    private String isTraceabilitySystemRemarks;
    private String areEnvironmentalEfforts;
    private String areEnvironmentalEffortsRemarks;
    private String isValueAddition;
    private String isValueAdditionRemarks;
    private String isPackagignQuality;
    private String isPackagignQualityRemarks;
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private String documentStatus;

    private String serverRecordID;

    private String coffeeMillerLicenceApplicationID;

    public CoffeeExporterDealerInspectionDetails() {
    }

    public CoffeeExporterDealerInspectionDetails(String documentNumber, String documentDate, String applicantName, String dealerLicenceNumber) {
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.applicantName = applicantName;
        this.dealerLicenceNumber = dealerLicenceNumber;
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

    public String getSentStatus() {
        return sentStatus;
    }

    public void setSentStatus(String sentStatus) {
        this.sentStatus = sentStatus;
    }

    public String getAFA_CD_DealerChecklist_ID() {
        return AFA_CD_DealerChecklist_ID;
    }

    public void setAFA_CD_DealerChecklist_ID(String AFA_CD_DealerChecklist_ID) {
        this.AFA_CD_DealerChecklist_ID = AFA_CD_DealerChecklist_ID;
    }

    public String getC_BPartner_ID() {
        return C_BPartner_ID;
    }

    public void setC_BPartner_ID(String c_BPartner_ID) {
        C_BPartner_ID = c_BPartner_ID;
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

    public String getDealerLicenceNumber() {
        return dealerLicenceNumber;
    }

    public void setDealerLicenceNumber(String dealerLicenceNumber) {
        this.dealerLicenceNumber = dealerLicenceNumber;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getAreMarkingsClear() {
        return areMarkingsClear;
    }

    public void setAreMarkingsClear(String areMarkingsClear) {
        this.areMarkingsClear = areMarkingsClear;
    }

    public String getAreMarkingsClearRemarks() {
        return areMarkingsClearRemarks;
    }

    public void setAreMarkingsClearRemarks(String areMarkingsClearRemarks) {
        this.areMarkingsClearRemarks = areMarkingsClearRemarks;
    }

    public String getAreOfficesPremisesIdeal() {
        return areOfficesPremisesIdeal;
    }

    public void setAreOfficesPremisesIdeal(String areOfficesPremisesIdeal) {
        this.areOfficesPremisesIdeal = areOfficesPremisesIdeal;
    }

    public String getAreOfficesPremisesIdealRemarks() {
        return areOfficesPremisesIdealRemarks;
    }

    public void setAreOfficesPremisesIdealRemarks(String areOfficesPremisesIdealRemarks) {
        this.areOfficesPremisesIdealRemarks = areOfficesPremisesIdealRemarks;
    }

    public String getIsCoffeeDirectorateLicenceValid() {
        return isCoffeeDirectorateLicenceValid;
    }

    public void setIsCoffeeDirectorateLicenceValid(String isCoffeeDirectorateLicenceValid) {
        this.isCoffeeDirectorateLicenceValid = isCoffeeDirectorateLicenceValid;
    }

    public String getIsCoffeeDirectorateLicenceValidRemarks() {
        return isCoffeeDirectorateLicenceValidRemarks;
    }

    public void setIsCoffeeDirectorateLicenceValidRemarks(String isCoffeeDirectorateLicenceValidRemarks) {
        this.isCoffeeDirectorateLicenceValidRemarks = isCoffeeDirectorateLicenceValidRemarks;
    }

    public String getHasSingleBusinessPermit() {
        return hasSingleBusinessPermit;
    }

    public void setHasSingleBusinessPermit(String hasSingleBusinessPermit) {
        this.hasSingleBusinessPermit = hasSingleBusinessPermit;
    }

    public String getHasSingleBusinessPermitRemarks() {
        return hasSingleBusinessPermitRemarks;
    }

    public void setHasSingleBusinessPermitRemarks(String hasSingleBusinessPermitRemarks) {
        this.hasSingleBusinessPermitRemarks = hasSingleBusinessPermitRemarks;
    }

    public String getAreMarkingsClear2() {
        return areMarkingsClear2;
    }

    public void setAreMarkingsClear2(String areMarkingsClear2) {
        this.areMarkingsClear2 = areMarkingsClear2;
    }

    public String getAreMarkingsClear2Remarks() {
        return areMarkingsClear2Remarks;
    }

    public void setAreMarkingsClear2Remarks(String areMarkingsClear2Remarks) {
        this.areMarkingsClear2Remarks = areMarkingsClear2Remarks;
    }

    public String getAreWasteDisposalSystems() {
        return areWasteDisposalSystems;
    }

    public void setAreWasteDisposalSystems(String areWasteDisposalSystems) {
        this.areWasteDisposalSystems = areWasteDisposalSystems;
    }

    public String getAreWasteDisposalSystemsRemarks() {
        return areWasteDisposalSystemsRemarks;
    }

    public void setAreWasteDisposalSystemsRemarks(String areWasteDisposalSystemsRemarks) {
        this.areWasteDisposalSystemsRemarks = areWasteDisposalSystemsRemarks;
    }

    public String getAreFireFightingPlace() {
        return areFireFightingPlace;
    }

    public void setAreFireFightingPlace(String areFireFightingPlace) {
        this.areFireFightingPlace = areFireFightingPlace;
    }

    public String getAreFireFightingPlaceRemarks() {
        return areFireFightingPlaceRemarks;
    }

    public void setAreFireFightingPlaceRemarks(String areFireFightingPlaceRemarks) {
        this.areFireFightingPlaceRemarks = areFireFightingPlaceRemarks;
    }

    public String getAreFireFightingServiced() {
        return areFireFightingServiced;
    }

    public void setAreFireFightingServiced(String areFireFightingServiced) {
        this.areFireFightingServiced = areFireFightingServiced;
    }

    public String getAreFireFightingServicedRemakrs() {
        return areFireFightingServicedRemakrs;
    }

    public void setAreFireFightingServicedRemakrs(String areFireFightingServicedRemakrs) {
        this.areFireFightingServicedRemakrs = areFireFightingServicedRemakrs;
    }

    public String getIsCleanWaterAvailable() {
        return isCleanWaterAvailable;
    }

    public void setIsCleanWaterAvailable(String isCleanWaterAvailable) {
        this.isCleanWaterAvailable = isCleanWaterAvailable;
    }

    public String getIsCleanWaterAvailableRemarks() {
        return isCleanWaterAvailableRemarks;
    }

    public void setIsCleanWaterAvailableRemarks(String isCleanWaterAvailableRemarks) {
        this.isCleanWaterAvailableRemarks = isCleanWaterAvailableRemarks;
    }

    public String getIsGeneralHygieneSatisfactory() {
        return isGeneralHygieneSatisfactory;
    }

    public void setIsGeneralHygieneSatisfactory(String isGeneralHygieneSatisfactory) {
        this.isGeneralHygieneSatisfactory = isGeneralHygieneSatisfactory;
    }

    public String getIsGeneralHygieneSatisfactoryRemarks() {
        return isGeneralHygieneSatisfactoryRemarks;
    }

    public void setIsGeneralHygieneSatisfactoryRemarks(String isGeneralHygieneSatisfactoryRemarks) {
        this.isGeneralHygieneSatisfactoryRemarks = isGeneralHygieneSatisfactoryRemarks;
    }

    public String getAreWashingRoomsClean() {
        return areWashingRoomsClean;
    }

    public void setAreWashingRoomsClean(String areWashingRoomsClean) {
        this.areWashingRoomsClean = areWashingRoomsClean;
    }

    public String getAreWashingRoomsCleanRemarks() {
        return areWashingRoomsCleanRemarks;
    }

    public void setAreWashingRoomsCleanRemarks(String areWashingRoomsCleanRemarks) {
        this.areWashingRoomsCleanRemarks = areWashingRoomsCleanRemarks;
    }

    public String getIsCleanWaterSupplied() {
        return isCleanWaterSupplied;
    }

    public void setIsCleanWaterSupplied(String isCleanWaterSupplied) {
        this.isCleanWaterSupplied = isCleanWaterSupplied;
    }

    public String getIsCleanWaterSuppliedRemarks() {
        return isCleanWaterSuppliedRemarks;
    }

    public void setIsCleanWaterSuppliedRemarks(String isCleanWaterSuppliedRemarks) {
        this.isCleanWaterSuppliedRemarks = isCleanWaterSuppliedRemarks;
    }

    public String getIsElectricitySupplied() {
        return isElectricitySupplied;
    }

    public void setIsElectricitySupplied(String isElectricitySupplied) {
        this.isElectricitySupplied = isElectricitySupplied;
    }

    public String getIsElectricitySuppliedRemarks() {
        return isElectricitySuppliedRemarks;
    }

    public void setIsElectricitySuppliedRemarks(String isElectricitySuppliedRemarks) {
        this.isElectricitySuppliedRemarks = isElectricitySuppliedRemarks;
    }

    public String getIsSampleRoasterInPlace() {
        return isSampleRoasterInPlace;
    }

    public void setIsSampleRoasterInPlace(String isSampleRoasterInPlace) {
        this.isSampleRoasterInPlace = isSampleRoasterInPlace;
    }

    public String getIsSampleRoasterInPlaceRemarks() {
        return isSampleRoasterInPlaceRemarks;
    }

    public void setIsSampleRoasterInPlaceRemarks(String isSampleRoasterInPlaceRemarks) {
        this.isSampleRoasterInPlaceRemarks = isSampleRoasterInPlaceRemarks;
    }

    public String getIsSampleGrinderInPlace() {
        return isSampleGrinderInPlace;
    }

    public void setIsSampleGrinderInPlace(String isSampleGrinderInPlace) {
        this.isSampleGrinderInPlace = isSampleGrinderInPlace;
    }

    public String getIsSampleGrinderInPlaceRemarks() {
        return isSampleGrinderInPlaceRemarks;
    }

    public void setIsSampleGrinderInPlaceRemarks(String isSampleGrinderInPlaceRemarks) {
        this.isSampleGrinderInPlaceRemarks = isSampleGrinderInPlaceRemarks;
    }

    public String getAreSpittingDrumsInPlace() {
        return areSpittingDrumsInPlace;
    }

    public void setAreSpittingDrumsInPlace(String areSpittingDrumsInPlace) {
        this.areSpittingDrumsInPlace = areSpittingDrumsInPlace;
    }

    public String getAreSpittingDrumsInPlaceRemarks() {
        return areSpittingDrumsInPlaceRemarks;
    }

    public void setAreSpittingDrumsInPlaceRemarks(String areSpittingDrumsInPlaceRemarks) {
        this.areSpittingDrumsInPlaceRemarks = areSpittingDrumsInPlaceRemarks;
    }

    public String getAreTestingCupsInPlace() {
        return areTestingCupsInPlace;
    }

    public void setAreTestingCupsInPlace(String areTestingCupsInPlace) {
        this.areTestingCupsInPlace = areTestingCupsInPlace;
    }

    public String getAreTestingCupsInPlaceRemarks() {
        return areTestingCupsInPlaceRemarks;
    }

    public void setAreTestingCupsInPlaceRemarks(String areTestingCupsInPlaceRemarks) {
        this.areTestingCupsInPlaceRemarks = areTestingCupsInPlaceRemarks;
    }

    public String getIsSampleTraysInPlace() {
        return isSampleTraysInPlace;
    }

    public void setIsSampleTraysInPlace(String isSampleTraysInPlace) {
        this.isSampleTraysInPlace = isSampleTraysInPlace;
    }

    public String getIsSampleTraysInPlaceRemarks() {
        return isSampleTraysInPlaceRemarks;
    }

    public void setIsSampleTraysInPlaceRemarks(String isSampleTraysInPlaceRemarks) {
        this.isSampleTraysInPlaceRemarks = isSampleTraysInPlaceRemarks;
    }

    public String getAreSpoonsInPlace() {
        return areSpoonsInPlace;
    }

    public void setAreSpoonsInPlace(String areSpoonsInPlace) {
        this.areSpoonsInPlace = areSpoonsInPlace;
    }

    public String getAreSpoonsInPlaceRemarks() {
        return areSpoonsInPlaceRemarks;
    }

    public void setAreSpoonsInPlaceRemarks(String areSpoonsInPlaceRemarks) {
        this.areSpoonsInPlaceRemarks = areSpoonsInPlaceRemarks;
    }

    public String getIsWaterHeatingSystemInPlace() {
        return isWaterHeatingSystemInPlace;
    }

    public void setIsWaterHeatingSystemInPlace(String isWaterHeatingSystemInPlace) {
        this.isWaterHeatingSystemInPlace = isWaterHeatingSystemInPlace;
    }

    public String getIsWaterHeatingSystemInPlaceRemarks() {
        return isWaterHeatingSystemInPlaceRemarks;
    }

    public void setIsWaterHeatingSystemInPlaceRemarks(String isWaterHeatingSystemInPlaceRemarks) {
        this.isWaterHeatingSystemInPlaceRemarks = isWaterHeatingSystemInPlaceRemarks;
    }

    public String getIsMoistureMeterInPlace() {
        return isMoistureMeterInPlace;
    }

    public void setIsMoistureMeterInPlace(String isMoistureMeterInPlace) {
        this.isMoistureMeterInPlace = isMoistureMeterInPlace;
    }

    public String getIsMoistureMeterInPlaceRemarks() {
        return isMoistureMeterInPlaceRemarks;
    }

    public void setIsMoistureMeterInPlaceRemarks(String isMoistureMeterInPlaceRemarks) {
        this.isMoistureMeterInPlaceRemarks = isMoistureMeterInPlaceRemarks;
    }

    public String getGetIsCleanWaterSupplied2() {
        return getIsCleanWaterSupplied2;
    }

    public void setGetIsCleanWaterSupplied2(String getIsCleanWaterSupplied2) {
        this.getIsCleanWaterSupplied2 = getIsCleanWaterSupplied2;
    }

    public String getGetIsCleanWaterSupplied2Remarks() {
        return getIsCleanWaterSupplied2Remarks;
    }

    public void setGetIsCleanWaterSupplied2Remarks(String getIsCleanWaterSupplied2Remarks) {
        this.getIsCleanWaterSupplied2Remarks = getIsCleanWaterSupplied2Remarks;
    }

    public String getAreWashingRoomsSatisfactory() {
        return areWashingRoomsSatisfactory;
    }

    public void setAreWashingRoomsSatisfactory(String areWashingRoomsSatisfactory) {
        this.areWashingRoomsSatisfactory = areWashingRoomsSatisfactory;
    }

    public String getAreWashingRoomsSatisfactoryRemarks() {
        return areWashingRoomsSatisfactoryRemarks;
    }

    public void setAreWashingRoomsSatisfactoryRemarks(String areWashingRoomsSatisfactoryRemarks) {
        this.areWashingRoomsSatisfactoryRemarks = areWashingRoomsSatisfactoryRemarks;
    }

    public String getAreReturnsToCoffee() {
        return areReturnsToCoffee;
    }

    public void setAreReturnsToCoffee(String areReturnsToCoffee) {
        this.areReturnsToCoffee = areReturnsToCoffee;
    }

    public String getAreReturnsToCoffeeRemarks() {
        return areReturnsToCoffeeRemarks;
    }

    public void setAreReturnsToCoffeeRemarks(String areReturnsToCoffeeRemarks) {
        this.areReturnsToCoffeeRemarks = areReturnsToCoffeeRemarks;
    }

    public String getIsLicencedLiquorerHired() {
        return isLicencedLiquorerHired;
    }

    public void setIsLicencedLiquorerHired(String isLicencedLiquorerHired) {
        this.isLicencedLiquorerHired = isLicencedLiquorerHired;
    }

    public String getIsLicencedLiquorerHiredRemarks() {
        return isLicencedLiquorerHiredRemarks;
    }

    public void setIsLicencedLiquorerHiredRemarks(String isLicencedLiquorerHiredRemarks) {
        this.isLicencedLiquorerHiredRemarks = isLicencedLiquorerHiredRemarks;
    }

    public String getIsTraceabilitySystem() {
        return isTraceabilitySystem;
    }

    public void setIsTraceabilitySystem(String isTraceabilitySystem) {
        this.isTraceabilitySystem = isTraceabilitySystem;
    }

    public String getIsTraceabilitySystemRemarks() {
        return isTraceabilitySystemRemarks;
    }

    public void setIsTraceabilitySystemRemarks(String isTraceabilitySystemRemarks) {
        this.isTraceabilitySystemRemarks = isTraceabilitySystemRemarks;
    }

    public String getAreEnvironmentalEfforts() {
        return areEnvironmentalEfforts;
    }

    public void setAreEnvironmentalEfforts(String areEnvironmentalEfforts) {
        this.areEnvironmentalEfforts = areEnvironmentalEfforts;
    }

    public String getAreEnvironmentalEffortsRemarks() {
        return areEnvironmentalEffortsRemarks;
    }

    public void setAreEnvironmentalEffortsRemarks(String areEnvironmentalEffortsRemarks) {
        this.areEnvironmentalEffortsRemarks = areEnvironmentalEffortsRemarks;
    }

    public String getIsValueAddition() {
        return isValueAddition;
    }

    public void setIsValueAddition(String isValueAddition) {
        this.isValueAddition = isValueAddition;
    }

    public String getIsValueAdditionRemarks() {
        return isValueAdditionRemarks;
    }

    public void setIsValueAdditionRemarks(String isValueAdditionRemarks) {
        this.isValueAdditionRemarks = isValueAdditionRemarks;
    }

    public String getIsPackagignQuality() {
        return isPackagignQuality;
    }

    public void setIsPackagignQuality(String isPackagignQuality) {
        this.isPackagignQuality = isPackagignQuality;
    }

    public String getIsPackagignQualityRemarks() {
        return isPackagignQualityRemarks;
    }

    public void setIsPackagignQualityRemarks(String isPackagignQualityRemarks) {
        this.isPackagignQualityRemarks = isPackagignQualityRemarks;
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

    public String getCoffeeMillerLicenceApplicationID() {
        return coffeeMillerLicenceApplicationID;
    }

    public void setCoffeeMillerLicenceApplicationID(String coffeeMillerLicenceApplicationID) {
        this.coffeeMillerLicenceApplicationID = coffeeMillerLicenceApplicationID;
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
