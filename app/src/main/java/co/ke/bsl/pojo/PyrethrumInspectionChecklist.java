package co.ke.bsl.pojo;

import org.idempiere.webservice.client.base.LoginRequest;


public class PyrethrumInspectionChecklist implements java.io.Serializable
{

    private LoginRequest loginRequest;

    private String serviceType="QueryPyrethrumInspection";

    private String sentStatus;

    private  String aFA_PD_Inspect_Processor_ID;


    private String C_BPartner_ID;

    private String document_number;
    private String document_date;
    private String name_of_applicant;
    private String certificate_number;
    private String localID;
    private String title_deed;
    private String title_deed_evidence;
    private String title_deed_remarks;
    private String total_acreage;
    private String total_acreage_evidence;
    private String total_acreage_remarks;
    private String acreage_available;
    private String acreage_available_evidence;
    private String acreage_available_remarks;
    private String suitability_of_the_land;
    private String suitability_of_the_land_evidence;
    private String suitability_of_the_land_remarks;
    private String reliable_supply_clean_water;
    private String reliable_supply_clean_water_evidence;
    private String reliable_supply_clean_water_remarks;
    private String accessibility_of_nursery_site;
    private String accessibility_of_nursery_site_evidence;
    private String accessibility_of_nursery_site_remarks;
    private String clearance_letter;
    private String clearance_letter_evidence;
    private String clearance_letter_remarks;
    private String demonstrate_adequate_knowledge;
    private String demonstrate_adequate_knowledge_evidence;
    private String demonstrate_adequate_knowledge_remarks;
    private String age_of_an_existing_crop;
    private String age_of_an_existing_crop_date_planted;
    private String age_of_an_existing_crop_remarks;
    private String source_of_planting_materials;
    private String source_of_planting_materials_evidence;
    private String source_of_planting_materials_remarks;
    private String phenotypic_characteristics;
    private String phenotypic_characteristics_evidence;
    private String phenotypic_characteristics_remarks;
    private String disease_incidences;
    private String disease_incidences_remarks;
    private String pest_incidences;
    private String pest_incidences_remarks;
    private String field_hygiene_conditions;
    private String field_hygiene_conditions_evidence;
    private String field_hygiene_conditions_remarks;
    private String target_market;
    private String target_market_evidence;
    private String target_market_remarks;
    private String inspection_by_kephis;
    private String inspection_by_kephis_evidence;
    private String inspection_by_kephis_remarks;
    private String recommendations;
    private String officerrecommendation;
    private String officerrecommendation_remark;

    private String localId;
    private String serverRecordID;

    private String pyrethrumID;

    public PyrethrumInspectionChecklist(String document_number, String document_date, String name_of_applicant, String certificate_number) {
        this.document_number = document_number;
        this.document_date = document_date;
        this.name_of_applicant = name_of_applicant;
        this.certificate_number = certificate_number;
    }

