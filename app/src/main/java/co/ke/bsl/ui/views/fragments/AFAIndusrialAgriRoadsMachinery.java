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
public class AFAIndusrialAgriRoadsMachinery extends Fragment implements BlockingStep
{
    @BindView(R.id.ssroads_machinery_operation)
    SearchableSpinner ssroads_machinery_operation;
    @BindView(R.id.etroads_machinery_no_units)
    CustomEditText etroads_machinery_no_units;
    @BindView(R.id.etroads_machinery_power_rating)
    CustomEditText etroads_machinery_power_rating;
    @BindView(R.id.etroads_machinery_remarks)
    CustomEditText etroads_machinery_remarks;

    private String roads_machinery_operation, roads_machinery_no_of_units, roads_machinery_power_rating, roads_machinery_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindusrial_agri_roads_machinery, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
       // roads_machinery_operation = Objects.requireNonNull(ssroads_machinery_operation.getSelectedItem().toString());
        roads_machinery_no_of_units = Objects.requireNonNull(etroads_machinery_no_units.getText().toString());
        roads_machinery_power_rating = Objects.requireNonNull(etroads_machinery_power_rating.getText().toString());
        roads_machinery_remarks = Objects.requireNonNull(etroads_machinery_remarks.getText().toString());
/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setRoads_machinery_operation(roads_machinery_operation);
        industryAgriculturalProductionBus.setRoads_machinery_no_of_units(roads_machinery_no_of_units);
        industryAgriculturalProductionBus.setRoads_machinery_power_rating(roads_machinery_power_rating);
        industryAgriculturalProductionBus.setRoads_machinery_remarks(roads_machinery_remarks);
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


