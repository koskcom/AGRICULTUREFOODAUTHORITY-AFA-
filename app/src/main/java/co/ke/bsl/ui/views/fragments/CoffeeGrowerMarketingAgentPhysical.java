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
public class CoffeeGrowerMarketingAgentPhysical extends Fragment implements BlockingStep {
    @BindView(R.id.ch_are_waste_disposal_systems)
    CheckBox ch_are_waste_disposal_systems;
    @BindView(R.id.etare_waste_disposal_systems_remarks)
    CustomEditText etare_waste_disposal_systems_remarks;
    @BindView(R.id.ch_has_fire_fighting_equipment)
    CheckBox ch_has_fire_fighting_equipment;
    @BindView(R.id.ethas_fire_fighting_equipment_remarks)
    CustomEditText ethas_fire_fighting_equipment_remarks;
    @BindView(R.id.ch_is_general_hygiene_satisfactory)
    CheckBox ch_is_general_hygiene_satisfactory;
    @BindView(R.id.etis_general_hygiene_satisfactory_remarks)
    CustomEditText etis_general_hygiene_satisfactory_remarks;
    @BindView(R.id.ch_are_washing_rooms_clean)
    CheckBox ch_are_washing_rooms_clean;
    @BindView(R.id.etare_washing_rooms_clean_remarks)
    CustomEditText etare_washing_rooms_clean_remarks;
    @BindView(R.id.ch_is_clean_water_supplied)
    CheckBox ch_is_clean_water_supplied;
    @BindView(R.id.etis_clean_water_supplied_remarks)
    CustomEditText etis_clean_water_supplied_remarks;
    @BindView(R.id.ch_is_electricity_supplied)
    CheckBox ch_is_electricity_supplied;
    @BindView(R.id.etis_electricity_supplied_remarks)
    CustomEditText etis_electricity_supplied_remarks;

    private String Savestring = "N";

    private String str_waste, str_fire, str_general, str_washing, str_clean, str_electricity;



    public CoffeeGrowerMarketingAgentPhysical() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_grower_marketing_agent_physical, container, false);
        ButterKnife.bind(this, view);

        ch_are_waste_disposal_systems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_waste_disposal_systems.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_waste = Savestring;
            }
        });

        ch_has_fire_fighting_equipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_has_fire_fighting_equipment.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_fire = Savestring;
            }
        });

        ch_is_general_hygiene_satisfactory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_general_hygiene_satisfactory.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_general = Savestring;
            }
        });

        ch_are_washing_rooms_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_washing_rooms_clean.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_washing = Savestring;
            }
        });

        ch_is_clean_water_supplied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_clean_water_supplied.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_clean = Savestring;
            }
        });

        ch_is_electricity_supplied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_electricity_supplied.isChecked()) {
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
        String waste = Objects.requireNonNull(etare_waste_disposal_systems_remarks.getText()).toString().trim();
        String fire = Objects.requireNonNull(ethas_fire_fighting_equipment_remarks.getText()).toString().trim();
        String general = Objects.requireNonNull(etis_general_hygiene_satisfactory_remarks.getText()).toString().trim();
        String washing = Objects.requireNonNull(etare_washing_rooms_clean_remarks.getText()).toString().trim();
        String clean = Objects.requireNonNull(etis_clean_water_supplied_remarks.getText()).toString().trim();
        String electricity = Objects.requireNonNull(etis_electricity_supplied_remarks.getText()).toString().trim();

        boolean valid = validateFields(ch_are_waste_disposal_systems, etare_waste_disposal_systems_remarks, waste) &
                validateFields(ch_has_fire_fighting_equipment, ethas_fire_fighting_equipment_remarks, fire) &
                validateFields(ch_is_general_hygiene_satisfactory, etis_general_hygiene_satisfactory_remarks, general) &
                validateFields(ch_are_washing_rooms_clean, etare_washing_rooms_clean_remarks, washing) &
                validateFields(ch_is_clean_water_supplied, etis_clean_water_supplied_remarks, clean) &
                validateFields(ch_is_electricity_supplied, etis_electricity_supplied_remarks, electricity);

        CoffeeGrowerMarketingAgentBus coffeeGrowerMarketingAgentBus = CoffeeGrowerMarketingAgentBus.getInstance();
        coffeeGrowerMarketingAgentBus.setIsWasteDisposalSystems(str_waste);
        coffeeGrowerMarketingAgentBus.setIsWasteDisposalSystemsRemarks(waste);
        coffeeGrowerMarketingAgentBus.setIsFireFightingEquipment(str_fire);
        coffeeGrowerMarketingAgentBus.setIsFireFightingEquipmentRemarks(fire);
        coffeeGrowerMarketingAgentBus.setIsGeneralHygieneSatisfactory(str_general);
        coffeeGrowerMarketingAgentBus.setIsGeneralHygieneSatisfactoryRemarks(general);
        coffeeGrowerMarketingAgentBus.setIsWashingRoomsClean(str_washing);
        coffeeGrowerMarketingAgentBus.setIsWashingRoomsCleanRemarks(washing);
        coffeeGrowerMarketingAgentBus.setIsCleanWaterSupplied(str_clean);
        coffeeGrowerMarketingAgentBus.setIsCleanWaterSuppliedRemarks(clean);
        coffeeGrowerMarketingAgentBus.setIsElectricitySupplied(str_electricity);
        coffeeGrowerMarketingAgentBus.setIsElectricitySuppliedRemarks(electricity);

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
