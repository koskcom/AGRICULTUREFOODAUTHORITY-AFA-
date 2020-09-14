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
public class HCDAvocadoQualityInspectionChecklistStep2 extends Fragment implements BlockingStep {

    @BindView(R.id.isFuarteSkinGlossyShine)
    CheckBox isFuarteSkinGlossyShine;
    @BindView(R.id.etFuarteSkinGlossyShineRemarks)
    CustomEditText etFuarteSkinGlossyShineRemarks;

    @BindView(R.id.isFuarteColorGreeWithYelowFint)
    CheckBox isFuarteColorGreeWithYelowFint;
    @BindView(R.id.etFuarteColorGreeWithYelowFintRemarks)
    CustomEditText etFuarteColorGreeWithYelowFintRemarks;

    @BindView(R.id.isFuarteSkinTextureSmooth)
    CheckBox isFuarteSkinTextureSmooth;
    @BindView(R.id.etFuarteSkinTextureSmoothRemarks)
    CustomEditText etFuarteSkinTextureSmoothRemarks;

    @BindView(R.id.isFuarteFleshColorCreamyYellow)
    CheckBox isFuarteFleshColorCreamyYellow;
    @BindView(R.id.etFuarteFleshColorCreamyYellowRemarks)
    CustomEditText etFuarteFleshColorCreamyYellowRemarks;

    @BindView(R.id.isHassColorGreen)
    CheckBox isHassColorGreen;
    @BindView(R.id.etHassColorGreenRemarks)
    CustomEditText etHassColorGreenRemarks;

    @BindView(R.id.isHassSkinTextureRough)
    CheckBox isHassSkinTextureRough;
    @BindView(R.id.etHassSkinTextureRoughRemarks)
    CustomEditText etHassSkinTextureRoughRemarks;

    @BindView(R.id.isHassFleshColorCreamy)
    CheckBox isHassFleshColorCreamy;
    @BindView(R.id.etHassFleshColorCreamyRemarks)
    CustomEditText etHassFleshColorCreamyRemarks;

    @BindView(R.id.isSkinColorGreenToYellow)
    CheckBox isSkinColorGreenToYellow;
    @BindView(R.id.etSkinColorGreenToYellowRemarks)
    CustomEditText etSkinColorGreenToYellowRemarks;

    @BindView(R.id.isSkinSmoothAtBlossom)
    CheckBox isSkinSmoothAtBlossom;
    @BindView(R.id.etSkinSmoothAtBlossomRemarks)
    CustomEditText etSkinSmoothAtBlossomRemarks;

