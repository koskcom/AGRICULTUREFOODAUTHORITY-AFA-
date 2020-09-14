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
public class AFAIndustrialAgroMeteorologicalDataCentralMetStation extends Fragment implements BlockingStep
{
    @BindView(R.id.etrainfall)
    CustomEditText etrainfall;
    @BindView(R.id.etltm)
    CustomEditText etltm;
    @BindView(R.id.etmeteorological_total)
    CustomEditText etmeteorological_total;
    @BindView(R.id.etmeteorological_variance)
    CustomEditText etmeteorological_variance;
    @BindView(R.id.etmeteorological_remarks)
    CustomEditText etmeteorological_remarks;

    private String rainfall, ltm, meteorological_total, meteorological_variance, meteorological_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaagro_meteorological_data_central_met_station, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        rainfall = Objects.requireNonNull(etrainfall.getText().toString());
        ltm = Objects.requireNonNull(etltm.getText().toString());
        meteorological_total = Objects.requireNonNull(etmeteorological_total.getText().toString());
        meteorological_variance = Objects.requireNonNull(etmeteorological_variance.getText().toString());
        meteorological_remarks = Objects.requireNonNull(etmeteorological_remarks.getText().toString());
/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();
        industryAgriculturalProductionBus.setRainfall(rainfall);
        industryAgriculturalProductionBus.setLtm(ltm);
        industryAgriculturalProductionBus.setMeteorological(meteorological_total);
        industryAgriculturalProductionBus.setMeteorological_variance(meteorological_variance);
        industryAgriculturalProductionBus.setMeteorological_remarks(meteorological_remarks);
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

