package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FoodWarehouse {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int food_warehouse_id;
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String foodWarehouselicence;
    private String localID;
    private String ssleaseagreement;
    private String isGraincleaningfacility;
    private String graincleaningfacility_Remarks;
    private String isLoadingCapacity;
    private String loadingCapacity_Remarks;
    private String isdrier;
    private String drier_remarks;
    private String islabroom;
    private String labroom_Remarks;
    private String isWallandVentilation;
    private String wallandVentilation_Remarks;
    private String isWaterproofProvisions;
    private String waterproofProvisions_Remarks;
    private String isInternalSupport;
    private String internalSupport_Remarks;
    private String isContinuousConcretefloor;
    private String continuousconcretefloor_Remarks;
    private String isCorrugatedgalvanizedRoof;
    private String corrugatedgalvanizedroof_Remarks;
    private String isTheNohighGaugesteeldoors;
    private String theNohighgaugesteeldoors_Remarks;
    private String isHygieneAndcleanliness;
    private String hygieneAndCleanliness_Remarks;
    private String isPerimeterwallandtruckaccessPavement;
    private String perimeterwallandtruckaccesspavement_Remarks;
    private String isLoadingandoffLoadingshelter;
    private String loadingandoffloadingshelter_Remarks;
    private String isGuardHouse;
    private String guardhouse_Remarks;
    private String isFireextinguishersmokedetectorsandAlarmsystem;
    private String fireextinguishersmokedetectorsandalarmsystem_remarks;
    private String isGuardhouseandsecurityLights;
    private String guardhouseandsecuritylights_remarks;
    private String isWeighbridgesandweighingScales;
    private String weighbridgesandweighingscales_remarks;
    private String isOfficesworkingtelephonesandinternetacces;
    private String officesworkingtelephonesandinternetaccess_remarks;
    private String isProvisionofWASHfacilitie;
    private String provisionofWASHfacilities_remarks;
    private String isBooksofaccount;
    private String booksofaccounts_remarks;
    private String isRecallandtraceabilityprocedure;
    private String recallandtraceabilityprocedures_remarks;
    private String ssRecomendation;
    private String reasonForThegiveReccomm;
    private boolean is_synced;
    private String remote_id;


    public FoodWarehouse(int food_warehouse_id, String documentNumber, String documentDate, String nameOfApplicant, String foodWarehouselicence, String localID, String ssleaseagreement, String isGraincleaningfacility, String graincleaningfacility_Remarks, String isLoadingCapacity, String loadingCapacity_Remarks, String isdrier, String drier_remarks, String islabroom, String labroom_Remarks, String isWallandVentilation, String wallandVentilation_Remarks, String isWaterproofProvisions, String waterproofProvisions_Remarks, String isInternalSupport, String internalSupport_Remarks, String isContinuousConcretefloor, String continuousconcretefloor_Remarks, String isCorrugatedgalvanizedRoof, String corrugatedgalvanizedroof_Remarks, String isTheNohighGaugesteeldoors, String theNohighgaugesteeldoors_Remarks, String isHygieneAndcleanliness, String hygieneAndCleanliness_Remarks, String isPerimeterwallandtruckaccessPavement, String perimeterwallandtruckaccesspavement_Remarks, String isLoadingandoffLoadingshelter, String loadingandoffloadingshelter_Remarks, String isGuardHouse, String guardhouse_Remarks, String isFireextinguishersmokedetectorsandAlarmsystem, String fireextinguishersmokedetectorsandalarmsystem_remarks, String isGuardhouseandsecurityLights, String guardhouseandsecuritylights_remarks, String isWeighbridgesandweighingScales, String weighbridgesandweighingscales_remarks, String isOfficesworkingtelephonesandinternetacces, String officesworkingtelephonesandinternetaccess_remarks, String isProvisionofWASHfacilitie, String provisionofWASHfacilities_remarks, String isBooksofaccount, String booksofaccounts_remarks, String isRecallandtraceabilityprocedure, String recallandtraceabilityprocedures_remarks, String ssRecomendation, String reasonForThegiveReccomm, boolean is_synced, String remote_id) {
        this.food_warehouse_id = food_warehouse_id;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.foodWarehouselicence = foodWarehouselicence;
        this.localID = localID;
        this.ssleaseagreement = ssleaseagreement;
        this.isGraincleaningfacility = isGraincleaningfacility;
        this.graincleaningfacility_Remarks = graincleaningfacility_Remarks;
        this.isLoadingCapacity = isLoadingCapacity;
        this.loadingCapacity_Remarks = loadingCapacity_Remarks;
        this.isdrier = isdrier;
        this.drier_remarks = drier_remarks;
        this.islabroom = islabroom;
        this.labroom_Remarks = labroom_Remarks;
        this.isWallandVentilation = isWallandVentilation;
        this.wallandVentilation_Remarks = wallandVentilation_Remarks;
        this.isWaterproofProvisions = isWaterproofProvisions;
        this.waterproofProvisions_Remarks = waterproofProvisions_Remarks;
        this.isInternalSupport = isInternalSupport;
        this.internalSupport_Remarks = internalSupport_Remarks;
        this.isContinuousConcretefloor = isContinuousConcretefloor;
        this.continuousconcretefloor_Remarks = continuousconcretefloor_Remarks;
        this.isCorrugatedgalvanizedRoof = isCorrugatedgalvanizedRoof;
        this.corrugatedgalvanizedroof_Remarks = corrugatedgalvanizedroof_Remarks;
        this.isTheNohighGaugesteeldoors = isTheNohighGaugesteeldoors;
        this.theNohighgaugesteeldoors_Remarks = theNohighgaugesteeldoors_Remarks;
        this.isHygieneAndcleanliness = isHygieneAndcleanliness;
        this.hygieneAndCleanliness_Remarks = hygieneAndCleanliness_Remarks;
        this.isPerimeterwallandtruckaccessPavement = isPerimeterwallandtruckaccessPavement;
        this.perimeterwallandtruckaccesspavement_Remarks = perimeterwallandtruckaccesspavement_Remarks;
        this.isLoadingandoffLoadingshelter = isLoadingandoffLoadingshelter;
        this.loadingandoffloadingshelter_Remarks = loadingandoffloadingshelter_Remarks;
        this.isGuardHouse = isGuardHouse;
        this.guardhouse_Remarks = guardhouse_Remarks;
        this.isFireextinguishersmokedetectorsandAlarmsystem = isFireextinguishersmokedetectorsandAlarmsystem;
        this.fireextinguishersmokedetectorsandalarmsystem_remarks = fireextinguishersmokedetectorsandalarmsystem_remarks;
        this.isGuardhouseandsecurityLights = isGuardhouseandsecurityLights;
        this.guardhouseandsecuritylights_remarks = guardhouseandsecuritylights_remarks;
        this.isWeighbridgesandweighingScales = isWeighbridgesandweighingScales;
        this.weighbridgesandweighingscales_remarks = weighbridgesandweighingscales_remarks;
        this.isOfficesworkingtelephonesandinternetacces = isOfficesworkingtelephonesandinternetacces;
        this.officesworkingtelephonesandinternetaccess_remarks = officesworkingtelephonesandinternetaccess_remarks;
        this.isProvisionofWASHfacilitie = isProvisionofWASHfacilitie;
        this.provisionofWASHfacilities_remarks = provisionofWASHfacilities_remarks;
        this.isBooksofaccount = isBooksofaccount;
        this.booksofaccounts_remarks = booksofaccounts_remarks;
        this.isRecallandtraceabilityprocedure = isRecallandtraceabilityprocedure;
        this.recallandtraceabilityprocedures_remarks = recallandtraceabilityprocedures_remarks;
        this.ssRecomendation = ssRecomendation;
        this.reasonForThegiveReccomm = reasonForThegiveReccomm;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getFood_warehouse_id() {
        return food_warehouse_id;
    }

    public void setFood_warehouse_id(int food_warehouse_id) {
        this.food_warehouse_id = food_warehouse_id;
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

    public String getFoodWarehouselicence() {
        return foodWarehouselicence;
    }

    public void setFoodWarehouselicence(String foodWarehouselicence) {
        this.foodWarehouselicence = foodWarehouselicence;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getSsleaseagreement() {
        return ssleaseagreement;
    }

    public void setSsleaseagreement(String ssleaseagreement) {
        this.ssleaseagreement = ssleaseagreement;
    }

    public String getIsGraincleaningfacility() {
        return isGraincleaningfacility;
    }

    public void setIsGraincleaningfacility(String isGraincleaningfacility) {
        this.isGraincleaningfacility = isGraincleaningfacility;
    }

    public String getGraincleaningfacility_Remarks() {
        return graincleaningfacility_Remarks;
    }

    public void setGraincleaningfacility_Remarks(String graincleaningfacility_Remarks) {
        this.graincleaningfacility_Remarks = graincleaningfacility_Remarks;
    }

    public String getIsLoadingCapacity() {
        return isLoadingCapacity;
    }

    public void setIsLoadingCapacity(String isLoadingCapacity) {
        this.isLoadingCapacity = isLoadingCapacity;
    }

    public String getLoadingCapacity_Remarks() {
        return loadingCapacity_Remarks;
    }

    public void setLoadingCapacity_Remarks(String loadingCapacity_Remarks) {
        this.loadingCapacity_Remarks = loadingCapacity_Remarks;
    }

    public String getIsdrier() {
        return isdrier;
    }

    public void setIsdrier(String isdrier) {
        this.isdrier = isdrier;
    }

    public String getDrier_remarks() {
        return drier_remarks;
    }

    public void setDrier_remarks(String drier_remarks) {
        this.drier_remarks = drier_remarks;
    }

    public String getIslabroom() {
        return islabroom;
    }

    public void setIslabroom(String islabroom) {
        this.islabroom = islabroom;
    }

    public String getLabroom_Remarks() {
        return labroom_Remarks;
    }

    public void setLabroom_Remarks(String labroom_Remarks) {
        this.labroom_Remarks = labroom_Remarks;
    }

    public String getIsWallandVentilation() {
        return isWallandVentilation;
    }

    public void setIsWallandVentilation(String isWallandVentilation) {
        this.isWallandVentilation = isWallandVentilation;
    }

    public String getWallandVentilation_Remarks() {
        return wallandVentilation_Remarks;
    }

    public void setWallandVentilation_Remarks(String wallandVentilation_Remarks) {
        this.wallandVentilation_Remarks = wallandVentilation_Remarks;
    }

    public String getIsWaterproofProvisions() {
        return isWaterproofProvisions;
    }

    public void setIsWaterproofProvisions(String isWaterproofProvisions) {
        this.isWaterproofProvisions = isWaterproofProvisions;
    }

    public String getWaterproofProvisions_Remarks() {
        return waterproofProvisions_Remarks;
    }

    public void setWaterproofProvisions_Remarks(String waterproofProvisions_Remarks) {
        this.waterproofProvisions_Remarks = waterproofProvisions_Remarks;
    }

    public String getIsInternalSupport() {
        return isInternalSupport;
    }

    public void setIsInternalSupport(String isInternalSupport) {
        this.isInternalSupport = isInternalSupport;
    }

    public String getInternalSupport_Remarks() {
        return internalSupport_Remarks;
    }

    public void setInternalSupport_Remarks(String internalSupport_Remarks) {
        this.internalSupport_Remarks = internalSupport_Remarks;
    }

    public String getIsContinuousConcretefloor() {
        return isContinuousConcretefloor;
    }

    public void setIsContinuousConcretefloor(String isContinuousConcretefloor) {
        this.isContinuousConcretefloor = isContinuousConcretefloor;
    }

    public String getContinuousconcretefloor_Remarks() {
        return continuousconcretefloor_Remarks;
    }

    public void setContinuousconcretefloor_Remarks(String continuousconcretefloor_Remarks) {
        this.continuousconcretefloor_Remarks = continuousconcretefloor_Remarks;
    }

    public String getIsCorrugatedgalvanizedRoof() {
        return isCorrugatedgalvanizedRoof;
    }

    public void setIsCorrugatedgalvanizedRoof(String isCorrugatedgalvanizedRoof) {
        this.isCorrugatedgalvanizedRoof = isCorrugatedgalvanizedRoof;
    }

    public String getCorrugatedgalvanizedroof_Remarks() {
        return corrugatedgalvanizedroof_Remarks;
    }

    public void setCorrugatedgalvanizedroof_Remarks(String corrugatedgalvanizedroof_Remarks) {
        this.corrugatedgalvanizedroof_Remarks = corrugatedgalvanizedroof_Remarks;
    }

    public String getIsTheNohighGaugesteeldoors() {
        return isTheNohighGaugesteeldoors;
    }

    public void setIsTheNohighGaugesteeldoors(String isTheNohighGaugesteeldoors) {
        this.isTheNohighGaugesteeldoors = isTheNohighGaugesteeldoors;
    }

    public String getTheNohighgaugesteeldoors_Remarks() {
        return theNohighgaugesteeldoors_Remarks;
    }

    public void setTheNohighgaugesteeldoors_Remarks(String theNohighgaugesteeldoors_Remarks) {
        this.theNohighgaugesteeldoors_Remarks = theNohighgaugesteeldoors_Remarks;
    }

    public String getIsHygieneAndcleanliness() {
        return isHygieneAndcleanliness;
    }

    public void setIsHygieneAndcleanliness(String isHygieneAndcleanliness) {
        this.isHygieneAndcleanliness = isHygieneAndcleanliness;
    }

    public String getHygieneAndCleanliness_Remarks() {
        return hygieneAndCleanliness_Remarks;
    }

    public void setHygieneAndCleanliness_Remarks(String hygieneAndCleanliness_Remarks) {
        this.hygieneAndCleanliness_Remarks = hygieneAndCleanliness_Remarks;
    }

    public String getIsPerimeterwallandtruckaccessPavement() {
        return isPerimeterwallandtruckaccessPavement;
    }

    public void setIsPerimeterwallandtruckaccessPavement(String isPerimeterwallandtruckaccessPavement) {
        this.isPerimeterwallandtruckaccessPavement = isPerimeterwallandtruckaccessPavement;
    }

    public String getPerimeterwallandtruckaccesspavement_Remarks() {
        return perimeterwallandtruckaccesspavement_Remarks;
    }

    public void setPerimeterwallandtruckaccesspavement_Remarks(String perimeterwallandtruckaccesspavement_Remarks) {
        this.perimeterwallandtruckaccesspavement_Remarks = perimeterwallandtruckaccesspavement_Remarks;
    }

    public String getIsLoadingandoffLoadingshelter() {
        return isLoadingandoffLoadingshelter;
    }

    public void setIsLoadingandoffLoadingshelter(String isLoadingandoffLoadingshelter) {
        this.isLoadingandoffLoadingshelter = isLoadingandoffLoadingshelter;
    }

    public String getLoadingandoffloadingshelter_Remarks() {
        return loadingandoffloadingshelter_Remarks;
    }

    public void setLoadingandoffloadingshelter_Remarks(String loadingandoffloadingshelter_Remarks) {
        this.loadingandoffloadingshelter_Remarks = loadingandoffloadingshelter_Remarks;
    }

    public String getIsGuardHouse() {
        return isGuardHouse;
    }

    public void setIsGuardHouse(String isGuardHouse) {
        this.isGuardHouse = isGuardHouse;
    }

    public String getGuardhouse_Remarks() {
        return guardhouse_Remarks;
    }

    public void setGuardhouse_Remarks(String guardhouse_Remarks) {
        this.guardhouse_Remarks = guardhouse_Remarks;
    }

    public String getIsFireextinguishersmokedetectorsandAlarmsystem() {
        return isFireextinguishersmokedetectorsandAlarmsystem;
    }

    public void setIsFireextinguishersmokedetectorsandAlarmsystem(String isFireextinguishersmokedetectorsandAlarmsystem) {
        this.isFireextinguishersmokedetectorsandAlarmsystem = isFireextinguishersmokedetectorsandAlarmsystem;
    }

    public String getFireextinguishersmokedetectorsandalarmsystem_remarks() {
        return fireextinguishersmokedetectorsandalarmsystem_remarks;
    }

    public void setFireextinguishersmokedetectorsandalarmsystem_remarks(String fireextinguishersmokedetectorsandalarmsystem_remarks) {
        this.fireextinguishersmokedetectorsandalarmsystem_remarks = fireextinguishersmokedetectorsandalarmsystem_remarks;
    }

    public String getIsGuardhouseandsecurityLights() {
        return isGuardhouseandsecurityLights;
    }

    public void setIsGuardhouseandsecurityLights(String isGuardhouseandsecurityLights) {
        this.isGuardhouseandsecurityLights = isGuardhouseandsecurityLights;
    }

    public String getGuardhouseandsecuritylights_remarks() {
        return guardhouseandsecuritylights_remarks;
    }

    public void setGuardhouseandsecuritylights_remarks(String guardhouseandsecuritylights_remarks) {
        this.guardhouseandsecuritylights_remarks = guardhouseandsecuritylights_remarks;
    }

    public String getIsWeighbridgesandweighingScales() {
        return isWeighbridgesandweighingScales;
    }

    public void setIsWeighbridgesandweighingScales(String isWeighbridgesandweighingScales) {
        this.isWeighbridgesandweighingScales = isWeighbridgesandweighingScales;
    }

    public String getWeighbridgesandweighingscales_remarks() {
        return weighbridgesandweighingscales_remarks;
    }

    public void setWeighbridgesandweighingscales_remarks(String weighbridgesandweighingscales_remarks) {
        this.weighbridgesandweighingscales_remarks = weighbridgesandweighingscales_remarks;
    }

    public String getIsOfficesworkingtelephonesandinternetacces() {
        return isOfficesworkingtelephonesandinternetacces;
    }

    public void setIsOfficesworkingtelephonesandinternetacces(String isOfficesworkingtelephonesandinternetacces) {
        this.isOfficesworkingtelephonesandinternetacces = isOfficesworkingtelephonesandinternetacces;
    }

    public String getOfficesworkingtelephonesandinternetaccess_remarks() {
        return officesworkingtelephonesandinternetaccess_remarks;
    }

    public void setOfficesworkingtelephonesandinternetaccess_remarks(String officesworkingtelephonesandinternetaccess_remarks) {
        this.officesworkingtelephonesandinternetaccess_remarks = officesworkingtelephonesandinternetaccess_remarks;
    }

    public String getIsProvisionofWASHfacilitie() {
        return isProvisionofWASHfacilitie;
    }

    public void setIsProvisionofWASHfacilitie(String isProvisionofWASHfacilitie) {
        this.isProvisionofWASHfacilitie = isProvisionofWASHfacilitie;
    }

    public String getProvisionofWASHfacilities_remarks() {
        return provisionofWASHfacilities_remarks;
    }

    public void setProvisionofWASHfacilities_remarks(String provisionofWASHfacilities_remarks) {
        this.provisionofWASHfacilities_remarks = provisionofWASHfacilities_remarks;
    }

    public String getIsBooksofaccount() {
        return isBooksofaccount;
    }

    public void setIsBooksofaccount(String isBooksofaccount) {
        this.isBooksofaccount = isBooksofaccount;
    }

    public String getBooksofaccounts_remarks() {
        return booksofaccounts_remarks;
    }

    public void setBooksofaccounts_remarks(String booksofaccounts_remarks) {
        this.booksofaccounts_remarks = booksofaccounts_remarks;
    }

    public String getIsRecallandtraceabilityprocedure() {
        return isRecallandtraceabilityprocedure;
    }

    public void setIsRecallandtraceabilityprocedure(String isRecallandtraceabilityprocedure) {
        this.isRecallandtraceabilityprocedure = isRecallandtraceabilityprocedure;
    }

    public String getRecallandtraceabilityprocedures_remarks() {
        return recallandtraceabilityprocedures_remarks;
    }

    public void setRecallandtraceabilityprocedures_remarks(String recallandtraceabilityprocedures_remarks) {
        this.recallandtraceabilityprocedures_remarks = recallandtraceabilityprocedures_remarks;
    }

    public String getSsRecomendation() {
        return ssRecomendation;
    }

    public void setSsRecomendation(String ssRecomendation) {
        this.ssRecomendation = ssRecomendation;
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
