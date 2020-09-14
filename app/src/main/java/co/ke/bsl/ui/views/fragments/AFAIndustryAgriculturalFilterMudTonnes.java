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
public class AFAIndustryAgriculturalFilterMudTonnes extends Fragment implements BlockingStep
{

    @BindView(R.id.etnucleous_estate)
    CustomEditText etnucleous_estate;
    @BindView(R.id.etoutgrowers)
    CustomEditText etoutgrowers;
    @BindView(R.id.ettotal)
    CustomEditText ettotal;
    @BindView(R.id.ettarget)
    CustomEditText ettarget;
    @BindView(R.id.etvariance)
    CustomEditText etvariance;
    @BindView(R.id.etfilter_mud_remarks)
    CustomEditText etfilter_mud_remarks;

    private String nucleaus_estate, outgrowers, total, target, variance, filter_muds_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindustry_agricultural_filter_mud_tonnes, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        nucleaus_estate = Objects.requireNonNull(etnucleous_estate.getText().toString());
        outgrowers = Objects.requireNonNull(etoutgrowers.getText().toString());
        total = Objects.requireNonNull(ettotal.getText().toString());
        target = Objects.requireNonNull(ettarget.getText().toString());
        variance = Objects.requireNonNull(etvariance.getText().toString());
        filter_muds_remarks = Objects.requireNonNull(etfilter_mud_remarks.getText().toString());


/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();
        industryAgriculturalProductionBus.setNucleaus_estate(nucleaus_estate);
        industryAgriculturalProductionBus.setOutgrowers(outgrowers);
        industryAgriculturalProductionBus.setTotal(total);
        industryAgriculturalProductionBus.setTarget(target);
        industryAgriculturalProductionBus.setVariance(variance);
        industryAgriculturalProductionBus.setFilter_muds_remarks(filter_muds_remarks);
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

