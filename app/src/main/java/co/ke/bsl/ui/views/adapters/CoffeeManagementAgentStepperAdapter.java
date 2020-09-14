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
import co.ke.bsl.ui.views.fragments.CaneCensusFragment;
import co.ke.bsl.ui.views.fragments.CoffeeManagementAgentStep1;
import co.ke.bsl.ui.views.fragments.CoffeeManagementAgentStep12;
import co.ke.bsl.ui.views.fragments.CropDetailsFragment;
import co.ke.bsl.ui.views.fragments.FarmerDetailsFragment;

public class CoffeeManagementAgentStepperAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public CoffeeManagementAgentStepperAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final CoffeeManagementAgentStep1 step = new CoffeeManagementAgentStep1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final CoffeeManagementAgentStep12 step = new CoffeeManagementAgentStep12();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final CoffeeManagementAgentStep1 step = new CoffeeManagementAgentStep1();
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY, position);
        step.setArguments(b);
        return step;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        if (position == 0) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.coffee_management_agent)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.coffee_management_agent)
                    .setEndButtonLabel(R.string.save)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle(R.string.coffee_management_agent)
                .setEndButtonLabel(R.string.proceed)
                .create();
    }
}