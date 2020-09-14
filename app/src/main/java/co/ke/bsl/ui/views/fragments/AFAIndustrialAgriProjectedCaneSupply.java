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
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.MonthView;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAIndustrialAgriProjectedCaneSupply extends Fragment implements BlockingStep
{

    @BindView(R.id.ssprojected_cane_month)
    SearchableSpinner ssprojected_cane_month;
    @BindView(R.id.etsurface_ha)
    CustomEditText etsurface_ha;
    @BindView(R.id.etprojected_cane_tonnes)
    CustomEditText etprojected_cane_tonnes;
    @BindView(R.id.etprojected_cane_age_m)
    CustomEditText etprojected_cane_age_m;
    @BindView(R.id.etprojected_cane_tch)
    CustomEditText etprojected_cane_tch;
    @BindView(R.id.etprojected_cane_remarks)
    CustomEditText etprojected_cane_remarks;

    AFADatabaseAdapter db;
    private ArrayList<String> yearList = new ArrayList<>();
    private ArrayList<String> monthList = new ArrayList<>();

    private String projected_cane_month,projected_cane_surface_ha, projected_cane_tonnes, projected_cane_age_m, projected_cane_tch, projected_cane_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindustrial_agri_projected_cane_supply, container, false);
        ButterKnife.bind(this, view);


        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();



        setListmonth(getDummymonth());

        ssprojected_cane_month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                projected_cane_month = ssprojected_cane_month.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        return view;
    }

    private void setListmonth(List<MonthView> dummymonth)
    {

        monthList.add("- Required -");
        for (MonthView regionWrapper : dummymonth)
        {
            monthList.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, monthList);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssprojected_cane_month.setAdapter(regionAdapter);
    }

    private List<MonthView> getDummymonth() {
        List<MonthView> listViewItems = new ArrayList<>();
        listViewItems.add(new MonthView("January"));
        listViewItems.add(new MonthView("February"));
        listViewItems.add(new MonthView("March"));
        listViewItems.add(new MonthView("April"));
        listViewItems.add(new MonthView("May"));
        listViewItems.add(new MonthView("June"));
        listViewItems.add(new MonthView("July"));
        listViewItems.add(new MonthView("August"));
        listViewItems.add(new MonthView("September"));
        listViewItems.add(new MonthView("October"));
        listViewItems.add(new MonthView("November"));
        listViewItems.add(new MonthView("December"));
        return listViewItems;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {

        projected_cane_surface_ha = Objects.requireNonNull(etsurface_ha.getText().toString());
        projected_cane_tonnes = Objects.requireNonNull(etprojected_cane_tonnes.getText().toString());
        projected_cane_age_m = Objects.requireNonNull(etprojected_cane_age_m.getText().toString());
        projected_cane_tch= Objects.requireNonNull(etprojected_cane_tch.getText().toString());
        projected_cane_remarks= Objects.requireNonNull(etprojected_cane_remarks.getText().toString());
/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setProjected_cane_surface_ha(projected_cane_surface_ha);
        industryAgriculturalProductionBus.setProjected_cane_tonnes(projected_cane_tonnes);
        industryAgriculturalProductionBus.setProjected_cane_age_m(projected_cane_age_m);
        industryAgriculturalProductionBus.setProjected_cane_tch(projected_cane_tch);
        industryAgriculturalProductionBus.setProjected_cane_remarks(projected_cane_remarks);
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

