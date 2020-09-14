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
import android.widget.Spinner;
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
import co.ke.bsl.data.view.SugarCompanyView;
import co.ke.bsl.data.view.TeaPackerBus;
import co.ke.bsl.data.view.View10Marks;
import co.ke.bsl.data.view.View1Marks;
import co.ke.bsl.data.view.View2Marks;
import co.ke.bsl.data.view.View3Marks;
import co.ke.bsl.data.view.View5Marks;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeaPackerStep2 extends Fragment implements BlockingStep, AdapterView.OnItemClickListener {


    @BindView(R.id.isCertCompanyReg)
    CheckBox isCertCompanyReg;
    @BindView(R.id.sscompanyRegMandatory10mks)
    SearchableSpinner sscompanyRegMandatory10mks;
    @BindView(R.id.etcompanyRegRemarks)
    CustomEditText etcompanyRegRemarks;
    @BindView(R.id.isBusinessPermit)
    CheckBox isBusinessPermit;
    @BindView(R.id.ssbusinessPermitMust3mks)
    SearchableSpinner ssbusinessPermitMust3mks;
    @BindView(R.id.etbusinessPermitRemarks)
    CustomEditText etbusinessPermitRemarks;
    @BindView(R.id.isHealthCertificate)
    CheckBox isHealthCertificate;
    @BindView(R.id.sshealthCertificateMandatory10mks)
    SearchableSpinner sshealthCertificateMandatory10mks;
    @BindView(R.id.ethealthCertificateMandatory10mksremarks)
    CustomEditText ethealthCertificateMandatory10mksremarks;
    @BindView(R.id.isExternalSiteStandards)
    CheckBox isExternalSiteStandards;
    @BindView(R.id.ssexternalSiteStandardsMandatory3mks)
    SearchableSpinner ssexternalSiteStandardsMandatory3mks;
    @BindView(R.id.etexternalSiteStandardsRemarks)
    CustomEditText etexternalSiteStandardsRemarks;
    @BindView(R.id.isSecurityAccess)
    CheckBox isSecurityAccess;
    @BindView(R.id.sssecurityAccessReccomm1mks)
    SearchableSpinner sssecurityAccessReccomm1mks;
    @BindView(R.id.etsecurityAccessRemarks)
    CustomEditText etsecurityAccessRemarks;
    @BindView(R.id.isLayoutCALIBRATION)
    CheckBox isLayoutCALIBRATION;
    @BindView(R.id.sslayoutCALIBRATIONMust2mks)
    SearchableSpinner sslayoutCALIBRATIONMust2mks;
    @BindView(R.id.etlayoutCALIBRATIONRemarks)
    CustomEditText etlayoutCALIBRATIONRemarks;
    @BindView(R.id.isWalls)
    CheckBox isWalls;
    @BindView(R.id.sswallsMust3mks)
    SearchableSpinner sswallsMust3mks;
    @BindView(R.id.etwallsRemarks)
    CustomEditText etwallsRemarks;
    @BindView(R.id.isFloors)
    CheckBox isFloors;
    @BindView(R.id.ssfloorsMust3mks)
    SearchableSpinner ssfloorsMust3mks;
    @BindView(R.id.etfloorsRemarks)
    CustomEditText etfloorsRemarks;

    AFADatabaseAdapter db;
    AFA app;

    private ArrayList<String> marksof10List = new ArrayList<>();
    private ArrayList<String> marksof1List = new ArrayList<>();
    private ArrayList<String> marksof2List = new ArrayList<>();
    private ArrayList<String> marksof3List = new ArrayList<>();
    private ArrayList<String> marksof5List = new ArrayList<>();

    private String Savestring = "N";

    private String certCompanyReg, companyRegMandatory10mks, companyRegRemarks, businessPermit, businessPermitMust3mks, businesspermit_remarks, healtcertificate, healthCertificateMandatory10mks, healthCertificateRemarks;
    private String externalSiteStandards, externalSiteStandardsMandatory10mks, externalSiteStandardsRemarks, securityAccess, securityAccessReccomm, securityAccessRemarks, layoutCALIBRATION, layoutCALIBRATIONMust2mks, layoutCALIBRATIONRemarks;
    private String walls, wallswallsMust3mks, wallsRemarks, floors, floorsMust3mks, floorsRemarks;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tea_packer_fragment_step2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        setList10marks(getdummy10marks());
        setList3marks(getdummy3marks());
        setList1marks(getdummy1marks());
        setList2marks(getdummy2marks());


        isCertCompanyReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCertCompanyReg.isChecked())
                {
                    certCompanyReg = "Y";

                }
                else
                {
                    certCompanyReg = "N";
                }

            }
        });

        isBusinessPermit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBusinessPermit.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                businessPermit = Savestring;
            }
        });

        isHealthCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHealthCertificate.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                healtcertificate = Savestring;
            }
        });

        isExternalSiteStandards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExternalSiteStandards.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                externalSiteStandards = Savestring;
            }
        });

        isSecurityAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSecurityAccess.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                securityAccess = Savestring;
            }
        });

        isLayoutCALIBRATION.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLayoutCALIBRATION.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                layoutCALIBRATION = Savestring;
            }
        });

        isWalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWalls.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                walls = Savestring;
            }
        });

        isFloors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCertCompanyReg.isChecked()) {
                    Savestring = "Y";
                } else {
                    Savestring = "N";
                }
                floors = Savestring;
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
        sscompanyRegMandatory10mks.setAdapter(regionAdapter);
        sshealthCertificateMandatory10mks.setAdapter(regionAdapter);

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
        ssbusinessPermitMust3mks.setAdapter(regionAdapter);
        ssexternalSiteStandardsMandatory3mks.setAdapter(regionAdapter);
        sswallsMust3mks.setAdapter(regionAdapter);
        ssfloorsMust3mks.setAdapter(regionAdapter);

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
        sssecurityAccessReccomm1mks.setAdapter(regionAdapter);
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
        sslayoutCALIBRATIONMust2mks.setAdapter(regionAdapter);
    }

    private List<View2Marks> getdummy2marks() {
        List<View2Marks> listViewItems = new ArrayList<>();
        listViewItems.add(new View2Marks("0"));
        listViewItems.add(new View2Marks("2"));

        return listViewItems;
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        companyRegMandatory10mks = Objects.requireNonNull(sscompanyRegMandatory10mks.getSelectedItem()).toString().trim();
        companyRegRemarks = Objects.requireNonNull(etcompanyRegRemarks.getText()).toString().trim();
        businessPermitMust3mks = Objects.requireNonNull(ssbusinessPermitMust3mks.getSelectedItem()).toString().trim();
        businesspermit_remarks = Objects.requireNonNull(etbusinessPermitRemarks.getText()).toString().trim();
        healthCertificateMandatory10mks = Objects.requireNonNull(sshealthCertificateMandatory10mks.getSelectedItem()).toString().trim();
        healthCertificateRemarks = Objects.requireNonNull(ethealthCertificateMandatory10mksremarks.getText()).toString().trim();
        externalSiteStandardsMandatory10mks = Objects.requireNonNull(ssexternalSiteStandardsMandatory3mks.getSelectedItem()).toString().trim();
        externalSiteStandardsRemarks = Objects.requireNonNull(etexternalSiteStandardsRemarks.getText()).toString().trim();
        securityAccessReccomm = Objects.requireNonNull(sssecurityAccessReccomm1mks.getSelectedItem()).toString().trim();
        securityAccessRemarks = Objects.requireNonNull(etsecurityAccessRemarks.getText()).toString().trim();
        layoutCALIBRATIONMust2mks = Objects.requireNonNull(sslayoutCALIBRATIONMust2mks.getSelectedItem()).toString().trim();
        layoutCALIBRATIONRemarks = Objects.requireNonNull(etlayoutCALIBRATIONRemarks.getText()).toString().trim();
        wallswallsMust3mks = Objects.requireNonNull(sswallsMust3mks.getSelectedItem()).toString().trim();
        wallsRemarks = Objects.requireNonNull(etwallsRemarks.getText()).toString().trim();
        floorsMust3mks = Objects.requireNonNull(ssfloorsMust3mks.getSelectedItem()).toString().trim();
        floorsRemarks = Objects.requireNonNull(etfloorsRemarks.getText()).toString().trim();

        boolean valid = validateFields(isCertCompanyReg, etcompanyRegRemarks, companyRegRemarks, sscompanyRegMandatory10mks, companyRegMandatory10mks) &
                validateFields(isBusinessPermit, etbusinessPermitRemarks, businesspermit_remarks, ssbusinessPermitMust3mks, businesspermit_remarks) &
                validateFields(isHealthCertificate, ethealthCertificateMandatory10mksremarks, healthCertificateRemarks, sshealthCertificateMandatory10mks, healthCertificateMandatory10mks) &
                validateFields(isExternalSiteStandards, etexternalSiteStandardsRemarks, externalSiteStandardsRemarks, ssexternalSiteStandardsMandatory3mks, externalSiteStandardsMandatory10mks) &
                validateFields(isSecurityAccess, etsecurityAccessRemarks, securityAccessRemarks, sssecurityAccessReccomm1mks, securityAccessReccomm) &
                validateFields(isLayoutCALIBRATION, etlayoutCALIBRATIONRemarks, layoutCALIBRATIONRemarks, sslayoutCALIBRATIONMust2mks, layoutCALIBRATIONMust2mks) &
                validateFields(isWalls, etwallsRemarks, wallsRemarks, sswallsMust3mks, wallswallsMust3mks) &
                validateFields(isFloors, etfloorsRemarks, floorsRemarks, ssfloorsMust3mks, floorsMust3mks);


        TeaPackerBus teaPackerBus = TeaPackerBus.getInstance();

        teaPackerBus.setIsCertCompanyReg(certCompanyReg);
        teaPackerBus.setCompanyRegMandatory10mks(companyRegMandatory10mks);
        teaPackerBus.setCompanyRegRemarks(companyRegRemarks);
        teaPackerBus.setIsBusinessPermit(businessPermit);
        teaPackerBus.setBusinessPermitMust3mks(businessPermitMust3mks);
        teaPackerBus.setBusinessPermitRemarks(businesspermit_remarks);
        teaPackerBus.setIsHealthCertificate(healtcertificate);
        teaPackerBus.setHealthCertificateMandatory10mks(healthCertificateMandatory10mks);
        teaPackerBus.setHealthCertificateRemarks(healthCertificateRemarks);
        teaPackerBus.setIsExternalSiteStandards(externalSiteStandards);
        teaPackerBus.setExternalSiteStandardsMandatory10mks(externalSiteStandardsMandatory10mks);
        teaPackerBus.setExternalSiteStandardsRemarks(externalSiteStandardsRemarks);
        teaPackerBus.setIsSecurityAccess(securityAccess);
        teaPackerBus.setSecurityAccessReccomm(securityAccessReccomm);
        teaPackerBus.setSecurityAccessRemarks(securityAccessRemarks);
        teaPackerBus.setIsLayoutCALIBRATION(layoutCALIBRATION);
        teaPackerBus.setLayoutCALIBRATIONMust2mks(layoutCALIBRATIONMust2mks);
        teaPackerBus.setLayoutCALIBRATIONRemarks(layoutCALIBRATIONRemarks);
        teaPackerBus.setIsWalls(walls);
        teaPackerBus.setWallsMust3mks(wallswallsMust3mks);
        teaPackerBus.setWallsRemarks(wallsRemarks);
        teaPackerBus.setIsFloors(floors);
        teaPackerBus.setFloorsMust3mks(floorsMust3mks);
        teaPackerBus.setFloorsRemarks(floorsRemarks);

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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    public void onNothingSelected(AdapterView<?>arg0){

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
