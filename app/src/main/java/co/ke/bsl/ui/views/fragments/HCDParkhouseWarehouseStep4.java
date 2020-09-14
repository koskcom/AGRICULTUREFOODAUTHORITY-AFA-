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
import co.ke.bsl.data.view.HCDParkhouseWarehouseBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDParkhouseWarehouseStep4 extends Fragment implements BlockingStep {


    @BindView(R.id.isChemicallistapproved)
    CheckBox isChemicallistapproved;
    @BindView(R.id.etChemicallistapprovedRemarks)
    CustomEditText etChemicallistapprovedRemarks;

    @BindView(R.id.isTradenameOftheProductRecorded)
    CheckBox isTradenameOftheProductRecorded;
    @BindView(R.id.etTradenameOftheProductRecordedRemarks)
    CustomEditText etTradenameOftheProductRecordedRemarks;

    @BindView(R.id.isAmountOfChemicalAppliedRecorded)
    CheckBox isAmountOfChemicalAppliedRecorded;
    @BindView(R.id.etAmountOfChemicalAppliedRecordedRemarks)
    CustomEditText etAmountOfChemicalAppliedRecordedRemarks;

    @BindView(R.id.isTrainingSchedule)
    CheckBox isTrainingSchedule;
    @BindView(R.id.etTrainingScheduleRemarks)
    CustomEditText etTrainingScheduleRemarks;

    @BindView(R.id.isListOfProduceHandling)
    CheckBox isListOfProduceHandling;
    @BindView(R.id.etListOfProduceHandlingRemarks)
    CustomEditText etListOfProduceHandlingRemarks;

    @BindView(R.id.isProofOfTraining)
    CheckBox isProofOfTraining;
    @BindView(R.id.etProofOfTrainingRemarks)
    CustomEditText etProofOfTrainingRemarks;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private String isChemicalListapproved, chemicallistapprovedRemarks, isTradenameoftheProductRecorded, tradenameOftheProductRecordedRemarks, isAmountofChemicalAppliedRecorded, amountOfChemicalAppliedRecordedRemarks;
    private String isTrainingschedule, trainingScheduleRemarks, isListofProduceHandling, ListofProduceHandlingRemarks, isproofOfTraining, proofOfTrainingRemarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdparkhouse_warehouse_step4, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        isChemicallistapproved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChemicallistapproved.isChecked()) {
                    isChemicalListapproved = "Y";
                } else {
                    isChemicalListapproved = "N";
                }

            }
        });

        isTradenameOftheProductRecorded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTradenameOftheProductRecorded.isChecked()) {
                    isTradenameoftheProductRecorded = "Y";
                } else {
                    isTradenameoftheProductRecorded = "N";
                }

            }
        });

        isAmountOfChemicalAppliedRecorded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAmountOfChemicalAppliedRecorded.isChecked()) {
                    isAmountofChemicalAppliedRecorded = "Y";
                } else {
                    isAmountofChemicalAppliedRecorded = "N";
                }

            }
        });

        isTrainingSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTrainingSchedule.isChecked()) {
                    isTrainingschedule = "Y";
                } else {
                    isTrainingschedule = "N";
                }

            }
        });

        isListOfProduceHandling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isListOfProduceHandling.isChecked()) {
                    isListofProduceHandling = "Y";
                } else {
                    isListofProduceHandling = "N";
                }

            }
        });

        isProofOfTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProofOfTraining.isChecked()) {
                    isproofOfTraining = "Y";
                } else {
                    isproofOfTraining = "N";
                }

            }
        });
        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        chemicallistapprovedRemarks = Objects.requireNonNull(etChemicallistapprovedRemarks.getText()).toString().trim();
        tradenameOftheProductRecordedRemarks = Objects.requireNonNull(etTradenameOftheProductRecordedRemarks.getText()).toString().trim();
        amountOfChemicalAppliedRecordedRemarks = Objects.requireNonNull(etAmountOfChemicalAppliedRecordedRemarks.getText()).toString().trim();
        trainingScheduleRemarks = Objects.requireNonNull(etTrainingScheduleRemarks.getText()).toString().trim();
        ListofProduceHandlingRemarks = Objects.requireNonNull(etListOfProduceHandlingRemarks.getText()).toString().trim();
        proofOfTrainingRemarks = Objects.requireNonNull(etProofOfTrainingRemarks.getText()).toString().trim();

        //validation
        boolean valid = validateFields(isChemicallistapproved, etChemicallistapprovedRemarks, chemicallistapprovedRemarks) &
                validateFields(isTradenameOftheProductRecorded, etTradenameOftheProductRecordedRemarks, tradenameOftheProductRecordedRemarks) &
                validateFields(isAmountOfChemicalAppliedRecorded, etAmountOfChemicalAppliedRecordedRemarks, amountOfChemicalAppliedRecordedRemarks) &
                validateFields(isTrainingSchedule, etTrainingScheduleRemarks, trainingScheduleRemarks) &
                validateFields(isListOfProduceHandling, etListOfProduceHandlingRemarks, ListofProduceHandlingRemarks) &
                validateFields(isProofOfTraining, etProofOfTrainingRemarks, proofOfTrainingRemarks);


        HCDParkhouseWarehouseBus hCDParkhouseWarehouseBus = HCDParkhouseWarehouseBus.getInstance();

        hCDParkhouseWarehouseBus.setIsChemicalListapproved(isChemicalListapproved);
        hCDParkhouseWarehouseBus.setHemicallistapprovedRemarks(chemicallistapprovedRemarks);
        hCDParkhouseWarehouseBus.setIsTradenameoftheProductRecorded(isTradenameoftheProductRecorded);
        hCDParkhouseWarehouseBus.setTradenameOftheProductRecordedRemarks(tradenameOftheProductRecordedRemarks);
        hCDParkhouseWarehouseBus.setIsAmountofChemicalAppliedRecorded(isAmountofChemicalAppliedRecorded);
        hCDParkhouseWarehouseBus.setAmountOfChemicalAppliedRecordedRemarks(amountOfChemicalAppliedRecordedRemarks);
        hCDParkhouseWarehouseBus.setIsTrainingschedule(isTrainingschedule);
        hCDParkhouseWarehouseBus.setTrainingScheduleRemarks(trainingScheduleRemarks);
        hCDParkhouseWarehouseBus.setIsListofProduceHandling(isListofProduceHandling);
        hCDParkhouseWarehouseBus.setListofProduceHandlingRemarks(ListofProduceHandlingRemarks);
        hCDParkhouseWarehouseBus.setIsproofOfTraining(isproofOfTraining);
        hCDParkhouseWarehouseBus.setProofOfTrainingRemarks(proofOfTrainingRemarks);

        if (valid) {
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