    public PyrethrumInspectionChecklist() {
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

    public String getaFA_PD_Inspect_Processor_ID() {
        return aFA_PD_Inspect_Processor_ID;
    }

    public void setaFA_PD_Inspect_Processor_ID(String aFA_PD_Inspect_Processor_ID) {
        this.aFA_PD_Inspect_Processor_ID = aFA_PD_Inspect_Processor_ID;
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

    public String getName_of_applicant() {
        return name_of_applicant;
    }

    public void setName_of_applicant(String name_of_applicant) {
        this.name_of_applicant = name_of_applicant;
    }

    public String getCertificate_number() {
        return certificate_number;
    }

    public void setCertificate_number(String certificate_number) {
        this.certificate_number = certificate_number;
    }


    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getTitle_deed() {
        return title_deed;
    }

    public void setTitle_deed(String title_deed) {
        this.title_deed = title_deed;
    }

    public String getTitle_deed_evidence() {
        return title_deed_evidence;
    }

    public void setTitle_deed_evidence(String title_deed_evidence) {
        this.title_deed_evidence = title_deed_evidence;
    }

    public String getTitle_deed_remarks() {
        return title_deed_remarks;
    }

    public void setTitle_deed_remarks(String title_deed_remarks) {
        this.title_deed_remarks = title_deed_remarks;
    }

    public String getTotal_acreage() {
        return total_acreage;
    }

    public void setTotal_acreage(String total_acreage) {
        this.total_acreage = total_acreage;
    }

    public String getTotal_acreage_evidence() {
        return total_acreage_evidence;
    }

    public void setTotal_acreage_evidence(String total_acreage_evidence) {
        this.total_acreage_evidence = total_acreage_evidence;
    }

    public String getTotal_acreage_remarks() {
        return total_acreage_remarks;
    }

    public void setTotal_acreage_remarks(String total_acreage_remarks) {
        this.total_acreage_remarks = total_acreage_remarks;
    }

    public String getAcreage_available() {
        return acreage_available;
    }

    public void setAcreage_available(String acreage_available) {
        this.acreage_available = acreage_available;
    }

    public String getAcreage_available_evidence() {
        return acreage_available_evidence;
    }

    public void setAcreage_available_evidence(String acreage_available_evidence) {
        this.acreage_available_evidence = acreage_available_evidence;
    }

    public String getAcreage_available_remarks() {
        return acreage_available_remarks;
    }

    public void setAcreage_available_remarks(String acreage_available_remarks) {
        this.acreage_available_remarks = acreage_available_remarks;
    }

    public String getSuitability_of_the_land() {
        return suitability_of_the_land;
    }

    public void setSuitability_of_the_land(String suitability_of_the_land) {
        this.suitability_of_the_land = suitability_of_the_land;
    }

    public String getSuitability_of_the_land_evidence() {
        return suitability_of_the_land_evidence;
    }

    public void setSuitability_of_the_land_evidence(String suitability_of_the_land_evidence) {
        this.suitability_of_the_land_evidence = suitability_of_the_land_evidence;
    }

    public String getSuitability_of_the_land_remarks() {
        return suitability_of_the_land_remarks;
    }

    public void setSuitability_of_the_land_remarks(String suitability_of_the_land_remarks) {
        this.suitability_of_the_land_remarks = suitability_of_the_land_remarks;
    }

    public String getReliable_supply_clean_water() {
        return reliable_supply_clean_water;
    }

    public void setReliable_supply_clean_water(String reliable_supply_clean_water) {
        this.reliable_supply_clean_water = reliable_supply_clean_water;
    }

    public String getReliable_supply_clean_water_evidence() {
        return reliable_supply_clean_water_evidence;
    }

    public void setReliable_supply_clean_water_evidence(String reliable_supply_clean_water_evidence) {
        this.reliable_supply_clean_water_evidence = reliable_supply_clean_water_evidence;
    }

    public String getReliable_supply_clean_water_remarks() {
        return reliable_supply_clean_water_remarks;
    }

    public void setReliable_supply_clean_water_remarks(String reliable_supply_clean_water_remarks) {
        this.reliable_supply_clean_water_remarks = reliable_supply_clean_water_remarks;
    }


    public String getAccessibility_of_nursery_site() {
        return accessibility_of_nursery_site;
    }

    public void setAccessibility_of_nursery_site(String accessibility_of_nursery_site) {
        this.accessibility_of_nursery_site = accessibility_of_nursery_site;
    }

    public String getAccessibility_of_nursery_site_evidence() {
        return accessibility_of_nursery_site_evidence;
    }

    public void setAccessibility_of_nursery_site_evidence(String accessibility_of_nursery_site_evidence) {
        this.accessibility_of_nursery_site_evidence = accessibility_of_nursery_site_evidence;
    }

    public String getAccessibility_of_nursery_site_remarks() {
        return accessibility_of_nursery_site_remarks;
    }

    public void setAccessibility_of_nursery_site_remarks(String accessibility_of_nursery_site_remarks) {
        this.accessibility_of_nursery_site_remarks = accessibility_of_nursery_site_remarks;
    }
    public String getClearance_letter() {
        return clearance_letter;
    }

    public void setClearance_letter(String clearance_letter) {
        this.clearance_letter = clearance_letter;
    }

    public String getClearance_letter_evidence() {
        return clearance_letter_evidence;
    }

    public void setClearance_letter_evidence(String clearance_letter_evidence) {
        this.clearance_letter_evidence = clearance_letter_evidence;
    }

    public String getClearance_letter_remarks() {
        return clearance_letter_remarks;
    }

    public void setClearance_letter_remarks(String clearance_letter_remarks) {
        this.clearance_letter_remarks = clearance_letter_remarks;
    }


    public String getDemonstrate_adequate_knowledge() {
        return demonstrate_adequate_knowledge;
    }

    public void setDemonstrate_adequate_knowledge(String demonstrate_adequate_knowledge) {
        this.demonstrate_adequate_knowledge = demonstrate_adequate_knowledge;
    }

    public String getDemonstrate_adequate_knowledge_evidence() {
        return demonstrate_adequate_knowledge_evidence;
    }

    public void setDemonstrate_adequate_knowledge_evidence(String demonstrate_adequate_knowledge_evidence) {
        this.demonstrate_adequate_knowledge_evidence = demonstrate_adequate_knowledge_evidence;
    }

    public String getDemonstrate_adequate_knowledge_remarks() {
        return demonstrate_adequate_knowledge_remarks;
    }

    public void setDemonstrate_adequate_knowledge_remarks(String demonstrate_adequate_knowledge_remarks) {
        this.demonstrate_adequate_knowledge_remarks = demonstrate_adequate_knowledge_remarks;
    }

    public String getAge_of_an_existing_crop() {
        return age_of_an_existing_crop;
    }

    public void setAge_of_an_existing_crop(String age_of_an_existing_crop) {
        this.age_of_an_existing_crop = age_of_an_existing_crop;
    }

    public String getAge_of_an_existing_crop_date_planted() {
        return age_of_an_existing_crop_date_planted;
    }

    public void setAge_of_an_existing_crop_date_planted(String age_of_an_existing_crop_date_planted) {
        this.age_of_an_existing_crop_date_planted = age_of_an_existing_crop_date_planted;
    }

    public String getAge_of_an_existing_crop_remarks() {
        return age_of_an_existing_crop_remarks;
    }

    public void setAge_of_an_existing_crop_remarks(String age_of_an_existing_crop_remarks) {
        this.age_of_an_existing_crop_remarks = age_of_an_existing_crop_remarks;
    }
    public String getSource_of_planting_materials() {
        return source_of_planting_materials;
    }

    public void setSource_of_planting_materials(String source_of_planting_materials) {
        this.source_of_planting_materials = source_of_planting_materials;
    }

    public String getSource_of_planting_materials_evidence() {
        return source_of_planting_materials_evidence;
    }

    public void setSource_of_planting_materials_evidence(String source_of_planting_materials_evidence) {
        this.source_of_planting_materials_evidence = source_of_planting_materials_evidence;
    }

    public String getSource_of_planting_materials_remarks() {
        return source_of_planting_materials_remarks;
    }

    public void setSource_of_planting_materials_remarks(String source_of_planting_materials_remarks) {
        this.source_of_planting_materials_remarks = source_of_planting_materials_remarks;
    }

    public String getPhenotypic_characteristics() {
        return phenotypic_characteristics;
    }

    public void setPhenotypic_characteristics(String phenotypic_characteristics) {
        this.phenotypic_characteristics = phenotypic_characteristics;
    }

    public String getPhenotypic_characteristics_evidence() {
        return phenotypic_characteristics_evidence;
    }

    public void setPhenotypic_characteristics_evidence(String phenotypic_characteristics_evidence) {
        this.phenotypic_characteristics_evidence = phenotypic_characteristics_evidence;
    }

    public String getPhenotypic_characteristics_remarks() {
        return phenotypic_characteristics_remarks;
    }

    public void setPhenotypic_characteristics_remarks(String phenotypic_characteristics_remarks) {
        this.phenotypic_characteristics_remarks = phenotypic_characteristics_remarks;
    }

    public String getDisease_incidences() {
        return disease_incidences;
    }

    public void setDisease_incidences(String disease_incidences) {
        this.disease_incidences = disease_incidences;
    }

    public String getDisease_incidences_remarks() {
        return disease_incidences_remarks;
    }

    public void setDisease_incidences_remarks(String disease_incidences_remarks) {
        this.disease_incidences_remarks = disease_incidences_remarks;
    }

    public String getPest_incidences() {
        return pest_incidences;
    }

    public void setPest_incidences(String pest_incidences) {
        this.pest_incidences = pest_incidences;
    }

    public String getPest_incidences_remarks() {
        return pest_incidences_remarks;
    }

    public void setPest_incidences_remarks(String pest_incidences_remarks) {
        this.pest_incidences_remarks = pest_incidences_remarks;
    }

    public String getField_hygiene_conditions() {
        return field_hygiene_conditions;
    }

    public void setField_hygiene_conditions(String field_hygiene_conditions) {
        this.field_hygiene_conditions = field_hygiene_conditions;
    }

    public String getField_hygiene_conditions_evidence() {
        return field_hygiene_conditions_evidence;
    }

    public void setField_hygiene_conditions_evidence(String field_hygiene_conditions_evidence) {
        this.field_hygiene_conditions_evidence = field_hygiene_conditions_evidence;
    }

    public String getField_hygiene_conditions_remarks() {
        return field_hygiene_conditions_remarks;
    }

    public void setField_hygiene_conditions_remarks(String field_hygiene_conditions_remarks) {
        this.field_hygiene_conditions_remarks = field_hygiene_conditions_remarks;
    }

    public String getTarget_market() {
        return target_market;
    }

    public void setTarget_market(String target_market) {
        this.target_market = target_market;
    }

    public String getTarget_market_evidence() {
        return target_market_evidence;
    }

    public void setTarget_market_evidence(String target_market_evidence) {
        this.target_market_evidence = target_market_evidence;
    }

    public String getTarget_market_remarks() {
        return target_market_remarks;
    }

    public void setTarget_market_remarks(String target_market_remarks) {
        this.target_market_remarks = target_market_remarks;
    }

    public String getInspection_by_kephis() {
        return inspection_by_kephis;
    }

    public void setInspection_by_kephis(String inspection_by_kephis) {
        this.inspection_by_kephis = inspection_by_kephis;
    }

    public String getInspection_by_kephis_evidence() {
        return inspection_by_kephis_evidence;
    }

    public void setInspection_by_kephis_evidence(String inspection_by_kephis_evidence) {
        this.inspection_by_kephis_evidence = inspection_by_kephis_evidence;
    }

    public String getInspection_by_kephis_remarks() {
        return inspection_by_kephis_remarks;
    }

    public void setInspection_by_kephis_remarks(String inspection_by_kephis_remarks) {
        this.inspection_by_kephis_remarks = inspection_by_kephis_remarks;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }


    public String getPyrethrumID() {
        return pyrethrumID;
    }

    public void setPyrethrumID(String pyrethrumID) {
        this.pyrethrumID = pyrethrumID;

    }

    public String getServerRecordID() {
        return serverRecordID;
    }

    public void setServerRecordID(String serverRecordID) {
        this.serverRecordID = serverRecordID;
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

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }
}
