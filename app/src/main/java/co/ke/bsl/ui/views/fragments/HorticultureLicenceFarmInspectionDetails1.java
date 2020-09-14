package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.CallLog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import javax.security.auth.callback.Callback;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.R;
import co.ke.bsl.data.view.HorticultureCropExportLicenceFarmInspectionBus;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorticultureLicenceFarmInspectionDetails1 extends Fragment implements BlockingStep {

    @BindView(R.id.isCertificationToGap)
    CheckBox isCertificationToGap;
    @BindView(R.id.etHLFICertificationToGap)
    CustomEditText etHLFICertificationToGap;

    @BindView(R.id.isDulySignedAndWitnessed)
    CheckBox isDulySignedAndWitnessed;
    @BindView(R.id.etHLFIDulySignedAndWitnessed)
    CustomEditText etHLFIDulySignedAndWitnessed;

    @BindView(R.id.isProductionPlanPerCrop)
    CheckBox isProductionPlanPerCrop;
    @BindView(R.id.etHLFIProductionPlanPerCrop)
    CustomEditText etHLFIProductionPlanPerCrop;

    @BindView(R.id.isExporterAware)
    CheckBox isExporterAware;
    @BindView(R.id.etHLFIExporterAware)
    CustomEditText etHLFIExporterAware;

    @BindView(R.id.isExporterTrainedPersonnel)
    CheckBox isExporterTrainedPersonnel;
    @BindView(R.id.etHLFIExporterTrainedPersonnel)
    CustomEditText etHLFIExporterTrainedPersonnel;

    @BindView(R.id.isControlledAndApproved)
    CheckBox isControlledAndApproved;
    @BindView(R.id.etHLFIControlledAndApproved)
    CustomEditText etHLFIControlledAndApproved;

    @BindView(R.id.isExporterHavePetcideMRL)
    CheckBox isExporterHavePetcideMRL;
    @BindView(R.id.etHLFIExporterHavePetcideMRL)
    CustomEditText etHLFIExporterHavePetcideMRL;

    @BindView(R.id.isFieldCodesBlocks)
    CheckBox isFieldCodesBlocks;
    @BindView(R.id.etHLFIFieldCodesBlocks)
    CustomEditText etHLFIFieldCodesBlocks;

    @BindView(R.id.isPlantingDate)
    CheckBox isPlantingDate;
    @BindView(R.id.etHLFIPlantingDate)
    CustomEditText etHLFIPlantingDate;

    private String gap, duly, plan, aware, trained, controlled, petcide, field, planting;

    public HorticultureLicenceFarmInspectionDetails1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horticulture_licence_farm_inspection_details1, container, false);
        ButterKnife.bind(this, view);

        isCertificationToGap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCertificationToGap.isChecked()){
                    gap = "Y";
                }else{
                    gap = "N";
                }
            }

        });

        isDulySignedAndWitnessed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDulySignedAndWitnessed.isChecked()){
                    duly = "Y";
                }else{
                    duly = "N";
                }
            }

        });

        isProductionPlanPerCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isProductionPlanPerCrop.isChecked()){
                    plan = "Y";
                }else{
                    plan = "N";
                }
            }

        });

        isExporterAware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExporterAware.isChecked()){
                    aware = "Y";
                }else{
                    aware = "N";
                }
            }

        });

        isExporterTrainedPersonnel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExporterTrainedPersonnel.isChecked()){
                    trained = "Y";
                }else{
                    trained = "N";
                }
            }

        });

        isControlledAndApproved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isControlledAndApproved.isChecked()){
                    controlled = "Y";
                }else{
                    controlled = "N";
                }
            }

        });

        isExporterHavePetcideMRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExporterHavePetcideMRL.isChecked()){
                    petcide = "Y";
                }else{
                    petcide = "N";
                }
            }

        });

        isFieldCodesBlocks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFieldCodesBlocks.isChecked()){
                    field = "Y";
                }else{
                    field = "N";
                }
            }

        });

        isPlantingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlantingDate.isChecked()){
                    planting = "Y";
                }else{
                    planting = "N";
                }
            }

        });

        return view;

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        String strGap = Objects.requireNonNull(etHLFICertificationToGap.getText()).toString().trim();
        String strDuly = Objects.requireNonNull(etHLFIDulySignedAndWitnessed.getText()).toString().trim();
        String strPlan = Objects.requireNonNull(etHLFIProductionPlanPerCrop.getText()).toString().trim();
        String strAware = Objects.requireNonNull(etHLFIExporterAware.getText()).toString().trim();
        String strTrained = Objects.requireNonNull(etHLFIExporterTrainedPersonnel.getText()).toString().trim();
        String strControlled = Objects.requireNonNull(etHLFIControlledAndApproved.getText()).toString().trim();
        String strPetcide = Objects.requireNonNull(etHLFIExporterHavePetcideMRL.getText()).toString().trim();
        String strField = Objects.requireNonNull(etHLFIFieldCodesBlocks.getText()).toString().trim();
        String strPlanting = Objects.requireNonNull(etHLFIPlantingDate.getText()).toString().trim();

        boolean valid = validateFields(isCertificationToGap, etHLFICertificationToGap, strGap) &
                validateFields(isDulySignedAndWitnessed, etHLFIDulySignedAndWitnessed, strDuly) &
                validateFields(isProductionPlanPerCrop, etHLFIProductionPlanPerCrop, strPlan) &
                validateFields(isExporterAware, etHLFIExporterAware, strAware) &
                validateFields(isExporterTrainedPersonnel, etHLFIExporterTrainedPersonnel, strTrained) &
                validateFields(isControlledAndApproved, etHLFIControlledAndApproved, strControlled) &
                validateFields(isExporterHavePetcideMRL, etHLFIExporterHavePetcideMRL, strPetcide) &
                validateFields(isFieldCodesBlocks, etHLFIFieldCodesBlocks, strField) &
                validateFields(isPlantingDate, etHLFIPlantingDate, strPlanting) ;

        HorticultureCropExportLicenceFarmInspectionBus horticultureCropExportLicenceFarmInspectionBus = HorticultureCropExportLicenceFarmInspectionBus.getInstance();
        horticultureCropExportLicenceFarmInspectionBus.setIsCcertificationToGap(gap);
        horticultureCropExportLicenceFarmInspectionBus.setCcertificationToGap(strGap);
        horticultureCropExportLicenceFarmInspectionBus.setIsDulySigned(duly);
        horticultureCropExportLicenceFarmInspectionBus.setDulySigned(strDuly);
        horticultureCropExportLicenceFarmInspectionBus.setIsProductionPlanPerCrop(plan);
        horticultureCropExportLicenceFarmInspectionBus.setProductionPlanPerCrop(strPlan);
        horticultureCropExportLicenceFarmInspectionBus.setIsExporterAware(aware);
        horticultureCropExportLicenceFarmInspectionBus.setExporterAware(strAware);
        horticultureCropExportLicenceFarmInspectionBus.setIsExporterTrainedPersonnel(trained);
        horticultureCropExportLicenceFarmInspectionBus.setExporterTrainedPersonnel(strTrained);
        horticultureCropExportLicenceFarmInspectionBus.setIsControlledAndApproved(controlled);
        horticultureCropExportLicenceFarmInspectionBus.setControlledAndApproved(strControlled);
        horticultureCropExportLicenceFarmInspectionBus.setIsExporterHavePetcide(petcide);
        horticultureCropExportLicenceFarmInspectionBus.setExporterHavePetcide(strPetcide);
        horticultureCropExportLicenceFarmInspectionBus.setIsFieldCodes(field);
        horticultureCropExportLicenceFarmInspectionBus.setFieldCodes(strField);
        horticultureCropExportLicenceFarmInspectionBus.setIsPlantingDate(planting);
        horticultureCropExportLicenceFarmInspectionBus.setPlantingDate(strPlanting);

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
