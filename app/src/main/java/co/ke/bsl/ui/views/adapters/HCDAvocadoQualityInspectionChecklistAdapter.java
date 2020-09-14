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
import co.ke.bsl.ui.views.fragments.HCDAvocadoQualityInspectionChecklistStep1;
import co.ke.bsl.ui.views.fragments.HCDAvocadoQualityInspectionChecklistStep2;
import co.ke.bsl.ui.views.fragments.HCDAvocadoQualityInspectionChecklistStep3;
import co.ke.bsl.ui.views.fragments.HCDAvocadoQualityInspectionChecklistStep4;
import co.ke.bsl.ui.views.fragments.HCDAvocadoQualityInspectionChecklistStep5OilContent;

public class HCDAvocadoQualityInspectionChecklistAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public HCDAvocadoQualityInspectionChecklistAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final HCDAvocadoQualityInspectionChecklistStep1 step = new HCDAvocadoQualityInspectionChecklistStep1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final HCDAvocadoQualityInspectionChecklistStep2 step = new HCDAvocadoQualityInspectionChecklistStep2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final HCDAvocadoQualityInspectionChecklistStep3 step = new HCDAvocadoQualityInspectionChecklistStep3();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 3) {
            final HCDAvocadoQualityInspectionChecklistStep4 step = new HCDAvocadoQualityInspectionChecklistStep4();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 4) {
            final HCDAvocadoQualityInspectionChecklistStep5OilContent step = new HCDAvocadoQualityInspectionChecklistStep5OilContent();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final HCDAvocadoQualityInspectionChecklistStep1 step = new HCDAvocadoQualityInspectionChecklistStep1();
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY, position);
        step.setArguments(b);
        return step;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        if (position == 0) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.avacado_quality_inspection)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.avacado_quality_inspection)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.avacado_quality_inspection)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.avacado_quality_inspection)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }else if (position == 4) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.avacado_quality_inspection)
                    .setEndButtonLabel(R.string.save)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle(R.string.avacado_quality_inspection)
                .setEndButtonLabel(R.string.proceed)
                .create();
    }
}