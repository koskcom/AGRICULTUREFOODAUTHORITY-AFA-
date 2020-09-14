package co.ke.bsl.ui.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class SugarMollasesInitialStock extends Fragment implements BlockingStep
{
    @BindView(R.id.etsugar_initial_stock_this_month)
    CustomEditText etsugar_initial_stock_this_month;
    @BindView(R.id.chsugar_initial_stock_this_month)
    CheckBox chsugar_initial_stock_this_month;
    @BindView(R.id.etsugar_initial_stock_this_month_remarks)
    CustomEditText etsugar_initial_stock_this_month_remarks;
    @BindView(R.id.etsugar_initial_stock_this_year_to_date)
    CustomEditText etsugar_initial_stock_this_year_to_date;
    @BindView(R.id.chsugar_initial_stock_this_year_to_date)
    CheckBox chsugar_initial_stock_this_year_to_date;
    @BindView(R.id.etsugar_initial_stock_this_year_to_date_remarks)
    CustomEditText etsugar_initial_stock_this_year_to_date_remarks;

    @BindView(R.id.etmollases_initial_stock_this_month)
    CustomEditText etmollases_initial_stock_this_month;
    @BindView(R.id.chmollases_initial_stock_this_month)
    CheckBox chmollases_initial_stock_this_month;
    @BindView(R.id.etmollases_initial_stock_this_month_remarks)
    CustomEditText etmollases_initial_stock_this_month_remarks;
    @BindView(R.id.etmollases_initial_initial_stock_year_to_date)
    CustomEditText etmollases_initial_initial_stock_year_to_date;
    @BindView(R.id.chmollases_initial_stock_this_year_to_date)
    CheckBox chmollases_initial_to_date;
    @BindView(R.id.etmollases_initial_stock_year_to_date_remarks)
    CustomEditText etmollases_initial_stock_year_to_date_remarks;

    private String sugar_initial_stock_this_month, chksugar_initial_stock_this_month, sugar_initial_stock_this_month_remarks, sugar_initial_stock_this_year_to_date, chksugar_initial_stock_this_year_to_date, sugar_initial_stock_this_year_to_date_remarks;

    private String mollases_initial_stock_this_month, chkmollases_initial_stock_this_month, mollases_initial_stock_this_month_remarks,mollases_initial_initial_stock_year_to_date, chkmollases_initial_initial_stock_year_to_date, mollases_initial_initial_stock_year_to_date_remarks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sugar_mollases_initial_stock, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

       /* chsugar_initial_stock_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chsugar_initial_stock_month.isChecked()) {
                    etsugar_initial_stock_remarks.setBackgroundColor(Color.parseColor("#CCCCCC"));
                    etsugar_initial_stock_remarks.setEnabled(false);
                    etsugar_initial_stock_remarks.setBackgroundColor(Color.parseColor("#CCCCCC"));
                    etsugar_initial_stock_remarks.setTextIsSelectable(false);
                    etsugar_initial_stock_remarks.setFocusable(false);
                    etsugar_initial_stock_remarks.setFocusableInTouchMode(false);
                    etsugar_initial_stock_remarks.setCursorVisible(false);
                    etsugar_initial_stock_remarks.setEnabled(false);
                }
                else {
                    if (TextUtils.isEmpty(sugar_initial_stock_month_remarks))
                    {
                        etsugar_initial_stock_remarks.setError("Field Required");
                        return;
                    }
                    etsugar_initial_stock_remarks.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    etsugar_initial_stock_remarks.setEnabled(true);
                    etsugar_initial_stock_remarks.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    etsugar_initial_stock_remarks.setTextIsSelectable(true);
                    etsugar_initial_stock_remarks.setFocusable(true);
                    etsugar_initial_stock_remarks.setFocusableInTouchMode(true);
                    etsugar_initial_stock_remarks.setCursorVisible(true);
                    etsugar_initial_stock_remarks.setEnabled(true);

                }
            }
        });*/
        return view;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {

        sugar_initial_stock_this_month = Objects.requireNonNull(etsugar_initial_stock_this_month.getText().toString());
        sugar_initial_stock_this_month_remarks = Objects.requireNonNull(etsugar_initial_stock_this_month_remarks.getText().toString());
        sugar_initial_stock_this_year_to_date = Objects.requireNonNull(etsugar_initial_stock_this_year_to_date.getText().toString());
        sugar_initial_stock_this_year_to_date_remarks = Objects.requireNonNull(etsugar_initial_stock_this_year_to_date_remarks.getText().toString());

        mollases_initial_stock_this_month = Objects.requireNonNull(etmollases_initial_stock_this_month.getText().toString());
        mollases_initial_stock_this_month_remarks = Objects.requireNonNull(etmollases_initial_stock_this_month_remarks.getText().toString());
        mollases_initial_initial_stock_year_to_date = Objects.requireNonNull(etmollases_initial_initial_stock_year_to_date.getText().toString());
        mollases_initial_initial_stock_year_to_date_remarks = Objects.requireNonNull(etmollases_initial_stock_year_to_date_remarks.getText().toString());


/*
        SugarMolassesBus sugarMolassesBus = SugarMolassesBus.getInstance();

        sugarMolassesBus.setSugar_initial_stock_this_month(sugar_initial_stock_this_month);
        sugarMolassesBus.setSugar_initial_stock_this_month_remarks(sugar_initial_stock_this_month_remarks);
        sugarMolassesBus.setSugar_domestic_sale_year_to_date(sugar_initial_stock_this_year_to_date);
        sugarMolassesBus.setSugar_domestic_sale_year_to_date_remarks( sugar_initial_stock_this_year_to_date_remarks);

        sugarMolassesBus.setMollases_initial_stock_this_month(mollases_initial_stock_this_month);
        sugarMolassesBus.setMollases_initial_stock_this_month_remarks(mollases_initial_stock_this_month_remarks);
        sugarMolassesBus.setMollases_initial_initial_stock_year_to_date(mollases_initial_initial_stock_year_to_date);
        sugarMolassesBus.setMollases_initial_initial_stock_year_to_date_remarks( mollases_initial_initial_stock_year_to_date_remarks);
*/

        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback)
    {

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
    public void onError(@NonNull VerificationError error)
    {

    }


}

