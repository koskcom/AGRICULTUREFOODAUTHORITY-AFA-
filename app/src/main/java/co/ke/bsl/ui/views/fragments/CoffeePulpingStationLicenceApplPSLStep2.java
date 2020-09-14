package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
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
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.CoffeePulpingStationPSLBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.TeaPackerCustomListAdapter;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeePulpingStationLicenceApplPSLStep2 extends Fragment implements BlockingStep {

    @BindView(R.id.etAreaUnderCoffee)
    CustomEditText etAreaUnderCoffee;
    @BindView(R.id.etPulpingMachineType)
    CustomEditText etPulpingMachineType;
    @BindView(R.id.isSkinDrying)
    CheckBox isSkinDrying;
    @BindView(R.id.etSkinDryingremarks)
    CustomEditText etSkinDryingremarks;
    @BindView(R.id.isDryingTables)
    CheckBox isDryingTables;
    @BindView(R.id.etDryingTablesremarks)
    CustomEditText etDryingTablesremarks;
    @BindView(R.id.isFarmentationTanks)
    CheckBox isFarmentationTanks;
    @BindView(R.id.etFarmentationTanksremarks)
    CustomEditText etFarmentationTanksremarks;
    @BindView(R.id.isSoakTanks)
    CheckBox isSoakTanks;
    @BindView(R.id.etSoakTanksremarks)
    CustomEditText etSoakTanksremarks;
    @BindView(R.id.isParchmentBuniStore)
    CheckBox isParchmentBuniStore;
    @BindView(R.id.etParchmentBuniStoreremarks)
    CustomEditText etParchmentBuniStoreremarks;


    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    TeaPackerCustomListAdapter adapter;
    private String localID;

    private String skinDryingTable, isDryingTable, isFarmentationTable, isSoaktanks, isParcmentBuniStore, areaUnderCoffee, pulpingMachineType;
    private String skinDryingTableremarks, dryingTableremarks, farmentationTableremarks, soakTanksremarks, parcmentBuniStoreremarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_pulping_station_licence_appl_pslstep2, container, false);
        ButterKnife.bind(this, view);


        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();

        isSkinDrying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSkinDrying.isChecked()) {
                    skinDryingTable = "Y";
                } else {
                    skinDryingTable = "N";
                }
            }
        });

        isDryingTables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSkinDrying.isChecked()) {
                    isDryingTable = "Y";
                } else {
                    isDryingTable = "N";
                }
            }
        });

        isFarmentationTanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFarmentationTanks.isChecked()) {
                    isFarmentationTable = "Y";
                } else {
                    isFarmentationTable = "N";
                }
            }
        });

        isSoakTanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSoakTanks.isChecked()) {
                    isSoaktanks = "Y";
                } else {
                    isSoaktanks = "N";
                }
            }
        });

        isParchmentBuniStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isParchmentBuniStore.isChecked()) {
                    isParcmentBuniStore = "Y";
                } else {
                    isParcmentBuniStore = "N";
                }
            }
        });

        return view;
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        areaUnderCoffee = Objects.requireNonNull(etAreaUnderCoffee.getText()).toString().trim();
        pulpingMachineType = Objects.requireNonNull(etPulpingMachineType.getText()).toString().trim();
        dryingTableremarks = Objects.requireNonNull(etDryingTablesremarks.getText()).toString().trim();
        skinDryingTableremarks = Objects.requireNonNull(etSkinDryingremarks.getText()).toString().trim();
        farmentationTableremarks = Objects.requireNonNull(etFarmentationTanksremarks.getText()).toString().trim();
        soakTanksremarks = Objects.requireNonNull(etSoakTanksremarks.getText()).toString().trim();
        parcmentBuniStoreremarks = Objects.requireNonNull(etParchmentBuniStoreremarks.getText()).toString().trim();

        boolean valid = validateEditText(etAreaUnderCoffee, areaUnderCoffee) &
                validateEditText(etPulpingMachineType, pulpingMachineType) &
                validateFields(isDryingTables, etDryingTablesremarks, dryingTableremarks) &
                validateFields(isSkinDrying, etSkinDryingremarks, skinDryingTableremarks) &
                validateFields(isFarmentationTanks, etFarmentationTanksremarks, farmentationTableremarks) &
                validateFields(isSoakTanks, etSoakTanksremarks, soakTanksremarks) &
                validateFields(isParchmentBuniStore, etParchmentBuniStoreremarks, parcmentBuniStoreremarks);

        CoffeePulpingStationPSLBus coffeePulpingStationPSLBus = CoffeePulpingStationPSLBus.getInstance();

        coffeePulpingStationPSLBus.setAreaUnderCoffee(areaUnderCoffee);
        coffeePulpingStationPSLBus.setPulpingMachine(pulpingMachineType);
        coffeePulpingStationPSLBus.setIsSkinDryingTable(skinDryingTable);
        coffeePulpingStationPSLBus.setSkinDryingTableremarks(skinDryingTableremarks);
        coffeePulpingStationPSLBus.setIsDryingTable(isDryingTable);
        coffeePulpingStationPSLBus.setDryingTableremarks(dryingTableremarks);
        coffeePulpingStationPSLBus.setIsFarmentationTable(isFarmentationTable);
        coffeePulpingStationPSLBus.setFarmentationTableremarks(farmentationTableremarks);
        coffeePulpingStationPSLBus.setIsSoaktanks(isSoaktanks);
        coffeePulpingStationPSLBus.setSoakTanksremarks(soakTanksremarks);
        coffeePulpingStationPSLBus.setIsParcmentBuniStore(isParcmentBuniStore);
        coffeePulpingStationPSLBus.setParcmentBuniStoreremarks(parcmentBuniStoreremarks);

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
            } else {
                result = true;
            }
        } else{
            customEditText.setError(null);
            result = true;
        }

        return result;
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
}