    @BindView(R.id.isFleshColorCreamy)
    CheckBox isFleshColorCreamy;
    @BindView(R.id.etFleshColorCreamyRemarks)
    CustomEditText etFleshColorCreamyRemarks;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private String isFuarteSkinglossyShine, fuarteSkinglossyShineRemarks, isFuartecolorGreeWithYelowFint, fuarteColorGreeWithYelowFintRemarks;
    private String isFuarteskinTextureSmooth, fuarteSkinTextureSmoothRemarks, isFuarteFleshcolorCreamyYellow, fuarteFleshcolorCreamyYellowRemarks;
    private String isHasscolorGreen, hassColorGreenRemarks, isHassSkintextureRough, hassSkinTextureRoughRemarks, isHassFleshcolorCreamy, hassFleshColorCreamyRemarks;
    private String isSkinColorgreenToYellow, skinColorGreenToYellowRemarks, isSkinsmoothAtBlossom, skinSmoothAtBlossomRemarks, isFleshcolorCreamy, fleshColorCreamyRemarks;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdavocado_quality_inspection_checklist_step2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        isFuarteSkinGlossyShine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFuarteSkinGlossyShine.isChecked()) {
                    isFuarteSkinglossyShine = "Y";
                    //etFuarteSkinGlossyShineRemarks.setVisibility(View.GONE);

                } else {
                    //etFuarteSkinGlossyShineRemarks.setVisibility(View.VISIBLE);
                    if (TextUtils.isEmpty(fuarteSkinglossyShineRemarks)) {
                        etFuarteSkinGlossyShineRemarks.setError("Field Required");
                        return;
                    }
                    isFuarteSkinglossyShine = "N";
                }

            }
        });
        isFuarteColorGreeWithYelowFint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFuarteColorGreeWithYelowFint.isChecked()) {
                    isFuartecolorGreeWithYelowFint = "Y";
                } else {
                    isFuartecolorGreeWithYelowFint = "N";
                }

            }
        });
        isFuarteSkinTextureSmooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFuarteSkinTextureSmooth.isChecked()) {
                    isFuarteskinTextureSmooth = "Y";
                } else {
                    isFuarteskinTextureSmooth = "N";
                }

            }
        });
        isFuarteFleshColorCreamyYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFuarteFleshColorCreamyYellow.isChecked()) {
                    isFuarteFleshcolorCreamyYellow = "Y";
                } else {
                    isFuarteFleshcolorCreamyYellow = "N";
                }

            }
        });
        isHassColorGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHassColorGreen.isChecked()) {
                    isHasscolorGreen = "Y";
                } else {
                    isHasscolorGreen = "N";
                }

            }
        });
        isHassSkinTextureRough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHassSkinTextureRough.isChecked()) {
                    isHassSkintextureRough = "Y";
                } else {
                    isHassSkintextureRough = "N";
                }

            }
        });
        isHassFleshColorCreamy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHassFleshColorCreamy.isChecked()) {
                    isHassFleshcolorCreamy = "Y";
                } else {
                    isHassFleshcolorCreamy = "N";
                }

            }
        });
        isSkinColorGreenToYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSkinColorGreenToYellow.isChecked()) {
                    isSkinColorgreenToYellow = "Y";
                } else {
                    isSkinColorgreenToYellow = "N";
                }

            }
        });
        isSkinSmoothAtBlossom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSkinSmoothAtBlossom.isChecked()) {
                    isSkinsmoothAtBlossom = "Y";
                } else {
                    isSkinsmoothAtBlossom = "N";
                }

            }
        });
        isFleshColorCreamy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFleshColorCreamy.isChecked()) {
                    isFleshcolorCreamy = "Y";
                } else {
                    isFleshcolorCreamy = "N";
                }

            }
        });

        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        //getting user inputs
        fuarteSkinglossyShineRemarks = Objects.requireNonNull(etFuarteSkinGlossyShineRemarks.getText()).toString().trim();
        fuarteColorGreeWithYelowFintRemarks = Objects.requireNonNull(etFuarteColorGreeWithYelowFintRemarks.getText()).toString().trim();
        fuarteSkinTextureSmoothRemarks = Objects.requireNonNull(etFuarteSkinTextureSmoothRemarks.getText()).toString().trim();
        fuarteFleshcolorCreamyYellowRemarks = Objects.requireNonNull(etFuarteFleshColorCreamyYellowRemarks.getText()).toString().trim();
        hassColorGreenRemarks = Objects.requireNonNull(etHassColorGreenRemarks.getText()).toString().trim();
        hassSkinTextureRoughRemarks = Objects.requireNonNull(etHassSkinTextureRoughRemarks.getText()).toString().trim();
        hassFleshColorCreamyRemarks = Objects.requireNonNull(etHassFleshColorCreamyRemarks.getText()).toString().trim();
        skinColorGreenToYellowRemarks = Objects.requireNonNull(etSkinColorGreenToYellowRemarks.getText()).toString().trim();
        skinSmoothAtBlossomRemarks = Objects.requireNonNull(etSkinSmoothAtBlossomRemarks.getText()).toString().trim();
        fleshColorCreamyRemarks = Objects.requireNonNull(etFleshColorCreamyRemarks.getText()).toString().trim();


        //validation
        boolean valid = validateFields(isFuarteSkinGlossyShine, etFuarteSkinGlossyShineRemarks, fuarteSkinglossyShineRemarks) &
                validateFields(isFuarteColorGreeWithYelowFint, etFuarteColorGreeWithYelowFintRemarks, fuarteColorGreeWithYelowFintRemarks) &
                validateFields(isFuarteSkinTextureSmooth, etFuarteSkinTextureSmoothRemarks, fuarteSkinTextureSmoothRemarks) &
                validateFields(isFuarteFleshColorCreamyYellow, etFuarteFleshColorCreamyYellowRemarks, fuarteFleshcolorCreamyYellowRemarks) &
                validateFields(isHassColorGreen, etHassColorGreenRemarks, hassColorGreenRemarks) &
                validateFields(isHassSkinTextureRough, etHassSkinTextureRoughRemarks, hassSkinTextureRoughRemarks) &
                validateFields(isHassFleshColorCreamy, etHassFleshColorCreamyRemarks, hassFleshColorCreamyRemarks) &
                validateFields(isSkinColorGreenToYellow, etSkinColorGreenToYellowRemarks, skinColorGreenToYellowRemarks) &
                validateFields(isSkinSmoothAtBlossom, etSkinSmoothAtBlossomRemarks, skinSmoothAtBlossomRemarks) &
                validateFields(isFleshColorCreamy, etFleshColorCreamyRemarks, fleshColorCreamyRemarks);


        //saving inputs in the bus
        HCDAvocadoQualityInspectionBus hCDAvocadoQualityInspectionBus = HCDAvocadoQualityInspectionBus.getInstance();
        hCDAvocadoQualityInspectionBus.setIsFuarteSkinglossyShine(isFuarteSkinglossyShine);
        hCDAvocadoQualityInspectionBus.setFuarteSkinglossyShineRemarks(fuarteSkinglossyShineRemarks);
        hCDAvocadoQualityInspectionBus.setIsFuartecolorGreeWithYelowFint(isFuartecolorGreeWithYelowFint);
        hCDAvocadoQualityInspectionBus.setFuarteColorGreeWithYelowFintRemarks(fuarteColorGreeWithYelowFintRemarks);
        hCDAvocadoQualityInspectionBus.setIsFuarteskinTextureSmooth(isFuarteskinTextureSmooth);
        hCDAvocadoQualityInspectionBus.setFuarteSkinTextureSmoothRemarks(fuarteSkinTextureSmoothRemarks);
        hCDAvocadoQualityInspectionBus.setIsFuarteFleshcolorCreamyYellow(isFuarteFleshcolorCreamyYellow);
        hCDAvocadoQualityInspectionBus.setFuarteFleshcolorCreamyYellowRemarks(fuarteFleshcolorCreamyYellowRemarks);
        hCDAvocadoQualityInspectionBus.setIsHasscolorGreen(isHasscolorGreen);
        hCDAvocadoQualityInspectionBus.setHassColorGreenRemarks(hassColorGreenRemarks);
        hCDAvocadoQualityInspectionBus.setIsHassSkintextureRough(isHassSkintextureRough);
        hCDAvocadoQualityInspectionBus.setHassSkinTextureRoughRemarks(hassSkinTextureRoughRemarks);
        hCDAvocadoQualityInspectionBus.setIsHassFleshcolorCreamy(isHassFleshcolorCreamy);
        hCDAvocadoQualityInspectionBus.setHassFleshColorCreamyRemarks(hassFleshColorCreamyRemarks);
        hCDAvocadoQualityInspectionBus.setIsSkinColorgreenToYellow(isSkinColorgreenToYellow);
        hCDAvocadoQualityInspectionBus.setSkinColorGreenToYellowRemarks(skinColorGreenToYellowRemarks);
        hCDAvocadoQualityInspectionBus.setIsSkinsmoothAtBlossom(isSkinsmoothAtBlossom);
        hCDAvocadoQualityInspectionBus.setSkinSmoothAtBlossomRemarks(skinSmoothAtBlossomRemarks);
        hCDAvocadoQualityInspectionBus.setIsFleshcolorCreamy(isFleshcolorCreamy);
        hCDAvocadoQualityInspectionBus.setFleshColorCreamyRemarks(fleshColorCreamyRemarks);

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
            } else result = true;
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
