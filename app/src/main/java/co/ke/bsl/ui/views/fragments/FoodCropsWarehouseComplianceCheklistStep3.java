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
import android.widget.TextView;
import android.widget.Toast;

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
import co.ke.bsl.data.model.FoodProcessing;
import co.ke.bsl.data.model.FoodWarehouse;
import co.ke.bsl.data.view.FoodProcessingBus;
import co.ke.bsl.data.view.FoodWareHouseBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.pojo.Country;
import co.ke.bsl.pojo.WholeSaleImportedSugar;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.FoodProcessingViewModel;
import co.ke.bsl.ui.viewmodels.FoodWareHouseViewmodel;
import co.ke.bsl.util.CustomEditText;

public class FoodCropsWarehouseComplianceCheklistStep3 extends Fragment implements BlockingStep {


    @BindView(R.id.isLoadingandoffloadingshelter)
    CheckBox isLoadingandoffloadingshelter;
    @BindView(R.id.etLoadingandoffloadingshelter_Remarks)
    CustomEditText etLoadingandoffloadingshelter_Remarks;

    @BindView(R.id.isGuardhouse)
    CheckBox isGuardhouse;
    @BindView(R.id.etGuardhouse_Remarks)
    CustomEditText etGuardhouse_Remarks;

    @BindView(R.id.isFireextinguishersmokedetectorsandalarmsystem)
    CheckBox isFireextinguishersmokedetectorsandalarmsystem;
    @BindView(R.id.etFireextinguishersmokedetectorsandalarmsystem_remarks)
    CustomEditText etFireextinguishersmokedetectorsandalarmsystem_remarks;

    @BindView(R.id.isGuardhouseandsecuritylights)
    CheckBox isGuardhouseandsecuritylights;
    @BindView(R.id.etGuardhouseandsecuritylights_remarks)
    CustomEditText etGuardhouseandsecuritylights_remarks;

    @BindView(R.id.isWeighbridgesandweighingscales)
    CheckBox isWeighbridgesandweighingscales;
    @BindView(R.id.etWeighbridgesandweighingscales_remarks)
    CustomEditText etWeighbridgesandweighingscales_remarks;

    @BindView(R.id.isOfficesworkingtelephonesandinternetaccess)
    CheckBox isOfficesworkingtelephonesandinternetaccess;
    @BindView(R.id.etOfficesworkingtelephonesandinternetaccess_remarks)
    CustomEditText etOfficesworkingtelephonesandinternetaccess_remarks;

    @BindView(R.id.isProvisionofWASHfacilities)
    CheckBox isProvisionofWASHfacilities;
    @BindView(R.id.etProvisionofWASHfacilities_remarks)
    CustomEditText etProvisionofWASHfacilities_remarks;

    @BindView(R.id.isBooksofaccounts)
    CheckBox isBooksofaccounts;
    @BindView(R.id.etBooksofaccounts_remarks)
    CustomEditText etBooksofaccounts_remarks;

    @BindView(R.id.isRecallandtraceabilityprocedures)
    CheckBox isRecallandtraceabilityprocedures;
    @BindView(R.id.etRecallandtraceabilityprocedures_remarks)
    CustomEditText etRecallandtraceabilityprocedures_remarks;

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

    private FoodWareHouseViewmodel foodWareHouseViewmodel;

    AFA app;

    private String isLoadingandoffLoadingshelter, loadingandoffloadingshelter_Remarks, isGuardHouse, guardhouse_Remarks;
    private String isFireextinguishersmokedetectorsandAlarmsystem, fireextinguishersmokedetectorsandalarmsystem_remarks;
    private String isGuardhouseandsecurityLights, guardhouseandsecuritylights_remarks, isWeighbridgesandweighingScales, weighbridgesandweighingscales_remarks;
    private String isOfficesworkingtelephonesandinternetacces, officesworkingtelephonesandinternetaccess_remarks, isProvisionofWASHfacilitie, provisionofWASHfacilities_remarks;
    private String isBooksofaccount, booksofaccounts_remarks, isRecallandtraceabilityprocedure, recallandtraceabilityprocedures_remarks;
    private String ssRecomendation, reasonForThegiveReccomm;


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.food_crop_warehouse_fragment3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        foodWareHouseViewmodel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(FoodWareHouseViewmodel.class);

        setReccomendationsView(getReccomendationsView());

