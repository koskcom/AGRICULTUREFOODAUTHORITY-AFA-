package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.CoffeeNuerseryCertBus;
import co.ke.bsl.pojo.CoffeeNursercertInsp;
import co.ke.bsl.pojo.County;
import co.ke.bsl.pojo.SubCounty;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */

public class CoffeeNurseryCertInspectionStep2 extends Fragment implements BlockingStep {


    @BindView(R.id.etcountycounty)
    CustomEditText etcountycounty;
    @BindView(R.id.isCountyCorrect)
    CheckBox isCountyCorrect;
    @BindView(R.id.etcountyremarks)
    CustomEditText etcountyremarks;
    @BindView(R.id.etsubcounty)
    CustomEditText etsubcounty;
    @BindView(R.id.issubCountycorrect)
    CheckBox issubCountycorrect;
    @BindView(R.id.etsubcountyremarks)
    CustomEditText etsubcountyremarks;
    @BindView(R.id.etLocation)
    CustomEditText etLocation;
    @BindView(R.id.islocationcorrect)
    CheckBox islocationcorrect;
    @BindView(R.id.etlocationremarks)
    CustomEditText etlocationremarks;
    @BindView(R.id.etSubLocation)
    CustomEditText etSubLocation;
    @BindView(R.id.isSubLocationcorrect)
    CheckBox isSubLocationcorrect;
    @BindView(R.id.etsubLocationremarks)
    CustomEditText etsubLocationremarks;
    @BindView(R.id.etVillage)
    CustomEditText etVillage;
    @BindView(R.id.isVillagecorrect)
    CheckBox isVillagecorrect;
    @BindView(R.id.etVillageremarks)
    CustomEditText etVillageremarks;

    private String county, sub_county, location, sub_location, village;
    private String countyIsCorrect, sub_countyIsCorrect, locationIsCorrect, sub_locationIsCorrect, villageIsCorrect;
    private String countyRemarks, sub_countyRemarks, locationRemarks, sub_locationRemarks, villageRemarks;

    AFADatabaseAdapter db;
    AFA app;

    private GPSTracker mGPS;
    private ArrayList<String> cityList = new ArrayList<>();
    protected List<CoffeeNursercertInsp> CoffeeNursercertInspList;
    protected Handler asyncTaskHandler;
    private List<County> countyList = new ArrayList<>();
    private List<SubCounty> subCountyList = new ArrayList<>();
    CoffeeNursercertInsp coffeeNursercertInsp = new CoffeeNursercertInsp();

    public CoffeeNurseryCertInspectionStep2() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_inspection_step2, container, false);
        ButterKnife.bind(this, view);


        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        countyList = db.getAllCounty();

        final Observer<CoffeeNursercertInsp> observer = new Observer<CoffeeNursercertInsp>() {
            @Override
            public void onChanged(CoffeeNursercertInsp coffeeNursercertInspection) {
                coffeeNursercertInsp = coffeeNursercertInspection;

                System.out.println("applicant name passed " + coffeeNursercertInsp.getApplicantName());

                county = coffeeNursercertInsp.getCounty();
                sub_county = coffeeNursercertInsp.getSub_county();
                location = coffeeNursercertInsp.getLocation();
                sub_location = coffeeNursercertInsp.getSub_location();
                village = coffeeNursercertInsp.getVillage();

                if(!countyList.isEmpty()) {
                    for (County cnty : countyList) {
                        if (null != cnty.getCountyId() && cnty.getCountyId().equals(county)){

                            etcountycounty.setText(cnty.getCountyName());

                            System.out.println(app + "County CountyID is " + cnty.getCountyId());
                        }else {
                            System.out.println(app + "County CountyID is null");
                        }
                    }
                } else {
                    System.out.println(app + "County countyList is null");
                }

                if(county != null && !county.isEmpty()){
                    subCountyList = db.getAllSubCounty(county);
                    if(!subCountyList.isEmpty()) {
                        for (SubCounty subCnty : subCountyList) {
                            if (null != subCnty.getSubCountyId() && subCnty.getSubCountyId().equals(sub_county)){

                                etsubcounty.setText(subCnty.getSubCountyName());
                            }
                        }
                    }else{
                        System.out.println(app + "SubCounty SubCountyID is null");
                    }
                } else{
                    System.out.println(app + "SubCounty CountyID is null");
                }

                etLocation.setText(location);
                etSubLocation.setText(sub_location);
                etVillage.setText(village);
            }
        };

        app.getCoffeeNurseryInspection().observe(this, observer);

        isCountyCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCountyCorrect.isChecked()) {
                    countyIsCorrect = "Y";
                } else {
                    countyIsCorrect = "N";
                }

            }
        });

        issubCountycorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (issubCountycorrect.isChecked()) {
                    sub_countyIsCorrect = "Y";
                } else {
                    sub_countyIsCorrect = "N";
                }

            }
        });



        islocationcorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (islocationcorrect.isChecked()) {
                    locationIsCorrect = "Y";
                } else {
                    locationIsCorrect = "N";
                }

            }
        });

        isSubLocationcorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSubLocationcorrect.isChecked()) {
                    sub_locationIsCorrect = "Y";
                } else {
                    sub_locationIsCorrect = "N";
                }

            }
        });

        isVillagecorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isVillagecorrect.isChecked()) {
                    villageIsCorrect = "Y";
                } else {
                    villageIsCorrect = "N";
                }

            }
        });
        return view;
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {


        countyRemarks = Objects.requireNonNull(etcountyremarks.getText()).toString().trim();
        sub_countyRemarks = Objects.requireNonNull(etsubcountyremarks.getText()).toString().trim();
        locationRemarks = Objects.requireNonNull(etlocationremarks.getText()).toString().trim();
        sub_locationRemarks = Objects.requireNonNull(etsubLocationremarks.getText()).toString().trim();
        villageRemarks = Objects.requireNonNull(etVillageremarks.getText()).toString().trim();

        boolean valid = validateFields(isCountyCorrect, etcountyremarks, countyRemarks) &
                validateFields(issubCountycorrect, etsubcountyremarks, sub_countyRemarks) &
                validateFields(islocationcorrect, etlocationremarks, locationRemarks) &
                validateFields(isSubLocationcorrect, etsubLocationremarks, sub_locationRemarks) &
                validateFields(isVillagecorrect, etVillageremarks, villageRemarks);

        CoffeeNuerseryCertBus coffeeNuerseryCertBus = CoffeeNuerseryCertBus.getInstance();

        coffeeNuerseryCertBus.setCountyIsCorrect(countyIsCorrect);
        coffeeNuerseryCertBus.setCountyRemarks(countyRemarks);
        coffeeNuerseryCertBus.setSub_countyIsCorrect(sub_countyIsCorrect);
        coffeeNuerseryCertBus.setSub_countyRemarks(sub_countyRemarks);
        coffeeNuerseryCertBus.setLocationIsCorrect(locationIsCorrect);
        coffeeNuerseryCertBus.setLocationRemarks(locationRemarks);
        coffeeNuerseryCertBus.setSub_locationIsCorrect(sub_locationIsCorrect);
        coffeeNuerseryCertBus.setSub_locationRemarks(sub_locationRemarks);
        coffeeNuerseryCertBus.setVillageIsCorrect(villageIsCorrect);
        coffeeNuerseryCertBus.setVillageRemarks(villageRemarks);

        if(valid) {
            callback.goToNextStep();
        }
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
}
