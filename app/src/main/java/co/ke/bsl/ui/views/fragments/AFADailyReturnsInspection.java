package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.util.CustomEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFADailyReturnsInspection extends Fragment implements BlockingStep{


    @BindView(R.id.etDocument_no)
    CustomEditText etDocument_no;
    @BindView(R.id.etDocumentDate)
    CustomEditText etDocumentDate;
    @BindView(R.id.etApplicantName)
    CustomEditText etApplicantName;
    @BindView(R.id.etInspectionDate)
    CustomEditText etInspectionDate;

    private String document_no, document_date, applicant_name,inspection_date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afadaily_returns_inspection, container, false);

        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        document_no = Objects.requireNonNull(etDocument_no.getText()).toString().trim();
        document_date= Objects.requireNonNull(etDocumentDate.getText()).toString().trim();
        applicant_name= Objects.requireNonNull(etApplicantName.getText()).toString().trim();
        inspection_date= Objects.requireNonNull(etInspectionDate.getText()).toString().trim();

        if (TextUtils.isEmpty(document_no))
        {
            etDocument_no.setError("Document Number Required");
            return;
        }
        if (TextUtils.isEmpty(document_date))
        {
            etDocumentDate.setError("Document Date Required");
            return;
        }
        if (TextUtils.isEmpty(applicant_name))
        {
            etApplicantName.setError("Applicant Name Required");
            return;
        }

        if (TextUtils.isEmpty(inspection_date))
        {
            etInspectionDate.setError("Inspection Date Required");
            return;
        }
/*
        DailyReturnsInspectionBus dailyReturnsInspectionBus = DailyReturnsInspectionBus.getInstance();

        dailyReturnsInspectionBus.setDocument_no(document_no);
        dailyReturnsInspectionBus.setDocument_date(document_date);
        dailyReturnsInspectionBus.setSubLocation(applicant_name);
        dailyReturnsInspectionBus.setInspection_date(inspection_date);*/

        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

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