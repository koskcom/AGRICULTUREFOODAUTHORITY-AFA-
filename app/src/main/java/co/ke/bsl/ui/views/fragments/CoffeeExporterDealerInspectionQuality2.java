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
import co.ke.bsl.data.model.CoffeeExporterDealerInspection;
import co.ke.bsl.data.view.CoffeeExporterDealerInspectionBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.CoffeeExporterDealerInspectionViewModel;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeExporterDealerInspectionQuality2 extends Fragment implements BlockingStep {

    @BindView(R.id.ch_is_clean_water_supplied_ex_2)
    CheckBox ch_is_clean_water_supplied_ex_2;
    @BindView(R.id.etis_clean_water_supplied_ex_2_remarks)
    CustomEditText etis_clean_water_supplied_ex_2_remarks;
    @BindView(R.id.ch_are_washing_rooms_satisfactory_ex)
    CheckBox ch_are_washing_rooms_satisfactory_ex;
    @BindView(R.id.etare_washing_rooms_satisfactory_ex_remarks)
    CustomEditText etare_washing_rooms_satisfactory_ex_remarks;
    @BindView(R.id.ch_are_returns_to_coffee_directorate_remitted)
    CheckBox ch_are_returns_to_coffee_directorate_remitted;
    @BindView(R.id.etare_returns_to_coffee_directorate_remitted_remarks)
    CustomEditText etare_returns_to_coffee_directorate_remitted_remarks;
    @BindView(R.id.ch_is_licensed_liquorer_hired)
    CheckBox ch_is_licensed_liquorer_hired;
    @BindView(R.id.etis_licensed_liquorer_hired_remarks)
    CustomEditText etis_licensed_liquorer_hired_remarks;
    @BindView(R.id.ch_is_traceability_system_in_place_ex)
    CheckBox ch_is_traceability_system_in_place_ex;
    @BindView(R.id.etis_traceability_system_in_place_ex_remarks)
    CustomEditText etis_traceability_system_in_place_ex_remarks;
    @BindView(R.id.ch_are_environmental_sustainability_efforts)
    CheckBox ch_are_environmental_sustainability_efforts;
    @BindView(R.id.etare_environmental_sustainability_efforts_remarks)
    CustomEditText etare_environmental_sustainability_efforts_remarks;
    @BindView(R.id.ch_is_value_addition_roasting)
    CheckBox ch_is_value_addition_roasting;
    @BindView(R.id.etis_value_addition_roasting_remarks)
    CustomEditText etis_value_addition_roasting_remarks;
    @BindView(R.id.ch_is_packaging_quality_ex)
    CheckBox ch_is_packaging_quality_ex;
    @BindView(R.id.etis_packaging_quality_ex_remarks)
    CustomEditText etis_packaging_quality_ex_remarks;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;


    private String Savestring = "N";

    private String str_supplied, str_washing, str_remitted, str_hired, str_trace, str_environmental, str_roasting, str_packaging;

    AFADatabaseAdapter db;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();

    AFA app;

    private CoffeeExporterDealerInspectionViewModel coffeeExporterDealerInspectionViewModel;

    public CoffeeExporterDealerInspectionQuality2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_exporter_dealer_inspection_quality2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        coffeeExporterDealerInspectionViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CoffeeExporterDealerInspectionViewModel.class);

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

        ch_is_clean_water_supplied_ex_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_clean_water_supplied_ex_2.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_supplied = Savestring;
            }
        });

        ch_are_washing_rooms_satisfactory_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_washing_rooms_satisfactory_ex.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_washing = Savestring;
            }
        });

        ch_are_returns_to_coffee_directorate_remitted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_returns_to_coffee_directorate_remitted.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_remitted = Savestring;
            }
        });

        ch_is_licensed_liquorer_hired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_licensed_liquorer_hired.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_hired = Savestring;
            }
        });

        ch_is_traceability_system_in_place_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_traceability_system_in_place_ex.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_trace = Savestring;
            }
        });

        ch_are_environmental_sustainability_efforts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_environmental_sustainability_efforts.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_environmental = Savestring;
            }
        });

        ch_is_value_addition_roasting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_value_addition_roasting.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_roasting = Savestring;
            }
        });

        ch_is_packaging_quality_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_packaging_quality_ex.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_packaging = Savestring;
            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        String supplied = Objects.requireNonNull(etis_clean_water_supplied_ex_2_remarks.getText()).toString().trim();
        String washing = Objects.requireNonNull(etare_washing_rooms_satisfactory_ex_remarks.getText()).toString().trim();
        String remitted = Objects.requireNonNull(etare_returns_to_coffee_directorate_remitted_remarks.getText()).toString().trim();
        String hired = Objects.requireNonNull(etis_licensed_liquorer_hired_remarks.getText()).toString().trim();
        String trace = Objects.requireNonNull(etis_traceability_system_in_place_ex_remarks.getText()).toString().trim();
        String environmental = Objects.requireNonNull(etare_environmental_sustainability_efforts_remarks.getText()).toString().trim();
        String roasting= Objects.requireNonNull(etis_value_addition_roasting_remarks.getText()).toString().trim();
        String packaging= Objects.requireNonNull(etis_packaging_quality_ex_remarks.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateFields(ch_is_clean_water_supplied_ex_2, etis_clean_water_supplied_ex_2_remarks, supplied) &
                validateFields(ch_are_washing_rooms_satisfactory_ex, etare_washing_rooms_satisfactory_ex_remarks, washing) &
                validateFields(ch_are_returns_to_coffee_directorate_remitted, etare_returns_to_coffee_directorate_remitted_remarks, remitted) &
                validateFields(ch_is_licensed_liquorer_hired, etis_licensed_liquorer_hired_remarks, hired) &
                validateFields(ch_is_traceability_system_in_place_ex, etis_traceability_system_in_place_ex_remarks, trace) &
                validateFields(ch_are_environmental_sustainability_efforts, etare_environmental_sustainability_efforts_remarks, environmental) &
                validateFields(ch_is_value_addition_roasting, etis_value_addition_roasting_remarks, roasting) &
                validateFields(ch_is_packaging_quality_ex, etis_packaging_quality_ex_remarks, packaging);


        CoffeeExporterDealerInspectionBus coffeeExporterDealerInspectionBus = CoffeeExporterDealerInspectionBus.getInstance();
        CoffeeExporterDealerInspection coffeeExporterDealerInspection = new CoffeeExporterDealerInspection(
                0,
                coffeeExporterDealerInspectionBus.getDocumentNumber(),
                coffeeExporterDealerInspectionBus.getDocumentDate(),
                coffeeExporterDealerInspectionBus.getApplicantName(),
                coffeeExporterDealerInspectionBus.getDealerLicenceNumber(),
                coffeeExporterDealerInspectionBus.getLocalID(),
                coffeeExporterDealerInspectionBus.getAreMarkingsClear(),
                coffeeExporterDealerInspectionBus.getAreMarkingsClearRemarks(),
                coffeeExporterDealerInspectionBus.getAreOfficesPremisesIdeal(),
                coffeeExporterDealerInspectionBus.getAreOfficesPremisesIdealRemarks(),
                coffeeExporterDealerInspectionBus.getIsCoffeeDirectorateLicenceValid(),
                coffeeExporterDealerInspectionBus.getIsCoffeeDirectorateLicenceValidRemarks(),
                coffeeExporterDealerInspectionBus.getHasSingleBusinessPermit(),
                coffeeExporterDealerInspectionBus.getHasSingleBusinessPermitRemarks(),
                coffeeExporterDealerInspectionBus.getAreMarkingsClear2(),
                coffeeExporterDealerInspectionBus.getAreMarkingsClear2Remarks(),
                coffeeExporterDealerInspectionBus.getAreWasteDisposalSystems(),
                coffeeExporterDealerInspectionBus.getAreWasteDisposalSystemsRemarks(),
                coffeeExporterDealerInspectionBus.getAreFireFightingPlace(),
                coffeeExporterDealerInspectionBus.getAreFireFightingPlaceRemarks(),
                coffeeExporterDealerInspectionBus.getAreFireFightingServiced(),
                coffeeExporterDealerInspectionBus.getAreFireFightingServicedRemakrs(),
                coffeeExporterDealerInspectionBus.getIsCleanWaterAvailable(),
                coffeeExporterDealerInspectionBus.getIsCleanWaterAvailableRemarks(),
                coffeeExporterDealerInspectionBus.getIsGeneralHygieneSatisfactory(),
                coffeeExporterDealerInspectionBus.getIsGeneralHygieneSatisfactoryRemarks(),
                coffeeExporterDealerInspectionBus.getAreWashingRoomsClean(),
                coffeeExporterDealerInspectionBus.getAreWashingRoomsCleanRemarks(),
                coffeeExporterDealerInspectionBus.getIsCleanWaterSupplied(),
                coffeeExporterDealerInspectionBus.getIsCleanWaterSuppliedRemarks(),
                coffeeExporterDealerInspectionBus.getIsElectricitySupplied(),
                coffeeExporterDealerInspectionBus.getIsElectricitySuppliedRemarks(),
                coffeeExporterDealerInspectionBus.getIsSampleRoasterInPlace(),
                coffeeExporterDealerInspectionBus.getIsSampleRoasterInPlaceRemarks(),
                coffeeExporterDealerInspectionBus.getIsSampleGrinderInPlace(),
                coffeeExporterDealerInspectionBus.getIsSampleGrinderInPlaceRemarks(),
                coffeeExporterDealerInspectionBus.getAreSpittingDrumsInPlace(),
                coffeeExporterDealerInspectionBus.getAreSpittingDrumsInPlaceRemarks(),
                coffeeExporterDealerInspectionBus.getAreTestingCupsInPlace(),
                coffeeExporterDealerInspectionBus.getAreTestingCupsInPlaceRemarks(),
                coffeeExporterDealerInspectionBus.getIsSampleTraysInPlace(),
                coffeeExporterDealerInspectionBus.getIsSampleTraysInPlaceRemarks(),
                coffeeExporterDealerInspectionBus.getAreSpoonsInPlace(),
                coffeeExporterDealerInspectionBus.getAreSpoonsInPlaceRemarks(),
                coffeeExporterDealerInspectionBus.getIsWaterHeatingSystemInPlace(),
                coffeeExporterDealerInspectionBus.getIsWaterHeatingSystemInPlaceRemarks(),
                coffeeExporterDealerInspectionBus.getIsMoistureMeterInPlace(),
                coffeeExporterDealerInspectionBus.getIsMoistureMeterInPlaceRemarks(),
                str_supplied,
                supplied,
                str_washing,
                washing,
                str_remitted,
                remitted,
                str_hired,
                hired,
                str_trace,
                trace,
                str_environmental,
                environmental,
                str_roasting,
                roasting,
                str_packaging,
                packaging,
                recommendation,
                recommendationRemarks,
                "",
                false,
                "");


        if(valid) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("COFFEE EXPORTER INSPECTION!")
                    .setCancelText("NO!")
                    .setConfirmText("Submit!")
                    .showCancelButton(true)
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            // reuse previous dialog instance, keep widget user state, reset them if you need
                            sDialog.setTitleText("Cancelled!")
                                    .setContentText("You Cancelled Submission:)")
                                    .setConfirmText("OK")
                                    .showCancelButton(false)
                                    .setCancelClickListener(null)
                                    .setConfirmClickListener(null)
                                    .changeAlertType(SweetAlertDialog.ERROR_TYPE);

                        }
                    })
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.setTitleText("Successfully!!!")
                                    .setContentText("Submitted!")
                                    .setConfirmText("OK")
                                    .showCancelButton(false)
                                    .setCancelClickListener(null)
                                    .setConfirmClickListener(null)
                                    .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                            db.updateCoffeeExporterDealerInspection(coffeeExporterDealerInspection);
                            coffeeExporterDealerInspectionViewModel.addRecord(coffeeExporterDealerInspection);

                            sDialog.dismissWithAnimation();
                            Intent intent = new Intent(getActivity(), DashboardActivity.class);
                            startActivity(intent);
                        }
                    })
                    .show();
        }
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
