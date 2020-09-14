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
import co.ke.bsl.data.model.FruitsVegetablesExportersDeskVetting;
import co.ke.bsl.data.view.FruitsVegetablesExportersDeskVettingBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.data.view.View10Marks;
import co.ke.bsl.data.view.View15Marks;
import co.ke.bsl.data.view.View5Marks;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.FruitsAndVegetablesExportersViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FruitsVegetablesExportersDeskVettingChecklistStep3 extends Fragment implements BlockingStep {

    @BindView(R.id.isEvidenceOfAtendanceOfAnnualTraining)
    CheckBox isEvidenceOfAtendanceOfAnnualTraining;
    @BindView(R.id.etEvidenceOfAtendanceOfAnnualTrainingAward)
    SearchableSpinner etEvidenceOfAtendanceOfAnnualTrainingAward;
    @BindView(R.id.etEvidenceOfAtendanceOfAnnualTrainingTimeline)
    CustomEditText etEvidenceOfAtendanceOfAnnualTrainingTimeline;
    @BindView(R.id.etEvidenceOfAtendanceOfAnnualTrainingRemarks)
    CustomEditText etEvidenceOfAtendanceOfAnnualTrainingRemarks;

    @BindView(R.id.isAnnualTrainingMatrixSchedule)
    CheckBox isAnnualTrainingMatrixSchedule;
    @BindView(R.id.etAnnualTrainingMatrixScheduleAward)
    SearchableSpinner etAnnualTrainingMatrixScheduleAward;
    @BindView(R.id.etAnnualTrainingMatrixScheduleTimeline)
    CustomEditText etAnnualTrainingMatrixScheduleTimeline;
    @BindView(R.id.etAnnualTrainingMatrixScheduleRemarks)
    CustomEditText etAnnualTrainingMatrixScheduleRemarks;

    @BindView(R.id.isPestDiseaseControlProcedures)
    CheckBox isPestDiseaseControlProcedures;
    @BindView(R.id.etPestDiseaseControlProceduresAward)
    SearchableSpinner etPestDiseaseControlProceduresAward;
    @BindView(R.id.etPestDiseaseControlProceduresTimeline)
    CustomEditText etPestDiseaseControlProceduresTimeline;
    @BindView(R.id.etPestDiseaseControlProceduresRemarks)
    CustomEditText etPestDiseaseControlProceduresRemarks;

    @BindView(R.id.isClaimsOnNonPayment)
    CheckBox isClaimsOnNonPayment;
    @BindView(R.id.etClaimsOnNonPaymentAward)
    SearchableSpinner etClaimsOnNonPaymentAward;
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

    private FruitsAndVegetablesExportersViewModel fruitsAndVegetablesExportersViewModel;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();


    private String isEvidenceofAtendanceOfAnnualTraining, evidenceofAtendanceOfAnnualTrainingAward, evidenceofAtendanceOfAnnualTrainingTimeline, evidenceofAtendanceOfAnnualTrainingRemarks;
    private String isAnnualTrainingmatrixSchedule, annualTrainingmatrixScheduleAward, annualTrainingmatrixScheduleTimeline, annualTrainingmatrixScheduleRemarks;
    private String isPestDiseaseControlprocedures, pestDiseaseControlproceduresAward, pestDiseaseControlproceduresTimeline, pestDiseaseControlproceduresRemarks;
    private String isClaimsonNonPayment, claimsonNonPaymentAward, claimsonNonPaymentTimeline, claimsonNonPaymentRemarks;

    private ArrayList<String> marksof10List = new ArrayList<>();
    private ArrayList<String> marksof5List = new ArrayList<>();
    private ArrayList<String> marksof15List = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fruits_vegetables_exporters_desk_vetting_checklist_step3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        fruitsAndVegetablesExportersViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(FruitsAndVegetablesExportersViewModel.class);


        setList10marks(getdummy10marks());

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


        isEvidenceOfAtendanceOfAnnualTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEvidenceOfAtendanceOfAnnualTraining.isChecked()) {
                    isEvidenceofAtendanceOfAnnualTraining = "Y";
                } else {
                    isEvidenceofAtendanceOfAnnualTraining = "N";
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
                    isPestDiseaseControlprocedures = "Y";
                } else {
                    isPestDiseaseControlprocedures = "N";
                }

            }
        });
        isClaimsOnNonPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClaimsOnNonPayment.isChecked()) {
                    isClaimsonNonPayment = "Y";
                } else {
                    isClaimsonNonPayment = "N";
                }

            }
        });
        return view;

    }


    private void setList10marks(List<View10Marks> getdummy10marks) {
        marksof10List.add("- Required -");
        for (View10Marks regionWrapper : getdummy10marks) {
            marksof10List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof10List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        etEvidenceOfAtendanceOfAnnualTrainingAward.setAdapter(regionAdapter);
        etAnnualTrainingMatrixScheduleAward.setAdapter(regionAdapter);
        etClaimsOnNonPaymentAward.setAdapter(regionAdapter);
        etPestDiseaseControlProceduresAward.setAdapter(regionAdapter);

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

        evidenceofAtendanceOfAnnualTrainingAward = Objects.requireNonNull(etEvidenceOfAtendanceOfAnnualTrainingAward.getSelectedItem()).toString().trim();
        evidenceofAtendanceOfAnnualTrainingTimeline = Objects.requireNonNull(etEvidenceOfAtendanceOfAnnualTrainingTimeline.getText()).toString().trim();
        evidenceofAtendanceOfAnnualTrainingRemarks = Objects.requireNonNull(etEvidenceOfAtendanceOfAnnualTrainingRemarks.getText()).toString().trim();
        annualTrainingmatrixScheduleAward = Objects.requireNonNull(etAnnualTrainingMatrixScheduleAward.getSelectedItem()).toString().trim();
        annualTrainingmatrixScheduleTimeline = Objects.requireNonNull(etAnnualTrainingMatrixScheduleTimeline.getText()).toString().trim();
        annualTrainingmatrixScheduleRemarks = Objects.requireNonNull(etAnnualTrainingMatrixScheduleRemarks.getText()).toString().trim();
        pestDiseaseControlproceduresAward = Objects.requireNonNull(etPestDiseaseControlProceduresAward.getSelectedItem()).toString().trim();
        pestDiseaseControlproceduresTimeline = Objects.requireNonNull(etPestDiseaseControlProceduresTimeline.getText()).toString().trim();
        pestDiseaseControlproceduresRemarks = Objects.requireNonNull(etPestDiseaseControlProceduresRemarks.getText()).toString().trim();
        claimsonNonPaymentAward = Objects.requireNonNull(etClaimsOnNonPaymentAward.getSelectedItem()).toString().trim();
        claimsonNonPaymentTimeline = Objects.requireNonNull(etClaimsOnNonPaymentTimeline.getText()).toString().trim();
        claimsonNonPaymentRemarks = Objects.requireNonNull(etClaimsOnNonPaymentRemarks.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateFields(isEvidenceOfAtendanceOfAnnualTraining, etEvidenceOfAtendanceOfAnnualTrainingRemarks, evidenceofAtendanceOfAnnualTrainingRemarks, etEvidenceOfAtendanceOfAnnualTrainingTimeline, evidenceofAtendanceOfAnnualTrainingTimeline, etEvidenceOfAtendanceOfAnnualTrainingAward, evidenceofAtendanceOfAnnualTrainingAward) &
                validateFields(isAnnualTrainingMatrixSchedule, etAnnualTrainingMatrixScheduleTimeline, annualTrainingmatrixScheduleTimeline, etAnnualTrainingMatrixScheduleRemarks, annualTrainingmatrixScheduleRemarks, etAnnualTrainingMatrixScheduleAward, annualTrainingmatrixScheduleAward) &
                validateFields(isPestDiseaseControlProcedures, etPestDiseaseControlProceduresTimeline, pestDiseaseControlproceduresTimeline, etPestDiseaseControlProceduresRemarks, pestDiseaseControlproceduresRemarks, etPestDiseaseControlProceduresAward, pestDiseaseControlproceduresAward) &
                validateFields(isClaimsOnNonPayment, etClaimsOnNonPaymentTimeline, claimsonNonPaymentTimeline, etClaimsOnNonPaymentRemarks, claimsonNonPaymentRemarks, etClaimsOnNonPaymentAward, claimsonNonPaymentAward);


        FruitsVegetablesExportersDeskVettingBus fruitsVegetablesExportersDeskVettingBus = FruitsVegetablesExportersDeskVettingBus.getInstance();

        FruitsVegetablesExportersDeskVetting fruitsVegetablesExportersDeskVetting = new FruitsVegetablesExportersDeskVetting(
                0,
                fruitsVegetablesExportersDeskVettingBus.getDocumentNumber(),
                fruitsVegetablesExportersDeskVettingBus.getDocumentDate(),
                fruitsVegetablesExportersDeskVettingBus.getNameOfApplicant(),
                fruitsVegetablesExportersDeskVettingBus.getTelephone(),
                fruitsVegetablesExportersDeskVettingBus.getEmail(),
                fruitsVegetablesExportersDeskVettingBus.getPostaladdress(),
                fruitsVegetablesExportersDeskVettingBus.getExportLicence(),
                fruitsVegetablesExportersDeskVettingBus.getLocalID(),
                fruitsVegetablesExportersDeskVettingBus.getIsCertificationtoKsh1758(),
                fruitsVegetablesExportersDeskVettingBus.getCertificationtoKsh1758Award(),
                fruitsVegetablesExportersDeskVettingBus.getCertificationtoKsh1758Timeline(),
                fruitsVegetablesExportersDeskVettingBus.getCertificationtoKsh1758Remarks(),
                fruitsVegetablesExportersDeskVettingBus.getIsOtherRecognizedstandards(),
                fruitsVegetablesExportersDeskVettingBus.getOtherRecognizedstandardsAward(),
                fruitsVegetablesExportersDeskVettingBus.getOtherRecognizedstandardsTimeline(),
                fruitsVegetablesExportersDeskVettingBus.getOtherRecognizedstandardsremarks(),
                fruitsVegetablesExportersDeskVettingBus.getIsEvidenceofRegonNaionalTraceability(),
                fruitsVegetablesExportersDeskVettingBus.getEvidenceofRegonNaionalTraceabilityAward(),
                fruitsVegetablesExportersDeskVettingBus.getEvidenceofRegonNaionalTraceabilityTimeline(),
                fruitsVegetablesExportersDeskVettingBus.getEvidenceofRegonNaionalTraceabilityRemarks(),
                fruitsVegetablesExportersDeskVettingBus.getIsEvidenceofRegSingleWindow(),
                fruitsVegetablesExportersDeskVettingBus.getEvidenceofRegSingleWindowAward(),
                fruitsVegetablesExportersDeskVettingBus.getEvidenceofRegSingleWindowTimeline(),
                fruitsVegetablesExportersDeskVettingBus.getEvidenceofRegSingleWindowRemarks(),
                fruitsVegetablesExportersDeskVettingBus.getIsCopyOfHcdexportLicence(),
                fruitsVegetablesExportersDeskVettingBus.getCopyOfHcdexportLicenceAward(),
                fruitsVegetablesExportersDeskVettingBus.getCopyOfHcdexportLicenceTimeine(),
                fruitsVegetablesExportersDeskVettingBus.getCopyOfHcdexportLicenceRemarks(),
                fruitsVegetablesExportersDeskVettingBus.getIsTraceablitylistOfTheCompany(),
                fruitsVegetablesExportersDeskVettingBus.getTraceablitylistOfTheCompanyAward(),
                fruitsVegetablesExportersDeskVettingBus.getTraceablitylistOfTheCompanyTimeline(),
                fruitsVegetablesExportersDeskVettingBus.getTraceablitylistOfTheCompanyReamrks(),
                fruitsVegetablesExportersDeskVettingBus.getIsDeclareMarketingAgents(),
                fruitsVegetablesExportersDeskVettingBus.getDeclareMarketingAgentsAward(),
                fruitsVegetablesExportersDeskVettingBus.getDeclareMarketingAgentsTimeline(),
                fruitsVegetablesExportersDeskVettingBus.getDeclareMarketingAgentsRemarks(),
                fruitsVegetablesExportersDeskVettingBus.getIsEvidenceOfhcdRegistered(),
                fruitsVegetablesExportersDeskVettingBus.getEvidenceOfhcdRegisteredAward(),
                fruitsVegetablesExportersDeskVettingBus.getEvidenceOfhcdRegisteredTimeline(),
                fruitsVegetablesExportersDeskVettingBus.getEvidenceOfhcdRegisteredRemarks(),
                fruitsVegetablesExportersDeskVettingBus.getIsSystempoliceAndProcedure(),
                fruitsVegetablesExportersDeskVettingBus.getSystemPoliceAndProcedureAward(),
                fruitsVegetablesExportersDeskVettingBus.getSystemPoliceAndProcedureTimeline(),
                fruitsVegetablesExportersDeskVettingBus.getSystemPoliceAndProcedureRemarks(),
                isEvidenceofAtendanceOfAnnualTraining,
                evidenceofAtendanceOfAnnualTrainingAward,
                evidenceofAtendanceOfAnnualTrainingTimeline,
                evidenceofAtendanceOfAnnualTrainingRemarks,
                isAnnualTrainingmatrixSchedule,
                annualTrainingmatrixScheduleAward,
                annualTrainingmatrixScheduleTimeline,
                annualTrainingmatrixScheduleRemarks,
                isPestDiseaseControlprocedures,
                pestDiseaseControlproceduresAward,
                pestDiseaseControlproceduresTimeline,
                pestDiseaseControlproceduresRemarks,
                isClaimsonNonPayment,
                claimsonNonPaymentAward,
                claimsonNonPaymentTimeline,
                claimsonNonPaymentRemarks,
                recommendation,
                recommendationRemarks,
                false,
                ""


        );

        if(valid) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("FRUITS VEGETABLES INSPECTION!")
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
                            db.UpdateFruitsVegetablesExportersDeskVetting(fruitsVegetablesExportersDeskVetting);
                            fruitsAndVegetablesExportersViewModel.addRecord(fruitsVegetablesExportersDeskVetting);

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
