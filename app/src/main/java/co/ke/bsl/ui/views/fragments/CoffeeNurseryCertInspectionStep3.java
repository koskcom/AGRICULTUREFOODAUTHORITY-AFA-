package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.CoffeeNuerseryCertBus;
import co.ke.bsl.pojo.CoffeeNursercertInsp;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeNurseryCertInspectionStep3 extends Fragment implements BlockingStep {


    @BindView(R.id.etTitleDeed)
    CustomEditText etTitleDeed;
    @BindView(R.id.isTitleDeed)
    CheckBox isTitleDeed;
    @BindView(R.id.etTitleDeedremarks)
    CustomEditText etTitleDeedremarks;
    @BindView(R.id.etCoffeecreage)
    CustomEditText etCoffeecreage;
    @BindView(R.id.etProduction)
    CustomEditText etProduction;
    @BindView(R.id.etNurseryCategory)
    CustomEditText etNurseryCategory;
    @BindView(R.id.isNurseryCategory)
    CheckBox isNurseryCategory;
    @BindView(R.id.etNurseryCategoryRemarks)
    CustomEditText etNurseryCategoryRemarks;

    private String titledeedIsTitledeed, coffeeacreage, production, nurserycategory, naurseryCategoryIsNursery;
    private String titledeedRemarks, nurserycategoryRemarks;
    CoffeeNursercertInsp coffeeNursercertInsp = new CoffeeNursercertInsp();


    AFADatabaseAdapter db;
    AFA app;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_inspection_step3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        coffeeNursercertInsp = db.getCoffeeNurseryInspSelected();

        if(null != coffeeNursercertInsp & !coffeeNursercertInsp.getTitleDeed().isEmpty()){
            etTitleDeed.setText(coffeeNursercertInsp.getTitleDeed());
        }
        if(null != coffeeNursercertInsp & !coffeeNursercertInsp.getNurserycategory().isEmpty()){
            etNurseryCategory.setText(coffeeNursercertInsp.getNurserycategory());
        }

        isTitleDeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTitleDeed.isChecked()) {
                    titledeedIsTitledeed = "Y";
                } else {
                    titledeedIsTitledeed = "N";
                }

            }
        });

        isNurseryCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNurseryCategory.isChecked()) {
                    naurseryCategoryIsNursery = "Y";
                } else {
                    naurseryCategoryIsNursery = "N";
                }

            }
        });
        return view;

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        titledeedRemarks = Objects.requireNonNull(etTitleDeedremarks.getText()).toString().trim();
        coffeeacreage = Objects.requireNonNull(etCoffeecreage.getText()).toString().trim();
        production = Objects.requireNonNull(etProduction.getText()).toString().trim();
        nurserycategory = Objects.requireNonNull(etNurseryCategory.getText()).toString().trim();
        nurserycategoryRemarks = Objects.requireNonNull(etNurseryCategoryRemarks.getText()).toString().trim();

        boolean valid = validateFields(isTitleDeed, etTitleDeedremarks, titledeedRemarks) &
                validateFields(isNurseryCategory, etNurseryCategoryRemarks, nurserycategoryRemarks) &
                validateEditText(etCoffeecreage, coffeeacreage) &
                validateEditText(etProduction, production);


        CoffeeNuerseryCertBus coffeeNuerseryCertBus = CoffeeNuerseryCertBus.getInstance();

        coffeeNuerseryCertBus.setTitledeedIsTitledeed(titledeedIsTitledeed);
        coffeeNuerseryCertBus.setTitledeedRemarks(titledeedRemarks);
        coffeeNuerseryCertBus.setCoffeeacreage(coffeeacreage);
        coffeeNuerseryCertBus.setProduction(production);
        coffeeNuerseryCertBus.setNurserycategory(nurserycategory);
        coffeeNuerseryCertBus.setNaurseryCategoryIsNursery(naurseryCategoryIsNursery);
        coffeeNuerseryCertBus.setNurserycategoryRemarks(nurserycategoryRemarks);

        if(valid) {
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

    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString) {

        boolean result = false;

        if (!checkBox.isChecked()) {
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                result = false;
            }
        } else {
            customEditText.setError(null);
            result = true;
        }

        return result;
    }

    private boolean validateEditText(CustomEditText customEditText, String customEditTextString) {

        boolean result = false;

        if (TextUtils.isEmpty(customEditTextString)) {
            customEditText.setError("Field Required ");
            result = false;
        } else {
            customEditText.setError(null);
            result = true;
        }

        return result;
    }

  
}
