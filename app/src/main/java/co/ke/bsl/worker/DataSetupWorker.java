package co.ke.bsl.worker;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.idempiere.webservice.client.base.DataRow;
import org.idempiere.webservice.client.base.Enums;
import org.idempiere.webservice.client.base.Field;
import org.idempiere.webservice.client.base.LoginRequest;
import org.idempiere.webservice.client.net.WebServiceConnection;
import org.idempiere.webservice.client.request.QueryDataRequest;
import org.idempiere.webservice.client.response.WindowTabDataResponse;

import java.net.InetAddress;
import java.util.ArrayList;

import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.pojo.AvocadoQualityInspection;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CaneCensusFarmer;
import co.ke.bsl.pojo.City;
import co.ke.bsl.pojo.CoffeeCommercialAgent;
import co.ke.bsl.pojo.CoffeeExporterDealerInspectionDetails;
import co.ke.bsl.pojo.CoffeeGrowerMarketingAgentDetails;
import co.ke.bsl.pojo.CoffeeMillerLicenceApplicationDetails;
import co.ke.bsl.pojo.CoffeeManagementAgentInsp;
import co.ke.bsl.pojo.CoffeeNursercertInsp;
import co.ke.bsl.pojo.CoffeePulpinglicenceApllPSL;
import co.ke.bsl.pojo.CottonBuyingStoreInspection;
import co.ke.bsl.pojo.CottonGinneryInspection;
import co.ke.bsl.pojo.CottonLintClassingReport;
import co.ke.bsl.pojo.Country;
import co.ke.bsl.pojo.County;
import co.ke.bsl.pojo.FlowersConsolidators;
import co.ke.bsl.pojo.FoodProcessingInpection;
import co.ke.bsl.pojo.FoodWareHouseInspection;
import co.ke.bsl.pojo.FruitsAndVegetablesExporters;
import co.ke.bsl.pojo.HCDFruitVegetableConsolidators;
import co.ke.bsl.pojo.HCDParkhouseWarehouseDetails;
import co.ke.bsl.pojo.HorticulturalFlowerExportersDeskVettingDetails;
import co.ke.bsl.pojo.HorticultureCropExportLicenceFarmInspectionDetails;
import co.ke.bsl.pojo.HorticultureNurseryInspectionDetails;
import co.ke.bsl.pojo.HorticultureProduceTransportationDetails;
import co.ke.bsl.pojo.MangoQualityInspection;
import co.ke.bsl.pojo.Product;
import co.ke.bsl.pojo.PulpingStationLicenseApplicationDetails;
import co.ke.bsl.pojo.PyrethrumInspectionChecklist;
import co.ke.bsl.pojo.SisalFactoryInspection;
import co.ke.bsl.pojo.SisalSpinningFactoryInspection;
import co.ke.bsl.pojo.SubCounty;
import co.ke.bsl.pojo.SugarMillDetails;
import co.ke.bsl.pojo.TeaWarehouseManInspectionDataCollection;
import co.ke.bsl.pojo.TeaPackerChecklist;
import co.ke.bsl.ui.common.DashboardActivity;

public class DataSetupWorker extends Worker {

    private static final String WORK_RESULT = "data Setup";
    private static final String CHANNEL_ID = "1000000";
    Context context = getApplicationContext();
    String uri = context.getString(R.string.baseURI);
    AFADatabaseAdapter db;
    ArrayList<County> countyArrayList = new ArrayList<>();
    ArrayList<Product> productArrayList = new ArrayList<>();
    ArrayList<City> cityArrayList = new ArrayList<>();
    ArrayList<Country> CountryList = new ArrayList<>();

    ArrayList<SubCounty> subCountyArrayList = new ArrayList<>();
    private final int notificationID = 1;

    public DataSetupWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Worker.Result doWork() {
        //read input argument

        if (isInternetAvailable()) {

            try {

                String workType = getInputData().getString("workType");
                String directorate = getInputData().getString("directorate");
                Log.i("refresh cpn work", "type of work request: " + workType);

                System.out.println("-----------------------Running the job-----------------------" + workType);
                //appState = (ApplicationState) getApplication();

                db = new AFADatabaseAdapter(getApplicationContext());

                if (directorate.equals("1000001")) {

                    //Sugar Directorate
                    getSugarCompany();
                    getSugarMillInspection();

                } else if (directorate.equals("1000002")) {

                    //Tea Directorate
                    getteapackerchecklist();
                    getTeaWarehouseManInspection();

                } else if (directorate.equals("1000004")) {

                    //Coffee Directorate
                    getPulpingStationLicenseApplication();
                    getCoffeeNurseryInspection();
                    getCoffeeMillerLicenseApplication();
                    getCoffeemanagementAgent();
                    getCoffeeGrowerMarketingAgent();
                    getCoffeeExporterDealerInspection();
                    getCoffeemarketingManagementAgents();
                    getCoffeePulpingLicenceApllPLS();

                } else if (directorate.equals("1000007")) {

                    //Horticulture Directorate
                    getFlowersConsolidators();
                    getHorticultureNurseryInspectionChecklist();
                    getHorticultureParkhouseWarehouseInspection();
                    getHorticultureProduceTransportationChecklist();
                    getHorticultureFruitsAndVegetablesExporters();
                    getFruitsConsolidators();
                    getAvocadoQualityInspection();
                    getMangoQualityInspection();
                    getHorticulturalFlowerExportersDeskVetting();
                    getHorticultureCropExportLicenceFarmInspection();

                } else if (directorate.equals("1000010")) {

                    //Pyrethrum Directorate
                    getPyrethrumChecklistInspection();

                }else if (directorate.equals("1000006")) {

                    //food Directorate
                    getFoodProcessingInspection();
                    getFoodWareHouse();

                } else if (directorate.equals("1000011")) {

                    //Fibre Directorate
                    getSisalFactoryInspection();
                    getCottonBuyingStoreInspection();
                    getCottonGinneryInspection();
                    getCottonLintClassingReport();
                    getSisalSpinningFactoryInspection();

                }

                countyArrayList = (ArrayList<County>) db.getAllCounty();
                subCountyArrayList = (ArrayList<SubCounty>) db.getAllLocalSubCounty();
                productArrayList = (ArrayList<Product>) db.getAllProduct();
                cityArrayList = (ArrayList<City>) db.getCityList();
                CountryList = (ArrayList<Country>) db.getCountryList();

                if (countyArrayList.isEmpty() || countyArrayList == null) {
                    getCountyList();
                }

                if (subCountyArrayList.isEmpty() || subCountyArrayList == null) {
                    getSubCounty();
                }

                if (productArrayList.isEmpty()) {
                    getProducts();
                }
                if (cityArrayList.isEmpty()) {
                    getCities();
                }
                if (CountryList.isEmpty()) {
                    getCountry();
                }

            } finally {
                // db.closeDB();
                System.out.println("----------------------job- ended and closed the db----------------------");
            }

            trigerNotification("Success");
            return Result.SUCCESS;
        }

        trigerNotification("Failure");
        return Result.FAILURE;
    }


    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }

    protected void getCountyList() {

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

                        db.insertCounty(city.getCountyName(), city.getCountyId());
                    }
                    cityArrayList.add(city);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void getSugarMillInspection() {

        String sugarMillerLicenceNumber = "";
        //LoginRequest loginRequest= params[0];
        //db.deleteSugarmillLicenceInspection();
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QuerySugarMillInspection");
        ws.setLogin(getLogin());

        DataRow data = new DataRow();

        //data.addField("Name", "%%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<SugarMillDetails> sugarMillDetailsArrayList = new ArrayList<>();

        SugarMillDetails sugarMillDetails = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
//                db.deleteSugarMillCompliance();
                System.out.println("Total sugar mill rows: " + response.getTotalRows());
                System.out.println("Num sugar mill rows: " + response.getNumRows());
                System.out.println("Start sugar mill row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    sugarMillDetails = new SugarMillDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_SD_Smillcliancelist_ID".equalsIgnoreCase(field.getColumn()))
                            sugarMillDetails.setAfa_sd_smillcliancelist_id(field.getStringValue());
                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            sugarMillDetails.setDocument_number(field.getStringValue());
                            System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        } else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            sugarMillDetails.setC_BPartner_ID(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            sugarMillDetails.setDocument_date(field.getStringValue());

                        else if ("AFA_SD_Smillconstrcompnote1_ID".equalsIgnoreCase(field.getColumn())) {
                            System.out.println("AFA_SD_Smillconstrcompnote1_ID:" + field.getStringValue());
                            sugarMillerLicenceNumber = getSugarMillerLicenceNumber(field.getStringValue());
                            sugarMillDetails.setLetter_of_comfort(sugarMillerLicenceNumber);
                        }

                    }

                    sugarMillDetailsArrayList.add(sugarMillDetails);
                    db.insertSugarMillLicencecompliance(sugarMillDetails);
                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception eeeee " + e.getMessage());
        }
    }

    protected String getSugarMillerLicenceNumber(String sugarMillerLicenceID) {

        String sugarMillerLicenceNumber = "";

        db.open();

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QuerySugarMillerLicenceNumber");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("AFA_SD_Smillconstrcompnote1_ID", sugarMillerLicenceID);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("Total Sugar Miller Licence rows: " + response.getTotalRows());
                System.out.println("Num Sugar Miller Licence rows: " + response.getNumRows());
                System.out.println("Start Sugar Miller Licence row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            sugarMillerLicenceNumber = field.getStringValue();
                        }
                    }

                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception sugarMillerLicenceNumber " + e.getMessage());
        } finally {
            db.close();
        }
        return sugarMillerLicenceNumber;

    }

    protected void getteapackerchecklist() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryTeaPacker");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);
        DataRow data = new DataRow();
        data.addField("IsApproved", "N");
        data.addField("Processing", "N");
        data.addField("Processing", "N");
        data.addField("ispacker", "Y");
        data.addField("IsApproved", "N");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<TeaPackerChecklist> TeaPackerChecklistArrayList = new ArrayList<>();

        TeaPackerChecklist teaPackerChecklist = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
