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
public class FCDCottonBuyingStoreInspectionConformityAssessmentStep3 extends Fragment implements BlockingStep {


    @BindView(R.id.isProperlyClean)
    CheckBox isProperlyClean;
    @BindView(R.id.etProperlyCleanRemarks)
    CustomEditText etProperlyCleanRemarks;
    @BindView(R.id.isIntact)
    CheckBox isIntact;
    @BindView(R.id.etIntactRemarks)
    CustomEditText etIntactRemarks;
    @BindView(R.id.isFumigated)
    CheckBox isFumigated;
    @BindView(R.id.etFumigatedRemarks)
    CustomEditText etFumigatedRemarks;


    private String isProperlyclean, properlycleanRemarks, isintact, intactRemarks, isfumigated, fumigatedRemarks;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdcotton_buying_store_inspection_conformity_assessment_step3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        isProperlyClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProperlyClean.isChecked()) {
                    isProperlyclean = "Y";
                } else {
                    isProperlyclean = "N";
                }

            }
        });
        isIntact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isIntact.isChecked()) {
                    isintact = "Y";
                } else {
                    isintact = "N";
                }

            }
        });
        isFumigated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFumigated.isChecked()) {
                    isfumigated = "Y";
                } else {
                    isfumigated = "N";
                }

            }
        });
        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        properlycleanRemarks = Objects.requireNonNull(etProperlyCleanRemarks.getText()).toString().trim();
        intactRemarks = Objects.requireNonNull(etIntactRemarks.getText()).toString().trim();
        fumigatedRemarks = Objects.requireNonNull(etFumigatedRemarks.getText()).toString().trim();

        //validation
        boolean valid = validateFields(isProperlyClean, etProperlyCleanRemarks, properlycleanRemarks) &
                validateFields(isIntact, etIntactRemarks, intactRemarks) &
                validateFields(isFumigated, etFumigatedRemarks, fumigatedRemarks);


        FCDCottonBuyingStoreInspectionBus fCDCottonBuyingStoreInspectionBus = FCDCottonBuyingStoreInspectionBus.getInstance();
        fCDCottonBuyingStoreInspectionBus.setIsProperlyclean(isProperlyclean);
        fCDCottonBuyingStoreInspectionBus.setProperlycleanRemarks(properlycleanRemarks);
        fCDCottonBuyingStoreInspectionBus.setIsintact(isintact);
        fCDCottonBuyingStoreInspectionBus.setIntactRemarks(intactRemarks);
        fCDCottonBuyingStoreInspectionBus.setIsfumigated(isfumigated);
        fCDCottonBuyingStoreInspectionBus.setFumigatedRemarks(fumigatedRemarks);


        if (valid ) {
            callback.goToNextStep();
        }



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
