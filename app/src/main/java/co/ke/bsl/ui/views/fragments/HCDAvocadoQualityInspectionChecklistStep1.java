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
import co.ke.bsl.data.view.FruitVegetableConsolidatorsBus;
import co.ke.bsl.data.view.HCDAvocadoQualityInspectionBus;
import co.ke.bsl.pojo.AvocadoQualityInspection;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.HCDFruitVegetableConsolidators;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.FruitVegetableConsolidatorsCustomListAdapter;
import co.ke.bsl.ui.views.widgets.HCDAvocadoQualityInspectionCustomListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDAvocadoQualityInspectionChecklistStep1 extends Fragment implements BlockingStep {


    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private ArrayList<AvocadoQualityInspection> avocadoQualityInspectionlist = new ArrayList<>();
    private HashMap<Integer, String> localhash = new HashMap<>();

    private String cbPartnerID;


    private String documentNumber, documentDate, nameOfApplicant, horticultureExporterRequest, fax, locationOfProduce, telephone;
    private String exportersAgentName, sizeOfConsignment, designation, localID, avocadoID;

    HCDAvocadoQualityInspectionCustomListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdavocado_quality_inspection_checklist_step1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getAvocadoQualityInspectionList();


    }

    private void getAvocadoQualityInspectionList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.usershcdconsolidatorslist);
        avocadoQualityInspectionlist.clear();

        HCDAvocadoQualityInspectionBus hCDAvocadoQualityInspectionBus = HCDAvocadoQualityInspectionBus.getInstance();


        List<AvocadoQualityInspection> avocadoQualityInspection = db.getAvocadoQualityInspectionList();

        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = avocadoQualityInspection.size();
        System.out.println(listSize + "===============getAvocadoQualityInspectionList Checklist ==========");

        for (int i = 0; i < avocadoQualityInspection.size(); i++) {
            System.out.println("Document Number=== " + avocadoQualityInspection.get(i).getDocumentNumber());


            String retreivedDocumentDate = avocadoQualityInspection.get(i).getDocumentDate();
            cbPartnerID = avocadoQualityInspection.get(i).getNameOfApplicant();

            for(CBPartner partner : cbPartnerList){
                if(null != avocadoQualityInspection.get(i).getNameOfApplicant() && avocadoQualityInspection.get(i).getNameOfApplicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            if (retreivedDocumentDate != null) {
                avocadoQualityInspectionlist.add(new AvocadoQualityInspection
                        (avocadoQualityInspection.get(i).getDocumentNumber(),
                                avocadoQualityInspection.get(i).getDocumentDate(),
                                cbPartner,
                                avocadoQualityInspection.get(i).getHorticultureExporterRequest(),
                                avocadoQualityInspection.get(i).getFax(),
                                avocadoQualityInspection.get(i).getLocationOfProduce(),
                                avocadoQualityInspection.get(i).getTelephone(),
                                avocadoQualityInspection.get(i).getExportersAgentName(),
                                avocadoQualityInspection.get(i).getSizeOfConsignment(),
                                avocadoQualityInspection.get(i).getDesignation(),
                                avocadoQualityInspection.get(i).getAFA_HCD_Avocado_Quality_Inspection_ID()
                        ));
            }

            localhash.put(i, avocadoQualityInspection.get(i).getLocalID());
            adapter = new HCDAvocadoQualityInspectionCustomListAdapter(getActivity(), avocadoQualityInspectionlist);
            list.setAdapter(adapter);


        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date);
                TextView textviewexportersAgentName = viewClicked.findViewById(R.id.textviewletter_of_comfort);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewapplicant_name);

                documentNumber = avocadoQualityInspectionlist.get(position).getDocumentNumber();
                documentDate = avocadoQualityInspectionlist.get(position).getDocumentDate();
                nameOfApplicant = avocadoQualityInspectionlist.get(position).getNameOfApplicant();
                exportersAgentName = avocadoQualityInspectionlist.get(position).getExportersAgentName();
                avocadoID = avocadoQualityInspectionlist.get(position).getAFA_HCD_Avocado_Quality_Inspection_ID();

                localID = localhash.get(position);

            }
        });
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        HCDAvocadoQualityInspectionBus hCDAvocadoQualityInspectionBus = HCDAvocadoQualityInspectionBus.getInstance();
        hCDAvocadoQualityInspectionBus.setAFA_HC_Avocadochecklist_ID(avocadoID);
        hCDAvocadoQualityInspectionBus.setDocumentNumber(documentNumber);
        hCDAvocadoQualityInspectionBus.setDocumentDate(documentDate);
        hCDAvocadoQualityInspectionBus.setNameOfApplicant(nameOfApplicant);
        hCDAvocadoQualityInspectionBus.setHorticultureExporterRequest(horticultureExporterRequest);
        hCDAvocadoQualityInspectionBus.setLocationOfProduce(locationOfProduce);
        hCDAvocadoQualityInspectionBus.setFax(fax);
        hCDAvocadoQualityInspectionBus.setTelephone(telephone);
        hCDAvocadoQualityInspectionBus.setExportersAgentName(exportersAgentName);
        hCDAvocadoQualityInspectionBus.setSizeOfConsignment(sizeOfConsignment);
        hCDAvocadoQualityInspectionBus.setDesignation(designation);
        hCDAvocadoQualityInspectionBus.setLocalID(localID);

        if (hCDAvocadoQualityInspectionBus.getLocalID() != null && !hCDAvocadoQualityInspectionBus.getLocalID().isEmpty()) {
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
