package co.ke.bsl.ui.views.fragments;

import android.content.Intent;
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
import co.ke.bsl.data.model.TeaBuyerImporterExporter;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.TeaBuyerImporterExporterBus;
import co.ke.bsl.data.view.TeaPackerBus;
import co.ke.bsl.data.view.View1Marks;
import co.ke.bsl.data.view.View2Marks;
import co.ke.bsl.data.view.View5Marks;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeaBuyerImporterExporterStep5 extends Fragment implements BlockingStep {

    @BindView(R.id.ispersonalhygienedocummented)
    CheckBox ispersonalhygienedocummented;
    @BindView(R.id.sspersonalhygienedocummented2mks)
    SearchableSpinner sspersonalhygienedocummented2mks;
    @BindView(R.id.etpersonalhygienedocummentedRemarks)
    CustomEditText etpersonalhygienedocummentedRemarks;
    @BindView(R.id.ismedicalScreening)
    CheckBox ismedicalScreening;
    @BindView(R.id.ssmedicalScreening1mks)
    SearchableSpinner ssmedicalScreening1mks;
    @BindView(R.id.etmedicalScreeningRemarks)
    CustomEditText etmedicalScreeningRemarks;
    @BindView(R.id.isValidmedicalcertificate)
    CheckBox isValidmedicalcertificate;
    @BindView(R.id.ssValidmedicalcertificate5mks)
    SearchableSpinner ssValidmedicalcertificate5mks;
    @BindView(R.id.etValidmedicalcertificateRemarks)
    CustomEditText etValidmedicalcertificateRemarks;
    @BindView(R.id.isadequateandcleanpersonalprot)
    CheckBox isadequateandcleanpersonalprot;
    @BindView(R.id.ssadequateandcleanpersonalprot5mks)
    SearchableSpinner ssadequateandcleanpersonalprot5mks;
    @BindView(R.id.etadequateandcleanpersonalprotRemarks)
    CustomEditText etadequateandcleanpersonalprotRemarks;
    @BindView(R.id.isValidCertOfreg)
    CheckBox isValidCertOfreg;
    @BindView(R.id.ssValidCertOfreg1mks)
    SearchableSpinner ssValidCertOfreg1mks;
    @BindView(R.id.etValidCertOfregRemarks)
    CustomEditText etValidCertOfregRemarks;

    @BindView(R.id.isIncidentandAccidentReports)
    CheckBox isIncidentandAccidentReports;
    @BindView(R.id.ssIncidentandAccidentreports1mks)
    SearchableSpinner ssIncidentandAccidentreports1mks;
    @BindView(R.id.etIncidentandAccidentReportsRemarks)
    CustomEditText etIncidentandAccidentReportsRemarks;

    @BindView(R.id.isFireEquipmentInspection)
    CheckBox isFireEquipmentInspection;
    @BindView(R.id.ssFireEquipmentInspection2mks)
    SearchableSpinner ssFireEquipmentInspection2mks;
    @BindView(R.id.etFireEquipmentInspectionRemarks)
    CustomEditText etFireEquipmentInspectionRemarks;
    @BindView(R.id.isMarkedZones)
    CheckBox isMarkedZones;
    @BindView(R.id.ssMarkedZones1mks)
    SearchableSpinner ssMarkedZones1mks;
    @BindView(R.id.etMarkedZonesRemarks)
    CustomEditText etMarkedZonesRemarks;
    @BindView(R.id.isLabourRules)
    CheckBox isLabourRules;
    @BindView(R.id.ssLabourRules1mks)
    SearchableSpinner ssLabourRules1mks;
    @BindView(R.id.etLabourRulesRemarks)
    CustomEditText etLabourRulesRemarks;
    @BindView(R.id.isCoplianceToOHS)
    CheckBox isCoplianceToOHS;
    @BindView(R.id.ssCoplianceToOHS1mks)
    SearchableSpinner ssCoplianceToOHS1mks;
    @BindView(R.id.etCoplianceToOHSRemarks)
    CustomEditText etCoplianceToOHSRemarks;
    @BindView(R.id.isCorrectionOfPrevInspec)
    CheckBox isCorrectionOfPrevInspec;
    @BindView(R.id.ssCorrectionOfPrevInspec2mks)
    SearchableSpinner ssCorrectionOfPrevInspec2mks;
    @BindView(R.id.etCorrectionOfPrevInspecRemarks)
    CustomEditText etCorrectionOfPrevInspecRemarks;

    AFADatabaseAdapter db;
    AFA app;

    private ArrayList<String> marksOf2List = new ArrayList<>();
    private ArrayList<String> marksOf1List = new ArrayList<>();
    private ArrayList<String> marksOf5List = new ArrayList<>();

    private String personalHygieneDocumented, medicalScreening, validMedicalCert, adequateAndCleanProt, validCertificateOfReg, incidentsAccidentsReports, fireEquipmentInspection, markedZones, complianceLabourRules, complianceToOHSAct, correctionOfPrevInspection;
    private String personalHygieneDocumentedmarks, medicalScreeningmarks, validMedicalCertmarks, adequateAndCleanProtmarks, validCertificateOfRegmarks, incidentsAccidentsReportsmarks, fireEquipmentInspectionmarks, markedZonesmarks, complianceLabourRulesmarks, complianceToOHSActmarks, correctionOfPrevInspectionmarks;
    private String personalHygieneDocumentedremarks, medicalScreeningremarks, validMedicalCertremarks, adequateAndCleanProtremarks, validCertificateOfRegremarks, incidentsAccidentsReportsremarks, fireEquipmentInspectionremarks, markedZonesremarks, complianceLabourRulesremarks, complianceToOHSActremarks, correctionOfPrevInspectionremarks;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tea_buyer_importer_exporter_step5, container, false);
        ButterKnife.bind(this, view);

        setList1Marks(getDummy1Marks());
        setList2Marks(getDummy2Marks());
        setList5Marks(getDummy5Marks());

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        ispersonalhygienedocummented.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ispersonalhygienedocummented.isChecked()) {
                    personalHygieneDocumented = "Y";
                } else {
                    personalHygieneDocumented = "N";
                }
            }
        });

        ismedicalScreening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ismedicalScreening.isChecked()) {
                    medicalScreening = "Y";
                } else {
                    medicalScreening = "N";
                }
            }
        });

        isValidmedicalcertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidmedicalcertificate.isChecked()) {
                    validMedicalCert = "Y";
                } else {
                    validMedicalCert = "N";
                }
            }
        });

        isadequateandcleanpersonalprot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isadequateandcleanpersonalprot.isChecked()) {
                    adequateAndCleanProt = "Y";
                } else {
                    adequateAndCleanProt = "N";
                }
            }
        });

        isValidCertOfreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidCertOfreg.isChecked()) {
                    validCertificateOfReg = "Y";
                } else {
                    validCertificateOfReg = "N";
                }
            }
        });

        isIncidentandAccidentReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isIncidentandAccidentReports.isChecked()) {
                    incidentsAccidentsReports = "Y";
                } else {
                    incidentsAccidentsReports = "N";
                }
            }
        });

        isFireEquipmentInspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFireEquipmentInspection.isChecked()) {
                    fireEquipmentInspection = "Y";
                } else {
                    fireEquipmentInspection = "N";
                }
            }
        });

        isMarkedZones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMarkedZones.isChecked()) {
                    markedZones = "Y";
                } else {
                    markedZones = "N";
                }
            }
        });

        isLabourRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLabourRules.isChecked()) {
                    complianceLabourRules = "Y";
                } else {
                    complianceLabourRules = "N";
                }
            }
        });

        isCoplianceToOHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCoplianceToOHS.isChecked()) {
                    complianceToOHSAct = "Y";
                } else {
                    complianceToOHSAct = "N";
                }
            }
        });

        isCorrectionOfPrevInspec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCorrectionOfPrevInspec.isChecked()) {
                    correctionOfPrevInspection = "Y";
                } else {
                    correctionOfPrevInspection = "N";
                }
            }
        });

        sspersonalhygienedocummented2mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                personalHygieneDocumentedmarks = sspersonalhygienedocummented2mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssmedicalScreening1mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                medicalScreeningmarks = ssmedicalScreening1mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssValidmedicalcertificate5mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                validMedicalCertmarks = ssValidmedicalcertificate5mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssadequateandcleanpersonalprot5mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adequateAndCleanProtmarks = ssadequateandcleanpersonalprot5mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssValidCertOfreg1mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                validCertificateOfRegmarks = ssValidCertOfreg1mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssIncidentandAccidentreports1mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                incidentsAccidentsReportsmarks = ssIncidentandAccidentreports1mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssFireEquipmentInspection2mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fireEquipmentInspectionmarks = ssFireEquipmentInspection2mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssMarkedZones1mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                markedZonesmarks = ssMarkedZones1mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssLabourRules1mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                complianceLabourRulesmarks = ssLabourRules1mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssCoplianceToOHS1mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                complianceToOHSActmarks = ssCoplianceToOHS1mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssCorrectionOfPrevInspec2mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                correctionOfPrevInspectionmarks = ssCorrectionOfPrevInspec2mks.getSelectedItem().toString();
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
        ssCoplianceToOHS1mks.setAdapter(regionAdapter);
        ssLabourRules1mks.setAdapter(regionAdapter);
        ssMarkedZones1mks.setAdapter(regionAdapter);
        ssIncidentandAccidentreports1mks.setAdapter(regionAdapter);
        ssValidCertOfreg1mks.setAdapter(regionAdapter);
        ssmedicalScreening1mks.setAdapter(regionAdapter);
    }

    private void setList2Marks(List<View2Marks> dummy2Marks) {

        marksOf2List.add("- Required -");
        for (View2Marks regionWrapper : dummy2Marks) {
            marksOf2List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf2List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        sspersonalhygienedocummented2mks.setAdapter(regionAdapter);
        ssFireEquipmentInspection2mks.setAdapter(regionAdapter);
        ssCorrectionOfPrevInspec2mks.setAdapter(regionAdapter);
    }

    private void setList5Marks(List<View5Marks> dummy5Marks) {

        marksOf5List.add("- Required -");
        for (View5Marks regionWrapper : dummy5Marks) {
            marksOf5List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf5List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssadequateandcleanpersonalprot5mks.setAdapter(regionAdapter);
        ssValidmedicalcertificate5mks.setAdapter(regionAdapter);
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
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        personalHygieneDocumentedremarks = Objects.requireNonNull(etpersonalhygienedocummentedRemarks.getText()).toString().trim();
        medicalScreeningremarks = Objects.requireNonNull(etmedicalScreeningRemarks.getText()).toString().trim();
        validMedicalCertremarks = Objects.requireNonNull(etValidmedicalcertificateRemarks.getText()).toString().trim();
        adequateAndCleanProtremarks = Objects.requireNonNull(etadequateandcleanpersonalprotRemarks.getText()).toString().trim();
        validCertificateOfRegremarks = Objects.requireNonNull(etValidCertOfregRemarks.getText()).toString().trim();
        incidentsAccidentsReportsremarks = Objects.requireNonNull(etIncidentandAccidentReportsRemarks.getText()).toString().trim();
        fireEquipmentInspectionremarks = Objects.requireNonNull(etFireEquipmentInspectionRemarks.getText()).toString().trim();
        markedZonesremarks = Objects.requireNonNull(etMarkedZonesRemarks.getText()).toString().trim();
        complianceLabourRulesremarks = Objects.requireNonNull(etLabourRulesRemarks.getText()).toString().trim();
        complianceToOHSActremarks = Objects.requireNonNull(etCoplianceToOHSRemarks.getText()).toString().trim();
        correctionOfPrevInspectionremarks = Objects.requireNonNull(etCorrectionOfPrevInspecRemarks.getText()).toString().trim();

        TeaBuyerImporterExporterBus teaBuyerImporterExporterBus = TeaBuyerImporterExporterBus.getInstance();
        TeaBuyerImporterExporter teaBuyerImporterExporter = new TeaBuyerImporterExporter(
                0,
                teaBuyerImporterExporterBus.getDocumentNumber(),
                teaBuyerImporterExporterBus.getDocumentDate(),
                teaBuyerImporterExporterBus.getApplicantName(),
                teaBuyerImporterExporterBus.getLicenseNumber(),
                teaBuyerImporterExporterBus.getLocalID(),
                teaBuyerImporterExporterBus.getIsValidTbk(),
                teaBuyerImporterExporterBus.getValidTbkMarks(),
                teaBuyerImporterExporterBus.getValidTbkRemarks(),
                teaBuyerImporterExporterBus.getIsBusinessPermit(),
                teaBuyerImporterExporterBus.getBusinessPermitMarks(),
                teaBuyerImporterExporterBus.getBusinessPermitRemarks(),
                teaBuyerImporterExporterBus.getIsHealthCertificate(),
                teaBuyerImporterExporterBus.getHealthCertificateMarks(),
                teaBuyerImporterExporterBus.getHealthCertificateRemarks(),
                teaBuyerImporterExporterBus.getIsSubmissionOfMonthlyReturns(),
                teaBuyerImporterExporterBus.getSubmissionOfMonthlyReturnsMarks(),
                teaBuyerImporterExporterBus.getSubmissionOfMonthlyReturnsRemarks(),
                teaBuyerImporterExporterBus.getIsRegistrationOfExportsDone(),
                teaBuyerImporterExporterBus.getRegistrationOfExportsDoneMarks(),
                teaBuyerImporterExporterBus.getRegistrationOfExportsDoneRemarks(),
                teaBuyerImporterExporterBus.getIsRegistrationOfImportsDone(),
                teaBuyerImporterExporterBus.getRegistrationOfImportsDoneMarks(),
                teaBuyerImporterExporterBus.getRegistrationOfImportsDoneRemarks(),
                teaBuyerImporterExporterBus.getIsImportsAccompaniedByCoc(),
                teaBuyerImporterExporterBus.getImportsAccompaniedByCocMarks(),
                teaBuyerImporterExporterBus.getImportsAccompaniedByCocRemarks(),
                teaBuyerImporterExporterBus.getIsReexportOfImportedTea(),
                teaBuyerImporterExporterBus.getReexportOfImportedTeaMarks(),
                teaBuyerImporterExporterBus.getReexportOfImportedTeaRemarks(),
                teaBuyerImporterExporterBus.getIsReexportOrDestruction(),
                teaBuyerImporterExporterBus.getReexportOrDestructionMarks(),
                teaBuyerImporterExporterBus.getReexportOrDestructionRemarks(),
                teaBuyerImporterExporterBus.getIsExternalSiteStandards(),
                teaBuyerImporterExporterBus.getExternalSiteStandardsMarks(),
                teaBuyerImporterExporterBus.getExternalSiteStandardsRemarks(),
                teaBuyerImporterExporterBus.getIsSecurityAccessControl(),
                teaBuyerImporterExporterBus.getSecurityAccessControlMarks(),
                teaBuyerImporterExporterBus.getSecurityAccessControlRemarks(),
                teaBuyerImporterExporterBus.getIsLayoutProductFlow(),
                teaBuyerImporterExporterBus.getLayoutProductFlowMarks(),
                teaBuyerImporterExporterBus.getLayoutProductFlowRemarks(),
                teaBuyerImporterExporterBus.getIsWalls(),
                teaBuyerImporterExporterBus.getWallsMarks(),
                teaBuyerImporterExporterBus.getWallsRemarks(),
                teaBuyerImporterExporterBus.getIsFloors(),
                teaBuyerImporterExporterBus.getFloorsMarks(),
                teaBuyerImporterExporterBus.getFloorsRemarks(),
                teaBuyerImporterExporterBus.getIsRoofCeilingAndOverhead(),
                teaBuyerImporterExporterBus.getRoofCeilingAndOverheadMarks(),
                teaBuyerImporterExporterBus.getRoofCeilingAndOverheadRemarks(),
                teaBuyerImporterExporterBus.getIsWindows(),
                teaBuyerImporterExporterBus.getWindowsMarks(),
                teaBuyerImporterExporterBus.getWindowsRemarks(),
                teaBuyerImporterExporterBus.getIsDoors(),
                teaBuyerImporterExporterBus.getDoorsMarks(),
                teaBuyerImporterExporterBus.getDoorsRemarks(),
                teaBuyerImporterExporterBus.getIsAdequateLighting(),
                teaBuyerImporterExporterBus.getAdequateLightingMarks(),
                teaBuyerImporterExporterBus.getAdequateLightingRemarks(),
                teaBuyerImporterExporterBus.getIsVentilation(),
                teaBuyerImporterExporterBus.getVentilationMarks(),
                teaBuyerImporterExporterBus.getVentilationRemarks(),
                teaBuyerImporterExporterBus.getIsEquipmentCleanliness(),
                teaBuyerImporterExporterBus.getEquipmentCleanlinessMarks(),
                teaBuyerImporterExporterBus.getEquipmentCleanlinessRemarks(),
                teaBuyerImporterExporterBus.getIsChangingRoomsAndToilets(),
                teaBuyerImporterExporterBus.getChangingRoomsAndToiletsMarks(),
                teaBuyerImporterExporterBus.getChangingRoomsAndToiletsRemarks(),
                teaBuyerImporterExporterBus.getIsRiskOfContaminants(),
                teaBuyerImporterExporterBus.getRiskOfContaminantsMarks(),
                teaBuyerImporterExporterBus.getRiskOfContaminantsRemarks(),
                teaBuyerImporterExporterBus.getIsWasteTeasDisposal(),
                teaBuyerImporterExporterBus.getWasteTeasDisposalMarks(),
                teaBuyerImporterExporterBus.getWasteTeasDisposalRemarks(),
                teaBuyerImporterExporterBus.getIsPestControlPrograms(),
                teaBuyerImporterExporterBus.getPestControlProgramsMarks(),
                teaBuyerImporterExporterBus.getPestControlProgramsRemarks(),
                teaBuyerImporterExporterBus.getIsProperStorage(),
                teaBuyerImporterExporterBus.getProperStorageMarks(),
                teaBuyerImporterExporterBus.getProperStorageRemarks(),
                teaBuyerImporterExporterBus.getIsPackagingMaterial(),
                teaBuyerImporterExporterBus.getPackagingMaterialMarks(),
                teaBuyerImporterExporterBus.getPackagingMaterialRemarks(),
                teaBuyerImporterExporterBus.getIsNonConformingProduct(),
                teaBuyerImporterExporterBus.getNonConformingProductMarks(),
                teaBuyerImporterExporterBus.getNonConformingProductRemarks(),
                teaBuyerImporterExporterBus.getIsPalletsAreHeatTreated(),
                teaBuyerImporterExporterBus.getPalletsAreHeatTreatedMarks(),
                teaBuyerImporterExporterBus.getPalletsAreHeatTreatedRemarks(),
                teaBuyerImporterExporterBus.getIsTeaDispatchRecordsMaintained(),
                teaBuyerImporterExporterBus.getTeaDispatchRecordsMaintainedMarks(),
                teaBuyerImporterExporterBus.getTeaDispatchRecordsMaintainedRemarks(),
                teaBuyerImporterExporterBus.getIsEquipmentIdentification(),
                teaBuyerImporterExporterBus.getEquipmentIdentificationMarks(),
                teaBuyerImporterExporterBus.getEquipmentIdentificationRemarks(),
                teaBuyerImporterExporterBus.getIsTraceabilitySystem(),
                teaBuyerImporterExporterBus.getTraceabilitySystemMarks(),
                teaBuyerImporterExporterBus.getTraceabilitySystemRemarks(),
                teaBuyerImporterExporterBus.getIsFoodSafetyHazardsIdentified(),
                teaBuyerImporterExporterBus.getFoodSafetyHazardsIdentifiedMarks(),
                teaBuyerImporterExporterBus.getFoodSafetyHazardsIdentifiedRemarks(),
                teaBuyerImporterExporterBus.getIsCustomerFeedbackRecords(),
                teaBuyerImporterExporterBus.getCustomerFeedbackRecordsMarks(),
                teaBuyerImporterExporterBus.getCustomerFeedbackRecordsRemarks(),
                teaBuyerImporterExporterBus.getIsProcessDocumentsAndRecords(),
                teaBuyerImporterExporterBus.getProcessDocumentsAndRecordsMarks(),
                teaBuyerImporterExporterBus.getProcessDocumentsAndRecordsRemarks(),
                personalHygieneDocumented,
                personalHygieneDocumentedmarks,
                personalHygieneDocumentedremarks,
                medicalScreening,
                medicalScreeningmarks,
                medicalScreeningremarks,
                validMedicalCert,
                validMedicalCertmarks,
                validMedicalCertremarks,
                adequateAndCleanProt,
                adequateAndCleanProtmarks,
                adequateAndCleanProtremarks,
                validCertificateOfReg,
                validCertificateOfRegmarks,
                validCertificateOfRegremarks,
                incidentsAccidentsReports,
                incidentsAccidentsReportsmarks,
                incidentsAccidentsReportsremarks,
                fireEquipmentInspection,
                fireEquipmentInspectionmarks,
                fireEquipmentInspectionremarks,
                markedZones,
                markedZonesmarks,
                markedZonesremarks,
                complianceLabourRules,
                complianceLabourRulesmarks,
                complianceLabourRulesremarks,
                complianceToOHSAct,
                complianceToOHSActmarks,
                complianceToOHSActremarks,
                correctionOfPrevInspection,
                correctionOfPrevInspectionmarks,
                correctionOfPrevInspectionremarks,
                false,
                ""
        );

        // teaPackerViewModel.addRecord(teaPacker);
//          db.updateTeaBuyerImporterExporter(teaBuyerImporterExporter);

          long updateTeaBuyerImporterExporterID = db.updateTeaBuyerImporterExporter(teaBuyerImporterExporter);
          System.out.println("updateTeaBuyerImporterExporterID " + updateTeaBuyerImporterExporterID);
            Intent intent = new Intent(getActivity(), DashboardActivity.class);
            Objects.requireNonNull(getActivity()).finish();
            startActivity(intent);


//      //
//        Intent intent = new Intent(getActivity(), DashboardActivity.class);
//        Objects.requireNonNull(getActivity()).finish();
//        startActivity(intent);

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
