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
import co.ke.bsl.data.model.CoffeeManagementAgent;
import co.ke.bsl.data.view.CoffeeMnagementAgentBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.CoffeeManagementAgentViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeManagementAgentStep12 extends Fragment implements BlockingStep {

    @BindView(R.id.etmanagementPerformanceProf)
    CustomEditText etmanagementPerformanceProf;
    @BindView(R.id.etFinancialPosition)
    CustomEditText etFinancialPosition;
    @BindView(R.id.etrelevantEquipments)
    CustomEditText etrelevantEquipments;
    @BindView(R.id.etServices)
    CustomEditText etServices;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;


    private String managementPerformanceProf, financialPosition, relevantEquipments, services, status;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();

    private String localID;

    private CoffeeManagementAgentViewModel coffeeManagementAgentViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_management_agent_step12, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();

        coffeeManagementAgentViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CoffeeManagementAgentViewModel.class);

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

        return view;
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        managementPerformanceProf = Objects.requireNonNull(etmanagementPerformanceProf.getText()).toString().trim();
        financialPosition = Objects.requireNonNull(etFinancialPosition.getText()).toString().trim();
        relevantEquipments = Objects.requireNonNull(etrelevantEquipments.getText()).toString().trim();
        services = Objects.requireNonNull(etServices.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateEditText(etmanagementPerformanceProf, managementPerformanceProf) &
                validateEditText(etFinancialPosition, financialPosition) &
                validateEditText(etrelevantEquipments, relevantEquipments);

        CoffeeMnagementAgentBus coffeeMnagementAgentBus = CoffeeMnagementAgentBus.getInstance();

        CoffeeManagementAgent coffeeManagementAgent = new CoffeeManagementAgent(
                0,
                coffeeMnagementAgentBus.getDocumnet_number(),
                coffeeMnagementAgentBus.getDocument_date(),
                coffeeMnagementAgentBus.getName_of_applicant(),
                coffeeMnagementAgentBus.getLicence_no(),
                coffeeMnagementAgentBus.getPrincipal_office(),
                managementPerformanceProf,
                financialPosition,
                relevantEquipments,
                services,
                recommendation,
                recommendationRemarks,
                status,
                coffeeMnagementAgentBus.getLocalID(),
                false,
                ""

        );

        if(valid) {


            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("COFEE MANAGEMENT INSPECTION!")
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

                            long updateCoffeeManagementAgentID = db.updateCoffeeManagementAgent(coffeeManagementAgent);
                            System.out.println("updateCoffeeManagementAgentID " + updateCoffeeManagementAgentID);
                            coffeeManagementAgentViewModel.addRecord(coffeeManagementAgent);

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
