package co.ke.bsl.ui.views.fragments;


import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.TextView;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.view.HCDHorticulturalCropsColdStorageBus;
import co.ke.bsl.pojo.PayCategory;
import co.ke.bsl.pojo.Product;
import co.ke.bsl.pojo.ProductCategory;
import co.ke.bsl.util.CustomEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class HCDHorticulturalCropsColdStorageIn extends Fragment implements BlockingStep {

    @BindView(R.id.ssProductCategory)
    SearchableSpinner ssProductCategory;
    @BindView(R.id.ssProduct)
    SearchableSpinner ssProduct;
    @BindView(R.id.etColdRoomNo)
    CustomEditText etColdRoomNo;
    @BindView(R.id.etDateBrought)
    CustomEditText etDateBrought;
    @BindView(R.id.ssPayCategory)
    SearchableSpinner ssPayCategory;
    @BindView(R.id.etPackagingMaterial)
    CustomEditText etPackagingMaterial;
    @BindView(R.id.etWeightIn)
    CustomEditText etWeightIn;
    @BindView(R.id.etQuality)
    CustomEditText etQuality;

    AFADatabaseAdapter db;
    AFA app;


    private String productsCategory, product, coldRoomNo, dateBrouught, payCategory, packagingMaterial, quality, etWeightin;
    final Calendar myCalendar = Calendar.getInstance();

    private ArrayList<ProductCategory> productCategoryArrayList = new ArrayList<>();
    private ArrayList<Product> productArrayList = new ArrayList<>();
    private ArrayList<PayCategory> payCategoryArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hcdhorticultural_crops_cold_storage_in, container, false);
        ButterKnife.bind(this, view);

        app = (AFA) Objects.requireNonNull(getActivity()).getApplication();
        db = new AFADatabaseAdapter(getContext()).open();

        List<ProductCategory> productCategoryList = db.getAllProductCategory();
        List<PayCategory> payCategoryList = db.getAllPayCategory();

        setProductCategory(productCategoryList);

        setPayCategory(payCategoryList);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        etDateBrought.setKeyListener(null);
        etDateBrought.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        ssProductCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               ProductCategory pc = (ProductCategory) ssProductCategory.getSelectedItem();
                productsCategory = pc.getProductCategoryID();

                List<Product> productList = db.getColdStorageProduct(productsCategory);
                setProduct(productList);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Product prod = (Product) ssProduct.getSelectedItem();
                product = prod.getProductID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ssPayCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                PayCategory pay = (PayCategory) ssPayCategory.getSelectedItem();
                payCategory = pay.getPayCategoryID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;

    }


    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        coldRoomNo = Objects.requireNonNull(etColdRoomNo.getText()).toString().trim();
        dateBrouught = new Timestamp(myCalendar.getTimeInMillis()).toString();
        packagingMaterial = Objects.requireNonNull(etPackagingMaterial.getText()).toString().trim();
        quality = Objects.requireNonNull(etQuality.getText()).toString().trim();
        etWeightin = Objects.requireNonNull(etWeightIn.getText()).toString().trim();

        //validation
        boolean valid = validateSpinner(ssProductCategory, productsCategory) &
                validateSpinner(ssProduct, product) &
                validateEditText(etColdRoomNo, coldRoomNo) &
                validateEditText(etDateBrought, dateBrouught) &
                validateSpinner(ssPayCategory, payCategory) &
                validateEditText(etPackagingMaterial, packagingMaterial) &
                validateEditText(etQuality, quality);

        HCDHorticulturalCropsColdStorageBus hCDHorticulturalCropsColdStorageBus = HCDHorticulturalCropsColdStorageBus.getInstance();

        hCDHorticulturalCropsColdStorageBus.setProductsCategory(productsCategory);
        hCDHorticulturalCropsColdStorageBus.setProduct(product);
        hCDHorticulturalCropsColdStorageBus.setColdRoomNo(coldRoomNo);
        hCDHorticulturalCropsColdStorageBus.setDateBrouught(dateBrouught);
        hCDHorticulturalCropsColdStorageBus.setPayCategory(payCategory);
        hCDHorticulturalCropsColdStorageBus.setPackagingMaterial(packagingMaterial);
        hCDHorticulturalCropsColdStorageBus.setQuality(quality);
        hCDHorticulturalCropsColdStorageBus.setWeightIn(etWeightin);

        if (valid) {
            callback.goToNextStep();
        }

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

    private boolean validateSpinner(SearchableSpinner searchableSpinner, String searchableSpinnerString) {

        boolean result = false;

        if ("- Required -".equals(searchableSpinnerString)) {
            TextView errorText = (TextView) searchableSpinner.getSelectedView();
            if (errorText != null) {
                errorText.setError("");
                errorText.setTextColor(getResources().getColor(R.color.colorWarning));
                errorText.setText("Required");
            }
            result = false;
        } else{
            result = true;
        }

        return result;
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etDateBrought.setText(sdf.format(myCalendar.getTime()));
    }

    private void setProductCategory(List<ProductCategory> productCategoryList) {
        productCategoryArrayList.clear();
//        productCategoryArrayList.add("- Required -");

        for (ProductCategory regionWrapper : productCategoryList) {
            productCategoryArrayList.add(regionWrapper);
        }

        ArrayAdapter<ProductCategory> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, productCategoryArrayList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssProductCategory.setAdapter(regionAdapter);

    }

    private void setProduct(List<Product> productList) {
        productArrayList.clear();

        for (Product regionWrapper : productList) {
            productArrayList.add(regionWrapper);
        }

        ArrayAdapter<Product> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, productArrayList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssProduct.setAdapter(regionAdapter);

    }

    private void setPayCategory(List<PayCategory> payCategoryList) {
        payCategoryArrayList.clear();

        for (PayCategory regionWrapper : payCategoryList) {
            payCategoryArrayList.add(regionWrapper);
        }

        ArrayAdapter<PayCategory> regionAdapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), R.layout.spinner_item_rg, payCategoryArrayList);
        regionAdapter.setDropDownViewResource(R.layout.spinner_item_rg2);
        ssPayCategory.setAdapter(regionAdapter);

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
