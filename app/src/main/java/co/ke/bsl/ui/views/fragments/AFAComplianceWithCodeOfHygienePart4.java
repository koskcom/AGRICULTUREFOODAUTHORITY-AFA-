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
public class AFAComplianceWithCodeOfHygienePart4 extends Fragment implements BlockingStep {

    @BindView(R.id.ch_inspection_at_least)
    CheckBox ch_inspection_at_least;
    @BindView(R.id.ssinspection_at_least_mandatory)
    SearchableSpinner ssinspection_at_least_mandatory;
    @BindView(R.id.etinspection_at_least_remarks)
    CustomEditText etinspection_at_least_remarks;

    @BindView(R.id.ch_precaution_to_prevent)
    CheckBox ch_precaution_to_prevent;
    @BindView(R.id.ssprecaution_to_prevent_mandatory)
    SearchableSpinner ssprecaution_to_prevent_mandatory;
    @BindView(R.id.etprecaution_to_prevent_remarks)
    CustomEditText etprecaution_to_prevent_remarks;


    @BindView(R.id.ch_storage_distribution_and_transportation)
    CheckBox ch_storage_distribution_and_transportation;
    @BindView(R.id.ssstorage_distribution_and_transportation_mandatory)
    SearchableSpinner ssstorage_distribution_and_transportation_mandatory;
    @BindView(R.id.etstorage_distribution_and_transportation_remarks)
    CustomEditText etstorage_distribution_and_transportation_remarks;


    @BindView(R.id.ch_walls_and_partitions)
    CheckBox ch_walls_and_partitions;
    @BindView(R.id.sswalls_and_partitions_mandatory)
    SearchableSpinner sswalls_and_partitions_mandatory;
    @BindView(R.id.etwalls_and_partitions_remarks)
    CustomEditText etwalls_and_partitions_remarks;


    @BindView(R.id.ch_procedure_for_inspection)
    CheckBox ch_procedure_for_inspection;
    @BindView(R.id.ssprocedure_for_inspection_mandatory)
    SearchableSpinner ssprocedure_for_inspection_mandatory;
    @BindView(R.id.etprocedure_for_inspection_remarks)
    CustomEditText etprocedure_for_inspection_remarks;


    @BindView(R.id.ch_proper_segregation_of_materials)
    CheckBox ch_proper_segregation_of_materials;
    @BindView(R.id.ssproper_segregation_of_materials_mandatory)
    SearchableSpinner ssproper_segregation_of_materials_mandatory;
    @BindView(R.id.etproper_segregation_of_materials_remarks)
    CustomEditText etproper_segregation_of_materials_remarks;


    @BindView(R.id.ch_security_access_control)
    CheckBox ch_security_access_control;
    @BindView(R.id.sssecurity_access_control_mandatory)
    SearchableSpinner sssecurity_access_control_mandatory;
    @BindView(R.id.etsecurity_access_control_remarks)
    CustomEditText etsecurity_access_control_remarks;

    private ArrayList<String> marksOf2List = new ArrayList<>();
    private ArrayList<String> marksOf1List = new ArrayList<>();
    private ArrayList<String> marksOf5List = new ArrayList<>();
    private ArrayList<String> marksOf10List = new ArrayList<>();

    private String Savestring = "N";

    private String str_inspection_at_least, str_precaution_to_prevent, str_storage_distribution_and_transportation, str_walls_and_partitions, str_procedure_for_inspection, str_proper_segregation_of_materials, str_security_access_control;
    private String inspection_at_least_mandatory, precaution_to_prevent_mandatory, storage_distribution_and_transportation_mandatory, walls_and_partitions_mandatory, procedure_for_inspection_mandatory, proper_segregation_of_materials_mandatory, security_access_control_mandatory;


