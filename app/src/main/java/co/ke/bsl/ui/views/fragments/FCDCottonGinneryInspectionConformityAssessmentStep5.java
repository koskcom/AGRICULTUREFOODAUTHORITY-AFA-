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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.FCDCottonGinneryInspection;
import co.ke.bsl.data.view.FCDCottonGinneryInspectionBus;
import co.ke.bsl.data.view.ReccomendationsView;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.ui.common.DashboardActivity;
import co.ke.bsl.ui.viewmodels.CottonGinneryViewModel;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDCottonGinneryInspectionConformityAssessmentStep5 extends Fragment implements BlockingStep {


    @BindView(R.id.etSeedsProducedBRkg)
    CustomEditText etSeedsProducedBRkg;
    @BindView(R.id.etSeedsProduceArKg)
    CustomEditText etSeedsProduceArKg;
    @BindView(R.id.etPlantingSeedAvailableKg)
    CustomEditText etPlantingSeedAvailableKg;
    @BindView(R.id.etLastYearCarryOver)
    CustomEditText etLastYearCarryOver;
    @BindView(R.id.etSeedsSoldForPlanting)
    CustomEditText etSeedsSoldForPlanting;
    @BindView(R.id.etSeedsSoldToMillersKg)
    CustomEditText etSeedsSoldToMillersKg;
    @BindView(R.id.etSeedRemaining)
    CustomEditText etSeedRemaining;
    @BindView(R.id.etBuyingCenterStore)
    CustomEditText etBuyingCenterStore;
    @BindView(R.id.etBoughtKg)
    CustomEditText etBoughtKg;
    @BindView(R.id.etReceivedAtGinner)
    CustomEditText etReceivedAtGinner;
    @BindView(R.id.etRemainingInTheField)
    CustomEditText etRemainingInTheField;
    @BindView(R.id.ssReccomendation)
    SearchableSpinner ssReccomendation;
    @BindView(R.id.etReasonForThegiveReccomm)
    CustomEditText etReasonForThegiveReccomm;

    private String seedsProducedBRkg, seedsProduceArKg, plantingSeedAvailableKg, lastYearCarryOver, seedsSoldForPlanting;
    private String seedsSoldToMillersKg, seedRemaining, buyingCenterStore, boughtKg, receivedAtGinner, remainingInTheField;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    private CottonGinneryViewModel cottonGinneryViewModel;

    private String recommendation, recommendationRemarks;
  private ArrayList<ReccomendationsView> reccomendationsViewList = new ArrayList<>();
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdcotton_ginnery_inspection_conformity_assessment_step5, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        cottonGinneryViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(CottonGinneryViewModel.class);

        setReccomendationsView(getReccomendationsView());

        ssReccomendation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ReccomendationsView rec = (ReccomendationsView) ssReccomendation.getSelectedItem();
                recommendation = rec.getServerID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {


    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        seedsProducedBRkg = Objects.requireNonNull(etSeedsProducedBRkg.getText()).toString().trim();
        seedsProduceArKg = Objects.requireNonNull(etSeedsProduceArKg.getText()).toString().trim();
        plantingSeedAvailableKg = Objects.requireNonNull(etPlantingSeedAvailableKg.getText()).toString().trim();
        lastYearCarryOver = Objects.requireNonNull(etLastYearCarryOver.getText()).toString().trim();
        seedsSoldForPlanting = Objects.requireNonNull(etSeedsSoldForPlanting.getText()).toString().trim();
        seedsSoldToMillersKg = Objects.requireNonNull(etSeedsSoldToMillersKg.getText()).toString().trim();
        seedRemaining = Objects.requireNonNull(etSeedRemaining.getText()).toString().trim();
        buyingCenterStore = Objects.requireNonNull(etBuyingCenterStore.getText()).toString().trim();
        boughtKg = Objects.requireNonNull(etBoughtKg.getText()).toString().trim();
        receivedAtGinner = Objects.requireNonNull(etReceivedAtGinner.getText()).toString().trim();
        remainingInTheField = Objects.requireNonNull(etRemainingInTheField.getText()).toString().trim();

        recommendationRemarks = Objects.requireNonNull(etReasonForThegiveReccomm.getText()).toString().trim();

        if (TextUtils.isEmpty(seedsProducedBRkg)) {
            etSeedsProducedBRkg.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(seedsProduceArKg)) {
            etSeedsProduceArKg.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(plantingSeedAvailableKg)) {
            etPlantingSeedAvailableKg.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(lastYearCarryOver)) {
            etLastYearCarryOver.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(seedsSoldForPlanting)) {
            etSeedsSoldForPlanting.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(seedsSoldToMillersKg)) {
            etSeedsSoldToMillersKg.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(seedRemaining)) {
            etSeedRemaining.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(buyingCenterStore)) {
            etBuyingCenterStore.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(boughtKg)) {
            etBoughtKg.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(receivedAtGinner)) {
            etReceivedAtGinner.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(remainingInTheField)) {
            etRemainingInTheField.setError("Field Required");
            return;
        }

        FCDCottonGinneryInspectionBus fCDCottonGinneryInspectionBus = FCDCottonGinneryInspectionBus.getInstance();

        FCDCottonGinneryInspection fCDCottonGinneryInspection = new FCDCottonGinneryInspection(
                0,
                fCDCottonGinneryInspectionBus.getDocumentNumber(),
                fCDCottonGinneryInspectionBus.getDocumentDate(),
                fCDCottonGinneryInspectionBus.getNameOfApplicant(),
                fCDCottonGinneryInspectionBus.getGinningLicence(),
                fCDCottonGinneryInspectionBus.getLocalId(),
                fCDCottonGinneryInspectionBus.getSsSeedvariety(),
                fCDCottonGinneryInspectionBus.getSeedCottonGrade(),
                fCDCottonGinneryInspectionBus.getSeedCottonWeightOpener(),
                fCDCottonGinneryInspectionBus.getLessTareWeight(),
                fCDCottonGinneryInspectionBus.getNettWeightOfUnCleanedSeedCotton(),
                fCDCottonGinneryInspectionBus.getCleanSeedCottonGrossKg(),
                fCDCottonGinneryInspectionBus.getLessTareWeightBeforeFeedingCleaned(),
                fCDCottonGinneryInspectionBus.getNettWeightUncleanedSeedKg(),
                fCDCottonGinneryInspectionBus.getOpenerWasteOrDirectBefore(),
                fCDCottonGinneryInspectionBus.getIsAppropirateprotective(),
                fCDCottonGinneryInspectionBus.getIsFireFightingprecautionary(),
                fCDCottonGinneryInspectionBus.getIsProtectedMovingparts(),
                fCDCottonGinneryInspectionBus.getIsFireengines(),
                fCDCottonGinneryInspectionBus.getIswater(),
                fCDCottonGinneryInspectionBus.getIsCarbondioxide(),
                fCDCottonGinneryInspectionBus.getIsfoam(),
                fCDCottonGinneryInspectionBus.getIsDrypowder(),
                fCDCottonGinneryInspectionBus.getIssand(),
                fCDCottonGinneryInspectionBus.getIsHydrantsystem(),
                fCDCottonGinneryInspectionBus.getHowManySeedStores(),
                fCDCottonGinneryInspectionBus.getSurroundingsOfBuyingSanitaryConditionRemarks(),
                fCDCottonGinneryInspectionBus.getBulkStorage(),
                fCDCottonGinneryInspectionBus.getBags(),
                fCDCottonGinneryInspectionBus.getTypeofBags(),
                fCDCottonGinneryInspectionBus.getTotalseedCottonPurchaseinFielddBR(),
                fCDCottonGinneryInspectionBus.getTotalSeedPurchasedFieldARkg(),
                fCDCottonGinneryInspectionBus.getSeedCottonBroughtToGinnerryBR(),
                fCDCottonGinneryInspectionBus.getSeedCottonBroughtToGinnerryAR(),
                fCDCottonGinneryInspectionBus.getTotalCottonGinnedToDateBR(),
                fCDCottonGinneryInspectionBus.getTotalCottonGinnedToDateAR(),
                fCDCottonGinneryInspectionBus.getTotalCottonRemainingInStoreBR(),
                fCDCottonGinneryInspectionBus.getTotalCottonRemainingInStoreAR(),
                fCDCottonGinneryInspectionBus.getRemainingStoreSpace(),
                fCDCottonGinneryInspectionBus.getIsroller(),
                fCDCottonGinneryInspectionBus.getIssaw(),
                fCDCottonGinneryInspectionBus.getCategory(),
                fCDCottonGinneryInspectionBus.getTotalNoOfGinningMachines(),
                fCDCottonGinneryInspectionBus.getNoOfWorkingGinningUnits(),
                fCDCottonGinneryInspectionBus.getNoOfCurrentSalesOuput8hrs(),
                fCDCottonGinneryInspectionBus.getNoOfInstalledBalesOutput8hrs(),
                fCDCottonGinneryInspectionBus.getNoOfBalesProducedFromBegginingOfSession(),
                fCDCottonGinneryInspectionBus.getNoOfBaselsSoldLocal(),
                fCDCottonGinneryInspectionBus.getNoOfBalesSoldExport(),
                fCDCottonGinneryInspectionBus.getBalesRemainingInFactory(),
                fCDCottonGinneryInspectionBus.getAlesRemainingInFactoryBRKg(),
                seedsProducedBRkg,
                seedsProduceArKg,
                plantingSeedAvailableKg,
                lastYearCarryOver,
                seedsSoldForPlanting,
                seedsSoldToMillersKg,
                seedRemaining,
                buyingCenterStore,
                boughtKg,
                receivedAtGinner,
                remainingInTheField,
                recommendation,
                recommendationRemarks,
                false,
                ""
        );

        new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("COTTON GINNERY INSPECTION!")
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


                        long result = db.UpdateFCDCottonGinneryInspection(fCDCottonGinneryInspection);
                        System.out.println("result is" + result);
                        cottonGinneryViewModel.addRecord(fCDCottonGinneryInspection);

                        sDialog.dismissWithAnimation();
                            Intent intent = new Intent(getActivity(), DashboardActivity.class);
                            startActivity(intent);
                        }
                    })
                    .show();

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
            } else result = true;
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

    private void setReccomendationsView(List<ReccomendationsView> getReccomendationsView) {

        for (ReccomendationsView regionWrapper : getReccomendationsView) {
            reccomendationsViewList.add(regionWrapper);
        }
        ArrayAdapter<ReccomendationsView> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, reccomendationsViewList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssReccomendation.setAdapter(regionAdapter);


    }

    private List<ReccomendationsView> getReccomendationsView() {
        List<ReccomendationsView> listViewItems = new ArrayList<>();
        listViewItems.add(new ReccomendationsView("-select-", ""));
        listViewItems.add(new ReccomendationsView("I Recommend", "10000245"));
        listViewItems.add(new ReccomendationsView("I Do Not Recommend", "10000246"));

        return listViewItems;
    }

}
