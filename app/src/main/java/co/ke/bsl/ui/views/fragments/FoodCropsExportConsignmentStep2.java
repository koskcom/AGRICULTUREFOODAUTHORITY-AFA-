package co.ke.bsl.ui.views.fragments;

import android.content.Intent;
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
import cn.pedant.SweetAlert.SweetAlertDialog;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.FoodCrop;
import co.ke.bsl.data.model.FoodProcessing;
import co.ke.bsl.data.view.FoodCropBus;
import co.ke.bsl.data.view.FoodProcessingBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.pojo.Country;
import co.ke.bsl.pojo.WholeSaleImportedSugar;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.FoodCropViewModel;
import co.ke.bsl.ui.viewmodels.FoodProcessingViewModel;
import co.ke.bsl.util.CustomEditText;

public class FoodCropsExportConsignmentStep2 extends Fragment implements BlockingStep {
    @BindView(R.id.etpackaging_and_labelling)
    CustomEditText etpackaging_and_labelling;
    @BindView(R.id.etconformityToRelevantStandards)
    CustomEditText etconformityToRelevantStandards;
    @BindView(R.id.etsourceOfProduce)
    CustomEditText etsourceOfProduce;
    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    protected Handler asyncTaskHandler;
    private AsyncActivitySupport asyncSupport;
    AFADatabaseAdapter db;

    private String packagingAndLabelling, conformityStandards, sourceOfProduce, recommendation, reasonForRecomendations;

    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();

    private FoodCropViewModel foodCropViewModel;

    AFA app;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_crops_step2_activity, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        foodCropViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(FoodCropViewModel.class);

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

        packagingAndLabelling = Objects.requireNonNull(etpackaging_and_labelling.getText()).toString().trim();
        conformityStandards = Objects.requireNonNull(etconformityToRelevantStandards.getText()).toString().trim();
        sourceOfProduce = Objects.requireNonNull(etsourceOfProduce.getText()).toString().trim();
        reasonForRecomendations = Objects.requireNonNull(etReasonForThegiveReccomm.getText().toString());

        if ("- Required -".equals(recommendation)) {
            TextView errorText = (TextView) ssReccomendation.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }

        boolean valid = validateEditText(etpackaging_and_labelling, packagingAndLabelling) &
                validateEditText(etconformityToRelevantStandards, conformityStandards) &
                validateEditText(etsourceOfProduce, sourceOfProduce )&
                validateEditText(etReasonForThegiveReccomm, reasonForRecomendations);
        FoodCropBus foodCropBus = FoodCropBus.getInstance();
        FoodCrop foodcrop = new FoodCrop(
                0,
                foodCropBus.getDocumentNumber(),
                foodCropBus.getDocumentDate(),
                foodCropBus.getNameOfApplicant(),
                foodCropBus.getFoodCroplicence(),
                foodCropBus.getLocalID(),
                packagingAndLabelling,
                conformityStandards,
                sourceOfProduce,
                recommendation,
                reasonForRecomendations,
                false,
                ""
        );

        if (valid) {
            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("Food Crop Export Inspection!")
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

                            db.UpdatefoodCropInpection(foodcrop);
                            foodCropViewModel.addRecord(foodcrop);


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
            } else result = true;
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
        listViewItems.add(new ReccomendationsView("-Select-", " "));
        listViewItems.add(new ReccomendationsView("I Recommend", "10000245"));
        listViewItems.add(new ReccomendationsView("I Do Not Recommend", "10000246"));

        return listViewItems;
    }
}
