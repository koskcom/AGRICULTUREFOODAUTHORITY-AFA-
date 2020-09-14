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
public class AFAComplianceWithCodeOfHygienePart3 extends Fragment implements BlockingStep {

    @BindView(R.id.ch_documented_cleaning_programs)
    CheckBox ch_documented_cleaning_programs;
    @BindView(R.id.ssdocumented_cleaning_programs_mandatory)
    SearchableSpinner ssdocumented_cleaning_programs_mandatory;
    @BindView(R.id.etdocumented_cleaning_programs_remarks)
    CustomEditText etdocumented_cleaning_programs_remarks;

    @BindView(R.id.ch_cleaning_records_kept)
    CheckBox ch_cleaning_records_kept;
    @BindView(R.id.sscleaning_records_kept_mandatory)
    SearchableSpinner sscleaning_records_kept_mandatory;
    @BindView(R.id.etcleaning_records_kept_remarks)
    CustomEditText etcleaning_records_kept_remarks;


    @BindView(R.id.ch_segregation_and_labelling)
    CheckBox ch_segregation_and_labelling;
    @BindView(R.id.sssegregation_and_labelling_mandatory)
    SearchableSpinner sssegregation_and_labelling_mandatory;
    @BindView(R.id.etsegregation_and_labelling_remarks)
    CustomEditText etsegregation_and_labelling_remarks;


    @BindView(R.id.ch_are_all_pests_excluded)
    CheckBox ch_are_all_pests_excluded;
    @BindView(R.id.ssare_all_pests_excluded_mandatory)
    SearchableSpinner ssare_all_pests_excluded_mandatory;
    @BindView(R.id.etare_all_pests_excluded_remarks)
    CustomEditText etare_all_pests_excluded_remarks;


    @BindView(R.id.ch_up_to_date_bait_map)
    CheckBox ch_up_to_date_bait_map;
    @BindView(R.id.ssup_to_date_bait_map_mandatory)
    SearchableSpinner ssup_to_date_bait_map_mandatory;
    @BindView(R.id.etup_to_date_bait_map_remarks)
    CustomEditText etup_to_date_bait_map_remarks;

    private ArrayList<String> marksOf2List = new ArrayList<>();
    private ArrayList<String> marksOf1List = new ArrayList<>();
    private ArrayList<String> marksOf5List = new ArrayList<>();
    private ArrayList<String> marksOf10List = new ArrayList<>();

    private String Savestring = "N";

    private String str_documented_cleaning_programs, str_cleaning_records_kept, str_segregation_and_labelling, str_are_all_pests_excluded, str_up_to_date_bait_map;
    private String documented_cleaning_programs_mandatory, cleaning_records_kept_mandatory, segregation_and_labelling_mandatory, are_all_pests_excluded_mandatory, up_to_date_bait_map_mandatory;


