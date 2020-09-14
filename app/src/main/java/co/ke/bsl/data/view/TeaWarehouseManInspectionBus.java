package co.ke.bsl.data.view;

public class TeaWarehouseManInspectionBus {

    private static TeaWarehouseManInspectionBus single_instance = null;

    private TeaWarehouseManInspectionBus() {
    }

    public static TeaWarehouseManInspectionBus getInstance() {
        if (single_instance == null)
            single_instance = new TeaWarehouseManInspectionBus();

        return single_instance;
    }

    public static TeaWarehouseManInspectionBus getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(TeaWarehouseManInspectionBus single_instance) {
        TeaWarehouseManInspectionBus.single_instance = single_instance;
    }


    private String document_number;
    private String document_date;
    private String name_of_applicant;
    private String license_number;
    private String localID;

    private String certificate_of_company_registration;
    private String certificate_of_company_registration_mandatory;
    private String certificate_of_company_registration_remarks;
    private String valid_insurance_policy;
    private String valid_insurance_policy_mandatory;
    private String valid_insurance_policy_remarks;
    private String business_permit;
    private String business_permit_mandatory;
    private String business_permit_remarks;
    private String health_certificate;
    private String health_certificate_mandatory;
    private String health_certificate_remarks;
    private String submission_of_annual_returns;
    private String submission_of_annual_returns_mandatory;
    private String submission_of_annual_returns_remarks;
    private String documented_hygiene_policy;
    private String documented_hygiene_policy_mandatory;
    private String documented_hygiene_policy_remarks;
    private String evidence_of_implementation;
    private String evidence_of_implementation_mandatory;
    private String evidence_of_implementation_remarks;
    private String food_safety_hazard;
    private String food_safety_hazard_mandatory;
    private String food_safety_hazard_remarks;
    private String control_measures;
    private String control_measures_mandatory;
    private String control_measures_remarks;
    private String documented_glass_policy;
    private String documented_glass_policy_mandatory;
    private String documented_glass_policy_remarks;
    private String valid_medical_certificates;
    private String valid_medical_certificates_mandatory;
    private String valid_medical_certificates_remarks;
    private String are_hygiene_trainings_conducted;
    private String are_hygiene_trainings_conducted_mandatory;
    private String are_hygiene_trainings_conducted_remarks;
    private String adequate_and_clean_personal;
    private String adequate_and_clean_personal_mandatory;
    private String adequate_and_clean_personal_remarks;
    private String personnel_hygiene_practices_followed;
    private String personnel_hygiene_practices_followed_mandatory;
    private String personnel_hygiene_practices_followed_remarks;
    private String changing_rooms_and_toilets;
    private String changing_rooms_and_toilets_mandatory;
    private String changing_rooms_and_toilets_remarks;
    private String documented_cleaning_programs;
    private String documented_cleaning_programs_mandatory;
    private String documented_cleaning_programs_remarks;
    private String cleaning_records_kept;
    private String cleaning_records_kept_mandatory;
    private String cleaning_records_kept_remarks;
    private String segregation_and_labelling;
    private String segregation_and_labelling_mandatory;
    private String segregation_and_labelling_remarks;
    private String are_all_pests_excluded;
    private String are_all_pests_excluded_mandatory;
    private String are_all_pests_excluded_remarks;
    private String up_to_date_bait_map;
    private String up_to_date_bait_map_mandatory;
    private String up_to_date_bait_map_remarks;
    private String inspection_every_three_months;
    private String inspection_every_three_months_mandatory;
    private String inspection_every_three_months_remarks;
    private String precaution_to_prevent;
    private String precaution_to_prevent_mandatory;
    private String precaution_to_prevent_remarks;
    private String storage_distribution_and_transportation;
    private String storage_distribution_and_transportation_mandatory;
    private String storage_distribution_and_transportation_remarks;
    private String walls_and_partitions;
    private String walls_and_partitions_mandatory;
    private String walls_and_partitions_remarks;
    private String source_of_planting_materials;
    private String source_of_planting_materials_mandatory;
    private String source_of_planting_materials_remarks;
    private String procedure_for_inspection;
    private String procedure_for_inspection_mandatory;
    private String procedure_for_inspection_remarks;
    private String proper_segregation_of_materials;
    private String proper_segregation_of_materials_mandatory;
    private String proper_segregation_of_materials_remarks;
    private String security_access_control;
    private String security_access_control_mandatory;
    private String security_access_control_remarks;
    private String sufficient_ventilation;
    private String sufficient_ventilation_mandatory;
    private String sufficient_ventilation_remarks;
    private String adequate_services;
    private String adequate_services_mandatory;
    private String adequate_services_remarks;
    private String proper_waste_collection;
    private String proper_waste_collection_mandatory;
    private String proper_waste_collection_remarks;
    private String external_site_standards;
    private String external_site_standards_mandatory;
    private String external_site_standards_remarks;
    private String walls;
    private String walls_mandatory;
    private String walls_remarks;
    private String floors;
    private String floors_mandatory;
    private String floors_remarks;
    private String roof_ceiling_and_overhead;
    private String roof_ceiling_and_overhead_mandatory;
    private String roof_ceiling_and_overhead_remarks;
    private String windows;
    private String windows_mandatory;
    private String windows_remarks;
    private String doors;
    private String doors_mandatory;
    private String doors_remarks;
    private String protection_of_light_tubes;
    private String protection_of_light_tubes_mandatory;
    private String protection_of_light_tubes_remarks;
    private String maintenance_programs;
    private String maintenance_programs_mandatory;
    private String maintenance_programs_remarks;
    private String maintenance_records_maintained;
    private String maintenance_records_maintained_mandatory;
    private String maintenance_records_maintained_remarks;
    private String are_conveyor_belts_protected;
    private String are_conveyor_belts_protected_mandatory;
    private String are_conveyor_belts_protected_remarks;
    private String product_testing;
    private String product_testing_mandatory;
    private String product_testing_remarks;
    private String calibration_of_weighing_scale;
    private String calibration_of_weighing_scale_mandatory;
    private String calibration_of_weighing_scale_remarks;
    private String medical_examination;
    private String medical_examination_mandatory;
    private String medical_examination_remarks;
    private String incoming_product;
    private String incoming_product_mandatory;
    private String incoming_product_remarks;
    private String incoming_product_vehicle_inspection;
    private String incoming_product_vehicle_inspection_mandatory;
    private String incoming_product_vehicle_inspection_remarks;
    private String hygiene_housekeeping_inspection;
    private String hygiene_housekeeping_inspection_mandatory;
    private String hygiene_housekeeping_inspection_remarks;
    private String officerrecommendation;
    private String officerrecommendation_remark;
    private String document_status;

