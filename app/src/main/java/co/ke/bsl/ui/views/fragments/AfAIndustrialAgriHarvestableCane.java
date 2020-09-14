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
public class AfAIndustrialAgriHarvestableCane extends Fragment implements BlockingStep
{

    @BindView(R.id.sscategory)
    SearchableSpinner sscategory;
    @BindView(R.id.etharvestable_cane_outgrowers)
    CustomEditText etharvestable_cane_outgrowers;
    @BindView(R.id.etharvestable_cane_nucleaus_estate)
    CustomEditText etharvestable_cane_nucleaus_estate;
    @BindView(R.id.etharvestable_cane_total)
    CustomEditText etharvestable_cane_total;
    @BindView(R.id.etharvestable_cane_remarks)
    CustomEditText etharvestable_cane_remarks;

    private String category, harvestable_cane_outgrowers, harvestable_cane_nucleous_estate, harvestable_cane_total, harvestable_cane_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_af_aindustrial_agri_harvestable_cane, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        harvestable_cane_outgrowers= Objects.requireNonNull(etharvestable_cane_outgrowers.getText().toString());
        harvestable_cane_nucleous_estate = Objects.requireNonNull(etharvestable_cane_nucleaus_estate.getText().toString());
        harvestable_cane_total = Objects.requireNonNull(etharvestable_cane_total.getText().toString());
        harvestable_cane_remarks = Objects.requireNonNull(etharvestable_cane_remarks.getText().toString());

/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setHarvestable_cane_outgrowers(harvestable_cane_outgrowers);
        industryAgriculturalProductionBus.setHarvestable_cane_nucleous_estate(harvestable_cane_nucleous_estate);
        industryAgriculturalProductionBus.setHarvestable_cane_total(harvestable_cane_total);
        industryAgriculturalProductionBus.setHarvestable_cane_remarks(harvestable_cane_remarks);
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

