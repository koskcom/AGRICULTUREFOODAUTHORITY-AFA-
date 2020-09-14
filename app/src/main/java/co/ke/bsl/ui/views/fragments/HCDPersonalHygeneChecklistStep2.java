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
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.HCDPersonalHygene;
import co.ke.bsl.data.view.PersanlHygieneBus;
import co.ke.bsl.pojo.PersanlHygiene;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.PersonalHygieneViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDPersonalHygeneChecklistStep2 extends Fragment implements BlockingStep {

    @BindView(R.id.etNames)
    CustomEditText etNames;
    @BindView(R.id.etNationalIdNo)
    CustomEditText etNationalIdNo;
    @BindView(R.id.etMedicalCertificateNo)
    CustomEditText etMedicalCertificateNo;
    @BindView(R.id.isDustcots)
    CheckBox isDustcots;
    @BindView(R.id.isHGearsCaps)
    CheckBox isHGearsCaps;
    @BindView(R.id.isJewels)
    CheckBox isJewels;
    @BindView(R.id.isNailsCut)
    CheckBox isNailsCut;
    @BindView(R.id.isBodyClean)
    CheckBox isBodyClean;
    @BindView(R.id.isShoes)
    CheckBox isShoes;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private PersonalHygieneViewModel personalHygieneViewModel;


    private String names, nationalId, medicalCertNo, isdustCots, isHgearsCaps , isjewels, isnailsCut, isbodyClean, isshoes;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdpersonal_hygene_checklist_step2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        personalHygieneViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(PersonalHygieneViewModel.class);


        isDustcots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDustcots.isChecked()) {
                    isdustCots = "Y";
                } else {
                    isdustCots = "N";
                }

            }
        });isHGearsCaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHGearsCaps.isChecked()) {
                    isHgearsCaps = "Y";
                } else {
                    isHgearsCaps = "N";
                }

            }
        });
        isJewels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isJewels.isChecked()) {
                    isjewels = "Y";
                } else {
                    isjewels = "N";
                }

            }
        });
        isNailsCut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNailsCut.isChecked()) {
                    isnailsCut = "Y";
                } else {
                    isnailsCut = "N";
                }

            }
        });
        isBodyClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBodyClean.isChecked()) {
                    isbodyClean = "Y";
                } else {
                    isbodyClean = "N";
                }

            }
        });
        isShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShoes.isChecked()) {
                    isshoes = "Y";
                } else {
                    isshoes = "N";
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
        names = Objects.requireNonNull(etNames.getText()).toString().trim();
        nationalId = Objects.requireNonNull(etNationalIdNo.getText()).toString().trim();
        medicalCertNo = Objects.requireNonNull(etMedicalCertificateNo.getText()).toString().trim();

        //validation
        boolean valid = validateEditText(etNames, names) &
                validateEditText(etNationalIdNo, nationalId) &
                validateEditText(etMedicalCertificateNo, medicalCertNo);


        PersanlHygieneBus persanlHygieneBus = PersanlHygieneBus.getInstance();
        HCDPersonalHygene hCDPersonalHygene = new HCDPersonalHygene(
                0,
                persanlHygieneBus.getSsnameOfApplicant(),
                persanlHygieneBus.getLocalID(),
                names,
                nationalId,
                medicalCertNo,
                isdustCots,
                isHgearsCaps,
                isjewels,
                isnailsCut,
                isbodyClean,
                isshoes,
                false,
                ""

        );


        if (persanlHygieneBus.getSsnameOfApplicant() != null && !persanlHygieneBus.getSsnameOfApplicant().isEmpty()) {

            db.insertHCDpersanlHygiene(hCDPersonalHygene);
            db.UpdatePersonalHygienDetails(hCDPersonalHygene);

            personalHygieneViewModel.addRecord(hCDPersonalHygene);

          Intent intent = new Intent(getActivity(), DashboardActivity.class);
            Objects.requireNonNull(getActivity()).finish();
            startActivity(intent);
        } else {
            Toast.makeText(app, "Please Select Applicant", Toast.LENGTH_SHORT).show();

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
}
