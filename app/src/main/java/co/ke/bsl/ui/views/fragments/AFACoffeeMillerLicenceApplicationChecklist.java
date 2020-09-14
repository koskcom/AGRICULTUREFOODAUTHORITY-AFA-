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
import co.ke.bsl.data.view.CoffeeMillerLicenceApplicationBus;
import co.ke.bsl.data.view.PulpingStationLicenseApplicationBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CoffeeMillerLicenceApplicationDetails;
import co.ke.bsl.ui.views.widgets.CoffeeMillerLicenseApplicationListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFACoffeeMillerLicenceApplicationChecklist extends Fragment implements BlockingStep {
    @BindView(R.id.coffeeMillerUserlist)
    ListView coffee_miller_user_list;

    AFADatabaseAdapter db;
    AFA app;
    String localID;
    String cbPartnerID;
    private String document_number, document_date, applicant_name, licence_number;
    private ArrayList<CoffeeMillerLicenceApplicationDetails> coffeeMillerLicenceApplicationDetailsArrayList = new ArrayList<>();
    private CoffeeMillerLicenseApplicationListAdapter adapter;
    private HashMap<Integer, String> localhash = new HashMap<>();




    public AFACoffeeMillerLicenceApplicationChecklist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afacoffee_miller_licence_application_checklist, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getActivity()).open();
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreated==========");
        getListOfCoffeeMillerLicenseApplication();

    }

    private void getListOfCoffeeMillerLicenseApplication() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.coffeeMillerUserlist);
        coffeeMillerLicenceApplicationDetailsArrayList.clear();
        List<CoffeeMillerLicenceApplicationDetails> coffeeMillerLicenceApplicationDetailsList = db.getCoffeeMillerLicenseApplicationList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";


        int listSize = coffeeMillerLicenceApplicationDetailsList.size();
        System.out.println(listSize + "===============coffeeMillerLicenceApplicationDetailsListSize==========");

        for (int i = 0; i < coffeeMillerLicenceApplicationDetailsList.size(); i++) {
            System.out.println("Document Number=== " + coffeeMillerLicenceApplicationDetailsList.get(i).getDocumentNumber());

            String retreivedDocumentDate = coffeeMillerLicenceApplicationDetailsList.get(i).getDocumentDate();
//            String convertedDocumentDate = null;
//            if(null != retreivedDocumentDate){
//                convertedDocumentDate = DateConverter.fromDateToString(DateConverter.toDate(retreivedDocumentDate));
//            }
            cbPartnerID = coffeeMillerLicenceApplicationDetailsList.get(i).getApplicantName();

            for(CBPartner partner : cbPartnerList){
                if(null != coffeeMillerLicenceApplicationDetailsList.get(i).getApplicantName() && coffeeMillerLicenceApplicationDetailsList.get(i).getApplicantName().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            if (retreivedDocumentDate != null) {
                coffeeMillerLicenceApplicationDetailsArrayList.add(new CoffeeMillerLicenceApplicationDetails(
                        coffeeMillerLicenceApplicationDetailsList.get(i).getDocumentNumber(),
                        retreivedDocumentDate,
                        cbPartner,
                        coffeeMillerLicenceApplicationDetailsList.get(i).getLicenceNumber()));
            }


            localhash.put(i, coffeeMillerLicenceApplicationDetailsList.get(i).getLocalID());
            adapter = new CoffeeMillerLicenseApplicationListAdapter(getActivity(), coffeeMillerLicenceApplicationDetailsArrayList);
            list.setAdapter(adapter);
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.tv_cm_document_number);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.tv_cm_document_date);
                TextView textviewAuthorityNumber = viewClicked.findViewById(R.id.tv_cm_licence_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.tv_cm_name_of_applicant);

                document_number = coffeeMillerLicenceApplicationDetailsArrayList.get(position).getDocumentNumber();
                document_date = coffeeMillerLicenceApplicationDetailsArrayList.get(position).getDocumentDate();
                licence_number = coffeeMillerLicenceApplicationDetailsArrayList.get(position).getLicenceNumber();
                applicant_name = coffeeMillerLicenceApplicationDetailsArrayList.get(position).getApplicantName();

                localID = localhash.get(position);

            }
        });
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        CoffeeMillerLicenceApplicationBus coffeeMillerLicenceApplicationBus = CoffeeMillerLicenceApplicationBus.getInstance();
        coffeeMillerLicenceApplicationBus.setDocumentNumber(document_number);
        coffeeMillerLicenceApplicationBus.setDocumentDate(document_date);
        coffeeMillerLicenceApplicationBus.setLicenceNumber(licence_number);
        coffeeMillerLicenceApplicationBus.setApplicantName(applicant_name);
        coffeeMillerLicenceApplicationBus.setLocalID(localID);


        if (coffeeMillerLicenceApplicationBus.getLocalID() != null && !coffeeMillerLicenceApplicationBus.getLocalID().isEmpty()) {

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
