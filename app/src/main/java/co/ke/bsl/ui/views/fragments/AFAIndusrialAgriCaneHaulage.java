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
public class AFAIndusrialAgriCaneHaulage extends Fragment  implements BlockingStep
{
    @BindView(R.id.sscane_haulage_operation)
    SearchableSpinner sscane_haulage_operation;
    @BindView(R.id.etcane_haulage_no_units)
    CustomEditText etcane_haulage_no_units;
    @BindView(R.id.etcane_haulage_power_rating)
    CustomEditText etcane_haulage_power_rating;
    @BindView(R.id.etcane_haulage_remarks)
    CustomEditText etcane_haulage_remarks;

    private String cane_haulage_operation, cane_haulage_no_units, cane_haulage_power_rating, cane_haulage_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindusrial_agri_cane_haulage, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        //cane_haulage_operation = Objects.requireNonNull(sscane_haulage_operation.getSelectedItem().toString());
        cane_haulage_no_units = Objects.requireNonNull(etcane_haulage_no_units.getText().toString());
        cane_haulage_power_rating = Objects.requireNonNull(etcane_haulage_power_rating.getText().toString());
        cane_haulage_remarks = Objects.requireNonNull(etcane_haulage_remarks.getText().toString());
/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setCane_haulage_operation(cane_haulage_operation);
        industryAgriculturalProductionBus.setCane_haulage_no_units(cane_haulage_no_units);
        industryAgriculturalProductionBus.setCane_haulage_power_rating(cane_haulage_power_rating);
        industryAgriculturalProductionBus.setCane_haulage_remarks(cane_haulage_remarks);
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


