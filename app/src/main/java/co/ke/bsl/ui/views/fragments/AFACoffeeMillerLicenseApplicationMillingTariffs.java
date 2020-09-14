package co.ke.bsl.ui.views.fragments;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
import cn.pedant.SweetAlert.SweetAlertDialog;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.CoffeeMillerLicenceApplication;
import co.ke.bsl.data.view.CoffeeMillerLicenceApplicationBus;
import co.ke.bsl.data.view.CurrencyView;
import co.ke.bsl.data.view.TypeOfServiceView;
import co.ke.bsl.pojo.City;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.CoffeeMillerViewModel;
import co.ke.bsl.ui.viewmodels.NutsAndOilsSurveyViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

public class AFACoffeeMillerLicenseApplicationMillingTariffs extends Fragment implements BlockingStep {

    @BindView(R.id.ssTypeOfService)
    SearchableSpinner ssTypeOfService;
    @BindView(R.id.ssCurrency)
    SearchableSpinner ssCurrency;
    @BindView(R.id.etJustification)
    CustomEditText etJustification;
    // This button is placed in main activity layout.
    private Button openInputPopupDialogButton;
    // This listview is just under above button.

    // Below edittext and button are all exist in the popup dialog view.
    private View popupInputDialogView = null;
    // Contains user name data.

    // Click this button in popup dialog to save user input data in above three edittext.
    private Button saveUserDataButton;
    // Click this button to cancel edit user data.
    private Button cancelUserDataButton;

    TypeOfServiceView typeOfServiceView;
    CurrencyView currencyView;
    AFADatabaseAdapter db;
    AFA app;
    private CoffeeMillerViewModel coffeeMillerViewModel;


    private GPSTracker mGPS;
    private String ssTypeOfservice,ssCurency,justification;

    private NutsAndOilsSurveyViewModel nutsAndOilsSurveyViewModel;

