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
public class HorticultureLicenceFarmInspectionDetails2 extends Fragment implements BlockingStep {

    @BindView(R.id.isChemicalListApproved)
    CheckBox isChemicalListApproved;
    @BindView(R.id.etHLFIChemicalListApproved)
    CustomEditText etHLFIChemicalListApproved;

    @BindView(R.id.isPrecenseOfApproved)
    CheckBox isPrecenseOfApproved;
    @BindView(R.id.etHLFIPrecenseOfApproved)
    CustomEditText etHLFIPrecenseOfApproved;

    @BindView(R.id.isProductInvoices)
    CheckBox isProductInvoices;
    @BindView(R.id.etHLFIProductInvoices)
    CustomEditText etHLFIProductInvoices;

    @BindView(R.id.isThereSprayRecords)
    CheckBox isThereSprayRecords;
    @BindView(R.id.etHLFIThereSprayRecords)
    CustomEditText etHLFIThereSprayRecords;

    @BindView(R.id.isTradenameOfTheProduct)
    CheckBox isTradenameOfTheProduct;
    @BindView(R.id.etHLFITradenameOfTheProduct)
    CustomEditText etHLFITradenameOfTheProduct;

    @BindView(R.id.isThePHIRecord)
    CheckBox isThePHIRecord;
    @BindView(R.id.etHLFIThePHIRecord)
    CustomEditText etHLFIThePHIRecord;

    @BindView(R.id.isAllSprayingDates)
    CheckBox isAllSprayingDates;
    @BindView(R.id.etHLFIAllSprayingDates)
    CustomEditText etHLFIAllSprayingDates;

    @BindView(R.id.isAmountOfPesticide)
    CheckBox isAmountOfPesticide;
    @BindView(R.id.etHLFIAmountOfPesticide)
    CustomEditText etHLFIAmountOfPesticide;

    @BindView(R.id.isThePHIObserved)
    CheckBox isThePHIObserved;
    @BindView(R.id.etHLFIThePHIObserved)
    CustomEditText etHLFIThePHIObserved;

    private String chemical, presence, invoices, sprayRecords, tradename, phiRecorded, sprayingDates, pesticide, phiObserved;

