package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;
import androidx.room.Entity;

@Entity
public class HCDAvocadoQualityInspection {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int hcdAvocado_QualityInspection_id;
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String horticultureExporterRequest;
    private String fax;
    private String locationOfProduce;
    private String telephone;
    private String exportersAgentName;
    private String sizeOfConsignment;
    private String designation;
    private String localID;
    private String isFuarteSkinglossyShine;
    private String fuarteSkinglossyShineRemarks;
    private String isFuartecolorGreeWithYelowFint;
    private String fuarteColorGreeWithYelowFintRemarks;
    private String isFuarteskinTextureSmooth;
    private String fuarteSkinTextureSmoothRemarks;
    private String isFuarteFleshcolorCreamyYellow;
    private String fuarteFleshcolorCreamyYellowRemarks;
    private String isHasscolorGreen;
    private String hassColorGreenRemarks;
    private String isHassSkintextureRough;
    private String hassSkinTextureRoughRemarks;
    private String isHassFleshcolorCreamy;
    private String hassFleshColorCreamyRemarks;
    private String isSkinColorgreenToYellow;
    private String skinColorGreenToYellowRemarks;
    private String isSkinsmoothAtBlossom;
    private String skinSmoothAtBlossomRemarks;
    private String isFleshcolorCreamyYellow;
    private String fleshColorCreamyRemarks;
    private String isOilcontent1;
    private String oilContent1Remarks;
    private String isStalkpressence;
    private String stalkPressenceRemarks;
    private String isWoundsdamage;
    private String woundsDamageRemarks;
    private String isDiscoloration;
    private String discolourationRemarks;
    private String fruitSizing;
    private String isvariety;
    private String varietyRemarks;
    private String isfleshColorCreamy;
    private String colorRemarks;
    private String issize;
    private String sizeRemarks;
    private String isFruitfirm;
    private String fruitFirmRemarks;
    private String isForeignmatterPresent;
    private String foreignMatterPresentRemarks;
    private String isMoistureonFruits;
    private String moistureOnFruitsRemarks;
    private String isPostharvestTreatment;
    private String postHarvestTreatmentRemarks;
    private String comments;
    private String source;
    private String destination;
    private String sampleVariety;
    private String sampleFruitSize;
    private String initialWT;
    private String finalWt;
    private String moistureContentIWFW;
    private String moistureContentPercetage;
    private String oilContent;
    private String remarks;
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private boolean is_synced;
    private String remote_id;

