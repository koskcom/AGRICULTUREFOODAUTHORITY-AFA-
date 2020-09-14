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
import co.ke.bsl.data.model.HCDNurseryInspection;
import co.ke.bsl.data.view.HCDNurseryInspectionBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.HorticultureNurseryViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDNurseryInspectionStep3 extends Fragment implements BlockingStep {


    @BindView(R.id.isAreStructuresInPlace)
    CheckBox isAreStructuresInPlace;
    @BindView(R.id.etAreStructuresInPlaceRemarks)
    CustomEditText etAreStructuresInPlaceRemarks;

    @BindView(R.id.isScionSource)
    CheckBox isScionSource;
    @BindView(R.id.etScionSourceRemarks)
    CustomEditText etScionSourceRemarks;


    @BindView(R.id.isApprovedSource)
    CheckBox isApprovedSource;
    @BindView(R.id.etApprovedSourceRemarks)
    CustomEditText etApprovedSourceRemarks;

    @BindView(R.id.isWellLabeledNurseryBlock)
    CheckBox isWellLabeledNurseryBlock;
    @BindView(R.id.etWellLabeledNurseryBlockRemarks)
    CustomEditText etWellLabeledNurseryBlockRemarks;

    @BindView(R.id.isReadyDispatchSeedlings)
    CheckBox isReadyDispatchSeedlings;
    @BindView(R.id.etReadyDispatchSeedlingsRemarks)
    CustomEditText etReadyDispatchSeedlingsRemarks;

    @BindView(R.id.isIsdistributionRecords)
    CheckBox isIsdistributionRecords;
    @BindView(R.id.etIsdistributionRecordsRemarks)
    CustomEditText etIsdistributionRecordsRemarks;

    @BindView(R.id.isNurseryCertificateWell)
    CheckBox isNurseryCertificateWell;
    @BindView(R.id.etNurseryCertificateWellRemarks)
    CustomEditText etNurseryCertificateWellRemarks;

    @BindView(R.id.etcomments)
    CustomEditText etcomments;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;


    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private HorticultureNurseryViewModel horticultureNurseryViewModel;

    private String isArestructuresInPlace, arestructuresInPlaceRemarks, isScionsource, scionSourceRemarks;
    private String isApprovedsource, approvedSourceRemarks, isWellLabeledNurseryblock, wellLabeledNurseryBlockRemarks, isReadydispatchSeedlings, readydispatchSeedlingsRemarks;
    private String isdistributionRecords, distributionRecordsRemarks, isNurserycertificateWell, nurserycertificateWellRemarks, otherRemarks;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afahcdnursery_inspection_step3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        horticultureNurseryViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(HorticultureNurseryViewModel.class);

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

        isAreStructuresInPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAreStructuresInPlace.isChecked()) {
                    isArestructuresInPlace = "Y";
                } else {
                    isArestructuresInPlace = "N";
                }

            }
        });
        isScionSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isScionSource.isChecked()) {
                    isScionsource = "Y";
                } else {
                    isScionsource = "N";
                }

            }
        });
        isApprovedSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isApprovedSource.isChecked()) {
                    isApprovedsource = "Y";
                } else {
                    isApprovedsource = "N";
                }

            }
        });
        isWellLabeledNurseryBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWellLabeledNurseryBlock.isChecked()) {
                    isWellLabeledNurseryblock = "Y";
                } else {
                    isWellLabeledNurseryblock = "N";
                }

            }
        });
        isReadyDispatchSeedlings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isReadyDispatchSeedlings.isChecked()) {
                    isReadydispatchSeedlings = "Y";
                } else {
                    isReadydispatchSeedlings = "N";
                }

            }
        });
        isIsdistributionRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isIsdistributionRecords.isChecked()) {
                    isdistributionRecords = "Y";
                } else {
                    isdistributionRecords = "N";
                }

            }
        });
        isNurseryCertificateWell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNurseryCertificateWell.isChecked()) {
                    isNurserycertificateWell = "Y";
                } else {
                    isNurserycertificateWell = "N";
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

        arestructuresInPlaceRemarks = Objects.requireNonNull(etAreStructuresInPlaceRemarks.getText()).toString().trim();
        scionSourceRemarks = Objects.requireNonNull(etScionSourceRemarks.getText()).toString().trim();
        approvedSourceRemarks = Objects.requireNonNull(etApprovedSourceRemarks.getText()).toString().trim();
        wellLabeledNurseryBlockRemarks = Objects.requireNonNull(etWellLabeledNurseryBlockRemarks.getText()).toString().trim();
        readydispatchSeedlingsRemarks = Objects.requireNonNull(etReadyDispatchSeedlingsRemarks.getText()).toString().trim();
        distributionRecordsRemarks = Objects.requireNonNull(etIsdistributionRecordsRemarks.getText()).toString().trim();
        nurserycertificateWellRemarks = Objects.requireNonNull(etNurseryCertificateWellRemarks.getText()).toString().trim();
        otherRemarks = Objects.requireNonNull(etcomments.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        //validation
        boolean valid = validateFields(isAreStructuresInPlace, etAreStructuresInPlaceRemarks, arestructuresInPlaceRemarks) &
                validateFields(isScionSource, etScionSourceRemarks, scionSourceRemarks) &
                validateFields(isApprovedSource, etApprovedSourceRemarks, approvedSourceRemarks) &
                validateFields(isWellLabeledNurseryBlock, etWellLabeledNurseryBlockRemarks, wellLabeledNurseryBlockRemarks) &
                validateFields(isReadyDispatchSeedlings, etReadyDispatchSeedlingsRemarks, readydispatchSeedlingsRemarks) &
                validateFields(isIsdistributionRecords, etIsdistributionRecordsRemarks, distributionRecordsRemarks) &
                validateFields(isNurseryCertificateWell, etNurseryCertificateWellRemarks, nurserycertificateWellRemarks);


        HCDNurseryInspectionBus hCDNurseryInspectionBus = HCDNurseryInspectionBus.getInstance();
        HCDNurseryInspection hCDNurseryInspection = new HCDNurseryInspection(
                0,
                hCDNurseryInspectionBus.getDocumentNumber(),
                hCDNurseryInspectionBus.getDocumentDate(),
                hCDNurseryInspectionBus.getNameOfApplicant(),
                hCDNurseryInspectionBus.getNurseryLicence(),
                hCDNurseryInspectionBus.getTelephone(),
                hCDNurseryInspectionBus.getLocation(),
                hCDNurseryInspectionBus.getEmail(),
                hCDNurseryInspectionBus.getLocalID(),
                hCDNurseryInspectionBus.getSsNurseryType(),
                hCDNurseryInspectionBus.getHectarage(),
                hCDNurseryInspectionBus.getIsDiseasefreeSeedling(),
                hCDNurseryInspectionBus.getDiseasefreeSeedlingRemarks(),
                hCDNurseryInspectionBus.getIsFreefromOrganicLitter(),
                hCDNurseryInspectionBus.getFreefromOrganicLitterRemarks(),
                hCDNurseryInspectionBus.getIsClearseparation(),
                hCDNurseryInspectionBus.getClearSeparationRemarks(),
                hCDNurseryInspectionBus.getIsYearroundSourceOfWater(),
                hCDNurseryInspectionBus.getYearroundSourceOfWaterRemarks(),
                hCDNurseryInspectionBus.getIsSoilmedia(),
                hCDNurseryInspectionBus.getSoilMediaRemarks(),
                hCDNurseryInspectionBus.getIsWellsecuredNurseryLayout(),
                hCDNurseryInspectionBus.getWellsecuredNurseryLayoutRemarks(),
                isArestructuresInPlace,
                arestructuresInPlaceRemarks,
                isScionsource,
                scionSourceRemarks,
                isApprovedsource,
                approvedSourceRemarks,
                isWellLabeledNurseryblock,
                wellLabeledNurseryBlockRemarks,
                isReadydispatchSeedlings,
                readydispatchSeedlingsRemarks,
                isdistributionRecords,
                distributionRecordsRemarks,
                isNurserycertificateWell,
                nurserycertificateWellRemarks,
                otherRemarks,
                recommendation,
                recommendationRemarks,
                false,
                ""


        );

        if (valid) {

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

                            db.UpdateHCDNurseryInspection(hCDNurseryInspection);
                            horticultureNurseryViewModel.addRecord(hCDNurseryInspection);


                            sDialog.dismissWithAnimation();
                            Intent intent = new Intent(getActivity(), DashboardActivity.class);
                            startActivity(intent);
                        }
                    })
                    .show();


        }

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
