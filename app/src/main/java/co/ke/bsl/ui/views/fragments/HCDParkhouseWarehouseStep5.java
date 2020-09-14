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
public class HCDParkhouseWarehouseStep5 extends Fragment implements BlockingStep {


    @BindView(R.id.isWorkingAreaAndPremisesKept)
    CheckBox isWorkingAreaAndPremisesKept;
    @BindView(R.id.etWorkingAreaAndPremisesKeptRemarks)
    CustomEditText etWorkingAreaAndPremisesKeptRemarks;

    @BindView(R.id.isPersonalWearing)
    CheckBox isPersonalWearing;
    @BindView(R.id.etPersonalWearingRemarks)
    CustomEditText etPersonalWearingRemarks;

    @BindView(R.id.isFoodHandlingPersonel)
    CheckBox isFoodHandlingPersonel;
    @BindView(R.id.etFoodHandlingPersonelRemarks)
    CustomEditText etFoodHandlingPersonelRemarks;

    @BindView(R.id.isFoodhandlingEquipment)
    CheckBox isFoodhandlingEquipment;
    @BindView(R.id.etFoodhandlingEquipmentRemarks)
    CustomEditText etFoodhandlingEquipmentRemarks;

    @BindView(R.id.isAdequateVentillation)
    CheckBox isAdequateVentillation;
    @BindView(R.id.etAdequateVentillationRemarks)
    CustomEditText etAdequateVentillationRemarks;

    @BindView(R.id.isFacilityConformshealthAct)
    CheckBox isFacilityConformshealthAct;
    @BindView(R.id.etFacilityConformshealthActRemarks)
    CustomEditText etFacilityConformshealthActRemarks;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private String isWorkingAreaandPremisesKept, workingAreaAndPremisesKeptRemarks, isPersonalwearing, personalWearingRemarks, isFoodhandlingPersonel, foodhandlingPersonelRemarks, isFoodhandlingequipment, foodhandlingEquipmentRemarks;
    private String isAdequateventillation, adequateVentillationRemarks, isFacilityconformshealthAct, facilityConformshealthActRemarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdparkhouse_warehouse_step5, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        isWorkingAreaAndPremisesKept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWorkingAreaAndPremisesKept.isChecked()) {
                    isWorkingAreaandPremisesKept = "Y";
                } else {
                    isWorkingAreaandPremisesKept = "N";
                }

            }
        });

        isPersonalWearing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPersonalWearing.isChecked()) {
                    isPersonalwearing = "Y";
                } else {
                    isPersonalwearing = "N";
                }

            }
        });

        isFoodHandlingPersonel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFoodHandlingPersonel.isChecked()) {
                    isFoodhandlingPersonel = "Y";
                } else {
                    isFoodhandlingPersonel = "N";
                }

            }
        });

        isFoodhandlingEquipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFoodhandlingEquipment.isChecked()) {
                    isFoodhandlingequipment = "Y";
                } else {
                    isFoodhandlingequipment = "N";
                }

            }
        });

        isAdequateVentillation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAdequateVentillation.isChecked()) {
                    isAdequateventillation = "Y";
                } else {
                    isAdequateventillation = "N";
                }

            }
        });

        isFacilityConformshealthAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFacilityConformshealthAct.isChecked()) {
                    isFacilityconformshealthAct = "Y";
                } else {
                    isFacilityconformshealthAct = "N";
                }

            }
        });
        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        workingAreaAndPremisesKeptRemarks = Objects.requireNonNull(etWorkingAreaAndPremisesKeptRemarks.getText()).toString().trim();
        personalWearingRemarks = Objects.requireNonNull(etPersonalWearingRemarks.getText()).toString().trim();
        foodhandlingPersonelRemarks = Objects.requireNonNull(etFoodHandlingPersonelRemarks.getText()).toString().trim();
        foodhandlingEquipmentRemarks = Objects.requireNonNull(etFoodhandlingEquipmentRemarks.getText()).toString().trim();
        adequateVentillationRemarks = Objects.requireNonNull(etAdequateVentillationRemarks.getText()).toString().trim();
        facilityConformshealthActRemarks = Objects.requireNonNull(etFacilityConformshealthActRemarks.getText()).toString().trim();
        //validation
        boolean valid = validateFields(isWorkingAreaAndPremisesKept, etWorkingAreaAndPremisesKeptRemarks, workingAreaAndPremisesKeptRemarks) &
                validateFields(isPersonalWearing, etPersonalWearingRemarks, personalWearingRemarks) &
                validateFields(isFoodHandlingPersonel, etFoodHandlingPersonelRemarks, foodhandlingPersonelRemarks) &
                validateFields(isFoodhandlingEquipment, etFoodhandlingEquipmentRemarks, foodhandlingEquipmentRemarks) &
                validateFields(isAdequateVentillation, etAdequateVentillationRemarks, adequateVentillationRemarks) &
                validateFields(isFacilityConformshealthAct, etFacilityConformshealthActRemarks, facilityConformshealthActRemarks);


        HCDParkhouseWarehouseBus hCDParkhouseWarehouseBus = HCDParkhouseWarehouseBus.getInstance();

        hCDParkhouseWarehouseBus.setIsWorkingAreaandPremisesKept(isWorkingAreaandPremisesKept);
        hCDParkhouseWarehouseBus.setWorkingAreaAndPremisesKeptRemarks(workingAreaAndPremisesKeptRemarks);
        hCDParkhouseWarehouseBus.setIsPersonalwearing(isPersonalwearing);
        hCDParkhouseWarehouseBus.setPersonalWearingRemarks(personalWearingRemarks);
        hCDParkhouseWarehouseBus.setIsFoodhandlingPersonel(isFoodhandlingPersonel);
        hCDParkhouseWarehouseBus.setFoodhandlingPersonelRemarks(foodhandlingPersonelRemarks);
        hCDParkhouseWarehouseBus.setIsFoodhandlingequipment(isFoodhandlingequipment);
        hCDParkhouseWarehouseBus.setFoodhandlingEquipmentRemarks(foodhandlingEquipmentRemarks);
        hCDParkhouseWarehouseBus.setIsAdequateventillation(isAdequateventillation);
        hCDParkhouseWarehouseBus.setAdequateVentillationRemarks(adequateVentillationRemarks);
        hCDParkhouseWarehouseBus.setIsFacilityconformshealthAct(isFacilityconformshealthAct);
        hCDParkhouseWarehouseBus.setAcilityConformshealthActRemarks(facilityConformshealthActRemarks);

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
