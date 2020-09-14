package co.ke.bsl.ui.views.fragments;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.DateConverter;
import co.ke.bsl.data.view.CaneCensusBus;
import co.ke.bsl.data.view.SugarMillLicenceBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CaneCensusDataCollection;
import co.ke.bsl.pojo.City;
import co.ke.bsl.pojo.County;
import co.ke.bsl.pojo.SugarMillDetails;
import co.ke.bsl.pojo.SugarMillLicenceDatacollection;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.CustomListAdapter;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFASugarMillLicenceComplianceVisitChecklist extends Fragment implements BlockingStep {


    @BindView(R.id.userlist)
    ListView user_list;

    ListView lv;

    AFADatabaseAdapter db;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private ArrayList<SugarMillDetails> sugarMillList = new ArrayList<>();
    private ArrayList<SugarMillDetails> sugarMillDisplayList = new ArrayList<>();
    private CustomListAdapter adapter;
    private HashMap<Integer, String> localHash = new HashMap<>();

    String localID;
    int pos = 0;
    private String cbPartnerID;
    AFA app;
    private String document_number, document_date, letter_of_comfort, applicant_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afasugar_mill_licence_compliance_visit_checklist, container, false);
        ButterKnife.bind(this, view);
        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getActivity()).open();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getListOfSugarMill();


    }
    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getActivity().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if (netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()) {
            Toast.makeText(getContext(), "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void getListOfSugarMill() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.userlist);
        sugarMillList.clear();
        List<SugarMillDetails> sugarMillDetailsList = db.getSugarMillDetailsList();
        List<CBPartner> cbPartnerList = db.getAllCompanys();
        String cbPartner = "";
        int listSize = sugarMillDetailsList.size();
        System.out.println(listSize + "===============SugarmilllistSize==========");

        for (int i = 0; i < sugarMillDetailsList.size(); i++) {
            System.out.println("Document Number=== " + sugarMillDetailsList.get(i).getDocument_number());
            System.out.println("Name of Applicant=== " + sugarMillDetailsList.get(i).getC_BPartner_ID());

            String retreivedDocumentDate = sugarMillDetailsList.get(i).getDocument_date();
            String convertedDocumentDate = null;
            if(null != retreivedDocumentDate){
                convertedDocumentDate = DateConverter.fromDateToString(DateConverter.toDate(retreivedDocumentDate));
            }
            cbPartnerID = sugarMillDetailsList.get(i).getC_BPartner_ID();

            for(CBPartner partner : cbPartnerList){
                if(null != cbPartnerID && cbPartnerID.equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            if(retreivedDocumentDate != null){
                sugarMillList.add(new SugarMillDetails(
                        sugarMillDetailsList.get(i).getDocument_number(),
                        convertedDocumentDate,
                        sugarMillDetailsList.get(i).getLetter_of_comfort(),
                        cbPartner));
            }


            localHash.put(i, sugarMillDetailsList.get(i).getLocalID());
            adapter = new CustomListAdapter(getActivity(), sugarMillList);
            list.setAdapter(adapter);

        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date);
                TextView textviewLetterOfComfort = viewClicked.findViewById(R.id.textviewletter_of_comfort);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewapplicant_name);

                document_number = sugarMillList.get(position).getDocument_number();
                document_date = sugarMillList.get(position).getDocument_date();
                letter_of_comfort = sugarMillList.get(position).getLetter_of_comfort();
                applicant_name = sugarMillList.get(position).getC_BPartner_ID();

                localID = localHash.get(position);

            }
        });
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        SugarMillLicenceBus sugarMillLicenceBus = SugarMillLicenceBus.getInstance();
        sugarMillLicenceBus.setDocument_number(document_number);
        sugarMillLicenceBus.setDocument_date(document_date);
        sugarMillLicenceBus.setLetter_of_comfort(letter_of_comfort);
        sugarMillLicenceBus.setC_BPartner_ID(applicant_name);
        sugarMillLicenceBus.setLocalID(localID);

        if (sugarMillLicenceBus.getLocalID() != null && !sugarMillLicenceBus.getLocalID().isEmpty()) {

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

