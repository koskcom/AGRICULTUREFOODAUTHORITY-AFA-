package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.R;
import co.ke.bsl.data.view.CoffeeGrowerMarketingAgentBus;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeGrowerMarketingAgentAspects extends Fragment implements BlockingStep {

    @BindView(R.id.ch_are_markings_clear)
    CheckBox ch_are_markings_clear;
    @BindView(R.id.etare_markings_clear_remarks)
    CustomEditText etare_markings_clear_remarks;
    @BindView(R.id.ch_is_coffee_directorate)
    CheckBox ch_is_coffee_directorate;
    @BindView(R.id.etis_coffee_directorate_remarks)
    CustomEditText etis_coffee_directorate_remarks;
    @BindView(R.id.ch_has_single_business)
    CheckBox ch_has_single_business;
    @BindView(R.id.ethas_single_business_remarks)
    CustomEditText ethas_single_business_remarks;

    private String Savestring = "N";
    private String str_markings, str_directorate, str_single;


    public CoffeeGrowerMarketingAgentAspects() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_grower_marketing_agent_aspects, container, false);
        ButterKnife.bind(this, view);

        ch_are_markings_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_markings_clear.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_markings = Savestring;
            }
        });

        ch_is_coffee_directorate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_coffee_directorate.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_directorate= Savestring;
            }
        });

        ch_has_single_business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_has_single_business.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_single = Savestring;
            }
        });

        return view;

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String markings = Objects.requireNonNull(etare_markings_clear_remarks.getText()).toString().trim();
        String directorate = Objects.requireNonNull(etis_coffee_directorate_remarks.getText()).toString().trim();
        String single = Objects.requireNonNull(ethas_single_business_remarks.getText()).toString().trim();

        boolean valid = validateFields(ch_are_markings_clear, etare_markings_clear_remarks, markings) &
                validateFields(ch_is_coffee_directorate, etis_coffee_directorate_remarks, directorate) &
                validateFields(ch_has_single_business, ethas_single_business_remarks, single);

        CoffeeGrowerMarketingAgentBus coffeeGrowerMarketingAgentBus = CoffeeGrowerMarketingAgentBus.getInstance();
        coffeeGrowerMarketingAgentBus.setIsMarkings(str_markings);
        coffeeGrowerMarketingAgentBus.setIsMarkingsRemarks(markings);
        coffeeGrowerMarketingAgentBus.setIsCoffeeDirectorate(str_directorate);
        coffeeGrowerMarketingAgentBus.setIsCoffeeDirectorateRemarks(directorate);
        coffeeGrowerMarketingAgentBus.setIsSingleBusinessPermit(str_single);
        coffeeGrowerMarketingAgentBus.setIsSingleBusinessPermitRemarks(single);

        if(valid) {
            callback.goToNextStep();
        }
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        callback.goToPrevStep();
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
