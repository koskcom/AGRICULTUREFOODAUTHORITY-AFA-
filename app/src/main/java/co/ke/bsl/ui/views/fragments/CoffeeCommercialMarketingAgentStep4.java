package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

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
import co.ke.bsl.data.model.CoffeeCommercialMarketingAgent;
import co.ke.bsl.data.view.CoffeeCommercialMarketingAgentBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.CoffeeCommercialMarketingAgentViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeCommercialMarketingAgentStep4 extends Fragment implements BlockingStep {

    @BindView(R.id.isReturnsRemitted)
    CheckBox isReturnsRemitted;
    @BindView(R.id.etReturnsRemittedRemarks)
    CustomEditText etReturnsRemittedRemarks;
    @BindView(R.id.isTraceAbilityInplace)
    CheckBox isTraceAbilityInplace;
    @BindView(R.id.etTraceAbilityInplaceRemarks)
    CustomEditText etTraceAbilityInplaceRemarks;
    @BindView(R.id.isCuppingFacilities)
    CheckBox isCuppingFacilities;
    @BindView(R.id.etCuppingFacilitiesRemarks)
    CustomEditText etCuppingFacilitiesRemarks;
    @BindView(R.id.isOccupationalAndealtAct)
    CheckBox isOccupationalAndealtAct;
    @BindView(R.id.etOccupationalAndealtActRemarks)
    CustomEditText etOccupationalAndealtActRemarks;
    @BindView(R.id.isPaymentToGrowers)
    CheckBox isPaymentToGrowers;
    @BindView(R.id.etPaymentToGrowersRemarks)
    CustomEditText etPaymentToGrowersRemarks;
    @BindView(R.id.isStarndardOutTurnSales)
    CheckBox isStarndardOutTurnSales;
    @BindView(R.id.etStarndardOutTurnSalesRemarks)
    CustomEditText etStarndardOutTurnSalesRemarks;
    @BindView(R.id.isStandardDirect)
    CheckBox isStandardDirect;
    @BindView(R.id.etStandardDirectRemarks)
    CustomEditText etStandardDirectRemarks;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    private CoffeeCommercialMarketingAgentViewModel coffeeCommercialMarketingAgentViewModel;

    private String isreturnsRemitted, returnsRemittedRemarks, istraceabilitySystem, traceabilitySystemRemarks, iscuppingFacilities, cuppingFacilitiesRemarks, isoccupationalAndHealthAct, occupationalAndHealthActRemarks, ispaymentToGrowers, paymentToGrowersRemarks, isstarndardOutTurnSales, starndardOutTurnSalesRemarks, isstandardDirect, standardDirectRemarks;

    private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_commercial_marketing_agent_step4, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();

        coffeeCommercialMarketingAgentViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CoffeeCommercialMarketingAgentViewModel.class);

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

        isReturnsRemitted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isReturnsRemitted.isChecked()) {
                    isreturnsRemitted = "Y";
                } else {
                    isreturnsRemitted = "N";
                }

            }
        });

        isTraceAbilityInplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTraceAbilityInplace.isChecked()) {
                    istraceabilitySystem = "Y";
                } else {
                    istraceabilitySystem = "N";
                }

            }
        });

        isCuppingFacilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCuppingFacilities.isChecked()) {
                    iscuppingFacilities = "Y";
                } else {
                    iscuppingFacilities = "N";
                }

            }
        });

        isOccupationalAndealtAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOccupationalAndealtAct.isChecked()) {
                    isoccupationalAndHealthAct = "Y";
                } else {
                    isoccupationalAndHealthAct = "N";
                }

            }
        });

        isPaymentToGrowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPaymentToGrowers.isChecked()) {
                    ispaymentToGrowers = "Y";
                } else {
                    ispaymentToGrowers = "N";
                }

            }
        });

        isStarndardOutTurnSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStarndardOutTurnSales.isChecked()) {
                    isstarndardOutTurnSales = "Y";
                } else {
                    isstarndardOutTurnSales = "N";
                }

            }
        });

        isStandardDirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStandardDirect.isChecked()) {
                    isstandardDirect = "Y";
                } else {
                    isstandardDirect = "N";
                }

            }
        });


        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        returnsRemittedRemarks = Objects.requireNonNull(etReturnsRemittedRemarks.getText()).toString().trim();
        traceabilitySystemRemarks = Objects.requireNonNull(etTraceAbilityInplaceRemarks.getText()).toString().trim();
        cuppingFacilitiesRemarks = Objects.requireNonNull(etCuppingFacilitiesRemarks.getText()).toString().trim();
        occupationalAndHealthActRemarks = Objects.requireNonNull(etOccupationalAndealtActRemarks.getText()).toString().trim();
        paymentToGrowersRemarks = Objects.requireNonNull(etPaymentToGrowersRemarks.getText()).toString().trim();
        starndardOutTurnSalesRemarks = Objects.requireNonNull(etStarndardOutTurnSalesRemarks.getText()).toString().trim();
        standardDirectRemarks = Objects.requireNonNull(etStandardDirectRemarks.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateFields(isReturnsRemitted, etReturnsRemittedRemarks, returnsRemittedRemarks) &
                validateFields(isTraceAbilityInplace, etTraceAbilityInplaceRemarks, traceabilitySystemRemarks) &
                validateFields(isCuppingFacilities, etCuppingFacilitiesRemarks, cuppingFacilitiesRemarks) &
                validateFields(isOccupationalAndealtAct, etOccupationalAndealtActRemarks, occupationalAndHealthActRemarks) &
                validateFields(isPaymentToGrowers, etPaymentToGrowersRemarks, paymentToGrowersRemarks) &
                validateFields(isStarndardOutTurnSales, etStarndardOutTurnSalesRemarks, starndardOutTurnSalesRemarks) &
                validateFields(isStandardDirect, etStandardDirectRemarks, standardDirectRemarks);

        CoffeeCommercialMarketingAgentBus coffeeCommercialMarketingAgentBus = CoffeeCommercialMarketingAgentBus.getInstance();

        CoffeeCommercialMarketingAgent coffeeCommercialMarketingAgent = new CoffeeCommercialMarketingAgent(
                0,
                coffeeCommercialMarketingAgentBus.getDocument_number(),
                coffeeCommercialMarketingAgentBus.getDocument_date(),
                coffeeCommercialMarketingAgentBus.getName_of_applicant(),
                coffeeCommercialMarketingAgentBus.getLicence_number(),
                coffeeCommercialMarketingAgentBus.getLocalID(),
                coffeeCommercialMarketingAgentBus.getIsmarkingClear(),
                coffeeCommercialMarketingAgentBus.getMarkingClearRemarks(),
                coffeeCommercialMarketingAgentBus.getIscoffeeLicenceValid(),
                coffeeCommercialMarketingAgentBus.getCoffeeLicenceValidRemarks(),
                coffeeCommercialMarketingAgentBus.getIssingleBusinessPermit(),
                coffeeCommercialMarketingAgentBus.getSingleBusinessPermitRemarks(),
                coffeeCommercialMarketingAgentBus.getIswasteDisposalsystem(),
                coffeeCommercialMarketingAgentBus.getWasteDisposalsystemRemarks(),
                coffeeCommercialMarketingAgentBus.getIsfireFightingEquipments(),
                coffeeCommercialMarketingAgentBus.getFireFightingEquipmentsRemarks(),
                coffeeCommercialMarketingAgentBus.getIsgeneralhygienes(),
                coffeeCommercialMarketingAgentBus.getGeneralhygienesRemarks(),
                coffeeCommercialMarketingAgentBus.getIswashingrRooms(),
                coffeeCommercialMarketingAgentBus.getWashingrRoomsRemarks(),
                coffeeCommercialMarketingAgentBus.getIscleanWaterSupplied(),
                coffeeCommercialMarketingAgentBus.getCleanWaterSuppliedRemarks(),
                coffeeCommercialMarketingAgentBus.getIselectricity(),
                coffeeCommercialMarketingAgentBus.getElectricityRemarks(),
                isreturnsRemitted,
                returnsRemittedRemarks,
                istraceabilitySystem,
                traceabilitySystemRemarks,
                iscuppingFacilities,
                cuppingFacilitiesRemarks,
                isoccupationalAndHealthAct,
                occupationalAndHealthActRemarks,
                ispaymentToGrowers,
                paymentToGrowersRemarks,
                isstarndardOutTurnSales,
                starndardOutTurnSalesRemarks,
                isstandardDirect,
                standardDirectRemarks,
                recommendation,
                recommendationRemarks,
                false,
                ""
        );

        if (valid) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("COFFEE COMMERCIAL INSPECTION!")
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

                            long result = db.UpdateCommercialMarketingAgents(coffeeCommercialMarketingAgent);
                            System.out.println("result is" + result);
                            coffeeCommercialMarketingAgentViewModel.addRecord(coffeeCommercialMarketingAgent);

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
