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
public class AFAComplianceWithCodeOfHygienePart1 extends Fragment implements BlockingStep {

    @BindView(R.id.ch_documented_hygiene_policy)
    CheckBox ch_documented_hygiene_policy;
    @BindView(R.id.ssdocumented_hygiene_policy_mandatory)
    SearchableSpinner ssdocumented_hygiene_policy_mandatory;
    @BindView(R.id.etdocumented_hygiene_policy_remarks)
    CustomEditText etdocumented_hygiene_policy_remarks;

    @BindView(R.id.ch_evidence_of_implementation)
    CheckBox ch_evidence_of_implementation;
    @BindView(R.id.ssevidence_of_implementation_mandatory)
    SearchableSpinner ssevidence_of_implementation_mandatory;
    @BindView(R.id.etevidence_of_implementation_remarks)
    CustomEditText etevidence_of_implementation_remarks;


    @BindView(R.id.ch_food_safety_hazard)
    CheckBox ch_food_safety_hazard;
    @BindView(R.id.ssfood_safety_hazard_mandatory)
    SearchableSpinner ssfood_safety_hazard_mandatory;
    @BindView(R.id.etfood_safety_hazard_remarks)
    CustomEditText etfood_safety_hazard_remarks;


    @BindView(R.id.ch_control_measures)
    CheckBox ch_control_measures;
    @BindView(R.id.sscontrol_measures_mandatory)
    SearchableSpinner sscontrol_measures_mandatory;
    @BindView(R.id.etcontrol_measures_remarks)
    CustomEditText etcontrol_measures_remarks;


    @BindView(R.id.ch_documented_glass_policy)
    CheckBox ch_documented_glass_policy;
    @BindView(R.id.ssdocumented_glass_policy_mandatory)
    SearchableSpinner ssdocumented_glass_policy_mandatory;
    @BindView(R.id.etdocumented_glass_policy_remarks)
    CustomEditText etdocumented_glass_policy_remarks;

    private ArrayList<String> marksOf2List = new ArrayList<>();
    private ArrayList<String> marksOf1List = new ArrayList<>();
    private ArrayList<String> marksOf5List = new ArrayList<>();
    private ArrayList<String> marksOf10List = new ArrayList<>();

    private String Savestring = "N";

    private String str_documented_hygiene_policy, str_evidence_of_implementation, str_food_safety_hazard, str_control_measures, str_documented_glass_policy;
    private String documented_hygiene_policy_mandatory, evidence_of_implementation_mandatory, food_safety_hazard_mandatory, control_measures_mandatory, documented_glass_policy_mandatory;


