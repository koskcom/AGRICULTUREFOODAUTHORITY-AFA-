package co.ke.bsl.ui.views.adapters;

import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

import co.ke.bsl.R;
import co.ke.bsl.ui.views.fragments.AFASugarMillLicenceComplianceVisitChecklist;
import co.ke.bsl.ui.views.fragments.AFASugarMillLicenseComplianceVisitChecklistInfo;
import co.ke.bsl.ui.views.fragments.CaneCensusFragment;
import co.ke.bsl.ui.views.fragments.CropDetailsFragment;
import co.ke.bsl.ui.views.fragments.FarmerDetailsFragment;
public class SugarMillLicenceAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "";

    public SugarMillLicenceAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final AFASugarMillLicenceComplianceVisitChecklist step = new AFASugarMillLicenceComplianceVisitChecklist();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final AFASugarMillLicenseComplianceVisitChecklistInfo step = new AFASugarMillLicenseComplianceVisitChecklistInfo();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }

        final AFASugarMillLicenceComplianceVisitChecklist step = new AFASugarMillLicenceComplianceVisitChecklist();
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY, position);
        step.setArguments(b);
        return step;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        if (position == 0) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.sugar_mill_compliance_visit_checklist)
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle(R.string.sugar_mill_compliance_visit_checklist)
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