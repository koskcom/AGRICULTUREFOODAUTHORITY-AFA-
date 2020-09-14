package co.ke.bsl.data.view;

public class CoffeeMnagementAgentBus
{

    private static CoffeeMnagementAgentBus single_instance = null;

    private CoffeeMnagementAgentBus() {
    }

    public static CoffeeMnagementAgentBus getInstance() {
        if (single_instance == null)
            single_instance = new CoffeeMnagementAgentBus();

        return single_instance;
    }

    public static CoffeeMnagementAgentBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(CoffeeMnagementAgentBus single_instance) {
        CoffeeMnagementAgentBus.single_instance = single_instance;
    }

    private String documnet_number;
    private String document_date;
    private String name_of_applicant;
    private String licence_no;
    private String principal_office;
    private String managementPerformanceProf;
    private String financialPosition;
    private String relevantEquipments;
    private String services;
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private String status;
    private String localID;

    public String getDocumnet_number() {
        return documnet_number;
    }

    public void setDocumnet_number(String documnet_number) {
        this.documnet_number = documnet_number;
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

    public String getLicence_no() {
        return licence_no;
    }

    public void setLicence_no(String licence_no) {
        this.licence_no = licence_no;
    }

    public String getPrincipal_office() {
        return principal_office;
    }

    public void setPrincipal_office(String principal_office) {
        this.principal_office = principal_office;
    }

    public String getManagementPerformanceProf() {
        return managementPerformanceProf;
    }

    public void setManagementPerformanceProf(String managementPerformanceProf) {
        this.managementPerformanceProf = managementPerformanceProf;
    }

    public String getFinancialPosition() {
        return financialPosition;
    }

    public void setFinancialPosition(String financialPosition) {
        this.financialPosition = financialPosition;
    }

    public String getRelevantEquipments() {
        return relevantEquipments;
    }

    public void setRelevantEquipments(String relevantEquipments) {
        this.relevantEquipments = relevantEquipments;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
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
