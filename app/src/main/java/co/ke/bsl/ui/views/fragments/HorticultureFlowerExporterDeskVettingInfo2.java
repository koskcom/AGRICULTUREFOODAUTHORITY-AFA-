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

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.R;
import co.ke.bsl.data.view.HorticulturalFlowerExportersDeskVettingBus;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorticultureFlowerExporterDeskVettingInfo2 extends Fragment implements BlockingStep {
    @BindView(R.id.isevidenceOfWorkerProtection)
    CheckBox isevidenceOfWorkerProtection;
    @BindView(R.id.etevidenceOfWorkerProtectionAward)
    CustomEditText etevidenceOfWorkerProtectionAward;
    @BindView(R.id.etevidenceOfWorkerProtectionTimeline)
    CustomEditText etevidenceOfWorkerProtectionTimeline;
    @BindView(R.id.etevidenceOfWorkerProtectionRemarks)
    CustomEditText etevidenceOfWorkerProtectionRemarks;

    @BindView(R.id.iscopyOfHCD)
    CheckBox iscopyOfHCD;
    @BindView(R.id.etcopyOfHCDAward)
    CustomEditText etcopyOfHCDAward;
    @BindView(R.id.etcopyOfHCDTimeline)
    CustomEditText etcopyOfHCDTimeline;
    @BindView(R.id.etcopyOfHCDRemarks)
    CustomEditText etcopyOfHCDRemarks;

    @BindView(R.id.istraceabilityList)
    CheckBox istraceabilityList;
    @BindView(R.id.ettraceabilityListAward)
    CustomEditText ettraceabilityListAward;
    @BindView(R.id.ettraceabilityListTimeline)
    CustomEditText ettraceabilityListTimeline;
    @BindView(R.id.ettraceabilityListRemarks)
    CustomEditText ettraceabilityListRemarks;

    @BindView(R.id.isdeclareMarketingAgents)
    CheckBox isdeclareMarketingAgents;
    @BindView(R.id.etdeclareMarketingAgentsAward)
    CustomEditText etdeclareMarketingAgentsAward;
    @BindView(R.id.etdeclareMarketingAgentsTimeline)
    CustomEditText etdeclareMarketingAgentsTimeline;
    @BindView(R.id.etdeclareMarketingAgentsRemarks)
    CustomEditText etdeclareMarketingAgentsRemarks;

    @BindView(R.id.isevidenceOfTraceabilitySystem)
    CheckBox isevidenceOfTraceabilitySystem;
    @BindView(R.id.etevidenceOfTraceabilitySystemAward)
    CustomEditText etevidenceOfTraceabilitySystemAward;
    @BindView(R.id.etevidenceOfTraceabilitySystemTimeline)
    CustomEditText etevidenceOfTraceabilitySystemTimeline;
    @BindView(R.id.etevidenceOfTraceabilitySystemRemarks)
    CustomEditText etevidenceOfTraceabilitySystemRemarks;

    private String str_workers, str_copy, str_list, str_declare, str_system;


    public HorticultureFlowerExporterDeskVettingInfo2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horticulture_flower_exporter_desk_vetting_info2, container, false);
        ButterKnife.bind(this, view);

        isevidenceOfWorkerProtection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isevidenceOfWorkerProtection.isChecked()) {
                    str_workers = "Y";
                } else {
                    str_workers = "N";
                }
            }
        });

        iscopyOfHCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iscopyOfHCD.isChecked()) {
                    str_copy = "Y";
                } else {
                    str_copy = "N";
                }
            }
        });

        istraceabilityList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (istraceabilityList.isChecked()) {
                    str_list = "Y";
                } else {
                    str_list = "N";
                }
            }
        });

        isdeclareMarketingAgents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isdeclareMarketingAgents.isChecked()) {
                    str_declare = "Y";
                } else {
                    str_declare = "N";
                }
            }
        });

        isevidenceOfTraceabilitySystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isevidenceOfTraceabilitySystem.isChecked()) {
                    str_system = "Y";
                } else {
                    str_system = "N";
                }
            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String workersAward = Objects.requireNonNull(etevidenceOfWorkerProtectionAward.getText()).toString().trim();
        String workersTimeline = Objects.requireNonNull(etevidenceOfWorkerProtectionTimeline.getText()).toString().trim();
        String workersRemarks = Objects.requireNonNull(etevidenceOfWorkerProtectionRemarks.getText()).toString().trim();
        String copyAward = Objects.requireNonNull(etcopyOfHCDAward.getText()).toString().trim();
        String copyTimeline = Objects.requireNonNull(etcopyOfHCDTimeline.getText()).toString().trim();
        String copyRemarks = Objects.requireNonNull(etcopyOfHCDRemarks.getText()).toString().trim();
        String listAward = Objects.requireNonNull(ettraceabilityListAward.getText()).toString().trim();
        String listTimeline = Objects.requireNonNull(ettraceabilityListTimeline.getText()).toString().trim();
        String listRemarks = Objects.requireNonNull(ettraceabilityListRemarks.getText()).toString().trim();
        String declareAward = Objects.requireNonNull(etdeclareMarketingAgentsAward.getText()).toString().trim();
        String declareTimeline = Objects.requireNonNull(etdeclareMarketingAgentsTimeline.getText()).toString().trim();
        String declareRemarks = Objects.requireNonNull(etdeclareMarketingAgentsRemarks.getText()).toString().trim();
        String systemAward = Objects.requireNonNull(etevidenceOfTraceabilitySystemAward.getText()).toString().trim();
        String systemTimeline = Objects.requireNonNull(etevidenceOfTraceabilitySystemTimeline.getText()).toString().trim();
        String systemRemarks = Objects.requireNonNull(etevidenceOfTraceabilitySystemRemarks.getText()).toString().trim();

        boolean valid = validateFields(isevidenceOfWorkerProtection, etevidenceOfWorkerProtectionAward, workersAward, etevidenceOfWorkerProtectionTimeline, workersTimeline, etevidenceOfWorkerProtectionRemarks, workersRemarks) &
                validateFields(iscopyOfHCD, etcopyOfHCDAward, copyAward, etcopyOfHCDTimeline, copyTimeline, etcopyOfHCDRemarks, copyRemarks) &
                validateFields(istraceabilityList, ettraceabilityListAward, listAward, ettraceabilityListTimeline, listTimeline, ettraceabilityListRemarks, listRemarks) &
                validateFields(isdeclareMarketingAgents, etdeclareMarketingAgentsAward, declareAward, etdeclareMarketingAgentsTimeline, declareTimeline, etdeclareMarketingAgentsRemarks, declareRemarks) &
                validateFields(isevidenceOfTraceabilitySystem, etevidenceOfTraceabilitySystemAward, systemAward, etevidenceOfTraceabilitySystemTimeline, systemTimeline, etevidenceOfTraceabilitySystemRemarks, systemRemarks);

        HorticulturalFlowerExportersDeskVettingBus horticulturalFlowerExportersDeskVettingBus = HorticulturalFlowerExportersDeskVettingBus.getInstance();
        horticulturalFlowerExportersDeskVettingBus.setIsEvidenceOfWorkerProtection(str_workers);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfWorkerProtectionAward(workersAward);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfWorkerProtectionTimeline(workersTimeline);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfWorkerProtectionRemarks(workersRemarks);
        horticulturalFlowerExportersDeskVettingBus.setIsCopyOfHCD(str_copy);
        horticulturalFlowerExportersDeskVettingBus.setCopyOfHCDAward(copyAward);
        horticulturalFlowerExportersDeskVettingBus.setCopyOfHCDTimeline(copyTimeline);
        horticulturalFlowerExportersDeskVettingBus.setCopyOfHCDRemarks(copyRemarks);
        horticulturalFlowerExportersDeskVettingBus.setIsTraceabilityList(str_list);
        horticulturalFlowerExportersDeskVettingBus.setTraceabilityListAward(listAward);
        horticulturalFlowerExportersDeskVettingBus.setTraceabilityListTimeline(listTimeline);
        horticulturalFlowerExportersDeskVettingBus.setTraceabilityListRemarks(listRemarks);
        horticulturalFlowerExportersDeskVettingBus.setIsDeclareMarkettingAgents(str_declare);
        horticulturalFlowerExportersDeskVettingBus.setDeclareMarkettingAgentsAward(declareAward);
        horticulturalFlowerExportersDeskVettingBus.setDeclareMarkettingAgentsTimeline(declareTimeline);
        horticulturalFlowerExportersDeskVettingBus.setDeclareMarkettingAgentsRemarks(declareRemarks);
        horticulturalFlowerExportersDeskVettingBus.setIsEvidenceOfTraceabilitySystems(str_system);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfTraceabilitySystemsAward(systemAward);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfTraceabilitySystemsTimeline(systemTimeline);
        horticulturalFlowerExportersDeskVettingBus.setEvidenceOfTraceabilitySystemsRemarks(systemRemarks);

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
