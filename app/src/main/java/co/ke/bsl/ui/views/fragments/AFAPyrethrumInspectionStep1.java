package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
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
import cn.pedant.SweetAlert.SweetAlertDialog;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.PyrethrumInspectionBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.PyrethrumInspectionChecklist;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.views.widgets.PyrethrumInspectionDetailsListAdapter;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAPyrethrumInspectionStep1 extends Fragment implements BlockingStep {

    @BindView(R.id.pyrethrumUserlist)
    ListView pyrethrum_user_list;

    AFADatabaseAdapter db;
    AFA app;
    String localID;

    private String cbPartnerID;
    private String document_number, document_date, applicant_name, nursery_certificate_number;
    private ArrayList<PyrethrumInspectionChecklist> pyrethrumInspectionArrayList = new ArrayList<>();
    private PyrethrumInspectionDetailsListAdapter adapter;
    private HashMap<Integer, String> localhash = new HashMap<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afapyrethrum_inspection_step1, container, false);
        ButterKnife.bind(this, view);
        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getActivity()).open();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        System.out.println("===============OnActicityCreated==========");
        getListOfPyrethrumInspection();

    }

    private void getListOfPyrethrumInspection() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.pyrethrumUserlist);
        pyrethrumInspectionArrayList.clear();
        List<PyrethrumInspectionChecklist> pyrethrumInspectionChecklistList = db.getPyrethrumInspectionList();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";

        System.out.println("picking data from the db" + pyrethrumInspectionChecklistList.size());


        for (int i = 0; i < pyrethrumInspectionChecklistList.size(); i++) {
            System.out.println("Document Number=== " + pyrethrumInspectionChecklistList.get(i).getDocument_number());
            System.out.println("Document date=== " + pyrethrumInspectionChecklistList.get(i).getDocument_date());
            System.out.println("c_b_partenr_id=== " + pyrethrumInspectionChecklistList.get(i).getName_of_applicant());
            System.out.println("certificate_number=== " + pyrethrumInspectionChecklistList.get(i).getCertificate_number());

            String retreivedDocumentDate = pyrethrumInspectionChecklistList.get(i).getDocument_date();
//            String convertedDocumentDate = null;
////            if(null != retreivedDocumentDate){
////                convertedDocumentDate = DateConverter.fromDateToString(DateConverter.toDate(retreivedDocumentDate));
////            }
            cbPartnerID = pyrethrumInspectionChecklistList.get(i).getName_of_applicant();

            for(CBPartner partner : cbPartnerList){
                if(null != pyrethrumInspectionChecklistList.get(i).getName_of_applicant() && pyrethrumInspectionChecklistList.get(i).getName_of_applicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }


            if(pyrethrumInspectionChecklistList.get(i).getDocument_number() != null){
                pyrethrumInspectionArrayList.add(new PyrethrumInspectionChecklist(
                        pyrethrumInspectionChecklistList.get(i).getDocument_number(),
                        retreivedDocumentDate,
                        cbPartner,
                        pyrethrumInspectionChecklistList.get(i).getCertificate_number()
                ));
            }



            localhash.put(i, pyrethrumInspectionChecklistList.get(i).getLocalID());
            adapter = new PyrethrumInspectionDetailsListAdapter(getActivity(), pyrethrumInspectionArrayList);
            list.setAdapter(adapter);
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.tvdocument_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.tvdocument_date);
                TextView textviewNurseryCertificateNumber = viewClicked.findViewById(R.id.tvnursery_certificate_number);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.tvapplicant_name);

                document_number = pyrethrumInspectionArrayList.get(position).getDocument_number();
                document_date = pyrethrumInspectionArrayList.get(position).getDocument_date();
                nursery_certificate_number = pyrethrumInspectionArrayList.get(position).getCertificate_number();
                applicant_name = pyrethrumInspectionArrayList.get(position).getName_of_applicant();

                localID = localhash.get(position);

            }
        });
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        PyrethrumInspectionBus pyrethrumInspectionBus = PyrethrumInspectionBus.getInstance();
        pyrethrumInspectionBus.setDocument_number(document_number);
        pyrethrumInspectionBus.setDocument_date(document_date);
        pyrethrumInspectionBus.setName_of_applicant(applicant_name);
        pyrethrumInspectionBus.setCertificate_number(nursery_certificate_number);
        pyrethrumInspectionBus.setLocalID(localID);

        if (pyrethrumInspectionBus.getLocalID() != null && !pyrethrumInspectionBus.getLocalID().isEmpty()) {

            callback.goToNextStep();
        }
        else
        {
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
