package co.ke.bsl.ui.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
import co.ke.bsl.data.view.ReturnsView;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class SugarMolassesProductionFactoryInspection extends Fragment implements BlockingStep {

    @BindView(R.id.etdocument_no)
    CustomEditText etdocument_no;
    @BindView(R.id.ssreturns)
    SearchableSpinner ssreturns;
    @BindView(R.id.etdocument_date)
    CustomEditText etdocument_date;
    @BindView(R.id.etyear)
    CustomEditText etyear;
    @BindView(R.id.etmonth)
    CustomEditText etmonth;
    @BindView(R.id.etApplicantName)
    CustomEditText etApplicantName;


    private ArrayList<String> returnslist = new ArrayList<>();
    private String document_number, returns, document_date, year, month, applicant_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_afasugarand_molasses_production_factory_inspection, container, false);
        ButterKnife.bind(this, view);

        AFA app = (AFA) Objects.requireNonNull(getActivity()).getApplication();

        setListreturns(getDummydummyreturns());

        ssreturns.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id)
            {
                returns = ssreturns.getSelectedItem().toString();
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
        listViewItems.add(new ReturnsView("Returns A"));
        listViewItems.add(new ReturnsView("Returns B"));
        listViewItems.add(new ReturnsView("Returns C"));
        listViewItems.add(new ReturnsView("Returns D"));

        return listViewItems;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback)
    {

        document_number= Objects.requireNonNull(etdocument_no.getText().toString());
        returns = Objects.requireNonNull(ssreturns.getSelectedItem().toString());
        document_date = Objects.requireNonNull(etdocument_date.getText().toString());
        year = Objects.requireNonNull(etyear.getText().toString());
        month = Objects.requireNonNull(etmonth.getText().toString());
        applicant_name = Objects.requireNonNull(etApplicantName.getText().toString());
/*
        SugarMolassesBus sugarMolassesBus = SugarMolassesBus.getInstance();

        sugarMolassesBus.setDocument_number(document_number);
        sugarMolassesBus.setReturns(returns);
        sugarMolassesBus.setDocument_date(document_date);
        sugarMolassesBus.setYear(year);
        sugarMolassesBus.setMonth(month);
        sugarMolassesBus.setSubLocation(applicant_name);
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
