package co.ke.bsl.data.view;

public class CoffeeCommercialMarketingAgentBus
{
    private static CoffeeCommercialMarketingAgentBus single_instance = null;

    private CoffeeCommercialMarketingAgentBus() {
    }

    public static CoffeeCommercialMarketingAgentBus getInstance() {
        if (single_instance == null)
            single_instance = new CoffeeCommercialMarketingAgentBus();

        return single_instance;
    }

    public static CoffeeCommercialMarketingAgentBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(CoffeeCommercialMarketingAgentBus single_instance) {
        CoffeeCommercialMarketingAgentBus.single_instance = single_instance;
    }

    private String document_number;
    private String document_date;
    private String name_of_applicant;
    private String licence_number;

    private String localID;

    private String ismarkingClear;
    private String markingClearRemarks;
    private String iscoffeeLicenceValid;
    private String coffeeLicenceValidRemarks;
    private String issingleBusinessPermit;
    private String singleBusinessPermitRemarks;
    private String iswasteDisposalsystem;
    private String wasteDisposalsystemRemarks;
    private String isfireFightingEquipments;
    private String fireFightingEquipmentsRemarks;
    private String isgeneralhygienes;
    private String generalhygienesRemarks;
    private String iswashingrRooms;
    private String washingrRoomsRemarks;
    private String iscleanWaterSupplied;
    private String cleanWaterSuppliedRemarks;
    private String iselectricity;
    private String electricityRemarks;
    private String isreturnsRemitted;
    private String returnsRemittedRemarks;
    private String istraceabilitySystem;
    private String traceabilitySystemRemarks;
    private String iscuppingFacilities;
    private String cuppingFacilitiesRemarks;
    private String isoccupationalAndHealthAct;
    private String occupationalAndHealthActRemarks;
    private String ispaymentToGrowers;
    private String paymentToGrowersRemarks;
    private String isstarndardOutTurnSales;
    private String starndardOutTurnSalesRemarks;
    private String isstandardDirect;
    private String standardDirectRemarks;
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private String doc_status;

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public String getDocument_date() {
        return document_date;
    }

    public void setDocument_date(String document_date) {
        this.document_date = document_date;
    }

    public String getName_of_applicant() {
        return name_of_applicant;
    }

    public void setName_of_applicant(String name_of_applicant) {
        this.name_of_applicant = name_of_applicant;
    }

    public String getLicence_number() {
        return licence_number;
    }

