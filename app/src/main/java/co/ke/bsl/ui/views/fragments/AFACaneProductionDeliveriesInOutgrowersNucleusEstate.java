package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

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
import co.ke.bsl.data.view.YearView;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFACaneProductionDeliveriesInOutgrowersNucleusEstate extends Fragment implements BlockingStep
{
    @BindView(R.id.etdocument_no)
    CustomEditText etdocument_no;
    @BindView(R.id.etdocument_date)
    CustomEditText etdocument_date;
    @BindView(R.id.etapplicant_name)
    CustomEditText etapplicant_name;
    @BindView(R.id.ssyear)
    SearchableSpinner ssyear;
    @BindView(R.id.ssmonth)
    SearchableSpinner ssmonth;

    private String document_number, document_date, applicant_name, year, month;

    AFADatabaseAdapter db;
    private ArrayList<String> yearList = new ArrayList<>();
    private ArrayList<String> monthList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afacane_production_deliveries_in_outgrowers_nucleus_estate, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
//        db=new AFADatabaseAdapter(getActivity()).open();
        setListyear(getDummyyear());
        setListmonth(getDummymonth());

        ssyear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                year = ssyear.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        ssmonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                month = ssmonth.getSelectedItem().toString();
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
        ssmonth.setAdapter(regionAdapter);
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

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback)
    {
        /*
        document_number =Objects.requireNonNull(etdocument_no.getText().toString());
        document_date =Objects.requireNonNull(etdocument_date.getText().toString());
        applicant_name =Objects.requireNonNull(etapplicant_name.getText().toString());
        year =Objects.requireNonNull(ssyear.getSelectedItem().toString());
        month =Objects.requireNonNull(ssmonth.getSelectedItem().toString());

        if (TextUtils.isEmpty(document_number))
        {
            etdocument_no.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(document_date))
        {
            etdocument_date.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(applicant_name))
        {
            etapplicant_name.setError("Field Required");
            return;
        }
        if ("- Required -".equals(year)) {
            TextView errorText = (TextView) ssyear.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }

        if ("- Required -".equals(month)) {
            TextView errorText = (TextView) ssmonth.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }

        CaneProductionDeliveriesOutgrowersBus caneProductionDeliveriesOutgrowersBus = CaneProductionDeliveriesOutgrowersBus.getInstance();

        CaneProductionDeliveriesOutgrowers caneProductionDeliveriesOutgrowers= new CaneProductionDeliveriesOutgrowers(
                0,
                caneProductionDeliveriesOutgrowersBus.getDocument_number(),
                caneProductionDeliveriesOutgrowersBus.getDocument_date(),
                caneProductionDeliveriesOutgrowersBus.getSubLocation(),
                caneProductionDeliveriesOutgrowersBus.getYear(),
                caneProductionDeliveriesOutgrowersBus.getMonth(),
                false,
                ""
        );

//        caneCensusRecordViewModel.addRecord(caneCensus);

      Intent intent = new Intent(getActivity(), DashboardActivity.class);
        Objects.requireNonNull(getActivity()).finish();
        startActivity(intent);*/


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


