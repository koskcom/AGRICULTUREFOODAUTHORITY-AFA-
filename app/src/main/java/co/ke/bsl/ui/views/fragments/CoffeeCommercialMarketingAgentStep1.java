package co.ke.bsl.ui.views.fragments;


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
import co.ke.bsl.data.view.CoffeeCommercialMarketingAgentBus;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CoffeeCommercialAgent;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.views.widgets.CofffeeComercialMarketCustomListAdapter;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeCommercialMarketingAgentStep1 extends Fragment implements BlockingStep {


    @BindView(R.id.coffeemktagentlist)
    ListView coffeemktagentlist;

    AFADatabaseAdapter db;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    CofffeeComercialMarketCustomListAdapter adapter;
    private String localID;
    private String cbPartnerID;

    private ArrayList<CoffeeCommercialAgent> coffeeCommercialAgentArraylist = new ArrayList<>();
    private HashMap<Integer, String> localhash = new HashMap<>();

    AFA app;
    private String document_number, document_date, name_of_applicant, licence_number;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_commercial_marketing_agent_step1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        db = new AFADatabaseAdapter(getContext()).open();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("===============OnActicityCreeted==========");
        getCoffeeCommercialAgent();


    }

    private void getCoffeeCommercialAgent() {
        //Creating a list view items
        ListView list = (ListView) getView().findViewById(R.id.coffeemktagentlist);

        List<CoffeeCommercialAgent> coffeeCommercialAgentlist = db.getCoffeeCommercialAgent();
        List<CBPartner> cbPartnerList = db.getAllCPartners();
        String cbPartner = "";
        coffeeCommercialAgentArraylist.clear();

        int listSize = coffeeCommercialAgentlist.size();
        System.out.println(listSize + "===============CoffeeCommercialAgent ==========");

        for (int i = 0; i < coffeeCommercialAgentlist.size(); i++) {
            System.out.println("Document Number=== " + coffeeCommercialAgentlist.get(i).getDocument_number());
            System.out.println("the Date passed is " + coffeeCommercialAgentlist.get(i).getDocument_date());
            System.out.println("the licence passed is " + coffeeCommercialAgentlist.get(i).getLicence_number());
            System.out.println("the Applicant name passed is " + coffeeCommercialAgentlist.get(i).getName_of_applicant());

            String retreivedDocumentDate = coffeeCommercialAgentlist.get(i).getDocument_date();
            cbPartnerID = coffeeCommercialAgentlist.get(i).getName_of_applicant();

            for(CBPartner partner : cbPartnerList){
                if(null != coffeeCommercialAgentlist.get(i).getName_of_applicant() && coffeeCommercialAgentlist.get(i).getName_of_applicant().equals(partner.getC_bpartner_id())){
                    cbPartner = partner.getName();
                    System.out.println(app + " cbPartner : " + cbPartner);
                } else{
                    System.out.println(app + " cbPartner not found");
                }
            }



            //Toast.makeText(getContext(), "No Surevy Has Been Created ", Toast.LENGTH_LONG).show();

            if (retreivedDocumentDate != null) {
                coffeeCommercialAgentArraylist.add(new CoffeeCommercialAgent(
                        coffeeCommercialAgentlist.get(i).getDocument_number(),
                        coffeeCommercialAgentlist.get(i).getDocument_date(),
                        cbPartner,
                        coffeeCommercialAgentlist.get(i).getLicence_number()));

            }

            localhash.put(i, coffeeCommercialAgentlist.get(i).getLocalID());
            adapter = new CofffeeComercialMarketCustomListAdapter(getActivity(), coffeeCommercialAgentArraylist);
            list.setAdapter(adapter);


        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textviewDocumentNumber = viewClicked.findViewById(R.id.textviewdocument_no);
                TextView textviewDocumentDate = viewClicked.findViewById(R.id.textviewdocument_date);
                TextView textviewLetterOfComfort = viewClicked.findViewById(R.id.textviewletter_of_comfort);
                TextView textviewApplicantName = viewClicked.findViewById(R.id.textviewapplicant_name);

                document_number = coffeeCommercialAgentArraylist.get(position).getDocument_number();
                document_date = coffeeCommercialAgentArraylist.get(position).getDocument_date();
                licence_number = coffeeCommercialAgentArraylist.get(position).getLicence_number();
                name_of_applicant = coffeeCommercialAgentArraylist.get(position).getName_of_applicant();

                localID = localhash.get(position);

            }
        });
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        CoffeeCommercialMarketingAgentBus coffeeCommercialMarketingAgentBus = CoffeeCommercialMarketingAgentBus.getInstance();

        coffeeCommercialMarketingAgentBus.setDocument_number(document_number);
        coffeeCommercialMarketingAgentBus.setDocument_date(document_date);
        coffeeCommercialMarketingAgentBus.setName_of_applicant(name_of_applicant);
        coffeeCommercialMarketingAgentBus.setLicence_number(licence_number);
        coffeeCommercialMarketingAgentBus.setLocalID(localID);
        if (coffeeCommercialMarketingAgentBus.getLocalID() != null && !coffeeCommercialMarketingAgentBus.getLocalID().isEmpty()) {

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
