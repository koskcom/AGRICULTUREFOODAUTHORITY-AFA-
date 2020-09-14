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
import co.ke.bsl.ui.views.fragments.FruitsVegetablesExportersDeskVettingChecklistStep1;
import co.ke.bsl.ui.views.fragments.FruitsVegetablesExportersDeskVettingChecklistStep2;
import co.ke.bsl.ui.views.fragments.FruitsVegetablesExportersDeskVettingChecklistStep3;

public class FruitsVegetablesExportersDeskVettingChecklistAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public FruitsVegetablesExportersDeskVettingChecklistAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final FruitsVegetablesExportersDeskVettingChecklistStep1 step = new FruitsVegetablesExportersDeskVettingChecklistStep1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final FruitsVegetablesExportersDeskVettingChecklistStep2 step = new FruitsVegetablesExportersDeskVettingChecklistStep2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final FruitsVegetablesExportersDeskVettingChecklistStep3 step = new FruitsVegetablesExportersDeskVettingChecklistStep3();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final FruitsVegetablesExportersDeskVettingChecklistStep1 step = new FruitsVegetablesExportersDeskVettingChecklistStep1();
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
                    .setTitle(R.string.fruits_Vegetables_Exporters_Desk_Vetting_Checklist)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.fruits_Vegetables_Exporters_Desk_Vetting_Checklist)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.fruits_Vegetables_Exporters_Desk_Vetting_Checklist)
                    .setEndButtonLabel(R.string.save)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle(R.string.fruits_Vegetables_Exporters_Desk_Vetting_Checklist)
                .setEndButtonLabel(R.string.proceed)
                .create();
    }
}