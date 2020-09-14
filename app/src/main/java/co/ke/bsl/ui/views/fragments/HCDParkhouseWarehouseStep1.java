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
import co.ke.bsl.data.view.HCDParkhouseWarehouseBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.FlowersConsolidators;
import co.ke.bsl.pojo.ParkhouseWarehouse;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.HCDFlowerConsolidatorsCustomListAdapter;
import co.ke.bsl.ui.views.widgets.ParkhouseWarehouseCustomListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDParkhouseWarehouseStep1 extends Fragment implements BlockingStep {

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private String documentNumber, documentDate,dealerCategory, nameOfApplicant, telephone, licenceNumber, email , county, location, produceCrops,exportLicence, localID;

    ParkhouseWarehouseCustomListAdapter adapter;
    private ArrayList<ParkhouseWarehouse> parkhouseWarehouselist = new ArrayList<>();
    private String cbPartnerID;
    private HashMap<Integer, String> localhash = new HashMap<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdparkhouse_warehouse_step1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getParkhouseWarehouseList();


    }

    private void getParkhouseWarehouseList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.usershParkhouseWarehouselist);
        parkhouseWarehouselist.clear();

        List<ParkhouseWarehouse> parkhouseWarehouse = db.getParkhouseWarehouseList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";
        int listSize = parkhouseWarehouse.size();
        System.out.println(listSize + "===============parkhouseWarehouseChecklist ==========");

        for (int i = 0; i < parkhouseWarehouse.size(); i++) {
            System.out.println("Document Number=== " + parkhouseWarehouse.get(i).getDocumentNumber());
            System.out.println("the Date passed is " + parkhouseWarehouse.get(i).getDocumentDate());
            System.out.println("the licence passed is " + parkhouseWarehouse.get(i).getLicenceNumber());
            System.out.println("the Applicant name passed is " + parkhouseWarehouse.get(i).getNameOfApplicant());

            String retreivedDocumentDate = parkhouseWarehouse.get(i).getDocumentDate();
            cbPartnerID = parkhouseWarehouse.get(i).getNameOfApplicant();

            for(CBPartner partner : cbPartnerList){
                if(null != parkhouseWarehouse.get(i).getNameOfApplicant() && parkhouseWarehouse.get(i).getNameOfApplicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            if (retreivedDocumentDate != null) {
                parkhouseWarehouselist.add(new ParkhouseWarehouse
                        (parkhouseWarehouse.get(i).getDocumentNumber(),
                                parkhouseWarehouse.get(i).getDocumentDate(),
                                parkhouseWarehouse.get(i).getDealerCategory(),
                                cbPartner,
                                parkhouseWarehouse.get(i).getTelephone(),
                                parkhouseWarehouse.get(i).getEmail(),
                                parkhouseWarehouse.get(i).getCounty(),
                                parkhouseWarehouse.get(i).getLocation(),
                                parkhouseWarehouse.get(i).getProduceCrops(),
                                parkhouseWarehouse.get(i).getLicenceNumber()));
            }

            localhash.put(i,parkhouseWarehouse.get(i).getLocalID());
            adapter = new ParkhouseWarehouseCustomListAdapter(getActivity(), parkhouseWarehouselist);
            list.setAdapter(adapter);


        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_n);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_d);
                TextView textviewcertifcateno = viewClicked.findViewById(R.id.textviewlicence_number_no);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicantt);

                documentNumber = parkhouseWarehouselist.get(position).getDocumentNumber();
                documentDate = parkhouseWarehouselist.get(position).getDocumentDate();
                licenceNumber = parkhouseWarehouselist.get(position).getLicenceNumber();
                nameOfApplicant = parkhouseWarehouselist.get(position).getNameOfApplicant();

                localID = localhash.get(position);


            }
        });
    }



    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        HCDParkhouseWarehouseBus hCDParkhouseWarehouseBus = HCDParkhouseWarehouseBus.getInstance();

        hCDParkhouseWarehouseBus.setDocumentNumber(documentNumber);
        hCDParkhouseWarehouseBus.setDocumentDate(documentDate);
        hCDParkhouseWarehouseBus.setDealerCategory(dealerCategory);
        hCDParkhouseWarehouseBus.setTelephone(telephone);
        hCDParkhouseWarehouseBus.setNameOfApplicant(nameOfApplicant);
        hCDParkhouseWarehouseBus.setEmail(email);
        hCDParkhouseWarehouseBus.setCounty(county);
        hCDParkhouseWarehouseBus.setLocation(location);
        hCDParkhouseWarehouseBus.setProduceCrops(produceCrops);
        hCDParkhouseWarehouseBus.setLocalID(localID);

        if (hCDParkhouseWarehouseBus.getLocalID() != null && !hCDParkhouseWarehouseBus.getLocalID().isEmpty()) {
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
