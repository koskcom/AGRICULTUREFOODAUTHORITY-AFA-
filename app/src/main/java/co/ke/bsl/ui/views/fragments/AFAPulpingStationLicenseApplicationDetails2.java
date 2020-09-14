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
import co.ke.bsl.data.model.PulpingStationLicenseApplication;
import co.ke.bsl.data.view.PulpingStationLicenseApplicationBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.CoffeePulpingStationATEViewModel;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAPulpingStationLicenseApplicationDetails2 extends Fragment implements BlockingStep {

    @BindView(R.id.ch_objection_letter)
    CheckBox ch_objection_letter;
    @BindView(R.id.etobjection_letter_remarks)
    CustomEditText etobjection_letter_remarks;

    @BindView(R.id.ch_waste_disposal)
    CheckBox ch_waste_disposal;
    @BindView(R.id.etwaste_disposal_remarks)
    CustomEditText etwaste_disposal_remarks;

    @BindView(R.id.ch_pollution_management)
    CheckBox ch_pollution_management;
    @BindView(R.id.etpollution_management_remarks)
    CustomEditText etpollution_management_remarks;

    @BindView(R.id.ch_water)
    CheckBox ch_water;
    @BindView(R.id.etwater_remarks)
    CustomEditText etwater_remarks;

    @BindView(R.id.ch_nema_certificate)
    CheckBox ch_nema_certificate;
    @BindView(R.id.etnema_certificate_remarks)
    CustomEditText etnema_certificate_remarks;

    @BindView(R.id.etcoffee_advisory)
    CustomEditText etcoffee_advisory;
    @BindView(R.id.etcoffee_working)
    CustomEditText etcoffee_working;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    private String Savestring = "N";

    private String str_objection_letter, str_pollution_management, str_water, str_nema_certificate, str_water_disposal;

    AFADatabaseAdapter db;

    AFA app;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();

    private CoffeePulpingStationATEViewModel coffeePulpingStationATEViewModel;


    public AFAPulpingStationLicenseApplicationDetails2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afapulping_station_license_application_details2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        coffeePulpingStationATEViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CoffeePulpingStationATEViewModel.class);


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

        ch_objection_letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_objection_letter.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_objection_letter = Savestring;

            }
        });

        ch_pollution_management.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_pollution_management.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_pollution_management = Savestring;

            }
        });

        ch_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_water.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_water = Savestring;

            }
        });

        ch_nema_certificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_nema_certificate.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_nema_certificate = Savestring;

            }
        });

        ch_waste_disposal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_waste_disposal.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_water_disposal = Savestring;

            }
        });


        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        String objection_letter = Objects.requireNonNull(etobjection_letter_remarks.getText()).toString().trim();
        String waste_disposal = Objects.requireNonNull(etwaste_disposal_remarks.getText()).toString().trim();
        String pollution_management = Objects.requireNonNull(etpollution_management_remarks.getText()).toString().trim();
        String water = Objects.requireNonNull(etwater_remarks.getText()).toString().trim();
        String nema = Objects.requireNonNull(etnema_certificate_remarks.getText()).toString().trim();
        String advisory = Objects.requireNonNull(etcoffee_advisory.getText()).toString().trim();
        String working = Objects.requireNonNull(etcoffee_working.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateFields(ch_objection_letter, etobjection_letter_remarks, objection_letter) &
                validateFields(ch_waste_disposal, etwaste_disposal_remarks, waste_disposal) &
                validateFields(ch_pollution_management, etpollution_management_remarks, pollution_management) &
                validateFields(ch_water, etwater_remarks, water) &
                validateFields(ch_nema_certificate, etnema_certificate_remarks, nema) &
                validateEditText(etcoffee_advisory, advisory) &
                validateEditText(etcoffee_working, working);

        PulpingStationLicenseApplicationBus pulpingStationLicenseApplicationBus= PulpingStationLicenseApplicationBus.getInstance();
        PulpingStationLicenseApplication pulpingStationLicenseApplication = new PulpingStationLicenseApplication(
                0,
                pulpingStationLicenseApplicationBus.getDocumentNumber(),
                pulpingStationLicenseApplicationBus.getDocumentDate(),
                pulpingStationLicenseApplicationBus.getApplicantName(),
                pulpingStationLicenseApplicationBus.getAuthorityToErectNumber(),
                pulpingStationLicenseApplicationBus.getLocalID(),
                pulpingStationLicenseApplicationBus.getTotalLandArea(),
                pulpingStationLicenseApplicationBus.getTotalNumberOfTrees(),
                pulpingStationLicenseApplicationBus.getAreaUnderMatureCoffee(),
                pulpingStationLicenseApplicationBus.getFirstYear(),
                pulpingStationLicenseApplicationBus.getFirstYearProduction(),
                pulpingStationLicenseApplicationBus.getSecondYear(),
                pulpingStationLicenseApplicationBus.getSecondYearProduction(),
                pulpingStationLicenseApplicationBus.getThirdYear(),
                pulpingStationLicenseApplicationBus.getThirdYearProduction(),
                pulpingStationLicenseApplicationBus.getCropHusbandryPractices(),
                str_objection_letter,
                objection_letter,
                str_water_disposal,
                waste_disposal,
                str_pollution_management,
                pollution_management,
                str_water,
                water,
                str_nema_certificate,
                nema,
                advisory,
                working,
                recommendation,
                recommendationRemarks,
                "",
                false,
                "");

        if(valid) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("COFFEE ATE INSPECTION!")
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


                            db.updatePulpingStationLicenseApplication(pulpingStationLicenseApplication);
                            coffeePulpingStationATEViewModel.addRecord(pulpingStationLicenseApplication);

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
