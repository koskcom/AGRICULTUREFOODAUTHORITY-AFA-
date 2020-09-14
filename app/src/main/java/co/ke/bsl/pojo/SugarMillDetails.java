package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;
public class SugarMillDetails implements java.io.Serializable
{
    private LoginRequest loginRequest;

    private String serviceType="QuerySugarMillInspection";

    private String sentStatus;

    private  String afa_sd_smillcliancelist_id;

    private String C_BPartner_ID;
    
    private String document_number;
    private String document_date;
    private String letter_of_comfort;
    private String applicant_name;

    private  String list_farmers;
    private String list_farmers_remark;
    private String grower_summary;
    private String grower_summary_remark;
    private String nemaweightsosha_cert;
    private String nemaweightsosha_cert_remark;
    private String millingshedule_monthly;
    private String millingshedule_monthly_remark;
    private String canecontract_samples;
    private String canecontract_samples_remark;
    private String caneprodproc_plans;
    private String caneprodproc_plans_remark;
    private String farmersdarreas_measure;
    private String farmersdarreas_measure_remark;
    private String payformula_conf;
    private String payformula_conf_remark;
    private String adhstatutorystandard;
    private String adhstatutorystandard_remark;
    private String officerrecommendation;
    private String officerrecommendation_remark;

    private String  localID;

    private String millerID;

    private String serverRecordID;




    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //to create a dummy data for afasugarmilllicencecompliancevisitchecklist
    public SugarMillDetails(String document_number, String document_date, String letter_of_comfort, String c_BPartner_ID) {
        this.document_number = document_number;
        this.document_date = document_date;
        this.letter_of_comfort = letter_of_comfort;
        this.C_BPartner_ID = c_BPartner_ID;
    }

    public SugarMillDetails() {
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

    public String getC_BPartner_ID() {
        return C_BPartner_ID;
    }
    
    public void setC_BPartner_ID(String c_BPartner_ID) {
        C_BPartner_ID = c_BPartner_ID;
    }
    
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

    public String getLetter_of_comfort() {
        return letter_of_comfort;
    }

    public void setLetter_of_comfort(String letter_of_comfort) {
        this.letter_of_comfort = letter_of_comfort;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public String getMillerID() {
        return millerID;
    }

    public void setMillerID(String millerID) {
        this.millerID = millerID;
    }

    public String getServerRecordID() {
        return serverRecordID;
    }

    public void setServerRecordID(String serverRecordID) {
        this.serverRecordID = serverRecordID;
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

    public String getSentStatus() {
        return sentStatus;
    }

    public void setSentStatus(String sentStatus) {
        this.sentStatus = sentStatus;
    }

    public String getAfa_sd_smillcliancelist_id() {
        return afa_sd_smillcliancelist_id;
    }

    public void setAfa_sd_smillcliancelist_id(String afa_sd_smillcliancelist_id) {
        this.afa_sd_smillcliancelist_id = afa_sd_smillcliancelist_id;
    }

    public String getList_farmers() {
        return list_farmers;
    }

    public void setList_farmers(String list_farmers) {
        this.list_farmers = list_farmers;
    }

    public String getList_farmers_remark() {
        return list_farmers_remark;
    }

    public void setList_farmers_remark(String list_farmers_remark) {
        this.list_farmers_remark = list_farmers_remark;
    }

    public String getGrower_summary() {
        return grower_summary;
    }

    public void setGrower_summary(String grower_summary) {
        this.grower_summary = grower_summary;
    }

    public String getGrower_summary_remark() {
        return grower_summary_remark;
    }

    public void setGrower_summary_remark(String grower_summary_remark) {
        this.grower_summary_remark = grower_summary_remark;
    }

    public String getNemaweightsosha_cert() {
        return nemaweightsosha_cert;
    }

    public void setNemaweightsosha_cert(String nemaweightsosha_cert) {
        this.nemaweightsosha_cert = nemaweightsosha_cert;
    }

    public String getNemaweightsosha_cert_remark() {
        return nemaweightsosha_cert_remark;
    }

    public void setNemaweightsosha_cert_remark(String nemaweightsosha_cert_remark) {
        this.nemaweightsosha_cert_remark = nemaweightsosha_cert_remark;
    }

    public String getMillingshedule_monthly() {
        return millingshedule_monthly;
    }

    public void setMillingshedule_monthly(String millingshedule_monthly) {
        this.millingshedule_monthly = millingshedule_monthly;
    }

    public String getMillingshedule_monthly_remark() {
        return millingshedule_monthly_remark;
    }

    public void setMillingshedule_monthly_remark(String millingshedule_monthly_remark) {
        this.millingshedule_monthly_remark = millingshedule_monthly_remark;
    }

    public String getCanecontract_samples() {
        return canecontract_samples;
    }

    public void setCanecontract_samples(String canecontract_samples) {
        this.canecontract_samples = canecontract_samples;
    }

    public String getCanecontract_samples_remark() {
        return canecontract_samples_remark;
    }

    public void setCanecontract_samples_remark(String canecontract_samples_remark) {
        this.canecontract_samples_remark = canecontract_samples_remark;
    }

    public String getCaneprodproc_plans() {
        return caneprodproc_plans;
    }

    public void setCaneprodproc_plans(String caneprodproc_plans) {
        this.caneprodproc_plans = caneprodproc_plans;
    }

    public String getCaneprodproc_plans_remark() {
        return caneprodproc_plans_remark;
    }

    public void setCaneprodproc_plans_remark(String caneprodproc_plans_remark) {
        this.caneprodproc_plans_remark = caneprodproc_plans_remark;
    }

    public String getFarmersdarreas_measure() {
        return farmersdarreas_measure;
    }

    public void setFarmersdarreas_measure(String farmersdarreas_measure) {
        this.farmersdarreas_measure = farmersdarreas_measure;
    }

    public String getFarmersdarreas_measure_remark() {
        return farmersdarreas_measure_remark;
    }

    public void setFarmersdarreas_measure_remark(String farmersdarreas_measure_remark) {
        this.farmersdarreas_measure_remark = farmersdarreas_measure_remark;
    }

    public String getPayformula_conf() {
        return payformula_conf;
    }

    public void setPayformula_conf(String payformula_conf) {
        this.payformula_conf = payformula_conf;
    }

    public String getPayformula_conf_remark() {
        return payformula_conf_remark;
    }

    public void setPayformula_conf_remark(String payformula_conf_remark) {
        this.payformula_conf_remark = payformula_conf_remark;
    }

    public String getAdhstatutorystandard() {
        return adhstatutorystandard;
    }

    public void setAdhstatutorystandard(String adhstatutorystandard) {
        this.adhstatutorystandard = adhstatutorystandard;
    }

    public String getAdhstatutorystandard_remark() {
        return adhstatutorystandard_remark;
    }

    public void setAdhstatutorystandard_remark(String adhstatutorystandard_remark) {
        this.adhstatutorystandard_remark = adhstatutorystandard_remark;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }
}
