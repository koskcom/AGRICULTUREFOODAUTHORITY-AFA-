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
import co.ke.bsl.data.model.CoffeeExporterDealerInspection;
import co.ke.bsl.data.view.CoffeeExporterDealerInspectionBus;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeExporterDealerInspectionAspects extends Fragment implements BlockingStep {

    @BindView(R.id.ch_are_markings_clear_ex)
    CheckBox ch_are_markings_clear_ex;
    @BindView(R.id.etare_markings_clear_ex_remarks)
    CustomEditText etare_markings_clear_ex_remarks;
    @BindView(R.id.ch_are_offices_premises_ideal)
    CheckBox ch_are_offices_premises_ideal;
    @BindView(R.id.etare_offices_premises_ideal_remarks)
    CustomEditText etare_offices_premises_ideal_remarks;
    @BindView(R.id.ch_is_coffee_directorate_licence)
    CheckBox ch_is_coffee_directorate_licence;
    @BindView(R.id.etis_coffee_directorate_licence_remarks)
    CustomEditText etis_coffee_directorate_licence_remarks;
    @BindView(R.id.ch_has_single_business_ex)
    CheckBox ch_has_single_business_ex;
    @BindView(R.id.ethas_single_business_ex_remarks)
    CustomEditText ethas_single_business_ex_remarks;

    private String Savestring = "N";
    private String str_markings,str_office, str_directorate, str_single;


    public CoffeeExporterDealerInspectionAspects() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_exporter_dealer_inspection_aspects, container, false);
        ButterKnife.bind(this, view);

        ch_are_markings_clear_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_markings_clear_ex.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_markings = Savestring;
            }
        });

        ch_are_offices_premises_ideal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_offices_premises_ideal.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_office = Savestring;
            }
        });

        ch_is_coffee_directorate_licence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_coffee_directorate_licence.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_directorate = Savestring;
            }
        });

        ch_has_single_business_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_has_single_business_ex.isChecked()) {
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
        String markings = Objects.requireNonNull(etare_markings_clear_ex_remarks.getText()).toString().trim();
        String office = Objects.requireNonNull(etare_offices_premises_ideal_remarks.getText()).toString().trim();
        String directorate = Objects.requireNonNull(etis_coffee_directorate_licence_remarks.getText()).toString().trim();
        String single = Objects.requireNonNull(ethas_single_business_ex_remarks.getText()).toString().trim();

        boolean valid = validateFields(ch_are_markings_clear_ex, etare_markings_clear_ex_remarks, markings) &
                validateFields(ch_are_offices_premises_ideal, etare_offices_premises_ideal_remarks, office) &
                validateFields(ch_is_coffee_directorate_licence, etis_coffee_directorate_licence_remarks, directorate) &
                validateFields(ch_has_single_business_ex, ethas_single_business_ex_remarks, single);

        CoffeeExporterDealerInspectionBus coffeeExporterDealerInspectionBus = CoffeeExporterDealerInspectionBus.getInstance();
        coffeeExporterDealerInspectionBus.setAreMarkingsClear(str_markings);
        coffeeExporterDealerInspectionBus.setAreMarkingsClearRemarks(office);
        coffeeExporterDealerInspectionBus.setAreOfficesPremisesIdeal(str_office);
        coffeeExporterDealerInspectionBus.setAreOfficesPremisesIdealRemarks(markings);
        coffeeExporterDealerInspectionBus.setIsCoffeeDirectorateLicenceValid(str_directorate);
        coffeeExporterDealerInspectionBus.setIsCoffeeDirectorateLicenceValidRemarks(directorate);
        coffeeExporterDealerInspectionBus.setHasSingleBusinessPermit(str_single);
        coffeeExporterDealerInspectionBus.setHasSingleBusinessPermitRemarks(single);

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

    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString){

        boolean result= false;

        if(!checkBox.isChecked()){
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                result = false;
            } else{
                result = true;
            }
        } else{
            customEditText.setError(null);
            result = true;
        }

        return result;
    }
}
