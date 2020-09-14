package co.ke.bsl.data.view;

public class FCDSisalSpinningFactoryInspectionBus {
    private static FCDSisalSpinningFactoryInspectionBus single_instance = null;

    private FCDSisalSpinningFactoryInspectionBus() {
    }

    public static FCDSisalSpinningFactoryInspectionBus getInstance() {
        if (single_instance == null)
            single_instance = new FCDSisalSpinningFactoryInspectionBus();

        return single_instance;
    }

    public static FCDSisalSpinningFactoryInspectionBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(FCDSisalSpinningFactoryInspectionBus single_instance) {
        FCDSisalSpinningFactoryInspectionBus.single_instance = single_instance;
    }
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String sisalSpinningExportNumber;
    private String localID;
    private String isValidTradinglicence;
    private String validTradinglicenceRemarks;
    private String isValidNeMACerificaion;
    private String validNeMACerificaionRemarks;
    private String isFireriskAssessment;
    private String fireriskAssessmentRemarks;
    private String isOccupationalhealthReport;
    private String occupationalhealthReportRemarks;
    private String isFiremarshalls;
    private String firemarshallsRemarks;
    private String isAccessiblefireemergencyexits;
    private String accessibleFireemergencyexitsRemarks;
    private String isFirstAidkit;
    private String firstAidkitRemarks;
    private String isAppropriateprotectiveclothing;
    private String appropriateprotectiveclothing;
    private String isProtectedmovingParts;
    private String protectedmovingParts;
    private String isGeneralcondition;
    private String generalconditionRemarks;
    private String isStoragecondition;
    private String storageconditionRemarks;
    private String isProofofSubmission;
    private String proofofSubmission;
    private String isCertificationbyAFA;
    private String certificationbyAFARemarks;
    private String isFireengines;
    private String iswater;
    private String isCarbondioxide;
    private String issand;
    private String isfoam;
    private String isHydrantsystem;
    private String isDrypowder;
    private String etFirefightingRemarks;
    private String comments;
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private boolean is_synced;
    private String remote_id;

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

    public String getSisalSpinningExportNumber() {
        return sisalSpinningExportNumber;
    }

