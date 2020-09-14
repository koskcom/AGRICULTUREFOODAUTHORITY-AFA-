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

public class SugarShopSurveyAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public SugarShopSurveyAdapter(FragmentManager fm, Context context) {
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
        } else {
            final SugarShopDetails step = new SugarShopDetails();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }
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
                    .setTitle(R.string.sugar_prices_survey)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.shop_details)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        }


    }
}