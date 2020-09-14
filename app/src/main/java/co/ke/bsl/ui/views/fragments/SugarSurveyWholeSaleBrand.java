package co.ke.bsl.ui.views.fragments;


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
import co.ke.bsl.data.view.CountyView;
import co.ke.bsl.data.view.SugarCompanyView;
import co.ke.bsl.data.view.SugarWholesalePricesSurveyBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class SugarSurveyWholeSaleBrand extends Fragment implements BlockingStep {

    @BindView(R.id.etWholesale_Brand)
    CustomEditText etWholesale_Brand;
    @BindView(R.id.etWholesale_Brand_price_20kg)
    CustomEditText etWholesale_Brand_price_20kg;
    @BindView(R.id.etWholesale_Brand_price_24kg)
    CustomEditText etWholesale_Brand_price_24kg;
    @BindView(R.id.etWholesale_Brand_price_50kg)
    CustomEditText etWholesale_Brandprice_50kg;

    private GPSTracker mGPS;
    AFADatabaseAdapter db;
    protected Handler asyncTaskHandler;
    AFA app;

    private String wholesale_Brand, wholesale_Brand_price_20kg, wholesale_Brand_price_24kg, wholesale_Brand_price_50kg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sugar_survey_whole_sale_brand, container, false);

        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();

        mGPS = new GPSTracker(getContext());
        return view;
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        wholesale_Brand = Objects.requireNonNull(etWholesale_Brand.getText()).toString().trim();
        wholesale_Brand_price_20kg = Objects.requireNonNull(etWholesale_Brand_price_20kg.getText()).toString().trim();
        wholesale_Brand_price_24kg = Objects.requireNonNull(etWholesale_Brand_price_24kg.getText()).toString().trim();
        wholesale_Brand_price_50kg = Objects.requireNonNull(etWholesale_Brandprice_50kg.getText()).toString().trim();

        if (TextUtils.isEmpty(wholesale_Brand)) {
            etWholesale_Brand.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(wholesale_Brand_price_20kg)) {
            etWholesale_Brand_price_20kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(wholesale_Brand_price_24kg)) {
            etWholesale_Brand_price_24kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(wholesale_Brand_price_50kg)) {
            etWholesale_Brandprice_50kg.setError("Price Required");
            return;
        }

        if (Integer.parseInt(etWholesale_Brand_price_24kg.getText().toString()) < Integer.parseInt(etWholesale_Brand_price_20kg.getText().toString())) {

            Toast.makeText(getActivity(),
                    "Price of 20KG Bale cannot be more than price of24KG Bale",
                    Toast.LENGTH_LONG).show();
            return;
        }

        if (Integer.parseInt(etWholesale_Brandprice_50kg.getText().toString()) < Integer.parseInt(etWholesale_Brand_price_24kg.getText().toString())) {

            Toast.makeText(getActivity(),
                    "Price of 24KG Bale cannot be more than price of 50 KG Bag ",
                    Toast.LENGTH_LONG).show();
            return;
        }
        SugarWholesalePricesSurveyBus sugarWholesalePricesSurveyBus = SugarWholesalePricesSurveyBus.getInstance();

        sugarWholesalePricesSurveyBus.setWholesale_Brand(wholesale_Brand);
        sugarWholesalePricesSurveyBus.setWholesale_Brand_price_20kg(wholesale_Brand_price_20kg);
        sugarWholesalePricesSurveyBus.setWholesale_Brand_price_24kg(wholesale_Brand_price_24kg);
        sugarWholesalePricesSurveyBus.setWholesale_Brand_price_50kg(wholesale_Brand_price_50kg);

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