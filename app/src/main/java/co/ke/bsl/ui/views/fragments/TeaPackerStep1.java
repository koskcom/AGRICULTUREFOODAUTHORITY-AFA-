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
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

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
import co.ke.bsl.data.view.SugarCompanyView;
import co.ke.bsl.data.view.TeaPackerBus;
import co.ke.bsl.data.view.View10Marks;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.SugarMillDetails;
import co.ke.bsl.pojo.TeaPackerChecklist;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.CustomListAdapter;
import co.ke.bsl.ui.views.widgets.TeaPackerCustomListAdapter;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeaPackerStep1 extends Fragment implements BlockingStep {


    @BindView(R.id.teapackeruserlist)
    ListView teapackeruserlist;


    AFADatabaseAdapter db;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private ArrayList<TeaPackerChecklist> teaPackerlist = new ArrayList<>();

    TeaPackerCustomListAdapter adapter;
    private String localID;
    private String cbPartnerID;
    private HashMap<Integer, String> localHash = new HashMap<>();

    AFA app;
    private String document_number, document_date, licence_number, applicant_name;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tea_packer, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();


        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getTeaPackerList();


    }

    private void getTeaPackerList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.teapackeruserlist);
        teaPackerlist.clear();

        List<TeaPackerChecklist> teaPackerChecklist = db.getTeaPackerChecklistList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";


        int listSize = teaPackerChecklist.size();
        System.out.println(listSize + "===============TEA PACKER INSPECTIONS ==========");

        for (int i = 0; i < teaPackerChecklist.size(); i++) {
            System.out.println("Document Number=== " + teaPackerChecklist.get(i).getDocumentNo());
            System.out.println("the Date passed is " + teaPackerChecklist.get(i).getDocumentDate());
            System.out.println("the licence passed is " + teaPackerChecklist.get(i).getLicenceNo());
            System.out.println("the Applicant name passed is " + teaPackerChecklist.get(i).getApplicantName());

            String retreivedDocumentDate = teaPackerChecklist.get(i).getDocumentDate();
            cbPartnerID = teaPackerChecklist.get(i).getApplicantName();

            for (CBPartner partner : cbPartnerList) {
                if (null != teaPackerChecklist.get(i).getApplicantName() && teaPackerChecklist.get(i).getApplicantName().equals(partner.getC_bpartner_id())) {
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else {
                    System.out.println(app + " cbPartner not found");
                }
            }

            if (retreivedDocumentDate != null) {
                teaPackerlist.add(new TeaPackerChecklist(
                        teaPackerChecklist.get(i).getDocumentNo(),
                        teaPackerChecklist.get(i).getDocumentDate(),
                        cbPartner,
                        teaPackerChecklist.get(i).getLicenceNo()));

            }

            localHash.put(i, teaPackerChecklist.get(i).getLocalID());
            adapter = new TeaPackerCustomListAdapter(getActivity(), teaPackerlist);
            list.setAdapter(adapter);


        }


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_date);
                TextView textviewLetterOfComfort = viewClicked.findViewById(R.id.textviewlicence_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicant);

                document_number = teaPackerlist.get(position).getDocumentNo();
                document_date = teaPackerlist.get(position).getDocumentDate();
                licence_number = teaPackerlist.get(position).getLicenceNo();
                applicant_name = teaPackerlist.get(position).getApplicantName();

                localID = localHash.get(position);

            }
        });
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        TeaPackerBus teaPackerBus = TeaPackerBus.getInstance();
        teaPackerBus.setDocumentNo(document_number);
        teaPackerBus.setDocumentDate(document_date);
        teaPackerBus.setApplicantName(applicant_name);
        teaPackerBus.setLicenceNo(licence_number);
        teaPackerBus.setLocalID(localID);


        if (teaPackerBus.getLocalID() != null && !teaPackerBus.getLocalID().isEmpty()) {

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
