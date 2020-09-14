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
import co.ke.bsl.ui.views.fragments.SugarSurveyRetailLocalBrand;
import co.ke.bsl.ui.views.fragments.SugarSurveyRetailLooseImported;
import co.ke.bsl.ui.views.fragments.SugarSurveyRetailLooseLocalBrand;
import co.ke.bsl.ui.views.fragments.SugarSurveyRetailStockedImported;
import co.ke.bsl.ui.views.fragments.SugarSurveyRetailStockedLocalBrand;

public class SugarPricesSurveyRetailAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public SugarPricesSurveyRetailAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {

        if (position == 0) {
            final SugarRetailPricesSurveyFragment step = new SugarRetailPricesSurveyFragment();
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
            final SugarSurveyRetailLooseLocalBrand step = new SugarSurveyRetailLooseLocalBrand();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 3) {
            final SugarSurveyRetailLooseImported step = new SugarSurveyRetailLooseImported();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 4) {
            final SugarSurveyRetailLocalBrand step = new SugarSurveyRetailLocalBrand();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 5) {
            final SugarSurveyRetailStockedImported step = new SugarSurveyRetailStockedImported();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 6) {
            final SugarSurveyRetailStockedLocalBrand step = new SugarSurveyRetailStockedLocalBrand();
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
        return 7;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        if (position == 0) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.sugar_survey_retail)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.shop_details)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.sugar_Survey_Retail_Loose_Local_Brand)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.sugar_Survey_Retail_Loose_Imported)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 4) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.sugar_Survey_Retail_Local_Brand)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 5) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.sugar_Survey_Retail_Stocked_Imported)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 6) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.sugar_Survey_Retail_Stocked_Local_Brand)
                    .setEndButtonLabel(R.string.save)
                    .create();
        }

        return new StepViewModel.Builder(context)
                .setTitle(R.string.sugar_survey_retail)
                .setEndButtonLabel(R.string.proceed)
                .create();
    }
}