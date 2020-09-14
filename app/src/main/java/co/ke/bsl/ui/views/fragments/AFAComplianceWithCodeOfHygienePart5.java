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
public class AFAComplianceWithCodeOfHygienePart5 extends Fragment implements BlockingStep {

    @BindView(R.id.ch_sufficient_ventilation)
    CheckBox ch_sufficient_ventilation;
    @BindView(R.id.sssufficient_ventilation_mandatory)
    SearchableSpinner sssufficient_ventilation_mandatory;
    @BindView(R.id.etsufficient_ventilation_remarks)
    CustomEditText etsufficient_ventilation_remarks;

    @BindView(R.id.ch_adequate_services)
    CheckBox ch_adequate_services;
    @BindView(R.id.ssadequate_services_mandatory)
    SearchableSpinner ssadequate_services_mandatory;
    @BindView(R.id.etadequate_services_remarks)
    CustomEditText etadequate_services_remarks;


    @BindView(R.id.ch_proper_waste_collection)
    CheckBox ch_proper_waste_collection;
    @BindView(R.id.ssproper_waste_collection_mandatory)
    SearchableSpinner ssproper_waste_collection_mandatory;
    @BindView(R.id.etproper_waste_collection_remarks)
    CustomEditText etproper_waste_collection_remarks;


    @BindView(R.id.ch_external_site_standards)
    CheckBox ch_external_site_standards;
    @BindView(R.id.ssexternal_site_standards_mandatory)
    SearchableSpinner ssexternal_site_standards_mandatory;
    @BindView(R.id.etexternal_site_standards_remarks)
    CustomEditText etexternal_site_standards_remarks;

    private ArrayList<String> marksOf2List = new ArrayList<>();
    private ArrayList<String> marksOf1List = new ArrayList<>();
    private ArrayList<String> marksOf5List = new ArrayList<>();
    private ArrayList<String> marksOf10List = new ArrayList<>();

    private String Savestring = "N";

    private String str_sufficient_ventilation, str_adequate_services, str_proper_waste_collection, str_external_site_standards;
    private String sufficient_ventilation_mandatory, adequate_services_mandatory, proper_waste_collection_mandatory, external_site_standards_mandatory;



    public AFAComplianceWithCodeOfHygienePart5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afacompliance_with_code_of_hygiene_part5, container, false);
        ButterKnife.bind(this, view);

        setList1Marks(getDummy1Marks());
        setList2Marks(getDummy2Marks());
        setList5Marks(getDummy5Marks());
        setList10Marks(getDummy10Marks());

        ch_sufficient_ventilation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_sufficient_ventilation.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_sufficient_ventilation = Savestring;

            }
        });

        ch_adequate_services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_adequate_services.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_adequate_services = Savestring;

            }
        });

        ch_proper_waste_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_proper_waste_collection.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_proper_waste_collection = Savestring;

            }
        });

        ch_external_site_standards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_external_site_standards.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_external_site_standards = Savestring;

            }
        });

        ssexternal_site_standards_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                external_site_standards_mandatory = ssexternal_site_standards_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sssufficient_ventilation_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sufficient_ventilation_mandatory = sssufficient_ventilation_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssadequate_services_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adequate_services_mandatory = ssadequate_services_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssproper_waste_collection_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                proper_waste_collection_mandatory = ssproper_waste_collection_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String sufficient_ventilation_remarks = Objects.requireNonNull(etsufficient_ventilation_remarks.getText()).toString().trim();
        String adequate_services_remarks = Objects.requireNonNull(etadequate_services_remarks.getText()).toString().trim();
        String proper_waste_collection_remarks = Objects.requireNonNull(etproper_waste_collection_remarks.getText()).toString().trim();
        String external_site_standards_remarks = Objects.requireNonNull(etexternal_site_standards_remarks.getText()).toString().trim();

        boolean a = validateFields(ch_sufficient_ventilation, etsufficient_ventilation_remarks, sufficient_ventilation_remarks, sssufficient_ventilation_mandatory, sufficient_ventilation_mandatory);
        boolean b = validateFields(ch_adequate_services, etadequate_services_remarks, adequate_services_remarks, ssadequate_services_mandatory, adequate_services_mandatory);
        boolean c = validateFields(ch_proper_waste_collection, etproper_waste_collection_remarks, proper_waste_collection_remarks, ssproper_waste_collection_mandatory, proper_waste_collection_mandatory);
        boolean d = validateFields(ch_external_site_standards, etexternal_site_standards_remarks, external_site_standards_remarks, ssexternal_site_standards_mandatory, external_site_standards_mandatory);

        TeaWarehouseManInspectionBus teaWarehouseManInspectionBus = TeaWarehouseManInspectionBus.getInstance();
        teaWarehouseManInspectionBus.setSufficient_ventilation(str_sufficient_ventilation);
        teaWarehouseManInspectionBus.setSufficient_ventilation_mandatory(sufficient_ventilation_mandatory);
        teaWarehouseManInspectionBus.setSufficient_ventilation_remarks(sufficient_ventilation_remarks);
        teaWarehouseManInspectionBus.setAdequate_services(str_adequate_services);
        teaWarehouseManInspectionBus.setAdequate_services_mandatory(adequate_services_mandatory);
        teaWarehouseManInspectionBus.setAdequate_services_remarks(adequate_services_remarks);
        teaWarehouseManInspectionBus.setProper_waste_collection(str_proper_waste_collection);
        teaWarehouseManInspectionBus.setProper_waste_collection_mandatory(proper_waste_collection_mandatory);
        teaWarehouseManInspectionBus.setProper_waste_collection_remarks(proper_waste_collection_remarks);
        teaWarehouseManInspectionBus.setExternal_site_standards(str_external_site_standards);
        teaWarehouseManInspectionBus.setExternal_site_standards_mandatory(external_site_standards_mandatory);
        teaWarehouseManInspectionBus.setExternal_site_standards_remarks(external_site_standards_remarks);

        if(a && b && c && d) {
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
        sssufficient_ventilation_mandatory.setAdapter(regionAdapter);
        ssadequate_services_mandatory.setAdapter(regionAdapter);
        ssexternal_site_standards_mandatory.setAdapter(regionAdapter);

    }

    private void setList2Marks(List<View2Marks> dummy2Marks) {

        marksOf2List.add("- Required -");
        for (View2Marks regionWrapper : dummy2Marks) {
            marksOf2List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf2List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssproper_waste_collection_mandatory.setAdapter(regionAdapter);

    }

    private void setList5Marks(List<View5Marks> dummy5Marks) {

        marksOf5List.add("- Required -");
        for (View5Marks regionWrapper : dummy5Marks) {
            marksOf5List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf5List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
//        ssadequateandcleanpersonalprot5mks.setAdapter(regionAdapter);
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
