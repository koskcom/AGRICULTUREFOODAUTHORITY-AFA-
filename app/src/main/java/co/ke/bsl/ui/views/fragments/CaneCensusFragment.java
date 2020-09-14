package co.ke.bsl.ui.views.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.CaneCensusBus;
import co.ke.bsl.data.view.ClientBus;
import co.ke.bsl.data.view.CountyView;
import co.ke.bsl.data.view.SugarCompanyView;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CaneCensusDataCollection;
import co.ke.bsl.pojo.County;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

public class CaneCensusFragment extends Fragment implements BlockingStep {

    @BindView(R.id.ssSugarCompany)
    SearchableSpinner ssSugarCompany;
    @BindView(R.id.sssCounty)
    SearchableSpinner ssCounty;
    protected List<County> countyList;
    AFADatabaseAdapter db;
    private ArrayList<String> sugarCompaniesNameList = new ArrayList<>();
    private GPSTracker mGPS;
    CaneCensusDataCollection caneCensusDataCollection;

    private ArrayList<String> countyNameList = new ArrayList<>();
    protected List<CBPartner> companyList;
    private String sugarCompany;
    private County county;
    AFA app;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cane_census, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
       
        
    
        db=new AFADatabaseAdapter(getActivity()).open();
        countyList = new ArrayList<>();
   
        caneCensusDataCollection = new CaneCensusDataCollection();

        setListSugarCompanies(getDummySugarCompanies());
        setListCounties(getCountyListApplicable());
        

        ssCounty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                county = (County) ssCounty.getSelectedItem();
               // county = ssCounty.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        ssSugarCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                sugarCompany = ssSugarCompany.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    
        mGPS = new GPSTracker(getActivity());
    
