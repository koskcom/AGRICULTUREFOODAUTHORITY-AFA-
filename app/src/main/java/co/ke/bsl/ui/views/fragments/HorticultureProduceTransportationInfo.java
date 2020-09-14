package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;

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
import co.ke.bsl.data.model.HorticultureProduceTransportation;
import co.ke.bsl.data.view.HorticultureProduceTransportationBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.HorticulturalProduceTransportationViewModel;
import co.ke.bsl.ui.viewmodels.HorticultureNurseryViewModel;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorticultureProduceTransportationInfo extends Fragment implements BlockingStep {


    @BindView(R.id.etHCDName)
    CustomEditText etHCDName;
    @BindView(R.id.etHCDRegNo)
    CustomEditText etHCDRegNo;

    @BindView(R.id.isOwnFarm)
    CheckBox isOwnFarm;
    @BindView(R.id.isContractedSources)
    CheckBox isContractedSources;

    @BindView(R.id.isProduceTrans)
    CheckBox isProduceTrans;
    @BindView(R.id.etProduceTransRemarks)
    CustomEditText etProduceTransRemarks;

    @BindView(R.id.isTransVessel)
    CheckBox isTransVessel;
    @BindView(R.id.etTransVesselRemarks)
    CustomEditText etTransVesselRemarks;

    @BindView(R.id.isClearedDoc)
    CheckBox isClearedDoc;
    @BindView(R.id.etClearedDocRemarks)
    CustomEditText etClearedDocRemarks;

    @BindView(R.id.isIntegrityProduct)
    CheckBox isIntegrityProduct;
    @BindView(R.id.etIntegrityProductRemarks)
    CustomEditText etIntegrityProductRemarks;

    @BindView(R.id.isProduceHandling)
    CheckBox isProduceHandling;
    @BindView(R.id.etProduceHandlingRemarks)
    CustomEditText etProduceHandlingRemarks;

    @BindView(R.id.etHCDComments)
    CustomEditText etHCDComments;

    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    AFADatabaseAdapter db;
    AFA app;

    private HorticulturalProduceTransportationViewModel horticulturalProduceTransportationViewModel;

    private String str_own, str_contracted, str_produce, str_transport, str_cleared, str_integrity, str_handling;

   private String recommendation, recommendationRemarks;
    private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();


    public HorticultureProduceTransportationInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horticulture_produce_transportation_info, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        horticulturalProduceTransportationViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(HorticulturalProduceTransportationViewModel.class);

        setReccomendationsView(getReccomendationsView());

        ssReccomendation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ReccomendationsView rec = (ReccomendationsView) ssReccomendation.getSelectedItem();
                recommendation = rec.getServerID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        isOwnFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOwnFarm.isChecked()) {
                    str_own = "Y";
                } else {
                    str_own= "N";
                }
            }
        });

        isContractedSources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isContractedSources.isChecked()) {
                    str_contracted = "Y";
                } else {
                    str_contracted= "N";
                }
            }
        });

        isProduceTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProduceTrans.isChecked()) {
                    str_produce = "Y";
                } else {
                    str_produce= "N";
                }
            }
        });

        isTransVessel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTransVessel.isChecked()) {
                    str_transport= "Y";
                } else {
                    str_transport= "N";
                }
            }
        });

        isClearedDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClearedDoc.isChecked()) {
                    str_cleared = "Y";
                } else {
                    str_cleared= "N";
                }
            }
        });

        isIntegrityProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isIntegrityProduct.isChecked()) {
                    str_integrity= "Y";
                } else {
                    str_integrity= "N";
                }
            }
        });

        isProduceHandling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProduceHandling.isChecked()) {
                    str_handling= "Y";
                } else {
                    str_handling= "N";
                }
            }
        });

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        String name = Objects.requireNonNull(etHCDName.getText()).toString().trim();
        String reg= Objects.requireNonNull(etHCDRegNo.getText()).toString().trim();
        String produce= Objects.requireNonNull(etProduceTransRemarks.getText()).toString().trim();
        String transport= Objects.requireNonNull(etTransVesselRemarks.getText()).toString().trim();
        String cleared= Objects.requireNonNull(etClearedDocRemarks.getText()).toString().trim();
        String integrity= Objects.requireNonNull(etIntegrityProductRemarks.getText()).toString().trim();
        String handling= Objects.requireNonNull(etProduceHandlingRemarks.getText()).toString().trim();
        String comment= Objects.requireNonNull(etHCDComments.getText()).toString().trim();
        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        boolean valid = validateEditText(etHCDName, name) &
                validateEditText(etHCDRegNo, reg) &
                validateFields(isProduceTrans, etProduceTransRemarks, produce) &
                validateFields(isTransVessel, etTransVesselRemarks, transport) &
                validateFields(isClearedDoc, etClearedDocRemarks, cleared) &
                validateFields(isIntegrityProduct, etIntegrityProductRemarks, integrity) &
                validateFields(isProduceHandling, etProduceHandlingRemarks, handling);

        HorticultureProduceTransportationBus horticultureProduceTransportationBus = HorticultureProduceTransportationBus.getInstance();
        HorticultureProduceTransportation horticultureProduceTransportation = new HorticultureProduceTransportation(
                0,
                horticultureProduceTransportationBus.getDealerCategory(),
                horticultureProduceTransportationBus.getNameOfApllicant(),
                horticultureProduceTransportationBus.getCountyID(),
                horticultureProduceTransportationBus.getLocation(),
                horticultureProduceTransportationBus.getDocumentNumber(),
                horticultureProduceTransportationBus.getDocumentDate(),
                horticultureProduceTransportationBus.getIsAdhocInspection(),
                horticultureProduceTransportationBus.getTelephone(),
                horticultureProduceTransportationBus.getSubCountyID(),
                horticultureProduceTransportationBus.getCropOfInterest(),
                horticultureProduceTransportationBus.getExportLicence(),
                horticultureProduceTransportationBus.getLocalID(),
                name,
                reg,
                str_own,
                str_contracted,
                str_produce,
                produce,
                str_transport,
                transport,
                str_cleared,
                cleared,
                str_integrity,
                integrity,
                str_handling,
                handling,
                comment,
                recommendation,
                recommendationRemarks,
                "",
                false,
                "");

        if(valid) {
            if(null != horticultureProduceTransportationBus.getLocalID() && !horticultureProduceTransportationBus.getLocalID().isEmpty()) {
                long updateHorticultureProduceTransportationID = db.updateHorticultureProduceTransportation(horticultureProduceTransportation);
              horticulturalProduceTransportationViewModel.addRecord(horticultureProduceTransportation);

                System.out.println("updateHorticultureProduceTransportationID " + updateHorticultureProduceTransportationID);
                Intent intent = new Intent(getActivity(), DashboardActivity.class);
                Objects.requireNonNull(getActivity()).finish();
                startActivity(intent);
            }
        }
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

    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString){

        boolean result= false;

        if(!checkBox.isChecked()){
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                result = false;
            } else{
                result = true;
            }
        } else{
            customEditText.setError(null);
            result = true;
        }

        return result;
    }

    private boolean validateEditText(CustomEditText customEditText, String customEditTextString) {

        boolean result = false;

        if (TextUtils.isEmpty(customEditTextString)) {
            customEditText.setError("Field Required ");
            result = false;
        } else {
            customEditText.setError(null);
            result = true;
        }

        return result;
    }

    private void setReccomendationsView(List<ReccomendationsView> getdummy10marks) {
        //        reccomendationsViewList.add("- Required -");
        for (ReccomendationsView regionWrapper : getdummy10marks) {
            reccomendationsViewList.add(regionWrapper);
        }

        ArrayAdapter<ReccomendationsView> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, reccomendationsViewList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssReccomendation.setAdapter(regionAdapter);

    }

    private List<ReccomendationsView> getReccomendationsView() {
        List<ReccomendationsView> listViewItems = new ArrayList<>();
        listViewItems.add(new ReccomendationsView("-select-", ""));
        listViewItems.add(new ReccomendationsView("I Recommend", "10000245"));
        listViewItems.add(new ReccomendationsView("I Do Not Recommend", "10000246"));

        return listViewItems;
    }

}
