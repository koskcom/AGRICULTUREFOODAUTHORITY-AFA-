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
import co.ke.bsl.data.view.HorticultureProduceTransportationBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.HorticultureProduceTransportationDetails;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.HorticultureProduceTransportationCustomListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorticultureProduceTransportationChecklist extends Fragment implements BlockingStep {

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    HorticultureProduceTransportationCustomListAdapter adapter;
    private ArrayList<HorticultureProduceTransportationDetails> horticultureProduceTransportationsArrayList = new ArrayList<>();

    private String documentNumber, documentDate, nameOfApplicant, exportLicence, telephone, location, email, localID;
    private String cbPartnerID;
    private HashMap<Integer, String> localhash = new HashMap<>();



    public HorticultureProduceTransportationChecklist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horticulture_produce_transportation_checklist, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getProduceTransportationList();


    }



    private void getProduceTransportationList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.usershcdproduceTransportationlist);
        horticultureProduceTransportationsArrayList.clear();

        List<HorticultureProduceTransportationDetails> nurseyInspection = db.getHorticultureProduceTransportationDetailsList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = nurseyInspection.size();
        System.out.println(listSize + "===============nurseyInspection Checklist ==========");

        for (int i = 0; i < nurseyInspection.size(); i++) {
            System.out.println("Document Number=== " + nurseyInspection.get(i).getDocumentNumber());
            System.out.println("the Date passed is " + nurseyInspection.get(i).getDocumentDate());
            System.out.println("the licence passed is " + nurseyInspection.get(i).getExportLicence());
            System.out.println("the Applicant name passed is " + nurseyInspection.get(i).getNameOfApllicant());

            String retreivedDocumentDate = nurseyInspection.get(i).getDocumentDate();

            cbPartnerID = nurseyInspection.get(i).getNameOfApllicant();

            for(CBPartner partner : cbPartnerList){
                if(null != nurseyInspection.get(i).getNameOfApllicant() && nurseyInspection.get(i).getNameOfApllicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            if (retreivedDocumentDate != null) {
                horticultureProduceTransportationsArrayList.add(new HorticultureProduceTransportationDetails
                        (cbPartner,
                                nurseyInspection.get(i).getDocumentNumber(),
                                nurseyInspection.get(i).getDocumentDate(),
                                nurseyInspection.get(i).getExportLicence()
                                ));
            }

            localhash.put(i,nurseyInspection.get(i).getLocalID());
            adapter = new HorticultureProduceTransportationCustomListAdapter(getActivity(), horticultureProduceTransportationsArrayList);
            list.setAdapter(adapter);


        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_n);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_d);
                TextView textviewcertifcateno = viewClicked.findViewById(R.id.textviewlicence_number_no);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicantt);

                documentNumber = horticultureProduceTransportationsArrayList.get(position).getDocumentNumber();
                documentDate = horticultureProduceTransportationsArrayList.get(position).getDocumentDate();
                exportLicence = horticultureProduceTransportationsArrayList.get(position).getExportLicence();
                nameOfApplicant = horticultureProduceTransportationsArrayList.get(position).getNameOfApllicant();

                localID = localhash.get(position);

            }
        });
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {


        HorticultureProduceTransportationBus horticultureProduceTransportationBus = HorticultureProduceTransportationBus.getInstance();
        horticultureProduceTransportationBus.setDocumentNumber(documentNumber);
        horticultureProduceTransportationBus.setDocumentDate(documentDate);
        horticultureProduceTransportationBus.setExportLicence(exportLicence);
        horticultureProduceTransportationBus.setNameOfApllicant(nameOfApplicant);
        horticultureProduceTransportationBus.setLocalID(localID);

        if (horticultureProduceTransportationBus.getLocalID() != null && !horticultureProduceTransportationBus.getLocalID().isEmpty()) {

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