        return view;
    }

    private void setListCounties(List<County> realCounty) {

       /* countyNameList.add("- Required -");
        for (County regionWrapper : realCounty) {
            countyNameList.add(regionWrapper.getCountyName());
        }*/

        ArrayAdapter<County> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, realCounty);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssCounty.setAdapter(regionAdapter);
    
    
       
    }

    private void setListSugarCompanies(List<SugarCompanyView> dummySugarCompanies) {

        sugarCompaniesNameList.add("- Required -");
        for (SugarCompanyView regionWrapper : dummySugarCompanies) {
            sugarCompaniesNameList.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, sugarCompaniesNameList);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssSugarCompany.setAdapter(regionAdapter);
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {


        if ("- Required -".equals(sugarCompany.trim())) {
            TextView errorText = (TextView) ssSugarCompany.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }

            return;
        } else if ("- Required -".equals(county.getCountyName())) {
            TextView errorText = (TextView) ssCounty.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        } else {
//            postShopData();

            CaneCensusBus caneCensusBus = CaneCensusBus.getInstance();
            caneCensusBus.setSugarCompanyCounty(county.getCountyId());
            caneCensusBus.setSugarCompany(sugarCompany);
            callback.goToNextStep();
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

    private List<SugarCompanyView> getDummySugarCompanies() {
        List<SugarCompanyView> listViewItems = new ArrayList<>();
        listViewItems.add(new SugarCompanyView("Muhoroni"));
        listViewItems.add(new SugarCompanyView("Butali"));
        listViewItems.add(new SugarCompanyView("Chemilil"));
        listViewItems.add(new SugarCompanyView("Kibos"));
        listViewItems.add(new SugarCompanyView("Kwale"));
        listViewItems.add(new SugarCompanyView("Mumias"));
        listViewItems.add(new SugarCompanyView("Nzoia"));
        listViewItems.add(new SugarCompanyView("Olepito"));
        listViewItems.add(new SugarCompanyView("South Nyanza"));
        listViewItems.add(new SugarCompanyView("Sukari"));
        listViewItems.add(new SugarCompanyView("Transmara"));
        listViewItems.add(new SugarCompanyView("West Kenya"));
        return listViewItems;
    }

   /* private List<CountyView> getDummyCounties() {
        List<CountyView> listViewItems = new ArrayList<>();
        listViewItems.add(new CountyView("Uasin Gishu"));
        listViewItems.add(new CountyView("Nairobi"));
        listViewItems.add(new CountyView("Homa Bay"));
        listViewItems.add(new CountyView("Migori"));
        listViewItems.add(new CountyView("Tana River"));
        listViewItems.add(new CountyView("Marsabit"));
        listViewItems.add(new CountyView("Isiolo"));
        listViewItems.add(new CountyView("Meru"));
        listViewItems.add(new CountyView("Tharaka-Nithi"));
        listViewItems.add(new CountyView("Embu"));
        listViewItems.add(new CountyView("Kitui"));
        listViewItems.add(new CountyView("Machakos"));
        listViewItems.add(new CountyView("Makueni"));
        listViewItems.add(new CountyView("Nyandarua"));
        listViewItems.add(new CountyView("Nyeri"));
        listViewItems.add(new CountyView("Kirinyaga"));
        listViewItems.add(new CountyView("Muranga"));
        listViewItems.add(new CountyView("Kiambu"));
        listViewItems.add(new CountyView("Turkana"));
        listViewItems.add(new CountyView("West Pokot"));
        listViewItems.add(new CountyView("Samburu"));
        listViewItems.add(new CountyView("Trans-Nzoia"));
        listViewItems.add(new CountyView("Elgeyo-Markwet"));
        listViewItems.add(new CountyView("Nandi"));
        listViewItems.add(new CountyView("Baringo"));
        listViewItems.add(new CountyView("Laikipia"));
        listViewItems.add(new CountyView("Nakuru"));
        listViewItems.add(new CountyView("Narok"));
        listViewItems.add(new CountyView("Kajiado"));
        listViewItems.add(new CountyView("Kericho"));
        listViewItems.add(new CountyView("Bomet"));
        listViewItems.add(new CountyView("Kakamega"));
        listViewItems.add(new CountyView("Vihiga"));
        listViewItems.add(new CountyView("Bungoma"));
        listViewItems.add(new CountyView("Busia"));
        listViewItems.add(new CountyView("Siaya"));
        listViewItems.add(new CountyView("Kisumu"));
        listViewItems.add(new CountyView("Kisii"));
        listViewItems.add(new CountyView("Nyamira"));
        listViewItems.add(new CountyView("Mombasa"));
        listViewItems.add(new CountyView("Kwale"));
        listViewItems.add(new CountyView("Kilifi"));
        listViewItems.add(new CountyView("Mandera"));
        listViewItems.add(new CountyView("Wajir"));
        listViewItems.add(new CountyView("Garissa"));
        listViewItems.add(new CountyView("Taita Taveta"));
        listViewItems.add(new CountyView("Lamu"));
        return listViewItems;
    }
    */
    
    protected  List<County>  getCountyListApplicable() {
        countyList.clear();
        
        countyList = db.getAllCounty();
        System.out.println("countyList"+countyList.size());
        return countyList;
        
       // populateSpinner();
        
        
    }
    
   /* protected void getCBPartnerListApplicable() {
        companyList.clear();
        
        // companyList = db.getAllCPartners();
        // countyList=db.getAllCounty();
        
        
        populateCompanySpinner();
        // getCountyListApplicable();
        
        
    }
    */
    
    /**
     * Adding spinner data
     */
    private void populateSpinner() {
        
        ArrayAdapter<County> spinnerAdapter = new ArrayAdapter<County>(getContext(),
                android.R.layout.simple_spinner_item, countyList);
        
        // Drop down layout style - list view with radio button
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        // attaching data adapter to spinner
        ssCounty.setAdapter(spinnerAdapter);
    
        ssCounty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // Can also use mySpinner.setOnItemClickListener(......)
                // Using a separate button here as there's often other data to select
                // or if you choose the wrong item.
                
                if (!(ssCounty.getSelectedItem() == null)) {
                    County selectedCounty = (County) ssCounty.getSelectedItem();
                    app.setCounty(selectedCounty);
                    
                    
                    // toast(String.format("Company Selected: " + selectedCounty.getCountyName() + "\t  County: " + selectedCounty.getCountyId()));
                    
                    
                }
            }
            
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            
            }
        });
    }
    
    /*
     
     * Adding spinner data
     * */
   /* private void populateCompanySpinner() {
      
      *//*  ArrayAdapter<CBPartner> spinnerAdapter = new ArrayAdapter<CBPartner>(getContext(),
                android.R.layout.simple_spinner_item, companyList);*//*
        
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter
                .createFromResource(getContext(), R.array.afa_sugarcompanies,
                        android.R.layout.simple_spinner_item);
        
        
        // Drop down layout style - list view with radio button
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        // attaching data adapter to spinner
        companySpinner.setAdapter(spinnerAdapter);
        
        
        companySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // Can also use mySpinner.setOnItemClickListener(......)
                // Using a separate button here as there's often other data to select
                // or if you choose the wrong item.
                
                if (!(companySpinner.getSelectedItem() == null)) {
                    
                    
                    
                    CBPartner selectedCompany=new CBPartner();
                    selectedCompany.setName(companySpinner.getSelectedItem().toString());
                    
                    appState.setCompany(selectedCompany);
                    // toast(String.format("Company Selected: " + selectedCompany.getName() ));
                    // toast(String.format("Company Selected: " + selectedCompany + "\t  County: " + selectedCompany.getC_bpartner_id()));
                    
                    
                }
            }
            
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            
            }
        });
    }*/
    
    protected void postShopData() {
        
        caneCensusDataCollection=new CaneCensusDataCollection();
        caneCensusDataCollection.setCompanyName(sugarCompany);
        caneCensusDataCollection.setCountyID(county.getCountyId());
        caneCensusDataCollection.setLatitude(String.valueOf(mGPS.getLatitude()));
        caneCensusDataCollection.setLongitude(String.valueOf( mGPS.getLongitude()));
        caneCensusDataCollection.setC_bpartnerID(sugarCompany);
        
        caneCensusDataCollection.setLoginRequest(app.getLoginRequest());
        
        
        
        
        long localID = db.insertMillingCompany(caneCensusDataCollection.getCountyID(),sugarCompany,
                String.valueOf( mGPS.getLongitude()), String.valueOf(mGPS.getLatitude()));
        caneCensusDataCollection.setLocalID(String.valueOf(localID));
        app.setCaneCensusDataCollection(caneCensusDataCollection);
        
        


        /*String uri = getString(R.string.baseURILocal);

        new HttpPostTask<CaneCensusDataCollection>(CaneCensusScoreDataCollectionActivity.this,
                caneCensusDataCollection, uri, 0).execute();*/
        // new SndDeviceDetails().execute(uri, userData.toString());
    }
    
}