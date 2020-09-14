package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.FCDSisalSpinningFactoryInspection;
import co.ke.bsl.data.view.FCDSisalSpinningFactoryInspectionBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.SisalFactoryInspection;
import co.ke.bsl.pojo.SisalSpinningFactoryInspection;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.views.widgets.FCDSisalFactoryInspectionCustomListAdapter;
import co.ke.bsl.ui.views.widgets.FCDSisalSpinningFactoryInspectionCustomListAdapter;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDSisalSpinningFactoryInspectionConformityAssessmentStep1 extends Fragment implements BlockingStep {


    private String documentNumber, documentDate, nameOfApplicant, sisalSpinningExportNumber, localID;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    String cbPartnerID;
    ListView factoryspinninguserlist;
    FCDSisalSpinningFactoryInspectionCustomListAdapter adapter;

    private ArrayList<SisalSpinningFactoryInspection> sisalSpinningFactoryInspectionArrayList = new ArrayList<>();
    private HashMap<Integer, String> localhash = new HashMap<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdsisal_spinning_factory_inspection_conformity_assessment_step1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getSisalSpinningFactoryInspectionList();


    }

    private void getSisalSpinningFactoryInspectionList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.factoryspinninguserlist);
        sisalSpinningFactoryInspectionArrayList.clear();
        List<SisalSpinningFactoryInspection> sisalSpinningFactoryInspectionlist = db.getSisalSpinningFactoryInspectionList();

        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = sisalSpinningFactoryInspectionlist.size();
        System.out.println(listSize + "===============SisalSpinningFactoryInspection==========");

        for (int i = 0; i < sisalSpinningFactoryInspectionlist.size(); i++) {
            System.out.println("Document Number=== " + sisalSpinningFactoryInspectionlist.get(i).getDocumentNumber());

            String retreivedDocumentDate = sisalSpinningFactoryInspectionlist.get(i).getDocumentDate();

            cbPartnerID = sisalSpinningFactoryInspectionlist.get(i).getNameOfApplicant();

            for(CBPartner partner : cbPartnerList){
                if(null != cbPartnerID && cbPartnerID.equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    //System.out.println(app + " cbPartner not found");
                }
            }


            if (retreivedDocumentDate != null) {
                sisalSpinningFactoryInspectionArrayList.add(new SisalSpinningFactoryInspection(
                        sisalSpinningFactoryInspectionlist.get(i).getDocumentNumber(),
                        retreivedDocumentDate,
                        cbPartner,
                        sisalSpinningFactoryInspectionlist.get(i).getSisalSpinningExportNumber()));
            }


            localhash.put(i, sisalSpinningFactoryInspectionlist.get(i).getLocalID());
            adapter = new FCDSisalSpinningFactoryInspectionCustomListAdapter(getActivity(), sisalSpinningFactoryInspectionArrayList);
            list.setAdapter(adapter);
        }


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_date);
                TextView textviewsisalSpinningExportNumber = viewClicked.findViewById(R.id.textviewlicence_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicant);

                documentNumber = sisalSpinningFactoryInspectionArrayList.get(position).getDocumentNumber();
                documentDate = sisalSpinningFactoryInspectionArrayList.get(position).getDocumentDate();
                sisalSpinningExportNumber = sisalSpinningFactoryInspectionArrayList.get(position).getSisalSpinningExportNumber();
                nameOfApplicant = sisalSpinningFactoryInspectionArrayList.get(position).getNameOfApplicant();

                localID = localhash.get(position);

            }
        });
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        FCDSisalSpinningFactoryInspectionBus fCDSisalSpinningFactoryInspectionBus = FCDSisalSpinningFactoryInspectionBus.getInstance();

        fCDSisalSpinningFactoryInspectionBus.setDocumentNumber(documentNumber);
        fCDSisalSpinningFactoryInspectionBus.setDocumentDate(documentDate);
        fCDSisalSpinningFactoryInspectionBus.setSisalSpinningExportNumber(sisalSpinningExportNumber);
        fCDSisalSpinningFactoryInspectionBus.setNameOfApplicant(nameOfApplicant);
        fCDSisalSpinningFactoryInspectionBus.setLocalID(localID);


        if (fCDSisalSpinningFactoryInspectionBus.getLocalID() != null && !fCDSisalSpinningFactoryInspectionBus.getLocalID().isEmpty()) {
            callback.goToNextStep();

        } else {
            Toast.makeText(app, "No Item Selected", Toast.LENGTH_SHORT).show();
            return;
        }


    }

    private boolean validateEditText(CustomEditText customEditText, String customEditTextString) {

        boolean result = false;

        if (TextUtils.isEmpty(customEditTextString)) {
            customEditText.setError("Field Required ");
            result = false;
        } else {
            customEditText.setError(null);
            result = true;
        }

        return result;
    }

    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString) {

        boolean result = false;

        if (!checkBox.isChecked()) {
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                result = false;
            }
            else result =true;
        } else {
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

    }
}
