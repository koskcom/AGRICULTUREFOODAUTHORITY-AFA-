package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
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
import co.ke.bsl.data.view.VarietyView;
import co.ke.bsl.pojo.City;
import co.ke.bsl.pojo.LoginService;
import co.ke.bsl.pojo.Survey;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFAIndustrialAgriCaneVarietiesCompositionHa extends Fragment implements BlockingStep
{

    @BindView(R.id.ssvariety)
    SearchableSpinner ssvariety;
    @BindView(R.id.etcane_varieties_outgrowers)
    CustomEditText etcane_varieties_outgrowers;
    @BindView(R.id.etcane_var_nucleaus_estate)
    CustomEditText etcane_var_nucleaus_estate;
    @BindView(R.id.etcane_variety_total)
    CustomEditText etcane_variety_total;

    protected List<City> countiesList;
    protected List<Survey> surveysList;
    protected List<String> subCountiesList;
    private AsyncActivitySupport asyncSupport;

    protected Handler asyncTaskHandler;
    LoginService loginService;


    private ArrayList<String> varietylist = new ArrayList<>();
    private String variety, cane_variety_outgrowers, cane_varieties_nucleous_estate, cane_varity_total;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindustrial_agri_cane_varieties_composition_ha, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        setListvariety(getDummyVariety());

        ssvariety.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                variety = ssvariety.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        return view;
    }

    private void setListvariety(List<VarietyView> dummyVariety)
    {
        varietylist.add("- Required -");
        for (VarietyView regionWrapper : dummyVariety)
        {
            varietylist.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, varietylist);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssvariety.setAdapter(regionAdapter);
    }

    private List<VarietyView> getDummyVariety()
    {
        List<VarietyView> listViewItems = new ArrayList<>();
        listViewItems.add(new VarietyView("Variety A"));
        listViewItems.add(new VarietyView("Variety B"));
        listViewItems.add(new VarietyView("Variety C"));
        listViewItems.add(new VarietyView("Variety D"));

        return listViewItems;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
//        variety = Objects.requireNonNull(ssvariety.getSelectedItem().toString());
        cane_variety_outgrowers = Objects.requireNonNull(etcane_varieties_outgrowers.getText().toString());
        cane_varieties_nucleous_estate = Objects.requireNonNull(etcane_var_nucleaus_estate.getText().toString());
        cane_varity_total = Objects.requireNonNull(etcane_variety_total.getText().toString());

/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setFertilizer_bags_activity(variety);
        industryAgriculturalProductionBus.setFertilizer_bags_type(cane_variety_outgrowers);
        industryAgriculturalProductionBus.setFertilizer_bags_nucleous_estate(cane_varieties_nucleous_estate);
        industryAgriculturalProductionBus.setFertilizer_bags_outgrowers(cane_varity_total);
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

