package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

import java.io.Serializable;

public class HorticulturalFlowerExportersDeskVettingDetails implements Serializable {

    private LoginRequest loginRequest;

    private String serviceType="QueryHorticulturalFlowerExportersDeskVetting";

    private String sentStatus;

    private  String AFA_HC_flower_Exptchcklst_ID;

    private String C_BPartner_ID;

    private String document_number;
    private String document_date;
    private String name_of_applicant;
    private String export_licence;
    private String localID;

    private String isCertificationToKS;
    private String certificationToKSAward;
    private String certificationToKSTimeline;
    private String certificationToKSRemarks;
    private String isRecognisedStandards;
    private String recognisedStandardsAward;
    private String recognisedStandardsTimeline;
    private String recognisedStandardsRemarks;
    private String isEvidenceOfRegistrationNational;
    private String evidenceOfRegistrationNationalAward;
    private String evidenceOfRegistrationNationalTimeline;
    private String evidenceOfRegistrationNationalRemarks;
    private String isEvidenceOfRegistrationSingle;
    private String evidenceOfRegistrationSingleAward;
    private String evidenceOfRegistrationSingleTimeline;
    private String evidenceOfRegistrationSingleRemarks;
    private String isEvidenceOfSafeDisposal;
    private String evidenceOfSafeDisposalAward;
    private String evidenceOfSafeDisposalTimeline;
    private String evidenceOfSafeDisposalRemarks;
    private String isEvidenceOfWorkerProtection;
    private String evidenceOfWorkerProtectionAward;
    private String evidenceOfWorkerProtectionTimeline;
    private String evidenceOfWorkerProtectionRemarks;
    private String isCopyOfHCD;
    private String copyOfHCDAward;
    private String copyOfHCDTimeline;
    private String copyOfHCDRemarks;
    private String isTraceabilityList;
    private String traceabilityListAward;
    private String traceabilityListTimeline;
    private String traceabilityListRemarks;
    private String isDeclareMarkettingAgents;
    private String declareMarkettingAgentsAward;
    private String declareMarkettingAgentsTimeline;
    private String declareMarkettingAgentsRemarks;
    private String isEvidenceOfTraceabilitySystems;
    private String evidenceOfTraceabilitySystemsAward;
    private String evidenceOfTraceabilitySystemsTimeline;
    private String evidenceOfTraceabilitySystemsRemarks;
    private String isEvidenceOfAttendance;
    private String evidenceOfAttendanceAward;
    private String evidenceOfAttendanceTimeline;
    private String evidenceOfAttendanceRemarks;
    private String isAnnualTrainingMatrix;
    private String annualTrainingMatrixAward;
    private String annualTrainingMatrixTimeline;
    private String annualTrainingMatrixRemarks;
    private String isEvidenceOfPests;
    private String evidenceOfPestsAward;
    private String evidenceOfPestsTimeline;
    private String evidenceOfPestsRemarks;
    private String isClaim;
    private String claimAward;
    private String claimTimeline;
    private String claimRemarks;
    private String isUtilizationOfHCD;
    private String utilizationOfHCDAward;
    private String utilizationOfHCDTimeline;
    private String utilizationOfHCDRemarks;
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private String documentStatus;
    private String approvalStage;

    private String serverRecordID;

    private String horticulturalFlowerExportersDeskVettingID;

    public HorticulturalFlowerExportersDeskVettingDetails() {
    }

