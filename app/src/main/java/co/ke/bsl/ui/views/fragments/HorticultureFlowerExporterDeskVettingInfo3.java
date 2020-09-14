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
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.HorticulturalFlowerExportersDeskVetting;
import co.ke.bsl.data.view.HorticulturalFlowerExportersDeskVettingBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.HorticulturalFlowerExportersViewModel;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorticultureFlowerExporterDeskVettingInfo3 extends Fragment implements BlockingStep {

    @BindView(R.id.isevidenceOfAttendanceAnnual)
    CheckBox isevidenceOfAttendanceAnnual;
    @BindView(R.id.etevidenceOfAttendanceAnnualAward)
    CustomEditText etevidenceOfAttendanceAnnualAward;
    @BindView(R.id.etevidenceOfAttendanceAnnualTimeline)
    CustomEditText etevidenceOfAttendanceAnnualTimeline;
    @BindView(R.id.etevidenceOfAttendanceAnnualRemarks)
    CustomEditText etevidenceOfAttendanceAnnualRemarks;

    @BindView(R.id.isannualTrainingMatrix)
    CheckBox isannualTrainingMatrix;
    @BindView(R.id.etannualTrainingMatrixAward)
    CustomEditText etannualTrainingMatrixAward;
    @BindView(R.id.etannualTrainingMatrixTimeline)
    CustomEditText etannualTrainingMatrixTimeline;
    @BindView(R.id.etannualTrainingMatrixRemarks)
    CustomEditText etannualTrainingMatrixRemarks;

    @BindView(R.id.isevidenceOfPests)
    CheckBox isevidenceOfPests;
    @BindView(R.id.etevidenceOfPestsAward)
    CustomEditText etevidenceOfPestsAward;
    @BindView(R.id.etevidenceOfPestsTimeline)
    CustomEditText etevidenceOfPestsTimeline;
    @BindView(R.id.etevidenceOfPestsRemarks)
    CustomEditText etevidenceOfPestsRemarks;

    @BindView(R.id.isClaimAgainst)
    CheckBox isClaimAgainst;
    @BindView(R.id.etClaimAgainstAward)
    CustomEditText etClaimAgainstAward;
    @BindView(R.id.etClaimAgainstTimeline)
    CustomEditText etClaimAgainstTimeline;
    @BindView(R.id.etClaimAgainstRemarks)
    CustomEditText etClaimAgainstRemarks;

    @BindView(R.id.isutilizationOfHCD)
    CheckBox isutilizationOfHCD;
    @BindView(R.id.etutilizationOfHCDAward)
    CustomEditText etutilizationOfHCDAward;
    @BindView(R.id.etutilizationOfHCDTimeline)
    CustomEditText etutilizationOfHCDTimeline;
    @BindView(R.id.etutilizationOfHCDRemarks)
    CustomEditText etutilizationOfHCDRemarks;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    AFADatabaseAdapter db;
    AFA app;

    private HorticulturalFlowerExportersViewModel horticulturalFlowerExportersViewModel;

    private String str_annual, str_matrix, str_pests, str_claim, str_utilization;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();


    public HorticultureFlowerExporterDeskVettingInfo3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horticulture_flower_exporter_desk_vetting_info3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();


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


        horticulturalFlowerExportersViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(HorticulturalFlowerExportersViewModel.class);

        isevidenceOfAttendanceAnnual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isevidenceOfAttendanceAnnual.isChecked()) {
                    str_annual = "Y";
                } else {
                    str_annual = "N";
                }
            }
        });

        isannualTrainingMatrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isannualTrainingMatrix.isChecked()) {
                    str_matrix = "Y";
                } else {
                    str_matrix = "N";
                }
            }
        });

        isevidenceOfPests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isevidenceOfPests.isChecked()) {
                    str_pests = "Y";
                } else {
                    str_pests = "N";
                }
            }
        });

        isClaimAgainst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClaimAgainst.isChecked()) {
                    str_claim = "Y";
                } else {
                    str_claim = "N";
                }
            }
        });

        isutilizationOfHCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isutilizationOfHCD.isChecked()) {
                    str_utilization = "Y";
                } else {
                    str_utilization = "N";
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
        String annualAward = Objects.requireNonNull(etevidenceOfAttendanceAnnualAward.getText()).toString().trim();
        String annualTimeline = Objects.requireNonNull(etevidenceOfAttendanceAnnualTimeline.getText()).toString().trim();
        String annualRemarks = Objects.requireNonNull(etevidenceOfAttendanceAnnualRemarks.getText()).toString().trim();
        String matrixAward = Objects.requireNonNull(etannualTrainingMatrixAward.getText()).toString().trim();
        String matrixTimeline = Objects.requireNonNull(etannualTrainingMatrixTimeline.getText()).toString().trim();
        String matrixRemarks = Objects.requireNonNull(etannualTrainingMatrixRemarks.getText()).toString().trim();
        String pestsAward = Objects.requireNonNull(etevidenceOfPestsAward.getText()).toString().trim();
        String pestsTimeline = Objects.requireNonNull(etevidenceOfPestsTimeline.getText()).toString().trim();
        String pestsRemarks = Objects.requireNonNull(etevidenceOfPestsRemarks.getText()).toString().trim();
        String claimAward = Objects.requireNonNull(etClaimAgainstAward.getText()).toString().trim();
        String claimTimeline = Objects.requireNonNull(etClaimAgainstTimeline.getText()).toString().trim();
        String claimRemarks = Objects.requireNonNull(etClaimAgainstRemarks.getText()).toString().trim();
        String utilizationAward = Objects.requireNonNull(etutilizationOfHCDAward.getText()).toString().trim();
        String utilizationTimeline = Objects.requireNonNull(etutilizationOfHCDTimeline.getText()).toString().trim();
        String utilizationRemarks = Objects.requireNonNull(etutilizationOfHCDRemarks.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateFields(isevidenceOfAttendanceAnnual, etevidenceOfAttendanceAnnualAward, annualAward, etevidenceOfAttendanceAnnualTimeline, annualTimeline, etevidenceOfAttendanceAnnualRemarks, annualRemarks) &
                validateFields(isannualTrainingMatrix, etannualTrainingMatrixAward, matrixAward, etannualTrainingMatrixTimeline, matrixTimeline, etannualTrainingMatrixRemarks, matrixRemarks) &
                validateFields(isevidenceOfPests, etevidenceOfPestsAward, pestsAward, etevidenceOfPestsTimeline, pestsTimeline, etevidenceOfPestsRemarks, pestsRemarks) &
                validateFields(isClaimAgainst, etClaimAgainstAward, claimAward, etClaimAgainstTimeline, claimTimeline, etClaimAgainstRemarks, claimRemarks) &
                validateFields(isutilizationOfHCD, etutilizationOfHCDAward, utilizationAward, etutilizationOfHCDTimeline, utilizationTimeline, etutilizationOfHCDRemarks, utilizationRemarks);

        HorticulturalFlowerExportersDeskVettingBus horticulturalFlowerExportersDeskVettingBus = HorticulturalFlowerExportersDeskVettingBus.getInstance();
        HorticulturalFlowerExportersDeskVetting horticulturalFlowerExportersDeskVetting = new HorticulturalFlowerExportersDeskVetting(
                0,
                horticulturalFlowerExportersDeskVettingBus.getDocument_number(),
                horticulturalFlowerExportersDeskVettingBus.getDocument_date(),
                horticulturalFlowerExportersDeskVettingBus.getName_of_applicant(),
                horticulturalFlowerExportersDeskVettingBus.getExport_licence(),
                horticulturalFlowerExportersDeskVettingBus.getLocalID(),
                horticulturalFlowerExportersDeskVettingBus.getIsCertificationToKS(),
                horticulturalFlowerExportersDeskVettingBus.getCertificationToKSAward(),
                horticulturalFlowerExportersDeskVettingBus.getCertificationToKSTimeline(),
                horticulturalFlowerExportersDeskVettingBus.getCertificationToKSRemarks(),
                horticulturalFlowerExportersDeskVettingBus.getIsRecognisedStandards(),
                horticulturalFlowerExportersDeskVettingBus.getRecognisedStandardsAward(),
                horticulturalFlowerExportersDeskVettingBus.getRecognisedStandardsTimeline(),
                horticulturalFlowerExportersDeskVettingBus.getRecognisedStandardsRemarks(),
                horticulturalFlowerExportersDeskVettingBus.getIsEvidenceOfRegistrationNational(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfRegistrationNationalAward(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfRegistrationNationalTimeline(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfRegistrationNationalRemarks(),
                horticulturalFlowerExportersDeskVettingBus.getIsEvidenceOfRegistrationSingle(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfRegistrationSingleAward(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfRegistrationSingleTimeline(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfRegistrationSingleRemarks(),
                horticulturalFlowerExportersDeskVettingBus.getIsEvidenceOfSafeDisposal(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfSafeDisposalAward(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfSafeDisposalTimeline(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfSafeDisposalRemarks(),
                horticulturalFlowerExportersDeskVettingBus.getIsEvidenceOfWorkerProtection(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfWorkerProtectionAward(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfWorkerProtectionTimeline(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfWorkerProtectionRemarks(),
                horticulturalFlowerExportersDeskVettingBus.getIsCopyOfHCD(),
                horticulturalFlowerExportersDeskVettingBus.getCopyOfHCDAward(),
                horticulturalFlowerExportersDeskVettingBus.getCopyOfHCDTimeline(),
                horticulturalFlowerExportersDeskVettingBus.getCopyOfHCDRemarks(),
                horticulturalFlowerExportersDeskVettingBus.getIsTraceabilityList(),
                horticulturalFlowerExportersDeskVettingBus.getTraceabilityListAward(),
                horticulturalFlowerExportersDeskVettingBus.getTraceabilityListTimeline(),
                horticulturalFlowerExportersDeskVettingBus.getTraceabilityListRemarks(),
                horticulturalFlowerExportersDeskVettingBus.getIsDeclareMarkettingAgents(),
                horticulturalFlowerExportersDeskVettingBus.getDeclareMarkettingAgentsAward(),
                horticulturalFlowerExportersDeskVettingBus.getDeclareMarkettingAgentsTimeline(),
                horticulturalFlowerExportersDeskVettingBus.getDeclareMarkettingAgentsRemarks(),
                horticulturalFlowerExportersDeskVettingBus.getIsEvidenceOfTraceabilitySystems(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfTraceabilitySystemsAward(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfTraceabilitySystemsTimeline(),
                horticulturalFlowerExportersDeskVettingBus.getEvidenceOfTraceabilitySystemsRemarks(),
                str_annual,
                annualAward,
                annualTimeline,
                annualRemarks,
                str_matrix,
                matrixAward,
                matrixTimeline,
                matrixRemarks,
                str_pests,
                pestsAward,
                pestsTimeline,
                pestsRemarks,
                str_claim,
                claimAward,
                claimTimeline,
                claimRemarks,
                str_utilization,
                utilizationAward,
                utilizationTimeline,
                utilizationRemarks,
                recommendation,
                recommendationRemarks,
                "",
                "",
                false,
                ""
        );

        if(valid) {
            if (horticulturalFlowerExportersDeskVettingBus.getLocalID() != null && !horticulturalFlowerExportersDeskVettingBus.getLocalID().isEmpty()) {
                db.updateHorticulturalFlowerExportersDeskVetting(horticulturalFlowerExportersDeskVetting);
              horticulturalFlowerExportersViewModel.addRecord(horticulturalFlowerExportersDeskVetting);

                Intent intent = new Intent(getActivity(), DashboardActivity.class);
                Objects.requireNonNull(getActivity()).finish();
                startActivity(intent);
            } else {
                Toast.makeText(app, "Please select item from checklist", Toast.LENGTH_SHORT).show();
                return;
            }
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

    private boolean validateFields(CheckBox checkBox, CustomEditText firstCustomEditText, String firstCustomEditTextString, CustomEditText secondCustomEditText, String secondCustomEditTextString, CustomEditText thirdCustomEditText, String thirdCustomEditTextString){

        boolean resultEditText1 = false;
        boolean resultEditText2 = false;
        boolean resultEditText3 = false;
        boolean resultCheckbox = false;

        if (TextUtils.isEmpty(firstCustomEditTextString)) {
            firstCustomEditText.setError("Field Required ");
            resultEditText1 = false;
        } else {
            resultEditText1 = true;
        }

        if(!checkBox.isChecked()){
            if (TextUtils.isEmpty(secondCustomEditTextString)) {
                secondCustomEditText.setError("Field Required ");
                resultEditText2 = false;
            } else {
                resultEditText2 = true;
            }
            if (TextUtils.isEmpty(thirdCustomEditTextString)) {
                thirdCustomEditText.setError("Field Required ");
                resultEditText3 = false;
            } else {
                resultEditText3 = true;
            }
            resultCheckbox = resultEditText2 && resultEditText3;
        } else{
            secondCustomEditText.setError(null);
            thirdCustomEditText.setError(null);
            resultCheckbox = true;
        }
        return (resultCheckbox && resultEditText1);
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
