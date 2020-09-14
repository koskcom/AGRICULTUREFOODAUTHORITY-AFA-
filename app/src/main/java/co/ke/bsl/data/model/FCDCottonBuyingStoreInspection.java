package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class FCDCottonBuyingStoreInspection {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int fcd_Cotton_Buying_Store_Inspection_id;
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
    private boolean is_synced;
    private String remote_id;

    public FCDCottonBuyingStoreInspection(int fcd_Cotton_Buying_Store_Inspection_id, String documentNumber, String documentDate, String nameOfApplicant, String cottonExportNumber, String localID, String nameOfOperator, String isSurroundingsofBuyingSanitaryCondition, String surroundingsofBuyingSanitaryConditionRemarks, String isFloorWellsurfaced, String floorWellsurfacedRemarks, String isGradeBoxapproved, String gradeBoxapprovedRemarks, String isCertifiedWeighingscale, String certifiedWeighingScaleRemarks, String isCottonBuyercenterQualified, String cottonBuyercenterQualifiedRemarks, String isFirePrecauionarymeasure, String firePrecauionarymeasureRemarks, String isProperlyclean, String properlycleanRemarks, String isintact, String intactRemarks, String isfumigated, String fumigatedRemarks, String ar, String br, String recommendaion, String reasonForThegiveReccomm, boolean is_synced, String remote_id) {
        this.fcd_Cotton_Buying_Store_Inspection_id = fcd_Cotton_Buying_Store_Inspection_id;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.cottonExportNumber = cottonExportNumber;
        this.localID = localID;
        this.nameOfOperator = nameOfOperator;
        this.isSurroundingsofBuyingSanitaryCondition = isSurroundingsofBuyingSanitaryCondition;
        this.surroundingsofBuyingSanitaryConditionRemarks = surroundingsofBuyingSanitaryConditionRemarks;
        this.isFloorWellsurfaced = isFloorWellsurfaced;
        this.floorWellsurfacedRemarks = floorWellsurfacedRemarks;
        this.isGradeBoxapproved = isGradeBoxapproved;
        this.gradeBoxapprovedRemarks = gradeBoxapprovedRemarks;
        this.isCertifiedWeighingscale = isCertifiedWeighingscale;
        this.certifiedWeighingScaleRemarks = certifiedWeighingScaleRemarks;
        this.isCottonBuyercenterQualified = isCottonBuyercenterQualified;
        this.cottonBuyercenterQualifiedRemarks = cottonBuyercenterQualifiedRemarks;
        this.isFirePrecauionarymeasure = isFirePrecauionarymeasure;
        this.firePrecauionarymeasureRemarks = firePrecauionarymeasureRemarks;
        this.isProperlyclean = isProperlyclean;
        this.properlycleanRemarks = properlycleanRemarks;
        this.isintact = isintact;
        this.intactRemarks = intactRemarks;
        this.isfumigated = isfumigated;
        this.fumigatedRemarks = fumigatedRemarks;
        this.ar = ar;
        this.br = br;
        this.recommendaion = recommendaion;
        this.reasonForThegiveReccomm = reasonForThegiveReccomm;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getFcd_Cotton_Buying_Store_Inspection_id() {
        return fcd_Cotton_Buying_Store_Inspection_id;
    }

    public void setFcd_Cotton_Buying_Store_Inspection_id(int fcd_Cotton_Buying_Store_Inspection_id) {
        this.fcd_Cotton_Buying_Store_Inspection_id = fcd_Cotton_Buying_Store_Inspection_id;
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
