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
import co.ke.bsl.data.view.FruitVegetableConsolidatorsBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.FruitsAndVegetablesExporters;
import co.ke.bsl.pojo.HCDFruitVegetableConsolidators;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.FruitVegetableConsolidatorsCustomListAdapter;
import co.ke.bsl.ui.views.widgets.FruitsAndVegetablesCustomListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FruitVegetableConsolidatorsDeskvettingChecklistStep1 extends Fragment implements BlockingStep {


    FruitVegetableConsolidatorsCustomListAdapter adapter;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private ArrayList<HCDFruitVegetableConsolidators> hCDFruitVegetableConsolidatorslist = new ArrayList<>();
    private String cbPartnerID;
    private HashMap<Integer, String> localhash = new HashMap<>();

    private String documentNumber, documentDate, nameOfApplicant, exportLicence,localID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fruit_vegetable_consolidators_deskvetting_checklist_step1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getHCDFruitVegetableConsolidatorsList();


    }

    private void getHCDFruitVegetableConsolidatorsList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.usershcdconsolidatorslist);
        hCDFruitVegetableConsolidatorslist.clear();

        List<HCDFruitVegetableConsolidators> hCDFruitVegetableConsolidators = db.getHCDFruitVegetableConsolidatorsList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = hCDFruitVegetableConsolidators.size();
        System.out.println(listSize + "===============fruitsAndVegetablesExporters Checklist ==========");

        for (int i = 0; i < hCDFruitVegetableConsolidators.size(); i++) {
            System.out.println("Document Number=== " + hCDFruitVegetableConsolidators.get(i).getDocumentNumber());


            String retreivedDocumentDate = hCDFruitVegetableConsolidators.get(i).getDocumentDate();
            cbPartnerID = hCDFruitVegetableConsolidators.get(i).getNameOfApplicant();

            for(CBPartner partner : cbPartnerList){
                if(null != hCDFruitVegetableConsolidators.get(i).getNameOfApplicant() && hCDFruitVegetableConsolidators.get(i).getNameOfApplicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }

            if (retreivedDocumentDate != null) {
                hCDFruitVegetableConsolidatorslist.add(new HCDFruitVegetableConsolidators
                        (hCDFruitVegetableConsolidators.get(i).getDocumentNumber(),
                                hCDFruitVegetableConsolidators.get(i).getDocumentDate(),
                                cbPartner,
                                hCDFruitVegetableConsolidators.get(i).getExportLicence()));
            }

            localhash.put(i, hCDFruitVegetableConsolidators.get(i).getLocalID());
            adapter = new FruitVegetableConsolidatorsCustomListAdapter(getActivity(), hCDFruitVegetableConsolidatorslist);
            list.setAdapter(adapter);


        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_n);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_d);
                TextView textviewexportLicence = viewClicked.findViewById(R.id.textviewlicence_number_no);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicantt);

                documentNumber = hCDFruitVegetableConsolidatorslist.get(position).getDocumentNumber();
                documentDate = hCDFruitVegetableConsolidatorslist.get(position).getDocumentDate();
                nameOfApplicant = hCDFruitVegetableConsolidatorslist.get(position).getNameOfApplicant();
                exportLicence = hCDFruitVegetableConsolidatorslist.get(position).getExportLicence();

                localID = localhash.get(position);

            }
        });
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        FruitVegetableConsolidatorsBus fruitVegetableConsolidatorsBus = FruitVegetableConsolidatorsBus.getInstance();
        fruitVegetableConsolidatorsBus.setDocumentNumber(documentNumber);
        fruitVegetableConsolidatorsBus.setDocumentDate(documentDate);
        fruitVegetableConsolidatorsBus.setNameOfApplicant(nameOfApplicant);
        fruitVegetableConsolidatorsBus.setExportLicence(exportLicence);
        fruitVegetableConsolidatorsBus.setLocalID(localID);
        if (fruitVegetableConsolidatorsBus.getLocalID() != null && !fruitVegetableConsolidatorsBus.getLocalID().isEmpty()) {
            callback.goToNextStep();

        } else {
            Toast.makeText(app, "No Inspection Selected", Toast.LENGTH_SHORT).show();
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
