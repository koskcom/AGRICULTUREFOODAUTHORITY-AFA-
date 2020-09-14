package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.DateConverter;
import co.ke.bsl.data.view.HorticultureCropExportLicenceFarmInspectionBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.County;
import co.ke.bsl.pojo.HorticultureCropExportLicenceFarmInspectionDetails;
import co.ke.bsl.ui.views.widgets.HorticultureLicenceFarmInspectionListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorticultureLicenceFarmInspectionChecklist extends Fragment implements BlockingStep{
    @BindView(R.id.horticultureLicenceFarmInspectionUserlist)
    ListView horticultureLicenceFarmInspectionUserlist;

    AFADatabaseAdapter db;
    AFA app;
    String localID;
    private String document_number, document_date, county_name, countyID, applicant_name;
    private ArrayList<HorticultureCropExportLicenceFarmInspectionDetails> horticultureCropExportLicenceFarmInspectionDetailsArrayList = new ArrayList<>();
    private HorticultureLicenceFarmInspectionListAdapter adapter;

    private String cbPartnerID;
    private ArrayList<String> applicantList = new ArrayList<>();
    private HashMap<Integer, String> localhash = new HashMap<>();




    public HorticultureLicenceFarmInspectionChecklist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horticulture_licence_farm_inspection_checklist, container, false);
        ButterKnife.bind(this, view);


        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getActivity()).open();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreated==========");
        getListOfLicenceFarmInspection();

    }

    private void getListOfLicenceFarmInspection() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.horticultureLicenceFarmInspectionUserlist);
        horticultureCropExportLicenceFarmInspectionDetailsArrayList.clear();

        List<HorticultureCropExportLicenceFarmInspectionDetails> horticultureCropExportLicenceFarmInspectionDetailsList = db.getHorticultureCropExportLicenceFarmInspectionDetailsList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        List<County> countyList = db.getAllCounty();
        String cbPartner = "";
        String countyName = "";

        int listSize = horticultureCropExportLicenceFarmInspectionDetailsList.size();
        System.out.println(listSize + "===============horticultureCropExportLicenceFarmInspectionDetailsListSize==========");

        for (int i = 0; i < horticultureCropExportLicenceFarmInspectionDetailsList.size(); i++) {
            System.out.println("Document Number=== " + horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getDocumentNumber());

            String retreivedDocumentDate = horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getDocumentDate();
            String convertedDocumentDate = null;
            if(null != retreivedDocumentDate){
                convertedDocumentDate = DateConverter.fromDateToString(DateConverter.toDate(retreivedDocumentDate));
            }
            cbPartnerID = horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getNameOfApplicant();
            countyID = horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getCountyId();

            for(CBPartner partner : cbPartnerList){
                if(null != horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getNameOfApplicant() && horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getNameOfApplicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }
            for(County county : countyList){
                if(null != horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getCountyId() && horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getCountyId().equals(county.getCountyId())){
                    countyName = county.getCountyName();
                    System.out.println(app + " county : " + countyName);
                } else{
                    System.out.println(app + " county not found");
                }
            }

            if(retreivedDocumentDate != null){
                this.horticultureCropExportLicenceFarmInspectionDetailsArrayList.add(new HorticultureCropExportLicenceFarmInspectionDetails(
                        horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getDocumentNumber(),
                        cbPartner,
                        countyName,
                        retreivedDocumentDate,
                        horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getIsExporterOwnFarm(),
                        horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getIsContractedSources(),
                        horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getFarmName(),
                        horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getFarmerName(),
                        horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getFarmerIdNumber(),
                        horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getFarmerTelephone(),
                        horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getFarmerEmail(),
                        horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getFarmerCounty(),
                        horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getFarmerLocation(),
                        horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getIntendedCrop(),
                        horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getAcreageUnderCrop()));
            }

            localhash.put(i, horticultureCropExportLicenceFarmInspectionDetailsList.get(i).getLocalID());
            adapter = new HorticultureLicenceFarmInspectionListAdapter(getActivity(), this.horticultureCropExportLicenceFarmInspectionDetailsArrayList);
            list.setAdapter(adapter);

        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.tv_hfedv_document_number);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.tv_hfedv_document_date);
                TextView textviewAuthorityNumber = viewClicked.findViewById(R.id.tv_hfedv_export_licence);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.tv_hfedv_name_of_applicant);

                document_number = horticultureCropExportLicenceFarmInspectionDetailsArrayList.get(position).getDocumentNumber();
                document_date = horticultureCropExportLicenceFarmInspectionDetailsArrayList.get(position).getDocumentDate();
                county_name = horticultureCropExportLicenceFarmInspectionDetailsArrayList.get(position).getCountyId();
                applicant_name = horticultureCropExportLicenceFarmInspectionDetailsArrayList.get(position).getNameOfApplicant();
                localID = localhash.get(position);

                app.getHorticultureCropExportLicenceFarmInspectionDetails().setValue(horticultureCropExportLicenceFarmInspectionDetailsArrayList.get(position));

            }
        });
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        HorticultureCropExportLicenceFarmInspectionBus horticultureCropExportLicenceFarmInspectionBus = HorticultureCropExportLicenceFarmInspectionBus.getInstance();
        horticultureCropExportLicenceFarmInspectionBus.setNameOfApplicant(applicant_name);
        horticultureCropExportLicenceFarmInspectionBus.setCountyId(countyID);
        horticultureCropExportLicenceFarmInspectionBus.setDocumentNumber(document_number);
        horticultureCropExportLicenceFarmInspectionBus.setDocumentDate(document_date);
        horticultureCropExportLicenceFarmInspectionBus.setLocalID(localID);
        if (horticultureCropExportLicenceFarmInspectionBus.getLocalID() != null && !horticultureCropExportLicenceFarmInspectionBus.getLocalID().isEmpty()) {
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
