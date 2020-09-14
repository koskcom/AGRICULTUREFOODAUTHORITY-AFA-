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
import android.widget.CheckBox;
import android.widget.Spinner;

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
import co.ke.bsl.data.view.PersanlHygieneBus;
import co.ke.bsl.data.view.View2Marks;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.PersanlHygiene;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDPersonalHygeneChecklistStep1 extends Fragment implements BlockingStep {

    @BindView(R.id.ssNameOfApplicant)
    SearchableSpinner ssNameOfApplicant;


    private String ssnameOfApplicant, cbPartnerID;
    private List<CBPartner> cbPartnerArrayList = new ArrayList<>();

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdpersonal_hygene_checklist_step1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        List<CBPartner> cbPartnerList = db.getAllCPartners();

        setListApplicants(cbPartnerList);

        ssNameOfApplicant.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CBPartner cb = (CBPartner) ssNameOfApplicant.getSelectedItem();
                ssnameOfApplicant = cb.getName();
                cbPartnerID = cb.getC_bpartner_id();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
       // nameOfApplicant = Objects.requireNonNull(ssNameOfApplicant.getSelectedItem()).toString().trim();
        PersanlHygieneBus persanlHygieneBus = PersanlHygieneBus.getInstance();
        persanlHygieneBus.setSsnameOfApplicant(cbPartnerID);

        callback.goToNextStep();

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

    private void setListApplicants(List<CBPartner> cbPartnerList) {
//        cbPartnerList.add("- Required -");
        for (CBPartner regionWrapper : cbPartnerList) {
            cbPartnerArrayList.add(regionWrapper);
        }
        ArrayAdapter<CBPartner> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, cbPartnerArrayList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssNameOfApplicant.setAdapter(regionAdapter);
    }
}
