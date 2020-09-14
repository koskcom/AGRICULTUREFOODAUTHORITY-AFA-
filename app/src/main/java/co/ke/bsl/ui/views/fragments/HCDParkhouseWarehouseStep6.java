package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.HCDParkhouseWarehouse;
import co.ke.bsl.data.view.HCDParkhouseWarehouseBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.HorticulturalPackhouseWarehouseViewModel;
import co.ke.bsl.ui.viewmodels.HorticulturalProduceTransportationViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDParkhouseWarehouseStep6 extends Fragment implements BlockingStep {

    @BindView(R.id.isFacilityDesigned)
    CheckBox isFacilityDesigned;
    @BindView(R.id.etFacilityDesignedRemarks)
    CustomEditText etFacilityDesignedRemarks;

    @BindView(R.id.isDisplayedProminentSigns)
    CheckBox isDisplayedProminentSigns;
    @BindView(R.id.etDisplayedProminentSignsRemarks)
    CustomEditText etDisplayedProminentSignsRemarks;

    @BindView(R.id.isDisplayedProminentProduceSpecifications)
    CheckBox isDisplayedProminentProduceSpecifications;
    @BindView(R.id.etDisplayedProminentProduceSpecificationsRemarks)
    CustomEditText etDisplayedProminentProduceSpecificationsRemarks;

    @BindView(R.id.isStorageAreaOfPackaging)
    CheckBox isStorageAreaOfPackaging;
    @BindView(R.id.etStorageAreaOfPackagingRemarks)
    CustomEditText etStorageAreaOfPackagingRemarks;

    @BindView(R.id.isProductsGraded)
    CheckBox isProductsGraded;
    @BindView(R.id.etProductsGradedRemarks)
    CustomEditText etProductsGradedRemarks;

    @BindView(R.id.isProduceFollowFIFO)
    CheckBox isProduceFollowFIFO;
    @BindView(R.id.etProduceFollowFIFORemarks)
    CustomEditText etProduceFollowFIFORemarks;

    @BindView(R.id.isAcquissitionOfProduce)
    CheckBox isAcquissitionOfProduce;
    @BindView(R.id.etAcquissitionOfProduceRemarks)
    CustomEditText etAcquissitionOfProduceRemarks;

    @BindView(R.id.isStorageAreaSafeHygiene)
    CheckBox isStorageAreaSafeHygiene;
    @BindView(R.id.etStorageAreaSafeHygieneRemarks)
    CustomEditText etStorageAreaSafeHygieneRemarks;

    @BindView(R.id.etOtherCommentss)
    CustomEditText etOtherCommentss;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private HorticulturalPackhouseWarehouseViewModel horticulturalPackhouseWarehouseViewModel;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();


    private String isFacilitydesigned, facilityDesignedRemarks, isDisplayedprominentSigns, displayedProminentSignsRemarks, isDisplayedProminentproduceSpecifications, displayedProminentProduceSpecificationsRemarks;
    private String isStorageareaOfPackaging, storageAreaOfPackagingRemarks, isProductsgraded, productsGradedRemarks, isProducefollowFIFO, produceFollowFIFORemarks, isAcquissitionofProduce, acquissitionOfProduceRemarks;
    private String isStorageareaSafeHygiene, storageAreaSafeHygieneRemarks, otherComments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdparkhouse_warehouse_step6, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        horticulturalPackhouseWarehouseViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(HorticulturalPackhouseWarehouseViewModel.class);

        setReccomendationsView(getReccomendationsView());

        ssReccomendation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ReccomendationsView rec = (ReccomendationsView) ssReccomendation.getSelectedItem();
                recommendation = rec.getServerID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        isFacilityDesigned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFacilityDesigned.isChecked()) {
                    isFacilitydesigned = "Y";
                } else {
                    isFacilitydesigned = "N";
                }

            }
        });

        isDisplayedProminentSigns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDisplayedProminentSigns.isChecked()) {
                    isDisplayedprominentSigns = "Y";
                } else {
                    isDisplayedprominentSigns = "N";
                }

            }
        });

        isDisplayedProminentProduceSpecifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDisplayedProminentProduceSpecifications.isChecked()) {
                    isDisplayedProminentproduceSpecifications = "Y";
                } else {
                    isDisplayedProminentproduceSpecifications = "N";
                }

            }
        });

        isStorageAreaOfPackaging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStorageAreaOfPackaging.isChecked()) {
                    isStorageareaOfPackaging = "Y";
                } else {
                    isStorageareaOfPackaging = "N";
                }

            }
        });
        isProductsGraded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProductsGraded.isChecked()) {
                    isProductsgraded = "Y";
                } else {
                    isProductsgraded = "N";
                }

            }
        });

        isProduceFollowFIFO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProduceFollowFIFO.isChecked()) {
                    isProducefollowFIFO = "Y";
                } else {
                    isProducefollowFIFO = "N";
                }

            }
        });

        isAcquissitionOfProduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAcquissitionOfProduce.isChecked()) {
                    isAcquissitionofProduce = "Y";
                } else {
                    isAcquissitionofProduce = "N";
                }

            }
        });

        isStorageAreaSafeHygiene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStorageAreaSafeHygiene.isChecked()) {
                    isStorageareaSafeHygiene = "Y";
                } else {
                    isStorageareaSafeHygiene = "N";
                }

            }
        });


        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {


    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {


        facilityDesignedRemarks = Objects.requireNonNull(etFacilityDesignedRemarks.getText()).toString().trim();
        displayedProminentSignsRemarks = Objects.requireNonNull(etDisplayedProminentSignsRemarks.getText()).toString().trim();
        displayedProminentProduceSpecificationsRemarks = Objects.requireNonNull(etDisplayedProminentProduceSpecificationsRemarks.getText()).toString().trim();
        storageAreaOfPackagingRemarks = Objects.requireNonNull(etStorageAreaOfPackagingRemarks.getText()).toString().trim();
        productsGradedRemarks = Objects.requireNonNull(etProductsGradedRemarks.getText()).toString().trim();
        produceFollowFIFORemarks = Objects.requireNonNull(etProduceFollowFIFORemarks.getText()).toString().trim();
        acquissitionOfProduceRemarks = Objects.requireNonNull(etAcquissitionOfProduceRemarks.getText()).toString().trim();
        storageAreaSafeHygieneRemarks = Objects.requireNonNull(etStorageAreaSafeHygieneRemarks.getText()).toString().trim();
        otherComments = Objects.requireNonNull(etOtherCommentss.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        //validation
        boolean valid = validateFields(isFacilityDesigned, etFacilityDesignedRemarks, facilityDesignedRemarks) &
                validateFields(isDisplayedProminentSigns, etDisplayedProminentSignsRemarks, displayedProminentSignsRemarks) &
                validateFields(isDisplayedProminentProduceSpecifications, etDisplayedProminentProduceSpecificationsRemarks, displayedProminentProduceSpecificationsRemarks) &
                validateFields(isStorageAreaOfPackaging, etStorageAreaOfPackagingRemarks, storageAreaOfPackagingRemarks) &
                validateFields(isProductsGraded, etProductsGradedRemarks, productsGradedRemarks) &
                validateFields(isProduceFollowFIFO, etProduceFollowFIFORemarks, produceFollowFIFORemarks) &
                validateFields(isAcquissitionOfProduce, etAcquissitionOfProduceRemarks, acquissitionOfProduceRemarks) &
                validateFields(isStorageAreaSafeHygiene, etStorageAreaSafeHygieneRemarks, storageAreaSafeHygieneRemarks);


        HCDParkhouseWarehouseBus hCDParkhouseWarehouseBus = HCDParkhouseWarehouseBus.getInstance();
        HCDParkhouseWarehouse hCDParkhouseWarehouse = new HCDParkhouseWarehouse(
                0,
                hCDParkhouseWarehouseBus.getDocumentNumber(),
                hCDParkhouseWarehouseBus.getDocumentDate(),
                hCDParkhouseWarehouseBus.getDealerCategory(),
                hCDParkhouseWarehouseBus.getNameOfApplicant(),
                hCDParkhouseWarehouseBus.getTelephone(),
                hCDParkhouseWarehouseBus.getEmail(),
                hCDParkhouseWarehouseBus.getCounty(),
                hCDParkhouseWarehouseBus.getLocation(),
                hCDParkhouseWarehouseBus.getProduceCrops(),
                hCDParkhouseWarehouseBus.getExportLicence(),
                hCDParkhouseWarehouseBus.getLocalID(),
                hCDParkhouseWarehouseBus.getName(),
                hCDParkhouseWarehouseBus.getTel(),
                hCDParkhouseWarehouseBus.getLocation2(),
                hCDParkhouseWarehouseBus.getLicenceNumber(),
                hCDParkhouseWarehouseBus.getIsCertificationtoSafetyStandards(),
                hCDParkhouseWarehouseBus.getCertificationToSafetyStandardsRemarks(),
                hCDParkhouseWarehouseBus.getIsDulysignedExporter(),
                hCDParkhouseWarehouseBus.getDulySignedExporterRemarks(),
                hCDParkhouseWarehouseBus.getIsListandCodes(),
                hCDParkhouseWarehouseBus.getListAndCodesRemarks(),
                hCDParkhouseWarehouseBus.getIsRegisterofIncomingProduce(),
                hCDParkhouseWarehouseBus.getRegisterOfIncomingProduceRemarks(),
                hCDParkhouseWarehouseBus.getIsAreproduceAndSourcesDeclared(),
                hCDParkhouseWarehouseBus.getAreProduceAndSourcesDeclaredRemarks(),
                hCDParkhouseWarehouseBus.getIsCopiesofProduceCollection(),
                hCDParkhouseWarehouseBus.getCopiesOfProduceCollectionRemarks(),
                hCDParkhouseWarehouseBus.getIsHarvestdateAndQuantity(),
                hCDParkhouseWarehouseBus.getHarvestDateAndQuantityRemarks(),
                hCDParkhouseWarehouseBus.getIsDatelastSprayed(),
                hCDParkhouseWarehouseBus.getDateLastSprayedRemarks(),
                hCDParkhouseWarehouseBus.getIsDocumentedtraceability(),
                hCDParkhouseWarehouseBus.getDocumentedTraceabilityRemarks(),
                hCDParkhouseWarehouseBus.getIsArePackedproductsCoded(),
                hCDParkhouseWarehouseBus.getArePackedProductsCodedRemarks(),
                hCDParkhouseWarehouseBus.getIsOrderandDispatch(),
                hCDParkhouseWarehouseBus.getOrderAndDispatchRemarks(),
                hCDParkhouseWarehouseBus.getIsChemicalListapproved(),
                hCDParkhouseWarehouseBus.getHemicallistapprovedRemarks(),
                hCDParkhouseWarehouseBus.getIsTradenameoftheProductRecorded(),
                hCDParkhouseWarehouseBus.getTradenameOftheProductRecordedRemarks(),
                hCDParkhouseWarehouseBus.getIsAmountofChemicalAppliedRecorded(),
                hCDParkhouseWarehouseBus.getAmountOfChemicalAppliedRecordedRemarks(),
                hCDParkhouseWarehouseBus.getIsTrainingschedule(),
                hCDParkhouseWarehouseBus.getTrainingScheduleRemarks(),
                hCDParkhouseWarehouseBus.getIsListofProduceHandling(),
                hCDParkhouseWarehouseBus.getListofProduceHandlingRemarks(),
                hCDParkhouseWarehouseBus.getIsproofOfTraining(),
                hCDParkhouseWarehouseBus.getProofOfTrainingRemarks(),
                hCDParkhouseWarehouseBus.getIsWorkingAreaandPremisesKept(),
                hCDParkhouseWarehouseBus.getWorkingAreaAndPremisesKeptRemarks(),
                hCDParkhouseWarehouseBus.getIsPersonalwearing(),
                hCDParkhouseWarehouseBus.getPersonalWearingRemarks(),
                hCDParkhouseWarehouseBus.getIsFoodhandlingPersonel(),
                hCDParkhouseWarehouseBus.getFoodhandlingPersonelRemarks(),
                hCDParkhouseWarehouseBus.getIsFoodhandlingequipment(),
                hCDParkhouseWarehouseBus.getFoodhandlingEquipmentRemarks(),
                hCDParkhouseWarehouseBus.getIsAdequateventillation(),
                hCDParkhouseWarehouseBus.getAdequateVentillationRemarks(),
                hCDParkhouseWarehouseBus.getIsFacilityconformshealthAct(),
                hCDParkhouseWarehouseBus.getAcilityConformshealthActRemarks(),
                isFacilitydesigned,
                facilityDesignedRemarks,
                isDisplayedprominentSigns,
                displayedProminentSignsRemarks,
                isDisplayedProminentproduceSpecifications,
                displayedProminentProduceSpecificationsRemarks,
                isStorageareaOfPackaging,
                storageAreaOfPackagingRemarks,
                isProductsgraded,
                productsGradedRemarks,
                isProducefollowFIFO,
                produceFollowFIFORemarks,
                isAcquissitionofProduce,
                acquissitionOfProduceRemarks,
                isStorageareaSafeHygiene,
                storageAreaSafeHygieneRemarks,
                otherComments,
                recommendation,
                recommendationRemarks,
                false,
                ""

        );

        if (valid) {

            if (hCDParkhouseWarehouseBus.getLocalID() != null && !hCDParkhouseWarehouseBus.getLocalID().isEmpty()) {
                db.UpdateparkhouseWarehouse(hCDParkhouseWarehouse);
              horticulturalPackhouseWarehouseViewModel.addRecord(hCDParkhouseWarehouse);

                Intent intent = new Intent(getActivity(), DashboardActivity.class);
                Objects.requireNonNull(getActivity()).finish();
                startActivity(intent);

            } else {
                Toast.makeText(app, "Please select item from Checklist", Toast.LENGTH_SHORT).show();

            }

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

    private void setReccomendationsView(List<ReccomendationsView> getdummy10marks) {
        //        reccomendationsViewList.add("- Required -");
        for (ReccomendationsView regionWrapper : getdummy10marks) {
            reccomendationsViewList.add(regionWrapper);
        }

        ArrayAdapter<ReccomendationsView> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, reccomendationsViewList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssReccomendation.setAdapter(regionAdapter);

    }

    private List<ReccomendationsView> getReccomendationsView() {
        List<ReccomendationsView> listViewItems = new ArrayList<>();
        listViewItems.add(new ReccomendationsView("-select-", ""));
        listViewItems.add(new ReccomendationsView("I Recommend", "10000245"));
        listViewItems.add(new ReccomendationsView("I Do Not Recommend", "10000246"));

        return listViewItems;
    }

}
