package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.CoffeeMillerLicenceApplication;
import co.ke.bsl.data.view.CoffeeMillerLicenceApplicationBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.CoffeeMillerViewModel;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFACoffeeMillerLicenseApplicationWarehousing extends Fragment implements BlockingStep {
    @BindView(R.id.ch_cm_walls)
    CheckBox ch_cm_walls;
    @BindView(R.id.etcm_walls_findings)
    CustomEditText etcm_walls_findings;

    @BindView(R.id.ch_cm_floors)
    CheckBox ch_cm_floors;
    @BindView(R.id.etcm_floors_findings)
    CustomEditText etcm_floors_findings;

    @BindView(R.id.ch_roof)
    CheckBox ch_roof;
    @BindView(R.id.etroof_findings)
    CustomEditText etroof_findings;

    @BindView(R.id.ch_washrooms)
    CheckBox ch_washrooms;
    @BindView(R.id.etwashroom_findings)
    CustomEditText etwashroom_findings;

    @BindView(R.id.ch_ventilation)
    CheckBox ch_ventilation;
    @BindView(R.id.etventilation_findings)
    CustomEditText etventilation_findings;

    @BindView(R.id.ch_coffee_packaging)
    CheckBox ch_coffee_packaging;
    @BindView(R.id.etcoffee_packaging_findings)
    CustomEditText etcoffee_packaging_findings;

    @BindView(R.id.ch_general_hygiene)
    CheckBox ch_general_hygiene;
    @BindView(R.id.etgeneral_hygiene_findings)
    CustomEditText etgeneral_hygiene_findings;

    @BindView(R.id.ch_firefighting_equipment)
    CheckBox ch_firefighting_equipment;
    @BindView(R.id.etfirefighting_equipment_findings)
    CustomEditText etfirefighting_equipment_findings;


    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    private String Savestring = "N";
    private String str_walls, str_floors, str_roof, str_ventilation, str_washrooms, str_coffee, str_general, str_firefighting;

    AFADatabaseAdapter db;

    AFA app;

    private CoffeeMillerViewModel coffeeMillerViewModel;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();


    public AFACoffeeMillerLicenseApplicationWarehousing() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afacoffee_miller_license_application_warehousing, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        setReccomendationsView(getReccomendationsView());

        ssReccomendation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ReccomendationsView rec = (ReccomendationsView) ssReccomendation.getSelectedItem();
                recommendation = rec.getServerID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ch_cm_walls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_cm_walls.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_walls = Savestring;
            }
        });

        ch_cm_floors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_cm_floors.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_floors = Savestring;
            }
        });

        ch_roof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_roof.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_roof = Savestring;
            }
        });

        ch_ventilation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_ventilation.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_ventilation = Savestring;
            }
        });

        ch_washrooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_washrooms.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_washrooms = Savestring;
            }
        });

        ch_coffee_packaging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_coffee_packaging.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_coffee = Savestring;
            }
        });

        ch_general_hygiene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_general_hygiene.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_general = Savestring;
            }
        });

        ch_firefighting_equipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_firefighting_equipment.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_firefighting = Savestring;
            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String walls = Objects.requireNonNull(etcm_walls_findings.getText()).toString().trim();
        String floors = Objects.requireNonNull(etcm_floors_findings.getText()).toString().trim();
        String roof = Objects.requireNonNull(etroof_findings.getText()).toString().trim();
        String ventilation = Objects.requireNonNull(etventilation_findings.getText()).toString().trim();
        String washroom = Objects.requireNonNull(etwashroom_findings.getText()).toString().trim();
        String coffee = Objects.requireNonNull(etcoffee_packaging_findings.getText()).toString().trim();
        String general = Objects.requireNonNull(etgeneral_hygiene_findings.getText()).toString().trim();
        String firefighting = Objects.requireNonNull(etfirefighting_equipment_findings.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateFields(ch_cm_walls, etcm_walls_findings, walls) &
                validateFields(ch_cm_floors, etcm_floors_findings, floors) &
                validateFields(ch_roof, etroof_findings, roof) &
                validateFields(ch_ventilation, etventilation_findings, ventilation) &
                validateFields(ch_washrooms, etwashroom_findings, washroom) &
                validateFields(ch_coffee_packaging, etcoffee_packaging_findings, coffee) &
                validateFields(ch_general_hygiene, etgeneral_hygiene_findings, general) &
                validateFields(ch_firefighting_equipment, etfirefighting_equipment_findings, firefighting);




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

    private void setReccomendationsView(List<ReccomendationsView> getdummy10marks) {
        //        reccomendationsViewList.add("- Required -");
        for (ReccomendationsView regionWrapper : getdummy10marks) {
            reccomendationsViewList.add(regionWrapper);
        }

        ArrayAdapter<ReccomendationsView> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, reccomendationsViewList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssReccomendation.setAdapter(regionAdapter);

    }

    private List<ReccomendationsView> getReccomendationsView() {
        List<ReccomendationsView> listViewItems = new ArrayList<>();
        listViewItems.add(new ReccomendationsView("-select-", ""));
        listViewItems.add(new ReccomendationsView("I Recommend", "10000245"));
        listViewItems.add(new ReccomendationsView("I Do Not Recommend", "10000246"));

        return listViewItems;
    }

}
