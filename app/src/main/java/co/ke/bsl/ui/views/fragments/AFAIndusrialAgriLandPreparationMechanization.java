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
public class AFAIndusrialAgriLandPreparationMechanization extends Fragment implements BlockingStep
{
    @BindView(R.id.ssland_pre_mechanization_operation)
    SearchableSpinner ssland_pre_mechanization_operation;
    @BindView(R.id.etno_units)
    CustomEditText etno_units;
    @BindView(R.id.etpower_rating)
    CustomEditText etpower_rating;
    @BindView(R.id.etland_pre_mechanization_remarks)
    CustomEditText etland_pre_mechanization_remarks;

    private  String land_pre_mechanization_operation, number_of_units, power_rating, land_pre_mechanization_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindusrial_agri_land_preparation_mechanization, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        //land_pre_mechanization_operation = Objects.requireNonNull(ssland_pre_mechanization_operation.getSelectedItem().toString());
        number_of_units = Objects.requireNonNull(etno_units.getText().toString());
        power_rating = Objects.requireNonNull(etpower_rating.getText().toString());
        land_pre_mechanization_remarks = Objects.requireNonNull(etland_pre_mechanization_remarks.getText().toString());
/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setLand_pre_mechanization_operation(land_pre_mechanization_operation);
        industryAgriculturalProductionBus.setNumber_of_units(number_of_units);
        industryAgriculturalProductionBus.setPower_rating(power_rating);
        industryAgriculturalProductionBus.setLand_pre_mechanization_remarks(land_pre_mechanization_remarks);
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


