package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import co.ke.bsl.util.CustomEditText;

@Entity
public class TeaBuyerImporterExporter {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int tea_buyer_exp_importer_id;
    private String documentNumber;
    private String documentDate;
    private String licenseNumber;
    private String applicantName;

    private String localID;
    private String isValidTbk;
    private String validTbkMarks;
    private String validTbkRemarks;
    private String isBusinessPermit;
    private String businessPermitMarks;
    private String businessPermitRemarks;
    private String isHealthCertificate;
    private String healthCertificateMarks;
    private String healthCertificateRemarks;
    private String isSubmissionOfMonthlyReturns;
    private String submissionOfMonthlyReturnsMarks;
    private String submissionOfMonthlyReturnsRemarks;
    private String isRegistrationOfExportsDone;
    private String registrationOfExportsDoneMarks;
    private String registrationOfExportsDoneRemarks;
    private String isRegistrationOfImportsDone;
    private String registrationOfImportsDoneMarks;
    private String registrationOfImportsDoneRemarks;
    private String isImportsAccompaniedByCoc;
    private String importsAccompaniedByCocMarks;
    private String importsAccompaniedByCocRemarks;
    private String isReexportOfImportedTea;
    private String reexportOfImportedTeaMarks;
    private String reexportOfImportedTeaRemarks;
    private String isReexportOrDestruction;
    private String reexportOrDestructionMarks;
    private String reexportOrDestructionRemarks;
    private String isExternalSiteStandards;
    private String externalSiteStandardsMarks;
    private String externalSiteStandardsRemarks;
    private String isSecurityAccessControl;
    private String securityAccessControlMarks;
    private String securityAccessControlRemarks;
    private String isLayoutProductFlow;
    private String layoutProductFlowMarks;
    private String layoutProductFlowRemarks;
    private String isWalls;
    private String wallsMarks;
    private String wallsRemarks;
    private String isFloors;
    private String floorsMarks;
    private String floorsRemarks;
    private String isRoofCeilingAndOverhead;
    private String roofCeilingAndOverheadMarks;
    private String roofCeilingAndOverheadRemarks;
    private String isWindows;
    private String windowsMarks;
    private String windowsRemarks;
    private String isDoors;
    private String doorsMarks;
    private String doorsRemarks;
    private String isAdequateLighting;
    private String adequateLightingMarks;
    private String adequateLightingRemarks;
    private String isVentilation;
    private String ventilationMarks;
    private String ventilationRemarks;
    private String isEquipmentCleanliness;
    private String equipmentCleanlinessMarks;
    private String equipmentCleanlinessRemarks;
    private String isChangingRoomsAndToilets;
    private String changingRoomsAndToiletsMarks;
    private String changingRoomsAndToiletsRemarks;
    private String isRiskOfContaminants;
    private String riskOfContaminantsMarks;
    private String riskOfContaminantsRemarks;
    private String isWasteTeasDisposal;
    private String wasteTeasDisposalMarks;
    private String wasteTeasDisposalRemarks;
    private String isPestControlPrograms;
    private String pestControlProgramsMarks;
    private String pestControlProgramsRemarks;
    private String isProperStorage;
    private String properStorageMarks;
    private String properStorageRemarks;
    private String isPackagingMaterial;
    private String packagingMaterialMarks;
    private String packagingMaterialRemarks;
    private String isNonConformingProduct;
    private String nonConformingProductMarks;
    private String nonConformingProductRemarks;
    private String isPalletsAreHeatTreated;
    private String palletsAreHeatTreatedMarks;
    private String palletsAreHeatTreatedRemarks;
    private String isTeaDispatchRecordsMaintained;
    private String teaDispatchRecordsMaintainedMarks;
    private String teaDispatchRecordsMaintainedRemarks;
    private String isEquipmentIdentification;
    private String equipmentIdentificationMarks;
    private String equipmentIdentificationRemarks;
    private String isTraceabilitySystem;
    private String traceabilitySystemMarks;
    private String traceabilitySystemRemarks;
    private String isFoodSafetyHazardsIdentified;
    private String foodSafetyHazardsIdentifiedMarks;
    private String foodSafetyHazardsIdentifiedRemarks;
    private String isCustomerFeedbackRecords;
    private String customerFeedbackRecordsMarks;
    private String customerFeedbackRecordsRemarks;
    private String isProcessDocumentsAndRecords;
    private String processDocumentsAndRecordsMarks;
    private String processDocumentsAndRecordsRemarks;
    private String isDocumentedPersonalHygiene;
    private String documentedPersonalHygieneMarks;
    private String documentedPersonalHygieneRemarks;
    private String isMedicalScreening;
    private String medicalScreeningMarks;
    private String medicalScreeningRemarks;
    private String isValidMedicalCertificate;
    private String validMedicalCertificateMarks;
    private String validMedicalCertificateRemarks;
    private String isAdequateAndCleanPersonal;
    private String adequateAndCleanPersonalMarks;
    private String adequateAndCleanPersonalRemarks;
    private String isValidCertificateOfRegistration;
    private String validCertificateOfRegistrationMarks;
    private String validCertificateOfRegistrationRemarks;
    private String isIncidentAndAccidentReports;
    private String incidentAndAccidentReportsMarks;
    private String incidentAndAccidentReportsRemarks;
    private String isFireEquipmentInspection;
    private String fireEquipmentInspectionMarks;
    private String fireEquipmentInspectionRemarks;
    private String isMarkedZonesFireExits;
    private String markedZonesFireExitsMarks;
    private String markedZonesFireExitsRemarks;
    private String isCompliancewithLabourRules;
    private String compliancewithLabourRulesMarks;
    private String compliancewithLabourRulesRemarks;
    private String isComplianceToOhsAct;
    private String complianceToOhsActMarks;
    private String complianceToOhsActRemarks;
    private String isCorrectionOfPreviousInspection;
    private String correctionOfPreviousInspectionMarks;
    private String correctionOfPreviousInspectionRemarks;
    private boolean is_synced;
    private String remote_id;
    
    
    

