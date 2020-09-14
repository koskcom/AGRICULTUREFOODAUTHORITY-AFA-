package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

import java.io.Serializable;

public class NOCDMarketPriceSurveyDetails implements Serializable {

    private LoginRequest loginRequest;

    private String serviceType="QueryNOCD";

    private String AFA_ND_Marketprices_ID;

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
    private String parentID;

    private String localID;

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    public void setLoginRequest(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getAFA_ND_Marketprices_ID() {
        return AFA_ND_Marketprices_ID;
    }

    public void setAFA_ND_Marketprices_ID(String AFA_ND_Marketprices_ID) {
        this.AFA_ND_Marketprices_ID = AFA_ND_Marketprices_ID;
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
}
