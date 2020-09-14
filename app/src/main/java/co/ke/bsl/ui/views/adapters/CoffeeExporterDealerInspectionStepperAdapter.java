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
import co.ke.bsl.ui.views.fragments.CoffeeExporterDealerInspectionAspects;
import co.ke.bsl.ui.views.fragments.CoffeeExporterDealerInspectionChecklist;
import co.ke.bsl.ui.views.fragments.CoffeeExporterDealerInspectionPhysical;
import co.ke.bsl.ui.views.fragments.CoffeeExporterDealerInspectionQuality1;
import co.ke.bsl.ui.views.fragments.CoffeeExporterDealerInspectionQuality2;

public class CoffeeExporterDealerInspectionStepperAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public CoffeeExporterDealerInspectionStepperAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final CoffeeExporterDealerInspectionChecklist step = new CoffeeExporterDealerInspectionChecklist();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final CoffeeExporterDealerInspectionAspects step = new CoffeeExporterDealerInspectionAspects();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final CoffeeExporterDealerInspectionPhysical step = new CoffeeExporterDealerInspectionPhysical();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 3) {
            final CoffeeExporterDealerInspectionQuality1 step = new CoffeeExporterDealerInspectionQuality1();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 4) {
            final CoffeeExporterDealerInspectionQuality2 step = new CoffeeExporterDealerInspectionQuality2();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final CoffeeExporterDealerInspectionChecklist step = new CoffeeExporterDealerInspectionChecklist();
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
                    .setTitle("Coffee Exporter/Dealer Inspection Checklist")
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle("Coffee Exporter/Dealer Inspection Aspects")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle("Coffee Exporter/Dealer Inspection Physical Facilities")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle("Coffee Exporter/Dealer Inspection Quality Analysis Facility")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        } else if (position == 4) {
            return new StepViewModel.Builder(context)
                    .setTitle("Coffee Exporter/Dealer Inspection Quality Analysis Facility")
                    .setEndButtonLabel(R.string.save)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }
        return new StepViewModel.Builder(context)
                .setTitle("Coffee Exporter/Dealer Inspection")
                .setEndButtonLabel(R.string.proceed)
                .create();
    }
}
