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
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.pojo.City;
import co.ke.bsl.pojo.LoginService;
import co.ke.bsl.pojo.SubCounty;
import co.ke.bsl.pojo.SugarPricesSurveyDataCollection;
import co.ke.bsl.pojo.Survey;
import co.ke.bsl.task.HttpGetCountyListTask;
import co.ke.bsl.task.HttpPostTask;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.ErrorHandler;
import co.ke.bsl.util.GPSTracker;
import co.ke.bsl.util.StringUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAIndustrialUnderCaneByCounties extends Fragment implements BlockingStep
{
    @BindView(R.id.sscounty)
    SearchableSpinner sscounty;
    @BindView(R.id.sssub_county)
    SearchableSpinner sssub_county;
    @BindView(R.id.etarea_undercane)
    CustomEditText etarea_undercane;
    @BindView(R.id.ettotal_farmers)
    CustomEditText ettotal_farmers;
    @BindView(R.id.etaverage_farm_size)
    CustomEditText etaverage_farm_size;

    AFADatabaseAdapter db;
    private GPSTracker mGPS;
    SugarPricesSurveyDataCollection sugarPricesSurveyDataCollection;

    private ArrayList<String> surveyTypeList = new ArrayList<>();
    private ArrayList<String> cityList = new ArrayList<>();

    protected List<City> countiesList;
    protected List<Survey> surveysList;
    protected List<SubCounty> subCountiesList;
    private AsyncActivitySupport asyncSupport;

    protected Handler asyncTaskHandler;
    LoginService loginService;

    AFA app;
    private String county, sub_county, area_undercane, total_farmers, average_farm_size;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindustrial_under_cane_by_counties, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        asyncSupport = new AsyncActivitySupport(getActivity());
        countiesList = new ArrayList<City>();
        subCountiesList=new ArrayList<SubCounty>();

        db=new AFADatabaseAdapter(getActivity()).open();


        //setListCity(getDummyCity());
        getCityListApplicable();
        return view;
    }
    protected void getCityListApplicable()
    {
        countiesList=db.getCityList();
        populateSpinner();

    }


    private void populateSpinner() {




        ArrayAdapter<City> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, countiesList);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);

        sscounty.setAdapter(regionAdapter);


    /*    ArrayAdapter<City> spinnerAdapter = new ArrayAdapter<City>(getContext(),
                android.R.layout.simple_spinner_item, countiesList);*/

        // Drop down layout style - list view with radio button
 /*       spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        */
        // attaching data adapter to spinner
        if(sscounty!=null){
            // sscity.setAdapter(regionAdapter);


            sscounty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                    // Can also use mySpinner.setOnItemClickListener(......)
                    // Using a separate button here as there's often other data to select
                    // or if you choose the wrong item.
                    City selectedCity;
                    if (!(sscounty.getSelectedItem() == null)) {
                        selectedCity = (City) sscounty.getSelectedItem();
                        //  appState.setCity(selectedCity);


                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }


    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {

//        county = Objects.requireNonNull(sscounty.getSelectedItem().toString());
       // sub_county= Objects.requireNonNull(sssub_county.getSelectedItem().toString());
        area_undercane = Objects.requireNonNull(etarea_undercane.getText().toString());
        total_farmers= Objects.requireNonNull(ettotal_farmers.getText().toString());
        average_farm_size = Objects.requireNonNull(etaverage_farm_size.getText().toString());
/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();
        industryAgriculturalProductionBus.setCounty(county);
        industryAgriculturalProductionBus.setSub_county(sub_county);
        industryAgriculturalProductionBus.setArea_undercane(area_undercane);
        industryAgriculturalProductionBus.setTotal_farmers(total_farmers);
        industryAgriculturalProductionBus.setAverage_farm_size(average_farm_size);
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


    protected String getAsyncTaskFailedMessage(Class<?> taskClass,
                                               Throwable throwable) {
        int msgResID = R.string.error_unspecied;
        if (taskClass == HttpGetCountyListTask.class) {
            msgResID = R.string.pizzasList_error_postingOrderFailed;
        }
        if (taskClass == HttpPostTask.class) {
            msgResID = R.string.pizzasList_error_postingOrderFailed;
        } else {
            ErrorHandler.logAndThrow(getClass(), new IllegalArgumentException(
                    "Unexpected class: " + taskClass.toString()));
        }

        return StringUtils.limitStringLength(
                getString(msgResID, throwable.getMessage()), 200, " ...");
    }


}

