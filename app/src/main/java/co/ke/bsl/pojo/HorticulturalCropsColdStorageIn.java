package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class HorticulturalCropsColdStorageIn implements java.io.Serializable{

    private String serverRecordID;

    private LoginRequest loginRequest;

    private String serviceType="CreateHorticulturalCropsColdStoragein";

    private String AFA_HCD_Horticultural_Crops_Cold_Storage_in_ID;

    public String localID;
   private String productsCategory;
    private String product;
    private String coldRoomNo;
    private String dateBrought;
    private String payCategory;
    private String payRemarks;
    private String packaginMaterial;
    private String packagingRemarks;
    private String quality;
    private String weightIn;
    private String parentID;

    public String getWeightIn() {
        return weightIn;
    }

    public void setWeightIn(String weightIn) {
        this.weightIn = weightIn;
    }

    public String getServerRecordID() {
        return serverRecordID;
    }

    public void setServerRecordID(String serverRecordID) {
        this.serverRecordID = serverRecordID;
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

    public String getAFA_HCD_Horticultural_Crops_Cold_Storage_in_ID() {
        return AFA_HCD_Horticultural_Crops_Cold_Storage_in_ID;
    }

    public void setAFA_HCD_Horticultural_Crops_Cold_Storage_in_ID(String AFA_HCD_Horticultural_Crops_Cold_Storage_in_ID) {
        this.AFA_HCD_Horticultural_Crops_Cold_Storage_in_ID = AFA_HCD_Horticultural_Crops_Cold_Storage_in_ID;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getProductsCategory() {
        return productsCategory;
    }

    public void setProductsCategory(String productsCategory) {
        this.productsCategory = productsCategory;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getColdRoomNo() {
        return coldRoomNo;
    }

    public void setColdRoomNo(String coldRoomNo) {
        this.coldRoomNo = coldRoomNo;
    }

    public String getDateBrought() {
        return dateBrought;
    }

    public void setDateBrought(String dateBrought) {
        this.dateBrought = dateBrought;
    }

    public String getPayCategory() {
        return payCategory;
    }

    public void setPayCategory(String payCategory) {
        this.payCategory = payCategory;
    }

    public String getPayRemarks() {
        return payRemarks;
    }

    public void setPayRemarks(String payRemarks) {
        this.payRemarks = payRemarks;
    }

    public String getPackaginMaterial() {
        return packaginMaterial;
    }

    public void setPackaginMaterial(String packaginMaterial) {
        this.packaginMaterial = packaginMaterial;
    }

    public String getPackagingRemarks() {
        return packagingRemarks;
    }

    public void setPackagingRemarks(String packagingRemarks) {
        this.packagingRemarks = packagingRemarks;
    }

    public String getQuality() {
        return quality;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
