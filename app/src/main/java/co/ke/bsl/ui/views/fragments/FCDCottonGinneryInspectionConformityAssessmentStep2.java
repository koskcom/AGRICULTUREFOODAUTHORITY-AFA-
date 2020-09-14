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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.FCDCottonGinneryInspectionBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.data.view.SeedVarietyView;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDCottonGinneryInspectionConformityAssessmentStep2 extends Fragment implements BlockingStep {


    @BindView(R.id.ssSeedVariety)
    SearchableSpinner ssSeedVariety;
    @BindView(R.id.etSeedCottonGrade)
    CustomEditText etSeedCottonGrade;
    @BindView(R.id.etSeedCottonWeightOpener)
    CustomEditText etSeedCottonWeightOpener;
    @BindView(R.id.etLessTareWeight)
    CustomEditText etLessTareWeight;
    @BindView(R.id.etNettWeightOfUnCleanedSeedCotton)
    CustomEditText etNettWeightOfUnCleanedSeedCotton;


    @BindView(R.id.etCleanSeedCottonGrossKg)
    CustomEditText etCleanSeedCottonGrossKg;
    @BindView(R.id.etLessTareWeightBeforeFeedingCleaned)
    CustomEditText etLessTareWeightBeforeFeedingCleaned;
    @BindView(R.id.etNettWeightUncleanedSeedKg)
    CustomEditText etNettWeightUncleanedSeedKg;
    @BindView(R.id.etOpenerWasteOrDirectBefore)
    CustomEditText etOpenerWasteOrDirectBefore;

    @BindView(R.id.isAppropirateProtective)
    CheckBox isAppropirateProtective;
    @BindView(R.id.isFireFightingPrecautionary)
    CheckBox isFireFightingPrecautionary;
    @BindView(R.id.isProtectedMovingParts)
    CheckBox isProtectedMovingParts;
    @BindView(R.id.isFireEngines)
    CheckBox isFireEngines;
    @BindView(R.id.isWater)
    CheckBox isWater;
    @BindView(R.id.isCarbonDioxide)
    CheckBox isCarbonDioxide;
    @BindView(R.id.isFoam)
    CheckBox isFoam;
    @BindView(R.id.isDryPowder)
    CheckBox isDryPowder;
    @BindView(R.id.isSand)
    CheckBox isSand;
    @BindView(R.id.isHydrantSystem)
    CheckBox isHydrantSystem;

    private String ssSeedvariety, seedCottonGrade, seedCottonWeightOpener, lessTareWeight, nettWeightOfUnCleanedSeedCotton;
    private String cleanSeedCottonGrossKg, lessTareWeightBeforeFeedingCleaned, nettWeightUncleanedSeedKg, openerWasteOrDirectBefore;
    private String isAppropirateprotective, isFireFightingprecautionary, isProtectedMovingparts, fireEngines, water, carbonDioxide, foam, dryPowder, sand, hydrantsystem;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;


    private ArrayList<SeedVarietyView> SeedVarietyViewList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdfcdcotton_ginnery_inspection_conformity_assessment_step2, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        setSeedVarietyView(getSeedVarietyView());

        ssSeedVariety.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SeedVarietyView svv = (SeedVarietyView) ssSeedVariety.getSelectedItem();
                ssSeedvariety = svv.getServerID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        isAppropirateProtective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAppropirateProtective.isChecked()){

                    isAppropirateprotective = "Y";
                } else {
                    isAppropirateprotective = "N";
                }


            }
        });

        isFireFightingPrecautionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFireFightingPrecautionary.isChecked()){
                    isFireFightingprecautionary = "Y";
                } else {
                    isFireFightingprecautionary = "N";
                }


            }
        });

        isProtectedMovingParts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isProtectedMovingParts.isChecked()){
                    isProtectedMovingparts = "Y";
                } else {
                    isProtectedMovingparts = "N";
                }


            }
        });


        isFireEngines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFireEngines.isChecked()){
                    fireEngines = "Y";
                } else {
                    fireEngines = "N";
                }


            }
        });

        isWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isWater.isChecked()){
                    water = "Y";
                } else {
                    water = "N";
                }


            }
        });

        isCarbonDioxide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCarbonDioxide.isChecked()){
                    carbonDioxide = "Y";
                } else {
                    carbonDioxide = "N";
                }


            }
        });

        isFoam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFoam.isChecked()){
                    foam = "Y";
                } else {
                    foam = "N";
                }


            }
        });

        isDryPowder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDryPowder.isChecked()){
                    dryPowder = "Y";
                } else {
                    dryPowder = "N";
                }


            }
        });

        isSand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isSand.isChecked()){
                    sand = "Y";
                } else {
                    sand = "N";
                }


            }
        });

        isHydrantSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isHydrantSystem.isChecked()){
                    hydrantsystem = "Y";
                } else {
                    hydrantsystem = "N";
                }


            }
        });

        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        seedCottonGrade = Objects.requireNonNull(etSeedCottonGrade.getText()).toString().trim();
        seedCottonWeightOpener = Objects.requireNonNull(etSeedCottonWeightOpener.getText()).toString().trim();
        lessTareWeight = Objects.requireNonNull(etLessTareWeight.getText()).toString().trim();
        nettWeightOfUnCleanedSeedCotton = Objects.requireNonNull(etNettWeightOfUnCleanedSeedCotton.getText()).toString().trim();
        cleanSeedCottonGrossKg = Objects.requireNonNull(etCleanSeedCottonGrossKg.getText()).toString().trim();
        lessTareWeightBeforeFeedingCleaned = Objects.requireNonNull(etLessTareWeightBeforeFeedingCleaned.getText()).toString().trim();
        nettWeightUncleanedSeedKg = Objects.requireNonNull(etNettWeightUncleanedSeedKg.getText()).toString().trim();
        openerWasteOrDirectBefore = Objects.requireNonNull(etOpenerWasteOrDirectBefore.getText()).toString().trim();

        if (TextUtils.isEmpty(seedCottonGrade)) {
            etSeedCottonGrade.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(lessTareWeight)) {
            etLessTareWeight.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(cleanSeedCottonGrossKg)) {
            etCleanSeedCottonGrossKg.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(lessTareWeightBeforeFeedingCleaned)) {
            etLessTareWeightBeforeFeedingCleaned.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(openerWasteOrDirectBefore)) {
            etOpenerWasteOrDirectBefore.setError("Field Required");
            return;
        }

        FCDCottonGinneryInspectionBus fCDCottonGinneryInspectionBus = FCDCottonGinneryInspectionBus.getInstance();

        fCDCottonGinneryInspectionBus.setSsSeedvariety(ssSeedvariety);
        fCDCottonGinneryInspectionBus.setSeedCottonGrade(seedCottonGrade);
        fCDCottonGinneryInspectionBus.setSeedCottonWeightOpener(seedCottonWeightOpener);
        fCDCottonGinneryInspectionBus.setLessTareWeight(lessTareWeight);
        fCDCottonGinneryInspectionBus.setNettWeightOfUnCleanedSeedCotton(nettWeightOfUnCleanedSeedCotton);
        fCDCottonGinneryInspectionBus.setCleanSeedCottonGrossKg(cleanSeedCottonGrossKg);
        fCDCottonGinneryInspectionBus.setLessTareWeightBeforeFeedingCleaned(lessTareWeightBeforeFeedingCleaned);
        fCDCottonGinneryInspectionBus.setNettWeightUncleanedSeedKg(nettWeightUncleanedSeedKg);
        fCDCottonGinneryInspectionBus.setOpenerWasteOrDirectBefore(openerWasteOrDirectBefore);
        fCDCottonGinneryInspectionBus.setIsAppropirateprotective(isAppropirateprotective);
        fCDCottonGinneryInspectionBus.setIsFireFightingprecautionary(isFireFightingprecautionary);
        fCDCottonGinneryInspectionBus.setIsProtectedMovingparts(isProtectedMovingparts);
        fCDCottonGinneryInspectionBus.setIsFireengines(fireEngines);
        fCDCottonGinneryInspectionBus.setIswater(water);
        fCDCottonGinneryInspectionBus.setIsCarbondioxide(carbonDioxide);
        fCDCottonGinneryInspectionBus.setIsfoam(foam);
        fCDCottonGinneryInspectionBus.setIsDrypowder(dryPowder);
        fCDCottonGinneryInspectionBus.setIssand(sand);
        fCDCottonGinneryInspectionBus.setIsHydrantsystem(hydrantsystem);

        callback.goToNextStep();

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

    private boolean validateFields(CheckBox checkBox, CustomEditText customEditText, String customEditTextString) {

        boolean result = false;

        if (!checkBox.isChecked()) {
            if (TextUtils.isEmpty(customEditTextString)) {
                customEditText.setError("Field Required ");
                result = false;
            }
            else result =true;
        } else {
            customEditText.setError(null);
            result = true;
        }

        return result;
    }

    private void setSeedVarietyView(List<SeedVarietyView> seedVarietyList) {
        SeedVarietyViewList.add(new SeedVarietyView("- Required -",""));
        for (SeedVarietyView regionWrapper : seedVarietyList) {
            SeedVarietyViewList.add(regionWrapper);
        }
        ArrayAdapter<SeedVarietyView> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, SeedVarietyViewList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssSeedVariety.setAdapter(regionAdapter);


    }

    private List<SeedVarietyView> getSeedVarietyView() {
        List<SeedVarietyView> listViewItems = new ArrayList<>();
        listViewItems.add(new SeedVarietyView("Variety 1", "10000240"));
        listViewItems.add(new SeedVarietyView("Variety 2", "10000241"));
        listViewItems.add(new SeedVarietyView("Variety 3", "10000242"));

        return listViewItems;
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
