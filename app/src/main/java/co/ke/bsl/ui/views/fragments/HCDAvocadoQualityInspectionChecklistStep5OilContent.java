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
import co.ke.bsl.data.model.HCDAvocadoQualityInspection;
import co.ke.bsl.data.view.HCDAvocadoQualityInspectionBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.AvocadoQualityInspectionViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDAvocadoQualityInspectionChecklistStep5OilContent extends Fragment implements BlockingStep {

    @BindView(R.id.etSource)
    CustomEditText etSource;
    @BindView(R.id.etDestination)
    CustomEditText etDestination;
    @BindView(R.id.etSampleVariety)
    CustomEditText etSampleVariety;
    @BindView(R.id.etSampleFruitSize)
    CustomEditText etSampleFruitSize;
    @BindView(R.id.etInitialWt)
    CustomEditText etInitialWt;
    @BindView(R.id.etFinalWt)
    CustomEditText etFinalWt;
    @BindView(R.id.etMoistureContentIWFW)
    CustomEditText etMoistureContentIWFW;
    @BindView(R.id.etMoistureContentPercentage)
    CustomEditText etMoistureContentPercentage;
    @BindView(R.id.etOilContent)
    CustomEditText etOilContent;
    @BindView(R.id.etRemarks)
    CustomEditText etRemarks;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    private String source, destination, sampleVariety, sampleFruitSize, initialWT, finalWt, moistureContentIWFW, moistureContentPercetage, oilContent, remarks;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private AvocadoQualityInspectionViewModel avocadoQualityInspectionViewModel;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdavocado_quality_inspection_checklist_step5_oil_content, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        avocadoQualityInspectionViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(AvocadoQualityInspectionViewModel.class);

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

        source = Objects.requireNonNull(etSource.getText()).toString().trim();
        destination = Objects.requireNonNull(etDestination.getText()).toString().trim();
        sampleVariety = Objects.requireNonNull(etSampleVariety.getText()).toString().trim();
        sampleFruitSize = Objects.requireNonNull(etSampleFruitSize.getText()).toString().trim();
        initialWT = Objects.requireNonNull(etInitialWt.getText()).toString().trim();
        finalWt = Objects.requireNonNull(etFinalWt.getText()).toString().trim();
        moistureContentIWFW = Objects.requireNonNull(etMoistureContentIWFW.getText()).toString().trim();
        moistureContentPercetage = Objects.requireNonNull(etMoistureContentPercentage.getText()).toString().trim();
        oilContent = Objects.requireNonNull(etOilContent.getText()).toString().trim();
        remarks = Objects.requireNonNull(etRemarks.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        //validation
        boolean valid = validateEditText(etSource, source) &
                validateEditText(etDestination, destination) &
                validateEditText(etSampleVariety, sampleVariety) &
                validateEditText(etSampleFruitSize, sampleFruitSize) &
                validateEditText(etInitialWt, initialWT) &
                validateEditText(etFinalWt, finalWt) &
                validateEditText(etMoistureContentIWFW, moistureContentIWFW) &
                validateEditText(etMoistureContentPercentage, moistureContentPercetage) &
                validateEditText(etOilContent, oilContent);

        HCDAvocadoQualityInspectionBus hCDAvocadoQualityInspectionBus = HCDAvocadoQualityInspectionBus.getInstance();
        HCDAvocadoQualityInspection hCDAvocadoQualityInspection = new HCDAvocadoQualityInspection(
                0,
                hCDAvocadoQualityInspectionBus.getDocumentNumber(),
                hCDAvocadoQualityInspectionBus.getDocumentDate(),
                hCDAvocadoQualityInspectionBus.getNameOfApplicant(),
                hCDAvocadoQualityInspectionBus.getHorticultureExporterRequest(),
                hCDAvocadoQualityInspectionBus.getFax(),
                hCDAvocadoQualityInspectionBus.getLocationOfProduce(),
                hCDAvocadoQualityInspectionBus.getTelephone(),
                hCDAvocadoQualityInspectionBus.getExportersAgentName(),
                hCDAvocadoQualityInspectionBus.getSizeOfConsignment(),
                hCDAvocadoQualityInspectionBus.getDesignation(),
                hCDAvocadoQualityInspectionBus.getLocalID(),
                hCDAvocadoQualityInspectionBus.getIsFuarteSkinglossyShine(),
                hCDAvocadoQualityInspectionBus.getFuarteSkinglossyShineRemarks(),
                hCDAvocadoQualityInspectionBus.getIsFuartecolorGreeWithYelowFint(),
                hCDAvocadoQualityInspectionBus.getFuarteColorGreeWithYelowFintRemarks(),
                hCDAvocadoQualityInspectionBus.getIsFuarteskinTextureSmooth(),
                hCDAvocadoQualityInspectionBus.getFuarteSkinTextureSmoothRemarks(),
                hCDAvocadoQualityInspectionBus.getIsFuarteFleshcolorCreamyYellow(),
                hCDAvocadoQualityInspectionBus.getFuarteFleshcolorCreamyYellowRemarks(),
                hCDAvocadoQualityInspectionBus.getIsHasscolorGreen(),
                hCDAvocadoQualityInspectionBus.getHassColorGreenRemarks(),
                hCDAvocadoQualityInspectionBus.getIsHassSkintextureRough(),
                hCDAvocadoQualityInspectionBus.getHassSkinTextureRoughRemarks(),
                hCDAvocadoQualityInspectionBus.getIsHassFleshcolorCreamy(),
                hCDAvocadoQualityInspectionBus.getHassFleshColorCreamyRemarks(),
                hCDAvocadoQualityInspectionBus.getIsSkinColorgreenToYellow(),
                hCDAvocadoQualityInspectionBus.getSkinColorGreenToYellowRemarks(),
                hCDAvocadoQualityInspectionBus.getIsSkinsmoothAtBlossom(),
                hCDAvocadoQualityInspectionBus.getSkinSmoothAtBlossomRemarks(),
                hCDAvocadoQualityInspectionBus.getIsFleshcolorCreamy(),
                hCDAvocadoQualityInspectionBus.getFleshColorCreamyRemarks(),
                hCDAvocadoQualityInspectionBus.getIsOilcontent1(),
                hCDAvocadoQualityInspectionBus.getOilContent1Remarks(),
                hCDAvocadoQualityInspectionBus.getIsStalkpressence(),
                hCDAvocadoQualityInspectionBus.getStalkPressenceRemarks(),
                hCDAvocadoQualityInspectionBus.getIsWoundsdamage(),
                hCDAvocadoQualityInspectionBus.getWoundsDamageRemarks(),
                hCDAvocadoQualityInspectionBus.getIsDiscoloration(),
                hCDAvocadoQualityInspectionBus.getDiscolourationRemarks(),
                hCDAvocadoQualityInspectionBus.getFruitSizing(),
                hCDAvocadoQualityInspectionBus.getIsvariety(),
                hCDAvocadoQualityInspectionBus.getVarietyRemarks(),
                hCDAvocadoQualityInspectionBus.getIsHassfleshColorCreamy(),
                hCDAvocadoQualityInspectionBus.getColorRemarks(),
                hCDAvocadoQualityInspectionBus.getIssize(),
                hCDAvocadoQualityInspectionBus.getSizeRemarks(),
                hCDAvocadoQualityInspectionBus.getIsFruitfirm(),
                hCDAvocadoQualityInspectionBus.getFruitFirmRemarks(),
                hCDAvocadoQualityInspectionBus.getIsForeignmatterPresent(),
                hCDAvocadoQualityInspectionBus.getForeignMatterPresentRemarks(),
                hCDAvocadoQualityInspectionBus.getIsMoistureonFruits(),
                hCDAvocadoQualityInspectionBus.getMoistureOnFruitsRemarks(),
                hCDAvocadoQualityInspectionBus.getIsPostharvestTreatment(),
                hCDAvocadoQualityInspectionBus.getPostHarvestTreatmentRemarks(),
                hCDAvocadoQualityInspectionBus.getComments(),
                source,
                destination,
                sampleVariety,
                sampleFruitSize,
                initialWT,
                finalWt,
                moistureContentIWFW,
                moistureContentPercetage,
                oilContent,
                remarks,
                recommendation,
                recommendationRemarks,
                false,
                ""
        );

        if (valid) {

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

                            System.out.println(app + " parent id = " + hCDAvocadoQualityInspectionBus.getAFA_HC_Avocadochecklist_ID());
                            long updateHCDAvocadoQualityInspection = db.UpdateHCDAvocadoQualityInspection(hCDAvocadoQualityInspection);

                            avocadoQualityInspectionViewModel.addRecord(hCDAvocadoQualityInspection);

                            long updateHCDAvocadoQualityInspectionOilContent = db.UpdateHCDAvocadoQualityInspectionOilContent(hCDAvocadoQualityInspectionBus.getAFA_HC_Avocadochecklist_ID(), source,
                                    destination, sampleVariety, sampleFruitSize, initialWT,
                                    finalWt, moistureContentIWFW, moistureContentPercetage, oilContent, remarks);
                            System.out.println(app + " updateHCDAvocadoQualityInspection " + updateHCDAvocadoQualityInspection);
                            System.out.println(app + " updateHCDAvocadoQualityInspectionOilContent " + updateHCDAvocadoQualityInspectionOilContent);

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
            }
            else result =true;
        } else {
            customEditText.setError(null);
            result = true;
        }

        return result;
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
