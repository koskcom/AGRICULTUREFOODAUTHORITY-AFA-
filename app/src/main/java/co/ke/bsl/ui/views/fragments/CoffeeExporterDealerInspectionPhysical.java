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
public class CoffeeExporterDealerInspectionPhysical extends Fragment implements BlockingStep {

    @BindView(R.id.ch_are_markings_clear_ex_2)
    CheckBox ch_are_markings_clear_ex_2;
    @BindView(R.id.etare_markings_clear_ex_2_remarks)
    CustomEditText etare_markings_clear_ex_2_remarks;
    @BindView(R.id.ch_are_waste_disposal_systems_ex)
    CheckBox ch_are_waste_disposal_systems_ex;
    @BindView(R.id.etare_waste_disposal_systems_ex_remarks)
    CustomEditText etare_waste_disposal_systems_ex_remarks;
    @BindView(R.id.ch_are_fire_fighting_place)
    CheckBox ch_are_fire_fighting_place;
    @BindView(R.id.etare_fire_fighting_place_remarks)
    CustomEditText etare_fire_fighting_place_remarks;
    @BindView(R.id.ch_has_fire_fighting_serviced)
    CheckBox ch_has_fire_fighting_serviced;
    @BindView(R.id.ethas_fire_fighting_serviced_remarks)
    CustomEditText ethas_fire_fighting_serviced_remarks;
    @BindView(R.id.ch_is_clean_water_available_ex)
    CheckBox ch_is_clean_water_available_ex;
    @BindView(R.id.etis_clean_water_available_ex_remarks)
    CustomEditText etis_clean_water_available_ex_remarks;
    @BindView(R.id.ch_is_general_hygiene_satisfactory_ex)
    CheckBox ch_is_general_hygiene_satisfactory_ex;
    @BindView(R.id.etis_general_hygiene_satisfactory_ex_remarks)
    CustomEditText etis_general_hygiene_satisfactory_ex_remarks;
    @BindView(R.id.ch_are_washing_rooms_clean_ex)
    CheckBox ch_are_washing_rooms_clean_ex;
    @BindView(R.id.etare_washing_rooms_clean_ex_remarks)
    CustomEditText etare_washing_rooms_clean_ex_remarks;
    @BindView(R.id.ch_is_clean_water_supplied_ex)
    CheckBox ch_is_clean_water_supplied_ex;
    @BindView(R.id.etis_clean_water_supplied_ex_remarks)
    CustomEditText etis_clean_water_supplied_ex_remarks;
    @BindView(R.id.ch_is_electricity_supplied_ex)
    CheckBox ch_is_electricity_supplied_ex;
    @BindView(R.id.etis_electricity_supplied_ex_remarks)
    CustomEditText etis_electricity_supplied_ex_remarks;

    private String Savestring = "N";

    private String str_markings, str_waste, str_fire_place, str_fire_serviced, str_clean,  str_general, str_washing, str_supplied, str_electricity;


