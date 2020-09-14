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
import co.ke.bsl.ui.views.fragments.HorticulturalFlowerExportersDeskVettingChecklist;
import co.ke.bsl.ui.views.fragments.HorticulturalFlowerExportersDeskVettingInfo1;
import co.ke.bsl.ui.views.fragments.HorticultureFlowerExporterDeskVettingInfo2;
import co.ke.bsl.ui.views.fragments.HorticultureFlowerExporterDeskVettingInfo3;

public class HorticultureFlowerExporterDeskVettingActivityStepperAdapter extends AbstractFragmentStepAdapter {

    public static final String CURRENT_STEP_POSITION_KEY = "";

    public HorticultureFlowerExporterDeskVettingActivityStepperAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final HorticulturalFlowerExportersDeskVettingChecklist step = new HorticulturalFlowerExportersDeskVettingChecklist();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final HorticulturalFlowerExportersDeskVettingInfo1 step = new HorticulturalFlowerExportersDeskVettingInfo1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final HorticultureFlowerExporterDeskVettingInfo2 step = new HorticultureFlowerExporterDeskVettingInfo2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 3) {
            final HorticultureFlowerExporterDeskVettingInfo3 step = new HorticultureFlowerExporterDeskVettingInfo3();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final HorticulturalFlowerExportersDeskVettingChecklist step = new HorticulturalFlowerExportersDeskVettingChecklist();
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
                    .setTitle("Horticultural Flower Exporters Desk-Vetting Checklist")
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle("Horticultural Flower Exporters Desk-Vetting Details")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle("Horticultural Flower Exporters Desk-Vetting Details")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle("Horticultural Flower Exporters Desk-Vetting Details")
                    .setEndButtonLabel(R.string.save)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle(R.string.step_1)
                .setEndButtonLabel(R.string.proceed)
                .create();
    }
}
