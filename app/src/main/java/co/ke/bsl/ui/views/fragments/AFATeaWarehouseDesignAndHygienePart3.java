package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.TeaWarehouseManInspection;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.data.view.TeaWarehouseManInspectionBus;
import co.ke.bsl.data.view.View10Marks;
import co.ke.bsl.data.view.View1Marks;
import co.ke.bsl.data.view.View2Marks;
import co.ke.bsl.data.view.View5Marks;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.TeaWarehouseManViewModel;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFATeaWarehouseDesignAndHygienePart3 extends Fragment implements BlockingStep {

    @BindView(R.id.ch_incoming_product_vehicle_inspection)
    CheckBox ch_incoming_product_vehicle_inspection;
    @BindView(R.id.ssincoming_product_vehicle_inspection_mandatory)
    SearchableSpinner ssincoming_product_vehicle_inspection_mandatory;
    @BindView(R.id.etincoming_product_vehicle_inspection_remarks)
    CustomEditText etincoming_product_vehicle_inspection_remarks;

    @BindView(R.id.ch_hygiene_housekeeping_inspection)
    CheckBox ch_hygiene_housekeeping_inspection;
    @BindView(R.id.sshygiene_housekeeping_inspection_mandatory)
    SearchableSpinner sshygiene_housekeeping_inspection_mandatory;
    @BindView(R.id.ethygiene_housekeeping_inspection_remarks)
    CustomEditText ethygiene_housekeeping_inspection_remarks;


    @BindView(R.id.ch_medical_examination)
    CheckBox ch_medical_examination;
    @BindView(R.id.ssmedical_examination_mandatory)
    SearchableSpinner ssmedical_examination_mandatory;
    @BindView(R.id.etmedical_examination_remarks)
    CustomEditText etmedical_examination_remarks;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    private TeaWarehouseManViewModel teaWarehouseManViewModel;

    private ArrayList<String> marksOf2List = new ArrayList<>();
    private ArrayList<String> marksOf1List = new ArrayList<>();
    private ArrayList<String> marksOf5List = new ArrayList<>();
    private ArrayList<String> marksOf10List = new ArrayList<>();

    private String Savestring = "N";

    private String str_incoming_product_vehicle_inspection, str_hygiene_housekeeping_inspection, str_medical_examination;
    private String incoming_product_vehicle_inspection_mandatory, hygiene_housekeeping_inspection_mandatory, medical_examination_mandatory;

    AFADatabaseAdapter db;

    AFA app;

    private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();

    public AFATeaWarehouseDesignAndHygienePart3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afatea_warehouse_design_and_hygiene_part3, container, false);
        ButterKnife.bind(this, view);

        setList1Marks(getDummy1Marks());
        setList2Marks(getDummy2Marks());
        setList5Marks(getDummy5Marks());
        setList10Marks(getDummy10Marks());

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        teaWarehouseManViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(TeaWarehouseManViewModel.class);

        setReccomendationsView(getReccomendationsView());

        ssReccomendation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ReccomendationsView rec = (ReccomendationsView) ssReccomendation.getSelectedItem();
                recommendation = rec.getServerID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ch_incoming_product_vehicle_inspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_incoming_product_vehicle_inspection.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_incoming_product_vehicle_inspection = Savestring;

            }
        });

        ch_hygiene_housekeeping_inspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_hygiene_housekeeping_inspection.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_hygiene_housekeeping_inspection = Savestring;

            }
        });

        ch_medical_examination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_medical_examination.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_medical_examination = Savestring;

            }
        });

        ssmedical_examination_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                medical_examination_mandatory = ssmedical_examination_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssincoming_product_vehicle_inspection_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                incoming_product_vehicle_inspection_mandatory = ssincoming_product_vehicle_inspection_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sshygiene_housekeeping_inspection_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hygiene_housekeeping_inspection_mandatory = sshygiene_housekeeping_inspection_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {


        String incoming_product_vehicle_inspection_remarks = Objects.requireNonNull(etincoming_product_vehicle_inspection_remarks.getText()).toString().trim();
        String hygiene_housekeeping_inspection_remarks = Objects.requireNonNull(ethygiene_housekeeping_inspection_remarks.getText()).toString().trim();
        String medical_examination_remarks = Objects.requireNonNull(etmedical_examination_remarks.getText()).toString().trim();

        boolean a = validateFields(ch_incoming_product_vehicle_inspection, etincoming_product_vehicle_inspection_remarks, incoming_product_vehicle_inspection_remarks, ssincoming_product_vehicle_inspection_mandatory, incoming_product_vehicle_inspection_mandatory);
        boolean b = validateFields(ch_hygiene_housekeeping_inspection, ethygiene_housekeeping_inspection_remarks, hygiene_housekeeping_inspection_remarks, sshygiene_housekeeping_inspection_mandatory, hygiene_housekeeping_inspection_mandatory);
        boolean c = validateFields(ch_medical_examination, etmedical_examination_remarks, medical_examination_remarks, ssmedical_examination_mandatory, medical_examination_mandatory);

        TeaWarehouseManInspectionBus teaWarehouseManInspectionBus = TeaWarehouseManInspectionBus.getInstance();
        TeaWarehouseManInspection teaWarehouseManInspection = new TeaWarehouseManInspection(
                0,
                teaWarehouseManInspectionBus.getDocument_number(),
                teaWarehouseManInspectionBus.getDocument_date(),
                teaWarehouseManInspectionBus.getName_of_applicant(),
                teaWarehouseManInspectionBus.getLicense_number(),
                teaWarehouseManInspectionBus.getLocalID(),
                teaWarehouseManInspectionBus.getCertificate_of_company_registration(),
                teaWarehouseManInspectionBus.getCertificate_of_company_registration_mandatory(),
                teaWarehouseManInspectionBus.getCertificate_of_company_registration_remarks(),
                teaWarehouseManInspectionBus.getValid_insurance_policy(),
                teaWarehouseManInspectionBus.getValid_insurance_policy_mandatory(),
                teaWarehouseManInspectionBus.getValid_insurance_policy_remarks(),
                teaWarehouseManInspectionBus.getBusiness_permit(),
                teaWarehouseManInspectionBus.getBusiness_permit_mandatory(),
                teaWarehouseManInspectionBus.getBusiness_permit_remarks(),
                teaWarehouseManInspectionBus.getHealth_certificate(),
                teaWarehouseManInspectionBus.getHealth_certificate_mandatory(),
                teaWarehouseManInspectionBus.getHealth_certificate_remarks(),
                teaWarehouseManInspectionBus.getSubmission_of_annual_returns(),
                teaWarehouseManInspectionBus.getSubmission_of_annual_returns_mandatory(),
                teaWarehouseManInspectionBus.getSubmission_of_annual_returns_remarks(),
                teaWarehouseManInspectionBus.getDocumented_hygiene_policy(),
                teaWarehouseManInspectionBus.getDocumented_hygiene_policy_mandatory(),
                teaWarehouseManInspectionBus.getDocumented_hygiene_policy_remarks(),
                teaWarehouseManInspectionBus.getEvidence_of_implementation(),
                teaWarehouseManInspectionBus.getEvidence_of_implementation_mandatory(),
                teaWarehouseManInspectionBus.getEvidence_of_implementation_remarks(),
                teaWarehouseManInspectionBus.getFood_safety_hazard(),
                teaWarehouseManInspectionBus.getFood_safety_hazard_mandatory(),
                teaWarehouseManInspectionBus.getFood_safety_hazard_remarks(),
                teaWarehouseManInspectionBus.getControl_measures(),
                teaWarehouseManInspectionBus.getControl_measures_mandatory(),
                teaWarehouseManInspectionBus.getControl_measures_remarks(),
                teaWarehouseManInspectionBus.getDocumented_glass_policy(),
                teaWarehouseManInspectionBus.getDocumented_glass_policy_mandatory(),
                teaWarehouseManInspectionBus.getDocumented_glass_policy_remarks(),
                teaWarehouseManInspectionBus.getValid_medical_certificates(),
                teaWarehouseManInspectionBus.getValid_medical_certificates_mandatory(),
                teaWarehouseManInspectionBus.getValid_medical_certificates_remarks(),
                teaWarehouseManInspectionBus.getAre_hygiene_trainings_conducted(),
                teaWarehouseManInspectionBus.getAre_hygiene_trainings_conducted_mandatory(),
                teaWarehouseManInspectionBus.getAre_hygiene_trainings_conducted_remarks(),
                teaWarehouseManInspectionBus.getAdequate_and_clean_personal(),
                teaWarehouseManInspectionBus.getAdequate_and_clean_personal_mandatory(),
                teaWarehouseManInspectionBus.getAdequate_and_clean_personal_remarks(),
                teaWarehouseManInspectionBus.getPersonnel_hygiene_practices_followed(),
                teaWarehouseManInspectionBus.getPersonnel_hygiene_practices_followed_mandatory(),
                teaWarehouseManInspectionBus.getPersonnel_hygiene_practices_followed_remarks(),
                teaWarehouseManInspectionBus.getChanging_rooms_and_toilets(),
                teaWarehouseManInspectionBus.getChanging_rooms_and_toilets_mandatory(),
                teaWarehouseManInspectionBus.getChanging_rooms_and_toilets_remarks(),
                teaWarehouseManInspectionBus.getDocumented_cleaning_programs(),
                teaWarehouseManInspectionBus.getDocumented_cleaning_programs_mandatory(),
                teaWarehouseManInspectionBus.getDocumented_cleaning_programs_remarks(),
                teaWarehouseManInspectionBus.getCleaning_records_kept(),
                teaWarehouseManInspectionBus.getCleaning_records_kept_mandatory(),
                teaWarehouseManInspectionBus.getCleaning_records_kept_remarks(),
                teaWarehouseManInspectionBus.getSegregation_and_labelling(),
                teaWarehouseManInspectionBus.getSegregation_and_labelling_mandatory(),
                teaWarehouseManInspectionBus.getSegregation_and_labelling_remarks(),
                teaWarehouseManInspectionBus.getAre_all_pests_excluded(),
                teaWarehouseManInspectionBus.getAre_all_pests_excluded_mandatory(),
                teaWarehouseManInspectionBus.getAre_all_pests_excluded_remarks(),
                teaWarehouseManInspectionBus.getUp_to_date_bait_map(),
                teaWarehouseManInspectionBus.getUp_to_date_bait_map_mandatory(),
                teaWarehouseManInspectionBus.getUp_to_date_bait_map_remarks(),
                teaWarehouseManInspectionBus.getInspection_every_three_months(),
                teaWarehouseManInspectionBus.getInspection_every_three_months_mandatory(),
                teaWarehouseManInspectionBus.getInspection_every_three_months_remarks(),
                teaWarehouseManInspectionBus.getPrecaution_to_prevent(),
                teaWarehouseManInspectionBus.getPrecaution_to_prevent_mandatory(),
                teaWarehouseManInspectionBus.getPrecaution_to_prevent_remarks(),
                teaWarehouseManInspectionBus.getStorage_distribution_and_transportation(),
                teaWarehouseManInspectionBus.getStorage_distribution_and_transportation_mandatory(),
                teaWarehouseManInspectionBus.getStorage_distribution_and_transportation_remarks(),
                teaWarehouseManInspectionBus.getWalls_and_partitions(),
                teaWarehouseManInspectionBus.getWalls_and_partitions_mandatory(),
                teaWarehouseManInspectionBus.getWalls_and_partitions_remarks(),
                teaWarehouseManInspectionBus.getProcedure_for_inspection(),
                teaWarehouseManInspectionBus.getProcedure_for_inspection_mandatory(),
                teaWarehouseManInspectionBus.getProcedure_for_inspection_remarks(),
                teaWarehouseManInspectionBus.getProper_segregation_of_materials(),
                teaWarehouseManInspectionBus.getProper_segregation_of_materials_mandatory(),
                teaWarehouseManInspectionBus.getProper_segregation_of_materials_remarks(),
                teaWarehouseManInspectionBus.getSecurity_access_control(),
                teaWarehouseManInspectionBus.getSecurity_access_control_mandatory(),
                teaWarehouseManInspectionBus.getSecurity_access_control_remarks(),
                teaWarehouseManInspectionBus.getSufficient_ventilation(),
                teaWarehouseManInspectionBus.getSufficient_ventilation_mandatory(),
                teaWarehouseManInspectionBus.getSufficient_ventilation_remarks(),
                teaWarehouseManInspectionBus.getAdequate_services(),
                teaWarehouseManInspectionBus.getAdequate_services_mandatory(),
                teaWarehouseManInspectionBus.getAdequate_services_remarks(),
                teaWarehouseManInspectionBus.getProper_waste_collection(),
                teaWarehouseManInspectionBus.getProper_waste_collection_mandatory(),
                teaWarehouseManInspectionBus.getProper_waste_collection_remarks(),
                teaWarehouseManInspectionBus.getExternal_site_standards(),
                teaWarehouseManInspectionBus.getExternal_site_standards_mandatory(),
                teaWarehouseManInspectionBus.getExternal_site_standards_remarks(),
                teaWarehouseManInspectionBus.getWalls(),
                teaWarehouseManInspectionBus.getWalls_mandatory(),
                teaWarehouseManInspectionBus.getWalls_remarks(),
                teaWarehouseManInspectionBus.getFloors(),
                teaWarehouseManInspectionBus.getFloors_mandatory(),
                teaWarehouseManInspectionBus.getFloors_remarks(),
                teaWarehouseManInspectionBus.getRoof_ceiling_and_overhead(),
                teaWarehouseManInspectionBus.getRoof_ceiling_and_overhead_mandatory(),
                teaWarehouseManInspectionBus.getRoof_ceiling_and_overhead_remarks(),
                teaWarehouseManInspectionBus.getWindows(),
                teaWarehouseManInspectionBus.getWindows_mandatory(),
                teaWarehouseManInspectionBus.getWindows_remarks(),
                teaWarehouseManInspectionBus.getDoors(),
                teaWarehouseManInspectionBus.getDoors_mandatory(),
                teaWarehouseManInspectionBus.getDoors_remarks(),
                teaWarehouseManInspectionBus.getProtection_of_light_tubes(),
                teaWarehouseManInspectionBus.getProtection_of_light_tubes_mandatory(),
                teaWarehouseManInspectionBus.getProtection_of_light_tubes_remarks(),
                teaWarehouseManInspectionBus.getMaintenance_programs(),
                teaWarehouseManInspectionBus.getMaintenance_programs_mandatory(),
                teaWarehouseManInspectionBus.getMaintenance_programs_remarks(),
                teaWarehouseManInspectionBus.getMaintenance_records_maintained(),
                teaWarehouseManInspectionBus.getMaintenance_records_maintained_mandatory(),
                teaWarehouseManInspectionBus.getMaintenance_records_maintained_remarks(),
                teaWarehouseManInspectionBus.getAre_conveyor_belts_protected(),
                teaWarehouseManInspectionBus.getAre_conveyor_belts_protected_mandatory(),
                teaWarehouseManInspectionBus.getAre_conveyor_belts_protected_remarks(),
                teaWarehouseManInspectionBus.getProduct_testing(),
                teaWarehouseManInspectionBus.getProduct_testing_mandatory(),
                teaWarehouseManInspectionBus.getProduct_testing_remarks(),
                teaWarehouseManInspectionBus.getCalibration_of_weighing_scale(),
                teaWarehouseManInspectionBus.getCalibration_of_weighing_scale_mandatory(),
                teaWarehouseManInspectionBus.getCalibration_of_weighing_scale_remarks(),
                str_medical_examination,
                medical_examination_mandatory,
                medical_examination_remarks,
                str_incoming_product_vehicle_inspection,
                incoming_product_vehicle_inspection_mandatory,
                incoming_product_vehicle_inspection_remarks,
                str_hygiene_housekeeping_inspection,
                hygiene_housekeeping_inspection_mandatory,
                hygiene_housekeeping_inspection_remarks,
                recommendation,
                recommendationRemarks,
                "",
                false,
                ""
        );

        if (a && b && c) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("TEAWAREHOUSEMAN INSPECTION!")
                    .setCancelText("NO!")
                    .setConfirmText("Submit!")
                    .showCancelButton(true)
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            // reuse previous dialog instance, keep widget user state, reset them if you need
                            sDialog.setTitleText("Cancelled!")
                                    .setContentText("You Cancelled Submission:)")
                                    .setConfirmText("OK")
                                    .showCancelButton(false)
                                    .setCancelClickListener(null)
                                    .setConfirmClickListener(null)
                                    .changeAlertType(SweetAlertDialog.ERROR_TYPE);

                        }
                    })
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.setTitleText("Successfully!!!")
                                    .setContentText("Submitted!")
                                    .setConfirmText("OK")
                                    .showCancelButton(false)
                                    .setCancelClickListener(null)
                                    .setConfirmClickListener(null)
                                    .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);


                            db.updateTeaWarehouseManInspection(teaWarehouseManInspection);
                            teaWarehouseManViewModel.addRecord(teaWarehouseManInspection);

                            sDialog.dismissWithAnimation();
                            Intent intent = new Intent(getActivity(), DashboardActivity.class);
                            startActivity(intent);
                        }
                    })
                    .show();


        }

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        callback.goToPrevStep();
    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }


    private void setList1Marks(List<View1Marks> dummy1Marks) {

        marksOf1List.add("- Required -");
        for (View1Marks regionWrapper : dummy1Marks) {
            marksOf1List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf1List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssmedical_examination_mandatory.setAdapter(regionAdapter);
        ssincoming_product_vehicle_inspection_mandatory.setAdapter(regionAdapter);
        sshygiene_housekeeping_inspection_mandatory.setAdapter(regionAdapter);

    }

    private void setList2Marks(List<View2Marks> dummy2Marks) {

        marksOf2List.add("- Required -");
        for (View2Marks regionWrapper : dummy2Marks) {
            marksOf2List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf2List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
//        sspersonalhygienedocummented2mks.setAdapter(regionAdapter);

    }

    private void setList5Marks(List<View5Marks> dummy5Marks) {

        marksOf5List.add("- Required -");
        for (View5Marks regionWrapper : dummy5Marks) {
            marksOf5List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf5List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
//        ssadequateandcleanpersonalprot5mks.setAdapter(regionAdapter);
    }


    private void setList10Marks(List<View10Marks> dummy10Marks) {

        marksOf10List.add("- Required -");
        for (View10Marks regionWrapper : dummy10Marks) {
            marksOf10List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf10List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
//        ssadequateandcleanpersonalprot5mks.setAdapter(regionAdapter);
    }

    private List<View1Marks> getDummy1Marks() {
        List<View1Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View1Marks("0"));
        listViewItems.add(new View1Marks("1"));
        return listViewItems;
    }

    private List<View2Marks> getDummy2Marks() {
        List<View2Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View2Marks("0"));
        listViewItems.add(new View2Marks("2"));
        return listViewItems;
    }

    private List<View5Marks> getDummy5Marks() {
        List<View5Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View5Marks("0"));
        listViewItems.add(new View5Marks("5"));
        return listViewItems;
    }

    private List<View10Marks> getDummy10Marks() {
        List<View10Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View10Marks("0"));
        listViewItems.add(new View10Marks("10"));
        return listViewItems;
    }

    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString, SearchableSpinner searchableSpinner, String searchableSpinnerString) {

        boolean resultCheckbox = false;
        boolean resultSpinner = false;

        if (!checkBox.isChecked()) {
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                resultCheckbox = false;
            }
        } else {
            customEditText.setError(null);
            resultCheckbox = true;
        }

        if ("- Required -".equals(searchableSpinnerString)) {
            TextView errorText = (TextView) searchableSpinner.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            resultSpinner = false;
        } else {
            resultSpinner = true;
        }
        return (resultCheckbox && resultSpinner);
    }

    private void setReccomendationsView(List<ReccomendationsView> getdummy10marks) {
//        reccomendationsViewList.add("- Required -");
        for (ReccomendationsView regionWrapper : getdummy10marks) {
            reccomendationsViewList.add(regionWrapper);
        }
        ArrayAdapter<ReccomendationsView> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, reccomendationsViewList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssReccomendation.setAdapter(regionAdapter);


    }

    private List<ReccomendationsView> getReccomendationsView() {
        List<ReccomendationsView> listViewItems = new ArrayList<>();
        listViewItems.add(new ReccomendationsView("-select-", ""));
        listViewItems.add(new ReccomendationsView("I Recommend", "10000245"));
        listViewItems.add(new ReccomendationsView("I Do Not Recommend", "10000246"));

        return listViewItems;
    }

}
