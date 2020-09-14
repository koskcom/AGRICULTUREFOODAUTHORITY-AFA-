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
import co.ke.bsl.data.model.HCDFlowersConsolidators;
import co.ke.bsl.data.view.HCDFlowersConsolidatorsBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.data.view.View10Marks;
import co.ke.bsl.data.view.View15Marks;
import co.ke.bsl.data.view.View5Marks;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.HorticulturalCropsExportLicenceViewModel;
import co.ke.bsl.ui.viewmodels.HorticulturalFlowerConsolidatorsViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDFlowersConsolidatorsChecklistStep3 extends Fragment implements BlockingStep {

    @BindView(R.id.isEvidenceOfRegSingleWindow)
    CheckBox isEvidenceOfRegSingleWindow;
    @BindView(R.id.etEvidenceOfRegSingleWindowAward)
    SearchableSpinner etEvidenceOfRegSingleWindowAward;
    @BindView(R.id.etEvidenceOfRegSingleWindowTimeline)
    CustomEditText etEvidenceOfRegSingleWindowTimeline;
    @BindView(R.id.etEvidenceOfRegSingleWindowRemarks)
    CustomEditText etEvidenceOfRegSingleWindowRemarks;

    @BindView(R.id.isEvidenceOfAtendanceOfAnnualTraining)
    CheckBox isEvidenceOfAtendanceOfAnnualTraining;
    @BindView(R.id.etEvidenceOfAtendanceOfAnnualTrainingAward)
    SearchableSpinner etEvidenceOfAtendanceOfAnnualTrainingAward;
    @BindView(R.id.etEvidenceOfAtendanceOfAnnualTrainingTimeline)
    CustomEditText etEvidenceOfAtendanceOfAnnualTrainingTimeline;
    @BindView(R.id.etEvidenceOfAtendanceOfAnnualTrainingRemarks)
    CustomEditText etEvidenceOfAtendanceOfAnnualTrainingRemarks;

    @BindView(R.id.isVettingMarksCertified)
    CheckBox isVettingMarksCertified;
    @BindView(R.id.etVettingMarksCertifiedAward)
    SearchableSpinner etVettingMarksCertifiedAward;
    @BindView(R.id.etVettingMarksCertifiedTimeline)
    CustomEditText etVettingMarksCertifiedTimeline;
    @BindView(R.id.etVettingMarksCertifiedRemarks)
    CustomEditText etVettingMarksCertifiedRemarks;

    @BindView(R.id.isUtilizationOfHcd)
    CheckBox isUtilizationOfHcd;
    @BindView(R.id.etUtilizationOfHcdAward)
    SearchableSpinner etUtilizationOfHcdAward;
    @BindView(R.id.etUtilizationOfHcdTimeline)
    CustomEditText etUtilizationOfHcdTimeline;
    @BindView(R.id.etUtilizationOfHcdRemarks)
    CustomEditText etUtilizationOfHcdRemarks;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;


    private String isevidenceOfSingleWindow, isEvidenceOfAttendanceAnnualtraning, isVettingMarksCert, isUtilizationHcd;
    private String evidenceOfSingleWindowAward, evidenceOfAttendanceAnnualtraningAward, vettingMarksCertAward, utilizationHcdAward;
    private String evidenceOfSingleWindowTimeline, evidenceOfAttendanceAnnualtraningTimeline, vettingMarksCertTimeline, utilizationHcdTimeline;
    private String evidenceOfSingleWindowRemarks, evidenceOfAttendanceAnnualtraningRemarks, vettingMarksCertRemarks, utilizationHcdRemarks;

    private ArrayList<String> marksof10List = new ArrayList<>();
    private ArrayList<String> marksof5List = new ArrayList<>();
    private ArrayList<String> marksof15List = new ArrayList<>();


    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private HorticulturalFlowerConsolidatorsViewModel horticulturalFlowerConsolidatorsViewModel;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdflowers_consolidators_checklist_step3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        horticulturalFlowerConsolidatorsViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(HorticulturalFlowerConsolidatorsViewModel.class);


        setList15marks(getdummy15marks());
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


        isEvidenceOfRegSingleWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEvidenceOfRegSingleWindow.isChecked()) {
                    isevidenceOfSingleWindow = "Y";
                } else {
                    isevidenceOfSingleWindow = "N";
                }

            }
        });
        isEvidenceOfAtendanceOfAnnualTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEvidenceOfAtendanceOfAnnualTraining.isChecked()) {
                    isEvidenceOfAttendanceAnnualtraning = "Y";
                } else {
                    isEvidenceOfAttendanceAnnualtraning = "N";
                }

            }
        });
        ;
        isVettingMarksCertified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isVettingMarksCertified.isChecked()) {
                    isVettingMarksCert = "Y";
                } else {
                    isVettingMarksCert = "N";
                }

            }
        });
        ;
        isUtilizationOfHcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isUtilizationOfHcd.isChecked()) {
                    isUtilizationHcd = "Y";
                } else {
                    isUtilizationHcd = "N";
                }

            }
        });

        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {


    }


    private void setList15marks(List<View15Marks> getdummy15marks) {
        marksof15List.add("- Required -");
        for (View15Marks regionWrapper : getdummy15marks) {
            marksof15List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof15List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        etEvidenceOfAtendanceOfAnnualTrainingAward.setAdapter(regionAdapter);
        etVettingMarksCertifiedAward.setAdapter(regionAdapter);
        etUtilizationOfHcdAward.setAdapter(regionAdapter);

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


    private void setList5marks(List<View5Marks> getdummy5marks) {
        marksof5List.add("- Required -");
        for (View5Marks regionWrapper : getdummy5marks) {
            marksof5List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof5List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        etEvidenceOfRegSingleWindowAward.setAdapter(regionAdapter);
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
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        evidenceOfSingleWindowAward = Objects.requireNonNull(etEvidenceOfRegSingleWindowAward.getSelectedItem()).toString().trim();
        evidenceOfSingleWindowTimeline = Objects.requireNonNull(etEvidenceOfRegSingleWindowTimeline.getText()).toString().trim();
        evidenceOfSingleWindowRemarks = Objects.requireNonNull(etEvidenceOfRegSingleWindowRemarks.getText()).toString().trim();
        evidenceOfAttendanceAnnualtraningAward = Objects.requireNonNull(etEvidenceOfAtendanceOfAnnualTrainingAward.getSelectedItem()).toString().trim();
        evidenceOfAttendanceAnnualtraningTimeline = Objects.requireNonNull(etEvidenceOfAtendanceOfAnnualTrainingTimeline.getText()).toString().trim();
        evidenceOfAttendanceAnnualtraningRemarks = Objects.requireNonNull(etEvidenceOfAtendanceOfAnnualTrainingRemarks.getText()).toString().trim();
        vettingMarksCertAward = Objects.requireNonNull(etVettingMarksCertifiedAward.getSelectedItem()).toString().trim();
        vettingMarksCertTimeline = Objects.requireNonNull(etVettingMarksCertifiedTimeline.getText()).toString().trim();
        vettingMarksCertRemarks = Objects.requireNonNull(etVettingMarksCertifiedRemarks.getText()).toString().trim();
        utilizationHcdAward = Objects.requireNonNull(etUtilizationOfHcdAward.getSelectedItem()).toString().trim();
        utilizationHcdTimeline = Objects.requireNonNull(etUtilizationOfHcdTimeline.getText()).toString().trim();
        utilizationHcdRemarks = Objects.requireNonNull(etUtilizationOfHcdRemarks.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateFields(isEvidenceOfRegSingleWindow, etEvidenceOfRegSingleWindowTimeline, evidenceOfSingleWindowTimeline, etEvidenceOfRegSingleWindowRemarks, evidenceOfSingleWindowRemarks, etEvidenceOfRegSingleWindowAward, evidenceOfSingleWindowAward) &
                validateFields(isEvidenceOfAtendanceOfAnnualTraining, etEvidenceOfAtendanceOfAnnualTrainingTimeline, evidenceOfAttendanceAnnualtraningTimeline, etEvidenceOfAtendanceOfAnnualTrainingRemarks, evidenceOfAttendanceAnnualtraningRemarks, etEvidenceOfAtendanceOfAnnualTrainingAward, evidenceOfAttendanceAnnualtraningAward) &
                validateFields(isVettingMarksCertified, etVettingMarksCertifiedTimeline, vettingMarksCertTimeline, etVettingMarksCertifiedRemarks, vettingMarksCertRemarks, etVettingMarksCertifiedAward, vettingMarksCertAward) &
                validateFields(isUtilizationOfHcd, etUtilizationOfHcdTimeline, utilizationHcdTimeline, etUtilizationOfHcdRemarks, utilizationHcdRemarks, etUtilizationOfHcdAward, utilizationHcdAward);

        HCDFlowersConsolidatorsBus hCDFlowersConsolidatorsBus = HCDFlowersConsolidatorsBus.getInstance();

        HCDFlowersConsolidators hCDFlowersConsolidators = new HCDFlowersConsolidators(
                0,
                hCDFlowersConsolidatorsBus.getDocument_number(),
                hCDFlowersConsolidatorsBus.getDocument_date(),
                hCDFlowersConsolidatorsBus.getName_of_applicant(),
                hCDFlowersConsolidatorsBus.getExport_licence(),
                hCDFlowersConsolidatorsBus.getPostal_address(),
                hCDFlowersConsolidatorsBus.getEmail(),
                hCDFlowersConsolidatorsBus.getTelephone(),
                hCDFlowersConsolidatorsBus.getLocalID(),
                hCDFlowersConsolidatorsBus.getIslistofcomapanycertificate(),
                hCDFlowersConsolidatorsBus.getListofcomapanycertificateAward(),
                hCDFlowersConsolidatorsBus.getListofcomapanycertificateTimeline(),
                hCDFlowersConsolidatorsBus.getListofcomapanycertificateRemarks(),
                hCDFlowersConsolidatorsBus.getIsValididtyOfSupplliers(),
                hCDFlowersConsolidatorsBus.getValididtyOfSupplliersAward(),
                hCDFlowersConsolidatorsBus.getValididtyOfSupplliersTimeline(),
                hCDFlowersConsolidatorsBus.getValididtyOfSupplliersRemarks(),
                hCDFlowersConsolidatorsBus.getIsCertificationToksh1758(),
                hCDFlowersConsolidatorsBus.getCertificationToksh1758Award(),
                hCDFlowersConsolidatorsBus.getCertificationToksh1758Timeline(),
                hCDFlowersConsolidatorsBus.getCertificationToksh1758Remarks(),
                hCDFlowersConsolidatorsBus.getIsCopyHcdExportlicence(),
                hCDFlowersConsolidatorsBus.getCopyHcdExportlicenceAward(),
                hCDFlowersConsolidatorsBus.getCopyHcdExportlicenceTimeline(),
                hCDFlowersConsolidatorsBus.getCopyHcdExportlicenceRemarks(),
                hCDFlowersConsolidatorsBus.getIsEvidenceRegistrationNationalTraceability(),
                hCDFlowersConsolidatorsBus.getEvidenceRegistrationNationalTraceabilityAward(),
                hCDFlowersConsolidatorsBus.getEvidenceRegistrationNationalTraceabilityTimeline(),
                hCDFlowersConsolidatorsBus.getEvidenceRegistrationNationalTraceabilityRemarks(),
                isevidenceOfSingleWindow,
                evidenceOfSingleWindowAward,
                evidenceOfSingleWindowTimeline,
                evidenceOfSingleWindowRemarks,
                isEvidenceOfAttendanceAnnualtraning,
                evidenceOfAttendanceAnnualtraningAward,
                evidenceOfAttendanceAnnualtraningTimeline,
                evidenceOfAttendanceAnnualtraningRemarks,
                isVettingMarksCert,
                vettingMarksCertAward,
                vettingMarksCertTimeline,
                vettingMarksCertRemarks,
                isUtilizationHcd,
                utilizationHcdAward,
                utilizationHcdTimeline,
                utilizationHcdRemarks,
                recommendation,
                recommendationRemarks,
                false,
                ""


        );

        if(valid) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("FLOWER CONSOLIDATORS INSPECTION!")
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

                            db.UpdateHCDFlowersConsolidators(hCDFlowersConsolidators);
                            horticulturalFlowerConsolidatorsViewModel.addRecord(hCDFlowersConsolidators);

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
