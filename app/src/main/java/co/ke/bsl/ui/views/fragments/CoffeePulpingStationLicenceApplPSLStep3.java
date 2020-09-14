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
import co.ke.bsl.data.model.CoffeePulpingStationPSL;
import co.ke.bsl.data.view.CoffeePulpingStationPSLBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.CoffeePulpingStationPSLViewModel;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeePulpingStationLicenceApplPSLStep3 extends Fragment implements BlockingStep {


    @BindView(R.id.etWasteAndPollution)
    CustomEditText etWasteAndPollution;
    @BindView(R.id.etCoffeeAdvisoryOfficers)
    CustomEditText etCoffeeAdvisoryOfficers;
    @BindView(R.id.etReccomendationFromCWG)
    CustomEditText etReccomendationFromCWG;
    @BindView(R.id.etOthersRemarks)
    CustomEditText etOthersRemarks;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    AFADatabaseAdapter db;
    AFA app;
    protected Handler asyncTaskHandler;

    private String localID;

    private String wasteAndPollutionsremarks, coffeeAdvisoryOfficers, reccommendationsFromCOWG, othersRemrks, status;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();


    private CoffeePulpingStationPSLViewModel coffeePulpingStationPSLViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_pulping_station_licence_appl_pslstep3, container, false);
        ButterKnife.bind(this, view);


        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();

        coffeePulpingStationPSLViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CoffeePulpingStationPSLViewModel.class);

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


        return view;
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        wasteAndPollutionsremarks = Objects.requireNonNull(etWasteAndPollution.getText()).toString().trim();
        coffeeAdvisoryOfficers = Objects.requireNonNull(etCoffeeAdvisoryOfficers.getText()).toString().trim();
        reccommendationsFromCOWG = Objects.requireNonNull(etReccomendationFromCWG.getText()).toString().trim();
        othersRemrks = Objects.requireNonNull(etOthersRemarks.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateEditText(etWasteAndPollution, wasteAndPollutionsremarks) &
                validateEditText(etCoffeeAdvisoryOfficers, coffeeAdvisoryOfficers) &
                validateEditText(etReccomendationFromCWG, reccommendationsFromCOWG) &
                validateEditText(etOthersRemarks, othersRemrks);

        CoffeePulpingStationPSLBus coffeePulpingStationPSLBus = CoffeePulpingStationPSLBus.getInstance();

        CoffeePulpingStationPSL coffeePulpingStationPSL = new CoffeePulpingStationPSL(
                0,
                coffeePulpingStationPSLBus.getDocument_number(),
                coffeePulpingStationPSLBus.getVisited_date(),
                coffeePulpingStationPSLBus.getName_of_applicant(),
                coffeePulpingStationPSLBus.getLicence_number(),
                coffeePulpingStationPSLBus.getAreaUnderCoffee(),
                coffeePulpingStationPSLBus.getPulpingMachine(),
                coffeePulpingStationPSLBus.getDateApprovedByTheBoard(),

                coffeePulpingStationPSLBus.getIsSkinDryingTable(),
                coffeePulpingStationPSLBus.getIsDryingTable(),
                coffeePulpingStationPSLBus.getIsFarmentationTable(),
                coffeePulpingStationPSLBus.getIsSoaktanks(),
                coffeePulpingStationPSLBus.getIsParcmentBuniStore(),
                coffeePulpingStationPSLBus.getSkinDryingTableremarks(),
                coffeePulpingStationPSLBus.getDryingTableremarks(),
                coffeePulpingStationPSLBus.getFarmentationTableremarks(),
                coffeePulpingStationPSLBus.getSoakTanksremarks(),
                coffeePulpingStationPSLBus.getParcmentBuniStoreremarks(),
                wasteAndPollutionsremarks,
                coffeeAdvisoryOfficers,
                reccommendationsFromCOWG,
                othersRemrks,
                recommendation,
                recommendationRemarks,
                status,
                coffeePulpingStationPSLBus.getLocalID(),
                false,
                ""
        );

        if (valid) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("COFFEE PSL INSPECTION!")
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


                            long coffeePSLLicenceAppPSL = db.updateCoffeePSLLicenceAppPSL(coffeePulpingStationPSL);
                            System.out.println("updateCoffeePSLLicenceAppPSL " + coffeePSLLicenceAppPSL);
                            coffeePulpingStationPSLViewModel.addRecord(coffeePulpingStationPSL);

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
