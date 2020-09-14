package co.ke.bsl.ui.views.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

import co.ke.bsl.R;
import co.ke.bsl.ui.views.fragments.AFACoffeeMillerLicenceApplicationChecklist;
import co.ke.bsl.ui.views.fragments.AFACoffeeMillerLicenseApplicationGeneral;
import co.ke.bsl.ui.views.fragments.AFACoffeeMillerLicenseApplicationMillingTariffs;
import co.ke.bsl.ui.views.fragments.AFACoffeeMillerLicenseApplicationTechnical;
import co.ke.bsl.ui.views.fragments.AFACoffeeMillerLicenseApplicationWarehousing;

public class CoffeeMillerLicenseApplicationAdapter extends AbstractFragmentStepAdapter {

    public static final String CURRENT_STEP_POSITION_KEY = "";

    public CoffeeMillerLicenseApplicationAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        if (position == 0) {
            final AFACoffeeMillerLicenceApplicationChecklist step = new AFACoffeeMillerLicenceApplicationChecklist();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 1) {
            final AFACoffeeMillerLicenseApplicationGeneral step = new AFACoffeeMillerLicenseApplicationGeneral();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 2) {
            final AFACoffeeMillerLicenseApplicationTechnical step = new AFACoffeeMillerLicenseApplicationTechnical();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } else if (position == 3) {
            final AFACoffeeMillerLicenseApplicationWarehousing step = new AFACoffeeMillerLicenseApplicationWarehousing();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }else if (position == 4) {
            final AFACoffeeMillerLicenseApplicationMillingTariffs step = new AFACoffeeMillerLicenseApplicationMillingTariffs();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        }
        final AFACoffeeMillerLicenceApplicationChecklist step = new AFACoffeeMillerLicenceApplicationChecklist();
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
                    .setTitle("Coffee Miller Licence Application Checklist")
                    .setEndButtonLabel(R.string.proceed)
                    .create();
        } else if (position == 1) {
            return new StepViewModel.Builder(context)
                    .setTitle("Coffee Miller Licence Application General and Statutory Requirements")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }else if (position == 2) {
            return new StepViewModel.Builder(context)
                    .setTitle("Coffee Miller Licence Application Technical Requirements")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }else if (position == 3) {
            return new StepViewModel.Builder(context)
                    .setTitle("Coffee Miller Licence Application Warehousing Facilities")
                    .setEndButtonLabel(R.string.proceed)
                    .setBackButtonLabel(R.string.back)
                    .create();
        }else if (position == 4) {
            return new StepViewModel.Builder(context)
                    .setTitle("Coffee Miller Licence Application Tariffs")
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
