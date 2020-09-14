package co.ke.bsl.ui.views.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.R;
import co.ke.bsl.data.view.PyrethrumInspectionBus;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAPyrethrumInspectionStep3 extends Fragment implements BlockingStep {

    @BindView(R.id.ch_accessibility_of_nursery_site)
    CheckBox ch_accessibility_of_nursery_site;
    @BindView(R.id.etaccessibility_of_nursery_site_evidence)
    CustomEditText etaccessibility_of_nursery_site_evidence;
    @BindView(R.id.etaccessibility_of_nursery_site_remarks)
    CustomEditText etaccessibility_of_nursery_site_remarks;

    @BindView(R.id.ch_clearance_letter_from_supplier)
    CheckBox ch_clearance_letter_from_supplier;
    @BindView(R.id.etclearance_letter_from_supplier_evidence)
    CustomEditText etclearance_letter_from_supplier_evidence;
    @BindView(R.id.etclearance_letter_from_supplier_remarks)
    CustomEditText etclearance_letter_from_supplier_remarks;

    @BindView(R.id.ch_adequate_knowledge)
    CheckBox ch_adequate_knowledge;
    @BindView(R.id.etadequate_knowledge_evidence)
    CustomEditText etadequate_knowledge_evidence;
    @BindView(R.id.etadequate_knowledge_remarks)
    CustomEditText etadequate_knowledge_remarks;

    @BindView(R.id.ch_age_of_crop)
    CheckBox ch_age_of_crop;
    @BindView(R.id.etage_of_crop_date_planted)
    CustomEditText etage_of_crop_date_planted;
    @BindView(R.id.etage_of_crop_remarks)
    CustomEditText etage_of_crop_remarks;

    @BindView(R.id.ch_source_of_planting_materials)
    CheckBox ch_source_of_planting_materials;
    @BindView(R.id.etsource_of_planting_materials_evidence)
    CustomEditText etsource_of_planting_materials_evidence;
    @BindView(R.id.etsource_of_planting_materials_remarks)
    CustomEditText etsource_of_planting_materials_remarks;

    @BindView(R.id.ch_phenotypic_characteristics)
    CheckBox ch_phenotypic_characteristics;
    @BindView(R.id.etphenotypic_characteristics_evidence)
    CustomEditText etphenotypic_characteristics_evidence;
    @BindView(R.id.etphenotypic_characteristics_remarks)
    CustomEditText etphenotypic_characteristics_remarks;

    private String Savestring = "N";
    final Calendar myCalendar = Calendar.getInstance();

    private String str_accessibility_of_nursery_site, str_clearance_letter_from_supplier, str_adequate_knowledge, str_age_of_crop, str_source_of_planting_materials, str_phenotypic_characteristics;


    public AFAPyrethrumInspectionStep3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afapyrethrum_inspection_step3, container, false);
        ButterKnife.bind(this, view);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        etage_of_crop_date_planted.setKeyListener(null);
        etage_of_crop_date_planted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        ch_accessibility_of_nursery_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_accessibility_of_nursery_site.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_accessibility_of_nursery_site = Savestring;

            }
        });

        ch_clearance_letter_from_supplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_clearance_letter_from_supplier.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_clearance_letter_from_supplier = Savestring;

            }
        });

        ch_adequate_knowledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_adequate_knowledge.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_adequate_knowledge = Savestring;

            }
        });

        ch_age_of_crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_age_of_crop.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_age_of_crop = Savestring;

            }
        });

        ch_source_of_planting_materials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_source_of_planting_materials.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_source_of_planting_materials = Savestring;

            }
        });

        ch_phenotypic_characteristics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch_phenotypic_characteristics.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }

                str_phenotypic_characteristics = Savestring;

            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String accessibility_of_nursery_site_evidence = Objects.requireNonNull(etaccessibility_of_nursery_site_evidence.getText()).toString().trim();
        String accessibility_of_nursery_site_remarks = Objects.requireNonNull(etaccessibility_of_nursery_site_remarks.getText()).toString().trim();
        String clearance_letter_from_supplier_evidence = Objects.requireNonNull(etclearance_letter_from_supplier_evidence.getText()).toString().trim();
        String clearance_letter_from_supplier_remarks = Objects.requireNonNull(etclearance_letter_from_supplier_remarks.getText()).toString().trim();
        String adequate_knowledge_evidence = Objects.requireNonNull(etadequate_knowledge_evidence.getText()).toString().trim();
        String adequate_knowledge_remarks = Objects.requireNonNull(etadequate_knowledge_remarks.getText()).toString().trim();
        String age_of_crop_date_planted = Objects.requireNonNull(etage_of_crop_date_planted.getText()).toString().trim();
        String age_of_crop_remarks = Objects.requireNonNull(etage_of_crop_remarks.getText()).toString().trim();
        String source_of_planting_materials_evidence = Objects.requireNonNull(etsource_of_planting_materials_evidence.getText()).toString().trim();
        String source_of_planting_materials_remarks = Objects.requireNonNull(etsource_of_planting_materials_remarks.getText()).toString().trim();
        String phenotypic_characteristics_evidence = Objects.requireNonNull(etphenotypic_characteristics_evidence.getText()).toString().trim();
        String phenotypic_characteristics_remarks = Objects.requireNonNull(etphenotypic_characteristics_remarks.getText()).toString().trim();

        boolean valid = validateFields(ch_accessibility_of_nursery_site, etaccessibility_of_nursery_site_remarks, accessibility_of_nursery_site_remarks) &
                validateFields(ch_clearance_letter_from_supplier, etclearance_letter_from_supplier_remarks, clearance_letter_from_supplier_remarks) &
                validateFields(ch_adequate_knowledge, etadequate_knowledge_remarks, adequate_knowledge_remarks) &
                validateFields(ch_age_of_crop, etage_of_crop_remarks, age_of_crop_remarks) &
                validateFields(ch_source_of_planting_materials, etsource_of_planting_materials_remarks, source_of_planting_materials_remarks) &
                validateFields(ch_phenotypic_characteristics, etphenotypic_characteristics_remarks, phenotypic_characteristics_remarks);


        PyrethrumInspectionBus pyrethrumInspectionBus = PyrethrumInspectionBus.getInstance();
        pyrethrumInspectionBus.setAccessibility_of_nursery_site(str_accessibility_of_nursery_site);
        pyrethrumInspectionBus.setAccessibility_of_nursery_site_evidence(accessibility_of_nursery_site_evidence);
        pyrethrumInspectionBus.setAccessibility_of_nursery_site_remarks(accessibility_of_nursery_site_remarks);
        pyrethrumInspectionBus.setClearance_letter(str_clearance_letter_from_supplier);
        pyrethrumInspectionBus.setClearance_letter_evidence(clearance_letter_from_supplier_evidence);
        pyrethrumInspectionBus.setClearance_letter_remarks(clearance_letter_from_supplier_remarks);
        pyrethrumInspectionBus.setAdequate_knowledge(str_adequate_knowledge);
        pyrethrumInspectionBus.setDemonstrate_adequate_knowledge(adequate_knowledge_evidence);
        pyrethrumInspectionBus.setDemonstrate_adequate_knowledge_remarks(adequate_knowledge_remarks);
        pyrethrumInspectionBus.setAge_of_an_existing_crop(str_age_of_crop);
        pyrethrumInspectionBus.setAge_of_an_existing_crop_date_planted(age_of_crop_date_planted);
        pyrethrumInspectionBus.setAge_of_an_existing_crop_remarks(age_of_crop_remarks);
        pyrethrumInspectionBus.setSource_of_planting_materials(str_source_of_planting_materials);
        pyrethrumInspectionBus.setSource_of_planting_materials_evidence(source_of_planting_materials_evidence);
        pyrethrumInspectionBus.setSource_of_planting_materials_remarks(source_of_planting_materials_remarks);
        pyrethrumInspectionBus.setPhenotypic_characteristics(str_phenotypic_characteristics);
        pyrethrumInspectionBus.setPhenotypic_characteristics_evidence(phenotypic_characteristics_evidence);
        pyrethrumInspectionBus.setPhenotypic_characteristics_remarks(phenotypic_characteristics_remarks);

        if (valid){
            callback.goToNextStep();

        }

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

    }private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etage_of_crop_date_planted.setText(sdf.format(myCalendar.getTime()));
    }
}
