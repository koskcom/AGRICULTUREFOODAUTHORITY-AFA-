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
import co.ke.bsl.data.model.PyrethrumInspection;
import co.ke.bsl.data.model.SugarMillLicence;
import co.ke.bsl.data.view.PyrethrumInspectionBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.data.view.SugarMillLicenceBus;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.PyrethrumInspectionViewModel;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAPyrethrumInspectionStep4 extends Fragment implements BlockingStep {

    @BindView(R.id.ch_disease_incidences)
    CheckBox ch_disease_incidences;
    @BindView(R.id.etdisease_incidences_remarks)
    CustomEditText etdisease_incidences_remarks;

    @BindView(R.id.ch_pest_incidences)
    CheckBox ch_pest_incidences;
    @BindView(R.id.etpest_incidences_remarks)
    CustomEditText etpest_incidences_remarks;

    @BindView(R.id.ch_field_hygiene_conditions)
    CheckBox ch_field_hygiene_conditions;
    @BindView(R.id.etfield_hygiene_conditions_evidence)
    CustomEditText etfield_hygiene_conditions_evidence;
    @BindView(R.id.etfield_hygiene_conditions_remarks)
    CustomEditText etfield_hygiene_conditions_remarks;

    @BindView(R.id.ch_target_market)
    CheckBox ch_target_market;
    @BindView(R.id.ettarget_market_evidence)
    CustomEditText ettarget_market_evidence;
    @BindView(R.id.ettarget_market_remarks)
    CustomEditText ettarget_market_remarks;

    @BindView(R.id.ch_inspection_by)
    CheckBox ch_inspection_by;
    @BindView(R.id.etinspection_by_evidence)
    CustomEditText etinspection_by_evidence;
    @BindView(R.id.etinspection_by_remarks)
    CustomEditText etinspection_by_remarks;


    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    private String Savestring = "N";

    AFADatabaseAdapter db;

    AFA app;

    private PyrethrumInspectionViewModel pyrethrumInspectionViewModel;

    private String str_disease_incidences, str_pest_incidences, str_field_hygiene_conditions, str_target_market, str_inspection_by, str_recommendations;
    private String str_field_hygiene_conditions_evidence, str_target_market_evidence, str_inspection_by_evidence;
    private String str_disease_incidences_remarks, str_pest_incidences_remarks,str_field_hygiene_conditions_remarks, str_target_market_remarks, str_inspection_by_remarks;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();


    public AFAPyrethrumInspectionStep4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afapyrethrum_inspection_step4, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        pyrethrumInspectionViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(PyrethrumInspectionViewModel.class);

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

        ch_disease_incidences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_disease_incidences.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_disease_incidences =Savestring;

            }
        });

        ch_pest_incidences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_pest_incidences.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_pest_incidences =Savestring;

            }
        });

        ch_field_hygiene_conditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_field_hygiene_conditions.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_field_hygiene_conditions =Savestring;

            }
        });

        ch_target_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_target_market.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_target_market =Savestring;

            }
        });

        ch_inspection_by.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_inspection_by.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_inspection_by =Savestring;

            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        str_disease_incidences_remarks = Objects.requireNonNull(etdisease_incidences_remarks.getText()).toString().trim();
        str_pest_incidences_remarks = Objects.requireNonNull(etpest_incidences_remarks.getText()).toString().trim();
        str_field_hygiene_conditions_evidence = Objects.requireNonNull(etfield_hygiene_conditions_evidence.getText()).toString().trim();
        str_field_hygiene_conditions_remarks = Objects.requireNonNull(etfield_hygiene_conditions_remarks.getText()).toString().trim();
        str_target_market_evidence = Objects.requireNonNull(ettarget_market_evidence.getText()).toString().trim();
        str_target_market_remarks = Objects.requireNonNull(ettarget_market_remarks.getText()).toString().trim();
        str_inspection_by_evidence = Objects.requireNonNull(etinspection_by_evidence.getText()).toString().trim();
        str_inspection_by_remarks = Objects.requireNonNull(etinspection_by_remarks.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateFields(ch_disease_incidences, etdisease_incidences_remarks, str_disease_incidences_remarks) &
                validateFields(ch_pest_incidences, etpest_incidences_remarks, str_pest_incidences_remarks) &
                validateFields(ch_field_hygiene_conditions, etfield_hygiene_conditions_remarks, str_field_hygiene_conditions_remarks) &
                validateFields(ch_target_market, ettarget_market_remarks, str_target_market_remarks) &
                validateFields(ch_inspection_by, etinspection_by_remarks, str_inspection_by_remarks);


        PyrethrumInspectionBus pyrethrumInspectionBus = PyrethrumInspectionBus.getInstance();
        PyrethrumInspection pyrethrumInspection = new PyrethrumInspection(
                0,
                pyrethrumInspectionBus.getDocument_number(),
                pyrethrumInspectionBus.getDocument_date(),
                pyrethrumInspectionBus.getName_of_applicant(),
                pyrethrumInspectionBus.getCertificate_number(),
                pyrethrumInspectionBus.getTitle_deed(),
                pyrethrumInspectionBus.getTitle_deed_evidence(),
                pyrethrumInspectionBus.getTitle_deed_remarks(),
                pyrethrumInspectionBus.getTotal_acreage(),
                pyrethrumInspectionBus.getTotal_acreage_evidence(),
                pyrethrumInspectionBus.getTotal_acreage_remarks(),
                pyrethrumInspectionBus.getAcreage_available(),
                pyrethrumInspectionBus.getAcreage_available_evidence(),
                pyrethrumInspectionBus.getAcreage_available_remarks(),
                pyrethrumInspectionBus.getSuitability_of_the_land(),
                pyrethrumInspectionBus.getSuitability_of_the_land_evidence(),
                pyrethrumInspectionBus.getSuitability_of_the_land_remarks(),
                pyrethrumInspectionBus.getReliable_supply_clean_water(),
                pyrethrumInspectionBus.getReliable_supply_clean_water_evidence(),
                pyrethrumInspectionBus.getReliable_supply_clean_water_remarks(),
                pyrethrumInspectionBus.getAccessibility_of_nursery_site(),
                pyrethrumInspectionBus.getAccessibility_of_nursery_site_evidence(),
                pyrethrumInspectionBus.getAccessibility_of_nursery_site_remarks(),
                pyrethrumInspectionBus.getClearance_letter(),
                pyrethrumInspectionBus.getClearance_letter_evidence(),
                pyrethrumInspectionBus.getClearance_letter_remarks(),
                pyrethrumInspectionBus.getAdequate_knowledge(),
                pyrethrumInspectionBus.getDemonstrate_adequate_knowledge(),
                pyrethrumInspectionBus.getDemonstrate_adequate_knowledge_remarks(),
                pyrethrumInspectionBus.getAge_of_an_existing_crop(),
                pyrethrumInspectionBus.getAge_of_an_existing_crop_date_planted(),
                pyrethrumInspectionBus.getAge_of_an_existing_crop_remarks(),
                pyrethrumInspectionBus.getSource_of_planting_materials(),
                pyrethrumInspectionBus.getSource_of_planting_materials_evidence(),
                pyrethrumInspectionBus.getSource_of_planting_materials_remarks(),
                pyrethrumInspectionBus.getPhenotypic_characteristics(),
                pyrethrumInspectionBus.getPhenotypic_characteristics_evidence(),
                pyrethrumInspectionBus.getPhenotypic_characteristics_remarks(),
                str_disease_incidences,
                str_disease_incidences_remarks,
                str_pest_incidences,
                str_pest_incidences_remarks,
                str_field_hygiene_conditions,
                str_field_hygiene_conditions_evidence,
                str_field_hygiene_conditions_remarks,
                str_target_market,
                str_target_market_evidence,
                str_target_market_remarks,
                str_inspection_by,
                str_inspection_by_evidence,
                str_inspection_by_remarks,
                str_recommendations,
                pyrethrumInspectionBus.getLocalID(),
                recommendation,
                recommendationRemarks,
                false,
                ""
        );



        if (valid) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("TEAPACKER INSPECTION!")
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
                            pyrethrumInspectionViewModel.addPyrethrumInspectionRecord(pyrethrumInspection);

                            long pyrethrumInspectionID = db.updatePyrethrumInspectionChecklist(pyrethrumInspection);
                            System.out.print("pyrethrumInspectionID " + pyrethrumInspectionID);

                            sDialog.dismissWithAnimation();
                            Intent intent = new Intent(getActivity(), DashboardActivity.class);
                            startActivity(intent);
                        }
                    })
                    .show();
        }

    }
    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString){

        boolean result= false;

        if(!checkBox.isChecked()){
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                result = false;
            } else {
                result = true;
            }
        } else{
            customEditText.setError(null);
            result = true;
        }

        return result;
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
