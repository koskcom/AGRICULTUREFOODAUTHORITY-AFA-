package co.ke.bsl.data.view;

public class FCDCottonBuyingStoreInspectionBus {
    private static FCDCottonBuyingStoreInspectionBus single_instance = null;

    private FCDCottonBuyingStoreInspectionBus() {
    }

    public static FCDCottonBuyingStoreInspectionBus getInstance() {
        if (single_instance == null)
            single_instance = new FCDCottonBuyingStoreInspectionBus();

        return single_instance;
    }

    public static FCDCottonBuyingStoreInspectionBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(FCDCottonBuyingStoreInspectionBus single_instance) {
        FCDCottonBuyingStoreInspectionBus.single_instance = single_instance;
    }
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String cottonExportNumber;
    private String localID;
    private String nameOfOperator;
    private String isSurroundingsofBuyingSanitaryCondition;
    private String surroundingsofBuyingSanitaryConditionRemarks;
    private String isFloorWellsurfaced;
    private String floorWellsurfacedRemarks;
    private String isGradeBoxapproved;
    private String gradeBoxapprovedRemarks;
    private String isCertifiedWeighingscale;
    private String certifiedWeighingScaleRemarks;
    private String isCottonBuyercenterQualified;
    private String cottonBuyercenterQualifiedRemarks;
    private String isFirePrecauionarymeasure;
    private String firePrecauionarymeasureRemarks;
    private String isProperlyclean;
    private String properlycleanRemarks;
    private String isintact;
    private String intactRemarks;
    private String isfumigated;
    private String fumigatedRemarks;
    private String ar;
    private String br;
    private String recommendaion;
    private String reasonForThegiveReccomm;

    public FCDCottonBuyingStoreInspectionBus(String documentNumber, String documentDate, String nameOfApplicant, String cottonExportNumber) {
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.cottonExportNumber = cottonExportNumber;
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

    public String getCottonExportNumber() {
        return cottonExportNumber;
    }

    public void setCottonExportNumber(String cottonExportNumber) {
        this.cottonExportNumber = cottonExportNumber;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getNameOfOperator() {
        return nameOfOperator;
    }

    public void setNameOfOperator(String nameOfOperator) {
        this.nameOfOperator = nameOfOperator;
    }

    public String getIsSurroundingsofBuyingSanitaryCondition() {
        return isSurroundingsofBuyingSanitaryCondition;
    }

    public void setIsSurroundingsofBuyingSanitaryCondition(String isSurroundingsofBuyingSanitaryCondition) {
        this.isSurroundingsofBuyingSanitaryCondition = isSurroundingsofBuyingSanitaryCondition;
    }

    public String getSurroundingsofBuyingSanitaryConditionRemarks() {
        return surroundingsofBuyingSanitaryConditionRemarks;
    }

    public void setSurroundingsofBuyingSanitaryConditionRemarks(String surroundingsofBuyingSanitaryConditionRemarks) {
        this.surroundingsofBuyingSanitaryConditionRemarks = surroundingsofBuyingSanitaryConditionRemarks;
    }

    public String getIsFloorWellsurfaced() {
        return isFloorWellsurfaced;
    }

    public void setIsFloorWellsurfaced(String isFloorWellsurfaced) {
        this.isFloorWellsurfaced = isFloorWellsurfaced;
    }

    public String getFloorWellsurfacedRemarks() {
        return floorWellsurfacedRemarks;
    }

    public void setFloorWellsurfacedRemarks(String floorWellsurfacedRemarks) {
        this.floorWellsurfacedRemarks = floorWellsurfacedRemarks;
    }

    public String getIsGradeBoxapproved() {
        return isGradeBoxapproved;
    }

    public void setIsGradeBoxapproved(String isGradeBoxapproved) {
        this.isGradeBoxapproved = isGradeBoxapproved;
    }

    public String getGradeBoxapprovedRemarks() {
        return gradeBoxapprovedRemarks;
    }

    public void setGradeBoxapprovedRemarks(String gradeBoxapprovedRemarks) {
        this.gradeBoxapprovedRemarks = gradeBoxapprovedRemarks;
    }

    public String getIsCertifiedWeighingscale() {
        return isCertifiedWeighingscale;
    }

    public void setIsCertifiedWeighingscale(String isCertifiedWeighingscale) {
        this.isCertifiedWeighingscale = isCertifiedWeighingscale;
    }

    public String getCertifiedWeighingScaleRemarks() {
        return certifiedWeighingScaleRemarks;
    }

    public void setCertifiedWeighingScaleRemarks(String certifiedWeighingScaleRemarks) {
        this.certifiedWeighingScaleRemarks = certifiedWeighingScaleRemarks;
    }

    public String getIsCottonBuyercenterQualified() {
        return isCottonBuyercenterQualified;
    }

    public void setIsCottonBuyercenterQualified(String isCottonBuyercenterQualified) {
        this.isCottonBuyercenterQualified = isCottonBuyercenterQualified;
    }

    public String getCottonBuyercenterQualifiedRemarks() {
        return cottonBuyercenterQualifiedRemarks;
    }

    public void setCottonBuyercenterQualifiedRemarks(String cottonBuyercenterQualifiedRemarks) {
        this.cottonBuyercenterQualifiedRemarks = cottonBuyercenterQualifiedRemarks;
    }

    public String getIsFirePrecauionarymeasure() {
        return isFirePrecauionarymeasure;
    }

    public void setIsFirePrecauionarymeasure(String isFirePrecauionarymeasure) {
        this.isFirePrecauionarymeasure = isFirePrecauionarymeasure;
    }

    public String getFirePrecauionarymeasureRemarks() {
        return firePrecauionarymeasureRemarks;
    }

    public void setFirePrecauionarymeasureRemarks(String firePrecauionarymeasureRemarks) {
        this.firePrecauionarymeasureRemarks = firePrecauionarymeasureRemarks;
    }

    public String getIsProperlyclean() {
        return isProperlyclean;
    }

    public void setIsProperlyclean(String isProperlyclean) {
        this.isProperlyclean = isProperlyclean;
    }

    public String getProperlycleanRemarks() {
        return properlycleanRemarks;
    }

    public void setProperlycleanRemarks(String properlycleanRemarks) {
        this.properlycleanRemarks = properlycleanRemarks;
    }

    public String getIsintact() {
        return isintact;
    }

    public void setIsintact(String isintact) {
        this.isintact = isintact;
    }

    public String getIntactRemarks() {
        return intactRemarks;
    }

    public void setIntactRemarks(String intactRemarks) {
        this.intactRemarks = intactRemarks;
    }

    public String getIsfumigated() {
        return isfumigated;
    }

    public void setIsfumigated(String isfumigated) {
        this.isfumigated = isfumigated;
    }

    public String getFumigatedRemarks() {
        return fumigatedRemarks;
    }

    public void setFumigatedRemarks(String fumigatedRemarks) {
        this.fumigatedRemarks = fumigatedRemarks;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getBr() {
        return br;
    }

    public void setBr(String br) {
        this.br = br;
    }

    public String getRecommendaion() {
        return recommendaion;
    }

    public void setRecommendaion(String recommendaion) {
        this.recommendaion = recommendaion;
    }

    public String getReasonForThegiveReccomm() {
        return reasonForThegiveReccomm;
    }

    public void setReasonForThegiveReccomm(String reasonForThegiveReccomm) {
        this.reasonForThegiveReccomm = reasonForThegiveReccomm;
    }
}
