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

import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.HCDNurseryInspectionBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.HorticultureNurseryInspectionDetails;
import co.ke.bsl.pojo.NurseyInspection;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.NurseryCustomListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDNurseryInspectionDetails extends Fragment implements BlockingStep {


    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    NurseryCustomListAdapter adapter;
    private ArrayList<NurseyInspection> nurseyInspectionlist = new ArrayList<>();

    private String documentNumber, documentDate, nameOfApplicant, nurseryLicence, telephone, location, email, localID;
    private String cbPartnerID;
    private HashMap<Integer, String> localhash = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdnursery_inspection_details, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getNurseyInspectionList();


    }

    private void getNurseyInspectionList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.usershcdnurseryinspecionlist);
        nurseyInspectionlist.clear();

        List<HorticultureNurseryInspectionDetails> nurseyInspection = db.getNurseyInspectionList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = nurseyInspection.size();
        System.out.println(listSize + "===============nurseyInspection Checklist ==========");

        for (int i = 0; i < nurseyInspection.size(); i++) {
            System.out.println("Document Number=== " + nurseyInspection.get(i).getDocumentNumber());
            System.out.println("the Date passed is " + nurseyInspection.get(i).getDocumentDate());
            System.out.println("the licence passed is " + nurseyInspection.get(i).getNurseryLicence());
            System.out.println("the Applicant name passed is " + nurseyInspection.get(i).getNameOfApplicant());

            String retreivedDocumentDate = nurseyInspection.get(i).getDocumentDate();

            cbPartnerID = nurseyInspection.get(i).getNameOfApplicant();

            for(CBPartner partner : cbPartnerList){
                if(null != nurseyInspection.get(i).getNameOfApplicant() && nurseyInspection.get(i).getNameOfApplicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            if (retreivedDocumentDate != null) {
                nurseyInspectionlist.add(new NurseyInspection
                        (nurseyInspection.get(i).getDocumentNumber(),
                                nurseyInspection.get(i).getDocumentDate(),
                                cbPartner,
                                nurseyInspection.get(i).getNurseryLicence(),
                                nurseyInspection.get(i).getTelephone(),
                                nurseyInspection.get(i).getLocation(),
                                nurseyInspection.get(i).getEmail()));
            }

            localhash.put(i, nurseyInspection.get(i).getLocalID());
            adapter = new NurseryCustomListAdapter(getActivity(), nurseyInspectionlist);
            list.setAdapter(adapter);


        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_n);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_d);
                TextView textviewcertifcateno = viewClicked.findViewById(R.id.textviewlicence_number_no);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicantt);

//                documentNumber = textviewDocumentNumber.getText().toString();
//                documentDate = textviewDocumentDate.getText().toString();
//                nurseryLicence = textviewcertifcateno.getText().toString().replaceAll("[^0-9]", "");
//                nameOfApplicant = textviewApplicantName.getText().toString();

                documentNumber = nurseyInspectionlist.get(position).getDocumentNumber();
                documentDate = nurseyInspectionlist.get(position).getDocumentDate();
                nurseryLicence = nurseyInspectionlist.get(position).getNurseryLicence();
                nameOfApplicant = nurseyInspectionlist.get(position).getNameOfApplicant();

                localID = localhash.get(position);

            }
        });
    }



    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        HCDNurseryInspectionBus hCDNurseryInspectionBus = HCDNurseryInspectionBus.getInstance();
        hCDNurseryInspectionBus.setDocumentNumber(documentNumber);
        hCDNurseryInspectionBus.setDocumentDate(documentDate);
        hCDNurseryInspectionBus.setNameOfApplicant(nameOfApplicant);
        hCDNurseryInspectionBus.setNurseryLicence(nurseryLicence);
        hCDNurseryInspectionBus.setEmail(email);
        hCDNurseryInspectionBus.setTelephone(telephone);
        hCDNurseryInspectionBus.setLocation(location);
        hCDNurseryInspectionBus.setLocalID(localID);

        if (hCDNurseryInspectionBus.getLocalID() != null && !hCDNurseryInspectionBus.getLocalID().isEmpty()) {
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
