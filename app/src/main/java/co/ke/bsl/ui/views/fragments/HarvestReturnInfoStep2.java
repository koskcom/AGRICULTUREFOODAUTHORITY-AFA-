package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
import co.ke.bsl.data.view.ReturnsView;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class HarvestReturnInfoStep2 extends Fragment implements BlockingStep
{

    @BindView(R.id.ssreturns)
    SearchableSpinner ssreturns;
    @BindView(R.id.etdate_of_return)
    CustomEditText etdate_of_return;
    @BindView(R.id.etmiller)
    CustomEditText etmiller;
    @BindView(R.id.etremarks_miller)
    CustomEditText etremarks_miller;
    @BindView(R.id.etreturns_type)
    CustomEditText etreturns_type;
    @BindView(R.id.etremarks_type_of_return)
    CustomEditText etremarks_type_of_return;
    @BindView(R.id.etzone)
    CustomEditText etzone;
    @BindView(R.id.etremarks_zone)
    CustomEditText etremarks_zone;
    @BindView(R.id.etcane_varieties)
    CustomEditText etcane_varieties;
    @BindView(R.id.etremarks_cane_varieties)
    CustomEditText etremarks_cane_varieties;
    @BindView(R.id.etcalender_year)
    CustomEditText etcalender_year;
    @BindView(R.id.etremarks_calender_year)
    CustomEditText etremarks_calender_year;
    @BindView(R.id.etmonth)
    CustomEditText etmonth;
    @BindView(R.id.etremarks_month)
    CustomEditText etremarks_month;

    private ArrayList<String> returnslist = new ArrayList<>();

    private String select_returns, date_of_returns, miller,remarks_miller, returns_type, remarks_returns_type;
    private String zone, remarks_zone, cane_varieties, remarks_cane_varieties, calendar_year, remarks_calendar_year;
    private String month, remarks_month;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_harvest_return_info, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();


        setListreturns(getDummydummyreturns());

        ssreturns.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id)
            {
                select_returns = ssreturns.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) { }
        });

        return view;

    }

    private void setListreturns(List<ReturnsView> dummyreturns)
    {
        returnslist.add("- Required -");
        for (ReturnsView regionWrapper : dummyreturns)
        {
            returnslist.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, returnslist);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssreturns.setAdapter(regionAdapter);
    }

    private List<ReturnsView> getDummydummyreturns()
    {
        List<ReturnsView> listViewItems = new ArrayList<>();
        listViewItems.add(new ReturnsView("A"));
        listViewItems.add(new ReturnsView("B"));
        listViewItems.add(new ReturnsView("C"));
        listViewItems.add(new ReturnsView("D"));

        return listViewItems;
    }
    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        date_of_returns = Objects.requireNonNull(etdate_of_return.getText()).toString().trim();
        miller = Objects.requireNonNull(etmiller.getText()).toString().trim();
        remarks_miller = Objects.requireNonNull(etremarks_miller.getText()).toString().trim();
        returns_type = Objects.requireNonNull(etreturns_type.getText()).toString().trim();
        remarks_returns_type = Objects.requireNonNull(etremarks_type_of_return.getText()).toString().trim();
        zone = Objects.requireNonNull(etzone.getText()).toString().trim();
        remarks_zone = Objects.requireNonNull(etremarks_zone.getText()).toString().trim();
        cane_varieties = Objects.requireNonNull(etcane_varieties.getText()).toString().trim();
        remarks_cane_varieties= Objects.requireNonNull(etremarks_cane_varieties.getText()).toString().trim();
        calendar_year = Objects.requireNonNull(etcalender_year.getText()).toString().trim();
        remarks_calendar_year = Objects.requireNonNull(etremarks_calender_year.getText()).toString().trim();
        month = Objects.requireNonNull(etmonth.getText()).toString().trim();
        remarks_month = Objects.requireNonNull(etremarks_month.getText()).toString().trim();
/*

        HarvestReturnsBus harvestReturnsBus = HarvestReturnsBus.getInstance();

        harvestReturnsBus.setSelect_returns(select_returns);
        harvestReturnsBus.setDate_of_returns(date_of_returns);
        harvestReturnsBus.setMiller(miller);
        harvestReturnsBus.setRemarks_miller(remarks_miller);
        harvestReturnsBus.setReturns_type(returns_type);
        harvestReturnsBus.setReturns_type(returns_type);
        harvestReturnsBus.setZone(zone);
        harvestReturnsBus.setRemarks_zone(remarks_zone);
        harvestReturnsBus.setCane_varieties(cane_varieties);
        harvestReturnsBus.setRemarks_cane_varieties(remarks_cane_varieties);
        harvestReturnsBus.setCalendar_year(calendar_year);
        harvestReturnsBus.setRemarks_calendar_year(remarks_calendar_year);
        harvestReturnsBus.setMonth(month);
        harvestReturnsBus.setRemarks_month(remarks_month);
*/
        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {

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
    public void onError(@NonNull VerificationError error) {

    }



}
