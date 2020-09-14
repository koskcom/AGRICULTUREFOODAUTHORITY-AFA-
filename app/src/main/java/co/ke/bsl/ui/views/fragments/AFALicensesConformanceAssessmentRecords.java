package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
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
import co.ke.bsl.data.view.YearView;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFALicensesConformanceAssessmentRecords extends Fragment implements BlockingStep
{
    @BindView(R.id.etdocument_no)
    CustomEditText etdocument_no;
    @BindView(R.id.etdocument_date)
    CustomEditText etdocument_date;
    @BindView(R.id.etlicence_no)
    CustomEditText etlicence_no;
    @BindView(R.id.ssyear)
    SearchableSpinner ssyear;

    private  String document_number, document_date, licence_number, year;
    AFADatabaseAdapter db;
    private ArrayList<String> yearList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afalicenses_conformaformance_records, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db=new AFADatabaseAdapter(getActivity()).open();

        setListyear(getDummyyear());
          ssyear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                year = ssyear.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        return view;
    }
    private void setListyear(List<YearView> dummyyear)
    {

        yearList.add("- Required -");
        for (YearView regionWrapper : dummyyear)
        {
            yearList.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, yearList);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssyear.setAdapter(regionAdapter);
    }

    private List<YearView> getDummyyear() {
        List<YearView> listViewItems = new ArrayList<>();
        listViewItems.add(new YearView("2010"));
        listViewItems.add(new YearView("2011"));
        listViewItems.add(new YearView("2012"));
        listViewItems.add(new YearView("2013"));
        listViewItems.add(new YearView("2014"));
        listViewItems.add(new YearView("2015"));
        listViewItems.add(new YearView("2016"));
        listViewItems.add(new YearView("2017"));
        listViewItems.add(new YearView("2018"));
        listViewItems.add(new YearView("2019"));
        return listViewItems;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {


        document_number = Objects.requireNonNull(etdocument_no.getText().toString());
        document_date =Objects.requireNonNull(etdocument_date.getText().toString());
        licence_number =Objects.requireNonNull(etlicence_no.getText().toString());
        year =Objects.requireNonNull(ssyear.getSelectedItem().toString());

        if (TextUtils.isEmpty(document_number))
        {
             etdocument_no.setError("Document Number Required");
            return;
        }
        if (TextUtils.isEmpty(document_date))
        {
             etdocument_date.setError("Date Required");
            return;
        }
        if (TextUtils.isEmpty(licence_number))
        {
            etlicence_no.setError("Licence No Required");
            return;
        }

/*
        LicenceConformanceAssessmentBus licenceConformanceAssessmentBus = LicenceConformanceAssessmentBus.getInstance();

        licenceConformanceAssessmentBus.setDocument_number(document_number);
        licenceConformanceAssessmentBus.setDocument_date(document_date);
        licenceConformanceAssessmentBus.setLicence_number(licence_number);
        licenceConformanceAssessmentBus.setYear(year);
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

