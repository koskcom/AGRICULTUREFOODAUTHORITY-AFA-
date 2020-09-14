package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

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
import co.ke.bsl.data.model.HorticultureCropExportLicenceFarmInspection;
import co.ke.bsl.data.view.HorticultureCropExportLicenceFarmInspectionBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.HorticulturalCropsExportLicenceViewModel;
import co.ke.bsl.ui.viewmodels.HorticulturalPackhouseWarehouseViewModel;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorticultureLicenceFarmInspectionDetails4 extends Fragment implements BlockingStep {

    @BindView(R.id.isCollectionShedAccessible)
    CheckBox isCollectionShedAccessible;
    @BindView(R.id.etHLFICollectionShedAccessible)
    CustomEditText etHLFICollectionShedAccessible;

    @BindView(R.id.isCollectionAreaOffice)
    CheckBox isCollectionAreaOffice;
    @BindView(R.id.etHLFICollectionAreaOffice)
    CustomEditText etHLFICollectionAreaOffice;

    @BindView(R.id.isCollectionShedEasy)
    CheckBox isCollectionShedEasy;
    @BindView(R.id.etHLFICollectionShedEasy)
    CustomEditText etHLFICollectionShedEasy;

    @BindView(R.id.isAdequateLightingVentilation)
    CheckBox isAdequateLightingVentilation;
    @BindView(R.id.etHLFIAdequateLightingVentilation)
    CustomEditText etHLFIAdequateLightingVentilation;

    @BindView(R.id.isWasteDisposalFacility)
    CheckBox isWasteDisposalFacility;
    @BindView(R.id.etHLFIWasteDisposalFacility)
    CustomEditText etHLFIWasteDisposalFacility;

    @BindView(R.id.isRegisterIncoming)
    CheckBox isRegisterIncoming;
    @BindView(R.id.etHLFIRegisterIncoming)
    CustomEditText etHLFIRegisterIncoming;

    @BindView(R.id.isProcedureForProduct)
    CheckBox isProcedureForProduct;
    @BindView(R.id.etHLFIProcedureForProduct)
    CustomEditText etHLFIProcedureForProduct;

    @BindView(R.id.isPersonnelHandling)
    CheckBox isPersonnelHandling;
    @BindView(R.id.etHLFIPersonnelHandling)
    CustomEditText etHLFIPersonnelHandling;

    @BindView(R.id.isAllFarmersRegistered)
    CheckBox isAllFarmersRegistered;
    @BindView(R.id.etHLFIAllFarmersRegistered)
    CustomEditText etHLFIAllFarmersRegistered;

    @BindView(R.id.isPresenceTraceability)
    CheckBox isPresenceTraceability;
    @BindView(R.id.etHLFIPresenceTraceability)
    CustomEditText etHLFIPresenceTraceability;

    @BindView(R.id.isAvailabilityOfRegistered)
    CheckBox isAvailabilityOfRegistered;
    @BindView(R.id.etHLFIAvailabilityOfRegistered)
    CustomEditText etHLFIAvailabilityOfRegistered;

    @BindView(R.id.isTrainingCertificates)
    CheckBox isTrainingCertificates;
    @BindView(R.id.etHLFITrainingCertificates)
    CustomEditText etHLFITrainingCertificates;

    @BindView(R.id.isEvidenceOfTechnical)
    CheckBox isEvidenceOfTechnical;
    @BindView(R.id.etHLFIEvidenceOfTechnical)
    CustomEditText etHLFIEvidenceOfTechnical;

    @BindView(R.id.etHLFIOtherComments)
    CustomEditText etHLFIOtherComments;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    private String accessible, office, easy, ventilation, wasteDisposal, incoming, product, personnel, allFarmers, traceability, availability, training, technical;

    AFADatabaseAdapter db;
    AFA app;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();


    private HorticulturalCropsExportLicenceViewModel horticulturalCropsExportLicenceViewModel;

    public HorticultureLicenceFarmInspectionDetails4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horticulture_licence_farm_inspection_details4, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        horticulturalCropsExportLicenceViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(HorticulturalCropsExportLicenceViewModel.class);

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


        isCollectionShedAccessible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCollectionShedAccessible.isChecked()) {
                    accessible = "Y";
                } else {
                    accessible = "N";
                }
            }

        });

        isCollectionAreaOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCollectionAreaOffice.isChecked()) {
                    office = "Y";
                } else {
                    office = "N";
                }
            }

        });

        isCollectionShedEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCollectionShedEasy.isChecked()) {
                    easy = "Y";
                } else {
                    easy = "N";
                }
            }

        });

        isAdequateLightingVentilation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAdequateLightingVentilation.isChecked()) {
                    ventilation = "Y";
                } else {
                    ventilation = "N";
                }
            }

        });

        isWasteDisposalFacility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWasteDisposalFacility.isChecked()) {
                    wasteDisposal = "Y";
                } else {
                    wasteDisposal = "N";
                }
            }

        });

        isRegisterIncoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRegisterIncoming.isChecked()) {
                    incoming = "Y";
                } else {
                    incoming = "N";
                }
            }

        });

        isProcedureForProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProcedureForProduct.isChecked()) {
                    product = "Y";
                } else {
                    product = "N";
                }
            }

        });

        isPersonnelHandling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPersonnelHandling.isChecked()) {
                    personnel = "Y";
                } else {
                    personnel = "N";
                }
            }

        });

        isAllFarmersRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAllFarmersRegistered.isChecked()) {
                    allFarmers = "Y";
                } else {
                    allFarmers = "N";
                }
            }

        });

        isPresenceTraceability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPresenceTraceability.isChecked()) {
                    traceability = "Y";
                } else {
                    traceability = "N";
                }
            }

        });

        isAvailabilityOfRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAvailabilityOfRegistered.isChecked()) {
                    availability = "Y";
                } else {
                    availability = "N";
                }
            }

        });

        isTrainingCertificates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTrainingCertificates.isChecked()) {
                    training = "Y";
                } else {
                    training = "N";
                }
            }

        });

        isEvidenceOfTechnical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEvidenceOfTechnical.isChecked()) {
                    technical = "Y";
                } else {
                    technical = "N";
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
        String strAccessible = Objects.requireNonNull(etHLFICollectionShedAccessible.getText()).toString().trim();
        String strOffice = Objects.requireNonNull(etHLFICollectionAreaOffice.getText()).toString().trim();
        String strEasy = Objects.requireNonNull(etHLFICollectionShedEasy.getText()).toString().trim();
        String strVentilation = Objects.requireNonNull(etHLFIAdequateLightingVentilation.getText()).toString().trim();
        String strWasteDisposal = Objects.requireNonNull(etHLFIWasteDisposalFacility.getText()).toString().trim();
        String strincoming = Objects.requireNonNull(etHLFIRegisterIncoming.getText()).toString().trim();
        String strProduct = Objects.requireNonNull(etHLFIProcedureForProduct.getText()).toString().trim();
        String strPersonnel = Objects.requireNonNull(etHLFIPersonnelHandling.getText()).toString().trim();
        String strAllFarmers = Objects.requireNonNull(etHLFIAllFarmersRegistered.getText()).toString().trim();
        String strTraceability = Objects.requireNonNull(etHLFIPresenceTraceability.getText()).toString().trim();
        String strAvailability = Objects.requireNonNull(etHLFIAvailabilityOfRegistered.getText()).toString().trim();
        String strTraining = Objects.requireNonNull(etHLFITrainingCertificates.getText()).toString().trim();
        String strTechnical = Objects.requireNonNull(etHLFIEvidenceOfTechnical.getText()).toString().trim();
        String strComments = Objects.requireNonNull(etHLFIOtherComments.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateFields(isCollectionShedAccessible, etHLFICollectionShedAccessible, strAccessible) &
                validateFields(isCollectionAreaOffice, etHLFICollectionAreaOffice, strOffice) &
                validateFields(isCollectionShedEasy, etHLFICollectionShedEasy, strEasy) &
                validateFields(isAdequateLightingVentilation, etHLFIAdequateLightingVentilation, strVentilation) &
                validateFields(isWasteDisposalFacility, etHLFIWasteDisposalFacility, strWasteDisposal) &
                validateFields(isRegisterIncoming, etHLFIRegisterIncoming, strincoming) &
                validateFields(isProcedureForProduct, etHLFIProcedureForProduct, strProduct) &
                validateFields(isPersonnelHandling, etHLFIPersonnelHandling, strPersonnel) &
                validateFields(isAllFarmersRegistered, etHLFIAllFarmersRegistered, strAllFarmers) &
                validateFields(isPresenceTraceability, etHLFIPresenceTraceability, strTraceability) &
                validateFields(isAvailabilityOfRegistered, etHLFIAvailabilityOfRegistered, strAvailability) &
                validateFields(isTrainingCertificates, etHLFITrainingCertificates, strTraining) &
                validateFields(isEvidenceOfTechnical, etHLFIEvidenceOfTechnical, strTechnical);

        HorticultureCropExportLicenceFarmInspectionBus horticultureCropExportLicenceFarmInspectionBus = HorticultureCropExportLicenceFarmInspectionBus.getInstance();
        HorticultureCropExportLicenceFarmInspection horticultureCropExportLicenceFarmInspection = new HorticultureCropExportLicenceFarmInspection(
                0,
                horticultureCropExportLicenceFarmInspectionBus.getNameOfApplicant(),
                horticultureCropExportLicenceFarmInspectionBus.getIsAdhocInspection(),
                horticultureCropExportLicenceFarmInspectionBus.getCountyId(),
                horticultureCropExportLicenceFarmInspectionBus.getSubCountyId(),
                horticultureCropExportLicenceFarmInspectionBus.getLocation(),
                horticultureCropExportLicenceFarmInspectionBus.getTelephone(),
                horticultureCropExportLicenceFarmInspectionBus.getLocalID(),
                horticultureCropExportLicenceFarmInspectionBus.getIsExporterOwnFarm(),
                horticultureCropExportLicenceFarmInspectionBus.getIsContractedSources(),
                horticultureCropExportLicenceFarmInspectionBus.getFarmName(),
                horticultureCropExportLicenceFarmInspectionBus.getFarmerName(),
                horticultureCropExportLicenceFarmInspectionBus.getFarmerIdNumber(),
                horticultureCropExportLicenceFarmInspectionBus.getFarmerTelephone(),
                horticultureCropExportLicenceFarmInspectionBus.getFarmerEmail(),
                horticultureCropExportLicenceFarmInspectionBus.getFarmerCounty(),
                horticultureCropExportLicenceFarmInspectionBus.getFarmerLocation(),
                horticultureCropExportLicenceFarmInspectionBus.getIntendedCrop(),
                horticultureCropExportLicenceFarmInspectionBus.getAcreageUnderCrop(),
                horticultureCropExportLicenceFarmInspectionBus.getIsCcertificationToGap(),
                horticultureCropExportLicenceFarmInspectionBus.getCcertificationToGap(),
                horticultureCropExportLicenceFarmInspectionBus.getIsDulySigned(),
                horticultureCropExportLicenceFarmInspectionBus.getDulySigned(),
                horticultureCropExportLicenceFarmInspectionBus.getIsProductionPlanPerCrop(),
                horticultureCropExportLicenceFarmInspectionBus.getProductionPlanPerCrop(),
                horticultureCropExportLicenceFarmInspectionBus.getIsExporterAware(),
                horticultureCropExportLicenceFarmInspectionBus.getExporterAware(),
                horticultureCropExportLicenceFarmInspectionBus.getIsExporterTrainedPersonnel(),
                horticultureCropExportLicenceFarmInspectionBus.getExporterTrainedPersonnel(),
                horticultureCropExportLicenceFarmInspectionBus.getIsControlledAndApproved(),
                horticultureCropExportLicenceFarmInspectionBus.getControlledAndApproved(),
                horticultureCropExportLicenceFarmInspectionBus.getIsExporterHavePetcide(),
                horticultureCropExportLicenceFarmInspectionBus.getExporterHavePetcide(),
                horticultureCropExportLicenceFarmInspectionBus.getIsFieldCodes(),
                horticultureCropExportLicenceFarmInspectionBus.getFieldCodes(),
                horticultureCropExportLicenceFarmInspectionBus.getIsPlantingDate(),
                horticultureCropExportLicenceFarmInspectionBus.getPlantingDate(),
                horticultureCropExportLicenceFarmInspectionBus.getIsChemicalListApproved(),
                horticultureCropExportLicenceFarmInspectionBus.getChemicalListApproved(),
                horticultureCropExportLicenceFarmInspectionBus.getIsPresenceOfApprovedSpray(),
                horticultureCropExportLicenceFarmInspectionBus.getPresenceOfApprovedSpray(),
                horticultureCropExportLicenceFarmInspectionBus.getIsProductInvoices(),
                horticultureCropExportLicenceFarmInspectionBus.getProductInvoices(),
                horticultureCropExportLicenceFarmInspectionBus.getIsSprayRecords(),
                horticultureCropExportLicenceFarmInspectionBus.getSprayRecords(),
                horticultureCropExportLicenceFarmInspectionBus.getIsTradenameOfProduct(),
                horticultureCropExportLicenceFarmInspectionBus.getTradenameOfProduct(),
                horticultureCropExportLicenceFarmInspectionBus.getIsPhiRecorded(),
                horticultureCropExportLicenceFarmInspectionBus.getPhiRecorded(),
                horticultureCropExportLicenceFarmInspectionBus.getIsAllSprayingDates(),
                horticultureCropExportLicenceFarmInspectionBus.getAllSprayingDates(),
                horticultureCropExportLicenceFarmInspectionBus.getIsAmountOfPesticide(),
                horticultureCropExportLicenceFarmInspectionBus.getAmountOfPesticide(),
                horticultureCropExportLicenceFarmInspectionBus.getIsPhiObserved(),
                horticultureCropExportLicenceFarmInspectionBus.getPhiObserved(),
                horticultureCropExportLicenceFarmInspectionBus.getIsTrainingSchedules(),
                horticultureCropExportLicenceFarmInspectionBus.getTrainingSchedules(),
                horticultureCropExportLicenceFarmInspectionBus.getIsPestManagementProtocol(),
                horticultureCropExportLicenceFarmInspectionBus.getPestManagementProtocol(),
                horticultureCropExportLicenceFarmInspectionBus.getIsEvidenceOnScouring(),
                horticultureCropExportLicenceFarmInspectionBus.getEvidenceOnScouring(),
                horticultureCropExportLicenceFarmInspectionBus.getIsEvidenceOfPests(),
                horticultureCropExportLicenceFarmInspectionBus.getEvidenceOfPests(),
                horticultureCropExportLicenceFarmInspectionBus.getIsCollectionShedForFarmers(),
                horticultureCropExportLicenceFarmInspectionBus.getCollectionShedForFarmers(),
                horticultureCropExportLicenceFarmInspectionBus.getIsCollectionAndSortingShed(),
                horticultureCropExportLicenceFarmInspectionBus.getCollectionAndSortingShed(),
                horticultureCropExportLicenceFarmInspectionBus.getIsAppropriateHygiene(),
                horticultureCropExportLicenceFarmInspectionBus.getAppropriateHygiene(),
                horticultureCropExportLicenceFarmInspectionBus.getIsGradingtables(),
                horticultureCropExportLicenceFarmInspectionBus.getGradingtables(),
                horticultureCropExportLicenceFarmInspectionBus.getIsShedHaveRunningWater(),
                horticultureCropExportLicenceFarmInspectionBus.getShedHaveRunningWater(),
                horticultureCropExportLicenceFarmInspectionBus.getIsToiletAtFacility(),
                horticultureCropExportLicenceFarmInspectionBus.getToiletAtFacility(),
                horticultureCropExportLicenceFarmInspectionBus.getIsPpeGraders(),
                horticultureCropExportLicenceFarmInspectionBus.getPpeGraders(),
                horticultureCropExportLicenceFarmInspectionBus.getIsStorageAreaForGraded(),
                horticultureCropExportLicenceFarmInspectionBus.getStorageAreaForGraded(),
                horticultureCropExportLicenceFarmInspectionBus.getIsPlasticCrates(),
                horticultureCropExportLicenceFarmInspectionBus.getPlasticCrates(),
                accessible,
                strAccessible,
                office,
                strOffice,
                easy,
                strEasy,
                ventilation,
                strVentilation,
                wasteDisposal,
                strWasteDisposal,
                incoming,
                strincoming,
                product,
                strProduct,
                personnel,
                strPersonnel,
                allFarmers,
                strAllFarmers,
                traceability,
                strTraceability,
                availability,
                strAvailability,
                training,
                strTraining,
                technical,
                strTechnical,
                strComments,
                recommendation,
                recommendationRemarks,
                false,
                ""
        );

        if (valid) {
            if (null != horticultureCropExportLicenceFarmInspectionBus.getLocalID() && !horticultureCropExportLicenceFarmInspectionBus.getLocalID().isEmpty()) {

                long updateHorticultureCropExportLicenceFarmInspection = db.updateHorticultureCropExportLicenceFarmInspection(horticultureCropExportLicenceFarmInspection);
              horticulturalCropsExportLicenceViewModel.addRecord(horticultureCropExportLicenceFarmInspection);

                System.out.println("updateHorticultureCropExportLicenceFarmInspection " + updateHorticultureCropExportLicenceFarmInspection);
                Intent intent = new Intent(getActivity(), DashboardActivity.class);
                Objects.requireNonNull(getActivity()).finish();
                startActivity(intent);
            }
        }
    }

        @Override
        public void onBackClicked (StepperLayout.OnBackClickedCallback callback){
            callback.goToPrevStep();
        }

        @Nullable
        @Override
        public VerificationError verifyStep () {
            return null;
        }

        @Override
        public void onSelected () {

        }

        @Override
        public void onError (@NonNull VerificationError error){

        }

        private boolean validateFields (CheckBox checkBox, CustomEditText customEditText, String
        customEditTextString){

            boolean result = false;

            if (!checkBox.isChecked()) {
                if (TextUtils.isEmpty(customEditTextString)) {
                    customEditText.setError("Field Required ");
                    result = false;
                } else {
                    result = true;
                }
            } else {
                customEditText.setError(null);
                result = true;
            }

            return result;
        }

        private boolean validateEditText (CustomEditText customEditText, String customEditTextString)
        {

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
