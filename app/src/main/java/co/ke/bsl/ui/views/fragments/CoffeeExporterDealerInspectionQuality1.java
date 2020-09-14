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
import co.ke.bsl.data.view.CoffeeExporterDealerInspectionBus;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeExporterDealerInspectionQuality1 extends Fragment implements BlockingStep {

    @BindView(R.id.ch_is_sample_roaster_in_place)
    CheckBox ch_is_sample_roaster_in_place;
    @BindView(R.id.etis_sample_roaster_in_place_remarks)
    CustomEditText etis_sample_roaster_in_place_remarks;
    @BindView(R.id.ch_is_sample_grinder_in_place)
    CheckBox ch_is_sample_grinder_in_place;
    @BindView(R.id.etis_sample_grinder_in_place_remarks)
    CustomEditText etis_sample_grinder_in_place_remarks;
    @BindView(R.id.ch_are_spitting_drums_in_place)
    CheckBox ch_are_spitting_drums_in_place;
    @BindView(R.id.etare_spitting_drums_in_place_remarks)
    CustomEditText etare_spitting_drums_in_place_remarks;
    @BindView(R.id.ch_are_testing_cups_in_place)
    CheckBox ch_are_testing_cups_in_place;
    @BindView(R.id.etare_testing_cups_in_place_remarks)
    CustomEditText etare_testing_cups_in_place_remarks;
    @BindView(R.id.ch_is_sample_trays_in_place)
    CheckBox ch_is_sample_trays_in_place;
    @BindView(R.id.etis_sample_trays_in_place_remarks)
    CustomEditText etis_sample_trays_in_place_remarks;
    @BindView(R.id.ch_are_spoons_in_place)
    CheckBox ch_are_spoons_in_place;
    @BindView(R.id.etare_spoons_in_place_remarks)
    CustomEditText etare_spoons_in_place_remarks;
    @BindView(R.id.ch_is_water_heating_system_in_place)
    CheckBox ch_is_water_heating_system_in_place;
    @BindView(R.id.etis_water_heating_system_in_place_remarks)
    CustomEditText etis_water_heating_system_in_place_remarks;
    @BindView(R.id.ch_is_moisture_meter_in_place)
    CheckBox ch_is_moisture_meter_in_place;
    @BindView(R.id.etis_moisture_meter_in_place_remarks)
    CustomEditText etis_moisture_meter_in_place_remarks;


    private String Savestring = "N";

    private String str_roaster, str_grinder, str_spitting, str_testing, str_trays, str_spoons, str_water, str_moisture;


    public CoffeeExporterDealerInspectionQuality1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_exporter_dealer_inspection_quality1, container, false);
        ButterKnife.bind(this, view);

        ch_is_sample_roaster_in_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_sample_roaster_in_place.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_roaster = Savestring;
            }
        });

        ch_is_sample_grinder_in_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_sample_grinder_in_place.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_grinder = Savestring;
            }
        });

        ch_are_spitting_drums_in_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_spitting_drums_in_place.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_spitting = Savestring;
            }
        });

        ch_are_testing_cups_in_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_testing_cups_in_place.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_testing = Savestring;
            }
        });

        ch_is_sample_trays_in_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_sample_trays_in_place.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_trays = Savestring;
            }
        });

        ch_are_spoons_in_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_spoons_in_place.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_spoons = Savestring;
            }
        });

        ch_is_water_heating_system_in_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_water_heating_system_in_place.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_water = Savestring;
            }
        });

        ch_is_moisture_meter_in_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_moisture_meter_in_place.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_moisture = Savestring;
            }
        });



        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String roaster = Objects.requireNonNull(etis_sample_roaster_in_place_remarks.getText()).toString().trim();
        String grinder = Objects.requireNonNull(etis_sample_grinder_in_place_remarks.getText()).toString().trim();
        String spitting = Objects.requireNonNull(etare_spitting_drums_in_place_remarks.getText()).toString().trim();
        String testing = Objects.requireNonNull(etare_testing_cups_in_place_remarks.getText()).toString().trim();
        String trays = Objects.requireNonNull(etis_sample_trays_in_place_remarks.getText()).toString().trim();
        String spoons = Objects.requireNonNull(etare_spoons_in_place_remarks.getText()).toString().trim();
        String water= Objects.requireNonNull(etis_water_heating_system_in_place_remarks.getText()).toString().trim();
        String moisture= Objects.requireNonNull(etis_moisture_meter_in_place_remarks.getText()).toString().trim();

        boolean valid = validateFields(ch_is_sample_roaster_in_place, etis_sample_roaster_in_place_remarks, roaster)&
                validateFields(ch_is_sample_grinder_in_place, etis_sample_grinder_in_place_remarks, grinder) &
                validateFields(ch_are_spitting_drums_in_place, etare_spitting_drums_in_place_remarks, spitting) &
                validateFields(ch_are_testing_cups_in_place, etare_testing_cups_in_place_remarks, testing) &
                validateFields(ch_is_sample_trays_in_place, etis_sample_trays_in_place_remarks, trays) &
                validateFields(ch_are_spoons_in_place, etare_spoons_in_place_remarks, spoons) &
                validateFields(ch_is_water_heating_system_in_place, etis_water_heating_system_in_place_remarks, water) &
                validateFields(ch_is_moisture_meter_in_place, etis_moisture_meter_in_place_remarks, moisture);

        CoffeeExporterDealerInspectionBus coffeeExporterDealerInspectionBus = CoffeeExporterDealerInspectionBus.getInstance();
        coffeeExporterDealerInspectionBus.setIsSampleRoasterInPlace(str_roaster);
        coffeeExporterDealerInspectionBus.setIsSampleRoasterInPlaceRemarks(roaster);
        coffeeExporterDealerInspectionBus.setIsSampleGrinderInPlace(str_grinder);
        coffeeExporterDealerInspectionBus.setIsSampleGrinderInPlaceRemarks(grinder);
        coffeeExporterDealerInspectionBus.setAreSpittingDrumsInPlace(str_spitting);
        coffeeExporterDealerInspectionBus.setAreSpittingDrumsInPlaceRemarks(spitting);
        coffeeExporterDealerInspectionBus.setAreTestingCupsInPlace(str_testing);
        coffeeExporterDealerInspectionBus.setAreTestingCupsInPlaceRemarks(testing);
        coffeeExporterDealerInspectionBus.setIsSampleTraysInPlace(str_trays);
        coffeeExporterDealerInspectionBus.setIsSampleTraysInPlaceRemarks(trays);
        coffeeExporterDealerInspectionBus.setAreSpoonsInPlace(str_spoons);
        coffeeExporterDealerInspectionBus.setAreSpoonsInPlaceRemarks(spoons);
        coffeeExporterDealerInspectionBus.setIsWaterHeatingSystemInPlace(str_water);
        coffeeExporterDealerInspectionBus.setIsWaterHeatingSystemInPlaceRemarks(water);
        coffeeExporterDealerInspectionBus.setIsMoistureMeterInPlace(str_moisture);
        coffeeExporterDealerInspectionBus.setIsMoistureMeterInPlaceRemarks(moisture);

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
