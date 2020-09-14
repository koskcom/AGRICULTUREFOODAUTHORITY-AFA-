package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFALicensesConformanceAssessmentSection1Generalconditions extends Fragment implements BlockingStep {

    @BindView(R.id.etapplicant_profile)
    CustomEditText etapplicant_profile;
    @BindView(R.id.etself_score1)
    CustomEditText etself_score1;
    @BindView(R.id.etaddress_physical)
    CustomEditText etaddress_physical;
    @BindView(R.id.etself_score2)
    CustomEditText etself_score2;
    @BindView(R.id.etdisclosure_of_profile)
    CustomEditText etdisclosure_of_profile;
    @BindView(R.id.etself_score3)
    CustomEditText etself_score3;
    @BindView(R.id.etland_sources_of_util)
    CustomEditText etland_sources_of_util;
    @BindView(R.id.etself_score4)
    CustomEditText etself_score4;
    @BindView(R.id.etsugar_source)
    CustomEditText etsugar_source;
    @BindView(R.id.etself_score5)
    CustomEditText etself_score5;
    @BindView(R.id.etsustainability)
    CustomEditText etsustainability;
    @BindView(R.id.etself_score6)
    CustomEditText etself_score6;
    @BindView(R.id.etcompliance_with_quality)
    CustomEditText etcompliance_with_quality;
    @BindView(R.id.etself_score7)
    CustomEditText etself_score7;
    @BindView(R.id.etcompliance_with_legal_requirements)
    CustomEditText etcompliance_with_legal_requirements;
    @BindView(R.id.etself_score8)
    CustomEditText etself_score8;
    @BindView(R.id.etnature_and_quality)
    CustomEditText etnature_and_quality;
    @BindView(R.id.etself_score9)
    CustomEditText etself_score9;
    @BindView(R.id.etproduction_and_distribution)
    CustomEditText etproduction_and_distribution;
    @BindView(R.id.etself_score10)
    CustomEditText etself_score10;

    private String applicant_profile, self_score1,physical_address, self_score2, disclosure_of_profile, self_score3,land_sources_of_util, self_score4, sugar_source, self_score5;

    private String sustainability, self_score6, compliance_with_quality, self_score7,compliance_with_legal_requirements, self_score8,nature_and_quality, self_score9,production_and_distribution, self_score10;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afalicenses_conformaformance_section1_generalconditions, container, false);
        ButterKnife.bind(this, view);
        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        applicant_profile = Objects.requireNonNull(etapplicant_profile.getText().toString());
        self_score1 = Objects.requireNonNull(etself_score1.getText().toString());
        physical_address =Objects.requireNonNull(etaddress_physical.getText().toString());
        self_score2 =Objects.requireNonNull(etself_score2.getText().toString());
        disclosure_of_profile =Objects.requireNonNull(etdisclosure_of_profile.getText().toString());
        self_score3 =Objects.requireNonNull(etself_score3.getText().toString());
        land_sources_of_util =Objects.requireNonNull(etland_sources_of_util.getText().toString());
        self_score4 =Objects.requireNonNull(etself_score4.getText().toString());
        sugar_source =Objects.requireNonNull(etsugar_source.getText().toString());
        self_score5 =Objects.requireNonNull(etself_score5.getText().toString());
        sustainability =Objects.requireNonNull(etsustainability.getText().toString());
        self_score6 =Objects.requireNonNull(etself_score6.getText().toString());
        compliance_with_quality =Objects.requireNonNull(etcompliance_with_quality.getText().toString());
        self_score7 =Objects.requireNonNull(etself_score7.getText().toString());
        compliance_with_legal_requirements =Objects.requireNonNull(etcompliance_with_legal_requirements.getText().toString());
        self_score8 =Objects.requireNonNull(etself_score8.getText().toString());
        nature_and_quality =Objects.requireNonNull(etnature_and_quality.getText().toString());
        self_score9 =Objects.requireNonNull(etself_score9.getText().toString());
        production_and_distribution =Objects.requireNonNull(etproduction_and_distribution.getText().toString());
        self_score10 =Objects.requireNonNull(etself_score10.getText().toString());

        if (TextUtils.isEmpty(applicant_profile))
        {
            etapplicant_profile.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_score1))
        {
            etself_score1.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(physical_address))
        {
            etaddress_physical.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_score2))
        {
            etself_score2.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(disclosure_of_profile))
        {
            etdisclosure_of_profile.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_score3))
        {
            etself_score3.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(land_sources_of_util))
        {
            etland_sources_of_util.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_score4))
        {
            etself_score4.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(sugar_source))
        {
            etsugar_source.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_score5))
        {
            etself_score5.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(sustainability))
        {
            etsustainability.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_score6))
        {
            etself_score6.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(compliance_with_quality))
        {
            etcompliance_with_quality.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_score7))
        {
            etself_score7.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(compliance_with_legal_requirements))
        {
            etcompliance_with_legal_requirements.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_score8))
        {
            etself_score8.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(nature_and_quality))
        {
            etnature_and_quality.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_score9))
        {
            etself_score9.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(production_and_distribution))
        {
            etproduction_and_distribution.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_score10))
        {
            etself_score10.setError("Field Required");
            return;
        }
/*
        LicenceConformanceAssessmentBus licenceConformanceAssessmentBus = LicenceConformanceAssessmentBus.getInstance();

        licenceConformanceAssessmentBus.setApplicant_profile(applicant_profile);
        licenceConformanceAssessmentBus.setSelf_score1(self_score1);
        licenceConformanceAssessmentBus.setPhysical_address(physical_address);
        licenceConformanceAssessmentBus.setSelf_score2(self_score2);
        licenceConformanceAssessmentBus.setDisclosure_of_profile(disclosure_of_profile);
        licenceConformanceAssessmentBus.setSelf_score3(self_score3);
        licenceConformanceAssessmentBus.setLand_sources_of_util(land_sources_of_util);
        licenceConformanceAssessmentBus.setSelf_score4(self_score4);
        licenceConformanceAssessmentBus.setSugar_source(sugar_source);
        licenceConformanceAssessmentBus.setSelf_score5(self_score5);
        licenceConformanceAssessmentBus.setSustainability(sustainability);
        licenceConformanceAssessmentBus.setSelf_score6(self_score6);
        licenceConformanceAssessmentBus.setCompliance_with_quality(compliance_with_quality);
        licenceConformanceAssessmentBus.setSelf_score7(self_score7);
        licenceConformanceAssessmentBus.setCompliance_with_legal_requirements(compliance_with_legal_requirements);
        licenceConformanceAssessmentBus.setSelf_score8(self_score8);
        licenceConformanceAssessmentBus.setNature_and_quality(nature_and_quality);
        licenceConformanceAssessmentBus.setSelf_score9(self_score9);
        licenceConformanceAssessmentBus.setProduction_and_distribution(production_and_distribution);
        licenceConformanceAssessmentBus.setSelf_score10(self_score10);
*/
        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback)
    {

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback)
    {

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
    public void onError(@NonNull VerificationError error)
    {

    }


}

