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
import co.ke.bsl.data.view.FCDCottonBuyingStoreInspectionBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CottonBuyingStoreInspection;
import co.ke.bsl.pojo.SisalFactoryInspection;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.FCDCottonBuyingStoreInspectionCustomListAdapter;
import co.ke.bsl.ui.views.widgets.FCDSisalFactoryInspectionCustomListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDCottonBuyingStoreInspectionConformityAssessmentStep1 extends Fragment implements BlockingStep {


    private String documentNumber, documentDate, nameOfApplicant, cottonExportNumber, localID, cbPartnerID;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    ListView cottonbuyernuserlist;

    FCDCottonBuyingStoreInspectionCustomListAdapter adapter;
    private ArrayList<CottonBuyingStoreInspection> cottonBuyingStoreInspectionArrayList = new ArrayList<>();
    private HashMap<Integer, String> localhash = new HashMap<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdcotton_buying_store_inspection_conformity_assessment_step1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getCottonBuyingStoreInspectionList();


    }

    private void getCottonBuyingStoreInspectionList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.cottonbuyernuserlist);
        cottonBuyingStoreInspectionArrayList.clear();
        List<CottonBuyingStoreInspection> cottonBuyingStoreInspectionlist = db.getCottonBuyingStoreInspectionList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = cottonBuyingStoreInspectionlist.size();

        for (int i = 0; i < cottonBuyingStoreInspectionlist.size(); i++) {

            String retreivedDocumentDate = cottonBuyingStoreInspectionlist.get(i).getDocumentDate();
            //Toast.makeText(getContext(), "No Surevy Has Been Created ", Toast.LENGTH_LONG).show();
            cbPartnerID = cottonBuyingStoreInspectionlist.get(i).getNameOfApplicant();

            for(CBPartner partner : cbPartnerList){
                if(null != cottonBuyingStoreInspectionlist.get(i).getNameOfApplicant() && cottonBuyingStoreInspectionlist.get(i).getNameOfApplicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            if (retreivedDocumentDate != null) {
                cottonBuyingStoreInspectionArrayList.add(new CottonBuyingStoreInspection(
                        cottonBuyingStoreInspectionlist.get(i).getDocumentNumber(),
                        cottonBuyingStoreInspectionlist.get(i).getDocumentDate(),
                        cbPartner,
                        cottonBuyingStoreInspectionlist.get(i).getCottonExportNumber()));


            }

            localhash.put(i, cottonBuyingStoreInspectionlist.get(i).getLocalID());
            adapter = new FCDCottonBuyingStoreInspectionCustomListAdapter(getActivity(), cottonBuyingStoreInspectionArrayList);
            list.setAdapter(adapter);
        }

//

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_date);
                TextView textviewcottonExportNumber = viewClicked.findViewById(R.id.textviewlicence_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicant);

                documentNumber = cottonBuyingStoreInspectionArrayList.get(position).getDocumentNumber();
                documentDate = cottonBuyingStoreInspectionArrayList.get(position).getDocumentDate();
                cottonExportNumber = cottonBuyingStoreInspectionArrayList.get(position).getCottonExportNumber();
                nameOfApplicant = cottonBuyingStoreInspectionArrayList.get(position).getNameOfApplicant();

                localID = localhash.get(position);

            }
        });
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        FCDCottonBuyingStoreInspectionBus fCDCottonBuyingStoreInspectionBus = FCDCottonBuyingStoreInspectionBus.getInstance();
        fCDCottonBuyingStoreInspectionBus.setDocumentNumber(documentNumber);
        fCDCottonBuyingStoreInspectionBus.setDocumentDate(documentDate);
        fCDCottonBuyingStoreInspectionBus.setNameOfApplicant(nameOfApplicant);
        fCDCottonBuyingStoreInspectionBus.setCottonExportNumber(cottonExportNumber);
        fCDCottonBuyingStoreInspectionBus.setLocalID(localID);


        if (fCDCottonBuyingStoreInspectionBus.getLocalID() != null && !fCDCottonBuyingStoreInspectionBus.getLocalID().isEmpty()) {

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
