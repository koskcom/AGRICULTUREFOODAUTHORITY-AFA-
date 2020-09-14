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
import co.ke.bsl.data.view.HCDMangoQualityInspectionBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.MangoQualityInspection;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.MangoQualityInspectionCustomListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDMangoQualityInspectionChecklistStep1 extends Fragment implements BlockingStep {

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private String documentNumber, dosumentdate, inspectionRequestNo, exportersName, exportersAgentName, sizeOfConsignment, localID;

    private String cbPartnerID;
    private HashMap<Integer, String> localhash = new HashMap<>();

    MangoQualityInspectionCustomListAdapter adapter;
    private ArrayList<MangoQualityInspection> mangoQualityInspectionlist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdmango_quality_inspection_checklist_step1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getMangoQualityInspectionList();


    }

    private void getMangoQualityInspectionList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.usershcdmangoqualitylist);
        mangoQualityInspectionlist.clear();

        List<MangoQualityInspection> mangoQualityInspection = db.getMangoQualityInspectionList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = mangoQualityInspection.size();
        System.out.println(listSize + "===============mangoQualityInspection Checklist ==========");

        for (int i = 0; i < mangoQualityInspection.size(); i++) {
            System.out.println("Document Number=== " + mangoQualityInspection.get(i).getDocumentNumber());


            String retreivedDocumentDate = mangoQualityInspection.get(i).getDocumentdate();
            cbPartnerID = mangoQualityInspection.get(i).getExportersName();

            for(CBPartner partner : cbPartnerList){
                if(null != mangoQualityInspection.get(i).getExportersName() && mangoQualityInspection.get(i).getExportersName().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }


            if (retreivedDocumentDate != null) {
                mangoQualityInspectionlist.add(new MangoQualityInspection
                        (mangoQualityInspection.get(i).getDocumentNumber(),
                                mangoQualityInspection.get(i).getDocumentdate(),
                                mangoQualityInspection.get(i).getInspectionRequestNo(),
                                cbPartner,
                                mangoQualityInspection.get(i).getExportersAgentName(),
                                mangoQualityInspection.get(i).getSizeOfConsignment()));
            }

            localhash.put(i, mangoQualityInspection.get(i).getLocalID());
            adapter = new MangoQualityInspectionCustomListAdapter(getActivity(), mangoQualityInspectionlist);
            list.setAdapter(adapter);


        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_n);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_d);
                TextView textviewexportLicence = viewClicked.findViewById(R.id.textviewlicence_number_no);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicantt);

                documentNumber = mangoQualityInspectionlist.get(position).getDocumentNumber();
                dosumentdate = mangoQualityInspectionlist.get(position).getDocumentdate();
                inspectionRequestNo = mangoQualityInspectionlist.get(position).getInspectionRequestNo();
                exportersName = mangoQualityInspectionlist.get(position).getExportersName();

                localID = localhash.get(position);

            }
        });
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        HCDMangoQualityInspectionBus hCDMangoQualityInspectionBus = HCDMangoQualityInspectionBus.getInstance();
        hCDMangoQualityInspectionBus.setDocumentNumber(documentNumber);
        hCDMangoQualityInspectionBus.setDosumentdate(dosumentdate);
        hCDMangoQualityInspectionBus.setInspectionRequestNo(inspectionRequestNo);
        hCDMangoQualityInspectionBus.setExportersName(exportersName);
        hCDMangoQualityInspectionBus.setExportersAgentName(exportersAgentName);
        hCDMangoQualityInspectionBus.setSizeOfConsignment(sizeOfConsignment);
        hCDMangoQualityInspectionBus.setLocalID(localID);
        if (hCDMangoQualityInspectionBus.getLocalID() != null && !hCDMangoQualityInspectionBus.getLocalID().isEmpty()) {
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
