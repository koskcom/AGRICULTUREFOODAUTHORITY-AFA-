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
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

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
import co.ke.bsl.data.view.FruitsVegetablesExportersDeskVettingBus;
import co.ke.bsl.data.view.View10Marks;
import co.ke.bsl.data.view.View15Marks;
import co.ke.bsl.data.view.View5Marks;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FruitsVegetablesExportersDeskVettingChecklistStep2 extends Fragment implements BlockingStep {

    @BindView(R.id.isCertificationToKsh1758)
    CheckBox isCertificationToKsh1758;
    @BindView(R.id.etCertificationToKsh1758Award)
    SearchableSpinner etCertificationToKsh1758Award;
    @BindView(R.id.etCertificationToKsh1758Timeline)
    CustomEditText etCertificationToKsh1758Timeline;
    @BindView(R.id.etCertificationToKsh1758Remarks)
    CustomEditText etCertificationToKsh1758Remarks;

    @BindView(R.id.isOtherRecognizedStandards)
    CheckBox isOtherRecognizedStandards;
    @BindView(R.id.etOtherRecognizedStandardsAward)
    SearchableSpinner etOtherRecognizedStandardsAward;
    @BindView(R.id.etOtherRecognizedStandardsTimeline)
    CustomEditText etOtherRecognizedStandardsTimeline;
    @BindView(R.id.etOtherRecognizedStandardsRemarks)
    CustomEditText etOtherRecognizedStandardsRemarks;

    @BindView(R.id.isEvidenceOfRegonNaionalTraceability)
    CheckBox isEvidenceOfRegonNaionalTraceability;
    @BindView(R.id.etEvidenceOfRegonNaionalTraceabilityAward)
    SearchableSpinner etEvidenceOfRegonNaionalTraceabilityAward;
    @BindView(R.id.etEvidenceOfRegonNaionalTraceabilityTimeline)
    CustomEditText etEvidenceOfRegonNaionalTraceabilityTimeline;
    @BindView(R.id.etEvidenceOfRegonNaionalTraceabilityRemarks)
    CustomEditText etEvidenceOfRegonNaionalTraceabilityRemarks;

    @BindView(R.id.isEvidenceOfRegSingleWindow)
    CheckBox isEvidenceOfRegSingleWindow;
    @BindView(R.id.etEvidenceOfRegSingleWindowAward)
    SearchableSpinner etEvidenceOfRegSingleWindowAward;
    @BindView(R.id.etEvidenceOfRegSingleWindowTimeline)
    CustomEditText etEvidenceOfRegSingleWindowTimeline;
    @BindView(R.id.etEvidenceOfRegSingleWindowRemarks)
    CustomEditText etEvidenceOfRegSingleWindowRemarks;

    @BindView(R.id.isCopyOfHcdExportLicence)
    CheckBox isCopyOfHcdExportLicence;
    @BindView(R.id.etCopyOfHcdExportLicenceAward)
    SearchableSpinner etCopyOfHcdExportLicenceAward;
    @BindView(R.id.etCopyOfHcdExportLicenceTimeline)
    CustomEditText etCopyOfHcdExportLicenceTimeline;
    @BindView(R.id.etCopyOfHcdExportLicenceRemarks)
    CustomEditText etCopyOfHcdExportLicenceRemarks;

    @BindView(R.id.isTraceablityListOfTheCompany)
    CheckBox isTraceablityListOfTheCompany;
    @BindView(R.id.etTraceablityListOfTheCompanyAward)
    SearchableSpinner etTraceablityListOfTheCompanyAward;
    @BindView(R.id.etTraceablityListOfTheCompanyTimeline)
    CustomEditText etTraceablityListOfTheCompanyTimeline;
    @BindView(R.id.etTraceablityListOfTheCompanyRemarks)
    CustomEditText etTraceablityListOfTheCompanyRemarks;

    @BindView(R.id.isDeclareMArketingAgents)
    CheckBox isDeclareMArketingAgents;
    @BindView(R.id.etDeclareMArketingAgentsAward)
    SearchableSpinner etDeclareMArketingAgentsAward;
    @BindView(R.id.etDeclareMArketingAgentsTimeline)
    CustomEditText etDeclareMArketingAgentsTimeline;
    @BindView(R.id.etDeclareMArketingAgentsRemarks)
    CustomEditText etDeclareMArketingAgentsRemarks;

    @BindView(R.id.isEvidenceOfHcdRegistered)
    CheckBox isEvidenceOfHcdRegistered;
    @BindView(R.id.etEvidenceOfHcdRegisteredAward)
    SearchableSpinner etEvidenceOfHcdRegisteredAward;
    @BindView(R.id.etEvidenceOfHcdRegisteredTimeline)
    CustomEditText etEvidenceOfHcdRegisteredTimeline;
    @BindView(R.id.etEvidenceOfHcdRegisteredRemarks)
    CustomEditText etEvidenceOfHcdRegisteredRemarks;

    @BindView(R.id.isSystemPoliceAndProcedure)
    CheckBox isSystemPoliceAndProcedure;
    @BindView(R.id.etSystemPoliceAndProcedureAward)
    SearchableSpinner etSystemPoliceAndProcedureAward;
    @BindView(R.id.etSystemPoliceAndProcedureTimeline)
    CustomEditText etSystemPoliceAndProcedureTimeline;
    @BindView(R.id.etSystemPoliceAndProcedureRemarks)
    CustomEditText etSystemPoliceAndProcedureRemarks;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private String isCertificationtoKsh1758, certificationtoKsh1758Award, certificationtoKsh1758Timeline, certificationtoKsh1758Remarks, isOtherRecognizedstandards, otherRecognizedstandardsAward, otherRecognizedstandardsTimeline, otherRecognizedstandardsremarks;
    private String isEvidenceofRegonNaionalTraceability, evidenceofRegonNaionalTraceabilityAward, evidenceofRegonNaionalTraceabilityTimeline, evidenceofRegonNaionalTraceabilityRemarks, isEvidenceofRegSingleWindow, evidenceofRegSingleWindowAward, evidenceofRegSingleWindowTimeline, evidenceofRegSingleWindowRemarks;
    private String isCopyOfHcdexportLicence, copyOfHcdexportLicenceAward, copyOfHcdexportLicenceTimeine, copyOfHcdexportLicenceRemarks;
    private String isTraceablitylistOfTheCompany, traceablitylistOfTheCompanyAward, traceablitylistOfTheCompanyTimeline, traceablitylistOfTheCompanyReamrks;
    private String isDeclareMarketingAgents, declareMarketingAgentsAward, declareMarketingAgentsTimeline, declareMarketingAgentsRemarks;
    private String isEvidenceOfhcdRegistered, evidenceOfhcdRegisteredAward, evidenceOfhcdRegisteredTimeline, evidenceOfhcdRegisteredRemarks;

    private String isSystempoliceAndProcedure, systemPoliceAndProcedureAward, systemPoliceAndProcedureTimeline, systemPoliceAndProcedureRemarks;

    private ArrayList<String> marksof10List = new ArrayList<>();
    private ArrayList<String> marksof5List = new ArrayList<>();
    private ArrayList<String> marksof15List = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fruits_vegetables_exporters_desk_vetting_checklist_step2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        setList15marks(getdummy15marks());
        setList10marks(getdummy10marks());
        setList5marks(getdummy5marks());

        isCertificationToKsh1758.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCertificationToKsh1758.isChecked()) {
                    isCertificationtoKsh1758 = "Y";
                } else {
                    isCertificationtoKsh1758 = "N";
                }

            }
        });

        isOtherRecognizedStandards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOtherRecognizedStandards.isChecked()) {
                    isOtherRecognizedstandards = "Y";
                } else {
                    isOtherRecognizedstandards = "N";
                }

            }
        });
        isEvidenceOfRegonNaionalTraceability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEvidenceOfRegonNaionalTraceability.isChecked()) {
                    isEvidenceofRegonNaionalTraceability = "Y";
                } else {
                    isEvidenceofRegonNaionalTraceability = "N";
                }

            }
        });

        isEvidenceOfRegSingleWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEvidenceOfRegSingleWindow.isChecked()) {
                    isEvidenceofRegSingleWindow = "Y";
                } else {
                    isEvidenceofRegSingleWindow = "N";
                }

            }
        });
        isCopyOfHcdExportLicence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCopyOfHcdExportLicence.isChecked()) {
                    isCopyOfHcdexportLicence = "Y";
                } else {
                    isCopyOfHcdexportLicence = "N";
                }

            }
        });

        isTraceablityListOfTheCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTraceablityListOfTheCompany.isChecked()) {
                    isTraceablitylistOfTheCompany = "Y";
                } else {
                    isTraceablitylistOfTheCompany = "N";
                }

            }
        });
        isDeclareMArketingAgents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDeclareMArketingAgents.isChecked()) {
                    isDeclareMarketingAgents = "Y";
                } else {
                    isDeclareMarketingAgents = "N";
                }

            }
        });
        isEvidenceOfHcdRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEvidenceOfHcdRegistered.isChecked()) {
                    isEvidenceOfhcdRegistered = "Y";
                } else {
                    isEvidenceOfhcdRegistered = "N";
                }

            }
        });
        isSystemPoliceAndProcedure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSystemPoliceAndProcedure.isChecked()) {
                    isSystempoliceAndProcedure = "Y";
                } else {
                    isSystempoliceAndProcedure = "N";
                }

            }
        });
        return view;

    }

    private void setList15marks(List<View15Marks> getdummy15marks) {
        marksof15List.add("- Required -");
        for (View15Marks regionWrapper : getdummy15marks) {
            marksof15List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof15List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        etCertificationToKsh1758Award.setAdapter(regionAdapter);

    }

    private List<View15Marks> getdummy15marks() {
        List<View15Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View15Marks("0"));
        listViewItems.add(new View15Marks("1"));
        listViewItems.add(new View15Marks("2"));
        listViewItems.add(new View15Marks("3"));
        listViewItems.add(new View15Marks("4"));
        listViewItems.add(new View15Marks("5"));
        listViewItems.add(new View15Marks("6"));
        listViewItems.add(new View15Marks("7"));
        listViewItems.add(new View15Marks("8"));
        listViewItems.add(new View15Marks("9"));
        listViewItems.add(new View15Marks("10"));
        listViewItems.add(new View15Marks("11"));
        listViewItems.add(new View15Marks("12"));
        listViewItems.add(new View15Marks("13"));
        listViewItems.add(new View15Marks("14"));
        listViewItems.add(new View15Marks("15"));

        return listViewItems;
    }


    private void setList10marks(List<View10Marks> getdummy10marks) {
        marksof10List.add("- Required -");
        for (View10Marks regionWrapper : getdummy10marks) {
            marksof10List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof10List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        etOtherRecognizedStandardsAward.setAdapter(regionAdapter);

    }

    private List<View10Marks> getdummy10marks() {
        List<View10Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View10Marks("0"));
        listViewItems.add(new View10Marks("1"));
        listViewItems.add(new View10Marks("2"));
        listViewItems.add(new View10Marks("3"));
        listViewItems.add(new View10Marks("4"));
        listViewItems.add(new View10Marks("5"));
        listViewItems.add(new View10Marks("6"));
        listViewItems.add(new View10Marks("7"));
        listViewItems.add(new View10Marks("8"));
        listViewItems.add(new View10Marks("9"));
        listViewItems.add(new View10Marks("10"));
        listViewItems.add(new View10Marks("-10"));

        return listViewItems;
    }

    private void setList5marks(List<View5Marks> getdummy5marks) {
        marksof5List.add("- Required -");
        for (View5Marks regionWrapper : getdummy5marks) {
            marksof5List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof5List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        etEvidenceOfRegonNaionalTraceabilityAward.setAdapter(regionAdapter);
        etEvidenceOfRegSingleWindowAward.setAdapter(regionAdapter);
        etDeclareMArketingAgentsAward.setAdapter(regionAdapter);
        etCopyOfHcdExportLicenceAward.setAdapter(regionAdapter);
        etTraceablityListOfTheCompanyAward.setAdapter(regionAdapter);
        etEvidenceOfHcdRegisteredAward.setAdapter(regionAdapter);
        etSystemPoliceAndProcedureAward.setAdapter(regionAdapter);

    }

    private List<View5Marks> getdummy5marks() {
        List<View5Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View5Marks("0"));
        listViewItems.add(new View5Marks("1"));
        listViewItems.add(new View5Marks("2"));
        listViewItems.add(new View5Marks("3"));
        listViewItems.add(new View5Marks("4"));
        listViewItems.add(new View5Marks("5"));


        return listViewItems;
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        certificationtoKsh1758Award = Objects.requireNonNull(etCertificationToKsh1758Award.getSelectedItem()).toString().trim();
        certificationtoKsh1758Timeline = Objects.requireNonNull(etCertificationToKsh1758Timeline.getText()).toString().trim();
        certificationtoKsh1758Remarks = Objects.requireNonNull(etCertificationToKsh1758Remarks.getText()).toString().trim();
        otherRecognizedstandardsAward = Objects.requireNonNull(etOtherRecognizedStandardsAward.getSelectedItem()).toString().trim();
        otherRecognizedstandardsTimeline = Objects.requireNonNull(etOtherRecognizedStandardsTimeline.getText()).toString().trim();
        otherRecognizedstandardsremarks = Objects.requireNonNull(etOtherRecognizedStandardsRemarks.getText()).toString().trim();
        evidenceofRegonNaionalTraceabilityAward = Objects.requireNonNull(etEvidenceOfRegonNaionalTraceabilityAward.getSelectedItem()).toString().trim();
        evidenceofRegonNaionalTraceabilityTimeline = Objects.requireNonNull(etEvidenceOfRegonNaionalTraceabilityTimeline.getText()).toString().trim();
        evidenceofRegonNaionalTraceabilityRemarks = Objects.requireNonNull(etEvidenceOfRegonNaionalTraceabilityRemarks.getText()).toString().trim();
        evidenceofRegSingleWindowAward = Objects.requireNonNull(etEvidenceOfRegSingleWindowAward.getSelectedItem()).toString().trim();
        evidenceofRegSingleWindowTimeline = Objects.requireNonNull(etEvidenceOfRegSingleWindowTimeline.getText()).toString().trim();
        evidenceofRegSingleWindowRemarks = Objects.requireNonNull(etEvidenceOfRegSingleWindowRemarks.getText()).toString().trim();
        copyOfHcdexportLicenceAward = Objects.requireNonNull(etCopyOfHcdExportLicenceAward.getSelectedItem()).toString().trim();
        copyOfHcdexportLicenceTimeine = Objects.requireNonNull(etCopyOfHcdExportLicenceTimeline.getText()).toString().trim();
        copyOfHcdexportLicenceRemarks = Objects.requireNonNull(etCopyOfHcdExportLicenceRemarks.getText()).toString().trim();
        traceablitylistOfTheCompanyAward = Objects.requireNonNull(etTraceablityListOfTheCompanyAward.getSelectedItem()).toString().trim();
        traceablitylistOfTheCompanyTimeline = Objects.requireNonNull(etTraceablityListOfTheCompanyTimeline.getText()).toString().trim();
        traceablitylistOfTheCompanyReamrks = Objects.requireNonNull(etTraceablityListOfTheCompanyRemarks.getText()).toString().trim();
        declareMarketingAgentsAward = Objects.requireNonNull(etDeclareMArketingAgentsAward.getSelectedItem()).toString().trim();
        declareMarketingAgentsTimeline = Objects.requireNonNull(etDeclareMArketingAgentsTimeline.getText()).toString().trim();
        declareMarketingAgentsRemarks = Objects.requireNonNull(etDeclareMArketingAgentsRemarks.getText()).toString().trim();
        evidenceOfhcdRegisteredAward = Objects.requireNonNull(etEvidenceOfHcdRegisteredAward.getSelectedItem()).toString().trim();
        evidenceOfhcdRegisteredTimeline = Objects.requireNonNull(etEvidenceOfHcdRegisteredTimeline.getText()).toString().trim();
        evidenceOfhcdRegisteredRemarks = Objects.requireNonNull(etEvidenceOfHcdRegisteredRemarks.getText()).toString().trim();
        systemPoliceAndProcedureAward = Objects.requireNonNull(etSystemPoliceAndProcedureAward.getSelectedItem()).toString().trim();
        systemPoliceAndProcedureTimeline = Objects.requireNonNull(etSystemPoliceAndProcedureTimeline.getText()).toString().trim();
        systemPoliceAndProcedureRemarks = Objects.requireNonNull(etSystemPoliceAndProcedureRemarks.getText()).toString().trim();

        boolean valid = validateFields(isCertificationToKsh1758, etCertificationToKsh1758Timeline, certificationtoKsh1758Timeline, etCertificationToKsh1758Remarks, certificationtoKsh1758Remarks, etCertificationToKsh1758Award, certificationtoKsh1758Award) &
                validateFields(isOtherRecognizedStandards, etOtherRecognizedStandardsTimeline, otherRecognizedstandardsTimeline, etOtherRecognizedStandardsRemarks, otherRecognizedstandardsremarks, etOtherRecognizedStandardsAward, otherRecognizedstandardsAward) &
                validateFields(isEvidenceOfRegonNaionalTraceability, etEvidenceOfRegonNaionalTraceabilityTimeline, evidenceofRegonNaionalTraceabilityTimeline, etEvidenceOfRegonNaionalTraceabilityRemarks, evidenceofRegonNaionalTraceabilityRemarks, etEvidenceOfRegonNaionalTraceabilityAward, evidenceofRegonNaionalTraceabilityAward) &
                validateFields(isEvidenceOfRegSingleWindow, etEvidenceOfRegSingleWindowTimeline, evidenceofRegSingleWindowTimeline, etEvidenceOfRegSingleWindowRemarks, evidenceofRegSingleWindowRemarks, etEvidenceOfRegSingleWindowAward, evidenceofRegSingleWindowAward) &
                validateFields(isCopyOfHcdExportLicence, etCopyOfHcdExportLicenceTimeline, copyOfHcdexportLicenceTimeine, etCopyOfHcdExportLicenceRemarks, copyOfHcdexportLicenceRemarks, etCopyOfHcdExportLicenceAward, copyOfHcdexportLicenceAward) &
                validateFields(isTraceablityListOfTheCompany, etTraceablityListOfTheCompanyTimeline, traceablitylistOfTheCompanyTimeline, etTraceablityListOfTheCompanyRemarks, traceablitylistOfTheCompanyReamrks, etTraceablityListOfTheCompanyAward, traceablitylistOfTheCompanyAward) &
                validateFields(isDeclareMArketingAgents, etDeclareMArketingAgentsTimeline, declareMarketingAgentsTimeline, etDeclareMArketingAgentsRemarks, declareMarketingAgentsRemarks, etDeclareMArketingAgentsAward, declareMarketingAgentsAward) &
                validateFields(isEvidenceOfHcdRegistered, etEvidenceOfHcdRegisteredTimeline, evidenceOfhcdRegisteredTimeline, etEvidenceOfHcdRegisteredRemarks, evidenceOfhcdRegisteredRemarks, etEvidenceOfRegSingleWindowAward, evidenceOfhcdRegisteredAward) &
                validateFields(isSystemPoliceAndProcedure, etSystemPoliceAndProcedureTimeline, systemPoliceAndProcedureTimeline, etSystemPoliceAndProcedureRemarks, systemPoliceAndProcedureRemarks, etSystemPoliceAndProcedureAward, systemPoliceAndProcedureAward);

        FruitsVegetablesExportersDeskVettingBus fruitsVegetablesExportersDeskVettingBus = FruitsVegetablesExportersDeskVettingBus.getInstance();


        fruitsVegetablesExportersDeskVettingBus.setIsCertificationtoKsh1758(isCertificationtoKsh1758);
        fruitsVegetablesExportersDeskVettingBus.setCertificationtoKsh1758Award(certificationtoKsh1758Award);
        fruitsVegetablesExportersDeskVettingBus.setCertificationtoKsh1758Timeline(certificationtoKsh1758Timeline);
        fruitsVegetablesExportersDeskVettingBus.setCertificationtoKsh1758Remarks(certificationtoKsh1758Remarks);

        fruitsVegetablesExportersDeskVettingBus.setIsOtherRecognizedstandards(isOtherRecognizedstandards);
        fruitsVegetablesExportersDeskVettingBus.setOtherRecognizedstandardsAward(otherRecognizedstandardsAward);
        fruitsVegetablesExportersDeskVettingBus.setOtherRecognizedstandardsTimeline(otherRecognizedstandardsTimeline);
        fruitsVegetablesExportersDeskVettingBus.setOtherRecognizedstandardsremarks(otherRecognizedstandardsremarks);

        fruitsVegetablesExportersDeskVettingBus.setIsEvidenceofRegonNaionalTraceability(isEvidenceofRegonNaionalTraceability);
        fruitsVegetablesExportersDeskVettingBus.setEvidenceofRegonNaionalTraceabilityAward(evidenceofRegonNaionalTraceabilityAward);
        fruitsVegetablesExportersDeskVettingBus.setEvidenceofRegonNaionalTraceabilityTimeline(evidenceofRegonNaionalTraceabilityTimeline);
        fruitsVegetablesExportersDeskVettingBus.setEvidenceofRegonNaionalTraceabilityRemarks(evidenceofRegonNaionalTraceabilityRemarks);

        fruitsVegetablesExportersDeskVettingBus.setIsEvidenceofRegSingleWindow(isEvidenceofRegSingleWindow);
        fruitsVegetablesExportersDeskVettingBus.setEvidenceofRegSingleWindowAward(evidenceofRegSingleWindowAward);
        fruitsVegetablesExportersDeskVettingBus.setEvidenceofRegSingleWindowTimeline(evidenceofRegSingleWindowTimeline);
        fruitsVegetablesExportersDeskVettingBus.setEvidenceofRegSingleWindowRemarks(evidenceofRegSingleWindowRemarks);

        fruitsVegetablesExportersDeskVettingBus.setIsCopyOfHcdexportLicence(isCopyOfHcdexportLicence);
        fruitsVegetablesExportersDeskVettingBus.setCopyOfHcdexportLicenceAward(copyOfHcdexportLicenceAward);
        fruitsVegetablesExportersDeskVettingBus.setCopyOfHcdexportLicenceTimeine(copyOfHcdexportLicenceTimeine);
        fruitsVegetablesExportersDeskVettingBus.setCopyOfHcdexportLicenceRemarks(copyOfHcdexportLicenceRemarks);

        fruitsVegetablesExportersDeskVettingBus.setIsTraceablitylistOfTheCompany(isTraceablitylistOfTheCompany);
        fruitsVegetablesExportersDeskVettingBus.setTraceablitylistOfTheCompanyAward(traceablitylistOfTheCompanyAward);
        fruitsVegetablesExportersDeskVettingBus.setTraceablitylistOfTheCompanyTimeline(traceablitylistOfTheCompanyTimeline);
        fruitsVegetablesExportersDeskVettingBus.setTraceablitylistOfTheCompanyReamrks(traceablitylistOfTheCompanyReamrks);

        fruitsVegetablesExportersDeskVettingBus.setIsDeclareMarketingAgents(isDeclareMarketingAgents);
        fruitsVegetablesExportersDeskVettingBus.setDeclareMarketingAgentsAward(declareMarketingAgentsAward);
        fruitsVegetablesExportersDeskVettingBus.setDeclareMarketingAgentsTimeline(declareMarketingAgentsTimeline);
        fruitsVegetablesExportersDeskVettingBus.setDeclareMarketingAgentsRemarks(declareMarketingAgentsRemarks);

        fruitsVegetablesExportersDeskVettingBus.setIsEvidenceOfhcdRegistered(isEvidenceOfhcdRegistered);
        fruitsVegetablesExportersDeskVettingBus.setEvidenceOfhcdRegisteredAward(evidenceOfhcdRegisteredAward);
        fruitsVegetablesExportersDeskVettingBus.setEvidenceOfhcdRegisteredTimeline(evidenceOfhcdRegisteredTimeline);
        fruitsVegetablesExportersDeskVettingBus.setEvidenceOfhcdRegisteredRemarks(evidenceOfhcdRegisteredRemarks);

        fruitsVegetablesExportersDeskVettingBus.setIsSystempoliceAndProcedure(isSystempoliceAndProcedure);
        fruitsVegetablesExportersDeskVettingBus.setSystemPoliceAndProcedureAward(systemPoliceAndProcedureAward);
        fruitsVegetablesExportersDeskVettingBus.setSystemPoliceAndProcedureTimeline(systemPoliceAndProcedureTimeline);
        fruitsVegetablesExportersDeskVettingBus.setSystemPoliceAndProcedureRemarks(systemPoliceAndProcedureRemarks);

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

    private boolean validateFields(CheckBox checkBox, CustomEditText firstCustomEditText, String firstCustomEditTextString, CustomEditText secondCustomEditText, String secondCustomEditTextString, SearchableSpinner searchableSpinner, String searchableSpinnerString){

        boolean resultEditText1 = false;
        boolean resultEditText2 = false;
        boolean resultCheckbox = false;
        boolean resultSpinner = false;

        if(!checkBox.isChecked()){
            if (TextUtils.isEmpty(firstCustomEditTextString)) {
                firstCustomEditText.setError("Field Required ");
                resultEditText1 = false;
            } else {
                resultEditText1 = true;
            }
            if (TextUtils.isEmpty(secondCustomEditTextString)) {
                secondCustomEditText.setError("Field Required ");
                resultEditText2 = false;
            } else {
                resultEditText2 = true;
            }
            resultCheckbox = resultEditText1 && resultEditText2;
        } else{
            firstCustomEditText.setError(null);
            secondCustomEditText.setError(null);
            resultCheckbox = true;
        }

        if ("- Required -".equals(searchableSpinnerString)) {
            TextView errorText = (TextView) searchableSpinner.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            resultSpinner = false;
        } else{
            resultSpinner = true;
        }
        return (resultCheckbox && resultSpinner);
    }

}
