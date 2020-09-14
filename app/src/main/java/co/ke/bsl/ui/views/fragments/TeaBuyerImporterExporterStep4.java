package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.R;
import co.ke.bsl.data.view.TeaBuyerImporterExporterBus;
import co.ke.bsl.data.view.View1Marks;
import co.ke.bsl.data.view.View2Marks;
import co.ke.bsl.data.view.View5Marks;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeaBuyerImporterExporterStep4 extends Fragment implements BlockingStep {

    @BindView(R.id.isPackagingMaterialConfirmity)
    CheckBox isPackagingMaterialConfirmity;
    @BindView(R.id.sspackagingMaterialConfirmityMust2mks)
    SearchableSpinner sspackagingMaterialConfirmityMust2mks;
    @BindView(R.id.etpackagingMaterialConfirmitymarksMust2mks)
    CustomEditText etpackagingMaterialConfirmitymarksMust2mks;
    @BindView(R.id.etpackagingMaterialConfirmityRemarks)
    CustomEditText etpackagingMaterialConfirmityRemarks;
    @BindView(R.id.isNonConformingProduct)
    CheckBox isNonConformingProduct;
    @BindView(R.id.ssNonConformingProduct3mks)
    SearchableSpinner ssNonConformingProduct3mks;
    @BindView(R.id.etNonConformingProductRemarks)
    CustomEditText etNonConformingProductRemarks;
    @BindView(R.id.isPalletsHeatTreated)
    CheckBox isPalletsHeatTreated;
    @BindView(R.id.ssPalletsHeatTreated1mks)
    SearchableSpinner ssPalletsHeatTreated1mks;
    @BindView(R.id.etPalletsHeatTreatedRemarks)
    CustomEditText etPalletsHeatTreatedRemarks;
    @BindView(R.id.isTeaDispatchRecordMaintained)
    CheckBox isTeaDispatchRecordMaintained;
    @BindView(R.id.ssTeaDispatchRecordMaintained1mks)
    SearchableSpinner ssTeaDispatchRecordMaintained1mks;
    @BindView(R.id.etTeaDispatchRecordMaintainedRemarks)
    CustomEditText etTeaDispatchRecordMaintainedRemarks;
    @BindView(R.id.isEquipmentIdentification)
    CheckBox isEquipmentIdentification;
    @BindView(R.id.ssEquipmentIdentification2mks)
    SearchableSpinner ssEquipmentIdentification2mks;
    @BindView(R.id.etEquipmentIdentificationRemarks)
    CustomEditText etEquipmentIdentificationRemarks;
    @BindView(R.id.isTraceabilitySystem)
    CheckBox isTraceabilitySystem;
    @BindView(R.id.sstraceabilitySystemMandatory10mks)
    SearchableSpinner sstraceabilitySystemMandatory10mks;
    @BindView(R.id.ettraceabilitySystemRemarks)
    CustomEditText ettraceabilitySystemRemarks;
    @BindView(R.id.isFoodSafety)
    CheckBox isFoodSafety;
    @BindView(R.id.ssFoodSafety2mks)
    SearchableSpinner ssFoodSafety2mks;
    @BindView(R.id.etFoodSafetyRemarks)
    CustomEditText etFoodSafetyRemarks;
    @BindView(R.id.isCustomerFeebackRecords)
    CheckBox isCustomerFeebackRecords;
    @BindView(R.id.ssCustomerFeebackRecords1mks)
    SearchableSpinner ssCustomerFeebackRecords1mks;
    @BindView(R.id.etCustomerFeebackRecordsRemarks)
    CustomEditText etCustomerFeebackRecordsRemarks;
    @BindView(R.id.isprocesdocuments)
    CheckBox isprocesdocuments;
    @BindView(R.id.ssprocesdocuments2mks)
    SearchableSpinner ssprocesdocuments2mks;
    @BindView(R.id.etprocesdocumentsRemarks)
    CustomEditText etprocesdocumentsRemarks;

    private ArrayList<String> marksOf2List = new ArrayList<>();
    private ArrayList<String> marksOf1List = new ArrayList<>();
    private ArrayList<String> marksOf5List = new ArrayList<>();

    private String packaginMaterialConformity, nonConformityProduct, pallets, teaDispatch, equipmentIdentification, traceabilitySystem, foodSafetyHazards, customerFeedback, processDocuments;
    private String packaginMaterialConformitymarks, nonConformityProductmarks, palletsmarks, teaDispatchmarks, equipmentIdentificationmarks, traceabilitySystemmarks, foodSafetyHazardsmarks, customerFeedbackmarks, processDocumentsmarks;
    private String packaginMaterialConformityremarks, nonConformityProductremarks, palletsremarks, teaDispatchremarks, equipmentIdentificationremarks, traceabilitySystemremarks, foodSafetyHazardsremarks, customerFeedbackremarks, processDocumentsremarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tea_buyer_importer_exporter_step4, container, false);
        ButterKnife.bind(this, view);

        setList1Marks(getDummy1Marks());
        setList2Marks(getDummy2Marks());
        setList5Marks(getDummy5Marks());

        isPackagingMaterialConfirmity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPackagingMaterialConfirmity.isChecked()) {
                    packaginMaterialConformity = "Y";
                } else {
                    packaginMaterialConformity = "N";
                }
            }
        });

        isNonConformingProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNonConformingProduct.isChecked()) {
                    nonConformityProduct = "Y";
                } else {
                    nonConformityProduct = "N";
                }
            }
        });

        isPalletsHeatTreated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPalletsHeatTreated.isChecked()) {
                    pallets = "Y";
                } else {
                    pallets = "N";
                }
            }
        });

        isTeaDispatchRecordMaintained.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTeaDispatchRecordMaintained.isChecked()) {
                    teaDispatch = "Y";
                } else {
                    teaDispatch = "N";
                }
            }
        });

        isEquipmentIdentification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEquipmentIdentification.isChecked()) {
                    equipmentIdentification = "Y";
                } else {
                    equipmentIdentification = "N";
                }
            }
        });

        isTraceabilitySystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTraceabilitySystem.isChecked()) {
                    traceabilitySystem = "Y";
                } else {
                    traceabilitySystem = "N";
                }
            }
        });

        isFoodSafety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFoodSafety.isChecked()) {
                    foodSafetyHazards = "Y";
                } else {
                    foodSafetyHazards = "N";
                }
            }
        });

        isCustomerFeebackRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCustomerFeebackRecords.isChecked()) {
                    customerFeedback = "Y";
                } else {
                    customerFeedback = "N";
                }
            }
        });

        isprocesdocuments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isprocesdocuments.isChecked()) {
                    processDocuments = "Y";
                } else {
                    processDocuments = "N";
                }
            }
        });

        sspackagingMaterialConfirmityMust2mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                packaginMaterialConformitymarks = sspackagingMaterialConfirmityMust2mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssNonConformingProduct3mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nonConformityProductmarks = ssNonConformingProduct3mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssPalletsHeatTreated1mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                palletsmarks = ssPalletsHeatTreated1mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssTeaDispatchRecordMaintained1mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                teaDispatchmarks = ssTeaDispatchRecordMaintained1mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssEquipmentIdentification2mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                equipmentIdentificationmarks = ssEquipmentIdentification2mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sstraceabilitySystemMandatory10mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                traceabilitySystemmarks = sstraceabilitySystemMandatory10mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssFoodSafety2mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                foodSafetyHazardsmarks = ssFoodSafety2mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssCustomerFeebackRecords1mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                customerFeedbackmarks = ssCustomerFeebackRecords1mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssprocesdocuments2mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                processDocumentsmarks = ssprocesdocuments2mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }

    private void setList1Marks(List<View1Marks> dummy1Marks) {

        marksOf1List.add("- Required -");
        for (View1Marks regionWrapper : dummy1Marks) {
            marksOf1List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf1List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        sspackagingMaterialConfirmityMust2mks.setAdapter(regionAdapter);
        ssPalletsHeatTreated1mks.setAdapter(regionAdapter);
        ssTeaDispatchRecordMaintained1mks.setAdapter(regionAdapter);
        ssCustomerFeebackRecords1mks.setAdapter(regionAdapter);
    }

    private void setList2Marks(List<View2Marks> dummy2Marks) {

        marksOf2List.add("- Required -");
        for (View2Marks regionWrapper : dummy2Marks) {
            marksOf2List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf2List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssprocesdocuments2mks.setAdapter(regionAdapter);
        ssFoodSafety2mks.setAdapter(regionAdapter);
        ssEquipmentIdentification2mks.setAdapter(regionAdapter);
        ssNonConformingProduct3mks.setAdapter(regionAdapter);
    }

    private void setList5Marks(List<View5Marks> dummy5Marks) {

        marksOf5List.add("- Required -");
        for (View5Marks regionWrapper : dummy5Marks) {
            marksOf5List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf5List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        sstraceabilitySystemMandatory10mks.setAdapter(regionAdapter);
    }

    private List<View1Marks> getDummy1Marks() {
        List<View1Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View1Marks("0"));
        listViewItems.add(new View1Marks("1"));
        return listViewItems;
    }

    private List<View2Marks> getDummy2Marks() {
        List<View2Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View2Marks("0"));
        listViewItems.add(new View2Marks("2"));
        return listViewItems;
    }

    private List<View5Marks> getDummy5Marks() {
        List<View5Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View5Marks("0"));
        listViewItems.add(new View5Marks("5"));
        return listViewItems;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        packaginMaterialConformitymarks = Objects.requireNonNull(etpackagingMaterialConfirmitymarksMust2mks.getText()).toString().trim();
        packaginMaterialConformityremarks = Objects.requireNonNull(etpackagingMaterialConfirmityRemarks.getText()).toString().trim();
        nonConformityProductremarks = Objects.requireNonNull(etNonConformingProductRemarks.getText()).toString().trim();
        palletsremarks = Objects.requireNonNull(etPalletsHeatTreatedRemarks.getText()).toString().trim();
        teaDispatchremarks = Objects.requireNonNull(etTeaDispatchRecordMaintainedRemarks.getText()).toString().trim();
        equipmentIdentificationremarks = Objects.requireNonNull(etEquipmentIdentificationRemarks.getText()).toString().trim();
        traceabilitySystemremarks = Objects.requireNonNull(ettraceabilitySystemRemarks.getText()).toString().trim();
        foodSafetyHazardsremarks = Objects.requireNonNull(etFoodSafetyRemarks.getText()).toString().trim();
        customerFeedbackremarks = Objects.requireNonNull(etCustomerFeebackRecordsRemarks.getText()).toString().trim();
        processDocumentsremarks = Objects.requireNonNull(etprocesdocumentsRemarks.getText()).toString().trim();


        TeaBuyerImporterExporterBus teaBuyerImporterExporterBus = TeaBuyerImporterExporterBus.getInstance();

        teaBuyerImporterExporterBus.setIsPackagingMaterial(packaginMaterialConformity);
        teaBuyerImporterExporterBus.setPackagingMaterialMarks(packaginMaterialConformitymarks);
        teaBuyerImporterExporterBus.setPackagingMaterialRemarks(packaginMaterialConformityremarks);
        teaBuyerImporterExporterBus.setIsNonConformingProduct(nonConformityProduct);
        teaBuyerImporterExporterBus.setNonConformingProductMarks(nonConformityProductmarks);
        teaBuyerImporterExporterBus.setNonConformingProductRemarks(nonConformityProductremarks);
        teaBuyerImporterExporterBus.setIsPalletsAreHeatTreated(pallets);
        teaBuyerImporterExporterBus.setPalletsAreHeatTreatedMarks(palletsmarks);
        teaBuyerImporterExporterBus.setPalletsAreHeatTreatedRemarks(palletsremarks);
        teaBuyerImporterExporterBus.setIsTeaDispatchRecordsMaintained(teaDispatch);
        teaBuyerImporterExporterBus.setTeaDispatchRecordsMaintainedMarks(teaDispatchmarks);
        teaBuyerImporterExporterBus.setTeaDispatchRecordsMaintainedRemarks(teaDispatchremarks);
        teaBuyerImporterExporterBus.setIsEquipmentIdentification(equipmentIdentification);
        teaBuyerImporterExporterBus.setEquipmentIdentificationMarks(equipmentIdentificationmarks);
        teaBuyerImporterExporterBus.setEquipmentIdentificationRemarks(equipmentIdentificationremarks);
        teaBuyerImporterExporterBus.setIsTraceabilitySystem(traceabilitySystem);
        teaBuyerImporterExporterBus.setTraceabilitySystemMarks(traceabilitySystemmarks);
        teaBuyerImporterExporterBus.setTraceabilitySystemRemarks(traceabilitySystemremarks);
        teaBuyerImporterExporterBus.setIsFoodSafetyHazardsIdentified(foodSafetyHazards);
        teaBuyerImporterExporterBus.setFoodSafetyHazardsIdentifiedMarks(foodSafetyHazardsmarks);
        teaBuyerImporterExporterBus.setFoodSafetyHazardsIdentifiedRemarks(foodSafetyHazardsremarks);
        teaBuyerImporterExporterBus.setIsCustomerFeedbackRecords(customerFeedback);
        teaBuyerImporterExporterBus.setCustomerFeedbackRecordsMarks(customerFeedbackmarks);
        teaBuyerImporterExporterBus.setCustomerFeedbackRecordsRemarks(customerFeedbackremarks);
        teaBuyerImporterExporterBus.setIsProcessDocumentsAndRecords(processDocuments);
        teaBuyerImporterExporterBus.setProcessDocumentsAndRecordsMarks(processDocumentsmarks);
        teaBuyerImporterExporterBus.setProcessDocumentsAndRecordsRemarks(processDocumentsremarks);

        callback.goToNextStep();
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
