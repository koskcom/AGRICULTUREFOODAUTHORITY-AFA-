package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

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
import co.ke.bsl.data.view.CategoryView;
import co.ke.bsl.data.view.FCDCottonGinneryInspectionBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDCottonGinneryInspectionConformityAssessmentStep4 extends Fragment implements BlockingStep {

    @BindView(R.id.isRoller)
    CheckBox isRoller;
    @BindView(R.id.isSaw)
    CheckBox isSaw;
    @BindView(R.id.ssCategory)
    SearchableSpinner ssCategory;
    @BindView(R.id.etTotalNoOfGinningMachines)
    CustomEditText etTotalNoOfGinningMachines;
    @BindView(R.id.etNoOfWorkingGinningUnits)
    CustomEditText etNoOfWorkingGinningUnits;
    @BindView(R.id.etNoOfCurrentSalesOuput8hrs)
    CustomEditText etNoOfCurrentSalesOuput8hrs;
    @BindView(R.id.etNoOfInstalledBalesOutput8hrs)
    CustomEditText etNoOfInstalledBalesOutput8hrs;
    @BindView(R.id.etNoOfBalesProducedFromBegginingOfSession)
    CustomEditText etNoOfBalesProducedFromBegginingOfSession;
    @BindView(R.id.etNoOfBaselsSoldLocal)
    CustomEditText etNoOfBaselsSoldLocal;
    @BindView(R.id.etNoOfBalesSoldExport)
    CustomEditText etNoOfBalesSoldExport;
    @BindView(R.id.etBalesRemainingInFactory)
    CustomEditText etBalesRemainingInFactory;
    @BindView(R.id.etBalesRemainingInFactoryBRKg)
    CustomEditText etBalesRemainingInFactoryBRKg;

    private String isroller, issaw, category, totalNoOfGinningMachines, noOfWorkingGinningUnits, noOfCurrentSalesOuput8hrs, noOfInstalledBalesOutput8hrs;
    private String noOfBalesProducedFromBegginingOfSession, noOfBaselsSoldLocal, noOfBalesSoldExport, balesRemainingInFactory, alesRemainingInFactoryBRKg;

   AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private ArrayList<CategoryView> categoryViewList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdcotton_ginnery_inspection_conformity_assessment_step4, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        setCategoryView(getCategoryView());

        ssCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CategoryView rec = (CategoryView) ssCategory.getSelectedItem();
                category = rec.getServerID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        isRoller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isRoller.isChecked()){
                   isroller = "Y";
                } else{
                    isroller = "N";
                }
            }
        });

        isSaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isSaw.isChecked()){
                   issaw = "Y";
                } else{
                    issaw = "N";
                }
            }
        });

        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        totalNoOfGinningMachines = Objects.requireNonNull(etTotalNoOfGinningMachines.getText()).toString().trim();
        noOfWorkingGinningUnits = Objects.requireNonNull(etNoOfWorkingGinningUnits.getText()).toString().trim();
        noOfCurrentSalesOuput8hrs = Objects.requireNonNull(etNoOfCurrentSalesOuput8hrs.getText()).toString().trim();
        noOfInstalledBalesOutput8hrs = Objects.requireNonNull(etNoOfInstalledBalesOutput8hrs.getText()).toString().trim();
        noOfBalesProducedFromBegginingOfSession = Objects.requireNonNull(etNoOfBalesProducedFromBegginingOfSession.getText()).toString().trim();
        noOfBaselsSoldLocal = Objects.requireNonNull(etNoOfBaselsSoldLocal.getText()).toString().trim();
        noOfBalesSoldExport = Objects.requireNonNull(etNoOfBalesSoldExport.getText()).toString().trim();
        balesRemainingInFactory = Objects.requireNonNull(etBalesRemainingInFactory.getText()).toString().trim();
        alesRemainingInFactoryBRKg = Objects.requireNonNull(etBalesRemainingInFactoryBRKg.getText()).toString().trim();


        if ("- Required -".equals(category)) {
            TextView errorText = (TextView) ssCategory.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }

        if (TextUtils.isEmpty(totalNoOfGinningMachines)) {
            etTotalNoOfGinningMachines.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(noOfWorkingGinningUnits)) {
            etNoOfWorkingGinningUnits.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(noOfCurrentSalesOuput8hrs)) {
            etNoOfCurrentSalesOuput8hrs.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(noOfInstalledBalesOutput8hrs)) {
            etNoOfInstalledBalesOutput8hrs.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(noOfBalesProducedFromBegginingOfSession)) {
            etNoOfBalesProducedFromBegginingOfSession.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(noOfBaselsSoldLocal)) {
            etNoOfBaselsSoldLocal.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(noOfBalesSoldExport)) {
            etNoOfBalesSoldExport.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(balesRemainingInFactory)) {
            etBalesRemainingInFactory.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(alesRemainingInFactoryBRKg)) {
            etBalesRemainingInFactoryBRKg.setError("Field Required");
            return;
        }

        FCDCottonGinneryInspectionBus fCDCottonGinneryInspectionBus = FCDCottonGinneryInspectionBus.getInstance();

        fCDCottonGinneryInspectionBus.setIsroller(isroller);
        fCDCottonGinneryInspectionBus.setIssaw(issaw);
        fCDCottonGinneryInspectionBus.setCategory(category);
        fCDCottonGinneryInspectionBus.setTotalNoOfGinningMachines(totalNoOfGinningMachines);
        fCDCottonGinneryInspectionBus.setNoOfWorkingGinningUnits(noOfWorkingGinningUnits);
        fCDCottonGinneryInspectionBus.setNoOfCurrentSalesOuput8hrs(noOfCurrentSalesOuput8hrs);
        fCDCottonGinneryInspectionBus.setNoOfInstalledBalesOutput8hrs(noOfInstalledBalesOutput8hrs);
        fCDCottonGinneryInspectionBus.setNoOfBalesProducedFromBegginingOfSession(noOfBalesProducedFromBegginingOfSession);
        fCDCottonGinneryInspectionBus.setNoOfBaselsSoldLocal(noOfBaselsSoldLocal);
        fCDCottonGinneryInspectionBus.setNoOfBalesSoldExport(noOfBalesSoldExport);
        fCDCottonGinneryInspectionBus.setBalesRemainingInFactory(balesRemainingInFactory);
        fCDCottonGinneryInspectionBus.setAlesRemainingInFactoryBRKg(alesRemainingInFactoryBRKg);
        callback.goToNextStep();

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

    private void setCategoryView(List<CategoryView> getdummy10marks) {
        //        reccomendationsViewList.add("- Required -");
        for (CategoryView regionWrapper : getdummy10marks) {
            categoryViewList.add(regionWrapper);
        }

        ArrayAdapter<CategoryView> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, categoryViewList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssCategory.setAdapter(regionAdapter);

    }

    private List<CategoryView> getCategoryView() {
        List<CategoryView> listViewItems = new ArrayList<>();
        listViewItems.add(new CategoryView("Single", "10000236"));
        listViewItems.add(new CategoryView("Double", "10000237"));

        return listViewItems;
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
