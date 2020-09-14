package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;
public class TeaPackerChecklist implements java.io.Serializable {

    private LoginRequest loginRequest;

    private String serviceType="QueryTeaPacker";

    private String AFA_TD_Inspection_Checklist_ID;
    private String documentNo;
    private String documentDate;
    private String applicantName;
    private String licenceNo;
    private String isCertCompanyReg;
    private String companyRegMandatory10mks;
    private String companyRegRemarks;
    private String isBusinessPermit;
    private String businessPermitMust3mks;
    private String businessPermitRemarks;
    private String isHealthCertificate;
    private String healthCertificateMandatory10mks;
    private String healthCertificateRemarks;
    private String isExternalSiteStandards;
    private String externalSiteStandardsMandatory10mks;
    private String externalSiteStandardsRemarks;
    private String isSecurityAccess;
    private String securityAccessReccomm;
    private String securityAccessRemarks;
    private String isLayoutCALIBRATION;
    private String layoutCALIBRATIONMust2mks;
    private String layoutCALIBRATIONRemarks;
    private String isWalls;
    private String wallsMust3mks;
    private String wallsRemarks;
    private String isFloors;
    private String floorsMust3mks;
    private String floorsRemarks;
    private String isRoofCeiling;
    private String roofCeilingMust3mks;
    private String roofCeilingRemarks;
    private String isWindows;
    private String windowsRecom1mk;
    private String windowsRemarks;
    private String isDoors;
    private String doorsRecom1mk;
    private String doorsRemarks;
    private String isAdequatelighting;
    private String adequateLightingMust3mks;
    private String adequateLightingRemarks;
    private String isVentilation;
    private String ventilationRecom1mks;
    private String ventilationRemarks;
    private String isEquipmentCleanliness;
    private String equipmentCleanlinessMust3mks;
    private String equipmentCleanlinessRemarks;
    private String isChangingrooms;
    private String changingroomsMust3mks;
    private String changingroomsRemarks;
    private String isRiskOfChemical;
    private String riskOfChemicalMust3mks;
    private String riskOfChemicalRemarks;
    private String isWasteTeaDisposal;
    private String wasteTeaDisposalMust3mks;
    private String wasteTeaDisposalRemarks;
    private String isPestControlProgram;
    private String pestControlProgramMust3mks;
    private String pestControlProgramRemarks;
    private String isProperStorage;
    private String properStorageRecom1mk;
    private String properStorageRemarks;
    private String isPackagingMaterialConfirmity;
    private String packagingMaterialConfirmityMust2mks;
    private String packagingMaterialConfirmityRemarks;
    private String isIdentificationAndSegregation;
    private String IdentificationAndSegregationMust2mks;
    private String IdentificationAndSegregationRemarks;
    private String isEquipmentIdentificationAndCalibration;
    private String EquipmentIdentificationAndCalibrationMust3mks;
    private String EquipmentIdentificationAndCalibrationRemarks;
    private String isTraceabilitySystem;
    private String traceabilitySystemMandatory10mks;
    private String traceabilitySystemRemarks;
    private String isProcessDocuments;
    private String processDocumentsMust3mks;
    private String processDocumentsRemarks;
    private String isValidMedicalCert;
    private String validMedicalCertMandatory10mks;
    private String validMedicalCertRemarks;
    private String isCleanPersonalProtective;
    private String cleanPersonalProtectiveMndatory10mks;
    private String cleanPersonalProtectiveRemarks;
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private String localID;


    public TeaPackerChecklist(String documentNo, String documentDate, String applicantName, String licenceNo) {
        this.documentNo = documentNo;
        this.documentDate = documentDate;
        this.applicantName = applicantName;
        this.licenceNo = licenceNo;
    }


    public TeaPackerChecklist() {
    }

