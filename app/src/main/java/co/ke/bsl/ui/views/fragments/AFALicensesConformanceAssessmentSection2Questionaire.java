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
public class AFALicensesConformanceAssessmentSection2Questionaire extends Fragment implements BlockingStep {

    @BindView(R.id.etorganisation_changes)
    CustomEditText etorganisation_changes;
    @BindView(R.id.etself_rating1)
    CustomEditText etself_rating1;
    @BindView(R.id.etproject_boundary_changes)
    CustomEditText etproject_boundary_changes;
    @BindView(R.id.etself_rating2)
    CustomEditText etself_rating2;
    @BindView(R.id.etproject_changes_afecting_cane)
    CustomEditText etproject_changes_afecting_cane;
    @BindView(R.id.etself_rating3)
    CustomEditText etself_rating3;
    @BindView(R.id.etmanufacturing_assets_changes)
    CustomEditText etmanufacturing_assets_changes;
    @BindView(R.id.etself_rating4)
    CustomEditText etself_rating4;
    @BindView(R.id.ettarget_and_achievements_variance)
    CustomEditText ettarget_and_achievements_variance;
    @BindView(R.id.etself_rating5)
    CustomEditText etself_rating5;
    @BindView(R.id.etcane_production)
    CustomEditText etcane_production;
    @BindView(R.id.etself_rating6)
    CustomEditText etself_rating6;

    private String organisation_changes, self_rating1, project_boundary_changes, self_rating2, project_changes_afecting_cane, self_rating3, manufacturing_assets_changes, self_rating4;

    private String target_and_achievements_variance, self_rating5, cane_production, self_rating6;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afalicenses_conformance_assessment_section2_questionaire, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        organisation_changes = Objects.requireNonNull(etorganisation_changes.getText().toString());
        self_rating1 = Objects.requireNonNull(etself_rating1.getText().toString());
        project_boundary_changes = Objects.requireNonNull(etproject_boundary_changes.getText().toString());
        self_rating2 = Objects.requireNonNull(etself_rating2.getText().toString());
        project_changes_afecting_cane= Objects.requireNonNull(etproject_changes_afecting_cane.getText().toString());
        self_rating3 = Objects.requireNonNull(etself_rating3.getText().toString());
        manufacturing_assets_changes = Objects.requireNonNull(etmanufacturing_assets_changes.getText().toString());
        self_rating4 = Objects.requireNonNull(etself_rating4.getText().toString());
        target_and_achievements_variance = Objects.requireNonNull(ettarget_and_achievements_variance.getText().toString());
        self_rating5 = Objects.requireNonNull(etself_rating5.getText().toString());
        cane_production = Objects.requireNonNull(etcane_production.getText().toString());
        self_rating6 = Objects.requireNonNull(etself_rating6.getText().toString());

        if (TextUtils.isEmpty(organisation_changes))
        {
            etorganisation_changes.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating1))
        {
            etself_rating1.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(project_boundary_changes))
        {
            etproject_boundary_changes.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating2))
        {
            etself_rating2.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(project_changes_afecting_cane))
        {
            etproject_changes_afecting_cane.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating3))
        {
            etself_rating3.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(manufacturing_assets_changes))
        {
            etmanufacturing_assets_changes.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating4))
        {
            etself_rating4.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(target_and_achievements_variance))
        {
            ettarget_and_achievements_variance.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating5))
        {
            etself_rating5.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(cane_production))
        {
            etcane_production.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating6))
        {
            etself_rating6.setError("Field Required");
            return;
        }
/*
        LicenceConformanceAssessmentBus licenceConformanceAssessmentBus = LicenceConformanceAssessmentBus.getInstance();

        licenceConformanceAssessmentBus.setOrganisation_changes(organisation_changes);
        licenceConformanceAssessmentBus.setSelf_rating1(self_rating1);
        licenceConformanceAssessmentBus.setProject_boundary_changes(project_boundary_changes);
        licenceConformanceAssessmentBus.setSelf_rating2(self_rating2);
        licenceConformanceAssessmentBus.setProject_changes_afecting_cane(project_changes_afecting_cane);
        licenceConformanceAssessmentBus.setSelf_rating3(self_rating3);
        licenceConformanceAssessmentBus.setManufacturing_assets_changes(manufacturing_assets_changes);
        licenceConformanceAssessmentBus.setSelf_rating4(self_rating4);
        licenceConformanceAssessmentBus.setTarget_and_achievements_variance(target_and_achievements_variance);
        licenceConformanceAssessmentBus.setSelf_rating5(self_rating5);
        licenceConformanceAssessmentBus.setCane_production(cane_production);
        licenceConformanceAssessmentBus.setSelf_rating6(self_rating6);
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

