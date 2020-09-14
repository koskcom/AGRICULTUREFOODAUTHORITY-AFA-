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


public class AFAIndustrialAgriCanePlanting extends Fragment implements BlockingStep {

    @BindView(R.id.sscane_planting_type)
    SearchableSpinner sscane_planting_type;
    @BindView(R.id.etcane_planting_nucleaus_estate)
    CustomEditText etcane_planting_nucleaus_estate;
    @BindView(R.id.etcane_planting_outgrowers)
    CustomEditText etcane_planting_outgrowers;
    @BindView(R.id.etcane_planting_total)
    CustomEditText etcane_planting_total;
    @BindView(R.id.etcane_planting_target)
    CustomEditText etcane_planting_target;

    private  String cane_planting_type, cane_planting_nucleous_estate, cane_planting_outgrowers, cane_planting_total, cane_planting_target;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindustrial_agri_cane_planting, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        //cane_planting_type = Objects.requireNonNull(sscane_planting_type.getSelectedItem().toString());
        cane_planting_nucleous_estate = Objects.requireNonNull(etcane_planting_nucleaus_estate.getText().toString());
        cane_planting_outgrowers = Objects.requireNonNull(etcane_planting_outgrowers.getText().toString());
        cane_planting_total = Objects.requireNonNull(etcane_planting_total.getText().toString());
        cane_planting_target = Objects.requireNonNull(etcane_planting_target.getText().toString());
/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setCane_planting_type(cane_planting_type);
        industryAgriculturalProductionBus.setCane_planting_nucleous_estate(cane_planting_nucleous_estate);
        industryAgriculturalProductionBus.setCane_planting_outgrowers(cane_planting_outgrowers);
        industryAgriculturalProductionBus.setCane_planting_total(cane_planting_total);
        industryAgriculturalProductionBus.setCane_planting_target(cane_planting_target);
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

