package co.ke.bsl.ui.views.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
public class HarvestInspectionReturnsStep3 extends Fragment implements BlockingStep
{

    @BindView(R.id.etoutgrowers_pc)
    CustomEditText etoutgrowers_pc;
    @BindView(R.id.remarks_outgrowers_pc)
    CustomEditText remarks_outgrowers_pc;
    @BindView(R.id.etoutgrowers_r1)
    CustomEditText etoutgrowers_r1;
    @BindView(R.id.etremarks_outgrowers_r1)
    CustomEditText etremarks_outgrowers_r1;
    @BindView(R.id.etoutgrowers_r2)
    CustomEditText etoutgrowers_r2;
    @BindView(R.id.etremarks_outgrowers_r2)
    CustomEditText etremarks_outgrowers_r2;
    @BindView(R.id.etoutgrowers_r3)
    CustomEditText etoutgrowers_r3;
    @BindView(R.id.etremarks_outgrowers_r3)
    CustomEditText etremarks_outgrowers_r3;
    @BindView(R.id.etnucleus_estate)
    CustomEditText etnucleus_estate;
    @BindView(R.id.etremarks_nucleus_estate)
    CustomEditText etremarks_nucleus_estate;
    @BindView(R.id.etnucleus_estate_r1)
    CustomEditText etnucleus_estate_r1;
    @BindView(R.id.etremarks_nucleus_estate_r1)
    CustomEditText etremarks_nucleus_estate_r1;
    @BindView(R.id.etnucleus_estate_r2)
    CustomEditText etnucleus_estate_r2;
    @BindView(R.id.etremarks_nucleus_estate_r2)
    CustomEditText etremarks_nucleus_estate_r2;
    @BindView(R.id.etnucleus_estate_r3)
    CustomEditText etnucleus_estate_r3;
    @BindView(R.id.etremarks_nucleus_estate_r3)
    CustomEditText etremarks_nucleus_estate_r3;

    private String outgrowers_pc, remarks_outgro_pc, outgrowers_r1, remarks_outgrowers_r1,outgrowers_r2, remarks_outgrowers_r2,outgrowers_r3, remarks_outgrowers_r3;
    private String nucleous_estate, remarks_nucleaus_estate, nucleaus_estate_r1, remarks_nucleus_r1, nucleaus_estate_r2, remarks_nucleus_r2, nucleaus_estate_r3, remarks_nucleus_r3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afasugar_harvest_inspection_returns, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback)
    {
        outgrowers_pc = Objects.requireNonNull(etoutgrowers_pc.getText()).toString().trim();
        remarks_outgro_pc = Objects.requireNonNull(remarks_outgrowers_pc.getText()).toString().trim();
        outgrowers_r1 = Objects.requireNonNull(etoutgrowers_r1.getText()).toString().trim();
        remarks_outgrowers_r1 = Objects.requireNonNull(etremarks_outgrowers_r1.getText()).toString().trim();
        outgrowers_r2 = Objects.requireNonNull(etoutgrowers_r2.getText()).toString().trim();
        remarks_outgrowers_r2 = Objects.requireNonNull(etremarks_outgrowers_r2.getText()).toString().trim();
        outgrowers_r3 = Objects.requireNonNull(etoutgrowers_r3.getText()).toString().trim();
        remarks_outgrowers_r3 = Objects.requireNonNull(etremarks_outgrowers_r3.getText()).toString().trim();
        nucleous_estate = Objects.requireNonNull(etnucleus_estate.getText()).toString().trim();
        remarks_nucleaus_estate = Objects.requireNonNull(etremarks_nucleus_estate.getText()).toString().trim();
        nucleaus_estate_r1 = Objects.requireNonNull(etnucleus_estate_r1.getText()).toString().trim();
        remarks_nucleus_r1 = Objects.requireNonNull(etremarks_nucleus_estate_r1.getText()).toString().trim();
        nucleaus_estate_r2 = Objects.requireNonNull(etnucleus_estate_r2.getText()).toString().trim();
        remarks_nucleus_r2 = Objects.requireNonNull(etremarks_nucleus_estate_r2.getText()).toString().trim();
        nucleaus_estate_r3 = Objects.requireNonNull(etnucleus_estate_r3.getText()).toString().trim();
        remarks_nucleus_r3 = Objects.requireNonNull(etremarks_nucleus_estate_r3.getText()).toString().trim();
/*
        HarvestReturnsBus harvestReturnsBus = HarvestReturnsBus.getInstance();

        HarvestReturnsInspection harvestReturnsInspection= new HarvestReturnsInspection(
                0,
                harvestReturnsBus.getDocument_number(),
                harvestReturnsBus.getDocument_date(),
                harvestReturnsBus.getSubLocation(),
                harvestReturnsBus.getName(),
                harvestReturnsBus.getSelect_returns(),
                harvestReturnsBus.getDate_of_returns(),
                harvestReturnsBus.getMiller(),
                harvestReturnsBus.getRemarks_miller(),
                harvestReturnsBus.getReturns_type(),
                harvestReturnsBus.getRemarks_returns_type(),
                harvestReturnsBus.getZone(),
                harvestReturnsBus.getRemarks_zone(),
                harvestReturnsBus.getCane_varieties(),
                harvestReturnsBus.getRemarks_cane_varieties(),
                harvestReturnsBus.getCalendar_year(),
                harvestReturnsBus.getRemarks_calendar_year(),
                harvestReturnsBus.getMonth(),
                harvestReturnsBus.getRemarks_month(),
                harvestReturnsBus.getOutgrowers_pc(),
                harvestReturnsBus.getRemarks_outgro_pc(),
                harvestReturnsBus.getOutgrowers_r1(),
                harvestReturnsBus.getRemarks_outgrowers_r1(),
                harvestReturnsBus.getOutgrowers_r2(),
                harvestReturnsBus.getRemarks_outgrowers_r2(),
                harvestReturnsBus.getOutgrowers_r3(),
                harvestReturnsBus.getRemarks_outgrowers_r3(),
                harvestReturnsBus.getNucleous_estate(),
                harvestReturnsBus.getRemarks_nucleaus_estate(),
                harvestReturnsBus.getNucleaus_estate_r1(),
                harvestReturnsBus.getRemarks_nucleus_r1(),
                harvestReturnsBus.getNucleaus_estate_r2(),
                harvestReturnsBus.getRemarks_nucleus_r2(),
                harvestReturnsBus.getNucleaus_estate_r3(),
                harvestReturnsBus.getRemarks_nucleus_r3(),

                false,
                ""
        );

//        dailyReturnsInspectionViewModel.addRecords(dailyReturnsInspectinModel);
*/
      Intent intent = new Intent(getActivity(), DashboardActivity.class);
        Objects.requireNonNull(getActivity()).finish();
        startActivity(intent);

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback)
    {

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
