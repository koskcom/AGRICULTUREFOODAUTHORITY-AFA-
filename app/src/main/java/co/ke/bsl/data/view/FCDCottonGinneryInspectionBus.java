package co.ke.bsl.data.view;

public class FCDCottonGinneryInspectionBus {
    private static FCDCottonGinneryInspectionBus single_instance = null;

    private FCDCottonGinneryInspectionBus() {
    }

    public static FCDCottonGinneryInspectionBus getInstance() {
        if (single_instance == null)
            single_instance = new FCDCottonGinneryInspectionBus();

        return single_instance;
    }

    public static FCDCottonGinneryInspectionBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(FCDCottonGinneryInspectionBus single_instance) {
        FCDCottonGinneryInspectionBus.single_instance = single_instance;
    }
    private String localId;
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String ginningLicence;
    private String ssSeedvariety;
    private String seedCottonGrade;
    private String seedCottonWeightOpener;
    private String lessTareWeight;
    private String nettWeightOfUnCleanedSeedCotton;
    private String cleanSeedCottonGrossKg;
    private String lessTareWeightBeforeFeedingCleaned;
    private String nettWeightUncleanedSeedKg;
    private String openerWasteOrDirectBefore;
    private String isAppropirateprotective;
    private String isFireFightingprecautionary;
    private String isProtectedMovingparts;
    private String isFireengines;
    private String iswater;
    private String isCarbondioxide;
    private String isfoam;
    private String isDrypowder;
    private String issand;
    private String isHydrantsystem;
    private String howManySeedStores;
    private String surroundingsOfBuyingSanitaryConditionRemarks;
    private String bulkStorage;
    private String bags;
    private String typeofBags;
    private String totalseedCottonPurchaseinFielddBR;
    private String totalSeedPurchasedFieldARkg;
    private String seedCottonBroughtToGinnerryBR;
    private String seedCottonBroughtToGinnerryAR;
    private String totalCottonGinnedToDateBR;
    private String totalCottonGinnedToDateAR;
    private String totalCottonRemainingInStoreBR;
    private String totalCottonRemainingInStoreAR;
    private String remainingStoreSpace;
    private String isroller;
    private String issaw;
    private String category;
    private String totalNoOfGinningMachines;
    private String noOfWorkingGinningUnits;
    private String noOfCurrentSalesOuput8hrs;
    private String noOfInstalledBalesOutput8hrs;
    private String noOfBalesProducedFromBegginingOfSession;
    private String noOfBaselsSoldLocal;
    private String noOfBalesSoldExport;
    private String balesRemainingInFactory;
    private String alesRemainingInFactoryBRKg;
    private String seedsProducedBRkg;
    private String seedsProduceArKg;
    private String plantingSeedAvailableKg;
    private String lastYearCarryOver;
    private String seedsSoldForPlanting;
    private String seedsSoldToMillersKg;
    private String seedRemaining;
    private String buyingCenterStore;
    private String boughtKg;
    private String receivedAtGinner;
    private String remainingInTheField;
    private String officerrecommendation;
    private String officerrecommendation_remark;


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

    public String getGinningLicence() {
        return ginningLicence;
    }

    public void setGinningLicence(String ginningLicence) {
        this.ginningLicence = ginningLicence;
    }

    public String getSsSeedvariety() {
        return ssSeedvariety;
    }

    public void setSsSeedvariety(String ssSeedvariety) {
        this.ssSeedvariety = ssSeedvariety;
    }

    public String getSeedCottonGrade() {
        return seedCottonGrade;
    }

    public void setSeedCottonGrade(String seedCottonGrade) {
        this.seedCottonGrade = seedCottonGrade;
    }

    public String getSeedCottonWeightOpener() {
        return seedCottonWeightOpener;
    }

    public void setSeedCottonWeightOpener(String seedCottonWeightOpener) {
        this.seedCottonWeightOpener = seedCottonWeightOpener;
    }

    public String getLessTareWeight() {
        return lessTareWeight;
    }

    public void setLessTareWeight(String lessTareWeight) {
        this.lessTareWeight = lessTareWeight;
    }

    public String getNettWeightOfUnCleanedSeedCotton() {
        return nettWeightOfUnCleanedSeedCotton;
    }

