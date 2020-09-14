package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FoodProcessing {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int food_processing_id;
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String foodCropManufacturingPlanApproval;
    private String localID;
    private String suppliers_source_raw_materials;
    private String installedCapacity;
    private String isLocationDesignconstructionStandards;
    private String locationDesignConstructionStandards_remarks;
    private String isProceduresforensuringPersonalhygieneareinplace;
    private String proceduresforensuringpersonalhygieneareinplace_remarks;
    private String isProceduresforReceivinghandlingandstorageareinplace;
    private String proceduresforreceivinghandlingandstorageareinplace_remarks;
    private String isMonitoringproceduresforPestcontroloftheareinplace;
    private String monitoringproceduresforpestcontroloftheareinplace_remarks;
    private String isCleaningandsanitizingProceduresinplace;
    private String cleaningandsanitizingproceduresinplace_remarks;
    private String isProceduresdescribingPreventivemaintenanceandcalibration;
    private String proceduresdescribingpreventivemaintenanceandcalibration_remarks;
    private String isRecallandTraceabilityprocedures;
    private String recallandtraceabilityprocedures_remarks;
    private String isWaterSafetymonitoringProcedures;
    private String waterSafetyMonitoringProcedures_remarks;
    private String recommendation;
    private String recommendationRemarks;
    private boolean is_synced;
    private String remote_id;

    public FoodProcessing(int food_processing_id, String documentNumber, String documentDate, String nameOfApplicant, String foodCropManufacturingPlanApproval, String localID, String suppliers_source_raw_materials, String installedCapacity, String isLocationDesignconstructionStandards, String locationDesignConstructionStandards_remarks, String isProceduresforensuringPersonalhygieneareinplace, String proceduresforensuringpersonalhygieneareinplace_remarks, String isProceduresforReceivinghandlingandstorageareinplace, String proceduresforreceivinghandlingandstorageareinplace_remarks, String isMonitoringproceduresforPestcontroloftheareinplace, String monitoringproceduresforpestcontroloftheareinplace_remarks, String isCleaningandsanitizingProceduresinplace, String cleaningandsanitizingproceduresinplace_remarks, String isProceduresdescribingPreventivemaintenanceandcalibration, String proceduresdescribingpreventivemaintenanceandcalibration_remarks, String isRecallandTraceabilityprocedures, String recallandtraceabilityprocedures_remarks, String isWaterSafetymonitoringProcedures, String waterSafetyMonitoringProcedures_remarks, String recommendation, String recommendationRemarks, boolean is_synced, String remote_id) {
        this.food_processing_id = food_processing_id;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.foodCropManufacturingPlanApproval = foodCropManufacturingPlanApproval;
        this.localID = localID;
        this.suppliers_source_raw_materials = suppliers_source_raw_materials;
        this.installedCapacity = installedCapacity;
        this.isLocationDesignconstructionStandards = isLocationDesignconstructionStandards;
        this.locationDesignConstructionStandards_remarks = locationDesignConstructionStandards_remarks;
        this.isProceduresforensuringPersonalhygieneareinplace = isProceduresforensuringPersonalhygieneareinplace;
        this.proceduresforensuringpersonalhygieneareinplace_remarks = proceduresforensuringpersonalhygieneareinplace_remarks;
        this.isProceduresforReceivinghandlingandstorageareinplace = isProceduresforReceivinghandlingandstorageareinplace;
        this.proceduresforreceivinghandlingandstorageareinplace_remarks = proceduresforreceivinghandlingandstorageareinplace_remarks;
        this.isMonitoringproceduresforPestcontroloftheareinplace = isMonitoringproceduresforPestcontroloftheareinplace;
        this.monitoringproceduresforpestcontroloftheareinplace_remarks = monitoringproceduresforpestcontroloftheareinplace_remarks;
        this.isCleaningandsanitizingProceduresinplace = isCleaningandsanitizingProceduresinplace;
        this.cleaningandsanitizingproceduresinplace_remarks = cleaningandsanitizingproceduresinplace_remarks;
        this.isProceduresdescribingPreventivemaintenanceandcalibration = isProceduresdescribingPreventivemaintenanceandcalibration;
        this.proceduresdescribingpreventivemaintenanceandcalibration_remarks = proceduresdescribingpreventivemaintenanceandcalibration_remarks;
        this.isRecallandTraceabilityprocedures = isRecallandTraceabilityprocedures;
        this.recallandtraceabilityprocedures_remarks = recallandtraceabilityprocedures_remarks;
        this.isWaterSafetymonitoringProcedures = isWaterSafetymonitoringProcedures;
        this.waterSafetyMonitoringProcedures_remarks = waterSafetyMonitoringProcedures_remarks;
        this.recommendation = recommendation;
        this.recommendationRemarks = recommendationRemarks;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }
    
    public int getFood_processing_id() {
        return food_processing_id;
    }

    public void setFood_processing_id(int food_processing_id) {
        this.food_processing_id = food_processing_id;
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

    public String getFoodCropManufacturingPlanApproval() {
        return foodCropManufacturingPlanApproval;
    }

    public void setFoodCropManufacturingPlanApproval(String foodCropManufacturingPlanApproval) {
        this.foodCropManufacturingPlanApproval = foodCropManufacturingPlanApproval;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getSuppliers_source_raw_materials() {
        return suppliers_source_raw_materials;
    }

    public void setSuppliers_source_raw_materials(String suppliers_source_raw_materials) {
        this.suppliers_source_raw_materials = suppliers_source_raw_materials;
    }

    public String getInstalledCapacity() {
        return installedCapacity;
    }

    public void setInstalledCapacity(String installedCapacity) {
        this.installedCapacity = installedCapacity;
    }

    public String getIsLocationDesignconstructionStandards() {
        return isLocationDesignconstructionStandards;
    }

    public void setIsLocationDesignconstructionStandards(String isLocationDesignconstructionStandards) {
        this.isLocationDesignconstructionStandards = isLocationDesignconstructionStandards;
    }

    public String getLocationDesignConstructionStandards_remarks() {
        return locationDesignConstructionStandards_remarks;
    }

    public void setLocationDesignConstructionStandards_remarks(String locationDesignConstructionStandards_remarks) {
        this.locationDesignConstructionStandards_remarks = locationDesignConstructionStandards_remarks;
    }

    public String getIsProceduresforensuringPersonalhygieneareinplace() {
        return isProceduresforensuringPersonalhygieneareinplace;
    }

    public void setIsProceduresforensuringPersonalhygieneareinplace(String isProceduresforensuringPersonalhygieneareinplace) {
        this.isProceduresforensuringPersonalhygieneareinplace = isProceduresforensuringPersonalhygieneareinplace;
    }

    public String getProceduresforensuringpersonalhygieneareinplace_remarks() {
        return proceduresforensuringpersonalhygieneareinplace_remarks;
    }

    public void setProceduresforensuringpersonalhygieneareinplace_remarks(String proceduresforensuringpersonalhygieneareinplace_remarks) {
        this.proceduresforensuringpersonalhygieneareinplace_remarks = proceduresforensuringpersonalhygieneareinplace_remarks;
    }

    public String getIsProceduresforReceivinghandlingandstorageareinplace() {
        return isProceduresforReceivinghandlingandstorageareinplace;
    }

    public void setIsProceduresforReceivinghandlingandstorageareinplace(String isProceduresforReceivinghandlingandstorageareinplace) {
        this.isProceduresforReceivinghandlingandstorageareinplace = isProceduresforReceivinghandlingandstorageareinplace;
    }

    public String getProceduresforreceivinghandlingandstorageareinplace_remarks() {
        return proceduresforreceivinghandlingandstorageareinplace_remarks;
    }

    public void setProceduresforreceivinghandlingandstorageareinplace_remarks(String proceduresforreceivinghandlingandstorageareinplace_remarks) {
        this.proceduresforreceivinghandlingandstorageareinplace_remarks = proceduresforreceivinghandlingandstorageareinplace_remarks;
    }

    public String getIsMonitoringproceduresforPestcontroloftheareinplace() {
        return isMonitoringproceduresforPestcontroloftheareinplace;
    }

    public void setIsMonitoringproceduresforPestcontroloftheareinplace(String isMonitoringproceduresforPestcontroloftheareinplace) {
        this.isMonitoringproceduresforPestcontroloftheareinplace = isMonitoringproceduresforPestcontroloftheareinplace;
    }

    public String getMonitoringproceduresforpestcontroloftheareinplace_remarks() {
        return monitoringproceduresforpestcontroloftheareinplace_remarks;
    }

    public void setMonitoringproceduresforpestcontroloftheareinplace_remarks(String monitoringproceduresforpestcontroloftheareinplace_remarks) {
        this.monitoringproceduresforpestcontroloftheareinplace_remarks = monitoringproceduresforpestcontroloftheareinplace_remarks;
    }

    public String getIsCleaningandsanitizingProceduresinplace() {
        return isCleaningandsanitizingProceduresinplace;
    }

    public void setIsCleaningandsanitizingProceduresinplace(String isCleaningandsanitizingProceduresinplace) {
        this.isCleaningandsanitizingProceduresinplace = isCleaningandsanitizingProceduresinplace;
    }

    public String getCleaningandsanitizingproceduresinplace_remarks() {
        return cleaningandsanitizingproceduresinplace_remarks;
    }

    public void setCleaningandsanitizingproceduresinplace_remarks(String cleaningandsanitizingproceduresinplace_remarks) {
        this.cleaningandsanitizingproceduresinplace_remarks = cleaningandsanitizingproceduresinplace_remarks;
    }

    public String getIsProceduresdescribingPreventivemaintenanceandcalibration() {
        return isProceduresdescribingPreventivemaintenanceandcalibration;
    }

    public void setIsProceduresdescribingPreventivemaintenanceandcalibration(String isProceduresdescribingPreventivemaintenanceandcalibration) {
        this.isProceduresdescribingPreventivemaintenanceandcalibration = isProceduresdescribingPreventivemaintenanceandcalibration;
    }

    public String getProceduresdescribingpreventivemaintenanceandcalibration_remarks() {
        return proceduresdescribingpreventivemaintenanceandcalibration_remarks;
    }

    public void setProceduresdescribingpreventivemaintenanceandcalibration_remarks(String proceduresdescribingpreventivemaintenanceandcalibration_remarks) {
        this.proceduresdescribingpreventivemaintenanceandcalibration_remarks = proceduresdescribingpreventivemaintenanceandcalibration_remarks;
    }

    public String getIsRecallandTraceabilityprocedures() {
        return isRecallandTraceabilityprocedures;
    }

    public void setIsRecallandTraceabilityprocedures(String isRecallandTraceabilityprocedures) {
        this.isRecallandTraceabilityprocedures = isRecallandTraceabilityprocedures;
    }

    public String getRecallandtraceabilityprocedures_remarks() {
        return recallandtraceabilityprocedures_remarks;
    }

    public void setRecallandtraceabilityprocedures_remarks(String recallandtraceabilityprocedures_remarks) {
        this.recallandtraceabilityprocedures_remarks = recallandtraceabilityprocedures_remarks;
    }

    public String getIsWaterSafetymonitoringProcedures() {
        return isWaterSafetymonitoringProcedures;
    }

    public void setIsWaterSafetymonitoringProcedures(String isWaterSafetymonitoringProcedures) {
        this.isWaterSafetymonitoringProcedures = isWaterSafetymonitoringProcedures;
    }

    public String getWaterSafetyMonitoringProcedures_remarks() {
        return waterSafetyMonitoringProcedures_remarks;
    }

    public void setWaterSafetyMonitoringProcedures_remarks(String waterSafetyMonitoringProcedures_remarks) {
        this.waterSafetyMonitoringProcedures_remarks = waterSafetyMonitoringProcedures_remarks;
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
}
