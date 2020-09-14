package co.ke.bsl.data.model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class SugarRetailPricesSurvey {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int sugarRetailPricesSurvey_id;
    private String surveyType;
    private String city;
    private String document_Number;
    private String document_date;
    private String survey_Ending;
    private String shop;
    private String retail_local_Brand;
    private String retail_local_Brandprice_1kg;
    private String retail_local_Brandprice_2kg;
    private String retail_Loose_Imported_price_origin;
    private String retail_Loose_Imported_price_of_1kg;
    private String retail_Loose_Imported_price_of_2kg;
    private String retail_Loose_Local_Brandbrand;
    private String retail_Loose_Local_Brandprice_of_1kg;
    private String retail_Loose_Local_Brandprice_of_2kg;
    private String retail_Stocked_Imported_origin;
    private String retail_Stocked_Imported_price_of_20kg;
    private String retail_Stocked_Imported_price_of_24kg;
    private String retail_Stocked_Imported_price_of_50kg;
    private String retail_stocked_brand;
    private String retail_Stocked_Local_Brandprice_of_20kg;
    private String retail_Stocked_Local_Brandprice_of_24kg;
    private String retail_Stocked_Local_Brandprice_of_50kg;
    private boolean is_synced;
    private String remote_id;

    public SugarRetailPricesSurvey(int sugarRetailPricesSurvey_id, String surveyType, String city, String document_Number, String document_date, String survey_Ending, String shop, String retail_local_Brand, String retail_local_Brandprice_1kg, String retail_local_Brandprice_2kg, String retail_Loose_Imported_price_origin, String retail_Loose_Imported_price_of_1kg, String retail_Loose_Imported_price_of_2kg, String retail_Loose_Local_Brandbrand, String retail_Loose_Local_Brandprice_of_1kg, String retail_Loose_Local_Brandprice_of_2kg, String retail_Stocked_Imported_origin, String retail_Stocked_Imported_price_of_20kg, String retail_Stocked_Imported_price_of_24kg, String retail_Stocked_Imported_price_of_50kg, String retail_stocked_brand, String retail_Stocked_Local_Brandprice_of_20kg, String retail_Stocked_Local_Brandprice_of_24kg, String retail_Stocked_Local_Brandprice_of_50kg, boolean is_synced, String remote_id) {
        this.sugarRetailPricesSurvey_id = sugarRetailPricesSurvey_id;
        this.surveyType = surveyType;
        this.city = city;
        this.document_Number = document_Number;
        this.document_date = document_date;
        this.survey_Ending = survey_Ending;
        this.shop = shop;
        this.retail_local_Brand = retail_local_Brand;
        this.retail_local_Brandprice_1kg = retail_local_Brandprice_1kg;
        this.retail_local_Brandprice_2kg = retail_local_Brandprice_2kg;
        this.retail_Loose_Imported_price_origin = retail_Loose_Imported_price_origin;
        this.retail_Loose_Imported_price_of_1kg = retail_Loose_Imported_price_of_1kg;
        this.retail_Loose_Imported_price_of_2kg = retail_Loose_Imported_price_of_2kg;
        this.retail_Loose_Local_Brandbrand = retail_Loose_Local_Brandbrand;
        this.retail_Loose_Local_Brandprice_of_1kg = retail_Loose_Local_Brandprice_of_1kg;
        this.retail_Loose_Local_Brandprice_of_2kg = retail_Loose_Local_Brandprice_of_2kg;
        this.retail_Stocked_Imported_origin = retail_Stocked_Imported_origin;
        this.retail_Stocked_Imported_price_of_20kg = retail_Stocked_Imported_price_of_20kg;
        this.retail_Stocked_Imported_price_of_24kg = retail_Stocked_Imported_price_of_24kg;
        this.retail_Stocked_Imported_price_of_50kg = retail_Stocked_Imported_price_of_50kg;
        this.retail_stocked_brand = retail_stocked_brand;
        this.retail_Stocked_Local_Brandprice_of_20kg = retail_Stocked_Local_Brandprice_of_20kg;
        this.retail_Stocked_Local_Brandprice_of_24kg = retail_Stocked_Local_Brandprice_of_24kg;
        this.retail_Stocked_Local_Brandprice_of_50kg = retail_Stocked_Local_Brandprice_of_50kg;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getSugarRetailPricesSurvey_id() {
        return sugarRetailPricesSurvey_id;
    }

    public void setSugarRetailPricesSurvey_id(int sugarRetailPricesSurvey_id) {
        this.sugarRetailPricesSurvey_id = sugarRetailPricesSurvey_id;
    }

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

    public String getRetail_local_Brand() {
        return retail_local_Brand;
    }

    public void setRetail_local_Brand(String retail_local_Brand) {
        this.retail_local_Brand = retail_local_Brand;
    }

    public String getRetail_local_Brandprice_1kg() {
        return retail_local_Brandprice_1kg;
    }

    public void setRetail_local_Brandprice_1kg(String retail_local_Brandprice_1kg) {
        this.retail_local_Brandprice_1kg = retail_local_Brandprice_1kg;
    }

    public String getRetail_local_Brandprice_2kg() {
        return retail_local_Brandprice_2kg;
    }

    public void setRetail_local_Brandprice_2kg(String retail_local_Brandprice_2kg) {
        this.retail_local_Brandprice_2kg = retail_local_Brandprice_2kg;
    }

    public String getRetail_Loose_Imported_price_origin() {
        return retail_Loose_Imported_price_origin;
    }

    public void setRetail_Loose_Imported_price_origin(String retail_Loose_Imported_price_origin) {
        this.retail_Loose_Imported_price_origin = retail_Loose_Imported_price_origin;
    }

    public String getRetail_Loose_Imported_price_of_1kg() {
        return retail_Loose_Imported_price_of_1kg;
    }

    public void setRetail_Loose_Imported_price_of_1kg(String retail_Loose_Imported_price_of_1kg) {
        this.retail_Loose_Imported_price_of_1kg = retail_Loose_Imported_price_of_1kg;
    }

    public String getRetail_Loose_Imported_price_of_2kg() {
        return retail_Loose_Imported_price_of_2kg;
    }

    public void setRetail_Loose_Imported_price_of_2kg(String retail_Loose_Imported_price_of_2kg) {
        this.retail_Loose_Imported_price_of_2kg = retail_Loose_Imported_price_of_2kg;
    }

    public String getRetail_Loose_Local_Brandbrand() {
        return retail_Loose_Local_Brandbrand;
    }

    public void setRetail_Loose_Local_Brandbrand(String retail_Loose_Local_Brandbrand) {
        this.retail_Loose_Local_Brandbrand = retail_Loose_Local_Brandbrand;
    }

    public String getRetail_Loose_Local_Brandprice_of_1kg() {
        return retail_Loose_Local_Brandprice_of_1kg;
    }

    public void setRetail_Loose_Local_Brandprice_of_1kg(String retail_Loose_Local_Brandprice_of_1kg) {
        this.retail_Loose_Local_Brandprice_of_1kg = retail_Loose_Local_Brandprice_of_1kg;
    }

    public String getRetail_Loose_Local_Brandprice_of_2kg() {
        return retail_Loose_Local_Brandprice_of_2kg;
    }

    public void setRetail_Loose_Local_Brandprice_of_2kg(String retail_Loose_Local_Brandprice_of_2kg) {
        this.retail_Loose_Local_Brandprice_of_2kg = retail_Loose_Local_Brandprice_of_2kg;
    }

    public String getRetail_Stocked_Imported_origin() {
        return retail_Stocked_Imported_origin;
    }

    public void setRetail_Stocked_Imported_origin(String retail_Stocked_Imported_origin) {
        this.retail_Stocked_Imported_origin = retail_Stocked_Imported_origin;
    }

    public String getRetail_Stocked_Imported_price_of_20kg() {
        return retail_Stocked_Imported_price_of_20kg;
    }

    public void setRetail_Stocked_Imported_price_of_20kg(String retail_Stocked_Imported_price_of_20kg) {
        this.retail_Stocked_Imported_price_of_20kg = retail_Stocked_Imported_price_of_20kg;
    }

    public String getRetail_Stocked_Imported_price_of_24kg() {
        return retail_Stocked_Imported_price_of_24kg;
    }

    public void setRetail_Stocked_Imported_price_of_24kg(String retail_Stocked_Imported_price_of_24kg) {
        this.retail_Stocked_Imported_price_of_24kg = retail_Stocked_Imported_price_of_24kg;
    }

    public String getRetail_Stocked_Imported_price_of_50kg() {
        return retail_Stocked_Imported_price_of_50kg;
    }

    public void setRetail_Stocked_Imported_price_of_50kg(String retail_Stocked_Imported_price_of_50kg) {
        this.retail_Stocked_Imported_price_of_50kg = retail_Stocked_Imported_price_of_50kg;
    }

    public String getRetail_stocked_brand() {
        return retail_stocked_brand;
    }

    public void setRetail_stocked_brand(String retail_stocked_brand) {
        this.retail_stocked_brand = retail_stocked_brand;
    }

    public String getRetail_Stocked_Local_Brandprice_of_20kg() {
        return retail_Stocked_Local_Brandprice_of_20kg;
    }

    public void setRetail_Stocked_Local_Brandprice_of_20kg(String retail_Stocked_Local_Brandprice_of_20kg) {
        this.retail_Stocked_Local_Brandprice_of_20kg = retail_Stocked_Local_Brandprice_of_20kg;
    }

    public String getRetail_Stocked_Local_Brandprice_of_24kg() {
        return retail_Stocked_Local_Brandprice_of_24kg;
    }

    public void setRetail_Stocked_Local_Brandprice_of_24kg(String retail_Stocked_Local_Brandprice_of_24kg) {
        this.retail_Stocked_Local_Brandprice_of_24kg = retail_Stocked_Local_Brandprice_of_24kg;
    }

    public String getRetail_Stocked_Local_Brandprice_of_50kg() {
        return retail_Stocked_Local_Brandprice_of_50kg;
    }

    public void setRetail_Stocked_Local_Brandprice_of_50kg(String retail_Stocked_Local_Brandprice_of_50kg) {
        this.retail_Stocked_Local_Brandprice_of_50kg = retail_Stocked_Local_Brandprice_of_50kg;
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