    public void setNettWeightOfUnCleanedSeedCotton(String nettWeightOfUnCleanedSeedCotton) {
        this.nettWeightOfUnCleanedSeedCotton = nettWeightOfUnCleanedSeedCotton;
    }

    public String getCleanSeedCottonGrossKg() {
        return cleanSeedCottonGrossKg;
    }

    public void setCleanSeedCottonGrossKg(String cleanSeedCottonGrossKg) {
        this.cleanSeedCottonGrossKg = cleanSeedCottonGrossKg;
    }

    public String getLessTareWeightBeforeFeedingCleaned() {
        return lessTareWeightBeforeFeedingCleaned;
    }

    public void setLessTareWeightBeforeFeedingCleaned(String lessTareWeightBeforeFeedingCleaned) {
        this.lessTareWeightBeforeFeedingCleaned = lessTareWeightBeforeFeedingCleaned;
    }

    public String getNettWeightUncleanedSeedKg() {
        return nettWeightUncleanedSeedKg;
    }

    public void setNettWeightUncleanedSeedKg(String nettWeightUncleanedSeedKg) {
        this.nettWeightUncleanedSeedKg = nettWeightUncleanedSeedKg;
    }

    public String getOpenerWasteOrDirectBefore() {
        return openerWasteOrDirectBefore;
    }

    public void setOpenerWasteOrDirectBefore(String openerWasteOrDirectBefore) {
        this.openerWasteOrDirectBefore = openerWasteOrDirectBefore;
    }

    public String getIsAppropirateprotective() {
        return isAppropirateprotective;
    }

    public void setIsAppropirateprotective(String isAppropirateprotective) {
        this.isAppropirateprotective = isAppropirateprotective;
    }

    public String getIsFireFightingprecautionary() {
        return isFireFightingprecautionary;
    }

    public void setIsFireFightingprecautionary(String isFireFightingprecautionary) {
        this.isFireFightingprecautionary = isFireFightingprecautionary;
    }

    public String getIsProtectedMovingparts() {
        return isProtectedMovingparts;
    }

    public void setIsProtectedMovingparts(String isProtectedMovingparts) {
        this.isProtectedMovingparts = isProtectedMovingparts;
    }

    public String getIsFireengines() {
        return isFireengines;
    }

    public void setIsFireengines(String isFireengines) {
        this.isFireengines = isFireengines;
    }

    public String getIswater() {
        return iswater;
    }

    public void setIswater(String iswater) {
        this.iswater = iswater;
    }

    public String getIsCarbondioxide() {
        return isCarbondioxide;
    }

    public void setIsCarbondioxide(String isCarbondioxide) {
        this.isCarbondioxide = isCarbondioxide;
    }

    public String getIsfoam() {
        return isfoam;
    }

    public void setIsfoam(String isfoam) {
        this.isfoam = isfoam;
    }

    public String getIsDrypowder() {
        return isDrypowder;
    }

    public void setIsDrypowder(String isDrypowder) {
        this.isDrypowder = isDrypowder;
    }

    public String getIssand() {
        return issand;
    }

    public void setIssand(String issand) {
        this.issand = issand;
    }

    public String getIsHydrantsystem() {
        return isHydrantsystem;
    }

    public void setIsHydrantsystem(String isHydrantsystem) {
        this.isHydrantsystem = isHydrantsystem;
    }

    public String getHowManySeedStores() {
        return howManySeedStores;
    }

    public void setHowManySeedStores(String howManySeedStores) {
        this.howManySeedStores = howManySeedStores;
    }

    public String getSurroundingsOfBuyingSanitaryConditionRemarks() {
        return surroundingsOfBuyingSanitaryConditionRemarks;
    }

    public void setSurroundingsOfBuyingSanitaryConditionRemarks(String surroundingsOfBuyingSanitaryConditionRemarks) {
        this.surroundingsOfBuyingSanitaryConditionRemarks = surroundingsOfBuyingSanitaryConditionRemarks;
    }

    public String getBulkStorage() {
        return bulkStorage;
    }

    public void setBulkStorage(String bulkStorage) {
        this.bulkStorage = bulkStorage;
    }

    public String getBags() {
        return bags;
    }

