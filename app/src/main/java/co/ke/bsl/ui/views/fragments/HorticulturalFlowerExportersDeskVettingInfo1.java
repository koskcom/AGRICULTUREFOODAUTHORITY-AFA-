package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.R;
import co.ke.bsl.data.view.HorticulturalFlowerExportersDeskVettingBus;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorticulturalFlowerExportersDeskVettingInfo1 extends Fragment implements BlockingStep {

    @BindView(R.id.iscertificationToKS)
    CheckBox iscertificationToKS;
    @BindView(R.id.etcertificationToKSAward)
    CustomEditText etcertificationToKSAward;
    @BindView(R.id.etcertificationToKSTimeline)
    CustomEditText etcertificationToKSTimeline;
    @BindView(R.id.etcertificationToKSRemarks)
    CustomEditText etcertificationToKSRemarks;

    @BindView(R.id.isrecognizedStandards)
    CheckBox isrecognizedStandards;
    @BindView(R.id.etrecognizedStandardsAward)
    CustomEditText etrecognizedStandardsAward;
    @BindView(R.id.etrecognizedStandardsTimeline)
    CustomEditText etrecognizedStandardsTimeline;
    @BindView(R.id.etrecognizedStandardsRemarks)
    CustomEditText etrecognizedStandardsRemarks;

    @BindView(R.id.isevidenceOfRegistrationNational)
    CheckBox isevidenceOfRegistrationNational;
    @BindView(R.id.etevidenceOfRegistrationNationalAward)
    CustomEditText etevidenceOfRegistrationNationalAward;
    @BindView(R.id.etevidenceOfRegistrationNationalTimeline)
    CustomEditText etevidenceOfRegistrationNationalTimeline;
    @BindView(R.id.etevidenceOfRegistrationNationalRemarks)
    CustomEditText etevidenceOfRegistrationNationalRemarks;

    @BindView(R.id.isevidenceOfRegistrationSingle)
    CheckBox isevidenceOfRegistrationSingle;
    @BindView(R.id.etevidenceOfRegistrationSingleAward)
    CustomEditText etevidenceOfRegistrationSingleAward;
    @BindView(R.id.etevidenceOfRegistrationSingleTimeline)
    CustomEditText etevidenceOfRegistrationSingleTimeline;
    @BindView(R.id.etevidenceOfRegistrationSingleRemarks)
    CustomEditText etevidenceOfRegistrationSingleRemarks;

    @BindView(R.id.isevidenceOfSafeDisposal)
    CheckBox isevidenceOfSafeDisposal;
    @BindView(R.id.etevidenceOfSafeDisposalAward)
    CustomEditText etevidenceOfSafeDisposalAward;
    @BindView(R.id.etevidenceOfSafeDisposalTimeline)
    CustomEditText etevidenceOfSafeDisposalTimeline;
    @BindView(R.id.etevidenceOfSafeDisposalRemarks)
    CustomEditText etevidenceOfSafeDisposalRemarks;

    private String str_certification, str_recognised, str_national, str_single, str_safe;


    public HorticulturalFlowerExportersDeskVettingInfo1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horticultural_flower_exporters_desk_vetting_info1, container, false);
        ButterKnife.bind(this, view);

        iscertificationToKS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iscertificationToKS.isChecked()) {
                    str_certification = "Y";
                } else {
                    str_certification = "N";
                }
            }
        });

        isrecognizedStandards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isrecognizedStandards.isChecked()) {
                    str_recognised = "Y";
                } else {
                    str_recognised = "N";
                }
            }
        });

        isevidenceOfRegistrationNational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isevidenceOfRegistrationNational.isChecked()) {
                    str_national= "Y";
                } else {
                    str_national = "N";
                }
            }
        });

        isevidenceOfRegistrationSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isevidenceOfRegistrationSingle.isChecked()) {
                    str_single = "Y";
                } else {
                    str_single = "N";
                }
            }
        });

        isevidenceOfSafeDisposal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isevidenceOfSafeDisposal.isChecked()) {
                    str_safe = "Y";
                } else {
                    str_safe = "N";
                }
            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        String certificationAward = Objects.requireNonNull(etcertificationToKSAward.getText()).toString().trim();
        String certificationTimeline = Objects.requireNonNull(etcertificationToKSTimeline.getText()).toString().trim();
        String certificationRemarks = Objects.requireNonNull(etcertificationToKSRemarks.getText()).toString().trim();
        String recognisedAward = Objects.requireNonNull(etrecognizedStandardsAward.getText()).toString().trim();
        String recognisedTimeline = Objects.requireNonNull(etrecognizedStandardsTimeline.getText()).toString().trim();
        String recognisedRemarks = Objects.requireNonNull(etrecognizedStandardsRemarks.getText()).toString().trim();
        String nationalAward = Objects.requireNonNull(etevidenceOfRegistrationNationalAward.getText()).toString().trim();
        String nationalTimeline = Objects.requireNonNull(etevidenceOfRegistrationNationalTimeline.getText()).toString().trim();
        String nationalRemarks = Objects.requireNonNull(etevidenceOfRegistrationNationalRemarks.getText()).toString().trim();
        String singleAward = Objects.requireNonNull(etevidenceOfRegistrationSingleAward.getText()).toString().trim();
        String singleTimeline = Objects.requireNonNull(etevidenceOfRegistrationSingleTimeline.getText()).toString().trim();
        String singleRemarks = Objects.requireNonNull(etevidenceOfRegistrationSingleRemarks.getText()).toString().trim();
        String safeAward = Objects.requireNonNull(etevidenceOfSafeDisposalAward.getText()).toString().trim();
        String safeTimeline = Objects.requireNonNull(etevidenceOfSafeDisposalTimeline.getText()).toString().trim();
        String safeRemarks = Objects.requireNonNull(etevidenceOfSafeDisposalRemarks.getText()).toString().trim();

        boolean valid = validateFields(iscertificationToKS, etcertificationToKSAward, certificationAward, etcertificationToKSTimeline, certificationTimeline, etcertificationToKSRemarks, certificationRemarks) &
                validateFields(isrecognizedStandards, etrecognizedStandardsAward, recognisedAward, etrecognizedStandardsTimeline, recognisedTimeline, etrecognizedStandardsRemarks, recognisedRemarks) &
                validateFields(isevidenceOfRegistrationNational, etevidenceOfRegistrationNationalAward, nationalAward, etevidenceOfRegistrationNationalTimeline, nationalTimeline, etevidenceOfRegistrationNationalRemarks, nationalRemarks) &
                validateFields(isevidenceOfRegistrationSingle, etevidenceOfRegistrationSingleAward, singleAward, etevidenceOfRegistrationSingleTimeline, singleTimeline, etevidenceOfRegistrationSingleRemarks, singleRemarks) &
                validateFields(isevidenceOfSafeDisposal, etevidenceOfSafeDisposalAward, safeAward, etevidenceOfSafeDisposalTimeline, safeTimeline, etevidenceOfSafeDisposalRemarks, safeRemarks);

        HorticulturalFlowerExportersDeskVettingBus horticulturalFlowerExportersDeskVettingBus = HorticulturalFlowerExportersDeskVettingBus.getInstance();
        horticulturalFlowerExportersDeskVettingBus.setIsCertificationToKS(str_certification);
        horticulturalFlowerExportersDeskVettingBus.setCertificationToKSAward(certificationAward);
        horticulturalFlowerExportersDeskVettingBus.setCertificationToKSTimeline(certificationTimeline);
        horticulturalFlowerExportersDeskVettingBus.setCertificationToKSRemarks(certificationRemarks);
        horticulturalFlowerExportersDeskVettingBus.setIsRecognisedStandards(str_recognised);
        horticulturalFlowerExportersDeskVettingBus.setRecognisedStandardsAward(recognisedAward);
        horticulturalFlowerExportersDeskVettingBus.setRecognisedStandardsTimeline(recognisedTimeline);
        horticulturalFlowerExportersDeskVettingBus.setRecognisedStandardsRemarks(recognisedRemarks);
        horticulturalFlowerExportersDeskVettingBus.setIsEvidenceOfRegistrationNational(str_national);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfRegistrationNationalAward(nationalAward);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfRegistrationNationalTimeline(nationalTimeline);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfRegistrationNationalRemarks(nationalRemarks);
        horticulturalFlowerExportersDeskVettingBus.setIsEvidenceOfRegistrationSingle(str_single);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfRegistrationSingleAward(singleAward);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfRegistrationSingleTimeline(singleTimeline);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfRegistrationSingleRemarks(singleRemarks);
        horticulturalFlowerExportersDeskVettingBus.setIsEvidenceOfSafeDisposal(str_safe);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfSafeDisposalAward(safeAward);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfSafeDisposalTimeline(safeTimeline);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfSafeDisposalRemarks(safeRemarks);

        if(valid) {
            callback.goToNextStep();
        }
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

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

}
