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
public class AFALicensesConformanceAssessmentLegalRequirements extends Fragment implements BlockingStep {

    @BindView(R.id.etconformed_with)
    CustomEditText etconformed_with;
    @BindView(R.id.etself_rating7)
    CustomEditText etself_rating7;
    @BindView(R.id.etenvironmental_laws)
    CustomEditText etenvironmental_laws;
    @BindView(R.id.etself_rating8)
    CustomEditText etself_rating8;
    @BindView(R.id.etcurrent_labour_laws)
    CustomEditText etcurrent_labour_laws;
    @BindView(R.id.etself_rating9)
    CustomEditText etself_rating9;
    @BindView(R.id.etcurrent_tax_regulations)
    CustomEditText etcurrent_tax_regulations;
    @BindView(R.id.etself_rating10)
    CustomEditText etself_rating10;
    @BindView(R.id.etpublic_health_act)
    CustomEditText etpublic_health_act;
    @BindView(R.id.etself_rating11)
    CustomEditText etself_rating11;
    @BindView(R.id.etfood_and_drugs)
    CustomEditText etfood_and_drugs;
    @BindView(R.id.etself_rating12)
    CustomEditText etself_rating12;
    @BindView(R.id.etrelevant_laws)
    CustomEditText etrelevant_laws;
    @BindView(R.id.etself_rating13)
    CustomEditText etself_rating13;

    private String conformed_with, self_rating7,environmental_laws, self_rating8, current_labour_laws, self_rating9, current_tax_regulations, self_rating10;

    private String public_health_act, self_rating11, food_and_drugs, self_rating12, other_relevant_laws,self_rating13;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afalicenses_conformance_assessment_legal_requirements, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
        conformed_with = Objects.requireNonNull(etconformed_with.getText().toString());
        self_rating7 = Objects.requireNonNull(etself_rating7.getText().toString());
        environmental_laws= Objects.requireNonNull(etenvironmental_laws.getText().toString());
        self_rating8 = Objects.requireNonNull(etself_rating8.getText().toString());
        current_labour_laws = Objects.requireNonNull(etcurrent_labour_laws.getText().toString());
        self_rating9 = Objects.requireNonNull(etself_rating9.getText().toString());
        current_tax_regulations = Objects.requireNonNull(etcurrent_tax_regulations.getText().toString());
        self_rating10 = Objects.requireNonNull(etself_rating10.getText().toString());
        public_health_act= Objects.requireNonNull(etpublic_health_act.getText().toString());
        self_rating11 = Objects.requireNonNull(etself_rating11.getText().toString());
        food_and_drugs = Objects.requireNonNull(etfood_and_drugs.getText().toString());
        self_rating12 = Objects.requireNonNull(etself_rating12.getText().toString());
        other_relevant_laws = Objects.requireNonNull(etrelevant_laws.getText().toString());
        self_rating13 = Objects.requireNonNull(etself_rating13.getText().toString());


        if (TextUtils.isEmpty(conformed_with))
        {
            etconformed_with.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating7))
        {
            etself_rating7.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(environmental_laws))
        {
            etenvironmental_laws.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating8))
        {
            etself_rating8.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(current_labour_laws))
        {
            etcurrent_labour_laws.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating9))
        {
            etself_rating9.setError("Field Required");
            return;
        }

        if (TextUtils.isEmpty(current_tax_regulations))
        {
            etcurrent_tax_regulations.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating10))
        {
            etself_rating10.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(public_health_act))
        {
            etpublic_health_act.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating11))
        {
            etself_rating11.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(food_and_drugs))
        {
            etfood_and_drugs.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating12))
        {
            etself_rating12.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(other_relevant_laws))
        {
            etrelevant_laws.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(self_rating13))
        {
            etself_rating13.setError("Field Required");
            return;
        }
      /*  LicenceConformanceAssessmentBus licenceConformanceAssessmentBus = LicenceConformanceAssessmentBus.getInstance();

        licenceConformanceAssessmentBus.setConformed_with(conformed_with);
        licenceConformanceAssessmentBus.setSelf_rating7(self_rating7);
        licenceConformanceAssessmentBus.setEnvironmental_laws(environmental_laws);
        licenceConformanceAssessmentBus.setSelf_rating8(self_rating8);
        licenceConformanceAssessmentBus.setCurrent_labour_laws(current_labour_laws);
        licenceConformanceAssessmentBus.setSelf_rating9(self_rating9);
        licenceConformanceAssessmentBus.setCurrent_tax_regulations(current_tax_regulations);
        licenceConformanceAssessmentBus.setSelf_rating10(self_rating10);
        licenceConformanceAssessmentBus.setPublic_health_act(public_health_act);
        licenceConformanceAssessmentBus.setSelf_rating11(self_rating11);
        licenceConformanceAssessmentBus.setFood_and_drugs(food_and_drugs);
        licenceConformanceAssessmentBus.setSelf_rating12(self_rating12);
        licenceConformanceAssessmentBus.setOther_relevant_laws(other_relevant_laws);
        licenceConformanceAssessmentBus.setSelf_rating13(self_rating13);
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