    public AFAComplianceWithCodeOfHygienePart3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afacompliance_with_code_of_hygiene_part3, container, false);
        ButterKnife.bind(this, view);

        // todo - change setList5Marks to setList3Marks
        setList1Marks(getDummy1Marks());
        setList2Marks(getDummy2Marks());
        setList5Marks(getDummy5Marks());
        setList10Marks(getDummy10Marks());

        ch_documented_cleaning_programs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_documented_cleaning_programs.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_documented_cleaning_programs = Savestring;

            }
        });

        ch_cleaning_records_kept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_cleaning_records_kept.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_cleaning_records_kept = Savestring;

            }
        });

        ch_segregation_and_labelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_segregation_and_labelling.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_segregation_and_labelling = Savestring;

            }
        });

        ch_are_all_pests_excluded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_are_all_pests_excluded.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_are_all_pests_excluded = Savestring;

            }
        });

        ch_up_to_date_bait_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_up_to_date_bait_map.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_up_to_date_bait_map = Savestring;

            }
        });

        ssdocumented_cleaning_programs_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                documented_cleaning_programs_mandatory = ssdocumented_cleaning_programs_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sscleaning_records_kept_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cleaning_records_kept_mandatory = sscleaning_records_kept_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sssegregation_and_labelling_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                segregation_and_labelling_mandatory = sssegregation_and_labelling_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssare_all_pests_excluded_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                are_all_pests_excluded_mandatory = ssare_all_pests_excluded_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssup_to_date_bait_map_mandatory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                up_to_date_bait_map_mandatory = ssup_to_date_bait_map_mandatory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        String documented_cleaning_programs_remarks = Objects.requireNonNull(etdocumented_cleaning_programs_remarks.getText()).toString().trim();
        String cleaning_records_kept_remarks = Objects.requireNonNull(etcleaning_records_kept_remarks.getText()).toString().trim();
        String segregation_and_labelling_remarks = Objects.requireNonNull(etsegregation_and_labelling_remarks.getText()).toString().trim();
        String are_all_pests_excluded_remarks = Objects.requireNonNull(etare_all_pests_excluded_remarks.getText()).toString().trim();
        String up_to_date_bait_map_remarks= Objects.requireNonNull(etup_to_date_bait_map_remarks.getText()).toString().trim();

        boolean a = validateFields(ch_documented_cleaning_programs, etdocumented_cleaning_programs_remarks, documented_cleaning_programs_remarks, ssdocumented_cleaning_programs_mandatory, documented_cleaning_programs_mandatory);
        boolean b = validateFields(ch_cleaning_records_kept, etcleaning_records_kept_remarks, cleaning_records_kept_remarks, sscleaning_records_kept_mandatory, cleaning_records_kept_mandatory);
        boolean c = validateFields(ch_segregation_and_labelling, etsegregation_and_labelling_remarks, segregation_and_labelling_remarks, sssegregation_and_labelling_mandatory, segregation_and_labelling_mandatory);
        boolean d = validateFields(ch_are_all_pests_excluded, etare_all_pests_excluded_remarks, are_all_pests_excluded_remarks, ssare_all_pests_excluded_mandatory, are_all_pests_excluded_mandatory);
        boolean e = validateFields(ch_up_to_date_bait_map, etup_to_date_bait_map_remarks, up_to_date_bait_map_remarks, ssup_to_date_bait_map_mandatory, up_to_date_bait_map_mandatory);

        TeaWarehouseManInspectionBus teaWarehouseManInspectionBus = TeaWarehouseManInspectionBus.getInstance();
        teaWarehouseManInspectionBus.setDocumented_cleaning_programs(str_documented_cleaning_programs);
        teaWarehouseManInspectionBus.setDocumented_cleaning_programs_mandatory(documented_cleaning_programs_mandatory);
        teaWarehouseManInspectionBus.setDocumented_cleaning_programs_remarks(documented_cleaning_programs_remarks);
        teaWarehouseManInspectionBus.setCleaning_records_kept(str_cleaning_records_kept);
        teaWarehouseManInspectionBus.setCleaning_records_kept_mandatory(cleaning_records_kept_mandatory);
        teaWarehouseManInspectionBus.setCleaning_records_kept_remarks(cleaning_records_kept_remarks);
        teaWarehouseManInspectionBus.setSegregation_and_labelling(str_segregation_and_labelling);
        teaWarehouseManInspectionBus.setSegregation_and_labelling_mandatory(segregation_and_labelling_mandatory);
        teaWarehouseManInspectionBus.setSegregation_and_labelling_remarks(segregation_and_labelling_remarks);
        teaWarehouseManInspectionBus.setAre_all_pests_excluded(str_are_all_pests_excluded);
        teaWarehouseManInspectionBus.setAre_all_pests_excluded_mandatory(are_all_pests_excluded_mandatory);
        teaWarehouseManInspectionBus.setAre_all_pests_excluded_remarks(are_all_pests_excluded_remarks);
        teaWarehouseManInspectionBus.setUp_to_date_bait_map(str_up_to_date_bait_map);
        teaWarehouseManInspectionBus.setUp_to_date_bait_map_mandatory(up_to_date_bait_map_mandatory);
        teaWarehouseManInspectionBus.setUp_to_date_bait_map_remarks(up_to_date_bait_map_remarks);

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
        ssdocumented_cleaning_programs_mandatory.setAdapter(regionAdapter);
        ssup_to_date_bait_map_mandatory.setAdapter(regionAdapter);

    }

    private void setList2Marks(List<View2Marks> dummy2Marks) {

        marksOf2List.add("- Required -");
        for (View2Marks regionWrapper : dummy2Marks) {
            marksOf2List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf2List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        sscleaning_records_kept_mandatory.setAdapter(regionAdapter);
        sssegregation_and_labelling_mandatory.setAdapter(regionAdapter);

    }

    private void setList5Marks(List<View5Marks> dummy5Marks) {

        marksOf5List.add("- Required -");
        for (View5Marks regionWrapper : dummy5Marks) {
            marksOf5List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf5List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssare_all_pests_excluded_mandatory.setAdapter(regionAdapter);
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
        listViewItems.add(new View5Marks("3"));
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
