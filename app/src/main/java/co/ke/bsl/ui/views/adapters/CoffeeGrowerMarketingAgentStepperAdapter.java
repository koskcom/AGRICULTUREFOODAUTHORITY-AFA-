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
import co.ke.bsl.ui.views.fragments.CoffeeGrowerMarketingAgentAspects;
import co.ke.bsl.ui.views.fragments.CoffeeGrowerMarketingAgentChecklist;
import co.ke.bsl.ui.views.fragments.CoffeeGrowerMarketingAgentPhysical;
import co.ke.bsl.ui.views.fragments.CoffeeGrowerMarketingAgentQuality;

public class CoffeeGrowerMarketingAgentStepperAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public CoffeeGrowerMarketingAgentStepperAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final CoffeeGrowerMarketingAgentChecklist step = new CoffeeGrowerMarketingAgentChecklist();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final CoffeeGrowerMarketingAgentAspects step = new CoffeeGrowerMarketingAgentAspects();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final CoffeeGrowerMarketingAgentPhysical step = new CoffeeGrowerMarketingAgentPhysical();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 3) {
            final CoffeeGrowerMarketingAgentQuality step = new CoffeeGrowerMarketingAgentQuality();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final CoffeeGrowerMarketingAgentChecklist step = new CoffeeGrowerMarketingAgentChecklist();
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
                    .setTitle("Coffee Grower Marketing Agent Inspection Checklist")
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle("Coffee Grower Marketing Agent Inspection Aspects")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle("Coffee Grower Marketing Agent Inspection Physical Facilities")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle("Coffee Grower Marketing Agent Inspection Quality Analysis Facility")
                    .setEndButtonLabel(R.string.save)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle("Coffee Grower Marketing Agent Inspection")
                .setEndButtonLabel(R.string.proceed)
                .create();
    }
}
