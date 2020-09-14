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
import co.ke.bsl.ui.views.fragments.CoffeeNurseryCertInspectionStep1;
import co.ke.bsl.ui.views.fragments.CoffeeNurseryCertInspectionStep2;
import co.ke.bsl.ui.views.fragments.CoffeeNurseryCertInspectionStep3;
import co.ke.bsl.ui.views.fragments.CoffeeNurseryCertInspectionStep4;

public class CoffeeNurseryCertAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public CoffeeNurseryCertAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final CoffeeNurseryCertInspectionStep1 step = new CoffeeNurseryCertInspectionStep1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final CoffeeNurseryCertInspectionStep2 step = new CoffeeNurseryCertInspectionStep2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final CoffeeNurseryCertInspectionStep3 step = new CoffeeNurseryCertInspectionStep3();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 3) {
            final CoffeeNurseryCertInspectionStep4 step = new CoffeeNurseryCertInspectionStep4();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final CoffeeNurseryCertInspectionStep1 step = new CoffeeNurseryCertInspectionStep1();
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY, position);
        step.setArguments(b);
        return step;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        if (position == 0) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.coffee_nursery_inp)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.coffee_nursery_inp)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.coffee_nursery_inp)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.coffee_nursery_inp)
                    .setEndButtonLabel(R.string.save)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }

        return new StepViewModel.Builder(context)
                .setTitle(R.string.coffee_nursery_inp)
                .setEndButtonLabel(R.string.proceed)
                .create();
    }
}