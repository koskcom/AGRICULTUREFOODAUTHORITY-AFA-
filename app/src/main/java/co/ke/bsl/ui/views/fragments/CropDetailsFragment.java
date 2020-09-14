package co.ke.bsl.ui.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
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
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.CaneCensus;
import co.ke.bsl.data.view.CaneCensusBus;
import co.ke.bsl.data.view.ClientBus;
import co.ke.bsl.data.view.CountyView;
import co.ke.bsl.data.view.CropClassView;
import co.ke.bsl.data.view.CropVarietyView;
import co.ke.bsl.data.view.GenderView;
import co.ke.bsl.pojo.Product;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.CaneCensusRecordViewModel;
import co.ke.bsl.ui.viewmodels.RecordViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

public class CropDetailsFragment extends Fragment implements BlockingStep {

    @BindView(R.id.editTextCropAge)
    CustomEditText editTextCropAge;
    @BindView(R.id.ssCropClass)
    SearchableSpinner ssCropClass;
    @BindView(R.id.ssCropColour)
    SearchableSpinner ssCropColour;
    @BindView(R.id.ssCropDensity)
    SearchableSpinner ssCropDensity;
    @BindView(R.id.ssCropVigour)
    SearchableSpinner ssCropVigour;
    @BindView(R.id.ssCropVariety)
    SearchableSpinner ssCropVariety;
    @BindView(R.id.editTextHectares)
    CustomEditText editTextHectares;
    @BindView(R.id.editTextExpectedTCH)
    CustomEditText editTextExpectedTCH;
    @BindView(R.id.ssPestsAndDisease)
    SearchableSpinner ssPestsAndDisease;


    private ArrayList<String> cropClassNameList = new ArrayList<>();
    private ArrayList<String> cropVarietyNameList = new ArrayList<>();
    private Product product;
    protected List<Product> productsList = new ArrayList<>();
    AFADatabaseAdapter db;
    private GPSTracker mGPS;

    private String cropClass, cropVariety;
    private CaneCensusRecordViewModel caneCensusRecordViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crop_details, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();
        product = new Product();

        mGPS = new GPSTracker(getActivity());


        getProductListApplicable();
        setListCropClasses(getDummyCropClasses());

        setListCropVarieties(getCropMarks());


        // Apply the adapter to the spinner
       /* expectedTCH.setAdapter(adapterCaneMarks);
        hectares.setAdapter(adapterCaneMarks);
                aGEmonths.setAdapter(adapterCaneMarks);*/

        //


        ssCropClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                cropClass = ssCropClass.getSelectedItem().toString();

                if (!(ssCropClass.getSelectedItem() == null)) {


                    String expected_tch = "100.0";
                    String expected_tch1 = "90.0";
                    String expected_tch2 = "80.0";
                    String expected_tch3 = "70.0";

                    if (ssCropClass.getSelectedItem().equals("Plant Crop (PC)")) {
                        editTextExpectedTCH.setText(expected_tch);
                    }


                    if (ssCropClass.getSelectedItem().equals("Ratoon 1 (R1)")) {
                        editTextExpectedTCH.setText(expected_tch1);
                    }
                    if (ssCropClass.getSelectedItem().equals("Ratoon 2 (R2)")) {
                        editTextExpectedTCH.setText(expected_tch2);

                    }
                    if (ssCropClass.getSelectedItem().equals("Ratoon 3 (R3)")) {
                        editTextExpectedTCH.setText(expected_tch3);

                    }


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        caneCensusRecordViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CaneCensusRecordViewModel.class);

