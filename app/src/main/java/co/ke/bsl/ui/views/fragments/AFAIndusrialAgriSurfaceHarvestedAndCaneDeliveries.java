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
public class AFAIndusrialAgriSurfaceHarvestedAndCaneDeliveries extends Fragment implements BlockingStep
{
    @BindView(R.id.ssharvestable_cane_deliveries_category)
    SearchableSpinner ssharvestable_cane_deliveries_category;
    @BindView(R.id.etharvestable_cane_deliverie_outgrowers)
    CustomEditText etharvestable_cane_deliverie_outgrowers;
    @BindView(R.id.etharvestable_cane_deliverie_nucleaus_estate)
    CustomEditText etharvestable_cane_deliverie_nucleaus_estate;
    @BindView(R.id.etharvestable_cane_deliverie_total)
    CustomEditText etharvestable_cane_deliverie_total;
    @BindView(R.id.etharvestable_cane_deliverie_remarks)
    CustomEditText etharvestable_cane_deliverie_remarks;

    private  String harvestable_cane_deliveries_category, harvestable_cane_deliveries_outgrowers, harvestable_cane_deliveries_nucleous_estate, harvestable_cane_deliveries_total, harvestable_cane_deliveries_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindusrial_agri_surface_harvested_and_cane_deliveries, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
       // harvestable_cane_deliveries_category = Objects.requireNonNull(ssharvestable_cane_deliveries_category.getSelectedItem().toString());
        harvestable_cane_deliveries_outgrowers = Objects.requireNonNull(etharvestable_cane_deliverie_outgrowers.getText().toString());
        harvestable_cane_deliveries_nucleous_estate = Objects.requireNonNull(etharvestable_cane_deliverie_nucleaus_estate.getText().toString());
        harvestable_cane_deliveries_total = Objects.requireNonNull(etharvestable_cane_deliverie_total.getText().toString());
        harvestable_cane_deliveries_remarks = Objects.requireNonNull(etharvestable_cane_deliverie_remarks.getText().toString());
/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setHarvestable_cane_deliveries_category(harvestable_cane_deliveries_category);
        industryAgriculturalProductionBus.setHarvestable_cane_deliveries_outgrowers(harvestable_cane_deliveries_outgrowers);
        industryAgriculturalProductionBus.setHarvestable_cane_deliveries_nucleous_estate(harvestable_cane_deliveries_nucleous_estate);
        industryAgriculturalProductionBus.setHarvestable_cane_deliveries_total(harvestable_cane_deliveries_total);
        industryAgriculturalProductionBus.setHarvestable_cane_deliveries_remarks(harvestable_cane_deliveries_remarks);
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

