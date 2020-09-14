package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
public class AFAIndustryAgriculturalLimeTonnes extends Fragment implements BlockingStep
{

    @BindView(R.id.etlimenucleous_estate)
    CustomEditText etlimenucleous_estate;
    @BindView(R.id.etlime_outgrowers)
    CustomEditText etlime_outgrowers;
    @BindView(R.id.etlime_total)
    CustomEditText etlime_total;
    @BindView(R.id.etlime_target)
    CustomEditText etlime_target;
    @BindView(R.id.etlimevariance)
    CustomEditText etlimevariance;
    @BindView(R.id.etlime_tonnes_remarks)
    CustomEditText etlime_tonnes_remarks;

    private String lime_nucleous_estate, lime_outgrowers, lime_total, lime_target, lime_variance, lime_tonnes_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindustry_agricultural_lime_tonnes, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        lime_nucleous_estate = Objects.requireNonNull(etlimenucleous_estate.getText().toString());
        lime_outgrowers= Objects.requireNonNull(etlime_outgrowers.getText().toString());
        lime_total = Objects.requireNonNull(etlime_total.getText().toString());
        lime_target= Objects.requireNonNull(etlime_target.getText().toString());
        lime_variance = Objects.requireNonNull(etlimevariance.getText().toString());
        lime_tonnes_remarks= Objects.requireNonNull(etlime_tonnes_remarks.getText().toString());
/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();
        industryAgriculturalProductionBus.setLime_nucleous_estate(lime_nucleous_estate);
        industryAgriculturalProductionBus.setLime_outgrowers(lime_outgrowers);
        industryAgriculturalProductionBus.setLime_total(lime_total);
        industryAgriculturalProductionBus.setLime_target(lime_target);
        industryAgriculturalProductionBus.setLime_variance(lime_variance);
        industryAgriculturalProductionBus.setLime_tonnes_remarks(lime_tonnes_remarks);
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

