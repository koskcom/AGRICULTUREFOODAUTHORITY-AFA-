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
import co.ke.bsl.data.view.PyrethrumInspectionBus;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAPyrethrumInspectionStep2 extends Fragment implements BlockingStep {

    @BindView(R.id.ch_title_deed)
    CheckBox ch_title_deed;
    @BindView(R.id.ettitle_deed_evidence)
    CustomEditText ettitle_deed_evidence;
    @BindView(R.id.ettitle_deed_remarks)
    CustomEditText ettitle_deed_remarks;

    @BindView(R.id.ch_total_acreage)
    CheckBox ch_total_acreage;
    @BindView(R.id.ettotal_acreage_evidence)
    CustomEditText ettotal_acreage_evidence;
    @BindView(R.id.ettotal_acreage_remarks)
    CustomEditText ettotal_ecreage_remarks;

    @BindView(R.id.ch_acreage_available)
    CheckBox ch_acreage_available;
    @BindView(R.id.etacreage_available_evidence)
    CustomEditText etacreage_available_evidence;
    @BindView(R.id.etacreage_available_remarks)
    CustomEditText etacreage_available_remarks;

    @BindView(R.id.ch_suitability_of_the_land)
    CheckBox ch_suitability_of_the_land;
    @BindView(R.id.etsuitability_of_the_land_evidence)
    CustomEditText etsuitability_of_the_land_evidence;
    @BindView(R.id.etsuitability_of_the_land_remarks)
    CustomEditText etsuitability_of_the_land_remarks;

    @BindView(R.id.ch_reliable_supply)
    CheckBox ch_reliable_supply;
    @BindView(R.id.etreliable_supply_evidence)
    CustomEditText etreliable_supply_evidence;
    @BindView(R.id.etreliable_supply_remarks)
    CustomEditText etreliable_supply_remarks;

    private String Savestring = "N";

    private String str_title_deed, str_total_acreage, str_acreage_available, str_suitability_of_the_land, str_reliable_supply;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afapyrethrum_inspection_step2, container, false);
        ButterKnife.bind(this, view);

        ch_title_deed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_title_deed.isChecked()) {
                    Savestring = "Y";
                } else
                    {
                    Savestring = "N";
                }

                str_title_deed = Savestring;

            }
        });

        ch_total_acreage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_total_acreage.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_total_acreage = Savestring;

            }
        });

        ch_acreage_available.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_acreage_available.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_acreage_available = Savestring;

            }
        });

        ch_suitability_of_the_land.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_suitability_of_the_land.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_suitability_of_the_land = Savestring;

            }
        });

        ch_reliable_supply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_reliable_supply.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_reliable_supply = Savestring;

            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        String title_deed_evidence = Objects.requireNonNull(ettitle_deed_evidence.getText()).toString().trim();
        String title_deed_remarks = Objects.requireNonNull(ettitle_deed_remarks.getText()).toString().trim();
        String total_acreage_evidence = Objects.requireNonNull(ettotal_acreage_evidence.getText()).toString().trim();
        String total_ecreage_remarks = Objects.requireNonNull(ettotal_ecreage_remarks.getText()).toString().trim();
        String acreage_available_evidence = Objects.requireNonNull(etacreage_available_evidence.getText()).toString().trim();
        String acreage_available_remarks = Objects.requireNonNull(etacreage_available_remarks.getText()).toString().trim();
        String suitability_of_the_land_evidence= Objects.requireNonNull(etsuitability_of_the_land_evidence.getText()).toString().trim();
        String suitability_of_the_land_remarks = Objects.requireNonNull(etsuitability_of_the_land_remarks.getText()).toString().trim();
        String reliable_supply_evidence = Objects.requireNonNull(etreliable_supply_evidence.getText()).toString().trim();
        String reliable_supply_remarks = Objects.requireNonNull(etreliable_supply_remarks.getText()).toString().trim();

        boolean valid = validateFields(ch_title_deed, ettitle_deed_remarks, title_deed_remarks) &
                validateFields(ch_total_acreage, ettotal_ecreage_remarks, total_ecreage_remarks) &
                validateFields(ch_acreage_available, etacreage_available_remarks, acreage_available_remarks) &
                validateFields(ch_suitability_of_the_land, etsuitability_of_the_land_remarks, suitability_of_the_land_remarks) &
                validateFields(ch_reliable_supply, etreliable_supply_remarks, reliable_supply_remarks);


        PyrethrumInspectionBus pyrethrumInspectionBus = PyrethrumInspectionBus.getInstance();
        pyrethrumInspectionBus.setTitle_deed(str_title_deed);
        pyrethrumInspectionBus.setTitle_deed_evidence(title_deed_evidence);
        pyrethrumInspectionBus.setTitle_deed_remarks(title_deed_remarks);
        pyrethrumInspectionBus.setTotal_acreage(str_total_acreage);
        pyrethrumInspectionBus.setTotal_acreage_evidence(total_acreage_evidence);
        pyrethrumInspectionBus.setTotal_acreage_remarks(total_ecreage_remarks);
        pyrethrumInspectionBus.setAcreage_available(str_acreage_available);
        pyrethrumInspectionBus.setAcreage_available_evidence(acreage_available_evidence);
        pyrethrumInspectionBus.setAcreage_available_remarks(acreage_available_remarks);
        pyrethrumInspectionBus.setSuitability_of_the_land(str_suitability_of_the_land);
        pyrethrumInspectionBus.setSuitability_of_the_land_evidence(suitability_of_the_land_evidence);
        pyrethrumInspectionBus.setSuitability_of_the_land_remarks(suitability_of_the_land_remarks);
        pyrethrumInspectionBus.setReliable_supply_clean_water(str_reliable_supply);
        pyrethrumInspectionBus.setReliable_supply_clean_water_evidence(reliable_supply_evidence);
        pyrethrumInspectionBus.setReliable_supply_clean_water_remarks(reliable_supply_remarks);

        if (valid){
            callback.goToNextStep();
        }

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
}
