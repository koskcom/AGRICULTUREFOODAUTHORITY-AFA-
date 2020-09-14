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
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAIndustrialAgriHerbicidesLtsKg extends Fragment implements BlockingStep
{
    @BindView(R.id.ssherbicides_stage)
    SearchableSpinner ssherbicides_stage;
    @BindView(R.id.ssherbicides_type)
    SearchableSpinner ssherbicides_type;
    @BindView(R.id.etherbicides_nucleaus_estate)
    CustomEditText etherbicides_nucleaus_estate;
    @BindView(R.id.etherbicides_outgrowers)
    CustomEditText etherbicides_outgrowers;
    @BindView(R.id.etherbicides_total)
    CustomEditText etherbicides_total;
    @BindView(R.id.etherbicides_variance)
    CustomEditText etherbicides_variance;
    @BindView(R.id.etherbicides_remarks)
    CustomEditText etherbicides_remarks;

    private String herbicides_stage,herbicides_type,herbicides_nucleous_estate, herbicides_outgrowers, herbicides_total, herbicides_variance,herbicides_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindustrial_agri_herbicides_lts_kg, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        herbicides_nucleous_estate = Objects.requireNonNull(etherbicides_nucleaus_estate.getText().toString());
        herbicides_outgrowers = Objects.requireNonNull(etherbicides_outgrowers.getText().toString());
        herbicides_total= Objects.requireNonNull(etherbicides_total.getText().toString());
        herbicides_variance = Objects.requireNonNull(etherbicides_variance.getText().toString());
        herbicides_remarks = Objects.requireNonNull(etherbicides_remarks.getText().toString());

/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setHerbicides_nucleous_estate(herbicides_nucleous_estate);
        industryAgriculturalProductionBus.setHerbicides_outgrowers(herbicides_outgrowers);
        industryAgriculturalProductionBus.setHerbicides_total(herbicides_total);
        industryAgriculturalProductionBus.setHerbicides_variance(herbicides_variance);
        industryAgriculturalProductionBus.setHerbicides_remarks(herbicides_remarks);
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

