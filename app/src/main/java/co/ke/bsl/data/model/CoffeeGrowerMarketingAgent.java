package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CoffeeGrowerMarketingAgent {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int coffee_grower_marketing_agent_id;

    private String documentNumber;
    private String documentDate;
    private String applicantName;
    private String licenceNumber;
    private String localID;

    private String isMarkings;
    private String isMarkingsRemarks;
    private String isCoffeeDirectorate;
    private String isCoffeeDirectorateRemarks;
    private String isSingleBusinessPermit;
    private String isSingleBusinessPermitRemarks;
    private String isWasteDisposalSystems;
    private String isWasteDisposalSystemsRemarks;
    private String isFireFightingEquipment;
    private String isFireFightingEquipmentRemarks;
    private String isGeneralHygieneSatisfactory;
    private String isGeneralHygieneSatisfactoryRemarks;
    private String isWashingRoomsClean;
    private String isWashingRoomsCleanRemarks;
    private String isCleanWaterSupplied;
    private String isCleanWaterSuppliedRemarks;
    private String isElectricitySupplied;
    private String isElectricitySuppliedRemarks;
    private String isReturnsToCoffeeDirectorate;
    private String isReturnsToCoffeeDirectorateRemarks;
    private String isTraceabilitySystem;
    private String isTraceabilitySystemRemarks;
    private String isCuppingFacilities;
    private String isCuppingFacilitiesRemarks;
    private String isOccupationalHealth;
    private String isOccupationalHealthRemarks;
    private String isPayementToGrowers;
    private String isPayementToGrowersRemarks;
    private String isStandardOutTurn;
    private String isStandardOutTurnRemarks;
    private String isStandardDirect;
    private String isStandardDirectRemarks;
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private String documentStatus;

    private boolean is_synced;
    private String remote_id;

    public CoffeeGrowerMarketingAgent(int coffee_grower_marketing_agent_id, String documentNumber, String documentDate, String applicantName, String licenceNumber, String localID, String isMarkings, String isMarkingsRemarks, String isCoffeeDirectorate, String isCoffeeDirectorateRemarks, String isSingleBusinessPermit, String isSingleBusinessPermitRemarks, String isWasteDisposalSystems, String isWasteDisposalSystemsRemarks, String isFireFightingEquipment, String isFireFightingEquipmentRemarks, String isGeneralHygieneSatisfactory, String isGeneralHygieneSatisfactoryRemarks, String isWashingRoomsClean, String isWashingRoomsCleanRemarks, String isCleanWaterSupplied, String isCleanWaterSuppliedRemarks, String isElectricitySupplied, String isElectricitySuppliedRemarks, String isReturnsToCoffeeDirectorate, String isReturnsToCoffeeDirectorateRemarks, String isTraceabilitySystem, String isTraceabilitySystemRemarks, String isCuppingFacilities, String isCuppingFacilitiesRemarks, String isOccupationalHealth, String isOccupationalHealthRemarks, String isPayementToGrowers, String isPayementToGrowersRemarks, String isStandardOutTurn, String isStandardOutTurnRemarks, String isStandardDirect, String isStandardDirectRemarks, String officerrecommendation, String officerrecommendation_remark, String documentStatus, boolean is_synced, String remote_id) {
        this.coffee_grower_marketing_agent_id = coffee_grower_marketing_agent_id;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.applicantName = applicantName;
        this.licenceNumber = licenceNumber;
        this.localID = localID;
        this.isMarkings = isMarkings;
        this.isMarkingsRemarks = isMarkingsRemarks;
        this.isCoffeeDirectorate = isCoffeeDirectorate;
        this.isCoffeeDirectorateRemarks = isCoffeeDirectorateRemarks;
        this.isSingleBusinessPermit = isSingleBusinessPermit;
        this.isSingleBusinessPermitRemarks = isSingleBusinessPermitRemarks;
        this.isWasteDisposalSystems = isWasteDisposalSystems;
        this.isWasteDisposalSystemsRemarks = isWasteDisposalSystemsRemarks;
        this.isFireFightingEquipment = isFireFightingEquipment;
        this.isFireFightingEquipmentRemarks = isFireFightingEquipmentRemarks;
        this.isGeneralHygieneSatisfactory = isGeneralHygieneSatisfactory;
        this.isGeneralHygieneSatisfactoryRemarks = isGeneralHygieneSatisfactoryRemarks;
        this.isWashingRoomsClean = isWashingRoomsClean;
        this.isWashingRoomsCleanRemarks = isWashingRoomsCleanRemarks;
        this.isCleanWaterSupplied = isCleanWaterSupplied;
        this.isCleanWaterSuppliedRemarks = isCleanWaterSuppliedRemarks;
        this.isElectricitySupplied = isElectricitySupplied;
        this.isElectricitySuppliedRemarks = isElectricitySuppliedRemarks;
        this.isReturnsToCoffeeDirectorate = isReturnsToCoffeeDirectorate;
        this.isReturnsToCoffeeDirectorateRemarks = isReturnsToCoffeeDirectorateRemarks;
        this.isTraceabilitySystem = isTraceabilitySystem;
        this.isTraceabilitySystemRemarks = isTraceabilitySystemRemarks;
        this.isCuppingFacilities = isCuppingFacilities;
        this.isCuppingFacilitiesRemarks = isCuppingFacilitiesRemarks;
        this.isOccupationalHealth = isOccupationalHealth;
        this.isOccupationalHealthRemarks = isOccupationalHealthRemarks;
        this.isPayementToGrowers = isPayementToGrowers;
        this.isPayementToGrowersRemarks = isPayementToGrowersRemarks;
        this.isStandardOutTurn = isStandardOutTurn;
        this.isStandardOutTurnRemarks = isStandardOutTurnRemarks;
        this.isStandardDirect = isStandardDirect;
        this.isStandardDirectRemarks = isStandardDirectRemarks;
        this.officerrecommendation = officerrecommendation;
        this.officerrecommendation_remark = officerrecommendation_remark;
        this.documentStatus = documentStatus;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getCoffee_grower_marketing_agent_id() {
        return coffee_grower_marketing_agent_id;
    }

    public void setCoffee_grower_marketing_agent_id(int coffee_grower_marketing_agent_id) {
        this.coffee_grower_marketing_agent_id = coffee_grower_marketing_agent_id;
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

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getIsMarkings() {
        return isMarkings;
    }

    public void setIsMarkings(String isMarkings) {
        this.isMarkings = isMarkings;
    }

    public String getIsMarkingsRemarks() {
        return isMarkingsRemarks;
    }

    public void setIsMarkingsRemarks(String isMarkingsRemarks) {
        this.isMarkingsRemarks = isMarkingsRemarks;
    }

    public String getIsCoffeeDirectorate() {
        return isCoffeeDirectorate;
    }

    public void setIsCoffeeDirectorate(String isCoffeeDirectorate) {
        this.isCoffeeDirectorate = isCoffeeDirectorate;
    }

    public String getIsCoffeeDirectorateRemarks() {
        return isCoffeeDirectorateRemarks;
    }

    public void setIsCoffeeDirectorateRemarks(String isCoffeeDirectorateRemarks) {
        this.isCoffeeDirectorateRemarks = isCoffeeDirectorateRemarks;
    }

    public String getIsSingleBusinessPermit() {
        return isSingleBusinessPermit;
    }

    public void setIsSingleBusinessPermit(String isSingleBusinessPermit) {
        this.isSingleBusinessPermit = isSingleBusinessPermit;
    }

    public String getIsSingleBusinessPermitRemarks() {
        return isSingleBusinessPermitRemarks;
    }

    public void setIsSingleBusinessPermitRemarks(String isSingleBusinessPermitRemarks) {
        this.isSingleBusinessPermitRemarks = isSingleBusinessPermitRemarks;
    }

    public String getIsWasteDisposalSystems() {
        return isWasteDisposalSystems;
    }

    public void setIsWasteDisposalSystems(String isWasteDisposalSystems) {
        this.isWasteDisposalSystems = isWasteDisposalSystems;
    }

    public String getIsWasteDisposalSystemsRemarks() {
        return isWasteDisposalSystemsRemarks;
    }

    public void setIsWasteDisposalSystemsRemarks(String isWasteDisposalSystemsRemarks) {
        this.isWasteDisposalSystemsRemarks = isWasteDisposalSystemsRemarks;
    }

    public String getIsFireFightingEquipment() {
        return isFireFightingEquipment;
    }

    public void setIsFireFightingEquipment(String isFireFightingEquipment) {
        this.isFireFightingEquipment = isFireFightingEquipment;
    }

    public String getIsFireFightingEquipmentRemarks() {
        return isFireFightingEquipmentRemarks;
    }

    public void setIsFireFightingEquipmentRemarks(String isFireFightingEquipmentRemarks) {
        this.isFireFightingEquipmentRemarks = isFireFightingEquipmentRemarks;
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

    public String getIsWashingRoomsClean() {
        return isWashingRoomsClean;
    }

    public void setIsWashingRoomsClean(String isWashingRoomsClean) {
        this.isWashingRoomsClean = isWashingRoomsClean;
    }

    public String getIsWashingRoomsCleanRemarks() {
        return isWashingRoomsCleanRemarks;
    }

    public void setIsWashingRoomsCleanRemarks(String isWashingRoomsCleanRemarks) {
        this.isWashingRoomsCleanRemarks = isWashingRoomsCleanRemarks;
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

    public String getIsReturnsToCoffeeDirectorate() {
        return isReturnsToCoffeeDirectorate;
    }

    public void setIsReturnsToCoffeeDirectorate(String isReturnsToCoffeeDirectorate) {
        this.isReturnsToCoffeeDirectorate = isReturnsToCoffeeDirectorate;
    }

    public String getIsReturnsToCoffeeDirectorateRemarks() {
        return isReturnsToCoffeeDirectorateRemarks;
    }

    public void setIsReturnsToCoffeeDirectorateRemarks(String isReturnsToCoffeeDirectorateRemarks) {
        this.isReturnsToCoffeeDirectorateRemarks = isReturnsToCoffeeDirectorateRemarks;
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

    public String getIsCuppingFacilities() {
        return isCuppingFacilities;
    }

    public void setIsCuppingFacilities(String isCuppingFacilities) {
        this.isCuppingFacilities = isCuppingFacilities;
    }

    public String getIsCuppingFacilitiesRemarks() {
        return isCuppingFacilitiesRemarks;
    }

    public void setIsCuppingFacilitiesRemarks(String isCuppingFacilitiesRemarks) {
        this.isCuppingFacilitiesRemarks = isCuppingFacilitiesRemarks;
    }

    public String getIsOccupationalHealth() {
        return isOccupationalHealth;
    }

    public void setIsOccupationalHealth(String isOccupationalHealth) {
        this.isOccupationalHealth = isOccupationalHealth;
    }

    public String getIsOccupationalHealthRemarks() {
        return isOccupationalHealthRemarks;
    }

    public void setIsOccupationalHealthRemarks(String isOccupationalHealthRemarks) {
        this.isOccupationalHealthRemarks = isOccupationalHealthRemarks;
    }

    public String getIsPayementToGrowers() {
        return isPayementToGrowers;
    }

    public void setIsPayementToGrowers(String isPayementToGrowers) {
        this.isPayementToGrowers = isPayementToGrowers;
    }

    public String getIsPayementToGrowersRemarks() {
        return isPayementToGrowersRemarks;
    }

    public void setIsPayementToGrowersRemarks(String isPayementToGrowersRemarks) {
        this.isPayementToGrowersRemarks = isPayementToGrowersRemarks;
    }

    public String getIsStandardOutTurn() {
        return isStandardOutTurn;
    }

    public void setIsStandardOutTurn(String isStandardOutTurn) {
        this.isStandardOutTurn = isStandardOutTurn;
    }

    public String getIsStandardOutTurnRemarks() {
        return isStandardOutTurnRemarks;
    }

    public void setIsStandardOutTurnRemarks(String isStandardOutTurnRemarks) {
        this.isStandardOutTurnRemarks = isStandardOutTurnRemarks;
    }

    public String getIsStandardDirect() {
        return isStandardDirect;
    }

    public void setIsStandardDirect(String isStandardDirect) {
        this.isStandardDirect = isStandardDirect;
    }

    public String getIsStandardDirectRemarks() {
        return isStandardDirectRemarks;
    }

    public void setIsStandardDirectRemarks(String isStandardDirectRemarks) {
        this.isStandardDirectRemarks = isStandardDirectRemarks;
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