        return view;
    }

    protected void getProductListApplicable() {
        productsList.clear();

        productsList = db.getAllProduct();
        System.out.println("ther size of the Product list is " + productsList.size());

        populateProductSpinner();


    }


    /**
     *
     */
    private void populateProductSpinner() {


        ArrayAdapter<Product> spinnerAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, productsList);

        // Drop down layout style - list view with radio button


        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);


        // attaching data adapter to spinner
        ssCropVariety.setAdapter(spinnerAdapter);


        ssCropVariety.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // Can also use mySpinner.setOnItemClickListener(......)
                // Using a separate button here as there's often other data to select
                // or if you choose the wrong item.

                if (!(ssCropVariety.getSelectedItem() == null)) {


                    product = (Product) ssCropVariety.getSelectedItem();

                    cropClass = (String) ssCropClass.getSelectedItem();


//                    toast(cropClass);
                    // toast(String.format("Company Selected: " + product.getName() + "\t  County: " + product.getProductCategoryID() + "\t  CropClass: " + cropClass));


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setListCropClasses(List<CropClassView> dummyCropClasses) {

        cropClassNameList.add("- Required -");
        for (CropClassView regionWrapper : dummyCropClasses) {
            cropClassNameList.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, cropClassNameList);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssCropClass.setAdapter(regionAdapter);
    }

    private void setListCropVarieties(List<CropClassView> dummyCropVarieties) {

        cropVarietyNameList.add("- Required -");
        for (CropClassView regionWrapper : dummyCropVarieties) {
            cropVarietyNameList.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, cropVarietyNameList);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        // ssCropVariety.setAdapter(regionAdapter);
        ssCropVigour.setAdapter(regionAdapter);
        ssCropColour.setAdapter(regionAdapter);
        ssCropDensity.setAdapter(regionAdapter);
        ssPestsAndDisease.setAdapter(regionAdapter);
    }


    private List<CropClassView> getCropMarks() {
        List<CropClassView> listViewItems = new ArrayList<>();
        listViewItems.add(new CropClassView("0"));
        listViewItems.add(new CropClassView("1"));
        listViewItems.add(new CropClassView("2"));
        listViewItems.add(new CropClassView("3"));
        listViewItems.add(new CropClassView("4"));
        return listViewItems;
    }


    private List<CropClassView> getDummyCropClasses() {
        List<CropClassView> listViewItems = new ArrayList<>();
        listViewItems.add(new CropClassView("Plant Crop (PC)"));
        listViewItems.add(new CropClassView("Ratoon 1 (R1)"));
        listViewItems.add(new CropClassView("Ratoon 2 (R2)"));
        listViewItems.add(new CropClassView("Ratoon 3 (R3)"));
        return listViewItems;
    }

    // Toast
    public void toast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        String cropAge = Objects.requireNonNull(editTextCropAge.getText()).toString().trim();
        String cropColour = Objects.requireNonNull(ssCropColour.getSelectedItem().toString());
        String cropDensity = Objects.requireNonNull(ssCropDensity.getSelectedItem().toString());
        String cropVigour = Objects.requireNonNull(ssCropVigour.getSelectedItem().toString());
        String hectares = Objects.requireNonNull(editTextHectares.getText()).toString().trim();
        String expectedTCH = Objects.requireNonNull(editTextExpectedTCH.getText()).toString().trim();
        String cropPestsAndDisease = Objects.requireNonNull(ssPestsAndDisease.getSelectedItem().toString());
        String cropVariety = Objects.requireNonNull(product.getProductID().toString());


        if ("- Required -".equals(cropDensity)  || null == cropDensity) {
            TextView errorText = (TextView) ssCropDensity.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }
        if (TextUtils.isEmpty(hectares)) {
            editTextHectares.setError("Hectares Required");
            return;
        }

        if (TextUtils.isEmpty(cropAge)) {
            editTextCropAge.setError("Crop Age Required");
            return;
        }


        if ("- Required -".equals(cropColour) || null == cropColour) {
            TextView errorText = (TextView) ssCropColour.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }

        if (TextUtils.isEmpty(expectedTCH)) {
            editTextExpectedTCH.setError("Expected TCH Required");
            return;
        }


        if ("- Required -".equals(cropVigour) || null == cropVigour) {
            TextView errorText = (TextView) ssCropVigour.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }

        if ("- Required -".equals(cropClass) || null == cropClass) {
            TextView errorText = (TextView) ssCropClass.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }

        if ("- Required -".equals(cropVariety) || null == cropVariety) {
            TextView errorText = (TextView) ssCropVariety.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }

        CaneCensusBus caneCensusBus = CaneCensusBus.getInstance();

        CaneCensus caneCensus = new CaneCensus(
                0,
                caneCensusBus.getSugarCompany(),
                caneCensusBus.getSugarCompanyCounty(),
                caneCensusBus.getFarmerCounty(),
                caneCensusBus.getFarmerSubCounty(),
                caneCensusBus.getFarmerGender(),
                caneCensusBus.getFarmerFullNames(),
                caneCensusBus.getFarmerPhoneNumber(),
                caneCensusBus.getFarmerIDNumber(),
                cropAge,
                cropVariety,
                hectares,
                cropPestsAndDisease,
                cropClass,
                cropDensity,
                cropColour,
                cropVigour,
                expectedTCH,
                false,
                ""
        );

        caneCensusRecordViewModel.addRecord(caneCensus);

      long localID = db.insertMillingCompany(caneCensusBus.getSugarCompanyCounty(), caneCensusBus.getSugarCompany(),
                String.valueOf(mGPS.getLongitude()), String.valueOf(mGPS.getLatitude()));

        long localfarmerID = db.insertFarmerDetails(caneCensusBus.getFarmerCounty(),
                caneCensusBus.getFarmerSubCounty(), String.valueOf(localID),
                caneCensusBus.getFarmerFullNames(), caneCensusBus.getFarmerPhoneNumber(),
                String.valueOf(localID), caneCensusBus.getFarmerIDNumber(), caneCensusBus.getFarmerGender());

        db.inserCropDetails(cropClass, cropVariety,
                hectares, cropAge,
                cropVigour, cropColour,
                cropDensity, cropPestsAndDisease,
                expectedTCH, String.valueOf(localfarmerID));


      Intent intent = new Intent(getActivity(), DashboardActivity.class);
        Objects.requireNonNull(getActivity()).finish();
        startActivity(intent);
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