    public void setLicence_number(String licence_number) {
        this.licence_number = licence_number;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getIsmarkingClear() {
        return ismarkingClear;
    }

    public void setIsmarkingClear(String ismarkingClear) {
        this.ismarkingClear = ismarkingClear;
    }

    public String getMarkingClearRemarks() {
        return markingClearRemarks;
    }

    public void setMarkingClearRemarks(String markingClearRemarks) {
        this.markingClearRemarks = markingClearRemarks;
    }

    public String getIscoffeeLicenceValid() {
        return iscoffeeLicenceValid;
    }

    public void setIscoffeeLicenceValid(String iscoffeeLicenceValid) {
        this.iscoffeeLicenceValid = iscoffeeLicenceValid;
    }

    public String getCoffeeLicenceValidRemarks() {
        return coffeeLicenceValidRemarks;
    }

    public void setCoffeeLicenceValidRemarks(String coffeeLicenceValidRemarks) {
        this.coffeeLicenceValidRemarks = coffeeLicenceValidRemarks;
    }

    public String getIssingleBusinessPermit() {
        return issingleBusinessPermit;
    }

    public void setIssingleBusinessPermit(String issingleBusinessPermit) {
        this.issingleBusinessPermit = issingleBusinessPermit;
    }

    public String getSingleBusinessPermitRemarks() {
        return singleBusinessPermitRemarks;
    }

    public void setSingleBusinessPermitRemarks(String singleBusinessPermitRemarks) {
        this.singleBusinessPermitRemarks = singleBusinessPermitRemarks;
    }

    public String getIswasteDisposalsystem() {
        return iswasteDisposalsystem;
    }

    public void setIswasteDisposalsystem(String iswasteDisposalsystem) {
        this.iswasteDisposalsystem = iswasteDisposalsystem;
    }

    public String getWasteDisposalsystemRemarks() {
        return wasteDisposalsystemRemarks;
    }

    public void setWasteDisposalsystemRemarks(String wasteDisposalsystemRemarks) {
        this.wasteDisposalsystemRemarks = wasteDisposalsystemRemarks;
    }

    public String getIsfireFightingEquipments() {
        return isfireFightingEquipments;
    }

    public void setIsfireFightingEquipments(String isfireFightingEquipments) {
        this.isfireFightingEquipments = isfireFightingEquipments;
    }

    public String getFireFightingEquipmentsRemarks() {
        return fireFightingEquipmentsRemarks;
    }

    public void setFireFightingEquipmentsRemarks(String fireFightingEquipmentsRemarks) {
        this.fireFightingEquipmentsRemarks = fireFightingEquipmentsRemarks;
    }

    public String getIsgeneralhygienes() {
        return isgeneralhygienes;
    }

    public void setIsgeneralhygienes(String isgeneralhygienes) {
        this.isgeneralhygienes = isgeneralhygienes;
    }

    public String getGeneralhygienesRemarks() {
        return generalhygienesRemarks;
    }

    public void setGeneralhygienesRemarks(String generalhygienesRemarks) {
        this.generalhygienesRemarks = generalhygienesRemarks;
    }

    public String getIswashingrRooms() {
        return iswashingrRooms;
    }

    public void setIswashingrRooms(String iswashingrRooms) {
        this.iswashingrRooms = iswashingrRooms;
    }

    public String getWashingrRoomsRemarks() {
        return washingrRoomsRemarks;
    }

    public void setWashingrRoomsRemarks(String washingrRoomsRemarks) {
        this.washingrRoomsRemarks = washingrRoomsRemarks;
    }

    public String getIscleanWaterSupplied() {
        return iscleanWaterSupplied;
    }

    public void setIscleanWaterSupplied(String iscleanWaterSupplied) {
        this.iscleanWaterSupplied = iscleanWaterSupplied;
    }

    public String getCleanWaterSuppliedRemarks() {
        return cleanWaterSuppliedRemarks;
    }

    public void setCleanWaterSuppliedRemarks(String cleanWaterSuppliedRemarks) {
        this.cleanWaterSuppliedRemarks = cleanWaterSuppliedRemarks;
    }

    public String getIselectricity() {
        return iselectricity;
    }

    public void setIselectricity(String iselectricity) {
        this.iselectricity = iselectricity;
    }

    public String getElectricityRemarks() {
        return electricityRemarks;
    }

    public void setElectricityRemarks(String electricityRemarks) {
        this.electricityRemarks = electricityRemarks;
    }

    public String getIsreturnsRemitted() {
        return isreturnsRemitted;
    }

    public void setIsreturnsRemitted(String isreturnsRemitted) {
        this.isreturnsRemitted = isreturnsRemitted;
    }

    public String getReturnsRemittedRemarks() {
        return returnsRemittedRemarks;
    }

    public void setReturnsRemittedRemarks(String returnsRemittedRemarks) {
        this.returnsRemittedRemarks = returnsRemittedRemarks;
    }

    public String getIstraceabilitySystem() {
        return istraceabilitySystem;
    }

    public void setIstraceabilitySystem(String istraceabilitySystem) {
        this.istraceabilitySystem = istraceabilitySystem;
    }

    public String getTraceabilitySystemRemarks() {
        return traceabilitySystemRemarks;
    }

    public void setTraceabilitySystemRemarks(String traceabilitySystemRemarks) {
        this.traceabilitySystemRemarks = traceabilitySystemRemarks;
    }

    public String getIscuppingFacilities() {
        return iscuppingFacilities;
    }

    public void setIscuppingFacilities(String iscuppingFacilities) {
        this.iscuppingFacilities = iscuppingFacilities;
    }

    public String getCuppingFacilitiesRemarks() {
        return cuppingFacilitiesRemarks;
    }

    public void setCuppingFacilitiesRemarks(String cuppingFacilitiesRemarks) {
        this.cuppingFacilitiesRemarks = cuppingFacilitiesRemarks;
    }

    public String getIsoccupationalAndHealthAct() {
        return isoccupationalAndHealthAct;
    }

    public void setIsoccupationalAndHealthAct(String isoccupationalAndHealthAct) {
        this.isoccupationalAndHealthAct = isoccupationalAndHealthAct;
    }

    public String getOccupationalAndHealthActRemarks() {
        return occupationalAndHealthActRemarks;
    }

    public void setOccupationalAndHealthActRemarks(String occupationalAndHealthActRemarks) {
        this.occupationalAndHealthActRemarks = occupationalAndHealthActRemarks;
    }

    public String getIspaymentToGrowers() {
        return ispaymentToGrowers;
    }

    public void setIspaymentToGrowers(String ispaymentToGrowers) {
        this.ispaymentToGrowers = ispaymentToGrowers;
    }

    public String getPaymentToGrowersRemarks() {
        return paymentToGrowersRemarks;
    }

    public void setPaymentToGrowersRemarks(String paymentToGrowersRemarks) {
        this.paymentToGrowersRemarks = paymentToGrowersRemarks;
    }

    public String getIsstarndardOutTurnSales() {
        return isstarndardOutTurnSales;
    }

    public void setIsstarndardOutTurnSales(String isstarndardOutTurnSales) {
        this.isstarndardOutTurnSales = isstarndardOutTurnSales;
    }

    public String getStarndardOutTurnSalesRemarks() {
        return starndardOutTurnSalesRemarks;
    }

    public void setStarndardOutTurnSalesRemarks(String starndardOutTurnSalesRemarks) {
        this.starndardOutTurnSalesRemarks = starndardOutTurnSalesRemarks;
    }

    public String getIsstandardDirect() {
        return isstandardDirect;
    }

    public void setIsstandardDirect(String isstandardDirect) {
        this.isstandardDirect = isstandardDirect;
    }

    public String getStandardDirectRemarks() {
        return standardDirectRemarks;
    }

    public void setStandardDirectRemarks(String standardDirectRemarks) {
        this.standardDirectRemarks = standardDirectRemarks;
    }

    public String getDoc_status() {
        return doc_status;
    }

    public void setDoc_status(String doc_status) {
        this.doc_status = doc_status;
    }

    public String getOfficerrecommendation() {
        return officerrecommendation;
    }

    public void setOfficerrecommendation(String officerrecommendation) {
        this.officerrecommendation = officerrecommendation;
    }

    public String getOfficerrecommendation_remark() {
        return officerrecommendation_remark;
    }

    public void setOfficerrecommendation_remark(String officerrecommendation_remark) {
        this.officerrecommendation_remark = officerrecommendation_remark;
    }
}
