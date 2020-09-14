package co.ke.bsl.data.model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HCDHorticulturalCropsColdStorage {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int hcdHorticultural_Crops_Cold_Storage_id;
    private String nameOfApplicant;
    private String localID;
    private String productsCategory;
    private String product;
    private String coldRoomNo;
    private String dateBrouught;
    private String payCategory;
    private String payCategoryRemarks;
    private String packagingMaterial;
    private String packagingMaterialRemarks;
    private String quality;
    private String dateOut;
    private String weightOut;
    private String balance;
    private String charges;
    private boolean is_synced;
    private String remote_id;

    public HCDHorticulturalCropsColdStorage(int hcdHorticultural_Crops_Cold_Storage_id, String nameOfApplicant, String localID, String productsCategory, String product, String coldRoomNo, String dateBrouught, String payCategory, String payCategoryRemarks, String packagingMaterial, String packagingMaterialRemarks, String quality, String dateOut, String weightOut, String balance, String charges, boolean is_synced, String remote_id) {
        this.hcdHorticultural_Crops_Cold_Storage_id = hcdHorticultural_Crops_Cold_Storage_id;
        this.nameOfApplicant = nameOfApplicant;
        this.localID = localID;
        this.productsCategory = productsCategory;
        this.product = product;
        this.coldRoomNo = coldRoomNo;
        this.dateBrouught = dateBrouught;
        this.payCategory = payCategory;
        this.payCategoryRemarks = payCategoryRemarks;
        this.packagingMaterial = packagingMaterial;
        this.packagingMaterialRemarks = packagingMaterialRemarks;
        this.quality = quality;
        this.dateOut = dateOut;
        this.weightOut = weightOut;
        this.balance = balance;
        this.charges = charges;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getHcdHorticultural_Crops_Cold_Storage_id() {
        return hcdHorticultural_Crops_Cold_Storage_id;
    }

    public void setHcdHorticultural_Crops_Cold_Storage_id(int hcdHorticultural_Crops_Cold_Storage_id) {
        this.hcdHorticultural_Crops_Cold_Storage_id = hcdHorticultural_Crops_Cold_Storage_id;
    }

    public String getNameOfApplicant() {
        return nameOfApplicant;
    }

    public void setNameOfApplicant(String nameOfApplicant) {
        this.nameOfApplicant = nameOfApplicant;
    }

    public String getPayCategoryRemarks() {
        return payCategoryRemarks;
    }

    public void setPayCategoryRemarks(String payCategoryRemarks) {
        this.payCategoryRemarks = payCategoryRemarks;
    }

    public String getPackagingMaterialRemarks() {
        return packagingMaterialRemarks;
    }

    public void setPackagingMaterialRemarks(String packagingMaterialRemarks) {
        this.packagingMaterialRemarks = packagingMaterialRemarks;
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

    public String getDateBrouught() {
        return dateBrouught;
    }

    public void setDateBrouught(String dateBrouught) {
        this.dateBrouught = dateBrouught;
    }

    public String getPayCategory() {
        return payCategory;
    }

    public void setPayCategory(String payCategory) {
        this.payCategory = payCategory;
    }

    public String getPackagingMaterial() {
        return packagingMaterial;
    }

    public void setPackagingMaterial(String packagingMaterial) {
        this.packagingMaterial = packagingMaterial;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getWeightOut() {
        return weightOut;
    }

    public void setWeightOut(String weightOut) {
        this.weightOut = weightOut;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
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
