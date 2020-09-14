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
import co.ke.bsl.ui.views.fragments.FoodCropsExportConsignmentStep1;
import co.ke.bsl.ui.views.fragments.FoodCropsExportConsignmentStep2;
import co.ke.bsl.ui.views.fragments.FoodProcessingInspectionChecklist;
import co.ke.bsl.ui.views.fragments.FoodProcessingInspectionChecklistStep2;

public class FoodCropStepperAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public FoodCropStepperAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final FoodCropsExportConsignmentStep1 step = new FoodCropsExportConsignmentStep1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final FoodCropsExportConsignmentStep2 step = new FoodCropsExportConsignmentStep2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final FoodCropsExportConsignmentStep1 step = new FoodCropsExportConsignmentStep1();
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
                    .setTitle("Food Crop Export Inspection Checklist")
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle("Food Crop Export Inspection Checklist")
                    .setEndButtonLabel(R.string.save)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle("Food Crop Export Inspection Checklist")
                .setEndButtonLabel(R.string.proceed)
                .create();
    }
}
