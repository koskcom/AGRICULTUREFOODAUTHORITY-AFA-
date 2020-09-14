package co.ke.bsl.data.view;

public class FoodCropBus {
    private static FoodCropBus single_instance = null;

    private FoodCropBus() {
    }

    public static FoodCropBus getInstance() {
        if (single_instance == null)
            single_instance = new FoodCropBus();

        return single_instance;
    }

    public static FoodCropBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(FoodCropBus single_instance) {
        FoodCropBus.single_instance = single_instance;
    }

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
}
