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
import co.ke.bsl.data.view.CoffeePulpingStationPSLBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CoffeePulpinglicenceApllPSL;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.CoffeePulpingPSLListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeePulpingStationLicenceApplPSLStep1 extends Fragment implements BlockingStep {


    @BindView(R.id.userPSLlist)
    ListView userPSLlist;
    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;


    private ArrayList<CoffeePulpinglicenceApllPSL> coffeePulpinglicenceList = new ArrayList<>();
    CoffeePulpingPSLListAdapter adapter;
    private String localID;
    private String cbPartnerID;
    private HashMap<Integer, String> localhash = new HashMap<>();

    private String document_number, visited_date, licenceNo, applicant_name,pulping_machine, date_approved, area_undercoffee;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_pulping_station_licence_appl_pslstep1, container, false);
        ButterKnife.bind(this, view);


        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getCoffeePulpingPSLList();


    }

    private void getCoffeePulpingPSLList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.userPSLlist);
        coffeePulpinglicenceList.clear();
        List<CoffeePulpinglicenceApllPSL> coffeePulpinglicenceApllPSL = db.getCoffeePulpinglicenceApllPSL();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = coffeePulpinglicenceApllPSL.size();
        System.out.println(listSize + "===============coffee pulping PSL inspections ==========");

        for (int i = 0; i < coffeePulpinglicenceApllPSL.size(); i++) {
            System.out.println("Document Number=== " + coffeePulpinglicenceApllPSL.get(i).getDocument_number());
            System.out.println("the Date passed is " + coffeePulpinglicenceApllPSL.get(i).getName_of_applicant());
            System.out.println("the licence passed is " + coffeePulpinglicenceApllPSL.get(i).getLicence_number());
            System.out.println("the Applicant name passed is " + coffeePulpinglicenceApllPSL.get(i).getName_of_applicant());

            String retreivedDocumentDate = coffeePulpinglicenceApllPSL.get(i).getVisited_date();
            cbPartnerID = coffeePulpinglicenceApllPSL.get(i).getName_of_applicant();

            for(CBPartner partner : cbPartnerList){
                if(null != coffeePulpinglicenceApllPSL.get(i).getName_of_applicant() && coffeePulpinglicenceApllPSL.get(i).getName_of_applicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }


            //Toast.makeText(getContext(), "No Surevy Has Been Created ", Toast.LENGTH_LONG).show();

            if (retreivedDocumentDate != null) {
                coffeePulpinglicenceList.add(new CoffeePulpinglicenceApllPSL(
                        coffeePulpinglicenceApllPSL.get(i).getDocument_number(),
                        coffeePulpinglicenceApllPSL.get(i).getVisited_date(),
                        cbPartner,
                        coffeePulpinglicenceApllPSL.get(i).getLicence_number(),
                        coffeePulpinglicenceApllPSL.get(i).getAreaUnderCoffee(),
                        coffeePulpinglicenceApllPSL.get(i).getPulpingMachine(),
                        coffeePulpinglicenceApllPSL.get(i).getDateApprovedByTheBoard()
                ));
            }

            localhash.put(i, coffeePulpinglicenceApllPSL.get(i).getLocalID());
            adapter = new CoffeePulpingPSLListAdapter(getActivity(), coffeePulpinglicenceList);
            list.setAdapter(adapter);


        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_date);
                TextView textviewLetterOfComfort = viewClicked.findViewById(R.id.textviewlicence_number_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicant_applicant);

                document_number = coffeePulpinglicenceList.get(position).getDocument_number();
                visited_date= coffeePulpinglicenceList.get(position).getVisited_date();
                licenceNo = coffeePulpinglicenceList.get(position).getLicence_number();
                applicant_name = coffeePulpinglicenceList.get(position).getName_of_applicant();
                date_approved = coffeePulpinglicenceApllPSL.get(position).getDateApprovedByTheBoard();

                localID = localhash.get(position);

            }
        });
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {


        CoffeePulpingStationPSLBus coffeePulpingStationPSLBus = CoffeePulpingStationPSLBus.getInstance();
        coffeePulpingStationPSLBus.setDocument_number(document_number);
        coffeePulpingStationPSLBus.setVisited_date(visited_date);
        coffeePulpingStationPSLBus.setLicence_number(licenceNo);
        coffeePulpingStationPSLBus.setName_of_applicant(applicant_name);
        coffeePulpingStationPSLBus.setDateApprovedByTheBoard(date_approved);

        coffeePulpingStationPSLBus.setLocalID(localID);

        if (coffeePulpingStationPSLBus.getLocalID() != null && !coffeePulpingStationPSLBus.getLocalID().isEmpty()) {

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
