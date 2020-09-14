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
import co.ke.bsl.data.model.CoffeeNurseryCert;
import co.ke.bsl.data.view.CoffeeNuerseryCertBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.pojo.Country;
import co.ke.bsl.pojo.WholeSaleImportedSugar;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.CoffeeNurseryCertificateViewModel;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeNurseryCertInspectionStep4 extends Fragment implements BlockingStep {


    @BindView(R.id.etSiteSuitability)
    CustomEditText etSiteSuitability;
    @BindView(R.id.etSiteAccessibilty)
    CustomEditText etSiteAccessibilty;
    @BindView(R.id.etWaterAvailability)
    CustomEditText etWaterAvailability;
    @BindView(R.id.etTechnicalKnowHow)
    CustomEditText etTechnicalKnowHow;
    @BindView(R.id.etAdvisoryOfficers)
    CustomEditText etAdvisoryOfficers;
    @BindView(R.id.etGroupReccomendations)
    CustomEditText etGroupReccomendations;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    protected Handler asyncTaskHandler;
    private AsyncActivitySupport asyncSupport;
    protected List<Country> countries;
    List<WholeSaleImportedSugar> wholeSaleImportedSugarList;
    AFADatabaseAdapter db;
    AFA app;
    private String siteSuitability, siteAccessibilty, waterAvailability, technicalKnowHow, advisoryOfficers, groupReccomendations;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();



    private CoffeeNurseryCertificateViewModel coffeeNurseryCertificateViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_nursery_cert_inspection_step4, container, false);
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

        coffeeNurseryCertificateViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CoffeeNurseryCertificateViewModel.class);

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        siteSuitability = Objects.requireNonNull(etSiteSuitability.getText()).toString().trim();
        siteAccessibilty = Objects.requireNonNull(etSiteAccessibilty.getText()).toString().trim();
        waterAvailability = Objects.requireNonNull(etWaterAvailability.getText()).toString().trim();
        technicalKnowHow = Objects.requireNonNull(etTechnicalKnowHow.getText()).toString().trim();
        advisoryOfficers = Objects.requireNonNull(etAdvisoryOfficers.getText()).toString().trim();
        groupReccomendations = Objects.requireNonNull(etGroupReccomendations.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateEditText(etSiteSuitability, siteSuitability) &
                validateEditText(etSiteAccessibilty, siteAccessibilty) &
                validateEditText(etWaterAvailability, waterAvailability) &
                validateEditText(etTechnicalKnowHow, technicalKnowHow) &
                validateEditText(etAdvisoryOfficers, advisoryOfficers) &
                validateEditText(etGroupReccomendations, groupReccomendations);

        CoffeeNuerseryCertBus coffeeNuerseryCertBus = CoffeeNuerseryCertBus.getInstance();
        CoffeeNurseryCert coffeeNurseryCert = new CoffeeNurseryCert(
                0,
                coffeeNuerseryCertBus.getDocumentNumber(),
                coffeeNuerseryCertBus.getDocumentaDate(),
                coffeeNuerseryCertBus.getApplicantName(),
                coffeeNuerseryCertBus.getCertificateNumber(),
                coffeeNuerseryCertBus.getLocalID(),
                coffeeNuerseryCertBus.getCounty(),
                coffeeNuerseryCertBus.getCountyIsCorrect(),
                coffeeNuerseryCertBus.getCountyRemarks(),
                coffeeNuerseryCertBus.getSub_county(),
                coffeeNuerseryCertBus.getSub_countyIsCorrect(),
                coffeeNuerseryCertBus.getSub_countyRemarks(),
                coffeeNuerseryCertBus.getLocation(),
                coffeeNuerseryCertBus.getLocationIsCorrect(),
                coffeeNuerseryCertBus.getLocationRemarks(),
                coffeeNuerseryCertBus.getSub_location(),
                coffeeNuerseryCertBus.getSub_locationIsCorrect(),
                coffeeNuerseryCertBus.getSub_locationRemarks(),
                coffeeNuerseryCertBus.getVillage(),
                coffeeNuerseryCertBus.getVillageIsCorrect(),
                coffeeNuerseryCertBus.getVillageRemarks(),
                coffeeNuerseryCertBus.getTitledeedIsTitledeed(),
                coffeeNuerseryCertBus.getTitledeedRemarks(),
                coffeeNuerseryCertBus.getCoffeeacreage(),
                coffeeNuerseryCertBus.getProduction(),
                coffeeNuerseryCertBus.getNurserycategory(),
                coffeeNuerseryCertBus.getNaurseryCategoryIsNursery(),
                coffeeNuerseryCertBus.getNurserycategoryRemarks(),
                siteSuitability,
                siteAccessibilty,
                waterAvailability,
                technicalKnowHow,
                advisoryOfficers,
                groupReccomendations,
                recommendation,
                recommendationRemarks,
                false,
                ""
        );

        if(valid) {
            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("NURSERY INSPECTION!")
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
                            db.UpdateCoffeeRecords(coffeeNurseryCert);
                            coffeeNurseryCertificateViewModel.addRecord(coffeeNurseryCert);


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
