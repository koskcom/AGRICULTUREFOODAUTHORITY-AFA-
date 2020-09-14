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
public class AFAIndusrialAgriSeedRateTcHa extends Fragment implements BlockingStep
{
    @BindView(R.id.ssseed_rate_category)
    SearchableSpinner ssseed_rate_category;
    @BindView(R.id.etseed_rate_nucleaus_estate)
    CustomEditText etseed_rate_nucleaus_estate;
    @BindView(R.id.etseed_rate_outgrowers)
    CustomEditText etseed_rate_outgrowers;
    @BindView(R.id.etseed_rate_target)
    CustomEditText etseed_rate_target;
    @BindView(R.id.etseed_rate_remarks)
    CustomEditText etseed_rate_remarks;

    private String seed_rate_category, seed_rate_nucleous_estate, seed_rate_outgrowers, seed_rate_target, seed_rate_remarks;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindusrial_agri_seed_rate_tc_ha, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        //seed_rate_category = Objects.requireNonNull(ssseed_rate_category.getSelectedItem().toString());
        seed_rate_nucleous_estate = Objects.requireNonNull(etseed_rate_nucleaus_estate.getText().toString());
        seed_rate_outgrowers = Objects.requireNonNull(etseed_rate_outgrowers.getText().toString());
        seed_rate_target = Objects.requireNonNull(etseed_rate_target.getText().toString());
        seed_rate_remarks = Objects.requireNonNull(etseed_rate_remarks.getText().toString());
/*

        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setSeed_rate_category(seed_rate_category);
        industryAgriculturalProductionBus.setSeed_rate_nucleous_estate(seed_rate_nucleous_estate);
        industryAgriculturalProductionBus.setSeed_rate_outgrowers(seed_rate_outgrowers);
        industryAgriculturalProductionBus.setSeed_rate_target(seed_rate_target);
        industryAgriculturalProductionBus.setSeed_rate_remarks(seed_rate_remarks);
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

