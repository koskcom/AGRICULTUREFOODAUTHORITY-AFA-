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
import android.widget.CheckBox;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.HCDAvocadoQualityInspectionBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDAvocadoQualityInspectionChecklistStep3 extends Fragment implements BlockingStep {


    @BindView(R.id.isOilContent1)
    CheckBox isOilContent1;
    @BindView(R.id.etOilContent1Remarks)
    CustomEditText etOilContent1Remarks;

    @BindView(R.id.isStalkPressence)
    CheckBox isStalkPressence;
    @BindView(R.id.etStalkPressenceRemarks)
    CustomEditText etStalkPressenceRemarks;

    @BindView(R.id.isWoundsDamage)
    CheckBox isWoundsDamage;
    @BindView(R.id.etWoundsDamageRemarks)
    CustomEditText etWoundsDamageRemarks;

    @BindView(R.id.isDiscolouration)
    CheckBox isDiscolouration;
    @BindView(R.id.etDiscolourationRemarks)
    CustomEditText etDiscolourationRemarks;

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

    private String isOilcontent1, oilContent1Remarks, isStalkpressence, stalkPressenceRemarks, isWoundsdamage, woundsDamageRemarks;
    private String isDiscoloration, discolourationRemarks, fruitSizing, isvariety, varietyRemarks, isHassfleshColorCreamy, colorRemarks, issize, sizeRemarks;


    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdavocado_quality_inspection_checklist_step3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        isOilContent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOilContent1.isChecked()) {
                    isOilcontent1 = "Y";
                } else {
                    isOilcontent1 = "N";
                }

            }
        });
        isStalkPressence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStalkPressence.isChecked()) {
                    isStalkpressence = "Y";
                } else {
                    isStalkpressence = "N";
                }

            }
        });
        isWoundsDamage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWoundsDamage.isChecked()) {
                    isWoundsdamage = "Y";
                } else {
                    isWoundsdamage = "N";
                }

            }
        });
        isDiscolouration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDiscolouration.isChecked()) {
                    isDiscoloration = "Y";
                } else {
                    isDiscoloration = "N";
                }

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
                    isHassfleshColorCreamy = "Y";
                } else {
                    isHassfleshColorCreamy = "N";
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

        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        oilContent1Remarks = Objects.requireNonNull(etOilContent1Remarks.getText()).toString().trim();
        stalkPressenceRemarks = Objects.requireNonNull(etStalkPressenceRemarks.getText()).toString().trim();
        woundsDamageRemarks = Objects.requireNonNull(etWoundsDamageRemarks.getText()).toString().trim();
        discolourationRemarks = Objects.requireNonNull(etDiscolourationRemarks.getText()).toString().trim();

        fruitSizing = Objects.requireNonNull(etFruitSizing.getText()).toString().trim();

        varietyRemarks = Objects.requireNonNull(etVarietyRemarks.getText()).toString().trim();
        colorRemarks = Objects.requireNonNull(etColorRemarks.getText()).toString().trim();
        sizeRemarks = Objects.requireNonNull(etSizeRemarks.getText()).toString().trim();


        //validation
        boolean valid = validateFields(isOilContent1, etOilContent1Remarks, oilContent1Remarks) &
                validateFields(isStalkPressence, etStalkPressenceRemarks, stalkPressenceRemarks) &
                validateFields(isWoundsDamage, etWoundsDamageRemarks, woundsDamageRemarks) &
                validateFields(isDiscolouration, etDiscolourationRemarks, discolourationRemarks) &
                validateFields(isVariety, etVarietyRemarks, varietyRemarks) &
                validateFields(isColor, etColorRemarks, colorRemarks) &
                validateFields(isSize, etSizeRemarks, sizeRemarks) &
                validateEditText(etFruitSizing, fruitSizing);


        HCDAvocadoQualityInspectionBus hCDAvocadoQualityInspectionBus = HCDAvocadoQualityInspectionBus.getInstance();
        hCDAvocadoQualityInspectionBus.setIsOilcontent1(isOilcontent1);
        hCDAvocadoQualityInspectionBus.setOilContent(oilContent1Remarks);
        hCDAvocadoQualityInspectionBus.setIsStalkpressence(isStalkpressence);
        hCDAvocadoQualityInspectionBus.setStalkPressenceRemarks(stalkPressenceRemarks);
        hCDAvocadoQualityInspectionBus.setIsWoundsdamage(isWoundsdamage);
        hCDAvocadoQualityInspectionBus.setIsDiscoloration(isDiscoloration);
        hCDAvocadoQualityInspectionBus.setDiscolourationRemarks(discolourationRemarks);
        hCDAvocadoQualityInspectionBus.setFruitSizing(fruitSizing);
        hCDAvocadoQualityInspectionBus.setIsvariety(isvariety);
        hCDAvocadoQualityInspectionBus.setVarietyRemarks(varietyRemarks);
        hCDAvocadoQualityInspectionBus.setColorRemarks(colorRemarks);
        hCDAvocadoQualityInspectionBus.setIssize(issize);
        hCDAvocadoQualityInspectionBus.setSizeRemarks(sizeRemarks);


        if (valid ) {
            callback.goToNextStep();
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
