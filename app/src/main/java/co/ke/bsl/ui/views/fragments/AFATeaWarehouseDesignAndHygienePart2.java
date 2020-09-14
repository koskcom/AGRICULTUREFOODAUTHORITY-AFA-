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
import android.widget.EditText;
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
public class AFATeaWarehouseDesignAndHygienePart2 extends Fragment implements BlockingStep {

    @BindView(R.id.ch_maintenance_programs)
    CheckBox ch_maintenance_programs;
    @BindView(R.id.ssmaintenance_programs_mandatory)
    SearchableSpinner ssmaintenance_programs_mandatory;
    @BindView(R.id.etmaintenance_programs_remarks)
    CustomEditText etmaintenance_programs_remarks;

    @BindView(R.id.ch_are_conveyor_belts_protected)
    CheckBox ch_are_conveyor_belts_protected;
    @BindView(R.id.ssare_conveyor_belts_protected_mandatory)
    SearchableSpinner ssare_conveyor_belts_protected_mandatory;
    @BindView(R.id.etare_conveyor_belts_protected_remarks)
    CustomEditText etare_conveyor_belts_protected_remarks;


    @BindView(R.id.ch_product_testing)
    CheckBox ch_product_testing;
    @BindView(R.id.ssproduct_testing_mandatory)
    SearchableSpinner ssproduct_testing_mandatory;
    @BindView(R.id.etproduct_testing_remarks)
    CustomEditText etproduct_testing_remarks;


    @BindView(R.id.ch_calibration_of_the_weighing_scale)
    CheckBox ch_calibration_of_weighing_scale;
    @BindView(R.id.sscalibration_of_the_weighing_scale_mandatory)
    SearchableSpinner sscalibration_of_the_weighing_scale_mandatory;
    @BindView(R.id.etcalibration_of_the_weighing_scale_remarks)
    CustomEditText etcalibration_of_weighing_scale_remarks;


    @BindView(R.id.ch_maintenance_records_maintained)
    CheckBox ch_maintenance_records_maintained;
    @BindView(R.id.ssmaintenance_records_maintained_mandatory)
    SearchableSpinner ssmaintenance_records_maintained_mandatory;
    @BindView(R.id.etmaintenance_records_maintained_remarks)
    CustomEditText etmaintenance_records_maintained_remarks;

    private ArrayList<String> marksOf2List = new ArrayList<>();
    private ArrayList<String> marksOf1List = new ArrayList<>();
    private ArrayList<String> marksOf5List = new ArrayList<>();
    private ArrayList<String> marksOf10List = new ArrayList<>();


    private String Savestring = "N";

    private String str_maintenance_programs, str_are_conveyor_belts_protected, str_product_testing, str_calibration_of_weighing_scale, str_maintenance_records_maintained;
    private String maintenance_programs_mandatory, are_conveyor_belts_protected_mandatory, product_testing_mandatory, calibration_of_weighing_scale_mandatory, maintenance_records_maintained_mandatory;



