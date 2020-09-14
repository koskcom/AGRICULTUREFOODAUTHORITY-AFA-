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
import co.ke.bsl.ui.views.fragments.TeaBuyerImporterExporterStep1;
import co.ke.bsl.ui.views.fragments.TeaBuyerImporterExporterStep2;
import co.ke.bsl.ui.views.fragments.TeaBuyerImporterExporterStep3;
import co.ke.bsl.ui.views.fragments.TeaBuyerImporterExporterStep4;
import co.ke.bsl.ui.views.fragments.TeaBuyerImporterExporterStep5;

public class TeaBuyerImporterExporterAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public TeaBuyerImporterExporterAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final TeaBuyerImporterExporterStep1 step = new TeaBuyerImporterExporterStep1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final TeaBuyerImporterExporterStep2 step = new TeaBuyerImporterExporterStep2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final TeaBuyerImporterExporterStep3 step = new TeaBuyerImporterExporterStep3();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }
        else if (position == 3) {
            final TeaBuyerImporterExporterStep4 step = new TeaBuyerImporterExporterStep4();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }else if (position == 4) {
            final TeaBuyerImporterExporterStep5 step = new TeaBuyerImporterExporterStep5();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final TeaBuyerImporterExporterStep1 step = new TeaBuyerImporterExporterStep1();
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
                    .setTitle(R.string.tea_buyer_iporter_exporter)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.compliance_with_reg_36mks)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.compliance_with_hygiene)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.process_control)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        else if (position == 4) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.personal_hygiene)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        else if (position == 5) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.process_control_14mks)
                    .setEndButtonLabel(R.string.save)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }

        return new StepViewModel.Builder(context)
                .setTitle(R.string.teacker_inspection)
                .setEndButtonLabel(R.string.proceed)
                .create();
    }


}