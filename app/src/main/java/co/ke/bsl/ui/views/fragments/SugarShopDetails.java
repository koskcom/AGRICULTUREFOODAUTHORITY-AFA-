package co.ke.bsl.ui.views.fragments;


import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.Objects;

import co.ke.bsl.data.view.SugarRetailPricesSurveyBus;
import co.ke.bsl.data.view.SugarWholesalePricesSurveyBus;
import co.ke.bsl.pojo.Shop;
import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.pojo.Survey;
import co.ke.bsl.task.HttpGetCountyListTask;
import co.ke.bsl.task.HttpGetSurveyListTask;
import co.ke.bsl.task.HttpPostTask;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.ErrorHandler;
import co.ke.bsl.util.GPSTracker;
import co.ke.bsl.util.StringUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class SugarShopDetails extends Fragment implements BlockingStep, HttpGetSurveyListTask.HttpJsonGetSurveyListTaskCaller<Survey> {
    @BindView(R.id.etshop)
    CustomEditText etshop;

    Shop shop;

    private String shop_name;
    //    public Context ctx = SugarShopDetails.this;
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
    private String surveyType;
    private GPSTracker mGPS;

    AFADatabaseAdapter db;

    public SugarShopDetails() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sugar_shop, container, false);

        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        asyncSupport = new AsyncActivitySupport(getActivity());

        db = new AFADatabaseAdapter(getActivity()).open();


        return view;
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        shop_name = Objects.requireNonNull(etshop.getText()).toString().trim();
        if (TextUtils.isEmpty(shop_name)) {
            etshop.setError("Shop Name Required");
            return;
        }

        SugarRetailPricesSurveyBus sugarRetailPricesSurveyBus = SugarRetailPricesSurveyBus.getInstance();
        SugarWholesalePricesSurveyBus sugarWholesalePricesSurveyBus = SugarWholesalePricesSurveyBus.getInstance();

        sugarRetailPricesSurveyBus.setShop(shop_name);

        sugarWholesalePricesSurveyBus.setShop(shop_name);

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
        final String msgText = getAsyncTaskFailedMessage(taskClass, throwable);

        Runnable callback = new Runnable() {
            @Override
            public void run() {
                ErrorHandler.logAndAlert(getContext(),
                        SugarRetailPricesSurveyFragment.class, msgText, throwable);
                // TODO
                // PizzasListActivity.this.finish();
            }
        };

        Message message = Message.obtain(this.asyncTaskHandler, callback);
        message.sendToTarget();
    }

    protected String getAsyncTaskFailedMessage(Class<?> taskClass,
                                               Throwable throwable) {
        int msgResID = R.string.error_unspecied;
        if (taskClass == HttpGetCountyListTask.class) {
            msgResID = R.string.pizzasList_error_postingOrderFailed;
        }
        if (taskClass == HttpPostTask.class) {
            msgResID = R.string.pizzasList_error_postingOrderFailed;
        } else {
            ErrorHandler.logAndThrow(getClass(), new IllegalArgumentException(
                    "Unexpected class: " + taskClass.toString()));
        }

        return StringUtils.limitStringLength(
                getString(msgResID, throwable.getMessage()), 200, " ...");
    }

    @Override
    public void onHttpGetTaskSucceeded(int requestCode, ArrayList<Survey> serverResponse) {

    }
}