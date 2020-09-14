package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CoffeeMillerLicenceApplication {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int coffee_miller_licence_application_id;

    private String documentNumber;
    private String documentDate;
    private String applicantName;
    private String licenceNumber;
    private String localID;
    private String officeCondition;
    private String nemaCertification;
    private String nemaCertificationFindings;
    private String occupationalSafety;
    private String occupationalSafetyFindings;
    private String millingMachinery;
    private String millingMachineryFindings;
    private String wasteTeas;
    private String wasteTeasFindings;
    private String liqouringCupping;
    private String liqouringCuppingFindings;
    private String engagementQualified;
    private String engagementQualifiedFindings;
    private String protectiveClothing;
    private String protectiveClothingFindings;
    private String weighingScale;
    private String weighingScaleFindings;
    private String validInsurance;
    private String validInsuranceFindings;
    private String generalSecurity;
    private String generalSecurityFindings;
    private String growersContracted;
    private String growersContractedFindings;
    private String millingReturns;
    private String millingReturnsFindings;
    private String walls;
    private String wallsFindings;
    private String floors;
    private String floorsFindings;
    private String roof;
    private String roofFindings;
    private String ventilation;
    private String ventilationFindings;
    private String washroom;
    private String washroomFindings;
    private String coffeePackaging;
    private String coffeePackagingFindings;
    private String generalHygiene;
    private String generalHygieneFindings;
    private String firefighting;
    private String firefightingFindings;
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private String ssTypeOfservice;
    private String ssCurency;
    private String justification;
    private boolean is_synced;
    private String remote_id;

    public CoffeeMillerLicenceApplication(int coffee_miller_licence_application_id, String documentNumber, String documentDate, String applicantName, String licenceNumber, String localID, String officeCondition, String nemaCertification, String nemaCertificationFindings, String occupationalSafety, String occupationalSafetyFindings, String millingMachinery, String millingMachineryFindings, String wasteTeas, String wasteTeasFindings, String liqouringCupping, String liqouringCuppingFindings, String engagementQualified, String engagementQualifiedFindings, String protectiveClothing, String protectiveClothingFindings, String weighingScale, String weighingScaleFindings, String validInsurance, String validInsuranceFindings, String generalSecurity, String generalSecurityFindings, String growersContracted, String growersContractedFindings, String millingReturns, String millingReturnsFindings, String walls, String wallsFindings, String floors, String floorsFindings, String roof, String roofFindings, String ventilation, String ventilationFindings, String washroom, String washroomFindings, String coffeePackaging, String coffeePackagingFindings, String generalHygiene, String generalHygieneFindings, String firefighting, String firefightingFindings, String officerrecommendation, String officerrecommendation_remark, String ssTypeOfservice, String ssCurency, String justification, boolean is_synced, String remote_id) {
        this.coffee_miller_licence_application_id = coffee_miller_licence_application_id;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.applicantName = applicantName;
        this.licenceNumber = licenceNumber;
        this.localID = localID;
        this.officeCondition = officeCondition;
        this.nemaCertification = nemaCertification;
        this.nemaCertificationFindings = nemaCertificationFindings;
        this.occupationalSafety = occupationalSafety;
        this.occupationalSafetyFindings = occupationalSafetyFindings;
        this.millingMachinery = millingMachinery;
        this.millingMachineryFindings = millingMachineryFindings;
        this.wasteTeas = wasteTeas;
        this.wasteTeasFindings = wasteTeasFindings;
        this.liqouringCupping = liqouringCupping;
        this.liqouringCuppingFindings = liqouringCuppingFindings;
        this.engagementQualified = engagementQualified;
        this.engagementQualifiedFindings = engagementQualifiedFindings;
        this.protectiveClothing = protectiveClothing;
        this.protectiveClothingFindings = protectiveClothingFindings;
        this.weighingScale = weighingScale;
        this.weighingScaleFindings = weighingScaleFindings;
        this.validInsurance = validInsurance;
        this.validInsuranceFindings = validInsuranceFindings;
        this.generalSecurity = generalSecurity;
        this.generalSecurityFindings = generalSecurityFindings;
        this.growersContracted = growersContracted;
        this.growersContractedFindings = growersContractedFindings;
        this.millingReturns = millingReturns;
        this.millingReturnsFindings = millingReturnsFindings;
        this.walls = walls;
        this.wallsFindings = wallsFindings;
        this.floors = floors;
        this.floorsFindings = floorsFindings;
        this.roof = roof;
        this.roofFindings = roofFindings;
        this.ventilation = ventilation;
        this.ventilationFindings = ventilationFindings;
        this.washroom = washroom;
        this.washroomFindings = washroomFindings;
        this.coffeePackaging = coffeePackaging;
        this.coffeePackagingFindings = coffeePackagingFindings;
        this.generalHygiene = generalHygiene;
        this.generalHygieneFindings = generalHygieneFindings;
        this.firefighting = firefighting;
        this.firefightingFindings = firefightingFindings;
        this.officerrecommendation = officerrecommendation;
        this.officerrecommendation_remark = officerrecommendation_remark;
        this.ssTypeOfservice = ssTypeOfservice;
        this.ssCurency = ssCurency;
        this.justification = justification;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getCoffee_miller_licence_application_id() {
        return coffee_miller_licence_application_id;
    }

    public void setCoffee_miller_licence_application_id(int coffee_miller_licence_application_id) {
        this.coffee_miller_licence_application_id = coffee_miller_licence_application_id;
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

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getOfficeCondition() {
        return officeCondition;
    }

    public void setOfficeCondition(String officeCondition) {
        this.officeCondition = officeCondition;
    }

    public String getNemaCertification() {
        return nemaCertification;
    }

    public void setNemaCertification(String nemaCertification) {
        this.nemaCertification = nemaCertification;
    }

    public String getNemaCertificationFindings() {
        return nemaCertificationFindings;
    }

    public void setNemaCertificationFindings(String nemaCertificationFindings) {
        this.nemaCertificationFindings = nemaCertificationFindings;
    }

    public String getOccupationalSafety() {
        return occupationalSafety;
    }

    public void setOccupationalSafety(String occupationalSafety) {
        this.occupationalSafety = occupationalSafety;
    }

    public String getOccupationalSafetyFindings() {
        return occupationalSafetyFindings;
    }

    public void setOccupationalSafetyFindings(String occupationalSafetyFindings) {
        this.occupationalSafetyFindings = occupationalSafetyFindings;
    }

    public String getMillingMachinery() {
        return millingMachinery;
    }

    public void setMillingMachinery(String millingMachinery) {
        this.millingMachinery = millingMachinery;
    }

    public String getMillingMachineryFindings() {
        return millingMachineryFindings;
    }

    public void setMillingMachineryFindings(String millingMachineryFindings) {
        this.millingMachineryFindings = millingMachineryFindings;
    }

    public String getWasteTeas() {
        return wasteTeas;
    }

    public void setWasteTeas(String wasteTeas) {
        this.wasteTeas = wasteTeas;
    }

    public String getWasteTeasFindings() {
        return wasteTeasFindings;
    }

    public void setWasteTeasFindings(String wasteTeasFindings) {
        this.wasteTeasFindings = wasteTeasFindings;
    }

    public String getLiqouringCupping() {
        return liqouringCupping;
    }

    public void setLiqouringCupping(String liqouringCupping) {
        this.liqouringCupping = liqouringCupping;
    }

    public String getLiqouringCuppingFindings() {
        return liqouringCuppingFindings;
    }

    public void setLiqouringCuppingFindings(String liqouringCuppingFindings) {
        this.liqouringCuppingFindings = liqouringCuppingFindings;
    }

    public String getEngagementQualified() {
        return engagementQualified;
    }

    public void setEngagementQualified(String engagementQualified) {
        this.engagementQualified = engagementQualified;
    }

    public String getEngagementQualifiedFindings() {
        return engagementQualifiedFindings;
    }

    public void setEngagementQualifiedFindings(String engagementQualifiedFindings) {
        this.engagementQualifiedFindings = engagementQualifiedFindings;
    }

    public String getProtectiveClothing() {
        return protectiveClothing;
    }

    public void setProtectiveClothing(String protectiveClothing) {
        this.protectiveClothing = protectiveClothing;
    }

    public String getProtectiveClothingFindings() {
        return protectiveClothingFindings;
    }

    public void setProtectiveClothingFindings(String protectiveClothingFindings) {
        this.protectiveClothingFindings = protectiveClothingFindings;
    }

    public String getWeighingScale() {
        return weighingScale;
    }

    public void setWeighingScale(String weighingScale) {
        this.weighingScale = weighingScale;
    }

    public String getWeighingScaleFindings() {
        return weighingScaleFindings;
    }

    public void setWeighingScaleFindings(String weighingScaleFindings) {
        this.weighingScaleFindings = weighingScaleFindings;
    }

    public String getValidInsurance() {
        return validInsurance;
    }

    public void setValidInsurance(String validInsurance) {
        this.validInsurance = validInsurance;
    }

    public String getValidInsuranceFindings() {
        return validInsuranceFindings;
    }

    public void setValidInsuranceFindings(String validInsuranceFindings) {
        this.validInsuranceFindings = validInsuranceFindings;
    }

    public String getGeneralSecurity() {
        return generalSecurity;
    }

    public void setGeneralSecurity(String generalSecurity) {
        this.generalSecurity = generalSecurity;
    }

    public String getGeneralSecurityFindings() {
        return generalSecurityFindings;
    }

    public void setGeneralSecurityFindings(String generalSecurityFindings) {
        this.generalSecurityFindings = generalSecurityFindings;
    }

    public String getGrowersContracted() {
        return growersContracted;
    }

    public void setGrowersContracted(String growersContracted) {
        this.growersContracted = growersContracted;
    }

    public String getGrowersContractedFindings() {
        return growersContractedFindings;
    }

    public void setGrowersContractedFindings(String growersContractedFindings) {
        this.growersContractedFindings = growersContractedFindings;
    }

    public String getMillingReturns() {
        return millingReturns;
    }

    public void setMillingReturns(String millingReturns) {
        this.millingReturns = millingReturns;
    }

    public String getMillingReturnsFindings() {
        return millingReturnsFindings;
    }

    public void setMillingReturnsFindings(String millingReturnsFindings) {
        this.millingReturnsFindings = millingReturnsFindings;
    }

    public String getWalls() {
        return walls;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public String getWallsFindings() {
        return wallsFindings;
    }

    public void setWallsFindings(String wallsFindings) {
        this.wallsFindings = wallsFindings;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getFloorsFindings() {
        return floorsFindings;
    }

    public void setFloorsFindings(String floorsFindings) {
        this.floorsFindings = floorsFindings;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public String getRoofFindings() {
        return roofFindings;
    }

    public void setRoofFindings(String roofFindings) {
        this.roofFindings = roofFindings;
    }

    public String getVentilation() {
        return ventilation;
    }

    public void setVentilation(String ventilation) {
        this.ventilation = ventilation;
    }

    public String getVentilationFindings() {
        return ventilationFindings;
    }

    public void setVentilationFindings(String ventilationFindings) {
        this.ventilationFindings = ventilationFindings;
    }

    public String getWashroom() {
        return washroom;
    }

    public void setWashroom(String washroom) {
        this.washroom = washroom;
    }

    public String getWashroomFindings() {
        return washroomFindings;
    }

    public void setWashroomFindings(String washroomFindings) {
        this.washroomFindings = washroomFindings;
    }

    public String getCoffeePackaging() {
        return coffeePackaging;
    }

    public void setCoffeePackaging(String coffeePackaging) {
        this.coffeePackaging = coffeePackaging;
    }

    public String getCoffeePackagingFindings() {
        return coffeePackagingFindings;
    }

    public void setCoffeePackagingFindings(String coffeePackagingFindings) {
        this.coffeePackagingFindings = coffeePackagingFindings;
    }

    public String getGeneralHygiene() {
        return generalHygiene;
    }

    public void setGeneralHygiene(String generalHygiene) {
        this.generalHygiene = generalHygiene;
    }

    public String getGeneralHygieneFindings() {
        return generalHygieneFindings;
    }

    public void setGeneralHygieneFindings(String generalHygieneFindings) {
        this.generalHygieneFindings = generalHygieneFindings;
    }

    public String getFirefighting() {
        return firefighting;
    }

    public void setFirefighting(String firefighting) {
        this.firefighting = firefighting;
    }

    public String getFirefightingFindings() {
        return firefightingFindings;
    }

    public void setFirefightingFindings(String firefightingFindings) {
        this.firefightingFindings = firefightingFindings;
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

    public String getSsTypeOfservice() {
        return ssTypeOfservice;
    }

    public void setSsTypeOfservice(String ssTypeOfservice) {
        this.ssTypeOfservice = ssTypeOfservice;
    }

    public String getSsCurency() {
        return ssCurency;
    }

    public void setSsCurency(String ssCurency) {
        this.ssCurency = ssCurency;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
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
