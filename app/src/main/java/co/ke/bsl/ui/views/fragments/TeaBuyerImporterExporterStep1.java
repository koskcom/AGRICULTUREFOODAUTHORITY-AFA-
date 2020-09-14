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
import java.util.List;
import java.util.Objects;

import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.TeaBuyerImporterExporterBus;
import co.ke.bsl.pojo.CoffeeNursercertInsp;
import co.ke.bsl.pojo.TeaBuyerImporterExporterDetails;
import co.ke.bsl.pojo.TeaPackerChecklist;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.CoffeeCustomAdapter;
import co.ke.bsl.ui.views.widgets.TeaBuyerImporterExporterListAdapter;
import co.ke.bsl.ui.views.widgets.TeaPackerCustomListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeaBuyerImporterExporterStep1 extends Fragment implements BlockingStep {


    AFADatabaseAdapter db;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    TeaBuyerImporterExporterListAdapter adapter;
    private String localID, document_number, document_date, licence_number, applicant_name;

    private ArrayList<TeaBuyerImporterExporterDetails> teaBuyerImporterExporterDetailsArrayList = new ArrayList<>();

    AFA app;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tea_buyer_importer_exporter_step1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getTeaBuyerImporterExporter();


    }

    private void getTeaBuyerImporterExporter() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.teabuyerimporteruserlist);
        teaBuyerImporterExporterDetailsArrayList.clear();

        List<TeaBuyerImporterExporterDetails> teaBuyerImporterExporterList = db.getTeaBuyerImporterExporterList();
        int listSize = teaBuyerImporterExporterList.size();
        System.out.println(listSize + "===============TEA BUYER IMPORTER EXPORTER INSPECTIONS ==========");
        System.out.println(listSize + "=============== picking data from db teaBuyerImporterExporterList ==========");

        for (int i = 0; i < teaBuyerImporterExporterList.size(); i++) {
            System.out.println("Document Number " + teaBuyerImporterExporterList.get(i).getDocumentNumber());
            System.out.println("the Date passed is " + teaBuyerImporterExporterList.get(i).getDocumentDate());
            System.out.println("the licence passed is " + teaBuyerImporterExporterList.get(i).getLicenseNumber());
            System.out.println("the Applicant name passed is " + teaBuyerImporterExporterList.get(i).getApplicantName());

            String retreivedDocumentDate = teaBuyerImporterExporterList.get(i).getDocumentDate();


            //Toast.makeText(getContext(), "No Surevy Has Been Created ", Toast.LENGTH_LONG).show();

            if (retreivedDocumentDate != null) {
                teaBuyerImporterExporterDetailsArrayList.add(new TeaBuyerImporterExporterDetails(
                        teaBuyerImporterExporterList.get(i).getDocumentNumber(),
                        teaBuyerImporterExporterList.get(i).getDocumentDate(),
                        teaBuyerImporterExporterList.get(i).getApplicantName(),
                        teaBuyerImporterExporterList.get(i).getLicenseNumber()));

            }

            localID = teaBuyerImporterExporterList.get(i).getLocalID();
            adapter = new TeaBuyerImporterExporterListAdapter(getActivity(), teaBuyerImporterExporterDetailsArrayList);
            list.setAdapter(adapter);


        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_nu_number);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_dt_date);
                TextView textviewLicenceNumber = viewClicked.findViewById(R.id.textviewlicence_nu_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_app_applicant);

                document_number = textviewDocumentNumber.getText().toString();
                document_date = textviewDocumentDate.getText().toString();
                licence_number = textviewLicenceNumber.getText().toString();
                applicant_name = textviewApplicantName.getText().toString();

            }
        });
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        TeaBuyerImporterExporterBus teaBuyerImporterExporterBus = TeaBuyerImporterExporterBus.getInstance();
        teaBuyerImporterExporterBus.setDocumentNumber(document_number);
        teaBuyerImporterExporterBus.setDocumentDate(document_date);
        teaBuyerImporterExporterBus.setLicenseNumber(licence_number);
        teaBuyerImporterExporterBus.setApplicantName(applicant_name);
        teaBuyerImporterExporterBus.setLocalID(localID);
        if (teaBuyerImporterExporterBus.getLocalID() != null && !teaBuyerImporterExporterBus.getLocalID().isEmpty()) {

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