    public void setBags(String bags) {
        this.bags = bags;
    }

    public String getTypeofBags() {
        return typeofBags;
    }

    public void setTypeofBags(String typeofBags) {
        this.typeofBags = typeofBags;
    }

    public String getTotalseedCottonPurchaseinFielddBR() {
        return totalseedCottonPurchaseinFielddBR;
    }

    public void setTotalseedCottonPurchaseinFielddBR(String totalseedCottonPurchaseinFielddBR) {
        this.totalseedCottonPurchaseinFielddBR = totalseedCottonPurchaseinFielddBR;
    }

    public String getTotalSeedPurchasedFieldARkg() {
        return totalSeedPurchasedFieldARkg;
    }

    public void setTotalSeedPurchasedFieldARkg(String totalSeedPurchasedFieldARkg) {
        this.totalSeedPurchasedFieldARkg = totalSeedPurchasedFieldARkg;
    }

    public String getSeedCottonBroughtToGinnerryBR() {
        return seedCottonBroughtToGinnerryBR;
    }

    public void setSeedCottonBroughtToGinnerryBR(String seedCottonBroughtToGinnerryBR) {
        this.seedCottonBroughtToGinnerryBR = seedCottonBroughtToGinnerryBR;
    }

    public String getSeedCottonBroughtToGinnerryAR() {
        return seedCottonBroughtToGinnerryAR;
    }

    public void setSeedCottonBroughtToGinnerryAR(String seedCottonBroughtToGinnerryAR) {
        this.seedCottonBroughtToGinnerryAR = seedCottonBroughtToGinnerryAR;
    }

    public String getTotalCottonGinnedToDateBR() {
        return totalCottonGinnedToDateBR;
    }

    public void setTotalCottonGinnedToDateBR(String totalCottonGinnedToDateBR) {
        this.totalCottonGinnedToDateBR = totalCottonGinnedToDateBR;
    }

    public String getTotalCottonGinnedToDateAR() {
        return totalCottonGinnedToDateAR;
    }

    public void setTotalCottonGinnedToDateAR(String totalCottonGinnedToDateAR) {
        this.totalCottonGinnedToDateAR = totalCottonGinnedToDateAR;
    }

    public String getTotalCottonRemainingInStoreBR() {
        return totalCottonRemainingInStoreBR;
    }

    public void setTotalCottonRemainingInStoreBR(String totalCottonRemainingInStoreBR) {
        this.totalCottonRemainingInStoreBR = totalCottonRemainingInStoreBR;
    }

    public String getTotalCottonRemainingInStoreAR() {
        return totalCottonRemainingInStoreAR;
    }

    public void setTotalCottonRemainingInStoreAR(String totalCottonRemainingInStoreAR) {
        this.totalCottonRemainingInStoreAR = totalCottonRemainingInStoreAR;
    }

    public String getRemainingStoreSpace() {
        return remainingStoreSpace;
    }

    public void setRemainingStoreSpace(String remainingStoreSpace) {
        this.remainingStoreSpace = remainingStoreSpace;
    }

    public String getIsroller() {
        return isroller;
    }

    public void setIsroller(String isroller) {
        this.isroller = isroller;
    }

    public String getIssaw() {
        return issaw;
    }

