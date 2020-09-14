package co.ke.bsl.ui.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

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
import co.ke.bsl.data.model.FCDSisalSpinningFactoryInspection;
import co.ke.bsl.data.model.FoodProcessing;
import co.ke.bsl.data.model.SugarMillLicence;
import co.ke.bsl.data.view.FCDSisalSpinningFactoryInspectionBus;
import co.ke.bsl.data.view.FoodProcessingBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.data.view.SugarMillLicenceBus;
import co.ke.bsl.pojo.Country;
import co.ke.bsl.pojo.WholeSaleImportedSugar;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.FoodProcessingViewModel;
import co.ke.bsl.ui.viewmodels.SisalSpinningInspViewModel;
import co.ke.bsl.ui.viewmodels.SugarMillLicenceViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

public class FoodProcessingInspectionChecklistStep2 extends Fragment implements BlockingStep {


    @BindView(R.id.etsuppliers_source_raw_materials)
    CustomEditText etsuppliers_source_raw_materials;
    @BindView(R.id.etInstalledCapacity)
    CustomEditText etInstalledCapacity;

    @BindView(R.id.isLocationDesignConstructionStandards)
    CheckBox isLocationDesignConstructionStandards;
    @BindView(R.id.etLocationDesignConstructionStandards_remarks)
    CustomEditText etLocationDesignConstructionStandards_remarks;

    @BindView(R.id.isProceduresforensuringpersonalhygieneareinplace)
    CheckBox isProceduresforensuringpersonalhygieneareinplace;
    @BindView(R.id.etProceduresforensuringpersonalhygieneareinplace_remarks)
    CustomEditText etProceduresforensuringpersonalhygieneareinplace_remarks;

    @BindView(R.id.isProceduresforreceivinghandlingandstorageareinplace)
    CheckBox isProceduresforreceivinghandlingandstorageareinplace;
    @BindView(R.id.etProceduresforreceivinghandlingandstorageareinplace_remarks)
    CustomEditText etProceduresforreceivinghandlingandstorageareinplace_remarks;

    @BindView(R.id.isMonitoringproceduresforpestcontroloftheareinplace)
    CheckBox isMonitoringproceduresforpestcontroloftheareinplace;
    @BindView(R.id.etMonitoringproceduresforpestcontroloftheareinplace_remarks)
    CustomEditText etMonitoringproceduresforpestcontroloftheareinplace_remarks;

    @BindView(R.id.isCleaningandsanitizingproceduresinplace)
    CheckBox isCleaningandsanitizingproceduresinplace;
    @BindView(R.id.etCleaningandsanitizingproceduresinplace_remarks)
    CustomEditText etCleaningandsanitizingproceduresinplace_remarks;

    @BindView(R.id.isProceduresdescribingpreventivemaintenanceandcalibration)
    CheckBox isProceduresdescribingpreventivemaintenanceandcalibration;
    @BindView(R.id.etProceduresdescribingpreventivemaintenanceandcalibration_remarks)
    CustomEditText etProceduresdescribingpreventivemaintenanceandcalibration_remarks;

    @BindView(R.id.isRecallandtraceabilityprocedures)
    CheckBox isRecallandtraceabilityprocedures;
    @BindView(R.id.etRecallandtraceabilityprocedures_remarks)
    CustomEditText etRecallandtraceabilityprocedures_remarks;

    @BindView(R.id.isWaterSafetyMonitoringProcedures)
    CheckBox isWaterSafetyMonitoringProcedures;
    @BindView(R.id.etWaterSafetyMonitoringProcedures_remarks)
    CustomEditText etWaterSafetyMonitoringProcedures_remarks;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;


    protected Handler asyncTaskHandler;
    private AsyncActivitySupport asyncSupport;
    protected List<Country> countries;
    List<WholeSaleImportedSugar> wholeSaleImportedSugarList;
    AFADatabaseAdapter db;


    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();

    private FoodProcessingViewModel foodProcessingViewModel;

    AFA app;

