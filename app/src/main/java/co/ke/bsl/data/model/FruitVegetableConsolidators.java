package co.ke.bsl.data.model;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FruitVegetableConsolidators {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int fruitVegetableConsolidators_id;
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String exportLicence;
    private String localID;
    private String isCertificationtoKsh1758;
    private String ssCertificationtoKsh1758Award;
    private String certificationtoKsh1758Timeline;
    private String certificationtoKsh1758Remarks;
    private String isOtherrecognizedStandards;
    private String ssOtherrecognizedStandardsAward;
    private String otherrecognizedStandardstimeline;
    private String otherrecognizedStandardsRemarks;
    private String isEvidenceofRegonNaionalTraceability;
    private String ssEvidenceofRegonNaionalTraceabilityAward;
    private String evidenceofRegonNaionalTraceabilityTimeline;
    private String evidenceofRegonNaionalTraceabilityRemarks;
    private String isEvidenceofRegSingleWindow;
    private String ssEvidenceofRegSingleWindowAward;
    private String evidenceofRegSingleWindowTimeline;
    private String evidenceofRegSingleWindowRemarks;
    private String isCopyofHcdExportLicence;
    private String ssCopyofHcdExportLicenceAward;
    private String copyofHcdExportLicenceTimeline;
    private String copyofHcdExportLicenceRemarks;
    private String isTraceabilityListContractedfarmers;
    private String ssTraceabilityListContractedfarmersAward;
    private String traceabilityListContractedfarmersTimeline;
    private String traceabilityListContractedfarmersRemarks;
    private String isDeclaremarketingAgent;
    private String ssDeclaremarketingAgentAward;
    private String declaremarketingAgentTimeline;
    private String declaremarketingAgentREmarks;
    private String isUtilizationofHCD;
    private String ssUtilizationofHCDAward;
    private String utilizationofHCDTimeline;
    private String utilizationofHCDRemarks;
    private String isSystemPoliceandProcedure;
    private String ssSystemPoliceandProcedureAward;
    private String systemPoliceandProcedureTimeline;
    private String systemPoliceandProcedureRemarks;
    private String isEvidenceOfatendanceOfAnnualTraining;
    private String ssEvidenceOfatendanceOfAnnualTrainingAward;
    private String evidenceOfatendanceOfAnnualTraininAwardTimeline;
    private String evidenceOfatendanceOfAnnualTrainingRemarks;
    private String isAnnualTrainingmatrixSchedule;
    private String ssAnnualTrainingmatrixScheduleAward;
    private String annualTrainingmatrixScheduleTimeline;
    private String annualTrainingmatrixScheduleRemarks;
    private String isPestDiseasecontrolProcedures;
    private String ssPestDiseasecontrolProceduresAward;
    private String pestDiseasecontrolProceduresTimeline;
    private String pestDiseasecontrolProceduresRemarks;
    private String isClaimsOnnonPayment;
    private String ssClaimsOnnonPaymentAward;
    private String claimsOnnonPaymentTimeline;
    private String claimsOnnonPaymentRemarks;
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private boolean is_synced;
    private String remote_id;

    public FruitVegetableConsolidators(int fruitVegetableConsolidators_id, String documentNumber, String documentDate, String nameOfApplicant, String exportLicence, String localID, String isCertificationtoKsh1758, String ssCertificationtoKsh1758Award, String certificationtoKsh1758Timeline, String certificationtoKsh1758Remarks, String isOtherrecognizedStandards, String ssOtherrecognizedStandardsAward, String otherrecognizedStandardstimeline, String otherrecognizedStandardsRemarks, String isEvidenceofRegonNaionalTraceability, String ssEvidenceofRegonNaionalTraceabilityAward, String evidenceofRegonNaionalTraceabilityTimeline, String evidenceofRegonNaionalTraceabilityRemarks, String isEvidenceofRegSingleWindow, String ssEvidenceofRegSingleWindowAward, String evidenceofRegSingleWindowTimeline, String evidenceofRegSingleWindowRemarks, String isCopyofHcdExportLicence, String ssCopyofHcdExportLicenceAward, String copyofHcdExportLicenceTimeline, String copyofHcdExportLicenceRemarks, String isTraceabilityListContractedfarmers, String ssTraceabilityListContractedfarmersAward, String traceabilityListContractedfarmersTimeline, String traceabilityListContractedfarmersRemarks, String isDeclaremarketingAgent, String ssDeclaremarketingAgentAward, String declaremarketingAgentTimeline, String declaremarketingAgentREmarks, String isUtilizationofHCD, String ssUtilizationofHCDAward, String utilizationofHCDTimeline, String utilizationofHCDRemarks, String isSystemPoliceandProcedure, String ssSystemPoliceandProcedureAward, String systemPoliceandProcedureTimeline, String systemPoliceandProcedureRemarks, String isEvidenceOfatendanceOfAnnualTraining, String ssEvidenceOfatendanceOfAnnualTrainingAward, String evidenceOfatendanceOfAnnualTraininAwardTimeline, String evidenceOfatendanceOfAnnualTrainingRemarks, String isAnnualTrainingmatrixSchedule, String ssAnnualTrainingmatrixScheduleAward, String annualTrainingmatrixScheduleTimeline, String annualTrainingmatrixScheduleRemarks, String isPestDiseasecontrolProcedures, String ssPestDiseasecontrolProceduresAward, String pestDiseasecontrolProceduresTimeline, String pestDiseasecontrolProceduresRemarks, String isClaimsOnnonPayment, String ssClaimsOnnonPaymentAward, String claimsOnnonPaymentTimeline, String claimsOnnonPaymentRemarks, String officerrecommendation, String officerrecommendation_remark, boolean is_synced, String remote_id) {
        this.fruitVegetableConsolidators_id = fruitVegetableConsolidators_id;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.exportLicence = exportLicence;
        this.localID = localID;
        this.isCertificationtoKsh1758 = isCertificationtoKsh1758;
        this.ssCertificationtoKsh1758Award = ssCertificationtoKsh1758Award;
        this.certificationtoKsh1758Timeline = certificationtoKsh1758Timeline;
        this.certificationtoKsh1758Remarks = certificationtoKsh1758Remarks;
        this.isOtherrecognizedStandards = isOtherrecognizedStandards;
        this.ssOtherrecognizedStandardsAward = ssOtherrecognizedStandardsAward;
        this.otherrecognizedStandardstimeline = otherrecognizedStandardstimeline;
        this.otherrecognizedStandardsRemarks = otherrecognizedStandardsRemarks;
        this.isEvidenceofRegonNaionalTraceability = isEvidenceofRegonNaionalTraceability;
        this.ssEvidenceofRegonNaionalTraceabilityAward = ssEvidenceofRegonNaionalTraceabilityAward;
        this.evidenceofRegonNaionalTraceabilityTimeline = evidenceofRegonNaionalTraceabilityTimeline;
        this.evidenceofRegonNaionalTraceabilityRemarks = evidenceofRegonNaionalTraceabilityRemarks;
        this.isEvidenceofRegSingleWindow = isEvidenceofRegSingleWindow;
        this.ssEvidenceofRegSingleWindowAward = ssEvidenceofRegSingleWindowAward;
        this.evidenceofRegSingleWindowTimeline = evidenceofRegSingleWindowTimeline;
        this.evidenceofRegSingleWindowRemarks = evidenceofRegSingleWindowRemarks;
        this.isCopyofHcdExportLicence = isCopyofHcdExportLicence;
        this.ssCopyofHcdExportLicenceAward = ssCopyofHcdExportLicenceAward;
        this.copyofHcdExportLicenceTimeline = copyofHcdExportLicenceTimeline;
        this.copyofHcdExportLicenceRemarks = copyofHcdExportLicenceRemarks;
        this.isTraceabilityListContractedfarmers = isTraceabilityListContractedfarmers;
        this.ssTraceabilityListContractedfarmersAward = ssTraceabilityListContractedfarmersAward;
        this.traceabilityListContractedfarmersTimeline = traceabilityListContractedfarmersTimeline;
        this.traceabilityListContractedfarmersRemarks = traceabilityListContractedfarmersRemarks;
        this.isDeclaremarketingAgent = isDeclaremarketingAgent;
        this.ssDeclaremarketingAgentAward = ssDeclaremarketingAgentAward;
        this.declaremarketingAgentTimeline = declaremarketingAgentTimeline;
        this.declaremarketingAgentREmarks = declaremarketingAgentREmarks;
        this.isUtilizationofHCD = isUtilizationofHCD;
        this.ssUtilizationofHCDAward = ssUtilizationofHCDAward;
        this.utilizationofHCDTimeline = utilizationofHCDTimeline;
        this.utilizationofHCDRemarks = utilizationofHCDRemarks;
        this.isSystemPoliceandProcedure = isSystemPoliceandProcedure;
        this.ssSystemPoliceandProcedureAward = ssSystemPoliceandProcedureAward;
        this.systemPoliceandProcedureTimeline = systemPoliceandProcedureTimeline;
        this.systemPoliceandProcedureRemarks = systemPoliceandProcedureRemarks;
        this.isEvidenceOfatendanceOfAnnualTraining = isEvidenceOfatendanceOfAnnualTraining;
        this.ssEvidenceOfatendanceOfAnnualTrainingAward = ssEvidenceOfatendanceOfAnnualTrainingAward;
        this.evidenceOfatendanceOfAnnualTraininAwardTimeline = evidenceOfatendanceOfAnnualTraininAwardTimeline;
        this.evidenceOfatendanceOfAnnualTrainingRemarks = evidenceOfatendanceOfAnnualTrainingRemarks;
        this.isAnnualTrainingmatrixSchedule = isAnnualTrainingmatrixSchedule;
        this.ssAnnualTrainingmatrixScheduleAward = ssAnnualTrainingmatrixScheduleAward;
        this.annualTrainingmatrixScheduleTimeline = annualTrainingmatrixScheduleTimeline;
        this.annualTrainingmatrixScheduleRemarks = annualTrainingmatrixScheduleRemarks;
        this.isPestDiseasecontrolProcedures = isPestDiseasecontrolProcedures;
        this.ssPestDiseasecontrolProceduresAward = ssPestDiseasecontrolProceduresAward;
        this.pestDiseasecontrolProceduresTimeline = pestDiseasecontrolProceduresTimeline;
        this.pestDiseasecontrolProceduresRemarks = pestDiseasecontrolProceduresRemarks;
        this.isClaimsOnnonPayment = isClaimsOnnonPayment;
        this.ssClaimsOnnonPaymentAward = ssClaimsOnnonPaymentAward;
        this.claimsOnnonPaymentTimeline = claimsOnnonPaymentTimeline;
        this.claimsOnnonPaymentRemarks = claimsOnnonPaymentRemarks;
        this.officerrecommendation = officerrecommendation;
        this.officerrecommendation_remark = officerrecommendation_remark;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getFruitVegetableConsolidators_id() {
        return fruitVegetableConsolidators_id;
    }

    public void setFruitVegetableConsolidators_id(int fruitVegetableConsolidators_id) {
        this.fruitVegetableConsolidators_id = fruitVegetableConsolidators_id;
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

    public String getSsCertificationtoKsh1758Award() {
        return ssCertificationtoKsh1758Award;
    }

    public void setSsCertificationtoKsh1758Award(String ssCertificationtoKsh1758Award) {
        this.ssCertificationtoKsh1758Award = ssCertificationtoKsh1758Award;
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

    public String getIsOtherrecognizedStandards() {
        return isOtherrecognizedStandards;
    }

    public void setIsOtherrecognizedStandards(String isOtherrecognizedStandards) {
        this.isOtherrecognizedStandards = isOtherrecognizedStandards;
    }

    public String getSsOtherrecognizedStandardsAward() {
        return ssOtherrecognizedStandardsAward;
    }

    public void setSsOtherrecognizedStandardsAward(String ssOtherrecognizedStandardsAward) {
        this.ssOtherrecognizedStandardsAward = ssOtherrecognizedStandardsAward;
    }

    public String getOtherrecognizedStandardstimeline() {
        return otherrecognizedStandardstimeline;
    }

    public void setOtherrecognizedStandardstimeline(String otherrecognizedStandardstimeline) {
        this.otherrecognizedStandardstimeline = otherrecognizedStandardstimeline;
    }

    public String getOtherrecognizedStandardsRemarks() {
        return otherrecognizedStandardsRemarks;
    }

    public void setOtherrecognizedStandardsRemarks(String otherrecognizedStandardsRemarks) {
        this.otherrecognizedStandardsRemarks = otherrecognizedStandardsRemarks;
    }

    public String getIsEvidenceofRegonNaionalTraceability() {
        return isEvidenceofRegonNaionalTraceability;
    }

    public void setIsEvidenceofRegonNaionalTraceability(String isEvidenceofRegonNaionalTraceability) {
        this.isEvidenceofRegonNaionalTraceability = isEvidenceofRegonNaionalTraceability;
    }

    public String getSsEvidenceofRegonNaionalTraceabilityAward() {
        return ssEvidenceofRegonNaionalTraceabilityAward;
    }

    public void setSsEvidenceofRegonNaionalTraceabilityAward(String ssEvidenceofRegonNaionalTraceabilityAward) {
        this.ssEvidenceofRegonNaionalTraceabilityAward = ssEvidenceofRegonNaionalTraceabilityAward;
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

    public String getSsEvidenceofRegSingleWindowAward() {
        return ssEvidenceofRegSingleWindowAward;
    }

    public void setSsEvidenceofRegSingleWindowAward(String ssEvidenceofRegSingleWindowAward) {
        this.ssEvidenceofRegSingleWindowAward = ssEvidenceofRegSingleWindowAward;
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

    public String getIsCopyofHcdExportLicence() {
        return isCopyofHcdExportLicence;
    }

    public void setIsCopyofHcdExportLicence(String isCopyofHcdExportLicence) {
        this.isCopyofHcdExportLicence = isCopyofHcdExportLicence;
    }

    public String getSsCopyofHcdExportLicenceAward() {
        return ssCopyofHcdExportLicenceAward;
    }

    public void setSsCopyofHcdExportLicenceAward(String ssCopyofHcdExportLicenceAward) {
        this.ssCopyofHcdExportLicenceAward = ssCopyofHcdExportLicenceAward;
    }

    public String getCopyofHcdExportLicenceTimeline() {
        return copyofHcdExportLicenceTimeline;
    }

    public void setCopyofHcdExportLicenceTimeline(String copyofHcdExportLicenceTimeline) {
        this.copyofHcdExportLicenceTimeline = copyofHcdExportLicenceTimeline;
    }

    public String getCopyofHcdExportLicenceRemarks() {
        return copyofHcdExportLicenceRemarks;
    }

    public void setCopyofHcdExportLicenceRemarks(String copyofHcdExportLicenceRemarks) {
        this.copyofHcdExportLicenceRemarks = copyofHcdExportLicenceRemarks;
    }

    public String getIsTraceabilityListContractedfarmers() {
        return isTraceabilityListContractedfarmers;
    }

    public void setIsTraceabilityListContractedfarmers(String isTraceabilityListContractedfarmers) {
        this.isTraceabilityListContractedfarmers = isTraceabilityListContractedfarmers;
    }

    public String getSsTraceabilityListContractedfarmersAward() {
        return ssTraceabilityListContractedfarmersAward;
    }

    public void setSsTraceabilityListContractedfarmersAward(String ssTraceabilityListContractedfarmersAward) {
        this.ssTraceabilityListContractedfarmersAward = ssTraceabilityListContractedfarmersAward;
    }

    public String getTraceabilityListContractedfarmersTimeline() {
        return traceabilityListContractedfarmersTimeline;
    }

    public void setTraceabilityListContractedfarmersTimeline(String traceabilityListContractedfarmersTimeline) {
        this.traceabilityListContractedfarmersTimeline = traceabilityListContractedfarmersTimeline;
    }

    public String getTraceabilityListContractedfarmersRemarks() {
        return traceabilityListContractedfarmersRemarks;
    }

    public void setTraceabilityListContractedfarmersRemarks(String traceabilityListContractedfarmersRemarks) {
        this.traceabilityListContractedfarmersRemarks = traceabilityListContractedfarmersRemarks;
    }

    public String getIsDeclaremarketingAgent() {
        return isDeclaremarketingAgent;
    }

    public void setIsDeclaremarketingAgent(String isDeclaremarketingAgent) {
        this.isDeclaremarketingAgent = isDeclaremarketingAgent;
    }

    public String getSsDeclaremarketingAgentAward() {
        return ssDeclaremarketingAgentAward;
    }

    public void setSsDeclaremarketingAgentAward(String ssDeclaremarketingAgentAward) {
        this.ssDeclaremarketingAgentAward = ssDeclaremarketingAgentAward;
    }

    public String getDeclaremarketingAgentTimeline() {
        return declaremarketingAgentTimeline;
    }

    public void setDeclaremarketingAgentTimeline(String declaremarketingAgentTimeline) {
        this.declaremarketingAgentTimeline = declaremarketingAgentTimeline;
    }

    public String getDeclaremarketingAgentREmarks() {
        return declaremarketingAgentREmarks;
    }

    public void setDeclaremarketingAgentREmarks(String declaremarketingAgentREmarks) {
        this.declaremarketingAgentREmarks = declaremarketingAgentREmarks;
    }

    public String getIsUtilizationofHCD() {
        return isUtilizationofHCD;
    }

    public void setIsUtilizationofHCD(String isUtilizationofHCD) {
        this.isUtilizationofHCD = isUtilizationofHCD;
    }

    public String getSsUtilizationofHCDAward() {
        return ssUtilizationofHCDAward;
    }

    public void setSsUtilizationofHCDAward(String ssUtilizationofHCDAward) {
        this.ssUtilizationofHCDAward = ssUtilizationofHCDAward;
    }

    public String getUtilizationofHCDTimeline() {
        return utilizationofHCDTimeline;
    }

    public void setUtilizationofHCDTimeline(String utilizationofHCDTimeline) {
        this.utilizationofHCDTimeline = utilizationofHCDTimeline;
    }

    public String getUtilizationofHCDRemarks() {
        return utilizationofHCDRemarks;
    }

    public void setUtilizationofHCDRemarks(String utilizationofHCDRemarks) {
        this.utilizationofHCDRemarks = utilizationofHCDRemarks;
    }

    public String getIsSystemPoliceandProcedure() {
        return isSystemPoliceandProcedure;
    }

    public void setIsSystemPoliceandProcedure(String isSystemPoliceandProcedure) {
        this.isSystemPoliceandProcedure = isSystemPoliceandProcedure;
    }

    public String getSsSystemPoliceandProcedureAward() {
        return ssSystemPoliceandProcedureAward;
    }

    public void setSsSystemPoliceandProcedureAward(String ssSystemPoliceandProcedureAward) {
        this.ssSystemPoliceandProcedureAward = ssSystemPoliceandProcedureAward;
    }

    public String getSystemPoliceandProcedureTimeline() {
        return systemPoliceandProcedureTimeline;
    }

    public void setSystemPoliceandProcedureTimeline(String systemPoliceandProcedureTimeline) {
        this.systemPoliceandProcedureTimeline = systemPoliceandProcedureTimeline;
    }

    public String getSystemPoliceandProcedureRemarks() {
        return systemPoliceandProcedureRemarks;
    }

    public void setSystemPoliceandProcedureRemarks(String systemPoliceandProcedureRemarks) {
        this.systemPoliceandProcedureRemarks = systemPoliceandProcedureRemarks;
    }

    public String getIsEvidenceOfatendanceOfAnnualTraining() {
        return isEvidenceOfatendanceOfAnnualTraining;
    }

    public void setIsEvidenceOfatendanceOfAnnualTraining(String isEvidenceOfatendanceOfAnnualTraining) {
        this.isEvidenceOfatendanceOfAnnualTraining = isEvidenceOfatendanceOfAnnualTraining;
    }

    public String getSsEvidenceOfatendanceOfAnnualTrainingAward() {
        return ssEvidenceOfatendanceOfAnnualTrainingAward;
    }

    public void setSsEvidenceOfatendanceOfAnnualTrainingAward(String ssEvidenceOfatendanceOfAnnualTrainingAward) {
        this.ssEvidenceOfatendanceOfAnnualTrainingAward = ssEvidenceOfatendanceOfAnnualTrainingAward;
    }

    public String getEvidenceOfatendanceOfAnnualTraininAwardTimeline() {
        return evidenceOfatendanceOfAnnualTraininAwardTimeline;
    }

    public void setEvidenceOfatendanceOfAnnualTraininAwardTimeline(String evidenceOfatendanceOfAnnualTraininAwardTimeline) {
        this.evidenceOfatendanceOfAnnualTraininAwardTimeline = evidenceOfatendanceOfAnnualTraininAwardTimeline;
    }

    public String getEvidenceOfatendanceOfAnnualTrainingRemarks() {
        return evidenceOfatendanceOfAnnualTrainingRemarks;
    }

    public void setEvidenceOfatendanceOfAnnualTrainingRemarks(String evidenceOfatendanceOfAnnualTrainingRemarks) {
        this.evidenceOfatendanceOfAnnualTrainingRemarks = evidenceOfatendanceOfAnnualTrainingRemarks;
    }

    public String getIsAnnualTrainingmatrixSchedule() {
        return isAnnualTrainingmatrixSchedule;
    }

    public void setIsAnnualTrainingmatrixSchedule(String isAnnualTrainingmatrixSchedule) {
        this.isAnnualTrainingmatrixSchedule = isAnnualTrainingmatrixSchedule;
    }

    public String getSsAnnualTrainingmatrixScheduleAward() {
        return ssAnnualTrainingmatrixScheduleAward;
    }

    public void setSsAnnualTrainingmatrixScheduleAward(String ssAnnualTrainingmatrixScheduleAward) {
        this.ssAnnualTrainingmatrixScheduleAward = ssAnnualTrainingmatrixScheduleAward;
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

    public String getIsPestDiseasecontrolProcedures() {
        return isPestDiseasecontrolProcedures;
    }

    public void setIsPestDiseasecontrolProcedures(String isPestDiseasecontrolProcedures) {
        this.isPestDiseasecontrolProcedures = isPestDiseasecontrolProcedures;
    }

    public String getSsPestDiseasecontrolProceduresAward() {
        return ssPestDiseasecontrolProceduresAward;
    }

    public void setSsPestDiseasecontrolProceduresAward(String ssPestDiseasecontrolProceduresAward) {
        this.ssPestDiseasecontrolProceduresAward = ssPestDiseasecontrolProceduresAward;
    }

    public String getPestDiseasecontrolProceduresTimeline() {
        return pestDiseasecontrolProceduresTimeline;
    }

    public void setPestDiseasecontrolProceduresTimeline(String pestDiseasecontrolProceduresTimeline) {
        this.pestDiseasecontrolProceduresTimeline = pestDiseasecontrolProceduresTimeline;
    }

    public String getPestDiseasecontrolProceduresRemarks() {
        return pestDiseasecontrolProceduresRemarks;
    }

    public void setPestDiseasecontrolProceduresRemarks(String pestDiseasecontrolProceduresRemarks) {
        this.pestDiseasecontrolProceduresRemarks = pestDiseasecontrolProceduresRemarks;
    }

    public String getIsClaimsOnnonPayment() {
        return isClaimsOnnonPayment;
    }

    public void setIsClaimsOnnonPayment(String isClaimsOnnonPayment) {
        this.isClaimsOnnonPayment = isClaimsOnnonPayment;
    }

    public String getSsClaimsOnnonPaymentAward() {
        return ssClaimsOnnonPaymentAward;
    }

    public void setSsClaimsOnnonPaymentAward(String ssClaimsOnnonPaymentAward) {
        this.ssClaimsOnnonPaymentAward = ssClaimsOnnonPaymentAward;
    }

    public String getClaimsOnnonPaymentTimeline() {
        return claimsOnnonPaymentTimeline;
    }

    public void setClaimsOnnonPaymentTimeline(String claimsOnnonPaymentTimeline) {
        this.claimsOnnonPaymentTimeline = claimsOnnonPaymentTimeline;
    }

    public String getClaimsOnnonPaymentRemarks() {
        return claimsOnnonPaymentRemarks;
    }

    public void setClaimsOnnonPaymentRemarks(String claimsOnnonPaymentRemarks) {
        this.claimsOnnonPaymentRemarks = claimsOnnonPaymentRemarks;
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
