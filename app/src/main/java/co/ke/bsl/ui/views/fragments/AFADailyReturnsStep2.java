package co.ke.bsl.ui.views.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;

import butterknife.BindView;
import co.ke.bsl.data.view.ReturnsView;
import co.ke.bsl.util.CustomEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFADailyReturnsStep2 extends Fragment implements BlockingStep
{
    @BindView(R.id.ssreturns)
    SearchableSpinner ssreturns;

    @BindView(R.id.etdate_of_return)
    CustomEditText etdate_of_return;

    @BindView(R.id.etZone)
    CustomEditText etZone;
    @BindView(R.id.chZone)
    CheckBox chZone;
    @BindView(R.id.etzoneremarks)
    CustomEditText etzoneremarks;

    @BindView(R.id.etsugar_production_tons)
    CustomEditText etsugar_production_tons;
    @BindView(R.id.chsugar_production_tons)
    CheckBox chsugar_production_tons;
    @BindView(R.id.etremarks_sugar_production_tons)
    CustomEditText etremarks_sugar_production_tons;

    @BindView(R.id.etclosing_stock)
    CustomEditText etclosing_stock;
    @BindView(R.id.chclosing_stock)
    CheckBox chclosing_stock;
    @BindView(R.id.etremarks_closing_stock)
    CustomEditText etremarks_closing_stock;


    private ArrayList<String> returnslist = new ArrayList<>();

    private String select_returns, date_of_returns, zone, chzone, zoneremarks,sugar_production_tons ;
    private  String chksugar_production_tons, sugar_prod_remarks, closing_stock, chkclosing_stock, closing_stock_remarks;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afainspect_returns, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        setListreturns(getDummydummyreturns());

        ssreturns.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id)
            {
                select_returns = ssreturns.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) { }
        });
        return view;
    }

    private void setListreturns(List<ReturnsView> dummyreturns)
    {
        returnslist.add("- Required -");
        for (ReturnsView regionWrapper : dummyreturns)
        {
            returnslist.add(regionWrapper.getName());
        }

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                R.layout.spinner_item_rg, returnslist);

        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssreturns.setAdapter(regionAdapter);
    }

    private List<ReturnsView> getDummydummyreturns()
    {
        List<ReturnsView> listViewItems = new ArrayList<>();
        listViewItems.add(new ReturnsView("A"));
        listViewItems.add(new ReturnsView("B"));
        listViewItems.add(new ReturnsView("C"));
        listViewItems.add(new ReturnsView("D"));

        return listViewItems;
    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {
//        String name = Objects.requireNonNull(select_return_text.getText()).toString().trim();
        if ("- Required -".equals(select_returns))
        {
            TextView errorText = (TextView) ssreturns.getSelectedView();
            if (errorText != null)
            {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            return;
        }

        date_of_returns = Objects.requireNonNull(etdate_of_return.getText()).toString().trim();
        zone = Objects.requireNonNull(etZone.getText()).toString().trim();
        sugar_production_tons = Objects.requireNonNull(etsugar_production_tons.getText()).toString().trim();
        closing_stock = Objects.requireNonNull(etclosing_stock.getText()).toString().trim();
        zoneremarks = Objects.requireNonNull(etzoneremarks.getText()).toString().trim();
        sugar_prod_remarks = Objects.requireNonNull(etremarks_sugar_production_tons.getText()).toString().trim();
        closing_stock_remarks = Objects.requireNonNull(etremarks_closing_stock.getText()).toString().trim();

        if (TextUtils.isEmpty(date_of_returns))
        {
            etdate_of_return.setError("Date Required");
            return;
        }
        if (TextUtils.isEmpty(zone))
        {
            etZone.setError("Zone Required");
            return;
        }
        if (TextUtils.isEmpty(sugar_production_tons))
        {
            etsugar_production_tons.setError("Tons Required");
            return;
        }
        if (TextUtils.isEmpty(closing_stock))
        {
            etclosing_stock.setError("Closing Stock Required");
            return;
        }
        if (TextUtils.isEmpty(zoneremarks))
        {
            etzoneremarks.setError("Remarks Required");
            return;
        }
        if (TextUtils.isEmpty(sugar_prod_remarks))
         {
        etremarks_sugar_production_tons.setError("Remarks Required");
        return;
          }
        if (TextUtils.isEmpty(closing_stock_remarks))
        {
            etremarks_closing_stock.setError("Remarks Required");
            return;
        }
     /*   DailyReturnsInspectionBus dailyReturnsInspectionBus = DailyReturnsInspectionBus.getInstance();

        dailyReturnsInspectionBus.setSelect_returns(select_returns);
        dailyReturnsInspectionBus.setDate_of_returns(date_of_returns);
        dailyReturnsInspectionBus.setZone(zone);
        dailyReturnsInspectionBus.setZoneremarks(zoneremarks);
        dailyReturnsInspectionBus.setSugar_production_tons(sugar_production_tons);
        dailyReturnsInspectionBus.setSugar_prod_remarks(sugar_prod_remarks);
        dailyReturnsInspectionBus.setClosing_stock(closing_stock);
        dailyReturnsInspectionBus.setClosing_stock_remarks(closing_stock_remarks);
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
