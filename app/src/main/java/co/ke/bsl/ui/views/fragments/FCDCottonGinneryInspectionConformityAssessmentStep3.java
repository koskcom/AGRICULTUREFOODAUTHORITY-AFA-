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
import android.widget.CheckBox;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.FCDCottonGinneryInspectionBus;
import co.ke.bsl.task.async.AsyncActivitySupport;
import co.ke.bsl.util.CustomEditText;
import co.ke.bsl.util.GPSTracker;

/**
 * A simple {@link Fragment} subclass.
 */
public class FCDCottonGinneryInspectionConformityAssessmentStep3 extends Fragment implements BlockingStep {


    @BindView(R.id.etHowManySeedStores)
    CustomEditText etHowManySeedStores;
    @BindView(R.id.etSurroundingsOfBuyingSanitaryConditionRemarks)
    CustomEditText etSurroundingsOfBuyingSanitaryConditionRemarks;
    @BindView(R.id.isBulkStorage)
    CheckBox isBulkStorage;
    @BindView(R.id.isBags)
    CheckBox isBags;
    @BindView(R.id.etTypeofBags)
    CustomEditText etTypeofBags;
    @BindView(R.id.etTotalseedCottonPurchaseinFielddBR)
    CustomEditText etTotalseedCottonPurchaseinFielddBR;
    @BindView(R.id.etTotalSeedPurchasedFieldARkg)
    CustomEditText etTotalSeedPurchasedFieldARkg;
    @BindView(R.id.etSeedCottonBroughtToGinnerryBR)
    CustomEditText etSeedCottonBroughtToGinnerryBR;
    @BindView(R.id.etSeedCottonBroughtToGinnerryAR)
    CustomEditText etSeedCottonBroughtToGinnerryAR;
    @BindView(R.id.etTotalCottonGinnedToDateBR)
    CustomEditText etTotalCottonGinnedToDateBR;
    @BindView(R.id.etTotalCottonGinnedToDateAR)
    CustomEditText etTotalCottonGinnedToDateAR;
    @BindView(R.id.etTotalCottonRemainingInStoreBR)
    CustomEditText etTotalCottonRemainingInStoreBR;
    @BindView(R.id.etTotalCottonRemainingInStoreAR)
    CustomEditText etTotalCottonRemainingInStoreAR;
    @BindView(R.id.etRemainingStoreSpace)
    CustomEditText etRemainingStoreSpace;

    private String howManySeedStores, surroundingsOfBuyingSanitaryConditionRemarks, bulkStorage, bags, typeofBags, totalseedCottonPurchaseinFielddBR;
    private String totalSeedPurchasedFieldARkg, seedCottonBroughtToGinnerryBR, seedCottonBroughtToGinnerryAR, totalCottonGinnedToDateBR, totalCottonGinnedToDateAR;
    private String totalCottonRemainingInStoreBR, totalCottonRemainingInStoreAR, remainingStoreSpace;