    public String getAFA_TD_Inspection_Checklist_ID() {
        return AFA_TD_Inspection_Checklist_ID;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public void setAFA_TD_Inspection_Checklist_ID(String AFA_TD_Inspection_Checklist_ID) {
        this.AFA_TD_Inspection_Checklist_ID = AFA_TD_Inspection_Checklist_ID;
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

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
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

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getIsCertCompanyReg() {
        return isCertCompanyReg;
    }

    public void setIsCertCompanyReg(String isCertCompanyReg) {
        this.isCertCompanyReg = isCertCompanyReg;
    }

    public String getCompanyRegMandatory10mks() {
        return companyRegMandatory10mks;
    }

    public void setCompanyRegMandatory10mks(String companyRegMandatory10mks) {
        this.companyRegMandatory10mks = companyRegMandatory10mks;
    }

    public String getCompanyRegRemarks() {
        return companyRegRemarks;
    }

    public void setCompanyRegRemarks(String companyRegRemarks) {
        this.companyRegRemarks = companyRegRemarks;
    }

    public String getIsBusinessPermit() {
        return isBusinessPermit;
    }

    public void setIsBusinessPermit(String isBusinessPermit) {
        this.isBusinessPermit = isBusinessPermit;
    }

    public String getBusinessPermitMust3mks() {
        return businessPermitMust3mks;
    }

    public void setBusinessPermitMust3mks(String businessPermitMust3mks) {
        this.businessPermitMust3mks = businessPermitMust3mks;
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

    public String getHealthCertificateMandatory10mks() {
        return healthCertificateMandatory10mks;
    }

    public void setHealthCertificateMandatory10mks(String healthCertificateMandatory10mks) {
        this.healthCertificateMandatory10mks = healthCertificateMandatory10mks;
    }

    public String getHealthCertificateRemarks() {
        return healthCertificateRemarks;
    }

    public void setHealthCertificateRemarks(String healthCertificateRemarks) {
        this.healthCertificateRemarks = healthCertificateRemarks;
    }

    public String getIsExternalSiteStandards() {
        return isExternalSiteStandards;
    }

    public void setIsExternalSiteStandards(String isExternalSiteStandards) {
        this.isExternalSiteStandards = isExternalSiteStandards;
    }

    public String getExternalSiteStandardsMandatory10mks() {
        return externalSiteStandardsMandatory10mks;
    }

    public void setExternalSiteStandardsMandatory10mks(String externalSiteStandardsMandatory10mks) {
        this.externalSiteStandardsMandatory10mks = externalSiteStandardsMandatory10mks;
    }

    public String getExternalSiteStandardsRemarks() {
        return externalSiteStandardsRemarks;
    }

    public void setExternalSiteStandardsRemarks(String externalSiteStandardsRemarks) {
        this.externalSiteStandardsRemarks = externalSiteStandardsRemarks;
    }

    public String getIsSecurityAccess() {
        return isSecurityAccess;
    }

    public void setIsSecurityAccess(String isSecurityAccess) {
        this.isSecurityAccess = isSecurityAccess;
    }

    public String getSecurityAccessReccomm() {
        return securityAccessReccomm;
    }

    public void setSecurityAccessReccomm(String securityAccessReccomm) {
        this.securityAccessReccomm = securityAccessReccomm;
    }

    public String getSecurityAccessRemarks() {
        return securityAccessRemarks;
    }

    public void setSecurityAccessRemarks(String securityAccessRemarks) {
        this.securityAccessRemarks = securityAccessRemarks;
    }

    public String getIsLayoutCALIBRATION() {
        return isLayoutCALIBRATION;
    }

    public void setIsLayoutCALIBRATION(String isLayoutCALIBRATION) {
        this.isLayoutCALIBRATION = isLayoutCALIBRATION;
    }

    public String getLayoutCALIBRATIONMust2mks() {
        return layoutCALIBRATIONMust2mks;
    }

    public void setLayoutCALIBRATIONMust2mks(String layoutCALIBRATIONMust2mks) {
        this.layoutCALIBRATIONMust2mks = layoutCALIBRATIONMust2mks;
    }

    public String getLayoutCALIBRATIONRemarks() {
        return layoutCALIBRATIONRemarks;
    }

    public void setLayoutCALIBRATIONRemarks(String layoutCALIBRATIONRemarks) {
        this.layoutCALIBRATIONRemarks = layoutCALIBRATIONRemarks;
    }

    public String getIsWalls() {
        return isWalls;
    }

    public void setIsWalls(String isWalls) {
        this.isWalls = isWalls;
    }

    public String getWallsMust3mks() {
        return wallsMust3mks;
    }

    public void setWallsMust3mks(String wallsMust3mks) {
        this.wallsMust3mks = wallsMust3mks;
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

    public String getFloorsMust3mks() {
        return floorsMust3mks;
    }

    public void setFloorsMust3mks(String floorsMust3mks) {
        this.floorsMust3mks = floorsMust3mks;
    }

    public String getFloorsRemarks() {
        return floorsRemarks;
    }

    public void setFloorsRemarks(String floorsRemarks) {
        this.floorsRemarks = floorsRemarks;
    }

    public String getIsRoofCeiling() {
        return isRoofCeiling;
    }

    public void setIsRoofCeiling(String isRoofCeiling) {
        this.isRoofCeiling = isRoofCeiling;
    }

    public String getRoofCeilingMust3mks() {
        return roofCeilingMust3mks;
    }

    public void setRoofCeilingMust3mks(String roofCeilingMust3mks) {
        this.roofCeilingMust3mks = roofCeilingMust3mks;
    }

    public String getRoofCeilingRemarks() {
        return roofCeilingRemarks;
    }

    public void setRoofCeilingRemarks(String roofCeilingRemarks) {
        this.roofCeilingRemarks = roofCeilingRemarks;
    }

    public String getIsWindows() {
        return isWindows;
    }

    public void setIsWindows(String isWindows) {
        this.isWindows = isWindows;
    }

    public String getWindowsRecom1mk() {
        return windowsRecom1mk;
    }

    public void setWindowsRecom1mk(String windowsRecom1mk) {
        this.windowsRecom1mk = windowsRecom1mk;
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

    public String getDoorsRecom1mk() {
        return doorsRecom1mk;
    }

    public void setDoorsRecom1mk(String doorsRecom1mk) {
        this.doorsRecom1mk = doorsRecom1mk;
    }

    public String getDoorsRemarks() {
        return doorsRemarks;
    }

    public void setDoorsRemarks(String doorsRemarks) {
        this.doorsRemarks = doorsRemarks;
    }

    public String getIsAdequatelighting() {
        return isAdequatelighting;
    }

    public void setIsAdequatelighting(String isAdequatelighting) {
        this.isAdequatelighting = isAdequatelighting;
    }

    public String getAdequateLightingMust3mks() {
        return adequateLightingMust3mks;
    }

    public void setAdequateLightingMust3mks(String adequateLightingMust3mks) {
        this.adequateLightingMust3mks = adequateLightingMust3mks;
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

    public String getVentilationRecom1mks() {
        return ventilationRecom1mks;
    }

    public void setVentilationRecom1mks(String ventilationRecom1mks) {
        this.ventilationRecom1mks = ventilationRecom1mks;
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

    public String getEquipmentCleanlinessMust3mks() {
        return equipmentCleanlinessMust3mks;
    }

    public void setEquipmentCleanlinessMust3mks(String equipmentCleanlinessMust3mks) {
        this.equipmentCleanlinessMust3mks = equipmentCleanlinessMust3mks;
    }

    public String getEquipmentCleanlinessRemarks() {
        return equipmentCleanlinessRemarks;
    }

    public void setEquipmentCleanlinessRemarks(String equipmentCleanlinessRemarks) {
        this.equipmentCleanlinessRemarks = equipmentCleanlinessRemarks;
    }

    public String getIsChangingrooms() {
        return isChangingrooms;
    }

    public void setIsChangingrooms(String isChangingrooms) {
        this.isChangingrooms = isChangingrooms;
    }

    public String getChangingroomsMust3mks() {
        return changingroomsMust3mks;
    }

    public void setChangingroomsMust3mks(String changingroomsMust3mks) {
        this.changingroomsMust3mks = changingroomsMust3mks;
    }

    public String getChangingroomsRemarks() {
        return changingroomsRemarks;
    }

    public void setChangingroomsRemarks(String changingroomsRemarks) {
        this.changingroomsRemarks = changingroomsRemarks;
    }

    public String getIsRiskOfChemical() {
        return isRiskOfChemical;
    }

    public void setIsRiskOfChemical(String isRiskOfChemical) {
        this.isRiskOfChemical = isRiskOfChemical;
    }

    public String getRiskOfChemicalMust3mks() {
        return riskOfChemicalMust3mks;
    }

    public void setRiskOfChemicalMust3mks(String riskOfChemicalMust3mks) {
        this.riskOfChemicalMust3mks = riskOfChemicalMust3mks;
    }

    public String getRiskOfChemicalRemarks() {
        return riskOfChemicalRemarks;
    }

    public void setRiskOfChemicalRemarks(String riskOfChemicalRemarks) {
        this.riskOfChemicalRemarks = riskOfChemicalRemarks;
    }

    public String getIsWasteTeaDisposal() {
        return isWasteTeaDisposal;
    }

    public void setIsWasteTeaDisposal(String isWasteTeaDisposal) {
        this.isWasteTeaDisposal = isWasteTeaDisposal;
    }

    public String getWasteTeaDisposalMust3mks() {
        return wasteTeaDisposalMust3mks;
    }

    public void setWasteTeaDisposalMust3mks(String wasteTeaDisposalMust3mks) {
        this.wasteTeaDisposalMust3mks = wasteTeaDisposalMust3mks;
    }

    public String getWasteTeaDisposalRemarks() {
        return wasteTeaDisposalRemarks;
    }

    public void setWasteTeaDisposalRemarks(String wasteTeaDisposalRemarks) {
        this.wasteTeaDisposalRemarks = wasteTeaDisposalRemarks;
    }

    public String getIsPestControlProgram() {
        return isPestControlProgram;
    }

    public void setIsPestControlProgram(String isPestControlProgram) {
        this.isPestControlProgram = isPestControlProgram;
    }

    public String getPestControlProgramMust3mks() {
        return pestControlProgramMust3mks;
    }

    public void setPestControlProgramMust3mks(String pestControlProgramMust3mks) {
        this.pestControlProgramMust3mks = pestControlProgramMust3mks;
    }

    public String getPestControlProgramRemarks() {
        return pestControlProgramRemarks;
    }

    public void setPestControlProgramRemarks(String pestControlProgramRemarks) {
        this.pestControlProgramRemarks = pestControlProgramRemarks;
    }

    public String getIsProperStorage() {
        return isProperStorage;
    }

    public void setIsProperStorage(String isProperStorage) {
        this.isProperStorage = isProperStorage;
    }

    public String getProperStorageRecom1mk() {
        return properStorageRecom1mk;
    }

    public void setProperStorageRecom1mk(String properStorageRecom1mk) {
        this.properStorageRecom1mk = properStorageRecom1mk;
    }

    public String getProperStorageRemarks() {
        return properStorageRemarks;
    }

    public void setProperStorageRemarks(String properStorageRemarks) {
        this.properStorageRemarks = properStorageRemarks;
    }

    public String getIsPackagingMaterialConfirmity() {
        return isPackagingMaterialConfirmity;
    }

    public void setIsPackagingMaterialConfirmity(String isPackagingMaterialConfirmity) {
        this.isPackagingMaterialConfirmity = isPackagingMaterialConfirmity;
    }

    public String getPackagingMaterialConfirmityMust2mks() {
        return packagingMaterialConfirmityMust2mks;
    }

    public void setPackagingMaterialConfirmityMust2mks(String packagingMaterialConfirmityMust2mks) {
        this.packagingMaterialConfirmityMust2mks = packagingMaterialConfirmityMust2mks;
    }

    public String getPackagingMaterialConfirmityRemarks() {
        return packagingMaterialConfirmityRemarks;
    }

    public void setPackagingMaterialConfirmityRemarks(String packagingMaterialConfirmityRemarks) {
        this.packagingMaterialConfirmityRemarks = packagingMaterialConfirmityRemarks;
    }

    public String getIsIdentificationAndSegregation() {
        return isIdentificationAndSegregation;
    }

    public void setIsIdentificationAndSegregation(String isIdentificationAndSegregation) {
        this.isIdentificationAndSegregation = isIdentificationAndSegregation;
    }

    public String getIdentificationAndSegregationMust2mks() {
        return IdentificationAndSegregationMust2mks;
    }

    public void setIdentificationAndSegregationMust2mks(String IdentificationAndSegregationMust2mks) {
        this.IdentificationAndSegregationMust2mks = IdentificationAndSegregationMust2mks;
    }

    public String getIdentificationAndSegregationRemarks() {
        return IdentificationAndSegregationRemarks;
    }

    public void setIdentificationAndSegregationRemarks(String IdentificationAndSegregationRemarks) {
        this.IdentificationAndSegregationRemarks = IdentificationAndSegregationRemarks;
    }

    public String getEquipmentIdentificationAndCalibrationMust3mks() {
        return EquipmentIdentificationAndCalibrationMust3mks;
    }

    public void setEquipmentIdentificationAndCalibrationMust3mks(String EquipmentIdentificationAndCalibrationMust3mks) {
        this.EquipmentIdentificationAndCalibrationMust3mks = EquipmentIdentificationAndCalibrationMust3mks;
    }

    public String getEquipmentIdentificationAndCalibrationRemarks() {
        return EquipmentIdentificationAndCalibrationRemarks;
    }

    public void setEquipmentIdentificationAndCalibrationRemarks(String EquipmentIdentificationAndCalibrationRemarks) {
        this.EquipmentIdentificationAndCalibrationRemarks = EquipmentIdentificationAndCalibrationRemarks;
    }

    public String getIsTraceabilitySystem() {
        return isTraceabilitySystem;
    }

    public void setIsTraceabilitySystem(String isTraceabilitySystem) {
        this.isTraceabilitySystem = isTraceabilitySystem;
    }

    public String getTraceabilitySystemMandatory10mks() {
        return traceabilitySystemMandatory10mks;
    }

    public void setTraceabilitySystemMandatory10mks(String traceabilitySystemMandatory10mks) {
        this.traceabilitySystemMandatory10mks = traceabilitySystemMandatory10mks;
    }

    public String getTraceabilitySystemRemarks() {
        return traceabilitySystemRemarks;
    }

    public void setTraceabilitySystemRemarks(String traceabilitySystemRemarks) {
        this.traceabilitySystemRemarks = traceabilitySystemRemarks;
    }

    public String getIsProcessDocuments() {
        return isProcessDocuments;
    }

    public void setIsProcessDocuments(String isProcessDocuments) {
        this.isProcessDocuments = isProcessDocuments;
    }

    public String getProcessDocumentsMust3mks() {
        return processDocumentsMust3mks;
    }

    public void setProcessDocumentsMust3mks(String processDocumentsMust3mks) {
        this.processDocumentsMust3mks = processDocumentsMust3mks;
    }

    public String getProcessDocumentsRemarks() {
        return processDocumentsRemarks;
    }

    public void setProcessDocumentsRemarks(String processDocumentsRemarks) {
        this.processDocumentsRemarks = processDocumentsRemarks;
    }

    public String getIsValidMedicalCert() {
        return isValidMedicalCert;
    }

    public void setIsValidMedicalCert(String isValidMedicalCert) {
        this.isValidMedicalCert = isValidMedicalCert;
    }

    public String getValidMedicalCertMandatory10mks() {
        return validMedicalCertMandatory10mks;
    }

    public void setValidMedicalCertMandatory10mks(String validMedicalCertMandatory10mks) {
        this.validMedicalCertMandatory10mks = validMedicalCertMandatory10mks;
    }

    public String getValidMedicalCertRemarks() {
        return validMedicalCertRemarks;
    }

    public void setValidMedicalCertRemarks(String validMedicalCertRemarks) {
        this.validMedicalCertRemarks = validMedicalCertRemarks;
    }

    public String getIsCleanPersonalProtective() {
        return isCleanPersonalProtective;
    }

    public void setIsCleanPersonalProtective(String isCleanPersonalProtective) {
        this.isCleanPersonalProtective = isCleanPersonalProtective;
    }

    public String getCleanPersonalProtectiveMndatory10mks() {
        return cleanPersonalProtectiveMndatory10mks;
    }

    public void setCleanPersonalProtectiveMndatory10mks(String cleanPersonalProtectiveMndatory10mks) {
        this.cleanPersonalProtectiveMndatory10mks = cleanPersonalProtectiveMndatory10mks;
    }

    public String getCleanPersonalProtectiveRemarks() {
        return cleanPersonalProtectiveRemarks;
    }

    public void setCleanPersonalProtectiveRemarks(String cleanPersonalProtectiveRemarks) {
        this.cleanPersonalProtectiveRemarks = cleanPersonalProtectiveRemarks;
    }

    public String getIsEquipmentIdentificationAndCalibration() {
        return isEquipmentIdentificationAndCalibration;
    }

    public void setIsEquipmentIdentificationAndCalibration(String isEquipmentIdentificationAndCalibration) {
        this.isEquipmentIdentificationAndCalibration = isEquipmentIdentificationAndCalibration;
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
