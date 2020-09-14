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
import co.ke.bsl.data.view.HorticulturalFlowerExportersDeskVettingBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.HorticulturalFlowerExportersDeskVettingDetails;
import co.ke.bsl.ui.views.widgets.HorticulturalFlowerExportersDeskVettingListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorticulturalFlowerExportersDeskVettingChecklist extends Fragment implements BlockingStep {
    @BindView(R.id.horticultureFlowerExporterUserlist)
    ListView horticulture_flower_exporter_user_list;

    AFADatabaseAdapter db;
    AFA app;
    String localID;
    private String document_number, document_date, applicant_name, export_licence;
    private ArrayList<HorticulturalFlowerExportersDeskVettingDetails> horticulturalFlowerExportersDeskVettingDetailsList = new ArrayList<>();
    private HorticulturalFlowerExportersDeskVettingListAdapter adapter;
    private HashMap<Integer, String> localhash = new HashMap<>();

    private String cbPartnerID;


    public HorticulturalFlowerExportersDeskVettingChecklist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horticultural_flower_exporters_desk_vetting_checklist, container, false);
        ButterKnife.bind(this, view);


        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getActivity()).open();

        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreated==========");
        getListOfHorticulturalFlowerExportersDeskVetting();

    }

    private void getListOfHorticulturalFlowerExportersDeskVetting() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.horticultureFlowerExporterUserlist);
        List<HorticulturalFlowerExportersDeskVettingDetails> horticulturalFlowerExportersDeskVettingDetails = db.getHorticulturalFlowerExportersDeskVettingList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";
        horticulturalFlowerExportersDeskVettingDetailsList.clear();

        int listSize = horticulturalFlowerExportersDeskVettingDetails.size();
        System.out.println(listSize + "===============pulpingStationLicenseApplicationDetailsSize==========");

        for (int i = 0; i < horticulturalFlowerExportersDeskVettingDetails.size(); i++) {
            System.out.println("Document Number=== " + horticulturalFlowerExportersDeskVettingDetails.get(i).getDocument_number());

            String retreivedDocumentDate = horticulturalFlowerExportersDeskVettingDetails.get(i).getDocument_date();
//            String convertedDocumentDate = null;
//            if(null != retreivedDocumentDate){
//                convertedDocumentDate = DateConverter.fromDateToString(DateConverter.toDate(retreivedDocumentDate));
//            }
            cbPartnerID = horticulturalFlowerExportersDeskVettingDetails.get(i).getName_of_applicant();

            for(CBPartner partner : cbPartnerList){
                if(null != horticulturalFlowerExportersDeskVettingDetails.get(i).getName_of_applicant() && horticulturalFlowerExportersDeskVettingDetails.get(i).getName_of_applicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            if(retreivedDocumentDate != null){
                this.horticulturalFlowerExportersDeskVettingDetailsList.add(new HorticulturalFlowerExportersDeskVettingDetails(
                        horticulturalFlowerExportersDeskVettingDetails.get(i).getDocument_number(),
                        retreivedDocumentDate,
                        cbPartner,
                        horticulturalFlowerExportersDeskVettingDetails.get(i).getExport_licence()));
            }


            localhash.put(i, horticulturalFlowerExportersDeskVettingDetails.get(i).getLocalID());
            adapter = new HorticulturalFlowerExportersDeskVettingListAdapter(getActivity(), this.horticulturalFlowerExportersDeskVettingDetailsList);
            list.setAdapter(adapter);

        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.tv_hfedv_document_number);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.tv_hfedv_document_date);
                TextView textviewAuthorityNumber = viewClicked.findViewById(R.id.tv_hfedv_export_licence);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.tv_hfedv_name_of_applicant);

                document_number = horticulturalFlowerExportersDeskVettingDetailsList.get(position).getDocument_number();
                document_date = horticulturalFlowerExportersDeskVettingDetailsList.get(position).getDocument_date();
                export_licence = horticulturalFlowerExportersDeskVettingDetailsList.get(position).getExport_licence();
                applicant_name = horticulturalFlowerExportersDeskVettingDetailsList.get(position).getName_of_applicant();
                localID = localhash.get(position);


            }
        });
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        HorticulturalFlowerExportersDeskVettingBus horticulturalFlowerExportersDeskVettingBus = HorticulturalFlowerExportersDeskVettingBus.getInstance();
        horticulturalFlowerExportersDeskVettingBus.setDocument_number(document_number);
        horticulturalFlowerExportersDeskVettingBus.setDocument_date(document_date);
        horticulturalFlowerExportersDeskVettingBus.setExport_licence(export_licence);
        horticulturalFlowerExportersDeskVettingBus.setName_of_applicant(applicant_name);
        horticulturalFlowerExportersDeskVettingBus.setLocalID(localID);

        if (horticulturalFlowerExportersDeskVettingBus.getLocalID() != null && !horticulturalFlowerExportersDeskVettingBus.getLocalID().isEmpty()) {
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
