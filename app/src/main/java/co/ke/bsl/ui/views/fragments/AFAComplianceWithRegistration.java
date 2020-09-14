package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
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
import co.ke.bsl.R;
import co.ke.bsl.data.view.TeaWarehouseManInspectionBus;
import co.ke.bsl.data.view.View5Marks;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAComplianceWithRegistration extends Fragment implements BlockingStep {

    @BindView(R.id.ch_certificate_of_company_registration_incorp)
    CheckBox ch_certificate_of_company_registration_incorp;
    @BindView(R.id.sscertificate_of_company_registration_mandatory)
    SearchableSpinner sscertificate_of_company_registration_mandatory;
    @BindView(R.id.etcertificate_of_company_registration_remarks)
    CustomEditText etcertificate_of_company_registration_remarks;

    @BindView(R.id.ch_valid_insurance_policy)
    CheckBox ch_valid_insurance_policy;
    @BindView(R.id.ssvalid_insurance_policy_mandatory)
    SearchableSpinner ssvalid_insurance_policy_mandatory;
    @BindView(R.id.etvalid_insurance_policy_remarks)
    CustomEditText etvalid_insurance_policy_remarks;


    @BindView(R.id.ch_business_permit)
    CheckBox ch_business_permit;
    @BindView(R.id.ssbusiness_permit_mandatory)
    SearchableSpinner ssbusiness_permit_mandatory;
    @BindView(R.id.etbusiness_permit_remarks)
    CustomEditText etbusiness_permit_remarks;


    @BindView(R.id.ch_health_certificate)
    CheckBox ch_health_certificate;
    @BindView(R.id.sshealth_certificate_mandatory)
    SearchableSpinner sshealth_certificate_mandatory;
    @BindView(R.id.ethealth_certificate_remarks)
    CustomEditText ethealth_certificate_remarks;


    @BindView(R.id.ch_submission_of_annual_returns)
    CheckBox ch_submission_of_annual_returns;
    @BindView(R.id.sssubmission_of_annual_returns_mandatory)
    SearchableSpinner sssubmission_of_annual_returns_mandatory;
    @BindView(R.id.etsubmission_of_annual_returns_remarks)
    CustomEditText etsubmission_of_annual_returns_remarks;

    private String Savestring = "N";

    private String str_certificate_of_company_registration, str_valid_insurance_policy, str_business_permit, str_health_certificate, str_submission_of_annual_returns;
    private String certificate_of_company_registration_mandatory, valid_insurance_policy_mandatory, business_permit_mandatory, health_certificate_mandatory, submission_of_annual_returns_mandatory;

    private ArrayList<String> marksOf5List = new ArrayList<>();


    public AFAComplianceWithRegistration() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afacompliance_with_registration, container, false);
        ButterKnife.bind(this, view);

        setList5Marks(getDummy5Marks());


        ch_certificate_of_company_registration_incorp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_certificate_of_company_registration_incorp.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_certificate_of_company_registration = Savestring;

            }
        });

        ch_valid_insurance_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_valid_insurance_policy.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_valid_insurance_policy = Savestring;

            }
        });

        ch_business_permit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_business_permit.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_business_permit = Savestring;

            }
        });

        ch_health_certificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_health_certificate.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_health_certificate = Savestring;

            }
        });

        ch_submission_of_annual_returns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_submission_of_annual_returns.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_submission_of_annual_returns = Savestring;

            }
        });


        sscertificate_of_company_registration_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                certificate_of_company_registration_mandatory = sscertificate_of_company_registration_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssvalid_insurance_policy_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valid_insurance_policy_mandatory = ssvalid_insurance_policy_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssbusiness_permit_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                business_permit_mandatory = ssbusiness_permit_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sshealth_certificate_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                health_certificate_mandatory = sshealth_certificate_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sssubmission_of_annual_returns_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                submission_of_annual_returns_mandatory = sssubmission_of_annual_returns_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        String certificate_of_company_registration_remarks = Objects.requireNonNull(etcertificate_of_company_registration_remarks.getText()).toString().trim();
        String valid_insurance_policy_remarks = Objects.requireNonNull(etvalid_insurance_policy_remarks.getText()).toString().trim();
        String business_permit_remarks = Objects.requireNonNull(etbusiness_permit_remarks.getText()).toString().trim();
        String health_certificate_remarks = Objects.requireNonNull(ethealth_certificate_remarks.getText()).toString().trim();
        String submission_of_annual_returns_remarks= Objects.requireNonNull(etsubmission_of_annual_returns_remarks.getText()).toString().trim();

        boolean a = validateFields(ch_certificate_of_company_registration_incorp, etcertificate_of_company_registration_remarks, certificate_of_company_registration_remarks, sscertificate_of_company_registration_mandatory, certificate_of_company_registration_mandatory);
        boolean b = validateFields(ch_valid_insurance_policy, etvalid_insurance_policy_remarks, valid_insurance_policy_remarks, ssvalid_insurance_policy_mandatory, valid_insurance_policy_mandatory);
        boolean c = validateFields(ch_business_permit, etbusiness_permit_remarks, business_permit_remarks, ssbusiness_permit_mandatory, business_permit_mandatory);
        boolean d = validateFields(ch_health_certificate, ethealth_certificate_remarks, health_certificate_remarks, sshealth_certificate_mandatory, health_certificate_mandatory);
        boolean e = validateFields(ch_submission_of_annual_returns, etsubmission_of_annual_returns_remarks, submission_of_annual_returns_remarks, sssubmission_of_annual_returns_mandatory, submission_of_annual_returns_mandatory);

        TeaWarehouseManInspectionBus teaWarehouseManInspectionBus = TeaWarehouseManInspectionBus.getInstance();
        teaWarehouseManInspectionBus.setCertificate_of_company_registration(str_certificate_of_company_registration);
        teaWarehouseManInspectionBus.setCertificate_of_company_registration_mandatory(certificate_of_company_registration_mandatory);
        teaWarehouseManInspectionBus.setCertificate_of_company_registration_remarks(certificate_of_company_registration_remarks);
        teaWarehouseManInspectionBus.setValid_insurance_policy(str_valid_insurance_policy);
        teaWarehouseManInspectionBus.setValid_insurance_policy_mandatory(valid_insurance_policy_mandatory);
        teaWarehouseManInspectionBus.setValid_insurance_policy_remarks(valid_insurance_policy_remarks);
        teaWarehouseManInspectionBus.setBusiness_permit(str_business_permit);
        teaWarehouseManInspectionBus.setBusiness_permit_mandatory(business_permit_mandatory);
        teaWarehouseManInspectionBus.setBusiness_permit_remarks(business_permit_remarks);
        teaWarehouseManInspectionBus.setHealth_certificate(str_health_certificate);
        teaWarehouseManInspectionBus.setHealth_certificate_mandatory(health_certificate_mandatory);
        teaWarehouseManInspectionBus.setHealth_certificate_remarks(health_certificate_remarks);
        teaWarehouseManInspectionBus.setSubmission_of_annual_returns(str_submission_of_annual_returns);
        teaWarehouseManInspectionBus.setSubmission_of_annual_returns_mandatory(submission_of_annual_returns_mandatory);
        teaWarehouseManInspectionBus.setSubmission_of_annual_returns_remarks(submission_of_annual_returns_remarks);

        if(a && b && c && d && e){
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


    private void setList5Marks(List<View5Marks> dummy5Marks) {

        marksOf5List.add("- Required -");
        for (View5Marks regionWrapper : dummy5Marks) {
            marksOf5List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf5List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssbusiness_permit_mandatory.setAdapter(regionAdapter);
        sscertificate_of_company_registration_mandatory.setAdapter(regionAdapter);
        sshealth_certificate_mandatory.setAdapter(regionAdapter);
        sssubmission_of_annual_returns_mandatory.setAdapter(regionAdapter);
        ssvalid_insurance_policy_mandatory.setAdapter(regionAdapter);
    }

    private List<View5Marks> getDummy5Marks() {
        List<View5Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View5Marks("0"));
        listViewItems.add(new View5Marks("5"));
        return listViewItems;
    }

    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString, SearchableSpinner searchableSpinner, String searchableSpinnerString){

        boolean resultCheckbox = false;
        boolean resultSpinner = false;

        if(!checkBox.isChecked()){
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                resultCheckbox = false;
            }
        } else{
            customEditText.setError(null);
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
