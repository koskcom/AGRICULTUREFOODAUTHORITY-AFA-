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
public class AFADailySugar20KG18Returns extends Fragment implements BlockingStep
{

    @BindView(R.id.etbale_20KG)
    CustomEditText etbale_20KG;
    @BindView(R.id.etremarks_bale_20KG)
    CustomEditText etremarks_bale_20KG;
    @BindView(R.id.etbale_18KG)
    CustomEditText etbale_18KG;
    @BindView(R.id.etremarks_bale_18KG)
    CustomEditText etremarks_bale_18KG;
    private String bale_20kg, remarks_bale20kg,bale_18kg,remarks_bale18kg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afa__sugar_20kg_18kg_returns, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();


        return view;
    }

    @Override
    public void onNextClicked (StepperLayout.OnNextClickedCallback callback)
    {
        bale_20kg = Objects.requireNonNull(etbale_20KG.getText()).toString().trim();
        bale_18kg= Objects.requireNonNull(etbale_18KG.getText()).toString().trim();
        remarks_bale20kg = Objects.requireNonNull(etremarks_bale_20KG.getText()).toString().trim();
        remarks_bale18kg = Objects.requireNonNull(etremarks_bale_18KG.getText()).toString().trim();

        if (TextUtils.isEmpty(bale_20kg)) {
            etbale_20KG.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(bale_18kg)) {
            etbale_18KG.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(remarks_bale20kg)) {
            etremarks_bale_20KG.setError("Field Required");
            return;
        }
        if (TextUtils.isEmpty(remarks_bale18kg)) {
            etremarks_bale_18KG.setError("Closing Stock Required");
            return;
        }

       /* DailyReturnsInspectionBus dailyReturnsInspectionBus = DailyReturnsInspectionBus.getInstance();

        dailyReturnsInspectionBus.setBale_20kg(bale_20kg);
        dailyReturnsInspectionBus.setRemarks_bale20kg(remarks_bale20kg);
        dailyReturnsInspectionBus.setBale_18kg(bale_18kg);
        dailyReturnsInspectionBus.setRemarks_bale18kg(remarks_bale18kg);
*/
        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked (StepperLayout.OnCompleteClickedCallback callback)
    {

    }

    @Override
    public void onBackClicked (StepperLayout.OnBackClickedCallback callback)
    {

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
