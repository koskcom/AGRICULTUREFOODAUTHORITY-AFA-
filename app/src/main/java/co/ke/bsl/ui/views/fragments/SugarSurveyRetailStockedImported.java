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
import co.ke.bsl.data.view.CountryOfOriginView;
import co.ke.bsl.data.view.SugarRetailPricesSurveyBus;
import co.ke.bsl.pojo.Country;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class SugarSurveyRetailStockedImported extends Fragment implements BlockingStep {
    @BindView(R.id.ssRetail_Stocked_Imported_importedorigin)
    SearchableSpinner ssRetail_Stocked_Imported_importedorigin;
    @BindView(R.id.etRetail_Stocked_Imported_price_20kg)
    CustomEditText etRetail_Stocked_Imported_price_20kg;
    @BindView(R.id.etRetail_Stocked_Imported_price_24kg)
    CustomEditText etRetail_Stocked_Imported_price_24kg;
    @BindView(R.id.etRetail_Stocked_Imported_price_of_50kg)
    CustomEditText etRetail_Stocked_Imported_price_of_50kg;

    Country country;
    AFADatabaseAdapter db;

    AFA app;


    protected List<Country> countryList;


    private ArrayList<String> countryoforiginlist = new ArrayList<>();
    private String retail_Stocked_Imported_origin, retail_Stocked_Imported_price_of_20kg, retail_Stocked_Imported_price_of_24kg, retail_Stocked_Imported_price_of_50kg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sugar_survey_retail_stocked_imported, container, false);

        ButterKnife.bind(this, view);


        db = new AFADatabaseAdapter(getContext()).open();
        countryList = new ArrayList<Country>();

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();


        getCountryListApplicable();

        // setListCountryOfOrigin(getDummyCountryOfOrigin());

/*
        ssimportedorigin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id)
            {
                origin = ssimportedorigin.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) { }
        });*/
        return view;
    }


    protected void getCountryListApplicable() {


        List<Country> countryDBList = db.getCountryList();

        System.out.println("the size of the  list" + countryDBList.size());

		/*if(countryDBList.isEmpty() || !(countryDBList.size()>0)){

			String uri = getString(R.string.baseURILocal);
			if (isNetworkConnectedElseAlert()) {

				new  HttpGetCountryListTask(SugarSurveyRetailLooseImportedActivity.this, uri, 0)
						.execute(appState.getLoginRequest());
			}
		}else{*/
        countryList.clear();
        countryList = countryDBList;
        populateSpinner();
        //}


    }

    private void populateSpinner() {


        ArrayAdapter<Country> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, countryList);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssRetail_Stocked_Imported_importedorigin.setAdapter(regionAdapter);


        ssRetail_Stocked_Imported_importedorigin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // Can also use mySpinner.setOnItemClickListener(......)
                // Using a separate button here as there's often other data to select
                // or if you choose the wrong item.
                Country selectedCountry;
                country = new Country();
                if (!(ssRetail_Stocked_Imported_importedorigin.getSelectedItem() == null)) {
                    selectedCountry = (Country) ssRetail_Stocked_Imported_importedorigin.getSelectedItem();
                    app.setImportSugarCountryOfOrigin(selectedCountry);

                    String country_id = (String) selectedCountry.getC_country_id();

                    country = selectedCountry;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void setListCountryOfOrigin(List<CountryOfOriginView> dummyCounttryOfOrigin) {
        countryoforiginlist.add("- Required -");
        for (CountryOfOriginView regionWrapper : dummyCounttryOfOrigin) {
            countryoforiginlist.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, countryoforiginlist);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssRetail_Stocked_Imported_importedorigin.setAdapter(regionAdapter);
    }

    private List<CountryOfOriginView> getDummyCountryOfOrigin() {
        List<CountryOfOriginView> listViewItems = new ArrayList<>();
        listViewItems.add(new CountryOfOriginView("India"));
        listViewItems.add(new CountryOfOriginView("Mexico"));
        listViewItems.add(new CountryOfOriginView("UK"));
        listViewItems.add(new CountryOfOriginView("London"));

        return listViewItems;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {


        if ("- Required -".equals(retail_Stocked_Imported_origin)) {
            TextView errorText = (TextView) ssRetail_Stocked_Imported_importedorigin.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }
        retail_Stocked_Imported_price_of_20kg = Objects.requireNonNull(etRetail_Stocked_Imported_price_20kg.getText()).toString().trim();
        retail_Stocked_Imported_price_of_24kg = Objects.requireNonNull(etRetail_Stocked_Imported_price_24kg.getText()).toString().trim();
        retail_Stocked_Imported_price_of_50kg = Objects.requireNonNull(etRetail_Stocked_Imported_price_of_50kg.getText()).toString().trim();

        if (TextUtils.isEmpty(retail_Stocked_Imported_price_of_20kg)) {
            etRetail_Stocked_Imported_price_20kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(retail_Stocked_Imported_price_of_24kg)) {
            etRetail_Stocked_Imported_price_24kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(retail_Stocked_Imported_price_of_50kg)) {
            etRetail_Stocked_Imported_price_of_50kg.setError("Price Required");
            return;
        }
        SugarRetailPricesSurveyBus sugarRetailPricesSurveyBus = SugarRetailPricesSurveyBus.getInstance();

        sugarRetailPricesSurveyBus.setRetail_Stocked_Imported_origin(country.getC_country_id());
        sugarRetailPricesSurveyBus.setRetail_Stocked_Imported_price_of_20kg(retail_Stocked_Imported_price_of_20kg);
        sugarRetailPricesSurveyBus.setRetail_Stocked_Imported_price_of_24kg(retail_Stocked_Imported_price_of_24kg);
        sugarRetailPricesSurveyBus.setRetail_Stocked_Imported_price_of_50kg(retail_Stocked_Imported_price_of_50kg);

        callback.goToNextStep();
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

}