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
import co.ke.bsl.data.view.View10Marks;
import co.ke.bsl.data.view.View2Marks;
import co.ke.bsl.data.view.View3Marks;
import co.ke.bsl.data.view.View5Marks;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeaBuyerImporterExporterStep2 extends Fragment implements BlockingStep {

    @BindView(R.id.isvalidtbk)
    CheckBox isvalidtbk;
    @BindView(R.id.ssvalidtbk5mks)
    SearchableSpinner ssvalidtbk5mks;
    @BindView(R.id.etvalidtbkRemarks)
    CustomEditText etvalidtbkRemarks;
    @BindView(R.id.isBusinespermit)
    CheckBox isBusinespermit;
    @BindView(R.id.ssbusinesspermit2mks)
    SearchableSpinner ssbusinesspermit2mks;
    @BindView(R.id.etBusinesspermitremarks)
    CustomEditText etBusinesspermitremarks;
    @BindView(R.id.isHealthcertificate)
    CheckBox isHealthcertificate;
    @BindView(R.id.sshealthcertificate5mks)
    SearchableSpinner sshealthcertificate5mks;
    @BindView(R.id.ethealthcertificateremarks)
    CustomEditText ethealthcertificateremarks;
    @BindView(R.id.isSubmissionOfMonthlyreturns)
    CheckBox isSubmissionOfMonthlyreturns;
    @BindView(R.id.ssSubmissionOfMonthlyreturns5mks)
    SearchableSpinner ssSubmissionOfMonthlyreturns5mks;
    @BindView(R.id.etSubmissionOfMonthlyreturnsRemarks)
    CustomEditText etSubmissionOfMonthlyreturnsRemarks;
    @BindView(R.id.isRegistrationOfExport)
    CheckBox isRegistrationOfExport;
    @BindView(R.id.ssRegistrationOfExport5mks)
    SearchableSpinner ssRegistrationOfExport5mks;
    @BindView(R.id.etRegistrationOfExportRemarks)
    CustomEditText etRegistrationOfExportRemarks;
    @BindView(R.id.isRegistrationOfImports)
    CheckBox isRegistrationOfImports;
    @BindView(R.id.ssRegistrationOfImports5mks)
    SearchableSpinner ssRegistrationOfImports5mks;
    @BindView(R.id.etRegistrationOfImportsRemarks)
    CustomEditText etRegistrationOfImportsRemarks;
    @BindView(R.id.isImportsAccmpaniedByCOC)
    CheckBox isImportsAccmpaniedByCOC;
    @BindView(R.id.ssImportsAccmpaniedByCOC5mks)
    SearchableSpinner ssImportsAccmpaniedByCOC5mks;
    @BindView(R.id.etImportsAccmpaniedByCOCRemarks)
    CustomEditText etImportsAccmpaniedByCOCRemarks;
    @BindView(R.id.isReexportOfImportedTeas)
    CheckBox isReexportOfImportedTeas;
    @BindView(R.id.ssReexportOfImportedTeas2mks)
    SearchableSpinner ssReexportOfImportedTeas2mks;
    @BindView(R.id.etReexportOfImportedTeasRemarks)
    CustomEditText etReexportOfImportedTeasRemarks;
    @BindView(R.id.isReexportOfDestruction)
    CheckBox isReexportOfDestruction;
    @BindView(R.id.ssReexportOfDestruction2mks)
    SearchableSpinner ssReexportOfDestruction2mks;
    @BindView(R.id.etReexportOfDestructionRemarks)
    CustomEditText etReexportOfDestructionRemarks;

    private ArrayList<String> marksOf2List = new ArrayList<>();
    private ArrayList<String> marksOf5List = new ArrayList<>();

    private String validtbk, businesspermit, healthcertificate, submissionOfMonthlyReturns, registrationOfExport, registrationOfImports, importsAccampaniedByCoc, re_exportOfImportedTeas, re_exportOfDestructions;
    private String validtbkmarks, businesspermitmarks, healthcertificatemarks, submissionOfMonthlyReturnsmarks, registrationOfExportmarks, registrationOfImportsmarks, importsAccampaniedByCocmarks, re_exportOfImportedTeasmarks, re_exportOfDestructionsmarks;
    private String validtbkremarks, businesspermitremarks, healthcertificateremarks, submissionOfMonthlyReturnsremarks, registrationOfExportremarks, registrationOfImportsremarks, importsAccampaniedByCocremarks, re_exportOfImportedTeasremarks, re_exportOfDestructionsremarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tea_buyer_importer_exporter_step2, container, false);
        ButterKnife.bind(this, view);

        setList5Marks(getDummy5Marks());
        setList2Marks(getDummy2Marks());

        isvalidtbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isvalidtbk.isChecked()) {
                    validtbk = "Y";
                } else {
                    validtbk = "N";
                }
            }
        });

        isBusinespermit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBusinespermit.isChecked()) {
                    businesspermit = "Y";
                } else {
                    businesspermit = "N";
                }
            }
        });

        isHealthcertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHealthcertificate.isChecked()) {
                    healthcertificate = "Y";
                } else {
                    healthcertificate = "N";
                }
            }
        });

        isSubmissionOfMonthlyreturns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSubmissionOfMonthlyreturns.isChecked()) {
                    submissionOfMonthlyReturns = "Y";
                } else {
                    submissionOfMonthlyReturns = "N";
                }
            }
        });

        isRegistrationOfExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRegistrationOfExport.isChecked()) {
                    registrationOfExport = "Y";
                } else {
                    registrationOfExport = "N";
                }
            }
        });

        isRegistrationOfImports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRegistrationOfImports.isChecked()) {
                    registrationOfImports = "Y";
                } else {
                    registrationOfImports = "N";
                }
            }
        });

        isImportsAccmpaniedByCOC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isImportsAccmpaniedByCOC.isChecked()) {
                    importsAccampaniedByCoc = "Y";
                } else {
                    importsAccampaniedByCoc = "N";
                }
            }
        });

        isReexportOfImportedTeas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isReexportOfImportedTeas.isChecked()) {
                    re_exportOfImportedTeas = "Y";
                } else {
                    re_exportOfImportedTeas = "N";
                }
            }
        });

        isReexportOfDestruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isReexportOfDestruction.isChecked()) {
                    re_exportOfDestructions = "Y";
                } else {
                    re_exportOfDestructions = "N";
                }
            }
        });

        ssvalidtbk5mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                validtbkmarks = ssvalidtbk5mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssbusinesspermit2mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                businesspermitmarks = ssbusinesspermit2mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sshealthcertificate5mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                healthcertificatemarks = sshealthcertificate5mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssSubmissionOfMonthlyreturns5mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                submissionOfMonthlyReturnsmarks = ssSubmissionOfMonthlyreturns5mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssRegistrationOfExport5mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                registrationOfExportmarks = ssRegistrationOfExport5mks.getSelectedItem().toString();
            }
        });

        ssRegistrationOfImports5mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                registrationOfImportsmarks = ssRegistrationOfImports5mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssImportsAccmpaniedByCOC5mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                importsAccampaniedByCocmarks = ssImportsAccmpaniedByCOC5mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssReexportOfImportedTeas2mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                re_exportOfImportedTeasmarks = ssReexportOfImportedTeas2mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssReexportOfDestruction2mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                re_exportOfDestructionsmarks = ssReexportOfDestruction2mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }

    private void setList5Marks(List<View5Marks> dummy5Marks) {

        marksOf5List.add("- Required -");
        for (View5Marks regionWrapper : dummy5Marks) {
            marksOf5List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf5List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssvalidtbk5mks.setAdapter(regionAdapter);
        sshealthcertificate5mks.setAdapter(regionAdapter);
        ssImportsAccmpaniedByCOC5mks.setAdapter(regionAdapter);
        ssRegistrationOfExport5mks.setAdapter(regionAdapter);
        ssRegistrationOfImports5mks.setAdapter(regionAdapter);
        ssSubmissionOfMonthlyreturns5mks.setAdapter(regionAdapter);
    }

    private void setList2Marks(List<View2Marks> dummy2Marks) {

        marksOf2List.add("- Required -");
        for (View2Marks regionWrapper : dummy2Marks) {
            marksOf2List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf2List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssbusinesspermit2mks.setAdapter(regionAdapter);
        ssReexportOfImportedTeas2mks.setAdapter(regionAdapter);
        ssReexportOfDestruction2mks.setAdapter(regionAdapter);
    }

    private List<View5Marks> getDummy5Marks() {
        List<View5Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View5Marks("0"));
        listViewItems.add(new View5Marks("5"));
        return listViewItems;
    }

    private List<View2Marks> getDummy2Marks() {
        List<View2Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View2Marks("0"));
        listViewItems.add(new View2Marks("2"));
        return listViewItems;
    }



    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        validtbkremarks = Objects.requireNonNull(etvalidtbkRemarks.getText()).toString().trim();
        businesspermitremarks = Objects.requireNonNull(etBusinesspermitremarks.getText()).toString().trim();
        healthcertificateremarks = Objects.requireNonNull(ethealthcertificateremarks.getText()).toString().trim();
        submissionOfMonthlyReturnsremarks = Objects.requireNonNull(etSubmissionOfMonthlyreturnsRemarks.getText()).toString().trim();
        registrationOfExportremarks = Objects.requireNonNull(etRegistrationOfExportRemarks.getText()).toString().trim();
        registrationOfImportsremarks = Objects.requireNonNull(etRegistrationOfImportsRemarks.getText()).toString().trim();
        importsAccampaniedByCocremarks = Objects.requireNonNull(etImportsAccmpaniedByCOCRemarks.getText()).toString().trim();
        re_exportOfImportedTeasremarks = Objects.requireNonNull(etReexportOfImportedTeasRemarks.getText()).toString().trim();
        re_exportOfDestructionsremarks = Objects.requireNonNull(etReexportOfDestructionRemarks.getText()).toString().trim();


        TeaBuyerImporterExporterBus teaBuyerImporterExporterBus = TeaBuyerImporterExporterBus.getInstance();

        teaBuyerImporterExporterBus.setIsValidTbk(validtbk);
        teaBuyerImporterExporterBus.setValidTbkMarks(validtbkmarks);
        teaBuyerImporterExporterBus.setValidTbkRemarks(validtbkremarks);
        teaBuyerImporterExporterBus.setIsBusinessPermit(businesspermit);
        teaBuyerImporterExporterBus.setBusinessPermitMarks(businesspermitmarks);
        teaBuyerImporterExporterBus.setBusinessPermitRemarks(businesspermitremarks);
        teaBuyerImporterExporterBus.setIsHealthCertificate(healthcertificate);
        teaBuyerImporterExporterBus.setHealthCertificateMarks(healthcertificatemarks);
        teaBuyerImporterExporterBus.setHealthCertificateRemarks(healthcertificateremarks);
        teaBuyerImporterExporterBus.setIsSubmissionOfMonthlyReturns(submissionOfMonthlyReturns);
        teaBuyerImporterExporterBus.setSubmissionOfMonthlyReturnsMarks(submissionOfMonthlyReturnsmarks);
        teaBuyerImporterExporterBus.setSubmissionOfMonthlyReturnsRemarks(submissionOfMonthlyReturnsremarks);
        teaBuyerImporterExporterBus.setIsRegistrationOfExportsDone(registrationOfExport);
        teaBuyerImporterExporterBus.setRegistrationOfExportsDoneMarks(registrationOfExportmarks);
        teaBuyerImporterExporterBus.setRegistrationOfExportsDoneRemarks(registrationOfExportremarks);
        teaBuyerImporterExporterBus.setIsRegistrationOfImportsDone(registrationOfImports);
        teaBuyerImporterExporterBus.setRegistrationOfImportsDoneMarks(registrationOfImportsmarks);
        teaBuyerImporterExporterBus.setRegistrationOfImportsDoneRemarks(registrationOfImportsremarks);
        teaBuyerImporterExporterBus.setIsImportsAccompaniedByCoc(importsAccampaniedByCoc);
        teaBuyerImporterExporterBus.setImportsAccompaniedByCocMarks(importsAccampaniedByCocmarks);
        teaBuyerImporterExporterBus.setImportsAccompaniedByCocRemarks(importsAccampaniedByCocremarks);
        teaBuyerImporterExporterBus.setIsReexportOfImportedTea(re_exportOfImportedTeas);
        teaBuyerImporterExporterBus.setReexportOfImportedTeaMarks(re_exportOfImportedTeasmarks);
        teaBuyerImporterExporterBus.setReexportOfImportedTeaRemarks(re_exportOfImportedTeasremarks);
        teaBuyerImporterExporterBus.setIsReexportOrDestruction(re_exportOfDestructions);
        teaBuyerImporterExporterBus.setReexportOrDestructionMarks(re_exportOfDestructionsmarks);
        teaBuyerImporterExporterBus.setReexportOrDestructionRemarks(re_exportOfDestructionsremarks);

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
