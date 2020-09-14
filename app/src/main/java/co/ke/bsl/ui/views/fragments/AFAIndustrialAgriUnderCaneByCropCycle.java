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
import android.widget.ArrayAdapter;

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
import co.ke.bsl.data.view.SectorView;
import co.ke.bsl.pojo.LoginService;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFAIndustrialAgriUnderCaneByCropCycle extends Fragment implements BlockingStep
{
    @BindView(R.id.sssector)
    SearchableSpinner sssector;
    @BindView(R.id.etpc)
    CustomEditText etpc;
    @BindView(R.id.etr1)
    CustomEditText etr1;
    @BindView(R.id.etr2)
    CustomEditText etr2;
    @BindView(R.id.etr3)
    CustomEditText etr3;
    @BindView(R.id.etcrop_cycle_total)
    CustomEditText etcrop_cycle_total;
    @BindView(R.id.etcrop_cycle_remarks)
    CustomEditText etcrop_cycle_remarks;

    protected List<SectorView> sectorList;

    private AsyncActivitySupport asyncSupport;
    AFADatabaseAdapter db;
    private GPSTracker mGPS;

    protected Handler asyncTaskHandler;
    LoginService loginService;
    private String survey_type, city,document_number,document_date, survey_ending;

    AFA app;

    private ArrayList<String> sectorlist = new ArrayList<>();

    private String sector, pc, R1,R2,R3,crop_Cycle_Total,crop_Cycle_Remarks;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afaindustrial_agri_under_cane_by_crop_cycle, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        setListsector(getDummySector());

        sssector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                sector = sssector.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        return view;
    }

    private void setListsector(List<SectorView> dummySector)
    {
        sectorlist.add("- Required -");
        for (SectorView regionWrapper : dummySector)
        {
            sectorlist.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, sectorlist);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        sssector.setAdapter(regionAdapter);
    }

    private List<SectorView> getDummySector()
    {
        List<SectorView> listViewItems = new ArrayList<>();
        listViewItems.add(new SectorView("Sector A"));
        listViewItems.add(new SectorView("Sector B"));
        listViewItems.add(new SectorView("Sector C"));
        listViewItems.add(new SectorView("Sector D"));

        return listViewItems;
    }
    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
//        sector = Objects.requireNonNull(sssector.getSelectedItem().toString());
        pc = Objects.requireNonNull(etpc.getText().toString());
        R1 = Objects.requireNonNull(etr1.getText().toString());
        R2 = Objects.requireNonNull(etr2.getText().toString());
        R3 = Objects.requireNonNull(etr3.getText().toString());
        crop_Cycle_Total = Objects.requireNonNull(etcrop_cycle_total.getText().toString());
        crop_Cycle_Remarks = Objects.requireNonNull(etcrop_cycle_remarks.getText().toString());
/*
        IndustryAgriculturalProductionBus industryAgriculturalProductionBus = IndustryAgriculturalProductionBus.getInstance();

        industryAgriculturalProductionBus.setSector(sector);
        industryAgriculturalProductionBus.setR1(R1);
        industryAgriculturalProductionBus.setR2(R2);
        industryAgriculturalProductionBus.setR3(R3);
        industryAgriculturalProductionBus.setCrop_Cycle_Total(crop_Cycle_Total);
        industryAgriculturalProductionBus.setCrop_Cycle_Remarks(crop_Cycle_Remarks);
*/
        callback.goToNextStep();
    }
    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback)
    {

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback)
    {

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
    public void onError(@NonNull VerificationError error)
    {

    }
    void dismissProgressDialog() {
        asyncSupport.dismissProgressDialog();



    }


}

