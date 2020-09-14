package co.ke.bsl.ui.views.adapters;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

import co.ke.bsl.R;
import co.ke.bsl.ui.views.fragments.SugarRetailPricesSurveyFragment;
import co.ke.bsl.ui.views.fragments.SugarShopDetails;
import co.ke.bsl.ui.views.fragments.SugarSurveyWholeSaleBrand;
import co.ke.bsl.ui.views.fragments.SugarSurveyWholeSaleImported;
import co.ke.bsl.ui.views.fragments.SugarSurveyWholeSaleImportedStocked;
import co.ke.bsl.ui.views.fragments.SugarSurveyWholeSaleStokedBrand;
import co.ke.bsl.ui.views.fragments.SugarWholesalePricesSurveyFragment;

public class SugarPricesSurveyWholesaleAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public SugarPricesSurveyWholesaleAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final SugarWholesalePricesSurveyFragment step = new SugarWholesalePricesSurveyFragment();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final SugarShopDetails step = new SugarShopDetails();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final SugarSurveyWholeSaleBrand step = new SugarSurveyWholeSaleBrand();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 3) {
            final SugarSurveyWholeSaleImported step = new SugarSurveyWholeSaleImported();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 4) {
            final SugarSurveyWholeSaleStokedBrand step = new SugarSurveyWholeSaleStokedBrand();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 5) {
            final SugarSurveyWholeSaleImportedStocked step = new SugarSurveyWholeSaleImportedStocked();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final SugarRetailPricesSurveyFragment step = new SugarRetailPricesSurveyFragment();
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY, position);
        step.setArguments(b);

        return step;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        if (position == 0) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.sugar_Wholesale_Prices_Survey)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.shop_details)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.sugar_Survey_WholeSale_Brand)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.sugar_Survey_WholeSale_Imported)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        }
        else if (position == 4) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.sugar_Survey_WholeSale_Stoked_Brand)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        }else if (position == 5) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.sugar_Survey_WholeSale_Imported_Stocked)
                    .setEndButtonLabel(R.string.save)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle(R.string.sugar_Wholesale_Prices_Survey)
                .setEndButtonLabel(R.string.proceed)
                .create();
    }
}