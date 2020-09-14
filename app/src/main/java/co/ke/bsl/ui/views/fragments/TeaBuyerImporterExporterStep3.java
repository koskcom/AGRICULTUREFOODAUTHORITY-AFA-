package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

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
import co.ke.bsl.data.view.TeaBuyerImporterExporterBus;
import co.ke.bsl.data.view.View1Marks;
import co.ke.bsl.data.view.View2Marks;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeaBuyerImporterExporterStep3 extends Fragment implements BlockingStep {

    @BindView(R.id.isExternalsitestandards)
    CheckBox isExternalsitestandards;
    @BindView(R.id.ssexternalsitestandards2mks)
    SearchableSpinner ssexternalsitestandards2mks;
    @BindView(R.id.etexternalsitestandardsRemarks)
    CustomEditText etexternalsitestandardsRemarks;
    @BindView(R.id.isSecurityaccess)
    CheckBox isSecurityaccess;
    @BindView(R.id.sssecurityaccessReccomm)
    SearchableSpinner sssecurityaccessReccomm;
    @BindView(R.id.etSecurityaccessRemarks)
    CustomEditText etSecurityaccessRemarks;
    @BindView(R.id.isLayoutproductflow)
    CheckBox isLayoutproductflow;
    @BindView(R.id.ssLayoutproductflow2mks)
    SearchableSpinner ssLayoutproductflow2mks;
    @BindView(R.id.etLayoutproductflowRemarks)
    CustomEditText etLayoutproductflowRemarks;
    @BindView(R.id.isWall)
    CheckBox isWall;
    @BindView(R.id.sswall3mks)
    SearchableSpinner sswall3mks;
    @BindView(R.id.etwallRemarks)
    CustomEditText etwallRemarks;
    @BindView(R.id.isFloor)
    CheckBox isFloor;
    @BindView(R.id.ssFloor3mks)
    SearchableSpinner ssFloor3mks;
    @BindView(R.id.etFloorremarks)
    CustomEditText etFloorremarks;
    @BindView(R.id.isRoof)
    CheckBox isRoof;
    @BindView(R.id.ssroof3mks)
    SearchableSpinner ssroof3mks;
    @BindView(R.id.etroofRemarks)
    CustomEditText etroofRemarks;
    @BindView(R.id.isWindow)
    CheckBox isWindow;
    @BindView(R.id.ssWindow1mk)
    SearchableSpinner ssWindow1mk;
    @BindView(R.id.etWindowRemarks)
    CustomEditText etWindowRemarks;
    @BindView(R.id.isDoor)
    CheckBox isDoor;
    @BindView(R.id.ssDoors1mk)
    SearchableSpinner ssDoors1mk;
    @BindView(R.id.etDoorRemarks)
    CustomEditText etDoorRemarks;
    @BindView(R.id.isAdequateLighting)
    CheckBox isAdequateLighting;
    @BindView(R.id.ssadequateLighting3mks)
    SearchableSpinner ssadequateLighting3mks;
    @BindView(R.id.etAdequateLightingremarks)
    CustomEditText etAdequateLightingremarks;
    @BindView(R.id.isVentillation)
    CheckBox isVentillation;
    @BindView(R.id.ssVentillation1mks)
    SearchableSpinner ssVentillation1mks;
    @BindView(R.id.etVentillationRemarks)
    CustomEditText etVentillationRemarks;
    @BindView(R.id.isEquipmentCleanliness)
    CheckBox isEquipmentCleanliness;
    @BindView(R.id.ssEquipmentCleanliness3mks)
    SearchableSpinner ssEquipmentCleanliness3mks;
    @BindView(R.id.etEquipmentcleanlinessRemarks)
    CustomEditText etEquipmentcleanlinessRemarks;
    @BindView(R.id.isChangingRooms)
    CheckBox isChangingRooms;
    @BindView(R.id.ssChangingRooms3mks)
    SearchableSpinner ssChangingRooms3mks;
    @BindView(R.id.etChangingRoomRemarks)
    CustomEditText etChangingRoomRemarks;
    @BindView(R.id.isRiskofchemical)
    CheckBox isRiskofchemical;
    @BindView(R.id.ssRiskOfchemical3mks)
    SearchableSpinner ssRiskOfchemical3mks;
    @BindView(R.id.etRiskOfchemicalRemarks)
    CustomEditText etRiskOfchemicalRemarks;
    @BindView(R.id.isWasteteadisposal)
    CheckBox isWasteteadisposal;
    @BindView(R.id.sswasteTeaDisposalMust3mks)
    SearchableSpinner sswasteTeaDisposalMust3mks;
    @BindView(R.id.etwasteTeaDisposalRemarks)
    CustomEditText etwasteTeaDisposalRemarks;
    @BindView(R.id.isPestcontrolprogram)
    CheckBox isPestcontrolprogram;
    @BindView(R.id.ssPestcontrolprogram3mks)
    SearchableSpinner ssPestcontrolprogram3mks;
    @BindView(R.id.etPestControlprogramRemarks)
    CustomEditText etPestControlprogramRemarks;
    @BindView(R.id.isProperstorage)
    CheckBox isProperstorage;
    @BindView(R.id.ssProperstorage1mk)
    SearchableSpinner ssProperstorage1mk;
    @BindView(R.id.etProperstorageRemarks)
    CustomEditText etProperstorageRemarks;

    private ArrayList<String> marksOf2List = new ArrayList<>();
    private ArrayList<String> marksOf1List = new ArrayList<>();


    private String externalStandards, securityAccess, layoutProductFlow, wall, floor, roof, window, door, adequateLighting, ventillation, equipmnetCleanliness, changingRooms, riskOfChemicals, wasteteaDisposal, pestControlPrograms, properStorage;
    private String externalStandardsmarks, securityAccessmarks, layoutProductFlowmarks, wallmarks, floormarks, roofmarks, windowmarks, doormarks, adequateLightingmarks, ventillationmarks, equipmnetCleanlinessmarks, changingRoomsmarks, riskOfChemicalsmarks, wasteteaDisposalmarks, pestControlProgramsmarks, properStoragemarks;
    private String externalStandardsremarks, securityAccessremarks, layoutProductFlowremarks, wallremarks, floorremarks, roofremarks, windowremarks, doorremarks, adequateLightingremarks, ventillationremarks, equipmnetCleanlinessremarks, changingRoomsremarks, riskOfChemicalsremarks, wasteteaDisposalremarks, pestControlProgramsremarks, properStorageremarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tea_buyer_importer_exporter_step3, container, false);
        ButterKnife.bind(this, view);

        setList1Marks(getDummy1Marks());
        setList2Marks(getDummy2Marks());

        isExternalsitestandards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExternalsitestandards.isChecked()) {
                    externalStandards = "Y";
                } else {
                    externalStandards = "N";
                }
            }
        });

        isSecurityaccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSecurityaccess.isChecked()) {
                    securityAccess = "Y";
                } else {
                    securityAccess = "N";
                }
            }
        });

        isLayoutproductflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLayoutproductflow.isChecked()) {
                    layoutProductFlow = "Y";
                } else {
                    layoutProductFlow = "N";
                }
            }
        });

        isWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWall.isChecked()) {
                    wall = "Y";
                } else {
                    wall = "N";
                }
            }
        });

        isFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFloor.isChecked()) {
                    floor = "Y";
                } else {
                    floor = "N";
                }
            }
        });

        isRoof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRoof.isChecked()) {
                    roof = "Y";
                } else {
                    roof = "N";
                }
            }
        });

        isWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWindow.isChecked()) {
                    window = "Y";
                } else {
                    window = "N";
                }
            }
        });

        isDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDoor.isChecked()) {
                    door = "Y";
                } else {
                    door = "N";
                }
            }
        });

        isAdequateLighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAdequateLighting.isChecked()) {
                    adequateLighting = "Y";
                } else {
                    adequateLighting = "N";
                }
            }
        });

        isVentillation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isVentillation.isChecked()) {
                    ventillation = "Y";
                } else {
                    ventillation = "N";
                }
            }
        });

        isEquipmentCleanliness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEquipmentCleanliness.isChecked()) {
                    equipmnetCleanliness = "Y";
                } else {
                    equipmnetCleanliness = "N";
                }
            }
        });

        isChangingRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChangingRooms.isChecked()) {
                    changingRooms = "Y";
                } else {
                    changingRooms = "N";
                }
            }
        });

        isRiskofchemical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRiskofchemical.isChecked()) {
                    riskOfChemicals = "Y";
                } else {
                    riskOfChemicals = "N";
                }
            }
        });

        isWasteteadisposal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWasteteadisposal.isChecked()) {
                    wasteteaDisposal = "Y";
                } else {
                    wasteteaDisposal = "N";
                }
            }
        });

        isPestcontrolprogram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPestcontrolprogram.isChecked()) {
                    pestControlPrograms = "Y";
                } else {
                    pestControlPrograms = "N";
                }
            }
        });

        isProperstorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProperstorage.isChecked()) {
                    properStorage = "Y";
                } else {
                    properStorage = "N";
                }
            }
        });

        ssexternalsitestandards2mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                externalStandardsmarks = ssexternalsitestandards2mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sssecurityaccessReccomm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                securityAccessmarks = sssecurityaccessReccomm.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssLayoutproductflow2mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                layoutProductFlowmarks = ssLayoutproductflow2mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sswall3mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                wallmarks = sswall3mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssFloor3mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                floormarks = ssFloor3mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssroof3mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                roofmarks = ssroof3mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssWindow1mk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                windowmarks = ssWindow1mk.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssDoors1mk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                doormarks = ssDoors1mk.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssadequateLighting3mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adequateLightingmarks = ssadequateLighting3mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssVentillation1mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ventillationmarks = ssVentillation1mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssEquipmentCleanliness3mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                equipmnetCleanlinessmarks = ssEquipmentCleanliness3mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssChangingRooms3mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changingRoomsmarks = ssChangingRooms3mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssRiskOfchemical3mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                riskOfChemicalsmarks = ssRiskOfchemical3mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sswasteTeaDisposalMust3mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                wasteteaDisposalmarks = sswasteTeaDisposalMust3mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssPestcontrolprogram3mks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pestControlProgramsmarks = ssPestcontrolprogram3mks.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssProperstorage1mk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                properStoragemarks = ssProperstorage1mk.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    private void setList1Marks(List<View1Marks> dummy1Marks) {

        marksOf1List.add("- Required -");
        for (View1Marks regionWrapper : dummy1Marks) {
            marksOf1List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf1List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssProperstorage1mk.setAdapter(regionAdapter);
        ssEquipmentCleanliness3mks.setAdapter(regionAdapter);
        ssVentillation1mks.setAdapter(regionAdapter);
        ssadequateLighting3mks.setAdapter(regionAdapter);
        ssDoors1mk.setAdapter(regionAdapter);
        ssWindow1mk.setAdapter(regionAdapter);
        sssecurityaccessReccomm.setAdapter(regionAdapter);
    }

    private void setList2Marks(List<View2Marks> dummy2Marks) {

        marksOf2List.add("- Required -");
        for (View2Marks regionWrapper : dummy2Marks) {
            marksOf2List.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, marksOf2List);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssPestcontrolprogram3mks.setAdapter(regionAdapter);
        sswasteTeaDisposalMust3mks.setAdapter(regionAdapter);
        ssRiskOfchemical3mks.setAdapter(regionAdapter);
        ssChangingRooms3mks.setAdapter(regionAdapter);
        ssroof3mks.setAdapter(regionAdapter);
        ssFloor3mks.setAdapter(regionAdapter);
        sswall3mks.setAdapter(regionAdapter);
        ssLayoutproductflow2mks.setAdapter(regionAdapter);
        ssexternalsitestandards2mks.setAdapter(regionAdapter);
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


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        externalStandardsremarks = Objects.requireNonNull(etexternalsitestandardsRemarks.getText()).toString().trim();
        securityAccessremarks = Objects.requireNonNull(etSecurityaccessRemarks.getText()).toString().trim();
        layoutProductFlowremarks = Objects.requireNonNull(etLayoutproductflowRemarks.getText()).toString().trim();
        wallremarks = Objects.requireNonNull(etwallRemarks.getText()).toString().trim();
        floorremarks = Objects.requireNonNull(etFloorremarks.getText()).toString().trim();
        roofremarks = Objects.requireNonNull(etroofRemarks.getText()).toString().trim();
        windowremarks = Objects.requireNonNull(etWindowRemarks.getText()).toString().trim();
        doorremarks = Objects.requireNonNull(etDoorRemarks.getText()).toString().trim();
        adequateLightingremarks = Objects.requireNonNull(etAdequateLightingremarks.getText()).toString().trim();
        ventillationremarks = Objects.requireNonNull(etVentillationRemarks.getText()).toString().trim();
        equipmnetCleanlinessremarks = Objects.requireNonNull(etEquipmentcleanlinessRemarks.getText()).toString().trim();
        changingRoomsremarks = Objects.requireNonNull(etChangingRoomRemarks.getText()).toString().trim();
        riskOfChemicalsremarks = Objects.requireNonNull(etRiskOfchemicalRemarks.getText()).toString().trim();
        wasteteaDisposalremarks = Objects.requireNonNull(etwasteTeaDisposalRemarks.getText()).toString().trim();
        pestControlProgramsremarks = Objects.requireNonNull(etPestControlprogramRemarks.getText()).toString().trim();
        properStorageremarks = Objects.requireNonNull(etProperstorageRemarks.getText()).toString().trim();


        TeaBuyerImporterExporterBus teaBuyerImporterExporterBus = TeaBuyerImporterExporterBus.getInstance();

        teaBuyerImporterExporterBus.setIsExternalSiteStandards(externalStandards);
        teaBuyerImporterExporterBus.setExternalSiteStandardsMarks(externalStandardsmarks);
        teaBuyerImporterExporterBus.setExternalSiteStandardsRemarks(externalStandardsremarks);
        teaBuyerImporterExporterBus.setIsSecurityAccessControl(securityAccess);
        teaBuyerImporterExporterBus.setSecurityAccessControlMarks(securityAccessmarks);
        teaBuyerImporterExporterBus.setSecurityAccessControlRemarks(securityAccessremarks);
        teaBuyerImporterExporterBus.setIsLayoutProductFlow(layoutProductFlow);
        teaBuyerImporterExporterBus.setLayoutProductFlowMarks(layoutProductFlowmarks);
        teaBuyerImporterExporterBus.setLayoutProductFlowRemarks(layoutProductFlowremarks);
        teaBuyerImporterExporterBus.setIsWalls(wall);
        teaBuyerImporterExporterBus.setWallsMarks(wallmarks);
        teaBuyerImporterExporterBus.setWallsRemarks(wallremarks);
        teaBuyerImporterExporterBus.setIsFloors(floor);
        teaBuyerImporterExporterBus.setFloorsMarks(floormarks);
        teaBuyerImporterExporterBus.setFloorsRemarks(floorremarks);
        teaBuyerImporterExporterBus.setIsRoofCeilingAndOverhead(roof);
        teaBuyerImporterExporterBus.setRoofCeilingAndOverheadMarks(roofmarks);
        teaBuyerImporterExporterBus.setRoofCeilingAndOverheadRemarks(roofremarks);
        teaBuyerImporterExporterBus.setIsWindows(window);
        teaBuyerImporterExporterBus.setWindowsMarks(windowmarks);
        teaBuyerImporterExporterBus.setWindowsRemarks(windowremarks);
        teaBuyerImporterExporterBus.setIsDoors(door);
        teaBuyerImporterExporterBus.setDoorsMarks(doormarks);
        teaBuyerImporterExporterBus.setDoorsRemarks(doorremarks);
        teaBuyerImporterExporterBus.setIsAdequateLighting(adequateLighting);
        teaBuyerImporterExporterBus.setAdequateLightingMarks(adequateLightingmarks);
        teaBuyerImporterExporterBus.setAdequateLightingRemarks(adequateLightingremarks);
        teaBuyerImporterExporterBus.setIsVentilation(ventillation);
        teaBuyerImporterExporterBus.setVentilationMarks(ventillationmarks);
        teaBuyerImporterExporterBus.setVentilationRemarks(ventillationremarks);
        teaBuyerImporterExporterBus.setIsEquipmentCleanliness(equipmnetCleanliness);
        teaBuyerImporterExporterBus.setEquipmentCleanlinessMarks(equipmnetCleanlinessmarks);
        teaBuyerImporterExporterBus.setEquipmentCleanlinessRemarks(equipmnetCleanlinessremarks);
        teaBuyerImporterExporterBus.setIsChangingRoomsAndToilets(changingRooms);
        teaBuyerImporterExporterBus.setChangingRoomsAndToiletsMarks(changingRoomsmarks);
        teaBuyerImporterExporterBus.setChangingRoomsAndToiletsRemarks(changingRoomsremarks);
        teaBuyerImporterExporterBus.setIsRiskOfContaminants(riskOfChemicals);
        teaBuyerImporterExporterBus.setRiskOfContaminantsMarks(riskOfChemicalsmarks);
        teaBuyerImporterExporterBus.setRiskOfContaminantsRemarks(riskOfChemicalsremarks);
        teaBuyerImporterExporterBus.setIsWasteTeasDisposal(wasteteaDisposal);
        teaBuyerImporterExporterBus.setWasteTeasDisposalMarks(wasteteaDisposalmarks);
        teaBuyerImporterExporterBus.setWasteTeasDisposalRemarks(wasteteaDisposalremarks);
        teaBuyerImporterExporterBus.setIsPestControlPrograms(pestControlPrograms);
        teaBuyerImporterExporterBus.setPestControlProgramsMarks(pestControlProgramsmarks);
        teaBuyerImporterExporterBus.setPestControlProgramsRemarks(pestControlProgramsremarks);
        teaBuyerImporterExporterBus.setIsProperStorage(properStorage);
        teaBuyerImporterExporterBus.setProperStorageMarks(properStoragemarks);
        teaBuyerImporterExporterBus.setProperStorageRemarks(properStorageremarks);


        callback.goToNextStep();
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
}
