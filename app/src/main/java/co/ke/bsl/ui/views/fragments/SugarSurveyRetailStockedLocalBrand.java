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
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.SugarRetailPricesSurvey;
import co.ke.bsl.data.view.SugarRetailPricesSurveyBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.CaneCensusRecordViewModel;
import co.ke.bsl.ui.viewmodels.SugarRetailsPricesSurveyViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class SugarSurveyRetailStockedLocalBrand extends Fragment implements BlockingStep {
    @BindView(R.id.etRetail_Stocked_Local_Brand)
    CustomEditText etRetail_Stocked_Local_Brand;
    @BindView(R.id.etRetail_Stocked_Local_Brand_price_20kg)
    CustomEditText etRetail_Stocked_Local_Brand_price_20kg;
    @BindView(R.id.etRetail_Stocked_Local_Brand_price_24kg)
    CustomEditText etRetail_Stocked_Local_Brand_price_24kg;
    @BindView(R.id.etRetail_Stocked_Local_Brand_price_of_50kg)
    CustomEditText etRetail_Stocked_Local_Brand_price_of_50kg;

    private GPSTracker mGPS;
    AFADatabaseAdapter db;
    protected Handler asyncTaskHandler;
    private AsyncActivitySupport asyncSupport;
    private SugarRetailsPricesSurveyViewModel sugarRetailsPricesSurveyViewModel;
    AFA app;
    private ArrayList<String> countryoforiginlist = new ArrayList<>();

    private String retail_stocked_local_brand, retail_Stocked_Local_Brandprice_of_20kg, retail_Stocked_Local_Brandprice_of_24kg, retail_Stocked_Local_Brandprice_of_50kg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sugar_survey_retail_stocked_local_brand, container, false);

        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();

        mGPS = new GPSTracker(getContext());

        sugarRetailsPricesSurveyViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(SugarRetailsPricesSurveyViewModel.class);


        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {


        retail_stocked_local_brand = Objects.requireNonNull(etRetail_Stocked_Local_Brand.getText()).toString().trim();
        retail_Stocked_Local_Brandprice_of_20kg = Objects.requireNonNull(etRetail_Stocked_Local_Brand_price_20kg.getText()).toString().trim();
        retail_Stocked_Local_Brandprice_of_24kg = Objects.requireNonNull(etRetail_Stocked_Local_Brand_price_24kg.getText()).toString().trim();
        retail_Stocked_Local_Brandprice_of_50kg = Objects.requireNonNull(etRetail_Stocked_Local_Brand_price_of_50kg.getText()).toString().trim();

        if (TextUtils.isEmpty(retail_stocked_local_brand)) {
            etRetail_Stocked_Local_Brand.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(retail_Stocked_Local_Brandprice_of_20kg)) {
            etRetail_Stocked_Local_Brand_price_20kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(retail_Stocked_Local_Brandprice_of_24kg)) {
            etRetail_Stocked_Local_Brand_price_24kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(retail_Stocked_Local_Brandprice_of_50kg)) {
            etRetail_Stocked_Local_Brand_price_of_50kg.setError("Price Required");
            return;
        }
        SugarRetailPricesSurveyBus sugarRetailPricesSurveyBus = SugarRetailPricesSurveyBus.getInstance();

        SugarRetailPricesSurvey sugarRetailPricesSurvey = new SugarRetailPricesSurvey(
                0,
                sugarRetailPricesSurveyBus.getSurveyType(),
                sugarRetailPricesSurveyBus.getCity(),
                sugarRetailPricesSurveyBus.getDocument_Number(),
                sugarRetailPricesSurveyBus.getDocument_date(),
                sugarRetailPricesSurveyBus.getSurvey_Ending(),

                sugarRetailPricesSurveyBus.getShop(),

                sugarRetailPricesSurveyBus.getRetail_local_Brand(),
                sugarRetailPricesSurveyBus.getRetail_local_Brandprice_1kg(),
                sugarRetailPricesSurveyBus.getRetail_local_Brandprice_2kg(),

                sugarRetailPricesSurveyBus.getRetail_Loose_Imported_price_origin(),
                sugarRetailPricesSurveyBus.getRetail_Loose_Imported_price_of_1kg(),
                sugarRetailPricesSurveyBus.getRetail_Loose_Imported_price_of_2kg(),

                sugarRetailPricesSurveyBus.getRetail_Loose_Local_Brandbrand(),
                sugarRetailPricesSurveyBus.getRetail_Loose_Local_Brandprice_of_1kg(),
                sugarRetailPricesSurveyBus.getRetail_Loose_Local_Brandprice_of_2kg(),

                sugarRetailPricesSurveyBus.getRetail_Stocked_Imported_origin(),
                sugarRetailPricesSurveyBus.getRetail_Stocked_Imported_price_of_20kg(),
                sugarRetailPricesSurveyBus.getRetail_Stocked_Imported_price_of_24kg(),
                sugarRetailPricesSurveyBus.getRetail_Stocked_Imported_price_of_50kg(),

                retail_stocked_local_brand,
                retail_Stocked_Local_Brandprice_of_20kg,
                retail_Stocked_Local_Brandprice_of_24kg,
                retail_Stocked_Local_Brandprice_of_50kg,
                false,
                ""
        );

        new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Sugar Retail Inspection!")
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

                        sugarRetailsPricesSurveyViewModel.addRecord(sugarRetailPricesSurvey);

                        long shop_id = db.insertShopRecords(sugarRetailPricesSurveyBus.getShop(), String.valueOf(mGPS.getLongitude()),
                                String.valueOf(mGPS.getLatitude()), sugarRetailPricesSurveyBus.getSurveyType());


                        db.insertRetailLocalBrand(sugarRetailPricesSurveyBus.getRetail_local_Brand(), sugarRetailPricesSurveyBus.getRetail_local_Brandprice_1kg(),
                                sugarRetailPricesSurveyBus.getRetail_local_Brandprice_2kg(), Integer.parseInt(String.valueOf(shop_id)), "0");

                        db.insertRetailLooseSugarPricesRangeLocal(sugarRetailPricesSurveyBus.getRetail_Loose_Local_Brandbrand(), sugarRetailPricesSurveyBus.getRetail_Loose_Local_Brandprice_of_1kg(),
                                sugarRetailPricesSurveyBus.getRetail_Loose_Local_Brandprice_of_2kg(), Integer.parseInt(String.valueOf(shop_id)), "0");

                        db.insertRetailLooseSugarPricesRangeImported(sugarRetailPricesSurveyBus.getRetail_Loose_Imported_price_origin(), sugarRetailPricesSurveyBus.getRetail_Loose_Imported_price_of_1kg(),
                                sugarRetailPricesSurveyBus.getRetail_Loose_Imported_price_of_2kg(), Integer.parseInt(String.valueOf(shop_id)), 0);

                        db.insertRetailStockedSugarPricesRangeImported(sugarRetailPricesSurveyBus.getRetail_Stocked_Imported_origin(), sugarRetailPricesSurveyBus.getRetail_Stocked_Imported_price_of_20kg(),
                                sugarRetailPricesSurveyBus.getRetail_Stocked_Imported_price_of_24kg(),
                                sugarRetailPricesSurveyBus.getRetail_Stocked_Imported_price_of_50kg(), Integer.parseInt(String.valueOf(shop_id)), 0);

                        db.insertRetailStockedSugarPricesRangeLocal(
                                retail_stocked_local_brand,
                                retail_Stocked_Local_Brandprice_of_20kg,
                                retail_Stocked_Local_Brandprice_of_24kg,
                                retail_Stocked_Local_Brandprice_of_50kg,
                                Integer.parseInt(String.valueOf(shop_id)),
                                "0");

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