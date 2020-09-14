package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
public class HarvestReturnsInspectionStep1 extends Fragment implements BlockingStep
{

    @BindView(R.id.etdocument_no)
    CustomEditText etdocument_no;
    @BindView(R.id.etdocument_date)
    CustomEditText etdocument_date;
    @BindView(R.id.etApplicantName)
    CustomEditText etApplicantName;
    @BindView(R.id.etname)
    CustomEditText etname;

    private String document_number, document_date, applicant_name, name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_harvest_returns_inspection_insert_records, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        document_number = Objects.requireNonNull(etdocument_no.getText()).toString().trim();
        document_date = Objects.requireNonNull(etdocument_date.getText()).toString().trim();
        applicant_name = Objects.requireNonNull(etApplicantName.getText()).toString().trim();
        name = Objects.requireNonNull(etname.getText()).toString().trim();

        if (TextUtils.isEmpty(document_number))
        {
            etdocument_no.setError("Document Number Required");
            return;
        }
        if (TextUtils.isEmpty(document_date))
        {
            etdocument_date.setError("Date Required");
            return;
        }

        if (TextUtils.isEmpty(applicant_name))
        {
            etApplicantName.setError("Date Required");
            return;
        }
        if (TextUtils.isEmpty(name))
        {
            etname.setError("Date Required");
            return;
        }
/*

        HarvestReturnsBus harvestReturnsBus = HarvestReturnsBus.getInstance();

        harvestReturnsBus.setDocument_number(document_number);
        harvestReturnsBus.setDocument_date(document_date);
        harvestReturnsBus.setSubLocation(applicant_name);
        harvestReturnsBus.setName(name);
*/
        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback)
    {

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback)
    {

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
    public void onError(@NonNull VerificationError error)
    {

    }


}
