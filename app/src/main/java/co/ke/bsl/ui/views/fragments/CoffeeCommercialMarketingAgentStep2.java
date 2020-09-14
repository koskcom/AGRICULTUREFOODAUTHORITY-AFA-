package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.CoffeeCommercialMarketingAgentBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeCommercialMarketingAgentStep2 extends Fragment implements BlockingStep {

    @BindView(R.id.isMarkingClear)
    CheckBox isMarkingClear;
    @BindView(R.id.etMarkingClearRemarks)
    CustomEditText etMarkingClearRemarks;
    @BindView(R.id.isCoffeeLicenceValid)
    CheckBox isCoffeeLicenceValid;
    @BindView(R.id.etCoffeeLicenceValidRemarks)
    CustomEditText etCoffeeLicenceValidRemarks;
    @BindView(R.id.isSingleBusinessPermit)
    CheckBox isSingleBusinessPermit;
    @BindView(R.id.etSingleBusinessPermitRemarks)
    CustomEditText etSingleBusinessPermitRemarks;

    private String ismarkingClear, markingClearRemarks, iscoffeeLicenceValid, coffeeLicenceValidRemarks, issingleBusinessPermit, singleBusinessPermitRemarks;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_commercial_marketing_agent_step2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();

        isMarkingClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMarkingClear.isChecked()) {
                    ismarkingClear = "Y";
                } else {
                    ismarkingClear = "N";
                }

            }
        });

        isCoffeeLicenceValid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCoffeeLicenceValid.isChecked()) {
                    iscoffeeLicenceValid = "Y";
                } else {
                    iscoffeeLicenceValid = "N";
                }

            }
        });

        isSingleBusinessPermit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSingleBusinessPermit.isChecked()) {
                    issingleBusinessPermit = "Y";
                } else {
                    issingleBusinessPermit = "N";
                }

            }
        });
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        markingClearRemarks = Objects.requireNonNull(etMarkingClearRemarks.getText()).toString().trim();
        coffeeLicenceValidRemarks = Objects.requireNonNull(etCoffeeLicenceValidRemarks.getText()).toString().trim();
        singleBusinessPermitRemarks = Objects.requireNonNull(etSingleBusinessPermitRemarks.getText()).toString().trim();

        boolean valid = validateFields(isMarkingClear, etMarkingClearRemarks, markingClearRemarks) &
                validateFields(isCoffeeLicenceValid, etCoffeeLicenceValidRemarks, coffeeLicenceValidRemarks) &
                validateFields(isSingleBusinessPermit, etSingleBusinessPermitRemarks, singleBusinessPermitRemarks);

        CoffeeCommercialMarketingAgentBus coffeeCommercialMarketingAgentBus = CoffeeCommercialMarketingAgentBus.getInstance();

        coffeeCommercialMarketingAgentBus.setIsmarkingClear(ismarkingClear);
        coffeeCommercialMarketingAgentBus.setMarkingClearRemarks(markingClearRemarks);
        coffeeCommercialMarketingAgentBus.setIscoffeeLicenceValid(iscoffeeLicenceValid);
        coffeeCommercialMarketingAgentBus.setCoffeeLicenceValidRemarks(coffeeLicenceValidRemarks);
        coffeeCommercialMarketingAgentBus.setIssingleBusinessPermit(issingleBusinessPermit);
        coffeeCommercialMarketingAgentBus.setSingleBusinessPermitRemarks(singleBusinessPermitRemarks);

        if(valid) {
            callback.goToNextStep();
        }

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {

    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    private boolean validateEditText(CustomEditText customEditText, String customEditTextString) {

        boolean result = false;

        if (TextUtils.isEmpty(customEditTextString)) {
            customEditText.setError("Field Required ");
            result = false;
        } else {
            customEditText.setError(null);
            result = true;
        }

        return result;
    }

    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString) {

        boolean result = false;

        if (!checkBox.isChecked()) {
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                result = false;
            }
            else result =true;
        } else {
            customEditText.setError(null);
            result = true;
        }

        return result;
    }
}
