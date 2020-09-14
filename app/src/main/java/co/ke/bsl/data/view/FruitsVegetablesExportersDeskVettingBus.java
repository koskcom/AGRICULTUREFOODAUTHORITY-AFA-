package co.ke.bsl.data.view;

public class FruitsVegetablesExportersDeskVettingBus {

    private static FruitsVegetablesExportersDeskVettingBus single_instance = null;

    private FruitsVegetablesExportersDeskVettingBus() {
    }

    public static FruitsVegetablesExportersDeskVettingBus getInstance() {
        if (single_instance == null)
            single_instance = new FruitsVegetablesExportersDeskVettingBus();

        return single_instance;
    }

    public static FruitsVegetablesExportersDeskVettingBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(FruitsVegetablesExportersDeskVettingBus single_instance) {
        FruitsVegetablesExportersDeskVettingBus.single_instance = single_instance;
    }

    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String telephone;
    private String email;
    private String postaladdress;
    private String exportLicence;
    private String localID;
    private String isCertificationtoKsh1758;
    private String certificationtoKsh1758Award;
    private String certificationtoKsh1758Timeline;
    private String certificationtoKsh1758Remarks;
    private String isOtherRecognizedstandards;
    private String otherRecognizedstandardsAward;
    private String otherRecognizedstandardsTimeline;
    private String otherRecognizedstandardsremarks;
    private String isEvidenceofRegonNaionalTraceability;
    private String evidenceofRegonNaionalTraceabilityAward;
    private String evidenceofRegonNaionalTraceabilityTimeline;
    private String evidenceofRegonNaionalTraceabilityRemarks;
    private String isEvidenceofRegSingleWindow;
    private String evidenceofRegSingleWindowAward;
    private String evidenceofRegSingleWindowTimeline;
    private String evidenceofRegSingleWindowRemarks;
    private String isCopyOfHcdexportLicence;
    private String copyOfHcdexportLicenceAward;
    private String copyOfHcdexportLicenceTimeine;
    private String copyOfHcdexportLicenceRemarks;
    private String isTraceablitylistOfTheCompany;
    private String traceablitylistOfTheCompanyAward;
    private String traceablitylistOfTheCompanyTimeline;
    private String traceablitylistOfTheCompanyReamrks;
    private String isDeclareMarketingAgents;
    private String declareMarketingAgentsAward;
    private String declareMarketingAgentsTimeline;
    private String declareMarketingAgentsRemarks;
    private String isEvidenceOfhcdRegistered;
    private String evidenceOfhcdRegisteredAward;
    private String evidenceOfhcdRegisteredTimeline;
    private String evidenceOfhcdRegisteredRemarks;
    private String isSystempoliceAndProcedure;
    private String systemPoliceAndProcedureAward;
    private String systemPoliceAndProcedureTimeline;
    private String systemPoliceAndProcedureRemarks;
    private String isEvidenceofAtendanceOfAnnualTraining;
    private String evidenceofAtendanceOfAnnualTrainingAward;
    private String evidenceofAtendanceOfAnnualTrainingTimeline;
    private String evidenceofAtendanceOfAnnualTrainingRemarks;
    private String isAnnualTrainingmatrixSchedule;
    private String annualTrainingmatrixScheduleAward;
    private String annualTrainingmatrixScheduleTimeline;
    private String annualTrainingmatrixScheduleRemarks;
    private String isPestDiseaseControlprocedures;
    private String pestDiseaseControlproceduresAward;
    private String pestDiseaseControlproceduresTimeline;
    private String pestDiseaseControlproceduresRemarks;
    private String isClaimsonNonPayment;
    private String claimsonNonPaymentAward;
    private String claimsonNonPaymentTimeline;
    private String claimsonNonPaymentRemarks;
    private String officerrecommendation;
    private String officerrecommendation_remark;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostaladdress() {
        return postaladdress;
    }

    public void setPostaladdress(String postaladdress) {
        this.postaladdress = postaladdress;
    }

    public String getExportLicence() {
        return exportLicence;
    }