    public void setIssaw(String issaw) {
        this.issaw = issaw;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTotalNoOfGinningMachines() {
        return totalNoOfGinningMachines;
    }

    public void setTotalNoOfGinningMachines(String totalNoOfGinningMachines) {
        this.totalNoOfGinningMachines = totalNoOfGinningMachines;
    }

    public String getNoOfWorkingGinningUnits() {
        return noOfWorkingGinningUnits;
    }

    public void setNoOfWorkingGinningUnits(String noOfWorkingGinningUnits) {
        this.noOfWorkingGinningUnits = noOfWorkingGinningUnits;
    }

    public String getNoOfCurrentSalesOuput8hrs() {
        return noOfCurrentSalesOuput8hrs;
    }

    public void setNoOfCurrentSalesOuput8hrs(String noOfCurrentSalesOuput8hrs) {
        this.noOfCurrentSalesOuput8hrs = noOfCurrentSalesOuput8hrs;
    }

    public String getNoOfInstalledBalesOutput8hrs() {
        return noOfInstalledBalesOutput8hrs;
    }

    public void setNoOfInstalledBalesOutput8hrs(String noOfInstalledBalesOutput8hrs) {
        this.noOfInstalledBalesOutput8hrs = noOfInstalledBalesOutput8hrs;
    }

    public String getNoOfBalesProducedFromBegginingOfSession() {
        return noOfBalesProducedFromBegginingOfSession;
    }

    public void setNoOfBalesProducedFromBegginingOfSession(String noOfBalesProducedFromBegginingOfSession) {
        this.noOfBalesProducedFromBegginingOfSession = noOfBalesProducedFromBegginingOfSession;
    }

    public String getNoOfBaselsSoldLocal() {
        return noOfBaselsSoldLocal;
    }

    public void setNoOfBaselsSoldLocal(String noOfBaselsSoldLocal) {
        this.noOfBaselsSoldLocal = noOfBaselsSoldLocal;
    }

    public String getNoOfBalesSoldExport() {
        return noOfBalesSoldExport;
    }

    public void setNoOfBalesSoldExport(String noOfBalesSoldExport) {
        this.noOfBalesSoldExport = noOfBalesSoldExport;
    }

    public String getBalesRemainingInFactory() {
        return balesRemainingInFactory;
    }

    public void setBalesRemainingInFactory(String balesRemainingInFactory) {
        this.balesRemainingInFactory = balesRemainingInFactory;
    }

    public String getAlesRemainingInFactoryBRKg() {
        return alesRemainingInFactoryBRKg;
    }

    public void setAlesRemainingInFactoryBRKg(String alesRemainingInFactoryBRKg) {
        this.alesRemainingInFactoryBRKg = alesRemainingInFactoryBRKg;
    }

    public String getSeedsProducedBRkg() {
        return seedsProducedBRkg;
    }

    public void setSeedsProducedBRkg(String seedsProducedBRkg) {
        this.seedsProducedBRkg = seedsProducedBRkg;
    }

    public String getSeedsProduceArKg() {
        return seedsProduceArKg;
    }

    public void setSeedsProduceArKg(String seedsProduceArKg) {
        this.seedsProduceArKg = seedsProduceArKg;
    }

    public String getPlantingSeedAvailableKg() {
        return plantingSeedAvailableKg;
    }

    public void setPlantingSeedAvailableKg(String plantingSeedAvailableKg) {
        this.plantingSeedAvailableKg = plantingSeedAvailableKg;
    }

    public String getLastYearCarryOver() {
        return lastYearCarryOver;
    }

    public void setLastYearCarryOver(String lastYearCarryOver) {
        this.lastYearCarryOver = lastYearCarryOver;
    }

    public String getSeedsSoldForPlanting() {
        return seedsSoldForPlanting;
    }

    public void setSeedsSoldForPlanting(String seedsSoldForPlanting) {
        this.seedsSoldForPlanting = seedsSoldForPlanting;
    }

    public String getSeedsSoldToMillersKg() {
        return seedsSoldToMillersKg;
    }

    public void setSeedsSoldToMillersKg(String seedsSoldToMillersKg) {
        this.seedsSoldToMillersKg = seedsSoldToMillersKg;
    }

    public String getSeedRemaining() {
        return seedRemaining;
    }

    public void setSeedRemaining(String seedRemaining) {
        this.seedRemaining = seedRemaining;
    }

    public String getBuyingCenterStore() {
        return buyingCenterStore;
    }

    public void setBuyingCenterStore(String buyingCenterStore) {
        this.buyingCenterStore = buyingCenterStore;
    }

    public String getBoughtKg() {
        return boughtKg;
    }

    public void setBoughtKg(String boughtKg) {
        this.boughtKg = boughtKg;
    }

    public String getReceivedAtGinner() {
        return receivedAtGinner;
    }

    public void setReceivedAtGinner(String receivedAtGinner) {
        this.receivedAtGinner = receivedAtGinner;
    }

    public String getRemainingInTheField() {
        return remainingInTheField;
    }

    public void setRemainingInTheField(String remainingInTheField) {
        this.remainingInTheField = remainingInTheField;
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