    public void setSisalSpinningExportNumber(String sisalSpinningExportNumber) {
        this.sisalSpinningExportNumber = sisalSpinningExportNumber;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getIsValidTradinglicence() {
        return isValidTradinglicence;
    }

    public void setIsValidTradinglicence(String isValidTradinglicence) {
        this.isValidTradinglicence = isValidTradinglicence;
    }

    public String getValidTradinglicenceRemarks() {
        return validTradinglicenceRemarks;
    }

    public void setValidTradinglicenceRemarks(String validTradinglicenceRemarks) {
        this.validTradinglicenceRemarks = validTradinglicenceRemarks;
    }

    public String getIsValidNeMACerificaion() {
        return isValidNeMACerificaion;
    }

    public void setIsValidNeMACerificaion(String isValidNeMACerificaion) {
        this.isValidNeMACerificaion = isValidNeMACerificaion;
    }

    public String getValidNeMACerificaionRemarks() {
        return validNeMACerificaionRemarks;
    }

    public void setValidNeMACerificaionRemarks(String validNeMACerificaionRemarks) {
        this.validNeMACerificaionRemarks = validNeMACerificaionRemarks;
    }

    public String getIsFireriskAssessment() {
        return isFireriskAssessment;
    }

    public void setIsFireriskAssessment(String isFireriskAssessment) {
        this.isFireriskAssessment = isFireriskAssessment;
    }

    public String getFireriskAssessmentRemarks() {
        return fireriskAssessmentRemarks;
    }

    public void setFireriskAssessmentRemarks(String fireriskAssessmentRemarks) {
        this.fireriskAssessmentRemarks = fireriskAssessmentRemarks;
    }

    public String getIsOccupationalhealthReport() {
        return isOccupationalhealthReport;
    }

    public void setIsOccupationalhealthReport(String isOccupationalhealthReport) {
        this.isOccupationalhealthReport = isOccupationalhealthReport;
    }

    public String getOccupationalhealthReportRemarks() {
        return occupationalhealthReportRemarks;
    }

    public void setOccupationalhealthReportRemarks(String occupationalhealthReportRemarks) {
        this.occupationalhealthReportRemarks = occupationalhealthReportRemarks;
    }

    public String getIsFiremarshalls() {
        return isFiremarshalls;
    }

    public void setIsFiremarshalls(String isFiremarshalls) {
        this.isFiremarshalls = isFiremarshalls;
    }

    public String getFiremarshallsRemarks() {
        return firemarshallsRemarks;
    }

    public void setFiremarshallsRemarks(String firemarshallsRemarks) {
        this.firemarshallsRemarks = firemarshallsRemarks;
    }

    public String getIsAccessiblefireemergencyexits() {
        return isAccessiblefireemergencyexits;
    }

    public void setIsAccessiblefireemergencyexits(String isAccessiblefireemergencyexits) {
        this.isAccessiblefireemergencyexits = isAccessiblefireemergencyexits;
    }

    public String getAccessibleFireemergencyexitsRemarks() {
        return accessibleFireemergencyexitsRemarks;
    }

    public void setAccessibleFireemergencyexitsRemarks(String accessibleFireemergencyexitsRemarks) {
        this.accessibleFireemergencyexitsRemarks = accessibleFireemergencyexitsRemarks;
    }

    public String getIsFirstAidkit() {
        return isFirstAidkit;
    }

    public void setIsFirstAidkit(String isFirstAidkit) {
        this.isFirstAidkit = isFirstAidkit;
    }

    public String getFirstAidkitRemarks() {
        return firstAidkitRemarks;
    }

    public void setFirstAidkitRemarks(String firstAidkitRemarks) {
        this.firstAidkitRemarks = firstAidkitRemarks;
    }

    public String getIsAppropriateprotectiveclothing() {
        return isAppropriateprotectiveclothing;
    }

    public void setIsAppropriateprotectiveclothing(String isAppropriateprotectiveclothing) {
        this.isAppropriateprotectiveclothing = isAppropriateprotectiveclothing;
    }

    public String getAppropriateprotectiveclothing() {
        return appropriateprotectiveclothing;
    }

    public void setAppropriateprotectiveclothing(String appropriateprotectiveclothing) {
        this.appropriateprotectiveclothing = appropriateprotectiveclothing;
    }

    public String getIsProtectedmovingParts() {
        return isProtectedmovingParts;
    }

    public void setIsProtectedmovingParts(String isProtectedmovingParts) {
        this.isProtectedmovingParts = isProtectedmovingParts;
    }

    public String getProtectedmovingParts() {
        return protectedmovingParts;
    }

    public void setProtectedmovingParts(String protectedmovingParts) {
        this.protectedmovingParts = protectedmovingParts;
    }

    public String getIsGeneralcondition() {
        return isGeneralcondition;
    }

    public void setIsGeneralcondition(String isGeneralcondition) {
        this.isGeneralcondition = isGeneralcondition;
    }

    public String getGeneralconditionRemarks() {
        return generalconditionRemarks;
    }

    public void setGeneralconditionRemarks(String generalconditionRemarks) {
        this.generalconditionRemarks = generalconditionRemarks;
    }

    public String getIsStoragecondition() {
        return isStoragecondition;
    }

    public void setIsStoragecondition(String isStoragecondition) {
        this.isStoragecondition = isStoragecondition;
    }

    public String getStorageconditionRemarks() {
        return storageconditionRemarks;
    }

    public void setStorageconditionRemarks(String storageconditionRemarks) {
        this.storageconditionRemarks = storageconditionRemarks;
    }

    public String getIsProofofSubmission() {
        return isProofofSubmission;
    }

    public void setIsProofofSubmission(String isProofofSubmission) {
        this.isProofofSubmission = isProofofSubmission;
    }

    public String getProofofSubmission() {
        return proofofSubmission;
    }

    public void setProofofSubmission(String proofofSubmission) {
        this.proofofSubmission = proofofSubmission;
    }

    public String getIsCertificationbyAFA() {
        return isCertificationbyAFA;
    }

    public void setIsCertificationbyAFA(String isCertificationbyAFA) {
        this.isCertificationbyAFA = isCertificationbyAFA;
    }

    public String getCertificationbyAFARemarks() {
        return certificationbyAFARemarks;
    }

    public void setCertificationbyAFARemarks(String certificationbyAFARemarks) {
        this.certificationbyAFARemarks = certificationbyAFARemarks;
    }

    public String getIsFireengines() {
        return isFireengines;
    }

    public void setIsFireengines(String isFireengines) {
        this.isFireengines = isFireengines;
    }

    public String getIswater() {
        return iswater;
    }

    public void setIswater(String iswater) {
        this.iswater = iswater;
    }

    public String getIsCarbondioxide() {
        return isCarbondioxide;
    }

    public void setIsCarbondioxide(String isCarbondioxide) {
        this.isCarbondioxide = isCarbondioxide;
    }

    public String getIssand() {
        return issand;
    }

    public void setIssand(String issand) {
        this.issand = issand;
    }

    public String getIsfoam() {
        return isfoam;
    }

    public void setIsfoam(String isfoam) {
        this.isfoam = isfoam;
    }

    public String getIsHydrantsystem() {
        return isHydrantsystem;
    }

    public void setIsHydrantsystem(String isHydrantsystem) {
        this.isHydrantsystem = isHydrantsystem;
    }

    public String getIsDrypowder() {
        return isDrypowder;
    }

    public void setIsDrypowder(String isDrypowder) {
        this.isDrypowder = isDrypowder;
    }

    public String getEtFirefightingRemarks() {
        return etFirefightingRemarks;
    }

    public void setEtFirefightingRemarks(String etFirefightingRemarks) {
        this.etFirefightingRemarks = etFirefightingRemarks;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