    private String suppliers_source_raw_materials, installedCapacity, isLocationDesignconstructionStandards, locationDesignConstructionStandards_remarks;
    private String isProceduresforensuringPersonalhygieneareinplace,proceduresforensuringpersonalhygieneareinplace_remarks,isProceduresforReceivinghandlingandstorageareinplace,proceduresforreceivinghandlingandstorageareinplace_remarks;
    private String isMonitoringproceduresforPestcontroloftheareinplace, monitoringproceduresforpestcontroloftheareinplace_remarks, isCleaningandsanitizingProceduresinplace, cleaningandsanitizingproceduresinplace_remarks;
    private String isProceduresdescribingPreventivemaintenanceandcalibration,proceduresdescribingpreventivemaintenanceandcalibration_remarks,isRecallandTraceabilityprocedures,recallandtraceabilityprocedures_remarks;
    private String isWaterSafetymonitoringProcedures,waterSafetyMonitoringProcedures_remarks,recommendation, recommendationRemarks;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_food_processing_inspection_checklist_step2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        foodProcessingViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(FoodProcessingViewModel.class);

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

        isLocationDesignConstructionStandards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLocationDesignConstructionStandards.isChecked()) {
                    isLocationDesignconstructionStandards = "Y";
                } else {
                    isLocationDesignconstructionStandards = "N";
                }

            }
        });

        isProceduresforensuringpersonalhygieneareinplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProceduresforensuringpersonalhygieneareinplace.isChecked()) {
                    isProceduresforensuringPersonalhygieneareinplace = "Y";

                } else {
                    isProceduresforensuringPersonalhygieneareinplace = "N";
                }
            }
        });

        isProceduresforreceivinghandlingandstorageareinplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProceduresforreceivinghandlingandstorageareinplace.isChecked()) {
                    isProceduresforReceivinghandlingandstorageareinplace = "Y";
                } else {
                    isProceduresforReceivinghandlingandstorageareinplace = "N";
                }

            }
        });

        isMonitoringproceduresforpestcontroloftheareinplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMonitoringproceduresforpestcontroloftheareinplace.isChecked()) {
                    isMonitoringproceduresforPestcontroloftheareinplace = "Y";
                } else {
                    isMonitoringproceduresforPestcontroloftheareinplace = "N";
                }

            }
        });

        isCleaningandsanitizingproceduresinplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCleaningandsanitizingproceduresinplace.isChecked()) {
                    isCleaningandsanitizingProceduresinplace = "Y";
                } else {
                    isCleaningandsanitizingProceduresinplace = "N";
                }
            }
        });

        isProceduresdescribingpreventivemaintenanceandcalibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProceduresdescribingpreventivemaintenanceandcalibration.isChecked()) {
                    isProceduresdescribingPreventivemaintenanceandcalibration = "Y";
                } else {
                    isProceduresdescribingPreventivemaintenanceandcalibration = "N";
                }

            }

        });


        isRecallandtraceabilityprocedures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRecallandtraceabilityprocedures.isChecked()) {
                    isRecallandTraceabilityprocedures = "Y";
                } else {
                    isRecallandTraceabilityprocedures = "N";
                }
            }


        });

        isWaterSafetyMonitoringProcedures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWaterSafetyMonitoringProcedures.isChecked()) {
                    isWaterSafetymonitoringProcedures = "Y";
                } else {
                    isWaterSafetymonitoringProcedures = "N";
                }

            }
        });



        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        suppliers_source_raw_materials = Objects.requireNonNull(etsuppliers_source_raw_materials.getText()).toString().trim();
        installedCapacity = Objects.requireNonNull(etInstalledCapacity.getText()).toString().trim();
        locationDesignConstructionStandards_remarks = Objects.requireNonNull(etLocationDesignConstructionStandards_remarks.getText()).toString().trim();
        proceduresforensuringpersonalhygieneareinplace_remarks = Objects.requireNonNull(etProceduresforensuringpersonalhygieneareinplace_remarks.getText().toString());
        proceduresforreceivinghandlingandstorageareinplace_remarks = Objects.requireNonNull(etProceduresforreceivinghandlingandstorageareinplace_remarks.getText()).toString().trim();
        monitoringproceduresforpestcontroloftheareinplace_remarks = Objects.requireNonNull(etMonitoringproceduresforpestcontroloftheareinplace_remarks.getText().toString());
        cleaningandsanitizingproceduresinplace_remarks = Objects.requireNonNull(etCleaningandsanitizingproceduresinplace_remarks.getText()).toString().trim();
        proceduresdescribingpreventivemaintenanceandcalibration_remarks = Objects.requireNonNull(etProceduresdescribingpreventivemaintenanceandcalibration_remarks.getText().toString());
        recallandtraceabilityprocedures_remarks = Objects.requireNonNull(etRecallandtraceabilityprocedures_remarks.getText()).toString().trim();
        waterSafetyMonitoringProcedures_remarks = Objects.requireNonNull(etWaterSafetyMonitoringProcedures_remarks.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateEditText(etsuppliers_source_raw_materials, suppliers_source_raw_materials) &
                validateEditText(etInstalledCapacity, installedCapacity) &
                validateFields(isLocationDesignConstructionStandards, etLocationDesignConstructionStandards_remarks, locationDesignConstructionStandards_remarks) &
                validateFields(isProceduresforensuringpersonalhygieneareinplace, etProceduresforensuringpersonalhygieneareinplace_remarks, proceduresforensuringpersonalhygieneareinplace_remarks) &
                validateFields(isProceduresforreceivinghandlingandstorageareinplace, etProceduresforreceivinghandlingandstorageareinplace_remarks, proceduresforreceivinghandlingandstorageareinplace_remarks) &
                validateFields(isMonitoringproceduresforpestcontroloftheareinplace, etMonitoringproceduresforpestcontroloftheareinplace_remarks, monitoringproceduresforpestcontroloftheareinplace_remarks) &
                validateFields(isCleaningandsanitizingproceduresinplace, etCleaningandsanitizingproceduresinplace_remarks, cleaningandsanitizingproceduresinplace_remarks) &
                validateFields(isProceduresdescribingpreventivemaintenanceandcalibration, etProceduresdescribingpreventivemaintenanceandcalibration_remarks, proceduresdescribingpreventivemaintenanceandcalibration_remarks) &
                validateFields(isRecallandtraceabilityprocedures, etRecallandtraceabilityprocedures_remarks, recallandtraceabilityprocedures_remarks) &
                validateFields(isWaterSafetyMonitoringProcedures, etWaterSafetyMonitoringProcedures_remarks, waterSafetyMonitoringProcedures_remarks) &
                validateEditText(etReasonForThegiveReccomm, recommendationRemarks);
        FoodProcessingBus foodProcessingBus = FoodProcessingBus.getInstance();
        FoodProcessing foodProcessing = new FoodProcessing(
                0,
                foodProcessingBus.getDocumentNumber(),
                foodProcessingBus.getDocumentDate(),
                foodProcessingBus.getNameOfApplicant(),
                foodProcessingBus.getFoodCropManufacturingPlanApproval(),
                foodProcessingBus.getLocalID(),
                suppliers_source_raw_materials,
                installedCapacity,
                isLocationDesignconstructionStandards,
                locationDesignConstructionStandards_remarks,
                isProceduresforensuringPersonalhygieneareinplace,
                proceduresforensuringpersonalhygieneareinplace_remarks,
                isProceduresforReceivinghandlingandstorageareinplace,
                proceduresforreceivinghandlingandstorageareinplace_remarks,
                isMonitoringproceduresforPestcontroloftheareinplace,
                monitoringproceduresforpestcontroloftheareinplace_remarks,
                isCleaningandsanitizingProceduresinplace,
                cleaningandsanitizingproceduresinplace_remarks,
                isProceduresdescribingPreventivemaintenanceandcalibration,
                proceduresdescribingpreventivemaintenanceandcalibration_remarks,
                isRecallandTraceabilityprocedures,
                recallandtraceabilityprocedures_remarks,
                isWaterSafetymonitoringProcedures,
                waterSafetyMonitoringProcedures_remarks,
                recommendation,
                recommendationRemarks,
                false,
                ""
        );

        if (valid) {


            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("Food Processing Inspection!")
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

                            db.UpdatefoodProcessingInpection(foodProcessing);
                            foodProcessingViewModel.addRecord(foodProcessing);

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

    private boolean validateEditText(CustomEditText customEditText, String customEditTextString) {

        boolean result = false;

        if (TextUtils.isEmpty(customEditTextString)) {
            customEditText.setError("Field Required ");
            result = false;
        } else {
            customEditText.setError(null);
            result = true;
        }

        return result;
    }

    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString) {

        boolean result = false;

        if (!checkBox.isChecked()) {
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                result = false;
            } else result = true;
        } else {
            customEditText.setError(null);
            result = true;
        }

        return result;
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
        listViewItems.add(new ReccomendationsView("-Select-", " "));
        listViewItems.add(new ReccomendationsView("I Recommend", "10000245"));
        listViewItems.add(new ReccomendationsView("I Do Not Recommend", "10000246"));

        return listViewItems;
    }
}
