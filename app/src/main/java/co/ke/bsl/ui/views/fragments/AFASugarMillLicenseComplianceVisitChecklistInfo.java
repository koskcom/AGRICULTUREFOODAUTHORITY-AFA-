package co.ke.bsl.ui.views.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Handler;
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
import co.ke.bsl.data.model.SugarMillLicence;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.data.view.SugarMillLicenceBus;
import co.ke.bsl.pojo.Country;
import co.ke.bsl.pojo.WholeSaleImportedSugar;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.SugarMillLicenceViewModel;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFASugarMillLicenseComplianceVisitChecklistInfo extends Fragment implements BlockingStep {


    @BindView(R.id.chlist_of_contracted_farmers)
    CheckBox chlist_of_contracted_farmers;
    @BindView(R.id.etlist_of_contracted_farmers_remarks)
    CustomEditText etlist_of_contracted_farmers_remarks;

    @BindView(R.id.chsummary_showing_number_of_growers)
    CheckBox chsummary_showing_number_of_growers;
    @BindView(R.id.etsummary_showing_number_of_growers_remarks)
    CustomEditText etsummary_showing_number_of_growers_remarks;

    @BindView(R.id.chnema_weights_osha_certificates)
    CheckBox chnema_weights_osha_certificates;
    @BindView(R.id.etnema_weights_osha_certificates_remarks)
    CustomEditText etnema_weights_osha_certificates_remarks;

    @BindView(R.id.chsugar_cane_milling_schedule)
    CheckBox chsugar_cane_milling_schedule;
    @BindView(R.id.etsugar_cane_milling_schedule__remarks)
    CustomEditText etsugar_cane_milling_schedule__remarks;

    @BindView(R.id.chsamples_of_contracts_in_use_by_miller_for_cane_contracts)
    CheckBox chsamples_of_contracts_in_use_by_miller_for_cane_contracts;
    @BindView(R.id.etsamples_of_contracts_in_use_remarks)
    CustomEditText etsamples_of_contracts_in_use_remarks;

    @BindView(R.id.chcane_production_and_processing_plans)
    CheckBox chcane_production_and_processing_plans;
    @BindView(R.id.etcane_production_and_processing_remarks)
    CustomEditText etcane_production_and_processing_remarks;

    @BindView(R.id.chschedule_of_farmers_and_sdl)
    CheckBox chschedule_of_farmers_and_sdl;
    @BindView(R.id.etschedule_of_farmers_and_sdl_remarks)
    CustomEditText etschedule_of_farmers_and_sdl_remarks;

    @BindView(R.id.chconformance_to_cane_payment_formula)
    CheckBox chconformance_to_cane_payment_formula;
    @BindView(R.id.etconformance_to_cane_payment_remarks)
    CustomEditText etconformance_to_cane_payment_remarks;

    @BindView(R.id.chadherence_to_relevant_statutory_requirement)
    CheckBox chadherence_to_relevant_statutory_requirement;
    @BindView(R.id.etadherence_to_relevant_statutory_remarks)
    CustomEditText etadherence_to_relevant_statutory_remarks;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;


    protected Handler asyncTaskHandler;
    private AsyncActivitySupport asyncSupport;
    protected List<Country> countries;
    List<WholeSaleImportedSugar> wholeSaleImportedSugarList;
    AFADatabaseAdapter db;

    private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();

    private SugarMillLicenceViewModel sugarMillLicenceViewModel;

    private String Savestring = "N";
    AFA app;

    private String list_farmers = "N", list_farmers_remark, grower_summary = "N", grower_summary_remark, nemaweightsosha_cert = "N", nemaweightsosha_cert_remark, millingshedule_monthly = "N";
    private String millingshedule_monthly_remark, canecontract_samples = "N", canecontract_samples_remark, caneprodproc_plans = "N", caneprodproc_plans_remark;
    private String farmersdarreas_measure = "N", farmersdarreas_measure_remark, payformula_conf = "N", payformula_conf_remark, adhstatutorystandard = "N", adhstatutorystandard_remark;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afasugar_mill_license_compliance_visit_checklist_info, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        sugarMillLicenceViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(SugarMillLicenceViewModel.class);

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

        chlist_of_contracted_farmers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chlist_of_contracted_farmers.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                list_farmers = Savestring;
            }
        });

        chsummary_showing_number_of_growers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chsummary_showing_number_of_growers.isChecked()) {
                    Savestring = "Y";

                } else {
                    Savestring = "N";
                }
                grower_summary = Savestring;
            }
        });

        chnema_weights_osha_certificates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chnema_weights_osha_certificates.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                nemaweightsosha_cert = Savestring;
            }
        });

        chsugar_cane_milling_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chsugar_cane_milling_schedule.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                millingshedule_monthly = Savestring;
            }
        });

        chsamples_of_contracts_in_use_by_miller_for_cane_contracts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chsamples_of_contracts_in_use_by_miller_for_cane_contracts.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                canecontract_samples = Savestring;
            }
        });

        chcane_production_and_processing_plans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chcane_production_and_processing_plans.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                caneprodproc_plans = Savestring;

            }

        });


        chschedule_of_farmers_and_sdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chschedule_of_farmers_and_sdl.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                farmersdarreas_measure = Savestring;
            }


        });

        chconformance_to_cane_payment_formula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chconformance_to_cane_payment_formula.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                payformula_conf = Savestring;
            }
        });

        chadherence_to_relevant_statutory_requirement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chadherence_to_relevant_statutory_requirement.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                adhstatutorystandard = Savestring;

            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        list_farmers_remark = Objects.requireNonNull(etlist_of_contracted_farmers_remarks.getText()).toString().trim();
        grower_summary_remark = Objects.requireNonNull(etsummary_showing_number_of_growers_remarks.getText().toString());
        nemaweightsosha_cert_remark = Objects.requireNonNull(etnema_weights_osha_certificates_remarks.getText()).toString().trim();
        millingshedule_monthly_remark = Objects.requireNonNull(etsugar_cane_milling_schedule__remarks.getText().toString());
        canecontract_samples_remark = Objects.requireNonNull(etsamples_of_contracts_in_use_remarks.getText()).toString().trim();
        caneprodproc_plans_remark = Objects.requireNonNull(etcane_production_and_processing_remarks.getText().toString());
        farmersdarreas_measure_remark = Objects.requireNonNull(etschedule_of_farmers_and_sdl_remarks.getText()).toString().trim();
        payformula_conf_remark = Objects.requireNonNull(etconformance_to_cane_payment_remarks.getText().toString());
        adhstatutorystandard_remark = Objects.requireNonNull(etadherence_to_relevant_statutory_remarks.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateFields(chlist_of_contracted_farmers, etlist_of_contracted_farmers_remarks, list_farmers_remark) &
                validateFields(chsummary_showing_number_of_growers, etsummary_showing_number_of_growers_remarks, grower_summary_remark) &
                validateFields(chnema_weights_osha_certificates, etnema_weights_osha_certificates_remarks, nemaweightsosha_cert_remark) &
                validateFields(chsugar_cane_milling_schedule, etsugar_cane_milling_schedule__remarks, millingshedule_monthly_remark) &
                validateFields(chsamples_of_contracts_in_use_by_miller_for_cane_contracts, etsamples_of_contracts_in_use_remarks, canecontract_samples_remark) &
                validateFields(chcane_production_and_processing_plans, etcane_production_and_processing_remarks, caneprodproc_plans_remark) &
                validateFields(chschedule_of_farmers_and_sdl, etschedule_of_farmers_and_sdl_remarks, farmersdarreas_measure_remark) &
                validateFields(chconformance_to_cane_payment_formula, etconformance_to_cane_payment_remarks, payformula_conf_remark) &
                validateFields(chadherence_to_relevant_statutory_requirement, etadherence_to_relevant_statutory_remarks, adhstatutorystandard_remark);

        SugarMillLicenceBus sugarMillLicenceBus = SugarMillLicenceBus.getInstance();
        SugarMillLicence sugarMillLicence = new SugarMillLicence(
                0,
                sugarMillLicenceBus.getDocument_number(),
                sugarMillLicenceBus.getDocument_date(),
                sugarMillLicenceBus.getLetter_of_comfort(),
                sugarMillLicenceBus.getC_BPartner_ID(),
                sugarMillLicenceBus.getLocalID(),
                list_farmers,
                list_farmers_remark,
                grower_summary,
                grower_summary_remark,
                nemaweightsosha_cert,
                nemaweightsosha_cert_remark,
                millingshedule_monthly,
                millingshedule_monthly_remark,
                canecontract_samples,
                canecontract_samples_remark,
                caneprodproc_plans,
                caneprodproc_plans_remark,
                farmersdarreas_measure,
                farmersdarreas_measure_remark,
                payformula_conf,
                payformula_conf_remark,
                adhstatutorystandard,
                adhstatutorystandard_remark,
                recommendation,
                recommendationRemarks,
                false,
                ""
        );

        if (valid) {


            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("SUGAR MILL INSPECTION!")
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


                            db.updateSugarMillLicencecompliance(sugarMillLicence);
                            sugarMillLicenceViewModel.addSugarMillRecord(sugarMillLicence);

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

    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString) {

        boolean result = false;

        if (!checkBox.isChecked()) {
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                result = false;
            } else {
                result = true;
            }
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
        listViewItems.add(new ReccomendationsView("Select Reccomendation ", " "));
        listViewItems.add(new ReccomendationsView("I Recommend", "10000245"));
        listViewItems.add(new ReccomendationsView("I Do Not Recommend", "10000246"));

        return listViewItems;
    }

}

