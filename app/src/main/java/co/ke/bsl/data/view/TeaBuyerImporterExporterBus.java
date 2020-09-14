package co.ke.bsl.data.view;

public class TeaBuyerImporterExporterBus
{
    private static TeaBuyerImporterExporterBus single_instance = null;

    private TeaBuyerImporterExporterBus() {
    }

    public static TeaBuyerImporterExporterBus getInstance() {
        if (single_instance == null)
            single_instance = new TeaBuyerImporterExporterBus();

        return single_instance;
    }

    public static TeaBuyerImporterExporterBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(TeaBuyerImporterExporterBus single_instance) {
        TeaBuyerImporterExporterBus.single_instance = single_instance;
    }

    private String documentNumber;
    private String documentDate;
    private String licenseNumber;
    private String applicantName;

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
    private String documentStatus;

    private String localID;

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
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

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }
}
