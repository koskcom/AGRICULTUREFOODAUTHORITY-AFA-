package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FoodCrop {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int food_crop_id;
    private String documentNumber;
    private String documentDate;
    private String nameOfApplicant;
    private String foodCroplicence;
    private String localID;
    private String packagingAndLabelling;
    private String  conformityStandards;
    private String  sourceOfProduce;
    private String recommendation;
    private String recommendationRemarks;
    private boolean is_synced;
    private String remote_id;


    public FoodCrop(int food_crop_id, String documentNumber, String documentDate, String nameOfApplicant, String foodCroplicence, String localID, String packagingAndLabelling, String conformityStandards, String sourceOfProduce, String recommendation, String recommendationRemarks, boolean is_synced, String remote_id) {
        this.food_crop_id = food_crop_id;
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
        this.nameOfApplicant = nameOfApplicant;
        this.foodCroplicence = foodCroplicence;
        this.localID = localID;
        this.packagingAndLabelling = packagingAndLabelling;
        this.conformityStandards = conformityStandards;
        this.sourceOfProduce = sourceOfProduce;
        this.recommendation = recommendation;
        this.recommendationRemarks = recommendationRemarks;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getFood_crop_id() {
        return food_crop_id;
    }

    public void setFood_crop_id(int food_crop_id) {
        this.food_crop_id = food_crop_id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    public String getNameOfApplicant() {
        return nameOfApplicant;
    }

    public void setNameOfApplicant(String nameOfApplicant) {
        this.nameOfApplicant = nameOfApplicant;
    }

    public String getFoodCroplicence() {
        return foodCroplicence;
    }

    public void setFoodCroplicence(String foodCroplicence) {
        this.foodCroplicence = foodCroplicence;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getPackagingAndLabelling() {
        return packagingAndLabelling;
    }

    public void setPackagingAndLabelling(String packagingAndLabelling) {
        this.packagingAndLabelling = packagingAndLabelling;
    }

    public String getConformityStandards() {
        return conformityStandards;
    }

    public void setConformityStandards(String conformityStandards) {
        this.conformityStandards = conformityStandards;
    }

    public String getSourceOfProduce() {
        return sourceOfProduce;
    }

    public void setSourceOfProduce(String sourceOfProduce) {
        this.sourceOfProduce = sourceOfProduce;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getRecommendationRemarks() {
        return recommendationRemarks;
    }

    public void setRecommendationRemarks(String recommendationRemarks) {
        this.recommendationRemarks = recommendationRemarks;
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
