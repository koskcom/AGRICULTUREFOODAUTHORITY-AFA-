package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class NOCDMarketPriceSurvey {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int nocdMarketPriceSurveyID;
    private String countyID;
    private String subCountyID;
    private String subLocation;
    private String longitude;
    private String latitude;
    private String product;
    private String brandName;
    private String quantity;
    private String price;
    private String marketOutlet;
    private String localID;
    private boolean is_synced;
    private String remote_id;

    public NOCDMarketPriceSurvey(int nocdMarketPriceSurveyID, String countyID, String subCountyID, String subLocation, String longitude, String latitude, String product, String brandName, String quantity, String price, String marketOutlet, String localID, boolean is_synced, String remote_id) {
        this.nocdMarketPriceSurveyID = nocdMarketPriceSurveyID;
        this.countyID = countyID;
        this.subCountyID = subCountyID;
        this.subLocation = subLocation;
        this.longitude = longitude;
        this.latitude = latitude;
        this.product = product;
        this.brandName = brandName;
        this.quantity = quantity;
        this.price = price;
        this.marketOutlet = marketOutlet;
        this.localID = localID;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getNocdMarketPriceSurveyID() {
        return nocdMarketPriceSurveyID;
    }

    public void setNocdMarketPriceSurveyID(int nocdMarketPriceSurveyID) {
        this.nocdMarketPriceSurveyID = nocdMarketPriceSurveyID;
    }

    public String getCountyID() {
        return countyID;
    }

    public void setCountyID(String countyID) {
        this.countyID = countyID;
    }

    public String getSubCountyID() {
        return subCountyID;
    }

    public void setSubCountyID(String subCountyID) {
        this.subCountyID = subCountyID;
    }

    public String getSubLocation() {
        return subLocation;
    }

    public void setSubLocation(String subLocation) {
        this.subLocation = subLocation;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMarketOutlet() {
        return marketOutlet;
    }

    public void setMarketOutlet(String marketOutlet) {
        this.marketOutlet = marketOutlet;
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
}
