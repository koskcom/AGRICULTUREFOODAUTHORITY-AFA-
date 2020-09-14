package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FCDCottonGinneryInspection {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int fcd_Cotton_Ginnery_Inspection_id;
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String ginningLicence;
    private String localId;
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

    private boolean is_synced;
    private String remote_id;

    public FCDCottonGinneryInspection(int fcd_Cotton_Ginnery_Inspection_id, String documentNumber, String documentDate, String nameOfApplicant, String ginningLicence, String localId, String ssSeedvariety, String seedCottonGrade, String seedCottonWeightOpener, String lessTareWeight, String nettWeightOfUnCleanedSeedCotton, String cleanSeedCottonGrossKg, String lessTareWeightBeforeFeedingCleaned, String nettWeightUncleanedSeedKg, String openerWasteOrDirectBefore, String isAppropirateprotective, String isFireFightingprecautionary, String isProtectedMovingparts, String isFireengines, String iswater, String isCarbondioxide, String isfoam, String isDrypowder, String issand, String isHydrantsystem, String howManySeedStores, String surroundingsOfBuyingSanitaryConditionRemarks, String bulkStorage, String bags, String typeofBags, String totalseedCottonPurchaseinFielddBR, String totalSeedPurchasedFieldARkg, String seedCottonBroughtToGinnerryBR, String seedCottonBroughtToGinnerryAR, String totalCottonGinnedToDateBR, String totalCottonGinnedToDateAR, String totalCottonRemainingInStoreBR, String totalCottonRemainingInStoreAR, String remainingStoreSpace, String isroller, String issaw, String category, String totalNoOfGinningMachines, String noOfWorkingGinningUnits, String noOfCurrentSalesOuput8hrs, String noOfInstalledBalesOutput8hrs, String noOfBalesProducedFromBegginingOfSession, String noOfBaselsSoldLocal, String noOfBalesSoldExport, String balesRemainingInFactory, String alesRemainingInFactoryBRKg, String seedsProducedBRkg, String seedsProduceArKg, String plantingSeedAvailableKg, String lastYearCarryOver, String seedsSoldForPlanting, String seedsSoldToMillersKg, String seedRemaining, String buyingCenterStore, String boughtKg, String receivedAtGinner, String remainingInTheField, String officerrecommendation, String officerrecommendation_remark, boolean is_synced, String remote_id) {
        this.fcd_Cotton_Ginnery_Inspection_id = fcd_Cotton_Ginnery_Inspection_id;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.ginningLicence = ginningLicence;
        this.localId = localId;
        this.ssSeedvariety = ssSeedvariety;
        this.seedCottonGrade = seedCottonGrade;
        this.seedCottonWeightOpener = seedCottonWeightOpener;
        this.lessTareWeight = lessTareWeight;
        this.nettWeightOfUnCleanedSeedCotton = nettWeightOfUnCleanedSeedCotton;
        this.cleanSeedCottonGrossKg = cleanSeedCottonGrossKg;
        this.lessTareWeightBeforeFeedingCleaned = lessTareWeightBeforeFeedingCleaned;
        this.nettWeightUncleanedSeedKg = nettWeightUncleanedSeedKg;
        this.openerWasteOrDirectBefore = openerWasteOrDirectBefore;
        this.isAppropirateprotective = isAppropirateprotective;
        this.isFireFightingprecautionary = isFireFightingprecautionary;
        this.isProtectedMovingparts = isProtectedMovingparts;
        this.isFireengines = isFireengines;
        this.iswater = iswater;
        this.isCarbondioxide = isCarbondioxide;
        this.isfoam = isfoam;
        this.isDrypowder = isDrypowder;
        this.issand = issand;
        this.isHydrantsystem = isHydrantsystem;
        this.howManySeedStores = howManySeedStores;
        this.surroundingsOfBuyingSanitaryConditionRemarks = surroundingsOfBuyingSanitaryConditionRemarks;
        this.bulkStorage = bulkStorage;
        this.bags = bags;
        this.typeofBags = typeofBags;
        this.totalseedCottonPurchaseinFielddBR = totalseedCottonPurchaseinFielddBR;
        this.totalSeedPurchasedFieldARkg = totalSeedPurchasedFieldARkg;
        this.seedCottonBroughtToGinnerryBR = seedCottonBroughtToGinnerryBR;
        this.seedCottonBroughtToGinnerryAR = seedCottonBroughtToGinnerryAR;
        this.totalCottonGinnedToDateBR = totalCottonGinnedToDateBR;
        this.totalCottonGinnedToDateAR = totalCottonGinnedToDateAR;
        this.totalCottonRemainingInStoreBR = totalCottonRemainingInStoreBR;
        this.totalCottonRemainingInStoreAR = totalCottonRemainingInStoreAR;
        this.remainingStoreSpace = remainingStoreSpace;
        this.isroller = isroller;
        this.issaw = issaw;
        this.category = category;
        this.totalNoOfGinningMachines = totalNoOfGinningMachines;
        this.noOfWorkingGinningUnits = noOfWorkingGinningUnits;
        this.noOfCurrentSalesOuput8hrs = noOfCurrentSalesOuput8hrs;
        this.noOfInstalledBalesOutput8hrs = noOfInstalledBalesOutput8hrs;
        this.noOfBalesProducedFromBegginingOfSession = noOfBalesProducedFromBegginingOfSession;
        this.noOfBaselsSoldLocal = noOfBaselsSoldLocal;
        this.noOfBalesSoldExport = noOfBalesSoldExport;
        this.balesRemainingInFactory = balesRemainingInFactory;
        this.alesRemainingInFactoryBRKg = alesRemainingInFactoryBRKg;
        this.seedsProducedBRkg = seedsProducedBRkg;
        this.seedsProduceArKg = seedsProduceArKg;
        this.plantingSeedAvailableKg = plantingSeedAvailableKg;
        this.lastYearCarryOver = lastYearCarryOver;
        this.seedsSoldForPlanting = seedsSoldForPlanting;
        this.seedsSoldToMillersKg = seedsSoldToMillersKg;
        this.seedRemaining = seedRemaining;
        this.buyingCenterStore = buyingCenterStore;
        this.boughtKg = boughtKg;
        this.receivedAtGinner = receivedAtGinner;
        this.remainingInTheField = remainingInTheField;
        this.officerrecommendation = officerrecommendation;
        this.officerrecommendation_remark = officerrecommendation_remark;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public int getFcd_Cotton_Ginnery_Inspection_id() {
        return fcd_Cotton_Ginnery_Inspection_id;
    }

    public void setFcd_Cotton_Ginnery_Inspection_id(int fcd_Cotton_Ginnery_Inspection_id) {
        this.fcd_Cotton_Ginnery_Inspection_id = fcd_Cotton_Ginnery_Inspection_id;
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