//                db.deleteTeapackerInspection();
                System.out.println("Total tea packer rows: " + response.getTotalRows());
                System.out.println("Num tea packer rows: " + response.getNumRows());
                System.out.println("Start tea packer row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    teaPackerChecklist = new TeaPackerChecklist();
                    System.out.println("Tea packer Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Tea Packer Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_TD_Inspection_Checklist_ID".equalsIgnoreCase(field.getColumn()))
                            teaPackerChecklist.setAFA_TD_Inspection_Checklist_ID(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            teaPackerChecklist.setDocumentNo(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            teaPackerChecklist.setDocumentDate(field.getStringValue());

                        else if ("AFA_TD_Teapacker_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            teaPackerChecklist.setLicenceNo(getTeaPackerLicence(field.getStringValue()));

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            teaPackerChecklist.setApplicantName(field.getStringValue());

                        System.out.println("AFA_td_teapacker_id:" + teaPackerChecklist.getDocumentNo());

                    }
                    db.insertTeaPackerRecord(teaPackerChecklist);
                    TeaPackerChecklistArrayList.add(teaPackerChecklist);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected String getTeaPackerLicence(String licenceNumber) {

        String licenceDocumentNumber = "";

        db.open();

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryTeaPackerLicence");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("AFA_TD_Teapacker_Lic_ID", licenceNumber);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("Total tea packer licence rows: " + response.getTotalRows());
                System.out.println("Num tea packer licence rows: " + response.getNumRows());
                System.out.println("Start tea packer licence row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            licenceDocumentNumber = field.getStringValue();
                        }
                    }

                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception tea packer licence " + e.getMessage());
        } finally {
            db.close();
        }
        return licenceDocumentNumber;

    }

    private void getFoodProcessingInspection() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryFoodProcessing");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");

        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<FoodProcessingInpection> foodProcessingInpectionArrayList = new ArrayList<>();

        FoodProcessingInpection foodProcessingInpection = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {


                System.out.println("Total foodProcessingInpectionrows: " + response.getTotalRows());
                System.out.println("Num foodProcessingInpection rows: " + response.getNumRows());
                System.out.println("foodProcessingInpection report row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    foodProcessingInpection = new FoodProcessingInpection();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("AFA_FCD_ManufacturerLic_ID".equalsIgnoreCase(field.getColumn()))
                            foodProcessingInpection.setAFA_FD_FOOD_PROCESSING_Inspection_ID(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            foodProcessingInpection.setDocumentNumber(field.getStringValue());

                        else if ("application_date".equalsIgnoreCase(field.getColumn()))
                            foodProcessingInpection.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            foodProcessingInpection.setNameOfApplicant(field.getStringValue());

                        else if ("AFA_FCD_ManufPlantReg_ID".equalsIgnoreCase(field.getColumn()))
                            foodProcessingInpection.setFoodCropManufacturingPlanApproval(field.getStringValue());

                        else if ("AFA_FCD_ManufPlantReg_ID".equalsIgnoreCase(field.getColumn()))
                            foodProcessingInpection.setFoodCropManufacturingPlanApproval(getFoodProcessingLicence(field.getStringValue()));

                    }
                    foodProcessingInpectionArrayList.add(foodProcessingInpection);
                    db.insertFoodProcessingInpection(foodProcessingInpection);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void getFoodWareHouse() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryFoodWarehouse");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");

        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<FoodWareHouseInspection> foodWareHouseInspectionArrayList = new ArrayList<>();

        FoodWareHouseInspection foodWareHouseInspection = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                db.deletefoodWareHouseInspectionlist();
                System.out.println("Total food rows: " + response.getTotalRows());
                System.out.println("Num food rows: " + response.getNumRows());
                System.out.println("Start food row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    foodWareHouseInspection = new FoodWareHouseInspection();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("AFA_FCD_Warhsechecklist_ID".equalsIgnoreCase(field.getColumn()))
                            foodWareHouseInspection.setAFA_FD_FOOD_WAREHOUSE_Inspection_ID(field.getStringValue());


                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            foodWareHouseInspection.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            foodWareHouseInspection.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            foodWareHouseInspection.setNameOfApplicant(field.getStringValue());

                        else if ("AFA_FCD_Fooddepot_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            foodWareHouseInspection.setFoodWarehouselicence(field.getStringValue());

                    }
                    db.insertFoodWareHouseInspection(foodWareHouseInspection);
                    foodWareHouseInspectionArrayList.add(foodWareHouseInspection);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }



    protected String getFoodProcessingLicence(String licenceNumber) {

        String licenceDocumentNumber = "";

        db.open();

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryFoodProcessingLicence");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("AFA_FCD_ManufPlantReg_ID", licenceNumber);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("food processing licence rows: " + response.getTotalRows());
                System.out.println("Num food processing licence rows: " + response.getNumRows());
                System.out.println("Start food processinglicence row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            licenceDocumentNumber = field.getStringValue();
                        }
                    }

                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception food processing licence " + e.getMessage());
        } finally {
            db.close();
        }
        return licenceDocumentNumber;

    }

    private void getPyrethrumChecklistInspection() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryPyrethrumInspection");
        ws.setLogin(getLogin());

        DataRow data = new DataRow();
        data.addField("IsApproved", "N");
        data.addField("Processing", "N");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<PyrethrumInspectionChecklist> PyrethrumInspectionArrayList = new ArrayList<>();

        PyrethrumInspectionChecklist pyrethrumInspectionChecklist = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
