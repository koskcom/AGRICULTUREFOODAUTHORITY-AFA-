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
import co.ke.bsl.data.view.HorticultureCropExportLicenceFarmInspectionBus;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorticultureLicenceFarmInspectionDetails3 extends Fragment implements BlockingStep {

    @BindView(R.id.isTrainingSchedules)
    CheckBox isTrainingSchedules;
    @BindView(R.id.etHLFITrainingSchedules)
    CustomEditText etHLFITrainingSchedules;

    @BindView(R.id.isTherePestManagement)
    CheckBox isTherePestManagement;
    @BindView(R.id.etHLFITherePestManagement)
    CustomEditText etHLFITherePestManagement;

    @BindView(R.id.isThereEvidenceOnScouring)
    CheckBox isThereEvidenceOnScouring;
    @BindView(R.id.etHLFIThereEvidenceOnScouring)
    CustomEditText etHLFIThereEvidenceOnScouring;

    @BindView(R.id.isEvidenceInControlOfPests)
    CheckBox isEvidenceInControlOfPests;
    @BindView(R.id.etHLFIEvidenceInControlOfPests)
    CustomEditText etHLFIEvidenceInControlOfPests;

    @BindView(R.id.isCollectionShedForFarmers)
    CheckBox isCollectionShedForFarmers;
    @BindView(R.id.etHLFICollectionShedForFarmers)
    CustomEditText etHLFICollectionShedForFarmers;

    @BindView(R.id.isCollectionAndSortingShed)
    CheckBox isCollectionAndSortingShed;
    @BindView(R.id.etHLFICollectionAndSortingShed)
    CustomEditText etHLFICollectionAndSortingShed;

    @BindView(R.id.isAppropriateHygieneInstructions)
    CheckBox isAppropriateHygieneInstructions;
    @BindView(R.id.etHLFIAppropriateHygieneInstructions)
    CustomEditText etHLFIAppropriateHygieneInstructions;

    @BindView(R.id.isGradingTables)
    CheckBox isGradingTables;
    @BindView(R.id.etHLFIGradingTables)
    CustomEditText etHLFIGradingTables;

    @BindView(R.id.isShedHaveRunningWater)
    CheckBox isShedHaveRunningWater;
    @BindView(R.id.etHLFIShedHaveRunningWater)
    CustomEditText etHLFIShedHaveRunningWater;

    @BindView(R.id.isToiletAtFacility)
    CheckBox isToiletAtFacility;
    @BindView(R.id.etHLFIToiletAtFacility)
    CustomEditText etHLFIToiletAtFacility;

    @BindView(R.id.isPPEForGraders)
    CheckBox isPPEForGraders;
    @BindView(R.id.etHLFIPPEForGraders)
    CustomEditText etHLFIPPEForGraders;

    @BindView(R.id.isStorageAreaForGraders)
    CheckBox isStorageAreaForGraders;
    @BindView(R.id.etHLFIStorageAreaForGraders)
    CustomEditText etHLFIStorageAreaForGraders;

    @BindView(R.id.isPlasticCrates)
    CheckBox isPlasticCrates;
    @BindView(R.id.etHLFIPlasticCrates)
    CustomEditText etHLFIPlasticCrates;

    private String schedules, management, scouring, controlPests, collectionShed, collectionSorting, appropriate, gradingTables, running, toilet, ppe, storageGraders, plasticCrates;


    public HorticultureLicenceFarmInspectionDetails3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horticulture_licence_farm_inspection_details3, container, false);
        ButterKnife.bind(this, view);

        isTrainingSchedules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTrainingSchedules.isChecked()){
                    schedules = "Y";
                }else{
                    schedules = "N";
                }
            }

        });

        isTherePestManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTherePestManagement.isChecked()){
                    management = "Y";
                }else{
                    management = "N";
                }
            }

        });

        isThereEvidenceOnScouring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isThereEvidenceOnScouring.isChecked()){
                    scouring = "Y";
                }else{
                    scouring = "N";
                }
            }

        });

        isEvidenceInControlOfPests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEvidenceInControlOfPests.isChecked()){
                    controlPests = "Y";
                }else{
                    controlPests = "N";
                }
            }

        });

        isCollectionShedForFarmers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCollectionShedForFarmers.isChecked()){
                    collectionShed = "Y";
                }else{
                    collectionShed = "N";
                }
            }

        });

        isCollectionAndSortingShed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCollectionAndSortingShed.isChecked()){
                    collectionSorting = "Y";
                }else{
                    collectionSorting = "N";
                }
            }

        });

        isAppropriateHygieneInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAppropriateHygieneInstructions.isChecked()){
                    appropriate = "Y";
                }else{
                    appropriate = "N";
                }
            }

        });

        isGradingTables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isGradingTables.isChecked()){
                    gradingTables = "Y";
                }else{
                    gradingTables = "N";
                }
            }

        });

        isShedHaveRunningWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isShedHaveRunningWater.isChecked()){
                    running = "Y";
                }else{
                    running = "N";
                }
            }

        });

        isToiletAtFacility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isToiletAtFacility.isChecked()){
                    toilet = "Y";
                }else{
                    toilet = "N";
                }
            }

        });

        isPPEForGraders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPPEForGraders.isChecked()){
                    ppe = "Y";
                }else{
                    ppe = "N";
                }
            }

        });

        isStorageAreaForGraders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isStorageAreaForGraders.isChecked()){
                    storageGraders = "Y";
                }else{
                    storageGraders = "N";
                }
            }

        });

        isPlasticCrates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlasticCrates.isChecked()){
                    plasticCrates = "Y";
                }else{
                    plasticCrates = "N";
                }
            }

        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String strSchedules = Objects.requireNonNull(etHLFITrainingSchedules.getText()).toString().trim();
        String strManagement = Objects.requireNonNull(etHLFITherePestManagement.getText()).toString().trim();
        String strScouring = Objects.requireNonNull(etHLFIThereEvidenceOnScouring.getText()).toString().trim();
        String strControlPests = Objects.requireNonNull(etHLFIEvidenceInControlOfPests.getText()).toString().trim();
        String strCollectionShed = Objects.requireNonNull(etHLFICollectionShedForFarmers.getText()).toString().trim();
        String strCollectionSorting = Objects.requireNonNull(etHLFICollectionAndSortingShed.getText()).toString().trim();
        String strAppropriate = Objects.requireNonNull(etHLFIAppropriateHygieneInstructions.getText()).toString().trim();
        String strGradingTables = Objects.requireNonNull(etHLFIGradingTables.getText()).toString().trim();
        String strRunning = Objects.requireNonNull(etHLFIShedHaveRunningWater.getText()).toString().trim();
        String strToilet = Objects.requireNonNull(etHLFIToiletAtFacility.getText()).toString().trim();
        String strPpe = Objects.requireNonNull(etHLFIPPEForGraders.getText()).toString().trim();
        String strStorageGraders = Objects.requireNonNull(etHLFIStorageAreaForGraders.getText()).toString().trim();
        String strPlasticCrates = Objects.requireNonNull(etHLFIPlasticCrates.getText()).toString().trim();

        boolean valid = validateFields(isTrainingSchedules, etHLFITrainingSchedules, strSchedules) &
                validateFields(isTherePestManagement, etHLFITherePestManagement, strManagement) &
                validateFields(isThereEvidenceOnScouring, etHLFIThereEvidenceOnScouring, strScouring) &
                validateFields(isEvidenceInControlOfPests, etHLFIEvidenceInControlOfPests, strControlPests) &
                validateFields(isCollectionShedForFarmers, etHLFICollectionShedForFarmers, strCollectionShed) &
                validateFields(isCollectionAndSortingShed, etHLFICollectionAndSortingShed, strCollectionSorting) &
                validateFields(isAppropriateHygieneInstructions, etHLFIAppropriateHygieneInstructions, strAppropriate) &
                validateFields(isGradingTables, etHLFIGradingTables, strGradingTables) &
                validateFields(isShedHaveRunningWater, etHLFIShedHaveRunningWater, strRunning) &
                validateFields(isToiletAtFacility, etHLFIToiletAtFacility, strToilet) &
                validateFields(isPPEForGraders, etHLFIPPEForGraders, strPpe) &
                validateFields(isStorageAreaForGraders, etHLFIStorageAreaForGraders, strStorageGraders) &
                validateFields(isPlasticCrates, etHLFIPlasticCrates, strPlasticCrates);

        HorticultureCropExportLicenceFarmInspectionBus horticultureCropExportLicenceFarmInspectionBus = HorticultureCropExportLicenceFarmInspectionBus.getInstance();
        horticultureCropExportLicenceFarmInspectionBus.setIsTrainingSchedules(schedules);
        horticultureCropExportLicenceFarmInspectionBus.setTrainingSchedules(strSchedules);
        horticultureCropExportLicenceFarmInspectionBus.setIsPestManagementProtocol(management);
        horticultureCropExportLicenceFarmInspectionBus.setPestManagementProtocol(strManagement);
        horticultureCropExportLicenceFarmInspectionBus.setIsEvidenceOnScouring(scouring);
        horticultureCropExportLicenceFarmInspectionBus.setEvidenceOnScouring(strScouring);
        horticultureCropExportLicenceFarmInspectionBus.setIsEvidenceOfPests(controlPests);
        horticultureCropExportLicenceFarmInspectionBus.setEvidenceOfPests(strControlPests);
        horticultureCropExportLicenceFarmInspectionBus.setIsCollectionShedForFarmers(collectionShed);
        horticultureCropExportLicenceFarmInspectionBus.setCollectionShedForFarmers(strCollectionShed);
        horticultureCropExportLicenceFarmInspectionBus.setIsCollectionAndSortingShed(collectionSorting);
        horticultureCropExportLicenceFarmInspectionBus.setCollectionAndSortingShed(strCollectionSorting);
        horticultureCropExportLicenceFarmInspectionBus.setIsAppropriateHygiene(appropriate);
        horticultureCropExportLicenceFarmInspectionBus.setAppropriateHygiene(strAppropriate);
        horticultureCropExportLicenceFarmInspectionBus.setIsGradingtables(gradingTables);
        horticultureCropExportLicenceFarmInspectionBus.setGradingtables(strGradingTables);
        horticultureCropExportLicenceFarmInspectionBus.setIsShedHaveRunningWater(running);
        horticultureCropExportLicenceFarmInspectionBus.setShedHaveRunningWater(strRunning);
        horticultureCropExportLicenceFarmInspectionBus.setIsToiletAtFacility(toilet);
        horticultureCropExportLicenceFarmInspectionBus.setToiletAtFacility(strToilet);
        horticultureCropExportLicenceFarmInspectionBus.setIsPpeGraders(ppe);
        horticultureCropExportLicenceFarmInspectionBus.setPpeGraders(strPpe);
        horticultureCropExportLicenceFarmInspectionBus.setIsStorageAreaForGraded(storageGraders);
        horticultureCropExportLicenceFarmInspectionBus.setStorageAreaForGraded(strStorageGraders);
        horticultureCropExportLicenceFarmInspectionBus.setIsPlasticCrates(plasticCrates);
        horticultureCropExportLicenceFarmInspectionBus.setPlasticCrates(strPlasticCrates);

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

    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString){

        boolean result= false;

        if(!checkBox.isChecked()){
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                result = false;
            } else{
                result = true;
            }
        } else{
            customEditText.setError(null);
            result = true;
        }

        return result;
    }

}