    public AFATeaWarehouseDesignAndHygienePart2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_afatea_warehouse_design_and_hygiene_part2, container, false);
        ButterKnife.bind(this, view);

        setList1Marks(getDummy1Marks());
        setList2Marks(getDummy2Marks());
        setList5Marks(getDummy5Marks());
        setList10Marks(getDummy10Marks());

        ch_maintenance_programs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_maintenance_programs.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_maintenance_programs = Savestring;

            }
        });

        ch_are_conveyor_belts_protected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_conveyor_belts_protected.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_are_conveyor_belts_protected = Savestring;

            }
        });

        ch_product_testing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_product_testing.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_product_testing = Savestring;

            }
        });

        ch_calibration_of_weighing_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_calibration_of_weighing_scale.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_calibration_of_weighing_scale = Savestring;

            }
        });

        ch_maintenance_records_maintained.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_maintenance_records_maintained.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_maintenance_records_maintained = Savestring;

            }
        });

        ssmaintenance_programs_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maintenance_programs_mandatory = ssmaintenance_programs_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssmaintenance_records_maintained_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maintenance_records_maintained_mandatory = ssmaintenance_records_maintained_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssare_conveyor_belts_protected_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                are_conveyor_belts_protected_mandatory = ssare_conveyor_belts_protected_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssproduct_testing_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                product_testing_mandatory = ssproduct_testing_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sscalibration_of_the_weighing_scale_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calibration_of_weighing_scale_mandatory = sscalibration_of_the_weighing_scale_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        String maintenance_programs_remarks = Objects.requireNonNull(etmaintenance_programs_remarks.getText()).toString().trim();
        String are_conveyor_belts_protected_remarks = Objects.requireNonNull(etare_conveyor_belts_protected_remarks.getText()).toString().trim();
        String product_testing_remarks = Objects.requireNonNull(etproduct_testing_remarks.getText()).toString().trim();
        String calibration_of_weighing_scale_remarks = Objects.requireNonNull(etcalibration_of_weighing_scale_remarks.getText()).toString().trim();
        String maintenance_records_maintained_remarks= Objects.requireNonNull(etmaintenance_records_maintained_remarks.getText()).toString().trim();

        boolean a = validateFields(ch_maintenance_programs, etmaintenance_programs_remarks, maintenance_programs_remarks, ssmaintenance_programs_mandatory, maintenance_programs_mandatory);
        boolean b = validateFields(ch_are_conveyor_belts_protected, etare_conveyor_belts_protected_remarks, are_conveyor_belts_protected_remarks, ssare_conveyor_belts_protected_mandatory, are_conveyor_belts_protected_mandatory);
        boolean c = validateFields(ch_product_testing, etproduct_testing_remarks, product_testing_remarks, ssproduct_testing_mandatory, product_testing_mandatory);
        boolean d = validateFields(ch_calibration_of_weighing_scale, etcalibration_of_weighing_scale_remarks, calibration_of_weighing_scale_remarks, sscalibration_of_the_weighing_scale_mandatory, calibration_of_weighing_scale_mandatory);
        boolean e = validateFields(ch_maintenance_records_maintained, etmaintenance_records_maintained_remarks, maintenance_records_maintained_remarks, ssmaintenance_records_maintained_mandatory, maintenance_records_maintained_mandatory);

        TeaWarehouseManInspectionBus teaWarehouseManInspectionBus = TeaWarehouseManInspectionBus.getInstance();
        teaWarehouseManInspectionBus.setMaintenance_programs(str_maintenance_programs);
        teaWarehouseManInspectionBus.setMaintenance_programs_mandatory(maintenance_programs_mandatory);
        teaWarehouseManInspectionBus.setMaintenance_programs_remarks(maintenance_programs_remarks);
        teaWarehouseManInspectionBus.setAre_conveyor_belts_protected(str_are_conveyor_belts_protected);
        teaWarehouseManInspectionBus.setAre_conveyor_belts_protected_mandatory(are_conveyor_belts_protected_mandatory);
        teaWarehouseManInspectionBus.setAre_conveyor_belts_protected_remarks(are_conveyor_belts_protected_remarks);
        teaWarehouseManInspectionBus.setProduct_testing(str_product_testing);
        teaWarehouseManInspectionBus.setProduct_testing_mandatory(product_testing_mandatory);
        teaWarehouseManInspectionBus.setProduct_testing_remarks(product_testing_remarks);
        teaWarehouseManInspectionBus.setCalibration_of_weighing_scale(str_calibration_of_weighing_scale);
        teaWarehouseManInspectionBus.setCalibration_of_weighing_scale_mandatory(calibration_of_weighing_scale_mandatory);
        teaWarehouseManInspectionBus.setCalibration_of_weighing_scale_remarks(calibration_of_weighing_scale_remarks);
        teaWarehouseManInspectionBus.setMaintenance_records_maintained(str_maintenance_records_maintained);
        teaWarehouseManInspectionBus.setMaintenance_records_maintained_mandatory(maintenance_records_maintained_mandatory);
        teaWarehouseManInspectionBus.setMaintenance_records_maintained_remarks(maintenance_records_maintained_remarks);

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
        ssmaintenance_programs_mandatory.setAdapter(regionAdapter);
        ssare_conveyor_belts_protected_mandatory.setAdapter(regionAdapter);
        ssproduct_testing_mandatory.setAdapter(regionAdapter);
        sscalibration_of_the_weighing_scale_mandatory.setAdapter(regionAdapter);

    }

    private void setList2Marks(List<View2Marks> dummy2Marks) {

        marksOf2List.add("- Required -");
        for (View2Marks regionWrapper : dummy2Marks) {
            marksOf2List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf2List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssmaintenance_records_maintained_mandatory.setAdapter(regionAdapter);

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
}
