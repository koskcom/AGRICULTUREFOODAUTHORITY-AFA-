package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
import co.ke.bsl.data.model.CoffeeExporterDealerInspection;
import co.ke.bsl.data.view.CoffeeExporterDealerInspectionBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CoffeeExporterDealerInspectionDetails;
import co.ke.bsl.ui.views.widgets.CoffeeExporterDealerInspactionListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeExporterDealerInspectionChecklist extends Fragment implements BlockingStep {
    @BindView(R.id.coffeeExporterUserlist)
    ListView coffeeExporterUserlist;

    AFADatabaseAdapter db;
    AFA app;
    String localID;
    String cbPartnerID;
    private String document_number, document_date, applicant_name, licence_number;
    private ArrayList<CoffeeExporterDealerInspectionDetails> coffeeExporterDealerInspectionDetailsArrayList = new ArrayList<>();
    private CoffeeExporterDealerInspactionListAdapter adapter;
    private HashMap<Integer, String> localhash = new HashMap<>();



    public CoffeeExporterDealerInspectionChecklist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_exporter_dealer_inspection_checklist, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();
        
        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreated==========");
        getListOfCoffeeExporterDealerInspection();

    }


    private void getListOfCoffeeExporterDealerInspection() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.coffeeExporterUserlist);
        coffeeExporterDealerInspectionDetailsArrayList.clear();
        List<CoffeeExporterDealerInspectionDetails> coffeeExporterDealerInspectionDetailsList = db.getCoffeeExporterDealerInspectionDetailsList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = coffeeExporterDealerInspectionDetailsList.size();
        System.out.println(listSize + "===============coffeeGrowerMarketingAgentDetailsList==========");

        for (int i = 0; i < coffeeExporterDealerInspectionDetailsList.size(); i++) {
            System.out.println("Document Number=== " + coffeeExporterDealerInspectionDetailsList.get(i).getDocumentNumber());

            String retreivedDocumentDate = coffeeExporterDealerInspectionDetailsList.get(i).getDocumentDate();
//            String convertedDocumentDate = null;
//            if(null != retreivedDocumentDate){
//                convertedDocumentDate = DateConverter.fromDateToString(DateConverter.toDate(retreivedDocumentDate));
//            }
            cbPartnerID = coffeeExporterDealerInspectionDetailsList.get(i).getApplicantName();

            for(CBPartner partner : cbPartnerList){
                if(null != coffeeExporterDealerInspectionDetailsList.get(i).getApplicantName() && coffeeExporterDealerInspectionDetailsList.get(i).getApplicantName().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }


            if (retreivedDocumentDate != null) {
                coffeeExporterDealerInspectionDetailsArrayList.add(new CoffeeExporterDealerInspectionDetails(
                        coffeeExporterDealerInspectionDetailsList.get(i).getDocumentNumber(),
                        retreivedDocumentDate,
                        cbPartner,
                        coffeeExporterDealerInspectionDetailsList.get(i).getDealerLicenceNumber()));
            }


            localhash.put(i, coffeeExporterDealerInspectionDetailsList.get(i).getLocalID());
            adapter = new CoffeeExporterDealerInspactionListAdapter(getActivity(), coffeeExporterDealerInspectionDetailsArrayList);
            list.setAdapter(adapter);
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.tv_ce_document_number);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.tv_ce_document_date);
                TextView textviewAuthorityNumber = viewClicked.findViewById(R.id.tv_ce_licence_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.tv_ce_name_of_applicant);

                document_number = coffeeExporterDealerInspectionDetailsArrayList.get(position).getDocumentNumber();
                document_date = coffeeExporterDealerInspectionDetailsArrayList.get(position).getDocumentDate();
                licence_number = coffeeExporterDealerInspectionDetailsArrayList.get(position).getDealerLicenceNumber();
                applicant_name = coffeeExporterDealerInspectionDetailsArrayList.get(position).getApplicantName();

                localID = localhash.get(position);

            }
        });
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        CoffeeExporterDealerInspectionBus coffeeExporterDealerInspectionBus = CoffeeExporterDealerInspectionBus.getInstance();
        coffeeExporterDealerInspectionBus.setDocumentNumber(document_number);
        coffeeExporterDealerInspectionBus.setDocumentDate(document_date);
        coffeeExporterDealerInspectionBus.setDealerLicenceNumber(licence_number);
        coffeeExporterDealerInspectionBus.setApplicantName(applicant_name);
        coffeeExporterDealerInspectionBus.setLocalID(localID);
        if (coffeeExporterDealerInspectionBus.getLocalID() != null && !coffeeExporterDealerInspectionBus.getLocalID().isEmpty()) {

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
