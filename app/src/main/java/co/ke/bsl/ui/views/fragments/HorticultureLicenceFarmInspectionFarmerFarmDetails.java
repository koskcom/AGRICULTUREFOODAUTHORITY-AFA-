package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.HorticultureCropExportLicenceFarmInspectionBus;
import co.ke.bsl.pojo.County;
import co.ke.bsl.pojo.HorticultureCropExportLicenceFarmInspectionDetails;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorticultureLicenceFarmInspectionFarmerFarmDetails extends Fragment implements BlockingStep {

    @BindView(R.id.etHLFIFarmName)
    CustomEditText etHLFIFarmName;
    @BindView(R.id.etHLFIFarmerName)
    CustomEditText etHLFIFarmerName;

    @BindView(R.id.isOwnFarm)
    CheckBox isOwnFarm;
    @BindView(R.id.isContractedSources)
    CheckBox isContractedSources;

    @BindView(R.id.etHLFIidNo)
    CustomEditText etHLFIidNo;
    @BindView(R.id.etHLFITel)
    CustomEditText etHLFITel;
    @BindView(R.id.etHLFIEmailAddress)
    CustomEditText etHLFIEmailAddress;
    @BindView(R.id.etHLFICounty)
    CustomEditText etHLFICounty;
    @BindView(R.id.etHLFILocation)
    CustomEditText etHLFILocation;
    @BindView(R.id.etHLFIIntendedCrop)
    CustomEditText etHLFIIntendedCrop;
    @BindView(R.id.etHLFIAcreageUnderCrop)
    CustomEditText etHLFIAcreageUnderCrop;

    private HorticultureCropExportLicenceFarmInspectionDetails horticultureCropExportLicenceFarmInspectionDetails = new HorticultureCropExportLicenceFarmInspectionDetails();
    private List<County> countyList = new ArrayList<>();
    private AFA app;
    private AFADatabaseAdapter db;

    private String own = "N", contracted = "N", farmName, farmerName;


    public HorticultureLicenceFarmInspectionFarmerFarmDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horticulture_licence_farm_inspection_farmer_farm_details, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        countyList = db.getAllCounty();

        final Observer<HorticultureCropExportLicenceFarmInspectionDetails> observer = new Observer<HorticultureCropExportLicenceFarmInspectionDetails>() {
            @Override
            public void onChanged(HorticultureCropExportLicenceFarmInspectionDetails changedHorticultureCropExportLicenceFarmInspectionDetails) {
                horticultureCropExportLicenceFarmInspectionDetails = changedHorticultureCropExportLicenceFarmInspectionDetails;

                System.out.println("applicant name passed " + horticultureCropExportLicenceFarmInspectionDetails.getNameOfApplicant());

                if(null != horticultureCropExportLicenceFarmInspectionDetails.getIsExporterOwnFarm() && horticultureCropExportLicenceFarmInspectionDetails.getIsExporterOwnFarm().equals("Y")){
                    isOwnFarm.setChecked(true);
                    own = "Y";
                    isOwnFarm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            isOwnFarm.setChecked(true);
                            isContractedSources.setChecked(false);
                        }
                    });
                } else {
                    isOwnFarm.setChecked(false);
                    own = "N";
                    isOwnFarm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            isOwnFarm.setChecked(false);
                        }
                    });
                }

                if(null != horticultureCropExportLicenceFarmInspectionDetails.getIsContractedSources() && horticultureCropExportLicenceFarmInspectionDetails.getIsContractedSources().equals("Y")){
                    isContractedSources.setChecked(true);
                    contracted = "Y";
                    isContractedSources.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            isContractedSources.setChecked(true);
                            isOwnFarm.setChecked(false);
                        }
                    });
                } else {
                    isContractedSources.setChecked(false);
                    contracted = "N";
                    isContractedSources.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            isContractedSources.setChecked(false);
                        }
                    });
                }

                if(!countyList.isEmpty()) {
                    for (County cnty : countyList) {
                        if (null != cnty.getCountyId() && cnty.getCountyId().equals(horticultureCropExportLicenceFarmInspectionDetails.getFarmerCounty())){

                            etHLFICounty.setText(cnty.getCountyName());

                            System.out.println(app + "County CountyID is " + cnty.getCountyId());
                        }else {
                            System.out.println(app + "County CountyID is null");
                        }
                    }
                } else {
                    System.out.println(app + "County countyList is null");
                }

                etHLFIFarmName.setText(horticultureCropExportLicenceFarmInspectionDetails.getFarmName());
                etHLFIFarmerName.setText(horticultureCropExportLicenceFarmInspectionDetails.getFarmerName());
                etHLFIidNo.setText(horticultureCropExportLicenceFarmInspectionDetails.getFarmerIdNumber());
                etHLFITel.setText(horticultureCropExportLicenceFarmInspectionDetails.getFarmerTelephone());
                etHLFIEmailAddress.setText(horticultureCropExportLicenceFarmInspectionDetails.getFarmerEmail());
                etHLFILocation.setText(horticultureCropExportLicenceFarmInspectionDetails.getFarmerLocation());
                etHLFIIntendedCrop.setText(horticultureCropExportLicenceFarmInspectionDetails.getIntendedCrop());
                etHLFIAcreageUnderCrop.setText(horticultureCropExportLicenceFarmInspectionDetails.getAcreageUnderCrop());

            }
        };

        app.getHorticultureCropExportLicenceFarmInspectionDetails().observe(this, observer);

        view.jumpDrawablesToCurrentState();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        farmName = Objects.requireNonNull(etHLFIFarmName.getText()).toString().trim();
        farmerName = Objects.requireNonNull(etHLFIFarmerName.getText()).toString().trim();
        String idNo = Objects.requireNonNull(etHLFIidNo.getText()).toString().trim();
        String tel = Objects.requireNonNull(etHLFITel.getText()).toString().trim();
        String email = Objects.requireNonNull(etHLFIEmailAddress.getText()).toString().trim();
        String county = Objects.requireNonNull(etHLFICounty.getText()).toString().trim();
        String location = Objects.requireNonNull(etHLFILocation.getText()).toString().trim();
        String intended = Objects.requireNonNull(etHLFIIntendedCrop.getText()).toString().trim();
        String acreage = Objects.requireNonNull(etHLFIAcreageUnderCrop.getText()).toString().trim();



        HorticultureCropExportLicenceFarmInspectionBus horticultureCropExportLicenceFarmInspectionBus = HorticultureCropExportLicenceFarmInspectionBus.getInstance();
        horticultureCropExportLicenceFarmInspectionBus.setIsExporterOwnFarm(own);
        horticultureCropExportLicenceFarmInspectionBus.setIsContractedSources(contracted);
        horticultureCropExportLicenceFarmInspectionBus.setFarmName(farmName);
        horticultureCropExportLicenceFarmInspectionBus.setFarmerName(farmerName);
        horticultureCropExportLicenceFarmInspectionBus.setFarmerIdNumber(idNo);
        horticultureCropExportLicenceFarmInspectionBus.setFarmerTelephone(tel);
        horticultureCropExportLicenceFarmInspectionBus.setFarmerEmail(email);
        horticultureCropExportLicenceFarmInspectionBus.setFarmerCounty(county);
        horticultureCropExportLicenceFarmInspectionBus.setFarmerLocation(location);
        horticultureCropExportLicenceFarmInspectionBus.setIntendedCrop(intended);
        horticultureCropExportLicenceFarmInspectionBus.setAcreageUnderCrop(acreage);
        callback.goToNextStep();
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
