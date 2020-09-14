package co.ke.bsl.data.view;

public class CoffeePulpingStationPSLBus
{
    private static CoffeePulpingStationPSLBus single_instance = null;

    private CoffeePulpingStationPSLBus() {
    }

    public static CoffeePulpingStationPSLBus getInstance() {
        if (single_instance == null)
            single_instance = new CoffeePulpingStationPSLBus();

        return single_instance;
    }

    public static CoffeePulpingStationPSLBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(CoffeePulpingStationPSLBus single_instance) {
        CoffeePulpingStationPSLBus.single_instance = single_instance;
    }

    private String document_number;
    private String visited_date;
    private String name_of_applicant;
    private String licence_number;
    private String areaUnderCoffee;
    private String pulpingMachine;
    private String dateApprovedByTheBoard;


    private String isSkinDryingTable;
    private String isDryingTable;
    private String isFarmentationTable;
    private String isSoaktanks;
    private String isParcmentBuniStore;
    private String skinDryingTableremarks;
    private String dryingTableremarks;
    private String farmentationTableremarks;
    private String soakTanksremarks;
    private String parcmentBuniStoreremarks;
    private String wasteAndPollutionsremarks;
    private String coffeeAdvisoryOfficers;
    private String reccommendationsFromCOWG;
    private String othersRemrks;
    private String status;
    private String localID;

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public String getVisited_date() {
        return visited_date;
    }

    public void setVisited_date(String visited_date) {
        this.visited_date = visited_date;
    }

    public String getName_of_applicant() {
        return name_of_applicant;
    }

    public void setName_of_applicant(String name_of_applicant) {
        this.name_of_applicant = name_of_applicant;
    }

    public String getLicence_number() {
        return licence_number;
    }

    public void setLicence_number(String licence_number) {
        this.licence_number = licence_number;
    }

    public String getAreaUnderCoffee() {
        return areaUnderCoffee;
    }

    public void setAreaUnderCoffee(String areaUnderCoffee) {
        this.areaUnderCoffee = areaUnderCoffee;
    }

    public String getPulpingMachine() {
        return pulpingMachine;
    }

    public void setPulpingMachine(String pulpingMachine) {
        this.pulpingMachine = pulpingMachine;
    }

    public String getDateApprovedByTheBoard() {
        return dateApprovedByTheBoard;
    }

    public void setDateApprovedByTheBoard(String dateApprovedByTheBoard) {
        this.dateApprovedByTheBoard = dateApprovedByTheBoard;
    }

    public String getIsSkinDryingTable() {
        return isSkinDryingTable;
    }

    public void setIsSkinDryingTable(String isSkinDryingTable) {
        this.isSkinDryingTable = isSkinDryingTable;
    }

    public String getIsDryingTable() {
        return isDryingTable;
    }

    public void setIsDryingTable(String isDryingTable) {
        this.isDryingTable = isDryingTable;
    }

    public String getIsFarmentationTable() {
        return isFarmentationTable;
    }

    public void setIsFarmentationTable(String isFarmentationTable) {
        this.isFarmentationTable = isFarmentationTable;
    }

    public String getIsSoaktanks() {
        return isSoaktanks;
    }

    public void setIsSoaktanks(String isSoaktanks) {
        this.isSoaktanks = isSoaktanks;
    }

    public String getIsParcmentBuniStore() {
        return isParcmentBuniStore;
    }

    public void setIsParcmentBuniStore(String isParcmentBuniStore) {
        this.isParcmentBuniStore = isParcmentBuniStore;
    }

    public String getSkinDryingTableremarks() {
        return skinDryingTableremarks;
    }

    public void setSkinDryingTableremarks(String skinDryingTableremarks) {
        this.skinDryingTableremarks = skinDryingTableremarks;
    }

    public String getDryingTableremarks() {
        return dryingTableremarks;
    }

    public void setDryingTableremarks(String dryingTableremarks) {
        this.dryingTableremarks = dryingTableremarks;
    }

    public String getFarmentationTableremarks() {
        return farmentationTableremarks;
    }

    public void setFarmentationTableremarks(String farmentationTableremarks) {
        this.farmentationTableremarks = farmentationTableremarks;
    }

    public String getSoakTanksremarks() {
        return soakTanksremarks;
    }

    public void setSoakTanksremarks(String soakTanksremarks) {
        this.soakTanksremarks = soakTanksremarks;
    }

    public String getParcmentBuniStoreremarks() {
        return parcmentBuniStoreremarks;
    }

    public void setParcmentBuniStoreremarks(String parcmentBuniStoreremarks) {
        this.parcmentBuniStoreremarks = parcmentBuniStoreremarks;
    }

    public String getWasteAndPollutionsremarks() {
        return wasteAndPollutionsremarks;
    }

    public void setWasteAndPollutionsremarks(String wasteAndPollutionsremarks) {
        this.wasteAndPollutionsremarks = wasteAndPollutionsremarks;
    }

    public String getCoffeeAdvisoryOfficers() {
        return coffeeAdvisoryOfficers;
    }

    public void setCoffeeAdvisoryOfficers(String coffeeAdvisoryOfficers) {
        this.coffeeAdvisoryOfficers = coffeeAdvisoryOfficers;
    }

    public String getReccommendationsFromCOWG() {
        return reccommendationsFromCOWG;
    }

    public void setReccommendationsFromCOWG(String reccommendationsFromCOWG) {
        this.reccommendationsFromCOWG = reccommendationsFromCOWG;
    }

    public String getOthersRemrks() {
        return othersRemrks;
    }

    public void setOthersRemrks(String othersRemrks) {
        this.othersRemrks = othersRemrks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }
}