    private boolean is_synced;
    private String remote_id;

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

    public String getLicense_number() {
        return license_number;
    }

    public void setLicense_number(String license_number) {
        this.license_number = license_number;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getCertificate_of_company_registration() {
        return certificate_of_company_registration;
    }

    public void setCertificate_of_company_registration(String certificate_of_company_registration) {
        this.certificate_of_company_registration = certificate_of_company_registration;
    }

    public String getCertificate_of_company_registration_mandatory() {
        return certificate_of_company_registration_mandatory;
    }

    public void setCertificate_of_company_registration_mandatory(String certificate_of_company_registration_mandatory) {
        this.certificate_of_company_registration_mandatory = certificate_of_company_registration_mandatory;
    }

    public String getCertificate_of_company_registration_remarks() {
        return certificate_of_company_registration_remarks;
    }

    public void setCertificate_of_company_registration_remarks(String certificate_of_company_registration_remarks) {
        this.certificate_of_company_registration_remarks = certificate_of_company_registration_remarks;
    }

    public String getValid_insurance_policy() {
        return valid_insurance_policy;
    }

    public void setValid_insurance_policy(String valid_insurance_policy) {
        this.valid_insurance_policy = valid_insurance_policy;
    }

    public String getValid_insurance_policy_mandatory() {
        return valid_insurance_policy_mandatory;
    }

    public void setValid_insurance_policy_mandatory(String valid_insurance_policy_mandatory) {
        this.valid_insurance_policy_mandatory = valid_insurance_policy_mandatory;
    }

    public String getValid_insurance_policy_remarks() {
        return valid_insurance_policy_remarks;
    }

    public void setValid_insurance_policy_remarks(String valid_insurance_policy_remarks) {
        this.valid_insurance_policy_remarks = valid_insurance_policy_remarks;
    }

    public String getBusiness_permit() {
        return business_permit;
    }

    public void setBusiness_permit(String business_permit) {
        this.business_permit = business_permit;
    }

    public String getBusiness_permit_mandatory() {
        return business_permit_mandatory;
    }

    public void setBusiness_permit_mandatory(String business_permit_mandatory) {
        this.business_permit_mandatory = business_permit_mandatory;
    }

    public String getBusiness_permit_remarks() {
        return business_permit_remarks;
    }

    public void setBusiness_permit_remarks(String business_permit_remarks) {
        this.business_permit_remarks = business_permit_remarks;
    }

    public String getHealth_certificate() {
        return health_certificate;
    }

    public void setHealth_certificate(String health_certificate) {
        this.health_certificate = health_certificate;
    }

    public String getHealth_certificate_mandatory() {
        return health_certificate_mandatory;
    }

    public void setHealth_certificate_mandatory(String health_certificate_mandatory) {
        this.health_certificate_mandatory = health_certificate_mandatory;
    }

    public String getHealth_certificate_remarks() {
        return health_certificate_remarks;
    }

    public void setHealth_certificate_remarks(String health_certificate_remarks) {
        this.health_certificate_remarks = health_certificate_remarks;
    }

    public String getSubmission_of_annual_returns() {
        return submission_of_annual_returns;
    }

    public void setSubmission_of_annual_returns(String submission_of_annual_returns) {
        this.submission_of_annual_returns = submission_of_annual_returns;
    }

    public String getSubmission_of_annual_returns_mandatory() {
        return submission_of_annual_returns_mandatory;
    }

    public void setSubmission_of_annual_returns_mandatory(String submission_of_annual_returns_mandatory) {
        this.submission_of_annual_returns_mandatory = submission_of_annual_returns_mandatory;
    }

    public String getSubmission_of_annual_returns_remarks() {
        return submission_of_annual_returns_remarks;
    }

    public void setSubmission_of_annual_returns_remarks(String submission_of_annual_returns_remarks) {
        this.submission_of_annual_returns_remarks = submission_of_annual_returns_remarks;
    }

    public String getDocumented_hygiene_policy() {
        return documented_hygiene_policy;
    }

    public void setDocumented_hygiene_policy(String documented_hygiene_policy) {
        this.documented_hygiene_policy = documented_hygiene_policy;
    }

    public String getDocumented_hygiene_policy_mandatory() {
        return documented_hygiene_policy_mandatory;
    }

    public void setDocumented_hygiene_policy_mandatory(String documented_hygiene_policy_mandatory) {
        this.documented_hygiene_policy_mandatory = documented_hygiene_policy_mandatory;
    }

    public String getDocumented_hygiene_policy_remarks() {
        return documented_hygiene_policy_remarks;
    }

    public void setDocumented_hygiene_policy_remarks(String documented_hygiene_policy_remarks) {
        this.documented_hygiene_policy_remarks = documented_hygiene_policy_remarks;
    }

    public String getEvidence_of_implementation() {
        return evidence_of_implementation;
    }

    public void setEvidence_of_implementation(String evidence_of_implementation) {
        this.evidence_of_implementation = evidence_of_implementation;
    }

    public String getEvidence_of_implementation_mandatory() {
        return evidence_of_implementation_mandatory;
    }

    public void setEvidence_of_implementation_mandatory(String evidence_of_implementation_mandatory) {
        this.evidence_of_implementation_mandatory = evidence_of_implementation_mandatory;
    }

    public String getEvidence_of_implementation_remarks() {
        return evidence_of_implementation_remarks;
    }

    public void setEvidence_of_implementation_remarks(String evidence_of_implementation_remarks) {
        this.evidence_of_implementation_remarks = evidence_of_implementation_remarks;
    }

    public String getFood_safety_hazard() {
        return food_safety_hazard;
    }

    public void setFood_safety_hazard(String food_safety_hazard) {
        this.food_safety_hazard = food_safety_hazard;
    }

    public String getFood_safety_hazard_mandatory() {
        return food_safety_hazard_mandatory;
    }

    public void setFood_safety_hazard_mandatory(String food_safety_hazard_mandatory) {
        this.food_safety_hazard_mandatory = food_safety_hazard_mandatory;
    }

    public String getFood_safety_hazard_remarks() {
        return food_safety_hazard_remarks;
    }

    public void setFood_safety_hazard_remarks(String food_safety_hazard_remarks) {
        this.food_safety_hazard_remarks = food_safety_hazard_remarks;
    }

    public String getControl_measures() {
        return control_measures;
    }

    public void setControl_measures(String control_measures) {
        this.control_measures = control_measures;
    }

    public String getControl_measures_mandatory() {
        return control_measures_mandatory;
    }

    public void setControl_measures_mandatory(String control_measures_mandatory) {
        this.control_measures_mandatory = control_measures_mandatory;
    }

    public String getControl_measures_remarks() {
        return control_measures_remarks;
    }

    public void setControl_measures_remarks(String control_measures_remarks) {
        this.control_measures_remarks = control_measures_remarks;
    }

    public String getDocumented_glass_policy() {
        return documented_glass_policy;
    }

    public void setDocumented_glass_policy(String documented_glass_policy) {
        this.documented_glass_policy = documented_glass_policy;
    }

    public String getDocumented_glass_policy_mandatory() {
        return documented_glass_policy_mandatory;
    }

    public void setDocumented_glass_policy_mandatory(String documented_glass_policy_mandatory) {
        this.documented_glass_policy_mandatory = documented_glass_policy_mandatory;
    }

    public String getDocumented_glass_policy_remarks() {
        return documented_glass_policy_remarks;
    }

    public void setDocumented_glass_policy_remarks(String documented_glass_policy_remarks) {
        this.documented_glass_policy_remarks = documented_glass_policy_remarks;
    }

    public String getValid_medical_certificates() {
        return valid_medical_certificates;
    }

    public void setValid_medical_certificates(String valid_medical_certificates) {
        this.valid_medical_certificates = valid_medical_certificates;
    }

    public String getValid_medical_certificates_mandatory() {
        return valid_medical_certificates_mandatory;
    }

    public void setValid_medical_certificates_mandatory(String valid_medical_certificates_mandatory) {
        this.valid_medical_certificates_mandatory = valid_medical_certificates_mandatory;
    }

    public String getValid_medical_certificates_remarks() {
        return valid_medical_certificates_remarks;
    }

    public void setValid_medical_certificates_remarks(String valid_medical_certificates_remarks) {
        this.valid_medical_certificates_remarks = valid_medical_certificates_remarks;
    }

    public String getAre_hygiene_trainings_conducted() {
        return are_hygiene_trainings_conducted;
    }

    public void setAre_hygiene_trainings_conducted(String are_hygiene_trainings_conducted) {
        this.are_hygiene_trainings_conducted = are_hygiene_trainings_conducted;
    }

    public String getAre_hygiene_trainings_conducted_mandatory() {
        return are_hygiene_trainings_conducted_mandatory;
    }

    public void setAre_hygiene_trainings_conducted_mandatory(String are_hygiene_trainings_conducted_mandatory) {
        this.are_hygiene_trainings_conducted_mandatory = are_hygiene_trainings_conducted_mandatory;
    }

    public String getAre_hygiene_trainings_conducted_remarks() {
        return are_hygiene_trainings_conducted_remarks;
    }

    public void setAre_hygiene_trainings_conducted_remarks(String are_hygiene_trainings_conducted_remarks) {
        this.are_hygiene_trainings_conducted_remarks = are_hygiene_trainings_conducted_remarks;
    }

    public String getAdequate_and_clean_personal() {
        return adequate_and_clean_personal;
    }

    public void setAdequate_and_clean_personal(String adequate_and_clean_personal) {
        this.adequate_and_clean_personal = adequate_and_clean_personal;
    }

    public String getAdequate_and_clean_personal_mandatory() {
        return adequate_and_clean_personal_mandatory;
    }

    public void setAdequate_and_clean_personal_mandatory(String adequate_and_clean_personal_mandatory) {
        this.adequate_and_clean_personal_mandatory = adequate_and_clean_personal_mandatory;
    }

    public String getAdequate_and_clean_personal_remarks() {
        return adequate_and_clean_personal_remarks;
    }

    public void setAdequate_and_clean_personal_remarks(String adequate_and_clean_personal_remarks) {
        this.adequate_and_clean_personal_remarks = adequate_and_clean_personal_remarks;
    }

    public String getPersonnel_hygiene_practices_followed() {
        return personnel_hygiene_practices_followed;
    }

    public void setPersonnel_hygiene_practices_followed(String personnel_hygiene_practices_followed) {
        this.personnel_hygiene_practices_followed = personnel_hygiene_practices_followed;
    }

    public String getPersonnel_hygiene_practices_followed_mandatory() {
        return personnel_hygiene_practices_followed_mandatory;
    }

    public void setPersonnel_hygiene_practices_followed_mandatory(String personnel_hygiene_practices_followed_mandatory) {
        this.personnel_hygiene_practices_followed_mandatory = personnel_hygiene_practices_followed_mandatory;
    }

    public String getPersonnel_hygiene_practices_followed_remarks() {
        return personnel_hygiene_practices_followed_remarks;
    }

    public void setPersonnel_hygiene_practices_followed_remarks(String personnel_hygiene_practices_followed_remarks) {
        this.personnel_hygiene_practices_followed_remarks = personnel_hygiene_practices_followed_remarks;
    }

    public String getChanging_rooms_and_toilets() {
        return changing_rooms_and_toilets;
    }

    public void setChanging_rooms_and_toilets(String changing_rooms_and_toilets) {
        this.changing_rooms_and_toilets = changing_rooms_and_toilets;
    }

    public String getChanging_rooms_and_toilets_mandatory() {
        return changing_rooms_and_toilets_mandatory;
    }

    public void setChanging_rooms_and_toilets_mandatory(String changing_rooms_and_toilets_mandatory) {
        this.changing_rooms_and_toilets_mandatory = changing_rooms_and_toilets_mandatory;
    }

    public String getChanging_rooms_and_toilets_remarks() {
        return changing_rooms_and_toilets_remarks;
    }

    public void setChanging_rooms_and_toilets_remarks(String changing_rooms_and_toilets_remarks) {
        this.changing_rooms_and_toilets_remarks = changing_rooms_and_toilets_remarks;
    }

    public String getDocumented_cleaning_programs() {
        return documented_cleaning_programs;
    }

    public void setDocumented_cleaning_programs(String documented_cleaning_programs) {
        this.documented_cleaning_programs = documented_cleaning_programs;
    }

    public String getDocumented_cleaning_programs_mandatory() {
        return documented_cleaning_programs_mandatory;
    }

    public void setDocumented_cleaning_programs_mandatory(String documented_cleaning_programs_mandatory) {
        this.documented_cleaning_programs_mandatory = documented_cleaning_programs_mandatory;
    }

    public String getDocumented_cleaning_programs_remarks() {
        return documented_cleaning_programs_remarks;
    }

    public void setDocumented_cleaning_programs_remarks(String documented_cleaning_programs_remarks) {
        this.documented_cleaning_programs_remarks = documented_cleaning_programs_remarks;
    }

    public String getCleaning_records_kept() {
        return cleaning_records_kept;
    }

    public void setCleaning_records_kept(String cleaning_records_kept) {
        this.cleaning_records_kept = cleaning_records_kept;
    }

    public String getCleaning_records_kept_mandatory() {
        return cleaning_records_kept_mandatory;
    }

    public void setCleaning_records_kept_mandatory(String cleaning_records_kept_mandatory) {
        this.cleaning_records_kept_mandatory = cleaning_records_kept_mandatory;
    }

    public String getCleaning_records_kept_remarks() {
        return cleaning_records_kept_remarks;
    }

    public void setCleaning_records_kept_remarks(String cleaning_records_kept_remarks) {
        this.cleaning_records_kept_remarks = cleaning_records_kept_remarks;
    }

    public String getSegregation_and_labelling() {
        return segregation_and_labelling;
    }

    public void setSegregation_and_labelling(String segregation_and_labelling) {
        this.segregation_and_labelling = segregation_and_labelling;
    }

    public String getSegregation_and_labelling_mandatory() {
        return segregation_and_labelling_mandatory;
    }

    public void setSegregation_and_labelling_mandatory(String segregation_and_labelling_mandatory) {
        this.segregation_and_labelling_mandatory = segregation_and_labelling_mandatory;
    }

    public String getSegregation_and_labelling_remarks() {
        return segregation_and_labelling_remarks;
    }

    public void setSegregation_and_labelling_remarks(String segregation_and_labelling_remarks) {
        this.segregation_and_labelling_remarks = segregation_and_labelling_remarks;
    }

    public String getAre_all_pests_excluded() {
        return are_all_pests_excluded;
    }

    public void setAre_all_pests_excluded(String are_all_pests_excluded) {
        this.are_all_pests_excluded = are_all_pests_excluded;
    }

    public String getAre_all_pests_excluded_mandatory() {
        return are_all_pests_excluded_mandatory;
    }

    public void setAre_all_pests_excluded_mandatory(String are_all_pests_excluded_mandatory) {
        this.are_all_pests_excluded_mandatory = are_all_pests_excluded_mandatory;
    }

    public String getAre_all_pests_excluded_remarks() {
        return are_all_pests_excluded_remarks;
    }

    public void setAre_all_pests_excluded_remarks(String are_all_pests_excluded_remarks) {
        this.are_all_pests_excluded_remarks = are_all_pests_excluded_remarks;
    }

    public String getUp_to_date_bait_map() {
        return up_to_date_bait_map;
    }

    public void setUp_to_date_bait_map(String up_to_date_bait_map) {
        this.up_to_date_bait_map = up_to_date_bait_map;
    }

    public String getUp_to_date_bait_map_mandatory() {
        return up_to_date_bait_map_mandatory;
    }

    public void setUp_to_date_bait_map_mandatory(String up_to_date_bait_map_mandatory) {
        this.up_to_date_bait_map_mandatory = up_to_date_bait_map_mandatory;
    }

    public String getUp_to_date_bait_map_remarks() {
        return up_to_date_bait_map_remarks;
    }

    public void setUp_to_date_bait_map_remarks(String up_to_date_bait_map_remarks) {
        this.up_to_date_bait_map_remarks = up_to_date_bait_map_remarks;
    }

    public String getInspection_every_three_months() {
        return inspection_every_three_months;
    }

    public void setInspection_every_three_months(String inspection_every_three_months) {
        this.inspection_every_three_months = inspection_every_three_months;
    }

    public String getInspection_every_three_months_mandatory() {
        return inspection_every_three_months_mandatory;
    }

    public void setInspection_every_three_months_mandatory(String inspection_every_three_months_mandatory) {
        this.inspection_every_three_months_mandatory = inspection_every_three_months_mandatory;
    }

    public String getInspection_every_three_months_remarks() {
        return inspection_every_three_months_remarks;
    }

    public void setInspection_every_three_months_remarks(String inspection_every_three_months_remarks) {
        this.inspection_every_three_months_remarks = inspection_every_three_months_remarks;
    }

    public String getPrecaution_to_prevent() {
        return precaution_to_prevent;
    }

    public void setPrecaution_to_prevent(String precaution_to_prevent) {
        this.precaution_to_prevent = precaution_to_prevent;
    }

    public String getPrecaution_to_prevent_mandatory() {
        return precaution_to_prevent_mandatory;
    }

    public void setPrecaution_to_prevent_mandatory(String precaution_to_prevent_mandatory) {
        this.precaution_to_prevent_mandatory = precaution_to_prevent_mandatory;
    }

    public String getPrecaution_to_prevent_remarks() {
        return precaution_to_prevent_remarks;
    }

    public void setPrecaution_to_prevent_remarks(String precaution_to_prevent_remarks) {
        this.precaution_to_prevent_remarks = precaution_to_prevent_remarks;
    }

    public String getStorage_distribution_and_transportation() {
        return storage_distribution_and_transportation;
    }

    public void setStorage_distribution_and_transportation(String storage_distribution_and_transportation) {
        this.storage_distribution_and_transportation = storage_distribution_and_transportation;
    }

    public String getStorage_distribution_and_transportation_mandatory() {
        return storage_distribution_and_transportation_mandatory;
    }

    public void setStorage_distribution_and_transportation_mandatory(String storage_distribution_and_transportation_mandatory) {
        this.storage_distribution_and_transportation_mandatory = storage_distribution_and_transportation_mandatory;
    }

    public String getStorage_distribution_and_transportation_remarks() {
        return storage_distribution_and_transportation_remarks;
    }

    public void setStorage_distribution_and_transportation_remarks(String storage_distribution_and_transportation_remarks) {
        this.storage_distribution_and_transportation_remarks = storage_distribution_and_transportation_remarks;
    }

    public String getWalls_and_partitions() {
        return walls_and_partitions;
    }

    public void setWalls_and_partitions(String walls_and_partitions) {
        this.walls_and_partitions = walls_and_partitions;
    }

    public String getWalls_and_partitions_mandatory() {
        return walls_and_partitions_mandatory;
    }

    public void setWalls_and_partitions_mandatory(String walls_and_partitions_mandatory) {
        this.walls_and_partitions_mandatory = walls_and_partitions_mandatory;
    }

    public String getWalls_and_partitions_remarks() {
        return walls_and_partitions_remarks;
    }

    public void setWalls_and_partitions_remarks(String walls_and_partitions_remarks) {
        this.walls_and_partitions_remarks = walls_and_partitions_remarks;
    }

    public String getSource_of_planting_materials() {
        return source_of_planting_materials;
    }

    public void setSource_of_planting_materials(String source_of_planting_materials) {
        this.source_of_planting_materials = source_of_planting_materials;
    }

    public String getSource_of_planting_materials_mandatory() {
        return source_of_planting_materials_mandatory;
    }

    public void setSource_of_planting_materials_mandatory(String source_of_planting_materials_mandatory) {
        this.source_of_planting_materials_mandatory = source_of_planting_materials_mandatory;
    }

    public String getSource_of_planting_materials_remarks() {
        return source_of_planting_materials_remarks;
    }

    public void setSource_of_planting_materials_remarks(String source_of_planting_materials_remarks) {
        this.source_of_planting_materials_remarks = source_of_planting_materials_remarks;
    }

    public String getProcedure_for_inspection() {
        return procedure_for_inspection;
    }

    public void setProcedure_for_inspection(String procedure_for_inspection) {
        this.procedure_for_inspection = procedure_for_inspection;
    }

    public String getProcedure_for_inspection_mandatory() {
        return procedure_for_inspection_mandatory;
    }

    public void setProcedure_for_inspection_mandatory(String procedure_for_inspection_mandatory) {
        this.procedure_for_inspection_mandatory = procedure_for_inspection_mandatory;
    }

    public String getProcedure_for_inspection_remarks() {
        return procedure_for_inspection_remarks;
    }

    public void setProcedure_for_inspection_remarks(String procedure_for_inspection_remarks) {
        this.procedure_for_inspection_remarks = procedure_for_inspection_remarks;
    }

    public String getProper_segregation_of_materials() {
        return proper_segregation_of_materials;
    }

    public void setProper_segregation_of_materials(String proper_segregation_of_materials) {
        this.proper_segregation_of_materials = proper_segregation_of_materials;
    }

    public String getProper_segregation_of_materials_mandatory() {
        return proper_segregation_of_materials_mandatory;
    }

    public void setProper_segregation_of_materials_mandatory(String proper_segregation_of_materials_mandatory) {
        this.proper_segregation_of_materials_mandatory = proper_segregation_of_materials_mandatory;
    }

    public String getProper_segregation_of_materials_remarks() {
        return proper_segregation_of_materials_remarks;
    }

    public void setProper_segregation_of_materials_remarks(String proper_segregation_of_materials_remarks) {
        this.proper_segregation_of_materials_remarks = proper_segregation_of_materials_remarks;
    }

    public String getSufficient_ventilation() {
        return sufficient_ventilation;
    }

    public void setSufficient_ventilation(String sufficient_ventilation) {
        this.sufficient_ventilation = sufficient_ventilation;
    }

    public String getSufficient_ventilation_mandatory() {
        return sufficient_ventilation_mandatory;
    }

    public void setSufficient_ventilation_mandatory(String sufficient_ventilation_mandatory) {
        this.sufficient_ventilation_mandatory = sufficient_ventilation_mandatory;
    }

    public String getSufficient_ventilation_remarks() {
        return sufficient_ventilation_remarks;
    }

    public void setSufficient_ventilation_remarks(String sufficient_ventilation_remarks) {
        this.sufficient_ventilation_remarks = sufficient_ventilation_remarks;
    }

    public String getAdequate_services() {
        return adequate_services;
    }

    public void setAdequate_services(String adequate_services) {
        this.adequate_services = adequate_services;
    }

    public String getAdequate_services_mandatory() {
        return adequate_services_mandatory;
    }

    public void setAdequate_services_mandatory(String adequate_services_mandatory) {
        this.adequate_services_mandatory = adequate_services_mandatory;
    }

    public String getAdequate_services_remarks() {
        return adequate_services_remarks;
    }

    public void setAdequate_services_remarks(String adequate_services_remarks) {
        this.adequate_services_remarks = adequate_services_remarks;
    }

    public String getProper_waste_collection() {
        return proper_waste_collection;
    }

    public void setProper_waste_collection(String proper_waste_collection) {
        this.proper_waste_collection = proper_waste_collection;
    }

    public String getProper_waste_collection_mandatory() {
        return proper_waste_collection_mandatory;
    }

    public void setProper_waste_collection_mandatory(String proper_waste_collection_mandatory) {
        this.proper_waste_collection_mandatory = proper_waste_collection_mandatory;
    }

    public String getProper_waste_collection_remarks() {
        return proper_waste_collection_remarks;
    }

    public void setProper_waste_collection_remarks(String proper_waste_collection_remarks) {
        this.proper_waste_collection_remarks = proper_waste_collection_remarks;
    }

    public String getExternal_site_standards() {
        return external_site_standards;
    }

    public void setExternal_site_standards(String external_site_standards) {
        this.external_site_standards = external_site_standards;
    }

    public String getExternal_site_standards_mandatory() {
        return external_site_standards_mandatory;
    }

    public void setExternal_site_standards_mandatory(String external_site_standards_mandatory) {
        this.external_site_standards_mandatory = external_site_standards_mandatory;
    }

    public String getExternal_site_standards_remarks() {
        return external_site_standards_remarks;
    }

    public void setExternal_site_standards_remarks(String external_site_standards_remarks) {
        this.external_site_standards_remarks = external_site_standards_remarks;
    }

    public String getWalls() {
        return walls;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public String getWalls_mandatory() {
        return walls_mandatory;
    }

    public void setWalls_mandatory(String walls_mandatory) {
        this.walls_mandatory = walls_mandatory;
    }

    public String getWalls_remarks() {
        return walls_remarks;
    }

    public void setWalls_remarks(String walls_remarks) {
        this.walls_remarks = walls_remarks;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getFloors_mandatory() {
        return floors_mandatory;
    }

    public void setFloors_mandatory(String floors_mandatory) {
        this.floors_mandatory = floors_mandatory;
    }

    public String getFloors_remarks() {
        return floors_remarks;
    }

    public void setFloors_remarks(String floors_remarks) {
        this.floors_remarks = floors_remarks;
    }

    public String getRoof_ceiling_and_overhead() {
        return roof_ceiling_and_overhead;
    }

    public void setRoof_ceiling_and_overhead(String roof_ceiling_and_overhead) {
        this.roof_ceiling_and_overhead = roof_ceiling_and_overhead;
    }

    public String getRoof_ceiling_and_overhead_mandatory() {
        return roof_ceiling_and_overhead_mandatory;
    }

    public void setRoof_ceiling_and_overhead_mandatory(String roof_ceiling_and_overhead_mandatory) {
        this.roof_ceiling_and_overhead_mandatory = roof_ceiling_and_overhead_mandatory;
    }

    public String getRoof_ceiling_and_overhead_remarks() {
        return roof_ceiling_and_overhead_remarks;
    }

    public void setRoof_ceiling_and_overhead_remarks(String roof_ceiling_and_overhead_remarks) {
        this.roof_ceiling_and_overhead_remarks = roof_ceiling_and_overhead_remarks;
    }

    public String getWindows() {
        return windows;
    }

    public void setWindows(String windows) {
        this.windows = windows;
    }

    public String getWindows_mandatory() {
        return windows_mandatory;
    }

    public void setWindows_mandatory(String windows_mandatory) {
        this.windows_mandatory = windows_mandatory;
    }

    public String getWindows_remarks() {
        return windows_remarks;
    }

    public void setWindows_remarks(String windows_remarks) {
        this.windows_remarks = windows_remarks;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getDoors_mandatory() {
        return doors_mandatory;
    }

    public void setDoors_mandatory(String doors_mandatory) {
        this.doors_mandatory = doors_mandatory;
    }

    public String getDoors_remarks() {
        return doors_remarks;
    }

    public void setDoors_remarks(String doors_remarks) {
        this.doors_remarks = doors_remarks;
    }

    public String getProtection_of_light_tubes() {
        return protection_of_light_tubes;
    }

    public void setProtection_of_light_tubes(String protection_of_light_tubes) {
        this.protection_of_light_tubes = protection_of_light_tubes;
    }

    public String getProtection_of_light_tubes_mandatory() {
        return protection_of_light_tubes_mandatory;
    }

    public void setProtection_of_light_tubes_mandatory(String protection_of_light_tubes_mandatory) {
        this.protection_of_light_tubes_mandatory = protection_of_light_tubes_mandatory;
    }

    public String getProtection_of_light_tubes_remarks() {
        return protection_of_light_tubes_remarks;
    }

    public void setProtection_of_light_tubes_remarks(String protection_of_light_tubes_remarks) {
        this.protection_of_light_tubes_remarks = protection_of_light_tubes_remarks;
    }

    public String getMaintenance_programs() {
        return maintenance_programs;
    }

    public void setMaintenance_programs(String maintenance_programs) {
        this.maintenance_programs = maintenance_programs;
    }

    public String getMaintenance_programs_mandatory() {
        return maintenance_programs_mandatory;
    }

    public void setMaintenance_programs_mandatory(String maintenance_programs_mandatory) {
        this.maintenance_programs_mandatory = maintenance_programs_mandatory;
    }

    public String getMaintenance_programs_remarks() {
        return maintenance_programs_remarks;
    }

    public void setMaintenance_programs_remarks(String maintenance_programs_remarks) {
        this.maintenance_programs_remarks = maintenance_programs_remarks;
    }

    public String getMaintenance_records_maintained() {
        return maintenance_records_maintained;
    }

    public void setMaintenance_records_maintained(String maintenance_records_maintained) {
        this.maintenance_records_maintained = maintenance_records_maintained;
    }

    public String getMaintenance_records_maintained_mandatory() {
        return maintenance_records_maintained_mandatory;
    }

    public void setMaintenance_records_maintained_mandatory(String maintenance_records_maintained_mandatory) {
        this.maintenance_records_maintained_mandatory = maintenance_records_maintained_mandatory;
    }

    public String getMaintenance_records_maintained_remarks() {
        return maintenance_records_maintained_remarks;
    }

    public void setMaintenance_records_maintained_remarks(String maintenance_records_maintained_remarks) {
        this.maintenance_records_maintained_remarks = maintenance_records_maintained_remarks;
    }

    public String getAre_conveyor_belts_protected() {
        return are_conveyor_belts_protected;
    }

    public void setAre_conveyor_belts_protected(String are_conveyor_belts_protected) {
        this.are_conveyor_belts_protected = are_conveyor_belts_protected;
    }

    public String getAre_conveyor_belts_protected_mandatory() {
        return are_conveyor_belts_protected_mandatory;
    }

    public void setAre_conveyor_belts_protected_mandatory(String are_conveyor_belts_protected_mandatory) {
        this.are_conveyor_belts_protected_mandatory = are_conveyor_belts_protected_mandatory;
    }

    public String getAre_conveyor_belts_protected_remarks() {
        return are_conveyor_belts_protected_remarks;
    }

    public void setAre_conveyor_belts_protected_remarks(String are_conveyor_belts_protected_remarks) {
        this.are_conveyor_belts_protected_remarks = are_conveyor_belts_protected_remarks;
    }

    public String getProduct_testing() {
        return product_testing;
    }

    public void setProduct_testing(String product_testing) {
        this.product_testing = product_testing;
    }

    public String getProduct_testing_mandatory() {
        return product_testing_mandatory;
    }

    public void setProduct_testing_mandatory(String product_testing_mandatory) {
        this.product_testing_mandatory = product_testing_mandatory;
    }

    public String getProduct_testing_remarks() {
        return product_testing_remarks;
    }

    public void setProduct_testing_remarks(String product_testing_remarks) {
        this.product_testing_remarks = product_testing_remarks;
    }

    public String getCalibration_of_weighing_scale() {
        return calibration_of_weighing_scale;
    }

    public void setCalibration_of_weighing_scale(String calibration_of_weighing_scale) {
        this.calibration_of_weighing_scale = calibration_of_weighing_scale;
    }

    public String getCalibration_of_weighing_scale_mandatory() {
        return calibration_of_weighing_scale_mandatory;
    }

    public void setCalibration_of_weighing_scale_mandatory(String calibration_of_weighing_scale_mandatory) {
        this.calibration_of_weighing_scale_mandatory = calibration_of_weighing_scale_mandatory;
    }

    public String getCalibration_of_weighing_scale_remarks() {
        return calibration_of_weighing_scale_remarks;
    }

    public void setCalibration_of_weighing_scale_remarks(String calibration_of_weighing_scale_remarks) {
        this.calibration_of_weighing_scale_remarks = calibration_of_weighing_scale_remarks;
    }

    public String getMedical_examination() {
        return medical_examination;
    }

    public void setMedical_examination(String medical_examination) {
        this.medical_examination = medical_examination;
    }

    public String getMedical_examination_mandatory() {
        return medical_examination_mandatory;
    }

    public void setMedical_examination_mandatory(String medical_examination_mandatory) {
        this.medical_examination_mandatory = medical_examination_mandatory;
    }

    public String getMedical_examination_remarks() {
        return medical_examination_remarks;
    }

    public void setMedical_examination_remarks(String medical_examination_remarks) {
        this.medical_examination_remarks = medical_examination_remarks;
    }

    public String getIncoming_product() {
        return incoming_product;
    }

    public void setIncoming_product(String incoming_product) {
        this.incoming_product = incoming_product;
    }

    public String getIncoming_product_mandatory() {
        return incoming_product_mandatory;
    }

    public void setIncoming_product_mandatory(String incoming_product_mandatory) {
        this.incoming_product_mandatory = incoming_product_mandatory;
    }

    public String getIncoming_product_remarks() {
        return incoming_product_remarks;
    }

    public void setIncoming_product_remarks(String incoming_product_remarks) {
        this.incoming_product_remarks = incoming_product_remarks;
    }

    public String getIncoming_product_vehicle_inspection() {
        return incoming_product_vehicle_inspection;
    }

    public void setIncoming_product_vehicle_inspection(String incoming_product_vehicle_inspection) {
        this.incoming_product_vehicle_inspection = incoming_product_vehicle_inspection;
    }

    public String getIncoming_product_vehicle_inspection_mandatory() {
        return incoming_product_vehicle_inspection_mandatory;
    }

    public void setIncoming_product_vehicle_inspection_mandatory(String incoming_product_vehicle_inspection_mandatory) {
        this.incoming_product_vehicle_inspection_mandatory = incoming_product_vehicle_inspection_mandatory;
    }

    public String getIncoming_product_vehicle_inspection_remarks() {
        return incoming_product_vehicle_inspection_remarks;
    }

    public void setIncoming_product_vehicle_inspection_remarks(String incoming_product_vehicle_inspection_remarks) {
        this.incoming_product_vehicle_inspection_remarks = incoming_product_vehicle_inspection_remarks;
    }

    public String getHygiene_housekeeping_inspection() {
        return hygiene_housekeeping_inspection;
    }

    public void setHygiene_housekeeping_inspection(String hygiene_housekeeping_inspection) {
        this.hygiene_housekeeping_inspection = hygiene_housekeeping_inspection;
    }

    public String getHygiene_housekeeping_inspection_mandatory() {
        return hygiene_housekeeping_inspection_mandatory;
    }

    public void setHygiene_housekeeping_inspection_mandatory(String hygiene_housekeeping_inspection_mandatory) {
        this.hygiene_housekeeping_inspection_mandatory = hygiene_housekeeping_inspection_mandatory;
    }

    public String getHygiene_housekeeping_inspection_remarks() {
        return hygiene_housekeeping_inspection_remarks;
    }

    public void setHygiene_housekeeping_inspection_remarks(String hygiene_housekeeping_inspection_remarks) {
        this.hygiene_housekeeping_inspection_remarks = hygiene_housekeeping_inspection_remarks;
    }

    public String getDocument_status() {
        return document_status;
    }

    public void setDocument_status(String document_status) {
        this.document_status = document_status;
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

    public String getSecurity_access_control() {
        return security_access_control;
    }

    public void setSecurity_access_control(String security_access_control) {
        this.security_access_control = security_access_control;
    }

    public String getSecurity_access_control_mandatory() {
        return security_access_control_mandatory;
    }

    public void setSecurity_access_control_mandatory(String security_access_control_mandatory) {
        this.security_access_control_mandatory = security_access_control_mandatory;
    }

    public String getSecurity_access_control_remarks() {
        return security_access_control_remarks;
    }

    public void setSecurity_access_control_remarks(String security_access_control_remarks) {
        this.security_access_control_remarks = security_access_control_remarks;
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
