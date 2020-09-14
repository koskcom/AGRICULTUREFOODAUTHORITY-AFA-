package co.ke.bsl.data.view;

public class FoodProcessingBus {
    private static FoodProcessingBus single_instance = null;

    private FoodProcessingBus() {
    }

    public static FoodProcessingBus getInstance() {
        if (single_instance == null)
            single_instance = new FoodProcessingBus();

        return single_instance;
    }

    public static FoodProcessingBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(FoodProcessingBus single_instance) {
        FoodProcessingBus.single_instance = single_instance;
    }

    private String C_BPartner_ID;
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