    public HorticulturalFlowerExportersDeskVettingDetails(String document_number, String document_date, String name_of_applicant, String export_licence) {
        this.document_number = document_number;
        this.document_date = document_date;
        this.name_of_applicant = name_of_applicant;
        this.export_licence = export_licence;
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

    public String getAFA_HC_flower_Exptchcklst_ID() {
        return AFA_HC_flower_Exptchcklst_ID;
    }

    public void setAFA_HC_flower_Exptchcklst_ID(String AFA_HC_flower_Exptchcklst_ID) {
        this.AFA_HC_flower_Exptchcklst_ID = AFA_HC_flower_Exptchcklst_ID;
    }

    public String getC_BPartner_ID() {
        return C_BPartner_ID;
    }

    public void setC_BPartner_ID(String c_BPartner_ID) {
        C_BPartner_ID = c_BPartner_ID;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public String getDocument_date() {
        return document_date;
    }

    public void setDocument_date(String document_date) {
        this.document_date = document_date;
    }

    public String getName_of_applicant() {
        return name_of_applicant;
    }

    public void setName_of_applicant(String name_of_applicant) {
        this.name_of_applicant = name_of_applicant;
    }

    public String getExport_licence() {
        return export_licence;
    }

    public void setExport_licence(String export_licence) {
        this.export_licence = export_licence;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getIsCertificationToKS() {
        return isCertificationToKS;
    }

    public void setIsCertificationToKS(String isCertificationToKS) {
        this.isCertificationToKS = isCertificationToKS;
    }

    public String getCertificationToKSAward() {
        return certificationToKSAward;
    }

    public void setCertificationToKSAward(String certificationToKSAward) {
        this.certificationToKSAward = certificationToKSAward;
    }

    public String getCertificationToKSTimeline() {
        return certificationToKSTimeline;
    }

    public void setCertificationToKSTimeline(String certificationToKSTimeline) {
        this.certificationToKSTimeline = certificationToKSTimeline;
    }

    public String getCertificationToKSRemarks() {
        return certificationToKSRemarks;
    }

    public void setCertificationToKSRemarks(String certificationToKSRemarks) {
        this.certificationToKSRemarks = certificationToKSRemarks;
    }

    public String getIsRecognisedStandards() {
        return isRecognisedStandards;
    }

    public void setIsRecognisedStandards(String isRecognisedStandards) {
        this.isRecognisedStandards = isRecognisedStandards;
    }

    public String getRecognisedStandardsAward() {
        return recognisedStandardsAward;
    }

    public void setRecognisedStandardsAward(String recognisedStandardsAward) {
        this.recognisedStandardsAward = recognisedStandardsAward;
    }

    public String getRecognisedStandardsTimeline() {
        return recognisedStandardsTimeline;
    }

    public void setRecognisedStandardsTimeline(String recognisedStandardsTimeline) {
        this.recognisedStandardsTimeline = recognisedStandardsTimeline;
    }

    public String getRecognisedStandardsRemarks() {
        return recognisedStandardsRemarks;
    }

    public void setRecognisedStandardsRemarks(String recognisedStandardsRemarks) {
        this.recognisedStandardsRemarks = recognisedStandardsRemarks;
    }

    public String getIsEvidenceOfRegistrationNational() {
        return isEvidenceOfRegistrationNational;
    }

    public void setIsEvidenceOfRegistrationNational(String isEvidenceOfRegistrationNational) {
        this.isEvidenceOfRegistrationNational = isEvidenceOfRegistrationNational;
    }

    public String getEvidenceOfRegistrationNationalAward() {
        return evidenceOfRegistrationNationalAward;
    }

    public void setEvidenceOfRegistrationNationalAward(String evidenceOfRegistrationNationalAward) {
        this.evidenceOfRegistrationNationalAward = evidenceOfRegistrationNationalAward;
    }

    public String getEvidenceOfRegistrationNationalTimeline() {
        return evidenceOfRegistrationNationalTimeline;
    }

    public void setEvidenceOfRegistrationNationalTimeline(String evidenceOfRegistrationNationalTimeline) {
        this.evidenceOfRegistrationNationalTimeline = evidenceOfRegistrationNationalTimeline;
    }

    public String getEvidenceOfRegistrationNationalRemarks() {
        return evidenceOfRegistrationNationalRemarks;
    }

    public void setEvidenceOfRegistrationNationalRemarks(String evidenceOfRegistrationNationalRemarks) {
        this.evidenceOfRegistrationNationalRemarks = evidenceOfRegistrationNationalRemarks;
    }

    public String getIsEvidenceOfRegistrationSingle() {
        return isEvidenceOfRegistrationSingle;
    }

    public void setIsEvidenceOfRegistrationSingle(String isEvidenceOfRegistrationSingle) {
        this.isEvidenceOfRegistrationSingle = isEvidenceOfRegistrationSingle;
    }

    public String getEvidenceOfRegistrationSingleAward() {
        return evidenceOfRegistrationSingleAward;
    }

    public void setEvidenceOfRegistrationSingleAward(String evidenceOfRegistrationSingleAward) {
        this.evidenceOfRegistrationSingleAward = evidenceOfRegistrationSingleAward;
    }

    public String getEvidenceOfRegistrationSingleTimeline() {
        return evidenceOfRegistrationSingleTimeline;
    }

    public void setEvidenceOfRegistrationSingleTimeline(String evidenceOfRegistrationSingleTimeline) {
        this.evidenceOfRegistrationSingleTimeline = evidenceOfRegistrationSingleTimeline;
    }

    public String getEvidenceOfRegistrationSingleRemarks() {
        return evidenceOfRegistrationSingleRemarks;
    }

    public void setEvidenceOfRegistrationSingleRemarks(String evidenceOfRegistrationSingleRemarks) {
        this.evidenceOfRegistrationSingleRemarks = evidenceOfRegistrationSingleRemarks;
    }

    public String getIsEvidenceOfSafeDisposal() {
        return isEvidenceOfSafeDisposal;
    }

    public void setIsEvidenceOfSafeDisposal(String isEvidenceOfSafeDisposal) {
        this.isEvidenceOfSafeDisposal = isEvidenceOfSafeDisposal;
    }

    public String getEvidenceOfSafeDisposalAward() {
        return evidenceOfSafeDisposalAward;
    }

    public void setEvidenceOfSafeDisposalAward(String evidenceOfSafeDisposalAward) {
        this.evidenceOfSafeDisposalAward = evidenceOfSafeDisposalAward;
    }

    public String getEvidenceOfSafeDisposalTimeline() {
        return evidenceOfSafeDisposalTimeline;
    }

    public void setEvidenceOfSafeDisposalTimeline(String evidenceOfSafeDisposalTimeline) {
        this.evidenceOfSafeDisposalTimeline = evidenceOfSafeDisposalTimeline;
    }

    public String getEvidenceOfSafeDisposalRemarks() {
        return evidenceOfSafeDisposalRemarks;
    }

    public void setEvidenceOfSafeDisposalRemarks(String evidenceOfSafeDisposalRemarks) {
        this.evidenceOfSafeDisposalRemarks = evidenceOfSafeDisposalRemarks;
    }

    public String getIsEvidenceOfWorkerProtection() {
        return isEvidenceOfWorkerProtection;
    }

    public void setIsEvidenceOfWorkerProtection(String isEvidenceOfWorkerProtection) {
        this.isEvidenceOfWorkerProtection = isEvidenceOfWorkerProtection;
    }

    public String getEvidenceOfWorkerProtectionAward() {
        return evidenceOfWorkerProtectionAward;
    }

    public void setEvidenceOfWorkerProtectionAward(String evidenceOfWorkerProtectionAward) {
        this.evidenceOfWorkerProtectionAward = evidenceOfWorkerProtectionAward;
    }

    public String getEvidenceOfWorkerProtectionTimeline() {
        return evidenceOfWorkerProtectionTimeline;
    }

    public void setEvidenceOfWorkerProtectionTimeline(String evidenceOfWorkerProtectionTimeline) {
        this.evidenceOfWorkerProtectionTimeline = evidenceOfWorkerProtectionTimeline;
    }

    public String getEvidenceOfWorkerProtectionRemarks() {
        return evidenceOfWorkerProtectionRemarks;
    }

    public void setEvidenceOfWorkerProtectionRemarks(String evidenceOfWorkerProtectionRemarks) {
        this.evidenceOfWorkerProtectionRemarks = evidenceOfWorkerProtectionRemarks;
    }

    public String getIsCopyOfHCD() {
        return isCopyOfHCD;
    }

    public void setIsCopyOfHCD(String isCopyOfHCD) {
        this.isCopyOfHCD = isCopyOfHCD;
    }

    public String getCopyOfHCDAward() {
        return copyOfHCDAward;
    }

    public void setCopyOfHCDAward(String copyOfHCDAward) {
        this.copyOfHCDAward = copyOfHCDAward;
    }

    public String getCopyOfHCDTimeline() {
        return copyOfHCDTimeline;
    }

    public void setCopyOfHCDTimeline(String copyOfHCDTimeline) {
        this.copyOfHCDTimeline = copyOfHCDTimeline;
    }

    public String getCopyOfHCDRemarks() {
        return copyOfHCDRemarks;
    }

    public void setCopyOfHCDRemarks(String copyOfHCDRemarks) {
        this.copyOfHCDRemarks = copyOfHCDRemarks;
    }

    public String getIsTraceabilityList() {
        return isTraceabilityList;
    }

    public void setIsTraceabilityList(String isTraceabilityList) {
        this.isTraceabilityList = isTraceabilityList;
    }

    public String getTraceabilityListAward() {
        return traceabilityListAward;
    }

    public void setTraceabilityListAward(String traceabilityListAward) {
        this.traceabilityListAward = traceabilityListAward;
    }

    public String getTraceabilityListTimeline() {
        return traceabilityListTimeline;
    }

    public void setTraceabilityListTimeline(String traceabilityListTimeline) {
        this.traceabilityListTimeline = traceabilityListTimeline;
    }

    public String getTraceabilityListRemarks() {
        return traceabilityListRemarks;
    }

    public void setTraceabilityListRemarks(String traceabilityListRemarks) {
        this.traceabilityListRemarks = traceabilityListRemarks;
    }

    public String getIsDeclareMarkettingAgents() {
        return isDeclareMarkettingAgents;
    }

    public void setIsDeclareMarkettingAgents(String isDeclareMarkettingAgents) {
        this.isDeclareMarkettingAgents = isDeclareMarkettingAgents;
    }

    public String getDeclareMarkettingAgentsAward() {
        return declareMarkettingAgentsAward;
    }

    public void setDeclareMarkettingAgentsAward(String declareMarkettingAgentsAward) {
        this.declareMarkettingAgentsAward = declareMarkettingAgentsAward;
    }

    public String getDeclareMarkettingAgentsTimeline() {
        return declareMarkettingAgentsTimeline;
    }

    public void setDeclareMarkettingAgentsTimeline(String declareMarkettingAgentsTimeline) {
        this.declareMarkettingAgentsTimeline = declareMarkettingAgentsTimeline;
    }

    public String getDeclareMarkettingAgentsRemarks() {
        return declareMarkettingAgentsRemarks;
    }

    public void setDeclareMarkettingAgentsRemarks(String declareMarkettingAgentsRemarks) {
        this.declareMarkettingAgentsRemarks = declareMarkettingAgentsRemarks;
    }

    public String getIsEvidenceOfTraceabilitySystems() {
        return isEvidenceOfTraceabilitySystems;
    }

    public void setIsEvidenceOfTraceabilitySystems(String isEvidenceOfTraceabilitySystems) {
        this.isEvidenceOfTraceabilitySystems = isEvidenceOfTraceabilitySystems;
    }

    public String getEvidenceOfTraceabilitySystemsAward() {
        return evidenceOfTraceabilitySystemsAward;
    }

    public void setEvidenceOfTraceabilitySystemsAward(String evidenceOfTraceabilitySystemsAward) {
        this.evidenceOfTraceabilitySystemsAward = evidenceOfTraceabilitySystemsAward;
    }

    public String getEvidenceOfTraceabilitySystemsTimeline() {
        return evidenceOfTraceabilitySystemsTimeline;
    }

    public void setEvidenceOfTraceabilitySystemsTimeline(String evidenceOfTraceabilitySystemsTimeline) {
        this.evidenceOfTraceabilitySystemsTimeline = evidenceOfTraceabilitySystemsTimeline;
    }

    public String getEvidenceOfTraceabilitySystemsRemarks() {
        return evidenceOfTraceabilitySystemsRemarks;
    }

    public void setEvidenceOfTraceabilitySystemsRemarks(String evidenceOfTraceabilitySystemsRemarks) {
        this.evidenceOfTraceabilitySystemsRemarks = evidenceOfTraceabilitySystemsRemarks;
    }

    public String getIsEvidenceOfAttendance() {
        return isEvidenceOfAttendance;
    }

    public void setIsEvidenceOfAttendance(String isEvidenceOfAttendance) {
        this.isEvidenceOfAttendance = isEvidenceOfAttendance;
    }

    public String getEvidenceOfAttendanceAward() {
        return evidenceOfAttendanceAward;
    }

    public void setEvidenceOfAttendanceAward(String evidenceOfAttendanceAward) {
        this.evidenceOfAttendanceAward = evidenceOfAttendanceAward;
    }

    public String getEvidenceOfAttendanceTimeline() {
        return evidenceOfAttendanceTimeline;
    }

    public void setEvidenceOfAttendanceTimeline(String evidenceOfAttendanceTimeline) {
        this.evidenceOfAttendanceTimeline = evidenceOfAttendanceTimeline;
    }

    public String getEvidenceOfAttendanceRemarks() {
        return evidenceOfAttendanceRemarks;
    }

    public void setEvidenceOfAttendanceRemarks(String evidenceOfAttendanceRemarks) {
        this.evidenceOfAttendanceRemarks = evidenceOfAttendanceRemarks;
    }

    public String getIsAnnualTrainingMatrix() {
        return isAnnualTrainingMatrix;
    }

    public void setIsAnnualTrainingMatrix(String isAnnualTrainingMatrix) {
        this.isAnnualTrainingMatrix = isAnnualTrainingMatrix;
    }

    public String getAnnualTrainingMatrixAward() {
        return annualTrainingMatrixAward;
    }

    public void setAnnualTrainingMatrixAward(String annualTrainingMatrixAward) {
        this.annualTrainingMatrixAward = annualTrainingMatrixAward;
    }

    public String getAnnualTrainingMatrixTimeline() {
        return annualTrainingMatrixTimeline;
    }

    public void setAnnualTrainingMatrixTimeline(String annualTrainingMatrixTimeline) {
        this.annualTrainingMatrixTimeline = annualTrainingMatrixTimeline;
    }

    public String getAnnualTrainingMatrixRemarks() {
        return annualTrainingMatrixRemarks;
    }

    public void setAnnualTrainingMatrixRemarks(String annualTrainingMatrixRemarks) {
        this.annualTrainingMatrixRemarks = annualTrainingMatrixRemarks;
    }

    public String getIsEvidenceOfPests() {
        return isEvidenceOfPests;
    }

    public void setIsEvidenceOfPests(String isEvidenceOfPests) {
        this.isEvidenceOfPests = isEvidenceOfPests;
    }

    public String getEvidenceOfPestsAward() {
        return evidenceOfPestsAward;
    }

    public void setEvidenceOfPestsAward(String evidenceOfPestsAward) {
        this.evidenceOfPestsAward = evidenceOfPestsAward;
    }

    public String getEvidenceOfPestsTimeline() {
        return evidenceOfPestsTimeline;
    }

    public void setEvidenceOfPestsTimeline(String evidenceOfPestsTimeline) {
        this.evidenceOfPestsTimeline = evidenceOfPestsTimeline;
    }

    public String getEvidenceOfPestsRemarks() {
        return evidenceOfPestsRemarks;
    }

    public void setEvidenceOfPestsRemarks(String evidenceOfPestsRemarks) {
        this.evidenceOfPestsRemarks = evidenceOfPestsRemarks;
    }

    public String getIsClaim() {
        return isClaim;
    }

    public void setIsClaim(String isClaim) {
        this.isClaim = isClaim;
    }

    public String getClaimAward() {
        return claimAward;
    }

    public void setClaimAward(String claimAward) {
        this.claimAward = claimAward;
    }

    public String getClaimTimeline() {
        return claimTimeline;
    }

    public void setClaimTimeline(String claimTimeline) {
        this.claimTimeline = claimTimeline;
    }

    public String getClaimRemarks() {
        return claimRemarks;
    }

    public void setClaimRemarks(String claimRemarks) {
        this.claimRemarks = claimRemarks;
    }

    public String getIsUtilizationOfHCD() {
        return isUtilizationOfHCD;
    }

    public void setIsUtilizationOfHCD(String isUtilizationOfHCD) {
        this.isUtilizationOfHCD = isUtilizationOfHCD;
    }

    public String getUtilizationOfHCDAward() {
        return utilizationOfHCDAward;
    }

    public void setUtilizationOfHCDAward(String utilizationOfHCDAward) {
        this.utilizationOfHCDAward = utilizationOfHCDAward;
    }

    public String getUtilizationOfHCDTimeline() {
        return utilizationOfHCDTimeline;
    }

    public void setUtilizationOfHCDTimeline(String utilizationOfHCDTimeline) {
        this.utilizationOfHCDTimeline = utilizationOfHCDTimeline;
    }

    public String getUtilizationOfHCDRemarks() {
        return utilizationOfHCDRemarks;
    }

    public void setUtilizationOfHCDRemarks(String utilizationOfHCDRemarks) {
        this.utilizationOfHCDRemarks = utilizationOfHCDRemarks;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public String getApprovalStage() {
        return approvalStage;
    }

    public void setApprovalStage(String approvalStage) {
        this.approvalStage = approvalStage;
    }

    public String getServerRecordID() {
        return serverRecordID;
    }

    public void setServerRecordID(String serverRecordID) {
        this.serverRecordID = serverRecordID;
    }

    public String getHorticulturalFlowerExportersDeskVettingID() {
        return horticulturalFlowerExportersDeskVettingID;
    }

    public void setHorticulturalFlowerExportersDeskVettingID(String horticulturalFlowerExportersDeskVettingID) {
        this.horticulturalFlowerExportersDeskVettingID = horticulturalFlowerExportersDeskVettingID;
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
