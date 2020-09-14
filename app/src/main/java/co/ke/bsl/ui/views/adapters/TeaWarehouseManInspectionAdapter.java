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
import co.ke.bsl.ui.views.fragments.AFAComplianceWithCodeOfHygienePart1;
import co.ke.bsl.ui.views.fragments.AFAComplianceWithCodeOfHygienePart2;
import co.ke.bsl.ui.views.fragments.AFAComplianceWithCodeOfHygienePart3;
import co.ke.bsl.ui.views.fragments.AFAComplianceWithCodeOfHygienePart4;
import co.ke.bsl.ui.views.fragments.AFAComplianceWithCodeOfHygienePart5;
import co.ke.bsl.ui.views.fragments.AFAComplianceWithRegistration;
import co.ke.bsl.ui.views.fragments.AFATeaWarehouseDesignAndHygienePart1;
import co.ke.bsl.ui.views.fragments.AFATeaWarehouseDesignAndHygienePart2;
import co.ke.bsl.ui.views.fragments.AFATeaWarehouseDesignAndHygienePart3;
import co.ke.bsl.ui.views.fragments.AFATeaWarehouseManInspectionChecklist;

public class TeaWarehouseManInspectionAdapter extends AbstractFragmentStepAdapter {

    public static final String CURRENT_STEP_POSITION_KEY = "";

    public TeaWarehouseManInspectionAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final AFATeaWarehouseManInspectionChecklist step = new AFATeaWarehouseManInspectionChecklist();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final AFAComplianceWithRegistration step = new AFAComplianceWithRegistration();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final AFAComplianceWithCodeOfHygienePart1 step = new AFAComplianceWithCodeOfHygienePart1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 3) {
            final AFAComplianceWithCodeOfHygienePart2 step = new AFAComplianceWithCodeOfHygienePart2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 4) {
            final AFAComplianceWithCodeOfHygienePart3 step = new AFAComplianceWithCodeOfHygienePart3();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 5) {
            final AFAComplianceWithCodeOfHygienePart4 step = new AFAComplianceWithCodeOfHygienePart4();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 6) {
            final AFAComplianceWithCodeOfHygienePart5 step = new AFAComplianceWithCodeOfHygienePart5();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 7) {
            final AFATeaWarehouseDesignAndHygienePart1 step = new AFATeaWarehouseDesignAndHygienePart1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 8) {
            final AFATeaWarehouseDesignAndHygienePart2 step = new AFATeaWarehouseDesignAndHygienePart2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 9) {
            final AFATeaWarehouseDesignAndHygienePart3 step = new AFATeaWarehouseDesignAndHygienePart3();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final AFATeaWarehouseManInspectionChecklist step = new AFATeaWarehouseManInspectionChecklist();
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY, position);
        step.setArguments(b);
        return step;
    }

    @Override
    public int getCount() {
        return 10;
    }


    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        if (position == 0) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.tea_warehouse_inspection_checklist)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle("Compliance With Registration")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle("Compliance With Code Of Hygiene")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle("Compliance With Code Of Hygiene")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 4) {
            return new StepViewModel.Builder(context)
                    .setTitle("Compliance With Code Of Hygiene")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 5) {
            return new StepViewModel.Builder(context)
                    .setTitle("Compliance With Code Of Hygiene")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 6) {
            return new StepViewModel.Builder(context)
                    .setTitle("Compliance With Code Of Hygiene")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 7) {
            return new StepViewModel.Builder(context)
                    .setTitle("Tea Warehouse Design And Hygiene")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 8) {
            return new StepViewModel.Builder(context)
                    .setTitle("Tea Warehouse Design And Hygiene")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 9) {
            return new StepViewModel.Builder(context)
                    .setTitle("Tea Warehouse Design And Hygiene")
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
