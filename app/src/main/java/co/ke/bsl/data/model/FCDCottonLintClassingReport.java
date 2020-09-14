package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FCDCottonLintClassingReport {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int fcd_cotton_lint_classing_report_id;
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

    private boolean is_synced;
    private String remote_id;

    public FCDCottonLintClassingReport(int fcd_cotton_lint_classing_report_id, String documentNumber, String documentDate, String nameOfApplicant, String lintLicence, String localId, String sampleIdentification, String analysisDate, String origin, String micronaire, String lengthInches, String lengthMillimeters, String uniformityIndex, String strength, String colorRd, String colorB, String colorGrade, String remarks, boolean is_synced, String remote_id) {
        this.fcd_cotton_lint_classing_report_id = fcd_cotton_lint_classing_report_id;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.lintLicence = lintLicence;
        this.localId = localId;
        this.sampleIdentification = sampleIdentification;
        this.analysisDate = analysisDate;
        this.origin = origin;
        this.micronaire = micronaire;
        this.lengthInches = lengthInches;
        this.lengthMillimeters = lengthMillimeters;
        this.uniformityIndex = uniformityIndex;
        this.strength = strength;
        this.colorRd = colorRd;
        this.colorB = colorB;
        this.colorGrade = colorGrade;
        this.remarks = remarks;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getFcd_cotton_lint_classing_report_id() {
        return fcd_cotton_lint_classing_report_id;
    }

    public void setFcd_cotton_lint_classing_report_id(int fcd_cotton_lint_classing_report_id) {
        this.fcd_cotton_lint_classing_report_id = fcd_cotton_lint_classing_report_id;
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
