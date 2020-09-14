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
import co.ke.bsl.ui.views.fragments.CropDetailsFragment;
import co.ke.bsl.ui.views.fragments.FarmerDetailsFragment;
import co.ke.bsl.ui.views.fragments.HCDFlowersConsolidatorsChecklistStep1;
import co.ke.bsl.ui.views.fragments.HCDFlowersConsolidatorsChecklistStep2;
import co.ke.bsl.ui.views.fragments.HCDFlowersConsolidatorsChecklistStep3;

public class HCDFlowersConsolidatorsAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public HCDFlowersConsolidatorsAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final HCDFlowersConsolidatorsChecklistStep1 step = new HCDFlowersConsolidatorsChecklistStep1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final HCDFlowersConsolidatorsChecklistStep2 step = new HCDFlowersConsolidatorsChecklistStep2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final HCDFlowersConsolidatorsChecklistStep3 step = new HCDFlowersConsolidatorsChecklistStep3();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final HCDFlowersConsolidatorsChecklistStep1 step = new HCDFlowersConsolidatorsChecklistStep1();
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY, position);
        step.setArguments(b);
        return step;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        if (position == 0) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.flower_consolidatos)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.flower_consolidatos)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.flower_consolidatos)
                    .setEndButtonLabel(R.string.save)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle(R.string.flower_consolidatos)
                .setEndButtonLabel(R.string.proceed)
                .create();
    }
}