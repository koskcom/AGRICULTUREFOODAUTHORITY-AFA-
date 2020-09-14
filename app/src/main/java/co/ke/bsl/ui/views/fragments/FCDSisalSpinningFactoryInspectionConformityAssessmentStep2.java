package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
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
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.FCDSisalFactoryInspectionBus;
import co.ke.bsl.data.view.FCDSisalSpinningFactoryInspectionBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDSisalSpinningFactoryInspectionConformityAssessmentStep2 extends Fragment implements BlockingStep {


    @BindView(R.id.isValidTradingLicence)
    CheckBox isValidTradingLicence;
    @BindView(R.id.etValidTradingLicenceRemarks)
    CustomEditText etValidTradingLicenceRemarks;
    @BindView(R.id.isValidNEMACerificaion)
    CheckBox isValidNEMACerificaion;
    @BindView(R.id.etValidNEMACerificaionRemarks)
    CustomEditText etValidNEMACerificaionRemarks;
    @BindView(R.id.isFireRiskAssessment)
    CheckBox isFireRiskAssessment;
    @BindView(R.id.etFireRiskAssessmentRemarks)
    CustomEditText etFireRiskAssessmentRemarks;
    @BindView(R.id.isOccupationalHealthReport)
    CheckBox isOccupationalHealthReport;
    @BindView(R.id.etOccupationalHealthReportRemarks)
    CustomEditText etOccupationalHealthReportRemarks;
    @BindView(R.id.isFireMarshalls)
    CheckBox isFireMarshalls;
    @BindView(R.id.etFireMarshallsRemarks)
    CustomEditText etFireMarshallsRemarks;
    @BindView(R.id.isAccessibleFireemergencyexits)
    CheckBox isAccessibleFireemergencyexits;
    @BindView(R.id.etAccessibleFireemergencyexitsRemarks)
    CustomEditText etAccessibleFireemergencyexitsRemarks;
    @BindView(R.id.isFirstAidKit)
    CheckBox isFirstAidKit;
    @BindView(R.id.etFirstAidKitRemarks)
    CustomEditText etFirstAidKitRemarks;
    @BindView(R.id.isAppropriateProtectiveclothing)
    CheckBox isAppropriateProtectiveclothing;
    @BindView(R.id.etAppropriateProtectiveclothingRemarks)
    CustomEditText etAppropriateProtectiveclothingRemarks;
    @BindView(R.id.isProtectedMovingParts)
    CheckBox isProtectedMovingParts;
    @BindView(R.id.etProtectedMovingPartsRemarks)
    CustomEditText etProtectedMovingPartsRemarks;
    @BindView(R.id.isGeneralCondition)
    CheckBox isGeneralCondition;
    @BindView(R.id.etGeneralConditionRemarks)
    CustomEditText etGeneralConditionRemarks;
    @BindView(R.id.isStorageCondition)
    CheckBox isStorageCondition;
    @BindView(R.id.etStorageConditionRemarks)
    CustomEditText etStorageConditionRemarks;
    @BindView(R.id.isProofOfSubmission)
    CheckBox isProofOfSubmission;
    @BindView(R.id.etProofOfSubmissionRemarks)
    CustomEditText etProofOfSubmissionRemarks;
    @BindView(R.id.isCertificationByAFA)
    CheckBox isCertificationByAFA;
    @BindView(R.id.etCertificationByAFARemarks)
    CustomEditText etCertificationByAFARemarks;

    private String isValidTradinglicence, validTradinglicenceRemarks, isValidNeMACerificaion, validNeMACerificaionRemarks, isFireriskAssessment, fireriskAssessmentRemarks;
    private String isOccupationalhealthReport, occupationalhealthReportRemarks, isFiremarshalls, firemarshallsRemarks, isAccessiblefireemergencyexits, accessibleFireemergencyexitsRemarks;
    private String isFirstAidkit, firstAidkitRemarks, isAppropriateprotectiveclothing, appropriateprotectiveclothing, isProtectedmovingParts, protectedmovingParts;
    private String isGeneralcondition, generalconditionRemarks, isStoragecondition, storageconditionRemarks, isProofofSubmission, proofofSubmission, isCertificationbyAFA, certificationbyAFARemarks;


    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdsisal_spinning_factory_inspection_conformity_assessment_step2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        isValidTradingLicence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidTradingLicence.isChecked()) {
                    isValidTradinglicence = "Y";
                } else {
                    isValidTradinglicence = "N";
                }
            }
        });

        isValidNEMACerificaion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidNEMACerificaion.isChecked()) {
                    isValidNeMACerificaion = "Y";
                } else {
                    isValidNeMACerificaion = "N";
                }
            }
        });

        isFireRiskAssessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFireRiskAssessment.isChecked()) {
                    isFireriskAssessment = "Y";
                } else {
                    isFireriskAssessment = "N";
                }
            }
        });

        isOccupationalHealthReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOccupationalHealthReport.isChecked()) {
                    isOccupationalhealthReport = "Y";
                } else {
                    isOccupationalhealthReport = "N";
                }
            }
        });

        isFireMarshalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFireMarshalls.isChecked()) {
                    isFiremarshalls = "Y";
                } else {
                    isFiremarshalls = "N";
                }
            }
        });
        isAccessibleFireemergencyexits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAccessibleFireemergencyexits.isChecked()) {
                    isAccessiblefireemergencyexits = "Y";
                } else {
                    isAccessiblefireemergencyexits = "N";
                }
            }
        });

        isFirstAidKit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFirstAidKit.isChecked()) {
                    isFirstAidkit = "Y";
                } else {
                    isFirstAidkit = "N";
                }
            }
        });

        isAppropriateProtectiveclothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAppropriateProtectiveclothing.isChecked()) {
                    isAppropriateprotectiveclothing = "Y";
                } else {
                    isAppropriateprotectiveclothing = "N";
                }
            }
        });

        isProtectedMovingParts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProtectedMovingParts.isChecked()) {
                    isProtectedmovingParts = "Y";
                } else {
                    isProtectedmovingParts = "N";
                }
            }
        });

        isGeneralCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isGeneralCondition.isChecked()) {
                    isGeneralcondition = "Y";
                } else {
                    isGeneralcondition = "N";
                }
            }
        });

        isStorageCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStorageCondition.isChecked()) {
                    isStoragecondition = "Y";
                } else {
                    isStoragecondition = "N";
                }
            }
        });

        isProofOfSubmission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProofOfSubmission.isChecked()) {
                    isProofofSubmission = "Y";
                } else {
                    isProofofSubmission = "N";
                }
            }
        });

        isCertificationByAFA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCertificationByAFA.isChecked()) {
                    isCertificationbyAFA = "Y";
                } else {
                    isCertificationbyAFA = "N";
                }
            }
        });

        return view;


    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        validTradinglicenceRemarks = Objects.requireNonNull(etValidTradingLicenceRemarks.getText()).toString().trim();
        validNeMACerificaionRemarks = Objects.requireNonNull(etValidNEMACerificaionRemarks.getText()).toString().trim();
        fireriskAssessmentRemarks = Objects.requireNonNull(etFireRiskAssessmentRemarks.getText()).toString().trim();
        occupationalhealthReportRemarks = Objects.requireNonNull(etOccupationalHealthReportRemarks.getText()).toString().trim();
        firemarshallsRemarks = Objects.requireNonNull(etFireMarshallsRemarks.getText()).toString().trim();
        accessibleFireemergencyexitsRemarks = Objects.requireNonNull(etAccessibleFireemergencyexitsRemarks.getText()).toString().trim();
        firstAidkitRemarks = Objects.requireNonNull(etFirstAidKitRemarks.getText()).toString().trim();
        appropriateprotectiveclothing = Objects.requireNonNull(etAppropriateProtectiveclothingRemarks.getText()).toString().trim();
        protectedmovingParts = Objects.requireNonNull(etProtectedMovingPartsRemarks.getText()).toString().trim();
        generalconditionRemarks = Objects.requireNonNull(etGeneralConditionRemarks.getText()).toString().trim();
        storageconditionRemarks = Objects.requireNonNull(etStorageConditionRemarks.getText()).toString().trim();
        proofofSubmission = Objects.requireNonNull(etProofOfSubmissionRemarks.getText()).toString().trim();
        certificationbyAFARemarks = Objects.requireNonNull(etCertificationByAFARemarks.getText()).toString().trim();

        boolean valid = validateFields(isValidTradingLicence, etValidTradingLicenceRemarks, validTradinglicenceRemarks) &
                validateFields(isValidNEMACerificaion, etValidNEMACerificaionRemarks, validNeMACerificaionRemarks) &
                validateFields(isFireRiskAssessment, etFireRiskAssessmentRemarks, fireriskAssessmentRemarks) &
                validateFields(isOccupationalHealthReport, etOccupationalHealthReportRemarks, occupationalhealthReportRemarks) &
                validateFields(isFireMarshalls, etFireMarshallsRemarks, firemarshallsRemarks) &
                validateFields(isAccessibleFireemergencyexits, etAccessibleFireemergencyexitsRemarks, accessibleFireemergencyexitsRemarks) &
                validateFields(isFirstAidKit, etFirstAidKitRemarks, firstAidkitRemarks) &
                validateFields(isAppropriateProtectiveclothing, etAppropriateProtectiveclothingRemarks, appropriateprotectiveclothing) &
                validateFields(isProtectedMovingParts, etProtectedMovingPartsRemarks, protectedmovingParts) &
                validateFields(isGeneralCondition, etGeneralConditionRemarks, generalconditionRemarks) &
                validateFields(isStorageCondition, etStorageConditionRemarks, storageconditionRemarks) &
                validateFields(isProofOfSubmission, etProofOfSubmissionRemarks, proofofSubmission) &
                validateFields(isCertificationByAFA, etCertificationByAFARemarks, certificationbyAFARemarks);


        FCDSisalSpinningFactoryInspectionBus fCDSisalSpinningFactoryInspectionBus = FCDSisalSpinningFactoryInspectionBus.getInstance();

        fCDSisalSpinningFactoryInspectionBus.setIsValidTradinglicence(isValidTradinglicence);
        fCDSisalSpinningFactoryInspectionBus.setValidTradinglicenceRemarks(validTradinglicenceRemarks);
        fCDSisalSpinningFactoryInspectionBus.setIsValidNeMACerificaion(isValidNeMACerificaion);
        fCDSisalSpinningFactoryInspectionBus.setValidNeMACerificaionRemarks(validNeMACerificaionRemarks);
        fCDSisalSpinningFactoryInspectionBus.setIsFireriskAssessment(isFireriskAssessment);
        fCDSisalSpinningFactoryInspectionBus.setFireriskAssessmentRemarks(fireriskAssessmentRemarks);
        fCDSisalSpinningFactoryInspectionBus.setIsOccupationalhealthReport(isOccupationalhealthReport);
        fCDSisalSpinningFactoryInspectionBus.setOccupationalhealthReportRemarks(occupationalhealthReportRemarks);
        fCDSisalSpinningFactoryInspectionBus.setIsFiremarshalls(isFiremarshalls);
        fCDSisalSpinningFactoryInspectionBus.setFiremarshallsRemarks(firemarshallsRemarks);
        fCDSisalSpinningFactoryInspectionBus.setIsAccessiblefireemergencyexits(isAccessiblefireemergencyexits);
        fCDSisalSpinningFactoryInspectionBus.setAccessibleFireemergencyexitsRemarks(accessibleFireemergencyexitsRemarks);
        fCDSisalSpinningFactoryInspectionBus.setIsFirstAidkit(isFirstAidkit);
        fCDSisalSpinningFactoryInspectionBus.setFirstAidkitRemarks(firstAidkitRemarks);
        fCDSisalSpinningFactoryInspectionBus.setIsAppropriateprotectiveclothing(isAppropriateprotectiveclothing);
        fCDSisalSpinningFactoryInspectionBus.setAppropriateprotectiveclothing(appropriateprotectiveclothing);
        fCDSisalSpinningFactoryInspectionBus.setIsProtectedmovingParts(isProtectedmovingParts);
        fCDSisalSpinningFactoryInspectionBus.setProtectedmovingParts(protectedmovingParts);
        fCDSisalSpinningFactoryInspectionBus.setIsGeneralcondition(isGeneralcondition);
        fCDSisalSpinningFactoryInspectionBus.setGeneralconditionRemarks(generalconditionRemarks);
        fCDSisalSpinningFactoryInspectionBus.setIsStoragecondition(isStoragecondition);
        fCDSisalSpinningFactoryInspectionBus.setStorageconditionRemarks(storageconditionRemarks);
        fCDSisalSpinningFactoryInspectionBus.setIsProofofSubmission(isProofofSubmission);
        fCDSisalSpinningFactoryInspectionBus.setProofofSubmission(proofofSubmission);
        fCDSisalSpinningFactoryInspectionBus.setIsCertificationbyAFA(isCertificationbyAFA);
        fCDSisalSpinningFactoryInspectionBus.setCertificationbyAFARemarks(certificationbyAFARemarks);

        if (valid) {
            callback.goToNextStep();
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
            }
            else result =true;
        } else {
            customEditText.setError(null);
            result = true;
        }

        return result;
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
}
