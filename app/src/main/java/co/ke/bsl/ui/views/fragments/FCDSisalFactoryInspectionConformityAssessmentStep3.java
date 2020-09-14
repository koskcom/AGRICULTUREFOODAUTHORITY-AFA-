package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Handler;
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
import co.ke.bsl.data.model.FCDSisalFactoryInspection;
import co.ke.bsl.data.view.FCDSisalFactoryInspectionBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.SisalFactoryViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDSisalFactoryInspectionConformityAssessmentStep3 extends Fragment implements BlockingStep {


    @BindView(R.id.isFireEngines)
    CheckBox isFireEngines;
    @BindView(R.id.isWater)
    CheckBox isWater;
    @BindView(R.id.isCarbonDioxide)
    CheckBox isCarbonDioxide;
    @BindView(R.id.isSand)
    CheckBox isSand;
    @BindView(R.id.isFoam)
    CheckBox isFoam;
    @BindView(R.id.isHydrantSystem)
    CheckBox isHydrantSystem;
    @BindView(R.id.isDryPowder)
    CheckBox isDryPowder;
    @BindView(R.id.etFireFightingRemarks)
    CustomEditText etFireFightingRemarks;
    @BindView(R.id.etComments)
    CustomEditText etComments;
    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    private String isFireengines, iswater, isCarbondioxide, issand, isfoam, isHydrantsystem, isDrypowder, etFirefightingRemarks, comments;

    private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();
    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private SisalFactoryViewModel sisalFactoryViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdsisal_factory_inspection_conformity_assessment_step3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        sisalFactoryViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(SisalFactoryViewModel.class);

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


        isFireEngines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFireEngines.isChecked()) {
                    isFireengines = "Y";
                } else {
                    isFireengines = "N";
                }

            }
        });
        isWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWater.isChecked()) {
                    iswater = "Y";
                } else {
                    iswater = "N";
                }

            }
        });
        isCarbonDioxide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCarbonDioxide.isChecked()) {
                    isCarbondioxide = "Y";
                } else {
                    isCarbondioxide = "N";
                }

            }
        });
        isSand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSand.isChecked()) {
                    issand = "Y";
                } else {
                    issand = "N";
                }

            }
        });
        isFoam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFoam.isChecked()) {
                    isfoam = "Y";
                } else {
                    isfoam = "N";
                }

            }
        });
        isHydrantSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHydrantSystem.isChecked()) {
                    isHydrantsystem = "Y";
                } else {
                    isHydrantsystem = "N";
                }

            }
        });
        isDryPowder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDryPowder.isChecked()) {
                    isDrypowder = "Y";
                } else {
                    isDrypowder = "N";
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
        etFirefightingRemarks = Objects.requireNonNull(etFireFightingRemarks.getText()).toString().trim();
        comments = Objects.requireNonNull(etComments.getText()).toString().trim();

        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        //validation
        boolean valid = validateEditText(etFireFightingRemarks, etFirefightingRemarks);

        FCDSisalFactoryInspectionBus fCDSisalFactoryInspectionBus = FCDSisalFactoryInspectionBus.getInstance();

        FCDSisalFactoryInspection fCDSisalFactoryInspection = new FCDSisalFactoryInspection(
                0,
                fCDSisalFactoryInspectionBus.getDocumentNumber(),
                fCDSisalFactoryInspectionBus.getDocumentDate(),
                fCDSisalFactoryInspectionBus.getNameOfApplicant(),
                fCDSisalFactoryInspectionBus.getSisalSpinningExportNumber(),
                fCDSisalFactoryInspectionBus.getLocalID(),
                fCDSisalFactoryInspectionBus.getIsValidTradinglicence(),
                fCDSisalFactoryInspectionBus.getValidTradinglicenceRemarks(),
                fCDSisalFactoryInspectionBus.getIsValidNeMACerificaion(),
                fCDSisalFactoryInspectionBus.getValidNeMACerificaionRemarks(),
                fCDSisalFactoryInspectionBus.getIsFireriskAssessment(),
                fCDSisalFactoryInspectionBus.getFireriskAssessmentRemarks(),
                fCDSisalFactoryInspectionBus.getIsOccupationalhealthReport(),
                fCDSisalFactoryInspectionBus.getOccupationalhealthReportRemarks(),
                fCDSisalFactoryInspectionBus.getIsFiremarshalls(),
                fCDSisalFactoryInspectionBus.getFiremarshallsRemarks(),
                fCDSisalFactoryInspectionBus.getIsAccessiblefireemergencyexits(),
                fCDSisalFactoryInspectionBus.getAccessibleFireemergencyexitsRemarks(),
                fCDSisalFactoryInspectionBus.getIsFirstAidkit(),
                fCDSisalFactoryInspectionBus.getFirstAidkitRemarks(),
                fCDSisalFactoryInspectionBus.getIsAppropriateprotectiveclothing(),
                fCDSisalFactoryInspectionBus.getAppropriateprotectiveclothing(),
                fCDSisalFactoryInspectionBus.getIsProtectedmovingParts(),
                fCDSisalFactoryInspectionBus.getProtectedmovingParts(),
                fCDSisalFactoryInspectionBus.getIsGeneralcondition(),
                fCDSisalFactoryInspectionBus.getGeneralconditionRemarks(),
                fCDSisalFactoryInspectionBus.getIsStoragecondition(),
                fCDSisalFactoryInspectionBus.getStorageconditionRemarks(),
                fCDSisalFactoryInspectionBus.getIsProofofSubmission(),
                fCDSisalFactoryInspectionBus.getProofofSubmission(),
                fCDSisalFactoryInspectionBus.getIsCertificationbyAFA(),
                fCDSisalFactoryInspectionBus.getCertificationbyAFARemarks(),
                isFireengines,
                iswater,
                isCarbondioxide,
                issand,
                isfoam,
                isHydrantsystem,
                isDrypowder,
                etFirefightingRemarks,
                comments,
                recommendation,
                recommendationRemarks,
                false,
                ""


        );

        if (valid) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("SISAL FACTORY INSPECTION!")
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


                            long result = db.UpdateSisalFactoryInspection(fCDSisalFactoryInspection);
                            System.out.println("result is" + result);
                            sisalFactoryViewModel.addRecord(fCDSisalFactoryInspection);

                            sDialog.dismissWithAnimation();
                            Intent intent = new Intent(getActivity(), DashboardActivity.class);
                            startActivity(intent);
                        }
                    })
                    .show();

        }

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

    private void setReccomendationsView(List<ReccomendationsView> getReccomendationsView) {

        for (ReccomendationsView regionWrapper : getReccomendationsView) {
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
