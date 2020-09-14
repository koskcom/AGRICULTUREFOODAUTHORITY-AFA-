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
import co.ke.bsl.data.view.HCDFlowersConsolidatorsBus;
import co.ke.bsl.data.view.View10Marks;
import co.ke.bsl.data.view.View15Marks;
import co.ke.bsl.data.view.View5Marks;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDFlowersConsolidatorsChecklistStep2 extends Fragment implements BlockingStep {

    @BindView(R.id.isListOfCompCertificate)
    CheckBox isListOfCompCertificate;
    @BindView(R.id.etListOfCompCertificateAward)
    SearchableSpinner etListOfCompCertificateAward;
    @BindView(R.id.etListOfCompCertificateTimeline)
    CustomEditText etListOfCompCertificateTimeline;
    @BindView(R.id.etListOfCompCertificateRemarks)
    CustomEditText etListOfCompCertificateRemarks;

    @BindView(R.id.isValidityOfSuppliers)
    CheckBox isValidityOfSuppliers;
    @BindView(R.id.etValidityOfSuppliersAward)
    SearchableSpinner etValidityOfSuppliersAward;
    @BindView(R.id.etValidityOfSuppliersTimeline)
    CustomEditText etValidityOfSuppliersTimeline;
    @BindView(R.id.etValidityOfSuppliersRemarks)
    CustomEditText etValidityOfSuppliersRemarks;

    @BindView(R.id.isCertificationToKsh1758)
    CheckBox isCertificationToKsh1758;
    @BindView(R.id.etCertificationToKsh1758Award)
    SearchableSpinner etCertificationToKsh1758Award;
    @BindView(R.id.etCertificationToKsh1758Timeline)
    CustomEditText etCertificationToKsh1758Timeline;
    @BindView(R.id.etCertificationToKsh1758Remarks)
    CustomEditText etCertificationToKsh1758Remarks;

    @BindView(R.id.isCopyOfHcdExportLicence)
    CheckBox isCopyOfHcdExportLicence;
    @BindView(R.id.etCopyOfHcdExportLicenceAward)
    SearchableSpinner etCopyOfHcdExportLicenceAward;
    @BindView(R.id.etCopyOfHcdExportLicenceTimeline)
    CustomEditText etCopyOfHcdExportLicenceTimeline;
    @BindView(R.id.etCopyOfHcdExportLicenceRemarks)
    CustomEditText etCopyOfHcdExportLicenceRemarks;

    @BindView(R.id.isEvidenceOfRegonNaionalTraceability)
    CheckBox isEvidenceOfRegonNaionalTraceability;
    @BindView(R.id.etEvidenceOfRegonNaionalTraceabilityAward)
    SearchableSpinner etEvidenceOfRegonNaionalTraceabilityAward;
    @BindView(R.id.etEvidenceOfRegonNaionalTraceabilityTimeline)
    CustomEditText etEvidenceOfRegonNaionalTraceabilityTimeline;
    @BindView(R.id.etEvidenceOfRegonNaionalTraceabilityRemarks)
    CustomEditText etEvidenceOfRegonNaionalTraceabilityRemarks;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private String islistofcomapanycertificate, isValididtyOfSupplliers, isCertificationToksh1758, isCopyHcdExportlicence, isEvidenceNationalTraceability;
    private String listofcomapanycertificateAward, valididtyOfSupplliersAward, certificationToksh1758Award, copyHcdExportlicenceAward, evidenceNationalTraceabilityAward;
    private String listofcomapanycertificateTimeline, valididtyOfSupplliersTimeline, certificationToksh1758Timeline, copyHcdExportlicenceTimeline, evidenceNationalTraceabilityTimeline;
    private String listofcomapanycertificateRemarks, valididtyOfSupplliersRemarks, certificationToksh1758Remarks, copyHcdExportlicenceRemarks, evidenceNationalTraceabilityRemarks;

    private ArrayList<String> marksof10List = new ArrayList<>();
    private ArrayList<String> marksof5List = new ArrayList<>();
    private ArrayList<String> marksof15List = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdflowers_consolidators_checklist_step2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        setList15marks(getdummy15marks());
        setList10marks(getdummy10marks());
        setList5marks(getdummy5marks());


        isListOfCompCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isListOfCompCertificate.isChecked()) {
                    islistofcomapanycertificate = "Y";
                } else {
                    islistofcomapanycertificate = "N";
                }

            }
        });

        isValidityOfSuppliers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidityOfSuppliers.isChecked()) {
                    isValididtyOfSupplliers = "Y";
                } else {
                    isValididtyOfSupplliers = "N";
                }

            }
        });

        isCertificationToKsh1758.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCertificationToKsh1758.isChecked()) {
                    isCertificationToksh1758 = "Y";
                } else {
                    isCertificationToksh1758 = "N";
                }

            }
        });

        isCopyOfHcdExportLicence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCopyOfHcdExportLicence.isChecked()) {
                    isCopyHcdExportlicence = "Y";
                } else {
                    isCopyHcdExportlicence = "N";
                }

            }
        });

        isEvidenceOfRegonNaionalTraceability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEvidenceOfRegonNaionalTraceability.isChecked()) {
                    isEvidenceNationalTraceability = "Y";
                } else {
                    isEvidenceNationalTraceability = "N";
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
        etValidityOfSuppliersAward.setAdapter(regionAdapter);
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
        etListOfCompCertificateAward.setAdapter(regionAdapter);

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
        etCopyOfHcdExportLicenceAward.setAdapter(regionAdapter);
        etEvidenceOfRegonNaionalTraceabilityAward.setAdapter(regionAdapter);

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
        listofcomapanycertificateAward = Objects.requireNonNull(etListOfCompCertificateAward.getSelectedItem()).toString().trim();
        listofcomapanycertificateTimeline = Objects.requireNonNull(etListOfCompCertificateTimeline.getText()).toString().trim();
        listofcomapanycertificateRemarks = Objects.requireNonNull(etListOfCompCertificateRemarks.getText()).toString().trim();
        valididtyOfSupplliersAward = Objects.requireNonNull(etValidityOfSuppliersAward.getSelectedItem()).toString().trim();
        valididtyOfSupplliersTimeline = Objects.requireNonNull(etValidityOfSuppliersTimeline.getText()).toString().trim();
        valididtyOfSupplliersRemarks = Objects.requireNonNull(etValidityOfSuppliersRemarks.getText()).toString().trim();
        certificationToksh1758Award = Objects.requireNonNull(etCertificationToKsh1758Award.getSelectedItem()).toString().trim();
        certificationToksh1758Timeline = Objects.requireNonNull(etCertificationToKsh1758Timeline.getText()).toString().trim();
        certificationToksh1758Remarks = Objects.requireNonNull(etCertificationToKsh1758Remarks.getText()).toString().trim();
        copyHcdExportlicenceAward = Objects.requireNonNull(etCopyOfHcdExportLicenceAward.getSelectedItem()).toString().trim();
        copyHcdExportlicenceTimeline = Objects.requireNonNull(etCopyOfHcdExportLicenceTimeline.getText()).toString().trim();
        copyHcdExportlicenceRemarks = Objects.requireNonNull(etCopyOfHcdExportLicenceRemarks.getText()).toString().trim();
        evidenceNationalTraceabilityAward = Objects.requireNonNull(etEvidenceOfRegonNaionalTraceabilityAward.getSelectedItem()).toString().trim();
        evidenceNationalTraceabilityTimeline = Objects.requireNonNull(etEvidenceOfRegonNaionalTraceabilityTimeline.getText()).toString().trim();
        evidenceNationalTraceabilityRemarks = Objects.requireNonNull(etEvidenceOfRegonNaionalTraceabilityRemarks.getText()).toString().trim();

        boolean valid = validateFields(isListOfCompCertificate, etListOfCompCertificateTimeline, listofcomapanycertificateTimeline, etListOfCompCertificateRemarks, listofcomapanycertificateRemarks, etListOfCompCertificateAward, listofcomapanycertificateAward) &
                validateFields(isValidityOfSuppliers, etValidityOfSuppliersTimeline, valididtyOfSupplliersTimeline, etValidityOfSuppliersRemarks, valididtyOfSupplliersRemarks, etValidityOfSuppliersAward, valididtyOfSupplliersAward) &
                validateFields(isCertificationToKsh1758, etCertificationToKsh1758Timeline, certificationToksh1758Timeline, etCertificationToKsh1758Remarks, certificationToksh1758Remarks, etCertificationToKsh1758Award, certificationToksh1758Award) &
                validateFields(isCopyOfHcdExportLicence, etCopyOfHcdExportLicenceTimeline, copyHcdExportlicenceTimeline, etCopyOfHcdExportLicenceRemarks, copyHcdExportlicenceRemarks, etCopyOfHcdExportLicenceAward, copyHcdExportlicenceAward) &
                validateFields(isEvidenceOfRegonNaionalTraceability, etEvidenceOfRegonNaionalTraceabilityTimeline, evidenceNationalTraceabilityTimeline, etEvidenceOfRegonNaionalTraceabilityRemarks, evidenceNationalTraceabilityRemarks, etEvidenceOfRegonNaionalTraceabilityAward, evidenceNationalTraceabilityAward);


        HCDFlowersConsolidatorsBus hCDFlowersConsolidatorsBus = HCDFlowersConsolidatorsBus.getInstance();

        hCDFlowersConsolidatorsBus.setIslistofcomapanycertificate(islistofcomapanycertificate);
        hCDFlowersConsolidatorsBus.setListofcomapanycertificateAward(listofcomapanycertificateAward);
        hCDFlowersConsolidatorsBus.setListofcomapanycertificateTimeline(listofcomapanycertificateTimeline);
        hCDFlowersConsolidatorsBus.setListofcomapanycertificateRemarks(listofcomapanycertificateRemarks);
        hCDFlowersConsolidatorsBus.setIsValididtyOfSupplliers(isValididtyOfSupplliers);
        hCDFlowersConsolidatorsBus.setValididtyOfSupplliersAward(valididtyOfSupplliersAward);
        hCDFlowersConsolidatorsBus.setValididtyOfSupplliersTimeline(valididtyOfSupplliersTimeline);
        hCDFlowersConsolidatorsBus.setValididtyOfSupplliersRemarks(valididtyOfSupplliersRemarks);
        hCDFlowersConsolidatorsBus.setIsCertificationToksh1758(isCertificationToksh1758);
        hCDFlowersConsolidatorsBus.setCertificationToksh1758Award(certificationToksh1758Award);
        hCDFlowersConsolidatorsBus.setCertificationToksh1758Timeline(certificationToksh1758Timeline);
        hCDFlowersConsolidatorsBus.setCertificationToksh1758Remarks(certificationToksh1758Remarks);
        hCDFlowersConsolidatorsBus.setIsCopyHcdExportlicence(isCopyHcdExportlicence);
        hCDFlowersConsolidatorsBus.setCopyHcdExportlicenceAward(copyHcdExportlicenceAward);
        hCDFlowersConsolidatorsBus.setCopyHcdExportlicenceTimeline(copyHcdExportlicenceTimeline);
        hCDFlowersConsolidatorsBus.setCopyHcdExportlicenceRemarks(copyHcdExportlicenceRemarks);
        hCDFlowersConsolidatorsBus.setIsEvidenceRegistrationNationalTraceability(isEvidenceNationalTraceability);
        hCDFlowersConsolidatorsBus.setEvidenceRegistrationNationalTraceabilityAward(evidenceNationalTraceabilityAward);
        hCDFlowersConsolidatorsBus.setEvidenceRegistrationNationalTraceabilityTimeline(evidenceNationalTraceabilityTimeline);
        hCDFlowersConsolidatorsBus.setEvidenceRegistrationNationalTraceabilityRemarks(evidenceNationalTraceabilityRemarks);

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
