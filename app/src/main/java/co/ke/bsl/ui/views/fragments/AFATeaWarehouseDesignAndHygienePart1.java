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
public class AFATeaWarehouseDesignAndHygienePart1 extends Fragment implements BlockingStep {

    @BindView(R.id.ch_walls)
    CheckBox ch_walls;
    @BindView(R.id.sswalls_mandatory)
    SearchableSpinner sswalls_mandatory;
    @BindView(R.id.etwalls_remarks)
    CustomEditText etwalls_remarks;

    @BindView(R.id.ch_floors)
    CheckBox ch_floors;
    @BindView(R.id.ssfloors_mandatory)
    SearchableSpinner ssfloors_mandatory;
    @BindView(R.id.etfloors_remarks)
    CustomEditText etfloors_remarks;


    @BindView(R.id.ch_roof_ceiling_and_overhead)
    CheckBox ch_roof_ceiling_and_overhead;
    @BindView(R.id.ssroof_ceiling_and_overhead_mandatory)
    SearchableSpinner ssroof_ceiling_and_overhead_mandatory;
    @BindView(R.id.etroof_ceiling_and_overhead_remarks)
    CustomEditText etroof_ceiling_and_overhead_remarks;


    @BindView(R.id.ch_windows)
    CheckBox ch_windows;
    @BindView(R.id.sswindows_mandatory)
    SearchableSpinner sswindows_mandatory;
    @BindView(R.id.etwindows_remarks)
    CustomEditText etwindows_remarks;


    @BindView(R.id.ch_doors)
    CheckBox ch_doors;
    @BindView(R.id.ssdoors_mandatory)
    SearchableSpinner ssdoors_mandatory;
    @BindView(R.id.etdoors_remarks)
    CustomEditText etdoors_remarks;


    @BindView(R.id.ch_protection_of_light_tubes_bulbs)
    CheckBox ch_protection_of_light_tubes;
    @BindView(R.id.ssprotection_of_light_tubes_bulbs_mandatory)
    SearchableSpinner ssprotection_of_light_tubes_bulbs_mandatory;
    @BindView(R.id.etprotection_of_light_tubes_bulbs_remarks)
    CustomEditText etprotection_of_light_tubes_remarks;

    private ArrayList<String> marksOf2List = new ArrayList<>();
    private ArrayList<String> marksOf1List = new ArrayList<>();
    private ArrayList<String> marksOf5List = new ArrayList<>();
    private ArrayList<String> marksOf10List = new ArrayList<>();

    private String Savestring = "N";

    private String str_walls, str_floors, str_roof_ceiling_and_overhead, str_windows, str_doors, str_protection_of_light_tubes;
    private String walls_mandatory, floors_mandatory, roof_ceiling_and_overhead_mandatory, windows_mandatory, doors_mandatory, protection_of_light_tubes_mandatory;