        ssReccomendation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ReccomendationsView rec = (ReccomendationsView) ssReccomendation.getSelectedItem();
                ssRecomendation = rec.getServerID();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                return;

            }
        });

        isLoadingandoffloadingshelter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLoadingandoffloadingshelter.isChecked()) {
                    isLoadingandoffLoadingshelter = "Y";
                } else {
                    isLoadingandoffLoadingshelter = "N";
                }

            }
        });

        isGuardhouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isGuardhouse.isChecked()) {
                    isGuardHouse = "Y";

                } else {
                    isGuardHouse = "N";
                }
            }
        });

        isFireextinguishersmokedetectorsandalarmsystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFireextinguishersmokedetectorsandalarmsystem.isChecked()) {
                    isFireextinguishersmokedetectorsandAlarmsystem = "Y";
                } else {
                    isFireextinguishersmokedetectorsandAlarmsystem = "N";
                }

            }
        });

        isGuardhouseandsecuritylights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isGuardhouseandsecuritylights.isChecked()) {
                    isGuardhouseandsecurityLights = "Y";
                } else {
                    isGuardhouseandsecurityLights = "N";
                }

            }
        });

        isWeighbridgesandweighingscales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWeighbridgesandweighingscales.isChecked()) {
                    isWeighbridgesandweighingScales = "Y";
                } else {
                    isWeighbridgesandweighingScales = "N";
                }
            }
        });

        isOfficesworkingtelephonesandinternetaccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOfficesworkingtelephonesandinternetaccess.isChecked()) {
                    isOfficesworkingtelephonesandinternetacces = "Y";
                } else {
                    isOfficesworkingtelephonesandinternetacces = "N";
                }

            }

        });



        isProvisionofWASHfacilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProvisionofWASHfacilities.isChecked()) {
                    isProvisionofWASHfacilitie = "Y";
                } else {
                    isProvisionofWASHfacilitie = "N";
                }

            }
        });

        isBooksofaccounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBooksofaccounts.isChecked()) {
                    isBooksofaccount = "Y";
                } else {
                    isBooksofaccount = "N";
                }

            }
        });
        isRecallandtraceabilityprocedures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRecallandtraceabilityprocedures.isChecked()) {
                    isRecallandtraceabilityprocedure = "Y";
                } else {
                    isRecallandtraceabilityprocedure = "N";
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

        loadingandoffloadingshelter_Remarks = Objects.requireNonNull(etLoadingandoffloadingshelter_Remarks.getText()).toString().trim();
        guardhouse_Remarks = Objects.requireNonNull(etGuardhouse_Remarks.getText()).toString().trim();
        fireextinguishersmokedetectorsandalarmsystem_remarks = Objects.requireNonNull(etFireextinguishersmokedetectorsandalarmsystem_remarks.getText()).toString().trim();
        guardhouseandsecuritylights_remarks = Objects.requireNonNull(etGuardhouseandsecuritylights_remarks.getText().toString());
        weighbridgesandweighingscales_remarks = Objects.requireNonNull(etWeighbridgesandweighingscales_remarks.getText()).toString().trim();
        officesworkingtelephonesandinternetaccess_remarks = Objects.requireNonNull(etOfficesworkingtelephonesandinternetaccess_remarks.getText().toString());
        provisionofWASHfacilities_remarks = Objects.requireNonNull(etProvisionofWASHfacilities_remarks.getText()).toString().trim();
        booksofaccounts_remarks = Objects.requireNonNull(etBooksofaccounts_remarks.getText().toString());
        recallandtraceabilityprocedures_remarks = Objects.requireNonNull(etRecallandtraceabilityprocedures_remarks.getText()).toString().trim();
        reasonForThegiveReccomm = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();



        boolean valid = validateFields(isLoadingandoffloadingshelter, etLoadingandoffloadingshelter_Remarks, loadingandoffloadingshelter_Remarks) &
                validateFields(isGuardhouse, etGuardhouse_Remarks, guardhouse_Remarks) &
                validateFields(isFireextinguishersmokedetectorsandalarmsystem, etFireextinguishersmokedetectorsandalarmsystem_remarks, fireextinguishersmokedetectorsandalarmsystem_remarks) &
                validateFields(isGuardhouseandsecuritylights, etGuardhouseandsecuritylights_remarks, guardhouseandsecuritylights_remarks) &
                validateFields(isWeighbridgesandweighingscales, etWeighbridgesandweighingscales_remarks, weighbridgesandweighingscales_remarks) &
                validateFields(isOfficesworkingtelephonesandinternetaccess, etOfficesworkingtelephonesandinternetaccess_remarks, officesworkingtelephonesandinternetaccess_remarks) &
                validateFields(isProvisionofWASHfacilities, etProvisionofWASHfacilities_remarks, provisionofWASHfacilities_remarks) &
                validateFields(isBooksofaccounts, etBooksofaccounts_remarks, booksofaccounts_remarks) &
                validateFields(isRecallandtraceabilityprocedures, etRecallandtraceabilityprocedures_remarks, recallandtraceabilityprocedures_remarks)&
                validateEditText(etReasonForThegiveReccomm, reasonForThegiveReccomm);

        boolean validspinner = validateSpinner(ssReccomendation, ssRecomendation);


        FoodWareHouseBus foodWareHouseBus = FoodWareHouseBus.getInstance();
        FoodWarehouse foodWarehouse = new FoodWarehouse(
                0,
                foodWareHouseBus.getDocumentNumber(),
                foodWareHouseBus.getDocumentDate(),
                foodWareHouseBus.getNameOfApplicant(),
                foodWareHouseBus.getFoodWarehouselicence(),
                foodWareHouseBus.getLocalID(),
                foodWareHouseBus.getSsleaseagreement(),
                foodWareHouseBus.getIsGraincleaningfacility(),
                foodWareHouseBus.getGraincleaningfacility_Remarks(),
                foodWareHouseBus.getIsLoadingCapacity(),
                foodWareHouseBus.getLoadingCapacity_Remarks(),
                foodWareHouseBus.getIsdrier(),
                foodWareHouseBus.getDrier_remarks(),
                foodWareHouseBus.getIslabroom(),
                foodWareHouseBus.getLabroom_Remarks(),
                foodWareHouseBus.getIsWallandVentilation(),
                foodWareHouseBus.getWallandVentilation_Remarks(),
                foodWareHouseBus.getIsWaterproofProvisions(),
                foodWareHouseBus.getWaterproofProvisions_Remarks(),
                foodWareHouseBus.getIsInternalSupport(),
                foodWareHouseBus.getInternalSupport_Remarks(),
                foodWareHouseBus.getIsContinuousConcretefloor(),
                foodWareHouseBus.getContinuousconcretefloor_Remarks(),
                foodWareHouseBus.getIsCorrugatedgalvanizedRoof(),
                foodWareHouseBus.getCorrugatedgalvanizedroof_Remarks(),
                foodWareHouseBus.getIsTheNohighGaugesteeldoors(),
                foodWareHouseBus.getTheNohighgaugesteeldoors_Remarks(),
                foodWareHouseBus.getIsHygieneAndcleanliness(),
                foodWareHouseBus.getHygieneAndCleanliness_Remarks(),
                foodWareHouseBus.getIsPerimeterwallandtruckaccessPavement(),
                foodWareHouseBus.getPerimeterwallandtruckaccesspavement_Remarks(),
                isLoadingandoffLoadingshelter,
                loadingandoffloadingshelter_Remarks,
                isGuardHouse,
                guardhouse_Remarks,
                isFireextinguishersmokedetectorsandAlarmsystem,
                fireextinguishersmokedetectorsandalarmsystem_remarks,
                isGuardhouseandsecurityLights,
                guardhouseandsecuritylights_remarks,
                isWeighbridgesandweighingScales,
                weighbridgesandweighingscales_remarks,
                isOfficesworkingtelephonesandinternetacces,
                officesworkingtelephonesandinternetaccess_remarks,
                isProvisionofWASHfacilitie,
                provisionofWASHfacilities_remarks,
                isBooksofaccount,
                booksofaccounts_remarks,
                isRecallandtraceabilityprocedure,
                recallandtraceabilityprocedures_remarks,
                ssRecomendation,
                reasonForThegiveReccomm,
                false,
                ""
        );

        if (valid & validspinner) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("Food WareHouse Inspection!")
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

                            db.UpdateFoodWareHouseInspection(foodWarehouse);
                            foodWareHouseViewmodel.addRecord(foodWarehouse);

                            sDialog.dismissWithAnimation();
                            Intent intent = new Intent(getActivity(), DashboardActivity.class);
                            startActivity(intent);
                        }
                    })
                    .show();


       }


    }

    private boolean validateSpinner(SearchableSpinner searchableSpinner, String searchableSpinnerString){

        boolean resultSpinner = false;

        if ("".equals(searchableSpinnerString))
        {
            TextView errorText = (TextView) searchableSpinner.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            resultSpinner = false;
        }
        else
            {
            resultSpinner = true;
        }
        return (resultSpinner);
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

    private void setReccomendationsView(List<ReccomendationsView> getReccomendationsView) {
        //reccomendationsViewList.add("- Required -");
        for (ReccomendationsView regionWrapper : getReccomendationsView) {
            reccomendationsViewList.add(regionWrapper);
        }
        ArrayAdapter<ReccomendationsView> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, reccomendationsViewList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssReccomendation.setAdapter(regionAdapter);


    }

    private List<ReccomendationsView> getReccomendationsView() {
        List<ReccomendationsView> listViewItems = new ArrayList<>();
        listViewItems.add(new ReccomendationsView("- Select -", " "));
        listViewItems.add(new ReccomendationsView("I Recommend", "10000245"));
        listViewItems.add(new ReccomendationsView("I Do Not Recommend", "10000246"));

        return listViewItems;
    }
}
