package co.ke.bsl.ui.common;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import org.idempiere.webservice.client.base.DataRow;
import org.idempiere.webservice.client.base.Enums;
import org.idempiere.webservice.client.base.Field;
import org.idempiere.webservice.client.base.LoginRequest;
import org.idempiere.webservice.client.net.WebServiceConnection;
import org.idempiere.webservice.client.request.QueryDataRequest;
import org.idempiere.webservice.client.response.WindowTabDataResponse;

import java.util.ArrayList;

import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CaneCensusFarmer;
import co.ke.bsl.pojo.City;
import co.ke.bsl.pojo.Country;
import co.ke.bsl.pojo.County;
import co.ke.bsl.pojo.PayCategory;
import co.ke.bsl.pojo.Product;
import co.ke.bsl.pojo.ProductCategory;
import co.ke.bsl.pojo.SubCounty;
import co.ke.bsl.ui.activities.LoginActivity;

public class SplashActivity extends Activity {

    private static int SPLASH_TIME_OUT = 3000;
    private static AFADatabaseAdapter db;

    protected static AFA appState;

    private static Context mContext;
    static LoginRequest login;
    static String userName;
    static String password;

    static ArrayList<County> countyArrayList = new ArrayList<>();
    static ArrayList<Product> productArrayList = new ArrayList<>();
    static ArrayList<PayCategory> payCategoryArrayList = new ArrayList<>();
    static ArrayList<Product> nocdProductArrayList = new ArrayList<>();
    static ArrayList<Product> coldStorageProductArrayList = new ArrayList<>();
    static ArrayList<ProductCategory> productCategoryArrayList = new ArrayList<>();
    static ArrayList<City> cityArrayList = new ArrayList<>();
    static ArrayList<Country> CountryList = new ArrayList<>();


    private static final String CHANNEL_ID = "1000000";

    static ArrayList<SubCounty> subCountyArrayList = new ArrayList<>();


    static String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        userName = getResources().getString(R.string.baseUsername);
        password = getResources().getString(R.string.basePassword);
//        Typeface typeface = ResourcesCompat.getFont(this, R.font.sans_bold);

        TextView appname = findViewById(R.id.appname);
//        appname.setTypeface(typeface);
        appname.setTextColor(getResources().getColor(R.color.afayellow));

        appState = (AFA) getApplication();

        uri = getResources().getString(R.string.baseURI);
        mContext = getApplicationContext();
        db = new AFADatabaseAdapter(getApplicationContext());

        db.onCreate();
        createNotificationChannel();
        YoYo.with(Techniques.Bounce)
                .duration(3000)
                .playOn(findViewById(R.id.logo));

        YoYo.with(Techniques.FadeInUp)
                .duration(1500)
                .playOn(findViewById(R.id.appname));
        new FetchStats().execute();

