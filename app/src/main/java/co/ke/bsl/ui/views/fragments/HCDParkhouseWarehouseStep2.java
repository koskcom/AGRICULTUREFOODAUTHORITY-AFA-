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
import android.widget.CheckBox;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.HCDParkhouseWarehouseBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDParkhouseWarehouseStep2 extends Fragment implements BlockingStep {
    @BindView(R.id.etHCDPackhousename)
    CustomEditText etHCDPackhousename;
    @BindView(R.id.etHCDPackhousetel)
    CustomEditText etHCDPackhousetel;
    @BindView(R.id.etHCDPackhouselocation)
    CustomEditText etHCDPackhouselocation;
    @BindView(R.id.etHCDPackhouselicenceNumber)
    CustomEditText etHCDPackhouselicenceNumber;


    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;
    private String name, tel, location, licenceNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdparkhouse_warehouse_step2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();
        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

        name = Objects.requireNonNull(etHCDPackhousename.getText()).toString().trim();
        tel = Objects.requireNonNull(etHCDPackhousetel.getText()).toString().trim();
        location = Objects.requireNonNull(etHCDPackhouselocation.getText()).toString().trim();
        licenceNumber = Objects.requireNonNull(etHCDPackhouselicenceNumber.getText()).toString().trim();

        boolean valid = validateEditText(etHCDPackhousename, name) &
                validateEditText(etHCDPackhouselocation, location) &
                validateEditText(etHCDPackhouselicenceNumber, licenceNumber);


        HCDParkhouseWarehouseBus hCDParkhouseWarehouseBus = HCDParkhouseWarehouseBus.getInstance();
        hCDParkhouseWarehouseBus.setName(name);
        hCDParkhouseWarehouseBus.setTel(tel);
        hCDParkhouseWarehouseBus.setLocation(location);
        hCDParkhouseWarehouseBus.setLicenceNumber(licenceNumber);

        if(valid) {
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
}
