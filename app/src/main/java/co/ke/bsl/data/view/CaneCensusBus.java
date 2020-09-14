package co.ke.bsl.data.view;

public class CaneCensusBus
{
    private static CaneCensusBus single_instance = null;

    public String getSugarCompany()
    {
        return sugarCompany;
    }

    public void setSugarCompany(String sugarCompany) {
        this.sugarCompany = sugarCompany;
    }

    public String getSugarCompanyCounty() {
        return sugarCompanyCounty;
    }

    public void setSugarCompanyCounty(String sugarCompanyCounty) {
        this.sugarCompanyCounty = sugarCompanyCounty;
    }

    public String getFarmerCounty() {
        return farmerCounty;
    }

    public void setFarmerCounty(String farmerCounty) {
        this.farmerCounty = farmerCounty;
    }

    public String getFarmerSubCounty() {
        return farmerSubCounty;
    }

    public void setFarmerSubCounty(String farmerSubCounty) {
        this.farmerSubCounty = farmerSubCounty;
    }

    public String getFarmerGender() {
        return farmerGender;
    }

    public void setFarmerGender(String farmerGender) {
        this.farmerGender = farmerGender;
    }

    public String getFarmerFullNames() {
        return farmerFullNames;
    }

    public void setFarmerFullNames(String farmerFullNames) {
        this.farmerFullNames = farmerFullNames;
    }

    public String getFarmerPhoneNumber() {
        return farmerPhoneNumber;
    }

    public void setFarmerPhoneNumber(String farmerPhoneNumber) {
        this.farmerPhoneNumber = farmerPhoneNumber;
    }

    public String getCropAge() {
        return cropAge;
    }

    public void setCropAge(String cropAge) {
        this.cropAge = cropAge;
    }

    public String getCropVariety() {
        return cropVariety;
    }

    public void setCropVariety(String cropVariety) {
        this.cropVariety = cropVariety;
    }

    public String getCropHecterage() {
        return cropHecterage;
    }

    public void setCropHecterage(String cropHecterage) {
        this.cropHecterage = cropHecterage;
    }

    public String getCropPestsAndDisease() {
        return cropPestsAndDisease;
    }

    public void setCropPestsAndDisease(String cropPestsAndDisease) {
        this.cropPestsAndDisease = cropPestsAndDisease;
    }

    public String getCropClass() {
        return cropClass;
    }

    public void setCropClass(String cropClass) {
        this.cropClass = cropClass;
    }

    public String getCropDensity() {
        return cropDensity;
    }

    public void setCropDensity(String cropDensity) {
        this.cropDensity = cropDensity;
    }

    public String getCropColour() {
        return cropColour;
    }

    public void setCropColour(String cropColour) {
        this.cropColour = cropColour;
    }

    public String getCropVigour() {
        return cropVigour;
    }

    public void setCropVigour(String cropVigour) {
        this.cropVigour = cropVigour;
    }

    public String getCropExpectedTCH() {
        return cropExpectedTCH;
    }

    public void setCropExpectedTCH(String cropExpectedTCH) {
        this.cropExpectedTCH = cropExpectedTCH;
    }

    private String sugarCompany;
    private String sugarCompanyCounty;
    private String farmerCounty;
    private String farmerSubCounty;
    private String farmerGender;
    private String farmerFullNames;
    private String farmerPhoneNumber;
    private String farmerIDNumber;
    private String cropAge;
    private String cropVariety;
    private String cropHecterage;
    private String cropPestsAndDisease;
    private String cropClass;
    private String cropDensity;
    private String cropColour;
    private String cropVigour;
    private String cropExpectedTCH;

    public String getFarmerIDNumber() {
        return farmerIDNumber;
    }

    public void setFarmerIDNumber(String farmerIDNumber) {
        this.farmerIDNumber = farmerIDNumber;
    }



    private CaneCensusBus() {
    }

    public static CaneCensusBus getInstance() {
        if (single_instance == null)
            single_instance = new CaneCensusBus();

        return single_instance;
    }

    public static CaneCensusBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(CaneCensusBus single_instance) {
        CaneCensusBus.single_instance = single_instance;
    }
}
