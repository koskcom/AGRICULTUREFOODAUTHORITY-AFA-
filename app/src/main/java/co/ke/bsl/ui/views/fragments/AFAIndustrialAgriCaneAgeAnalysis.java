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
import co.ke.bsl.data.view.AgeMView;
import co.ke.bsl.util.CustomEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFAIndustrialAgriCaneAgeAnalysis extends Fragment implements BlockingStep
{
    @BindView(R.id.ssage)
    SearchableSpinner ssage;
    @BindView(R.id.etage_analysis_outgrowers)
    CustomEditText etage_analysis_outgrowers;
    @BindView(R.id.etage_analysis_nucleaus_estate)
    CustomEditText etage_analysis_nucleaus_estate;
    @BindView(R.id.etage_analysis_total)
    CustomEditText etage_analysis_total;

    private ArrayList<String> ageMlist = new ArrayList<>();
    private String age, age_analysis_outgrowers,age_analysis_nucleaus_estate,age_analysis_total;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindustrial_agri_cane_age_analysis, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        setListagem(getDummyagem());

        ssage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                age = ssage.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        return view;
    }
    private void setListagem(List<AgeMView> dummyagem)
    {
        ageMlist.add("- Required -");
        for (AgeMView regionWrapper : dummyagem)
        {
            ageMlist.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, ageMlist);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssage.setAdapter(regionAdapter);
    }

    private List<AgeMView> getDummyagem()
    {
        List<AgeMView> listViewItems = new ArrayList<>();
        listViewItems.add(new AgeMView("Age A"));
        listViewItems.add(new AgeMView("Age B"));
        return listViewItems;
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        age = Objects.requireNonNull(ssage.getSelectedItem().toString());
        age_analysis_outgrowers = Objects.requireNonNull(etage_analysis_outgrowers.getText().toString());
        age_analysis_nucleaus_estate = Objects.requireNonNull(etage_analysis_nucleaus_estate.getText().toString());
        age_analysis_total = Objects.requireNonNull(etage_analysis_total.getText().toString());

/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setAge(age);
        industryAgriculturalProductionBus.setAge_analysis_outgrowers(age_analysis_outgrowers);
        industryAgriculturalProductionBus.setAge_analysis_nucleaus_estate(age_analysis_nucleaus_estate);
        industryAgriculturalProductionBus.setAge_analysis_total(age_analysis_total);
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

