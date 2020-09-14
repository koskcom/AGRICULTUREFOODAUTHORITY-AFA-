package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

import java.io.Serializable;

public class CottonLintClassingReport implements Serializable {

    private LoginRequest loginRequest;

    private String serviceType = "QueryCottonLintClassingReport";

    private String sentStatus;

    private String AFA_Cotton_Lint_Classing_Report_ID;

    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String lintLicence;
    private String localId;
    private String sampleIdentification;
    private String analysisDate;
    private String origin;
    private String micronaire;
    private String lengthInches;
    private String lengthMillimeters;
    private String uniformityIndex;
    private String strength;
    private String colorRd;
    private String colorB;
    private String colorGrade;
    private String remarks;



    public CottonLintClassingReport(String documentNumber, String documentDate, String nameOfApplicant, String lintLicence) {
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.lintLicence = lintLicence;
    }

    public CottonLintClassingReport() {
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

    public String getAFA_Cotton_Lint_Classing_Report_ID() {
        return AFA_Cotton_Lint_Classing_Report_ID;
    }

    public void setAFA_Cotton_Lint_Classing_Report_ID(String AFA_Cotton_Lint_Classing_Report_ID) {
        this.AFA_Cotton_Lint_Classing_Report_ID = AFA_Cotton_Lint_Classing_Report_ID;
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

    public String getLintLicence() {
        return lintLicence;
    }

    public void setLintLicence(String lintLicence) {
        this.lintLicence = lintLicence;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getSampleIdentification() {
        return sampleIdentification;
    }

    public void setSampleIdentification(String sampleIdentification) {
        this.sampleIdentification = sampleIdentification;
    }

    public String getAnalysisDate() {
        return analysisDate;
    }

    public void setAnalysisDate(String analysisDate) {
        this.analysisDate = analysisDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMicronaire() {
        return micronaire;
    }

    public void setMicronaire(String micronaire) {
        this.micronaire = micronaire;
    }

    public String getLengthInches() {
        return lengthInches;
    }

    public void setLengthInches(String lengthInches) {
        this.lengthInches = lengthInches;
    }

    public String getLengthMillimeters() {
        return lengthMillimeters;
    }

    public void setLengthMillimeters(String lengthMillimeters) {
        this.lengthMillimeters = lengthMillimeters;
    }

    public String getUniformityIndex() {
        return uniformityIndex;
    }

    public void setUniformityIndex(String uniformityIndex) {
        this.uniformityIndex = uniformityIndex;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getColorRd() {
        return colorRd;
    }

    public void setColorRd(String colorRd) {
        this.colorRd = colorRd;
    }

    public String getColorB() {
        return colorB;
    }

    public void setColorB(String colorB) {
        this.colorB = colorB;
    }

    public String getColorGrade() {
        return colorGrade;
    }

    public void setColorGrade(String colorGrade) {
        this.colorGrade = colorGrade;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
