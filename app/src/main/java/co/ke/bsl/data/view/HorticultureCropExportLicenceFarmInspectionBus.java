package co.ke.bsl.data.view;

public class HorticultureCropExportLicenceFarmInspectionBus {
    private static HorticultureCropExportLicenceFarmInspectionBus single_instance = null;

    private HorticultureCropExportLicenceFarmInspectionBus() {
    }

    public static HorticultureCropExportLicenceFarmInspectionBus getInstance() {
        if (single_instance == null)
            single_instance = new HorticultureCropExportLicenceFarmInspectionBus();

        return single_instance;
    }

    public static HorticultureCropExportLicenceFarmInspectionBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(HorticultureCropExportLicenceFarmInspectionBus single_instance) {
        HorticultureCropExportLicenceFarmInspectionBus.single_instance = single_instance;
    }

    private String nameOfApplicant;
    private String isAdhocInspection;
    private String documentNumber;
    private String documentDate;
    private String countyId;
    private String subCountyId;
    private String location;
    private String telephone;
    private String localID;

    private String isExporterOwnFarm;
    private String isContractedSources;
    private String farmName;
    private String farmerName;
    private String farmerIdNumber;
    private String farmerTelephone;
    private String farmerEmail;
    private String farmerCounty;
    private String farmerLocation;
    private String intendedCrop;
    private String acreageUnderCrop;
    private String isCcertificationToGap;
    private String ccertificationToGap;
    private String isDulySigned;
    private String dulySigned;
    private String isProductionPlanPerCrop;
    private String productionPlanPerCrop;
    private String isExporterAware;
    private String exporterAware;
    private String isExporterTrainedPersonnel;
    private String exporterTrainedPersonnel;
    private String isControlledAndApproved;
    private String controlledAndApproved;
    private String isExporterHavePetcide;
    private String exporterHavePetcide;
    private String isFieldCodes;
    private String fieldCodes;
    private String isPlantingDate;
    private String plantingDate;
    private String isChemicalListApproved;
    private String chemicalListApproved;
    private String isPresenceOfApprovedSpray;
    private String presenceOfApprovedSpray;
    private String isProductInvoices;
    private String productInvoices;
    private String isSprayRecords;
    private String sprayRecords;
    private String isTradenameOfProduct;
    private String tradenameOfProduct;
    private String isPhiRecorded;
    private String phiRecorded;
    private String isAllSprayingDates;
    private String allSprayingDates;
    private String isAmountOfPesticide;
    private String amountOfPesticide;
    private String isPhiObserved;
    private String phiObserved;
    private String isTrainingSchedules;
    private String trainingSchedules;
    private String isPestManagementProtocol;
    private String pestManagementProtocol;
    private String isEvidenceOnScouring;
    private String evidenceOnScouring;
    private String isEvidenceOfPests;
    private String evidenceOfPests;
    private String isCollectionShedForFarmers;
    private String collectionShedForFarmers;
    private String isCollectionAndSortingShed;
    private String collectionAndSortingShed;
    private String isAppropriateHygiene;
    private String appropriateHygiene;
    private String isGradingtables;
    private String gradingtables;
    private String isShedHaveRunningWater;
    private String shedHaveRunningWater;
    private String isToiletAtFacility;
    private String toiletAtFacility;
    private String isPpeGraders;
    private String ppeGraders;
    private String isStorageAreaForGraded;
    private String storageAreaForGraded;
    private String isPlasticCrates;
    private String plasticCrates;
    private String isCollectionShedAccessible;
    private String collectionShedAccessible;
    private String isCollectionAreaHaveOffice;
    private String collectionAreaHaveOffice;
    private String isCollectionShedEasy;
    private String collectionShedEasy;
    private String isAdequateLightingAndVentilation;
    private String adequateLightingAndVentilation;
    private String isWasteDisposalFacility;
    private String wasteDisposalFacility;
    private String isRegisterOfAllIncoming;
    private String registerOfAllIncoming;
    private String isProceduresForProduct;
    private String proceduresForProduct;
    private String isPersonnelHandlingProduce;
    private String personnelHandlingProduce;
    private String isAllFarmersRegistered;
    private String allFarmersRegistered;
    private String isPresenceOfTraceability;
    private String presenceOfTraceability;
    private String isAvailabilityOfRegistered;
    private String availabilityOfRegistered;
    private String isTrainingCertificates;
    private String trainingCertificates;
    private String isEvidenceOfTechnical;
    private String evidenceOfTechnical;
    private String comments;
    private String officerrecommendation;
    private String officerrecommendation_remark;


