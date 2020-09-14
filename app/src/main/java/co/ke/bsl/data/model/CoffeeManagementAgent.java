package co.ke.bsl.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CoffeeManagementAgent
{
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int coffee_management_agent_id;
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

    private boolean is_synced;
    private String remote_id;

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public CoffeeManagementAgent(int coffee_management_agent_id, String documnet_number, String document_date, String name_of_applicant, String licence_no, String principal_office, String managementPerformanceProf, String financialPosition, String relevantEquipments, String services, String officerrecommendation, String officerrecommendation_remark, String status, String localID, boolean is_synced, String remote_id) {
        this.coffee_management_agent_id = coffee_management_agent_id;
        this.documnet_number = documnet_number;
        this.document_date = document_date;
        this.name_of_applicant = name_of_applicant;
        this.licence_no = licence_no;
        this.principal_office = principal_office;
        this.managementPerformanceProf = managementPerformanceProf;
        this.financialPosition = financialPosition;
        this.relevantEquipments = relevantEquipments;
        this.services = services;
        this.officerrecommendation = officerrecommendation;
        this.officerrecommendation_remark = officerrecommendation_remark;
        this.status = status;
        this.localID = localID;
        this.is_synced = is_synced;
        this.remote_id = remote_id;
    }

    public int getCoffee_management_agent_id() {
        return coffee_management_agent_id;
    }

    public void setCoffee_management_agent_id(int coffee_management_agent_id) {
        this.coffee_management_agent_id = coffee_management_agent_id;
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