    public CoffeeExporterDealerInspectionPhysical() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_exporter_dealer_inspection_physical, container, false);
        ButterKnife.bind(this, view);

        ch_are_markings_clear_ex_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_markings_clear_ex_2.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_markings = Savestring;
            }
        });

        ch_are_waste_disposal_systems_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_waste_disposal_systems_ex.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_waste = Savestring;
            }
        });

        ch_are_fire_fighting_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_fire_fighting_place.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_fire_place = Savestring;
            }
        });

        ch_has_fire_fighting_serviced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_has_fire_fighting_serviced.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_fire_serviced = Savestring;
            }
        });

        ch_is_clean_water_available_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_clean_water_available_ex.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_clean = Savestring;
            }
        });

        ch_is_general_hygiene_satisfactory_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_general_hygiene_satisfactory_ex.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_general = Savestring;
            }
        });

        ch_are_washing_rooms_clean_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_washing_rooms_clean_ex.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_washing = Savestring;
            }
        });

        ch_is_clean_water_supplied_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_clean_water_supplied_ex.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_supplied = Savestring;
            }
        });

        ch_is_electricity_supplied_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_electricity_supplied_ex.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_electricity = Savestring;
            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String markings = Objects.requireNonNull(etare_markings_clear_ex_2_remarks.getText()).toString().trim();
        String waste = Objects.requireNonNull(etare_waste_disposal_systems_ex_remarks.getText()).toString().trim();
        String fire_place = Objects.requireNonNull(etare_fire_fighting_place_remarks.getText()).toString().trim();
        String fire_serviced = Objects.requireNonNull(ethas_fire_fighting_serviced_remarks.getText()).toString().trim();
        String clean = Objects.requireNonNull(etis_clean_water_available_ex_remarks.getText()).toString().trim();
        String general = Objects.requireNonNull(etis_general_hygiene_satisfactory_ex_remarks.getText()).toString().trim();
        String washing = Objects.requireNonNull(etare_washing_rooms_clean_ex_remarks.getText()).toString().trim();
        String supplied = Objects.requireNonNull(etis_clean_water_supplied_ex_remarks.getText()).toString().trim();
        String electricity = Objects.requireNonNull(etis_electricity_supplied_ex_remarks.getText()).toString().trim();

        boolean valid = validateFields(ch_are_markings_clear_ex_2, etare_markings_clear_ex_2_remarks, markings) &
                validateFields(ch_are_waste_disposal_systems_ex, etare_waste_disposal_systems_ex_remarks, waste) &
                validateFields(ch_are_fire_fighting_place, etare_fire_fighting_place_remarks, fire_place) &
                validateFields(ch_has_fire_fighting_serviced, ethas_fire_fighting_serviced_remarks, fire_serviced) &
                validateFields(ch_is_clean_water_available_ex, etis_clean_water_available_ex_remarks, clean) &
                validateFields(ch_is_general_hygiene_satisfactory_ex, etis_general_hygiene_satisfactory_ex_remarks, general) &
                validateFields(ch_are_washing_rooms_clean_ex, etare_washing_rooms_clean_ex_remarks, washing) &
                validateFields(ch_is_clean_water_supplied_ex, etis_clean_water_supplied_ex_remarks, supplied) &
                validateFields(ch_is_electricity_supplied_ex, etis_electricity_supplied_ex_remarks, electricity);

        CoffeeExporterDealerInspectionBus coffeeExporterDealerInspectionBus = CoffeeExporterDealerInspectionBus.getInstance();
        coffeeExporterDealerInspectionBus.setAreMarkingsClear2(str_markings);
        coffeeExporterDealerInspectionBus.setAreMarkingsClear2Remarks(markings);
        coffeeExporterDealerInspectionBus.setAreWasteDisposalSystems(str_waste);
        coffeeExporterDealerInspectionBus.setAreWasteDisposalSystemsRemarks(waste);
        coffeeExporterDealerInspectionBus.setAreFireFightingPlace(str_fire_place);
        coffeeExporterDealerInspectionBus.setAreFireFightingPlaceRemarks(fire_place);
        coffeeExporterDealerInspectionBus.setAreFireFightingServiced(str_fire_serviced);
        coffeeExporterDealerInspectionBus.setAreFireFightingServicedRemakrs(fire_serviced);
        coffeeExporterDealerInspectionBus.setIsCleanWaterAvailable(str_clean);
        coffeeExporterDealerInspectionBus.setIsCleanWaterAvailableRemarks(clean);
        coffeeExporterDealerInspectionBus.setIsGeneralHygieneSatisfactory(str_general);
        coffeeExporterDealerInspectionBus.setIsGeneralHygieneSatisfactoryRemarks(general);
        coffeeExporterDealerInspectionBus.setAreWashingRoomsClean(str_washing);
        coffeeExporterDealerInspectionBus.setAreWashingRoomsCleanRemarks(washing);
        coffeeExporterDealerInspectionBus.setIsCleanWaterSupplied(str_supplied);
        coffeeExporterDealerInspectionBus.setIsCleanWaterSuppliedRemarks(supplied);
        coffeeExporterDealerInspectionBus.setIsElectricitySupplied(str_electricity);
        coffeeExporterDealerInspectionBus.setIsElectricitySuppliedRemarks(electricity);

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
