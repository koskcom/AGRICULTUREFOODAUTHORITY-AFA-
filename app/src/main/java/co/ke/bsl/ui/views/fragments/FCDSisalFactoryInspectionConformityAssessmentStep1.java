package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import co.ke.bsl.data.view.FCDSisalFactoryInspectionBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.SisalFactoryInspection;
import co.ke.bsl.pojo.TeaPackerChecklist;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.FCDSisalFactoryInspectionCustomListAdapter;
import co.ke.bsl.ui.views.widgets.TeaPackerCustomListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDSisalFactoryInspectionConformityAssessmentStep1 extends Fragment implements BlockingStep {

    private String documentNumber, documentDate, nameOfApplicant,sisalSpinningExportNumber,localID;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private String cbPartnerID;
    ListView factoryinspectionuserlist;

    FCDSisalFactoryInspectionCustomListAdapter adapter;
    private ArrayList<SisalFactoryInspection> sisalFactoryInspectionArrayList = new ArrayList<>();
    private HashMap<Integer, String> localhash = new HashMap<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdsisal_factory_inspection_conformity_assessment_step1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getSisalFactoryInspectionList();



    }

    private void getSisalFactoryInspectionList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.factoryinspectionuserlist);
        sisalFactoryInspectionArrayList.clear();
        List<SisalFactoryInspection> sisalFactoryInspectionlist = db.getSisalFactoryInspectionList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = sisalFactoryInspectionlist.size();

        for(int i=0; i<sisalFactoryInspectionlist.size(); i++){

            String retreivedDocumentDate = sisalFactoryInspectionlist.get(i).getDocumentDate();
            //Toast.makeText(getContext(), "No Surevy Has Been Created ", Toast.LENGTH_LONG).show();
            cbPartnerID = sisalFactoryInspectionlist.get(i).getNameOfApplicant();


            for(CBPartner partner : cbPartnerList){
                if(null != cbPartnerID && cbPartnerID.equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            System.out.println("cbPartnerID" + cbPartnerID + " CBPartner " + cbPartner);

            if (retreivedDocumentDate != null) {
                sisalFactoryInspectionArrayList.add(new SisalFactoryInspection(
                        sisalFactoryInspectionlist.get(i).getDocumentNumber(),
                        sisalFactoryInspectionlist.get(i).getDocumentDate(),
                        cbPartner,
                        sisalFactoryInspectionlist.get(i).getSisalSpinningExportNumber()));


            }

            localhash.put(i, sisalFactoryInspectionlist.get(i).getLocalID());
            adapter = new FCDSisalFactoryInspectionCustomListAdapter(getActivity(), sisalFactoryInspectionArrayList);
            list.setAdapter(adapter);
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_date);
                TextView textviewsisalSpinningExportNumber = viewClicked.findViewById(R.id.textviewlicence_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicant);

                documentNumber = sisalFactoryInspectionArrayList.get(position).getDocumentNumber();
                documentDate = sisalFactoryInspectionArrayList.get(position).getDocumentDate();
                sisalSpinningExportNumber = sisalFactoryInspectionArrayList.get(position).getSisalSpinningExportNumber();
                nameOfApplicant = sisalFactoryInspectionArrayList.get(position).getNameOfApplicant();

                localID = localhash.get(position);

            }
        });
    }



    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        FCDSisalFactoryInspectionBus fCDSisalFactoryInspectionBus = FCDSisalFactoryInspectionBus.getInstance();
        fCDSisalFactoryInspectionBus.setDocumentNumber(documentNumber);
        fCDSisalFactoryInspectionBus.setDocumentDate(documentDate);
        fCDSisalFactoryInspectionBus.setNameOfApplicant(nameOfApplicant);
        fCDSisalFactoryInspectionBus.setSisalSpinningExportNumber(sisalSpinningExportNumber);
        fCDSisalFactoryInspectionBus.setLocalID(localID);


        if (fCDSisalFactoryInspectionBus.getLocalID() != null && !fCDSisalFactoryInspectionBus.getLocalID().isEmpty()) {

            callback.goToNextStep();
        } else {
            Toast.makeText(app, "No Item Selected", Toast.LENGTH_SHORT).show();
            return;
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
}
