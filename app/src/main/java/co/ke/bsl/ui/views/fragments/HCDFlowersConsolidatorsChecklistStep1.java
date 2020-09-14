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
import co.ke.bsl.data.view.HCDFlowersConsolidatorsBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CoffeeNursercertInsp;
import co.ke.bsl.pojo.FlowersConsolidators;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.CoffeeCustomAdapter;
import co.ke.bsl.ui.views.widgets.HCDFlowerConsolidatorsCustomListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDFlowersConsolidatorsChecklistStep1 extends Fragment implements BlockingStep {


    HCDFlowerConsolidatorsCustomListAdapter adapter;
    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private ArrayList<FlowersConsolidators> flowersConsolidatorslist = new ArrayList<>();
    private String cbPartnerID;
    private HashMap<Integer, String> localhash = new HashMap<>();


    private String document_number, document_date, name_of_applicant, export_licence, postal_address, email, telephone, localID;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdflowers_consolidators_checklist, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getFlowerConsolidatorsList();


    }

    private void getFlowerConsolidatorsList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.usershcdconsolidatorslist);
        flowersConsolidatorslist.clear();

        List<FlowersConsolidators> flowersConsolidators = db.getFlowersConsolidators();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";
        int listSize = flowersConsolidators.size();
        System.out.println(listSize + "===============Coffee Nursery Certificate Field Inspection Checklist ==========");

        for (int i = 0; i < flowersConsolidators.size(); i++) {
            System.out.println("Document Number=== " + flowersConsolidators.get(i).getDocument_number());
            System.out.println("the Date passed is " + flowersConsolidators.get(i).getDocument_date());
            System.out.println("the licence passed is " + flowersConsolidators.get(i).getExport_licence());
            System.out.println("the Applicant name passed is " + flowersConsolidators.get(i).getName_of_applicant());

            String retreivedDocumentDate = flowersConsolidators.get(i).getDocument_date();
            cbPartnerID = flowersConsolidators.get(i).getName_of_applicant();

            for(CBPartner partner : cbPartnerList){
                if(null != flowersConsolidators.get(i).getName_of_applicant() && flowersConsolidators.get(i).getName_of_applicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            if (retreivedDocumentDate != null) {
                flowersConsolidatorslist.add(new FlowersConsolidators
                        (flowersConsolidators.get(i).getDocument_number(),
                                flowersConsolidators.get(i).getDocument_date(),
                                cbPartner,
                                flowersConsolidators.get(i).getExport_licence(),
                                flowersConsolidators.get(i).getPostal_address(),
                                flowersConsolidators.get(i).getEmail(),
                                flowersConsolidators.get(i).getTelephone()));
            }

            localhash.put(i, flowersConsolidators.get(i).getLocalID());
            adapter = new HCDFlowerConsolidatorsCustomListAdapter(getActivity(), flowersConsolidatorslist);
            list.setAdapter(adapter);


        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_n);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_d);
                TextView textviewcertifcateno = viewClicked.findViewById(R.id.textviewlicence_number_no);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicantt);

                document_number = flowersConsolidatorslist.get(position).getDocument_number();
                document_date = flowersConsolidatorslist.get(position).getDocument_date();
                export_licence = flowersConsolidatorslist.get(position).getExport_licence();
                name_of_applicant = flowersConsolidatorslist.get(position).getName_of_applicant();

                localID = localhash.get(position);

            }
        });
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        HCDFlowersConsolidatorsBus hCDFlowersConsolidatorsBus = HCDFlowersConsolidatorsBus.getInstance();

        hCDFlowersConsolidatorsBus.setDocument_number(document_number);
        hCDFlowersConsolidatorsBus.setDocument_date(document_date);
        hCDFlowersConsolidatorsBus.setName_of_applicant(cbPartnerID);
        hCDFlowersConsolidatorsBus.setEmail(email);
        hCDFlowersConsolidatorsBus.setTelephone(telephone);
        hCDFlowersConsolidatorsBus.setPostal_address(postal_address);
        hCDFlowersConsolidatorsBus.setExport_licence(export_licence);
        hCDFlowersConsolidatorsBus.setLocalID(localID);
        if (hCDFlowersConsolidatorsBus.getLocalID() != null && !hCDFlowersConsolidatorsBus.getLocalID().isEmpty()) {
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
