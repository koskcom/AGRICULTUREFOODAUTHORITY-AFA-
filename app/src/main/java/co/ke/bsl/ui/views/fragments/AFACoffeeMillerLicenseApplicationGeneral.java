package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.R;
import co.ke.bsl.data.view.CoffeeMillerLicenceApplicationBus;
import co.ke.bsl.data.view.PulpingStationLicenseApplicationBus;
import co.ke.bsl.data.view.View2Marks;
import co.ke.bsl.data.view.View5Marks;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFACoffeeMillerLicenseApplicationGeneral extends Fragment implements BlockingStep {
    @BindView(R.id.ssOfficeConditionMarks)
    SearchableSpinner ssOfficeConditionMarks;

    @BindView(R.id.ch_nema_certification)
    CheckBox ch_nema_certification;
    @BindView(R.id.etnema_certification_findings)
    CustomEditText etnema_certification_findings;
    @BindView(R.id.ch_occupational_safety)
    CheckBox ch_occupational_safety;
    @BindView(R.id.etoccupational_safety_findings)
    CustomEditText etoccupational_safety_findings;

    private String Savestring = "N";
    private String str_office, str_nema, str_occupational;

    private ArrayList<String> marksof5List = new ArrayList<>();

    public AFACoffeeMillerLicenseApplicationGeneral() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afacoffee_miller_license_application_general, container, false);
        ButterKnife.bind(this, view);

        setList5marks(getdummy5marks());

        ch_nema_certification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_nema_certification.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_nema = Savestring;
            }
        });

        ch_occupational_safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_nema_certification.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_occupational = Savestring;
            }
        });

        ssOfficeConditionMarks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_office = ssOfficeConditionMarks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String nema = Objects.requireNonNull(etnema_certification_findings.getText()).toString().trim();
        String safety = Objects.requireNonNull(etoccupational_safety_findings.getText()).toString().trim();

        if ("- Required -".equals(str_office)) {
            TextView errorText = (TextView) ssOfficeConditionMarks.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }

        boolean valid = validateFields(ch_nema_certification, etnema_certification_findings, nema) &
                validateFields(ch_occupational_safety, etoccupational_safety_findings, safety);

        CoffeeMillerLicenceApplicationBus coffeeMillerLicenceApplicationBus = CoffeeMillerLicenceApplicationBus.getInstance();
        coffeeMillerLicenceApplicationBus.setOfficeCondition(str_office);
        coffeeMillerLicenceApplicationBus.setNemaCertification(str_nema);
        coffeeMillerLicenceApplicationBus.setNemaCertificationFindings(nema);
        coffeeMillerLicenceApplicationBus.setOccupationalSafety(str_occupational);
        coffeeMillerLicenceApplicationBus.setOccupationalSafetyFindings(safety);

        if(valid) {
            callback.goToNextStep();
        }
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

   private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString){

        boolean result= false;

        if(!checkBox.isChecked()){
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                result = false;
            } else {
                result = true;
            }
        } else{
            customEditText.setError(null);
            result = true;
        }

        return result;
    }
    private void setList5marks(List<View5Marks> getdummy5marks) {
        marksof5List.add("- Required -");
        for (View5Marks regionWrapper : getdummy5marks) {
            marksof5List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof5List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssOfficeConditionMarks.setAdapter(regionAdapter);
    }

    private List<View5Marks> getdummy5marks() {
        List<View5Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View5Marks("0"));
        listViewItems.add(new View5Marks("1"));
        listViewItems.add(new View5Marks("2"));
        listViewItems.add(new View5Marks("3"));
        listViewItems.add(new View5Marks("4"));
        listViewItems.add(new View5Marks("5"));

        return listViewItems;
    }
}
