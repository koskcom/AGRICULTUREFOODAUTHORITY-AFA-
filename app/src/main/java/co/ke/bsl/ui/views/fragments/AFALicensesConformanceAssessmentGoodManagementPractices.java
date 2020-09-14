package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFALicensesConformanceAssessmentGoodManagementPractices extends Fragment implements BlockingStep {

    @BindView(R.id.etstrategic_plan)
    CustomEditText etstrategic_plan;
    @BindView(R.id.etself_rating14)
    CustomEditText etself_rating14;
    @BindView(R.id.etsocio_economic_impacts)
    CustomEditText etsocio_economic_impacts;
    @BindView(R.id.etself_rating15)
    CustomEditText etself_rating15;
    @BindView(R.id.etavarage_cost)
    CustomEditText etavarage_cost;
    @BindView(R.id.etself_rating16)
    CustomEditText etself_rating16;
    @BindView(R.id.etyour_productivity)
    CustomEditText etyour_productivity;
    @BindView(R.id.etself_rating17)
    CustomEditText etself_rating17;
    @BindView(R.id.etstarndardization_progress)
    CustomEditText etstarndardization_progress;
    @BindView(R.id.etself_rating18)
    CustomEditText etself_rating18;
    @BindView(R.id.etcertificate_management)
    CustomEditText etcertificate_management;
    @BindView(R.id.etself_rating19)
    CustomEditText etself_rating19;
    @BindView(R.id.etcorrected_non_conformities)
    CustomEditText etcorrected_non_conformities;
    @BindView(R.id.etself_rating20)
    CustomEditText etself_rating20;
    @BindView(R.id.etself_assessment)
    CustomEditText etself_assessment;

    private String Strategic_plan, self_rating14, socio_economic_impacts, self_rating15, average_cost, self_rating16, your_productivity, self_rating17;

    private String starndardization_progress, self_rating18, certificate_management, self_rating19, corrected_non_conformities, self_rating20, self_assessment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afalicenses_conformance_assessment_good_management_practices, container, false);
        ButterKnife.bind(this, view);
        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {


    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback)
    {
        Strategic_plan = Objects.requireNonNull(etstrategic_plan.getText().toString());
        self_rating14 = Objects.requireNonNull(etself_rating14.getText().toString());
        socio_economic_impacts = Objects.requireNonNull(etsocio_economic_impacts.getText().toString());
        self_rating15 = Objects.requireNonNull(etself_rating15.getText().toString());
        average_cost = Objects.requireNonNull(etavarage_cost.getText().toString());
        self_rating16 = Objects.requireNonNull(etself_rating16.getText().toString());
        your_productivity = Objects.requireNonNull(etyour_productivity.getText().toString());
        self_rating17 = Objects.requireNonNull(etself_rating17.getText().toString());
        starndardization_progress = Objects.requireNonNull(etstarndardization_progress.getText().toString());
        self_rating18 = Objects.requireNonNull(etself_rating18.getText().toString());
        certificate_management = Objects.requireNonNull(etcertificate_management.getText().toString());
        self_rating19 = Objects.requireNonNull(etself_rating19.getText().toString());
        corrected_non_conformities = Objects.requireNonNull(etcorrected_non_conformities.getText().toString());
        self_rating20 = Objects.requireNonNull(etself_rating20.getText().toString());
        self_assessment = Objects.requireNonNull(etself_assessment.getText().toString());


        if (TextUtils.isEmpty(Strategic_plan))
        {
            etstrategic_plan.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating14))
        {
            etself_rating14.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(socio_economic_impacts))
        {
            etsocio_economic_impacts.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating15))
        {
            etself_rating15.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(average_cost))
        {
            etavarage_cost.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating16))
        {
            etself_rating16.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(your_productivity))
        {
            etyour_productivity.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating17))
        {
            etself_rating17.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(starndardization_progress))
        {
            etstarndardization_progress.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating18))
        {
            etself_rating18.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(certificate_management))
        {
            etcertificate_management.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating19))
        {
            etself_rating19.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(corrected_non_conformities))
        {
            etcorrected_non_conformities.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating20))
        {
            etself_rating20.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(self_assessment))
        {
            etself_assessment.setError("Field Required");
            return;
        }
     /*   LicenceConformanceAssessmentBus licenceConformanceAssessmentBus = LicenceConformanceAssessmentBus.getInstance();

        LicenceConformanceAssessment licenceConformanceAssessment= new LicenceConformanceAssessment(
                0,
                licenceConformanceAssessmentBus.getDocument_number(),
                licenceConformanceAssessmentBus.getDocument_date(),
                licenceConformanceAssessmentBus.getLicence_number(),
                licenceConformanceAssessmentBus.getYear(),

                licenceConformanceAssessmentBus.getApplicant_profile(),
                licenceConformanceAssessmentBus.getSelf_score1(),
                licenceConformanceAssessmentBus.getPhysical_address(),
                licenceConformanceAssessmentBus.getSelf_score2(),
                licenceConformanceAssessmentBus.getDisclosure_of_profile(),
                licenceConformanceAssessmentBus.getSelf_score3(),
                licenceConformanceAssessmentBus.getLand_sources_of_util(),
                licenceConformanceAssessmentBus.getSelf_score4(),
                licenceConformanceAssessmentBus.getSugar_source(),
                licenceConformanceAssessmentBus.getSelf_score5(),
                licenceConformanceAssessmentBus.getSustainability(),
                licenceConformanceAssessmentBus.getSelf_score6(),
                licenceConformanceAssessmentBus.getCompliance_with_quality(),
                licenceConformanceAssessmentBus.getSelf_score7(),
                licenceConformanceAssessmentBus.getCompliance_with_legal_requirements(),
                licenceConformanceAssessmentBus.getSelf_score8(),
                licenceConformanceAssessmentBus.getNature_and_quality(),
                licenceConformanceAssessmentBus.getSelf_score9(),
                licenceConformanceAssessmentBus.getProduction_and_distribution(),
                licenceConformanceAssessmentBus.getSelf_score10(),

                licenceConformanceAssessmentBus.getOrganisation_changes(),
                licenceConformanceAssessmentBus.getSelf_rating1(),
                licenceConformanceAssessmentBus.getProject_boundary_changes(),
                licenceConformanceAssessmentBus.getSelf_rating2(),
                licenceConformanceAssessmentBus.getProject_changes_afecting_cane(),
                licenceConformanceAssessmentBus.getSelf_rating3(),
                licenceConformanceAssessmentBus.getManufacturing_assets_changes(),
                licenceConformanceAssessmentBus.getSelf_rating4(),
                licenceConformanceAssessmentBus.getTarget_and_achievements_variance(),
                licenceConformanceAssessmentBus.getSelf_rating5(),
                licenceConformanceAssessmentBus.getCane_production(),
                licenceConformanceAssessmentBus.getSelf_rating6(),

                licenceConformanceAssessmentBus.getConformed_with(),
                licenceConformanceAssessmentBus.getSelf_rating7(),
                licenceConformanceAssessmentBus.getEnvironmental_laws(),
                licenceConformanceAssessmentBus.getSelf_rating8(),
                licenceConformanceAssessmentBus.getCurrent_labour_laws(),
                licenceConformanceAssessmentBus.getSelf_rating9(),
                licenceConformanceAssessmentBus.getCurrent_tax_regulations(),
                licenceConformanceAssessmentBus.getSelf_rating10(),
                licenceConformanceAssessmentBus.getPublic_health_act(),
                licenceConformanceAssessmentBus.getSelf_rating11(),
                licenceConformanceAssessmentBus.getFood_and_drugs(),
                licenceConformanceAssessmentBus.getSelf_rating12(),
                licenceConformanceAssessmentBus.getOther_relevant_laws(),
                licenceConformanceAssessmentBus.getSelf_rating13(),

                licenceConformanceAssessmentBus.getStrategic_plan(),
                licenceConformanceAssessmentBus.getSelf_rating14(),
                licenceConformanceAssessmentBus.getSocio_economic_impacts(),
                licenceConformanceAssessmentBus.getSelf_rating15(),
                licenceConformanceAssessmentBus.getAverage_cost(),
                licenceConformanceAssessmentBus.getSelf_rating16(),
                licenceConformanceAssessmentBus.getYour_productivity(),
                licenceConformanceAssessmentBus.getSelf_rating17(),
                licenceConformanceAssessmentBus.getStarndardization_progress(),
                licenceConformanceAssessmentBus.getSelf_rating18(),
                licenceConformanceAssessmentBus.getCertificate_management(),
                licenceConformanceAssessmentBus.getSelf_rating19(),
                licenceConformanceAssessmentBus.getCorrected_non_conformities(),
                licenceConformanceAssessmentBus.getSelf_rating20(),
                licenceConformanceAssessmentBus.getSelf_assessment()
        );
//        caneCensusRecordViewModel.addRecord(caneCensus);
      Intent intent = new Intent(getActivity(), DashboardActivity.class);
        Objects.requireNonNull(getActivity()).finish();
        startActivity(intent);*/
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

