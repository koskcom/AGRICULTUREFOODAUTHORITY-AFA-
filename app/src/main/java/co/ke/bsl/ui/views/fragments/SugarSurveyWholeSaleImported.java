package co.ke.bsl.ui.views.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
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
import co.ke.bsl.data.view.CountryOfOriginView;
import co.ke.bsl.data.view.SugarWholesalePricesSurveyBus;
import co.ke.bsl.pojo.Country;
import co.ke.bsl.pojo.WholeSaleImportedSugar;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class SugarSurveyWholeSaleImported extends Fragment implements BlockingStep {

    @BindView(R.id.ssWholeSale_Imported_Country)
    SearchableSpinner ssWholeSale_Imported_Country;
    @BindView(R.id.etWholeSale_Imported_price_20kg)
    CustomEditText etWholeSale_Imported_price_20kg;
    @BindView(R.id.etWholeSale_Imported_price_24kg)
    CustomEditText etWholeSale_Imported_price_24kg;
    @BindView(R.id.etWholeSale_Imported_price_of_50kg)
    CustomEditText etWholeSale_Imported_price_of_50kg;

    protected Handler asyncTaskHandler;
    private AsyncActivitySupport asyncSupport;
    EditText priceOf50kgBag, priceOf24kgBale, priceOf20kgBale;
    protected List<Country> countries;
    Spinner countrySpinner;
    List<WholeSaleImportedSugar> wholeSaleImportedSugarList;
    Country country;
    AFADatabaseAdapter db;
    Boolean addMore = false;

    protected List<Country> countryList;

    AFA app;


    private String wholesale_Imported_Country, wholeSale_Imported_price_20kg, wholeSale_Imported_price_24kg, wholeSale_Imported_price_50kg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sugar_survey_whole_sale_imported, container, false);

        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();
        countryList = new ArrayList<Country>();
        getCountryListApplicable();




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
        ssWholeSale_Imported_Country.setAdapter(regionAdapter);


        ssWholeSale_Imported_Country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // Can also use mySpinner.setOnItemClickListener(......)
                // Using a separate button here as there's often other data to select
                // or if you choose the wrong item.
                Country selectedCountry;
                country = new Country();
                if (!(ssWholeSale_Imported_Country.getSelectedItem() == null)) {
                    selectedCountry = (Country) ssWholeSale_Imported_Country.getSelectedItem();
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

        wholesale_Imported_Country = Objects.requireNonNull(ssWholeSale_Imported_Country.getSelectedItem()).toString().trim();
        wholeSale_Imported_price_20kg = Objects.requireNonNull(etWholeSale_Imported_price_20kg.getText()).toString().trim();
        wholeSale_Imported_price_24kg = Objects.requireNonNull(etWholeSale_Imported_price_24kg.getText()).toString().trim();
        wholeSale_Imported_price_50kg = Objects.requireNonNull(etWholeSale_Imported_price_of_50kg.getText()).toString().trim();

        if ("- Required -".equals(wholesale_Imported_Country)) {
            TextView errorText = (TextView) ssWholeSale_Imported_Country.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }
        if (TextUtils.isEmpty(wholeSale_Imported_price_20kg)) {
            etWholeSale_Imported_price_20kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(wholeSale_Imported_price_24kg)) {
            etWholeSale_Imported_price_24kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(wholeSale_Imported_price_50kg)) {
            etWholeSale_Imported_price_of_50kg.setError("Price Required");
            return;
        }

        if (Integer.parseInt(etWholeSale_Imported_price_24kg.getText().toString()) < Integer.parseInt(etWholeSale_Imported_price_20kg.getText().toString())) {

            Toast.makeText(getContext(),
                    "Price of 20KG Bale cannot  more that of 24KG Bale",
                    Toast.LENGTH_LONG).show();
            return;
        }


        if (Integer.parseInt(etWholeSale_Imported_price_of_50kg.getText().toString()) < Integer.parseInt(etWholeSale_Imported_price_24kg.getText().toString())) {

            Toast.makeText(getContext(),
                    "Price of 24KG Bale cannot  more that of 50 KG Bag ",
                    Toast.LENGTH_LONG).show();
            return;
        }
            SugarWholesalePricesSurveyBus sugarWholesalePricesSurveyBus = SugarWholesalePricesSurveyBus.getInstance();

            sugarWholesalePricesSurveyBus.setWholesale_Imported_Country(country.getC_country_id());
            sugarWholesalePricesSurveyBus.setWholeSale_Imported_price_20kg(wholeSale_Imported_price_20kg);
            sugarWholesalePricesSurveyBus.setWholeSale_Imported_price_24kg(wholeSale_Imported_price_24kg);
            sugarWholesalePricesSurveyBus.setWholeSale_Imported_price_50kg(wholeSale_Imported_price_50kg);

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