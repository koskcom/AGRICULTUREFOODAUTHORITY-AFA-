package co.ke.bsl.ui.views.fragments;


import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.CountyView;
import co.ke.bsl.data.view.SugarCompanyView;
import co.ke.bsl.data.view.SugarRetailPricesSurveyBus;
import co.ke.bsl.pojo.Country;
import co.ke.bsl.pojo.Survey;
import co.ke.bsl.task.HttpGetSurveyListTask;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class SugarSurveyRetailLocalBrand extends Fragment implements BlockingStep, HttpGetSurveyListTask.HttpJsonGetSurveyListTaskCaller<Survey> {

    @BindView(R.id.etRetail_local_Brand)
    CustomEditText etRetail_local_Brand;
    @BindView(R.id.etRetail_local_Brandprice_1kg)
    CustomEditText etRetail_local_Brandprice_1kg;
    @BindView(R.id.etRetail_local_Brandprice_2kg)
    CustomEditText etRetail_local_Brandprice_2kg;

    private String retail_local_Brand, retail_local_Brandprice_1kg, retail_local_Brandprice_2kg;

    AFADatabaseAdapter db;

    protected Handler asyncTaskHandler;
    private AsyncActivitySupport asyncSupport;
    EditText shopName, latitude, longitude;

    private Location location;

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final long UPDATE_INTERVAL = 5000, FASTEST_INTERVAL = 5000; // = 5 seconds
    // lists for permissions
    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private ArrayList<String> permissions = new ArrayList<>();
    // integer for permissions results request
    private static final int ALL_PERMISSIONS_RESULT = 1011;


    AFA app;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sugar_survey_retail_local_brand, container, false);

        ButterKnife.bind(this, view);

        db = new AFADatabaseAdapter(getContext()).open();

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        retail_local_Brand = Objects.requireNonNull(etRetail_local_Brand.getText()).toString().trim();
        retail_local_Brandprice_1kg = Objects.requireNonNull(etRetail_local_Brandprice_1kg.getText()).toString().trim();
        retail_local_Brandprice_2kg = Objects.requireNonNull(etRetail_local_Brandprice_2kg.getText()).toString().trim();

        if (TextUtils.isEmpty(retail_local_Brand)) {
            etRetail_local_Brand.setError("Brand Required");
            return;
        }
        if (TextUtils.isEmpty(retail_local_Brandprice_1kg)) {
            etRetail_local_Brandprice_1kg.setError("Price Required");
            return;
        }
        if (TextUtils.isEmpty(retail_local_Brandprice_2kg)) {
            etRetail_local_Brandprice_2kg.setError("Price Required");
            return;
        }
        SugarRetailPricesSurveyBus sugarRetailPricesSurveyBus = SugarRetailPricesSurveyBus.getInstance();

        sugarRetailPricesSurveyBus.setRetail_local_Brand(retail_local_Brand);
        sugarRetailPricesSurveyBus.setRetail_local_Brandprice_1kg(retail_local_Brandprice_1kg);
        sugarRetailPricesSurveyBus.setRetail_local_Brandprice_2kg(retail_local_Brandprice_2kg);

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
    public void showLoadingProgressDialog() {
        asyncSupport.showLoadingProgressDialog();

    }

    @Override
    public void dismissProgressDialog() {
        asyncSupport.dismissProgressDialog();

    }

    @Override
    public void onAsyncTaskFailed(Class<?> taskClass, int requestCode, Throwable throwable) {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    @Override
    public void onHttpGetTaskSucceeded(int requestCode, ArrayList<Survey> serverResponse) {

    }
}