package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.data.view.ActivityView;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAIndustrialAgriLandPreparation extends Fragment implements BlockingStep
{

    @BindView(R.id.ssland_preparation_activity)
    SearchableSpinner ssland_preparation_activity;
    @BindView(R.id.etland_preparation_nucleaus_estate)
    CustomEditText etland_preparation_nucleaus_estate;
    @BindView(R.id.etland_preparation_outgrowers)
    CustomEditText etland_preparation_outgrowers;
    @BindView(R.id.etland_preparation_total)
    CustomEditText etland_preparation_total;
    @BindView(R.id.etland_preparation_target)
    CustomEditText etland_preparation_target;
    @BindView(R.id.etland_preparation_variance)
    CustomEditText etland_preparation_variance;
    @BindView(R.id.etland_preparation_remarks)
    CustomEditText etland_preparation_remarks;

    private ArrayList<String> activityList = new ArrayList<>();

    private String land_preparation_activity, land_preparation_nucleous_estate, land_preparation_outgrowers, land_preparation_total, land_preparation_target, land_preparation_variance, land_preparation_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindustrial_agri_land_preparation, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        setListactivity(getDummyactivity());

        ssland_preparation_activity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                land_preparation_activity = ssland_preparation_activity.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        return view;
    }

    private void setListactivity(List<ActivityView> dummyactivity)
    {

        activityList.add("- Required -");
        for (ActivityView regionWrapper : dummyactivity)
        {
            activityList.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, activityList);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssland_preparation_activity.setAdapter(regionAdapter);
    }

    private List<ActivityView> getDummyactivity() {
        List<ActivityView> listViewItems = new ArrayList<>();
        listViewItems.add(new ActivityView("Activity 1"));
        listViewItems.add(new ActivityView("Activity 1"));
        listViewItems.add(new ActivityView("Activity 1"));
        return listViewItems;
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        land_preparation_activity = Objects.requireNonNull(etland_preparation_nucleaus_estate.getText().toString());
        land_preparation_nucleous_estate = Objects.requireNonNull(etland_preparation_nucleaus_estate.getText().toString());
        land_preparation_outgrowers = Objects.requireNonNull(etland_preparation_outgrowers.getText().toString());
        land_preparation_total = Objects.requireNonNull(etland_preparation_total.getText().toString());
        land_preparation_target = Objects.requireNonNull(etland_preparation_target.getText().toString());
        land_preparation_variance = Objects.requireNonNull(etland_preparation_variance.getText().toString());
        land_preparation_remarks= Objects.requireNonNull(etland_preparation_remarks.getText().toString());

 /*       IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setLand_preparation_activity(land_preparation_activity);
        industryAgriculturalProductionBus.setLand_preparation_nucleous_estate(land_preparation_nucleous_estate);
        industryAgriculturalProductionBus.setLand_preparation_outgrowers(land_preparation_outgrowers);
        industryAgriculturalProductionBus.setLand_preparation_total(land_preparation_total);
        industryAgriculturalProductionBus.setLand_preparation_target(land_preparation_target);
        industryAgriculturalProductionBus.setLand_preparation_variance(land_preparation_variance);
        industryAgriculturalProductionBus.setLand_preparation_remarks(land_preparation_remarks);
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

