package co.ke.bsl.ui.views.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFADailySugar50kg25kgReturns extends Fragment implements BlockingStep {


    @BindView(R.id.etbag_50kg)
    CustomEditText etbag_50kg;
    @BindView(R.id.remarks_bag_50kg)
    CustomEditText remarks_bag_50kg;
    @BindView(R.id.etbag_25kg)
    CustomEditText etbag_25kg;
    @BindView(R.id.remarks_bag_25kg)
    CustomEditText remarks_bag_25kg;

    private String bag_50kg, bag_25kg, remarks_50kg, remarks_bag25kg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afa_sugar_50kg_25kg_returns, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();


        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        bag_50kg = Objects.requireNonNull(etbag_50kg.getText()).toString().trim();
        bag_25kg = Objects.requireNonNull(etbag_25kg.getText()).toString().trim();
        remarks_50kg = Objects.requireNonNull(remarks_bag_50kg.getText()).toString().trim();
        remarks_bag25kg = Objects.requireNonNull(remarks_bag_25kg.getText()).toString().trim();

        if (TextUtils.isEmpty(bag_50kg)) {
            etbag_50kg.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(bag_25kg)) {
            etbag_25kg.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(remarks_50kg)) {
            remarks_bag_50kg.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(remarks_bag25kg)) {
            remarks_bag_25kg.setError("Closing Stock Required");
            return;
        }
/*
        DailyReturnsInspectionBus dailyReturnsInspectionBus = DailyReturnsInspectionBus.getInstance();

        dailyReturnsInspectionBus.setBag_50kg(bag_50kg);
        dailyReturnsInspectionBus.setRemarks_50kg(remarks_50kg);
        dailyReturnsInspectionBus.setBag_25kg(bag_25kg);
        dailyReturnsInspectionBus.setRemarks_bag25kg(remarks_bag25kg);
*/
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


}


