package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.SugarRetailPricesSurveyBus;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class SugarSurveyRetailLooseLocalBrand extends Fragment implements BlockingStep {
    @BindView(R.id.etRetail_Loose_Local_Brandbrand)
    CustomEditText etRetail_Loose_Local_Brandbrand;
    @BindView(R.id.etRetail_Loose_Local_Brandprice_1kg)
    CustomEditText etRetail_Loose_Local_Brandprice_1kg;
    @BindView(R.id.etRetail_Loose_Local_Brandprice_2kg)
    CustomEditText etRetail_Loose_Local_Brandprice_2kg;

    private String retail_Loose_Local_Brandbrand, retail_Loose_Local_Brandprice_of_1kg, retail_Loose_Local_Brandprice_of_2kg;
    AFADatabaseAdapter db;
    AFA app;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sugar_survey_retail_loose_local_brand, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {


        retail_Loose_Local_Brandbrand = Objects.requireNonNull(etRetail_Loose_Local_Brandbrand.getText()).toString().trim();
        retail_Loose_Local_Brandprice_of_1kg = Objects.requireNonNull(etRetail_Loose_Local_Brandprice_1kg.getText()).toString().trim();
        retail_Loose_Local_Brandprice_of_2kg = Objects.requireNonNull(etRetail_Loose_Local_Brandprice_2kg.getText()).toString().trim();
        if (TextUtils.isEmpty(retail_Loose_Local_Brandbrand)) {
            etRetail_Loose_Local_Brandbrand.setError("Brand Required");
            return;
        }
        if (TextUtils.isEmpty(retail_Loose_Local_Brandprice_of_1kg)) {
            etRetail_Loose_Local_Brandprice_1kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(retail_Loose_Local_Brandprice_of_2kg)) {
            etRetail_Loose_Local_Brandprice_2kg.setError("Price Required");
            return;
        }

        SugarRetailPricesSurveyBus sugarRetailPricesSurveyBus = SugarRetailPricesSurveyBus.getInstance();

        sugarRetailPricesSurveyBus.setRetail_Loose_Local_Brandbrand(retail_Loose_Local_Brandbrand);
        sugarRetailPricesSurveyBus.setRetail_Loose_Local_Brandprice_of_1kg(retail_Loose_Local_Brandprice_of_1kg);
        sugarRetailPricesSurveyBus.setRetail_Loose_Local_Brandprice_of_2kg(retail_Loose_Local_Brandprice_of_2kg);

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