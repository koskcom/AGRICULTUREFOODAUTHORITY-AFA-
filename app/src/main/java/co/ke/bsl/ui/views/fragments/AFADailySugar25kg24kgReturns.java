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
public class AFADailySugar25kg24kgReturns extends Fragment implements BlockingStep
{

    @BindView(R.id.etbale_25KG)
    CustomEditText etbale_25KG;
    @BindView(R.id.etremarks_bale_25KG)
    CustomEditText etremarks_bale_25KG;
    @BindView(R.id.etbale_24KG)
    CustomEditText etbale_24KG;
    @BindView(R.id.etremarks_bale_24KG)
    CustomEditText etremarks_bale_24KG;
    private String bale_25kg, remarks_bale_25kg,bale_24kg,remarks_bale24kg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afa_sugar_25kg_24kg_returns, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();


        return view;
    }

    @Override
    public void onNextClicked (StepperLayout.OnNextClickedCallback callback)
    {
        bale_25kg = Objects.requireNonNull(etbale_25KG.getText()).toString().trim();
        bale_24kg= Objects.requireNonNull(etbale_24KG.getText()).toString().trim();
        remarks_bale24kg = Objects.requireNonNull(etremarks_bale_24KG.getText()).toString().trim();
        remarks_bale_25kg = Objects.requireNonNull(etremarks_bale_25KG.getText()).toString().trim();

        if (TextUtils.isEmpty(bale_25kg)) {
            etbale_25KG.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(bale_24kg)) {
            etbale_24KG.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(remarks_bale24kg)) {
            etremarks_bale_24KG.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(remarks_bale_25kg)) {
            etremarks_bale_25KG.setError("Closing Stock Required");
            return;
        }
/*
        DailyReturnsInspectionBus dailyReturnsInspectionBus = DailyReturnsInspectionBus.getInstance();

        dailyReturnsInspectionBus.setBale_25kg(bale_25kg);
        dailyReturnsInspectionBus.setRemarks_bale_25kg(remarks_bale_25kg);
        dailyReturnsInspectionBus.setBale_24kg(bale_24kg);
        dailyReturnsInspectionBus.setRemarks_bale24kg(remarks_bale24kg);
*/
        callback.goToNextStep();
    }


    @Override
    public void onCompleteClicked (StepperLayout.OnCompleteClickedCallback callback){

    }

    @Override
    public void onBackClicked (StepperLayout.OnBackClickedCallback callback){

    }

    @Nullable
    @Override
    public VerificationError verifyStep () {
        return null;
    }

    @Override
    public void onSelected () {

    }

    @Override
    public void onError (@NonNull VerificationError error){

    }

}