    AFADatabaseAdapter db;
    AFA app;
    private GPSTracker mGPS;
    private AsyncActivitySupport asyncSupport;
    protected Handler asyncTaskHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fcdcotton_ginnery_inspection_conformity_assessment_step3, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        isBulkStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBulkStorage.isChecked()){
                    bulkStorage = "Y";
                } else {
                    bulkStorage = "N";
                }
            }
        });

        isBags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBags.isChecked()){
                    bags = "Y";
                } else {
                    bags = "N";
                }
            }
        });

        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        howManySeedStores = Objects.requireNonNull(etHowManySeedStores.getText()).toString().trim();
        surroundingsOfBuyingSanitaryConditionRemarks = Objects.requireNonNull(etSurroundingsOfBuyingSanitaryConditionRemarks.getText()).toString().trim();
        typeofBags = Objects.requireNonNull(etTypeofBags.getText()).toString().trim();
        totalseedCottonPurchaseinFielddBR = Objects.requireNonNull(etTotalseedCottonPurchaseinFielddBR.getText()).toString().trim();
        totalSeedPurchasedFieldARkg = Objects.requireNonNull(etTotalSeedPurchasedFieldARkg.getText()).toString().trim();
        seedCottonBroughtToGinnerryBR = Objects.requireNonNull(etSeedCottonBroughtToGinnerryBR.getText()).toString().trim();
        seedCottonBroughtToGinnerryAR = Objects.requireNonNull(etSeedCottonBroughtToGinnerryAR.getText()).toString().trim();
        totalCottonGinnedToDateBR = Objects.requireNonNull(etTotalCottonGinnedToDateBR.getText()).toString().trim();
        totalCottonGinnedToDateAR = Objects.requireNonNull(etTotalCottonGinnedToDateAR.getText()).toString().trim();
        totalCottonRemainingInStoreBR = Objects.requireNonNull(etTotalCottonRemainingInStoreBR.getText()).toString().trim();
        totalCottonRemainingInStoreAR = Objects.requireNonNull(etTotalCottonRemainingInStoreAR.getText()).toString().trim();
        remainingStoreSpace = Objects.requireNonNull(etRemainingStoreSpace.getText()).toString().trim();


        if (TextUtils.isEmpty(howManySeedStores)) {
            etHowManySeedStores.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(surroundingsOfBuyingSanitaryConditionRemarks)) {
            etSurroundingsOfBuyingSanitaryConditionRemarks.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(typeofBags)) {
            etTypeofBags.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(totalseedCottonPurchaseinFielddBR)) {
            etTotalseedCottonPurchaseinFielddBR.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(totalSeedPurchasedFieldARkg)) {
            etTotalSeedPurchasedFieldARkg.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(seedCottonBroughtToGinnerryBR)) {
            etSeedCottonBroughtToGinnerryBR.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(seedCottonBroughtToGinnerryAR)) {
            etSeedCottonBroughtToGinnerryAR.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(totalCottonGinnedToDateBR)) {
            etTotalCottonGinnedToDateBR.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(totalCottonGinnedToDateAR)) {
            etTotalCottonGinnedToDateAR.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(totalCottonRemainingInStoreBR)) {
            etTotalCottonRemainingInStoreBR.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(totalCottonRemainingInStoreAR)) {
            etTotalCottonRemainingInStoreAR.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(remainingStoreSpace)) {
            etRemainingStoreSpace.setError("Field Required");
            return;
        }

        FCDCottonGinneryInspectionBus fCDCottonGinneryInspectionBus = FCDCottonGinneryInspectionBus.getInstance();

        fCDCottonGinneryInspectionBus.setHowManySeedStores(howManySeedStores);
        fCDCottonGinneryInspectionBus.setSurroundingsOfBuyingSanitaryConditionRemarks(surroundingsOfBuyingSanitaryConditionRemarks);
        fCDCottonGinneryInspectionBus.setBulkStorage(bulkStorage);
        fCDCottonGinneryInspectionBus.setBags(bags);
        fCDCottonGinneryInspectionBus.setTypeofBags(typeofBags);
        fCDCottonGinneryInspectionBus.setTotalseedCottonPurchaseinFielddBR(totalseedCottonPurchaseinFielddBR);
        fCDCottonGinneryInspectionBus.setTotalSeedPurchasedFieldARkg(totalSeedPurchasedFieldARkg);
        fCDCottonGinneryInspectionBus.setSeedCottonBroughtToGinnerryBR(seedCottonBroughtToGinnerryBR);
        fCDCottonGinneryInspectionBus.setSeedCottonBroughtToGinnerryAR(seedCottonBroughtToGinnerryAR);
        fCDCottonGinneryInspectionBus.setTotalCottonGinnedToDateBR(totalCottonGinnedToDateBR);
        fCDCottonGinneryInspectionBus.setTotalCottonGinnedToDateAR(totalCottonGinnedToDateAR);
        fCDCottonGinneryInspectionBus.setTotalCottonRemainingInStoreBR(totalCottonRemainingInStoreBR);
        fCDCottonGinneryInspectionBus.setTotalCottonRemainingInStoreAR(totalCottonRemainingInStoreAR);
        fCDCottonGinneryInspectionBus.setRemainingStoreSpace(remainingStoreSpace);
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
