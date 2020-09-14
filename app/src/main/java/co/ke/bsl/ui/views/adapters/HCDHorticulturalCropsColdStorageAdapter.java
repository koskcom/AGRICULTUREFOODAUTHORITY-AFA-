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
import co.ke.bsl.ui.views.fragments.HCDHorticulturalCropsColdStorageChanges;
import co.ke.bsl.ui.views.fragments.HCDHorticulturalCropsColdStorageIn;
import co.ke.bsl.ui.views.fragments.HCDHorticulturalCropsColdStorageOut;
import co.ke.bsl.ui.views.fragments.HCDHorticulturalCropsColdStorageRegister;

public class HCDHorticulturalCropsColdStorageAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public HCDHorticulturalCropsColdStorageAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final HCDHorticulturalCropsColdStorageRegister step = new HCDHorticulturalCropsColdStorageRegister();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final HCDHorticulturalCropsColdStorageIn step = new HCDHorticulturalCropsColdStorageIn();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final HCDHorticulturalCropsColdStorageOut step = new HCDHorticulturalCropsColdStorageOut();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 3) {
            final HCDHorticulturalCropsColdStorageChanges step = new HCDHorticulturalCropsColdStorageChanges();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final HCDHorticulturalCropsColdStorageRegister step = new HCDHorticulturalCropsColdStorageRegister();
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
                    .setTitle(R.string.horticultural_Crops_Cold_Storage_Register)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.horticultural_Crops_Cold_Storage_in)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.horticultural_Crops_Cold_Storage_out)
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.horticultural_Crops_Cold_Storage_charges)
                    .setEndButtonLabel(R.string.save)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle(R.string.horticultural_Crops_Cold_Storage_Register)
                .setEndButtonLabel(R.string.proceed)
                .create();
    }
}