//                db.deletePyrethrum();
                System.out.println("Total Pyrethrum  rows: " + response.getTotalRows());
                System.out.println("Num Pyrethrum rows: " + response.getNumRows());
                System.out.println("Start Pyrethrum row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    pyrethrumInspectionChecklist = new PyrethrumInspectionChecklist();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_PD_Inspect_Processor_ID".equalsIgnoreCase(field.getColumn())) {
                            pyrethrumInspectionChecklist.setaFA_PD_Inspect_Processor_ID(field.getStringValue());
                            System.out.println("AFA_PD_Inspect_Processor_ID " + field.getColumn());
                        } else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            pyrethrumInspectionChecklist.setDocument_number(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            pyrethrumInspectionChecklist.setDocument_date(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            pyrethrumInspectionChecklist.setName_of_applicant(field.getStringValue());

                        else if ("AFA_PD_Pyrethrum_Nsry_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            pyrethrumInspectionChecklist.setCertificate_number(field.getStringValue());


                    }
                    db.insertPyretrumInspection(pyrethrumInspectionChecklist);
                    PyrethrumInspectionArrayList.add(pyrethrumInspectionChecklist);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getCoffeeNurseryInspection() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryNuserryCertificateInspection");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();
        data.addField("Processing", "N");
        data.addField("IsApproved", "N");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<CoffeeNursercertInsp> CoffeeNursercertInspArrayList = new ArrayList<>();

        CoffeeNursercertInsp coffeeNursercertInsp = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
//                db.deletenurseryinspections();
                System.out.println("Total cofee nursery rows: " + response.getTotalRows());
                System.out.println("Num cofee nursery rows: " + response.getNumRows());
                System.out.println("Start cofee nursery row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    coffeeNursercertInsp = new CoffeeNursercertInsp();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        if ("AFA_CD_NurseryInspection_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeNursercertInsp.setAfa_cd_inspection_id(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            coffeeNursercertInsp.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            coffeeNursercertInsp.setDocumentaDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeNursercertInsp.setApplicantName(field.getStringValue());

                        else if ("AFA_CD_NurseryRegistration_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeNursercertInsp.setCertificateNumber(field.getStringValue());

                        else if ("SPD_County_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeNursercertInsp.setCounty(field.getStringValue());

                        else if ("SPD_SubCounty_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeNursercertInsp.setSub_county(field.getStringValue());

                        else if ("location".equalsIgnoreCase(field.getColumn()))
                            coffeeNursercertInsp.setLocation(field.getStringValue());

                        else if ("sublocation".equalsIgnoreCase(field.getColumn()))
                            coffeeNursercertInsp.setSub_location(field.getStringValue());

                        else if ("village".equalsIgnoreCase(field.getColumn()))
                            coffeeNursercertInsp.setVillage(field.getStringValue());

                        else if ("titledeed".equalsIgnoreCase(field.getColumn()))
                            coffeeNursercertInsp.setTitleDeed(field.getStringValue());

                        else if ("nurserycategory".equalsIgnoreCase(field.getColumn()))
                            coffeeNursercertInsp.setNurserycategory(field.getStringValue());

                    }

                    CoffeeNursercertInspArrayList.add(coffeeNursercertInsp);
                    db.insertcoffeerecords(coffeeNursercertInsp);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected void getTeaWarehouseManInspection() {

        QueryDataRequest webs = new QueryDataRequest();
        webs.setWebServiceType("QueryTeaWarehouseMan");
        webs.setLogin(getLogin());
        //webs.setLimit(3);
        //webs.setOffset(3);
        DataRow data = new DataRow();
        data.addField("iswarehouseman", "Y");
        data.addField("Processing", "N");
        data.addField("IsApproved", "N");
        webs.setDataRow(data);
        data.addField("iswarehouseman", "Y");
        webs.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<TeaWarehouseManInspectionDataCollection> teaWarehouseManArrayList = new ArrayList<>();

        TeaWarehouseManInspectionDataCollection teaWarehouseManInspection = null;
        try {
            WindowTabDataResponse response = client.sendRequest(webs);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println("Response Message" + response.getErrorMessage());
            } else {
//                db.deleteTeaWarehouseManInspection();
                System.out.println("Total warehouse rows: " + response.getTotalRows());
                System.out.println("Num  warehouse rows: " + response.getNumRows());
                System.out.println("Start warehouse row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    teaWarehouseManInspection = new TeaWarehouseManInspectionDataCollection();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Tea Warehouseman Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_TD_Inspection_Checklist_ID".equalsIgnoreCase(field.getColumn()))
                            teaWarehouseManInspection.setAFA_TD_Warehousemanlicappl_ID(field.getStringValue());
                        if ("AFA_TD_Inspection_Checklist_ID".equalsIgnoreCase(field.getColumn()))
                            teaWarehouseManInspection.setAFA_TD_Warehousemanlicappl_ID(field.getStringValue());
                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            teaWarehouseManInspection.setDocument_number(field.getStringValue());
                            System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        } else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            teaWarehouseManInspection.setName_of_applicant(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            teaWarehouseManInspection.setDocument_date(field.getStringValue());
                        else if ("afa_td_warehousemanlicappl".equalsIgnoreCase(field.getColumn())) {
                            System.out.println("afa_td_warehousemanlicappl" + field.getStringValue());
                            teaWarehouseManInspection.setLicense_number(getTeaWarehouseManLicence(field.getStringValue()));
                        }


                    }
                    System.out.println("Number of Tea WarehouseMan Inspections " + teaWarehouseManArrayList.size());
                    db.insertTeaWarehouseManInspection(teaWarehouseManInspection);
                    teaWarehouseManArrayList.add(teaWarehouseManInspection);
                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception warehouseman " + e.getMessage());
        }


    }

    protected String getTeaWarehouseManLicence(String licenceNumber) {

        String licenceDocumentNumber = "";

        db.open();

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryTeaWarehouseManLicence");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("AFA_TD_Warehousemanlicappl_ID", licenceNumber);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("Total tea warehouseman licence rows: " + response.getTotalRows());
                System.out.println("Num tea warehouseman licence rows: " + response.getNumRows());
                System.out.println("Start tea warehouseman licence row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            licenceDocumentNumber = field.getStringValue();
                        }
                    }

                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception tea warehouseman licence " + e.getMessage());
        } finally {
            db.close();
        }
        return licenceDocumentNumber;

    }

    /*protected void getTeaBuyerImporterExporter() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryTeaBuyerImporterExporter");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("Name", "%%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<TeaBuyerImporterExporterDetails> teaBuyerImporterExporterDetailsArrayList = new ArrayList<>();

        TeaBuyerImporterExporterDetails teaBuyerImporterExporterDetails = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                db.deleteTeaWarehouseManInspection();
                System.out.println("Total rows: " + response.getTotalRows());
                System.out.println("Num rows: " + response.getNumRows());
                System.out.println("Start row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    teaBuyerImporterExporterDetails = new TeaBuyerImporterExporterDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_TD_IM_EX_Porter_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            teaBuyerImporterExporterDetails.setAFA_TD_Inspection_Checklist_ID(field.getStringValue());
                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            teaBuyerImporterExporterDetails.setDocumentNumber(field.getStringValue());
                            System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        } else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            teaBuyerImporterExporterDetails.setApplicantName(field.getStringValue());
                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            teaBuyerImporterExporterDetails.setDocumentDate(field.getStringValue());
                        else if ("AFA_TD_IM_EX_Porter_Lic_ID".equalsIgnoreCase(field.getColumn())) {
                            System.out.println("AFA_TD_IM_EX_Porter_Lic_ID" + field.getStringValue());
                            teaBuyerImporterExporterDetails.setLicenseNumber(field.getStringValue());
                        }
                    }
                    db.insertTeaBuyerImporterExporter(teaBuyerImporterExporterDetails);
                    teaBuyerImporterExporterDetailsArrayList.add(teaBuyerImporterExporterDetails);
                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Exception eeeee " + e.getMessage());
        }

    }*/

    protected void getPulpingStationLicenseApplication() {

        db.open();

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryPulpingStationLicenseApplication");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("IsApproved", "N");
        data.addField("Processing", "N");

        ws.setDataRow(data);


        WebServiceConnection client = getClient();

        ArrayList<PulpingStationLicenseApplicationDetails> pulpingStationLicenseApplicationDetailsArrayList = new ArrayList<>();

        PulpingStationLicenseApplicationDetails pulpingStationLicenseApplicationDetails = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
//                db.deletePulpingStationLicenseApplication();
                System.out.println("Total pulping rows: " + response.getTotalRows());
                System.out.println("Num pulping rows: " + response.getNumRows());
                System.out.println("Start pulping row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    pulpingStationLicenseApplicationDetails = new PulpingStationLicenseApplicationDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_CD_Pulp_Ate_Checklist_ID".equalsIgnoreCase(field.getColumn()))
                            pulpingStationLicenseApplicationDetails.setAFA_CD_Pulp_Ate_Checklist_ID(field.getStringValue());
                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            pulpingStationLicenseApplicationDetails.setDocumentNumber(field.getStringValue());
                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            pulpingStationLicenseApplicationDetails.setApplicantName(field.getStringValue());
                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            pulpingStationLicenseApplicationDetails.setDocumentDate(field.getStringValue());
                        else if ("AFA_CD_Pulpstation_Letter_ID".equalsIgnoreCase(field.getColumn())) {
                            System.out.println("AFA_CD_Pulpstation_Letter_ID" + field.getStringValue());
                            pulpingStationLicenseApplicationDetails.setAuthorityToErectNumber(field.getStringValue());
                        }

                    }


                    db.insertPulpStationLicenseApplication(pulpingStationLicenseApplicationDetails);
                    System.out.println("Number of PulpStationLicenseApplication " + pulpingStationLicenseApplicationDetailsArrayList.size());
                    pulpingStationLicenseApplicationDetailsArrayList.add(pulpingStationLicenseApplicationDetails);
                    System.out.println();
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception eeeee " + e.getMessage());
        } finally {
            db.close();
        }

    }

    protected void getCoffeePulpingLicenceApllPLS() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCoffeePSLLicenceAppPSL");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("IsApproved", "N");
        data.addField("Processing", "N");
        ws.setDataRow(data);


        WebServiceConnection client = getClient();

        ArrayList<CoffeePulpinglicenceApllPSL> coffeePulpinglicenceApllPSLArrayList = new ArrayList<>();

        CoffeePulpinglicenceApllPSL coffeePulpinglicenceApllPSL = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
//                db.deletecoffeePulpingPSLrecords();
                System.out.println("Total pulping psl rows: " + response.getTotalRows());
                System.out.println("Num pulping psl rows: " + response.getNumRows());
                System.out.println("Start pulping psl row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    coffeePulpinglicenceApllPSL = new CoffeePulpinglicenceApllPSL();
                    System.out.println("pulping psl Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println(" pulping psl Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_CD_Psl_Checklist_ID".equalsIgnoreCase(field.getColumn()))
                            coffeePulpinglicenceApllPSL.setAfa_cd_PSL_id(field.getStringValue());
                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            coffeePulpinglicenceApllPSL.setDocument_number(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            coffeePulpinglicenceApllPSL.setVisited_date(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            coffeePulpinglicenceApllPSL.setName_of_applicant(field.getStringValue());

                        else if ("AFA_CD_Pulpstation_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            coffeePulpinglicenceApllPSL.setLicence_number(field.getStringValue());

                        else if ("ateboardapprovaldate".equalsIgnoreCase(field.getColumn()))
                            coffeePulpinglicenceApllPSL.setDateApprovedByTheBoard(field.getStringValue());

                        else if ("coffeearea".equalsIgnoreCase(field.getColumn()))
                            coffeePulpinglicenceApllPSL.setAreaUnderCoffee(field.getStringValue());

                        else if ("pulpmachinetype".equalsIgnoreCase(field.getColumn()))
                            coffeePulpinglicenceApllPSL.setPulpingMachine(field.getStringValue());

                        System.out.println("Numer of coffeePulpinglicenceApllPSL " + coffeePulpinglicenceApllPSLArrayList.size());
                    }

                    coffeePulpinglicenceApllPSLArrayList.add(coffeePulpinglicenceApllPSL);
                    db.insertcoffeePulpingPSLrecords(coffeePulpinglicenceApllPSL);
                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception eeeee " + e.getMessage());
        }

    }

    protected void getCoffeeGrowerMarketingAgent() {

        //LoginRequest loginRequest= params[0];
        //db.deleteSugarmillLicenceInspection();
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCoffeeGrowerMarketingChecklist");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("IsApproved", "N");
        data.addField("Processing", "N");
        ws.setDataRow(data);


        WebServiceConnection client = getClient();

        ArrayList<CoffeeGrowerMarketingAgentDetails> coffeeGrowerMarketingAgentDetailsArrayList = new ArrayList<>();

        CoffeeGrowerMarketingAgentDetails coffeeGrowerMarketingAgentDetails = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
//                db.deleteCoffeeGrowerMarketingAgent();
                System.out.println("Total Coffee Grower rows: " + response.getTotalRows());
                System.out.println("Num Coffee Grower rows: " + response.getNumRows());
                System.out.println("Start Coffee Grower row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    coffeeGrowerMarketingAgentDetails = new CoffeeGrowerMarketingAgentDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_CD_Growermarkchecklist_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeGrowerMarketingAgentDetails.setAFA_CD_Growermarkchecklist_ID(field.getStringValue());
                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            coffeeGrowerMarketingAgentDetails.setDocumentNumber(field.getStringValue());
                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            coffeeGrowerMarketingAgentDetails.setDocumentDate(field.getStringValue());
                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeGrowerMarketingAgentDetails.setApplicantName(field.getStringValue());
                        else if ("AFA_CD_CommMarketReg_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeGrowerMarketingAgentDetails.setLicenceNumber(field.getStringValue());

                        System.out.println("Number of coffee grower marketing agent" + coffeeGrowerMarketingAgentDetailsArrayList.size());
                    }
                    coffeeGrowerMarketingAgentDetailsArrayList.add(coffeeGrowerMarketingAgentDetails);
                    db.insertCoffeeGrowerMarketingAgent(coffeeGrowerMarketingAgentDetails);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception eeeee " + e.getMessage());
        }
    }

    protected void getCoffeeExporterDealerInspection() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCoffeeExporterDealerInspection");
        ws.setLogin(getLogin());

        DataRow data = new DataRow();
        data.addField("IsApproved", "N");
        data.addField("Processing", "N");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<CoffeeExporterDealerInspectionDetails> coffeeExporterDealerInspectionDetailsArrayList = new ArrayList<>();

        CoffeeExporterDealerInspectionDetails coffeeExporterDealerInspectionDetails = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println("Coffee Export Dealer " + response.getErrorMessage());
            } else {
//                db.deleteCoffeeExporterDealerInspection();
                System.out.println("Total Coffee Export Dealer rows: " + response.getTotalRows());
                System.out.println("Num Coffee Export Dealer rows: " + response.getNumRows());
                System.out.println("Start Coffee Export Dealer row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    coffeeExporterDealerInspectionDetails = new CoffeeExporterDealerInspectionDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_CD_DealerChecklist_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeExporterDealerInspectionDetails.setAFA_CD_DealerChecklist_ID(field.getStringValue());
                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            coffeeExporterDealerInspectionDetails.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            coffeeExporterDealerInspectionDetails.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeExporterDealerInspectionDetails.setApplicantName(field.getStringValue());

                        else if ("AFA_CD_ExporterDealerReg_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeExporterDealerInspectionDetails.setDealerLicenceNumber(field.getStringValue());

                        System.out.println("Number of coffeeExporterDealerInspectionDetails" + coffeeExporterDealerInspectionDetailsArrayList.size());
                    }
                    coffeeExporterDealerInspectionDetailsArrayList.add(coffeeExporterDealerInspectionDetails);
                    db.insertCoffeeExporterDealerInspection(coffeeExporterDealerInspectionDetails);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception Coffee Export Dealer " + e.getMessage());
        }
    }

    protected void getCoffeemarketingManagementAgents() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCoffeeCommericalMarketingAgent");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();
        data.addField("Processing", "N");
        data.addField("IsApproved", "N");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<CoffeeCommercialAgent> coffeeCommercialAgentArrayList = new ArrayList<>();

        CoffeeCommercialAgent coffeeCommercialAgent = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deletecommercialagentlistdata();
                System.out.println("Total coffee commercial rows: " + response.getTotalRows());
                System.out.println("Num coffee commercial rows: " + response.getNumRows());
                System.out.println("Start coffee commercial row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    coffeeCommercialAgent = new CoffeeCommercialAgent();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("CommercialQueryColumn: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_CD_CommMarkChecklist_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeCommercialAgent.setAfa_cd_Coffee_Commercial_mkt_Agent_id(field.getStringValue());


                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            coffeeCommercialAgent.setDocument_number(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            coffeeCommercialAgent.setDocument_date(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeCommercialAgent.setName_of_applicant(field.getStringValue());

                        else if ("AFA_CD_CommMarketReg_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeCommercialAgent.setLicence_number(field.getStringValue());


                    }
                    coffeeCommercialAgentArrayList.add(coffeeCommercialAgent);
                    db.insertCoffeeCommercialAgentrecords(coffeeCommercialAgent);
                    System.out.println("commercialTotalItems" + coffeeCommercialAgentArrayList.size());

                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("commercial Exception eeeee " + e.getMessage());
        }


    }

    private void getFlowersConsolidators() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryHorticulturalFlowerconsolidators");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");

        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<FlowersConsolidators> FlowersConsolidatorsArrayList = new ArrayList<>();

        FlowersConsolidators flowersConsolidators = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteHCDFlowersConsolidatorsdata();
                System.out.println("Total hcd flower cons rows: " + response.getTotalRows());
                System.out.println("Num hcd flower cons rows: " + response.getNumRows());
                System.out.println("Start hcd flowercons row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    flowersConsolidators = new FlowersConsolidators();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("AFA_HC_Flower_Cnslclst_ID".equalsIgnoreCase(field.getColumn()))
                            flowersConsolidators.setAfa_flower_Consolidators_Checklist_id(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            flowersConsolidators.setDocument_number(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            flowersConsolidators.setDocument_date(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            flowersConsolidators.setName_of_applicant(field.getStringValue());

                        else if ("AFA_HC_Export_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            flowersConsolidators.setExport_licence(field.getStringValue());

                        else if ("EMail".equalsIgnoreCase(field.getColumn()))
                            flowersConsolidators.setEmail(field.getStringValue());

                        else if ("physicaladdr".equalsIgnoreCase(field.getColumn()))
                            flowersConsolidators.setPostal_address(field.getStringValue());

                        else if ("tel".equalsIgnoreCase(field.getColumn()))
                            flowersConsolidators.setTelephone(field.getStringValue());


                    }
                    FlowersConsolidatorsArrayList.add(flowersConsolidators);
                    db.insertFlowerConslodatorsAgentrecords(flowersConsolidators);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected void getHorticultureNurseryInspectionChecklist() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryNurseryInspectionChecklist");
        ws.setLogin(getLogin());

        DataRow data = new DataRow();
        data.addField("IsApproved", "N");
        data.addField("Processing", "N");


        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<HorticultureNurseryInspectionDetails> horticultureNurseryInspectionDetailsArrayList = new ArrayList<>();

        HorticultureNurseryInspectionDetails horticultureNurseryInspectionDetails = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteHCDNurseryInspection();
                System.out.println("Total Horticulture Nursery Inspection rows: " + response.getTotalRows());
                System.out.println("Num Horticulture Nursery Inspection rows: " + response.getNumRows());
                System.out.println("Start Horticulture Nursery Inspection row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    horticultureNurseryInspectionDetails = new HorticultureNurseryInspectionDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_HC_Nursery_Insp_ID".equalsIgnoreCase(field.getColumn()))
                            horticultureNurseryInspectionDetails.setAFA_HC_Nursery_Insp_ID(field.getStringValue());
                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            horticultureNurseryInspectionDetails.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            horticultureNurseryInspectionDetails.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            horticultureNurseryInspectionDetails.setNameOfApplicant(field.getStringValue());

                        else if ("AFA_HC_NurseryRegistration_ID".equalsIgnoreCase(field.getColumn()))
                            horticultureNurseryInspectionDetails.setNurseryLicence(field.getStringValue());

                        System.out.println("Number of horticultureNurseryInspectionDetailsArrayList" + horticultureNurseryInspectionDetailsArrayList.size());
                    }

                    horticultureNurseryInspectionDetailsArrayList.add(horticultureNurseryInspectionDetails);
                    db.insertNurseryInspection(horticultureNurseryInspectionDetails);
                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception eeeee " + e.getMessage());
        }

    }

    protected void getHorticultureParkhouseWarehouseInspection() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryHorticulturalExportLicenseParkhouse");
        ws.setLogin(getLogin());

        DataRow data = new DataRow();
        data.addField("IsApproved", "N");
        data.addField("Processing", "N");


        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<HCDParkhouseWarehouseDetails> horticultureProduceTransportationDetailsArrayList = new ArrayList<>();

        HCDParkhouseWarehouseDetails horticultureProduceTransportationDetails = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteparkhouseWarehouse();
                System.out.println("Total Horticulture Packhouse Warehouse rows: " + response.getTotalRows());
                System.out.println("Num Horticulture Packhouse Warehouse rows: " + response.getNumRows());
                System.out.println("Start Horticulture Packhouse Warehouse row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    horticultureProduceTransportationDetails = new HCDParkhouseWarehouseDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("AFA_HC_Packhouse_Insp_ID".equalsIgnoreCase(field.getColumn()))
                            horticultureProduceTransportationDetails.setAFA_HC_Packhouse_Insp_ID(field.getStringValue());
                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            horticultureProduceTransportationDetails.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            horticultureProduceTransportationDetails.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            horticultureProduceTransportationDetails.setNameOfApplicant(field.getStringValue());

                        else if ("AFA_HC_Export_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            horticultureProduceTransportationDetails.setLicenceNumber(field.getStringValue());

                        System.out.println("Number of horticultureProduceTransportationDetailsArrayList" + horticultureProduceTransportationDetailsArrayList.size());
                    }

                    horticultureProduceTransportationDetailsArrayList.add(horticultureProduceTransportationDetails);
                    db.insertParkhouseWarehouseInspection(horticultureProduceTransportationDetails);
                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception eeeee " + e.getMessage());
        }

    }

    protected void getHorticultureProduceTransportationChecklist() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryHorticulturalProduceTransportation");
        ws.setLogin(getLogin());

        DataRow data = new DataRow();
        data.addField("IsApproved", "N");
        data.addField("Processing", "N");


        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<HorticultureProduceTransportationDetails> horticultureProduceTransportationDetailsArrayList = new ArrayList<>();

        HorticultureProduceTransportationDetails horticultureProduceTransportationDetails = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteHorticultureProduceTransportation();
                System.out.println("Total Horticulture Produce Transportation rows: " + response.getTotalRows());
                System.out.println("Num Horticulture Produce Transportation rows: " + response.getNumRows());
                System.out.println("Start Horticulture Produce Transportation row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    horticultureProduceTransportationDetails = new HorticultureProduceTransportationDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_HC_Produce_Trans_Insp_ID".equalsIgnoreCase(field.getColumn()))
                            horticultureProduceTransportationDetails.setAFA_HC_Produce_Trans_Insp_ID(field.getStringValue());
                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            horticultureProduceTransportationDetails.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            horticultureProduceTransportationDetails.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            horticultureProduceTransportationDetails.setNameOfApllicant(field.getStringValue());

                        else if ("AFA_HC_Export_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            horticultureProduceTransportationDetails.setExportLicence(field.getStringValue());

                        System.out.println("Number of horticultureProduceTransportationDetailsArrayList" + horticultureProduceTransportationDetailsArrayList.size());
                    }

                    horticultureProduceTransportationDetailsArrayList.add(horticultureProduceTransportationDetails);
                    db.insertHorticultureProduceTransportation(horticultureProduceTransportationDetails);
                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception eeeee " + e.getMessage());
        }

    }

    protected void getHorticultureFruitsAndVegetablesExporters() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryFruitsAndVegetablesExporters");
        ws.setLogin(getLogin());

        DataRow data = new DataRow();
        data.addField("IsApproved", "N");
        data.addField("Processing", "N");


        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<FruitsAndVegetablesExporters> fruitsAndVegetablesExportersArrayList = new ArrayList<>();

        FruitsAndVegetablesExporters fruitsAndVegetablesExporters = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteFruitsAndVegetablesExportersList();
                System.out.println("Total Horticultural Fruits And Vegetebles rows: " + response.getTotalRows());
                System.out.println("Num Horticultural Fruits And Vegetebles rows: " + response.getNumRows());
                System.out.println("Start Horticultural Fruits And Vegetebles row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    fruitsAndVegetablesExporters = new FruitsAndVegetablesExporters();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_HC_Fruitsvege_expoclst_ID".equalsIgnoreCase(field.getColumn()))
                            fruitsAndVegetablesExporters.setaFA_HCD_Fruits_Vegetables_Exporterse_ID(field.getStringValue());
                        else if ("AFA_HC_Export_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            fruitsAndVegetablesExporters.setExportLicence(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            fruitsAndVegetablesExporters.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            fruitsAndVegetablesExporters.setNameOfApplicant(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            fruitsAndVegetablesExporters.setDocumentNumber(field.getStringValue());

                        System.out.println("Number of horticultureCropExportLicenceFarmInspectionDetails" + fruitsAndVegetablesExportersArrayList.size());
                    }

                    fruitsAndVegetablesExportersArrayList.add(fruitsAndVegetablesExporters);
                    db.insertFruitsAndVegetablesExporters(fruitsAndVegetablesExporters);
                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception eeeee " + e.getMessage());
        }

    }

    private void getFruitsConsolidators() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryHorticulturalFruitconsolidators");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");

        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<HCDFruitVegetableConsolidators> fruitsConsolidatorsArrayList = new ArrayList<>();

        HCDFruitVegetableConsolidators fruitsConsolidators = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteHCDFruitVegetableConsolidatorsList();
                System.out.println("Total hcd fruits cons rows: " + response.getTotalRows());
                System.out.println("Num hcd fruits cons rows: " + response.getNumRows());
                System.out.println("Start hcd fruits cons row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    fruitsConsolidators = new HCDFruitVegetableConsolidators();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("AFA_HC_Fruit_Vegechcklst_ID".equalsIgnoreCase(field.getColumn()))
                            fruitsConsolidators.setAFA_HCD_Fruit_Vegetable_Consolidators_ID(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            fruitsConsolidators.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            fruitsConsolidators.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            fruitsConsolidators.setNameOfApplicant(field.getStringValue());

                        else if ("AFA_HC_Export_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            fruitsConsolidators.setExportLicence(field.getStringValue());

                    }
                    fruitsConsolidatorsArrayList.add(fruitsConsolidators);
                    db.insertHCDFruitVegetableConsolidators(fruitsConsolidators);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void getAvocadoQualityInspection() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryAvocadoQualityInspection");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");

        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<AvocadoQualityInspection> avocadoQualityInspectionArrayList = new ArrayList<>();

        AvocadoQualityInspection avocadoQualityInspection = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteAvocadoQualityInspection();
                System.out.println("Total hcd avocado rows: " + response.getTotalRows());
                System.out.println("Num hcd avocado rows: " + response.getNumRows());
                System.out.println("Start hcd avocado row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    avocadoQualityInspection = new AvocadoQualityInspection();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("AFA_HC_Avocadochecklist_ID".equalsIgnoreCase(field.getColumn()))
                            avocadoQualityInspection.setAFA_HCD_Avocado_Quality_Inspection_ID(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            avocadoQualityInspection.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            avocadoQualityInspection.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            avocadoQualityInspection.setNameOfApplicant(field.getStringValue());

                        else if ("AFA_HC_Inspectionreq_ID".equalsIgnoreCase(field.getColumn()))
                            avocadoQualityInspection.setHorticultureExporterRequest(field.getStringValue());

                    }
                    avocadoQualityInspectionArrayList.add(avocadoQualityInspection);
                    System.out.println("Avocado Document Number = " + avocadoQualityInspection.getDocumentNumber());

                    db.insertHCDAvocadoQualityInspection(avocadoQualityInspection);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void getMangoQualityInspection() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryMangoQualityInspection");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");

        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<MangoQualityInspection> mangoQualityInspectionArrayList = new ArrayList<>();

        MangoQualityInspection mangoQualityInspection = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteMangoQualityInspection();
                System.out.println("Total hcd mango rows: " + response.getTotalRows());
                System.out.println("Num hcd mango rows: " + response.getNumRows());
                System.out.println("Start hcd mango row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    mangoQualityInspection = new MangoQualityInspection();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("AFA_HC_Mangochecklist_ID".equalsIgnoreCase(field.getColumn()))
                            mangoQualityInspection.setAFA_Mango_Quality_Inspection_ID(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            mangoQualityInspection.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            mangoQualityInspection.setDocumentdate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            mangoQualityInspection.setExportersName(field.getStringValue());

                        else if ("AFA_HC_Inspectionreq_ID".equalsIgnoreCase(field.getColumn()))
                            mangoQualityInspection.setInspectionRequestNo(field.getStringValue());

                    }
                    mangoQualityInspectionArrayList.add(mangoQualityInspection);
                    db.insertMangoQualityInspection(mangoQualityInspection);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected void getHorticulturalFlowerExportersDeskVetting() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryFlowerExportersDeskVetting");
        ws.setLogin(getLogin());

        DataRow data = new DataRow();
        data.addField("IsApproved", "N");
        data.addField("Processing", "N");


        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<HorticulturalFlowerExportersDeskVettingDetails> horticulturalFlowerExportersDeskVettingDetailsArrayList = new ArrayList<>();

        HorticulturalFlowerExportersDeskVettingDetails horticulturalFlowerExportersDeskVettingDetails = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteHorticulturalFlowerExportersDeskVetting();
                System.out.println("Total Horticultural Flower Exporter rows: " + response.getTotalRows());
                System.out.println("Num Horticultural Flower Exporter rows: " + response.getNumRows());
                System.out.println("Start Horticultural Flower Exporter row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    horticulturalFlowerExportersDeskVettingDetails = new HorticulturalFlowerExportersDeskVettingDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_HC_flower_Exptchcklst_ID".equalsIgnoreCase(field.getColumn()))
                            horticulturalFlowerExportersDeskVettingDetails.setAFA_HC_flower_Exptchcklst_ID(field.getStringValue());
                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            horticulturalFlowerExportersDeskVettingDetails.setDocument_number(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            horticulturalFlowerExportersDeskVettingDetails.setDocument_date(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            horticulturalFlowerExportersDeskVettingDetails.setName_of_applicant(field.getStringValue());

                        else if ("AFA_HC_Export_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            horticulturalFlowerExportersDeskVettingDetails.setExport_licence(field.getStringValue());

                        System.out.println("Number of horticulturalFlowerExportersDeskVettingDetails" + horticulturalFlowerExportersDeskVettingDetailsArrayList.size());
                    }

                    horticulturalFlowerExportersDeskVettingDetailsArrayList.add(horticulturalFlowerExportersDeskVettingDetails);
                    db.insertHorticulturalFlowerExportersDeskVetting(horticulturalFlowerExportersDeskVettingDetails);
                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception eeeee " + e.getMessage());
        }

    }

    protected void getHorticultureCropExportLicenceFarmInspection() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryHorticulturalCropsExportLicense");
        ws.setLogin(getLogin());

        DataRow data = new DataRow();
        data.addField("IsApproved", "N");
        data.addField("Processing", "N");


        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<HorticultureCropExportLicenceFarmInspectionDetails> horticultureCropExportLicenceFarmInspectionDetailsArrayList = new ArrayList<>();

        HorticultureCropExportLicenceFarmInspectionDetails horticultureCropExportLicenceFarmInspectionDetails = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteHorticultureCropExportLicenceFarmInspection();
                System.out.println("Total Horticultural Crop Farm rows: " + response.getTotalRows());
                System.out.println("Num Horticultural Crop Farm rows: " + response.getNumRows());
                System.out.println("Start Horticultural Crop Farm row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    horticultureCropExportLicenceFarmInspectionDetails = new HorticultureCropExportLicenceFarmInspectionDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_HC_Export_Farm_Insp_ID".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setAFA_HC_Export_Farm_Insp_ID(field.getStringValue());

                        else if ("SPD_County_ID".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setCountyId(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setNameOfApplicant(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setDocumentNumber(field.getStringValue());

                        else if ("isexporterfarm".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setIsExporterOwnFarm(field.getStringValue());

                        else if ("iscontractedfarm".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setIsContractedSources(field.getStringValue());

                        else if ("farmname".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setFarmName(field.getStringValue());

                        else if ("farmername".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setFarmerName(field.getStringValue());

                        else if ("farmerno".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setFarmerIdNumber(field.getStringValue());

                        else if ("tel".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setTelephone(field.getStringValue());

                        else if ("EMail".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setFarmerEmail(field.getStringValue());

                        else if ("farmercounty".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setFarmerCounty(field.getStringValue());

                        else if ("location".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setLocation(field.getStringValue());

                        else if ("farmerloc".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setFarmerLocation(field.getStringValue());

                        else if ("crop".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setIntendedCrop(field.getStringValue());

                        else if ("acrerage".equalsIgnoreCase(field.getColumn()))
                            horticultureCropExportLicenceFarmInspectionDetails.setAcreageUnderCrop(field.getStringValue());

                        System.out.println("Number of horticultureCropExportLicenceFarmInspectionDetails" + horticultureCropExportLicenceFarmInspectionDetailsArrayList.size());
                    }

                    horticultureCropExportLicenceFarmInspectionDetailsArrayList.add(horticultureCropExportLicenceFarmInspectionDetails);
                    db.insertHorticultureCropExportLicenceFarmInspection(horticultureCropExportLicenceFarmInspectionDetails);
                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception eeeee " + e.getMessage());
        }

    }

    private void getSisalFactoryInspection() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QuerySisalFactoryInspection");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");

        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<SisalFactoryInspection> sisalFactoryInspectionArrayList = new ArrayList<>();

        SisalFactoryInspection sisalFactoryInspection = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteSisalFactoryInspectionList();
                System.out.println("Total hcd sisal factory rows: " + response.getTotalRows());
                System.out.println("Num hcd sisal factory rows: " + response.getNumRows());
                System.out.println("Start hcd sisal factory row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    sisalFactoryInspection = new SisalFactoryInspection();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("AFA_FD_Sisal_Fact_Insp_ID".equalsIgnoreCase(field.getColumn()))
                            sisalFactoryInspection.setAFA_Sisal_Factory_Inspection_ID(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            sisalFactoryInspection.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            sisalFactoryInspection.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            sisalFactoryInspection.setNameOfApplicant(field.getStringValue());

                        else if ("AFA_FD_Sisal_Fact_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            sisalFactoryInspection.setSisalSpinningExportNumber(getSisalFactoryInspectionLicence(field.getStringValue()));

                    }
                    sisalFactoryInspectionArrayList.add(sisalFactoryInspection);
                    db.insertFCDSisalFactoryInspection(sisalFactoryInspection);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void getSisalSpinningFactoryInspection() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QuerySisalSpinningFactoryInspection");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");

        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<SisalSpinningFactoryInspection> sisalSpinningFactoryInspectionArrayList = new ArrayList<>();

        SisalSpinningFactoryInspection sisalSpinningFactoryInspection = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteSisalSpinningFactoryInspectionList();
                System.out.println("Total hcd sisal spinning factory rows: " + response.getTotalRows());
                System.out.println("Num hcd sisal spinning factory rows: " + response.getNumRows());
                System.out.println("Start hcd sisal spinning factory row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    sisalSpinningFactoryInspection = new SisalSpinningFactoryInspection();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("AFA_FD_Sisal_Spin_Insp_ID".equalsIgnoreCase(field.getColumn()))
                            sisalSpinningFactoryInspection.setAFA_Sisal_Spinning_Factory_Inspection_ID(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            sisalSpinningFactoryInspection.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            sisalSpinningFactoryInspection.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            sisalSpinningFactoryInspection.setNameOfApplicant(field.getStringValue());

                        else if ("AFA_FD_Sisal_Spin_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            sisalSpinningFactoryInspection.setSisalSpinningExportNumber(getSisalSpinningFactoryInspectionLicence(field.getStringValue()));

                    }
                    sisalSpinningFactoryInspectionArrayList.add(sisalSpinningFactoryInspection);
                    db.insertSisalSpinningFactoryInspection(sisalSpinningFactoryInspection);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected String getSisalSpinningFactoryInspectionLicence(String licenceNumber) {

        String licenceDocumentNumber = "";

        db.open();

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QuerySisalSpinningInspectionLicence");
        ws.setLogin(getLogin());

        DataRow data = new DataRow();
        data.addField("AFA_FD_Sisal_Spin_Lic_ID", licenceNumber);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("Total sisal Spinning inspection licence rows: " + response.getTotalRows());
                System.out.println("Num sisal Spinning inspection licence rows: " + response.getNumRows());
                System.out.println("Start sisal Spinning inspection licence row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            licenceDocumentNumber = field.getStringValue();
                        }
                    }

                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception sisal factory inspection licence " + e.getMessage());
        } finally {
            db.close();
        }
        return licenceDocumentNumber;

    }


    protected String getSisalFactoryInspectionLicence(String licenceNumber) {

        String licenceDocumentNumber = "";

        db.open();

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QuerySisalFactoryInspectionLicence");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("AFA_FD_Sisal_Fact_Lic_ID", licenceNumber);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("Total sisal factory inspection licence rows: " + response.getTotalRows());
                System.out.println("Num sisal factory inspection licence rows: " + response.getNumRows());
                System.out.println("Start sisal factory inspection licence row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            licenceDocumentNumber = field.getStringValue();
                        }
                    }

                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception sisal factory inspection licence " + e.getMessage());
        } finally {
            db.close();
        }
        return licenceDocumentNumber;

    }

    private void getCottonBuyingStoreInspection() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCottonBuyingStoreInspection");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");

        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<CottonBuyingStoreInspection> cottonBuyingStoreInspectionArrayList = new ArrayList<>();

        CottonBuyingStoreInspection cottonBuyingStoreInspection = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteCottonBuyingStoreInspectionList();
                System.out.println("Total cotton buying store rows: " + response.getTotalRows());
                System.out.println("Num cotton buying store rows: " + response.getNumRows());
                System.out.println("Start cotton buying store row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    cottonBuyingStoreInspection = new CottonBuyingStoreInspection();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("AFA_FD_Cotton_BS_Insp_ID".equalsIgnoreCase(field.getColumn()))
                            cottonBuyingStoreInspection.setAFA_Cotton_Buying_Store_Inspection_ID(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            cottonBuyingStoreInspection.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            cottonBuyingStoreInspection.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            cottonBuyingStoreInspection.setNameOfApplicant(field.getStringValue());

                        else if ("AFA_FD_Seed_Buyer_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            cottonBuyingStoreInspection.setCottonExportNumber(field.getStringValue());

                    }
                    cottonBuyingStoreInspectionArrayList.add(cottonBuyingStoreInspection);
                    db.insertCottonBuyingStoreInspection(cottonBuyingStoreInspection);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void getCottonGinneryInspection() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCottonGinneryInspection");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");

        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<CottonGinneryInspection> cottonGinneryInspectionArrayList = new ArrayList<>();

        CottonGinneryInspection cottonGinneryInspection = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteCottonGinneryInspectionList();
                System.out.println("Total cotton ginnery store rows: " + response.getTotalRows());
                System.out.println("Num cotton ginnery store rows: " + response.getNumRows());
                System.out.println("Start cotton ginnery store row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    cottonGinneryInspection = new CottonGinneryInspection();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("AFA_FD_Cotton_Gin_Insp_ID".equalsIgnoreCase(field.getColumn()))
                            cottonGinneryInspection.setAFA_Cotton_Ginnery_Inspection_ID(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            cottonGinneryInspection.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            cottonGinneryInspection.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            cottonGinneryInspection.setNameOfApplicant(field.getStringValue());

                        else if ("AFA_FD_Ginning_License_ID".equalsIgnoreCase(field.getColumn()))
                            cottonGinneryInspection.setGinningLicence(getCottonGinneryInspectionLicence(field.getStringValue()));

                    }
                    cottonGinneryInspectionArrayList.add(cottonGinneryInspection);
                    db.insertCottonGinneryInspection(cottonGinneryInspection);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected String getCottonGinneryInspectionLicence(String licenceNumber) {

        String licenceDocumentNumber = "";

        db.open();

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCottonGinneryInspectionLicence");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        data.addField("AFA_FD_Ginning_License_ID", licenceNumber);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("Total Cotton Ginnery Inspection licence rows: " + response.getTotalRows());
                System.out.println("Num Cotton Ginnery Inspection licence rows: " + response.getNumRows());
                System.out.println("Start Cotton Ginnery Inspection licence row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            licenceDocumentNumber = field.getStringValue();
                        }
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception Cotton Ginnery Inspection licence " + e.getMessage());
        } finally {
            db.close();
        }
        return licenceDocumentNumber;
    }

    private void getCottonLintClassingReport() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCottonLintClassingReport");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");

        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<CottonLintClassingReport> cottonLintClassingReportArrayList = new ArrayList<>();

        CottonLintClassingReport cottonLintClassingReport = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deleteCottonLintClassingReportList();
                System.out.println("Total cotton lint classing report rows: " + response.getTotalRows());
                System.out.println("Num cotton lint classing report rows: " + response.getNumRows());
                System.out.println("Start cotton lint classing report row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    cottonLintClassingReport = new CottonLintClassingReport();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("AFA_FD_Lint_Clssngreport1_ID".equalsIgnoreCase(field.getColumn()))
                            cottonLintClassingReport.setAFA_Cotton_Lint_Classing_Report_ID(field.getStringValue());

                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            cottonLintClassingReport.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            cottonLintClassingReport.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            cottonLintClassingReport.setNameOfApplicant(field.getStringValue());

                        else if ("AFA_FD_Cottonlint_Clssng_ID".equalsIgnoreCase(field.getColumn()))
                            cottonLintClassingReport.setLintLicence(field.getStringValue());

                    }
                    cottonLintClassingReportArrayList.add(cottonLintClassingReport);
                    db.insertCottonLintClassingReport(cottonLintClassingReport);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected void getCountry() {


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

                        db.createCountry(country.getName(), country.getC_country_id());
                    }
                    // countryArrayList.add(country);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void getSubCounty() {
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

                            db.insertSubCounty(city.getSubCountyName(), city.getSubCountyId(), city.getCountyId());
                        }

                    }
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // return cityArrayList;

    }

    protected void getSugarCompany() {


        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QuerySugarMiller");
        ws.setLogin(getLogin());
        //ws.setLimit(3);
        //ws.setOffset(3);

        DataRow data = new DataRow();
        //data.addField("Name", "%%");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
        // db.deleteAllRecord("sugar_company");

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
                            db.insertSugarCompany(cbPartner.getName(), cbPartner.getC_bpartner_id());

                        }
                    }
                    countryArrayList.add(cbPartner);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void getProducts() {

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
                System.out.println("Total rows: " + response.getTotalRows());
                System.out.println("Num rows: " + response.getNumRows());
                System.out.println("Start row: " + response.getStartRow());
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

                        db.insertProduct(product.getName(), product.getProductID());
                    }
                    countryArrayList.add(product);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void getCities() {

        db.open();


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
                System.out.println("Total rows: " + response.getTotalRows());
                System.out.println("Num rows: " + response.getNumRows());
                System.out.println("Start row: " + response.getStartRow());
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


                        db.createCity(city.getName(), city.getC_city_id());
                    }
                    ;
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }


    }

    protected void getCoffeeMillerLicenseApplication() {

        db.open();

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCoffeeMillerLicenseApplication");
        ws.setLogin(getLogin());

        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<CoffeeMillerLicenceApplicationDetails> coffeeMillerLicenceApplicationDetailsArrayList = new ArrayList<>();

        CoffeeMillerLicenceApplicationDetails coffeeMillerLicenceApplicationDetails = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());

            } else {
//                db.deleteCoffeeMillerLicenseApplication();
                System.out.println("Total coffee miller rows: " + response.getTotalRows());
                System.out.println("Num coffee miller rows: " + response.getNumRows());
                System.out.println("Start coffee miller row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    coffeeMillerLicenceApplicationDetails = new CoffeeMillerLicenceApplicationDetails();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_CD_Millerrchecklist_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeMillerLicenceApplicationDetails.setAFA_CD_Millerrchecklist_ID(field.getStringValue());
                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            coffeeMillerLicenceApplicationDetails.setDocumentNumber(field.getStringValue());
                            System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        } else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeMillerLicenceApplicationDetails.setApplicantName(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeMillerLicenceApplicationDetails.setC_BPartner_ID(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            coffeeMillerLicenceApplicationDetails.setDocumentDate(field.getStringValue());
                        else if ("AFA_CD_Millerregistration_ID".equalsIgnoreCase(field.getColumn())) {
                            System.out.println("AFA_CD_Millerregistration_ID" + field.getStringValue());
                            coffeeMillerLicenceApplicationDetails.setLicenceNumber(field.getStringValue());
                        }

                        System.out.println("Number of CoffeeMillerLicenseApplication " + coffeeMillerLicenceApplicationDetailsArrayList.size());
                    }
                    db.insertCoffeeMillerLicenseApplication(coffeeMillerLicenceApplicationDetails);
                    coffeeMillerLicenceApplicationDetailsArrayList.add(coffeeMillerLicenceApplicationDetails);
                    System.out.println();
                }

                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception eeeee " + e.getMessage());
        } finally {
            db.close();
        }
    }

    protected void getCoffeemanagementAgent() {

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCoffeeManagementAgent");
        ws.setLogin(getLogin());


        DataRow data = new DataRow();
        data.addField("IsApproved", "N");
        data.addField("Processing", "N");
//        data.addField("Processing", "N");
        ws.setDataRow(data);


        WebServiceConnection client = getClient();


        CoffeeManagementAgentInsp coffeeManagementAgentInsp = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

//                db.deletecoffeeManagementAgentrecords();
                System.out.println("Total coffee management rows: " + response.getTotalRows());
                System.out.println("Num coffee management rows: " + response.getNumRows());
                System.out.println("Start coffee management row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    coffeeManagementAgentInsp = new CoffeeManagementAgentInsp();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Coffee Management Column: " + field.getColumn() + " = " + field.getStringValue());

                        if ("AFA_CD_Mgtagentchcklist_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeManagementAgentInsp.setAFA_CD_Mgtagentchcklist_ID_Coffee(field.getStringValue());
                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            coffeeManagementAgentInsp.setDocumnet_number(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            coffeeManagementAgentInsp.setDocument_date(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeManagementAgentInsp.setC_BPartner_ID(field.getStringValue());

                        else if ("AFA_CD_Mgt_Agent_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            coffeeManagementAgentInsp.setLicence_no(field.getStringValue());

                        else if ("principal_office".equalsIgnoreCase(field.getColumn()))
                            coffeeManagementAgentInsp.setPrincipal_office(field.getStringValue());

//                        System.out.println("Numer of cofffee mang agent " + CoffeeManagementAgentInspArrayList.size());
                    }

                    db.insertcoffeeManagementAgentrecords(coffeeManagementAgentInsp);

                    System.out.println();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception eeeee " + e.getMessage());
        }

    }

    private Notification buildNotification(Context context, String title, String content, Intent intent) {

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        return new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true).build();
    }

    private void showNotification(Context context, int notificationID, Notification notification) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(notificationID, notification);
    }

    private void trigerNotification(String input){
        Intent intent = new Intent(context, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        Notification notification = buildNotification(context, input + " New Inspection Pending", "You have a new inspection pending. please log into the app to view", intent);
        showNotification(context, this.notificationID, notification);
    }

    public WebServiceConnection getClient() {
        WebServiceConnection client = new WebServiceConnection();
        client.setAttempts(3);
        client.setTimeout(5000);
        client.setAttemptsTimeout(5000);
        client.setUrl(uri);
        client.setAppName("Java Test WS Client");
        return client;
    }

    public LoginRequest getLogin() {

        LoginRequest login = new LoginRequest();
        login.setUser("brisk.afa.mobile@gmail.com");
        login.setPass("abc123");
        login.setClientID(1000000);
        login.setRoleID(1000000);
        login.setOrgID(1000000);
        login.setWarehouseID(1000000);
        return login;
    }

}