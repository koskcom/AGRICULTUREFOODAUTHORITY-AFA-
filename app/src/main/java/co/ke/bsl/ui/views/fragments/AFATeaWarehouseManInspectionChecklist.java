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
import co.ke.bsl.data.view.TeaWarehouseManInspectionBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.TeaWarehouseManInspectionDataCollection;
import co.ke.bsl.ui.views.widgets.TeaWarehouseManInspectionListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFATeaWarehouseManInspectionChecklist extends Fragment implements BlockingStep {

    @BindView(R.id.teaWarehouseUserlist)
    ListView teaWarehouseUserlist;

    AFADatabaseAdapter db;
    AFA app;
    String localID;
    String cbPartnerID;
    private String document_number, document_date, applicant_name, license_number;
    private ArrayList<TeaWarehouseManInspectionDataCollection> teaWarehouseManInspectionDataCollectionArrayList = new ArrayList<>();
    private TeaWarehouseManInspectionListAdapter adapter;
    private HashMap<Integer, String> localhash = new HashMap<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_afatea_warehouse_man_inspection_checklist, container, false);

        ButterKnife.bind(this, view);
        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getActivity()).open();

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreated==========");
        getListOfTeaWarehouseInspection();

    }

    private void getListOfTeaWarehouseInspection() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.teaWarehouseUserlist);
        teaWarehouseManInspectionDataCollectionArrayList.clear();
        List<TeaWarehouseManInspectionDataCollection> teaWarehouseManInspectionDataCollections = db.getTeaWarehouseManInspectionList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = teaWarehouseManInspectionDataCollections.size();
        System.out.println(listSize + "===============teaWarehouseManInspectionDataCollections==========");

        for (int i = 0; i < teaWarehouseManInspectionDataCollections.size(); i++) {
            System.out.println("Name of applicant=== " + teaWarehouseManInspectionDataCollections.get(i).getName_of_applicant());

            String retreivedDocumentDate = teaWarehouseManInspectionDataCollections.get(i).getDocument_date();

            cbPartnerID = teaWarehouseManInspectionDataCollections.get(i).getName_of_applicant();

            for(CBPartner partner : cbPartnerList){
                if(null != teaWarehouseManInspectionDataCollections.get(i).getName_of_applicant() && teaWarehouseManInspectionDataCollections.get(i).getName_of_applicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            if(teaWarehouseManInspectionDataCollections.get(i).getName_of_applicant() != null){
                teaWarehouseManInspectionDataCollectionArrayList.add(new TeaWarehouseManInspectionDataCollection(
                        teaWarehouseManInspectionDataCollections.get(i).getDocument_number(),
                        retreivedDocumentDate,
                        cbPartner,
                        teaWarehouseManInspectionDataCollections.get(i).getLicense_number()
                ));
            }

            localhash.put(i, teaWarehouseManInspectionDataCollections.get(i).getLocalID());
            adapter = new TeaWarehouseManInspectionListAdapter(getActivity(), teaWarehouseManInspectionDataCollectionArrayList);
            list.setAdapter(adapter);
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.tvdocument_number);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.tvdocument_dt);
                TextView textviewLicenseNumber = viewClicked.findViewById(R.id.tvlicense_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.tvname_of_applicant);

                document_number = teaWarehouseManInspectionDataCollectionArrayList.get(position).getDocument_number();
                document_date = teaWarehouseManInspectionDataCollectionArrayList.get(position).getDocument_date();
                license_number = teaWarehouseManInspectionDataCollectionArrayList.get(position).getLicense_number();
                applicant_name = teaWarehouseManInspectionDataCollectionArrayList.get(position).getName_of_applicant();

                localID = localhash.get(position);

            }
        });
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        TeaWarehouseManInspectionBus teaWarehouseManInspectionBus = TeaWarehouseManInspectionBus.getInstance();
        teaWarehouseManInspectionBus.setDocument_number(document_number);
        teaWarehouseManInspectionBus.setDocument_date(document_date);
        teaWarehouseManInspectionBus.setName_of_applicant(applicant_name);
        teaWarehouseManInspectionBus.setLicense_number(license_number);
        teaWarehouseManInspectionBus.setLocalID(localID);

        if (teaWarehouseManInspectionBus.getLocalID() != null && !teaWarehouseManInspectionBus.getLocalID().isEmpty()) {

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
