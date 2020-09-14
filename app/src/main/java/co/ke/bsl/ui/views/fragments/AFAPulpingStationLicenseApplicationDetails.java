package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.R;
import co.ke.bsl.data.view.PulpingStationLicenseApplicationBus;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFAPulpingStationLicenseApplicationDetails extends Fragment implements BlockingStep {
    @BindView(R.id.etTotalLandArea)
    CustomEditText etTotalLandArea;
    @BindView(R.id.etTotalNumberOfTrees)
    CustomEditText etTotalNumberOfTrees;
    @BindView(R.id.etMatureCoffee)
    CustomEditText etMatureCoffee;
    @BindView(R.id.etFirstYear)
    CustomEditText etFirstYear;
    @BindView(R.id.etSecondYear)
    CustomEditText etSecondYear;
    @BindView(R.id.etThirdYear)
    CustomEditText etThirdYear;
    @BindView(R.id.etcrop_husbandry)
    CustomEditText etcrop_husbandry;

    @BindView(R.id.tvFirstYear)
    TextView tvFirstYear;
    @BindView(R.id.tvSecondYear)
    TextView tvSecondYear;
    @BindView(R.id.tvThirdYear)
    TextView tvThirdYear;

    public String first_year, second_year, third_year;

    public AFAPulpingStationLicenseApplicationDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afapulping_station_license_application_details, container, false);
        ButterKnife.bind(this, view);

        int year = Calendar.getInstance().get(Calendar.YEAR);

        first_year = String.valueOf(year - 1);
        tvFirstYear.setText("Production(Kg) in Year: " + first_year);
        second_year = String.valueOf(year - 2);
        tvSecondYear.setText("Production(Kg) in Year: " + second_year);
        third_year = String.valueOf(year - 3);
        tvThirdYear.setText("Production(Kg) in Year: " + third_year);

        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String total_land_area = Objects.requireNonNull(etTotalLandArea.getText()).toString().trim();
        String total_number_of_trees = Objects.requireNonNull(etTotalNumberOfTrees.getText()).toString().trim();
        String mature_coffee = Objects.requireNonNull(etMatureCoffee.getText()).toString().trim();
        String first_year_production = Objects.requireNonNull(etFirstYear.getText()).toString().trim();
        String second_year_production = Objects.requireNonNull(etSecondYear.getText()).toString().trim();
        String third_year_production = Objects.requireNonNull(etThirdYear.getText()).toString().trim();
        String crop_husbandry = Objects.requireNonNull(etcrop_husbandry.getText()).toString().trim();

        boolean valid = validateEditText(etTotalLandArea, total_land_area) &
                validateEditText(etTotalNumberOfTrees, total_number_of_trees) &
                validateEditText(etMatureCoffee, mature_coffee) &
                validateEditText(etFirstYear, first_year_production) &
                validateEditText(etSecondYear, second_year_production) &
                validateEditText(etThirdYear, third_year_production) &
                validateEditText(etcrop_husbandry, crop_husbandry);

        PulpingStationLicenseApplicationBus pulpingStationLicenseApplicationBus = PulpingStationLicenseApplicationBus.getInstance();
        pulpingStationLicenseApplicationBus.setTotalLandArea(total_land_area);
        pulpingStationLicenseApplicationBus.setTotalNumberOfTrees(total_number_of_trees);
        pulpingStationLicenseApplicationBus.setAreaUnderMatureCoffee(mature_coffee);
        pulpingStationLicenseApplicationBus.setFirstYear(first_year);
        pulpingStationLicenseApplicationBus.setFirstYearProduction(first_year_production);
        pulpingStationLicenseApplicationBus.setSecondYear(second_year);
        pulpingStationLicenseApplicationBus.setSecondYearProduction(second_year_production);
        pulpingStationLicenseApplicationBus.setThirdYear(third_year);
        pulpingStationLicenseApplicationBus.setThirdYearProduction(third_year_production);
        pulpingStationLicenseApplicationBus.setCropHusbandryPractices(crop_husbandry);

        if(valid) {
            callback.goToNextStep();
        }


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
}
