package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

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
import cn.pedant.SweetAlert.SweetAlertDialog;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.SugarWholesalePricesSurvey;
import co.ke.bsl.data.view.CountryOfOriginView;
import co.ke.bsl.data.view.SugarWholesalePricesSurveyBus;
import co.ke.bsl.pojo.Country;
import co.ke.bsl.pojo.WholeSaleBrandLocal;
import co.ke.bsl.pojo.WholeSaleImportedSugar;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.SugarRetailsPricesSurveyViewModel;
import co.ke.bsl.ui.viewmodels.SugarWholesalePricesSurveyViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class SugarSurveyWholeSaleImportedStocked extends Fragment implements BlockingStep {
    @BindView(R.id.ssWholeSale_Imported_Stocked_Origin)
    SearchableSpinner ssWholeSale_Imported_Stocked_Origin;
    @BindView(R.id.etWholeSale_Imported_Stocked_price_20kg)
    CustomEditText etWholeSale_Imported_Stocked_price_20kg;
    @BindView(R.id.etWholeSale_Imported_Stocked_price_24kg)
    CustomEditText etWholeSale_Imported_Stocked_price_24kg;
    @BindView(R.id.etWholeSale_Imported_Stocked_price_of_50kg)
    CustomEditText etWholeSale_Imported_Stocked_price_of_50kg;


    protected Handler asyncTaskHandler;
    private AsyncActivitySupport asyncSupport;
    EditText priceOf50kgBag, priceOf24kgBale, priceOf20kgBale;
    protected List<Country> countries;
    Spinner countrySpinner;
    List<WholeSaleImportedSugar> wholeSaleImportedSugarList;
    Country country;
    AFADatabaseAdapter db;
    private SugarWholesalePricesSurveyViewModel sugarWholesalePricesSurveyViewModel;
    private List<WholeSaleBrandLocal> wholeSaleBrandLocalList;
    private GPSTracker mGPS;

    protected List<Country> countryList;

    AFA app;

    private ArrayList<String> countryoforiginlist = new ArrayList<>();
    private String wholeSale_Imported_Stocked_origin, wholeSale_Imported_Stocked_price_20kg, wholeSale_Imported_Stocked_price_24kg, wholeSale_Imported_Stocked_price_50kg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sugar_survey_whole_sale_imported_stocked, container, false);

        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        countryList = new ArrayList<Country>();
        mGPS = new GPSTracker(getContext());
        getCountryListApplicable();

        sugarWholesalePricesSurveyViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(SugarWholesalePricesSurveyViewModel.class);

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
        ssWholeSale_Imported_Stocked_Origin.setAdapter(regionAdapter);

        ssWholeSale_Imported_Stocked_Origin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // Can also use mySpinner.setOnItemClickListener(......)
                // Using a separate button here as there's often other data to select
                // or if you choose the wrong item.
                Country selectedCountry;
                country = new Country();
                if (!(ssWholeSale_Imported_Stocked_Origin.getSelectedItem() == null)) {
                    selectedCountry = (Country) ssWholeSale_Imported_Stocked_Origin.getSelectedItem();
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


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {


    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        wholeSale_Imported_Stocked_origin = Objects.requireNonNull(ssWholeSale_Imported_Stocked_Origin.getSelectedItem()).toString().trim();
        wholeSale_Imported_Stocked_price_20kg = Objects.requireNonNull(etWholeSale_Imported_Stocked_price_20kg.getText()).toString().trim();
        wholeSale_Imported_Stocked_price_24kg = Objects.requireNonNull(etWholeSale_Imported_Stocked_price_24kg.getText()).toString().trim();
        wholeSale_Imported_Stocked_price_50kg = Objects.requireNonNull(etWholeSale_Imported_Stocked_price_of_50kg.getText()).toString().trim();


        if ("- Required -".equals(wholeSale_Imported_Stocked_origin)) {
            TextView errorText = (TextView) ssWholeSale_Imported_Stocked_Origin.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }
        if (TextUtils.isEmpty(wholeSale_Imported_Stocked_price_20kg)) {
            etWholeSale_Imported_Stocked_price_20kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(wholeSale_Imported_Stocked_price_24kg)) {
            etWholeSale_Imported_Stocked_price_24kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(wholeSale_Imported_Stocked_price_50kg)) {
            etWholeSale_Imported_Stocked_price_of_50kg.setError("Price Required");
            return;
        }

        if (Integer.parseInt(etWholeSale_Imported_Stocked_price_24kg.getText().toString()) < Integer.parseInt(etWholeSale_Imported_Stocked_price_20kg.getText().toString())) {

            Toast.makeText(getContext(),
                    "Price of 20KG Bale cannot  more that of 24KG Bale",
                    Toast.LENGTH_LONG).show();
            return;
        }


        if (Integer.parseInt(etWholeSale_Imported_Stocked_price_of_50kg.getText().toString()) < Integer.parseInt(etWholeSale_Imported_Stocked_price_24kg.getText().toString())) {

            Toast.makeText(getContext(),
                    "Price of 24KG Bale cannot  more that of 50 KG Bag ",
                    Toast.LENGTH_LONG).show();
            return;
        }

        SugarWholesalePricesSurveyBus sugarWholesalePricesSurveyBus = SugarWholesalePricesSurveyBus.getInstance();

        SugarWholesalePricesSurvey sugarWholesalePricesSurvey = new SugarWholesalePricesSurvey(
                0,
                sugarWholesalePricesSurveyBus.getSurveyType(),
                sugarWholesalePricesSurveyBus.getCity(),
                sugarWholesalePricesSurveyBus.getDocument_Number(),
                sugarWholesalePricesSurveyBus.getSurvey_Ending(),
                sugarWholesalePricesSurveyBus.getShop(),

                sugarWholesalePricesSurveyBus.getWholesale_Brand(),
                sugarWholesalePricesSurveyBus.getWholesale_Brand_price_20kg(),
                sugarWholesalePricesSurveyBus.getWholesale_Brand_price_24kg(),
                sugarWholesalePricesSurveyBus.getWholesale_Brand_price_50kg(),

                sugarWholesalePricesSurveyBus.getWholesale_Imported_Country(),
                sugarWholesalePricesSurveyBus.getWholeSale_Imported_price_20kg(),
                sugarWholesalePricesSurveyBus.getWholeSale_Imported_price_24kg(),
                sugarWholesalePricesSurveyBus.getWholeSale_Imported_price_50kg(),

                sugarWholesalePricesSurveyBus.getWholeSale_Stoked_Brand(),
                sugarWholesalePricesSurveyBus.getWholeSale_Stoked_Brand_priceOf20kgBale(),
                sugarWholesalePricesSurveyBus.getWholeSale_Stoked_Brand_priceOf24kgBale(),
                sugarWholesalePricesSurveyBus.getWholeSale_Stoked_Brand_priceOf50kgBag(),

                wholeSale_Imported_Stocked_origin,
                wholeSale_Imported_Stocked_price_20kg,
                wholeSale_Imported_Stocked_price_24kg,
                wholeSale_Imported_Stocked_price_50kg,

                false,
                ""
        );



        new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Sugar Wholesale Inspection!")
                .setCancelText("NO!")
                .setConfirmText("Submit!")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        // reuse previous dialog instance, keep widget user state, reset them if you need
                        sDialog.setTitleText("Cancelled!")
                                .setContentText("You Cancelled Submission:)")
                                .setConfirmText("OK")
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null)
                                .changeAlertType(SweetAlertDialog.ERROR_TYPE);

                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.setTitleText("Successfully!!!")
                                .setContentText("Submitted!")
                                .setConfirmText("OK")
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null)
                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);

                        sugarWholesalePricesSurveyViewModel.addRecord(sugarWholesalePricesSurvey);

                        long shop_id = db.insertShopRecords(sugarWholesalePricesSurveyBus.getShop(),
                                String.valueOf(mGPS.getLongitude()),
                                String.valueOf(mGPS.getLatitude()),
                                sugarWholesalePricesSurveyBus.getSurveyType());

                        db.insertLocalBrand(sugarWholesalePricesSurveyBus.getWholesale_Brand(),
                                sugarWholesalePricesSurveyBus.getWholesale_Brand_price_20kg(),
                                sugarWholesalePricesSurveyBus.getWholesale_Brand_price_24kg(),
                                sugarWholesalePricesSurveyBus.getWholesale_Brand_price_50kg(),
                                Integer.parseInt(String.valueOf(shop_id)), "0");

                        db.insertLocalImportBrand(country.getC_country_id(),
                                sugarWholesalePricesSurveyBus.getWholeSale_Imported_price_20kg(),
                                sugarWholesalePricesSurveyBus.getWholeSale_Imported_price_24kg(),
                                sugarWholesalePricesSurveyBus.getWholeSale_Imported_price_50kg(),
                                Integer.parseInt(String.valueOf(shop_id)), 0);

                        db.insertLocalBrandStocked(sugarWholesalePricesSurveyBus.getWholeSale_Stoked_Brand(),
                                sugarWholesalePricesSurveyBus.getWholeSale_Stoked_Brand_priceOf20kgBale(),
                                sugarWholesalePricesSurveyBus.getWholeSale_Stoked_Brand_priceOf24kgBale(),
                                sugarWholesalePricesSurveyBus.getWholeSale_Stoked_Brand_priceOf50kgBag(),
                                Integer.parseInt(String.valueOf(shop_id)), 0);

                        db.insertLocalImportBrandStocked(country.getC_country_id(),
                                wholeSale_Imported_Stocked_price_20kg,
                                wholeSale_Imported_Stocked_price_24kg,
                                wholeSale_Imported_Stocked_price_50kg,
                                Integer.parseInt(String.valueOf(shop_id)),
                                0);

                        sDialog.dismissWithAnimation();
                            Intent intent = new Intent(getActivity(), DashboardActivity.class);
                            startActivity(intent);
                        }
                    })
                    .show();
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