        /* new Handler().postDelayed(new Runnable() {
         *//*
         * Showing splash screen with a timer. This will be useful when you
         * want to show case your app logo / company
         *//*

            @Override
            public void run() {


                // This method will be executed once the timer is over
                // Start your app main activity
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);*/
    }

    private class FetchStats extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... params) {
            refreshCouponPeriodicWork();
            return null;
        }

        protected void onPostExecute(String result) {
            runOnUiThread(new Runnable() {
                public void run() {

                    // Start your app main activity
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));

                    // close this activity
                    finish();

                }
            });
        }
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


    public static void refreshCouponPeriodicWork() {


        System.out.println("the username passed is " + userName);
        System.out.println("the password passed is " + password);
       /* CompositeOperationRequest compositeOperation = new CompositeOperationRequest();
        compositeOperation.setWebServiceType("TestLogin");




        compositeOperation.setLogin(login);

        WebServiceConnection client = getClient();

        boolean success;


        try {
            CompositeResponse response = client.sendRequest(compositeOperation);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println("Error: " + response.getErrorMessage());

                success = false;
            } else {
                success = true;

                System.out.println("system logged in" + success);
            }


            System.out.println("--------------------------");
            System.out.println("Web Service: TestLogin");
            System.out.println("Attempts: " + client.getAttemptsRequest());
            System.out.println("Time: " + client.getTimeRequest());
            System.out.println("--------------------------");

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            success = false;
        }
    */
        try {

            getSugarCompany();
            getCBPartner();

            countyArrayList = (ArrayList<County>) db.getAllCounty();
            System.out.println(countyArrayList.size() + "countyArrayList");
            subCountyArrayList = (ArrayList<SubCounty>) db.getAllLocalSubCounty();
            productArrayList = (ArrayList<Product>) db.getAllProduct();
            nocdProductArrayList = (ArrayList<Product>) db.getAllNOCDProduct();
            coldStorageProductArrayList = (ArrayList<Product>) db.getAllColdStorageProduct();
            productCategoryArrayList = (ArrayList<ProductCategory>) db.getAllProductCategory();
            System.out.println(productArrayList.size() + "productArrayList");
            System.out.println(nocdProductArrayList.size() + "nocdProductArrayList");
            System.out.println(coldStorageProductArrayList.size() + "coldStorageProductArrayList");
            System.out.println(productCategoryArrayList.size() + "productCategoryArrayList");
            cityArrayList = (ArrayList<City>) db.getCityList();
            CountryList = (ArrayList<Country>) db.getCountryList();


            if (countyArrayList.isEmpty() || countyArrayList == null || countyArrayList.size() < 2) {
                getCountyList();
            }


            if (subCountyArrayList.isEmpty() || subCountyArrayList == null || subCountyArrayList.size() < 2) {
                getSubCounty();
            }


            if (productArrayList.isEmpty() || productArrayList == null || productArrayList.size() < 2) {
                getProducts();
            }

            if (payCategoryArrayList.isEmpty() || payCategoryArrayList == null || payCategoryArrayList.size() < 2) {
                getPayCategory();
            }

            if (nocdProductArrayList.isEmpty() || nocdProductArrayList == null || nocdProductArrayList.size() < 2) {
                getNOCDProducts();
            }

            if (coldStorageProductArrayList.isEmpty() || coldStorageProductArrayList == null || coldStorageProductArrayList.size() < 2) {
                getColdStorageProducts();
            }

            if (productCategoryArrayList.isEmpty() || productCategoryArrayList == null || productCategoryArrayList.size() < 2) {
                getProductCategories();
            }

            if (cityArrayList.isEmpty() || cityArrayList == null || cityArrayList.size() < 2) {
                getCities();
            }
            if (CountryList.isEmpty() || CountryList == null || CountryList.size() < 2) {
                getCountry();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected static void getCountyList() {

        //LoginRequest loginRequest= params[0];

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCounty");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("Name", "%%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<County> cityArrayList = new ArrayList<>();

        County city = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows: " + response.getTotalRows());
                System.out.println("Num rows: " + response.getNumRows());
                System.out.println("Start row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    city = new County();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("SPD_County_ID".equalsIgnoreCase(field.getColumn()))
                            city.setCountyId(field.getStringValue());
                        else if ("Name".equalsIgnoreCase(field.getColumn()))
                            city.setCountyName(field.getStringValue());


                    }
                    db.insertCounty(city.getCountyName(), city.getCountyId());
                    cityArrayList.add(city);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected static void getCountry() {


        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCountry");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("Name", "%%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<Country> countryArrayList = new ArrayList<>();
        Country country = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows: " + response.getTotalRows());
                System.out.println("Num rows: " + response.getNumRows());
                System.out.println("Start row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    country = new Country();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("C_Country_ID".equalsIgnoreCase(field.getColumn()))
                            country.setC_country_id(field.getStringValue());
                        else if ("Name".equalsIgnoreCase(field.getColumn()))
                            country.setName(field.getStringValue());


                    }
                    db.createCountry(country.getName(), country.getC_country_id());
                    // countryArrayList.add(country);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    protected static void getSubCounty() {
        CaneCensusFarmer caneCensusFarmer = new CaneCensusFarmer();


        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QuerySubCounty");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        System.out.println(caneCensusFarmer.getCountyID());
        DataRow data = new DataRow();

        //  data.addField("SPD_County_ID",caneCensusFarmer.getCountyID() );
        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows: " + response.getTotalRows());
                System.out.println("Num rows: " + response.getNumRows());
                System.out.println("Start row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    SubCounty city = new SubCounty();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("SPD_County_ID".equalsIgnoreCase(field.getColumn()))
                            city.setCountyId(field.getStringValue());
                        else if ("Name".equalsIgnoreCase(field.getColumn()))
                            city.setSubCountyName(field.getStringValue());
                        else if ("SPD_SubCounty_ID".equalsIgnoreCase(field.getColumn()))
                            city.setSubCountyId(field.getStringValue());

                        if (city.getSubCountyName() != null && city.getSubCountyId() != null) {


                        }

                    }
                    db.insertSubCounty(city.getSubCountyName(), city.getSubCountyId(), city.getCountyId());
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // return cityArrayList;

    }


    protected static void getSugarCompany() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QuerySugarMiller");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        //data.addField("Name", "%%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
//         db.deleteAllRecord("sugar_company");

        ArrayList<CBPartner> countryArrayList = new ArrayList<>();
        CBPartner cbPartner = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows: " + response.getTotalRows());
                System.out.println("Num rows: " + response.getNumRows());
                System.out.println("Start row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    cbPartner = new CBPartner();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            cbPartner.setC_bpartner_id(field.getStringValue());
                        else if ("applicant_name".equalsIgnoreCase(field.getColumn()))
                            cbPartner.setName(field.getStringValue());
                        if (cbPartner.getName() != null && cbPartner.getC_bpartner_id() != null) {


                        }
                    }
                    db.insertSugarCompany(cbPartner.getName(), cbPartner.getC_bpartner_id());
                    countryArrayList.add(cbPartner);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected static void getCBPartner() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCBPartner");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        //data.addField("Name", "%%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
//         db.deleteAllRecord("sugar_company");

        ArrayList<CBPartner> countryArrayList = new ArrayList<>();
        CBPartner cbPartner = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows: " + response.getTotalRows());
                System.out.println("Num rows: " + response.getNumRows());
                System.out.println("Start row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    cbPartner = new CBPartner();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            cbPartner.setC_bpartner_id(field.getStringValue());
                        else if ("Name".equalsIgnoreCase(field.getColumn()))
                            cbPartner.setName(field.getStringValue());
                        if (cbPartner.getName() != null && cbPartner.getC_bpartner_id() != null) {


                        }
                    }
                    db.insertCBPartner(cbPartner.getName(), cbPartner.getC_bpartner_id());
                    countryArrayList.add(cbPartner);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    protected static void getProducts() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryProduct");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        //data.addField("Name", "%%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<Product> countryArrayList = new ArrayList<>();
        Product product = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows Of products: " + response.getTotalRows());
                System.out.println("Num rows  Of products: " + response.getNumRows());
                System.out.println("Start row  Of products: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    product = new Product();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("M_Product_ID".equalsIgnoreCase(field.getColumn()))
                            product.setProductID(field.getStringValue());
                        else if ("Name".equalsIgnoreCase(field.getColumn()))
                            product.setName(field.getStringValue());

                    }
                    db.insertProduct(product.getName(), product.getProductID());
                    countryArrayList.add(product);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected static void getPayCategory() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryPayCategory");
        ws.setLogin(getLogin());

        DataRow data = new DataRow();

        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<PayCategory> payCategoryArrayList = new ArrayList<>();
        PayCategory payCategory = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows Of pay category: " + response.getTotalRows());
                System.out.println("Num rows  Of pay category: " + response.getNumRows());
                System.out.println("Start row  Of pay category: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    payCategory = new PayCategory();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_HC_Dailymonthpay_ID".equalsIgnoreCase(field.getColumn()))
                            payCategory.setPayCategoryID(field.getStringValue());
                        else if ("payname".equalsIgnoreCase(field.getColumn()))
                            payCategory.setName(field.getStringValue());

                    }
                    db.insertPayCategory(payCategory.getName(), payCategory.getPayCategoryID());
                    payCategoryArrayList.add(payCategory);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected static void getProductCategories() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryProductCategory");
        ws.setLogin(getLogin());

        DataRow data = new DataRow();
        data.addField("Description", "%Horticultural%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<ProductCategory> productCategoryArrayList = new ArrayList<>();
        ProductCategory productCategory = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows Of product categories: " + response.getTotalRows());
                System.out.println("Num rows  Of product categories: " + response.getNumRows());
                System.out.println("Start row  Of product categories: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    productCategory = new ProductCategory();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("M_Product_Category_ID".equalsIgnoreCase(field.getColumn()))
                            productCategory.setProductCategoryID(field.getStringValue());
                        else if ("Name".equalsIgnoreCase(field.getColumn()))
                            productCategory.setName(field.getStringValue());

                    }
                    db.insertProductCategory(productCategory.getName(), productCategory.getProductCategoryID());
                    productCategoryArrayList.add(productCategory);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    protected static void getNOCDProducts() {

            QueryDataRequest ws = new QueryDataRequest();
            ws.setWebServiceType("QueryNOCDProducts");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        //data.addField("Name", "%%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<Product> countryArrayList = new ArrayList<>();
        Product product = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows Of NOCD products: " + response.getTotalRows());
                System.out.println("Num rows  Of NOCD products: " + response.getNumRows());
                System.out.println("Start row  Of NOCD products: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    product = new Product();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("M_Product_ID".equalsIgnoreCase(field.getColumn()))
                            product.setProductID(field.getStringValue());
                        else if ("Name".equalsIgnoreCase(field.getColumn()))
                            product.setName(field.getStringValue());


                    }
                    db.insertNOCDProduct(product.getName(), product.getProductID());
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected static void getColdStorageProducts() {

            QueryDataRequest ws = new QueryDataRequest();
            ws.setWebServiceType("QueryColdStorageProducts");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        //data.addField("Name", "%%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<Product> countryArrayList = new ArrayList<>();
        Product product = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows Of Cold Storage products: " + response.getTotalRows());
                System.out.println("Num rows  Of Cold Storage products: " + response.getNumRows());
                System.out.println("Start row  Of Cold Storage products: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    product = new Product();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("M_Product_ID".equalsIgnoreCase(field.getColumn()))
                            product.setProductID(field.getStringValue());
                        else if ("Name".equalsIgnoreCase(field.getColumn()))
                            product.setName(field.getStringValue());
                        else if ("M_Product_Category_ID".equalsIgnoreCase(field.getColumn()))
                            product.setProductCategoryID(field.getStringValue());


                    }
                    db.insertColdStorageProduct(product.getName(), product.getProductCategoryID() , product.getProductID());
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    protected static void getCities() {

        //db.open();

        int counter = 0;

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCities");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("Name", "%%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        City city = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println("Total rows Of Cities: " + response.getTotalRows());
                System.out.println("Num rows of Cities:: " + response.getNumRows());
                System.out.println("Start row of  Cities:: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    city = new City();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("C_City_ID".equalsIgnoreCase(field.getColumn())) {
                            city.setC_city_id(field.getStringValue());
                        } else if ("Name".equalsIgnoreCase(field.getColumn())) {
                            city.setName(field.getStringValue());
                        }


                    }
                    long fetch = db.createCity(city.getName(), city.getC_city_id());
                    System.out.println("Fetching---------------" + fetch);
                    counter++;
                    System.out.println("Counter is ------------------" + counter);

                }            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static LoginRequest getLogin() {
        // SET LOGIN
        login = new LoginRequest();

        login.setUser(userName);
        login.setPass(password);
        login.setClientID(1000000);
        login.setRoleID(1000000);
        login.setOrgID(1000000);
        login.setWarehouseID(1000000);

        return login;
    }

    public static WebServiceConnection getClient() {

        WebServiceConnection client = new WebServiceConnection();
        client.setAttempts(3);
        client.setTimeout(10000);
        client.setAttemptsTimeout(10000);

        client.setUrl(uri);

        client.setAppName("Java Test WS Client");
        return client;
    }

}

