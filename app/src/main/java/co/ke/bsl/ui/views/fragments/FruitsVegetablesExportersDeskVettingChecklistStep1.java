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
import co.ke.bsl.data.view.FruitsVegetablesExportersDeskVettingBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.FlowersConsolidators;
import co.ke.bsl.pojo.FruitsAndVegetablesExporters;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.FruitsAndVegetablesCustomListAdapter;
import co.ke.bsl.ui.views.widgets.HCDFlowerConsolidatorsCustomListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FruitsVegetablesExportersDeskVettingChecklistStep1 extends Fragment implements BlockingStep {

    FruitsAndVegetablesCustomListAdapter adapter;
    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private ArrayList<FruitsAndVegetablesExporters> fruitsAndVegetablesExporterslist = new ArrayList<>();
    private String cbPartnerID;
    private HashMap<Integer, String> localhash = new HashMap<>();


    private String documentNumber, documentDate,  nameOfApplicant, telephone, email, postaladdress, exportLicence, localID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fruits_vegetables_exporters_desk_vetting_checklist_step1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getFruitsAndVegetablesExportersList();


    }

    private void getFruitsAndVegetablesExportersList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.usershcdfruitsvegetableseporterslist);
        fruitsAndVegetablesExporterslist.clear();

        List<FruitsAndVegetablesExporters> fruitsAndVegetablesExporters = db.getFruitsAndVegetablesExportersList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = fruitsAndVegetablesExporters.size();
        System.out.println(listSize + "===============fruitsAndVegetablesExporters Checklist ==========");

        for (int i = 0; i < fruitsAndVegetablesExporters.size(); i++) {
            System.out.println("Document Number=== " + fruitsAndVegetablesExporters.get(i).getDocumentNumber());


            String retreivedDocumentDate = fruitsAndVegetablesExporters.get(i).getDocumentDate();
            cbPartnerID = fruitsAndVegetablesExporters.get(i).getNameOfApplicant();

            for(CBPartner partner : cbPartnerList){
                if(null != fruitsAndVegetablesExporters.get(i).getNameOfApplicant() && fruitsAndVegetablesExporters.get(i).getNameOfApplicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }


            if (retreivedDocumentDate != null) {
                fruitsAndVegetablesExporterslist.add(new FruitsAndVegetablesExporters
                        (fruitsAndVegetablesExporters.get(i).getDocumentNumber(),
                                fruitsAndVegetablesExporters.get(i).getDocumentDate(),
                                cbPartner,
                                fruitsAndVegetablesExporters.get(i).getTelephone(),
                                fruitsAndVegetablesExporters.get(i).getEmail(),
                                fruitsAndVegetablesExporters.get(i).getPostaladdress(),
                                fruitsAndVegetablesExporters.get(i).getExportLicence()
                        ));
            }

            localhash.put(i, fruitsAndVegetablesExporters.get(i).getLocalID());
            adapter = new FruitsAndVegetablesCustomListAdapter(getActivity(), fruitsAndVegetablesExporterslist);
            list.setAdapter(adapter);


        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_n);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_d);
                TextView textviewexportLicence = viewClicked.findViewById(R.id.textviewlicence_number_no);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicantt);

                documentNumber = fruitsAndVegetablesExporterslist.get(position).getDocumentNumber();
                documentDate = fruitsAndVegetablesExporterslist.get(position).getDocumentDate();
                nameOfApplicant = fruitsAndVegetablesExporterslist.get(position).getNameOfApplicant();
                exportLicence = fruitsAndVegetablesExporterslist.get(position).getExportLicence();

                localID = localhash.get(position);

            }
        });
    }



    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        FruitsVegetablesExportersDeskVettingBus fruitsVegetablesExportersDeskVettingBus = FruitsVegetablesExportersDeskVettingBus.getInstance();
        fruitsVegetablesExportersDeskVettingBus.setDocumentNumber(documentNumber);
        fruitsVegetablesExportersDeskVettingBus.setDocumentDate(documentDate);
        fruitsVegetablesExportersDeskVettingBus.setNameOfApplicant(nameOfApplicant);
        fruitsVegetablesExportersDeskVettingBus.setTelephone(telephone);
        fruitsVegetablesExportersDeskVettingBus.setEmail(email);
        fruitsVegetablesExportersDeskVettingBus.setPostaladdress(postaladdress);
        fruitsVegetablesExportersDeskVettingBus.setExportLicence(exportLicence);
        fruitsVegetablesExportersDeskVettingBus.setLocalID(localID);
        if (fruitsVegetablesExportersDeskVettingBus.getLocalID() != null && !fruitsVegetablesExportersDeskVettingBus.getLocalID().isEmpty()) {
            callback.goToNextStep();

        } else {
            Toast.makeText(app, "No Inspection Selected", Toast.LENGTH_SHORT).show();
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
