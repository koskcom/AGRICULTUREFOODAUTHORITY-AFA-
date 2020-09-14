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
import co.ke.bsl.data.model.CoffeeGrowerMarketingAgent;
import co.ke.bsl.data.view.CoffeeGrowerMarketingAgentBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CoffeeGrowerMarketingAgentDetails;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.CoffeeGrowerMarketingAgentListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeGrowerMarketingAgentChecklist extends Fragment implements BlockingStep {
    @BindView(R.id.coffeeGrowerUserlist)
    ListView coffeeGrowerUserlist;

    AFADatabaseAdapter db;
    AFA app;
    String localID;
    String cbPartnerID;
    private String document_number, document_date, applicant_name, licence_number;
    private ArrayList<CoffeeGrowerMarketingAgentDetails> coffeeGrowerMarketingAgentDetailsArrayList = new ArrayList<>();
    private CoffeeGrowerMarketingAgentListAdapter adapter;
    private HashMap<Integer, String> localhash = new HashMap<>();


    public CoffeeGrowerMarketingAgentChecklist() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_grower_marketing_agent_checklist, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();

        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreated==========");
        getListOfCoffeeGrowerMarketingAgent();

    }

    private void getListOfCoffeeGrowerMarketingAgent() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.coffeeGrowerUserlist);
        coffeeGrowerMarketingAgentDetailsArrayList.clear();
        List<CoffeeGrowerMarketingAgentDetails> coffeeGrowerMarketingAgentDetailsList = db.getCoffeeGrowerMarketingAgentDetailsList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = coffeeGrowerMarketingAgentDetailsList.size();
        System.out.println(listSize + "===============coffeeGrowerMarketingAgentDetailsList==========");

        for (int i = 0; i < coffeeGrowerMarketingAgentDetailsList.size(); i++) {
            System.out.println("Document Number=== " + coffeeGrowerMarketingAgentDetailsList.get(i).getDocumentNumber());

            String retreivedDocumentDate = coffeeGrowerMarketingAgentDetailsList.get(i).getDocumentDate();
//            String convertedDocumentDate = null;
//            if(null != retreivedDocumentDate){
//                convertedDocumentDate = DateConverter.fromDateToString(DateConverter.toDate(retreivedDocumentDate));
//            }
            cbPartnerID = coffeeGrowerMarketingAgentDetailsList.get(i).getC_BPartner_ID();

            for(CBPartner partner : cbPartnerList){
                if(null != coffeeGrowerMarketingAgentDetailsList.get(i).getC_BPartner_ID() && coffeeGrowerMarketingAgentDetailsList.get(i).getC_BPartner_ID().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }
            if (retreivedDocumentDate != null) {
                coffeeGrowerMarketingAgentDetailsArrayList.add(new CoffeeGrowerMarketingAgentDetails(
                        coffeeGrowerMarketingAgentDetailsList.get(i).getDocumentNumber(),
                        retreivedDocumentDate,
                        cbPartner,
                        coffeeGrowerMarketingAgentDetailsList.get(i).getLicenceNumber()));
            }


            localhash.put(i, coffeeGrowerMarketingAgentDetailsList.get(i).getLocalID());
            adapter = new CoffeeGrowerMarketingAgentListAdapter(getActivity(), coffeeGrowerMarketingAgentDetailsArrayList);
            list.setAdapter(adapter);
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.tv_cg_document_number);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.tv_cg_document_date);
                TextView textviewAuthorityNumber = viewClicked.findViewById(R.id.tv_cg_licence_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.tv_cg_name_of_applicant);

                document_number = coffeeGrowerMarketingAgentDetailsArrayList.get(position).getDocumentNumber();
                document_date = coffeeGrowerMarketingAgentDetailsArrayList.get(position).getDocumentDate();
                licence_number = coffeeGrowerMarketingAgentDetailsArrayList.get(position).getLicenceNumber();
                applicant_name = coffeeGrowerMarketingAgentDetailsArrayList.get(position).getApplicantName();

                localID = localhash.get(position);

            }
        });
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        CoffeeGrowerMarketingAgentBus coffeeGrowerMarketingAgentBus = CoffeeGrowerMarketingAgentBus.getInstance();
        coffeeGrowerMarketingAgentBus.setDocumentNumber(document_number);
        coffeeGrowerMarketingAgentBus.setDocumentDate(document_date);
        coffeeGrowerMarketingAgentBus.setLicenceNumber(licence_number);
        coffeeGrowerMarketingAgentBus.setApplicantName(applicant_name);
        coffeeGrowerMarketingAgentBus.setLocalID(localID);
        if (coffeeGrowerMarketingAgentBus.getLocalID() != null && !coffeeGrowerMarketingAgentBus.getLocalID().isEmpty()) {

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
