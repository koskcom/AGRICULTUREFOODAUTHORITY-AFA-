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
public class AFAIndusrialAgriVarietiesPlanted extends Fragment implements BlockingStep
{
    @BindView(R.id.ssvarieties_planted_variety)
    SearchableSpinner ssvarieties_planted_variety;
    @BindView(R.id.etvarieties_planted_nucleaus_estate)
    CustomEditText etvarieties_planted_nucleaus_estate;
    @BindView(R.id.etvarieties_planted_outgrowers)
    CustomEditText etvarieties_planted_outgrowers;
    @BindView(R.id.etvarieties_planted_total)
    CustomEditText etvarieties_planted_total;
    @BindView(R.id.etvarieties_planted_target)
    CustomEditText etvarieties_planted_target;


    private String varieties_planted_variety, varieties_planted_nucleous_estate, varieties_planted_outgrowers,varieties_planted_total, varieties_planted_target;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_afaindusrial_agri_varieties_planted, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
       // varieties_planted_variety = Objects.requireNonNull(ssvarieties_planted_variety.getSelectedItem().toString());
        varieties_planted_nucleous_estate = Objects.requireNonNull(etvarieties_planted_nucleaus_estate.getText().toString());
        varieties_planted_outgrowers = Objects.requireNonNull(etvarieties_planted_outgrowers.getText().toString());
        varieties_planted_total = Objects.requireNonNull(etvarieties_planted_total.getText().toString());
        varieties_planted_target = Objects.requireNonNull(etvarieties_planted_target.getText().toString());
/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setVarieties_planted_variety(varieties_planted_variety);
        industryAgriculturalProductionBus.setVarieties_planted_nucleous_estate(varieties_planted_nucleous_estate);
        industryAgriculturalProductionBus.setVarieties_planted_outgrowers(varieties_planted_outgrowers);
        industryAgriculturalProductionBus.setVarieties_planted_total(varieties_planted_total);
        industryAgriculturalProductionBus.setVarieties_planted_target(varieties_planted_target);
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

