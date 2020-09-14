package co.ke.bsl.ui.views.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
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
import co.ke.bsl.data.view.FCDSisalSpinningFactoryInspectionBus;
import co.ke.bsl.data.view.FoodProcessingBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.FoodProcessingInpection;
import co.ke.bsl.pojo.SisalSpinningFactoryInspection;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.FCDSisalSpinningFactoryInspectionCustomListAdapter;
import co.ke.bsl.ui.views.widgets.FoodCropAdapterList;
import co.ke.bsl.ui.views.widgets.FoodProcessingListAdapter;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

public class FoodProcessingInspectionChecklist extends Fragment implements BlockingStep{


    private String documentNumber, documentDate, nameOfApplicant, Licenceno, localID;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    String cbPartnerID;
    FoodProcessingListAdapter adapter;
    ListView foodprocessinglist;
    SwipeRefreshLayout swiperefreshlayout;
    Context ctx;
    SwipeRefreshLayout swipeLayout;

    private ArrayList<FoodProcessingInpection> foodProcessingInpectionArrayList = new ArrayList<>();
    private HashMap<Integer, String> localhash = new HashMap<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_food_processing_inspection_checklist, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;

    }

  @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============Food processing inspection List =========");
        getFoodProcessingInpectionList();

    }

    private void getFoodProcessingInpectionList() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.foodprocessinglist);
        foodProcessingInpectionArrayList.clear();
        foodProcessingInpectionArrayList.removeAll(foodProcessingInpectionArrayList);
        List<FoodProcessingInpection> foodProcessingInpectionlist = db.getFoodProcessingInpectionList();

        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        int listSize = foodProcessingInpectionlist.size();
        System.out.println(listSize + "===============foodProcessingInpectionlist==========");

        for (int i = 0; i < foodProcessingInpectionlist.size(); i++) {
            System.out.println("Document Number=== " + foodProcessingInpectionlist.get(i).getDocumentNumber());

            String retreivedDocumentDate = foodProcessingInpectionlist.get(i).getDocumentDate();

            cbPartnerID = foodProcessingInpectionlist.get(i).getNameOfApplicant();

            for(CBPartner partner : cbPartnerList){
                if(null != cbPartnerID && cbPartnerID.equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    //System.out.println(app + " cbPartner not found");
                }
            }


            if (retreivedDocumentDate != null) {
                foodProcessingInpectionArrayList.add(new FoodProcessingInpection(
                        foodProcessingInpectionlist.get(i).getDocumentNumber(),
                        retreivedDocumentDate,
                        cbPartner,
                        foodProcessingInpectionlist.get(i).getFoodCropManufacturingPlanApproval()));
            }


            localhash.put(i, foodProcessingInpectionlist.get(i).getLocalID());
            adapter = new FoodProcessingListAdapter(getActivity(), foodProcessingInpectionArrayList);
            list.setAdapter(adapter);
        }


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date_date);
                TextView textviewsisalSpinningExportNumber = viewClicked.findViewById(R.id.textviewlicence_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewname_of_applicant);

                documentNumber = foodProcessingInpectionArrayList.get(position).getDocumentNumber();
                documentDate = foodProcessingInpectionArrayList.get(position).getDocumentDate();
                Licenceno = foodProcessingInpectionArrayList.get(position).getFoodCropManufacturingPlanApproval();
                nameOfApplicant = foodProcessingInpectionArrayList.get(position).getNameOfApplicant();

                localID = localhash.get(position);

            }
        });
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        FoodProcessingBus foodProcessingBus = FoodProcessingBus.getInstance();
        foodProcessingBus.setDocumentNumber(documentNumber);
        foodProcessingBus.setDocumentDate(documentDate);
        foodProcessingBus.setFoodCropManufacturingPlanApproval(Licenceno);
        foodProcessingBus.setNameOfApplicant(nameOfApplicant);
        foodProcessingBus.setLocalID(localID);



        if (foodProcessingBus.getLocalID() != null && !foodProcessingBus.getLocalID().isEmpty()) {
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