    public void setExportLicence(String exportLicence) {
        this.exportLicence = exportLicence;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getIsCertificationtoKsh1758() {
        return isCertificationtoKsh1758;
    }

    public void setIsCertificationtoKsh1758(String isCertificationtoKsh1758) {
        this.isCertificationtoKsh1758 = isCertificationtoKsh1758;
    }

    public String getCertificationtoKsh1758Award() {
        return certificationtoKsh1758Award;
    }

    public void setCertificationtoKsh1758Award(String certificationtoKsh1758Award) {
        this.certificationtoKsh1758Award = certificationtoKsh1758Award;
    }

    public String getCertificationtoKsh1758Timeline() {
        return certificationtoKsh1758Timeline;
    }

    public void setCertificationtoKsh1758Timeline(String certificationtoKsh1758Timeline) {
        this.certificationtoKsh1758Timeline = certificationtoKsh1758Timeline;
    }

    public String getCertificationtoKsh1758Remarks() {
        return certificationtoKsh1758Remarks;
    }

    public void setCertificationtoKsh1758Remarks(String certificationtoKsh1758Remarks) {
        this.certificationtoKsh1758Remarks = certificationtoKsh1758Remarks;
    }

    public String getIsOtherRecognizedstandards() {
        return isOtherRecognizedstandards;
    }

    public void setIsOtherRecognizedstandards(String isOtherRecognizedstandards) {
        this.isOtherRecognizedstandards = isOtherRecognizedstandards;
    }

    public String getOtherRecognizedstandardsAward() {
        return otherRecognizedstandardsAward;
    }

    public void setOtherRecognizedstandardsAward(String otherRecognizedstandardsAward) {
        this.otherRecognizedstandardsAward = otherRecognizedstandardsAward;
    }

    public String getOtherRecognizedstandardsTimeline() {
        return otherRecognizedstandardsTimeline;
    }

    public void setOtherRecognizedstandardsTimeline(String otherRecognizedstandardsTimeline) {
        this.otherRecognizedstandardsTimeline = otherRecognizedstandardsTimeline;
    }

    public String getOtherRecognizedstandardsremarks() {
        return otherRecognizedstandardsremarks;
    }

    public void setOtherRecognizedstandardsremarks(String otherRecognizedstandardsremarks) {
        this.otherRecognizedstandardsremarks = otherRecognizedstandardsremarks;
    }

    public String getIsEvidenceofRegonNaionalTraceability() {
        return isEvidenceofRegonNaionalTraceability;
    }

    public void setIsEvidenceofRegonNaionalTraceability(String isEvidenceofRegonNaionalTraceability) {
        this.isEvidenceofRegonNaionalTraceability = isEvidenceofRegonNaionalTraceability;
    }

    public String getEvidenceofRegonNaionalTraceabilityAward() {
        return evidenceofRegonNaionalTraceabilityAward;
    }

    public void setEvidenceofRegonNaionalTraceabilityAward(String evidenceofRegonNaionalTraceabilityAward) {
        this.evidenceofRegonNaionalTraceabilityAward = evidenceofRegonNaionalTraceabilityAward;
    }

    public String getEvidenceofRegonNaionalTraceabilityTimeline() {
        return evidenceofRegonNaionalTraceabilityTimeline;
    }

    public void setEvidenceofRegonNaionalTraceabilityTimeline(String evidenceofRegonNaionalTraceabilityTimeline) {
        this.evidenceofRegonNaionalTraceabilityTimeline = evidenceofRegonNaionalTraceabilityTimeline;
    }

    public String getEvidenceofRegonNaionalTraceabilityRemarks() {
        return evidenceofRegonNaionalTraceabilityRemarks;
    }

    public void setEvidenceofRegonNaionalTraceabilityRemarks(String evidenceofRegonNaionalTraceabilityRemarks) {
        this.evidenceofRegonNaionalTraceabilityRemarks = evidenceofRegonNaionalTraceabilityRemarks;
    }

    public String getIsEvidenceofRegSingleWindow() {
        return isEvidenceofRegSingleWindow;
    }

    public void setIsEvidenceofRegSingleWindow(String isEvidenceofRegSingleWindow) {
        this.isEvidenceofRegSingleWindow = isEvidenceofRegSingleWindow;
    }

    public String getEvidenceofRegSingleWindowAward() {
        return evidenceofRegSingleWindowAward;
    }

    public void setEvidenceofRegSingleWindowAward(String evidenceofRegSingleWindowAward) {
        this.evidenceofRegSingleWindowAward = evidenceofRegSingleWindowAward;
    }

    public String getEvidenceofRegSingleWindowTimeline() {
        return evidenceofRegSingleWindowTimeline;
    }

    public void setEvidenceofRegSingleWindowTimeline(String evidenceofRegSingleWindowTimeline) {
        this.evidenceofRegSingleWindowTimeline = evidenceofRegSingleWindowTimeline;
    }

    public String getEvidenceofRegSingleWindowRemarks() {
        return evidenceofRegSingleWindowRemarks;
    }

    public void setEvidenceofRegSingleWindowRemarks(String evidenceofRegSingleWindowRemarks) {
        this.evidenceofRegSingleWindowRemarks = evidenceofRegSingleWindowRemarks;
    }

    public String getIsCopyOfHcdexportLicence() {
        return isCopyOfHcdexportLicence;
    }

    public void setIsCopyOfHcdexportLicence(String isCopyOfHcdexportLicence) {
        this.isCopyOfHcdexportLicence = isCopyOfHcdexportLicence;
    }

    public String getCopyOfHcdexportLicenceAward() {
        return copyOfHcdexportLicenceAward;
    }

    public void setCopyOfHcdexportLicenceAward(String copyOfHcdexportLicenceAward) {
        this.copyOfHcdexportLicenceAward = copyOfHcdexportLicenceAward;
    }

    public String getCopyOfHcdexportLicenceTimeine() {
        return copyOfHcdexportLicenceTimeine;
    }

    public void setCopyOfHcdexportLicenceTimeine(String copyOfHcdexportLicenceTimeine) {
        this.copyOfHcdexportLicenceTimeine = copyOfHcdexportLicenceTimeine;
    }

    public String getCopyOfHcdexportLicenceRemarks() {
        return copyOfHcdexportLicenceRemarks;
    }

    public void setCopyOfHcdexportLicenceRemarks(String copyOfHcdexportLicenceRemarks) {
        this.copyOfHcdexportLicenceRemarks = copyOfHcdexportLicenceRemarks;
    }

    public String getIsTraceablitylistOfTheCompany() {
        return isTraceablitylistOfTheCompany;
    }

    public void setIsTraceablitylistOfTheCompany(String isTraceablitylistOfTheCompany) {
        this.isTraceablitylistOfTheCompany = isTraceablitylistOfTheCompany;
    }

    public String getTraceablitylistOfTheCompanyAward() {
        return traceablitylistOfTheCompanyAward;
    }

    public void setTraceablitylistOfTheCompanyAward(String traceablitylistOfTheCompanyAward) {
        this.traceablitylistOfTheCompanyAward = traceablitylistOfTheCompanyAward;
    }

    public String getTraceablitylistOfTheCompanyTimeline() {
        return traceablitylistOfTheCompanyTimeline;
    }

    public void setTraceablitylistOfTheCompanyTimeline(String traceablitylistOfTheCompanyTimeline) {
        this.traceablitylistOfTheCompanyTimeline = traceablitylistOfTheCompanyTimeline;
    }

    public String getTraceablitylistOfTheCompanyReamrks() {
        return traceablitylistOfTheCompanyReamrks;
    }

    public void setTraceablitylistOfTheCompanyReamrks(String traceablitylistOfTheCompanyReamrks) {
        this.traceablitylistOfTheCompanyReamrks = traceablitylistOfTheCompanyReamrks;
    }

    public String getIsDeclareMarketingAgents() {
        return isDeclareMarketingAgents;
    }

    public void setIsDeclareMarketingAgents(String isDeclareMarketingAgents) {
        this.isDeclareMarketingAgents = isDeclareMarketingAgents;
    }

    public String getDeclareMarketingAgentsAward() {
        return declareMarketingAgentsAward;
    }

    public void setDeclareMarketingAgentsAward(String declareMarketingAgentsAward) {
        this.declareMarketingAgentsAward = declareMarketingAgentsAward;
    }

    public String getDeclareMarketingAgentsTimeline() {
        return declareMarketingAgentsTimeline;
    }

    public void setDeclareMarketingAgentsTimeline(String declareMarketingAgentsTimeline) {
        this.declareMarketingAgentsTimeline = declareMarketingAgentsTimeline;
    }

    public String getDeclareMarketingAgentsRemarks() {
        return declareMarketingAgentsRemarks;
    }

    public void setDeclareMarketingAgentsRemarks(String declareMarketingAgentsRemarks) {
        this.declareMarketingAgentsRemarks = declareMarketingAgentsRemarks;
    }

    public String getIsEvidenceOfhcdRegistered() {
        return isEvidenceOfhcdRegistered;
    }

    public void setIsEvidenceOfhcdRegistered(String isEvidenceOfhcdRegistered) {
        this.isEvidenceOfhcdRegistered = isEvidenceOfhcdRegistered;
    }

    public String getEvidenceOfhcdRegisteredAward() {
        return evidenceOfhcdRegisteredAward;
    }

    public void setEvidenceOfhcdRegisteredAward(String evidenceOfhcdRegisteredAward) {
        this.evidenceOfhcdRegisteredAward = evidenceOfhcdRegisteredAward;
    }

    public String getEvidenceOfhcdRegisteredTimeline() {
        return evidenceOfhcdRegisteredTimeline;
    }

    public void setEvidenceOfhcdRegisteredTimeline(String evidenceOfhcdRegisteredTimeline) {
        this.evidenceOfhcdRegisteredTimeline = evidenceOfhcdRegisteredTimeline;
    }

    public String getEvidenceOfhcdRegisteredRemarks() {
        return evidenceOfhcdRegisteredRemarks;
    }

    public void setEvidenceOfhcdRegisteredRemarks(String evidenceOfhcdRegisteredRemarks) {
        this.evidenceOfhcdRegisteredRemarks = evidenceOfhcdRegisteredRemarks;
    }

    public String getIsSystempoliceAndProcedure() {
        return isSystempoliceAndProcedure;
    }

    public void setIsSystempoliceAndProcedure(String isSystempoliceAndProcedure) {
        this.isSystempoliceAndProcedure = isSystempoliceAndProcedure;
    }

    public String getSystemPoliceAndProcedureAward() {
        return systemPoliceAndProcedureAward;
    }

    public void setSystemPoliceAndProcedureAward(String systemPoliceAndProcedureAward) {
        this.systemPoliceAndProcedureAward = systemPoliceAndProcedureAward;
    }

    public String getSystemPoliceAndProcedureTimeline() {
        return systemPoliceAndProcedureTimeline;
    }

    public void setSystemPoliceAndProcedureTimeline(String systemPoliceAndProcedureTimeline) {
        this.systemPoliceAndProcedureTimeline = systemPoliceAndProcedureTimeline;
    }

    public String getSystemPoliceAndProcedureRemarks() {
        return systemPoliceAndProcedureRemarks;
    }

    public void setSystemPoliceAndProcedureRemarks(String systemPoliceAndProcedureRemarks) {
        this.systemPoliceAndProcedureRemarks = systemPoliceAndProcedureRemarks;
    }

    public String getIsEvidenceofAtendanceOfAnnualTraining() {
        return isEvidenceofAtendanceOfAnnualTraining;
    }

    public void setIsEvidenceofAtendanceOfAnnualTraining(String isEvidenceofAtendanceOfAnnualTraining) {
        this.isEvidenceofAtendanceOfAnnualTraining = isEvidenceofAtendanceOfAnnualTraining;
    }

    public String getEvidenceofAtendanceOfAnnualTrainingAward() {
        return evidenceofAtendanceOfAnnualTrainingAward;
    }

    public void setEvidenceofAtendanceOfAnnualTrainingAward(String evidenceofAtendanceOfAnnualTrainingAward) {
        this.evidenceofAtendanceOfAnnualTrainingAward = evidenceofAtendanceOfAnnualTrainingAward;
    }

    public String getEvidenceofAtendanceOfAnnualTrainingTimeline() {
        return evidenceofAtendanceOfAnnualTrainingTimeline;
    }

    public void setEvidenceofAtendanceOfAnnualTrainingTimeline(String evidenceofAtendanceOfAnnualTrainingTimeline) {
        this.evidenceofAtendanceOfAnnualTrainingTimeline = evidenceofAtendanceOfAnnualTrainingTimeline;
    }

    public String getEvidenceofAtendanceOfAnnualTrainingRemarks() {
        return evidenceofAtendanceOfAnnualTrainingRemarks;
    }

    public void setEvidenceofAtendanceOfAnnualTrainingRemarks(String evidenceofAtendanceOfAnnualTrainingRemarks) {
        this.evidenceofAtendanceOfAnnualTrainingRemarks = evidenceofAtendanceOfAnnualTrainingRemarks;
    }

    public String getIsAnnualTrainingmatrixSchedule() {
        return isAnnualTrainingmatrixSchedule;
    }

    public void setIsAnnualTrainingmatrixSchedule(String isAnnualTrainingmatrixSchedule) {
        this.isAnnualTrainingmatrixSchedule = isAnnualTrainingmatrixSchedule;
    }

    public String getAnnualTrainingmatrixScheduleAward() {
        return annualTrainingmatrixScheduleAward;
    }

    public void setAnnualTrainingmatrixScheduleAward(String annualTrainingmatrixScheduleAward) {
        this.annualTrainingmatrixScheduleAward = annualTrainingmatrixScheduleAward;
    }

    public String getAnnualTrainingmatrixScheduleTimeline() {
        return annualTrainingmatrixScheduleTimeline;
    }

    public void setAnnualTrainingmatrixScheduleTimeline(String annualTrainingmatrixScheduleTimeline) {
        this.annualTrainingmatrixScheduleTimeline = annualTrainingmatrixScheduleTimeline;
    }

    public String getAnnualTrainingmatrixScheduleRemarks() {
        return annualTrainingmatrixScheduleRemarks;
    }

    public void setAnnualTrainingmatrixScheduleRemarks(String annualTrainingmatrixScheduleRemarks) {
        this.annualTrainingmatrixScheduleRemarks = annualTrainingmatrixScheduleRemarks;
    }

    public String getIsPestDiseaseControlprocedures() {
        return isPestDiseaseControlprocedures;
    }

    public void setIsPestDiseaseControlprocedures(String isPestDiseaseControlprocedures) {
        this.isPestDiseaseControlprocedures = isPestDiseaseControlprocedures;
    }

    public String getPestDiseaseControlproceduresAward() {
        return pestDiseaseControlproceduresAward;
    }

    public void setPestDiseaseControlproceduresAward(String pestDiseaseControlproceduresAward) {
        this.pestDiseaseControlproceduresAward = pestDiseaseControlproceduresAward;
    }

    public String getPestDiseaseControlproceduresTimeline() {
        return pestDiseaseControlproceduresTimeline;
    }

    public void setPestDiseaseControlproceduresTimeline(String pestDiseaseControlproceduresTimeline) {
        this.pestDiseaseControlproceduresTimeline = pestDiseaseControlproceduresTimeline;
    }

    public String getPestDiseaseControlproceduresRemarks() {
        return pestDiseaseControlproceduresRemarks;
    }

    public void setPestDiseaseControlproceduresRemarks(String pestDiseaseControlproceduresRemarks) {
        this.pestDiseaseControlproceduresRemarks = pestDiseaseControlproceduresRemarks;
    }

    public String getIsClaimsonNonPayment() {
        return isClaimsonNonPayment;
    }

    public void setIsClaimsonNonPayment(String isClaimsonNonPayment) {
        this.isClaimsonNonPayment = isClaimsonNonPayment;
    }

    public String getClaimsonNonPaymentAward() {
        return claimsonNonPaymentAward;
    }

    public void setClaimsonNonPaymentAward(String claimsonNonPaymentAward) {
        this.claimsonNonPaymentAward = claimsonNonPaymentAward;
    }

    public String getClaimsonNonPaymentTimeline() {
        return claimsonNonPaymentTimeline;
    }

    public void setClaimsonNonPaymentTimeline(String claimsonNonPaymentTimeline) {
        this.claimsonNonPaymentTimeline = claimsonNonPaymentTimeline;
    }

    public String getClaimsonNonPaymentRemarks() {
        return claimsonNonPaymentRemarks;
    }

    public void setClaimsonNonPaymentRemarks(String claimsonNonPaymentRemarks) {
        this.claimsonNonPaymentRemarks = claimsonNonPaymentRemarks;
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
