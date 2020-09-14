package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CoffeePulpingStationPSL {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int coffee_pulping_station_psl_id;

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
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private String status;
    private String localID;

    private boolean is_synced;
    private String remote_id;

    public CoffeePulpingStationPSL(int coffee_pulping_station_psl_id, String document_number, String visited_date, String name_of_applicant, String licence_number, String areaUnderCoffee, String pulpingMachine, String dateApprovedByTheBoard, String isSkinDryingTable, String isDryingTable, String isFarmentationTable, String isSoaktanks, String isParcmentBuniStore, String skinDryingTableremarks, String dryingTableremarks, String farmentationTableremarks, String soakTanksremarks, String parcmentBuniStoreremarks, String wasteAndPollutionsremarks, String coffeeAdvisoryOfficers, String reccommendationsFromCOWG, String othersRemrks, String officerrecommendation, String officerrecommendation_remark, String status, String localID, boolean is_synced, String remote_id) {
        this.coffee_pulping_station_psl_id = coffee_pulping_station_psl_id;
        this.document_number = document_number;
        this.visited_date = visited_date;
        this.name_of_applicant = name_of_applicant;
        this.licence_number = licence_number;
        this.areaUnderCoffee = areaUnderCoffee;
        this.pulpingMachine = pulpingMachine;
        this.dateApprovedByTheBoard = dateApprovedByTheBoard;
        this.isSkinDryingTable = isSkinDryingTable;
        this.isDryingTable = isDryingTable;
        this.isFarmentationTable = isFarmentationTable;
        this.isSoaktanks = isSoaktanks;
        this.isParcmentBuniStore = isParcmentBuniStore;
        this.skinDryingTableremarks = skinDryingTableremarks;
        this.dryingTableremarks = dryingTableremarks;
        this.farmentationTableremarks = farmentationTableremarks;
        this.soakTanksremarks = soakTanksremarks;
        this.parcmentBuniStoreremarks = parcmentBuniStoreremarks;
        this.wasteAndPollutionsremarks = wasteAndPollutionsremarks;
        this.coffeeAdvisoryOfficers = coffeeAdvisoryOfficers;
        this.reccommendationsFromCOWG = reccommendationsFromCOWG;
        this.othersRemrks = othersRemrks;
        this.officerrecommendation = officerrecommendation;
        this.officerrecommendation_remark = officerrecommendation_remark;
        this.status = status;
        this.localID = localID;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

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

    public int getCoffee_pulping_station_psl_id() {
        return coffee_pulping_station_psl_id;
    }

    public void setCoffee_pulping_station_psl_id(int coffee_pulping_station_psl_id) {
        this.coffee_pulping_station_psl_id = coffee_pulping_station_psl_id;
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
