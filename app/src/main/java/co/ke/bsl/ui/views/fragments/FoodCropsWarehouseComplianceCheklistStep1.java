package co.ke.bsl.ui.views.fragments;

import android.content.Context;
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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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

import co.ke.bsl.data.view.FoodWareHouseBus;
import co.ke.bsl.pojo.CBPartner;

import co.ke.bsl.pojo.FoodWareHouseInspection;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.FoodProcessingListAdapter;
import co.ke.bsl.ui.views.widgets.FoodWareHouseAdapterlist;
import co.ke.bsl.util.GPSTracker;

public class FoodCropsWarehouseComplianceCheklistStep1 extends Fragment implements BlockingStep{


    private String documentNumber, documentDate, nameOfApplicant, Licenceno, localID;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    String cbPartnerID;
    FoodWareHouseAdapterlist adapter;
    Context ctx;
    SwipeRefreshLayout swipeLayout;


    ListView foodCropsWarehouselist;
    private ArrayList<FoodWareHouseInspection> foodWareHouseInspectionArrayList = new ArrayList<>();
    private HashMap<Integer, String> localhash = new HashMap<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.food_crops_warehouse_fragment1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============Food processing inspection List =========");
        getFoodWareHouseInspectionList();


    }

    private void getFoodWareHouseInspectionList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.foodCropsWarehouselist);
        foodWareHouseInspectionArrayList.clear();
        List<FoodWareHouseInspection> foodWareHouseInspectionlist = db.getFoodWareHouseInspectionList();

        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = foodWareHouseInspectionlist.size();
        System.out.println(listSize + "===============FoodWareHouseInspectionlist==========");

        for (int i = 0; i < foodWareHouseInspectionlist.size(); i++) {
            System.out.println("Document Number=== " + foodWareHouseInspectionlist.get(i).getDocumentNumber());

            String retreivedDocumentDate = foodWareHouseInspectionlist.get(i).getDocumentDate();

            cbPartnerID = foodWareHouseInspectionlist.get(i).getNameOfApplicant();

            for(CBPartner partner : cbPartnerList){
                if(null != cbPartnerID && cbPartnerID.equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    //System.out.println(app + " cbPartner not found");
                }
            }


            if (retreivedDocumentDate != null) {
                foodWareHouseInspectionArrayList.add(new FoodWareHouseInspection(
                        foodWareHouseInspectionlist.get(i).getDocumentNumber(),
                        retreivedDocumentDate,
                        cbPartner,
                        foodWareHouseInspectionlist.get(i).getFoodWarehouselicence()));
            }


            localhash.put(i, foodWareHouseInspectionlist.get(i).getLocalID());
            adapter = new FoodWareHouseAdapterlist(getActivity(), foodWareHouseInspectionArrayList);
            list.setAdapter(adapter);
        }


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_date);
                TextView textviewsisalSpinningExportNumber = viewClicked.findViewById(R.id.textviewlicence_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicant);

                documentNumber = foodWareHouseInspectionArrayList.get(position).getDocumentNumber();
                documentDate = foodWareHouseInspectionArrayList.get(position).getDocumentDate();
                Licenceno = foodWareHouseInspectionArrayList.get(position).getFoodWarehouselicence();
                nameOfApplicant = foodWareHouseInspectionArrayList.get(position).getNameOfApplicant();

                localID = localhash.get(position);

            }
        });
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        FoodWareHouseBus foodWareHouseBus = FoodWareHouseBus.getInstance();
       /* foodWareHouseBus.setDocumentNumber(documentNumber);
        foodWareHouseBus.setDocumentDate(documentDate);
        foodWareHouseBus.setFoodWarehouselicence(Licenceno);
        foodWareHouseBus.setNameOfApplicant(nameOfApplicant);*/
        foodWareHouseBus.setLocalID(localID);
        if (foodWareHouseBus.getLocalID() != null && !foodWareHouseBus.getLocalID().isEmpty()) {
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