    public AFATeaWarehouseDesignAndHygienePart1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afatea_warehouse_design_and_hygiene_part1, container, false);
        ButterKnife.bind(this, view);

        setList1Marks(getDummy1Marks());
        setList2Marks(getDummy2Marks());
        setList5Marks(getDummy5Marks());
        setList10Marks(getDummy10Marks());

        ch_walls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_walls.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_walls = Savestring;

            }
        });

        ch_floors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_floors.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_floors = Savestring;

            }
        });

        ch_roof_ceiling_and_overhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_roof_ceiling_and_overhead.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_roof_ceiling_and_overhead = Savestring;

            }
        });

        ch_windows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_windows.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_windows = Savestring;

            }
        });

        ch_doors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_doors.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_doors = Savestring;

            }
        });

        ch_protection_of_light_tubes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_protection_of_light_tubes.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_protection_of_light_tubes = Savestring;

            }
        });

        sswalls_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                walls_mandatory = sswalls_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssfloors_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                floors_mandatory = ssfloors_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssroof_ceiling_and_overhead_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                roof_ceiling_and_overhead_mandatory = ssroof_ceiling_and_overhead_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sswindows_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                windows_mandatory = sswindows_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssdoors_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                doors_mandatory = ssdoors_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssprotection_of_light_tubes_bulbs_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                protection_of_light_tubes_mandatory = ssprotection_of_light_tubes_bulbs_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String walls_remarks = Objects.requireNonNull(etwalls_remarks.getText()).toString().trim();
        String floors_remarks = Objects.requireNonNull(etfloors_remarks.getText()).toString().trim();
        String roof_ceiling_and_overhead_remarks = Objects.requireNonNull(etroof_ceiling_and_overhead_remarks.getText()).toString().trim();
        String windows_remarks = Objects.requireNonNull(etwindows_remarks.getText()).toString().trim();
        String doors_remarks= Objects.requireNonNull(etdoors_remarks.getText()).toString().trim();
        String protection_of_light_tubes_remarks= Objects.requireNonNull(etprotection_of_light_tubes_remarks.getText()).toString().trim();

        boolean a = validateFields(ch_walls, etwalls_remarks, walls_remarks, sswalls_mandatory, walls_mandatory);
        boolean b = validateFields(ch_floors, etfloors_remarks, floors_remarks, ssfloors_mandatory, floors_mandatory);
        boolean c = validateFields(ch_roof_ceiling_and_overhead, etroof_ceiling_and_overhead_remarks, roof_ceiling_and_overhead_remarks, ssroof_ceiling_and_overhead_mandatory, roof_ceiling_and_overhead_mandatory);
        boolean d = validateFields(ch_windows, etwindows_remarks, windows_remarks, sswindows_mandatory, windows_mandatory);
        boolean e = validateFields(ch_doors, etdoors_remarks, doors_remarks, ssdoors_mandatory, doors_mandatory);
        boolean f = validateFields(ch_protection_of_light_tubes, etprotection_of_light_tubes_remarks, protection_of_light_tubes_remarks, ssprotection_of_light_tubes_bulbs_mandatory, protection_of_light_tubes_mandatory);

        TeaWarehouseManInspectionBus teaWarehouseManInspectionBus = TeaWarehouseManInspectionBus.getInstance();
        teaWarehouseManInspectionBus.setWalls(str_walls);
        teaWarehouseManInspectionBus.setWalls_mandatory(walls_mandatory);
        teaWarehouseManInspectionBus.setWalls_remarks(walls_remarks);
        teaWarehouseManInspectionBus.setFloors(str_floors);
        teaWarehouseManInspectionBus.setFloors_mandatory(floors_mandatory);
        teaWarehouseManInspectionBus.setFloors_remarks(floors_remarks);
        teaWarehouseManInspectionBus.setRoof_ceiling_and_overhead(str_roof_ceiling_and_overhead);
        teaWarehouseManInspectionBus.setRoof_ceiling_and_overhead_mandatory(roof_ceiling_and_overhead_mandatory);
        teaWarehouseManInspectionBus.setRoof_ceiling_and_overhead_remarks(roof_ceiling_and_overhead_remarks);
        teaWarehouseManInspectionBus.setWindows(str_windows);
        teaWarehouseManInspectionBus.setWindows_mandatory(windows_mandatory);
        teaWarehouseManInspectionBus.setWindows_remarks(windows_remarks);
        teaWarehouseManInspectionBus.setDoors(str_doors);
        teaWarehouseManInspectionBus.setDoors_mandatory(doors_mandatory);
        teaWarehouseManInspectionBus.setDoors_remarks(doors_remarks);
        teaWarehouseManInspectionBus.setProtection_of_light_tubes(str_protection_of_light_tubes);
        teaWarehouseManInspectionBus.setProtection_of_light_tubes_mandatory(protection_of_light_tubes_mandatory);
        teaWarehouseManInspectionBus.setProtection_of_light_tubes_remarks(protection_of_light_tubes_remarks);

        if(a && b && c && d && e && f) {
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
        sswalls_mandatory.setAdapter(regionAdapter);
        ssfloors_mandatory.setAdapter(regionAdapter);
        ssroof_ceiling_and_overhead_mandatory.setAdapter(regionAdapter);
        sswindows_mandatory.setAdapter(regionAdapter);
        ssdoors_mandatory.setAdapter(regionAdapter);

    }

    private void setList2Marks(List<View2Marks> dummy2Marks) {

        marksOf2List.add("- Required -");
        for (View2Marks regionWrapper : dummy2Marks) {
            marksOf2List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf2List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssprotection_of_light_tubes_bulbs_mandatory.setAdapter(regionAdapter);

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
