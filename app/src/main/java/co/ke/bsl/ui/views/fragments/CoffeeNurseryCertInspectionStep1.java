package co.ke.bsl.ui.views.fragments;


import android.content.Context;
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
import co.ke.bsl.data.view.CoffeeNuerseryCertBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CoffeeNursercertInsp;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.activities.components.CoffeeNurseryCertificateActivity;
import co.ke.bsl.ui.views.adapters.CoffeeNurseryCertAdapter;
import co.ke.bsl.ui.views.widgets.CoffeeCustomAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeNurseryCertInspectionStep1 extends Fragment implements BlockingStep {

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    ListView userscoffeelist;

    private ArrayList<CoffeeNursercertInsp> coffeeNurseryInspectionlist = new ArrayList<>();

    CoffeeCustomAdapter adapter;
    private String localID, document_number, document_date, applicant_name, certificate_number;

    private String county, subcounty, location, sublocation, village;
    private String cbPartnerID;
    private HashMap<Integer, String> localhash = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_inspection_step1, container, false);
        ButterKnife.bind(this, view);


        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();

//        setSendDataToFragment(new CoffeeNurseryCertAdapter());


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getCoffeeList();

    }

    private void getCoffeeList() {

        if (null != coffeeNurseryInspectionlist) {
            coffeeNurseryInspectionlist.clear();
        }

        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.userscoffeelist);
        String cbPartner = "";
        coffeeNurseryInspectionlist.clear();
        List<CoffeeNursercertInsp> coffeeNursercertInsp = db.getCoffeeNursercertInspList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        int listSize = coffeeNursercertInsp.size();
        System.out.println(listSize + "===============Coffee Nursery Certificate Field Inspection Checklist ==========");

        for (int i = 0; i < coffeeNursercertInsp.size(); i++) {
            System.out.println("Document Number=== " + coffeeNursercertInsp.get(i).getDocumentNumber());
            System.out.println("the Date passed is " + coffeeNursercertInsp.get(i).getDocumentaDate());
            System.out.println("the licence passed is " + coffeeNursercertInsp.get(i).getCertificateNumber());
            System.out.println("the Applicant name passed is " + coffeeNursercertInsp.get(i).getApplicantName());
            System.out.println("the county id passed is " + coffeeNursercertInsp.get(i).getCounty());

            String retreivedDocumentDate = coffeeNursercertInsp.get(i).getCertificateNumber();

            cbPartnerID = coffeeNursercertInsp.get(i).getApplicantName();

            for (CBPartner partner : cbPartnerList) {
                if (null != coffeeNursercertInsp.get(i).getApplicantName() && coffeeNursercertInsp.get(i).getApplicantName().equals(partner.getC_bpartner_id())) {
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else {
                    System.out.println(app + " cbPartner not found");
                }
            }

            if (retreivedDocumentDate != null) {
                coffeeNurseryInspectionlist.add(new CoffeeNursercertInsp
                        (coffeeNursercertInsp.get(i).getDocumentNumber(),
                                coffeeNursercertInsp.get(i).getDocumentaDate(),
                                cbPartner,
                                coffeeNursercertInsp.get(i).getCertificateNumber(),
                                coffeeNursercertInsp.get(i).getCounty(),
                                coffeeNursercertInsp.get(i).getSub_county(),
                                coffeeNursercertInsp.get(i).getLocation(),
                                coffeeNursercertInsp.get(i).getSub_location(),
                                coffeeNursercertInsp.get(i).getVillage()));
            }

            localhash.put(i, coffeeNursercertInsp.get(i).getLocalID());
            adapter = new CoffeeCustomAdapter(getActivity(), coffeeNurseryInspectionlist);
            list.setAdapter(adapter);

        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_number);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocumentdatedate);
                TextView textviewcertifcateno = viewClicked.findViewById(R.id.textviewcert_numbernumber);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicant_name);

                document_number = coffeeNurseryInspectionlist.get(position).getDocumentNumber();
                document_date = coffeeNurseryInspectionlist.get(position).getDocumentaDate();
                certificate_number = coffeeNurseryInspectionlist.get(position).getCertificateNumber();
                applicant_name = coffeeNurseryInspectionlist.get(position).getApplicantName();
                localID = localhash.get(position);


                county = coffeeNurseryInspectionlist.get(position).getCounty();
                subcounty = coffeeNurseryInspectionlist.get(position).getSub_county();
                location = coffeeNurseryInspectionlist.get(position).getLocation();
                sublocation = coffeeNurseryInspectionlist.get(position).getSub_location();
                village = coffeeNurseryInspectionlist.get(position).getVillage();

                db.unselectCoffeeNurseryInsp();
                db.selectCoffeeNurseryInsp(localID);
                app.getCoffeeNurseryInspection().setValue(coffeeNurseryInspectionlist.get(position));
            }
        });
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        CoffeeNuerseryCertBus coffeeNuerseryCertBus = CoffeeNuerseryCertBus.getInstance();

        coffeeNuerseryCertBus.setDocumentNumber(document_number);
        coffeeNuerseryCertBus.setDocumentaDate(document_date);
        coffeeNuerseryCertBus.setApplicantName(applicant_name);
        coffeeNuerseryCertBus.setCertificateNumber(certificate_number);
        coffeeNuerseryCertBus.setLocalID(localID);
        coffeeNuerseryCertBus.setCounty(county);
        coffeeNuerseryCertBus.setSub_county(subcounty);
        coffeeNuerseryCertBus.setLocation(location);
        coffeeNuerseryCertBus.setSub_location(sublocation);
        coffeeNuerseryCertBus.setVillage(village);


        if (coffeeNuerseryCertBus.getLocalID() != null && !coffeeNuerseryCertBus.getLocalID().isEmpty()) {

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
