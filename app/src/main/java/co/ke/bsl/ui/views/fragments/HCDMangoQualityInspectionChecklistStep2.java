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
import co.ke.bsl.data.view.HCDMangoQualityInspectionBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDMangoQualityInspectionChecklistStep2 extends Fragment implements BlockingStep {


    @BindView(R.id.isLatexStains)
    CheckBox isLatexStains;
    @BindView(R.id.etLatexStainsRemarks)
    CustomEditText etLatexStainsRemarks;
    @BindView(R.id.isYellow)
    CheckBox isYellow;
    @BindView(R.id.isGreen)
    CheckBox isGreen;
    @BindView(R.id.isFleshYelow)
    CheckBox isFleshYelow;
    @BindView(R.id.isFleshWhitish)
    CheckBox isFleshWhitish;
    @BindView(R.id.isFleshFirmness)
    CheckBox isFleshFirmness;
    @BindView(R.id.etFleshColorRemarks)
    CustomEditText etFleshColorRemarks;
    @BindView(R.id.isWoundsDamage)
    CheckBox isWoundsDamage;
    @BindView(R.id.etWoundsDamageRemarks)
    CustomEditText etWoundsDamageRemarks;
    @BindView(R.id.isDiscolouration)
    CheckBox isDiscolouration;
    @BindView(R.id.etDiscolourationRemarks)
    CustomEditText etDiscolourationRemarks;
    @BindView(R.id.isStalkPressence)
    CheckBox isStalkPressence;
    @BindView(R.id.etStalkPressenceRemarks)
    CustomEditText etStalkPressenceRemarks;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private String isLatexstains, latexStainsRemarks, isyellow, isgreen, isfleshYellow, isfleshWhitesh, isfleshFirmness;
    private String fleshColorRemarks, iswoundDamage, woundDamageRemarks, isdiscoloration, discolorationRemarks, isStalkpressure, stalkPressureRemarks;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdmango_quality_inspection_checklist_step2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        isLatexStains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLatexStains.isChecked()) {
                    isLatexstains = "Y";
                } else {
                    isLatexstains = "N";
                }

            }
        });
        isYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isYellow.isChecked()) {
                    isyellow = "Y";
                } else {
                    isyellow = "N";
                }

            }
        });
        isGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isGreen.isChecked()) {
                    isgreen = "Y";
                } else {
                    isgreen = "N";
                }

            }
        });
        isFleshYelow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFleshYelow.isChecked()) {
                    isfleshYellow = "Y";
                } else {
                    isfleshYellow = "N";
                }

            }
        });
        isFleshWhitish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFleshWhitish.isChecked()) {
                    isfleshWhitesh = "Y";
                } else {
                    isfleshWhitesh = "N";
                }

            }
        });
        isFleshFirmness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFleshFirmness.isChecked()) {
                    isfleshFirmness = "Y";
                } else {
                    isfleshFirmness = "N";
                }

            }
        });
        isWoundsDamage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWoundsDamage.isChecked()) {
                    iswoundDamage = "Y";
                } else {
                    iswoundDamage = "N";
                }

            }
        });
        isDiscolouration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDiscolouration.isChecked()) {
                    isdiscoloration = "Y";
                } else {
                    isdiscoloration = "N";
                }

            }
        });
        isStalkPressence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStalkPressence.isChecked()) {
                    isStalkpressure = "Y";
                } else {
                    isStalkpressure = "N";
                }

            }
        });
        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        latexStainsRemarks = Objects.requireNonNull(etLatexStainsRemarks.getText()).toString().trim();
        fleshColorRemarks = Objects.requireNonNull(etFleshColorRemarks.getText()).toString().trim();
        woundDamageRemarks = Objects.requireNonNull(etWoundsDamageRemarks.getText()).toString().trim();
        discolorationRemarks = Objects.requireNonNull(etDiscolourationRemarks.getText()).toString().trim();
        stalkPressureRemarks = Objects.requireNonNull(etStalkPressenceRemarks.getText()).toString().trim();

        //validation
        boolean valid = validateFields(isLatexStains, etLatexStainsRemarks, latexStainsRemarks) &
                validateFields(isFleshFirmness, etFleshColorRemarks, fleshColorRemarks) &
                validateFields(isWoundsDamage, etWoundsDamageRemarks, woundDamageRemarks) &
                validateFields(isDiscolouration, etDiscolourationRemarks, discolorationRemarks) &
                validateFields(isStalkPressence, etStalkPressenceRemarks, stalkPressureRemarks);


        HCDMangoQualityInspectionBus hCDMangoQualityInspectionBus = HCDMangoQualityInspectionBus.getInstance();
        hCDMangoQualityInspectionBus.setIsLatexstains(isLatexstains);
        hCDMangoQualityInspectionBus.setLatexStainsRemarks(latexStainsRemarks);
        hCDMangoQualityInspectionBus.setIsyellow(isyellow);
        hCDMangoQualityInspectionBus.setIsgreen(isgreen);
        hCDMangoQualityInspectionBus.setIsfleshYellow(isfleshYellow);
        hCDMangoQualityInspectionBus.setIsfleshWhitesh(isfleshWhitesh);
        hCDMangoQualityInspectionBus.setIsfleshFirmness(isfleshFirmness);
        hCDMangoQualityInspectionBus.setFleshColorRemarks(fleshColorRemarks);
        hCDMangoQualityInspectionBus.setIswoundDamage(iswoundDamage);
        hCDMangoQualityInspectionBus.setWoundDamageRemarks(woundDamageRemarks);
        hCDMangoQualityInspectionBus.setIsdiscoloration(isdiscoloration);
        hCDMangoQualityInspectionBus.setDiscolorationRemarks(discolorationRemarks);
        hCDMangoQualityInspectionBus.setIsStalkpressure(isStalkpressure);
        hCDMangoQualityInspectionBus.setStalkPressureRemarks(stalkPressureRemarks);

        if (valid) {
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
