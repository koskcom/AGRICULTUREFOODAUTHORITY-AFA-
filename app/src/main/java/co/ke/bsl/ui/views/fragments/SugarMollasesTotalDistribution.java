package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.util.CustomEditText;

public class SugarMollasesTotalDistribution extends Fragment implements BlockingStep
{
    @BindView(R.id.etsugar_total_distribution_this_month)
    CustomEditText etsugar_total_distribution_this_month;
    @BindView(R.id.chsugar_total_distribution_this_month)
    CheckBox chsugar_total_distribution_this_month;
    @BindView(R.id.etsugar_total_distribution_this_month_remarks)
    CustomEditText etsugar_total_distribution_this_month_remarks;
    @BindView(R.id.etsugar_total_distribution_year_to_date)
    CustomEditText etsugar_total_distribution_year_to_date;
    @BindView(R.id.chsugar_total_distribution_year_to_date)
    CheckBox chsugar_total_distribution_year_to_date;
    @BindView(R.id.etsugar_total_distribution_year_to_date_remarks)
    CustomEditText etsugar_total_distribution_year_to_date_remarks;


    @BindView(R.id.etmolasses_total_distribution_this_month)
    CustomEditText etmolasses_total_distribution_this_month;
    @BindView(R.id.chmolasses_total_distribution_this_month)
    CheckBox chmolasses_total_distribution_this_month;
    @BindView(R.id.etmolasses_total_distribution_this_month_remarks)
    CustomEditText etmolasses_total_distribution_this_month_remarks;
    @BindView(R.id.etmollases_total_distribution_this_year_to_date)
    CustomEditText etmollases_total_distribution_this_year_to_date;
    @BindView(R.id.chmollases_total_distribution_this_year_to_date)
    CheckBox chmollases_total_distribution_this_year_to_date;
    @BindView(R.id.etmollases_total_distribution_this_month_date_remarks)
    CustomEditText etmollases_total_distribution_this_month_date_remarks;

    private String sugar_total_distribution_this_month, chksugar_total_distribution_this_month, sugar_total_distribution_this_month_remarks,sugar_total_distribution_year_to_date, chksugar_total_distribution_year_to_date, sugar_total_distribution_year_to_date_remarks;

    private String molasses_total_distribution_this_month, chkmolasses_total_distribution_this_month, molasses_total_distribution_this_month_remarks, mollases_total_distribution_this_year_to_date, chkmollases_total_distribution_this_year_to_date, mollases_total_distribution_this_year_to_date_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sugar_mollases_total_distribution, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {

        sugar_total_distribution_this_month = Objects.requireNonNull(etsugar_total_distribution_this_month.getText().toString());
        sugar_total_distribution_this_month_remarks = Objects.requireNonNull(etsugar_total_distribution_this_month_remarks.getText().toString());
        sugar_total_distribution_year_to_date = Objects.requireNonNull(etsugar_total_distribution_year_to_date.getText().toString());
        sugar_total_distribution_year_to_date_remarks = Objects.requireNonNull(etsugar_total_distribution_year_to_date_remarks.getText().toString());

        molasses_total_distribution_this_month = Objects.requireNonNull(etmolasses_total_distribution_this_month.getText().toString());
        molasses_total_distribution_this_month_remarks = Objects.requireNonNull(etmolasses_total_distribution_this_month_remarks.getText().toString());
        mollases_total_distribution_this_year_to_date = Objects.requireNonNull(etmollases_total_distribution_this_year_to_date.getText().toString());
        mollases_total_distribution_this_year_to_date_remarks = Objects.requireNonNull(etmollases_total_distribution_this_month_date_remarks.getText().toString());
/*
        SugarMolassesBus sugarMolassesBus = SugarMolassesBus.getInstance();

        sugarMolassesBus.setSugar_total_distribution_this_month(sugar_total_distribution_this_month);
        sugarMolassesBus.setSugar_total_distribution_this_month_remarks(sugar_total_distribution_this_month_remarks);
        sugarMolassesBus.setSugar_total_distribution_year_to_date(sugar_total_distribution_year_to_date);
        sugarMolassesBus.setSugar_total_distribution_year_to_date_remarks(sugar_total_distribution_year_to_date_remarks);

        sugarMolassesBus.setMolasses_total_distribution_this_month(molasses_total_distribution_this_month);
        sugarMolassesBus.setMolasses_total_distribution_this_month_remarks(molasses_total_distribution_this_month_remarks);
        sugarMolassesBus.setMollases_total_distribution_this_year_to_date(mollases_total_distribution_this_year_to_date);
        sugarMolassesBus.setMollases_total_distribution_this_year_to_date_remarks(mollases_total_distribution_this_year_to_date_remarks);
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

