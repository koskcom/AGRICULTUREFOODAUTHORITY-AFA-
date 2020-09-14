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
import co.ke.bsl.data.view.VarietyView;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAIndustrialAgriSeedCaneAvailability extends Fragment implements BlockingStep{

    @BindView(R.id.ssvariety)
    SearchableSpinner ssvariety;
    @BindView(R.id.etcane_availabiltity_surface)
    CustomEditText etcane_availabiltity_surface;
    @BindView(R.id.etcane_availability_age_m)
    CustomEditText etcane_availability_age_m;
    @BindView(R.id.etcane_availability_remarks)
    CustomEditText etcane_availability_remarks;

    private ArrayList<String> varietylist = new ArrayList<>();

    private String  cane_availabilty_variety, cane_availabilty_surface,cane_availabilty_age_m,cane_availabilty_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindustrial_agri_seed_cane_availability, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        setListvariety(getDummyVariety());

        ssvariety.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                cane_availabilty_variety = ssvariety.getSelectedItem().toString();
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
        cane_availabilty_variety = Objects.requireNonNull(ssvariety.getSelectedItem().toString());
        cane_availabilty_surface = Objects.requireNonNull(etcane_availabiltity_surface.getText().toString());
        cane_availabilty_age_m = Objects.requireNonNull(etcane_availability_age_m.getText().toString());
        cane_availabilty_remarks= Objects.requireNonNull(etcane_availability_remarks.getText().toString());
/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setCane_availabilty_variety(cane_availabilty_variety);
        industryAgriculturalProductionBus.setCane_availabilty_surface(cane_availabilty_surface);
        industryAgriculturalProductionBus.setCane_availabilty_age_m(cane_availabilty_age_m);
        industryAgriculturalProductionBus.setCane_availabilty_remarks(cane_availabilty_remarks);
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

