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
import co.ke.bsl.data.model.CoffeeGrowerMarketingAgent;
import co.ke.bsl.data.view.CoffeeGrowerMarketingAgentBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.CoffeeGrowerMarketingAgentViewModel;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeGrowerMarketingAgentQuality extends Fragment implements BlockingStep {

    @BindView(R.id.ch_are_returns_to_coffee)
    CheckBox ch_are_returns_to_coffee;
    @BindView(R.id.etare_returns_to_coffee_remarks)
    CustomEditText etare_returns_to_coffee_remarks;
    @BindView(R.id.ch_is_traceability_system)
    CheckBox ch_is_traceability_system;
    @BindView(R.id.etis_traceability_system_remarks)
    CustomEditText etis_traceability_system_remarks;
    @BindView(R.id.ch_are_cupping_facilities_for_coffee)
    CheckBox ch_are_cupping_facilities_for_coffee;
    @BindView(R.id.etare_cupping_facilities_for_coffee_remarks)
    CustomEditText etare_cupping_facilities_for_coffee_remarks;
    @BindView(R.id.ch_is_occupational_and_health)
    CheckBox ch_is_occupational_and_health;
    @BindView(R.id.etis_occupational_and_health_remarks)
    CustomEditText etis_occupational_and_health_remarks;
    @BindView(R.id.ch_is_payment_to_growers)
    CheckBox ch_is_payment_to_growers;
    @BindView(R.id.etis_payment_to_growers_remarks)
    CustomEditText etis_payment_to_growers_remarks;
    @BindView(R.id.ch_are_standard_out_turn)
    CheckBox ch_are_standard_out_turn;
    @BindView(R.id.etare_standard_out_turn_remarks)
    CustomEditText etare_standard_out_turn_remarks;
    @BindView(R.id.ch_are_standard_direct_sales)
    CheckBox ch_are_standard_direct_sales;
    @BindView(R.id.etare_standard_direct_sales_remarks)
    CustomEditText etare_standard_direct_sales_remarks;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    private String Savestring = "N";

    private String str_returns, str_trace, str_cupping, str_health, str_pay, str_out_turn, str_direct;

    AFADatabaseAdapter db;

    AFA app;

    private CoffeeGrowerMarketingAgentViewModel coffeeGrowerMarketingAgentViewModel;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();


    public CoffeeGrowerMarketingAgentQuality() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_grower_marketing_agent_quality, container, false);
        ButterKnife.bind(this, view);


        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        coffeeGrowerMarketingAgentViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CoffeeGrowerMarketingAgentViewModel.class);

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

        ch_are_returns_to_coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_returns_to_coffee.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_returns = Savestring;
            }
        });

        ch_is_traceability_system.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_traceability_system.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_trace = Savestring;
            }
        });

        ch_are_cupping_facilities_for_coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_cupping_facilities_for_coffee.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_cupping = Savestring;
            }
        });

        ch_is_occupational_and_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_occupational_and_health.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_health = Savestring;
            }
        });

        ch_is_payment_to_growers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_is_payment_to_growers.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_pay = Savestring;
            }
        });

        ch_are_standard_out_turn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_standard_out_turn.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_out_turn = Savestring;
            }
        });

        ch_are_standard_direct_sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_standard_direct_sales.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_direct = Savestring;
            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        String returns = Objects.requireNonNull(etare_returns_to_coffee_remarks.getText()).toString().trim();
        String trace = Objects.requireNonNull(etis_traceability_system_remarks.getText()).toString().trim();
        String cupping = Objects.requireNonNull(etare_cupping_facilities_for_coffee_remarks.getText()).toString().trim();
        String health = Objects.requireNonNull(etis_occupational_and_health_remarks.getText()).toString().trim();
        String pay = Objects.requireNonNull(etis_payment_to_growers_remarks.getText()).toString().trim();
        String out_run = Objects.requireNonNull(etare_standard_out_turn_remarks.getText()).toString().trim();
        String direct= Objects.requireNonNull(etare_standard_direct_sales_remarks.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateFields(ch_are_returns_to_coffee, etare_returns_to_coffee_remarks, returns) &
                validateFields(ch_is_traceability_system, etis_traceability_system_remarks, trace) &
                validateFields(ch_are_cupping_facilities_for_coffee, etare_cupping_facilities_for_coffee_remarks, cupping) &
                validateFields(ch_is_occupational_and_health, etis_occupational_and_health_remarks, health) &
                validateFields(ch_is_payment_to_growers, etis_payment_to_growers_remarks, pay) &
                validateFields(ch_are_standard_out_turn, etare_standard_out_turn_remarks, out_run) &
                validateFields(ch_are_standard_direct_sales, etare_standard_direct_sales_remarks, direct);

        CoffeeGrowerMarketingAgentBus coffeeGrowerMarketingAgentBus= CoffeeGrowerMarketingAgentBus.getInstance();
        CoffeeGrowerMarketingAgent coffeeGrowerMarketingAgent = new CoffeeGrowerMarketingAgent(
                0,
                coffeeGrowerMarketingAgentBus.getDocumentNumber(),
                coffeeGrowerMarketingAgentBus.getDocumentDate(),
                coffeeGrowerMarketingAgentBus.getApplicantName(),
                coffeeGrowerMarketingAgentBus.getLicenceNumber(),
                coffeeGrowerMarketingAgentBus.getLocalID(),
                coffeeGrowerMarketingAgentBus.getIsMarkings(),
                coffeeGrowerMarketingAgentBus.getIsMarkingsRemarks(),
                coffeeGrowerMarketingAgentBus.getIsCoffeeDirectorate(),
                coffeeGrowerMarketingAgentBus.getIsCoffeeDirectorateRemarks(),
                coffeeGrowerMarketingAgentBus.getIsSingleBusinessPermit(),
                coffeeGrowerMarketingAgentBus.getIsSingleBusinessPermitRemarks(),
                coffeeGrowerMarketingAgentBus.getIsWasteDisposalSystems(),
                coffeeGrowerMarketingAgentBus.getIsWasteDisposalSystemsRemarks(),
                coffeeGrowerMarketingAgentBus.getIsFireFightingEquipment(),
                coffeeGrowerMarketingAgentBus.getIsFireFightingEquipmentRemarks(),
                coffeeGrowerMarketingAgentBus.getIsGeneralHygieneSatisfactory(),
                coffeeGrowerMarketingAgentBus.getIsGeneralHygieneSatisfactoryRemarks(),
                coffeeGrowerMarketingAgentBus.getIsWashingRoomsClean(),
                coffeeGrowerMarketingAgentBus.getIsWashingRoomsCleanRemarks(),
                coffeeGrowerMarketingAgentBus.getIsCleanWaterSupplied(),
                coffeeGrowerMarketingAgentBus.getIsCleanWaterSuppliedRemarks(),
                coffeeGrowerMarketingAgentBus.getIsElectricitySupplied(),
                coffeeGrowerMarketingAgentBus.getIsElectricitySuppliedRemarks(),
                str_returns,
                returns,
                str_trace,
                trace,
                str_cupping,
                cupping,
                str_health,
                health,
                str_pay,
                pay,
                str_out_turn,
                out_run,
                str_direct,
                direct,
                recommendation,
                recommendationRemarks,
                "",
                false,
                "");

        if(valid) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("COFFEE GROWER INSPECTION!")
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
                            db.updateCoffeeGrowerMarketingAgent(coffeeGrowerMarketingAgent);
                            coffeeGrowerMarketingAgentViewModel.addRecord(coffeeGrowerMarketingAgent);

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
