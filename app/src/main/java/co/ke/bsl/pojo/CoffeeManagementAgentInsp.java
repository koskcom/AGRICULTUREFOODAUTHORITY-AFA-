package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;

public class CoffeeManagementAgentInsp {

    private LoginRequest loginRequest;

    private String serviceType = "QueryCoffeeManagementAgent";

    private String AFA_CD_Mgtagentchcklist_ID_Coffee;

    private String documnet_number;
    private String document_date;
    private String C_BPartner_ID;
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

    public CoffeeManagementAgentInsp() {
    }

    public CoffeeManagementAgentInsp(String documnet_number, String document_date, String C_BPartner_ID, String licence_no, String principal_office) {
        this.documnet_number = documnet_number;
        this.document_date = document_date;
        this.C_BPartner_ID = C_BPartner_ID;
        this.licence_no = licence_no;
        this.principal_office = principal_office;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
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

    public String getAFA_CD_Mgtagentchcklist_ID_Coffee() {
        return AFA_CD_Mgtagentchcklist_ID_Coffee;
    }

    public void setAFA_CD_Mgtagentchcklist_ID_Coffee(String aFA_CD_Mgtagentchcklist_ID_Coffee) {
        this.AFA_CD_Mgtagentchcklist_ID_Coffee = aFA_CD_Mgtagentchcklist_ID_Coffee;
    }

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

    public String getC_BPartner_ID() {
        return C_BPartner_ID;
    }

    public void setC_BPartner_ID(String c_BPartner_ID) {
        this.C_BPartner_ID = c_BPartner_ID;
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
