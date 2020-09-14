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
import android.widget.Spinner;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.HCDNurseryInspectionBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDNurseryInspectionStep2 extends Fragment implements BlockingStep {

    @BindView(R.id.isDiseaseFreeSeedlings)
    CheckBox isDiseaseFreeSeedlings;
    @BindView(R.id.etDiseaseFreeSeedlingsRemarks)
    CustomEditText etDiseaseFreeSeedlingsRemarks;

    @BindView(R.id.isFreeFromOrganicLitter)
    CheckBox isFreeFromOrganicLitter;
    @BindView(R.id.etFreeFromOrganicLitterRemarks)
    CustomEditText etFreeFromOrganicLitterRemarks;

    @BindView(R.id.isClearSeparation)
    CheckBox isClearSeparation;
    @BindView(R.id.etClearSeparationRemarks)
    CustomEditText etClearSeparationRemarks;

    @BindView(R.id.isYearRoundSourceOfWater)
    CheckBox isYearRoundSourceOfWater;
    @BindView(R.id.etYearRoundSourceOfWaterRemarks)
    CustomEditText etYearRoundSourceOfWaterRemarks;

    @BindView(R.id.isSoilMedia)
    CheckBox isSoilMedia;
    @BindView(R.id.etSoilMediaRemarks)
    CustomEditText etSoilMediaRemarks;

    @BindView(R.id.isWellSecuredNurseryLayout)
    CheckBox isWellSecuredNurseryLayout;
    @BindView(R.id.etWellSecuredNurseryLayoutRemarks)
    CustomEditText etWellSecuredNurseryLayoutRemarks;
    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private String isDiseasefreeSeedling, diseasefreeSeedlingRemarks, isFreefromOrganicLitter, freefromOrganicLitterRemarks, isClearseparation, clearSeparationRemarks;
    private String isYearroundSourceOfWater, yearroundSourceOfWaterRemarks, isSoilmedia, soilMediaRemarks, isWellsecuredNurseryLayout, wellsecuredNurseryLayoutRemarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afahcdnursery_inspection_step2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();


        isDiseaseFreeSeedlings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDiseaseFreeSeedlings.isChecked()) {
                    isDiseasefreeSeedling = "Y";
                } else {
                    isDiseasefreeSeedling = "N";
                }

            }
        });

        isFreeFromOrganicLitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFreeFromOrganicLitter.isChecked()) {
                    isFreefromOrganicLitter = "Y";
                } else {
                    isFreefromOrganicLitter = "N";
                }

            }
        });

        isClearSeparation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClearSeparation.isChecked()) {
                    isClearseparation = "Y";
                } else {
                    isClearseparation = "N";
                }

            }
        });

        isYearRoundSourceOfWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isYearRoundSourceOfWater.isChecked()) {
                    isYearroundSourceOfWater = "Y";
                } else {
                    isYearroundSourceOfWater = "N";
                }

            }
        });

        isSoilMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSoilMedia.isChecked()) {
                    isSoilmedia = "Y";
                } else {
                    isSoilmedia = "N";
                }

            }
        });
        isWellSecuredNurseryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWellSecuredNurseryLayout.isChecked()) {
                    isWellsecuredNurseryLayout = "Y";
                } else {
                    isWellsecuredNurseryLayout = "N";
                }

            }
        });


        return view;

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        diseasefreeSeedlingRemarks = Objects.requireNonNull(etDiseaseFreeSeedlingsRemarks.getText()).toString().trim();
        freefromOrganicLitterRemarks = Objects.requireNonNull(etFreeFromOrganicLitterRemarks.getText()).toString().trim();
        clearSeparationRemarks = Objects.requireNonNull(etClearSeparationRemarks.getText()).toString().trim();
        yearroundSourceOfWaterRemarks = Objects.requireNonNull(etYearRoundSourceOfWaterRemarks.getText()).toString().trim();
        soilMediaRemarks = Objects.requireNonNull(etSoilMediaRemarks.getText()).toString().trim();
        wellsecuredNurseryLayoutRemarks = Objects.requireNonNull(etWellSecuredNurseryLayoutRemarks.getText()).toString().trim();

        //validation
        boolean valid = validateFields(isDiseaseFreeSeedlings, etDiseaseFreeSeedlingsRemarks, diseasefreeSeedlingRemarks) &
                validateFields(isFreeFromOrganicLitter, etFreeFromOrganicLitterRemarks, freefromOrganicLitterRemarks) &
                validateFields(isClearSeparation, etClearSeparationRemarks, clearSeparationRemarks) &
                validateFields(isYearRoundSourceOfWater, etYearRoundSourceOfWaterRemarks, yearroundSourceOfWaterRemarks) &
                validateFields(isSoilMedia, etSoilMediaRemarks, soilMediaRemarks) &
                validateFields(isWellSecuredNurseryLayout, etWellSecuredNurseryLayoutRemarks, wellsecuredNurseryLayoutRemarks);

        HCDNurseryInspectionBus hCDNurseryInspectionBus = HCDNurseryInspectionBus.getInstance();
        hCDNurseryInspectionBus.setIsDiseasefreeSeedling(isDiseasefreeSeedling);
        hCDNurseryInspectionBus.setDiseasefreeSeedlingRemarks(diseasefreeSeedlingRemarks);
        hCDNurseryInspectionBus.setIsFreefromOrganicLitter(isFreefromOrganicLitter);
        hCDNurseryInspectionBus.setFreefromOrganicLitterRemarks(freefromOrganicLitterRemarks);
        hCDNurseryInspectionBus.setIsClearseparation(isClearseparation);
        hCDNurseryInspectionBus.setClearSeparationRemarks(clearSeparationRemarks);
        hCDNurseryInspectionBus.setIsYearroundSourceOfWater(isYearroundSourceOfWater);
        hCDNurseryInspectionBus.setYearroundSourceOfWaterRemarks(yearroundSourceOfWaterRemarks);
        hCDNurseryInspectionBus.setIsSoilmedia(isSoilmedia);
        hCDNurseryInspectionBus.setSoilMediaRemarks(soilMediaRemarks);
        hCDNurseryInspectionBus.setIsWellsecuredNurseryLayout(isWellsecuredNurseryLayout);
        hCDNurseryInspectionBus.setWellsecuredNurseryLayoutRemarks(wellsecuredNurseryLayoutRemarks);

        if (valid ) {
            callback.goToNextStep();
        }


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