    public TeaBuyerImporterExporter(int tea_buyer_exp_importer_id, String documentNumber, String documentDate, String licenseNumber, String applicantName, String localID, String isValidTbk, String validTbkMarks, String validTbkRemarks, String isBusinessPermit, String businessPermitMarks, String businessPermitRemarks, String isHealthCertificate, String healthCertificateMarks, String healthCertificateRemarks, String isSubmissionOfMonthlyReturns, String submissionOfMonthlyReturnsMarks, String submissionOfMonthlyReturnsRemarks, String isRegistrationOfExportsDone, String registrationOfExportsDoneMarks, String registrationOfExportsDoneRemarks, String isRegistrationOfImportsDone, String registrationOfImportsDoneMarks, String registrationOfImportsDoneRemarks, String isImportsAccompaniedByCoc, String importsAccompaniedByCocMarks, String importsAccompaniedByCocRemarks, String isReexportOfImportedTea, String reexportOfImportedTeaMarks, String reexportOfImportedTeaRemarks, String isReexportOrDestruction, String reexportOrDestructionMarks, String reexportOrDestructionRemarks, String isExternalSiteStandards, String externalSiteStandardsMarks, String externalSiteStandardsRemarks, String isSecurityAccessControl, String securityAccessControlMarks, String securityAccessControlRemarks, String isLayoutProductFlow, String layoutProductFlowMarks, String layoutProductFlowRemarks, String isWalls, String wallsMarks, String wallsRemarks, String isFloors, String floorsMarks, String floorsRemarks, String isRoofCeilingAndOverhead, String roofCeilingAndOverheadMarks, String roofCeilingAndOverheadRemarks, String isWindows, String windowsMarks, String windowsRemarks, String isDoors, String doorsMarks, String doorsRemarks, String isAdequateLighting, String adequateLightingMarks, String adequateLightingRemarks, String isVentilation, String ventilationMarks, String ventilationRemarks, String isEquipmentCleanliness, String equipmentCleanlinessMarks, String equipmentCleanlinessRemarks, String isChangingRoomsAndToilets, String changingRoomsAndToiletsMarks, String changingRoomsAndToiletsRemarks, String isRiskOfContaminants, String riskOfContaminantsMarks, String riskOfContaminantsRemarks, String isWasteTeasDisposal, String wasteTeasDisposalMarks, String wasteTeasDisposalRemarks, String isPestControlPrograms, String pestControlProgramsMarks, String pestControlProgramsRemarks, String isProperStorage, String properStorageMarks, String properStorageRemarks, String isPackagingMaterial, String packagingMaterialMarks, String packagingMaterialRemarks, String isNonConformingProduct, String nonConformingProductMarks, String nonConformingProductRemarks, String isPalletsAreHeatTreated, String palletsAreHeatTreatedMarks, String palletsAreHeatTreatedRemarks, String isTeaDispatchRecordsMaintained, String teaDispatchRecordsMaintainedMarks, String teaDispatchRecordsMaintainedRemarks, String isEquipmentIdentification, String equipmentIdentificationMarks, String equipmentIdentificationRemarks, String isTraceabilitySystem, String traceabilitySystemMarks, String traceabilitySystemRemarks, String isFoodSafetyHazardsIdentified, String foodSafetyHazardsIdentifiedMarks, String foodSafetyHazardsIdentifiedRemarks, String isCustomerFeedbackRecords, String customerFeedbackRecordsMarks, String customerFeedbackRecordsRemarks, String isProcessDocumentsAndRecords, String processDocumentsAndRecordsMarks, String processDocumentsAndRecordsRemarks, String isDocumentedPersonalHygiene, String documentedPersonalHygieneMarks, String documentedPersonalHygieneRemarks, String isMedicalScreening, String medicalScreeningMarks, String medicalScreeningRemarks, String isValidMedicalCertificate, String validMedicalCertificateMarks, String validMedicalCertificateRemarks, String isAdequateAndCleanPersonal, String adequateAndCleanPersonalMarks, String adequateAndCleanPersonalRemarks, String isValidCertificateOfRegistration, String validCertificateOfRegistrationMarks, String validCertificateOfRegistrationRemarks, String isIncidentAndAccidentReports, String incidentAndAccidentReportsMarks, String incidentAndAccidentReportsRemarks, String isFireEquipmentInspection, String fireEquipmentInspectionMarks, String fireEquipmentInspectionRemarks, String isMarkedZonesFireExits, String markedZonesFireExitsMarks, String markedZonesFireExitsRemarks, String isCompliancewithLabourRules, String compliancewithLabourRulesMarks, String compliancewithLabourRulesRemarks, String isComplianceToOhsAct, String complianceToOhsActMarks, String complianceToOhsActRemarks, String isCorrectionOfPreviousInspection, String correctionOfPreviousInspectionMarks, String correctionOfPreviousInspectionRemarks, boolean is_synced, String remote_id) {
            this.tea_buyer_exp_importer_id = tea_buyer_exp_importer_id;
            this.documentNumber = documentNumber;
            this.documentDate = documentDate;
            this.licenseNumber = licenseNumber;
            this.applicantName = applicantName;

            this.localID = localID;

            this.isValidTbk = isValidTbk;
            this.validTbkMarks = validTbkMarks;
            this.validTbkRemarks = validTbkRemarks;
            this.isBusinessPermit = isBusinessPermit;
            this.businessPermitMarks = businessPermitMarks;
            this.businessPermitRemarks = businessPermitRemarks;
            this.isHealthCertificate = isHealthCertificate;
            this.healthCertificateMarks = healthCertificateMarks;
            this.healthCertificateRemarks = healthCertificateRemarks;
            this.isSubmissionOfMonthlyReturns = isSubmissionOfMonthlyReturns;
            this.submissionOfMonthlyReturnsMarks = submissionOfMonthlyReturnsMarks;
            this.submissionOfMonthlyReturnsRemarks = submissionOfMonthlyReturnsRemarks;
            this.isRegistrationOfExportsDone = isRegistrationOfExportsDone;
            this.registrationOfExportsDoneMarks = registrationOfExportsDoneMarks;
            this.registrationOfExportsDoneRemarks = registrationOfExportsDoneRemarks;
            this.isRegistrationOfImportsDone = isRegistrationOfImportsDone;
            this.registrationOfImportsDoneMarks = registrationOfImportsDoneMarks;
            this.registrationOfImportsDoneRemarks = registrationOfImportsDoneRemarks;
            this.isImportsAccompaniedByCoc = isImportsAccompaniedByCoc;
            this.importsAccompaniedByCocMarks = importsAccompaniedByCocMarks;
            this.importsAccompaniedByCocRemarks = importsAccompaniedByCocRemarks;
            this.isReexportOfImportedTea = isReexportOfImportedTea;
            this.reexportOfImportedTeaMarks = reexportOfImportedTeaMarks;
            this.reexportOfImportedTeaRemarks = reexportOfImportedTeaRemarks;
            this.isReexportOrDestruction = isReexportOrDestruction;
            this.reexportOrDestructionMarks = reexportOrDestructionMarks;
            this.reexportOrDestructionRemarks = reexportOrDestructionRemarks;
            this.isExternalSiteStandards = isExternalSiteStandards;
            this.externalSiteStandardsMarks = externalSiteStandardsMarks;
            this.externalSiteStandardsRemarks = externalSiteStandardsRemarks;
            this.isSecurityAccessControl = isSecurityAccessControl;
            this.securityAccessControlMarks = securityAccessControlMarks;
            this.securityAccessControlRemarks = securityAccessControlRemarks;
            this.isLayoutProductFlow = isLayoutProductFlow;
            this.layoutProductFlowMarks = layoutProductFlowMarks;
            this.layoutProductFlowRemarks = layoutProductFlowRemarks;
            this.isWalls = isWalls;
            this.wallsMarks = wallsMarks;
            this.wallsRemarks = wallsRemarks;
            this.isFloors = isFloors;
            this.floorsMarks = floorsMarks;
            this.floorsRemarks = floorsRemarks;
            this.isRoofCeilingAndOverhead = isRoofCeilingAndOverhead;
            this.roofCeilingAndOverheadMarks = roofCeilingAndOverheadMarks;
            this.roofCeilingAndOverheadRemarks = roofCeilingAndOverheadRemarks;
            this.isWindows = isWindows;
            this.windowsMarks = windowsMarks;
            this.windowsRemarks = windowsRemarks;
            this.isDoors = isDoors;
            this.doorsMarks = doorsMarks;
            this.doorsRemarks = doorsRemarks;
            this.isAdequateLighting = isAdequateLighting;
            this.adequateLightingMarks = adequateLightingMarks;
            this.adequateLightingRemarks = adequateLightingRemarks;
            this.isVentilation = isVentilation;
            this.ventilationMarks = ventilationMarks;
            this.ventilationRemarks = ventilationRemarks;
            this.isEquipmentCleanliness = isEquipmentCleanliness;
            this.equipmentCleanlinessMarks = equipmentCleanlinessMarks;
            this.equipmentCleanlinessRemarks = equipmentCleanlinessRemarks;
            this.isChangingRoomsAndToilets = isChangingRoomsAndToilets;
            this.changingRoomsAndToiletsMarks = changingRoomsAndToiletsMarks;
            this.changingRoomsAndToiletsRemarks = changingRoomsAndToiletsRemarks;
            this.isRiskOfContaminants = isRiskOfContaminants;
            this.riskOfContaminantsMarks = riskOfContaminantsMarks;
            this.riskOfContaminantsRemarks = riskOfContaminantsRemarks;
            this.isWasteTeasDisposal = isWasteTeasDisposal;
            this.wasteTeasDisposalMarks = wasteTeasDisposalMarks;
            this.wasteTeasDisposalRemarks = wasteTeasDisposalRemarks;
            this.isPestControlPrograms = isPestControlPrograms;
            this.pestControlProgramsMarks = pestControlProgramsMarks;
            this.pestControlProgramsRemarks = pestControlProgramsRemarks;
            this.isProperStorage = isProperStorage;
            this.properStorageMarks = properStorageMarks;
            this.properStorageRemarks = properStorageRemarks;
            this.isPackagingMaterial = isPackagingMaterial;
            this.packagingMaterialMarks = packagingMaterialMarks;
            this.packagingMaterialRemarks = packagingMaterialRemarks;
            this.isNonConformingProduct = isNonConformingProduct;
            this.nonConformingProductMarks = nonConformingProductMarks;
            this.nonConformingProductRemarks = nonConformingProductRemarks;
            this.isPalletsAreHeatTreated = isPalletsAreHeatTreated;
            this.palletsAreHeatTreatedMarks = palletsAreHeatTreatedMarks;
            this.palletsAreHeatTreatedRemarks = palletsAreHeatTreatedRemarks;
            this.isTeaDispatchRecordsMaintained = isTeaDispatchRecordsMaintained;
            this.teaDispatchRecordsMaintainedMarks = teaDispatchRecordsMaintainedMarks;
            this.teaDispatchRecordsMaintainedRemarks = teaDispatchRecordsMaintainedRemarks;
            this.isEquipmentIdentification = isEquipmentIdentification;
            this.equipmentIdentificationMarks = equipmentIdentificationMarks;
            this.equipmentIdentificationRemarks = equipmentIdentificationRemarks;
            this.isTraceabilitySystem = isTraceabilitySystem;
            this.traceabilitySystemMarks = traceabilitySystemMarks;
            this.traceabilitySystemRemarks = traceabilitySystemRemarks;
            this.isFoodSafetyHazardsIdentified = isFoodSafetyHazardsIdentified;
            this.foodSafetyHazardsIdentifiedMarks = foodSafetyHazardsIdentifiedMarks;
            this.foodSafetyHazardsIdentifiedRemarks = foodSafetyHazardsIdentifiedRemarks;
            this.isCustomerFeedbackRecords = isCustomerFeedbackRecords;
            this.customerFeedbackRecordsMarks = customerFeedbackRecordsMarks;
            this.customerFeedbackRecordsRemarks = customerFeedbackRecordsRemarks;
            this.isProcessDocumentsAndRecords = isProcessDocumentsAndRecords;
            this.processDocumentsAndRecordsMarks = processDocumentsAndRecordsMarks;
            this.processDocumentsAndRecordsRemarks = processDocumentsAndRecordsRemarks;
            this.isDocumentedPersonalHygiene = isDocumentedPersonalHygiene;
            this.documentedPersonalHygieneMarks = documentedPersonalHygieneMarks;
            this.documentedPersonalHygieneRemarks = documentedPersonalHygieneRemarks;
            this.isMedicalScreening = isMedicalScreening;
            this.medicalScreeningMarks = medicalScreeningMarks;
            this.medicalScreeningRemarks = medicalScreeningRemarks;
            this.isValidMedicalCertificate = isValidMedicalCertificate;
            this.validMedicalCertificateMarks = validMedicalCertificateMarks;
            this.validMedicalCertificateRemarks = validMedicalCertificateRemarks;
            this.isAdequateAndCleanPersonal = isAdequateAndCleanPersonal;
            this.adequateAndCleanPersonalMarks = adequateAndCleanPersonalMarks;
            this.adequateAndCleanPersonalRemarks = adequateAndCleanPersonalRemarks;
            this.isValidCertificateOfRegistration = isValidCertificateOfRegistration;
            this.validCertificateOfRegistrationMarks = validCertificateOfRegistrationMarks;
            this.validCertificateOfRegistrationRemarks = validCertificateOfRegistrationRemarks;
            this.isIncidentAndAccidentReports = isIncidentAndAccidentReports;
            this.incidentAndAccidentReportsMarks = incidentAndAccidentReportsMarks;
            this.incidentAndAccidentReportsRemarks = incidentAndAccidentReportsRemarks;
            this.isFireEquipmentInspection = isFireEquipmentInspection;
            this.fireEquipmentInspectionMarks = fireEquipmentInspectionMarks;
            this.fireEquipmentInspectionRemarks = fireEquipmentInspectionRemarks;
            this.isMarkedZonesFireExits = isMarkedZonesFireExits;
            this.markedZonesFireExitsMarks = markedZonesFireExitsMarks;
            this.markedZonesFireExitsRemarks = markedZonesFireExitsRemarks;
            this.isCompliancewithLabourRules = isCompliancewithLabourRules;
            this.compliancewithLabourRulesMarks = compliancewithLabourRulesMarks;
            this.compliancewithLabourRulesRemarks = compliancewithLabourRulesRemarks;
            this.isComplianceToOhsAct = isComplianceToOhsAct;
            this.complianceToOhsActMarks = complianceToOhsActMarks;
            this.complianceToOhsActRemarks = complianceToOhsActRemarks;
            this.isCorrectionOfPreviousInspection = isCorrectionOfPreviousInspection;
            this.correctionOfPreviousInspectionMarks = correctionOfPreviousInspectionMarks;
            this.correctionOfPreviousInspectionRemarks = correctionOfPreviousInspectionRemarks;
            this.is_synced = is_synced;
            this.remote_id = remote_id;
        }


