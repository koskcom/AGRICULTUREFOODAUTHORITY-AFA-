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
import co.ke.bsl.data.model.HCDMangoQualityInspection;
import co.ke.bsl.data.view.HCDMangoQualityInspectionBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.MangoQualityInspectionViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDMangoQualityInspectionChecklistStep3 extends Fragment implements BlockingStep {

    @BindView(R.id.etFruitSizing)
    CustomEditText etFruitSizing;
    @BindView(R.id.isVariety)
    CheckBox isVariety;
    @BindView(R.id.etVarietyRemarks)
    CustomEditText etVarietyRemarks;
    @BindView(R.id.isColor)
    CheckBox isColor;
    @BindView(R.id.etColorRemarks)
    CustomEditText etColorRemarks;
    @BindView(R.id.isSize)
    CheckBox isSize;
    @BindView(R.id.etSizeRemarks)
    CustomEditText etSizeRemarks;
    @BindView(R.id.isForeignMatterPresent)
    CheckBox isForeignMatterPresent;
    @BindView(R.id.etForeignMatterPresentRemarks)
    CustomEditText etForeignMatterPresentRemarks;
    @BindView(R.id.isMoistureOnFruits)
    CheckBox isMoistureOnFruits;
    @BindView(R.id.etMoistureOnFruitsRemarks)
    CustomEditText etMoistureOnFruitsRemarks;
    @BindView(R.id.isLostHarvestTreatment)
    CheckBox isLostHarvestTreatment;
    @BindView(R.id.etLostHarvestTreatmentRemarks)
    CustomEditText etLostHarvestTreatmentRemarks;
    @BindView(R.id.etComments)
    CustomEditText etComments;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private MangoQualityInspectionViewModel mangoQualityInspectionViewModel;

    private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();


    private String fruitSizing, isvariety, varietyRemarks, ishassFleshColorCreamy, colorRemarks, issize, sizeRemarks;
    private String isforeignMatterpresen, foreignMatterPresentRemarks, isMoistureonFruits, moistureonFruitsRemarks;
    private String isLostHarvesttreatment, lostHarvesttreatmentRemarks, comments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdmango_quality_inspection_checklist_step3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        mangoQualityInspectionViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MangoQualityInspectionViewModel.class);

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


        isVariety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isVariety.isChecked()) {
                    isvariety = "Y";
                } else {
                    isvariety = "N";
                }

            }
        });
        isColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isColor.isChecked()) {
                    ishassFleshColorCreamy = "Y";
                } else {
                    ishassFleshColorCreamy = "N";
                }

            }
        });
        isSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSize.isChecked()) {
                    issize = "Y";
                } else {
                    issize = "N";
                }

            }
        });
        isForeignMatterPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isForeignMatterPresent.isChecked()) {
                    isforeignMatterpresen = "Y";
                } else {
                    isforeignMatterpresen = "N";
                }

            }
        });
        isMoistureOnFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMoistureOnFruits.isChecked()) {
                    isMoistureonFruits = "Y";
                } else {
                    isMoistureonFruits = "N";
                }

            }
        });
        isLostHarvestTreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLostHarvestTreatment.isChecked()) {
                    isLostHarvesttreatment = "Y";
                } else {
                    isLostHarvesttreatment = "N";
                }

            }
        });
        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        fruitSizing = Objects.requireNonNull(etFruitSizing.getText()).toString().trim();
        varietyRemarks = Objects.requireNonNull(etVarietyRemarks.getText()).toString().trim();
        colorRemarks = Objects.requireNonNull(etColorRemarks.getText()).toString().trim();
        sizeRemarks = Objects.requireNonNull(etSizeRemarks.getText()).toString().trim();
        foreignMatterPresentRemarks = Objects.requireNonNull(etForeignMatterPresentRemarks.getText()).toString().trim();
        moistureonFruitsRemarks = Objects.requireNonNull(etMoistureOnFruitsRemarks.getText()).toString().trim();
        lostHarvesttreatmentRemarks = Objects.requireNonNull(etLostHarvestTreatmentRemarks.getText()).toString().trim();
        comments = Objects.requireNonNull(etComments.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        //validation
        boolean valid = validateEditText(etFruitSizing, fruitSizing) &
                validateFields(isVariety, etVarietyRemarks, varietyRemarks) &
                validateFields(isColor, etColorRemarks, colorRemarks) &
                validateFields(isSize, etSizeRemarks, sizeRemarks) &
                validateFields(isForeignMatterPresent, etForeignMatterPresentRemarks, foreignMatterPresentRemarks) &
                validateFields(isMoistureOnFruits, etMoistureOnFruitsRemarks, moistureonFruitsRemarks) &
                validateFields(isLostHarvestTreatment, etLostHarvestTreatmentRemarks, lostHarvesttreatmentRemarks);


        HCDMangoQualityInspectionBus hCDMangoQualityInspectionBus = HCDMangoQualityInspectionBus.getInstance();

        HCDMangoQualityInspection hCDMangoQualityInspection = new HCDMangoQualityInspection(
                0,
                hCDMangoQualityInspectionBus.getDocumentNumber(),
                hCDMangoQualityInspectionBus.getDosumentdate(),
                hCDMangoQualityInspectionBus.getInspectionRequestNo(),
                hCDMangoQualityInspectionBus.getExportersName(),
                hCDMangoQualityInspectionBus.getExportersAgentName(),
                hCDMangoQualityInspectionBus.getSizeOfConsignment(),
                hCDMangoQualityInspectionBus.getLocalID(),
                hCDMangoQualityInspectionBus.getIsLatexstains(),
                hCDMangoQualityInspectionBus.getLatexStainsRemarks(),
                hCDMangoQualityInspectionBus.getIsyellow(),
                hCDMangoQualityInspectionBus.getIsgreen(),
                hCDMangoQualityInspectionBus.getIsfleshYellow(),
                hCDMangoQualityInspectionBus.getIsfleshWhitesh(),
                hCDMangoQualityInspectionBus.getIsfleshFirmness(),
                hCDMangoQualityInspectionBus.getFleshColorRemarks(),
                hCDMangoQualityInspectionBus.getIswoundDamage(),
                hCDMangoQualityInspectionBus.getWoundDamageRemarks(),
                hCDMangoQualityInspectionBus.getIsdiscoloration(),
                hCDMangoQualityInspectionBus.getDiscolorationRemarks(),
                hCDMangoQualityInspectionBus.getIsStalkpressure(),
                hCDMangoQualityInspectionBus.getStalkPressureRemarks(),
                fruitSizing,
                isvariety,
                varietyRemarks,
                ishassFleshColorCreamy,
                colorRemarks,
                issize,
                sizeRemarks,
                isforeignMatterpresen,
                foreignMatterPresentRemarks,
                isMoistureonFruits,
                moistureonFruitsRemarks,
                isLostHarvesttreatment,
                lostHarvesttreatmentRemarks,
                comments,
                recommendation,
                recommendationRemarks,
                false,
                ""
        );

        if (valid) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("COFFEE GROWER INSPECTION!")
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
                            db.UpdateMangoQualityInspection(hCDMangoQualityInspection);

                            mangoQualityInspectionViewModel.addRecord(hCDMangoQualityInspection);

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
