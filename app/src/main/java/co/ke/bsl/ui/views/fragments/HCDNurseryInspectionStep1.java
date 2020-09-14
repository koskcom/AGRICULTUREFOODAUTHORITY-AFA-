package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.TextUtils;
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
import co.ke.bsl.data.view.HCDNurseryInspectionBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDNurseryInspectionStep1 extends Fragment implements BlockingStep {


    @BindView(R.id.ssNurser_type)
    SearchableSpinner ssNurser_type;
    @BindView(R.id.etHectarage)
    CustomEditText etHectarage;
    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private String ssNurseryType, hectarage;

    private List<String> nurseryTypeList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afahcdnursery_inspection_step1, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        setListNurseryType(getdummyNurseryType());


        return view;

    }



    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {



        ssNurseryType= Objects.requireNonNull(ssNurser_type.getSelectedItem()).toString().trim();
        hectarage = Objects.requireNonNull(etHectarage.getText()).toString().trim();

        if ("- Required -".equals(ssNurseryType)) {
            TextView errorText = (TextView) ssNurser_type.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }

        //validation
        boolean valid =validateEditText(etHectarage, hectarage);

        HCDNurseryInspectionBus hCDNurseryInspectionBus = HCDNurseryInspectionBus.getInstance();
        hCDNurseryInspectionBus.setSsNurseryType(ssNurseryType);
        hCDNurseryInspectionBus.setHectarage(hectarage);

        if (valid ) {
            callback.goToNextStep();
        }


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

    private void setListNurseryType(List<String> getdummyNurseryType) {
        nurseryTypeList.add("- Required -");
        for (String regionWrapper : getdummyNurseryType) {
            nurseryTypeList.add(regionWrapper);
        }
        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, nurseryTypeList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssNurser_type.setAdapter(regionAdapter);
    }

    private List<String> getdummyNurseryType() {
        List<String> listViewItems = new ArrayList<>();
        listViewItems.add("Mother-block");
        listViewItems.add("Seedlings");
        listViewItems.add("TC");

        return listViewItems;
    }
}