        public String getLocalID() {
            return localID;
        }
        
        public void setLocalID(String localID) {
            this.localID = localID;
        }


        public int getTea_buyer_exp_importer_id() {
            return tea_buyer_exp_importer_id;
        }
        
        public void setTea_buyer_exp_importer_id(int tea_buyer_exp_importer_id) {
            this.tea_buyer_exp_importer_id = tea_buyer_exp_importer_id;
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
        
        public String getLicenseNumber() {
            return licenseNumber;
        }
        
        public void setLicenseNumber(String licenseNumber) {
            this.licenseNumber = licenseNumber;
        }
        
        public String getApplicantName() {
            return applicantName;
        }
        
        public void setApplicantName(String applicantName) {
            this.applicantName = applicantName;
        }
        
        public String getIsValidTbk() {
            return isValidTbk;
        }
        
        public void setIsValidTbk(String isValidTbk) {
            this.isValidTbk = isValidTbk;
        }
        
        public String getValidTbkMarks() {
            return validTbkMarks;
        }
        
        public void setValidTbkMarks(String validTbkMarks) {
            this.validTbkMarks = validTbkMarks;
        }
        
        public String getValidTbkRemarks() {
            return validTbkRemarks;
        }
        
        public void setValidTbkRemarks(String validTbkRemarks) {
            this.validTbkRemarks = validTbkRemarks;
        }
        
        public String getIsBusinessPermit() {
            return isBusinessPermit;
        }
        
        public void setIsBusinessPermit(String isBusinessPermit) {
            this.isBusinessPermit = isBusinessPermit;
        }
        
        public String getBusinessPermitMarks() {
            return businessPermitMarks;
        }
        
        public void setBusinessPermitMarks(String businessPermitMarks) {
            this.businessPermitMarks = businessPermitMarks;
        }
        
        public String getBusinessPermitRemarks() {
            return businessPermitRemarks;
        }
        
        public void setBusinessPermitRemarks(String businessPermitRemarks) {
            this.businessPermitRemarks = businessPermitRemarks;
        }
        
        public String getIsHealthCertificate() {
            return isHealthCertificate;
        }
        
        public void setIsHealthCertificate(String isHealthCertificate) {
            this.isHealthCertificate = isHealthCertificate;
        }
        
        public String getHealthCertificateMarks() {
            return healthCertificateMarks;
        }
        
        public void setHealthCertificateMarks(String healthCertificateMarks) {
            this.healthCertificateMarks = healthCertificateMarks;
        }
        
        public String getHealthCertificateRemarks() {
            return healthCertificateRemarks;
        }
        
        public void setHealthCertificateRemarks(String healthCertificateRemarks) {
            this.healthCertificateRemarks = healthCertificateRemarks;
        }
        
        public String getIsSubmissionOfMonthlyReturns() {
            return isSubmissionOfMonthlyReturns;
        }
        
        public void setIsSubmissionOfMonthlyReturns(String isSubmissionOfMonthlyReturns) {
            this.isSubmissionOfMonthlyReturns = isSubmissionOfMonthlyReturns;
        }
        
        public String getSubmissionOfMonthlyReturnsMarks() {
            return submissionOfMonthlyReturnsMarks;
        }
        
        public void setSubmissionOfMonthlyReturnsMarks(String submissionOfMonthlyReturnsMarks) {
            this.submissionOfMonthlyReturnsMarks = submissionOfMonthlyReturnsMarks;
        }
        
        public String getSubmissionOfMonthlyReturnsRemarks() {
            return submissionOfMonthlyReturnsRemarks;
        }
        
        public void setSubmissionOfMonthlyReturnsRemarks(String submissionOfMonthlyReturnsRemarks) {
            this.submissionOfMonthlyReturnsRemarks = submissionOfMonthlyReturnsRemarks;
        }
        
        public String getIsRegistrationOfExportsDone() {
            return isRegistrationOfExportsDone;
        }
        
        public void setIsRegistrationOfExportsDone(String isRegistrationOfExportsDone) {
            this.isRegistrationOfExportsDone = isRegistrationOfExportsDone;
        }
        
        public String getRegistrationOfExportsDoneMarks() {
            return registrationOfExportsDoneMarks;
        }
        
        public void setRegistrationOfExportsDoneMarks(String registrationOfExportsDoneMarks) {
            this.registrationOfExportsDoneMarks = registrationOfExportsDoneMarks;
        }
        
        public String getRegistrationOfExportsDoneRemarks() {
            return registrationOfExportsDoneRemarks;
        }
        
        public void setRegistrationOfExportsDoneRemarks(String registrationOfExportsDoneRemarks) {
            this.registrationOfExportsDoneRemarks = registrationOfExportsDoneRemarks;
        }
        
        public String getIsRegistrationOfImportsDone() {
            return isRegistrationOfImportsDone;
        }
        
        public void setIsRegistrationOfImportsDone(String isRegistrationOfImportsDone) {
            this.isRegistrationOfImportsDone = isRegistrationOfImportsDone;
        }
        
        public String getRegistrationOfImportsDoneMarks() {
            return registrationOfImportsDoneMarks;
        }
        
        public void setRegistrationOfImportsDoneMarks(String registrationOfImportsDoneMarks) {
            this.registrationOfImportsDoneMarks = registrationOfImportsDoneMarks;
        }
        
        public String getRegistrationOfImportsDoneRemarks() {
            return registrationOfImportsDoneRemarks;
        }
        
        public void setRegistrationOfImportsDoneRemarks(String registrationOfImportsDoneRemarks) {
            this.registrationOfImportsDoneRemarks = registrationOfImportsDoneRemarks;
        }
        
        public String getIsImportsAccompaniedByCoc() {
            return isImportsAccompaniedByCoc;
        }
        
        public void setIsImportsAccompaniedByCoc(String isImportsAccompaniedByCoc) {
            this.isImportsAccompaniedByCoc = isImportsAccompaniedByCoc;
        }
        
        public String getImportsAccompaniedByCocMarks() {
            return importsAccompaniedByCocMarks;
        }
        
        public void setImportsAccompaniedByCocMarks(String importsAccompaniedByCocMarks) {
            this.importsAccompaniedByCocMarks = importsAccompaniedByCocMarks;
        }
        
        public String getImportsAccompaniedByCocRemarks() {
            return importsAccompaniedByCocRemarks;
        }
        
        public void setImportsAccompaniedByCocRemarks(String importsAccompaniedByCocRemarks) {
            this.importsAccompaniedByCocRemarks = importsAccompaniedByCocRemarks;
        }
        
        public String getIsReexportOfImportedTea() {
            return isReexportOfImportedTea;
        }
        
        public void setIsReexportOfImportedTea(String isReexportOfImportedTea) {
            this.isReexportOfImportedTea = isReexportOfImportedTea;
        }
        
        public String getReexportOfImportedTeaMarks() {
            return reexportOfImportedTeaMarks;
        }
        
        public void setReexportOfImportedTeaMarks(String reexportOfImportedTeaMarks) {
            this.reexportOfImportedTeaMarks = reexportOfImportedTeaMarks;
        }
        
        public String getReexportOfImportedTeaRemarks() {
            return reexportOfImportedTeaRemarks;
        }
        
        public void setReexportOfImportedTeaRemarks(String reexportOfImportedTeaRemarks) {
            this.reexportOfImportedTeaRemarks = reexportOfImportedTeaRemarks;
        }
        
        public String getIsReexportOrDestruction() {
            return isReexportOrDestruction;
        }
        
        public void setIsReexportOrDestruction(String isReexportOrDestruction) {
            this.isReexportOrDestruction = isReexportOrDestruction;
        }
        
        public String getReexportOrDestructionMarks() {
            return reexportOrDestructionMarks;
        }
        
        public void setReexportOrDestructionMarks(String reexportOrDestructionMarks) {
            this.reexportOrDestructionMarks = reexportOrDestructionMarks;
        }
        
        public String getReexportOrDestructionRemarks() {
            return reexportOrDestructionRemarks;
        }
        
        public void setReexportOrDestructionRemarks(String reexportOrDestructionRemarks) {
            this.reexportOrDestructionRemarks = reexportOrDestructionRemarks;
        }
        
        public String getIsExternalSiteStandards() {
            return isExternalSiteStandards;
        }
        
        public void setIsExternalSiteStandards(String isExternalSiteStandards) {
            this.isExternalSiteStandards = isExternalSiteStandards;
        }
        
        public String getExternalSiteStandardsMarks() {
            return externalSiteStandardsMarks;
        }
        
        public void setExternalSiteStandardsMarks(String externalSiteStandardsMarks) {
            this.externalSiteStandardsMarks = externalSiteStandardsMarks;
        }
        
        public String getExternalSiteStandardsRemarks() {
            return externalSiteStandardsRemarks;
        }
        
        public void setExternalSiteStandardsRemarks(String externalSiteStandardsRemarks) {
            this.externalSiteStandardsRemarks = externalSiteStandardsRemarks;
        }
        
        public String getIsSecurityAccessControl() {
            return isSecurityAccessControl;
        }
        
        public void setIsSecurityAccessControl(String isSecurityAccessControl) {
            this.isSecurityAccessControl = isSecurityAccessControl;
        }
        
        public String getSecurityAccessControlMarks() {
            return securityAccessControlMarks;
        }
        
        public void setSecurityAccessControlMarks(String securityAccessControlMarks) {
            this.securityAccessControlMarks = securityAccessControlMarks;
        }
        
        public String getSecurityAccessControlRemarks() {
            return securityAccessControlRemarks;
        }
        
        public void setSecurityAccessControlRemarks(String securityAccessControlRemarks) {
            this.securityAccessControlRemarks = securityAccessControlRemarks;
        }
        
        public String getIsLayoutProductFlow() {
            return isLayoutProductFlow;
        }
        
        public void setIsLayoutProductFlow(String isLayoutProductFlow) {
            this.isLayoutProductFlow = isLayoutProductFlow;
        }
        
        public String getLayoutProductFlowMarks() {
            return layoutProductFlowMarks;
        }
        
        public void setLayoutProductFlowMarks(String layoutProductFlowMarks) {
            this.layoutProductFlowMarks = layoutProductFlowMarks;
        }
        
        public String getLayoutProductFlowRemarks() {
            return layoutProductFlowRemarks;
        }
        
        public void setLayoutProductFlowRemarks(String layoutProductFlowRemarks) {
            this.layoutProductFlowRemarks = layoutProductFlowRemarks;
        }
        
        public String getIsWalls() {
            return isWalls;
        }
        
        public void setIsWalls(String isWalls) {
            this.isWalls = isWalls;
        }
        
        public String getWallsMarks() {
            return wallsMarks;
        }
        
        public void setWallsMarks(String wallsMarks) {
            this.wallsMarks = wallsMarks;
        }
        
        public String getWallsRemarks() {
            return wallsRemarks;
        }
        
        public void setWallsRemarks(String wallsRemarks) {
            this.wallsRemarks = wallsRemarks;
        }
        
        public String getIsFloors() {
            return isFloors;
        }
        
        public void setIsFloors(String isFloors) {
            this.isFloors = isFloors;
        }
        
        public String getFloorsMarks() {
            return floorsMarks;
        }
        
        public void setFloorsMarks(String floorsMarks) {
            this.floorsMarks = floorsMarks;
        }
        
        public String getFloorsRemarks() {
            return floorsRemarks;
        }
        
        public void setFloorsRemarks(String floorsRemarks) {
            this.floorsRemarks = floorsRemarks;
        }
        
        public String getIsRoofCeilingAndOverhead() {
            return isRoofCeilingAndOverhead;
        }
        
        public void setIsRoofCeilingAndOverhead(String isRoofCeilingAndOverhead) {
            this.isRoofCeilingAndOverhead = isRoofCeilingAndOverhead;
        }
        
        public String getRoofCeilingAndOverheadMarks() {
            return roofCeilingAndOverheadMarks;
        }
        
        public void setRoofCeilingAndOverheadMarks(String roofCeilingAndOverheadMarks) {
            this.roofCeilingAndOverheadMarks = roofCeilingAndOverheadMarks;
        }
        
        public String getRoofCeilingAndOverheadRemarks() {
            return roofCeilingAndOverheadRemarks;
        }
        
        public void setRoofCeilingAndOverheadRemarks(String roofCeilingAndOverheadRemarks) {
            this.roofCeilingAndOverheadRemarks = roofCeilingAndOverheadRemarks;
        }
        
        public String getIsWindows() {
            return isWindows;
        }
        
        public void setIsWindows(String isWindows) {
            this.isWindows = isWindows;
        }
        
        public String getWindowsMarks() {
            return windowsMarks;
        }
        
        public void setWindowsMarks(String windowsMarks) {
            this.windowsMarks = windowsMarks;
        }
        
        public String getWindowsRemarks() {
            return windowsRemarks;
        }
        
        public void setWindowsRemarks(String windowsRemarks) {
            this.windowsRemarks = windowsRemarks;
        }
        
        public String getIsDoors() {
            return isDoors;
        }
        
        public void setIsDoors(String isDoors) {
            this.isDoors = isDoors;
        }
        
        public String getDoorsMarks() {
            return doorsMarks;
        }
        
        public void setDoorsMarks(String doorsMarks) {
            this.doorsMarks = doorsMarks;
        }
        
        public String getDoorsRemarks() {
            return doorsRemarks;
        }
        
        public void setDoorsRemarks(String doorsRemarks) {
            this.doorsRemarks = doorsRemarks;
        }
        
        public String getIsAdequateLighting() {
            return isAdequateLighting;
        }
        
        public void setIsAdequateLighting(String isAdequateLighting) {
            this.isAdequateLighting = isAdequateLighting;
        }
        
        public String getAdequateLightingMarks() {
            return adequateLightingMarks;
        }
        
        public void setAdequateLightingMarks(String adequateLightingMarks) {
            this.adequateLightingMarks = adequateLightingMarks;
        }
        
        public String getAdequateLightingRemarks() {
            return adequateLightingRemarks;
        }
        
        public void setAdequateLightingRemarks(String adequateLightingRemarks) {
            this.adequateLightingRemarks = adequateLightingRemarks;
        }
        
        public String getIsVentilation() {
            return isVentilation;
        }
        
        public void setIsVentilation(String isVentilation) {
            this.isVentilation = isVentilation;
        }
        
        public String getVentilationMarks() {
            return ventilationMarks;
        }
        
        public void setVentilationMarks(String ventilationMarks) {
            this.ventilationMarks = ventilationMarks;
        }
        
        public String getVentilationRemarks() {
            return ventilationRemarks;
        }
        
        public void setVentilationRemarks(String ventilationRemarks) {
            this.ventilationRemarks = ventilationRemarks;
        }
        
        public String getIsEquipmentCleanliness() {
            return isEquipmentCleanliness;
        }
        
        public void setIsEquipmentCleanliness(String isEquipmentCleanliness) {
            this.isEquipmentCleanliness = isEquipmentCleanliness;
        }
        
        public String getEquipmentCleanlinessMarks() {
            return equipmentCleanlinessMarks;
        }
        
        public void setEquipmentCleanlinessMarks(String equipmentCleanlinessMarks) {
            this.equipmentCleanlinessMarks = equipmentCleanlinessMarks;
        }
        
        public String getEquipmentCleanlinessRemarks() {
            return equipmentCleanlinessRemarks;
        }
        
        public void setEquipmentCleanlinessRemarks(String equipmentCleanlinessRemarks) {
            this.equipmentCleanlinessRemarks = equipmentCleanlinessRemarks;
        }
        
        public String getIsChangingRoomsAndToilets() {
            return isChangingRoomsAndToilets;
        }
        
        public void setIsChangingRoomsAndToilets(String isChangingRoomsAndToilets) {
            this.isChangingRoomsAndToilets = isChangingRoomsAndToilets;
        }
        
        public String getChangingRoomsAndToiletsMarks() {
            return changingRoomsAndToiletsMarks;
        }
        
        public void setChangingRoomsAndToiletsMarks(String changingRoomsAndToiletsMarks) {
            this.changingRoomsAndToiletsMarks = changingRoomsAndToiletsMarks;
        }
        
        public String getChangingRoomsAndToiletsRemarks() {
            return changingRoomsAndToiletsRemarks;
        }
        
        public void setChangingRoomsAndToiletsRemarks(String changingRoomsAndToiletsRemarks) {
            this.changingRoomsAndToiletsRemarks = changingRoomsAndToiletsRemarks;
        }
        
        public String getIsRiskOfContaminants() {
            return isRiskOfContaminants;
        }
        
        public void setIsRiskOfContaminants(String isRiskOfContaminants) {
            this.isRiskOfContaminants = isRiskOfContaminants;
        }
        
        public String getRiskOfContaminantsMarks() {
            return riskOfContaminantsMarks;
        }
        
        public void setRiskOfContaminantsMarks(String riskOfContaminantsMarks) {
            this.riskOfContaminantsMarks = riskOfContaminantsMarks;
        }
        
        public String getRiskOfContaminantsRemarks() {
            return riskOfContaminantsRemarks;
        }
        
        public void setRiskOfContaminantsRemarks(String riskOfContaminantsRemarks) {
            this.riskOfContaminantsRemarks = riskOfContaminantsRemarks;
        }
        
        public String getIsWasteTeasDisposal() {
            return isWasteTeasDisposal;
        }
        
        public void setIsWasteTeasDisposal(String isWasteTeasDisposal) {
            this.isWasteTeasDisposal = isWasteTeasDisposal;
        }
        
        public String getWasteTeasDisposalMarks() {
            return wasteTeasDisposalMarks;
        }
        
        public void setWasteTeasDisposalMarks(String wasteTeasDisposalMarks) {
            this.wasteTeasDisposalMarks = wasteTeasDisposalMarks;
        }
        
        public String getWasteTeasDisposalRemarks() {
            return wasteTeasDisposalRemarks;
        }
        
        public void setWasteTeasDisposalRemarks(String wasteTeasDisposalRemarks) {
            this.wasteTeasDisposalRemarks = wasteTeasDisposalRemarks;
        }
        
        public String getIsPestControlPrograms() {
            return isPestControlPrograms;
        }
        
        public void setIsPestControlPrograms(String isPestControlPrograms) {
            this.isPestControlPrograms = isPestControlPrograms;
        }
        
        public String getPestControlProgramsMarks() {
            return pestControlProgramsMarks;
        }
        
        public void setPestControlProgramsMarks(String pestControlProgramsMarks) {
            this.pestControlProgramsMarks = pestControlProgramsMarks;
        }
        
        public String getPestControlProgramsRemarks() {
            return pestControlProgramsRemarks;
        }
        
        public void setPestControlProgramsRemarks(String pestControlProgramsRemarks) {
            this.pestControlProgramsRemarks = pestControlProgramsRemarks;
        }
        
        public String getIsProperStorage() {
            return isProperStorage;
        }
        
        public void setIsProperStorage(String isProperStorage) {
            this.isProperStorage = isProperStorage;
        }
        
        public String getProperStorageMarks() {
            return properStorageMarks;
        }
        
        public void setProperStorageMarks(String properStorageMarks) {
            this.properStorageMarks = properStorageMarks;
        }
        
        public String getProperStorageRemarks() {
            return properStorageRemarks;
        }
        
        public void setProperStorageRemarks(String properStorageRemarks) {
            this.properStorageRemarks = properStorageRemarks;
        }
        
        public String getIsPackagingMaterial() {
            return isPackagingMaterial;
        }
        
        public void setIsPackagingMaterial(String isPackagingMaterial) {
            this.isPackagingMaterial = isPackagingMaterial;
        }
        
        public String getPackagingMaterialMarks() {
            return packagingMaterialMarks;
        }
        
        public void setPackagingMaterialMarks(String packagingMaterialMarks) {
            this.packagingMaterialMarks = packagingMaterialMarks;
        }
        
        public String getPackagingMaterialRemarks() {
            return packagingMaterialRemarks;
        }
        
        public void setPackagingMaterialRemarks(String packagingMaterialRemarks) {
            this.packagingMaterialRemarks = packagingMaterialRemarks;
        }
        
        public String getIsNonConformingProduct() {
            return isNonConformingProduct;
        }
        
        public void setIsNonConformingProduct(String isNonConformingProduct) {
            this.isNonConformingProduct = isNonConformingProduct;
        }
        
        public String getNonConformingProductMarks() {
            return nonConformingProductMarks;
        }
        
        public void setNonConformingProductMarks(String nonConformingProductMarks) {
            this.nonConformingProductMarks = nonConformingProductMarks;
        }
        
        public String getNonConformingProductRemarks() {
            return nonConformingProductRemarks;
        }
        
        public void setNonConformingProductRemarks(String nonConformingProductRemarks) {
            this.nonConformingProductRemarks = nonConformingProductRemarks;
        }
        
        public String getIsPalletsAreHeatTreated() {
            return isPalletsAreHeatTreated;
        }
        
        public void setIsPalletsAreHeatTreated(String isPalletsAreHeatTreated) {
            this.isPalletsAreHeatTreated = isPalletsAreHeatTreated;
        }
        
        public String getPalletsAreHeatTreatedMarks() {
            return palletsAreHeatTreatedMarks;
        }
        
        public void setPalletsAreHeatTreatedMarks(String palletsAreHeatTreatedMarks) {
            this.palletsAreHeatTreatedMarks = palletsAreHeatTreatedMarks;
        }
        
        public String getPalletsAreHeatTreatedRemarks() {
            return palletsAreHeatTreatedRemarks;
        }
        
        public void setPalletsAreHeatTreatedRemarks(String palletsAreHeatTreatedRemarks) {
            this.palletsAreHeatTreatedRemarks = palletsAreHeatTreatedRemarks;
        }
        
        public String getIsTeaDispatchRecordsMaintained() {
            return isTeaDispatchRecordsMaintained;
        }
        
        public void setIsTeaDispatchRecordsMaintained(String isTeaDispatchRecordsMaintained) {
            this.isTeaDispatchRecordsMaintained = isTeaDispatchRecordsMaintained;
        }
        
        public String getTeaDispatchRecordsMaintainedMarks() {
            return teaDispatchRecordsMaintainedMarks;
        }
        
        public void setTeaDispatchRecordsMaintainedMarks(String teaDispatchRecordsMaintainedMarks) {
            this.teaDispatchRecordsMaintainedMarks = teaDispatchRecordsMaintainedMarks;
        }
        
        public String getTeaDispatchRecordsMaintainedRemarks() {
            return teaDispatchRecordsMaintainedRemarks;
        }
        
        public void setTeaDispatchRecordsMaintainedRemarks(String teaDispatchRecordsMaintainedRemarks) {
            this.teaDispatchRecordsMaintainedRemarks = teaDispatchRecordsMaintainedRemarks;
        }
        
        public String getIsEquipmentIdentification() {
            return isEquipmentIdentification;
        }
        
        public void setIsEquipmentIdentification(String isEquipmentIdentification) {
            this.isEquipmentIdentification = isEquipmentIdentification;
        }
        
        public String getEquipmentIdentificationMarks() {
            return equipmentIdentificationMarks;
        }
        
        public void setEquipmentIdentificationMarks(String equipmentIdentificationMarks) {
            this.equipmentIdentificationMarks = equipmentIdentificationMarks;
        }
        
        public String getEquipmentIdentificationRemarks() {
            return equipmentIdentificationRemarks;
        }
        
        public void setEquipmentIdentificationRemarks(String equipmentIdentificationRemarks) {
            this.equipmentIdentificationRemarks = equipmentIdentificationRemarks;
        }
        
        public String getIsTraceabilitySystem() {
            return isTraceabilitySystem;
        }
        
        public void setIsTraceabilitySystem(String isTraceabilitySystem) {
            this.isTraceabilitySystem = isTraceabilitySystem;
        }
        
        public String getTraceabilitySystemMarks() {
            return traceabilitySystemMarks;
        }
        
        public void setTraceabilitySystemMarks(String traceabilitySystemMarks) {
            this.traceabilitySystemMarks = traceabilitySystemMarks;
        }
        
        public String getTraceabilitySystemRemarks() {
            return traceabilitySystemRemarks;
        }
        
        public void setTraceabilitySystemRemarks(String traceabilitySystemRemarks) {
            this.traceabilitySystemRemarks = traceabilitySystemRemarks;
        }
        
        public String getIsFoodSafetyHazardsIdentified() {
            return isFoodSafetyHazardsIdentified;
        }
        
        public void setIsFoodSafetyHazardsIdentified(String isFoodSafetyHazardsIdentified) {
            this.isFoodSafetyHazardsIdentified = isFoodSafetyHazardsIdentified;
        }
        
        public String getFoodSafetyHazardsIdentifiedMarks() {
            return foodSafetyHazardsIdentifiedMarks;
        }
        
        public void setFoodSafetyHazardsIdentifiedMarks(String foodSafetyHazardsIdentifiedMarks) {
            this.foodSafetyHazardsIdentifiedMarks = foodSafetyHazardsIdentifiedMarks;
        }
        
        public String getFoodSafetyHazardsIdentifiedRemarks() {
            return foodSafetyHazardsIdentifiedRemarks;
        }
        
        public void setFoodSafetyHazardsIdentifiedRemarks(String foodSafetyHazardsIdentifiedRemarks) {
            this.foodSafetyHazardsIdentifiedRemarks = foodSafetyHazardsIdentifiedRemarks;
        }
        
        public String getIsCustomerFeedbackRecords() {
            return isCustomerFeedbackRecords;
        }
        
        public void setIsCustomerFeedbackRecords(String isCustomerFeedbackRecords) {
            this.isCustomerFeedbackRecords = isCustomerFeedbackRecords;
        }
        
        public String getCustomerFeedbackRecordsMarks() {
            return customerFeedbackRecordsMarks;
        }
        
        public void setCustomerFeedbackRecordsMarks(String customerFeedbackRecordsMarks) {
            this.customerFeedbackRecordsMarks = customerFeedbackRecordsMarks;
        }
        
        public String getCustomerFeedbackRecordsRemarks() {
            return customerFeedbackRecordsRemarks;
        }
        
        public void setCustomerFeedbackRecordsRemarks(String customerFeedbackRecordsRemarks) {
            this.customerFeedbackRecordsRemarks = customerFeedbackRecordsRemarks;
        }
        
        public String getIsProcessDocumentsAndRecords() {
            return isProcessDocumentsAndRecords;
        }
        
        public void setIsProcessDocumentsAndRecords(String isProcessDocumentsAndRecords) {
            this.isProcessDocumentsAndRecords = isProcessDocumentsAndRecords;
        }
        
        public String getProcessDocumentsAndRecordsMarks() {
            return processDocumentsAndRecordsMarks;
        }
        
        public void setProcessDocumentsAndRecordsMarks(String processDocumentsAndRecordsMarks) {
            this.processDocumentsAndRecordsMarks = processDocumentsAndRecordsMarks;
        }
        
        public String getProcessDocumentsAndRecordsRemarks() {
            return processDocumentsAndRecordsRemarks;
        }
        
        public void setProcessDocumentsAndRecordsRemarks(String processDocumentsAndRecordsRemarks) {
            this.processDocumentsAndRecordsRemarks = processDocumentsAndRecordsRemarks;
        }
        
        public String getIsDocumentedPersonalHygiene() {
            return isDocumentedPersonalHygiene;
        }
        
        public void setIsDocumentedPersonalHygiene(String isDocumentedPersonalHygiene) {
            this.isDocumentedPersonalHygiene = isDocumentedPersonalHygiene;
        }
        
        public String getDocumentedPersonalHygieneMarks() {
            return documentedPersonalHygieneMarks;
        }
        
        public void setDocumentedPersonalHygieneMarks(String documentedPersonalHygieneMarks) {
            this.documentedPersonalHygieneMarks = documentedPersonalHygieneMarks;
        }
        
        public String getDocumentedPersonalHygieneRemarks() {
            return documentedPersonalHygieneRemarks;
        }
        
        public void setDocumentedPersonalHygieneRemarks(String documentedPersonalHygieneRemarks) {
            this.documentedPersonalHygieneRemarks = documentedPersonalHygieneRemarks;
        }
        
        public String getIsMedicalScreening() {
            return isMedicalScreening;
        }
        
        public void setIsMedicalScreening(String isMedicalScreening) {
            this.isMedicalScreening = isMedicalScreening;
        }
        
        public String getMedicalScreeningMarks() {
            return medicalScreeningMarks;
        }
        
        public void setMedicalScreeningMarks(String medicalScreeningMarks) {
            this.medicalScreeningMarks = medicalScreeningMarks;
        }
        
        public String getMedicalScreeningRemarks() {
            return medicalScreeningRemarks;
        }
        
        public void setMedicalScreeningRemarks(String medicalScreeningRemarks) {
            this.medicalScreeningRemarks = medicalScreeningRemarks;
        }
        
        public String getIsValidMedicalCertificate() {
            return isValidMedicalCertificate;
        }
        
        public void setIsValidMedicalCertificate(String isValidMedicalCertificate) {
            this.isValidMedicalCertificate = isValidMedicalCertificate;
        }
        
        public String getValidMedicalCertificateMarks() {
            return validMedicalCertificateMarks;
        }
        
        public void setValidMedicalCertificateMarks(String validMedicalCertificateMarks) {
            this.validMedicalCertificateMarks = validMedicalCertificateMarks;
        }
        
        public String getValidMedicalCertificateRemarks() {
            return validMedicalCertificateRemarks;
        }
        
        public void setValidMedicalCertificateRemarks(String validMedicalCertificateRemarks) {
            this.validMedicalCertificateRemarks = validMedicalCertificateRemarks;
        }
        
        public String getIsAdequateAndCleanPersonal() {
            return isAdequateAndCleanPersonal;
        }
        
        public void setIsAdequateAndCleanPersonal(String isAdequateAndCleanPersonal) {
            this.isAdequateAndCleanPersonal = isAdequateAndCleanPersonal;
        }
        
        public String getAdequateAndCleanPersonalMarks() {
            return adequateAndCleanPersonalMarks;
        }
        
        public void setAdequateAndCleanPersonalMarks(String adequateAndCleanPersonalMarks) {
            this.adequateAndCleanPersonalMarks = adequateAndCleanPersonalMarks;
        }
        
        public String getAdequateAndCleanPersonalRemarks() {
            return adequateAndCleanPersonalRemarks;
        }
        
        public void setAdequateAndCleanPersonalRemarks(String adequateAndCleanPersonalRemarks) {
            this.adequateAndCleanPersonalRemarks = adequateAndCleanPersonalRemarks;
        }
        
        public String getIsValidCertificateOfRegistration() {
            return isValidCertificateOfRegistration;
        }
        
        public void setIsValidCertificateOfRegistration(String isValidCertificateOfRegistration) {
            this.isValidCertificateOfRegistration = isValidCertificateOfRegistration;
        }
        
        public String getValidCertificateOfRegistrationMarks() {
            return validCertificateOfRegistrationMarks;
        }
        
        public void setValidCertificateOfRegistrationMarks(String validCertificateOfRegistrationMarks) {
            this.validCertificateOfRegistrationMarks = validCertificateOfRegistrationMarks;
        }
        
        public String getValidCertificateOfRegistrationRemarks() {
            return validCertificateOfRegistrationRemarks;
        }
        
        public void setValidCertificateOfRegistrationRemarks(String validCertificateOfRegistrationRemarks) {
            this.validCertificateOfRegistrationRemarks = validCertificateOfRegistrationRemarks;
        }
        
        public String getIsIncidentAndAccidentReports() {
            return isIncidentAndAccidentReports;
        }
        
        public void setIsIncidentAndAccidentReports(String isIncidentAndAccidentReports) {
            this.isIncidentAndAccidentReports = isIncidentAndAccidentReports;
        }
        
        public String getIncidentAndAccidentReportsMarks() {
            return incidentAndAccidentReportsMarks;
        }
        
        public void setIncidentAndAccidentReportsMarks(String incidentAndAccidentReportsMarks) {
            this.incidentAndAccidentReportsMarks = incidentAndAccidentReportsMarks;
        }
        
        public String getIncidentAndAccidentReportsRemarks() {
            return incidentAndAccidentReportsRemarks;
        }
        
        public void setIncidentAndAccidentReportsRemarks(String incidentAndAccidentReportsRemarks) {
            this.incidentAndAccidentReportsRemarks = incidentAndAccidentReportsRemarks;
        }
        
        public String getIsFireEquipmentInspection() {
            return isFireEquipmentInspection;
        }
        
        public void setIsFireEquipmentInspection(String isFireEquipmentInspection) {
            this.isFireEquipmentInspection = isFireEquipmentInspection;
        }
        
        public String getFireEquipmentInspectionMarks() {
            return fireEquipmentInspectionMarks;
        }
        
        public void setFireEquipmentInspectionMarks(String fireEquipmentInspectionMarks) {
            this.fireEquipmentInspectionMarks = fireEquipmentInspectionMarks;
        }
        
        public String getFireEquipmentInspectionRemarks() {
            return fireEquipmentInspectionRemarks;
        }
        
        public void setFireEquipmentInspectionRemarks(String fireEquipmentInspectionRemarks) {
            this.fireEquipmentInspectionRemarks = fireEquipmentInspectionRemarks;
        }
        
        public String getIsMarkedZonesFireExits() {
            return isMarkedZonesFireExits;
        }
        
        public void setIsMarkedZonesFireExits(String isMarkedZonesFireExits) {
            this.isMarkedZonesFireExits = isMarkedZonesFireExits;
        }
        
        public String getMarkedZonesFireExitsMarks() {
            return markedZonesFireExitsMarks;
        }
        
        public void setMarkedZonesFireExitsMarks(String markedZonesFireExitsMarks) {
            this.markedZonesFireExitsMarks = markedZonesFireExitsMarks;
        }
        
        public String getMarkedZonesFireExitsRemarks() {
            return markedZonesFireExitsRemarks;
        }
        
        public void setMarkedZonesFireExitsRemarks(String markedZonesFireExitsRemarks) {
            this.markedZonesFireExitsRemarks = markedZonesFireExitsRemarks;
        }
        
        public String getIsCompliancewithLabourRules() {
            return isCompliancewithLabourRules;
        }
        
        public void setIsCompliancewithLabourRules(String isCompliancewithLabourRules) {
            this.isCompliancewithLabourRules = isCompliancewithLabourRules;
        }
        
        public String getCompliancewithLabourRulesMarks() {
            return compliancewithLabourRulesMarks;
        }
        
        public void setCompliancewithLabourRulesMarks(String compliancewithLabourRulesMarks) {
            this.compliancewithLabourRulesMarks = compliancewithLabourRulesMarks;
        }
        
        public String getCompliancewithLabourRulesRemarks() {
            return compliancewithLabourRulesRemarks;
        }
        
        public void setCompliancewithLabourRulesRemarks(String compliancewithLabourRulesRemarks) {
            this.compliancewithLabourRulesRemarks = compliancewithLabourRulesRemarks;
        }
        
        public String getIsComplianceToOhsAct() {
            return isComplianceToOhsAct;
        }
        
        public void setIsComplianceToOhsAct(String isComplianceToOhsAct) {
            this.isComplianceToOhsAct = isComplianceToOhsAct;
        }
        
        public String getComplianceToOhsActMarks() {
            return complianceToOhsActMarks;
        }
        
        public void setComplianceToOhsActMarks(String complianceToOhsActMarks) {
            this.complianceToOhsActMarks = complianceToOhsActMarks;
        }
        
        public String getComplianceToOhsActRemarks() {
            return complianceToOhsActRemarks;
        }
        
        public void setComplianceToOhsActRemarks(String complianceToOhsActRemarks) {
            this.complianceToOhsActRemarks = complianceToOhsActRemarks;
        }
        
        public String getIsCorrectionOfPreviousInspection() {
            return isCorrectionOfPreviousInspection;
        }
        
        public void setIsCorrectionOfPreviousInspection(String isCorrectionOfPreviousInspection) {
            this.isCorrectionOfPreviousInspection = isCorrectionOfPreviousInspection;
        }
        
        public String getCorrectionOfPreviousInspectionMarks() {
            return correctionOfPreviousInspectionMarks;
        }
        
        public void setCorrectionOfPreviousInspectionMarks(String correctionOfPreviousInspectionMarks) {
            this.correctionOfPreviousInspectionMarks = correctionOfPreviousInspectionMarks;
        }
        
        public String getCorrectionOfPreviousInspectionRemarks() {
            return correctionOfPreviousInspectionRemarks;
        }
        
        public void setCorrectionOfPreviousInspectionRemarks(String correctionOfPreviousInspectionRemarks) {
            this.correctionOfPreviousInspectionRemarks = correctionOfPreviousInspectionRemarks;
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
