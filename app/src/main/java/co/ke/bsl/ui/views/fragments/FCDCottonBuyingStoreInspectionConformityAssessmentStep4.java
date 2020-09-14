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
import co.ke.bsl.data.model.FCDCottonBuyingStoreInspection;
import co.ke.bsl.data.view.FCDCottonBuyingStoreInspectionBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.data.view.View3Marks;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.CottonBuyingStoreViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDCottonBuyingStoreInspectionConformityAssessmentStep4 extends Fragment implements BlockingStep {


    @BindView(R.id.etAR)
    CustomEditText etAR;
    @BindView(R.id.etBR)
    CustomEditText etBR;
    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    private String ar, br, recommendation, reasonForThegiveReccomm;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

  private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();

    private CottonBuyingStoreViewModel cottonBuyingStoreViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdcotton_buying_store_inspection_conformity_assessment_step4, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        cottonBuyingStoreViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CottonBuyingStoreViewModel.class);

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


    private void setReccomendationsView(List<ReccomendationsView> getdummy10marks) {

       //reccomendationsViewList.add("- Required -");
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


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        ar = Objects.requireNonNull(etAR.getText()).toString().trim();
        br = Objects.requireNonNull(etBR.getText()).toString().trim();


        //validation
        boolean valid = validateEditText(etAR, ar) &
                validateEditText(etBR, br);



        reasonForThegiveReccomm = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        FCDCottonBuyingStoreInspectionBus fCDCottonBuyingStoreInspectionBus = FCDCottonBuyingStoreInspectionBus.getInstance();

        FCDCottonBuyingStoreInspection fCDCottonBuyingStoreInspection = new FCDCottonBuyingStoreInspection(
                0,
                fCDCottonBuyingStoreInspectionBus.getDocumentNumber(),
                fCDCottonBuyingStoreInspectionBus.getDocumentDate(),
                fCDCottonBuyingStoreInspectionBus.getNameOfApplicant(),
                fCDCottonBuyingStoreInspectionBus.getCottonExportNumber(),
                fCDCottonBuyingStoreInspectionBus.getLocalID(),
                fCDCottonBuyingStoreInspectionBus.getNameOfOperator(),
                fCDCottonBuyingStoreInspectionBus.getIsSurroundingsofBuyingSanitaryCondition(),
                fCDCottonBuyingStoreInspectionBus.getSurroundingsofBuyingSanitaryConditionRemarks(),
                fCDCottonBuyingStoreInspectionBus.getIsFloorWellsurfaced(),
                fCDCottonBuyingStoreInspectionBus.getFloorWellsurfacedRemarks(),
                fCDCottonBuyingStoreInspectionBus.getIsGradeBoxapproved(),
                fCDCottonBuyingStoreInspectionBus.getGradeBoxapprovedRemarks(),
                fCDCottonBuyingStoreInspectionBus.getIsCertifiedWeighingscale(),
                fCDCottonBuyingStoreInspectionBus.getCertifiedWeighingScaleRemarks(),
                fCDCottonBuyingStoreInspectionBus.getIsCottonBuyercenterQualified(),
                fCDCottonBuyingStoreInspectionBus.getCottonBuyercenterQualifiedRemarks(),
                fCDCottonBuyingStoreInspectionBus.getIsFirePrecauionarymeasure(),
                fCDCottonBuyingStoreInspectionBus.getFirePrecauionarymeasureRemarks(),
                fCDCottonBuyingStoreInspectionBus.getIsProperlyclean(),
                fCDCottonBuyingStoreInspectionBus.getProperlycleanRemarks(),
                fCDCottonBuyingStoreInspectionBus.getIsintact(),
                fCDCottonBuyingStoreInspectionBus.getIntactRemarks(),
                fCDCottonBuyingStoreInspectionBus.getIsfumigated(),
                fCDCottonBuyingStoreInspectionBus.getFumigatedRemarks(),
                ar,
                br,
                recommendation,
                reasonForThegiveReccomm,
                false,
                ""
        );

        if (valid) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("COTTON BUYING INSPECTION!")
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


                            long result = db.UpdateFCDCottonBuyingStoreInspection(fCDCottonBuyingStoreInspection);
                            System.out.println("result is" + result);
                            cottonBuyingStoreViewModel.addRecord(fCDCottonBuyingStoreInspection);

                            sDialog.dismissWithAnimation();
                            Intent intent = new Intent(getActivity(), DashboardActivity.class);
                            startActivity(intent);
                        }
                    })
                    .show();

        }
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
