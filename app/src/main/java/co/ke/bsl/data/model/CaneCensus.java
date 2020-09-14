package co.ke.bsl.data.model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CaneCensus {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int canecensus_id;
    
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
    private boolean is_synced;
    private String remote_id;

    public CaneCensus(int canecensus_id, String sugarCompany, String sugarCompanyCounty, String farmerCounty, String farmerSubCounty, String farmerGender, String farmerFullNames, String farmerPhoneNumber, String farmerIDNumber, String cropAge, String cropVariety, String cropHecterage, String cropPestsAndDisease, String cropClass, String cropDensity, String cropColour, String cropVigour, String cropExpectedTCH, boolean is_synced, String remote_id) {
        this.canecensus_id = canecensus_id;
        this.sugarCompany = sugarCompany;
        this.sugarCompanyCounty = sugarCompanyCounty;
        this.farmerCounty = farmerCounty;
        this.farmerSubCounty = farmerSubCounty;
        this.farmerGender = farmerGender;
        this.farmerFullNames = farmerFullNames;
        this.farmerPhoneNumber = farmerPhoneNumber;
        this.farmerIDNumber = farmerIDNumber;
        this.cropAge = cropAge;
        this.cropVariety = cropVariety;
        this.cropHecterage = cropHecterage;
        this.cropPestsAndDisease = cropPestsAndDisease;
        this.cropClass = cropClass;
        this.cropDensity = cropDensity;
        this.cropColour = cropColour;
        this.cropVigour = cropVigour;
        this.cropExpectedTCH = cropExpectedTCH;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }
    
    public int getCanecensus_id() {
        return canecensus_id;
    }
    
    public void setCanecensus_id(int canecensus_id) {
        this.canecensus_id = canecensus_id;
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

    public String getFarmerIDNumber() {
        return farmerIDNumber;
    }

    public void setFarmerIDNumber(String farmerIDNumber) {
        this.farmerIDNumber = farmerIDNumber;
    }

    public String getSugarCompany() {
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


}
