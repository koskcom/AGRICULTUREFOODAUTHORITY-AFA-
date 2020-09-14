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
public class SugarSurveyRetailLooseImported extends Fragment implements BlockingStep {
    @BindView(R.id.ssRetail_Loose_Imported_price_Origin)
    SearchableSpinner ssRetail_Loose_Imported_price_Origin;
    @BindView(R.id.etRetail_Loose_Imported_price_of_1kg)
    CustomEditText etRetail_Loose_Imported_price_of_1kg;
    @BindView(R.id.etRetail_Loose_Imported_price_of_2kg)
    CustomEditText etRetail_Loose_Imported_price_of_2kg;

    Country country;
    AFADatabaseAdapter db;

    protected List<Country> countryList;

    AFA app;

    private String retail_Loose_Imported_price_origin, retail_Loose_Imported_price_of_1kg, retail_Loose_Imported_price_of_2kg;

    private ArrayList<String> countryoforiginlist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sugar_survey_retail_loose_imported, container, false);
        ButterKnife.bind(this, view);
        db = new AFADatabaseAdapter(getContext()).open();
        countryList = new ArrayList<Country>();

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();


        getCountryListApplicable();

        return view;
    }

    private void setListCountryOfOrigin(List<CountryOfOriginView> dummyCounttryOfOrigin) {
        countryoforiginlist.add("- Required -");
        for (CountryOfOriginView regionWrapper : dummyCounttryOfOrigin) {
            countryoforiginlist.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, countryoforiginlist);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssRetail_Loose_Imported_price_Origin.setAdapter(regionAdapter);
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
        ssRetail_Loose_Imported_price_Origin.setAdapter(regionAdapter);


        ssRetail_Loose_Imported_price_Origin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // Can also use mySpinner.setOnItemClickListener(......)
                // Using a separate button here as there's often other data to select
                // or if you choose the wrong item.
                Country selectedCountry;
                country = new Country();
                if (!(ssRetail_Loose_Imported_price_Origin.getSelectedItem() == null)) {
                    selectedCountry = (Country) ssRetail_Loose_Imported_price_Origin.getSelectedItem();
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


        if ("- Required -".equals(retail_Loose_Imported_price_origin)) {
            TextView errorText = (TextView) ssRetail_Loose_Imported_price_Origin.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }

        retail_Loose_Imported_price_of_1kg = Objects.requireNonNull(etRetail_Loose_Imported_price_of_1kg.getText()).toString().trim();
        retail_Loose_Imported_price_of_2kg = Objects.requireNonNull(etRetail_Loose_Imported_price_of_2kg.getText()).toString().trim();

        if (TextUtils.isEmpty(retail_Loose_Imported_price_of_1kg)) {
            etRetail_Loose_Imported_price_of_1kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(retail_Loose_Imported_price_of_2kg)) {
            etRetail_Loose_Imported_price_of_1kg.setError("Price Required");
            return;
        }

        SugarRetailPricesSurveyBus sugarRetailPricesSurveyBus = SugarRetailPricesSurveyBus.getInstance();

        sugarRetailPricesSurveyBus.setRetail_Loose_Imported_price_origin(country.getC_country_id());
        sugarRetailPricesSurveyBus.setRetail_Loose_Imported_price_of_1kg(retail_Loose_Imported_price_of_1kg);
        sugarRetailPricesSurveyBus.setRetail_Loose_Imported_price_of_2kg(retail_Loose_Imported_price_of_2kg);

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