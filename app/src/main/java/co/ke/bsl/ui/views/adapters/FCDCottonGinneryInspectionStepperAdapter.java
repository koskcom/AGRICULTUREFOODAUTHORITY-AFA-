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
import co.ke.bsl.ui.views.fragments.FCDCottonGinneryInspectionConformityAssessmentStep1;
import co.ke.bsl.ui.views.fragments.FCDCottonGinneryInspectionConformityAssessmentStep2;
import co.ke.bsl.ui.views.fragments.FCDCottonGinneryInspectionConformityAssessmentStep3;
import co.ke.bsl.ui.views.fragments.FCDCottonGinneryInspectionConformityAssessmentStep4;
import co.ke.bsl.ui.views.fragments.FCDCottonGinneryInspectionConformityAssessmentStep5;

public class FCDCottonGinneryInspectionStepperAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public FCDCottonGinneryInspectionStepperAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final FCDCottonGinneryInspectionConformityAssessmentStep1 step = new FCDCottonGinneryInspectionConformityAssessmentStep1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final FCDCottonGinneryInspectionConformityAssessmentStep2 step = new FCDCottonGinneryInspectionConformityAssessmentStep2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final FCDCottonGinneryInspectionConformityAssessmentStep3 step = new FCDCottonGinneryInspectionConformityAssessmentStep3();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }else if (position == 3) {
            final FCDCottonGinneryInspectionConformityAssessmentStep4 step = new FCDCottonGinneryInspectionConformityAssessmentStep4();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }else if (position == 4) {
            final FCDCottonGinneryInspectionConformityAssessmentStep5 step = new FCDCottonGinneryInspectionConformityAssessmentStep5();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final FCDCottonGinneryInspectionConformityAssessmentStep1 step = new FCDCottonGinneryInspectionConformityAssessmentStep1();
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
                    .setTitle(R.string.cotton_ginnery_inspection)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.cotton_ginnery_inspection)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.cotton_ginnery_inspection)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.cotton_ginnery_inspection)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }else if (position == 4) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.cotton_ginnery_inspection)
                    .setEndButtonLabel(R.string.save)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle(R.string.cotton_ginnery_inspection)
                .setEndButtonLabel(R.string.proceed)
                .create();
    }
}