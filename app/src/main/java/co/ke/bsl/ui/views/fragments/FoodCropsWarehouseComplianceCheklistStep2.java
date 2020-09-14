package co.ke.bsl.ui.views.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.FCDSisalSpinningFactoryInspectionBus;
import co.ke.bsl.data.view.FoodWareHouseBus;
import co.ke.bsl.data.view.LeaseAgreementView;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.data.view.View10Marks;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

public class FoodCropsWarehouseComplianceCheklistStep2 extends Fragment implements BlockingStep {


    @BindView(R.id.ssleaseAgreement)
    SearchableSpinner ssleaseAgreement;

    @BindView(R.id.isGraincleaningFacility)
    CheckBox isGraincleaningFacility;
    @BindView(R.id.etgraincleaningFacility_Remarks)
    CustomEditText etgraincleaningFacility_Remarks;
    @BindView(R.id.isLoadingcapacity)
    CheckBox isLoadingcapacity;
    @BindView(R.id.etloadingcapacity_Remarks)
    CustomEditText etloadingcapacity_Remarks;
    @BindView(R.id.isDrier)
    CheckBox isDrier;
    @BindView(R.id.etdrier_Remarks)
    CustomEditText etdrier_Remarks;
    @BindView(R.id.isLabRoom)
    CheckBox isLabRoom;
    @BindView(R.id.etlabRoom_Remarks)
    CustomEditText etlabRoom_Remarks;
    @BindView(R.id.isWallandventilation)
    CheckBox isWallandventilation;
    @BindView(R.id.etWallandventilation_Remarks)
    CustomEditText etWallandventilation_Remarks;
    @BindView(R.id.isWaterproofprovisions)
    CheckBox isWaterproofprovisions;
    @BindView(R.id.etWaterproofprovisions_Remarks)
    CustomEditText etWaterproofprovisions_Remarks;
    @BindView(R.id.isInternalsupport)
    CheckBox isInternalsupport;
    @BindView(R.id.etInternalsupport_Remarks)
    CustomEditText etInternalsupport_Remarks;
    @BindView(R.id.isContinuousconcretefloor)
    CheckBox isContinuousconcretefloor;
    @BindView(R.id.etContinuousconcretefloor_Remarks)
    CustomEditText etContinuousconcretefloor_Remarks;
    @BindView(R.id.isCorrugatedgalvanizedroof)
    CheckBox isCorrugatedgalvanizedroof;
    @BindView(R.id.etCorrugatedgalvanizedroof_Remarks)
    CustomEditText etCorrugatedgalvanizedroof_Remarks;
    @BindView(R.id.isTheNohighgaugesteeldoors)
    CheckBox isTheNohighgaugesteeldoors;
    @BindView(R.id.etTheNohighgaugesteeldoors_Remarks)
    CustomEditText etTheNohighgaugesteeldoors_Remarks;
    @BindView(R.id.isHygieneAndCleanliness)
    CheckBox isHygieneAndCleanliness;
    @BindView(R.id.etHygieneAndCleanliness_Remarks)
    CustomEditText etHygieneAndCleanliness_Remarks;
    @BindView(R.id.isPerimeterwallandtruckaccesspavement)
    CheckBox isPerimeterwallandtruckaccesspavement;
    @BindView(R.id.etPerimeterwallandtruckaccesspavement_Remarks)
    CustomEditText etPerimeterwallandtruckaccesspavement_Remarks;


    private String ssleaseagreement, isGraincleaningfacility, graincleaningfacility_Remarks, isLoadingCapacity, loadingCapacity_Remarks;
    private String isdrier, drier_remarks, islabroom, labroom_Remarks, isWallandVentilation, wallandVentilation_Remarks;
    private String isWaterproofProvisions, waterproofProvisions_Remarks, isInternalSupport, internalSupport_Remarks, isContinuousConcretefloor, continuousconcretefloor_Remarks;
    private String isCorrugatedgalvanizedRoof, corrugatedgalvanizedroof_Remarks, isTheNohighGaugesteeldoors, theNohighgaugesteeldoors_Remarks;
    private String isHygieneAndcleanliness, hygieneAndCleanliness_Remarks, isPerimeterwallandtruckaccessPavement, perimeterwallandtruckaccesspavement_Remarks;


    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;


