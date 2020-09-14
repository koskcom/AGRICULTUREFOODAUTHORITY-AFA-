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
import co.ke.bsl.data.view.HCDAvocadoQualityInspectionBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDAvocadoQualityInspectionChecklistStep4 extends Fragment implements BlockingStep {


    @BindView(R.id.isFruitFirm)
    CheckBox isFruitFirm;
    @BindView(R.id.etFruitFirmRemarks)
    CustomEditText etFruitFirmRemarks;

    @BindView(R.id.isForeignMatterPresent)
    CheckBox isForeignMatterPresent;
    @BindView(R.id.etForeignMatterPresentRemarks)
    CustomEditText etForeignMatterPresentRemarks;

    @BindView(R.id.isMoistureOnFruits)
    CheckBox isMoistureOnFruits;
    @BindView(R.id.etMoistureOnFruitsRemarks)
    CustomEditText etMoistureOnFruitsRemarks;

    @BindView(R.id.isPostHarvestTreatment)
    CheckBox isPostHarvestTreatment;
    @BindView(R.id.etPostHarvestTreatmentRemarks)
    CustomEditText etPostHarvestTreatmentRemarks;

    @BindView(R.id.etComments)
    CustomEditText etComments;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private String isFruitfirm, fruitFirmRemarks,isForeignmatterPresent,foreignMatterPresentRemarks,isMoistureonFruits,moistureOnFruitsRemarks;
    private String isPostharvestTreatment,postHarvestTreatmentRemarks,comments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdavocado_quality_inspection_checklist_step4, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        isFruitFirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFruitFirm.isChecked()) {
                    isFruitfirm = "Y";
                } else {
                    isFruitfirm = "N";
                }

            }
        });
        isForeignMatterPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isForeignMatterPresent.isChecked()) {
                    isForeignmatterPresent = "Y";
                } else {
                    isForeignmatterPresent = "N";
                }

            }
        }); isMoistureOnFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMoistureOnFruits.isChecked()) {
                    isMoistureonFruits = "Y";
                } else {
                    isMoistureonFruits = "N";
                }

            }
        }); isPostHarvestTreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPostHarvestTreatment.isChecked()) {
                    isPostharvestTreatment = "Y";
                } else {
                    isPostharvestTreatment = "N";
                }

            }
        });
        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        fruitFirmRemarks = Objects.requireNonNull(etFruitFirmRemarks.getText()).toString().trim();
        foreignMatterPresentRemarks = Objects.requireNonNull(etForeignMatterPresentRemarks.getText()).toString().trim();
        moistureOnFruitsRemarks = Objects.requireNonNull(etMoistureOnFruitsRemarks.getText()).toString().trim();
        postHarvestTreatmentRemarks = Objects.requireNonNull(etPostHarvestTreatmentRemarks.getText()).toString().trim();
        comments = Objects.requireNonNull(etComments.getText()).toString().trim();


        //validation
        boolean valid = validateFields(isFruitFirm, etFruitFirmRemarks, fruitFirmRemarks) &
                validateFields(isForeignMatterPresent, etForeignMatterPresentRemarks, foreignMatterPresentRemarks) &
                validateFields(isMoistureOnFruits, etMoistureOnFruitsRemarks, moistureOnFruitsRemarks) &
                validateFields(isPostHarvestTreatment, etPostHarvestTreatmentRemarks, postHarvestTreatmentRemarks);



        HCDAvocadoQualityInspectionBus hCDAvocadoQualityInspectionBus = HCDAvocadoQualityInspectionBus.getInstance();
        hCDAvocadoQualityInspectionBus.setIsFruitfirm(isFruitfirm);
        hCDAvocadoQualityInspectionBus.setFruitFirmRemarks(fruitFirmRemarks);
        hCDAvocadoQualityInspectionBus.setIsForeignmatterPresent(isForeignmatterPresent);
        hCDAvocadoQualityInspectionBus.setForeignMatterPresentRemarks(foreignMatterPresentRemarks);
        hCDAvocadoQualityInspectionBus.setIsMoistureonFruits(isMoistureonFruits);
        hCDAvocadoQualityInspectionBus.setMoistureOnFruitsRemarks(moistureOnFruitsRemarks);
        hCDAvocadoQualityInspectionBus.setIsPostharvestTreatment(isPostharvestTreatment);
        hCDAvocadoQualityInspectionBus.setPostHarvestTreatmentRemarks(postHarvestTreatmentRemarks);
        hCDAvocadoQualityInspectionBus.setComments(comments);


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
