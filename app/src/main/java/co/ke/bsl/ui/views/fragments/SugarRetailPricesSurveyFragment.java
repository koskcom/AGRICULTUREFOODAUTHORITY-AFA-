package co.ke.bsl.ui.views.fragments;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import org.idempiere.webservice.client.base.LoginRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.CityView;
import co.ke.bsl.data.view.CropClassView;
import co.ke.bsl.data.view.SugarRetailPricesSurveyBus;
import co.ke.bsl.data.view.SurveyTypeView;
import co.ke.bsl.pojo.CaneCensusDataCollection;
import co.ke.bsl.pojo.City;
import co.ke.bsl.pojo.LoginService;
import co.ke.bsl.pojo.SugarPricesSurveyDataCollection;
import co.ke.bsl.pojo.Survey;
import co.ke.bsl.pojo.User;
import co.ke.bsl.task.HttpGetCountyListTask;
import co.ke.bsl.task.HttpGetSurveyListTask;
import co.ke.bsl.task.HttpPostTask;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.ErrorHandler;
import co.ke.bsl.util.GPSTracker;
import co.ke.bsl.util.StringUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class SugarRetailPricesSurveyFragment extends Fragment implements BlockingStep, HttpGetSurveyListTask.HttpJsonGetSurveyListTaskCaller<Survey> {
    @BindView(R.id.sssurvey_type)
    SearchableSpinner sssurvey_type;
    @BindView(R.id.sscity)
    SearchableSpinner sscity;
    @BindView(R.id.ssdocument_no)
    SearchableSpinner ssdocument_no;
    @BindView(R.id.etdocument_date)
    CustomEditText etdocument_date;
    @BindView(R.id.etsurvey_ending)
    CustomEditText etsurvey_ending;

    AFADatabaseAdapter db;
    private GPSTracker mGPS;
    SugarPricesSurveyDataCollection sugarPricesSurveyDataCollection;
    private ArrayList<String> surveyTypeList = new ArrayList<>();
    private ArrayList<String> cityList = new ArrayList<>();
    protected List<City> countiesList;
    protected List<Survey> surveysList;
    protected List<String> subCountiesList;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    LoginService loginService;
    Survey selectedSurvey;
    private String survey_type, city, document_number, document_date, survey_ending;

    AFA app;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sugar_prices_survey, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        asyncSupport = new AsyncActivitySupport(getActivity());
        countiesList = new ArrayList<City>();

        db = new AFADatabaseAdapter(getActivity()).open();

        setListSurveyType(getDummySurveyType());

        getCityListApplicable();


        return view;
    }

    protected void getCityListApplicable() {
        countiesList = db.getCityList();
        populateSpinner();

    }


    /**
     * Adding spinner data
     */
    private void populateSpinner() {


        if (ssdocument_no != null) {
            ssdocument_no.setAdapter(null);

        }
        if (surveysList != null) {
            ssdocument_no.setAdapter(null);
            surveysList = null;
            surveysList = null;

            etdocument_date.setText(null);
            etdocument_date.setText(null);

            etsurvey_ending.setText(null);
            etsurvey_ending.setText(null);
        }



        ArrayAdapter<City> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, countiesList);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);

        sscity.setAdapter(regionAdapter);
    
        
    /*    ArrayAdapter<City> spinnerAdapter = new ArrayAdapter<City>(getContext(),
                android.R.layout.simple_spinner_item, countiesList);*/

        // Drop down layout style - list view with radio button
 /*       spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        */
        // attaching data adapter to spinner
        if (sscity != null) {
            // sscity.setAdapter(regionAdapter);


            sscity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                    // Can also use mySpinner.setOnItemClickListener(......)
                    // Using a separate button here as there's often other data to select
                    // or if you choose the wrong item.
                    City selectedCity;
                    if (!(sscity.getSelectedItem() == null)) {
                        selectedCity = (City) sscity.getSelectedItem();
                        //  appState.setCity(selectedCity);

                        String surveytype = (String) sssurvey_type.getSelectedItem();

                        // appState.setSurveyType(surveytype);
                        //toast(String.format("City Selected: " + selectedCity.getName() + "\t Survey Type " + surveytype + " City ID: " + selectedCity.getC_city_id()));
                        if (surveytype.equalsIgnoreCase("Retail") || surveytype.equalsIgnoreCase("Wholesale")) {
                            getSurveyListApplicable(selectedCity.getC_city_id(), surveytype);
                        }


                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }


    }


    protected void getSurveyListApplicable(String city_id, String surveyType) {

        LoginRequest loginRequest = new LoginRequest();
        User user = db.getLogin();
        loginRequest.setUser(user.getUsername());
        loginRequest.setPass(user.getPassword());
        loginRequest.setClientID(1000000);
        loginRequest.setRoleID(1000000);
        loginRequest.setOrgID(1000000);
        loginRequest.setWarehouseID(1000000);

        surveysList = null;
        loginService = new LoginService();
        loginService.setC_City_ID(city_id);
        // loginService.setLoginRequest(appState.getLoginRequest());

        if (surveyType.equalsIgnoreCase("Retail")) {
            loginService.setTypeOfSugarPricesSurvey("10000062");
        }
        System.out.println("The Survey Type Passed " + loginService.getTypeOfSugarPricesSurvey());

        loginService.setLoginRequest(loginRequest);

	/*	String uri = getString(R.string.baseURI)
				+ "/getSurvey/{city}/{surveyType}";
*/
        String uri = getString(R.string.baseURI);

        if (isOnline()) {
            new HttpGetSurveyListTask(SugarRetailPricesSurveyFragment.this, uri, 0)
                    .execute(loginService);
        } else {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("No internet Connection");
                builder.setMessage("Please turn on internet connection to continue");
                builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            } catch (Exception e) {
            }
        }
    }

    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getActivity().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if (netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()) {
            Toast.makeText(getContext(), "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


    // Toast
    public void toast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    private void setListSurveyType(List<SurveyTypeView> dummySurveyType) {


        sssurvey_type.setEnabled(false);
        sssurvey_type.setClickable(false);
        for (SurveyTypeView regionWrapper : dummySurveyType) {
            surveyTypeList.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, surveyTypeList);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        sssurvey_type.setAdapter(regionAdapter);
    }

    private List<SurveyTypeView> getDummySurveyType() {
        List<SurveyTypeView> listViewItems = new ArrayList<>();
        listViewItems.add(new SurveyTypeView("Retail"));

        return listViewItems;
    }



    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        document_date = Objects.requireNonNull(etdocument_date.getText()).toString().trim();
        if(ssdocument_no.getSelectedItem() != null) {
            document_number = Objects.requireNonNull(ssdocument_no.getSelectedItem()).toString().trim();
        }
        survey_type = Objects.requireNonNull(sssurvey_type.getSelectedItem()).toString().trim();
        if(sscity.getSelectedItem().toString() != null){
            city = Objects.requireNonNull(sscity.getSelectedItem()).toString().trim();
        }
        survey_ending = Objects.requireNonNull(etsurvey_ending.getText()).toString().trim();

        if (TextUtils.isEmpty(document_date)) {
            etdocument_date.setError("Please Select City First");
            Toast.makeText(app, "Please Select City First", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(survey_ending)) {
            etsurvey_ending.setError("Please Select City First");
            Toast.makeText(app, "Please Select City First", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(document_number)) {
            TextView errorText = (TextView) ssdocument_no.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }


        if ("- Required -".equals(city))
        {
            TextView errorText = (TextView) sscity.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }


        //postShopData();
        SugarRetailPricesSurveyBus sugarRetailPricesSurveyBus = SugarRetailPricesSurveyBus.getInstance();

        sugarRetailPricesSurveyBus.setSurveyType(selectedSurvey.getAfa_sd_sugarprices_survey_id());
        sugarRetailPricesSurveyBus.setCity(city);
        sugarRetailPricesSurveyBus.setDocument_Number(document_number);
        sugarRetailPricesSurveyBus.setDocument_date(document_date);
        sugarRetailPricesSurveyBus.setSurvey_Ending(survey_ending);

        callback.goToNextStep();
    }

    protected void postShopData() {

        sugarPricesSurveyDataCollection = new SugarPricesSurveyDataCollection();
        sugarPricesSurveyDataCollection.setSurveyType(survey_type);
        sugarPricesSurveyDataCollection.setCity(city);
        sugarPricesSurveyDataCollection.setDocument_Number(document_number);
        sugarPricesSurveyDataCollection.setDocument_date(document_date);
        sugarPricesSurveyDataCollection.setSurvey_Ending(survey_ending);

        sugarPricesSurveyDataCollection.setLoginRequest(app.getLoginRequest());

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {

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

    @Override
    public void onHttpGetTaskSucceeded(int requestCode, ArrayList<Survey> serverResponse) {

        if (!serverResponse.isEmpty()) {
            System.out
                    .println(" -----------onHttpGetTaskSucceeded--------------"
                            + "----------------------------"
                            + serverResponse.get(0).getDocumentDate());
            surveysList = (ArrayList<Survey>) serverResponse;
            populateSurveySpinner();

            // toast("County list retrieved" + countyList.get(1));

        } else {
            //  clearForm();
            //toast("No Data Retrieved");
        }
    }

    /**
     * Adding spinner data
     */
    private void populateSurveySpinner() {

        ArrayAdapter<Survey> spinnerAdapter = new ArrayAdapter<Survey>(getContext(),
                android.R.layout.simple_spinner_item, surveysList);

        // Drop down layout style - list view with radio button
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        ssdocument_no.setAdapter(spinnerAdapter);


        ssdocument_no.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // Can also use mySpinner.setOnItemClickListener(......)
                // Using a separate button here as there's often other data to select
                // or if you choose the wrong item.
                if (!(ssdocument_no.getSelectedItem() == null)) {
                    selectedSurvey = (Survey) ssdocument_no.getSelectedItem();
                    String surveytype = (String) sssurvey_type.getSelectedItem();

                    selectedSurvey.setTypeOfSurvey(surveytype);
                    //  appState.setSurvey(selectedSurvey);
                    //toast(String.format("City Selected: " + selectedSurvey.getDocumentNo() + "\t Population: " + selectedSurvey.getAfa_sd_sugarprices_survey_id()));

                    etdocument_date.setText(selectedSurvey.getDocumentDate());
                    etsurvey_ending.setText(selectedSurvey.getSurveyEndDate());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void showLoadingProgressDialog() {
        // asyncSupport.showLoadingProgressDialog();

    }

    @Override
    public void dismissProgressDialog() {
        // asyncSupport.dismissProgressDialog();


    }

    @Override
    public void onAsyncTaskFailed(Class<?> taskClass, int requestCode, Throwable throwable) {
        final String msgText = getAsyncTaskFailedMessage(taskClass, throwable);

        Runnable callback = new Runnable() {
            @Override
            public void run() {
                ErrorHandler.logAndAlert(getContext(),
                        SugarRetailPricesSurveyFragment.class, msgText, throwable);
                // TODO
                // PizzasListActivity.this.finish();
            }
        };

        Message message = Message.obtain(this.asyncTaskHandler, callback);
        message.sendToTarget();

    }

    protected String getAsyncTaskFailedMessage(Class<?> taskClass,
                                               Throwable throwable) {
        int msgResID = R.string.error_unspecied;
        if (taskClass == HttpGetCountyListTask.class) {
            msgResID = R.string.pizzasList_error_postingOrderFailed;
        }
        if (taskClass == HttpPostTask.class) {
            msgResID = R.string.pizzasList_error_postingOrderFailed;
        } else {
            ErrorHandler.logAndThrow(getClass(), new IllegalArgumentException(
                    "Unexpected class: " + taskClass.toString()));
        }

        return StringUtils.limitStringLength(
                getString(msgResID, throwable.getMessage()), 200, " ...");
    }


}