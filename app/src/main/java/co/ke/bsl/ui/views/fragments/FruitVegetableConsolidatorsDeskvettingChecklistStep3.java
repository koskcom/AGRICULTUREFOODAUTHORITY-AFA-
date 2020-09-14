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
import android.widget.Spinner;
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
import co.ke.bsl.data.model.FruitVegetableConsolidators;
import co.ke.bsl.data.view.FruitVegetableConsolidatorsBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.data.view.View10Marks;
import co.ke.bsl.data.view.View15Marks;
import co.ke.bsl.data.view.View5Marks;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.FruitsAndVegetablesConsolidatorsViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FruitVegetableConsolidatorsDeskvettingChecklistStep3 extends Fragment implements BlockingStep {

    @BindView(R.id.isSystemPoliceAndProcedure)
    CheckBox isSystemPoliceAndProcedure;
    @BindView(R.id.ssSystemPoliceAndProcedureAward)
    SearchableSpinner ssSystemPoliceAndProcedureAward;
    @BindView(R.id.etSystemPoliceAndProcedureTimeline)
    CustomEditText etSystemPoliceAndProcedureTimeline;
    @BindView(R.id.etSystemPoliceAndProcedureRemarks)
    CustomEditText etSystemPoliceAndProcedureRemarks;

    @BindView(R.id.isEvidenceOfAtendanceOfAnnualTraining)
    CheckBox isEvidenceOfAtendanceOfAnnualTraining;
    @BindView(R.id.ssEvidenceOfAtendanceOfAnnualTrainingAward)
    SearchableSpinner ssEvidenceOfAtendanceOfAnnualTrainingAward;
    @BindView(R.id.etEvidenceOfAtendanceOfAnnualTrainingTimeline)
    CustomEditText etEvidenceOfAtendanceOfAnnualTrainingTimeline;
    @BindView(R.id.etEvidenceOfAtendanceOfAnnualTrainingRemarks)
    CustomEditText etEvidenceOfAtendanceOfAnnualTrainingRemarks;

    @BindView(R.id.isAnnualTrainingMatrixSchedule)
    CheckBox isAnnualTrainingMatrixSchedule;
    @BindView(R.id.ssAnnualTrainingMatrixScheduleAward)
    SearchableSpinner ssAnnualTrainingMatrixScheduleAward;
    @BindView(R.id.etAnnualTrainingMatrixScheduleTimeline)
    CustomEditText etAnnualTrainingMatrixScheduleTimeline;
    @BindView(R.id.etAnnualTrainingMatrixScheduleRemarks)
    CustomEditText etAnnualTrainingMatrixScheduleRemarks;

    @BindView(R.id.isPestDiseaseControlProcedures)
    CheckBox isPestDiseaseControlProcedures;
    @BindView(R.id.ssPestDiseaseControlProceduresAward)
    SearchableSpinner ssPestDiseaseControlProceduresAward;
    @BindView(R.id.etPestDiseaseControlProceduresTimeline)
    CustomEditText etPestDiseaseControlProceduresTimeline;
    @BindView(R.id.etPestDiseaseControlProceduresRemarks)
    CustomEditText etPestDiseaseControlProceduresRemarks;

    @BindView(R.id.isClaimsOnNonPayment)
    CheckBox isClaimsOnNonPayment;
    @BindView(R.id.ssClaimsOnNonPaymentAward)
    SearchableSpinner ssClaimsOnNonPaymentAward;
    @BindView(R.id.etClaimsOnNonPaymentTimeline)
    CustomEditText etClaimsOnNonPaymentTimeline;
    @BindView(R.id.etClaimsOnNonPaymentRemarks)
    CustomEditText etClaimsOnNonPaymentRemarks;
    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private FruitsAndVegetablesConsolidatorsViewModel fruitsAndVegetablesConsolidatorsViewModel;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();


    private String isSystemPoliceandProcedure, ssSystemPoliceandProcedureAward, systemPoliceandProcedureTimeline, systemPoliceandProcedureRemarks;
    private String isEvidenceOfatendanceOfAnnualTraining, ssEvidenceOfatendanceOfAnnualTrainingAward, evidenceOfatendanceOfAnnualTraininAwardTimeline, evidenceOfatendanceOfAnnualTrainingRemarks;
    private String isAnnualTrainingmatrixSchedule, ssAnnualTrainingmatrixScheduleAward, annualTrainingmatrixScheduleTimeline, annualTrainingmatrixScheduleRemarks;
    private String isPestDiseasecontrolProcedures, ssPestDiseasecontrolProceduresAward, pestDiseasecontrolProceduresTimeline, pestDiseasecontrolProceduresRemarks;
    private String isClaimsOnnonPayment, ssClaimsOnnonPaymentAward, claimsOnnonPaymentTimeline, claimsOnnonPaymentRemarks;

    private ArrayList<String> marksof10List = new ArrayList<>();
    private ArrayList<String> marksof5List = new ArrayList<>();
    private ArrayList<String> marksof15List = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fruit_vegetable_consolidators_deskvetting_checklist_step3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        fruitsAndVegetablesConsolidatorsViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(FruitsAndVegetablesConsolidatorsViewModel.class);

        setList15marks(getdummy15marks());
        setList10marks(getdummy10marks());
        setList5marks(getdummy5marks());

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


        isSystemPoliceAndProcedure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSystemPoliceAndProcedure.isChecked()) {
                    isSystemPoliceandProcedure = "Y";
                } else {
                    isSystemPoliceandProcedure = "N";
                }

            }
        });

        isEvidenceOfAtendanceOfAnnualTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEvidenceOfAtendanceOfAnnualTraining.isChecked()) {
                    isEvidenceOfatendanceOfAnnualTraining = "Y";
                } else {
                    isEvidenceOfatendanceOfAnnualTraining = "N";
                }

            }
        });

        isAnnualTrainingMatrixSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAnnualTrainingMatrixSchedule.isChecked()) {
                    isAnnualTrainingmatrixSchedule = "Y";
                } else {
                    isAnnualTrainingmatrixSchedule = "N";
                }

            }
        });

        isPestDiseaseControlProcedures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPestDiseaseControlProcedures.isChecked()) {
                    isPestDiseasecontrolProcedures = "Y";
                } else {
                    isPestDiseasecontrolProcedures = "N";
                }

            }
        });

        isClaimsOnNonPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClaimsOnNonPayment.isChecked()) {
                    isClaimsOnnonPayment = "Y";
                } else {
                    isClaimsOnnonPayment = "N";
                }

            }
        });

        return view;

    }

    private void setList15marks(List<View15Marks> getdummy15marks) {
        marksof15List.add("- Required -");
        for (View15Marks regionWrapper : getdummy15marks) {
            marksof15List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof15List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);


    }

    private List<View15Marks> getdummy15marks() {
        List<View15Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View15Marks("0"));
        listViewItems.add(new View15Marks("1"));
        listViewItems.add(new View15Marks("2"));
        listViewItems.add(new View15Marks("3"));
        listViewItems.add(new View15Marks("4"));
        listViewItems.add(new View15Marks("5"));
        listViewItems.add(new View15Marks("6"));
        listViewItems.add(new View15Marks("7"));
        listViewItems.add(new View15Marks("8"));
        listViewItems.add(new View15Marks("9"));
        listViewItems.add(new View15Marks("10"));
        listViewItems.add(new View15Marks("11"));
        listViewItems.add(new View15Marks("12"));
        listViewItems.add(new View15Marks("13"));
        listViewItems.add(new View15Marks("14"));
        listViewItems.add(new View15Marks("15"));

        return listViewItems;
    }


    private void setList10marks(List<View10Marks> getdummy10marks) {
        marksof10List.add("- Required -");
        for (View10Marks regionWrapper : getdummy10marks) {
            marksof10List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof10List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssEvidenceOfAtendanceOfAnnualTrainingAward.setAdapter(regionAdapter);
        ssAnnualTrainingMatrixScheduleAward.setAdapter(regionAdapter);
        ssPestDiseaseControlProceduresAward.setAdapter(regionAdapter);
        ssClaimsOnNonPaymentAward.setAdapter(regionAdapter);
    }

    private List<View10Marks> getdummy10marks() {
        List<View10Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View10Marks("0"));
        listViewItems.add(new View10Marks("1"));
        listViewItems.add(new View10Marks("2"));
        listViewItems.add(new View10Marks("3"));
        listViewItems.add(new View10Marks("4"));
        listViewItems.add(new View10Marks("5"));
        listViewItems.add(new View10Marks("6"));
        listViewItems.add(new View10Marks("7"));
        listViewItems.add(new View10Marks("8"));
        listViewItems.add(new View10Marks("9"));
        listViewItems.add(new View10Marks("10"));
        listViewItems.add(new View10Marks("-10"));

        return listViewItems;
    }

    private void setList5marks(List<View5Marks> getdummy5marks) {
        marksof5List.add("- Required -");
        for (View5Marks regionWrapper : getdummy5marks) {
            marksof5List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof5List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssEvidenceOfAtendanceOfAnnualTrainingAward.setAdapter(regionAdapter);
        ssSystemPoliceAndProcedureAward.setAdapter(regionAdapter);


    }

    private List<View5Marks> getdummy5marks() {
        List<View5Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View5Marks("0"));
        listViewItems.add(new View5Marks("1"));
        listViewItems.add(new View5Marks("2"));
        listViewItems.add(new View5Marks("3"));
        listViewItems.add(new View5Marks("4"));
        listViewItems.add(new View5Marks("5"));


        return listViewItems;
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {


        ssSystemPoliceandProcedureAward = Objects.requireNonNull(ssSystemPoliceAndProcedureAward.getSelectedItem()).toString().trim();
        systemPoliceandProcedureTimeline = Objects.requireNonNull(etSystemPoliceAndProcedureTimeline.getText()).toString().trim();
        systemPoliceandProcedureRemarks = Objects.requireNonNull(etSystemPoliceAndProcedureRemarks.getText()).toString().trim();

        ssEvidenceOfatendanceOfAnnualTrainingAward = Objects.requireNonNull(ssEvidenceOfAtendanceOfAnnualTrainingAward.getSelectedItem()).toString().trim();
        evidenceOfatendanceOfAnnualTraininAwardTimeline = Objects.requireNonNull(etEvidenceOfAtendanceOfAnnualTrainingTimeline.getText()).toString().trim();
        evidenceOfatendanceOfAnnualTrainingRemarks = Objects.requireNonNull(etEvidenceOfAtendanceOfAnnualTrainingRemarks.getText()).toString().trim();

        ssAnnualTrainingmatrixScheduleAward = Objects.requireNonNull(ssAnnualTrainingMatrixScheduleAward.getSelectedItem()).toString().trim();
        annualTrainingmatrixScheduleTimeline = Objects.requireNonNull(etAnnualTrainingMatrixScheduleTimeline.getText()).toString().trim();
        annualTrainingmatrixScheduleRemarks = Objects.requireNonNull(etAnnualTrainingMatrixScheduleRemarks.getText()).toString().trim();

        ssPestDiseasecontrolProceduresAward = Objects.requireNonNull(ssPestDiseaseControlProceduresAward.getSelectedItem()).toString().trim();
        pestDiseasecontrolProceduresTimeline = Objects.requireNonNull(etPestDiseaseControlProceduresTimeline.getText()).toString().trim();
        pestDiseasecontrolProceduresRemarks = Objects.requireNonNull(etPestDiseaseControlProceduresRemarks.getText()).toString().trim();

        ssClaimsOnnonPaymentAward = Objects.requireNonNull(ssClaimsOnNonPaymentAward.getSelectedItem()).toString().trim();
        claimsOnnonPaymentTimeline = Objects.requireNonNull(etClaimsOnNonPaymentTimeline.getText()).toString().trim();
        claimsOnnonPaymentRemarks = Objects.requireNonNull(etClaimsOnNonPaymentRemarks.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateFields(isSystemPoliceAndProcedure, etSystemPoliceAndProcedureTimeline, systemPoliceandProcedureTimeline, etSystemPoliceAndProcedureRemarks, systemPoliceandProcedureRemarks, ssSystemPoliceAndProcedureAward, ssSystemPoliceandProcedureAward) &
                validateFields(isEvidenceOfAtendanceOfAnnualTraining, etEvidenceOfAtendanceOfAnnualTrainingTimeline, evidenceOfatendanceOfAnnualTraininAwardTimeline, etEvidenceOfAtendanceOfAnnualTrainingRemarks, evidenceOfatendanceOfAnnualTrainingRemarks, ssEvidenceOfAtendanceOfAnnualTrainingAward, ssEvidenceOfatendanceOfAnnualTrainingAward) &
                validateFields(isAnnualTrainingMatrixSchedule, etAnnualTrainingMatrixScheduleTimeline, annualTrainingmatrixScheduleTimeline, etAnnualTrainingMatrixScheduleRemarks, annualTrainingmatrixScheduleRemarks, ssAnnualTrainingMatrixScheduleAward, ssAnnualTrainingmatrixScheduleAward) &
                validateFields(isPestDiseaseControlProcedures, etPestDiseaseControlProceduresTimeline, pestDiseasecontrolProceduresTimeline, etPestDiseaseControlProceduresRemarks, pestDiseasecontrolProceduresRemarks, ssPestDiseaseControlProceduresAward, ssPestDiseasecontrolProceduresAward) &
                validateFields(isClaimsOnNonPayment, etClaimsOnNonPaymentTimeline, claimsOnnonPaymentTimeline, etClaimsOnNonPaymentRemarks, claimsOnnonPaymentRemarks, ssClaimsOnNonPaymentAward, ssClaimsOnnonPaymentAward);


        FruitVegetableConsolidatorsBus fruitVegetableConsolidatorsBus = FruitVegetableConsolidatorsBus.getInstance();

        FruitVegetableConsolidators fruitVegetableConsolidators = new FruitVegetableConsolidators(
                0,
                fruitVegetableConsolidatorsBus.getDocumentNumber(),
                fruitVegetableConsolidatorsBus.getDocumentDate(),
                fruitVegetableConsolidatorsBus.getNameOfApplicant(),
                fruitVegetableConsolidatorsBus.getExportLicence(),
                fruitVegetableConsolidatorsBus.getLocalID(),
                fruitVegetableConsolidatorsBus.getIsCertificationtoKsh1758(),
                fruitVegetableConsolidatorsBus.getSsCertificationtoKsh1758Award(),
                fruitVegetableConsolidatorsBus.getCertificationtoKsh1758Timeline(),
                fruitVegetableConsolidatorsBus.getCertificationtoKsh1758Remarks(),
                fruitVegetableConsolidatorsBus.getIsOtherrecognizedStandards(),
                fruitVegetableConsolidatorsBus.getSsOtherrecognizedStandardsAward(),
                fruitVegetableConsolidatorsBus.getOtherrecognizedStandardstimeline(),
                fruitVegetableConsolidatorsBus.getOtherrecognizedStandardsRemarks(),
                fruitVegetableConsolidatorsBus.getIsEvidenceofRegonNaionalTraceability(),
                fruitVegetableConsolidatorsBus.getSsEvidenceofRegonNaionalTraceabilityAward(),
                fruitVegetableConsolidatorsBus.getEvidenceofRegonNaionalTraceabilityTimeline(),
                fruitVegetableConsolidatorsBus.getEvidenceofRegonNaionalTraceabilityRemarks(),
                fruitVegetableConsolidatorsBus.getIsEvidenceofRegSingleWindow(),
                fruitVegetableConsolidatorsBus.getSsEvidenceofRegSingleWindowAward(),
                fruitVegetableConsolidatorsBus.getEvidenceofRegSingleWindowTimeline(),
                fruitVegetableConsolidatorsBus.getEvidenceofRegSingleWindowRemarks(),
                fruitVegetableConsolidatorsBus.getIsCopyofHcdExportLicence(),
                fruitVegetableConsolidatorsBus.getSsCopyofHcdExportLicenceAward(),
                fruitVegetableConsolidatorsBus.getCopyofHcdExportLicenceTimeline(),
                fruitVegetableConsolidatorsBus.getCopyofHcdExportLicenceRemarks(),
                fruitVegetableConsolidatorsBus.getIsTraceabilityListContractedfarmers(),
                fruitVegetableConsolidatorsBus.getSsTraceabilityListContractedfarmersAward(),
                fruitVegetableConsolidatorsBus.getTraceabilityListContractedfarmersTimeline(),
                fruitVegetableConsolidatorsBus.getTraceabilityListContractedfarmersRemarks(),
                fruitVegetableConsolidatorsBus.getIsDeclaremarketingAgent(),
                fruitVegetableConsolidatorsBus.getSsDeclaremarketingAgentAward(),
                fruitVegetableConsolidatorsBus.getDeclaremarketingAgentTimeline(),
                fruitVegetableConsolidatorsBus.getDeclaremarketingAgentREmarks(),
                fruitVegetableConsolidatorsBus.getIsUtilizationofHCD(),
                fruitVegetableConsolidatorsBus.getSsUtilizationofHCDAward(),
                fruitVegetableConsolidatorsBus.getUtilizationofHCDTimeline(),
                fruitVegetableConsolidatorsBus.getUtilizationofHCDRemarks(),
                isSystemPoliceandProcedure,
                ssSystemPoliceandProcedureAward,
                systemPoliceandProcedureTimeline,
                systemPoliceandProcedureRemarks,
                isEvidenceOfatendanceOfAnnualTraining,
                ssEvidenceOfatendanceOfAnnualTrainingAward,
                evidenceOfatendanceOfAnnualTraininAwardTimeline,
                evidenceOfatendanceOfAnnualTrainingRemarks,
                isAnnualTrainingmatrixSchedule,
                ssAnnualTrainingmatrixScheduleAward,
                annualTrainingmatrixScheduleTimeline,
                annualTrainingmatrixScheduleRemarks,
                isPestDiseasecontrolProcedures,
                ssPestDiseasecontrolProceduresAward,
                pestDiseasecontrolProceduresTimeline,
                pestDiseasecontrolProceduresRemarks,
                isClaimsOnnonPayment,
                ssClaimsOnnonPaymentAward,
                claimsOnnonPaymentTimeline,
                claimsOnnonPaymentRemarks,
                recommendation,
                recommendationRemarks,
                false,
                ""


        );

        if(valid) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("FRUIT VEGETABLES INSPECTION!")
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
                            db.UpdateFruitVegetableConsolidators(fruitVegetableConsolidators);
                            fruitsAndVegetablesConsolidatorsViewModel.addRecord(fruitVegetableConsolidators);

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

    private boolean validateFields(CheckBox checkBox, CustomEditText firstCustomEditText, String firstCustomEditTextString, CustomEditText secondCustomEditText, String secondCustomEditTextString, SearchableSpinner searchableSpinner, String searchableSpinnerString){

        boolean resultEditText1 = false;
        boolean resultEditText2 = false;
        boolean resultCheckbox = false;
        boolean resultSpinner = false;

        if(!checkBox.isChecked()){
            if (TextUtils.isEmpty(firstCustomEditTextString)) {
                firstCustomEditText.setError("Field Required ");
                resultEditText1 = false;
            } else {
                resultEditText1 = true;
            }
            if (TextUtils.isEmpty(secondCustomEditTextString)) {
                secondCustomEditText.setError("Field Required ");
                resultEditText2 = false;
            } else {
                resultEditText2 = true;
            }
            resultCheckbox = resultEditText1 && resultEditText2;
        } else{
            firstCustomEditText.setError(null);
            secondCustomEditText.setError(null);
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
        } else{
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
