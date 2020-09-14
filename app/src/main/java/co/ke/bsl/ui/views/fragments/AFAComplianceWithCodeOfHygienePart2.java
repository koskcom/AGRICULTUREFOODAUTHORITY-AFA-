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
import co.ke.bsl.data.view.TeaWarehouseManInspectionBus;
import co.ke.bsl.data.view.View10Marks;
import co.ke.bsl.data.view.View1Marks;
import co.ke.bsl.data.view.View2Marks;
import co.ke.bsl.data.view.View5Marks;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAComplianceWithCodeOfHygienePart2 extends Fragment implements BlockingStep {

    @BindView(R.id.ch_valid_medical_certificates)
    CheckBox ch_valid_medical_certificates;
    @BindView(R.id.ssvalid_medical_certificates_mandatory)
    SearchableSpinner ssvalid_medical_certificates_mandatory;
    @BindView(R.id.etvalid_medical_certificates_remarks)
    CustomEditText etvalid_medical_certificates_remarks;

    @BindView(R.id.ch_are_hygiene_trainings_conducted)
    CheckBox ch_are_hygiene_trainings_conducted;
    @BindView(R.id.ssare_hygiene_trainings_conducted_mandatory)
    SearchableSpinner ssare_hygiene_trainings_conducted_mandatory;
    @BindView(R.id.etare_hygiene_trainings_conducted_remarks)
    CustomEditText etare_hygiene_trainings_conducted_remarks;


    @BindView(R.id.ch_adequate_and_clean)
    CheckBox ch_adequate_and_clean;
    @BindView(R.id.ssadequate_and_clean_mandatory)
    SearchableSpinner ssadequate_and_clean_mandatory;
    @BindView(R.id.etadequate_and_clean_remarks)
    CustomEditText etadequate_and_clean_remarks;


    @BindView(R.id.ch_personnel_hygiene_practices)
    CheckBox ch_personnel_hygiene_practices;
    @BindView(R.id.sspersonnel_hygiene_practices_mandatory)
    SearchableSpinner sspersonnel_hygiene_practices_mandatory;
    @BindView(R.id.etpersonnel_hygiene_practices_remarks)
    CustomEditText etpersonnel_hygiene_practices_remarks;


    @BindView(R.id.ch_changing_rooms_and_toilets)
    CheckBox ch_changing_rooms_and_toilets;
    @BindView(R.id.sschanging_rooms_and_toilets_mandatory)
    SearchableSpinner sschanging_rooms_and_toilets_mandatory;
    @BindView(R.id.etchanging_rooms_and_toilets_remarks)
    CustomEditText etchanging_rooms_and_toilets_remarks;

    private ArrayList<String> marksOf2List = new ArrayList<>();
    private ArrayList<String> marksOf1List = new ArrayList<>();
    private ArrayList<String> marksOf5List = new ArrayList<>();
    private ArrayList<String> marksOf10List = new ArrayList<>();

    private String Savestring = "N";

    private String str_valid_medical_certificates, str_are_hygiene_trainings_conducted, str_adequate_and_clean, str_personnel_hygiene_practices, str_changing_rooms_and_toilets;
    private String valid_medical_certificates_mandatory, are_hygiene_trainings_conducted_mandatory, adequate_and_clean_mandatory, personnel_hygiene_practices_mandatory, changing_rooms_and_toilets_mandatory;



    public AFAComplianceWithCodeOfHygienePart2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afacompliance_with_code_of_hygiene_part2, container, false);
        ButterKnife.bind(this, view);

        setList1Marks(getDummy1Marks());
        setList2Marks(getDummy2Marks());
        setList5Marks(getDummy5Marks());
        setList10Marks(getDummy10Marks());

        ch_valid_medical_certificates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_valid_medical_certificates.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_valid_medical_certificates = Savestring;

            }
        });

        ch_are_hygiene_trainings_conducted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_hygiene_trainings_conducted.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_are_hygiene_trainings_conducted = Savestring;

            }
        });

        ch_adequate_and_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_adequate_and_clean.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_adequate_and_clean = Savestring;

            }
        });

        ch_personnel_hygiene_practices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_personnel_hygiene_practices.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_personnel_hygiene_practices = Savestring;

            }
        });

        ch_changing_rooms_and_toilets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_changing_rooms_and_toilets.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_changing_rooms_and_toilets = Savestring;

            }
        });



        ssvalid_medical_certificates_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valid_medical_certificates_mandatory = ssvalid_medical_certificates_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssare_hygiene_trainings_conducted_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                are_hygiene_trainings_conducted_mandatory = ssare_hygiene_trainings_conducted_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssadequate_and_clean_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adequate_and_clean_mandatory = ssadequate_and_clean_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sspersonnel_hygiene_practices_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                personnel_hygiene_practices_mandatory = sspersonnel_hygiene_practices_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sschanging_rooms_and_toilets_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changing_rooms_and_toilets_mandatory = sschanging_rooms_and_toilets_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String valid_medical_certificates_remarks = Objects.requireNonNull(etvalid_medical_certificates_remarks.getText()).toString().trim();
        String are_hygiene_trainings_conducted_remarks = Objects.requireNonNull(etare_hygiene_trainings_conducted_remarks.getText()).toString().trim();
        String adequate_and_clean_remarks = Objects.requireNonNull(etadequate_and_clean_remarks.getText()).toString().trim();
        String personnel_hygiene_practices_remarks = Objects.requireNonNull(etpersonnel_hygiene_practices_remarks.getText()).toString().trim();
        String changing_rooms_and_toilets_remarks= Objects.requireNonNull(etchanging_rooms_and_toilets_remarks.getText()).toString().trim();

        boolean a = validateFields(ch_valid_medical_certificates, etvalid_medical_certificates_remarks, valid_medical_certificates_remarks, ssvalid_medical_certificates_mandatory, valid_medical_certificates_mandatory);
        boolean b = validateFields(ch_are_hygiene_trainings_conducted, etare_hygiene_trainings_conducted_remarks, are_hygiene_trainings_conducted_remarks, ssare_hygiene_trainings_conducted_mandatory, are_hygiene_trainings_conducted_mandatory);
        boolean c = validateFields(ch_adequate_and_clean, etadequate_and_clean_remarks, adequate_and_clean_remarks, ssadequate_and_clean_mandatory, adequate_and_clean_mandatory);
        boolean d = validateFields(ch_personnel_hygiene_practices, etpersonnel_hygiene_practices_remarks, personnel_hygiene_practices_remarks, sspersonnel_hygiene_practices_mandatory, personnel_hygiene_practices_mandatory);
        boolean e = validateFields(ch_changing_rooms_and_toilets, etchanging_rooms_and_toilets_remarks, changing_rooms_and_toilets_remarks, sschanging_rooms_and_toilets_mandatory, changing_rooms_and_toilets_mandatory);

        TeaWarehouseManInspectionBus teaWarehouseManInspectionBus = TeaWarehouseManInspectionBus.getInstance();
        teaWarehouseManInspectionBus.setValid_medical_certificates(str_valid_medical_certificates);
        teaWarehouseManInspectionBus.setValid_medical_certificates_mandatory(valid_medical_certificates_mandatory);
        teaWarehouseManInspectionBus.setValid_medical_certificates_remarks(valid_medical_certificates_remarks);
        teaWarehouseManInspectionBus.setAre_hygiene_trainings_conducted(str_are_hygiene_trainings_conducted);
        teaWarehouseManInspectionBus.setAre_hygiene_trainings_conducted_mandatory(are_hygiene_trainings_conducted_mandatory);
        teaWarehouseManInspectionBus.setAre_hygiene_trainings_conducted_remarks(are_hygiene_trainings_conducted_remarks);
        teaWarehouseManInspectionBus.setAdequate_and_clean_personal(str_adequate_and_clean);
        teaWarehouseManInspectionBus.setAdequate_and_clean_personal_mandatory(adequate_and_clean_mandatory);
        teaWarehouseManInspectionBus.setAdequate_and_clean_personal_remarks(adequate_and_clean_remarks);
        teaWarehouseManInspectionBus.setPersonnel_hygiene_practices_followed(str_personnel_hygiene_practices);
        teaWarehouseManInspectionBus.setPersonnel_hygiene_practices_followed_mandatory(personnel_hygiene_practices_mandatory);
        teaWarehouseManInspectionBus.setPersonnel_hygiene_practices_followed_remarks(personnel_hygiene_practices_remarks);
        teaWarehouseManInspectionBus.setChanging_rooms_and_toilets(str_changing_rooms_and_toilets);
        teaWarehouseManInspectionBus.setChanging_rooms_and_toilets_mandatory(changing_rooms_and_toilets_mandatory);
        teaWarehouseManInspectionBus.setChanging_rooms_and_toilets_remarks(changing_rooms_and_toilets_remarks);

        if(a && b && c && d && e) {
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


    private void setList1Marks(List<View1Marks> dummy1Marks) {

        marksOf1List.add("- Required -");
        for (View1Marks regionWrapper : dummy1Marks) {
            marksOf1List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf1List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
//        ssCoplianceToOHS1mks.setAdapter(regionAdapter);

    }

    private void setList2Marks(List<View2Marks> dummy2Marks) {

        marksOf2List.add("- Required -");
        for (View2Marks regionWrapper : dummy2Marks) {
            marksOf2List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf2List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssare_hygiene_trainings_conducted_mandatory.setAdapter(regionAdapter);
        sspersonnel_hygiene_practices_mandatory.setAdapter(regionAdapter);
        sschanging_rooms_and_toilets_mandatory.setAdapter(regionAdapter);

    }

    private void setList5Marks(List<View5Marks> dummy5Marks) {

        marksOf5List.add("- Required -");
        for (View5Marks regionWrapper : dummy5Marks) {
            marksOf5List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf5List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssvalid_medical_certificates_mandatory.setAdapter(regionAdapter);
        ssadequate_and_clean_mandatory.setAdapter(regionAdapter);
    }


    private void setList10Marks(List<View10Marks> dummy10Marks) {

        marksOf10List.add("- Required -");
        for (View10Marks regionWrapper : dummy10Marks) {
            marksOf10List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf10List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
//        ssadequateandcleanpersonalprot5mks.setAdapter(regionAdapter);
    }

    private List<View1Marks> getDummy1Marks() {
        List<View1Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View1Marks("0"));
        listViewItems.add(new View1Marks("1"));
        return listViewItems;
    }

    private List<View2Marks> getDummy2Marks() {
        List<View2Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View2Marks("0"));
        listViewItems.add(new View2Marks("2"));
        return listViewItems;
    }

    private List<View5Marks> getDummy5Marks() {
        List<View5Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View5Marks("0"));
        listViewItems.add(new View5Marks("5"));
        return listViewItems;
    }

    private List<View10Marks> getDummy10Marks() {
        List<View10Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View10Marks("0"));
        listViewItems.add(new View10Marks("10"));
        return listViewItems;
    }

    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString, SearchableSpinner searchableSpinner, String searchableSpinnerString){

        boolean resultCheckbox = false;
        boolean resultSpinner = false;

        if(!checkBox.isChecked()){
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                resultCheckbox = false;
            }
        } else{
            customEditText.setError(null);
            resultCheckbox = true;
        }

        if ("- Required -".equals(searchableSpinnerString)) {
            TextView errorText = (TextView) searchableSpinner.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            resultSpinner = false;
        } else{
            resultSpinner = true;
        }
        return (resultCheckbox && resultSpinner);
    }

}