    public AFAComplianceWithCodeOfHygienePart1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afacompliance_with_code_of_hygiene_part1, container, false);
        ButterKnife.bind(this, view);

        // todo - change setList1Marks to  setList3Marks
        setList1Marks(getDummy1Marks());
        setList2Marks(getDummy2Marks());
        setList5Marks(getDummy5Marks());
        setList10Marks(getDummy10Marks());

        ch_documented_hygiene_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_documented_hygiene_policy.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_documented_hygiene_policy = Savestring;

            }
        });

        ch_evidence_of_implementation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_evidence_of_implementation.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_evidence_of_implementation = Savestring;

            }
        });

        ch_food_safety_hazard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_food_safety_hazard.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_food_safety_hazard = Savestring;

            }
        });

        ch_control_measures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_control_measures.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_control_measures = Savestring;

            }
        });

        ch_documented_glass_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_documented_glass_policy.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_documented_glass_policy = Savestring;

            }
        });

        ssdocumented_hygiene_policy_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                documented_hygiene_policy_mandatory = ssdocumented_hygiene_policy_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssevidence_of_implementation_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                evidence_of_implementation_mandatory = ssevidence_of_implementation_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssfood_safety_hazard_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                food_safety_hazard_mandatory = ssfood_safety_hazard_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sscontrol_measures_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                control_measures_mandatory = sscontrol_measures_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssdocumented_glass_policy_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                documented_glass_policy_mandatory = ssdocumented_glass_policy_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        String documented_hygiene_policy_remarks = Objects.requireNonNull(etdocumented_hygiene_policy_remarks.getText()).toString().trim();
        String evidence_of_implementation_remarks = Objects.requireNonNull(etevidence_of_implementation_remarks.getText()).toString().trim();
        String food_safety_hazard_remarks = Objects.requireNonNull(etfood_safety_hazard_remarks.getText()).toString().trim();
        String control_measures_remarks = Objects.requireNonNull(etcontrol_measures_remarks.getText()).toString().trim();
        String documented_glass_policy_remarks= Objects.requireNonNull(etdocumented_glass_policy_remarks.getText()).toString().trim();

        boolean a = validateFields(ch_documented_hygiene_policy, etdocumented_hygiene_policy_remarks, documented_hygiene_policy_remarks, ssdocumented_hygiene_policy_mandatory, documented_hygiene_policy_mandatory);
        boolean b = validateFields(ch_evidence_of_implementation, etevidence_of_implementation_remarks, evidence_of_implementation_remarks, ssevidence_of_implementation_mandatory, evidence_of_implementation_mandatory);
        boolean c = validateFields(ch_food_safety_hazard, etfood_safety_hazard_remarks, food_safety_hazard_remarks, ssfood_safety_hazard_mandatory, food_safety_hazard_mandatory);
        boolean d = validateFields(ch_control_measures, etcontrol_measures_remarks, control_measures_remarks, sscontrol_measures_mandatory, control_measures_mandatory);
        boolean e = validateFields(ch_documented_glass_policy, etdocumented_glass_policy_remarks, documented_glass_policy_remarks, ssdocumented_glass_policy_mandatory, documented_glass_policy_mandatory);

        TeaWarehouseManInspectionBus teaWarehouseManInspectionBus = TeaWarehouseManInspectionBus.getInstance();
        teaWarehouseManInspectionBus.setDocumented_hygiene_policy(str_documented_hygiene_policy);
        teaWarehouseManInspectionBus.setDocumented_hygiene_policy_mandatory(documented_hygiene_policy_mandatory);
        teaWarehouseManInspectionBus.setDocumented_hygiene_policy_remarks(documented_hygiene_policy_remarks);
        teaWarehouseManInspectionBus.setEvidence_of_implementation(str_evidence_of_implementation);
        teaWarehouseManInspectionBus.setEvidence_of_implementation_mandatory(evidence_of_implementation_mandatory);
        teaWarehouseManInspectionBus.setEvidence_of_implementation_remarks(evidence_of_implementation_remarks);
        teaWarehouseManInspectionBus.setFood_safety_hazard(str_food_safety_hazard);
        teaWarehouseManInspectionBus.setFood_safety_hazard_mandatory(food_safety_hazard_mandatory);
        teaWarehouseManInspectionBus.setFood_safety_hazard_remarks(food_safety_hazard_remarks);
        teaWarehouseManInspectionBus.setControl_measures(str_control_measures);
        teaWarehouseManInspectionBus.setControl_measures_mandatory(control_measures_mandatory);
        teaWarehouseManInspectionBus.setControl_measures_remarks(control_measures_remarks);
        teaWarehouseManInspectionBus.setDocumented_glass_policy(str_documented_glass_policy);
        teaWarehouseManInspectionBus.setDocumented_glass_policy_mandatory(documented_glass_policy_mandatory);
        teaWarehouseManInspectionBus.setDocumented_glass_policy_remarks(documented_glass_policy_remarks);

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
        ssfood_safety_hazard_mandatory.setAdapter(regionAdapter);

    }

    private void setList2Marks(List<View2Marks> dummy2Marks) {

        marksOf2List.add("- Required -");
        for (View2Marks regionWrapper : dummy2Marks) {
            marksOf2List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf2List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssdocumented_hygiene_policy_mandatory.setAdapter(regionAdapter);
        ssdocumented_glass_policy_mandatory.setAdapter(regionAdapter);

    }

    private void setList5Marks(List<View5Marks> dummy5Marks) {

        marksOf5List.add("- Required -");
        for (View5Marks regionWrapper : dummy5Marks) {
            marksOf5List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf5List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        sscontrol_measures_mandatory.setAdapter(regionAdapter);
        ssevidence_of_implementation_mandatory.setAdapter(regionAdapter);
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
        listViewItems.add(new View1Marks("3"));
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