    public HCDAvocadoQualityInspection(int hcdAvocado_QualityInspection_id, String documentNumber, String documentDate, String nameOfApplicant, String horticultureExporterRequest, String fax, String locationOfProduce, String telephone, String exportersAgentName, String sizeOfConsignment, String designation, String localID, String isFuarteSkinglossyShine, String fuarteSkinglossyShineRemarks, String isFuartecolorGreeWithYelowFint, String fuarteColorGreeWithYelowFintRemarks, String isFuarteskinTextureSmooth, String fuarteSkinTextureSmoothRemarks, String isFuarteFleshcolorCreamyYellow, String fuarteFleshcolorCreamyYellowRemarks, String isHasscolorGreen, String hassColorGreenRemarks, String isHassSkintextureRough, String hassSkinTextureRoughRemarks, String isHassFleshcolorCreamy, String hassFleshColorCreamyRemarks, String isSkinColorgreenToYellow, String skinColorGreenToYellowRemarks, String isSkinsmoothAtBlossom, String skinSmoothAtBlossomRemarks, String isFleshcolorCreamyYellow, String fleshColorCreamyRemarks, String isOilcontent1, String oilContent1Remarks, String isStalkpressence, String stalkPressenceRemarks, String isWoundsdamage, String woundsDamageRemarks, String isDiscoloration, String discolourationRemarks, String fruitSizing, String isvariety, String varietyRemarks, String isfleshColorCreamy, String colorRemarks, String issize, String sizeRemarks, String isFruitfirm, String fruitFirmRemarks, String isForeignmatterPresent, String foreignMatterPresentRemarks, String isMoistureonFruits, String moistureOnFruitsRemarks, String isPostharvestTreatment, String postHarvestTreatmentRemarks, String comments, String source, String destination, String sampleVariety, String sampleFruitSize, String initialWT, String finalWt, String moistureContentIWFW, String moistureContentPercetage, String oilContent, String remarks, String officerrecommendation, String officerrecommendation_remark, boolean is_synced, String remote_id) {
        this.hcdAvocado_QualityInspection_id = hcdAvocado_QualityInspection_id;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.horticultureExporterRequest = horticultureExporterRequest;
        this.fax = fax;
        this.locationOfProduce = locationOfProduce;
        this.telephone = telephone;
        this.exportersAgentName = exportersAgentName;
        this.sizeOfConsignment = sizeOfConsignment;
        this.designation = designation;
        this.localID = localID;
        this.isFuarteSkinglossyShine = isFuarteSkinglossyShine;
        this.fuarteSkinglossyShineRemarks = fuarteSkinglossyShineRemarks;
        this.isFuartecolorGreeWithYelowFint = isFuartecolorGreeWithYelowFint;
        this.fuarteColorGreeWithYelowFintRemarks = fuarteColorGreeWithYelowFintRemarks;
        this.isFuarteskinTextureSmooth = isFuarteskinTextureSmooth;
        this.fuarteSkinTextureSmoothRemarks = fuarteSkinTextureSmoothRemarks;
        this.isFuarteFleshcolorCreamyYellow = isFuarteFleshcolorCreamyYellow;
        this.fuarteFleshcolorCreamyYellowRemarks = fuarteFleshcolorCreamyYellowRemarks;
        this.isHasscolorGreen = isHasscolorGreen;
        this.hassColorGreenRemarks = hassColorGreenRemarks;
        this.isHassSkintextureRough = isHassSkintextureRough;
        this.hassSkinTextureRoughRemarks = hassSkinTextureRoughRemarks;
        this.isHassFleshcolorCreamy = isHassFleshcolorCreamy;
        this.hassFleshColorCreamyRemarks = hassFleshColorCreamyRemarks;
        this.isSkinColorgreenToYellow = isSkinColorgreenToYellow;
        this.skinColorGreenToYellowRemarks = skinColorGreenToYellowRemarks;
        this.isSkinsmoothAtBlossom = isSkinsmoothAtBlossom;
        this.skinSmoothAtBlossomRemarks = skinSmoothAtBlossomRemarks;
        this.isFleshcolorCreamyYellow = isFleshcolorCreamyYellow;
        this.fleshColorCreamyRemarks = fleshColorCreamyRemarks;
        this.isOilcontent1 = isOilcontent1;
        this.oilContent1Remarks = oilContent1Remarks;
        this.isStalkpressence = isStalkpressence;
        this.stalkPressenceRemarks = stalkPressenceRemarks;
        this.isWoundsdamage = isWoundsdamage;
        this.woundsDamageRemarks = woundsDamageRemarks;
        this.isDiscoloration = isDiscoloration;
        this.discolourationRemarks = discolourationRemarks;
        this.fruitSizing = fruitSizing;
        this.isvariety = isvariety;
        this.varietyRemarks = varietyRemarks;
        this.isfleshColorCreamy = isfleshColorCreamy;
        this.colorRemarks = colorRemarks;
        this.issize = issize;
        this.sizeRemarks = sizeRemarks;
        this.isFruitfirm = isFruitfirm;
        this.fruitFirmRemarks = fruitFirmRemarks;
        this.isForeignmatterPresent = isForeignmatterPresent;
        this.foreignMatterPresentRemarks = foreignMatterPresentRemarks;
        this.isMoistureonFruits = isMoistureonFruits;
        this.moistureOnFruitsRemarks = moistureOnFruitsRemarks;
        this.isPostharvestTreatment = isPostharvestTreatment;
        this.postHarvestTreatmentRemarks = postHarvestTreatmentRemarks;
        this.comments = comments;
        this.source = source;
        this.destination = destination;
        this.sampleVariety = sampleVariety;
        this.sampleFruitSize = sampleFruitSize;
        this.initialWT = initialWT;
        this.finalWt = finalWt;
        this.moistureContentIWFW = moistureContentIWFW;
        this.moistureContentPercetage = moistureContentPercetage;
        this.oilContent = oilContent;
        this.remarks = remarks;
        this.officerrecommendation = officerrecommendation;
        this.officerrecommendation_remark = officerrecommendation_remark;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public int getHcdAvocado_QualityInspection_id() {
        return hcdAvocado_QualityInspection_id;
    }

    public void setHcdAvocado_QualityInspection_id(int hcdAvocado_QualityInspection_id) {
        this.hcdAvocado_QualityInspection_id = hcdAvocado_QualityInspection_id;
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

    public String getHorticultureExporterRequest() {
        return horticultureExporterRequest;
    }

    public void setHorticultureExporterRequest(String horticultureExporterRequest) {
        this.horticultureExporterRequest = horticultureExporterRequest;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLocationOfProduce() {
        return locationOfProduce;
    }

    public void setLocationOfProduce(String locationOfProduce) {
        this.locationOfProduce = locationOfProduce;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }



    public String getIsFuarteSkinglossyShine() {
        return isFuarteSkinglossyShine;
    }

    public void setIsFuarteSkinglossyShine(String isFuarteSkinglossyShine) {
        this.isFuarteSkinglossyShine = isFuarteSkinglossyShine;
    }

    public String getFuarteSkinglossyShineRemarks() {
        return fuarteSkinglossyShineRemarks;
    }

    public void setFuarteSkinglossyShineRemarks(String fuarteSkinglossyShineRemarks) {
        this.fuarteSkinglossyShineRemarks = fuarteSkinglossyShineRemarks;
    }

    public String getIsFuartecolorGreeWithYelowFint() {
        return isFuartecolorGreeWithYelowFint;
    }

    public void setIsFuartecolorGreeWithYelowFint(String isFuartecolorGreeWithYelowFint) {
        this.isFuartecolorGreeWithYelowFint = isFuartecolorGreeWithYelowFint;
    }

    public String getFuarteColorGreeWithYelowFintRemarks() {
        return fuarteColorGreeWithYelowFintRemarks;
    }

    public void setFuarteColorGreeWithYelowFintRemarks(String fuarteColorGreeWithYelowFintRemarks) {
        this.fuarteColorGreeWithYelowFintRemarks = fuarteColorGreeWithYelowFintRemarks;
    }

    public String getIsFuarteskinTextureSmooth() {
        return isFuarteskinTextureSmooth;
    }

    public void setIsFuarteskinTextureSmooth(String isFuarteskinTextureSmooth) {
        this.isFuarteskinTextureSmooth = isFuarteskinTextureSmooth;
    }

    public String getFuarteSkinTextureSmoothRemarks() {
        return fuarteSkinTextureSmoothRemarks;
    }

    public void setFuarteSkinTextureSmoothRemarks(String fuarteSkinTextureSmoothRemarks) {
        this.fuarteSkinTextureSmoothRemarks = fuarteSkinTextureSmoothRemarks;
    }

    public String getIsFuarteFleshcolorCreamyYellow() {
        return isFuarteFleshcolorCreamyYellow;
    }

    public void setIsFuarteFleshcolorCreamyYellow(String isFuarteFleshcolorCreamyYellow) {
        this.isFuarteFleshcolorCreamyYellow = isFuarteFleshcolorCreamyYellow;
    }

    public String getFuarteFleshcolorCreamyYellowRemarks() {
        return fuarteFleshcolorCreamyYellowRemarks;
    }

    public void setFuarteFleshcolorCreamyYellowRemarks(String fuarteFleshcolorCreamyYellowRemarks) {
        this.fuarteFleshcolorCreamyYellowRemarks = fuarteFleshcolorCreamyYellowRemarks;
    }

    public String getIsHasscolorGreen() {
        return isHasscolorGreen;
    }

    public void setIsHasscolorGreen(String isHasscolorGreen) {
        this.isHasscolorGreen = isHasscolorGreen;
    }

    public String getHassColorGreenRemarks() {
        return hassColorGreenRemarks;
    }

    public void setHassColorGreenRemarks(String hassColorGreenRemarks) {
        this.hassColorGreenRemarks = hassColorGreenRemarks;
    }

    public String getIsHassSkintextureRough() {
        return isHassSkintextureRough;
    }

    public void setIsHassSkintextureRough(String isHassSkintextureRough) {
        this.isHassSkintextureRough = isHassSkintextureRough;
    }

    public String getHassSkinTextureRoughRemarks() {
        return hassSkinTextureRoughRemarks;
    }

    public void setHassSkinTextureRoughRemarks(String hassSkinTextureRoughRemarks) {
        this.hassSkinTextureRoughRemarks = hassSkinTextureRoughRemarks;
    }

    public String getIsHassFleshcolorCreamy() {
        return isHassFleshcolorCreamy;
    }

    public void setIsHassFleshcolorCreamy(String isHassFleshcolorCreamy) {
        this.isHassFleshcolorCreamy = isHassFleshcolorCreamy;
    }

    public String getHassFleshColorCreamyRemarks() {
        return hassFleshColorCreamyRemarks;
    }

    public void setHassFleshColorCreamyRemarks(String hassFleshColorCreamyRemarks) {
        this.hassFleshColorCreamyRemarks = hassFleshColorCreamyRemarks;
    }

    public String getIsSkinColorgreenToYellow() {
        return isSkinColorgreenToYellow;
    }

    public void setIsSkinColorgreenToYellow(String isSkinColorgreenToYellow) {
        this.isSkinColorgreenToYellow = isSkinColorgreenToYellow;
    }

    public String getSkinColorGreenToYellowRemarks() {
        return skinColorGreenToYellowRemarks;
    }

    public void setSkinColorGreenToYellowRemarks(String skinColorGreenToYellowRemarks) {
        this.skinColorGreenToYellowRemarks = skinColorGreenToYellowRemarks;
    }

    public String getIsSkinsmoothAtBlossom() {
        return isSkinsmoothAtBlossom;
    }

    public void setIsSkinsmoothAtBlossom(String isSkinsmoothAtBlossom) {
        this.isSkinsmoothAtBlossom = isSkinsmoothAtBlossom;
    }

    public String getSkinSmoothAtBlossomRemarks() {
        return skinSmoothAtBlossomRemarks;
    }

    public void setSkinSmoothAtBlossomRemarks(String skinSmoothAtBlossomRemarks) {
        this.skinSmoothAtBlossomRemarks = skinSmoothAtBlossomRemarks;
    }

    public String getIsFleshcolorCreamyYellow() {
        return isFleshcolorCreamyYellow;
    }

    public void setIsFleshcolorCreamyYellow(String isFleshcolorCreamyYellow) {
        this.isFleshcolorCreamyYellow = isFleshcolorCreamyYellow;
    }

    public String getFleshColorCreamyRemarks() {
        return fleshColorCreamyRemarks;
    }

    public void setFleshColorCreamyRemarks(String fleshColorCreamyRemarks) {
        this.fleshColorCreamyRemarks = fleshColorCreamyRemarks;
    }

    public String getIsOilcontent1() {
        return isOilcontent1;
    }

    public void setIsOilcontent1(String isOilcontent1) {
        this.isOilcontent1 = isOilcontent1;
    }

    public String getOilContent1Remarks() {
        return oilContent1Remarks;
    }

    public void setOilContent1Remarks(String oilContent1Remarks) {
        this.oilContent1Remarks = oilContent1Remarks;
    }

    public String getIsStalkpressence() {
        return isStalkpressence;
    }

    public void setIsStalkpressence(String isStalkpressence) {
        this.isStalkpressence = isStalkpressence;
    }

    public String getStalkPressenceRemarks() {
        return stalkPressenceRemarks;
    }

    public void setStalkPressenceRemarks(String stalkPressenceRemarks) {
        this.stalkPressenceRemarks = stalkPressenceRemarks;
    }

    public String getIsWoundsdamage() {
        return isWoundsdamage;
    }

    public void setIsWoundsdamage(String isWoundsdamage) {
        this.isWoundsdamage = isWoundsdamage;
    }

    public String getWoundsDamageRemarks() {
        return woundsDamageRemarks;
    }

    public void setWoundsDamageRemarks(String woundsDamageRemarks) {
        this.woundsDamageRemarks = woundsDamageRemarks;
    }

    public String getIsDiscoloration() {
        return isDiscoloration;
    }

    public void setIsDiscoloration(String isDiscoloration) {
        this.isDiscoloration = isDiscoloration;
    }

    public String getDiscolourationRemarks() {
        return discolourationRemarks;
    }

    public void setDiscolourationRemarks(String discolourationRemarks) {
        this.discolourationRemarks = discolourationRemarks;
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

    public String getIsfleshColorCreamy() {
        return isfleshColorCreamy;
    }

    public void setIsfleshColorCreamy(String isfleshColorCreamy) {
        this.isfleshColorCreamy = isfleshColorCreamy;
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

    public String getIsFruitfirm() {
        return isFruitfirm;
    }

    public void setIsFruitfirm(String isFruitfirm) {
        this.isFruitfirm = isFruitfirm;
    }

    public String getFruitFirmRemarks() {
        return fruitFirmRemarks;
    }

    public void setFruitFirmRemarks(String fruitFirmRemarks) {
        this.fruitFirmRemarks = fruitFirmRemarks;
    }

    public String getIsForeignmatterPresent() {
        return isForeignmatterPresent;
    }

    public void setIsForeignmatterPresent(String isForeignmatterPresent) {
        this.isForeignmatterPresent = isForeignmatterPresent;
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

    public String getMoistureOnFruitsRemarks() {
        return moistureOnFruitsRemarks;
    }

    public void setMoistureOnFruitsRemarks(String moistureOnFruitsRemarks) {
        this.moistureOnFruitsRemarks = moistureOnFruitsRemarks;
    }

    public String getIsPostharvestTreatment() {
        return isPostharvestTreatment;
    }

    public void setIsPostharvestTreatment(String isPostharvestTreatment) {
        this.isPostharvestTreatment = isPostharvestTreatment;
    }

    public String getPostHarvestTreatmentRemarks() {
        return postHarvestTreatmentRemarks;
    }

    public void setPostHarvestTreatmentRemarks(String postHarvestTreatmentRemarks) {
        this.postHarvestTreatmentRemarks = postHarvestTreatmentRemarks;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSampleVariety() {
        return sampleVariety;
    }

    public void setSampleVariety(String sampleVariety) {
        this.sampleVariety = sampleVariety;
    }

    public String getSampleFruitSize() {
        return sampleFruitSize;
    }

    public void setSampleFruitSize(String sampleFruitSize) {
        this.sampleFruitSize = sampleFruitSize;
    }

    public String getInitialWT() {
        return initialWT;
    }

    public void setInitialWT(String initialWT) {
        this.initialWT = initialWT;
    }

    public String getFinalWt() {
        return finalWt;
    }

    public void setFinalWt(String finalWt) {
        this.finalWt = finalWt;
    }

    public String getMoistureContentIWFW() {
        return moistureContentIWFW;
    }

    public void setMoistureContentIWFW(String moistureContentIWFW) {
        this.moistureContentIWFW = moistureContentIWFW;
    }

    public String getMoistureContentPercetage() {
        return moistureContentPercetage;
    }

    public void setMoistureContentPercetage(String moistureContentPercetage) {
        this.moistureContentPercetage = moistureContentPercetage;
    }

    public String getOilContent() {
        return oilContent;
    }

    public void setOilContent(String oilContent) {
        this.oilContent = oilContent;
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
