package co.ke.bsl.ui.views.fragments;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.FCDCottonLintClassingReport;
import co.ke.bsl.data.view.FCDCottonLintClassingReportBus;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.CottonLintViewModel;
import co.ke.bsl.ui.viewmodels.PyrethrumInspectionViewModel;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDCottonLintClassingReportInfo extends Fragment implements BlockingStep {

    @BindView(R.id.etSampleIdentification)
    CustomEditText etSampleIdentification;
    @BindView(R.id.etAnalysisDate)
    CustomEditText etAnalysisDate;
    @BindView(R.id.etOrigin)
    CustomEditText etOrigin;
    @BindView(R.id.etMicronaire)
    CustomEditText etMicronaire;
    @BindView(R.id.etLengthInches)
    CustomEditText etLengthInches;
    @BindView(R.id.etLengthMillimeters)
    CustomEditText etLengthMillimeters;
    @BindView(R.id.etUniformityIndex)
    CustomEditText etUniformityIndex;
    @BindView(R.id.etStrength)
    CustomEditText etStrength;
    @BindView(R.id.etColorRd)
    CustomEditText etColorRd;
    @BindView(R.id.etColorB)
    CustomEditText etColorB;
    @BindView(R.id.etColorGrade)
    CustomEditText etColorGrade;
    @BindView(R.id.etCottonLintRemarks)
    CustomEditText etCottonLintRemarks;


    private String sampleIdentification, analysisDate, origin, micronaire, lengthInches, lengthMillimeters, uniformityIndex, strength, colorRD, colorB, colorGrade, remarks;

    AFADatabaseAdapter db;
    AFA app;
    final Calendar myCalendar = Calendar.getInstance();

    private CottonLintViewModel cottonLintViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdcotton_lint_classing_report_info, container, false);
        ButterKnife.bind(this, view);

        cottonLintViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CottonLintViewModel.class);


        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        etAnalysisDate.setKeyListener(null);
        etAnalysisDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        sampleIdentification = Objects.requireNonNull(etSampleIdentification.getText()).toString().trim();
        analysisDate = new Timestamp(myCalendar.getTimeInMillis()).toString();
        origin = Objects.requireNonNull(etOrigin.getText()).toString().trim();
        micronaire = Objects.requireNonNull(etMicronaire.getText()).toString().trim();
        lengthInches = Objects.requireNonNull(etLengthInches.getText()).toString().trim();
        lengthMillimeters = Objects.requireNonNull(etLengthMillimeters.getText()).toString().trim();
        uniformityIndex = Objects.requireNonNull(etUniformityIndex.getText()).toString().trim();
        strength = Objects.requireNonNull(etStrength.getText()).toString().trim();
        colorRD = Objects.requireNonNull(etColorRd.getText()).toString().trim();
        colorB = Objects.requireNonNull(etColorB.getText()).toString().trim();
        colorGrade = Objects.requireNonNull(etColorGrade.getText()).toString().trim();
        remarks = Objects.requireNonNull(etCottonLintRemarks.getText()).toString().trim();

        if (TextUtils.isEmpty(sampleIdentification)) {
            etSampleIdentification.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(origin)) {
            etOrigin.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(micronaire)) {
            etMicronaire.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(lengthInches)) {
            etLengthInches.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(lengthMillimeters)) {
            etLengthMillimeters.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(uniformityIndex)) {
            etUniformityIndex.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(strength)) {
            etStrength.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(colorRD)) {
            etColorRd.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(colorB)) {
            etColorB.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(colorGrade)) {
            etColorGrade.setError("Field Required");
            return;
        }

        FCDCottonLintClassingReportBus fcdCottonLintClassingReportBus = FCDCottonLintClassingReportBus.getInstance();

        FCDCottonLintClassingReport fcdCottonLintClassingReport = new FCDCottonLintClassingReport(
                0,
                fcdCottonLintClassingReportBus.getDocumentNumber(),
                fcdCottonLintClassingReportBus.getDocumentDate(),
                fcdCottonLintClassingReportBus.getNameOfApplicant(),
                fcdCottonLintClassingReportBus.getLintLicence(),
                fcdCottonLintClassingReportBus.getLocalId(),
                sampleIdentification,
                analysisDate,
                origin,
                micronaire,
                lengthInches,
                lengthMillimeters,
                uniformityIndex,
                strength,
                colorRD,
                colorB,
                colorGrade,
                remarks,
                false,
                ""
        );

        new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("SUGAR MILL INSPECTION!")
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

                        long result = db.UpdateFCDCottonLintClassingReport(fcdCottonLintClassingReport);
                        System.out.println("result is" + result);
                        cottonLintViewModel.addRecord(fcdCottonLintClassingReport);

                        sDialog.dismissWithAnimation();
                            Intent intent = new Intent(getActivity(), DashboardActivity.class);
                            startActivity(intent);
                        }
                    })
                    .show();


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

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        etAnalysisDate.setText(sdf.format(myCalendar.getTime()));
    }
}
