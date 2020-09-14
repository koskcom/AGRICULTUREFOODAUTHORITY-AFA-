package co.ke.bsl.data.view;

public class NOCDMarketPriceSurveyBus {

    private static NOCDMarketPriceSurveyBus single_instance = null;

    private NOCDMarketPriceSurveyBus() {
    }

    public static NOCDMarketPriceSurveyBus getInstance() {
        if (single_instance == null)
            single_instance = new NOCDMarketPriceSurveyBus();

        return single_instance;
    }

    public static NOCDMarketPriceSurveyBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(NOCDMarketPriceSurveyBus single_instance) {
        NOCDMarketPriceSurveyBus.single_instance = single_instance;
    }

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
