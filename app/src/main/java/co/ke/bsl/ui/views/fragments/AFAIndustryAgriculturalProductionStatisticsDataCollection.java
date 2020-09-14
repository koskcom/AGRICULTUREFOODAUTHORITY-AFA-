package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAIndustryAgriculturalProductionStatisticsDataCollection extends Fragment implements BlockingStep
{

    @BindView(R.id.etdocument_no)
    CustomEditText etdocument_no;
    @BindView(R.id.etdocument_date)
    CustomEditText etdocument_date;
    @BindView(R.id.etyear)
    CustomEditText etyear;
    @BindView(R.id.etmonth)
    CustomEditText etmonth;
    @BindView(R.id.etApplicantName)
    CustomEditText etApplicantName;

    private String document_number,  document_date, year, month, applicant_name;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindustry_agricultural_production_statistics_data_collection, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        document_number = Objects.requireNonNull(etdocument_no.getText().toString());
        document_date = Objects.requireNonNull(etdocument_date.getText().toString());
        year= Objects.requireNonNull(etyear.getText().toString());
        month= Objects.requireNonNull(etmonth.getText().toString());
        applicant_name= Objects.requireNonNull(etApplicantName.getText().toString());
/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();
        industryAgriculturalProductionBus.setDocument_number(document_number);
        industryAgriculturalProductionBus.setDocument_date(document_date);
        industryAgriculturalProductionBus.setYear(year);
        industryAgriculturalProductionBus.setMonth(month);
        industryAgriculturalProductionBus.setSubLocation(applicant_name);
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