    public AFAComplianceWithCodeOfHygienePart4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afacompliance_with_code_of_hygiene_part4, container, false);
        ButterKnife.bind(this, view);

        setList1Marks(getDummy1Marks());
        setList2Marks(getDummy2Marks());
        setList5Marks(getDummy5Marks());
        setList10Marks(getDummy10Marks());

        ch_inspection_at_least.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_inspection_at_least.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_inspection_at_least = Savestring;

            }
        });

        ch_precaution_to_prevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_precaution_to_prevent.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_precaution_to_prevent = Savestring;

            }
        });

        ch_storage_distribution_and_transportation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_storage_distribution_and_transportation.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_storage_distribution_and_transportation = Savestring;

            }
        });

        ch_walls_and_partitions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_walls_and_partitions.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_walls_and_partitions = Savestring;

            }
        });

        ch_procedure_for_inspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_procedure_for_inspection.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_procedure_for_inspection = Savestring;

            }
        });

        ch_proper_segregation_of_materials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_proper_segregation_of_materials.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_proper_segregation_of_materials = Savestring;

            }
        });

        ch_security_access_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_security_access_control.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_security_access_control = Savestring;

            }
        });

        ssinspection_at_least_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inspection_at_least_mandatory = ssinspection_at_least_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssprecaution_to_prevent_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                precaution_to_prevent_mandatory = ssprecaution_to_prevent_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssstorage_distribution_and_transportation_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                storage_distribution_and_transportation_mandatory = ssstorage_distribution_and_transportation_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sswalls_and_partitions_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                walls_and_partitions_mandatory = sswalls_and_partitions_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssprocedure_for_inspection_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                procedure_for_inspection_mandatory = ssprocedure_for_inspection_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssproper_segregation_of_materials_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                proper_segregation_of_materials_mandatory = ssproper_segregation_of_materials_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sssecurity_access_control_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                security_access_control_mandatory = sssecurity_access_control_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        String inspection_at_least_remarks = Objects.requireNonNull(etinspection_at_least_remarks.getText()).toString().trim();
        String precaution_to_prevent_remarks = Objects.requireNonNull(etprecaution_to_prevent_remarks.getText()).toString().trim();
        String storage_distribution_and_transportation_remarks = Objects.requireNonNull(etstorage_distribution_and_transportation_remarks.getText()).toString().trim();
        String walls_and_partitions_remarks = Objects.requireNonNull(etwalls_and_partitions_remarks.getText()).toString().trim();
        String procedure_for_inspection_remarks= Objects.requireNonNull(etprocedure_for_inspection_remarks.getText()).toString().trim();
        String proper_segregation_of_materials_remarks= Objects.requireNonNull(etproper_segregation_of_materials_remarks.getText()).toString().trim();
        String security_access_control_remarks= Objects.requireNonNull(etsecurity_access_control_remarks.getText()).toString().trim();

        boolean a = validateFields(ch_inspection_at_least, etinspection_at_least_remarks, inspection_at_least_remarks, ssinspection_at_least_mandatory, inspection_at_least_mandatory);
        boolean b = validateFields(ch_precaution_to_prevent, etprecaution_to_prevent_remarks, precaution_to_prevent_remarks, ssprecaution_to_prevent_mandatory, precaution_to_prevent_mandatory);
        boolean c = validateFields(ch_storage_distribution_and_transportation, etstorage_distribution_and_transportation_remarks, storage_distribution_and_transportation_remarks, ssstorage_distribution_and_transportation_mandatory, storage_distribution_and_transportation_mandatory);
        boolean d = validateFields(ch_walls_and_partitions, etwalls_and_partitions_remarks, walls_and_partitions_remarks, sswalls_and_partitions_mandatory, walls_and_partitions_mandatory);
        boolean e = validateFields(ch_procedure_for_inspection, etprocedure_for_inspection_remarks, procedure_for_inspection_remarks, ssprocedure_for_inspection_mandatory, procedure_for_inspection_mandatory);
        boolean f = validateFields(ch_proper_segregation_of_materials, etproper_segregation_of_materials_remarks, proper_segregation_of_materials_remarks, ssproper_segregation_of_materials_mandatory, proper_segregation_of_materials_mandatory);
        boolean g = validateFields(ch_security_access_control, etsecurity_access_control_remarks, security_access_control_remarks, sssecurity_access_control_mandatory, security_access_control_mandatory);

        TeaWarehouseManInspectionBus teaWarehouseManInspectionBus = TeaWarehouseManInspectionBus.getInstance();
        teaWarehouseManInspectionBus.setInspection_every_three_months(str_inspection_at_least);
        teaWarehouseManInspectionBus.setInspection_every_three_months_mandatory(inspection_at_least_mandatory);
        teaWarehouseManInspectionBus.setInspection_every_three_months_remarks(inspection_at_least_remarks);
        teaWarehouseManInspectionBus.setPrecaution_to_prevent(str_precaution_to_prevent);
        teaWarehouseManInspectionBus.setPrecaution_to_prevent_mandatory(precaution_to_prevent_mandatory);
        teaWarehouseManInspectionBus.setPrecaution_to_prevent_remarks(precaution_to_prevent_remarks);
        teaWarehouseManInspectionBus.setStorage_distribution_and_transportation(str_storage_distribution_and_transportation);
        teaWarehouseManInspectionBus.setStorage_distribution_and_transportation_mandatory(storage_distribution_and_transportation_mandatory);
        teaWarehouseManInspectionBus.setStorage_distribution_and_transportation_remarks(storage_distribution_and_transportation_remarks);
        teaWarehouseManInspectionBus.setWalls_and_partitions(str_walls_and_partitions);
        teaWarehouseManInspectionBus.setWalls_and_partitions_mandatory(walls_and_partitions_mandatory);
        teaWarehouseManInspectionBus.setWalls_and_partitions_remarks(walls_and_partitions_remarks);
        teaWarehouseManInspectionBus.setProcedure_for_inspection(str_procedure_for_inspection);
        teaWarehouseManInspectionBus.setProcedure_for_inspection_mandatory(procedure_for_inspection_mandatory);
        teaWarehouseManInspectionBus.setProcedure_for_inspection_remarks(procedure_for_inspection_remarks);
        teaWarehouseManInspectionBus.setProper_segregation_of_materials(str_proper_segregation_of_materials);
        teaWarehouseManInspectionBus.setProper_segregation_of_materials_mandatory(proper_segregation_of_materials_mandatory);
        teaWarehouseManInspectionBus.setProper_segregation_of_materials_remarks(proper_segregation_of_materials_remarks);
        teaWarehouseManInspectionBus.setSecurity_access_control(str_security_access_control);
        teaWarehouseManInspectionBus.setSecurity_access_control_mandatory(security_access_control_mandatory);
        teaWarehouseManInspectionBus.setSecurity_access_control_remarks(security_access_control_remarks);

        if(a && b && c && d && e && f && g) {
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
        sswalls_and_partitions_mandatory.setAdapter(regionAdapter);
        ssprocedure_for_inspection_mandatory.setAdapter(regionAdapter);

    }

    private void setList2Marks(List<View2Marks> dummy2Marks) {

        marksOf2List.add("- Required -");
        for (View2Marks regionWrapper : dummy2Marks) {
            marksOf2List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf2List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssinspection_at_least_mandatory.setAdapter(regionAdapter);
        ssstorage_distribution_and_transportation_mandatory.setAdapter(regionAdapter);
        ssprecaution_to_prevent_mandatory.setAdapter(regionAdapter);
        ssproper_segregation_of_materials_mandatory.setAdapter(regionAdapter);
        sssecurity_access_control_mandatory.setAdapter(regionAdapter);

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
