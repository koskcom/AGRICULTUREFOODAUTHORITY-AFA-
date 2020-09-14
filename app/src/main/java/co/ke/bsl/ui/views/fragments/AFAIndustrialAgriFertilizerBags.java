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
public class AFAIndustrialAgriFertilizerBags extends Fragment implements BlockingStep
{

    @BindView(R.id.ssfertilizer_bags_activity)
    SearchableSpinner ssfertilizer_bags_activity;
    @BindView(R.id.ssfertilizer_bags_type)
    SearchableSpinner ssfertilizer_bags_type;
    @BindView(R.id.etfertilizer_bags_nucleaus_estate)
    CustomEditText etfertilizer_bags_nucleaus_estate;
    @BindView(R.id.etfertilizer_bags_outgrowers)
    CustomEditText etfertilizer_bags_outgrowers;
    @BindView(R.id.etfertilizer_bags_total)
    CustomEditText etfertilizer_bags_total;
    @BindView(R.id.etfertilizer_bags_target)
    CustomEditText etfertilizer_bags_target;
    @BindView(R.id.etfertilizer_bags_variance)
    CustomEditText etfertilizer_bags_variance;
    @BindView(R.id.etfertilizer_bags_remarks)
    CustomEditText etfertilizer_bags_remarks;

    private String fertilizer_bags_activity, fertilizer_bags_type, fertilizer_bags_nucleous_estate, fertilizer_bags_outgrowers, fertilizer_bags_total,fertilizer_bags_target,fertilizer_bags_variance,fertilizer_bags_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindustrial_agri_fertilizer_bags, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        //fertilizer_bags_activity = Objects.requireNonNull(ssfertilizer_bags_activity.getSelectedItem().toString());
        //fertilizer_bags_type = Objects.requireNonNull(ssfertilizer_bags_type.getSelectedItem().toString());
        fertilizer_bags_nucleous_estate= Objects.requireNonNull(etfertilizer_bags_nucleaus_estate.getText().toString());
        fertilizer_bags_outgrowers = Objects.requireNonNull(etfertilizer_bags_outgrowers.getText().toString());
        fertilizer_bags_total = Objects.requireNonNull(etfertilizer_bags_total.getText().toString());
        fertilizer_bags_target = Objects.requireNonNull(etfertilizer_bags_target.getText().toString());
        fertilizer_bags_variance = Objects.requireNonNull(etfertilizer_bags_variance.getText().toString());
        fertilizer_bags_remarks = Objects.requireNonNull(etfertilizer_bags_remarks.getText().toString());

/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setFertilizer_bags_activity(fertilizer_bags_activity);
        industryAgriculturalProductionBus.setFertilizer_bags_type(fertilizer_bags_type);
        industryAgriculturalProductionBus.setFertilizer_bags_nucleous_estate(fertilizer_bags_nucleous_estate);
        industryAgriculturalProductionBus.setFertilizer_bags_outgrowers(fertilizer_bags_outgrowers);
        industryAgriculturalProductionBus.setFertilizer_bags_total(fertilizer_bags_total);
        industryAgriculturalProductionBus.setFertilizer_bags_target(fertilizer_bags_target);
        industryAgriculturalProductionBus.setFertilizer_bags_variance(fertilizer_bags_variance);
        industryAgriculturalProductionBus.setFertilizer_bags_remarks(fertilizer_bags_remarks);
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