    private boolean is_synced;
    private String remote_id;

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

    public String getIsAdhocInspection() {
        return isAdhocInspection;
    }

    public void setIsAdhocInspection(String isAdhocInspection) {
        this.isAdhocInspection = isAdhocInspection;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getSubCountyId() {
        return subCountyId;
    }

    public void setSubCountyId(String subCountyId) {
        this.subCountyId = subCountyId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getIsExporterOwnFarm() {
        return isExporterOwnFarm;
    }

    public void setIsExporterOwnFarm(String isExporterOwnFarm) {
        this.isExporterOwnFarm = isExporterOwnFarm;
    }

    public String getIsContractedSources() {
        return isContractedSources;
    }

    public void setIsContractedSources(String isContractedSources) {
        this.isContractedSources = isContractedSources;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerIdNumber() {
        return farmerIdNumber;
    }

    public void setFarmerIdNumber(String farmerIdNumber) {
        this.farmerIdNumber = farmerIdNumber;
    }

    public String getFarmerTelephone() {
        return farmerTelephone;
    }

    public void setFarmerTelephone(String farmerTelephone) {
        this.farmerTelephone = farmerTelephone;
    }

    public String getFarmerEmail() {
        return farmerEmail;
    }

    public void setFarmerEmail(String farmerEmail) {
        this.farmerEmail = farmerEmail;
    }

    public String getFarmerCounty() {
        return farmerCounty;
    }

    public void setFarmerCounty(String farmerCounty) {
        this.farmerCounty = farmerCounty;
    }

    public String getFarmerLocation() {
        return farmerLocation;
    }

    public void setFarmerLocation(String farmerLocation) {
        this.farmerLocation = farmerLocation;
    }

    public String getIntendedCrop() {
        return intendedCrop;
    }

    public void setIntendedCrop(String intendedCrop) {
        this.intendedCrop = intendedCrop;
    }

    public String getAcreageUnderCrop() {
        return acreageUnderCrop;
    }

    public void setAcreageUnderCrop(String acreageUnderCrop) {
        this.acreageUnderCrop = acreageUnderCrop;
    }

    public String getIsCcertificationToGap() {
        return isCcertificationToGap;
    }

    public void setIsCcertificationToGap(String isCcertificationToGap) {
        this.isCcertificationToGap = isCcertificationToGap;
    }

    public String getCcertificationToGap() {
        return ccertificationToGap;
    }

    public void setCcertificationToGap(String ccertificationToGap) {
        this.ccertificationToGap = ccertificationToGap;
    }

    public String getIsDulySigned() {
        return isDulySigned;
    }

    public void setIsDulySigned(String isDulySigned) {
        this.isDulySigned = isDulySigned;
    }

    public String getDulySigned() {
        return dulySigned;
    }

    public void setDulySigned(String dulySigned) {
        this.dulySigned = dulySigned;
    }

    public String getIsProductionPlanPerCrop() {
        return isProductionPlanPerCrop;
    }

    public void setIsProductionPlanPerCrop(String isProductionPlanPerCrop) {
        this.isProductionPlanPerCrop = isProductionPlanPerCrop;
    }

    public String getProductionPlanPerCrop() {
        return productionPlanPerCrop;
    }

    public void setProductionPlanPerCrop(String productionPlanPerCrop) {
        this.productionPlanPerCrop = productionPlanPerCrop;
    }

    public String getIsExporterAware() {
        return isExporterAware;
    }

    public void setIsExporterAware(String isExporterAware) {
        this.isExporterAware = isExporterAware;
    }

    public String getExporterAware() {
        return exporterAware;
    }

    public void setExporterAware(String exporterAware) {
        this.exporterAware = exporterAware;
    }

    public String getIsExporterTrainedPersonnel() {
        return isExporterTrainedPersonnel;
    }

    public void setIsExporterTrainedPersonnel(String isExporterTrainedPersonnel) {
        this.isExporterTrainedPersonnel = isExporterTrainedPersonnel;
    }

    public String getExporterTrainedPersonnel() {
        return exporterTrainedPersonnel;
    }

    public void setExporterTrainedPersonnel(String exporterTrainedPersonnel) {
        this.exporterTrainedPersonnel = exporterTrainedPersonnel;
    }

    public String getIsControlledAndApproved() {
        return isControlledAndApproved;
    }

    public void setIsControlledAndApproved(String isControlledAndApproved) {
        this.isControlledAndApproved = isControlledAndApproved;
    }

    public String getControlledAndApproved() {
        return controlledAndApproved;
    }

    public void setControlledAndApproved(String controlledAndApproved) {
        this.controlledAndApproved = controlledAndApproved;
    }

    public String getIsExporterHavePetcide() {
        return isExporterHavePetcide;
    }

    public void setIsExporterHavePetcide(String isExporterHavePetcide) {
        this.isExporterHavePetcide = isExporterHavePetcide;
    }

    public String getExporterHavePetcide() {
        return exporterHavePetcide;
    }

    public void setExporterHavePetcide(String exporterHavePetcide) {
        this.exporterHavePetcide = exporterHavePetcide;
    }

    public String getIsFieldCodes() {
        return isFieldCodes;
    }

    public void setIsFieldCodes(String isFieldCodes) {
        this.isFieldCodes = isFieldCodes;
    }

    public String getFieldCodes() {
        return fieldCodes;
    }

    public void setFieldCodes(String fieldCodes) {
        this.fieldCodes = fieldCodes;
    }

    public String getIsPlantingDate() {
        return isPlantingDate;
    }

    public void setIsPlantingDate(String isPlantingDate) {
        this.isPlantingDate = isPlantingDate;
    }

    public String getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(String plantingDate) {
        this.plantingDate = plantingDate;
    }

    public String getIsChemicalListApproved() {
        return isChemicalListApproved;
    }

    public void setIsChemicalListApproved(String isChemicalListApproved) {
        this.isChemicalListApproved = isChemicalListApproved;
    }

    public String getChemicalListApproved() {
        return chemicalListApproved;
    }

    public void setChemicalListApproved(String chemicalListApproved) {
        this.chemicalListApproved = chemicalListApproved;
    }

    public String getIsPresenceOfApprovedSpray() {
        return isPresenceOfApprovedSpray;
    }

    public void setIsPresenceOfApprovedSpray(String isPresenceOfApprovedSpray) {
        this.isPresenceOfApprovedSpray = isPresenceOfApprovedSpray;
    }

    public String getPresenceOfApprovedSpray() {
        return presenceOfApprovedSpray;
    }

    public void setPresenceOfApprovedSpray(String presenceOfApprovedSpray) {
        this.presenceOfApprovedSpray = presenceOfApprovedSpray;
    }

    public String getIsProductInvoices() {
        return isProductInvoices;
    }

    public void setIsProductInvoices(String isProductInvoices) {
        this.isProductInvoices = isProductInvoices;
    }

    public String getProductInvoices() {
        return productInvoices;
    }

    public void setProductInvoices(String productInvoices) {
        this.productInvoices = productInvoices;
    }

    public String getIsSprayRecords() {
        return isSprayRecords;
    }

    public void setIsSprayRecords(String isSprayRecords) {
        this.isSprayRecords = isSprayRecords;
    }

    public String getSprayRecords() {
        return sprayRecords;
    }

    public void setSprayRecords(String sprayRecords) {
        this.sprayRecords = sprayRecords;
    }

    public String getIsTradenameOfProduct() {
        return isTradenameOfProduct;
    }

    public void setIsTradenameOfProduct(String isTradenameOfProduct) {
        this.isTradenameOfProduct = isTradenameOfProduct;
    }

    public String getTradenameOfProduct() {
        return tradenameOfProduct;
    }

    public void setTradenameOfProduct(String tradenameOfProduct) {
        this.tradenameOfProduct = tradenameOfProduct;
    }

    public String getIsPhiRecorded() {
        return isPhiRecorded;
    }

    public void setIsPhiRecorded(String isPhiRecorded) {
        this.isPhiRecorded = isPhiRecorded;
    }

    public String getPhiRecorded() {
        return phiRecorded;
    }

    public void setPhiRecorded(String phiRecorded) {
        this.phiRecorded = phiRecorded;
    }

    public String getIsAllSprayingDates() {
        return isAllSprayingDates;
    }

    public void setIsAllSprayingDates(String isAllSprayingDates) {
        this.isAllSprayingDates = isAllSprayingDates;
    }

    public String getAllSprayingDates() {
        return allSprayingDates;
    }

    public void setAllSprayingDates(String allSprayingDates) {
        this.allSprayingDates = allSprayingDates;
    }

    public String getIsAmountOfPesticide() {
        return isAmountOfPesticide;
    }

    public void setIsAmountOfPesticide(String isAmountOfPesticide) {
        this.isAmountOfPesticide = isAmountOfPesticide;
    }

    public String getAmountOfPesticide() {
        return amountOfPesticide;
    }

    public void setAmountOfPesticide(String amountOfPesticide) {
        this.amountOfPesticide = amountOfPesticide;
    }

    public String getIsPhiObserved() {
        return isPhiObserved;
    }

    public void setIsPhiObserved(String isPhiObserved) {
        this.isPhiObserved = isPhiObserved;
    }

    public String getPhiObserved() {
        return phiObserved;
    }

    public void setPhiObserved(String phiObserved) {
        this.phiObserved = phiObserved;
    }

    public String getIsTrainingSchedules() {
        return isTrainingSchedules;
    }

    public void setIsTrainingSchedules(String isTrainingSchedules) {
        this.isTrainingSchedules = isTrainingSchedules;
    }

    public String getTrainingSchedules() {
        return trainingSchedules;
    }

    public void setTrainingSchedules(String trainingSchedules) {
        this.trainingSchedules = trainingSchedules;
    }

    public String getIsPestManagementProtocol() {
        return isPestManagementProtocol;
    }

    public void setIsPestManagementProtocol(String isPestManagementProtocol) {
        this.isPestManagementProtocol = isPestManagementProtocol;
    }

    public String getPestManagementProtocol() {
        return pestManagementProtocol;
    }

    public void setPestManagementProtocol(String pestManagementProtocol) {
        this.pestManagementProtocol = pestManagementProtocol;
    }

    public String getIsEvidenceOnScouring() {
        return isEvidenceOnScouring;
    }

    public void setIsEvidenceOnScouring(String isEvidenceOnScouring) {
        this.isEvidenceOnScouring = isEvidenceOnScouring;
    }

    public String getEvidenceOnScouring() {
        return evidenceOnScouring;
    }

    public void setEvidenceOnScouring(String evidenceOnScouring) {
        this.evidenceOnScouring = evidenceOnScouring;
    }

    public String getIsEvidenceOfPests() {
        return isEvidenceOfPests;
    }

    public void setIsEvidenceOfPests(String isEvidenceOfPests) {
        this.isEvidenceOfPests = isEvidenceOfPests;
    }

    public String getEvidenceOfPests() {
        return evidenceOfPests;
    }

    public void setEvidenceOfPests(String evidenceOfPests) {
        this.evidenceOfPests = evidenceOfPests;
    }

    public String getIsCollectionShedForFarmers() {
        return isCollectionShedForFarmers;
    }

    public void setIsCollectionShedForFarmers(String isCollectionShedForFarmers) {
        this.isCollectionShedForFarmers = isCollectionShedForFarmers;
    }

    public String getCollectionShedForFarmers() {
        return collectionShedForFarmers;
    }

    public void setCollectionShedForFarmers(String collectionShedForFarmers) {
        this.collectionShedForFarmers = collectionShedForFarmers;
    }

    public String getIsCollectionAndSortingShed() {
        return isCollectionAndSortingShed;
    }

    public void setIsCollectionAndSortingShed(String isCollectionAndSortingShed) {
        this.isCollectionAndSortingShed = isCollectionAndSortingShed;
    }

    public String getCollectionAndSortingShed() {
        return collectionAndSortingShed;
    }

    public void setCollectionAndSortingShed(String collectionAndSortingShed) {
        this.collectionAndSortingShed = collectionAndSortingShed;
    }

    public String getIsAppropriateHygiene() {
        return isAppropriateHygiene;
    }

    public void setIsAppropriateHygiene(String isAppropriateHygiene) {
        this.isAppropriateHygiene = isAppropriateHygiene;
    }

    public String getAppropriateHygiene() {
        return appropriateHygiene;
    }

    public void setAppropriateHygiene(String appropriateHygiene) {
        this.appropriateHygiene = appropriateHygiene;
    }

    public String getIsGradingtables() {
        return isGradingtables;
    }

    public void setIsGradingtables(String isGradingtables) {
        this.isGradingtables = isGradingtables;
    }

    public String getGradingtables() {
        return gradingtables;
    }

    public void setGradingtables(String gradingtables) {
        this.gradingtables = gradingtables;
    }

    public String getIsShedHaveRunningWater() {
        return isShedHaveRunningWater;
    }

    public void setIsShedHaveRunningWater(String isShedHaveRunningWater) {
        this.isShedHaveRunningWater = isShedHaveRunningWater;
    }

    public String getShedHaveRunningWater() {
        return shedHaveRunningWater;
    }

    public void setShedHaveRunningWater(String shedHaveRunningWater) {
        this.shedHaveRunningWater = shedHaveRunningWater;
    }

    public String getIsToiletAtFacility() {
        return isToiletAtFacility;
    }

    public void setIsToiletAtFacility(String isToiletAtFacility) {
        this.isToiletAtFacility = isToiletAtFacility;
    }

    public String getToiletAtFacility() {
        return toiletAtFacility;
    }

    public void setToiletAtFacility(String toiletAtFacility) {
        this.toiletAtFacility = toiletAtFacility;
    }

    public String getIsPpeGraders() {
        return isPpeGraders;
    }

    public void setIsPpeGraders(String isPpeGraders) {
        this.isPpeGraders = isPpeGraders;
    }

    public String getPpeGraders() {
        return ppeGraders;
    }

    public void setPpeGraders(String ppeGraders) {
        this.ppeGraders = ppeGraders;
    }

    public String getIsStorageAreaForGraded() {
        return isStorageAreaForGraded;
    }

    public void setIsStorageAreaForGraded(String isStorageAreaForGraded) {
        this.isStorageAreaForGraded = isStorageAreaForGraded;
    }

    public String getStorageAreaForGraded() {
        return storageAreaForGraded;
    }

    public void setStorageAreaForGraded(String storageAreaForGraded) {
        this.storageAreaForGraded = storageAreaForGraded;
    }

    public String getIsPlasticCrates() {
        return isPlasticCrates;
    }

    public void setIsPlasticCrates(String isPlasticCrates) {
        this.isPlasticCrates = isPlasticCrates;
    }

    public String getPlasticCrates() {
        return plasticCrates;
    }

    public void setPlasticCrates(String plasticCrates) {
        this.plasticCrates = plasticCrates;
    }

    public String getIsCollectionShedAccessible() {
        return isCollectionShedAccessible;
    }

    public void setIsCollectionShedAccessible(String isCollectionShedAccessible) {
        this.isCollectionShedAccessible = isCollectionShedAccessible;
    }

    public String getCollectionShedAccessible() {
        return collectionShedAccessible;
    }

    public void setCollectionShedAccessible(String collectionShedAccessible) {
        this.collectionShedAccessible = collectionShedAccessible;
    }

    public String getIsCollectionAreaHaveOffice() {
        return isCollectionAreaHaveOffice;
    }

    public void setIsCollectionAreaHaveOffice(String isCollectionAreaHaveOffice) {
        this.isCollectionAreaHaveOffice = isCollectionAreaHaveOffice;
    }

    public String getCollectionAreaHaveOffice() {
        return collectionAreaHaveOffice;
    }

    public void setCollectionAreaHaveOffice(String collectionAreaHaveOffice) {
        this.collectionAreaHaveOffice = collectionAreaHaveOffice;
    }

    public String getIsCollectionShedEasy() {
        return isCollectionShedEasy;
    }

    public void setIsCollectionShedEasy(String isCollectionShedEasy) {
        this.isCollectionShedEasy = isCollectionShedEasy;
    }

    public String getCollectionShedEasy() {
        return collectionShedEasy;
    }

    public void setCollectionShedEasy(String collectionShedEasy) {
        this.collectionShedEasy = collectionShedEasy;
    }

    public String getIsAdequateLightingAndVentilation() {
        return isAdequateLightingAndVentilation;
    }

    public void setIsAdequateLightingAndVentilation(String isAdequateLightingAndVentilation) {
        this.isAdequateLightingAndVentilation = isAdequateLightingAndVentilation;
    }

    public String getAdequateLightingAndVentilation() {
        return adequateLightingAndVentilation;
    }

    public void setAdequateLightingAndVentilation(String adequateLightingAndVentilation) {
        this.adequateLightingAndVentilation = adequateLightingAndVentilation;
    }

    public String getIsWasteDisposalFacility() {
        return isWasteDisposalFacility;
    }

    public void setIsWasteDisposalFacility(String isWasteDisposalFacility) {
        this.isWasteDisposalFacility = isWasteDisposalFacility;
    }

    public String getWasteDisposalFacility() {
        return wasteDisposalFacility;
    }

    public void setWasteDisposalFacility(String wasteDisposalFacility) {
        this.wasteDisposalFacility = wasteDisposalFacility;
    }

    public String getIsRegisterOfAllIncoming() {
        return isRegisterOfAllIncoming;
    }

    public void setIsRegisterOfAllIncoming(String isRegisterOfAllIncoming) {
        this.isRegisterOfAllIncoming = isRegisterOfAllIncoming;
    }

    public String getRegisterOfAllIncoming() {
        return registerOfAllIncoming;
    }

    public void setRegisterOfAllIncoming(String registerOfAllIncoming) {
        this.registerOfAllIncoming = registerOfAllIncoming;
    }

    public String getIsProceduresForProduct() {
        return isProceduresForProduct;
    }

    public void setIsProceduresForProduct(String isProceduresForProduct) {
        this.isProceduresForProduct = isProceduresForProduct;
    }

    public String getProceduresForProduct() {
        return proceduresForProduct;
    }

    public void setProceduresForProduct(String proceduresForProduct) {
        this.proceduresForProduct = proceduresForProduct;
    }

    public String getIsPersonnelHandlingProduce() {
        return isPersonnelHandlingProduce;
    }

    public void setIsPersonnelHandlingProduce(String isPersonnelHandlingProduce) {
        this.isPersonnelHandlingProduce = isPersonnelHandlingProduce;
    }

    public String getPersonnelHandlingProduce() {
        return personnelHandlingProduce;
    }

    public void setPersonnelHandlingProduce(String personnelHandlingProduce) {
        this.personnelHandlingProduce = personnelHandlingProduce;
    }

    public String getIsAllFarmersRegistered() {
        return isAllFarmersRegistered;
    }

    public void setIsAllFarmersRegistered(String isAllFarmersRegistered) {
        this.isAllFarmersRegistered = isAllFarmersRegistered;
    }

    public String getAllFarmersRegistered() {
        return allFarmersRegistered;
    }

    public void setAllFarmersRegistered(String allFarmersRegistered) {
        this.allFarmersRegistered = allFarmersRegistered;
    }

    public String getIsPresenceOfTraceability() {
        return isPresenceOfTraceability;
    }

    public void setIsPresenceOfTraceability(String isPresenceOfTraceability) {
        this.isPresenceOfTraceability = isPresenceOfTraceability;
    }

    public String getPresenceOfTraceability() {
        return presenceOfTraceability;
    }

    public void setPresenceOfTraceability(String presenceOfTraceability) {
        this.presenceOfTraceability = presenceOfTraceability;
    }

    public String getIsAvailabilityOfRegistered() {
        return isAvailabilityOfRegistered;
    }

    public void setIsAvailabilityOfRegistered(String isAvailabilityOfRegistered) {
        this.isAvailabilityOfRegistered = isAvailabilityOfRegistered;
    }

    public String getAvailabilityOfRegistered() {
        return availabilityOfRegistered;
    }

    public void setAvailabilityOfRegistered(String availabilityOfRegistered) {
        this.availabilityOfRegistered = availabilityOfRegistered;
    }

    public String getIsTrainingCertificates() {
        return isTrainingCertificates;
    }

    public void setIsTrainingCertificates(String isTrainingCertificates) {
        this.isTrainingCertificates = isTrainingCertificates;
    }

    public String getTrainingCertificates() {
        return trainingCertificates;
    }

    public void setTrainingCertificates(String trainingCertificates) {
        this.trainingCertificates = trainingCertificates;
    }

    public String getIsEvidenceOfTechnical() {
        return isEvidenceOfTechnical;
    }

    public void setIsEvidenceOfTechnical(String isEvidenceOfTechnical) {
        this.isEvidenceOfTechnical = isEvidenceOfTechnical;
    }

    public String getEvidenceOfTechnical() {
        return evidenceOfTechnical;
    }

    public void setEvidenceOfTechnical(String evidenceOfTechnical) {
        this.evidenceOfTechnical = evidenceOfTechnical;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
