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
import co.ke.bsl.data.view.FCDCottonGinneryInspectionBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CottonGinneryInspection;
import co.ke.bsl.pojo.SisalFactoryInspection;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.FCDCottonGinneryInspectionCusomListAdapter;
import co.ke.bsl.ui.views.widgets.FCDSisalFactoryInspectionCustomListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDCottonGinneryInspectionConformityAssessmentStep1 extends Fragment implements BlockingStep {



    private String documentNumber, documentDate, nameOfApplicant, ginningLicence, localID, cbPartnerID;

    FCDCottonGinneryInspectionCusomListAdapter adapter;
    private ArrayList<CottonGinneryInspection> cottonGinneryInspectionnArrayList = new ArrayList<>();

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private HashMap<Integer, String> localhash = new HashMap<>();
    ListView cottonGinnerryinspectionuserlist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdcotton_ginnery_inspection_conformity_assessment_step1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getCottonGinneryInspectionList();



    }

    private void getCottonGinneryInspectionList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.cottonGinnerryinspectionuserlist);
        cottonGinneryInspectionnArrayList.clear();
        List<CottonGinneryInspection> cottonGinneryInspectionlist = db.getCottonGinneryInspectionList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = cottonGinneryInspectionlist.size();

        for(int i=0; i<cottonGinneryInspectionlist.size(); i++){

            String retreivedDocumentDate = cottonGinneryInspectionlist.get(i).getDocumentDate();
            //Toast.makeText(getContext(), "No Surevy Has Been Created ", Toast.LENGTH_LONG).show();
            cbPartnerID = cottonGinneryInspectionlist.get(i).getNameOfApplicant();

            for(CBPartner partner : cbPartnerList){
                if(null != cottonGinneryInspectionlist.get(i).getNameOfApplicant() && cottonGinneryInspectionlist.get(i).getNameOfApplicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            if (retreivedDocumentDate != null) {
                cottonGinneryInspectionnArrayList.add(new CottonGinneryInspection(
                        cottonGinneryInspectionlist.get(i).getDocumentNumber(),
                        cottonGinneryInspectionlist.get(i).getDocumentDate(),
                        cbPartner,
                        cottonGinneryInspectionlist.get(i).getGinningLicence()));


            }

            localhash.put(i, cottonGinneryInspectionlist.get(i).getLocalId());
            adapter = new FCDCottonGinneryInspectionCusomListAdapter(getActivity(), cottonGinneryInspectionnArrayList);
            list.setAdapter(adapter);
        }

//

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_date);
                TextView textviewginningLicence = viewClicked.findViewById(R.id.textviewlicence_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicant);

                documentNumber = cottonGinneryInspectionnArrayList.get(position).getDocumentNumber();
                documentDate = cottonGinneryInspectionnArrayList.get(position).getDocumentDate();
                ginningLicence = cottonGinneryInspectionnArrayList.get(position).getGinningLicence();
                nameOfApplicant = cottonGinneryInspectionnArrayList.get(position).getNameOfApplicant();

                localID = localhash.get(position);

            }
        });
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        FCDCottonGinneryInspectionBus fCDCottonGinneryInspectionBus = FCDCottonGinneryInspectionBus.getInstance();

        fCDCottonGinneryInspectionBus.setDocumentNumber(documentNumber);
        fCDCottonGinneryInspectionBus.setDocumentDate(documentDate);
        fCDCottonGinneryInspectionBus.setGinningLicence(ginningLicence);
        fCDCottonGinneryInspectionBus.setNameOfApplicant(nameOfApplicant);
        fCDCottonGinneryInspectionBus.setLocalId(localID);

        if (fCDCottonGinneryInspectionBus.getLocalId() != null && !fCDCottonGinneryInspectionBus.getLocalId().isEmpty()) {

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
