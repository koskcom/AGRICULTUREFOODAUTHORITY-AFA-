package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.util.CustomEditText;



/**
 * A simple {@link Fragment} subclass.
 */
public class AFADailySugar15kg12kg10Kgreturns extends Fragment implements BlockingStep
{
    @BindView(R.id.etbale_15KG)
    CustomEditText etbale_15KG;
    @BindView(R.id.etremarks_bale_15KG)
    CustomEditText etremarks_bale_15KG;
    @BindView(R.id.etbale_12KG)
    CustomEditText etbale_12KG;
    @BindView(R.id.etremarks_bale_12KG)
    CustomEditText etremarks_bale_12KG;
    @BindView(R.id.etbale_10KG)
    CustomEditText etbale_10KG;
    @BindView(R.id.etremarks_bale_10KG)
    CustomEditText etremarks_bale_10KG;

//    private DailyReturnsInspectionViewModel dailyReturnsInspectionViewModel;

    private String bale_15kg, remarks_bale_15kg,bale_12kg,remarks_bale_12kg, bale_10kg, remarks_bale_10kg;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afa_sugar_15kg_12kg_returns, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();


        return view;
    }

    @Override
    public void onNextClicked (StepperLayout.OnNextClickedCallback callback)
    {

    }


    @Override
    public void onCompleteClicked (StepperLayout.OnCompleteClickedCallback callback)
    {
        bale_15kg = Objects.requireNonNull(etbale_15KG.getText()).toString().trim();
        bale_12kg= Objects.requireNonNull(etbale_12KG.getText()).toString().trim();
        bale_10kg= Objects.requireNonNull(etbale_10KG.getText()).toString().trim();
        remarks_bale_15kg = Objects.requireNonNull(etremarks_bale_15KG.getText()).toString().trim();
        remarks_bale_12kg = Objects.requireNonNull(etremarks_bale_12KG.getText()).toString().trim();
        remarks_bale_10kg = Objects.requireNonNull(etremarks_bale_10KG.getText()).toString().trim();

        if (TextUtils.isEmpty(bale_15kg)) {
            etbale_15KG.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(bale_12kg)) {
            etbale_12KG.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(bale_10kg)) {
            etbale_10KG.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(remarks_bale_15kg)) {
            etremarks_bale_15KG.setError("Closing Stock Required");
            return;
        }
        if (TextUtils.isEmpty(remarks_bale_12kg)) {
            etremarks_bale_12KG.setError("Closing Stock Required");
            return;
        }
        if (TextUtils.isEmpty(remarks_bale_10kg)) {
            etremarks_bale_10KG.setError("Closing Stock Required");
            return;
        }
/*
        DailyReturnsInspectionBus dailyReturnsInspectionBus = DailyReturnsInspectionBus.getInstance();
        DailyReturnsInspectinModel dailyReturnsInspectinModel= new DailyReturnsInspectinModel(
                0,
                dailyReturnsInspectionBus.getDocument_no(),
                dailyReturnsInspectionBus.getDocument_date(),
                dailyReturnsInspectionBus.getSubLocation(),
                dailyReturnsInspectionBus.getInspection_date(),
                dailyReturnsInspectionBus.getSelect_returns(),
                dailyReturnsInspectionBus.getDate_of_returns(),
                dailyReturnsInspectionBus.getZone(),
                dailyReturnsInspectionBus.getZoneremarks(),
                dailyReturnsInspectionBus.getSugar_production_tons(),
                dailyReturnsInspectionBus.getSugar_prod_remarks(),
                dailyReturnsInspectionBus.getClosing_stock(),
                dailyReturnsInspectionBus.getClosing_stock_remarks(),
                dailyReturnsInspectionBus.getBag_50kg(),
                dailyReturnsInspectionBus.getRemarks_50kg(),
                dailyReturnsInspectionBus.getBag_25kg(),
                dailyReturnsInspectionBus.getRemarks_bag25kg(),
                dailyReturnsInspectionBus.getBale_25kg(),
                dailyReturnsInspectionBus.getRemarks_bale_25kg(),
                dailyReturnsInspectionBus.getBale_24kg(),
                dailyReturnsInspectionBus.getRemarks_bale24kg(),
                dailyReturnsInspectionBus.getBale_20kg(),
                dailyReturnsInspectionBus.getRemarks_bale20kg(),
                dailyReturnsInspectionBus.getBale_18kg(),
                dailyReturnsInspectionBus.getRemarks_bale18kg(),
                dailyReturnsInspectionBus.getBale_15kg(),
                dailyReturnsInspectionBus.getRemarks_bale_15kg(),
                dailyReturnsInspectionBus.getBale_12kg(),
                dailyReturnsInspectionBus.getRemarks_bale_12kg(),
                dailyReturnsInspectionBus.getBale_10kg(),
                dailyReturnsInspectionBus.getRemarks_bale_10kg(),

                false,
                ""
        );*/

       // dailyReturnsInspectionViewModel.addRecords(dailyReturnsInspectinModel);

      Intent intent = new Intent(getActivity(), DashboardActivity.class);
        Objects.requireNonNull(getActivity()).finish();
        startActivity(intent);

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