    private ArrayList<String> typesofServiceList = new ArrayList<>();
    private ArrayList<String> currencyList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tariffs_activity, container, false);
        ButterKnife.bind(this, view);
        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getActivity()).open();
        mGPS = new GPSTracker(getActivity());
        setListtypeofservice(getdummytypeofservice());
        setListCurrencyView(getdummyCurrencyView());

       // initMainActivityControls();

        coffeeMillerViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CoffeeMillerViewModel.class);


        openInputPopupDialogButton=(Button) view.findViewById(R.id.button_popup_overlay_input_dialog);

        openInputPopupDialogButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                // Create a AlertDialog Builder.
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                // Set title, icon, can not cancel properties.
                alertDialogBuilder.setTitle("Add New Milling Tariffs");
                alertDialogBuilder.setIcon(R.drawable.ic_add_new_24dp);
                alertDialogBuilder.setView(view);
                alertDialogBuilder.setCancelable(false);

                setListtypeofservice(getdummytypeofservice());
                setListCurrencyView(getdummyCurrencyView());


                // Init popup dialog view and it's ui controls.
                initPopupViewControls();
                // Set the inflated layout view object to the AlertDialog builder.
                alertDialogBuilder.setView(popupInputDialogView);

                // Create AlertDialog and show.
                final AlertDialog alertDialog = alertDialogBuilder.create();

                ssTypeOfService= (SearchableSpinner)  popupInputDialogView.findViewById(R.id.ssTypeOfService);
                ssCurrency =(SearchableSpinner) popupInputDialogView.findViewById(R.id.ssCurrency);


                alertDialog.show();


                ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                        R.layout.spinner_item_rg, typesofServiceList);

                regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);

                ssTypeOfService.setAdapter(regionAdapter);


    /*    ArrayAdapter<City> spinnerAdapter = new ArrayAdapter<City>(getContext(),
                android.R.layout.simple_spinner_item, countiesList);*/

                // Drop down layout style - list view with radio button
 /*       spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        */
                // attaching data adapter to spinner
                if(ssTypeOfService!=null) {
                    // sscity.setAdapter(regionAdapter);


                    ssTypeOfService.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> arg0, View arg1,
                                                   int arg2, long arg3) {
                            // Can also use mySpinner.setOnItemClickListener(......)
                            // Using a separate button here as there's often other data to select
                            // or if you choose the wrong item.
                            City selectedCity;
                            if (!(ssTypeOfService.getSelectedItem() == null)) {
                                typeOfServiceView = (TypeOfServiceView) ssTypeOfService.getSelectedItem();
                                //  appState.setCity(selectedCity);


                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                ArrayAdapter<String> Adapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                        R.layout.spinner_item_rg, currencyList);

                Adapter.setDropDownViewResource(R.layout.spinner_item_rg2);

                ssCurrency.setAdapter(Adapter);


    /*    ArrayAdapter<City> spinnerAdapter = new ArrayAdapter<City>(getContext(),
                android.R.layout.simple_spinner_item, countiesList);*/

                // Drop down layout style - list view with radio button
 /*       spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        */
                // attaching data adapter to spinner
                if(ssCurrency!=null) {
                    // sscity.setAdapter(regionAdapter);


                    ssCurrency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> arg0, View arg1,
                                                   int arg2, long arg3) {
                            // Can also use mySpinner.setOnItemClickListener(......)
                            // Using a separate button here as there's often other data to select
                            // or if you choose the wrong item.
                            City selectedCity;
                            if (!(ssCurrency.getSelectedItem() == null)) {
                                currencyView = (CurrencyView) ssCurrency.getSelectedItem();
                                //  appState.setCity(selectedCity);


                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

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
        popupInputDialogView = layoutInflater.inflate(R.layout.fragment_tariffs, null);

        setListtypeofservice(getdummytypeofservice());
        setListCurrencyView(getdummyCurrencyView());

      etJustification = (CustomEditText) popupInputDialogView.findViewById(R.id.etJustification);

        saveUserDataButton=(Button) popupInputDialogView.findViewById(R.id.button_save_user_data);
        cancelUserDataButton=(Button) popupInputDialogView.findViewById(R.id.button_cancel_user_data);

    }

    public void savedata()
    {
        CoffeeMillerLicenceApplicationBus coffeeMillerLicenceApplicationBus = CoffeeMillerLicenceApplicationBus.getInstance();

        if ("- Required -".equals(ssTypeOfservice)) {
            TextView errorText = (TextView) ssTypeOfService.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return ;
        }
        if ("- Required -".equals(ssTypeOfservice)) {
            TextView errorText = (TextView) ssTypeOfService.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return ;
        }
        if(etJustification.getText().toString().isEmpty()) {
            etJustification.setError("Required");
            return;
        }
        else


            justification = Objects.requireNonNull(etJustification.getText()).toString().trim();
       // db.insertMillingtariffs(,,);

    }

    private void setListtypeofservice(List<TypeOfServiceView> getdummytypeofservice) {
        typesofServiceList.add("- Required -");
        for (TypeOfServiceView regionWrapper : getdummytypeofservice) {
            typesofServiceList.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, typesofServiceList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssTypeOfService.setAdapter(regionAdapter);

    }

    private List<TypeOfServiceView> getdummytypeofservice() {
        List<TypeOfServiceView> listViewItems = new ArrayList<>();
        listViewItems.add(new TypeOfServiceView("A"));
        listViewItems.add(new TypeOfServiceView("B"));
        listViewItems.add(new TypeOfServiceView("C"));
        listViewItems.add(new TypeOfServiceView("D"));
        listViewItems.add(new TypeOfServiceView("E"));

        return listViewItems;
    }
 private void setListCurrencyView(List<CurrencyView> getdummyCurrencyView) {
     currencyList.add("- Required -");
        for (CurrencyView regionWrapper : getdummyCurrencyView) {
            currencyList.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, currencyList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssCurrency.setAdapter(regionAdapter);

    }

    private List<CurrencyView> getdummyCurrencyView() {
        List<CurrencyView> listViewItems = new ArrayList<>();
        listViewItems.add(new CurrencyView("ksh"));
        listViewItems.add(new CurrencyView("$usd"));
        listViewItems.add(new CurrencyView("dollar"));

        return listViewItems;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        justification = Objects.requireNonNull(etJustification.getText()).toString().trim();

        if ("- Required -".equals(ssTypeOfservice)) {
            TextView errorText = (TextView) ssTypeOfService.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }
        if ("- Required -".equals(ssTypeOfservice)) {
            TextView errorText = (TextView) ssTypeOfService.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }
        if(etJustification.getText().toString().isEmpty()) {
            etJustification.setError("Required");
            return;
        }
        if(etJustification.getText().toString().isEmpty()){
            etJustification.setError("Required");
            return;
        }

        CoffeeMillerLicenceApplicationBus coffeeMillerLicenceApplicationBus = CoffeeMillerLicenceApplicationBus.getInstance();
        CoffeeMillerLicenceApplication coffeeMillerLicenceApplication = new CoffeeMillerLicenceApplication(
                0,
                coffeeMillerLicenceApplicationBus.getDocumentNumber(),
                coffeeMillerLicenceApplicationBus.getDocumentDate(),
                coffeeMillerLicenceApplicationBus.getApplicantName(),
                coffeeMillerLicenceApplicationBus.getLicenceNumber(),
                coffeeMillerLicenceApplicationBus.getLocalID(),
                coffeeMillerLicenceApplicationBus.getOfficeCondition(),
                coffeeMillerLicenceApplicationBus.getNemaCertification(),
                coffeeMillerLicenceApplicationBus.getNemaCertificationFindings(),
                coffeeMillerLicenceApplicationBus.getOccupationalSafety(),
                coffeeMillerLicenceApplicationBus.getOccupationalSafetyFindings(),
                coffeeMillerLicenceApplicationBus.getMillingMachinery(),
                coffeeMillerLicenceApplicationBus.getMillingMachineryFindings(),
                coffeeMillerLicenceApplicationBus.getWasteTeas(),
                coffeeMillerLicenceApplicationBus.getWasteTeasFindings(),
                coffeeMillerLicenceApplicationBus.getLiqouringCupping(),
                coffeeMillerLicenceApplicationBus.getLiqouringCuppingFindings(),
                coffeeMillerLicenceApplicationBus.getEngagementQualified(),
                coffeeMillerLicenceApplicationBus.getEngagementQualifiedFindings(),
                coffeeMillerLicenceApplicationBus.getProtectiveClothing(),
                coffeeMillerLicenceApplicationBus.getProtectiveClothingFindings(),
                coffeeMillerLicenceApplicationBus.getWeighingScale(),
                coffeeMillerLicenceApplicationBus.getWeighingScaleFindings(),
                coffeeMillerLicenceApplicationBus.getValidInsurance(),
                coffeeMillerLicenceApplicationBus.getValidInsuranceFindings(),
                coffeeMillerLicenceApplicationBus.getGeneralSecurity(),
                coffeeMillerLicenceApplicationBus.getGeneralSecurityFindings(),
                coffeeMillerLicenceApplicationBus.getGrowersContracted(),
                coffeeMillerLicenceApplicationBus.getGrowersContractedFindings(),
                coffeeMillerLicenceApplicationBus.getMillingReturns(),
                coffeeMillerLicenceApplicationBus.getMillingReturnsFindings(),
                coffeeMillerLicenceApplicationBus.getWalls(),
                coffeeMillerLicenceApplicationBus.getWallsFindings(),
                coffeeMillerLicenceApplicationBus.getFloors(),
                coffeeMillerLicenceApplicationBus.getFloorsFindings(),
                coffeeMillerLicenceApplicationBus.getRoof(),
                coffeeMillerLicenceApplicationBus.getRoofFindings(),
                coffeeMillerLicenceApplicationBus.getVentilation(),
                coffeeMillerLicenceApplicationBus.getVentilationFindings(),
                coffeeMillerLicenceApplicationBus.getWashroom(),
                coffeeMillerLicenceApplicationBus.getWashroomFindings(),
                coffeeMillerLicenceApplicationBus.getCoffeePackaging(),
                coffeeMillerLicenceApplicationBus.getCoffeePackagingFindings(),
                coffeeMillerLicenceApplicationBus.getGeneralHygiene(),
                coffeeMillerLicenceApplicationBus.getGeneralHygieneFindings(),
                coffeeMillerLicenceApplicationBus.getFirefighting(),
                coffeeMillerLicenceApplicationBus.getFirefightingFindings(),
                coffeeMillerLicenceApplicationBus.getOfficerrecommendation(),
                coffeeMillerLicenceApplicationBus.getOfficerrecommendation_remark(),
                ssTypeOfservice,
                ssCurency,
                justification,
                false,
                "0");




        new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Coffee  INSPECTION!")
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

                        db.updateCoffeeMillerLicenseApplication(coffeeMillerLicenceApplication);

                        sDialog.dismissWithAnimation();
                        Intent intent = new Intent(getActivity(), DashboardActivity.class);
                        startActivity(intent);
                    }
                })
                .show();


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
