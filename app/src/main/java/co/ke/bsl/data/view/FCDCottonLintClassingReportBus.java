package co.ke.bsl.data.view;

public class FCDCottonLintClassingReportBus {
    private static FCDCottonLintClassingReportBus single_instance = null;

    private FCDCottonLintClassingReportBus() {
    }

    public static FCDCottonLintClassingReportBus getInstance() {
        if (single_instance == null)
            single_instance = new FCDCottonLintClassingReportBus();

        return single_instance;
    }

    public static FCDCottonLintClassingReportBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(FCDCottonLintClassingReportBus single_instance) {
        FCDCottonLintClassingReportBus.single_instance = single_instance;
    }
    private String localId;
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String lintLicence;
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

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
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
