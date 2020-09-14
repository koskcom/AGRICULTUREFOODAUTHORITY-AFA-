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

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.CoffeeMnagementAgentBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CoffeeManagementAgentInsp;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.CoffeeMagtListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeManagementAgentStep1 extends Fragment implements BlockingStep {

    @BindView(R.id.userManagementAgentlist)
    ListView userManagementAgentlist;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private ArrayList<CoffeeManagementAgentInsp> coffeeManagementAgentInspArrayList = new ArrayList<>();
    private CoffeeMagtListAdapter adapter;
    private String document_number, document_date, applicant_name, licence_number, principal_office;


    String localID;
    String cbPartnerID;

    private HashMap<Integer, String> localhash = new HashMap<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_management_agent_step1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        System.out.println("===============OnActicityCreated==========");
        getListOfCoffeeManagementAgent();

    }
    private void getListOfCoffeeManagementAgent() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.userManagementAgentlist);
        coffeeManagementAgentInspArrayList.clear();
        userManagementAgentlist.setAdapter(null);
        List<CoffeeManagementAgentInsp> coffeeManagementAgentInspList = db.getcoffeeManagementAgent();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        System.out.println("picking data from the db" + coffeeManagementAgentInspList.size());


        for (int i = 0; i < coffeeManagementAgentInspList.size(); i++) {
            System.out.println("Document Number=== " + coffeeManagementAgentInspList.get(i).getDocumnet_number());
            System.out.println("Document date=== " + coffeeManagementAgentInspList.get(i).getDocument_date());
            System.out.println("c_b_partenr_id=== " + coffeeManagementAgentInspList.get(i).getC_BPartner_ID());
            System.out.println("certificate_number=== " + coffeeManagementAgentInspList.get(i).getLicence_no());
            System.out.println("principal_office === " + coffeeManagementAgentInspList.get(i).getPrincipal_office());

            String retreivedDocumentDate = coffeeManagementAgentInspList.get(i).getDocument_date();
//            String convertedDocumentDate = null;
////            if(null != retreivedDocumentDate){
////                convertedDocumentDate = DateConverter.fromDateToString(DateConverter.toDate(retreivedDocumentDate));
////            }

            cbPartnerID = coffeeManagementAgentInspList.get(i).getC_BPartner_ID();

            for(CBPartner partner : cbPartnerList){
                if(null != coffeeManagementAgentInspList.get(i).getC_BPartner_ID() && coffeeManagementAgentInspList.get(i).getC_BPartner_ID().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            if(coffeeManagementAgentInspList.get(i).getDocumnet_number() != null){
                coffeeManagementAgentInspArrayList.add(new CoffeeManagementAgentInsp(
                        coffeeManagementAgentInspList.get(i).getDocumnet_number(),
                        retreivedDocumentDate,
                        cbPartner,
                        coffeeManagementAgentInspList.get(i).getLicence_no(),
                        coffeeManagementAgentInspList.get(i).getPrincipal_office()
                ));
            }



            localhash.put(i, coffeeManagementAgentInspList.get(i).getLocalID());
            adapter = new CoffeeMagtListAdapter(getActivity(), coffeeManagementAgentInspArrayList);
            list.setAdapter(adapter);
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_nno);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_ddate);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewapplicant_nname);
                TextView textviewLicenceNumber = viewClicked.findViewById(R.id.textviewlicence_nnumber);

                document_number = coffeeManagementAgentInspArrayList.get(position).getDocumnet_number();
                document_date = coffeeManagementAgentInspArrayList.get(position).getDocument_date();
                licence_number = coffeeManagementAgentInspArrayList.get(position).getLicence_no();
                applicant_name = coffeeManagementAgentInspArrayList.get(position).getC_BPartner_ID();
                principal_office = coffeeManagementAgentInspArrayList.get(position).getPrincipal_office();

                localID = localhash.get(position);

            }
        });
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        CoffeeMnagementAgentBus coffeeMnagementAgentBus = CoffeeMnagementAgentBus.getInstance();
        coffeeMnagementAgentBus.setDocument_date(document_date);
        coffeeMnagementAgentBus.setDocumnet_number(document_number);
        coffeeMnagementAgentBus.setName_of_applicant(applicant_name);
        coffeeMnagementAgentBus.setLicence_no(licence_number);
        coffeeMnagementAgentBus.setPrincipal_office(principal_office);
        coffeeMnagementAgentBus.setLocalID(localID);

        if (coffeeMnagementAgentBus.getLocalID() != null && !coffeeMnagementAgentBus.getLocalID().isEmpty()) {

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
