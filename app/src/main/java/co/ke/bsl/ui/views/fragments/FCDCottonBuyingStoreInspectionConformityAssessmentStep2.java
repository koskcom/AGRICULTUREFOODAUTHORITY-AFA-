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
import co.ke.bsl.data.view.FCDCottonBuyingStoreInspectionBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDCottonBuyingStoreInspectionConformityAssessmentStep2 extends Fragment implements BlockingStep {


    @BindView(R.id.etnameOfOperator)
    CustomEditText etnameOfOperator;
    @BindView(R.id.isSurroundingsOfBuyingSanitaryCondition)
    CheckBox isSurroundingsOfBuyingSanitaryCondition;
    @BindView(R.id.etSurroundingsOfBuyingSanitaryConditionRemarks)
    CustomEditText etSurroundingsOfBuyingSanitaryConditionRemarks;
    @BindView(R.id.isFloorWellSurfaced)
    CheckBox isFloorWellSurfaced;
    @BindView(R.id.etFloorWellSurfacedRemarks)
    CustomEditText etFloorWellSurfacedRemarks;
    @BindView(R.id.isGradeBoxApproved)
    CheckBox isGradeBoxApproved;
    @BindView(R.id.etGradeBoxApprovedRemarks)
    CustomEditText etGradeBoxApprovedRemarks;
    @BindView(R.id.isCertifiedWeighingScale)
    CheckBox isCertifiedWeighingScale;
    @BindView(R.id.etCertifiedWeighingScaleRemarks)
    CustomEditText etCertifiedWeighingScaleRemarks;
    @BindView(R.id.isCottonBuyerCenterQualified)
    CheckBox isCottonBuyerCenterQualified;
    @BindView(R.id.etCottonBuyerCenterQualifiedRemarks)
    CustomEditText etCottonBuyerCenterQualifiedRemarks;

    @BindView(R.id.isFirePrecauionaryMeasure)
    CheckBox isFirePrecauionaryMeasure;
    @BindView(R.id.etFirePrecauionaryMeasureRemarks)
    CustomEditText etFirePrecauionaryMeasureRemarks;

    private String nameOfOperator, isSurroundingsofBuyingSanitaryCondition, surroundingsofBuyingSanitaryConditionRemarks, isFloorWellsurfaced, floorWellsurfacedRemarks, isGradeBoxapproved, gradeBoxapprovedRemarks;
    private String isCertifiedWeighingscale, certifiedWeighingScaleRemarks, isCottonBuyercenterQualified, cottonBuyercenterQualifiedRemarks, isFirePrecauionarymeasure, firePrecauionarymeasureRemarks;


    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdcotton_buying_store_inspection_conformity_assessment_step2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        isSurroundingsOfBuyingSanitaryCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSurroundingsOfBuyingSanitaryCondition.isChecked()) {
                    isSurroundingsofBuyingSanitaryCondition = "Y";
                } else {
                    isSurroundingsofBuyingSanitaryCondition = "N";
                }

            }
        });

        isFloorWellSurfaced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFloorWellSurfaced.isChecked()) {
                    isFloorWellsurfaced = "Y";
                } else {
                    isFloorWellsurfaced = "N";
                }

            }
        });
        isGradeBoxApproved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isGradeBoxApproved.isChecked()) {
                    isGradeBoxapproved = "Y";
                } else {
                    isGradeBoxapproved = "N";
                }

            }
        });
        isCertifiedWeighingScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCertifiedWeighingScale.isChecked()) {
                    isCertifiedWeighingscale = "Y";
                } else {
                    isCertifiedWeighingscale = "N";
                }

            }
        });
        isCottonBuyerCenterQualified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCottonBuyerCenterQualified.isChecked()) {
                    isCottonBuyercenterQualified = "Y";
                } else {
                    isCottonBuyercenterQualified = "N";
                }

            }
        }); isFirePrecauionaryMeasure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFirePrecauionaryMeasure.isChecked()) {
                    isFirePrecauionarymeasure = "Y";
                } else {
                    isFirePrecauionarymeasure = "N";
                }

            }
        });
        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        nameOfOperator = Objects.requireNonNull(etnameOfOperator.getText()).toString().trim();
        surroundingsofBuyingSanitaryConditionRemarks = Objects.requireNonNull(etSurroundingsOfBuyingSanitaryConditionRemarks.getText()).toString().trim();
        floorWellsurfacedRemarks = Objects.requireNonNull(etFloorWellSurfacedRemarks.getText()).toString().trim();
        gradeBoxapprovedRemarks = Objects.requireNonNull(etGradeBoxApprovedRemarks.getText()).toString().trim();
        certifiedWeighingScaleRemarks = Objects.requireNonNull(etCertifiedWeighingScaleRemarks.getText()).toString().trim();
        cottonBuyercenterQualifiedRemarks = Objects.requireNonNull(etCottonBuyerCenterQualifiedRemarks.getText()).toString().trim();
        firePrecauionarymeasureRemarks = Objects.requireNonNull(etFirePrecauionaryMeasureRemarks.getText()).toString().trim();

        //validation
        boolean valid = validateEditText(etnameOfOperator, nameOfOperator) &
                validateFields(isSurroundingsOfBuyingSanitaryCondition, etSurroundingsOfBuyingSanitaryConditionRemarks, surroundingsofBuyingSanitaryConditionRemarks) &
                validateFields(isFloorWellSurfaced, etFloorWellSurfacedRemarks, floorWellsurfacedRemarks) &
                validateFields(isGradeBoxApproved, etGradeBoxApprovedRemarks, gradeBoxapprovedRemarks) &
                validateFields(isCertifiedWeighingScale, etCertifiedWeighingScaleRemarks, certifiedWeighingScaleRemarks) &
                validateFields(isCottonBuyerCenterQualified, etCottonBuyerCenterQualifiedRemarks, cottonBuyercenterQualifiedRemarks) &
                validateFields(isFirePrecauionaryMeasure, etFirePrecauionaryMeasureRemarks, firePrecauionarymeasureRemarks) ;

        FCDCottonBuyingStoreInspectionBus fCDCottonBuyingStoreInspectionBus = FCDCottonBuyingStoreInspectionBus.getInstance();
        fCDCottonBuyingStoreInspectionBus.setNameOfOperator(nameOfOperator);
        fCDCottonBuyingStoreInspectionBus.setIsSurroundingsofBuyingSanitaryCondition(isSurroundingsofBuyingSanitaryCondition);
        fCDCottonBuyingStoreInspectionBus.setSurroundingsofBuyingSanitaryConditionRemarks(surroundingsofBuyingSanitaryConditionRemarks);
        fCDCottonBuyingStoreInspectionBus.setIsFloorWellsurfaced(isFloorWellsurfaced);
        fCDCottonBuyingStoreInspectionBus.setFloorWellsurfacedRemarks(floorWellsurfacedRemarks);
        fCDCottonBuyingStoreInspectionBus.setIsGradeBoxapproved(isGradeBoxapproved);
        fCDCottonBuyingStoreInspectionBus.setGradeBoxapprovedRemarks(gradeBoxapprovedRemarks);
        fCDCottonBuyingStoreInspectionBus.setIsCertifiedWeighingscale(isCertifiedWeighingscale);
        fCDCottonBuyingStoreInspectionBus.setCertifiedWeighingScaleRemarks(certifiedWeighingScaleRemarks);
        fCDCottonBuyingStoreInspectionBus.setIsCottonBuyercenterQualified(isCottonBuyercenterQualified);
        fCDCottonBuyingStoreInspectionBus.setCottonBuyercenterQualifiedRemarks(cottonBuyercenterQualifiedRemarks);
        fCDCottonBuyingStoreInspectionBus.setIsFirePrecauionarymeasure(isFirePrecauionarymeasure);
        fCDCottonBuyingStoreInspectionBus.setFirePrecauionarymeasureRemarks(firePrecauionarymeasureRemarks);


        if (valid ) {
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
