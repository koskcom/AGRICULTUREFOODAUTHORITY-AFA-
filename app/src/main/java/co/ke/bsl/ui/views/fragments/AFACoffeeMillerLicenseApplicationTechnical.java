package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
import co.ke.bsl.R;
import co.ke.bsl.data.view.CoffeeMillerLicenceApplicationBus;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFACoffeeMillerLicenseApplicationTechnical extends Fragment implements BlockingStep {
    @BindView(R.id.ch_milling_machinery)
    CheckBox ch_milling_machinery;
    @BindView(R.id.etmilling_machinery_findings)
    CustomEditText etmilling_machinery_findings;

    @BindView(R.id.ch_waste_teas)
    CheckBox ch_waste_teas;
    @BindView(R.id.etwaste_teas_findings)
    CustomEditText etwaste_teas_findings;

    @BindView(R.id.ch_liquoring_cupping_facilities)
    CheckBox ch_liquoring_cupping_facilities;
    @BindView(R.id.etliquoring_cupping_facilities_findings)
    CustomEditText etliquoring_cupping_facilities_findings;

    @BindView(R.id.ch_engagement_of_qualified)
    CheckBox ch_engagement_of_qualified;
    @BindView(R.id.etengagement_of_qualified_findings)
    CustomEditText etengagement_of_qualified_findings;

    @BindView(R.id.ch_protective_clothing_gear)
    CheckBox ch_protective_clothing_gear;
    @BindView(R.id.etprotective_clothing_gear_findings)
    CustomEditText etprotective_clothing_gear_findings;

    @BindView(R.id.ch_weighing_scale)
    CheckBox ch_weighing_scale;
    @BindView(R.id.etweighing_scale_findings)
    CustomEditText etweighing_scale_findings;

    @BindView(R.id.ch_valid_insurance)
    CheckBox ch_valid_insurance;
    @BindView(R.id.etvalid_insurance_findings)
    CustomEditText etvalid_insurance_findings;

    @BindView(R.id.ch_general_security)
    CheckBox ch_general_security;
    @BindView(R.id.etgeneral_security_findings)
    CustomEditText etgeneral_security_findings;

    @BindView(R.id.ch_growers_contracted)
    CheckBox ch_growers_contracted;
    @BindView(R.id.etgrowers_contracted_findings)
    CustomEditText etgrowers_contracted_findings;

    @BindView(R.id.ch_milling_returns)
    CheckBox ch_milling_returns;
    @BindView(R.id.etmilling_returns_findings)
    CustomEditText etmilling_returns_findings;

    private String Savestring = "N";

    private String str_machinery, str_teas, str_liquoring, str_engagement, str_protective, str_weighing, str_valid, str_general, str_growers, str_returns;



    public AFACoffeeMillerLicenseApplicationTechnical() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_afacoffee_miller_license_application_technical, container, false);
        ButterKnife.bind(this, view);

        ch_milling_machinery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_milling_machinery.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_machinery = Savestring;
            }
        });

        ch_waste_teas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_waste_teas.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_teas = Savestring;
            }
        });

        ch_liquoring_cupping_facilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_liquoring_cupping_facilities.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_liquoring = Savestring;
            }
        });

        ch_engagement_of_qualified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_engagement_of_qualified.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_engagement = Savestring;
            }
        });

        ch_protective_clothing_gear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_protective_clothing_gear.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_protective = Savestring;
            }
        });

        ch_weighing_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_weighing_scale.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_weighing = Savestring;
            }
        });

        ch_valid_insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_valid_insurance.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_valid = Savestring;
            }
        });

        ch_general_security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_general_security.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_general = Savestring;
            }
        });

        ch_growers_contracted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_growers_contracted.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_growers = Savestring;
            }
        });

        ch_milling_returns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_milling_returns.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_returns = Savestring;
            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String machinery = Objects.requireNonNull(etmilling_machinery_findings.getText()).toString().trim();
        String teas = Objects.requireNonNull(etwaste_teas_findings.getText()).toString().trim();
        String cupping = Objects.requireNonNull(etliquoring_cupping_facilities_findings.getText()).toString().trim();
        String engagement = Objects.requireNonNull(etengagement_of_qualified_findings.getText()).toString().trim();
        String protective = Objects.requireNonNull(etprotective_clothing_gear_findings.getText()).toString().trim();
        String scale = Objects.requireNonNull(etweighing_scale_findings.getText()).toString().trim();
        String valid = Objects.requireNonNull(etvalid_insurance_findings.getText()).toString().trim();
        String general = Objects.requireNonNull(etgeneral_security_findings.getText()).toString().trim();
        String growers = Objects.requireNonNull(etgrowers_contracted_findings.getText()).toString().trim();
        String returns = Objects.requireNonNull(etmilling_returns_findings.getText()).toString().trim();

        boolean validFields = validateFields(ch_milling_machinery, etmilling_machinery_findings, machinery) &
                validateFields(ch_waste_teas, etwaste_teas_findings, teas) &
                validateFields(ch_liquoring_cupping_facilities, etliquoring_cupping_facilities_findings, cupping) &
                validateFields(ch_engagement_of_qualified, etengagement_of_qualified_findings, engagement) &
                validateFields(ch_protective_clothing_gear, etprotective_clothing_gear_findings, protective) &
                validateFields(ch_weighing_scale, etweighing_scale_findings, scale) &
                validateFields(ch_valid_insurance, etvalid_insurance_findings, valid) &
                validateFields(ch_general_security, etgeneral_security_findings, general) &
                validateFields(ch_growers_contracted, etgrowers_contracted_findings, growers) &
                validateFields(ch_milling_returns, etmilling_returns_findings, returns);

        CoffeeMillerLicenceApplicationBus coffeeMillerLicenceApplicationBus = CoffeeMillerLicenceApplicationBus.getInstance();
        coffeeMillerLicenceApplicationBus.setMillingMachinery(str_machinery);
        coffeeMillerLicenceApplicationBus.setMillingMachineryFindings(machinery);
        coffeeMillerLicenceApplicationBus.setWasteTeas(str_teas);
        coffeeMillerLicenceApplicationBus.setWasteTeasFindings(teas);
        coffeeMillerLicenceApplicationBus.setLiqouringCupping(str_liquoring);
        coffeeMillerLicenceApplicationBus.setLiqouringCuppingFindings(cupping);
        coffeeMillerLicenceApplicationBus.setEngagementQualified(str_engagement);
        coffeeMillerLicenceApplicationBus.setEngagementQualifiedFindings(engagement);
        coffeeMillerLicenceApplicationBus.setProtectiveClothing(str_protective);
        coffeeMillerLicenceApplicationBus.setProtectiveClothingFindings(protective);
        coffeeMillerLicenceApplicationBus.setWeighingScale(str_weighing);
        coffeeMillerLicenceApplicationBus.setWeighingScaleFindings(scale);
        coffeeMillerLicenceApplicationBus.setValidInsurance(str_valid);
        coffeeMillerLicenceApplicationBus.setValidInsuranceFindings(valid);
        coffeeMillerLicenceApplicationBus.setGeneralSecurity(str_general);
        coffeeMillerLicenceApplicationBus.setGeneralSecurityFindings(general);
        coffeeMillerLicenceApplicationBus.setGrowersContracted(str_growers);
        coffeeMillerLicenceApplicationBus.setGrowersContractedFindings(growers);
        coffeeMillerLicenceApplicationBus.setMillingReturns(str_returns);
        coffeeMillerLicenceApplicationBus.setMillingReturnsFindings(returns);


        if(validFields) {
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

   private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString){

        boolean result= false;

        if(!checkBox.isChecked()){
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                result = false;
            } else {
                result = true;
            }
        } else{
            customEditText.setError(null);
            result = true;
        }

        return result;
    }

}
