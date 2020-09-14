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
import android.widget.Spinner;
import android.widget.TextView;

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
import co.ke.bsl.data.view.HCDHorticulturalCropsColdStorageBus;
import co.ke.bsl.pojo.CBPartner;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDHorticulturalCropsColdStorageRegister extends Fragment implements BlockingStep {

    @BindView(R.id.ssNameOfApplicant)
    SearchableSpinner ssNameOfApplicant;

    private AFA app;
    private AFADatabaseAdapter db;

    private String nameOfApplicant, cbPartnerID;
    private List<CBPartner> cbPartnerArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdhorticultural_crops_cold_storage_register, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        List<CBPartner> cbPartnerList = db.getAllCPartners();

        setListApplicants(cbPartnerList);

        ssNameOfApplicant.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CBPartner cb = (CBPartner) ssNameOfApplicant.getSelectedItem();
                nameOfApplicant = cb.getName();
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

        if (null == nameOfApplicant && "- Required -".equals(nameOfApplicant)) {
            TextView errorText = (TextView) ssNameOfApplicant.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }

            return;
        }
        HCDHorticulturalCropsColdStorageBus hCDHorticulturalCropsColdStorageBus = HCDHorticulturalCropsColdStorageBus.getInstance();
        hCDHorticulturalCropsColdStorageBus.setNameOfApplicant(nameOfApplicant);

        callback.goToNextStep();

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
