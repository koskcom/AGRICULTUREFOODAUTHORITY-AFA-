package co.ke.bsl.data.view;

public class SugarWholesalePricesSurveyBus
{
    private static SugarWholesalePricesSurveyBus single_instance = null;


    private SugarWholesalePricesSurveyBus() {
    }

    public static SugarWholesalePricesSurveyBus getInstance()
    {
        if (single_instance == null)
            single_instance = new SugarWholesalePricesSurveyBus();

        return single_instance;
    }

    public static SugarWholesalePricesSurveyBus getSingle_instance()
    {
        return single_instance;
    }

    public static void setSingle_instance(SugarWholesalePricesSurveyBus single_instance)
    {
        SugarWholesalePricesSurveyBus.single_instance = single_instance;
    }

    private String surveyType;
    private String city;
    private String document_Number;
    private String document_date;
    private String survey_Ending;
    private String shop;
    private String wholesale_Brand;
    private String wholesale_Brand_price_20kg;
    private String wholesale_Brand_price_24kg;
    private String wholesale_Brand_price_50kg;

    private String wholesale_Imported_Country;
    private String wholeSale_Imported_price_20kg;
    private String wholeSale_Imported_price_24kg;
    private String wholeSale_Imported_price_50kg;

    private String wholeSale_Stoked_Brand;
    private String wholeSale_Stoked_Brand_priceOf20kgBale;
    private String wholeSale_Stoked_Brand_priceOf24kgBale;
    private String wholeSale_Stoked_Brand_priceOf50kgBag;

    private String wholeSale_Imported_Stocked_origin;
    private String wholeSale_Imported_Stocked_price_20kg;
    private String wholeSale_Imported_Stocked_price_24kg;
    private String wholeSale_Imported_Stocked_price_50kg;

    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDocument_Number() {
        return document_Number;
    }

    public void setDocument_Number(String document_Number) {
        this.document_Number = document_Number;
    }

    public String getDocument_date() {
        return document_date;
    }

    public void setDocument_date(String document_date) {
        this.document_date = document_date;
    }

    public String getSurvey_Ending() {
        return survey_Ending;
    }

    public void setSurvey_Ending(String survey_Ending) {
        this.survey_Ending = survey_Ending;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getWholesale_Brand() {
        return wholesale_Brand;
    }

    public void setWholesale_Brand(String wholesale_Brand) {
        this.wholesale_Brand = wholesale_Brand;
    }

    public String getWholesale_Brand_price_20kg() {
        return wholesale_Brand_price_20kg;
    }

    public void setWholesale_Brand_price_20kg(String wholesale_Brand_price_20kg) {
        this.wholesale_Brand_price_20kg = wholesale_Brand_price_20kg;
    }

    public String getWholesale_Brand_price_24kg() {
        return wholesale_Brand_price_24kg;
    }

    public void setWholesale_Brand_price_24kg(String wholesale_Brand_price_24kg) {
        this.wholesale_Brand_price_24kg = wholesale_Brand_price_24kg;
    }

    public String getWholesale_Brand_price_50kg() {
        return wholesale_Brand_price_50kg;
    }

    public void setWholesale_Brand_price_50kg(String wholesale_Brand_price_50kg) {
        this.wholesale_Brand_price_50kg = wholesale_Brand_price_50kg;
    }

    public String getWholesale_Imported_Country() {
        return wholesale_Imported_Country;
    }

    public void setWholesale_Imported_Country(String wholesale_Imported_Country) {
        this.wholesale_Imported_Country = wholesale_Imported_Country;
    }

    public String getWholeSale_Imported_price_20kg() {
        return wholeSale_Imported_price_20kg;
    }

    public void setWholeSale_Imported_price_20kg(String wholeSale_Imported_price_20kg) {
        this.wholeSale_Imported_price_20kg = wholeSale_Imported_price_20kg;
    }

    public String getWholeSale_Imported_price_24kg() {
        return wholeSale_Imported_price_24kg;
    }

    public void setWholeSale_Imported_price_24kg(String wholeSale_Imported_price_24kg) {
        this.wholeSale_Imported_price_24kg = wholeSale_Imported_price_24kg;
    }

    public String getWholeSale_Imported_price_50kg() {
        return wholeSale_Imported_price_50kg;
    }

    public void setWholeSale_Imported_price_50kg(String wholeSale_Imported_price_50kg) {
        this.wholeSale_Imported_price_50kg = wholeSale_Imported_price_50kg;
    }

    public String getWholeSale_Stoked_Brand() {
        return wholeSale_Stoked_Brand;
    }

    public void setWholeSale_Stoked_Brand(String wholeSale_Stoked_Brand) {
        this.wholeSale_Stoked_Brand = wholeSale_Stoked_Brand;
    }

    public String getWholeSale_Stoked_Brand_priceOf50kgBag() {
        return wholeSale_Stoked_Brand_priceOf50kgBag;
    }

    public void setWholeSale_Stoked_Brand_priceOf50kgBag(String wholeSale_Stoked_Brand_priceOf50kgBag) {
        this.wholeSale_Stoked_Brand_priceOf50kgBag = wholeSale_Stoked_Brand_priceOf50kgBag;
    }

    public String getWholeSale_Stoked_Brand_priceOf24kgBale() {
        return wholeSale_Stoked_Brand_priceOf24kgBale;
    }

    public void setWholeSale_Stoked_Brand_priceOf24kgBale(String wholeSale_Stoked_Brand_priceOf24kgBale) {
        this.wholeSale_Stoked_Brand_priceOf24kgBale = wholeSale_Stoked_Brand_priceOf24kgBale;
    }

    public String getWholeSale_Stoked_Brand_priceOf20kgBale() {
        return wholeSale_Stoked_Brand_priceOf20kgBale;
    }

    public void setWholeSale_Stoked_Brand_priceOf20kgBale(String wholeSale_Stoked_Brand_priceOf20kgBale) {
        this.wholeSale_Stoked_Brand_priceOf20kgBale = wholeSale_Stoked_Brand_priceOf20kgBale;
    }

    public String getWholeSale_Imported_Stocked_origin() {
        return wholeSale_Imported_Stocked_origin;
    }

    public void setWholeSale_Imported_Stocked_origin(String wholeSale_Imported_Stocked_origin) {
        this.wholeSale_Imported_Stocked_origin = wholeSale_Imported_Stocked_origin;
    }

    public String getWholeSale_Imported_Stocked_price_20kg() {
        return wholeSale_Imported_Stocked_price_20kg;
    }

    public void setWholeSale_Imported_Stocked_price_20kg(String wholeSale_Imported_Stocked_price_20kg) {
        this.wholeSale_Imported_Stocked_price_20kg = wholeSale_Imported_Stocked_price_20kg;
    }

    public String getWholeSale_Imported_Stocked_price_24kg() {
        return wholeSale_Imported_Stocked_price_24kg;
    }

    public void setWholeSale_Imported_Stocked_price_24kg(String wholeSale_Imported_Stocked_price_24kg) {
        this.wholeSale_Imported_Stocked_price_24kg = wholeSale_Imported_Stocked_price_24kg;
    }

    public String getWholeSale_Imported_Stocked_price_50kg() {
        return wholeSale_Imported_Stocked_price_50kg;
    }

    public void setWholeSale_Imported_Stocked_price_50kg(String wholeSale_Imported_Stocked_price_50kg) {
        this.wholeSale_Imported_Stocked_price_50kg = wholeSale_Imported_Stocked_price_50kg;
    }
}
