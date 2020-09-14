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
import android.widget.CheckBox;
import android.widget.TextView;

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
import co.ke.bsl.data.view.NOCDMarketPriceSurveyBus;
import co.ke.bsl.pojo.County;
import co.ke.bsl.pojo.NOCDMarketPriceSurveyDetails;
import co.ke.bsl.pojo.SubCounty;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class NOCDMarketPriceSurveyFragment extends Fragment implements BlockingStep {

    @BindView(R.id.ssNOCDCounty)
    SearchableSpinner ssNOCDCounty;
    @BindView(R.id.ssNOCDSubCounty)
    SearchableSpinner ssNOCDSubCounty;
    @BindView(R.id.etNOCDSubLocation)
    CustomEditText etNOCSubLocation;

    protected List<County> countyList;
    protected List<SubCounty> subCountyList;

    AFADatabaseAdapter db;

    private SubCounty subCounty;
    private County county;
    String localID;
    private String countyID, subCountyID, subLocation;
    AFA app;


    NOCDMarketPriceSurveyDetails nocdMarketPriceSurveyDetails;


    public NOCDMarketPriceSurveyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nocdmarket_price_survey, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getActivity()).open();
        countyList = new ArrayList<>();
        subCountyList = new ArrayList<>();

        nocdMarketPriceSurveyDetails = new NOCDMarketPriceSurveyDetails();


        setListCounties(getCountyListApplicable());

        ssNOCDCounty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                county = (County) ssNOCDCounty.getSelectedItem();
                countyID = county.getCountyId();
                setListSubCounties(getSubCountyListApplicable(county.getCountyId()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        ssNOCDSubCounty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                subCounty = (SubCounty) ssNOCDSubCounty.getSelectedItem();
                subCountyID = subCounty.getSubCountyId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        subLocation = Objects.requireNonNull(etNOCSubLocation.getText()).toString().trim();

        boolean valid = validateSpinner(ssNOCDCounty, countyID) &
                validateSpinner(ssNOCDSubCounty, subCountyID);

        NOCDMarketPriceSurveyBus nocdMarketPriceSurveyBus = NOCDMarketPriceSurveyBus.getInstance();
        nocdMarketPriceSurveyBus.setCountyID(countyID);
        nocdMarketPriceSurveyBus.setSubCountyID(subCountyID);
        nocdMarketPriceSurveyBus.setSubLocation(subLocation);
        nocdMarketPriceSurveyBus.setLocalID(localID);

        callback.goToNextStep();

//            nocdMarketPriceSurveyDetails.setLoginRequest(app.getLoginRequest());

//        long localID = db.insertNOCDLocation(nocdMarketPriceSurveyDetails.getCountyID(),nocdMarketPriceSurveyDetails.getSubCountyID(),
//                subLocation, String.valueOf( mGPS.getLongitude()), String.valueOf(mGPS.getLatitude()));
//        nocdMarketPriceSurveyDetails.setLocalID(String.valueOf(localID));
//        app.setNOCDMarketPriceSurveyDetails(nocdMarketPriceSurveyDetails);

        if (valid) {
            callback.goToNextStep();
        }

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        callback.goToPrevStep();
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

    private void setListCounties(List<County> realCounty) {

        ArrayAdapter<County> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, realCounty);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssNOCDCounty.setAdapter(regionAdapter);


    }

    private void setListSubCounties(List<SubCounty> realSubCounty) {

        ArrayAdapter<SubCounty> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, realSubCounty);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssNOCDSubCounty.setAdapter(regionAdapter);


    }

    protected List<County> getCountyListApplicable() {
        countyList.clear();

        countyList = db.getAllCounty();
        System.out.println("countyList" + countyList.size());
        return countyList;

        // populateSpinner();


    }

    protected List<SubCounty> getSubCountyListApplicable(String countyID) {
        subCountyList.clear();

        subCountyList = db.getAllSubCounty(countyID);
        System.out.println("subCountyList " + countyList.size());
        return subCountyList;

        // populateSpinner();


    }

    private boolean validateSpinner(SearchableSpinner searchableSpinner, String searchableSpinnerString) {

        if (null == searchableSpinnerString || searchableSpinnerString.isEmpty() || "- Required -".equals(searchableSpinnerString)) {
            TextView errorText = (TextView) searchableSpinner.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return false;
        } else {
            return true;
        }
    }

}
