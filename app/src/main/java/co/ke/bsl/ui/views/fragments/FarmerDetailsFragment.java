package co.ke.bsl.ui.views.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import co.ke.bsl.data.view.CaneCensusBus;
import co.ke.bsl.data.view.ClientBus;
import co.ke.bsl.data.view.CountyView;
import co.ke.bsl.data.view.GenderView;
import co.ke.bsl.pojo.CaneCensusFarmer;
import co.ke.bsl.pojo.County;
import co.ke.bsl.pojo.SubCounty;
import co.ke.bsl.util.CustomEditText;

public class FarmerDetailsFragment extends Fragment implements BlockingStep {

    @BindView(R.id.ssCounty)
    SearchableSpinner ssCounty;
    @BindView(R.id.ssSubCounty)
    SearchableSpinner ssSubCounty;
    @BindView(R.id.ssGender)
    SearchableSpinner ssGender;
    @BindView(R.id.editTextName)
    CustomEditText editTextName;
    @BindView(R.id.editTextPhoneNumber)
    CustomEditText editTextPhoneNumber;
    @BindView(R.id.editTextIDNumber)
    CustomEditText editTextIDNumber;
    AFADatabaseAdapter db;
    protected List<County> countyList;
    protected List<SubCounty> subCountyList;

    private County county;

    private SubCounty subCounty;

    CaneCensusFarmer caneCensusFarmer;


    private ArrayList<String> genderNameList = new ArrayList<>();
    private ArrayList<String> countyNameList = new ArrayList<>();

