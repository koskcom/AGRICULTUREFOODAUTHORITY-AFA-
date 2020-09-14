package co.ke.bsl.ui.views.fragments;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.SugarWholesalePricesSurvey;
import co.ke.bsl.data.view.SugarWholesalePricesSurveyBus;
import co.ke.bsl.pojo.WholeSaleBrandLocal;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;
import co.ke.bsl.util.WidgetUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class SugarSurveyWholeSaleStokedBrand extends Fragment implements BlockingStep {
    @BindView(R.id.etWholeSale_Stoked_Brand)
    CustomEditText etWholeSale_Stoked_Brand;
    @BindView(R.id.etWholeSale_Stoked_Brand_price_20kg)
    CustomEditText etWholeSale_Stoked_Brand_price_20kg;
    @BindView(R.id.etWholeSale_Stoked_Brand_price_24kg)
    CustomEditText etWholeSale_Stoked_Brand_price_24kg;
    @BindView(R.id.etWholeSale_Stoked_Brand_price_of_50kg)
    CustomEditText etWholeSale_Stoked_Brand_price_of_50kg;


    protected Handler asyncTaskHandler;
    WholeSaleBrandLocal wholeSaleBrandLocal;

    AFADatabaseAdapter db;
    Boolean addMore = false;
    private AsyncActivitySupport asyncSupport;
    private List<WholeSaleBrandLocal> wholeSaleBrandLocalList;
    private GPSTracker mGPS;

    private String wholeSale_Stoked_Brand, wholeSale_Stoked_Brand_priceOf50kgBag, wholeSale_Stoked_Brand_priceOf24kgBale, wholeSale_Stoked_Brand_priceOf20kgBale;

    AFA app;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sugar_survey_whole_sale_stoked_brand, container, false);

        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getActivity()).open();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        wholeSale_Stoked_Brand = Objects.requireNonNull(etWholeSale_Stoked_Brand.getText()).toString().trim();
        wholeSale_Stoked_Brand_priceOf20kgBale = Objects.requireNonNull(etWholeSale_Stoked_Brand_price_20kg.getText()).toString().trim();
        wholeSale_Stoked_Brand_priceOf24kgBale = Objects.requireNonNull(etWholeSale_Stoked_Brand_price_24kg.getText()).toString().trim();
        wholeSale_Stoked_Brand_priceOf50kgBag = Objects.requireNonNull(etWholeSale_Stoked_Brand_price_of_50kg.getText()).toString().trim();

        if (TextUtils.isEmpty(wholeSale_Stoked_Brand)) {
            etWholeSale_Stoked_Brand.setError("Brand Required");
            return;
        }
        if (TextUtils.isEmpty(wholeSale_Stoked_Brand_priceOf20kgBale)) {
            etWholeSale_Stoked_Brand_price_20kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(wholeSale_Stoked_Brand_priceOf24kgBale)) {
            etWholeSale_Stoked_Brand_price_24kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(wholeSale_Stoked_Brand_priceOf50kgBag)) {
            etWholeSale_Stoked_Brand_price_of_50kg.setError("Price Required");
            return;
        }

        if (Integer.parseInt(etWholeSale_Stoked_Brand_price_24kg.getText().toString()) < Integer.parseInt(etWholeSale_Stoked_Brand_price_20kg.getText().toString())) {

            Toast.makeText(getContext(),
                    "Price of 20KG Bale cannot be more than price of 24KG Bale",
                    Toast.LENGTH_LONG).show();
            return;
        }


        if (Integer.parseInt(etWholeSale_Stoked_Brand_price_of_50kg.getText().toString()) < Integer.parseInt(etWholeSale_Stoked_Brand_price_24kg.getText().toString())) {

            Toast.makeText(getContext(),
                    "Price of 24KG Bale cannot be than price of 50 KG Bag ",
                    Toast.LENGTH_LONG).show();
            return;
        }

        SugarWholesalePricesSurveyBus sugarWholesalePricesSurveyBus = SugarWholesalePricesSurveyBus.getInstance();

        sugarWholesalePricesSurveyBus.setWholeSale_Stoked_Brand(wholeSale_Stoked_Brand);
        sugarWholesalePricesSurveyBus.setWholeSale_Stoked_Brand_priceOf20kgBale(wholeSale_Stoked_Brand_priceOf20kgBale);
        sugarWholesalePricesSurveyBus.setWholeSale_Stoked_Brand_priceOf24kgBale(wholeSale_Stoked_Brand_priceOf24kgBale);
        sugarWholesalePricesSurveyBus.setWholeSale_Stoked_Brand_priceOf50kgBag(wholeSale_Stoked_Brand_priceOf50kgBag);

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