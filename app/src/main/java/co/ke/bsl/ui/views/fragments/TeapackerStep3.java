package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
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
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.TeaPackerBus;
import co.ke.bsl.data.view.View10Marks;
import co.ke.bsl.data.view.View1Marks;
import co.ke.bsl.data.view.View2Marks;
import co.ke.bsl.data.view.View3Marks;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeapackerStep3 extends Fragment implements BlockingStep {

    @BindView(R.id.isRoofCeiling)
    CheckBox isRoofCeiling;
    @BindView(R.id.ssroofCeilingMust3mks)
    SearchableSpinner ssroofCeilingMust3mks;
    @BindView(R.id.etroofCeilingRemarks)
    CustomEditText etroofCeilingRemarks;
    @BindView(R.id.isWindows)
    CheckBox isWindows;
    @BindView(R.id.sswindowsRecom1mk)
    SearchableSpinner sswindowsRecom1mk;
    @BindView(R.id.etwindowsRemarks)
    CustomEditText etwindowsRemarks;
    @BindView(R.id.isDoors)
    CheckBox isDoors;
    @BindView(R.id.ssdoorsRecom1mk)
    SearchableSpinner ssdoorsRecom1mk;
    @BindView(R.id.etdoorsRemarks)
    CustomEditText etdoorsRemarks;
    @BindView(R.id.isAdequatelighting)
    CheckBox isAdequatelighting;
    @BindView(R.id.ssadequateLightingMust3mks)
    SearchableSpinner ssadequateLightingMust3mks;
    @BindView(R.id.etadequateLightingRemarks)
    CustomEditText etadequateLightingRemarks;
    @BindView(R.id.isVentilation)
    CheckBox isVentilation;
    @BindView(R.id.ssventilationRecom1mks)
    SearchableSpinner ssventilationRecom1mks;
    @BindView(R.id.etventilationRemarks)
    CustomEditText etventilationRemarks;
    @BindView(R.id.isEquipmentCleanliness)
    CheckBox isEquipmentCleanliness;
    @BindView(R.id.ssequipmentCleanlinessMust3mks)
    SearchableSpinner ssequipmentCleanlinessMust3mks;
    @BindView(R.id.etequipmentCleanlinessRemarks)
    CustomEditText etequipmentCleanlinessRemarks;
    @BindView(R.id.isChangingrooms)
    CheckBox isChangingrooms;
    @BindView(R.id.ssChangingroomsMust3mks)
    SearchableSpinner ssChangingroomsMust3mks;
    @BindView(R.id.etChangingroomsRemarks)
    CustomEditText etChangingroomsRemarks;
    @BindView(R.id.isRiskOfChemical)
    CheckBox isRiskOfChemical;
    @BindView(R.id.ssriskOfChemicalMust3mks)
    SearchableSpinner ssriskOfChemicalMust3mks;
    @BindView(R.id.etriskOfChemicalRemarks)
    CustomEditText etriskOfChemicalRemarks;
    @BindView(R.id.isWasteTeaDisposal)
    CheckBox isWasteTeaDisposal;
    @BindView(R.id.sswasteTeaDisposalMust3mks)
    SearchableSpinner sswasteTeaDisposalMust3mks;
    @BindView(R.id.etwasteTeaDisposalRemarks)
    CustomEditText etwasteTeaDisposalRemarks;

    private String roofCeiling, roofCeilingMust3mks, roofCeilingRemarks, windows, windowsRecom1mk, windowsRemarks, doors, doorsRecom1mk, doorsRemarks, adequatelighting, adequateLightingMust3mks, adequateLightingRemarks, ventilation;
    private String ventilationRecom1mks, ventilationRemarks, equipmentCleanliness, equipmentCleanlinessMust3mks, equipmentCleanlinessRemarks, changingrooms, changingroomsMust3mks, changingroomsRemarks, riskOfChemical, riskOfChemicalMust3mks, riskOfChemicalRemarks, wasteTeaDisposal, wasteTeaDisposalMust3mks, wasteTeaDisposalRemarks;

    private String Savestring = "Y";
    AFADatabaseAdapter db;
    AFA app;
    private ArrayList<String> marksof10List = new ArrayList<>();
    private ArrayList<String> marksof1List = new ArrayList<>();
    private ArrayList<String> marksof2List = new ArrayList<>();
    private ArrayList<String> marksof3List = new ArrayList<>();
    private ArrayList<String> marksof5List = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teapacker_step3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        setList3marks(getdummy3marks());
        setList1marks(getdummy1marks());
        setList2marks(getdummy2marks());

        isRoofCeiling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRoofCeiling.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                roofCeiling = Savestring;
            }
        });

        isWindows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWindows.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                windows = Savestring;
            }
        });

        isDoors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDoors.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                doors = Savestring;
            }
        });

        isAdequatelighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAdequatelighting.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                adequatelighting = Savestring;
            }
        });

        isVentilation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isVentilation.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                ventilation = Savestring;
            }
        });

        isEquipmentCleanliness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEquipmentCleanliness.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                equipmentCleanliness = Savestring;
            }
        });

        isChangingrooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChangingrooms.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                changingrooms = Savestring;
            }
        });

        isRiskOfChemical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRiskOfChemical.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                riskOfChemical = Savestring;
            }
        });

        isWasteTeaDisposal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWasteTeaDisposal.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                wasteTeaDisposal = Savestring;
            }
        });

        return view;
    }


    private void setList3marks(List<View3Marks> getdummy3marks) {
        marksof3List.add("- Required -");
        for (View3Marks regionWrapper : getdummy3marks) {
            marksof3List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof3List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssroofCeilingMust3mks.setAdapter(regionAdapter);
        ssadequateLightingMust3mks.setAdapter(regionAdapter);
        ssChangingroomsMust3mks.setAdapter(regionAdapter);
        ssriskOfChemicalMust3mks.setAdapter(regionAdapter);
        sswasteTeaDisposalMust3mks.setAdapter(regionAdapter);
        ssequipmentCleanlinessMust3mks.setAdapter(regionAdapter);


    }

    private List<View3Marks> getdummy3marks() {
        List<View3Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View3Marks("0"));
        listViewItems.add(new View3Marks("3"));

        return listViewItems;
    }

    private void setList1marks(List<View1Marks> getdummy1marks) {
        marksof1List.add("- Required -");
        for (View1Marks regionWrapper : getdummy1marks) {
            marksof1List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof1List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssdoorsRecom1mk.setAdapter(regionAdapter);
        ssventilationRecom1mks.setAdapter(regionAdapter);
        sswindowsRecom1mk.setAdapter(regionAdapter);


    }

    private List<View1Marks> getdummy1marks() {
        List<View1Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View1Marks("0"));
        listViewItems.add(new View1Marks("1"));

        return listViewItems;
    }

    private void setList2marks(List<View2Marks> getdummy2marks) {
        marksof2List.add("- Required -");
        for (View2Marks regionWrapper : getdummy2marks) {
            marksof2List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof2List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
    }

    private List<View2Marks> getdummy2marks() {
        List<View2Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View2Marks("0"));
        listViewItems.add(new View2Marks("2"));

        return listViewItems;
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        roofCeilingMust3mks = Objects.requireNonNull(ssroofCeilingMust3mks.getSelectedItem()).toString().trim();
        roofCeilingRemarks = Objects.requireNonNull(etroofCeilingRemarks.getText()).toString().trim();
        windowsRecom1mk = Objects.requireNonNull(sswindowsRecom1mk.getSelectedItem()).toString().trim();
        windowsRemarks = Objects.requireNonNull(etwindowsRemarks.getText()).toString().trim();
        doorsRecom1mk = Objects.requireNonNull(ssdoorsRecom1mk.getSelectedItem()).toString().trim();
        doorsRemarks = Objects.requireNonNull(etdoorsRemarks.getText()).toString().trim();
        adequateLightingMust3mks = Objects.requireNonNull(ssadequateLightingMust3mks.getSelectedItem()).toString().trim();
        adequateLightingRemarks = Objects.requireNonNull(etadequateLightingRemarks.getText()).toString().trim();
        ventilationRecom1mks = Objects.requireNonNull(ssventilationRecom1mks.getSelectedItem()).toString().trim();
        ventilationRemarks = Objects.requireNonNull(etventilationRemarks.getText()).toString().trim();
        equipmentCleanlinessMust3mks = Objects.requireNonNull(ssequipmentCleanlinessMust3mks.getSelectedItem()).toString().trim();
        equipmentCleanlinessRemarks = Objects.requireNonNull(etequipmentCleanlinessRemarks.getText()).toString().trim();
        changingroomsMust3mks = Objects.requireNonNull(ssChangingroomsMust3mks.getSelectedItem()).toString().trim();
        changingroomsRemarks = Objects.requireNonNull(etChangingroomsRemarks.getText()).toString().trim();
        riskOfChemicalMust3mks = Objects.requireNonNull(ssriskOfChemicalMust3mks.getSelectedItem()).toString().trim();
        riskOfChemicalRemarks = Objects.requireNonNull(etriskOfChemicalRemarks.getText()).toString().trim();
        wasteTeaDisposalMust3mks = Objects.requireNonNull(sswasteTeaDisposalMust3mks.getSelectedItem()).toString().trim();
        wasteTeaDisposalRemarks = Objects.requireNonNull(etwasteTeaDisposalRemarks.getText()).toString().trim();

        boolean valid = validateFields(isRoofCeiling, etroofCeilingRemarks, roofCeilingRemarks, ssroofCeilingMust3mks, roofCeilingMust3mks) &
                validateFields(isWindows, etwindowsRemarks, windowsRemarks, sswindowsRecom1mk, windowsRecom1mk) &
                validateFields(isDoors, etdoorsRemarks, doorsRemarks, ssdoorsRecom1mk, doorsRecom1mk) &
                validateFields(isAdequatelighting, etadequateLightingRemarks, adequateLightingRemarks, ssadequateLightingMust3mks, adequateLightingMust3mks) &
                validateFields(isVentilation, etventilationRemarks, ventilationRemarks, ssventilationRecom1mks, ventilationRecom1mks) &
                validateFields(isEquipmentCleanliness, etequipmentCleanlinessRemarks, equipmentCleanlinessRemarks, ssequipmentCleanlinessMust3mks, equipmentCleanlinessMust3mks) &
                validateFields(isChangingrooms, etChangingroomsRemarks, changingroomsRemarks, ssChangingroomsMust3mks, changingroomsMust3mks) &
                validateFields(isRiskOfChemical, etriskOfChemicalRemarks, riskOfChemicalRemarks, ssriskOfChemicalMust3mks, riskOfChemicalMust3mks) &
                validateFields(isWasteTeaDisposal, etwasteTeaDisposalRemarks, wasteTeaDisposalRemarks, sswasteTeaDisposalMust3mks, wasteTeaDisposalMust3mks);


        TeaPackerBus teaPackerBus = TeaPackerBus.getInstance();

        teaPackerBus.setIsRoofCeiling(roofCeiling);
        teaPackerBus.setRoofCeilingMust3mks(roofCeilingMust3mks);
        teaPackerBus.setRoofCeilingRemarks(roofCeilingRemarks);
        teaPackerBus.setIsWindows(windows);
        teaPackerBus.setWindowsRecom1mk(windowsRecom1mk);
        teaPackerBus.setWindowsRemarks(windowsRemarks);
        teaPackerBus.setIsDoors(doors);
        teaPackerBus.setDoorsRecom1mk(doorsRecom1mk);
        teaPackerBus.setDoorsRemarks(doorsRemarks);
        teaPackerBus.setIsAdequatelighting(adequatelighting);
        teaPackerBus.setAdequateLightingMust3mks(adequateLightingMust3mks);
        teaPackerBus.setAdequateLightingRemarks(adequateLightingRemarks);

        teaPackerBus.setIsVentilation(ventilation);
        teaPackerBus.setVentilationRecom1mks(ventilationRecom1mks);
        teaPackerBus.setVentilationRemarks(ventilationRemarks);

        teaPackerBus.setIsEquipmentCleanliness(equipmentCleanliness);
        teaPackerBus.setEquipmentCleanlinessMust3mks(equipmentCleanlinessMust3mks);
        teaPackerBus.setEquipmentCleanlinessRemarks(equipmentCleanlinessRemarks);
        teaPackerBus.setIsChangingrooms(changingrooms);
        teaPackerBus.setChangingroomsMust3mks(changingroomsMust3mks);
        teaPackerBus.setChangingroomsRemarks(changingroomsRemarks);
        teaPackerBus.setIsRiskOfChemical(riskOfChemical);
        teaPackerBus.setRiskOfChemicalMust3mks(riskOfChemicalMust3mks);
        teaPackerBus.setRiskOfChemicalRemarks(riskOfChemicalRemarks);
        teaPackerBus.setIsWasteTeaDisposal(wasteTeaDisposal);
        teaPackerBus.setWasteTeaDisposalMust3mks(wasteTeaDisposalMust3mks);
        teaPackerBus.setWasteTeaDisposalRemarks(wasteTeaDisposalRemarks);

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

    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString, SearchableSpinner searchableSpinner, String searchableSpinnerString){

        boolean resultCheckbox = false;
        boolean resultSpinner = false;

        if(!checkBox.isChecked())
        {
            if (TextUtils.isEmpty(customEditTextString))
            {
                customEditText.setError("Field Required ");
                resultCheckbox = false;
            }
        }
        else
            {
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
