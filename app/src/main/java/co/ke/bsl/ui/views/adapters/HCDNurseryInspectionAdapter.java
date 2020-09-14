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
import co.ke.bsl.ui.views.fragments.HCDNurseryInspectionDetails;
import co.ke.bsl.ui.views.fragments.HCDNurseryInspectionStep1;
import co.ke.bsl.ui.views.fragments.HCDNurseryInspectionStep2;
import co.ke.bsl.ui.views.fragments.HCDNurseryInspectionStep3;

public class HCDNurseryInspectionAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public HCDNurseryInspectionAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final HCDNurseryInspectionDetails step = new HCDNurseryInspectionDetails();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final HCDNurseryInspectionStep1 step = new HCDNurseryInspectionStep1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final HCDNurseryInspectionStep2 step = new HCDNurseryInspectionStep2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }else if (position == 3) {
            final HCDNurseryInspectionStep3 step = new HCDNurseryInspectionStep3();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final HCDNurseryInspectionDetails step = new HCDNurseryInspectionDetails();
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
                    .setTitle(R.string.nursery_inpection)
                    .setBackButtonLabel(R.string.back)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.nursery_inpection)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.nursery_inpection)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.nursery_inpection)
                    .setEndButtonLabel(R.string.save)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle(R.string.nursery_inpection)
                .setEndButtonLabel(R.string.proceed)
                .create();
    }
}