    public HorticultureLicenceFarmInspectionDetails2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horticulture_licence_farm_inspection_details2, container, false);
        ButterKnife.bind(this, view);

        isChemicalListApproved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isChemicalListApproved.isChecked()){
                    chemical = "Y";
                }else{
                    chemical = "N";
                }
            }

        });

        isPrecenseOfApproved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPrecenseOfApproved.isChecked()){
                    presence = "Y";
                }else{
                    presence = "N";
                }
            }

        });

        isProductInvoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isProductInvoices.isChecked()){
                    invoices = "Y";
                }else{
                    invoices = "N";
                }
            }

        });

        isThereSprayRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isThereSprayRecords.isChecked()){
                    sprayRecords = "Y";
                }else{
                    sprayRecords = "N";
                }
            }

        });

        isTradenameOfTheProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTradenameOfTheProduct.isChecked()){
                    tradename = "Y";
                }else{
                    tradename = "N";
                }
            }

        });

        isThePHIRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isThePHIRecord.isChecked()){
                    phiRecorded = "Y";
                }else{
                    phiRecorded = "N";
                }
            }

        });

        isAllSprayingDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAllSprayingDates.isChecked()){
                    sprayingDates = "Y";
                }else{
                    sprayingDates = "N";
                }
            }

        });

        isAmountOfPesticide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAmountOfPesticide.isChecked()){
                    pesticide = "Y";
                }else{
                    pesticide = "N";
                }
            }

        });

        isThePHIObserved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isThePHIObserved.isChecked()){
                    phiObserved = "Y";
                }else{
                    phiObserved = "N";
                }
            }

        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String strChemical = Objects.requireNonNull(etHLFIChemicalListApproved.getText()).toString().trim();
        String strPresence = Objects.requireNonNull(etHLFIPrecenseOfApproved.getText()).toString().trim();
        String strInvoices = Objects.requireNonNull(etHLFIProductInvoices.getText()).toString().trim();
        String strSprayRecords = Objects.requireNonNull(etHLFIThereSprayRecords.getText()).toString().trim();
        String strTradename = Objects.requireNonNull(etHLFITradenameOfTheProduct.getText()).toString().trim();
        String strPHIRecorded = Objects.requireNonNull(etHLFIThePHIRecord.getText()).toString().trim();
        String strSprayingDates = Objects.requireNonNull(etHLFIAllSprayingDates.getText()).toString().trim();
        String strPesticide = Objects.requireNonNull(etHLFIAmountOfPesticide.getText()).toString().trim();
        String strPHIObserved = Objects.requireNonNull(etHLFIThePHIObserved.getText()).toString().trim();

        boolean valid = validateFields(isChemicalListApproved, etHLFIChemicalListApproved, strChemical) &
                validateFields(isPrecenseOfApproved, etHLFIPrecenseOfApproved, strPresence) &
                validateFields(isProductInvoices, etHLFIProductInvoices, strInvoices) &
                validateFields(isThereSprayRecords, etHLFIThereSprayRecords, strSprayRecords) &
                validateFields(isTradenameOfTheProduct, etHLFITradenameOfTheProduct, strTradename) &
                validateFields(isThePHIRecord, etHLFIThePHIRecord, strPHIRecorded) &
                validateFields(isAllSprayingDates, etHLFIAllSprayingDates, strSprayingDates) &
                validateFields(isAmountOfPesticide, etHLFIAmountOfPesticide, strPesticide) &
                validateFields(isThePHIObserved, etHLFIThePHIObserved, strPHIObserved) ;

        HorticultureCropExportLicenceFarmInspectionBus horticultureCropExportLicenceFarmInspectionBus = HorticultureCropExportLicenceFarmInspectionBus.getInstance();
        horticultureCropExportLicenceFarmInspectionBus.setIsChemicalListApproved(chemical);
        horticultureCropExportLicenceFarmInspectionBus.setChemicalListApproved(strChemical);
        horticultureCropExportLicenceFarmInspectionBus.setIsPresenceOfApprovedSpray(presence);
        horticultureCropExportLicenceFarmInspectionBus.setPresenceOfApprovedSpray(strPresence);
        horticultureCropExportLicenceFarmInspectionBus.setIsProductInvoices(invoices);
        horticultureCropExportLicenceFarmInspectionBus.setProductInvoices(strInvoices);
        horticultureCropExportLicenceFarmInspectionBus.setIsSprayRecords(sprayRecords);
        horticultureCropExportLicenceFarmInspectionBus.setSprayRecords(strSprayRecords);
        horticultureCropExportLicenceFarmInspectionBus.setIsTradenameOfProduct(tradename);
        horticultureCropExportLicenceFarmInspectionBus.setTradenameOfProduct(strTradename);
        horticultureCropExportLicenceFarmInspectionBus.setIsPhiRecorded(phiRecorded);
        horticultureCropExportLicenceFarmInspectionBus.setPhiRecorded(strPHIRecorded);
        horticultureCropExportLicenceFarmInspectionBus.setIsAllSprayingDates(sprayingDates);
        horticultureCropExportLicenceFarmInspectionBus.setAllSprayingDates(strSprayingDates);
        horticultureCropExportLicenceFarmInspectionBus.setIsAmountOfPesticide(pesticide);
        horticultureCropExportLicenceFarmInspectionBus.setAmountOfPesticide(strPesticide);
        horticultureCropExportLicenceFarmInspectionBus.setIsPhiObserved(phiObserved);
        horticultureCropExportLicenceFarmInspectionBus.setPhiObserved(strPHIObserved);

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