    private String gender;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_farmer_details, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getActivity()).open();
        countyList = new ArrayList<>();

        setListGender(getDummyGender());
        // setListCounties(getDummyCounties());
        setListCounties(getCountyListApplicable());

        ssCounty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                county = (County) ssCounty.getSelectedItem();

                if (!(county == null)) {

                    System.out.println("the county ID================" + county.getCountyId());


                    getSubCountyListApplicable(county);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        ssSubCounty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                subCounty = (SubCounty) ssSubCounty.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        ssGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // gender = ssGender.getSelectedItem().toString();
                if (!(ssGender.getSelectedItem() == null)) {

                    if (ssGender.getSelectedItem().toString().equalsIgnoreCase("Male")) {
                        gender = "1000000";
                    } else {
                        gender = "1000001";
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        return view;
    }

    protected void getSubCountyListApplicable(County county) {

        System.out.println("the county ID================" + county.getCountyId());

        if (county.getCountyId() != null) {

            //caneCensusFarmer.setCountyID(county.getCountyId());
            //  caneCensusFarmer.setLoginRequest(appState.getLoginRequest());

            subCountyList = db.getAllSubCounty(county.getCountyId());

            populateSubCountySpinner();
/*
            String uri = getString(R.string.baseURILocal);

            if (isNetworkConnectedElseAlert()) {

                new HttpGetSubCountyListTask(CaneCensusScoreFarmerDetailsActivity.this, uri, 0)
                        .execute(caneCensusFarmer);

            }*/


        }


    }

    private void populateSubCountySpinner() {

        ArrayAdapter<SubCounty> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, subCountyList);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssSubCounty.setAdapter(regionAdapter);


        ssSubCounty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // Can also use mySpinner.setOnItemClickListener(......)
                // Using a separate button here as there's often other data to select
                // or if you choose the wrong item.

                if (!(ssSubCounty.getSelectedItem() == null)) {


                    subCounty = (SubCounty) ssSubCounty.getSelectedItem();


                    //appState.set(selectedSubcounty);
                    //	toast(String.format("Company Selected: " + selectedSubCounty.getSubCountyName() + "\t  County: " + selectedSubCounty.getSubCountyId()));


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void setListGender(List<GenderView> dummyGender) {

        genderNameList.add("- Required -");
        for (GenderView regionWrapper : dummyGender) {
            genderNameList.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, genderNameList);


        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssGender.setAdapter(regionAdapter);
    }

    /*private void setListCounties(List<CountyView> dummyCounty) {

        countyNameList.add("- Required -");
        for (CountyView regionWrapper : dummyCounty) {
            countyNameList.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, countyNameList);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssCounty.setAdapter(regionAdapter);
        ssSubCounty.setAdapter(regionAdapter);
    }*/

    private void setListCounties(List<County> realCounty) {

       /* countyNameList.add("- Required -");
        for (County regionWrapper : realCounty) {
            countyNameList.add(regionWrapper.getCountyName());
        }*/

        ArrayAdapter<County> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, realCounty);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssCounty.setAdapter(regionAdapter);


    }

    protected List<County> getCountyListApplicable() {
        countyList.clear();

        countyList = db.getAllCounty();
        System.out.println("countyList" + countyList.size());
        return countyList;

        // populateSpinner();


    }
    
    
/*
    private List<CountyView> getDummyCounties() {
        List<CountyView> listViewItems = new ArrayList<>();
        listViewItems.add(new CountyView("Uasin Gishu"));
        listViewItems.add(new CountyView("Nairobi"));
        listViewItems.add(new CountyView("Homa Bay"));
        listViewItems.add(new CountyView("Migori"));
        listViewItems.add(new CountyView("Tana River"));
        listViewItems.add(new CountyView("Marsabit"));
        listViewItems.add(new CountyView("Isiolo"));
        listViewItems.add(new CountyView("Meru"));
        listViewItems.add(new CountyView("Tharaka-Nithi"));
        listViewItems.add(new CountyView("Embu"));
        listViewItems.add(new CountyView("Kitui"));
        listViewItems.add(new CountyView("Machakos"));
        listViewItems.add(new CountyView("Makueni"));
        listViewItems.add(new CountyView("Nyandarua"));
        listViewItems.add(new CountyView("Nyeri"));
        listViewItems.add(new CountyView("Kirinyaga"));
        listViewItems.add(new CountyView("Muranga"));
        listViewItems.add(new CountyView("Kiambu"));
        listViewItems.add(new CountyView("Turkana"));
        listViewItems.add(new CountyView("West Pokot"));
        listViewItems.add(new CountyView("Samburu"));
        listViewItems.add(new CountyView("Trans-Nzoia"));
        listViewItems.add(new CountyView("Elgeyo-Markwet"));
        listViewItems.add(new CountyView("Nandi"));
        listViewItems.add(new CountyView("Baringo"));
        listViewItems.add(new CountyView("Laikipia"));
        listViewItems.add(new CountyView("Nakuru"));
        listViewItems.add(new CountyView("Narok"));
        listViewItems.add(new CountyView("Kajiado"));
        listViewItems.add(new CountyView("Kericho"));
        listViewItems.add(new CountyView("Bomet"));
        listViewItems.add(new CountyView("Kakamega"));
        listViewItems.add(new CountyView("Vihiga"));
        listViewItems.add(new CountyView("Bungoma"));
        listViewItems.add(new CountyView("Busia"));
        listViewItems.add(new CountyView("Siaya"));
        listViewItems.add(new CountyView("Kisumu"));
        listViewItems.add(new CountyView("Kisii"));
        listViewItems.add(new CountyView("Nyamira"));
        listViewItems.add(new CountyView("Mombasa"));
        listViewItems.add(new CountyView("Kwale"));
        listViewItems.add(new CountyView("Kilifi"));
        listViewItems.add(new CountyView("Mandera"));
        listViewItems.add(new CountyView("Wajir"));
        listViewItems.add(new CountyView("Garissa"));
        listViewItems.add(new CountyView("Taita Taveta"));
        listViewItems.add(new CountyView("Lamu"));
        return listViewItems;
    }
*/

    private List<GenderView> getDummyGender() {
        List<GenderView> listViewItems = new ArrayList<>();
        listViewItems.add(new GenderView("Male"));
        listViewItems.add(new GenderView("Female"));
        return listViewItems;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        String fullname = Objects.requireNonNull(editTextName.getText()).toString().trim();
        String telephone = Objects.requireNonNull(editTextPhoneNumber.getText()).toString().trim();
        String idNumber = Objects.requireNonNull(editTextIDNumber.getText()).toString().trim();

        if (TextUtils.isEmpty(fullname)) {
            editTextName.setError("Farmer's Name Required");
            return;
        }

        if (TextUtils.isEmpty(idNumber)) {
            editTextIDNumber.setError("Farmer's ID Number Required");
            return;
        }

        if ("- Required -".equals(gender)) {
            TextView errorText = (TextView) ssGender.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }


        if (TextUtils.isEmpty(telephone)) {
            editTextPhoneNumber.setError("Telephone Number Required");
            return;
        }

        if ("- Required -".equals(county)) {
            TextView errorText = (TextView) ssCounty.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }

        if ("- Required -".equals(subCounty) || null == subCounty) {
            TextView errorText = (TextView) ssSubCounty.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }

        CaneCensusBus caneCensusBus = CaneCensusBus.getInstance();
        caneCensusBus.setFarmerCounty(county.getCountyId());
        caneCensusBus.setFarmerFullNames(fullname);
        caneCensusBus.setFarmerIDNumber(idNumber);
        caneCensusBus.setFarmerGender(gender);
        caneCensusBus.setFarmerSubCounty(subCounty.getSubCountyId());
        caneCensusBus.setFarmerPhoneNumber(telephone);
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
