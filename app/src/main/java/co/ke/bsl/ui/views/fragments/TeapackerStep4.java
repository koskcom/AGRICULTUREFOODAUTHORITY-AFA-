package co.ke.bsl.ui.views.fragments;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

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
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.data.view.TeaPackerBus;
import co.ke.bsl.data.view.View10Marks;
import co.ke.bsl.data.view.View1Marks;
import co.ke.bsl.data.view.View2Marks;
import co.ke.bsl.data.view.View3Marks;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.TeaPackerViewModel;
import co.ke.bsl.util.CustomEditText;
import cn.pedant.SweetAlert.SweetAlertDialog;

import android.graphics.Color;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeapackerStep4 extends Fragment implements BlockingStep {

    @BindView(R.id.isPestControlProgram)
    CheckBox isPestControlProgram;
    @BindView(R.id.sspestControlProgramMust3mks)
    SearchableSpinner sspestControlProgramMust3mks;
    @BindView(R.id.etpestControlProgramRemarks)
    CustomEditText etpestControlProgramRemarks;

    @BindView(R.id.isProperStorage)
    CheckBox isProperStorage;
    @BindView(R.id.ssproperStorageRecom1mk)
    SearchableSpinner ssproperStorageRecom1mk;
    @BindView(R.id.etproperStorageRemarks)
    CustomEditText etproperStorageRemarks;

    @BindView(R.id.isPackagingMaterialConfirmity)
    CheckBox isPackagingMaterialConfirmity;
    @BindView(R.id.sspackagingMaterialConfirmityMust2mks)
    SearchableSpinner sspackagingMaterialConfirmityMust2mks;
    @BindView(R.id.etpackagingMaterialConfirmityRemarks)
    CustomEditText etpackagingMaterialConfirmityRemarks;

    @BindView(R.id.isIdentificationAndSegregation)
    CheckBox isIdentificationAndSegregation;
    @BindView(R.id.ssIdentificationSegregationMust2mks)
    SearchableSpinner ssIdentificationSegregationMust2mks;
    @BindView(R.id.etIdentificationAndSegregationRemarks)
    CustomEditText etIdentificationAndSegregationRemarks;

    @BindView(R.id.isEquipmentIdentificationCalibration)
    CheckBox isEquipmentIdentificationCalibration;
    @BindView(R.id.ssEquipmentIdentificationCalibrationMust2mks)
    SearchableSpinner ssEquipmentIdentificationCalibrationMust2mks;
    @BindView(R.id.etEquipmentIdentificationCalibrationRemarks)
    CustomEditText etEquipmentIdentificationCalibrationRemarks;

    @BindView(R.id.isTraceabilitySystem)
    CheckBox isTraceabilitySystem;
    @BindView(R.id.sstraceabilitySystemMandatory10mks)
    SearchableSpinner sstraceabilitySystemMandatory10mks;
    @BindView(R.id.ettraceabilitySystemRemarks)
    CustomEditText ettraceabilitySystemRemarks;

    @BindView(R.id.isProcessDocuments)
    CheckBox isProcessDocuments;
    @BindView(R.id.ssprocessDocumentsMust3mks)
    SearchableSpinner ssprocessDocumentsMust3mks;
    @BindView(R.id.etprocessDocumentsRemarks)
    CustomEditText etprocessDocumentsRemarks;

    @BindView(R.id.isValidMedicalCert)
    CheckBox isValidMedicalCert;
    @BindView(R.id.ssvalidMedicalCertMandatory10mks)
    SearchableSpinner ssvalidMedicalCertMandatory10mks;
    @BindView(R.id.etvalidMedicalCertRemarks)
    CustomEditText etvalidMedicalCertRemarks;

    @BindView(R.id.isCleanPersonalProtective)
    CheckBox isCleanPersonalProtective;
    @BindView(R.id.sscleanPersonalProtectiveMndatory10mks)
    SearchableSpinner sscleanPersonalProtectiveMndatory10mks;
    @BindView(R.id.etcleanPersonalProtectiveRemarks)
    CustomEditText etcleanPersonalProtectiveRemarks;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    AFADatabaseAdapter db;
    AFA app;

    AlertDialog.Builder builder;

    private String recommendation, recommendationRemarks;

    private TeaPackerViewModel teaPackerViewModel;

    private String pestControlProgram, pestControlProgramMust3mks, pestControlProgramRemarks, properStorage, properStorageRecom1mk, properStorageRemarks, packagingMaterialConfirmity, packagingMaterialConfirmityMust2mks, packagingMaterialConfirmityRemarks, IdentificationAndSegregation, IdentificationSegregationMust2mks, IdentificationAndSegregationRemarks, equipmentIdentificationAndCalibration, equipmentIdentificationAndCalibrationMust3mks, equipmentIdentificationAndCalibrationRemarks, traceabilitySystem, traceabilitySystemMandatory10mks, traceabilitySystemRemarks;
    private String processDocuments, processDocumentsMust3mks, processDocumentsRemarks, validMedicalCert, validMedicalCertMandatory10mks, validMedicalCertRemarks, cleanPersonalProtective, cleanPersonalProtectiveMndatory10mks, cleanPersonalProtectiveRemarks;

    private String Savestring = "N";
    private ArrayList<String> marksof10List = new ArrayList<>();
    private ArrayList<String> marksof1List = new ArrayList<>();
    private ArrayList<String> marksof2List = new ArrayList<>();
    private ArrayList<String> marksof3List = new ArrayList<>();
    private ArrayList<String> marksof5List = new ArrayList<>();
  private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teapacker_step4, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        builder = new AlertDialog.Builder(getActivity());
        setList10marks(getdummy10marks());
        setList3marks(getdummy3marks());
        setList1marks(getdummy1marks());
        setList2marks(getdummy2marks());


        teaPackerViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(TeaPackerViewModel.class);

        setReccomendationsView(getReccomendationsView());

        ssReccomendation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ReccomendationsView rec = (ReccomendationsView) ssReccomendation.getSelectedItem();
                recommendation = rec.getServerID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        isPestControlProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPestControlProgram.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                pestControlProgram = Savestring;
            }
        });

        isProperStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProperStorage.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                properStorage = Savestring;
            }
        });

        isPackagingMaterialConfirmity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPackagingMaterialConfirmity.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                packagingMaterialConfirmity = Savestring;
            }
        });

        isIdentificationAndSegregation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isIdentificationAndSegregation.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                IdentificationAndSegregation = Savestring;
            }
        });

        isEquipmentIdentificationCalibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEquipmentIdentificationCalibration.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                equipmentIdentificationAndCalibration = Savestring;
            }
        });


        isTraceabilitySystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTraceabilitySystem.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                traceabilitySystem = Savestring;
            }
        });

        isProcessDocuments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProcessDocuments.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                processDocuments = Savestring;
            }
        });

        isValidMedicalCert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidMedicalCert.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                validMedicalCert = Savestring;
            }
        });

        isCleanPersonalProtective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCleanPersonalProtective.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                cleanPersonalProtective = Savestring;
            }
        });


        return view;
    }

    private void setList10marks(List<View10Marks> getdummy10marks) {
        marksof10List.add("- Required -");
        for (View10Marks regionWrapper : getdummy10marks) {
            marksof10List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof10List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssvalidMedicalCertMandatory10mks.setAdapter(regionAdapter);
        sscleanPersonalProtectiveMndatory10mks.setAdapter(regionAdapter);
        sstraceabilitySystemMandatory10mks.setAdapter(regionAdapter);

    }

    private List<View10Marks> getdummy10marks() {
        List<View10Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View10Marks("0"));
        listViewItems.add(new View10Marks("10"));

        return listViewItems;
    }

    private void setList3marks(List<View3Marks> getdummy3marks) {
        marksof3List.add("- Required -");
        for (View3Marks regionWrapper : getdummy3marks) {
            marksof3List.add(regionWrapper.getName());
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, marksof3List);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        sspestControlProgramMust3mks.setAdapter(regionAdapter);
        ssEquipmentIdentificationCalibrationMust2mks.setAdapter(regionAdapter);
        ssprocessDocumentsMust3mks.setAdapter(regionAdapter);

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
        ssproperStorageRecom1mk.setAdapter(regionAdapter);
        ssproperStorageRecom1mk.setAdapter(regionAdapter);
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
        ssIdentificationSegregationMust2mks.setAdapter(regionAdapter);
        sspackagingMaterialConfirmityMust2mks.setAdapter(regionAdapter);

    }

    private List<View2Marks> getdummy2marks() {
        List<View2Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View2Marks("0"));
        listViewItems.add(new View2Marks("2"));

        return listViewItems;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        pestControlProgramMust3mks = Objects.requireNonNull(sspestControlProgramMust3mks.getSelectedItem()).toString().trim();
        pestControlProgramRemarks = Objects.requireNonNull(etpestControlProgramRemarks.getText()).toString().trim();
        properStorageRecom1mk = Objects.requireNonNull(ssproperStorageRecom1mk.getSelectedItem()).toString().trim();
        properStorageRemarks = Objects.requireNonNull(etproperStorageRemarks.getText()).toString().trim();
        packagingMaterialConfirmityMust2mks = Objects.requireNonNull(sspackagingMaterialConfirmityMust2mks.getSelectedItem()).toString().trim();
        packagingMaterialConfirmityRemarks = Objects.requireNonNull(etpackagingMaterialConfirmityRemarks.getText()).toString().trim();
        IdentificationSegregationMust2mks = Objects.requireNonNull(ssIdentificationSegregationMust2mks.getSelectedItem()).toString().trim();
        IdentificationAndSegregationRemarks = Objects.requireNonNull(etIdentificationAndSegregationRemarks.getText()).toString().trim();
        equipmentIdentificationAndCalibrationMust3mks = Objects.requireNonNull(ssEquipmentIdentificationCalibrationMust2mks.getSelectedItem()).toString().trim();
        equipmentIdentificationAndCalibrationRemarks = Objects.requireNonNull(etEquipmentIdentificationCalibrationRemarks.getText()).toString().trim();
        traceabilitySystemMandatory10mks = Objects.requireNonNull(sstraceabilitySystemMandatory10mks.getSelectedItem()).toString().trim();
        traceabilitySystemRemarks = Objects.requireNonNull(ettraceabilitySystemRemarks.getText()).toString().trim();
        processDocumentsMust3mks = Objects.requireNonNull(ssprocessDocumentsMust3mks.getSelectedItem()).toString().trim();
        processDocumentsRemarks = Objects.requireNonNull(etprocessDocumentsRemarks.getText()).toString().trim();
        validMedicalCertMandatory10mks = Objects.requireNonNull(ssvalidMedicalCertMandatory10mks.getSelectedItem()).toString().trim();
        validMedicalCertRemarks = Objects.requireNonNull(etvalidMedicalCertRemarks.getText()).toString().trim();
        cleanPersonalProtectiveMndatory10mks = Objects.requireNonNull(sscleanPersonalProtectiveMndatory10mks.getSelectedItem()).toString().trim();
        cleanPersonalProtectiveRemarks = Objects.requireNonNull(etcleanPersonalProtectiveRemarks.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateFields(isPestControlProgram, etpestControlProgramRemarks, pestControlProgramRemarks, sspestControlProgramMust3mks, pestControlProgramMust3mks) &
                validateFields(isProperStorage, etproperStorageRemarks, properStorageRemarks, ssproperStorageRecom1mk, properStorageRecom1mk) &
                validateFields(isPackagingMaterialConfirmity, etpackagingMaterialConfirmityRemarks, packagingMaterialConfirmityRemarks, sspackagingMaterialConfirmityMust2mks, packagingMaterialConfirmityMust2mks) &
                validateFields(isIdentificationAndSegregation, etIdentificationAndSegregationRemarks, IdentificationAndSegregationRemarks, ssIdentificationSegregationMust2mks, IdentificationSegregationMust2mks) &
                validateFields(isEquipmentIdentificationCalibration, etEquipmentIdentificationCalibrationRemarks, equipmentIdentificationAndCalibrationRemarks, ssEquipmentIdentificationCalibrationMust2mks, equipmentIdentificationAndCalibrationMust3mks) &
                validateFields(isTraceabilitySystem, ettraceabilitySystemRemarks, traceabilitySystemRemarks, sstraceabilitySystemMandatory10mks, traceabilitySystemMandatory10mks) &
                validateFields(isProcessDocuments, etprocessDocumentsRemarks, processDocumentsRemarks, ssprocessDocumentsMust3mks, processDocumentsMust3mks) &
                validateFields(isValidMedicalCert, etvalidMedicalCertRemarks, validMedicalCertRemarks, ssvalidMedicalCertMandatory10mks, validMedicalCertMandatory10mks) &
                validateFields(isCleanPersonalProtective, etcleanPersonalProtectiveRemarks, cleanPersonalProtectiveRemarks, sscleanPersonalProtectiveMndatory10mks, cleanPersonalProtectiveMndatory10mks);


        TeaPackerBus teaPackerBus = TeaPackerBus.getInstance();
        TeaPacker teaPacker = new TeaPacker(
                0,
                teaPackerBus.getDocumentNo(),
                teaPackerBus.getDocumentDate(),
                teaPackerBus.getApplicantName(),
                teaPackerBus.getLicenceNo(),
                teaPackerBus.getLocalID(),
                teaPackerBus.getIsCertCompanyReg(),
                teaPackerBus.getCompanyRegMandatory10mks(),
                teaPackerBus.getCompanyRegRemarks(),
                teaPackerBus.getIsBusinessPermit(),
                teaPackerBus.getBusinessPermitMust3mks(),
                teaPackerBus.getBusinessPermitRemarks(),
                teaPackerBus.getIsHealthCertificate(),
                teaPackerBus.getHealthCertificateMandatory10mks(),
                teaPackerBus.getHealthCertificateRemarks(),
                teaPackerBus.getIsExternalSiteStandards(),
                teaPackerBus.getExternalSiteStandardsMandatory10mks(),
                teaPackerBus.getExternalSiteStandardsRemarks(),
                teaPackerBus.getIsSecurityAccess(),
                teaPackerBus.getSecurityAccessReccomm(),
                teaPackerBus.getSecurityAccessRemarks(),
                teaPackerBus.getIsLayoutCALIBRATION(),
                teaPackerBus.getLayoutCALIBRATIONMust2mks(),
                teaPackerBus.getLayoutCALIBRATIONRemarks(),
                teaPackerBus.getIsWalls(),
                teaPackerBus.getWallsMust3mks(),
                teaPackerBus.getWallsRemarks(),
                teaPackerBus.getIsFloors(),
                teaPackerBus.getFloorsMust3mks(),
                teaPackerBus.getFloorsRemarks(),
                teaPackerBus.getIsRoofCeiling(),
                teaPackerBus.getRoofCeilingMust3mks(),
                teaPackerBus.getRoofCeilingRemarks(),
                teaPackerBus.getIsWindows(),
                teaPackerBus.getWindowsRecom1mk(),
                teaPackerBus.getWindowsRemarks(),
                teaPackerBus.getIsDoors(),
                teaPackerBus.getDoorsRecom1mk(),
                teaPackerBus.getDoorsRemarks(),
                teaPackerBus.getIsAdequatelighting(),
                teaPackerBus.getAdequateLightingMust3mks(),
                teaPackerBus.getAdequateLightingRemarks(),
                teaPackerBus.getIsVentilation(),
                teaPackerBus.getVentilationRecom1mks(),
                teaPackerBus.getVentilationRemarks(),
                teaPackerBus.getIsEquipmentCleanliness(),
                teaPackerBus.getEquipmentCleanlinessMust3mks(),
                teaPackerBus.getEquipmentCleanlinessRemarks(),
                teaPackerBus.getIsChangingrooms(),
                teaPackerBus.getChangingroomsMust3mks(),
                teaPackerBus.getChangingroomsRemarks(),
                teaPackerBus.getIsRiskOfChemical(),
                teaPackerBus.getRiskOfChemicalMust3mks(),
                teaPackerBus.getRiskOfChemicalRemarks(),
                teaPackerBus.getIsWasteTeaDisposal(),
                teaPackerBus.getWasteTeaDisposalMust3mks(),
                teaPackerBus.getWasteTeaDisposalRemarks(),
                pestControlProgram,
                pestControlProgramMust3mks,
                pestControlProgramRemarks,
                properStorage,
                properStorageRecom1mk,
                properStorageRemarks,
                packagingMaterialConfirmity,
                packagingMaterialConfirmityMust2mks,
                packagingMaterialConfirmityRemarks,
                IdentificationAndSegregation,
                IdentificationSegregationMust2mks,
                IdentificationAndSegregationRemarks,
                equipmentIdentificationAndCalibration,
                equipmentIdentificationAndCalibrationMust3mks,
                equipmentIdentificationAndCalibrationRemarks,
                traceabilitySystem,
                traceabilitySystemMandatory10mks,
                traceabilitySystemRemarks,
                processDocuments,
                processDocumentsMust3mks,
                processDocumentsRemarks,
                validMedicalCert,
                validMedicalCertMandatory10mks,
                validMedicalCertRemarks,
                cleanPersonalProtective,
                cleanPersonalProtectiveMndatory10mks,
                cleanPersonalProtectiveRemarks,
                recommendation,
                recommendationRemarks,
                false,
                ""
        );

       if (valid)
        {
            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("TEAPACKER INSPECTION!")
                    .setCancelText("NO!")
                    .setConfirmText("Submit!")
                    .showCancelButton(true)
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            // reuse previous dialog instance, keep widget user state, reset them if you need
                            sDialog.setTitleText("Cancelled!")
                                    .setContentText("You Cancelled Submission:)")
                                    .setConfirmText("OK")
                                    .showCancelButton(false)
                                    .setCancelClickListener(null)
                                    .setConfirmClickListener(null)
                                    .changeAlertType(SweetAlertDialog.ERROR_TYPE);

                        }
                    })
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.setTitleText("Successfully!!!")
                                    .setContentText("Submitted!")
                                    .setConfirmText("OK")
                                    .showCancelButton(false)
                                    .setCancelClickListener(null)
                                    .setConfirmClickListener(null)
                                    .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);

                            long result = db.updateTeapackerChecklist(teaPacker);
                            System.out.println("result is" + result);
                            teaPackerViewModel.addRecord(teaPacker);
                            sDialog.dismissWithAnimation();
                            Intent intent = new Intent(getActivity(), DashboardActivity.class);
                            startActivity(intent);
                        }
                    })
                    .show();

      }

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

    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString, SearchableSpinner searchableSpinner, String searchableSpinnerString) {

        boolean resultCheckbox = false;
        boolean resultSpinner = false;

        if (!checkBox.isChecked()) {
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                resultCheckbox = false;
            }
        } else {
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
        } else {
            resultSpinner = true;
        }
        return (resultCheckbox && resultSpinner);
    }

    private void setReccomendationsView(List<ReccomendationsView> getReccomendationsView) {

        for (ReccomendationsView regionWrapper : getReccomendationsView) {
            reccomendationsViewList.add(regionWrapper);
        }
        ArrayAdapter<ReccomendationsView> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, reccomendationsViewList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssReccomendation.setAdapter(regionAdapter);


    }

    private List<ReccomendationsView> getReccomendationsView() {
        List<ReccomendationsView> listViewItems = new ArrayList<>();
        listViewItems.add(new ReccomendationsView("-select-", ""));
        listViewItems.add(new ReccomendationsView("I Recommend", "10000245"));
        listViewItems.add(new ReccomendationsView("I Do Not Recommend", "10000246"));

        return listViewItems;
    }



}
