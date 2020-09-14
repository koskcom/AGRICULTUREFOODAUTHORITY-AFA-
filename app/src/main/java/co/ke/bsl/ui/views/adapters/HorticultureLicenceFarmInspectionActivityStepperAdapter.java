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
import co.ke.bsl.ui.views.fragments.HorticultureLicenceFarmInspectionChecklist;
import co.ke.bsl.ui.views.fragments.HorticultureLicenceFarmInspectionDetails1;
import co.ke.bsl.ui.views.fragments.HorticultureLicenceFarmInspectionDetails2;
import co.ke.bsl.ui.views.fragments.HorticultureLicenceFarmInspectionDetails3;
import co.ke.bsl.ui.views.fragments.HorticultureLicenceFarmInspectionDetails4;
import co.ke.bsl.ui.views.fragments.HorticultureLicenceFarmInspectionFarmerFarmDetails;

public class HorticultureLicenceFarmInspectionActivityStepperAdapter extends AbstractFragmentStepAdapter {

    public static final String CURRENT_STEP_POSITION_KEY = "";

    public HorticultureLicenceFarmInspectionActivityStepperAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final HorticultureLicenceFarmInspectionChecklist step = new HorticultureLicenceFarmInspectionChecklist();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }
        else if (position == 1) {
            final HorticultureLicenceFarmInspectionFarmerFarmDetails step = new HorticultureLicenceFarmInspectionFarmerFarmDetails();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }
        else if (position == 2) {
            final HorticultureLicenceFarmInspectionDetails1 step = new HorticultureLicenceFarmInspectionDetails1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 3) {
            final HorticultureLicenceFarmInspectionDetails2 step = new HorticultureLicenceFarmInspectionDetails2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 4) {
            final HorticultureLicenceFarmInspectionDetails3 step = new HorticultureLicenceFarmInspectionDetails3();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 5) {
            final HorticultureLicenceFarmInspectionDetails4 step = new HorticultureLicenceFarmInspectionDetails4();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final HorticultureLicenceFarmInspectionChecklist step = new HorticultureLicenceFarmInspectionChecklist();
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY, position);
        step.setArguments(b);
        return step;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        if (position == 0) {
            return new StepViewModel.Builder(context)
                    .setTitle("Horticultural Crops Export License Farm Inspection Checklist")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle("Horticultural Crops Export License Farm Inspection Farmer/Farm Details")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle("Horticultural Crops Export License Farm Inspection Details")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle("Horticultural Crops Export License Farm Inspection Details")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }else if (position == 4) {
            return new StepViewModel.Builder(context)
                    .setTitle("Horticultural Crops Export License Farm Inspection Details")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }else if (position == 5) {
            return new StepViewModel.Builder(context)
                    .setTitle("Horticultural Crops Export License Farm Inspection Details")
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
