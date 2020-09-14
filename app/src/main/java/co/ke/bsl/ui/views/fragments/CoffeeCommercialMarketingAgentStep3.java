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
public class CoffeeCommercialMarketingAgentStep3 extends Fragment implements BlockingStep {

    @BindView(R.id.isWasteDisposalSystem)
    CheckBox isWasteDisposalSystem;
    @BindView(R.id.etWasteDisposalSystemRemarks)
    CustomEditText etWasteDisposalSystemRemarks;
    @BindView(R.id.isFireFightingServiced)
    CheckBox isFireFightingServiced;
    @BindView(R.id.etFireFightingServicedRemarks)
    CustomEditText etFireFightingServicedRemarks;
    @BindView(R.id.isGeneralHygiene)
    CheckBox isGeneralHygiene;
    @BindView(R.id.etGeneralHygieneRemarks)
    CustomEditText etGeneralHygieneRemarks;
    @BindView(R.id.isWashingRoomsClean)
    CheckBox isWashingRoomsClean;
    @BindView(R.id.etWashingRoomsCleanRemarks)
    CustomEditText etWashingRoomsCleanRemarks;
    @BindView(R.id.isCleanWaterSupplied)
    CheckBox isCleanWaterSupplied;
    @BindView(R.id.etCleanWaterSuppliedRemarks)
    CustomEditText etCleanWaterSuppliedRemarks;
    @BindView(R.id.isElectricitySupplied)
    CheckBox isElectricitySupplied;
    @BindView(R.id.etElectricitySuppliedRemarks)
    CustomEditText etElectricitySuppliedRemarks;

    private String iswasteDisposalsystem, wasteDisposalsystemRemarks, isfireFightingEquipments, fireFightingEquipmentsRemarks, isgeneralhygienes, generalhygienesRemarks, iswashingrRooms, washingrRoomsRemarks, iscleanWaterSupplied, cleanWaterSuppliedRemarks, iselectricity, electricityRemarks;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_commercial_marketing_agent_step3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();

        isWasteDisposalSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWasteDisposalSystem.isChecked()) {
                    iswasteDisposalsystem = "Y";
                } else {
                    iswasteDisposalsystem = "N";
                }

            }
        });

        isFireFightingServiced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFireFightingServiced.isChecked()) {
                    isfireFightingEquipments = "Y";
                } else {
                    isfireFightingEquipments = "N";
                }

            }
        });

        isGeneralHygiene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isGeneralHygiene.isChecked()) {
                    isgeneralhygienes = "Y";
                } else {
                    isgeneralhygienes = "N";
                }

            }
        });

        isWashingRoomsClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWashingRoomsClean.isChecked()) {
                    iswashingrRooms = "Y";
                } else {
                    iswashingrRooms = "N";
                }

            }
        });

        isCleanWaterSupplied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCleanWaterSupplied.isChecked()) {
                    iscleanWaterSupplied = "Y";
                } else {
                    iscleanWaterSupplied = "N";
                }

            }
        });

        isElectricitySupplied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isElectricitySupplied.isChecked()) {
                    iselectricity = "Y";
                } else {
                    iselectricity = "N";
                }

            }
        });
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        wasteDisposalsystemRemarks = Objects.requireNonNull(etWasteDisposalSystemRemarks.getText()).toString().trim();
        fireFightingEquipmentsRemarks = Objects.requireNonNull(etFireFightingServicedRemarks.getText()).toString().trim();
        generalhygienesRemarks = Objects.requireNonNull(etGeneralHygieneRemarks.getText()).toString().trim();
        washingrRoomsRemarks = Objects.requireNonNull(etWashingRoomsCleanRemarks.getText()).toString().trim();
        cleanWaterSuppliedRemarks = Objects.requireNonNull(etCleanWaterSuppliedRemarks.getText()).toString().trim();
        electricityRemarks = Objects.requireNonNull(etElectricitySuppliedRemarks.getText()).toString().trim();

        boolean valid = validateFields(isWasteDisposalSystem, etWasteDisposalSystemRemarks, wasteDisposalsystemRemarks) &
                validateFields(isFireFightingServiced, etFireFightingServicedRemarks, fireFightingEquipmentsRemarks) &
                validateFields(isGeneralHygiene, etGeneralHygieneRemarks, generalhygienesRemarks) &
                validateFields(isWashingRoomsClean, etWashingRoomsCleanRemarks, washingrRoomsRemarks) &
                validateFields(isCleanWaterSupplied, etCleanWaterSuppliedRemarks, cleanWaterSuppliedRemarks) &
                validateFields(isElectricitySupplied, etElectricitySuppliedRemarks, electricityRemarks);

        CoffeeCommercialMarketingAgentBus coffeeCommercialMarketingAgentBus = CoffeeCommercialMarketingAgentBus.getInstance();

        coffeeCommercialMarketingAgentBus.setIswasteDisposalsystem(iswasteDisposalsystem);
        coffeeCommercialMarketingAgentBus.setWasteDisposalsystemRemarks(wasteDisposalsystemRemarks);
        coffeeCommercialMarketingAgentBus.setIsfireFightingEquipments(isfireFightingEquipments);
        coffeeCommercialMarketingAgentBus.setFireFightingEquipmentsRemarks(fireFightingEquipmentsRemarks);
        coffeeCommercialMarketingAgentBus.setIsgeneralhygienes(isgeneralhygienes);
        coffeeCommercialMarketingAgentBus.setGeneralhygienesRemarks(generalhygienesRemarks);
        coffeeCommercialMarketingAgentBus.setIswashingrRooms(iswashingrRooms);
        coffeeCommercialMarketingAgentBus.setWashingrRoomsRemarks(washingrRoomsRemarks);
        coffeeCommercialMarketingAgentBus.setIscleanWaterSupplied(iscleanWaterSupplied);
        coffeeCommercialMarketingAgentBus.setCleanWaterSuppliedRemarks(cleanWaterSuppliedRemarks);
        coffeeCommercialMarketingAgentBus.setIselectricity(iselectricity);
        coffeeCommercialMarketingAgentBus.setElectricityRemarks(electricityRemarks);

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
