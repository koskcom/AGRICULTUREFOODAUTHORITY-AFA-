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
import co.ke.bsl.data.view.PulpingStationLicenseApplicationBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.PulpingStationLicenseApplicationDetails;
import co.ke.bsl.ui.views.activities.components.PulpingStationLicenseApplicationActivity;
import co.ke.bsl.ui.views.widgets.CustomListAdapter;
import co.ke.bsl.ui.views.widgets.PulpingStationLicenseApplicationListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAPulpingStationLicenseApplicationChecklist extends Fragment implements BlockingStep {
    @BindView(R.id.pulpingStationUserlist)
    ListView pulping_station_user_list;

    AFADatabaseAdapter db;
    AFA app;
    String localID;
    private String document_number, document_date, applicant_name, authority_to_erect_number;
    private ArrayList<PulpingStationLicenseApplicationDetails> pulpingStationLicenseApplicationDetailsList = new ArrayList<>();
    private PulpingStationLicenseApplicationListAdapter adapter;
    private String cbPartnerID;
    private HashMap<Integer, String> localhash = new HashMap<>();


    public AFAPulpingStationLicenseApplicationChecklist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afapulping_station_license_application_checklist, container, false);

        ButterKnife.bind(this, view);
        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getActivity()).open();

        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreated==========");
        getListOfPulpingStationLicenseApplication();

    }

    private void getListOfPulpingStationLicenseApplication() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.pulpingStationUserlist);
        pulpingStationLicenseApplicationDetailsList.clear();

        List<PulpingStationLicenseApplicationDetails> pulpingStationLicenseApplicationDetails = db.getPulpingStationLicenseApplicationList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = pulpingStationLicenseApplicationDetails.size();
        System.out.println(listSize + "===============pulpingStationLicenseApplicationDetailsSize==========");

        for (int i = 0; i < pulpingStationLicenseApplicationDetails.size(); i++) {
            System.out.println("Document Number=== " + pulpingStationLicenseApplicationDetails.get(i).getDocumentNumber());

            String retreivedDocumentDate = pulpingStationLicenseApplicationDetails.get(i).getDocumentDate();
//            String convertedDocumentDate = null;
//            if(null != retreivedDocumentDate){
//                convertedDocumentDate = DateConverter.fromDateToString(DateConverter.toDate(retreivedDocumentDate));
//            }
            cbPartnerID = pulpingStationLicenseApplicationDetails.get(i).getApplicantName();

            for(CBPartner partner : cbPartnerList){
                if(null != pulpingStationLicenseApplicationDetails.get(i).getApplicantName() && pulpingStationLicenseApplicationDetails.get(i).getApplicantName().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }


            if(retreivedDocumentDate != null){
                pulpingStationLicenseApplicationDetailsList.add(new PulpingStationLicenseApplicationDetails(
                        pulpingStationLicenseApplicationDetails.get(i).getDocumentNumber(),
                        retreivedDocumentDate,
                        cbPartner,
                        pulpingStationLicenseApplicationDetails.get(i).getAuthorityToErectNumber()));
            }



            localhash.put(i, pulpingStationLicenseApplicationDetails.get(i).getLocalID());
            adapter = new PulpingStationLicenseApplicationListAdapter(getActivity(), pulpingStationLicenseApplicationDetailsList);
            list.setAdapter(adapter);

        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.tv_ps_document_number);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.tv_ps_document_date);
                TextView textviewAuthorityNumber = viewClicked.findViewById(R.id.tv_ps_authority_to_erect_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.tv_ps_name_of_applicant);

                document_number = pulpingStationLicenseApplicationDetailsList.get(position).getDocumentNumber();
                document_date = pulpingStationLicenseApplicationDetailsList.get(position).getDocumentDate();
                authority_to_erect_number = pulpingStationLicenseApplicationDetailsList.get(position).getAuthorityToErectNumber();
                applicant_name = pulpingStationLicenseApplicationDetailsList.get(position).getApplicantName();

                localID = localhash.get(position);

            }
        });
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        PulpingStationLicenseApplicationBus pulpingStationLicenseApplicationBus = PulpingStationLicenseApplicationBus.getInstance();
        pulpingStationLicenseApplicationBus.setDocumentNumber(document_number);
        pulpingStationLicenseApplicationBus.setDocumentDate(document_date);
        pulpingStationLicenseApplicationBus.setAuthorityToErectNumber(authority_to_erect_number);
        pulpingStationLicenseApplicationBus.setApplicantName(applicant_name);
        pulpingStationLicenseApplicationBus.setLocalID(localID);
        if (pulpingStationLicenseApplicationBus.getLocalID() != null && !pulpingStationLicenseApplicationBus.getLocalID().isEmpty()) {

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
