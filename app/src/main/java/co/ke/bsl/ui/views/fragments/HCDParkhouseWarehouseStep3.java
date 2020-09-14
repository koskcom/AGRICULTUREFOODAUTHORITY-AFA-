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
public class HCDParkhouseWarehouseStep3 extends Fragment implements BlockingStep {


    @BindView(R.id.isCertificationToSafetyStandards)
    CheckBox isCertificationToSafetyStandards;
    @BindView(R.id.etCertificationToSafetyStandardsRemarks)
    CustomEditText etCertificationToSafetyStandardsRemarks;
    @BindView(R.id.isDulySignedExporter)
    CheckBox isDulySignedExporter;
    @BindView(R.id.etDulySignedExporterRemarks)
    CustomEditText etDulySignedExporterRemarks;
    @BindView(R.id.isListAndCodes)
    CheckBox isListAndCodes;
    @BindView(R.id.etListAndCodesRemarks)
    CustomEditText etListAndCodesRemarks;
    @BindView(R.id.isRegisterOfIncomingProduce)
    CheckBox isRegisterOfIncomingProduce;
    @BindView(R.id.etRegisterOfIncomingProduceRemarks)
    CustomEditText etRegisterOfIncomingProduceRemarks;
    @BindView(R.id.isAreProduceAndSourcesDeclared)
    CheckBox isAreProduceAndSourcesDeclared;
    @BindView(R.id.etAreProduceAndSourcesDeclaredRemarks)
    CustomEditText etAreProduceAndSourcesDeclaredRemarks;
    @BindView(R.id.isCopiesOfProduceCollection)
    CheckBox isCopiesOfProduceCollection;
    @BindView(R.id.etCopiesOfProduceCollectionRemarks)
    CustomEditText etCopiesOfProduceCollectionRemarks;
    @BindView(R.id.isHarvestDateAndQuantity)
    CheckBox isHarvestDateAndQuantity;
    @BindView(R.id.etHarvestDateAndQuantityRemarks)
    CustomEditText etHarvestDateAndQuantityRemarks;
    @BindView(R.id.isDateLastSprayed)
    CheckBox isDateLastSprayed;
    @BindView(R.id.etDateLastSprayedRemarks)
    CustomEditText etDateLastSprayedRemarks;
    @BindView(R.id.isDocumentedTraceability)
    CheckBox isDocumentedTraceability;
    @BindView(R.id.etDocumentedTraceabilityRemarks)
    CustomEditText etDocumentedTraceabilityRemarks;
    @BindView(R.id.isArePackedProductsCoded)
    CheckBox isArePackedProductsCoded;
    @BindView(R.id.etArePackedProductsCodedRemarks)
    CustomEditText etArePackedProductsCodedRemarks;
    @BindView(R.id.isOrderAndDispatch)
    CheckBox isOrderAndDispatch;
    @BindView(R.id.etOrderAndDispatchRemarks)
    CustomEditText etOrderAndDispatchRemarks;
    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private String isCertificationtoSafetyStandards, certificationToSafetyStandardsRemarks, isDulysignedExporter, dulySignedExporterRemarks, isListandCodes, listAndCodesRemarks, isRegisterofIncomingProduce, registerOfIncomingProduceRemarks;
    private String isAreproduceAndSourcesDeclared, areProduceAndSourcesDeclaredRemarks, isCopiesofProduceCollection, copiesOfProduceCollectionRemarks, isHarvestdateAndQuantity, harvestDateAndQuantityRemarks;
    private String isDatelastSprayed, dateLastSprayedRemarks, isDocumentedtraceability, documentedTraceabilityRemarks, isArePackedproductsCoded, arePackedProductsCodedRemarks, isOrderandDispatch, orderAndDispatchRemarks;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdparkhouse_warehouse_step3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        isCertificationToSafetyStandards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCertificationToSafetyStandards.isChecked()) {
                    isCertificationtoSafetyStandards = "Y";
                } else {
                    isCertificationtoSafetyStandards = "N";
                }

            }
        });

        isDulySignedExporter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDulySignedExporter.isChecked()) {
                    isDulysignedExporter = "Y";
                } else {
                    isDulysignedExporter = "N";
                }

            }
        });

        isListAndCodes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isListAndCodes.isChecked()) {
                    isListandCodes = "Y";
                } else {
                    isListandCodes = "N";
                }

            }
        });

        isRegisterOfIncomingProduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRegisterOfIncomingProduce.isChecked()) {
                    isRegisterofIncomingProduce = "Y";
                } else {
                    isRegisterofIncomingProduce = "N";
                }

            }
        });

        isAreProduceAndSourcesDeclared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAreProduceAndSourcesDeclared.isChecked()) {
                    isAreproduceAndSourcesDeclared = "Y";
                } else {
                    isAreproduceAndSourcesDeclared = "N";
                }

            }
        });

        isCopiesOfProduceCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCopiesOfProduceCollection.isChecked()) {
                    isCopiesofProduceCollection = "Y";
                } else {
                    isCopiesofProduceCollection = "N";
                }

            }
        });

        isHarvestDateAndQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHarvestDateAndQuantity.isChecked()) {
                    isHarvestdateAndQuantity = "Y";
                } else {
                    isHarvestdateAndQuantity = "N";
                }

            }
        });

        isDateLastSprayed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDateLastSprayed.isChecked()) {
                    isDatelastSprayed = "Y";
                } else {
                    isDatelastSprayed = "N";
                }

            }
        });

        isDocumentedTraceability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDocumentedTraceability.isChecked()) {
                    isDocumentedtraceability = "Y";
                } else {
                    isDocumentedtraceability = "N";
                }

            }
        });

        isArePackedProductsCoded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isArePackedProductsCoded.isChecked()) {
                    isArePackedproductsCoded = "Y";
                } else {
                    isArePackedproductsCoded = "N";
                }

            }
        });

        isOrderAndDispatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOrderAndDispatch.isChecked()) {
                    isOrderandDispatch = "Y";
                } else {
                    isOrderandDispatch = "N";
                }

            }
        });


        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        certificationToSafetyStandardsRemarks = Objects.requireNonNull(etCertificationToSafetyStandardsRemarks.getText()).toString().trim();
        dulySignedExporterRemarks = Objects.requireNonNull(etDulySignedExporterRemarks.getText()).toString().trim();
        listAndCodesRemarks = Objects.requireNonNull(etListAndCodesRemarks.getText()).toString().trim();
        registerOfIncomingProduceRemarks = Objects.requireNonNull(etRegisterOfIncomingProduceRemarks.getText()).toString().trim();
        areProduceAndSourcesDeclaredRemarks = Objects.requireNonNull(etAreProduceAndSourcesDeclaredRemarks.getText()).toString().trim();
        copiesOfProduceCollectionRemarks = Objects.requireNonNull(etCopiesOfProduceCollectionRemarks.getText()).toString().trim();
        harvestDateAndQuantityRemarks = Objects.requireNonNull(etHarvestDateAndQuantityRemarks.getText()).toString().trim();
        dateLastSprayedRemarks = Objects.requireNonNull(etDateLastSprayedRemarks.getText()).toString().trim();
        documentedTraceabilityRemarks = Objects.requireNonNull(etDocumentedTraceabilityRemarks.getText()).toString().trim();
        arePackedProductsCodedRemarks = Objects.requireNonNull(etArePackedProductsCodedRemarks.getText()).toString().trim();
        orderAndDispatchRemarks = Objects.requireNonNull(etOrderAndDispatchRemarks.getText()).toString().trim();

        //validation
        boolean valid = validateFields(isCertificationToSafetyStandards, etCertificationToSafetyStandardsRemarks, certificationToSafetyStandardsRemarks) &
                validateFields(isDulySignedExporter, etDulySignedExporterRemarks, dulySignedExporterRemarks) &
                validateFields(isListAndCodes, etListAndCodesRemarks, listAndCodesRemarks) &
                validateFields(isRegisterOfIncomingProduce, etRegisterOfIncomingProduceRemarks, registerOfIncomingProduceRemarks) &
                validateFields(isAreProduceAndSourcesDeclared, etAreProduceAndSourcesDeclaredRemarks, areProduceAndSourcesDeclaredRemarks) &
                validateFields(isCopiesOfProduceCollection, etCopiesOfProduceCollectionRemarks, copiesOfProduceCollectionRemarks) &
                validateFields(isHarvestDateAndQuantity, etHarvestDateAndQuantityRemarks, harvestDateAndQuantityRemarks) &
                validateFields(isDateLastSprayed, etDateLastSprayedRemarks, dateLastSprayedRemarks) &
                validateFields(isDocumentedTraceability, etDocumentedTraceabilityRemarks, documentedTraceabilityRemarks) &
                validateFields(isArePackedProductsCoded, etArePackedProductsCodedRemarks, arePackedProductsCodedRemarks) &
                validateFields(isOrderAndDispatch, etOrderAndDispatchRemarks, orderAndDispatchRemarks);

        HCDParkhouseWarehouseBus hCDParkhouseWarehouseBus = HCDParkhouseWarehouseBus.getInstance();

        hCDParkhouseWarehouseBus.setIsCertificationtoSafetyStandards(isCertificationtoSafetyStandards);
        hCDParkhouseWarehouseBus.setCertificationToSafetyStandardsRemarks(certificationToSafetyStandardsRemarks);
        hCDParkhouseWarehouseBus.setIsDulysignedExporter(isDulysignedExporter);
        hCDParkhouseWarehouseBus.setDulySignedExporterRemarks(dulySignedExporterRemarks);
        hCDParkhouseWarehouseBus.setIsListandCodes(isListandCodes);
        hCDParkhouseWarehouseBus.setListAndCodesRemarks(listAndCodesRemarks);
        hCDParkhouseWarehouseBus.setIsRegisterofIncomingProduce(isRegisterofIncomingProduce);
        hCDParkhouseWarehouseBus.setRegisterOfIncomingProduceRemarks(registerOfIncomingProduceRemarks);
        hCDParkhouseWarehouseBus.setIsAreproduceAndSourcesDeclared(isAreproduceAndSourcesDeclared);
        hCDParkhouseWarehouseBus.setAreProduceAndSourcesDeclaredRemarks(areProduceAndSourcesDeclaredRemarks);
        hCDParkhouseWarehouseBus.setIsCopiesofProduceCollection(isCopiesofProduceCollection);
        hCDParkhouseWarehouseBus.setCopiesOfProduceCollectionRemarks(copiesOfProduceCollectionRemarks);
        hCDParkhouseWarehouseBus.setIsHarvestdateAndQuantity(isHarvestdateAndQuantity);
        hCDParkhouseWarehouseBus.setHarvestDateAndQuantityRemarks(harvestDateAndQuantityRemarks);
        hCDParkhouseWarehouseBus.setIsDatelastSprayed(isDatelastSprayed);
        hCDParkhouseWarehouseBus.setDateLastSprayedRemarks(dateLastSprayedRemarks);
        hCDParkhouseWarehouseBus.setIsDocumentedtraceability(isDocumentedtraceability);
        hCDParkhouseWarehouseBus.setDocumentedTraceabilityRemarks(documentedTraceabilityRemarks);
        hCDParkhouseWarehouseBus.setIsArePackedproductsCoded(isArePackedproductsCoded);
        hCDParkhouseWarehouseBus.setArePackedProductsCodedRemarks(arePackedProductsCodedRemarks);
        hCDParkhouseWarehouseBus.setIsOrderandDispatch(isOrderandDispatch);
        hCDParkhouseWarehouseBus.setOrderAndDispatchRemarks(orderAndDispatchRemarks);

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
