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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.HCDColdRoomTemperatures;
import co.ke.bsl.data.view.HCDColdRoomTemperaturesBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.ColdRoomTemperatureViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDColdRoomTemperaturesRecordsStep2 extends Fragment implements BlockingStep {

    @BindView(R.id.etColdRoom)
    CustomEditText etColdRoom;
    @BindView(R.id.etTime)
    CustomEditText etTime;
    @BindView(R.id.etIndicatorTemp)
    CustomEditText etIndicatorTemp;
    @BindView(R.id.etThermometerprobeTemp)
    CustomEditText etThermometerprobeTemp;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private ColdRoomTemperatureViewModel coldRoomTemperatureViewModel;

    private String coldRoom, /*time,*/ indicatorTempe, thermometerProbeTem;
    private Timestamp time;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdcold_room_temperatures_records_step2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        coldRoomTemperatureViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(ColdRoomTemperatureViewModel.class);


        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {


    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        coldRoom = Objects.requireNonNull(etColdRoom.getText()).toString().trim();
        indicatorTempe = Objects.requireNonNull(etIndicatorTemp.getText()).toString().trim();
        thermometerProbeTem = Objects.requireNonNull(etThermometerprobeTemp.getText()).toString().trim();

        time = new Timestamp(System.currentTimeMillis());
        //validation
        boolean valid = validateEditText(etColdRoom, coldRoom) &
//                validateEditText(etTime, time) &
                validateEditText(etIndicatorTemp, indicatorTempe) &
                validateEditText(etThermometerprobeTemp, thermometerProbeTem);

        HCDColdRoomTemperaturesBus hCDColdRoomTemperaturesBus = HCDColdRoomTemperaturesBus.getInstance();

        HCDColdRoomTemperatures HCDColdRoomTemperatures = new HCDColdRoomTemperatures(
                0,
                hCDColdRoomTemperaturesBus.getDocumentNumber(),
                hCDColdRoomTemperaturesBus.getDocumentDate(),
                hCDColdRoomTemperaturesBus.getNameOfApplicant(),
                hCDColdRoomTemperaturesBus.getLocalID(),
                coldRoom,
                time.toString(),
                indicatorTempe,
                thermometerProbeTem,
                false,
                ""
        );

        if (valid) {

            new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("COLD ROOM TEMPERATURES INSPECTION!")
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

                            db.insertHCDColdRoomTemparatureInspection(HCDColdRoomTemperatures);
                            db.UpdateColdRoomTemparatureDetails(HCDColdRoomTemperatures);

                            coldRoomTemperatureViewModel.addRecord(HCDColdRoomTemperatures);

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
