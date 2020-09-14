package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.HCDHorticulturalCropsColdStorage;
import co.ke.bsl.data.view.HCDHorticulturalCropsColdStorageBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.HorticulturalCropsColdStorageViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDHorticulturalCropsColdStorageChanges extends Fragment implements BlockingStep {


    @BindView(R.id.etBalance)
    CustomEditText etBalance;
    @BindView(R.id.etCharges)
    CustomEditText etCharges;

    private String balance, charges;
    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private HorticulturalCropsColdStorageViewModel horticulturalCropsColdStorageViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdhorticultural_crops_cold_storage_changes, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        horticulturalCropsColdStorageViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(HorticulturalCropsColdStorageViewModel.class);


        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        balance = Objects.requireNonNull(etBalance.getText()).toString().trim();
        charges = Objects.requireNonNull(etCharges.getText()).toString().trim();

        //validation
        boolean valid = validateEditText(etBalance, balance) &
                validateEditText(etCharges, charges);

        HCDHorticulturalCropsColdStorageBus hCDHorticulturalCropsColdStorageBus = HCDHorticulturalCropsColdStorageBus.getInstance();
        HCDHorticulturalCropsColdStorage hCDHorticulturalCropsColdStorage = new HCDHorticulturalCropsColdStorage(
                0,
                hCDHorticulturalCropsColdStorageBus.getNameOfApplicant(),
                hCDHorticulturalCropsColdStorageBus.getLocalID(),
                hCDHorticulturalCropsColdStorageBus.getProductsCategory(),
                hCDHorticulturalCropsColdStorageBus.getProduct(),
                hCDHorticulturalCropsColdStorageBus.getColdRoomNo(),
                hCDHorticulturalCropsColdStorageBus.getDateBrouught(),
                hCDHorticulturalCropsColdStorageBus.getPayCategory(),
                hCDHorticulturalCropsColdStorageBus.getPayCategoryRemarks(),
                hCDHorticulturalCropsColdStorageBus.getPackagingMaterial(),
                hCDHorticulturalCropsColdStorageBus.getWeightIn(),
                hCDHorticulturalCropsColdStorageBus.getQuality(),
                hCDHorticulturalCropsColdStorageBus.getDateOut(),
                hCDHorticulturalCropsColdStorageBus.getWeightOut(),
                balance,
                charges,
                false,
                ""
        );

        if (valid) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("HCD crops col storage INSPECTION!")
                    .setCancelText("NO!")
                    .setConfirmText("Submit!")
                    .showCancelButton(true)
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            // reuse previous dialog instance, keep widget user state, reset them if you need
                            sDialog.setTitleText("Cancelled!")
                                    .setContentText("You Cancelled Submission:)")
                                    .setConfirmText("OK")
                                    .showCancelButton(false)
                                    .setCancelClickListener(null)
                                    .setConfirmClickListener(null)
                                    .changeAlertType(SweetAlertDialog.ERROR_TYPE);

                        }
                    })
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.setTitleText("Successfully!!!")
                                    .setContentText("Submitted!")
                                    .setConfirmText("OK")
                                    .showCancelButton(false)
                                    .setCancelClickListener(null)
                                    .setConfirmClickListener(null)
                                    .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);


                            long coldStorageRegisterID = db.insertColdStorageRegister(hCDHorticulturalCropsColdStorageBus.getNameOfApplicant(),
                                    "0");

                            long coldStorageRegisterIn = db.insertColdStorageRegisterIn( String.valueOf(coldStorageRegisterID),
                                    hCDHorticulturalCropsColdStorageBus.getProductsCategory(),
                                    hCDHorticulturalCropsColdStorageBus.getProduct(),
                                    hCDHorticulturalCropsColdStorageBus.getColdRoomNo(),
                                    hCDHorticulturalCropsColdStorageBus.getDateBrouught(),
                                    hCDHorticulturalCropsColdStorageBus.getPayCategory(),
                                    hCDHorticulturalCropsColdStorageBus.getPackagingMaterial(),
                                    hCDHorticulturalCropsColdStorageBus.getWeightIn(),
                                    hCDHorticulturalCropsColdStorageBus.getQuality(),
                                    "0");

                            long coldStorageRegisterOut = db.insertColdStorageRegisterout(String.valueOf(coldStorageRegisterIn),
                                    hCDHorticulturalCropsColdStorageBus.getDateOut(),
                                    hCDHorticulturalCropsColdStorageBus.getWeightOut(),
                                    "0");

                            db.insertColdStorageRegisterCharges(String.valueOf(coldStorageRegisterOut),
                                    hCDHorticulturalCropsColdStorageBus.getBalance(),
                                    hCDHorticulturalCropsColdStorageBus.getCharges(),
                                    "0");

                            horticulturalCropsColdStorageViewModel.addRecord(hCDHorticulturalCropsColdStorage);


                            sDialog.dismissWithAnimation();
                            Intent intent = new Intent(getActivity(), DashboardActivity.class);
                            startActivity(intent);
                        }
                    })
                    .show();


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
