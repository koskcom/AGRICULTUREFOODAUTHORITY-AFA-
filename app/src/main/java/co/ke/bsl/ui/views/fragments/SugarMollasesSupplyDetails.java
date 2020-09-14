package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

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
public class SugarMollasesSupplyDetails extends Fragment implements BlockingStep
{
    @BindView(R.id.etnature_causes_of_wastage)
    CustomEditText etnature_causes_of_wastage;
    @BindView(R.id.chnature_causes_of_wastage)
    CheckBox chnature_causes_of_wastage;
    @BindView(R.id.etnature_causes_of_wastage_remarks)
    CustomEditText etnature_causes_of_wastage_remarks;
    @BindView(R.id.etcane_crushed_for_the_month)
    CustomEditText etcane_crushed_for_the_month;
    @BindView(R.id.chcane_crushed_for_the_month)
    CheckBox chcane_crushed_for_the_month;
    @BindView(R.id.etcane_crushed_for_the_month_remarks)
    CustomEditText etcane_crushed_for_the_month_remarks;
    @BindView(R.id.etcane_crushed_year_to_date)
    CustomEditText etcane_crushed_year_to_date;
    @BindView(R.id.chcane_crushed_year_to_date)
    CheckBox chcane_crushed_year_to_date;
    @BindView(R.id.etcane_crushed_year_to_date_remarks)
    CustomEditText etcane_crushed_year_to_date_remarks;
    @BindView(R.id.etsugar_made_for_the_month)
    CustomEditText etsugar_made_for_the_month;
    @BindView(R.id.chsugar_made_for_the_month)
    CheckBox chsugar_made_for_the_month;
    @BindView(R.id.etsugar_made_for_the_month_remarks)
    CustomEditText etsugar_made_for_the_month_remarks;
    @BindView(R.id.etsugar_made_year_to_date)
    CustomEditText etsugar_made_year_to_date;
    @BindView(R.id.chsugar_made_year_to_date)
    CheckBox chsugar_made_year_to_date;
    @BindView(R.id.etsugar_made_year_to_date_remarks)
    CustomEditText etsugar_made_year_to_date_remarks;
    @BindView(R.id.etfactory_rated_capacity)
    CustomEditText etfactory_rated_capacity;
    @BindView(R.id.chfactory_rated_capacity)
    CheckBox chfactory_rated_capacity;
    @BindView(R.id.etfactory_rated_capacity_remarks)
    CustomEditText etfactory_rated_capacity_remarks;
    @BindView(R.id.etfactory_actual_capacity)
    CustomEditText etfactory_actual_capacity;
    @BindView(R.id.chfactory_actual_capacity)
    CheckBox chfactory_actual_capacity;
    @BindView(R.id.etfactory_actual_capacity_remarks)
    CustomEditText etfactory_actual_capacity_remarks;


    private String nature_causes_of_wastage, chknature_causes_of_wastage, nature_causes_of_wastage_remarks,cane_crushed_for_the_month, chkcane_crushed_for_the_month, cane_crushed_for_the_month_remarks;

    private String cane_crushed_year_to_date, chkcane_crushed_year_to_date, cane_crushed_year_to_date_remarks, sugar_made_for_the_month, chksugar_made_for_the_month, sugar_made_for_the_month_remarks;

    private String sugar_made_year_to_date, chksugar_made_year_to_date, sugar_made_year_to_date_remarks, factory_rated_capacity, chkfactory_rated_capacity, factory_rated_capacity_remarks;

    private String factory_actual_capacity, chkfactory_actual_capacity, factory_actual_capacity_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sugar_mollases_supply_details, container, false);
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
        nature_causes_of_wastage = Objects.requireNonNull(etnature_causes_of_wastage.getText().toString());
        nature_causes_of_wastage_remarks = Objects.requireNonNull(etnature_causes_of_wastage_remarks.getText().toString());
        cane_crushed_for_the_month = Objects.requireNonNull(etcane_crushed_for_the_month.getText().toString());
        cane_crushed_for_the_month_remarks = Objects.requireNonNull(etcane_crushed_for_the_month_remarks.getText().toString());
        cane_crushed_year_to_date = Objects.requireNonNull(etcane_crushed_year_to_date.getText().toString());
        cane_crushed_year_to_date_remarks = Objects.requireNonNull(etcane_crushed_year_to_date_remarks.getText().toString());
        sugar_made_for_the_month = Objects.requireNonNull(etsugar_made_for_the_month.getText().toString());
        sugar_made_for_the_month_remarks = Objects.requireNonNull(etsugar_made_for_the_month_remarks.getText().toString());
        sugar_made_year_to_date = Objects.requireNonNull(etsugar_made_year_to_date.getText().toString());
        sugar_made_year_to_date_remarks = Objects.requireNonNull(etsugar_made_year_to_date_remarks.getText().toString());
        factory_rated_capacity = Objects.requireNonNull(etfactory_rated_capacity.getText().toString());
        factory_rated_capacity_remarks = Objects.requireNonNull(etfactory_rated_capacity_remarks.getText().toString());
        factory_actual_capacity = Objects.requireNonNull(etfactory_actual_capacity.getText().toString());
        factory_actual_capacity_remarks = Objects.requireNonNull(etfactory_actual_capacity_remarks.getText().toString());
/*
        SugarMolassesBus sugarMolassesBus = SugarMolassesBus.getInstance();
        sugarMolassesBus.setNature_causes_of_wastage(nature_causes_of_wastage);
        sugarMolassesBus.setNature_causes_of_wastage_remarks(nature_causes_of_wastage_remarks);
        sugarMolassesBus.setCane_crushed_for_the_month(cane_crushed_for_the_month);
        sugarMolassesBus.setCane_crushed_for_the_month_remarks(cane_crushed_for_the_month_remarks);
        sugarMolassesBus.setCane_crushed_year_to_date(cane_crushed_year_to_date);
        sugarMolassesBus.setCane_crushed_year_to_date_remarks(cane_crushed_year_to_date_remarks);
        sugarMolassesBus.setSugar_made_for_the_month(sugar_made_for_the_month);
        sugarMolassesBus.setSugar_made_for_the_month_remarks(sugar_made_for_the_month_remarks);
        sugarMolassesBus.setSugar_made_year_to_date(sugar_made_year_to_date);
        sugarMolassesBus.setSugar_made_year_to_date_remarks(sugar_made_year_to_date_remarks);
        sugarMolassesBus.setFactory_rated_capacity(factory_rated_capacity);
        sugarMolassesBus.setFactory_rated_capacity_remarks(factory_rated_capacity_remarks);
        sugarMolassesBus.setFactory_actual_capacity(factory_actual_capacity);
        sugarMolassesBus.setFactory_actual_capacity_remarks(factory_actual_capacity_remarks);

        caneCensusRecordViewModel.addRecord(caneCensus);*/

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

