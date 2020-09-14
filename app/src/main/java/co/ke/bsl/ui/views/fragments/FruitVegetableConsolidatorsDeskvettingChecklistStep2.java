package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
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
import co.ke.bsl.R;
import co.ke.bsl.data.view.FruitVegetableConsolidatorsBus;
import co.ke.bsl.data.view.View10Marks;
import co.ke.bsl.data.view.View15Marks;
import co.ke.bsl.data.view.View3Marks;
import co.ke.bsl.data.view.View5Marks;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class FruitVegetableConsolidatorsDeskvettingChecklistStep2 extends Fragment implements BlockingStep {

    @BindView(R.id.isCertificationToKsh1758)
    CheckBox isCertificationToKsh1758;
    @BindView(R.id.ssCertificationToKsh1758Award)
    SearchableSpinner ssCertificationToKsh1758Award;
    @BindView(R.id.etCertificationToKsh1758Timeline)
    CustomEditText etCertificationToKsh1758Timeline;
    @BindView(R.id.etCertificationToKsh1758Remarks)
    CustomEditText etCertificationToKsh1758Remarks;

    @BindView(R.id.isOtherRecognizedStandards)
    CheckBox isOtherRecognizedStandards;
    @BindView(R.id.ssOtherRecognizedStandardsAward)
    SearchableSpinner ssOtherRecognizedStandardsAward;
    @BindView(R.id.etOtherRecognizedStandardsTimeline)
    CustomEditText etOtherRecognizedStandardsTimeline;
    @BindView(R.id.etOtherRecognizedStandardsRemarks)
    CustomEditText etOtherRecognizedStandardsRemarks;

    @BindView(R.id.isEvidenceOfRegonNaionalTraceability)
    CheckBox isEvidenceOfRegonNaionalTraceability;
    @BindView(R.id.ssEvidenceOfRegonNaionalTraceabilityAward)
    SearchableSpinner ssEvidenceOfRegonNaionalTraceabilityAward;
    @BindView(R.id.etEvidenceOfRegonNaionalTraceabilityTimeline)
    CustomEditText etEvidenceOfRegonNaionalTraceabilityTimeline;
    @BindView(R.id.etEvidenceOfRegonNaionalTraceabilityRemarks)
    CustomEditText etEvidenceOfRegonNaionalTraceabilityRemarks;

    @BindView(R.id.isEvidenceOfRegSingleWindow)
    CheckBox isEvidenceOfRegSingleWindow;
    @BindView(R.id.ssEvidenceOfRegSingleWindowAward)
    SearchableSpinner ssEvidenceOfRegSingleWindowAward;
    @BindView(R.id.etEvidenceOfRegSingleWindowTimeline)
    CustomEditText etEvidenceOfRegSingleWindowTimeline;
    @BindView(R.id.etEvidenceOfRegSingleWindowRemarks)
    CustomEditText etEvidenceOfRegSingleWindowRemarks;

    @BindView(R.id.isCopyOfHcdExportLicence)
    CheckBox isCopyOfHcdExportLicence;
    @BindView(R.id.ssCopyOfHcdExportLicenceAward)
    SearchableSpinner ssCopyOfHcdExportLicenceAward;
    @BindView(R.id.etCopyOfHcdExportLicenceTimeline)
    CustomEditText etCopyOfHcdExportLicenceTimeline;
    @BindView(R.id.etCopyOfHcdExportLicenceRemarks)
    CustomEditText etCopyOfHcdExportLicenceRemarks;

    @BindView(R.id.isTraceAbilityListContractedfarmers)
    CheckBox isTraceAbilityListContractedfarmers;
    @BindView(R.id.ssTraceAbilityListContractedfarmersAward)
    SearchableSpinner ssTraceAbilityListContractedfarmersAward;
    @BindView(R.id.etTraceAbilityListContractedfarmersTimeline)
    CustomEditText etTraceAbilityListContractedfarmersTimeline;
    @BindView(R.id.etTraceAbilityListContractedfarmersRemarks)
    CustomEditText etTraceAbilityListContractedfarmersRemarks;

    @BindView(R.id.isDeclareMarketingAgent)
    CheckBox isDeclareMarketingAgent;
    @BindView(R.id.ssDeclareMarketingAgentAward)
    SearchableSpinner ssDeclareMarketingAgentAward;
    @BindView(R.id.etDeclareMarketingAgentTimeline)
    CustomEditText etDeclareMarketingAgentTimeline;
    @BindView(R.id.etDeclareMarketingAgentRemarks)
    CustomEditText etDeclareMarketingAgentRemarks;

    @BindView(R.id.isUtilizationOfHCD)
    CheckBox isUtilizationOfHCD;
    @BindView(R.id.ssUtilizationOfHCDAwardAward)
    SearchableSpinner ssUtilizationOfHCDAwardAward;
    @BindView(R.id.etUtilizationOfHCDTimeline)
    CustomEditText etUtilizationOfHCDTimeline;
    @BindView(R.id.etUtilizationOfHCDRemarks)
    CustomEditText etUtilizationOfHCDRemarks;


    private String isCertificationtoKsh1758, ssCertificationtoKsh1758Award, certificationtoKsh1758Timeline, certificationtoKsh1758Remarks;
    private String isOtherrecognizedStandards, ssOtherrecognizedStandardsAward, otherrecognizedStandardstimeline, otherrecognizedStandardsRemarks;
    private String isEvidenceofRegonNaionalTraceability, ssEvidenceofRegonNaionalTraceabilityAward, evidenceofRegonNaionalTraceabilityTimeline, evidenceofRegonNaionalTraceabilityRemarks;
    private String isEvidenceofRegSingleWindow, ssEvidenceofRegSingleWindowAward, evidenceofRegSingleWindowTimeline, evidenceofRegSingleWindowRemarks;
    private String isCopyofHcdExportLicence, ssCopyofHcdExportLicenceAward, copyofHcdExportLicenceTimeline, copyofHcdExportLicenceRemarks;
    private String isTraceabilityListContractedfarmers, ssTraceabilityListContractedfarmersAward, traceabilityListContractedfarmersTimeline, traceabilityListContractedfarmersRemarks;
    private String isDeclaremarketingAgent, ssDeclaremarketingAgentAward, declaremarketingAgentTimeline, declaremarketingAgentREmarks;
    private String isUtilizationofHCD, ssUtilizationofHCDAward, utilizationofHCDTimeline, utilizationofHCDRemarks;

    private ArrayList<String> marksof10List = new ArrayList<>();
    private ArrayList<String> marksof5List = new ArrayList<>();
    private ArrayList<String> marksof15List = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fruit_vegetable_consolidators_deskvetting_checklist_step2, container, false);
        ButterKnife.bind(this, view);

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
                    isOtherrecognizedStandards = "Y";
                } else {
                    isOtherrecognizedStandards = "N";
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
                    isCopyofHcdExportLicence = "Y";
                } else {
                    isCopyofHcdExportLicence = "N";
                }

            }
        });

        isTraceAbilityListContractedfarmers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTraceAbilityListContractedfarmers.isChecked()) {
                    isTraceabilityListContractedfarmers = "Y";
                } else {
                    isTraceabilityListContractedfarmers = "N";
                }

            }
        });

        isDeclareMarketingAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDeclareMarketingAgent.isChecked()) {
                    isDeclaremarketingAgent = "Y";
                } else {
                    isDeclaremarketingAgent = "N";
                }

            }
        });

        isUtilizationOfHCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isUtilizationOfHCD.isChecked()) {
                    isUtilizationofHCD = "Y";
                } else {
                    isUtilizationofHCD = "N";
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
        ssCertificationToKsh1758Award.setAdapter(regionAdapter);

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
        ssOtherRecognizedStandardsAward.setAdapter(regionAdapter);

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
        ssEvidenceOfRegonNaionalTraceabilityAward.setAdapter(regionAdapter);
        ssEvidenceOfRegSingleWindowAward.setAdapter(regionAdapter);
        ssCopyOfHcdExportLicenceAward.setAdapter(regionAdapter);
        ssTraceAbilityListContractedfarmersAward.setAdapter(regionAdapter);
        ssDeclareMarketingAgentAward.setAdapter(regionAdapter);
        ssUtilizationOfHCDAwardAward.setAdapter(regionAdapter);

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
        ssCertificationtoKsh1758Award = Objects.requireNonNull(ssCertificationToKsh1758Award.getSelectedItem()).toString().trim();
        certificationtoKsh1758Timeline = Objects.requireNonNull(etCertificationToKsh1758Timeline.getText()).toString().trim();
        certificationtoKsh1758Remarks = Objects.requireNonNull(etCertificationToKsh1758Remarks.getText()).toString().trim();

        ssOtherrecognizedStandardsAward = Objects.requireNonNull(ssOtherRecognizedStandardsAward.getSelectedItem()).toString().trim();
        otherrecognizedStandardstimeline = Objects.requireNonNull(etOtherRecognizedStandardsTimeline.getText()).toString().trim();
        otherrecognizedStandardsRemarks = Objects.requireNonNull(etOtherRecognizedStandardsRemarks.getText()).toString().trim();

        ssEvidenceofRegonNaionalTraceabilityAward = Objects.requireNonNull(ssEvidenceOfRegonNaionalTraceabilityAward.getSelectedItem()).toString().trim();
        evidenceofRegonNaionalTraceabilityTimeline = Objects.requireNonNull(etEvidenceOfRegonNaionalTraceabilityTimeline.getText()).toString().trim();
        evidenceofRegonNaionalTraceabilityRemarks = Objects.requireNonNull(etEvidenceOfRegonNaionalTraceabilityRemarks.getText()).toString().trim();


        ssEvidenceofRegSingleWindowAward = Objects.requireNonNull(ssEvidenceOfRegSingleWindowAward.getSelectedItem()).toString().trim();
        evidenceofRegSingleWindowTimeline = Objects.requireNonNull(etEvidenceOfRegSingleWindowTimeline.getText()).toString().trim();
        evidenceofRegSingleWindowRemarks = Objects.requireNonNull(etEvidenceOfRegSingleWindowRemarks.getText()).toString().trim();

        ssCopyofHcdExportLicenceAward = Objects.requireNonNull(ssCopyOfHcdExportLicenceAward.getSelectedItem()).toString().trim();
        copyofHcdExportLicenceTimeline = Objects.requireNonNull(etCopyOfHcdExportLicenceTimeline.getText()).toString().trim();
        copyofHcdExportLicenceRemarks = Objects.requireNonNull(etCopyOfHcdExportLicenceRemarks.getText()).toString().trim();

        ssTraceabilityListContractedfarmersAward = Objects.requireNonNull(ssTraceAbilityListContractedfarmersAward.getSelectedItem()).toString().trim();
        traceabilityListContractedfarmersTimeline = Objects.requireNonNull(etTraceAbilityListContractedfarmersTimeline.getText()).toString().trim();
        traceabilityListContractedfarmersRemarks = Objects.requireNonNull(etTraceAbilityListContractedfarmersRemarks.getText()).toString().trim();

        ssDeclaremarketingAgentAward = Objects.requireNonNull(ssDeclareMarketingAgentAward.getSelectedItem()).toString().trim();
        declaremarketingAgentTimeline = Objects.requireNonNull(etDeclareMarketingAgentTimeline.getText()).toString().trim();
        declaremarketingAgentREmarks = Objects.requireNonNull(etDeclareMarketingAgentRemarks.getText()).toString().trim();

        ssUtilizationofHCDAward = Objects.requireNonNull(ssUtilizationOfHCDAwardAward.getSelectedItem()).toString().trim();
        utilizationofHCDTimeline = Objects.requireNonNull(etUtilizationOfHCDTimeline.getText()).toString().trim();
        utilizationofHCDRemarks = Objects.requireNonNull(etUtilizationOfHCDRemarks.getText()).toString().trim();

        boolean valid = validateFields(isOtherRecognizedStandards, etOtherRecognizedStandardsTimeline, otherrecognizedStandardstimeline, etOtherRecognizedStandardsRemarks, otherrecognizedStandardsRemarks, ssOtherRecognizedStandardsAward, ssOtherrecognizedStandardsAward) &
                validateFields(isCertificationToKsh1758, etCertificationToKsh1758Timeline, certificationtoKsh1758Timeline, etCertificationToKsh1758Remarks, certificationtoKsh1758Remarks, ssCertificationToKsh1758Award, ssCertificationtoKsh1758Award) &
                validateFields(isEvidenceOfRegonNaionalTraceability, etEvidenceOfRegonNaionalTraceabilityTimeline, evidenceofRegonNaionalTraceabilityTimeline, etEvidenceOfRegonNaionalTraceabilityRemarks, evidenceofRegonNaionalTraceabilityRemarks, ssEvidenceOfRegonNaionalTraceabilityAward, ssEvidenceofRegonNaionalTraceabilityAward) &
                validateFields(isEvidenceOfRegSingleWindow, etEvidenceOfRegSingleWindowTimeline, evidenceofRegSingleWindowTimeline, etEvidenceOfRegSingleWindowRemarks, evidenceofRegSingleWindowRemarks, ssEvidenceOfRegSingleWindowAward, ssEvidenceofRegSingleWindowAward) &
                validateFields(isCopyOfHcdExportLicence, etCopyOfHcdExportLicenceTimeline, copyofHcdExportLicenceTimeline, etCopyOfHcdExportLicenceRemarks, copyofHcdExportLicenceRemarks, ssCopyOfHcdExportLicenceAward, ssCopyofHcdExportLicenceAward) &
                validateFields(isTraceAbilityListContractedfarmers, etTraceAbilityListContractedfarmersTimeline, traceabilityListContractedfarmersTimeline, etTraceAbilityListContractedfarmersRemarks, traceabilityListContractedfarmersRemarks, ssTraceAbilityListContractedfarmersAward, ssTraceabilityListContractedfarmersAward) &
                validateFields(isDeclareMarketingAgent, etDeclareMarketingAgentTimeline, declaremarketingAgentTimeline, etDeclareMarketingAgentRemarks, declaremarketingAgentREmarks, ssDeclareMarketingAgentAward, ssDeclaremarketingAgentAward) &
                validateFields(isUtilizationOfHCD, etUtilizationOfHCDTimeline, utilizationofHCDTimeline, etUtilizationOfHCDRemarks, utilizationofHCDRemarks, ssUtilizationOfHCDAwardAward, ssUtilizationofHCDAward);

        if (valid) {

            FruitVegetableConsolidatorsBus fruitVegetableConsolidatorsBus = FruitVegetableConsolidatorsBus.getInstance();
            fruitVegetableConsolidatorsBus.setIsCertificationtoKsh1758(isCertificationtoKsh1758);
            fruitVegetableConsolidatorsBus.setSsCertificationtoKsh1758Award(ssCertificationtoKsh1758Award);
            fruitVegetableConsolidatorsBus.setCertificationtoKsh1758Timeline(certificationtoKsh1758Timeline);
            fruitVegetableConsolidatorsBus.setCertificationtoKsh1758Remarks(certificationtoKsh1758Remarks);
            fruitVegetableConsolidatorsBus.setIsOtherrecognizedStandards(isOtherrecognizedStandards);
            fruitVegetableConsolidatorsBus.setSsOtherrecognizedStandardsAward(ssOtherrecognizedStandardsAward);
            fruitVegetableConsolidatorsBus.setOtherrecognizedStandardstimeline(otherrecognizedStandardstimeline);
            fruitVegetableConsolidatorsBus.setOtherrecognizedStandardsRemarks(otherrecognizedStandardsRemarks);
            fruitVegetableConsolidatorsBus.setIsEvidenceofRegonNaionalTraceability(isEvidenceofRegonNaionalTraceability);
            fruitVegetableConsolidatorsBus.setSsEvidenceofRegonNaionalTraceabilityAward(ssEvidenceofRegonNaionalTraceabilityAward);
            fruitVegetableConsolidatorsBus.setEvidenceofRegonNaionalTraceabilityTimeline(evidenceofRegonNaionalTraceabilityTimeline);
            fruitVegetableConsolidatorsBus.setEvidenceofRegonNaionalTraceabilityRemarks(evidenceofRegonNaionalTraceabilityRemarks);
            fruitVegetableConsolidatorsBus.setIsEvidenceofRegSingleWindow(isEvidenceofRegSingleWindow);
            fruitVegetableConsolidatorsBus.setSsEvidenceofRegSingleWindowAward(ssEvidenceofRegSingleWindowAward);
            fruitVegetableConsolidatorsBus.setEvidenceofRegSingleWindowTimeline(evidenceofRegSingleWindowTimeline);
            fruitVegetableConsolidatorsBus.setEvidenceofRegSingleWindowRemarks(evidenceofRegSingleWindowRemarks);
            fruitVegetableConsolidatorsBus.setIsCopyofHcdExportLicence(isCopyofHcdExportLicence);
            fruitVegetableConsolidatorsBus.setSsCopyofHcdExportLicenceAward(ssCopyofHcdExportLicenceAward);
            fruitVegetableConsolidatorsBus.setCopyofHcdExportLicenceTimeline(copyofHcdExportLicenceTimeline);
            fruitVegetableConsolidatorsBus.setCopyofHcdExportLicenceRemarks(copyofHcdExportLicenceRemarks);
            fruitVegetableConsolidatorsBus.setIsTraceabilityListContractedfarmers(isTraceabilityListContractedfarmers);
            fruitVegetableConsolidatorsBus.setSsTraceabilityListContractedfarmersAward(ssTraceabilityListContractedfarmersAward);
            fruitVegetableConsolidatorsBus.setTraceabilityListContractedfarmersTimeline(traceabilityListContractedfarmersTimeline);
            fruitVegetableConsolidatorsBus.setTraceabilityListContractedfarmersRemarks(traceabilityListContractedfarmersRemarks);
            fruitVegetableConsolidatorsBus.setIsDeclaremarketingAgent(isDeclaremarketingAgent);
            fruitVegetableConsolidatorsBus.setSsDeclaremarketingAgentAward(ssDeclaremarketingAgentAward);
            fruitVegetableConsolidatorsBus.setDeclaremarketingAgentTimeline(declaremarketingAgentTimeline);
            fruitVegetableConsolidatorsBus.setDeclaremarketingAgentREmarks(declaremarketingAgentREmarks);
            fruitVegetableConsolidatorsBus.setIsUtilizationofHCD(isUtilizationofHCD);
            fruitVegetableConsolidatorsBus.setSsUtilizationofHCDAward(ssUtilizationofHCDAward);
            fruitVegetableConsolidatorsBus.setUtilizationofHCDTimeline(utilizationofHCDTimeline);
            fruitVegetableConsolidatorsBus.setUtilizationofHCDRemarks(utilizationofHCDRemarks);
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

    private boolean validateFields(CheckBox checkBox, CustomEditText firstCustomEditText, String firstCustomEditTextString, CustomEditText secondCustomEditText, String secondCustomEditTextString, SearchableSpinner searchableSpinner, String searchableSpinnerString) {

        boolean resultEditText1 = false;
        boolean resultEditText2 = false;
        boolean resultCheckbox = false;
        boolean resultSpinner = false;

        if (!checkBox.isChecked()) {
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
        } else {
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
        } else {
            resultSpinner = true;
        }
        return (resultCheckbox && resultSpinner);
    }

}
