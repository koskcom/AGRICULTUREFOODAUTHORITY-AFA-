package co.ke.bsl.data.view;

public class HCDHorticulturalCropsColdStorageBus {
    private static HCDHorticulturalCropsColdStorageBus single_instance = null;

    private HCDHorticulturalCropsColdStorageBus() {
    }

    public static HCDHorticulturalCropsColdStorageBus getInstance() {
        if (single_instance == null)
            single_instance = new HCDHorticulturalCropsColdStorageBus();

        return single_instance;
    }

    public static HCDHorticulturalCropsColdStorageBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(HCDHorticulturalCropsColdStorageBus single_instance) {
        HCDHorticulturalCropsColdStorageBus.single_instance = single_instance;
    }


    private String nameOfApplicant;
    private String localID;
    private String productsCategory;
    private String product;
    private String coldRoomNo;
    private String dateBrouught;
    private String payCategory;
    private String payCategoryRemarks;
    private String packagingMaterial;
    private String weightIn;
    private String quality;
    private String dateOut;
    private String weightOut;
    private String balance;
    private String charges;
    private boolean is_synced;
    private String remote_id;

    public String getPayCategoryRemarks() {
        return payCategoryRemarks;
    }

    public void setPayCategoryRemarks(String payCategoryRemarks) {
        this.payCategoryRemarks = payCategoryRemarks;
    }

    public String getWeightIn() {
        return weightIn;
    }

    public void setWeightIn(String weightIn) {
        this.weightIn = weightIn;
    }

    public String getNameOfApplicant() {
        return nameOfApplicant;
    }

    public void setNameOfApplicant(String nameOfApplicant) {
        this.nameOfApplicant = nameOfApplicant;
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