    private ArrayList<LeaseAgreementView>leaseAgreementList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.food_crops_warehouse_fragment2, container, false);
        ButterKnife.bind(this, view);

        setListAgreement(getdummyLeaseOfAgreement());

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        ssleaseAgreement.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LeaseAgreementView rec = (LeaseAgreementView) ssleaseAgreement.getSelectedItem();
                ssleaseagreement = rec.getServerID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        isGraincleaningFacility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isGraincleaningFacility.isChecked()) {
                    isGraincleaningfacility = "Y";
                } else {
                    isGraincleaningfacility = "N";
                }
            }
        });


        isLoadingcapacity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLoadingcapacity.isChecked()) {
                    isLoadingCapacity = "Y";
                } else {
                    isLoadingCapacity = "N";
                }
            }
        });

        isDrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDrier.isChecked()) {
                    isdrier = "Y";
                } else {
                    isdrier = "N";
                }
            }
        });

        isLabRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLabRoom.isChecked()) {
                    islabroom = "Y";
                } else {
                    islabroom = "N";
                }
            }
        });
        isWallandventilation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWallandventilation.isChecked()) {
                    isWallandVentilation = "Y";
                } else {
                    isWallandVentilation = "N";
                }
            }
        });

        isWaterproofprovisions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWaterproofprovisions.isChecked()) {
                    isWaterproofProvisions = "Y";
                } else {
                    isWaterproofProvisions = "N";
                }
            }
        });

        isInternalsupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInternalsupport.isChecked()) {
                    isInternalSupport = "Y";
                } else {
                    isInternalSupport = "N";
                }
            }
        });

        isContinuousconcretefloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isContinuousconcretefloor.isChecked()) {
                    isContinuousConcretefloor = "Y";
                } else {
                    isContinuousConcretefloor = "N";
                }
            }
        });

        isCorrugatedgalvanizedroof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCorrugatedgalvanizedroof.isChecked()) {
                    isCorrugatedgalvanizedRoof = "Y";
                } else {
                    isCorrugatedgalvanizedRoof = "N";
                }
            }
        });

        isTheNohighgaugesteeldoors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTheNohighgaugesteeldoors.isChecked()) {
                    isTheNohighGaugesteeldoors = "Y";
                } else {
                    isTheNohighGaugesteeldoors = "N";
                }
            }
        });

        isHygieneAndCleanliness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHygieneAndCleanliness.isChecked()) {
                    isHygieneAndcleanliness = "Y";
                } else {
                    isHygieneAndcleanliness = "N";
                }
            }
        });

        isPerimeterwallandtruckaccesspavement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPerimeterwallandtruckaccesspavement.isChecked()) {
                    isPerimeterwallandtruckaccessPavement = "Y";
                } else {
                    isPerimeterwallandtruckaccessPavement = "N";
                }
            }
        });

        return view;


    }

    private void setListAgreement(List<LeaseAgreementView> getdummyLeaseOfAgreement) {
        for (LeaseAgreementView regionWrapper : getdummyLeaseOfAgreement) {
            leaseAgreementList.add(regionWrapper);
        }
        ArrayAdapter<LeaseAgreementView> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, leaseAgreementList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssleaseAgreement.setAdapter(regionAdapter);


    }
    private List<LeaseAgreementView> getdummyLeaseOfAgreement() {
        List<LeaseAgreementView> listViewItems = new ArrayList<>();
        listViewItems.add(new LeaseAgreementView("-Select-", " "));
        listViewItems.add(new LeaseAgreementView("Atleast 6 Months","10000437"));
        listViewItems.add(new LeaseAgreementView("Atleast 12 Months","10000436"));
        listViewItems.add(new LeaseAgreementView("Atleast 18 Months","10000435"));
        listViewItems.add(new LeaseAgreementView("Atleast 24 Months","10000434"));

        return listViewItems;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        graincleaningfacility_Remarks = Objects.requireNonNull(etgraincleaningFacility_Remarks.getText()).toString().trim();
        loadingCapacity_Remarks = Objects.requireNonNull(etloadingcapacity_Remarks.getText()).toString().trim();
        drier_remarks = Objects.requireNonNull(etdrier_Remarks.getText()).toString().trim();
        labroom_Remarks = Objects.requireNonNull(etlabRoom_Remarks.getText()).toString().trim();
        wallandVentilation_Remarks = Objects.requireNonNull(etWallandventilation_Remarks.getText()).toString().trim();
        waterproofProvisions_Remarks = Objects.requireNonNull(etWaterproofprovisions_Remarks.getText()).toString().trim();
        internalSupport_Remarks = Objects.requireNonNull(etInternalsupport_Remarks.getText()).toString().trim();
        continuousconcretefloor_Remarks = Objects.requireNonNull(etContinuousconcretefloor_Remarks.getText()).toString().trim();
        corrugatedgalvanizedroof_Remarks = Objects.requireNonNull(etCorrugatedgalvanizedroof_Remarks.getText()).toString().trim();
        theNohighgaugesteeldoors_Remarks = Objects.requireNonNull(etTheNohighgaugesteeldoors_Remarks.getText()).toString().trim();
        hygieneAndCleanliness_Remarks = Objects.requireNonNull(etHygieneAndCleanliness_Remarks.getText()).toString().trim();
        perimeterwallandtruckaccesspavement_Remarks = Objects.requireNonNull(etPerimeterwallandtruckaccesspavement_Remarks.getText()).toString().trim();

        boolean valid = validateFields(isGraincleaningFacility, etgraincleaningFacility_Remarks, graincleaningfacility_Remarks) &
                validateFields(isLoadingcapacity, etloadingcapacity_Remarks, loadingCapacity_Remarks) &
                validateFields(isDrier, etdrier_Remarks, drier_remarks) &
                validateFields(isLabRoom, etlabRoom_Remarks, labroom_Remarks) &
                validateFields(isWallandventilation, etWallandventilation_Remarks, wallandVentilation_Remarks) &
                validateFields(isWaterproofprovisions, etWaterproofprovisions_Remarks, waterproofProvisions_Remarks) &
                validateFields(isInternalsupport, etInternalsupport_Remarks, internalSupport_Remarks) &
                validateFields(isContinuousconcretefloor, etContinuousconcretefloor_Remarks, continuousconcretefloor_Remarks) &
                validateFields(isCorrugatedgalvanizedroof, etCorrugatedgalvanizedroof_Remarks, corrugatedgalvanizedroof_Remarks) &
                validateFields(isTheNohighgaugesteeldoors, etTheNohighgaugesteeldoors_Remarks, theNohighgaugesteeldoors_Remarks) &
                validateFields(isHygieneAndCleanliness, etHygieneAndCleanliness_Remarks, hygieneAndCleanliness_Remarks) &
                validateFields(isPerimeterwallandtruckaccesspavement, etPerimeterwallandtruckaccesspavement_Remarks, perimeterwallandtruckaccesspavement_Remarks);



        FoodWareHouseBus foodWareHouseBus = FoodWareHouseBus.getInstance();

        foodWareHouseBus.setSsleaseagreement(ssleaseagreement);
        foodWareHouseBus.setIsGraincleaningfacility(isGraincleaningfacility);
        foodWareHouseBus.setGraincleaningfacility_Remarks(graincleaningfacility_Remarks);
        foodWareHouseBus.setIsLoadingCapacity(isLoadingCapacity);
        foodWareHouseBus.setLoadingCapacity_Remarks(loadingCapacity_Remarks);
        foodWareHouseBus.setIsdrier(isdrier);
        foodWareHouseBus.setDrier_remarks(drier_remarks);
        foodWareHouseBus.setIslabroom(islabroom);
        foodWareHouseBus.setLabroom_Remarks(labroom_Remarks);
        foodWareHouseBus.setIsWallandVentilation(isWallandVentilation);
        foodWareHouseBus.setWallandVentilation_Remarks(wallandVentilation_Remarks);
        foodWareHouseBus.setIsWaterproofProvisions(isWaterproofProvisions);
        foodWareHouseBus.setWaterproofProvisions_Remarks(waterproofProvisions_Remarks);
        foodWareHouseBus.setIsInternalSupport(isInternalSupport);
        foodWareHouseBus.setInternalSupport_Remarks(internalSupport_Remarks);
        foodWareHouseBus.setIsContinuousConcretefloor(isContinuousConcretefloor);
        foodWareHouseBus.setContinuousconcretefloor_Remarks(continuousconcretefloor_Remarks);
        foodWareHouseBus.setIsCorrugatedgalvanizedRoof(isCorrugatedgalvanizedRoof);
        foodWareHouseBus.setCorrugatedgalvanizedroof_Remarks(corrugatedgalvanizedroof_Remarks);
        foodWareHouseBus.setIsTheNohighGaugesteeldoors(isTheNohighGaugesteeldoors);
        foodWareHouseBus.setTheNohighgaugesteeldoors_Remarks(theNohighgaugesteeldoors_Remarks);
        foodWareHouseBus.setIsHygieneAndcleanliness(isHygieneAndcleanliness);
        foodWareHouseBus.setHygieneAndCleanliness_Remarks(hygieneAndCleanliness_Remarks);
        foodWareHouseBus.setIsPerimeterwallandtruckaccessPavement(isPerimeterwallandtruckaccessPavement);
        foodWareHouseBus.setPerimeterwallandtruckaccesspavement_Remarks(perimeterwallandtruckaccesspavement_Remarks);

        if (valid) {
            callback.goToNextStep();
        }

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
            } else result = true;
        } else {
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
