package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HCDMangoQualityInspection {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int hcdMangoQualityInspection_id;
    private String documentNumber;
    private String documentdate;
    private String inspectionRequestNo;
    private String exportersName;
    private String exportersAgentName;
    private String sizeOfConsignment;
    private String localID;
    private String isLatexstains;
    private String latexStainsRemarks;
    private String isyellow;
    private String isgreen;
    private String isfleshYellow;
    private String isfleshWhitesh;
    private String isfleshFirmness;
    private String fleshColorRemarks;
    private String iswoundDamage;
    private String woundDamageRemarks;
    private String isdiscoloration;
    private String discolorationRemarks;
    private String isStalkpressure;
    private String stalkPressureRemarks;
    private String fruitSizing;
    private String isvariety;
    private String varietyRemarks;
    private String ishassFleshColorCreamy;
    private String colorRemarks;
    private String issize;
    private String sizeRemarks;
    private String isforeignMatterpresen;
    private String foreignMatterPresentRemarks;
    private String isMoistureonFruits;
    private String moistureonFruitsRemarks;
    private String isLostHarvesttreatment;
    private String lostHarvesttreatmentRemarks;
    private String comments;
    private String officerrecommendation;
    private String officerrecommendation_remark;

    private boolean is_synced;
    private String remote_id;

    public HCDMangoQualityInspection(int hcdMangoQualityInspection_id, String documentNumber, String documentdate, String inspectionRequestNo, String exportersName, String exportersAgentName, String sizeOfConsignment, String localID, String isLatexstains, String latexStainsRemarks, String isyellow, String isgreen, String isfleshYellow, String isfleshWhitesh, String isfleshFirmness, String fleshColorRemarks, String iswoundDamage, String woundDamageRemarks, String isdiscoloration, String discolorationRemarks, String isStalkpressure, String stalkPressureRemarks, String fruitSizing, String isvariety, String varietyRemarks, String ishassFleshColorCreamy, String colorRemarks, String issize, String sizeRemarks, String isforeignMatterpresen, String foreignMatterPresentRemarks, String isMoistureonFruits, String moistureonFruitsRemarks, String isLostHarvesttreatment, String lostHarvesttreatmentRemarks, String comments, String officerrecommendation, String officerrecommendation_remark, boolean is_synced, String remote_id) {
        this.hcdMangoQualityInspection_id = hcdMangoQualityInspection_id;
        this.documentNumber = documentNumber;
        this.documentdate = documentdate;
        this.inspectionRequestNo = inspectionRequestNo;
        this.exportersName = exportersName;
        this.exportersAgentName = exportersAgentName;
        this.sizeOfConsignment = sizeOfConsignment;
        this.localID = localID;
        this.isLatexstains = isLatexstains;
        this.latexStainsRemarks = latexStainsRemarks;
        this.isyellow = isyellow;
        this.isgreen = isgreen;
        this.isfleshYellow = isfleshYellow;
        this.isfleshWhitesh = isfleshWhitesh;
        this.isfleshFirmness = isfleshFirmness;
        this.fleshColorRemarks = fleshColorRemarks;
        this.iswoundDamage = iswoundDamage;
        this.woundDamageRemarks = woundDamageRemarks;
        this.isdiscoloration = isdiscoloration;
        this.discolorationRemarks = discolorationRemarks;
        this.isStalkpressure = isStalkpressure;
        this.stalkPressureRemarks = stalkPressureRemarks;
        this.fruitSizing = fruitSizing;
        this.isvariety = isvariety;
        this.varietyRemarks = varietyRemarks;
        this.ishassFleshColorCreamy = ishassFleshColorCreamy;
        this.colorRemarks = colorRemarks;
        this.issize = issize;
        this.sizeRemarks = sizeRemarks;
        this.isforeignMatterpresen = isforeignMatterpresen;
        this.foreignMatterPresentRemarks = foreignMatterPresentRemarks;
        this.isMoistureonFruits = isMoistureonFruits;
        this.moistureonFruitsRemarks = moistureonFruitsRemarks;
        this.isLostHarvesttreatment = isLostHarvesttreatment;
        this.lostHarvesttreatmentRemarks = lostHarvesttreatmentRemarks;
        this.comments = comments;
        this.officerrecommendation = officerrecommendation;
        this.officerrecommendation_remark = officerrecommendation_remark;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getHcdMangoQualityInspection_id() {
        return hcdMangoQualityInspection_id;
    }

    public void setHcdMangoQualityInspection_id(int hcdMangoQualityInspection_id) {
        this.hcdMangoQualityInspection_id = hcdMangoQualityInspection_id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentdate() {
        return documentdate;
    }

    public void setDocumentdate(String documentdate) {
        this.documentdate = documentdate;
    }

    public String getInspectionRequestNo() {
        return inspectionRequestNo;
    }

    public void setInspectionRequestNo(String inspectionRequestNo) {
        this.inspectionRequestNo = inspectionRequestNo;
    }

    public String getExportersName() {
        return exportersName;
    }

    public void setExportersName(String exportersName) {
        this.exportersName = exportersName;
    }

    public String getExportersAgentName() {
        return exportersAgentName;
    }

    public void setExportersAgentName(String exportersAgentName) {
        this.exportersAgentName = exportersAgentName;
    }

    public String getSizeOfConsignment() {
        return sizeOfConsignment;
    }

    public void setSizeOfConsignment(String sizeOfConsignment) {
        this.sizeOfConsignment = sizeOfConsignment;
    }

    public String getIsLatexstains() {
        return isLatexstains;
    }

    public void setIsLatexstains(String isLatexstains) {
        this.isLatexstains = isLatexstains;
    }

    public String getLatexStainsRemarks() {
        return latexStainsRemarks;
    }

    public void setLatexStainsRemarks(String latexStainsRemarks) {
        this.latexStainsRemarks = latexStainsRemarks;
    }

    public String getIsyellow() {
        return isyellow;
    }

    public void setIsyellow(String isyellow) {
        this.isyellow = isyellow;
    }

    public String getIsgreen() {
        return isgreen;
    }

    public void setIsgreen(String isgreen) {
        this.isgreen = isgreen;
    }

    public String getIsfleshYellow() {
        return isfleshYellow;
    }

    public void setIsfleshYellow(String isfleshYellow) {
        this.isfleshYellow = isfleshYellow;
    }

    public String getIsfleshWhitesh() {
        return isfleshWhitesh;
    }

    public void setIsfleshWhitesh(String isfleshWhitesh) {
        this.isfleshWhitesh = isfleshWhitesh;
    }

    public String getIsfleshFirmness() {
        return isfleshFirmness;
    }

    public void setIsfleshFirmness(String isfleshFirmness) {
        this.isfleshFirmness = isfleshFirmness;
    }

    public String getFleshColorRemarks() {
        return fleshColorRemarks;
    }

    public void setFleshColorRemarks(String fleshColorRemarks) {
        this.fleshColorRemarks = fleshColorRemarks;
    }

    public String getIswoundDamage() {
        return iswoundDamage;
    }

    public void setIswoundDamage(String iswoundDamage) {
        this.iswoundDamage = iswoundDamage;
    }

    public String getWoundDamageRemarks() {
        return woundDamageRemarks;
    }

    public void setWoundDamageRemarks(String woundDamageRemarks) {
        this.woundDamageRemarks = woundDamageRemarks;
    }

    public String getIsdiscoloration() {
        return isdiscoloration;
    }

    public void setIsdiscoloration(String isdiscoloration) {
        this.isdiscoloration = isdiscoloration;
    }

    public String getDiscolorationRemarks() {
        return discolorationRemarks;
    }

    public void setDiscolorationRemarks(String discolorationRemarks) {
        this.discolorationRemarks = discolorationRemarks;
    }

    public String getIsStalkpressure() {
        return isStalkpressure;
    }

    public void setIsStalkpressure(String isStalkpressure) {
        this.isStalkpressure = isStalkpressure;
    }

    public String getStalkPressureRemarks() {
        return stalkPressureRemarks;
    }

    public void setStalkPressureRemarks(String stalkPressureRemarks) {
        this.stalkPressureRemarks = stalkPressureRemarks;
    }

    public String getFruitSizing() {
        return fruitSizing;
    }

    public void setFruitSizing(String fruitSizing) {
        this.fruitSizing = fruitSizing;
    }

    public String getIsvariety() {
        return isvariety;
    }

    public void setIsvariety(String isvariety) {
        this.isvariety = isvariety;
    }

    public String getVarietyRemarks() {
        return varietyRemarks;
    }

    public void setVarietyRemarks(String varietyRemarks) {
        this.varietyRemarks = varietyRemarks;
    }

    public String getIshassFleshColorCreamy() {
        return ishassFleshColorCreamy;
    }

    public void setIshassFleshColorCreamy(String ishassFleshColorCreamy) {
        this.ishassFleshColorCreamy = ishassFleshColorCreamy;
    }

    public String getColorRemarks() {
        return colorRemarks;
    }

    public void setColorRemarks(String colorRemarks) {
        this.colorRemarks = colorRemarks;
    }

    public String getIssize() {
        return issize;
    }

    public void setIssize(String issize) {
        this.issize = issize;
    }

    public String getSizeRemarks() {
        return sizeRemarks;
    }

    public void setSizeRemarks(String sizeRemarks) {
        this.sizeRemarks = sizeRemarks;
    }

    public String getIsforeignMatterpresen() {
        return isforeignMatterpresen;
    }

    public void setIsforeignMatterpresen(String isforeignMatterpresen) {
        this.isforeignMatterpresen = isforeignMatterpresen;
    }

    public String getForeignMatterPresentRemarks() {
        return foreignMatterPresentRemarks;
    }

    public void setForeignMatterPresentRemarks(String foreignMatterPresentRemarks) {
        this.foreignMatterPresentRemarks = foreignMatterPresentRemarks;
    }

    public String getIsMoistureonFruits() {
        return isMoistureonFruits;
    }

    public void setIsMoistureonFruits(String isMoistureonFruits) {
        this.isMoistureonFruits = isMoistureonFruits;
    }

    public String getMoistureonFruitsRemarks() {
        return moistureonFruitsRemarks;
    }

    public void setMoistureonFruitsRemarks(String moistureonFruitsRemarks) {
        this.moistureonFruitsRemarks = moistureonFruitsRemarks;
    }

    public String getIsLostHarvesttreatment() {
        return isLostHarvesttreatment;
    }

    public void setIsLostHarvesttreatment(String isLostHarvesttreatment) {
        this.isLostHarvesttreatment = isLostHarvesttreatment;
    }

    public String getLostHarvesttreatmentRemarks() {
        return lostHarvesttreatmentRemarks;
    }

    public void setLostHarvesttreatmentRemarks(String lostHarvesttreatmentRemarks) {
        this.lostHarvesttreatmentRemarks = lostHarvesttreatmentRemarks;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
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
