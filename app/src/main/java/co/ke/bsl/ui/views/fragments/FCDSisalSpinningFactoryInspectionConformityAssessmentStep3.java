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
import co.ke.bsl.data.view.FCDSisalSpinningFactoryInspectionBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.SisalSpinningInspViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDSisalSpinningFactoryInspectionConformityAssessmentStep3 extends Fragment implements BlockingStep {
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

    private SisalSpinningInspViewModel sisalSpinningInspViewModel;

    private String isFireengines, iswater, isCarbondioxide, issand, isfoam, isHydrantsystem, isDrypowder, etFirefightingRemarks, comments, officeRecommendation, officeRecommendationRemarks;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdsisal_spinning_factory_inspection_conformity_assessment_step3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        setReccomendationsView(getReccomendationsView());

        sisalSpinningInspViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(SisalSpinningInspViewModel.class);


        ssReccomendation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ReccomendationsView rec = (ReccomendationsView) ssReccomendation.getSelectedItem();
                officeRecommendation = rec.getServerID();
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
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        etFirefightingRemarks = Objects.requireNonNull(etFireFightingRemarks.getText()).toString().trim();
        comments = Objects.requireNonNull(etComments.getText()).toString().trim();

        officeRecommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        //validation
        boolean valid = validateEditText(etFireFightingRemarks, etFirefightingRemarks);


        FCDSisalSpinningFactoryInspectionBus fCDSisalSpinningFactoryInspectionBus = FCDSisalSpinningFactoryInspectionBus.getInstance();

        FCDSisalSpinningFactoryInspection fCDSisalSpinningFactoryInspection = new FCDSisalSpinningFactoryInspection(

                0,
                fCDSisalSpinningFactoryInspectionBus.getDocumentNumber(),
                fCDSisalSpinningFactoryInspectionBus.getDocumentDate(),
                fCDSisalSpinningFactoryInspectionBus.getNameOfApplicant(),
                fCDSisalSpinningFactoryInspectionBus.getSisalSpinningExportNumber(),
                fCDSisalSpinningFactoryInspectionBus.getLocalID(),
                fCDSisalSpinningFactoryInspectionBus.getIsValidTradinglicence(),
                fCDSisalSpinningFactoryInspectionBus.getValidTradinglicenceRemarks(),
                fCDSisalSpinningFactoryInspectionBus.getIsValidNeMACerificaion(),
                fCDSisalSpinningFactoryInspectionBus.getValidNeMACerificaionRemarks(),
                fCDSisalSpinningFactoryInspectionBus.getIsFireriskAssessment(),
                fCDSisalSpinningFactoryInspectionBus.getFireriskAssessmentRemarks(),
                fCDSisalSpinningFactoryInspectionBus.getIsOccupationalhealthReport(),
                fCDSisalSpinningFactoryInspectionBus.getOccupationalhealthReportRemarks(),
                fCDSisalSpinningFactoryInspectionBus.getIsFiremarshalls(),
                fCDSisalSpinningFactoryInspectionBus.getFiremarshallsRemarks(),
                fCDSisalSpinningFactoryInspectionBus.getIsAccessiblefireemergencyexits(),
                fCDSisalSpinningFactoryInspectionBus.getAccessibleFireemergencyexitsRemarks(),
                fCDSisalSpinningFactoryInspectionBus.getIsFirstAidkit(),
                fCDSisalSpinningFactoryInspectionBus.getFirstAidkitRemarks(),
                fCDSisalSpinningFactoryInspectionBus.getIsAppropriateprotectiveclothing(),
                fCDSisalSpinningFactoryInspectionBus.getAppropriateprotectiveclothing(),
                fCDSisalSpinningFactoryInspectionBus.getIsProtectedmovingParts(),
                fCDSisalSpinningFactoryInspectionBus.getProtectedmovingParts(),
                fCDSisalSpinningFactoryInspectionBus.getIsGeneralcondition(),
                fCDSisalSpinningFactoryInspectionBus.getGeneralconditionRemarks(),
                fCDSisalSpinningFactoryInspectionBus.getIsStoragecondition(),
                fCDSisalSpinningFactoryInspectionBus.getStorageconditionRemarks(),
                fCDSisalSpinningFactoryInspectionBus.getIsProofofSubmission(),
                fCDSisalSpinningFactoryInspectionBus.getProofofSubmission(),
                fCDSisalSpinningFactoryInspectionBus.getIsCertificationbyAFA(),
                fCDSisalSpinningFactoryInspectionBus.getCertificationbyAFARemarks(),
                isFireengines,
                iswater,
                isCarbondioxide,
                issand,
                isfoam,
                isHydrantsystem,
                isDrypowder,
                etFirefightingRemarks,
                comments,
                officeRecommendation,
                officeRecommendationRemarks,
                false,
                ""
        );


        if (valid) {

             /* long result = db.UpdateFCDSisalSpinningFactoryInspection(fCDSisalSpinningFactoryInspection);
                sisalSpinningInspViewModel.addRecord(fCDSisalSpinningFactoryInspection);
                System.out.println("result is" + result);*/

                new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("SISAL SPINNING INSPECTION!")
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
                                long result = db.UpdateFCDSisalSpinningFactoryInspection(fCDSisalSpinningFactoryInspection);
                                sisalSpinningInspViewModel.addRecord(fCDSisalSpinningFactoryInspection);
                                System.out.println("result is" + result);

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
