package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.FCDCottonLintClassingReportBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CottonLintClassingReport;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.FCDCottonLintClassingReportCusomListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDCottonLintClassingReportChecklist extends Fragment implements BlockingStep {

    private String documentNumber, documentDate, nameOfApplicant, lintLicence, localID, cbPartnerID;

    FCDCottonLintClassingReportCusomListAdapter adapter;
    private ArrayList<CottonLintClassingReport> cottonLintClassingReportArrayList = new ArrayList<>();

    AFADatabaseAdapter db;
    AFA app;
    protected Handler asyncTaskHandler;
    ListView cottonLintClassingReportuserlist;

    private HashMap<Integer, String> localhash = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdcotton_lint_classing_report_checklist, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getCottonGinneryInspectionList();



    }

    private void getCottonGinneryInspectionList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.cottonLintClassingReportuserlist);
        cottonLintClassingReportArrayList.clear();
        List<CottonLintClassingReport> cottonLintClassingReportList = db.getCottonLintClassingReportList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = cottonLintClassingReportList.size();

        for(int i=0; i<cottonLintClassingReportList.size(); i++){

            String retreivedDocumentDate = cottonLintClassingReportList.get(i).getDocumentDate();
            //Toast.makeText(getContext(), "No Surevy Has Been Created ", Toast.LENGTH_LONG).show();
            cbPartnerID = cottonLintClassingReportList.get(i).getNameOfApplicant();

            for(CBPartner partner : cbPartnerList){
                if(null != cottonLintClassingReportList.get(i).getNameOfApplicant() && cottonLintClassingReportList.get(i).getNameOfApplicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            if (retreivedDocumentDate != null) {
                cottonLintClassingReportArrayList.add(new CottonLintClassingReport(
                        cottonLintClassingReportList.get(i).getDocumentNumber(),
                        cottonLintClassingReportList.get(i).getDocumentDate(),
                        cbPartner,
                        cottonLintClassingReportList.get(i).getLintLicence()));


            }

            localhash.put(i, cottonLintClassingReportList.get(i).getLocalId());
            adapter = new FCDCottonLintClassingReportCusomListAdapter(getActivity(), cottonLintClassingReportArrayList);
            list.setAdapter(adapter);
        }

//

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_date);
                TextView textviewginningLicence = viewClicked.findViewById(R.id.textviewlicence_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicant);

                documentNumber = cottonLintClassingReportArrayList.get(position).getDocumentNumber();
                documentDate = cottonLintClassingReportArrayList.get(position).getDocumentDate();
                lintLicence = cottonLintClassingReportArrayList.get(position).getLintLicence();
                nameOfApplicant = cottonLintClassingReportArrayList.get(position).getNameOfApplicant();

                localID = localhash.get(position);

            }
        });
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        FCDCottonLintClassingReportBus fcdCottonLintClassingReportBus = FCDCottonLintClassingReportBus.getInstance();

        fcdCottonLintClassingReportBus.setDocumentNumber(documentNumber);
        fcdCottonLintClassingReportBus.setDocumentDate(documentDate);
        fcdCottonLintClassingReportBus.setLintLicence(lintLicence);
        fcdCottonLintClassingReportBus.setNameOfApplicant(nameOfApplicant);
        fcdCottonLintClassingReportBus.setLocalId(localID);

        if (fcdCottonLintClassingReportBus.getLocalId() != null && !fcdCottonLintClassingReportBus.getLocalId().isEmpty()) {

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
