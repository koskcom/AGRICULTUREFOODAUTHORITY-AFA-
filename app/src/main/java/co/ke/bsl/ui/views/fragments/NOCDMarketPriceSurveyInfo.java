package co.ke.bsl.ui.views.fragments;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
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
import co.ke.bsl.data.model.NOCDMarketPriceSurvey;
import co.ke.bsl.data.view.NOCDMarketPriceSurveyBus;
import co.ke.bsl.pojo.Product;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.NutsAndOilsSurveyViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class NOCDMarketPriceSurveyInfo extends Fragment implements BlockingStep {

    @BindView(R.id.ssNOCDProduct)
    SearchableSpinner ssNOCDProduct;
    @BindView(R.id.etNOCDBrandName)
    CustomEditText etNOCDBrandName;
    @BindView(R.id.etNOCDPrice)
    CustomEditText etNOCDPrice;
    @BindView(R.id.etNOCDQuantity)
    CustomEditText etNOCDQuantity;
    @BindView(R.id.etNOCDMarketOutlet)
    CustomEditText etNOCDMarketOutlet;
    // This button is placed in main activity layout.
    private Button openInputPopupDialogButton = null;
    // This listview is just under above button.

    // Below edittext and button are all exist in the popup dialog view.
    private View popupInputDialogView = null;
    // Contains user name data.

    // Click this button in popup dialog to save user input data in above three edittext.
    private Button saveUserDataButton = null;
    // Click this button to cancel edit user data.
    private Button cancelUserDataButton = null;

    protected List<Product> productList;
    private String productName, productID, brandName, quantity, price, marketOutlet;
    private Product product;

    AFADatabaseAdapter db;
    AFA app;

    private GPSTracker mGPS;

    private NutsAndOilsSurveyViewModel nutsAndOilsSurveyViewModel;

    public NOCDMarketPriceSurveyInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nocdmarket_price_survey_info, container, false);
        ButterKnife.bind(this, view);
        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getActivity()).open();
        mGPS = new GPSTracker(getActivity());



        nutsAndOilsSurveyViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(NutsAndOilsSurveyViewModel.class);


        productList = db.getAllNOCDProduct();

        setListProducts(productList);

        ssNOCDProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                product = (Product) ssNOCDProduct.getSelectedItem();
                productName = product.getName();
                productID = product.getProductID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        openInputPopupDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ssNOCDProduct.setSelection(-1);
                etNOCDBrandName.setText("");
                etNOCDPrice.setText("");
                etNOCDQuantity.setText("");
                etNOCDMarketOutlet.setText("");
                // Create a AlertDialog Builder.
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                // Set title, icon, can not cancel properties.
                alertDialogBuilder.setTitle("Add New");
                alertDialogBuilder.setIcon(R.drawable.ic_launcher_background);
                alertDialogBuilder.setCancelable(false);

                // Init popup dialog view and it's ui controls.
                initPopupViewControls();

                // Set the inflated layout view object to the AlertDialog builder.
                alertDialogBuilder.setView(popupInputDialogView);

                // Create AlertDialog and show.
                final AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                // When user click the save user data button in the popup dialog.
                saveUserDataButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        savedata();
                        alertDialog.cancel();
                    }
                });

                cancelUserDataButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.cancel();
                    }
                });
            }
        });

        return view;
    }

    /* Initialize popup dialog view and ui controls in the popup dialog. */
    private void initPopupViewControls()
    {
        // Get layout inflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        // Inflate the popup dialog from a layout xml file.
        popupInputDialogView = layoutInflater.inflate(R.layout.popup_input_dialog, null);
        if ("- Required -".equals(productName)) {
            TextView errorText = (TextView) ssNOCDProduct.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        } else if(etNOCDBrandName.getText().toString().isEmpty()){
            etNOCDBrandName.setError("Required");
            return;
        } else if(etNOCDQuantity.getText().toString().isEmpty()){
            etNOCDQuantity.setError("Required");
            return;
        } else if(etNOCDPrice.getText().toString().isEmpty()){
            etNOCDPrice.setError("Required");
            return;
        } else if(etNOCDMarketOutlet.getText().toString().isEmpty()){
            etNOCDMarketOutlet.setError("Required");
            return;
        }else {
            brandName = Objects.requireNonNull(etNOCDBrandName.getText()).toString().trim();
            quantity = Objects.requireNonNull(etNOCDQuantity.getText()).toString().trim();
            price = Objects.requireNonNull(etNOCDPrice.getText()).toString().trim();
            marketOutlet = Objects.requireNonNull(etNOCDMarketOutlet.getText()).toString().trim();


        }


    }

    public void savedata(){
        NOCDMarketPriceSurveyBus nocdMarketPriceSurveyBus = NOCDMarketPriceSurveyBus.getInstance();
        long localid = db.insertNOCDMarketLocation(nocdMarketPriceSurveyBus.getCountyID(),nocdMarketPriceSurveyBus.getSubCountyID(),
                nocdMarketPriceSurveyBus.getSubLocation(), String.valueOf( mGPS.getLongitude()), String.valueOf(mGPS.getLatitude()));

        long marketPriceID = db.insertNOCDMarketPrice(String.valueOf(localid), productID, brandName,
                quantity, price, marketOutlet);

        System.out.println("marketLocationID " + localid);
        System.out.println("marketPriceID " + marketPriceID);


    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        if ("- Required -".equals(productName)) {
            TextView errorText = (TextView) ssNOCDProduct.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        } else if(etNOCDBrandName.getText().toString().isEmpty()){
            etNOCDBrandName.setError("Required");
            return;
        } else if(etNOCDQuantity.getText().toString().isEmpty()){
            etNOCDQuantity.setError("Required");
            return;
        } else if(etNOCDPrice.getText().toString().isEmpty()){
            etNOCDPrice.setError("Required");
            return;
        } else if(etNOCDMarketOutlet.getText().toString().isEmpty()){
            etNOCDMarketOutlet.setError("Required");
            return;
        }else{
            brandName = Objects.requireNonNull(etNOCDBrandName.getText()).toString().trim();
            quantity = Objects.requireNonNull(etNOCDQuantity.getText()).toString().trim();
            price = Objects.requireNonNull(etNOCDPrice.getText()).toString().trim();
            marketOutlet = Objects.requireNonNull(etNOCDMarketOutlet.getText()).toString().trim();

            NOCDMarketPriceSurveyBus nocdMarketPriceSurveyBus = NOCDMarketPriceSurveyBus.getInstance();
            NOCDMarketPriceSurvey nocdMarketPriceSurvey = new NOCDMarketPriceSurvey(
                    0,
                    nocdMarketPriceSurveyBus.getCountyID(),
                    nocdMarketPriceSurveyBus.getSubCountyID(),
                    nocdMarketPriceSurveyBus.getSubLocation(),
                    String.valueOf( mGPS.getLongitude()),
                    String.valueOf(mGPS.getLatitude()),
                    productID,
                    brandName,
                    quantity,
                    price,
                    marketOutlet,
                    nocdMarketPriceSurveyBus.getLocalID(),
                    false,
                    "0"

            );

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("TEAPACKER INSPECTION!")
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
                            long marketLocationID = db.insertNOCDMarketLocation(nocdMarketPriceSurveyBus.getCountyID(),nocdMarketPriceSurveyBus.getSubCountyID(),
                                    nocdMarketPriceSurveyBus.getSubLocation(), String.valueOf( mGPS.getLongitude()), String.valueOf(mGPS.getLatitude()));

                            long marketPriceID = db.insertNOCDMarketPrice(String.valueOf(marketLocationID), productID, brandName,
                                    quantity, price, marketOutlet);

                            System.out.println("marketLocationID " + marketLocationID);
                            System.out.println("marketPriceID " + marketPriceID);

                            nutsAndOilsSurveyViewModel.addRecord(nocdMarketPriceSurvey);

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

    private void setListProducts(List<Product> realProducts) {

        ArrayAdapter<Product> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, realProducts);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssNOCDProduct.setAdapter(regionAdapter);

    }

    private List<String> getDummyProducts() {
        List<String> listViewItems = new ArrayList<>();
        listViewItems.add("Bambra Nuts");
        listViewItems.add("Cashew Nut");
        listViewItems.add("Castor Beans");
        listViewItems.add("Coconut");
        listViewItems.add("Coco Peat");
        listViewItems.add("Ground Nuts");
        listViewItems.add("Jojobar");
        listViewItems.add("Linseed");
        listViewItems.add("Macadamia Nut (Integrifolia )");
        listViewItems.add("Macadamia Nut (Tetraphylla)");
        listViewItems.add("Macadamia Oil");
        listViewItems.add("Oil Palm");
        listViewItems.add("Oyster Nuts");
        listViewItems.add("Pistachio Nut");
        listViewItems.add("Rapeseed/Oil Seed");
        listViewItems.add("Raw Coconut");
        listViewItems.add("Saffower");
        listViewItems.add("Sesame");
        listViewItems.add("Sunflower");
        listViewItems.add("Virgin Coconut Oil");
        return listViewItems;
    }
}
