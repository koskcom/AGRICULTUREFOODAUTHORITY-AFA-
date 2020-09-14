package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAIndusrialAgriRoadsRehabilitationAndMaintainance extends Fragment implements BlockingStep
{
    @BindView(R.id.ssrehabilitation_maintainance_operation)
    SearchableSpinner ssrehabilitation_maintainance_operation;
    @BindView(R.id.etrehabilitation_maintainance_nucleaus_estate)
    CustomEditText etrehabilitation_maintainance_nucleaus_estate;
    @BindView(R.id.etrehabilitation_maintainance_outgrowers)
    CustomEditText etrehabilitation_maintainance_outgrowers;
    @BindView(R.id.etrehabilitation_maintainance_total)
    CustomEditText etrehabilitation_maintainance_total;
    @BindView(R.id.etrehabilitation_maintainance_target)
    CustomEditText etrehabilitation_maintainance_target;


    private String rehabilitation_maintainance_operation, rehabilitation_maintainance_nucleous_estate, rehabilitation_maintainance_outgrowers, rehabilitation_maintainance_total,rehabilitation_maintainance_target;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindusrial_agri_roads_rehabilitation_and_maintainance, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback)
    {

        //rehabilitation_maintainance_operation = Objects.requireNonNull(ssrehabilitation_maintainance_operation.getSelectedItem().toString());
        rehabilitation_maintainance_nucleous_estate = Objects.requireNonNull(etrehabilitation_maintainance_nucleaus_estate.getText().toString());
        rehabilitation_maintainance_outgrowers = Objects.requireNonNull(etrehabilitation_maintainance_outgrowers.getText().toString());
        rehabilitation_maintainance_total = Objects.requireNonNull(etrehabilitation_maintainance_total.getText().toString());
        rehabilitation_maintainance_target = Objects.requireNonNull(etrehabilitation_maintainance_target.getText().toString());
/*

        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        IndustryAgriculturalProduction industryAgriculturalProduction= new IndustryAgriculturalProduction(
                0,
                industryAgriculturalProductionBus.getDocument_number(),
                industryAgriculturalProductionBus.getDocument_date(),
                industryAgriculturalProductionBus.getYear(),
                industryAgriculturalProductionBus.getMonth(),
                industryAgriculturalProductionBus.getSubLocation(),

                industryAgriculturalProductionBus.getNucleaus_estate(),
                industryAgriculturalProductionBus.getOutgrowers(),
                industryAgriculturalProductionBus.getTotal(),
                industryAgriculturalProductionBus.getTarget(),
                industryAgriculturalProductionBus.getVariance(),
                industryAgriculturalProductionBus.getFilter_muds_remarks(),

                industryAgriculturalProductionBus.getLime_nucleous_estate(),
                industryAgriculturalProductionBus.getLime_outgrowers(),
                industryAgriculturalProductionBus.getLime_total(),
                industryAgriculturalProductionBus.getLime_target(),
                industryAgriculturalProductionBus.getLime_variance(),
                industryAgriculturalProductionBus.getLime_tonnes_remarks(),

                industryAgriculturalProductionBus.getRainfall(),
                industryAgriculturalProductionBus.getLtm(),
                industryAgriculturalProductionBus.getMeteorological(),
                industryAgriculturalProductionBus.getMeteorological_variance(),
                industryAgriculturalProductionBus.getMeteorological_remarks(),

                industryAgriculturalProductionBus.getCounty(),
                industryAgriculturalProductionBus.getSub_county(),
                industryAgriculturalProductionBus.getArea_undercane(),
                industryAgriculturalProductionBus.getTotal_farmers(),
                industryAgriculturalProductionBus.getAverage_farm_size(),

                industryAgriculturalProductionBus.getSector(),
                industryAgriculturalProductionBus.getPc(),
                industryAgriculturalProductionBus.getR1(),
                industryAgriculturalProductionBus.getR2(),
                industryAgriculturalProductionBus.getR3(),
                industryAgriculturalProductionBus.getCrop_Cycle_Total(),
                industryAgriculturalProductionBus.getCrop_Cycle_Remarks(),

                industryAgriculturalProductionBus.getVariety(),
                industryAgriculturalProductionBus.getCane_variety_outgrowers(),
                industryAgriculturalProductionBus.getCane_varieties_nucleous_estate(),
                industryAgriculturalProductionBus.getCane_varity_total(),
                industryAgriculturalProductionBus.getAge(),
                industryAgriculturalProductionBus.getAge_analysis_outgrowers(),
                industryAgriculturalProductionBus.getAge_analysis_nucleaus_estate(),
                industryAgriculturalProductionBus.getAge_analysis_total(),

                industryAgriculturalProductionBus.getCategory(),
                industryAgriculturalProductionBus.getHarvestable_cane_outgrowers(),
                industryAgriculturalProductionBus.getHarvestable_cane_nucleous_estate(),
                industryAgriculturalProductionBus.getHarvestable_cane_total(),
                industryAgriculturalProductionBus.getHarvestable_cane_remarks(),

                industryAgriculturalProductionBus.getHarvestable_cane_deliveries_category(),
                industryAgriculturalProductionBus.getHarvestable_cane_deliveries_outgrowers(),
                industryAgriculturalProductionBus.getHarvestable_cane_deliveries_nucleous_estate(),
                industryAgriculturalProductionBus.getHarvestable_cane_deliveries_total(),
                industryAgriculturalProductionBus.getHarvestable_cane_deliveries_remarks(),

                industryAgriculturalProductionBus.getProjected_cane_month(),
                industryAgriculturalProductionBus.getProjected_cane_surface_ha(),
                industryAgriculturalProductionBus.getProjected_cane_tonnes(),
                industryAgriculturalProductionBus.getProjected_cane_age_m(),
                industryAgriculturalProductionBus.getProjected_cane_tch(),
                industryAgriculturalProductionBus.getProjected_cane_remarks(),

                industryAgriculturalProductionBus.getFertilizer_bags_activity(),
                industryAgriculturalProductionBus.getFertilizer_bags_type(),
                industryAgriculturalProductionBus.getFertilizer_bags_nucleous_estate(),
                industryAgriculturalProductionBus.getFertilizer_bags_outgrowers(),
                industryAgriculturalProductionBus.getFertilizer_bags_total(),
                industryAgriculturalProductionBus.getFertilizer_bags_target(),
                industryAgriculturalProductionBus.getFertilizer_bags_variance(),
                industryAgriculturalProductionBus.getFertilizer_bags_remarks(),

                industryAgriculturalProductionBus.getHerbicides_stage(),
                industryAgriculturalProductionBus.getHerbicides_type(),
                industryAgriculturalProductionBus.getHerbicides_nucleous_estate(),
                industryAgriculturalProductionBus.getHerbicides_outgrowers(),
                industryAgriculturalProductionBus.getTotal(),
                industryAgriculturalProductionBus.getVariance(),
                industryAgriculturalProductionBus.getHerbicides_remarks(),

                industryAgriculturalProductionBus.getCane_availabilty_variety(),
                industryAgriculturalProductionBus.getCane_availabilty_surface(),
                industryAgriculturalProductionBus.getCane_availabilty_age_m(),
                industryAgriculturalProductionBus.getCane_availabilty_remarks(),

                industryAgriculturalProductionBus.getLand_preparation_activity(),
                industryAgriculturalProductionBus.getLand_preparation_nucleous_estate(),
                industryAgriculturalProductionBus.getLand_preparation_outgrowers(),
                industryAgriculturalProductionBus.getLand_preparation_total(),
                industryAgriculturalProductionBus.getLand_preparation_target(),
                industryAgriculturalProductionBus.getLand_preparation_variance(),
                industryAgriculturalProductionBus.getLand_preparation_remarks(),

                industryAgriculturalProductionBus.getCane_planting_type(),
                industryAgriculturalProductionBus.getCane_planting_nucleous_estate(),
                industryAgriculturalProductionBus.getCane_planting_outgrowers(),
                industryAgriculturalProductionBus.getCane_planting_total(),
                industryAgriculturalProductionBus.getCane_planting_target(),

                industryAgriculturalProductionBus.getVarieties_planted_variety(),
                industryAgriculturalProductionBus.getVarieties_planted_nucleous_estate(),
                industryAgriculturalProductionBus.getVarieties_planted_outgrowers(),
                industryAgriculturalProductionBus.getVarieties_planted_total(),
                industryAgriculturalProductionBus.getVarieties_planted_target(),

                industryAgriculturalProductionBus.getSeed_rate_category(),
                industryAgriculturalProductionBus.getSeed_rate_nucleous_estate(),
                industryAgriculturalProductionBus.getSeed_rate_outgrowers(),
                industryAgriculturalProductionBus.getSeed_rate_target(),
                industryAgriculturalProductionBus.getSeed_rate_remarks(),

                industryAgriculturalProductionBus.getLand_pre_mechanization_operation(),
                industryAgriculturalProductionBus.getNumber_of_units(),
                industryAgriculturalProductionBus.getPower_rating(),
                industryAgriculturalProductionBus.getLand_pre_mechanization_remarks(),

                industryAgriculturalProductionBus.getCane_haulage_operation(),
                industryAgriculturalProductionBus.getCane_haulage_no_units(),
                industryAgriculturalProductionBus.getCane_haulage_power_rating(),
                industryAgriculturalProductionBus.getCane_haulage_remarks(),

                industryAgriculturalProductionBus.getRoads_machinery_operation(),
                industryAgriculturalProductionBus.getRoads_machinery_no_of_units(),
                industryAgriculturalProductionBus.getRoads_machinery_power_rating(),
                industryAgriculturalProductionBus.getRoads_machinery_remarks(),

                industryAgriculturalProductionBus.getRehabilitation_maintainance_operation(),
                industryAgriculturalProductionBus.getRehabilitation_maintainance_nucleous_estate(),
                industryAgriculturalProductionBus.getRehabilitation_maintainance_outgrowers(),
                industryAgriculturalProductionBus.getRehabilitation_maintainance_total(),
                industryAgriculturalProductionBus.getRehabilitation_maintainance_target(),
                false,
                ""

        );*/

//        caneCensusRecordViewModel.addRecord(caneCensus);
      Intent intent = new Intent(getActivity(), DashboardActivity.class);
        Objects.requireNonNull(getActivity()).finish();
        startActivity(intent);

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


