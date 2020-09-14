package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class AvocadoQualityInspection implements java.io.Serializable{

    private String serverRecordID;

    private LoginRequest loginRequest;

    private String serviceType="quareyAvocadoQualityInspection";
    private String AFA_HCD_Avocado_Quality_Inspection_ID;
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
    private String isFleshcolorCreamy;
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
    private String isHassfleshColorCreamy;
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

    public AvocadoQualityInspection() {
    }

    public AvocadoQualityInspection(String documentNumber, String documentDate, String nameOfApplicant, String horticultureExporterRequest, String fax, String locationOfProduce, String telephone, String exportersAgentName, String sizeOfConsignment, String designation, String AFA_HCD_Avocado_Quality_Inspection_ID) {
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
        this.AFA_HCD_Avocado_Quality_Inspection_ID = AFA_HCD_Avocado_Quality_Inspection_ID;
    }

    public String getServerRecordID() {
        return serverRecordID;
    }

    public void setServerRecordID(String serverRecordID) {
        this.serverRecordID = serverRecordID;
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

    public String getAFA_HCD_Avocado_Quality_Inspection_ID() {
        return AFA_HCD_Avocado_Quality_Inspection_ID;
    }

    public void setAFA_HCD_Avocado_Quality_Inspection_ID(String AFA_HCD_Avocado_Quality_Inspection_ID) {
        this.AFA_HCD_Avocado_Quality_Inspection_ID = AFA_HCD_Avocado_Quality_Inspection_ID;
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

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
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

    public String getIsFleshcolorCreamy() {
        return isFleshcolorCreamy;
    }

    public void setIsFleshcolorCreamy(String isFleshcolorCreamy) {
        this.isFleshcolorCreamy = isFleshcolorCreamy;
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

    public String getIsHassfleshColorCreamy() {
        return isHassfleshColorCreamy;
    }

    public void setIsHassfleshColorCreamy(String isHassfleshColorCreamy) {
        this.isHassfleshColorCreamy = isHassfleshColorCreamy;
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
