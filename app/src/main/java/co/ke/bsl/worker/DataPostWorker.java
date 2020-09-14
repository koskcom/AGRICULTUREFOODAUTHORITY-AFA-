package co.ke.bsl.worker;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.idempiere.webservice.client.base.DataRow;
import org.idempiere.webservice.client.base.Enums;
import org.idempiere.webservice.client.base.Field;
import org.idempiere.webservice.client.base.LoginRequest;
import org.idempiere.webservice.client.net.WebServiceConnection;
import org.idempiere.webservice.client.request.CreateDataRequest;
import org.idempiere.webservice.client.request.QueryDataRequest;
import org.idempiere.webservice.client.request.UpdateDataRequest;
import org.idempiere.webservice.client.response.StandardResponse;
import org.idempiere.webservice.client.response.WindowTabDataResponse;

import java.net.InetAddress;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.HCDColdRoomTemperatures;
import co.ke.bsl.data.model.HCDPersonalHygene;
import co.ke.bsl.data.view.SurveyTypeView;
import co.ke.bsl.pojo.AvocadoQualityInspection;
import co.ke.bsl.pojo.AvocadoQualityInspectionOilContent;
import co.ke.bsl.pojo.CBPartner;
import co.ke.bsl.pojo.CaneCensusCropDetails;
import co.ke.bsl.pojo.CaneCensusDataCollection;
import co.ke.bsl.pojo.CaneCensusFarmer;
import co.ke.bsl.pojo.City;
import co.ke.bsl.pojo.CoffeeExporterDealerInspectionDetails;
import co.ke.bsl.pojo.CoffeeCommercialAgent;
import co.ke.bsl.pojo.CoffeeGrowerMarketingAgentDetails;
import co.ke.bsl.pojo.CoffeeManagementAgentInsp;
import co.ke.bsl.pojo.CoffeeMillerLicenceApplicationDetails;
import co.ke.bsl.pojo.CoffeeMillingTariffs;
import co.ke.bsl.pojo.CoffeeNursercertInsp;
import co.ke.bsl.pojo.CoffeePulpinglicenceApllPSL;
import co.ke.bsl.pojo.CottonBuyingStoreInspection;
import co.ke.bsl.pojo.CottonGinneryInspection;
import co.ke.bsl.pojo.CottonLintClassingReport;
import co.ke.bsl.pojo.Country;
import co.ke.bsl.pojo.County;
import co.ke.bsl.pojo.FOodCropInspection;
import co.ke.bsl.pojo.FoodProcessingInpection;
import co.ke.bsl.pojo.FoodWareHouseInspection;
import co.ke.bsl.pojo.FruitsAndVegetablesExporters;
import co.ke.bsl.pojo.HCDFruitVegetableConsolidators;
import co.ke.bsl.pojo.HCDParkhouseWarehouseDetails;
import co.ke.bsl.pojo.HorticulturalCropsColdStorageIn;
import co.ke.bsl.pojo.HorticulturalCropsColdStorageOut;
import co.ke.bsl.pojo.HorticulturalCropsColdStorageRegister;
import co.ke.bsl.pojo.HorticultureCropExportLicenceFarmInspectionDetails;
import co.ke.bsl.pojo.HorticultureNurseryInspectionDetails;
import co.ke.bsl.pojo.HorticulturalFlowerExportersDeskVettingDetails;
import co.ke.bsl.pojo.FlowersConsolidators;
import co.ke.bsl.pojo.HorticultureProduceTransportationDetails;
import co.ke.bsl.pojo.MangoQualityInspection;
import co.ke.bsl.pojo.NOCDMarketPriceSurveyDetails;
import co.ke.bsl.pojo.Product;
import co.ke.bsl.pojo.PulpingStationLicenseApplicationDetails;
import co.ke.bsl.pojo.PyrethrumInspectionChecklist;
import co.ke.bsl.pojo.RetailLooseSugarPricesRangeImported;
import co.ke.bsl.pojo.RetailLooseSugarPricesRangeLocal;
import co.ke.bsl.pojo.RetailStockedSugarPricesRangeImported;
import co.ke.bsl.pojo.RetailStockedSugarPricesRangeLocal;
import co.ke.bsl.pojo.RetailSugarPricesRangeLocal;
import co.ke.bsl.pojo.Shop;
import co.ke.bsl.pojo.SisalFactoryInspection;
import co.ke.bsl.pojo.SisalSpinningFactoryInspection;
import co.ke.bsl.pojo.SubCounty;
import co.ke.bsl.pojo.SugarMillDetails;
import co.ke.bsl.pojo.TeaBuyerImporterExporterDetails;
import co.ke.bsl.pojo.TeaPackerChecklist;
import co.ke.bsl.pojo.TeaWarehouseManInspectionDataCollection;
import co.ke.bsl.pojo.User;
import co.ke.bsl.pojo.WholeSaleBrandLocal;
import co.ke.bsl.pojo.WholeSaleImportedStockedSugar;
import co.ke.bsl.pojo.WholeSaleImportedSugar;
import co.ke.bsl.pojo.WholeSaleStockedBrandLocal;

import static co.ke.bsl.AFA.getApp;

public class DataPostWorker extends Worker {

    private static final String WORK_RESULT = "work_result";
    Context context = getApplicationContext();
    String uri = context.getString(R.string.baseURI);
    AFADatabaseAdapter db;
    ArrayList<County> countyArrayList = new ArrayList<>();
    ArrayList<Product> productArrayList = new ArrayList<>();
    ArrayList<City> cityArrayList = new ArrayList<>();
    ArrayList<Country> CountryList = new ArrayList<>();
    ArrayList<SurveyTypeView> List = new ArrayList<>();
    AFA app;

    ArrayList<SubCounty> subCountyArrayList = new ArrayList<>();

    public DataPostWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }


    @NonNull
    @Override
    public Worker.Result doWork() {
        //read input argument

        if (isInternetAvailable()) {

            try {

                String workType = getInputData().getString("workType");
                Log.i("refresh cpn work", "type of work request: " + workType);

                System.out.println("-----------------------Updating Data-----------------------" + workType);


                //appState = (ApplicationState) getApplication();


                db = new AFADatabaseAdapter(getApplicationContext());
                app = (AFA) getApp();


                //    System.out.println("----------------------postCensusDataCollection--------------------");
                postCensusDataCollection();

                //  System.out.println("--------------------end--postCensusDataCollection--------------------");
                postCaneCensusFarmer();
                postCaneCensusCropDetails();


                postShopDate();
                postWholeSaleStockedBrandLocalPrice();
                postWholeSaleImportedStockedSugar();
                postWholeSaleImportedSugarBrandPrice();

                postWholeSaleLocalSugarBrandPrice();


                postRetailLooseSugarPricesRangeImported();

                postRetailLooseSugarPricesRangeLocal();

                postRetailStockedSugarPricesRangeImported();


                postRetailStockedSugarPricesRangeLocal();

                postCoffeeMillingTariffs();


                //  System.out.println("---------------------DOne-------------------");

                postRetailSugarPricesRangeLocal();

                deleteAllHeaderSent();

                 System.out.println("----------------------sugarmillDataCollection--------------------");

                List<SugarMillDetails> sugarMillDetailsList = db.getSugarMillDetailInspectionDone();

                for (int k = 0; k < sugarMillDetailsList.size(); k++) {

                    SugarMillDetails sugarMillDetails = sugarMillDetailsList.get(k);

                    System.out.println("Record ID to push " + sugarMillDetails.getLocalID());
                    postSugarMillLLicencecomplianceRecords(sugarMillDetails);
                }

                 System.out.println("----------------------Coffee Nursery Certificate Field Inspection Checklist-------------------");

                List<CoffeeNursercertInsp> coffeeNursercertInsplist = db.getCoffeeNursercertInspDone();

                for (int k = 0; k < coffeeNursercertInsplist.size(); k++) {

                    CoffeeNursercertInsp coffeeNursercertInspList = coffeeNursercertInsplist.get(k);

                    System.out.println("Nursery Record ID to push " + coffeeNursercertInspList.getLocalID());
                    postCoffeRecords(coffeeNursercertInspList);
                }

                  System.out.println("----------------------pyrethrum Inspection--------------------");

                List<PyrethrumInspectionChecklist> pyrethrumInspectionList = db.getPyrethrumInspectionDone();
                for (int k = 0; k < pyrethrumInspectionList.size(); k++) {

                    PyrethrumInspectionChecklist pyrethrumInspectionChecklist = pyrethrumInspectionList.get(k);

                    System.out.println("Record ID to push " + pyrethrumInspectionChecklist.getLocalID());
                    postPyretrhumInspectionRecords(pyrethrumInspectionChecklist);
                }

                  System.out.println("--------------------start--postTeaWarehouseManInspectionRecords--------------------");


                List<TeaWarehouseManInspectionDataCollection> teaWarehouseManDetailsList = db.getTeaWarehouseManInspectionDoneList();

                for (int k = 0; k < teaWarehouseManDetailsList.size(); k++) {

                    TeaWarehouseManInspectionDataCollection teaWarehouseManDetails = teaWarehouseManDetailsList.get(k);

                    System.out.println("Record warehouseman ID to push " + teaWarehouseManDetails.getLocalID());
                    postTeaWarehouseManInspectionRecords(teaWarehouseManDetails);
                }


                  System.out.println("----------------------PulpStation ATE INSPECTION--------------------");

                List<PulpingStationLicenseApplicationDetails> pulpStationLicenseApplicationDetailsList = db.getPulpingStationLicenseApplicationDoneList();

                for (int k = 0; k < pulpStationLicenseApplicationDetailsList.size(); k++) {

                    PulpingStationLicenseApplicationDetails pulpingStationLicenseApplicationDetails = pulpStationLicenseApplicationDetailsList.get(k);

                    System.out.println("Record ID to push " + pulpingStationLicenseApplicationDetails.getLocalID());
                    postPulpingStationLicenseApplicationRecords(pulpingStationLicenseApplicationDetails);
                }

                   System.out.println("----------------------Teapacker INSPECTION--------------------");

                List<TeaPackerChecklist> teaPackerChecklistlist = db.getTeaPackerChecklistDone();

                for (int k = 0; k < teaPackerChecklistlist.size(); k++) {

                    TeaPackerChecklist teaPackerChecklist = teaPackerChecklistlist.get(k);

                    System.out.println("teaPackerRecord ID to push " + teaPackerChecklist.getLocalID());
                    postTeaPackerRecords(teaPackerChecklist);
                }

                 System.out.println("----------------------Pulping Station Licence Application (PSL) Checklist-------------------");

                List<CoffeePulpinglicenceApllPSL> coffeePulpinglicenceApllPSLlist = db.getCoffeePulpinglicenceApllPSLDone();

                for (int k = 0; k < coffeePulpinglicenceApllPSLlist.size(); k++) {

                    CoffeePulpinglicenceApllPSL coffeePulpinglicenceApllPSL = coffeePulpinglicenceApllPSLlist.get(k);

                    System.out.println("Record ID to push " + coffeePulpinglicenceApllPSL.getLocalID());
                    postcoffeePulpinglicenceApllPSLRecords(coffeePulpinglicenceApllPSL);
                }

                  System.out.println("----------------------Coffee Management License Inspection-------------------");

                List<CoffeeManagementAgentInsp> coffeeManagementAgentInspLlist = db.getCoffeeManagementAgentInspDone();

                for (int k = 0; k < coffeeManagementAgentInspLlist.size(); k++) {

                    CoffeeManagementAgentInsp coffeeManagementAgentInsp = coffeeManagementAgentInspLlist.get(k);

                    System.out.println("Record ID to push " + coffeeManagementAgentInsp.getLocalID());
                    postcoffeeManagementAgentRecords(coffeeManagementAgentInsp);
                }

                 System.out.println("----------------------Coffee Miller Licence Inspection Checklist-------------------");

                List<CoffeeMillerLicenceApplicationDetails> coffeeMillerLicenceApplicationDetailsList = db.getCoffeeMillerLicenseApplicationDoneList();

                for (int k = 0; k < coffeeMillerLicenceApplicationDetailsList.size(); k++) {

                    CoffeeMillerLicenceApplicationDetails coffeeMillerLicenceApplicationDetails = coffeeMillerLicenceApplicationDetailsList.get(k);

                    System.out.println("Record ID to push " + coffeeMillerLicenceApplicationDetails.getLocalID());
                    postCoffeeMillerLicenceApplication(coffeeMillerLicenceApplicationDetails);
                }


                 System.out.println("----------------------Coffee Grower Marketing Agent Checklist-------------------");

                List<CoffeeGrowerMarketingAgentDetails> coffeeGrowerMarketingAgentDetailsList = db.getCoffeeGrowerMarketingAgentDetailsDoneList();

                for (int k = 0; k < coffeeGrowerMarketingAgentDetailsList.size(); k++) {

                    CoffeeGrowerMarketingAgentDetails coffeeGrowerMarketingAgentDetails = coffeeGrowerMarketingAgentDetailsList.get(k);

                    System.out.println("Record ID to push " + coffeeGrowerMarketingAgentDetails.getLocalID());
                    postCoffeeGrowerMarketingAgent(coffeeGrowerMarketingAgentDetails);
                }


                 System.out.println("----------------------Coffee Exporter Dealer Inspection Checklist-------------------");

                List<CoffeeExporterDealerInspectionDetails> coffeeExporterDealerInspectionDetailsList = db.getCoffeeExporterDealerInspectionDetailsDoneList();

                for (int k = 0; k < coffeeExporterDealerInspectionDetailsList.size(); k++) {

                    CoffeeExporterDealerInspectionDetails coffeeExporterDealerInspectionDetails = coffeeExporterDealerInspectionDetailsList.get(k);

                    System.out.println("Record ID to push " + coffeeExporterDealerInspectionDetails.getLocalID());
                    postCoffeeExporterDealerInspection(coffeeExporterDealerInspectionDetails);
                }

                   System.out.println("---------------------- Coffee Commercial marketing Agent Checklist-------------------");

                List<CoffeeCommercialAgent> coffeeCommercialAgentLlist = db.getCoffeeCommercialAgentDone();

                for (int k = 0; k < coffeeCommercialAgentLlist.size(); k++) {

                    CoffeeCommercialAgent coffeeCommercialAgent = coffeeCommercialAgentLlist.get(k);

                    System.out.println("Record ID to push " + coffeeCommercialAgent.getLocalID());
                    postcoffeeCommercialAgentRecords(coffeeCommercialAgent);
                }

                   System.out.println("---------------------- Horticulture Nursery Inspection Checklist -------------------");

                List<HorticultureNurseryInspectionDetails> horticultureNurseryInspectionDetailsList = db.getNurseyInspectionDone();

                for (int k = 0; k < horticultureNurseryInspectionDetailsList.size(); k++) {

                    HorticultureNurseryInspectionDetails horticultureNurseryInspectionDetails = horticultureNurseryInspectionDetailsList.get(k);

                    System.out.println("Record ID to push " + horticultureNurseryInspectionDetails.getAFA_HC_Nursery_Insp_ID());
                    postHorticultureNurseryInspection(horticultureNurseryInspectionDetails);
                }

                   System.out.println("---------------------- Horticulture Produce Transportation Checklist -------------------");

                List<HorticultureProduceTransportationDetails> horticultureProduceTransportationDetailsList = db.getHorticultureProduceTransportationDetailsDoneList();

                for (int k = 0; k < horticultureProduceTransportationDetailsList.size(); k++) {

                    HorticultureProduceTransportationDetails horticultureProduceTransportationDetails = horticultureProduceTransportationDetailsList.get(k);

                    System.out.println("Record ID to push " + horticultureProduceTransportationDetails.getAFA_HC_Produce_Trans_Insp_ID());
                    postHorticultureProduceTransportation(horticultureProduceTransportationDetails);
                }

                  System.out.println("---------------------- Horticulture Packhouse Warehouse Inspection -------------------");

                List<HCDParkhouseWarehouseDetails> hcdParkhouseWarehouseDetailsList = db.getParkhouseWarehouseDone();

                for (int k = 0; k < hcdParkhouseWarehouseDetailsList.size(); k++) {

                    HCDParkhouseWarehouseDetails hcdParkhouseWarehouseDetails = hcdParkhouseWarehouseDetailsList.get(k);

                    System.out.println("Record ID to push " + hcdParkhouseWarehouseDetails.getAFA_HC_Packhouse_Insp_ID());
                    postHorticulturePackhouseWarehouse(hcdParkhouseWarehouseDetails);
                }


                 System.out.println("---------------------- Horticultural Crops Export License Farm Inspection Checklist -------------------");

                List<HorticultureCropExportLicenceFarmInspectionDetails> horticultureCropExportLicenceFarmInspectionDetailsList = db.getHorticultureCropExportLicenceFarmInspectionDetailsDoneList();

                for (int k = 0; k < horticultureCropExportLicenceFarmInspectionDetailsList.size(); k++) {
                    HorticultureCropExportLicenceFarmInspectionDetails horticultureCropExportLicenceFarmInspectionDetails = horticultureCropExportLicenceFarmInspectionDetailsList.get(k);

                    System.out.println("Record ID to push " + horticultureCropExportLicenceFarmInspectionDetails.getAFA_HC_Export_Farm_Insp_ID());
                    postHorticultureCropExportLicenceFarmInspectionDetails(horticultureCropExportLicenceFarmInspectionDetails);
                }

                 System.out.println("----------------------Horticultural Flower consolidators-------------------");

                List<FlowersConsolidators> flowersConsolidatorslist = db.getFlowersConsolidatorsDone();

                for (int k = 0; k < flowersConsolidatorslist.size(); k++) {

                    FlowersConsolidators flowersConsolidatorsList = flowersConsolidatorslist.get(k);

                    System.out.println("flowersConsolidators local ID to push " + flowersConsolidatorsList.getLocalID());
                    postFlowersConsolidators(flowersConsolidatorsList);
                }

                  System.out.println("----------------------Horticultural Flower Exporters Desk-Vetting Checklist-------------------");

                List<HorticulturalFlowerExportersDeskVettingDetails> flowerExportersDeskVettingDetailsList = db.getHorticulturalFlowerExportersDeskVettingDoneList();

                for (int k = 0; k < flowerExportersDeskVettingDetailsList.size(); k++) {

                    HorticulturalFlowerExportersDeskVettingDetails flowerExportersDeskVettingDetails = flowerExportersDeskVettingDetailsList.get(k);

                    System.out.println("flowersConsolidators local ID to push " + flowerExportersDeskVettingDetails.getLocalID());
                    postHorticulturalFlowerExportersDeskVetting(flowerExportersDeskVettingDetails);
                }

                   System.out.println("----------------------Horticultural Fruit consolidators-------------------");

                List<HCDFruitVegetableConsolidators> fruitConsolidatorslist = db.getHCDFruitVegetableConsolidatorsDone();

                for (int k = 0; k < fruitConsolidatorslist.size(); k++) {

                    HCDFruitVegetableConsolidators fruitConsolidators = fruitConsolidatorslist.get(k);

                    System.out.println("FruitsConsolidators local ID to push " + fruitConsolidators.getLocalID());
                    postFruitsConsolidators(fruitConsolidators);
                }

                  System.out.println("----------------------Horticultural Fruit Exporters Desk-Vetting Checklist -------------------");

                List<FruitsAndVegetablesExporters> fruitsAndVegetablesExportersList = db.getFruitsAndVegetablesExportersDone();

                for (int k = 0; k < fruitsAndVegetablesExportersList.size(); k++) {

                    FruitsAndVegetablesExporters fruitsAndVegetablesExporters = fruitsAndVegetablesExportersList.get(k);

                    System.out.println("FruitsConsolidators local ID to push " + fruitsAndVegetablesExporters.getLocalID());
                    postFruitsAndVegetablesExporters(fruitsAndVegetablesExporters);
                }

                  System.out.println("----------------------Avocado Quality Inspection-------------------");

                List<AvocadoQualityInspection> avocadoQualityInspectionList = db.getAvocadoQualityInspectionDone();

                for (int k = 0; k < avocadoQualityInspectionList.size(); k++) {

                    AvocadoQualityInspection avocadoQualityInspection = avocadoQualityInspectionList.get(k);

                    System.out.println("FruitsConsolidators local ID to push " + avocadoQualityInspection.getLocalID());
                    postAvocadoQualityInspection(avocadoQualityInspection);
                }

                  System.out.println("----------------------Avocado Quality Inspection Oil Content-------------------");

                List<AvocadoQualityInspectionOilContent> avocadoQualityInspectionOilContentDoneList = db.getAvocadoQualityInspectionOilContentDone();

                for (int k = 0; k < avocadoQualityInspectionOilContentDoneList.size(); k++) {

                    AvocadoQualityInspectionOilContent avocadoQualityInspectionOilContent = avocadoQualityInspectionOilContentDoneList.get(k);

                    System.out.println("FruitsConsolidators local ID to push " + avocadoQualityInspectionOilContent.getLocalID());
                    postAvocadoQualityInspectionOilContent(avocadoQualityInspectionOilContent);
                }

                //  System.out.println("----------------------Mango Quality Inspection-------------------");

                List<MangoQualityInspection> mangoQualityInspectionList = db.getMangoQualityInspectionDone();

                for (int k = 0; k < mangoQualityInspectionList.size(); k++) {

                    MangoQualityInspection mangoQualityInspection = mangoQualityInspectionList.get(k);

                    System.out.println("FruitsConsolidators local ID to push " + mangoQualityInspection.getLocalID());
                    postMangoQualityInspection(mangoQualityInspection);
                }

                //   System.out.println("----------------------Personal Hygiene-------------------");

                postPersonalHygiene();
                postPersonalHygieneRecord();

                //   System.out.println("----------------------Cold Room-------------------");

                postColdRoomInspection();
                postColdRoomDetails();

                   System.out.println("----------------------Horticulture Crop Cold Storage-------------------");

                postColdStorageRegister();
                postColdStorageIn();
                postColdStorageOut();

                // System.out.println("------------------------------Nuts And Oils-------------------");

                postNOCDLocation();
                postNOCDMarketPrice();

                System.out.println("----------------------Sisal Factory Inspection-------------------");

                List<SisalFactoryInspection> sisalFactoryInspectionList = db.getSisalFactoryInspectionDone();

                for (int k = 0; k < sisalFactoryInspectionList.size(); k++) {

                    SisalFactoryInspection sisalFactoryInspection = sisalFactoryInspectionList.get(k);

                    System.out.println("Sisal Factory local ID to push " + sisalFactoryInspection.getLocalID());
                    postSisalFactoryInspection(sisalFactoryInspection);
                }


                 System.out.println("----------------------Cotton Buyer Inspection-------------------");

                List<CottonBuyingStoreInspection> cottonBuyingStoreInspectionList = db.getCottonBuyingStoreInspectionDone();

                for (int k = 0; k < cottonBuyingStoreInspectionList.size(); k++) {

                    CottonBuyingStoreInspection cottonBuyingStoreInspection = cottonBuyingStoreInspectionList.get(k);

                    System.out.println("Cotton Buying local ID to push " + cottonBuyingStoreInspection.getLocalID());
                    postCottonBuyerInspection(cottonBuyingStoreInspection);
                }

                  System.out.println("----------------------Cotton Ginnery Inspection-------------------");

                List<CottonGinneryInspection> cottonGinneryInspectinList = db.getCottonGinneryInspectionDone();

                for (int k = 0; k < cottonGinneryInspectinList.size(); k++) {

                    CottonGinneryInspection cottonGinneryInspection = cottonGinneryInspectinList.get(k);

                    System.out.println("Cotton Buying local ID to push " + cottonGinneryInspection.getLocalId());
                    postCottonGinneryInspection(cottonGinneryInspection);
                }
                 System.out.println("----------------------foodProcessingInpectionList Inspection-------------------");

                List<FoodProcessingInpection> foodProcessingInpectionList = db.getFoodProcessingInpectionDone();

                for (int k = 0; k < foodProcessingInpectionList.size(); k++) {

                    FoodProcessingInpection foodProcessingInpection = foodProcessingInpectionList.get(k);

                    System.out.println("food Processing Inpection local ID to push " + foodProcessingInpection.getLocalID());
                    postFoodProcessingInpection(foodProcessingInpection);
                }

                System.out.println("----------------------posting food warehouse Inspection-------------------");

                List<FoodWareHouseInspection> foodWareHouseInspectionList = db.getFoodWareHouseInspectionDone();

                for (int k = 0; k < foodWareHouseInspectionList.size(); k++) {

                    FoodWareHouseInspection foodWareHouseInspection = foodWareHouseInspectionList.get(k);

                    System.out.println("food food WareHouse Inspection local ID to push " + foodWareHouseInspection.getLocalID());
                    postFoodWareHouseInspection(foodWareHouseInspection);
                }

                System.out.println("----------------------posting food crop export Inspection-------------------");

                List<FOodCropInspection> fOodCropInspectionList = db.getFOodCropInspectionDone();

                for (int k = 0; k < fOodCropInspectionList.size(); k++) {

                    FOodCropInspection fOodCropInspection = fOodCropInspectionList.get(k);

                    System.out.println("food food WareHouse Inspection local ID to push " + fOodCropInspection.getLocalID());
                    postFOodCropInspection(fOodCropInspection);
                }

                System.out.println("----------------------posting Sisal Spinning-------------------");

                List<SisalSpinningFactoryInspection> sisalSpinningFactoryInspectionList = db.getSisalSpinningFactoryInspectionDone();

                for (int k = 0; k < sisalSpinningFactoryInspectionList.size(); k++) {

                    SisalSpinningFactoryInspection sisalSpinningFactoryInspection = sisalSpinningFactoryInspectionList.get(k);

                    System.out.println("sisal spinning Inspection local ID to push " + sisalSpinningFactoryInspection.getLocalID());
                    postSisalSpinningFactoryInspection(sisalSpinningFactoryInspection);
                }

                  System.out.println("----------------------Cotton Ginnery Inspection-------------------");

                List<CottonLintClassingReport> cottonLintClassingReportList = db.getCottonLintClassingReportDone();

                for (int k = 0; k < cottonLintClassingReportList.size(); k++) {

                    CottonLintClassingReport cottonLintClassingReport = cottonLintClassingReportList.get(k);

                    System.out.println("Cotton Buying local ID to push " + cottonLintClassingReport.getLocalId());
                    postCottonLintClassingReport(cottonLintClassingReport);
                }

                System.out.println("------------------------------DOne-------------------");
            } finally {
                db.closeDB();
                System.out.println("---------------------- job- ended and closed the db ----------------------");

            }


//            doWork();
            return Worker.Result.RETRY;
        }
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

    public void updateCaneCensusDataCollection(String surveyID) {

        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateCaneCensusFieldScoreDataCollection");

        System.out.println(app + "Updating survey ID " + surveyID);
        updateData.setRecordID(Integer.parseInt(surveyID));

        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("applicationdate", new Timestamp(System.currentTimeMillis()));

        //  data.addField("afa_sd_smillcliancelist_id",sugarMillDetails.getAfa_sd_smillcliancelist_id());
        // db.getSentMillerID(sugarMillDetails.getMillerID()).getServerRecordID());
        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());
//                db.updateSugarmilllicenceSent(sugarMillDetails.getLocalID(), response.getRecordID().toString());
                // db.deleteSugarmillLicenceSentRecords("sugar_Mill_licence_compliance", sugarMillDetails.getLocalID(), response.getRecordID().toString());

                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateSurvey(String surveyID) {

        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateSurvey");

        System.out.println(app + "Updating survey ID " + surveyID);
        updateData.setRecordID(Integer.parseInt(surveyID));

        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("IsApproved", "Y");
        data.addField("Processing", "Y");

        //  data.addField("afa_sd_smillcliancelist_id",sugarMillDetails.getAfa_sd_smillcliancelist_id());
        // db.getSentMillerID(sugarMillDetails.getMillerID()).getServerRecordID());
        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());
//                db.updateSugarmilllicenceSent(sugarMillDetails.getLocalID(), response.getRecordID().toString());
                // db.deleteSugarmillLicenceSentRecords("sugar_Mill_licence_compliance", sugarMillDetails.getLocalID(), response.getRecordID().toString());

                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void postShopDate() {


        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();


        List<Shop> shopList = db.getAllUnSentShop();
        System.out.println(" the shop list : " + shopList.size());

        for (int k = 0; k < shopList.size(); k++) {
            Shop shop = (Shop) shopList.get(k);


            // createData.setLogin(shop.getLoginRequest());
            // if (shop.getSentStatus() == "PENDING") {
            System.out.println(k + " Shop status: " + shop.getSentStatus() + " and the SERVER ID" + shop.getServerRecordID());
            if (!shop.getSentStatus().equalsIgnoreCase("SENT")) {
                createData.setLogin(getLogin());
                createData.setWebServiceType(shop.getServiceType());


                data.addField("wholesale_shop", shop.getName());
                data.addField("longitude", shop.getLongitude());
                data.addField("latitude", shop.getLatitude());
                //data.addField("AD_User_ID","@AD_User_ID@" );
                data.addField("AFA_SD_Sugarprices_Survey_ID", shop.getAfa_sd_sugarprices_survey_id());
                data.addField("IsApproved", "Y");
                data.addField("Processed", "Y");
                data.addField("DocAction", "CL");
                data.addField("DocStatus", "CO");
                createData.setDataRow(data);

                WebServiceConnection client = getClient();

                try {
                    if (!shop.getSentStatus().equalsIgnoreCase("SENT")) {
                        response = client.sendRequest(createData);
                    }

                    if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                        System.out.println(response.getErrorMessage());
                    } else {

                        System.out.println("RecordID: " + response.getRecordID());

                        shop.setSentStatus("SENT");
                        System.out.println();

                        boolean i1 = db.updateShopSent("shop", shop.getShopID(), response.getRecordID().toString());
                        updateSurvey(shop.getAfa_sd_sugarprices_survey_id());
                        System.out.println(" updated the sent Record: " + i1);

                        for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                            System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                        }
                        System.out.println();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void postWholeSaleLocalSugarBrandPrice() {


        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();

/*
        AFADatabaseAdapter db;


        db = new AFADatabaseAdapter(getApplicationContext()).open();*/

        WholeSaleBrandLocal wholeSaleBrandLocal = new WholeSaleBrandLocal();


        List<WholeSaleBrandLocal> wholeSaleBrandLocalList = db.getAllUnSentLocalBrand();

        for (int k = 0; k < wholeSaleBrandLocalList.size(); k++) {
            wholeSaleBrandLocal = (WholeSaleBrandLocal) wholeSaleBrandLocalList.get(k);


            createData.setLogin(getLogin());
            createData.setWebServiceType(wholeSaleBrandLocal.getServiceType());

            System.out.println("the shop id is " + wholeSaleBrandLocal.getShopID());

            Shop shop = db.getSentShopID(wholeSaleBrandLocal.getShopID());

            System.out.println("the shop id is shop.getServerRecordID() " + shop.getServerRecordID());


            data.addField("whlsllssugarprice_20kgbale", wholeSaleBrandLocal.getPriceOfTwentykgBale());
            data.addField("whlsllssugarprice_24kgbale", wholeSaleBrandLocal.getPriceOfTwentyFOurkgBale());
            data.addField("whlsllssugarprice_50kgbag", wholeSaleBrandLocal.getPriceOfFiftykgBag());
            data.addField("whlsllocalsgr_brand_own", wholeSaleBrandLocal.getBrand());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
            data.addField("AFA_SD_SGR_Surveyshops_ID", shop.getServerRecordID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());

                    db.updateRecordsSent("local_brand", wholeSaleBrandLocal.getLocalID(), response.getRecordID().toString());
                    db.deleteSentRecords("local_brand", wholeSaleBrandLocal.getLocalID(), response.getRecordID().toString());
                    db.deleteSentRecords("shop", wholeSaleBrandLocal.getLocalID(), shop.getServerRecordID().toString());
                    //int i1 = db.updateShopSent("shop", shop.getShopID(), response.getRecordID().toString());

                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        //   new AFADatabaseAdapter(getApplicationContext()).close();

    }

    public void postWholeSaleImportedSugarBrandPrice() {

        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();


   /*     AFADatabaseAdapter db;


        db = new AFADatabaseAdapter(getApplicationContext()).open();*/

        WholeSaleImportedSugar wholeSaleImportedSugar = new WholeSaleImportedSugar();


        List<WholeSaleImportedSugar> wholeSaleImportedSugarList = db.getAllUnSentLocalImportBrand();

        for (int k = 0; k < wholeSaleImportedSugarList.size(); k++) {
            wholeSaleImportedSugar = wholeSaleImportedSugarList.get(k);


            createData.setLogin(getLogin());
            createData.setWebServiceType(wholeSaleImportedSugar.getServiceType());


            data.addField("whlslimportedsugar_20kgbale", wholeSaleImportedSugar.getPriceOf20kgBale());
            data.addField("whlslimportedsugar_24kgbale", wholeSaleImportedSugar.getPriceOf24kgBale());
            data.addField("whlslimprtdsgr_cntryoforigin", wholeSaleImportedSugar.getC_country_id());
            data.addField("whlslimportedsugar_50kgbag", wholeSaleImportedSugar.getPriceOf50kgBag());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
            data.addField("AFA_SD_SGR_Surveyshops_ID", db.getSentShopID(wholeSaleImportedSugar.getShopID()).getServerRecordID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());

                    db.updateRecordsSent("local_import", wholeSaleImportedSugar.getLocalID(), response.getRecordID().toString());
                    db.deleteSentRecords("local_import", wholeSaleImportedSugar.getLocalID(), response.getRecordID().toString());

                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //  new AFADatabaseAdapter(getApplicationContext()).close();

    }

    public void postWholeSaleStockedBrandLocalPrice() {
        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();


    /*    AFADatabaseAdapter db;


        db = new AFADatabaseAdapter(getApplicationContext()).open();*/

        WholeSaleStockedBrandLocal wholeSaleStockedBrandLocal = new WholeSaleStockedBrandLocal();

        List<WholeSaleStockedBrandLocal> wholeSaleStockedBrandLocalList = db.getAllUnSentLocalBrandStocked();

        for (int k = 0; k < wholeSaleStockedBrandLocalList.size(); k++) {
            wholeSaleStockedBrandLocal = wholeSaleStockedBrandLocalList.get(k);
            createData.setLogin(getLogin());
            createData.setWebServiceType(wholeSaleStockedBrandLocal.getServiceType());


            data.addField("stknglocalsugar_20kgbale", wholeSaleStockedBrandLocal.getPriceOf20kgBale());
            data.addField("stknglocalsugar_24kgbale", wholeSaleStockedBrandLocal.getPriceOf24kgBale());
            data.addField("stcknglocalsgr_brand_own", wholeSaleStockedBrandLocal.getBrand());
            data.addField("stknglocalsugar_50kgbag", wholeSaleStockedBrandLocal.getPriceOf50kgBag());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
            data.addField("AFA_SD_SGR_Surveyshops_ID", db.getSentShopID(wholeSaleStockedBrandLocal.getShopID()).getServerRecordID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());
                    db.updateRecordsSent("local_brand_stocked", wholeSaleStockedBrandLocal.getLocalID(), response.getRecordID().toString());
                    db.deleteSentRecords("local_brand_stocked", wholeSaleStockedBrandLocal.getLocalID(), response.getRecordID().toString());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        //  new AFADatabaseAdapter(getApplicationContext()).close();


    }

    public void postWholeSaleImportedStockedSugar() {
        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();

/*
            AFADatabaseAdapter db;


            db = new AFADatabaseAdapter(getApplicationContext()).open();*/


        WholeSaleImportedStockedSugar wholeSaleImportedStockedSugar = new WholeSaleImportedStockedSugar();

        List<WholeSaleImportedStockedSugar> wholeSaleImportedStockedSugarList = db.getAllUnSentLocalImportBrandStocked();

        for (int k = 0; k < wholeSaleImportedStockedSugarList.size(); k++) {
            wholeSaleImportedStockedSugar = wholeSaleImportedStockedSugarList.get(k);

            createData.setLogin(getLogin());
            createData.setWebServiceType(wholeSaleImportedStockedSugar.getServiceType());


            data.addField("stkngimportedsugar_20kgbale", wholeSaleImportedStockedSugar.getPriceOf20kgBale());
            data.addField("stkngimportedsugar_24kgbale", wholeSaleImportedStockedSugar.getPriceOf24kgBale());
            data.addField("stckngimprtdsgr_cntryoforigin", wholeSaleImportedStockedSugar.getC_country_id());
            data.addField("stkngimportedsugar_50kgbag", wholeSaleImportedStockedSugar.getPriceOf50kgBag());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
            data.addField("AFA_SD_SGR_Surveyshops_ID", db.getSentShopID(wholeSaleImportedStockedSugar.getShopID()).getServerRecordID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());
                    db.updateRecordsSent("local_import_stocked", wholeSaleImportedStockedSugar.getLocalID(), response.getRecordID().toString());
                    db.deleteSentRecords("local_import_stocked", wholeSaleImportedStockedSugar.getLocalID(), response.getRecordID().toString());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
//           / new AFADatabaseAdapter(getApplicationContext()).close();
    }

    public void postCoffeeMillingTariffs() {
        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();
        List<CoffeeMillingTariffs> coffeeMillingTariffsList = db.getAllUnSentCoffeeMillingTariffs();

        for (int k = 0; k < coffeeMillingTariffsList.size(); k++) {
            CoffeeMillingTariffs  coffeeMillingTariffs = new CoffeeMillingTariffs();

            coffeeMillingTariffs = coffeeMillingTariffsList.get(k);


            createData.setLogin(getLogin());
            createData.setWebServiceType( coffeeMillingTariffs.getServiceType());


            data.addField("servietype",  coffeeMillingTariffs.getServiceType());
            data.addField("currency",  coffeeMillingTariffs.getCurrency());
            data.addField("justification",  coffeeMillingTariffs.getJustification());
            data.addField("AFA_CD_MILLING_TARRIFS_ID", db.getSentMillingID(coffeeMillingTariffs.getMilling_id()).getServerRecordID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());
                    db.updateMillingTariffsSent("milling_tariffs", coffeeMillingTariffs.getLocalID(), response.getRecordID().toString());
                   // db.deleteSentRecords("retail_local_brand", coffeeMillingTariffs.getLocalID(), response.getRecordID().toString());

                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
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


    public void postCensusDataCollection() {

        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();
        List<CaneCensusDataCollection> caneCensusDataCollectionist = db.getUnsentCaneCensusDataCollection();

        System.out.println(" the size of the  caneCensusDataCollectionist " + caneCensusDataCollectionist.size());

        for (int k = 0; k < caneCensusDataCollectionist.size(); k++) {
            CaneCensusDataCollection censusDataCollection = new CaneCensusDataCollection();

            censusDataCollection = caneCensusDataCollectionist.get(k);

            createData.setLogin(getLogin());
            createData.setWebServiceType(censusDataCollection.getServiceType());
            if (db.getCaneCensusServerID(censusDataCollection.getLocalID(), "miller") == null) {

                // createData.setLogin(censusDataCollection.getLoginRequest());
                // createData.setWebServiceType(censusDataCollection.getServiceType());

                System.out.println("sugar_company: companID " + censusDataCollection.getC_bpartnerID());
                System.out.println("sugar_company Longitude: " + censusDataCollection.getLongitude());
                System.out.println("sugar_company latitude: " + censusDataCollection.getLatitude());
                System.out.println("sugar_company: county " + censusDataCollection.getCountyID());
                //System.out.println("the cane sensus server ID "+db.getCaneCensusServerID(censusDataCollection.getLocalID(),"miller" ));


                data.addField("SPD_County_ID", censusDataCollection.getCountyID());
                data.addField("longitude", censusDataCollection.getLongitude());
                data.addField("latitude", censusDataCollection.getLatitude());
                //data.addField("AD_User_ID","@AD_User_ID@" );
                data.addField("sugar_company", censusDataCollection.getC_bpartnerID());
                data.addField("enumerator_name", db.getADUser().getAd_user_name());
//                data.addField("applicationdate", new Timestamp(System.currentTimeMillis()));
//                data.addField("DocAction", "CL");
//                data.addField("DocStatus", "CO");
                data.addField("Processed", "Y");

                createData.setDataRow(data);

                WebServiceConnection client = getClient();

                try {
                    response = client.sendRequest(createData);

                    if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                        System.out.println(response.getErrorMessage());
                    } else {

                        System.out.println(" sugar_company RecordID: " + response.getRecordID());
                        if (response.getRecordID() != null) {
                            System.out.println("RecordID not null: " + response.getRecordID());

                            boolean i1 = db.updateCaneCensusSent("miller", censusDataCollection.getLocalID(), response.getRecordID().toString());
                            updateCaneCensusDataCollection(String.valueOf(response.getRecordID()));
                            System.out.println(" updated the sent Record: " + i1);
                        }

                        System.out.println();

                        for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                            System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                        }
                        System.out.println();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


        }
    }


    public void postCaneCensusCropDetails() {

        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();
        List<CaneCensusCropDetails> caneCensusCropDetails = db.getUnsentCaneCensusCropDetails();

        for (int k = 0; k < caneCensusCropDetails.size(); k++) {
            CaneCensusCropDetails caneCensusCropDetail = new CaneCensusCropDetails();

            caneCensusCropDetail = caneCensusCropDetails.get(k);
            if (db.getCaneCensusServerID(caneCensusCropDetail.getLocalID(), "crop_detail") == null) {
                createData.setLogin(getLogin());
                createData.setWebServiceType(caneCensusCropDetail.getServiceType());

                System.out.println("getCropColour: " + caneCensusCropDetail.getCropColour());
                System.out.println("getCropClass: " + caneCensusCropDetail.getCropClass());
                System.out.println("getVariety: " + caneCensusCropDetail.getVariety());


                data.addField("crop_class", caneCensusCropDetail.getCropClass());
                data.addField("crop_color", Integer.parseInt(caneCensusCropDetail.getCropColour()));
                data.addField("no_of_hectares", caneCensusCropDetail.getHectares());
                data.addField("age_months", caneCensusCropDetail.getaGEmonths());
                data.addField("expected_tch", caneCensusCropDetail.getExpectedTCH());

                data.addField("crop_vigour", caneCensusCropDetail.getCropVigour());
                data.addField("crop_density", caneCensusCropDetail.getCropDensity());
                data.addField("pest_disease_weeds", caneCensusCropDetail.getPestsDiseaseWeeds());
                data.addField("AFA_SD_Canefarmerdetails_ID",
                        db.getCaneCensusServerID(caneCensusCropDetail.getParentID(), "farmer"));
                data.addField("M_Product_ID", caneCensusCropDetail.getVariety());
                createData.setDataRow(data);

                WebServiceConnection client = getClient();

                try {
                    response = client.sendRequest(createData);

                    if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                        System.out.println(response.getErrorMessage());
                    } else {

                        System.out.println("RecordID: " + response.getRecordID());
                        // if (db.getCaneCensusServerID(caneCensusCropDetail.getParentID(), "farmer") != null) {

                        db.updateCaneCensusSent("crop_detail", caneCensusCropDetail.getLocalID(), response.getRecordID().toString());
                        // db.deleteSentCensusRecords("crop_detail");
                        // }


                        System.out.println();

                        for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                            System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                        }
                        System.out.println();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        ///  db.deleteSentCensusRecords("farmer", caneCensusCropDetail.getParentID());

    }

    public void postCaneCensusFarmer() {
        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();
        List<CaneCensusFarmer> caneCensusFarmerList = db.getUnsentCaneCensusFarmer();

        for (int k = 0; k < caneCensusFarmerList.size(); k++) {
            CaneCensusFarmer caneCensusFarmer = new CaneCensusFarmer();

            caneCensusFarmer = caneCensusFarmerList.get(k);


            createData.setLogin(getLogin());
            createData.setWebServiceType(caneCensusFarmer.getServiceType());

            System.out.println("---get AFA_SD_Canecensusscore_ID: " + db.getCaneCensusServerID(caneCensusFarmer.getParentID(), "miller"));

            if (db.getCaneCensusServerID(caneCensusFarmer.getLocalID(), "farmer") == null) {


                System.out.println("getAFA_HC_Produce_Trans_Insp_ID: " + db.getCaneCensusServerID(caneCensusFarmer.getParentID(), "miller"));
                System.out.println("setCountyID: " + caneCensusFarmer.getCountyID());
                System.out.println("getSubCountyID: " + caneCensusFarmer.getSubCountyID());
                System.out.println("getFarmerName: " + caneCensusFarmer.getFarmerName());
                System.out.println("getFarmerPhoneNo: " + caneCensusFarmer.getFarmerPhoneNo());


                data.addField("SPD_County_ID", caneCensusFarmer.getCountyID());
                data.addField("gender", caneCensusFarmer.getGender());
                data.addField("idnumber", caneCensusFarmer.getIdNo());
                data.addField("famername", caneCensusFarmer.getFarmerName());
                data.addField("farmerphoneno", caneCensusFarmer.getFarmerPhoneNo());
                //data.addField("AD_User_ID","@AD_User_ID@" );
                data.addField("SPD_SubCounty_ID", caneCensusFarmer.getSubCountyID());
                data.addField("AFA_SD_Canecensusscore_ID", db.getCaneCensusServerID(caneCensusFarmer.getParentID(), "miller"));
                //data.addField("SPD_SubCounty_ID_Sub-County", censusDataCollection.getCompanyName());
                createData.setDataRow(data);

                WebServiceConnection client = getClient();

                try {
                    response = client.sendRequest(createData);

                    if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                        System.out.println(response.getErrorMessage());
                    } else {

                        System.out.println("RecordID: " + response.getRecordID());
                        System.out.println();

                        db.updateCaneCensusSent("farmer", caneCensusFarmer.getLocalID(), response.getRecordID().toString());


                        // db.deleteSentCensusRecords("farmer", caneCensusFarmer.getLocalID());

                        for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                            System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                        }
                        System.out.println();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

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


    public void postRetailLooseSugarPricesRangeLocal() {

        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();


        List<RetailLooseSugarPricesRangeLocal> retailLooseSugarPricesRangeLocalList = db.getAllUnSentRetailLooseSugarPricesRangeLocal();

        for (int k = 0; k < retailLooseSugarPricesRangeLocalList.size(); k++) {
            RetailLooseSugarPricesRangeLocal retailLooseSugarPricesRangeLocal = new RetailLooseSugarPricesRangeLocal();
            retailLooseSugarPricesRangeLocal = retailLooseSugarPricesRangeLocalList.get(k);
            createData.setLogin(getLogin());
            createData.setWebServiceType(retailLooseSugarPricesRangeLocal.getServiceType());


            data.addField("lssugarlocal_2kg", retailLooseSugarPricesRangeLocal.getLooseSugarLocal2kg());
            data.addField("lssugarlocal_1kg", retailLooseSugarPricesRangeLocal.getLooseSugarLocal1kg());
            data.addField("lssugarlocal_brand_own", retailLooseSugarPricesRangeLocal.getBrand());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());

            data.addField("AFA_SD_SGR_Surveyshops_ID", db.getSentShopID(retailLooseSugarPricesRangeLocal.getShopID()).getServerRecordID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());
                    db.updateRecordsSent("retail_loose_brand", retailLooseSugarPricesRangeLocal.getLocalID(), response.getRecordID().toString());
                    db.deleteSentRecords("retail_loose_brand", retailLooseSugarPricesRangeLocal.getLocalID(), response.getRecordID().toString());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void postRetailLooseSugarPricesRangeImported() {
        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();
        List<RetailLooseSugarPricesRangeImported> retailLooseSugarPricesRangeImportedList = db.getAllUnSentRetailLooseSugarPricesRangeImported();

        for (int k = 0; k < retailLooseSugarPricesRangeImportedList.size(); k++) {
            RetailLooseSugarPricesRangeImported retailLooseSugarPricesRangeImported = new RetailLooseSugarPricesRangeImported();

            retailLooseSugarPricesRangeImported = retailLooseSugarPricesRangeImportedList.get(k);


            createData.setLogin(getLogin());
            createData.setWebServiceType(retailLooseSugarPricesRangeImported.getServiceType());

            System.out.println("2kg sugar price" + retailLooseSugarPricesRangeImported.getLooseSugarLocal2kg());
            System.out.println("1kg sugar price" + retailLooseSugarPricesRangeImported.getLooseSugarLocal1kg());


            data.addField("lssugarimported_2kg", retailLooseSugarPricesRangeImported.getLooseSugarLocal2kg());
            data.addField("lssugarimported_1kg", retailLooseSugarPricesRangeImported.getLooseSugarLocal1kg());
            data.addField("lssugarimported_cntryoforigin", retailLooseSugarPricesRangeImported.getCountryID());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
            data.addField("AFA_SD_SGR_Surveyshops_ID", db.getSentShopID(retailLooseSugarPricesRangeImported.getShopID()).getServerRecordID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());
                    db.updateRecordsSent("retail_loose_import", retailLooseSugarPricesRangeImported.getLocalID(), response.getRecordID().toString());
                    db.deleteSentRecords("retail_loose_import", retailLooseSugarPricesRangeImported.getLocalID(), response.getRecordID().toString());

                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public void postRetailSugarPricesRangeLocal() {
        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();
        List<RetailSugarPricesRangeLocal> caneCensusFarmerList = db.getAllUnSentRetailSugarPricesRangeLocal();

        for (int k = 0; k < caneCensusFarmerList.size(); k++) {
            RetailSugarPricesRangeLocal retailSugarPricesRangeLocal = new RetailSugarPricesRangeLocal();

            retailSugarPricesRangeLocal = caneCensusFarmerList.get(k);


            createData.setLogin(getLogin());
            createData.setWebServiceType(retailSugarPricesRangeLocal.getServiceType());


            data.addField("localbrandedsugar_2kg", retailSugarPricesRangeLocal.getLooseSugarLocal2kg());
            data.addField("localbrandedsugar_1kg", retailSugarPricesRangeLocal.getLooseSugarLocal1kg());
            data.addField("localbrandedsugar_brand_own", retailSugarPricesRangeLocal.getBrand());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
            data.addField("AFA_SD_SGR_Surveyshops_ID", db.getSentShopID(retailSugarPricesRangeLocal.getShopID()).getServerRecordID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());
                    db.updateRecordsSent("retail_local_brand", retailSugarPricesRangeLocal.getLocalID(), response.getRecordID().toString());
                    db.deleteSentRecords("retail_local_brand", retailSugarPricesRangeLocal.getLocalID(), response.getRecordID().toString());

                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void postRetailStockedSugarPricesRangeLocal() {
        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();
        List<RetailStockedSugarPricesRangeLocal> retailStockedSugarPricesRangeLocalList = db.getAllUnSentRetailStockedSugarPricesRangeLocal();

        for (int k = 0; k < retailStockedSugarPricesRangeLocalList.size(); k++) {
            RetailStockedSugarPricesRangeLocal retailStockedSugarPricesRangeLocal = new RetailStockedSugarPricesRangeLocal();

            retailStockedSugarPricesRangeLocal = retailStockedSugarPricesRangeLocalList.get(k);

            createData.setLogin(getLogin());
            createData.setWebServiceType(retailStockedSugarPricesRangeLocal.getServiceType());


            System.out.println("localsugar_20kgbale" + retailStockedSugarPricesRangeLocal.getLocalSugar20kgBale());
            System.out.println("localsugar_24kgbale" + retailStockedSugarPricesRangeLocal.getLocalSugar24kgBale());

            data.addField("localsugar_20kgbale", retailStockedSugarPricesRangeLocal.getLocalSugar20kgBale());
            data.addField("localsugar_24kgbale", retailStockedSugarPricesRangeLocal.getLocalSugar24kgBale());
            data.addField("localsugar_brand_own", retailStockedSugarPricesRangeLocal.getBrand());
            data.addField("localsugar_50kgbag", retailStockedSugarPricesRangeLocal.getLocalSugar50kgBag());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
            data.addField("AFA_SD_SGR_Surveyshops_ID", db.getSentShopID(retailStockedSugarPricesRangeLocal.getShopID()).getServerRecordID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println(" getAllUnSentRetailStockedSugarPricesRangeLocal RecordID: " + response.getRecordID());

                    db.updateRecordsSent("retail_local_brand_stocked", retailStockedSugarPricesRangeLocal.getLocalID(), response.getRecordID().toString());
                    db.deleteSentRecords("retail_local_brand_stocked", retailStockedSugarPricesRangeLocal.getLocalID(), response.getRecordID().toString());

                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public void postRetailStockedSugarPricesRangeImported() {
        StandardResponse response = null;
        CreateDataRequest createData = new CreateDataRequest();
        DataRow data = new DataRow();
        List<RetailStockedSugarPricesRangeImported> retailStockedSugarPricesRangeImportedList = db.getAllUnSentRetailStockedSugarPricesRangeImported();

        for (int k = 0; k < retailStockedSugarPricesRangeImportedList.size(); k++) {
            RetailStockedSugarPricesRangeImported retailStockedSugarPricesRangeImported = new RetailStockedSugarPricesRangeImported();


            retailStockedSugarPricesRangeImported = retailStockedSugarPricesRangeImportedList.get(k);


            createData.setLogin(getLogin());
            createData.setWebServiceType(retailStockedSugarPricesRangeImported.getServiceType());

            System.out.println("importedsugar_20kgbale" + retailStockedSugarPricesRangeImported.getLocalSugar20kgBale());
            System.out.println("importedsugar_24kgbale" + retailStockedSugarPricesRangeImported.getLocalSugar24kgBale());


            data.addField("importedsugar_20kgbale", retailStockedSugarPricesRangeImported.getLocalSugar20kgBale());
            data.addField("importedsugar_24kgbale", retailStockedSugarPricesRangeImported.getLocalSugar24kgBale());
            data.addField("importedsugar_cntryoforigin", retailStockedSugarPricesRangeImported.getCountryID());
            data.addField("importedsugar_50kgbag", retailStockedSugarPricesRangeImported.getLocalSugar50kgBag());
            //data.addField("AFA_SD_Sugarprices_Survey_ID",retailLooseSugarPricesRangeLocal.getAFA_SD_SGR_Surveyshops_ID());
            data.addField("AFA_SD_SGR_Surveyshops_ID", db.getSentShopID(retailStockedSugarPricesRangeImported.getShopID()).getServerRecordID());
            createData.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createData);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());
                    db.updateRecordsSent("retail_local_import_stocked", retailStockedSugarPricesRangeImported.getLocalID(), response.getRecordID().toString());
                    db.deleteSentRecords("retail_local_import_stocked", retailStockedSugarPricesRangeImported.getLocalID(), response.getRecordID().toString());

                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public void postSugarMillLLicencecomplianceRecords(SugarMillDetails sugarMillDetails) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("updateRecords");

        System.out.println("the local ID to be pushed " + sugarMillDetails.getLocalID());

        System.out.println("getAfa_sd_smillcliancelist_id" + sugarMillDetails.getAfa_sd_smillcliancelist_id());
        System.out.println("getLocalID" + sugarMillDetails.getLocalID());
        System.out.println("getLetter_of_comfort" + sugarMillDetails.getLetter_of_comfort());
        System.out.println("getSubLocation" + sugarMillDetails.getC_BPartner_ID());
        System.out.println("getDocument_date" + sugarMillDetails.getDocument_date());
        System.out.println("list_farmers" + sugarMillDetails.getList_farmers());

        updateData.setRecordID(Integer.parseInt(sugarMillDetails.getAfa_sd_smillcliancelist_id()));


        data.addField("list_farmers", sugarMillDetails.getList_farmers());
        data.addField("list_farmers_remark", sugarMillDetails.getList_farmers_remark());
        data.addField("grower_summary", sugarMillDetails.getGrower_summary());
        data.addField("grower_summary_remark", sugarMillDetails.getGrower_summary_remark());
        data.addField("nemaweightsosha_cert", sugarMillDetails.getNemaweightsosha_cert());
        data.addField("nemaweightsosha_cert_remark", sugarMillDetails.getNemaweightsosha_cert_remark());
        data.addField("millingshedule_monthly", sugarMillDetails.getMillingshedule_monthly());
        data.addField("millingshedule_monthly_remark", sugarMillDetails.getMillingshedule_monthly_remark());
        data.addField("canecontract_samples", sugarMillDetails.getCanecontract_samples());
        data.addField("canecontract_samples_remark", sugarMillDetails.getCanecontract_samples_remark());
        data.addField("caneprodproc_plans", sugarMillDetails.getCaneprodproc_plans());
        data.addField("caneprodproc_plans_remark", sugarMillDetails.getCaneprodproc_plans_remark());
        data.addField("farmersdarreas_measure", sugarMillDetails.getFarmersdarreas_measure());
        data.addField("farmersdarreas_measure_remark", sugarMillDetails.getFarmersdarreas_measure_remark());
        data.addField("payformula_conf", sugarMillDetails.getPayformula_conf());
        data.addField("payformula_conf_remark", sugarMillDetails.getPayformula_conf_remark());
        data.addField("adhstatutorystandard", sugarMillDetails.getAdhstatutorystandard());
        data.addField("adhstatutorystandard_remark", sugarMillDetails.getAdhstatutorystandard_remark());
        data.addField("recommendation", Integer.parseInt(sugarMillDetails.getOfficerrecommendation()));
        data.addField("recommendation_remarks", sugarMillDetails.getOfficerrecommendation_remark());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");

        //  data.addField("afa_sd_smillcliancelist_id",sugarMillDetails.getAfa_sd_smillcliancelist_id());
        // db.getSentMillerID(sugarMillDetails.getMillerID()).getServerRecordID());
        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());
                db.updateSugarmilllicenceSent(sugarMillDetails.getLocalID(), response.getRecordID().toString());
                // db.deleteSugarmillLicenceSentRecords("sugar_Mill_licence_compliance", sugarMillDetails.getLocalID(), response.getRecordID().toString());

                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void postPyretrhumInspectionRecords(PyrethrumInspectionChecklist pyrethrumInspectionChecklist) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdatePyrethrumInspection");

        System.out.println("the local ID to be pushed " + pyrethrumInspectionChecklist.getLocalID());

        System.out.println("aFA_PD_Inspect_Processor_ID" + pyrethrumInspectionChecklist.getaFA_PD_Inspect_Processor_ID());
        System.out.println("getLocalID" + pyrethrumInspectionChecklist.getLocalID());
        System.out.println("is_title_deed_A" + pyrethrumInspectionChecklist.getTitle_deed());
        System.out.println("is_area_under_pyrethrum_Total" + pyrethrumInspectionChecklist.getTitle_deed_evidence());
        System.out.println("is_area_under_pyrethrum_Total" + pyrethrumInspectionChecklist.getTitle_deed_remarks());


        if (!TextUtils.isEmpty(pyrethrumInspectionChecklist.getaFA_PD_Inspect_Processor_ID()) && TextUtils.isDigitsOnly(pyrethrumInspectionChecklist.getaFA_PD_Inspect_Processor_ID())) {
            updateData.setRecordID(Integer.parseInt(pyrethrumInspectionChecklist.getaFA_PD_Inspect_Processor_ID()));
        }

        data.addField("is_title_deed", pyrethrumInspectionChecklist.getTitle_deed());
        data.addField("title_deed_evidence", pyrethrumInspectionChecklist.getTitle_deed_evidence());
        data.addField("title_deed_remarks", pyrethrumInspectionChecklist.getTitle_deed_remarks());
        data.addField("is_area_under_pyrethrum", pyrethrumInspectionChecklist.getTotal_acreage());
        data.addField("area_under_pyrethrum_evidence", pyrethrumInspectionChecklist.getTotal_acreage_evidence());
        data.addField("area_under_pyrethrum_remarks", pyrethrumInspectionChecklist.getTotal_acreage_remarks());
        data.addField("is_acreage_expansion", pyrethrumInspectionChecklist.getAcreage_available());
        data.addField("acreage_expansion_evidence", pyrethrumInspectionChecklist.getAcreage_available_evidence());
        data.addField("acreage_expansion_remarks", pyrethrumInspectionChecklist.getAcreage_available_remarks());
        data.addField("is_nursery_viable", pyrethrumInspectionChecklist.getSuitability_of_the_land());
        data.addField("nursery_viable_evidence", pyrethrumInspectionChecklist.getSuitability_of_the_land_evidence());
        data.addField("nursery_viable_remarks", pyrethrumInspectionChecklist.getSuitability_of_the_land_remarks());
        data.addField("is_water_supply", pyrethrumInspectionChecklist.getReliable_supply_clean_water());
        data.addField("water_supply_evidence", pyrethrumInspectionChecklist.getReliable_supply_clean_water_evidence());
        data.addField("water_supply_remarks", pyrethrumInspectionChecklist.getReliable_supply_clean_water_remarks());
        data.addField("is_nursery_accessible", pyrethrumInspectionChecklist.getAccessibility_of_nursery_site());
        data.addField("nursery_accessible_evidence", pyrethrumInspectionChecklist.getAccessibility_of_nursery_site_evidence());
        data.addField("nursery_accessible_remakrs", pyrethrumInspectionChecklist.getAccessibility_of_nursery_site_remarks());
        data.addField("is_clearance_letter", pyrethrumInspectionChecklist.getClearance_letter());
        data.addField("clearance_letter_evidence", pyrethrumInspectionChecklist.getClearance_letter_evidence());
        data.addField("clearance_letter_remarks", pyrethrumInspectionChecklist.getClearance_letter_remarks());
        data.addField("is_nursery_managment", pyrethrumInspectionChecklist.getDemonstrate_adequate_knowledge());
        data.addField("nursery_managerment_evidence", pyrethrumInspectionChecklist.getDemonstrate_adequate_knowledge_evidence());
        data.addField("nursery_management_remarks", pyrethrumInspectionChecklist.getDemonstrate_adequate_knowledge_remarks());
        data.addField("is_crop_age", pyrethrumInspectionChecklist.getAge_of_an_existing_crop());
        data.addField("crop_planted_remarks", pyrethrumInspectionChecklist.getAge_of_an_existing_crop_remarks());
        data.addField("is_planting_materials", pyrethrumInspectionChecklist.getSource_of_planting_materials());
        data.addField("planting_materials_evidence", pyrethrumInspectionChecklist.getSource_of_planting_materials_evidence());
        data.addField("planting_materials_remarks", pyrethrumInspectionChecklist.getSource_of_planting_materials_remarks());
        data.addField("is_phenotypic", pyrethrumInspectionChecklist.getPhenotypic_characteristics());
        data.addField("phenotypic_evidence", pyrethrumInspectionChecklist.getPhenotypic_characteristics_evidence());
        data.addField("phenotypic_remarks", pyrethrumInspectionChecklist.getPhenotypic_characteristics_remarks());
        data.addField("is_disease", pyrethrumInspectionChecklist.getDisease_incidences());
        data.addField("disease_remarks", pyrethrumInspectionChecklist.getDisease_incidences_remarks());
        data.addField("is_pests", pyrethrumInspectionChecklist.getPest_incidences());
        data.addField("pests_remarks", pyrethrumInspectionChecklist.getPest_incidences_remarks());
        data.addField("is_hygiene", pyrethrumInspectionChecklist.getField_hygiene_conditions());
        data.addField("hygiene_evidence", pyrethrumInspectionChecklist.getField_hygiene_conditions_evidence());
        data.addField("hygiene_remarks", pyrethrumInspectionChecklist.getField_hygiene_conditions_remarks());
        data.addField("is_target_market", pyrethrumInspectionChecklist.getTarget_market());
        data.addField("target_market_evidence", pyrethrumInspectionChecklist.getTarget_market_evidence());
        data.addField("target_market_remarks", pyrethrumInspectionChecklist.getTarget_market_remarks());
        data.addField("is_inspection", pyrethrumInspectionChecklist.getInspection_by_kephis());
        data.addField("inspection_evidence", pyrethrumInspectionChecklist.getInspection_by_kephis_evidence());
        data.addField("inspection_remarks", pyrethrumInspectionChecklist.getInspection_by_kephis_remarks());
        data.addField("recommendation", pyrethrumInspectionChecklist.getOfficerrecommendation());
        data.addField("recommendation_remarks", pyrethrumInspectionChecklist.getOfficerrecommendation_remark());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updatePyretrumInspectionSent(pyrethrumInspectionChecklist.getaFA_PD_Inspect_Processor_ID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void postTeaWarehouseManInspectionRecords(TeaWarehouseManInspectionDataCollection teaWarehouseMan) {

        int major = 0, minor = 0, observation = 0;

        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());

        updateData.setWebServiceType("UpdateTeaWarehouseMan");

        System.out.println("the local ID to be pushed " + teaWarehouseMan.getLocalID());

        System.out.println("AFA_TD_Inspection_Checklist_ID" + teaWarehouseMan.getAFA_TD_Warehousemanlicappl_ID());
        System.out.println("getLocalID" + teaWarehouseMan.getLocalID());
        System.out.println("getLicense_number" + teaWarehouseMan.getLicense_number());
        System.out.println("getDocument_number" + teaWarehouseMan.getDocument_number());
        System.out.println("getSubLocation" + teaWarehouseMan.getName_of_applicant());

        if (!TextUtils.isEmpty(teaWarehouseMan.getAFA_TD_Warehousemanlicappl_ID()) && TextUtils.isDigitsOnly(teaWarehouseMan.getAFA_TD_Warehousemanlicappl_ID())) {
            updateData.setRecordID(Integer.parseInt(teaWarehouseMan.getAFA_TD_Warehousemanlicappl_ID()));
        }

        try {
            if (null != teaWarehouseMan.getCertificate_of_company_registration_mandatory() && Integer.parseInt(teaWarehouseMan.getCertificate_of_company_registration_mandatory()) == 0) {
                major++;
            }

            if (null != teaWarehouseMan.getValid_insurance_policy_mandatory() && Integer.parseInt(teaWarehouseMan.getValid_insurance_policy_mandatory()) == 0) {
                major++;
            }

            if (null != teaWarehouseMan.getBusiness_permit_mandatory() && Integer.parseInt(teaWarehouseMan.getBusiness_permit_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getHealth_certificate_mandatory() && Integer.parseInt(teaWarehouseMan.getHealth_certificate_mandatory()) == 0) {
                major++;
            }

            if (null != teaWarehouseMan.getSubmission_of_annual_returns_mandatory() && Integer.parseInt(teaWarehouseMan.getSubmission_of_annual_returns_mandatory()) == 0) {
                major++;
            }

            if (null != teaWarehouseMan.getDocumented_hygiene_policy_mandatory() && Integer.parseInt(teaWarehouseMan.getDocumented_hygiene_policy_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getEvidence_of_implementation_mandatory() && Integer.parseInt(teaWarehouseMan.getEvidence_of_implementation_mandatory()) == 0) {
                major++;
            }

            if (null != teaWarehouseMan.getFood_safety_hazard_mandatory() && Integer.parseInt(teaWarehouseMan.getFood_safety_hazard_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getControl_measures_mandatory() && Integer.parseInt(teaWarehouseMan.getControl_measures_mandatory()) == 0) {
                major++;
            }

            if (null != teaWarehouseMan.getDocumented_glass_policy_mandatory() && Integer.parseInt(teaWarehouseMan.getDocumented_glass_policy_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getValid_medical_certificates_mandatory() && Integer.parseInt(teaWarehouseMan.getValid_medical_certificates_mandatory()) == 0) {
                major++;
            }

            if (null != teaWarehouseMan.getAre_hygiene_trainings_conducted_mandatory() && Integer.parseInt(teaWarehouseMan.getAre_hygiene_trainings_conducted_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getAdequate_and_clean_personal_mandatory() && Integer.parseInt(teaWarehouseMan.getAdequate_and_clean_personal_mandatory()) == 0) {
                major++;
            }

            if (null != teaWarehouseMan.getPersonnel_hygiene_practices_followed_mandatory() && Integer.parseInt(teaWarehouseMan.getPersonnel_hygiene_practices_followed_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getChanging_rooms_and_toilets_mandatory() && Integer.parseInt(teaWarehouseMan.getChanging_rooms_and_toilets_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getDocumented_cleaning_programs_mandatory() && Integer.parseInt(teaWarehouseMan.getDocumented_cleaning_programs_mandatory()) == 0) {
                observation++;
            }

            if (null != teaWarehouseMan.getCleaning_records_kept_mandatory() && Integer.parseInt(teaWarehouseMan.getCleaning_records_kept_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getSegregation_and_labelling_mandatory() && Integer.parseInt(teaWarehouseMan.getSegregation_and_labelling_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getAre_all_pests_excluded_mandatory() && Integer.parseInt(teaWarehouseMan.getAre_all_pests_excluded_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getUp_to_date_bait_map_mandatory() && Integer.parseInt(teaWarehouseMan.getUp_to_date_bait_map_mandatory()) == 0) {
                observation++;
            }

            if (null != teaWarehouseMan.getInspection_every_three_months_mandatory() && Integer.parseInt(teaWarehouseMan.getInspection_every_three_months_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getPrecaution_to_prevent_mandatory() && Integer.parseInt(teaWarehouseMan.getPrecaution_to_prevent_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getStorage_distribution_and_transportation_mandatory() && Integer.parseInt(teaWarehouseMan.getStorage_distribution_and_transportation_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getWalls_and_partitions_mandatory() && Integer.parseInt(teaWarehouseMan.getWalls_and_partitions_mandatory()) == 0) {
                observation++;
            }

            if (null != teaWarehouseMan.getProcedure_for_inspection_mandatory() && Integer.parseInt(teaWarehouseMan.getProcedure_for_inspection_mandatory()) == 0) {
                observation++;
            }

            if (null != teaWarehouseMan.getProper_segregation_of_materials_mandatory() && Integer.parseInt(teaWarehouseMan.getProper_segregation_of_materials_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getSecurity_access_control_mandatory() && Integer.parseInt(teaWarehouseMan.getSecurity_access_control_mandatory()) == 0) {
                observation++;
            }

            if (null != teaWarehouseMan.getSufficient_ventilation_mandatory() && Integer.parseInt(teaWarehouseMan.getSufficient_ventilation_mandatory()) == 0) {
                observation++;
            }

            if (null != teaWarehouseMan.getAdequate_services_mandatory() && Integer.parseInt(teaWarehouseMan.getAdequate_services_mandatory()) == 0) {
                observation++;
            }

            if (null != teaWarehouseMan.getProper_waste_collection_mandatory() && Integer.parseInt(teaWarehouseMan.getProper_waste_collection_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getExternal_site_standards_mandatory() && Integer.parseInt(teaWarehouseMan.getExternal_site_standards_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getWalls_mandatory() && Integer.parseInt(teaWarehouseMan.getWalls_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getFloors_mandatory() && Integer.parseInt(teaWarehouseMan.getFloors_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getRoof_ceiling_and_overhead_mandatory() && Integer.parseInt(teaWarehouseMan.getRoof_ceiling_and_overhead_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getWindows_mandatory() && Integer.parseInt(teaWarehouseMan.getWindows_mandatory()) == 0) {
                observation++;
            }

            if (null != teaWarehouseMan.getDoors_mandatory() && Integer.parseInt(teaWarehouseMan.getDoors_mandatory()) == 0) {
                observation++;
            }

            if (null != teaWarehouseMan.getProtection_of_light_tubes_mandatory() && Integer.parseInt(teaWarehouseMan.getProtection_of_light_tubes_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getMaintenance_programs_mandatory() && Integer.parseInt(teaWarehouseMan.getMaintenance_programs_mandatory()) == 0) {
                observation++;
            }

            if (null != teaWarehouseMan.getMaintenance_records_maintained_mandatory() && Integer.parseInt(teaWarehouseMan.getMaintenance_records_maintained_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getAre_conveyor_belts_protected_mandatory() && Integer.parseInt(teaWarehouseMan.getAre_conveyor_belts_protected_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getProduct_testing_mandatory() && Integer.parseInt(teaWarehouseMan.getProduct_testing_mandatory()) == 0) {
                observation++;
            }

            if (null != teaWarehouseMan.getCalibration_of_weighing_scale_mandatory() && Integer.parseInt(teaWarehouseMan.getCalibration_of_weighing_scale_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getMedical_examination_mandatory() && Integer.parseInt(teaWarehouseMan.getMedical_examination_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getIncoming_product_vehicle_inspection_mandatory() && Integer.parseInt(teaWarehouseMan.getIncoming_product_vehicle_inspection_mandatory()) == 0) {
                minor++;
            }

            if (null != teaWarehouseMan.getHygiene_housekeeping_inspection_mandatory() && Integer.parseInt(teaWarehouseMan.getHygiene_housekeeping_inspection_mandatory()) == 0) {
                minor++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        data.addField("iscertificateofcompanyreg", teaWarehouseMan.getCertificate_of_company_registration());
        data.addField("certificateofcompanyregmarks", teaWarehouseMan.getCertificate_of_company_registration_mandatory());
        data.addField("certificateofcompanyregremarks", teaWarehouseMan.getCertificate_of_company_registration_remarks());
        data.addField("isinsurancepolicy", teaWarehouseMan.getValid_insurance_policy());
        data.addField("insurancepolicymarks", teaWarehouseMan.getValid_insurance_policy_mandatory());
        data.addField("insurancepolicyremarks", teaWarehouseMan.getValid_insurance_policy_remarks());
        data.addField("isbusinesspermit", teaWarehouseMan.getBusiness_permit());
        data.addField("businesspermitmarks", teaWarehouseMan.getBusiness_permit_mandatory());
        data.addField("businesspermitremaks", teaWarehouseMan.getBusiness_permit_remarks());
        data.addField("ishealthcertificate", teaWarehouseMan.getHealth_certificate());
        data.addField("healthcertificatemarks", teaWarehouseMan.getHealth_certificate_mandatory());
        data.addField("healthcertificateremarks", teaWarehouseMan.getHealth_certificate_remarks());
        data.addField("isreturns", teaWarehouseMan.getSubmission_of_annual_returns());
        data.addField("returnsmarks", teaWarehouseMan.getSubmission_of_annual_returns_mandatory());
        data.addField("returnsremarks", teaWarehouseMan.getSubmission_of_annual_returns_remarks());
        data.addField("ishygienepolicy", teaWarehouseMan.getDocumented_hygiene_policy());
        data.addField("hygienepolicymarks", teaWarehouseMan.getDocumented_hygiene_policy_mandatory());
        data.addField("hygienepolicyremarks", teaWarehouseMan.getDocumented_hygiene_policy_remarks());
        data.addField("isimplevidence", teaWarehouseMan.getEvidence_of_implementation());
        data.addField("implevidencemarks", teaWarehouseMan.getEvidence_of_implementation_mandatory());
        data.addField("implevidenceremarks", teaWarehouseMan.getEvidence_of_implementation_remarks());
        data.addField("isfoodsafetyassess", teaWarehouseMan.getFood_safety_hazard());
        data.addField("foodsafetyassesmarks", teaWarehouseMan.getFood_safety_hazard_mandatory());
        data.addField("foodsafetyassesremarks", teaWarehouseMan.getFood_safety_hazard_remarks());
        data.addField("isfoodsafetycontrol", teaWarehouseMan.getControl_measures());
        data.addField("foodsafetycontrolmarks", teaWarehouseMan.getControl_measures_mandatory());
        data.addField("foodsafetycontrolremarks", teaWarehouseMan.getControl_measures_remarks());
        data.addField("isdocglasspolinspec", teaWarehouseMan.getDocumented_glass_policy());
        data.addField("docglasspolinspecmarks", teaWarehouseMan.getDocumented_glass_policy_mandatory());
        data.addField("docglasspolinspecremarks", teaWarehouseMan.getDocumented_glass_policy_remarks());
        data.addField("ismedicalcert", teaWarehouseMan.getValid_medical_certificates());
        data.addField("medicalcertmarks", teaWarehouseMan.getValid_medical_certificates_mandatory());
        data.addField("medicalertremarks", teaWarehouseMan.getValid_medical_certificates_remarks());
        data.addField("ishygienetraining", teaWarehouseMan.getAre_hygiene_trainings_conducted());
        data.addField("hygeienetrainingmarks", teaWarehouseMan.getAre_hygiene_trainings_conducted_mandatory());
        data.addField("hygienetrainingremarks", teaWarehouseMan.getAre_hygiene_trainings_conducted_remarks());
        data.addField("isprotectiveequips", teaWarehouseMan.getAdequate_and_clean_personal());
        data.addField("protectiveequipmarks", teaWarehouseMan.getAdequate_and_clean_personal_mandatory());
        data.addField("protectiveequipremarks", teaWarehouseMan.getAdequate_and_clean_personal_remarks());
        data.addField("ispersonnelhygprac", teaWarehouseMan.getPersonnel_hygiene_practices_followed());
        data.addField("personnelhygpracmarks", teaWarehouseMan.getPersonnel_hygiene_practices_followed_mandatory());
        data.addField("personnelhygpracremarks", teaWarehouseMan.getPersonnel_hygiene_practices_followed_remarks());
        data.addField("ischangeroom", teaWarehouseMan.getChanging_rooms_and_toilets());
        data.addField("changeroommarks", teaWarehouseMan.getChanging_rooms_and_toilets_mandatory());
        data.addField("changeroomremarks", teaWarehouseMan.getChanging_rooms_and_toilets_remarks());
        data.addField("isdoccleaningprogs", teaWarehouseMan.getDocumented_cleaning_programs());
        data.addField("doccleaningprogsmarks", teaWarehouseMan.getDocumented_cleaning_programs_mandatory());
        data.addField("doccleaningprogsremarks", teaWarehouseMan.getDocumented_cleaning_programs_remarks());
        data.addField("iscleaningreckept", teaWarehouseMan.getCleaning_records_kept());
        data.addField("cleaningreckeptmarks", teaWarehouseMan.getCleaning_records_kept_mandatory());
        data.addField("cleaningreckeptremarks", teaWarehouseMan.getCleaning_records_kept_remarks());
        data.addField("isseglabelcleandet", teaWarehouseMan.getSegregation_and_labelling());
        data.addField("seglabelcleandetmarks", teaWarehouseMan.getSegregation_and_labelling_mandatory());
        data.addField("seglabelcleandetremarks", teaWarehouseMan.getSegregation_and_labelling_remarks());
        data.addField("ispestexcluded", teaWarehouseMan.getAre_all_pests_excluded());
        data.addField("pestexcludedmarks", teaWarehouseMan.getAre_all_pests_excluded_mandatory());
        data.addField("pestexcludedremarks", teaWarehouseMan.getAre_all_pests_excluded_remarks());
        data.addField("isbaitmap", teaWarehouseMan.getUp_to_date_bait_map());
        data.addField("baitmapmarks", teaWarehouseMan.getUp_to_date_bait_map_mandatory());
        data.addField("baitmapremarks", teaWarehouseMan.getUp_to_date_bait_map_remarks());
        data.addField("isinspectthreemonths", teaWarehouseMan.getInspection_every_three_months());
        data.addField("inspectthreemonthsmarks", teaWarehouseMan.getInspection_every_three_months_mandatory());
        data.addField("inspectthreemonthsremarks", teaWarehouseMan.getInspection_every_three_months_remarks());
        data.addField("iscontmnprecaution", teaWarehouseMan.getPrecaution_to_prevent());
        data.addField("contmnprecautionmarks", teaWarehouseMan.getPrecaution_to_prevent_mandatory());
        data.addField("contmnprecautionremarks", teaWarehouseMan.getPrecaution_to_prevent_remarks());
        data.addField("isstorage", teaWarehouseMan.getStorage_distribution_and_transportation());
        data.addField("storagemarks", teaWarehouseMan.getStorage_distribution_and_transportation_mandatory());
        data.addField("storageremarks", teaWarehouseMan.getStorage_distribution_and_transportation_remarks());
        data.addField("ispassway", teaWarehouseMan.getWalls_and_partitions());
        data.addField("passwaymarks", teaWarehouseMan.getWalls_and_partitions_mandatory());
        data.addField("passwayremarks", teaWarehouseMan.getWalls_and_partitions_remarks());
        data.addField("isinspecprocedure", teaWarehouseMan.getProcedure_for_inspection());
        data.addField("inspecproceduremarks", teaWarehouseMan.getProcedure_for_inspection_mandatory());
        data.addField("inspecprocedureremarks", teaWarehouseMan.getProcedure_for_inspection_remarks());
        data.addField("ispropersegmaterial", teaWarehouseMan.getProper_segregation_of_materials());
        data.addField("propersegmaterialmarks", teaWarehouseMan.getProper_segregation_of_materials_mandatory());
        data.addField("propersegmaterialremarks", teaWarehouseMan.getProper_segregation_of_materials_remarks());
        data.addField("issecurityaccess", teaWarehouseMan.getSecurity_access_control());
        data.addField("securityaccessmarks", teaWarehouseMan.getSecurity_access_control_mandatory());
        data.addField("securityaccessremarks", teaWarehouseMan.getSecurity_access_control_remarks());
        data.addField("issuffventilation", teaWarehouseMan.getSufficient_ventilation());
        data.addField("suffventilationmarks", teaWarehouseMan.getSufficient_ventilation_mandatory());
        data.addField("suffventilationremarks", teaWarehouseMan.getSufficient_ventilation_remarks());
        data.addField("isservices", teaWarehouseMan.getAdequate_services());
        data.addField("servicesmarks", teaWarehouseMan.getAdequate_services_mandatory());
        data.addField("servicesremarks", teaWarehouseMan.getAdequate_services_remarks());
        data.addField("isproperwastecoll", teaWarehouseMan.getProper_waste_collection());
        data.addField("properwastecollmarks", teaWarehouseMan.getProper_waste_collection_mandatory());
        data.addField("properwastecollremarks", teaWarehouseMan.getProper_waste_collection_remarks());
        data.addField("isexternalsitestds", teaWarehouseMan.getExternal_site_standards());
        data.addField("externalsitestdsmarks", teaWarehouseMan.getExternal_site_standards_mandatory());
        data.addField("externalsitestdsremarks", teaWarehouseMan.getExternal_site_standards_remarks());
        data.addField("iswalls", teaWarehouseMan.getWalls());
        data.addField("wallmarks", teaWarehouseMan.getWalls_mandatory());
        data.addField("wallremarks", teaWarehouseMan.getWalls_remarks());
        data.addField("isfloors", teaWarehouseMan.getFloors());
        data.addField("floormarks", teaWarehouseMan.getFloors_mandatory());
        data.addField("floorremarks", teaWarehouseMan.getFloors_remarks());
        data.addField("isroof_ceiling", teaWarehouseMan.getRoof_ceiling_and_overhead());
        data.addField("roof_ceilingmarks", teaWarehouseMan.getRoof_ceiling_and_overhead_mandatory());
        data.addField("roof_ceilingremarks", teaWarehouseMan.getRoof_ceiling_and_overhead_remarks());
        data.addField("iswindows", teaWarehouseMan.getWindows());
        data.addField("windowmarks", teaWarehouseMan.getWindows_mandatory());
        data.addField("windowremarks", teaWarehouseMan.getWindows_remarks());
        data.addField("isdoors", teaWarehouseMan.getDoors());
        data.addField("doormarks", teaWarehouseMan.getDoors_mandatory());
        data.addField("doorremarks", teaWarehouseMan.getDoors_remarks());
        data.addField("isadequatelighting", teaWarehouseMan.getProtection_of_light_tubes());
        data.addField("adequatelightmarks", teaWarehouseMan.getProtection_of_light_tubes_mandatory());
        data.addField("adequatelightremarks", teaWarehouseMan.getProtection_of_light_tubes_remarks());
        data.addField("ismaintprograms", teaWarehouseMan.getMaintenance_programs());
        data.addField("maintprogramsmarks", teaWarehouseMan.getMaintenance_programs_mandatory());
        data.addField("maintprogramsremarks", teaWarehouseMan.getMaintenance_programs_remarks());
        data.addField("ismaintrecmaintained", teaWarehouseMan.getMaintenance_records_maintained());
        data.addField("maintrecmaintainedmarks", teaWarehouseMan.getMaintenance_records_maintained_mandatory());
        data.addField("maintrecmaintainedremarks", teaWarehouseMan.getMaintenance_records_maintained_remarks());
        data.addField("isbelts", teaWarehouseMan.getAre_conveyor_belts_protected());
        data.addField("beltmarks", teaWarehouseMan.getAre_conveyor_belts_protected_mandatory());
        data.addField("beltremarks", teaWarehouseMan.getAre_conveyor_belts_protected_remarks());
        data.addField("isproducttesting", teaWarehouseMan.getProduct_testing());
        data.addField("producttestingmarks", teaWarehouseMan.getProduct_testing_mandatory());
        data.addField("producttestingremarks", teaWarehouseMan.getProduct_testing_remarks());
        data.addField("iscalibration", teaWarehouseMan.getCalibration_of_weighing_scale());
        data.addField("calibrationmarks", teaWarehouseMan.getCalibration_of_weighing_scale_mandatory());
        data.addField("calibrationremarks", teaWarehouseMan.getCalibration_of_weighing_scale_remarks());
        data.addField("ismedicalexam", teaWarehouseMan.getMedical_examination());
        data.addField("medicalexammarks", teaWarehouseMan.getMedical_examination_mandatory());
        data.addField("medicalexamremarks", teaWarehouseMan.getMedical_examination_remarks());
        data.addField("isincomingprodvinsp", teaWarehouseMan.getIncoming_product_vehicle_inspection());
        data.addField("incomingprodvinspmarks", teaWarehouseMan.getIncoming_product_vehicle_inspection_mandatory());
        data.addField("incomingprodvinspremarks", teaWarehouseMan.getIncoming_product_vehicle_inspection_remarks());
        data.addField("ishyginehkeepinginsp", teaWarehouseMan.getHygiene_housekeeping_inspection());
        data.addField("hyginehkeepinginspmarks", teaWarehouseMan.getHygiene_housekeeping_inspection_mandatory());
        data.addField("hyginehkeepinginspremarks", teaWarehouseMan.getHygiene_housekeeping_inspection_remarks());
        data.addField("major_marks", major);
        data.addField("minor_marks", minor);
        data.addField("observation_marks", observation);
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");



        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());

            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateTeaWarehousemanSent(teaWarehouseMan.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Posting warehouseman error " + e.getMessage());
            e.printStackTrace();
        }


    }


    public void postTeaBuyerImporterExporterRecords(TeaBuyerImporterExporterDetails teaBuyerImporterExporterDetails) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateTeaBuyerImporterExporter");

        System.out.println("the local ID to be pushed " + teaBuyerImporterExporterDetails.getLocalID());

        System.out.println("AFA_TD_IM_EX_Porter_Lic_ID" + teaBuyerImporterExporterDetails.getAFA_TD_Inspection_Checklist_ID());
        System.out.println("getLocalID" + teaBuyerImporterExporterDetails.getLocalID());
        System.out.println("getLicenseNumber" + teaBuyerImporterExporterDetails.getLicenseNumber());
        System.out.println("getDocumentNumber" + teaBuyerImporterExporterDetails.getDocumentNumber());
        System.out.println("getApplicantName" + teaBuyerImporterExporterDetails.getApplicantName());


        if (!TextUtils.isEmpty(teaBuyerImporterExporterDetails.getAFA_TD_Inspection_Checklist_ID()) && TextUtils.isDigitsOnly(teaBuyerImporterExporterDetails.getAFA_TD_Inspection_Checklist_ID())) {
            updateData.setRecordID(Integer.parseInt(teaBuyerImporterExporterDetails.getAFA_TD_Inspection_Checklist_ID()));
        }

        data.addField("istbkcertficate", teaBuyerImporterExporterDetails.getIsValidTbk());
        data.addField("tbkcertificatemarks", teaBuyerImporterExporterDetails.getValidTbkMarks());
        data.addField("tbkcertficateremarks", teaBuyerImporterExporterDetails.getValidTbkRemarks());
        data.addField("tbkcertificatemarks", teaBuyerImporterExporterDetails.getValidTbkMarks());
        data.addField("tbkcertficateremarks", teaBuyerImporterExporterDetails.getValidTbkRemarks());
        data.addField("isbusinesspermit", teaBuyerImporterExporterDetails.getIsBusinessPermit());
        data.addField("businesspermitmarks", teaBuyerImporterExporterDetails.getBusinessPermitMarks());
        data.addField("businesspermitremaks", teaBuyerImporterExporterDetails.getBusinessPermitRemarks());
        data.addField("ishealthcertificate", teaBuyerImporterExporterDetails.getIsHealthCertificate());
        data.addField("healthcertificatemarks", teaBuyerImporterExporterDetails.getHealthCertificateMarks());
        data.addField("healthcertificateremarks", teaBuyerImporterExporterDetails.getHealthCertificateRemarks());
        data.addField("isreturns", teaBuyerImporterExporterDetails.getIsSubmissionOfMonthlyReturns());
        data.addField("returnsmarks", teaBuyerImporterExporterDetails.getSubmissionOfMonthlyReturnsMarks());
        data.addField("returnsremarks", teaBuyerImporterExporterDetails.getSubmissionOfMonthlyReturnsRemarks());
        data.addField("isexportregistration", teaBuyerImporterExporterDetails.getIsRegistrationOfExportsDone());
        data.addField("exportregmarks", teaBuyerImporterExporterDetails.getRegistrationOfExportsDoneMarks());
        data.addField("exportregremmarks", teaBuyerImporterExporterDetails.getRegistrationOfExportsDoneRemarks());
        data.addField("isimportregistration", teaBuyerImporterExporterDetails.getIsRegistrationOfImportsDone());
        data.addField("importregmarks", teaBuyerImporterExporterDetails.getRegistrationOfImportsDoneMarks());
        data.addField("importregremmarks", teaBuyerImporterExporterDetails.getRegistrationOfImportsDoneRemarks());
        data.addField("isimportstanard", teaBuyerImporterExporterDetails.getIsImportsAccompaniedByCoc());
        data.addField("importstandardmarks", teaBuyerImporterExporterDetails.getImportsAccompaniedByCocMarks());
        data.addField("importstandardremarks", teaBuyerImporterExporterDetails.getImportsAccompaniedByCocRemarks());
        data.addField("isre_exportimported", teaBuyerImporterExporterDetails.getIsReexportOfImportedTea());
        data.addField("re_exportimportedmarks", teaBuyerImporterExporterDetails.getReexportOfImportedTeaMarks());
        data.addField("re_exportimportedremarks", teaBuyerImporterExporterDetails.getReexportOfImportedTeaRemarks());
        data.addField("isre_exportdestructed", teaBuyerImporterExporterDetails.getIsReexportOrDestruction());
        data.addField("re_exportdestructedmarks", teaBuyerImporterExporterDetails.getReexportOrDestructionMarks());
        data.addField("re_exportdestructedremarks", teaBuyerImporterExporterDetails.getReexportOrDestructionRemarks());
        data.addField("isexternalsitestds", teaBuyerImporterExporterDetails.getIsExternalSiteStandards());
        data.addField("externalsitestdsmarks", teaBuyerImporterExporterDetails.getExternalSiteStandardsMarks());
        data.addField("externalsitestdsremarks", teaBuyerImporterExporterDetails.getExternalSiteStandardsRemarks());
        data.addField("issecurityaccess", teaBuyerImporterExporterDetails.getIsSecurityAccessControl());
        data.addField("securityaccessmarks", teaBuyerImporterExporterDetails.getSecurityAccessControlMarks());
        data.addField("securityaccessremarks", teaBuyerImporterExporterDetails.getSecurityAccessControlRemarks());
        data.addField("islayout_segregation", teaBuyerImporterExporterDetails.getIsLayoutProductFlow());
        data.addField("layout_segregationmarks", teaBuyerImporterExporterDetails.getLayoutProductFlowMarks());
        data.addField("layout_segregationremarks", teaBuyerImporterExporterDetails.getLayoutProductFlowRemarks());
        data.addField("iswalls", teaBuyerImporterExporterDetails.getIsWalls());
        data.addField("wallmarks", teaBuyerImporterExporterDetails.getWallsMarks());
        data.addField("wallremarks", teaBuyerImporterExporterDetails.getWallsRemarks());
        data.addField("isfloors", teaBuyerImporterExporterDetails.getIsFloors());
        data.addField("floormarks", teaBuyerImporterExporterDetails.getFloorsMarks());
        data.addField("floorremarks", teaBuyerImporterExporterDetails.getFloorsRemarks());
        data.addField("isroof_ceiling", teaBuyerImporterExporterDetails.getIsRoofCeilingAndOverhead());
        data.addField("roof_ceilingmarks", teaBuyerImporterExporterDetails.getRoofCeilingAndOverheadMarks());
        data.addField("roof_ceilingremarks", teaBuyerImporterExporterDetails.getRoofCeilingAndOverheadRemarks());
        data.addField("iswindows", teaBuyerImporterExporterDetails.getIsWindows());
        data.addField("windowmarks", teaBuyerImporterExporterDetails.getWindowsMarks());
        data.addField("windowremarks", teaBuyerImporterExporterDetails.getWindowsRemarks());
        data.addField("isdoors", teaBuyerImporterExporterDetails.getIsDoors());
        data.addField("doormarks", teaBuyerImporterExporterDetails.getDoorsMarks());
        data.addField("doorremarks", teaBuyerImporterExporterDetails.getDoorsRemarks());
        data.addField("isadequatelighting", teaBuyerImporterExporterDetails.getIsAdequateLighting());
        data.addField("adequatelightmarks", teaBuyerImporterExporterDetails.getAdequateLightingMarks());
        data.addField("adequatelightremarks", teaBuyerImporterExporterDetails.getAdequateLightingRemarks());
        data.addField("isventilation", teaBuyerImporterExporterDetails.getIsVentilation());
        data.addField("ventmarks", teaBuyerImporterExporterDetails.getVentilationMarks());
        data.addField("ventremarks", teaBuyerImporterExporterDetails.getVentilationRemarks());
        data.addField("isequipmentcleaniness", teaBuyerImporterExporterDetails.getIsEquipmentCleanliness());
        data.addField("equipmentcleanmarks", teaBuyerImporterExporterDetails.getEquipmentCleanlinessMarks());
        data.addField("equipmentcleanremarks", teaBuyerImporterExporterDetails.getEquipmentCleanlinessRemarks());
        data.addField("ischangeroom", teaBuyerImporterExporterDetails.getIsChangingRoomsAndToilets());
        data.addField("changeroommarks", teaBuyerImporterExporterDetails.getChangingRoomsAndToiletsMarks());
        data.addField("changeroomremarks", teaBuyerImporterExporterDetails.getChangingRoomsAndToiletsRemarks());
        data.addField("isriskofchems", teaBuyerImporterExporterDetails.getIsRiskOfContaminants());
        data.addField("riskofchemsmarks", teaBuyerImporterExporterDetails.getRiskOfContaminantsMarks());
        data.addField("riskofchemsremarks", teaBuyerImporterExporterDetails.getRiskOfContaminantsRemarks());
        data.addField("iswastedisposal", teaBuyerImporterExporterDetails.getIsWasteTeasDisposal());
        data.addField("wastediposalmarks", teaBuyerImporterExporterDetails.getWasteTeasDisposalMarks());
        data.addField("wastedisposalremarks", teaBuyerImporterExporterDetails.getWasteTeasDisposalRemarks());
        data.addField("ispestcontrol", teaBuyerImporterExporterDetails.getIsPestControlPrograms());
        data.addField("pestcontrolmarks", teaBuyerImporterExporterDetails.getPestControlProgramsMarks());
        data.addField("pestcontrolremaks", teaBuyerImporterExporterDetails.getPestControlProgramsRemarks());
        data.addField("ispropersttorage", teaBuyerImporterExporterDetails.getIsProperStorage());
        data.addField("properstoragemarks", teaBuyerImporterExporterDetails.getProperStorageMarks());
        data.addField("properstorageremarks", teaBuyerImporterExporterDetails.getProperStorageRemarks());
        data.addField("ispackconformity", teaBuyerImporterExporterDetails.getIsPackagingMaterial());
        data.addField("packconformitymarks", teaBuyerImporterExporterDetails.getPackagingMaterialMarks());
        data.addField("packconformityremarks", teaBuyerImporterExporterDetails.getPackagingMaterialRemarks());
        data.addField("isnon_confom", teaBuyerImporterExporterDetails.getIsNonConformingProduct());
        data.addField("non_conformmarks", teaBuyerImporterExporterDetails.getNonConformingProductMarks());
        data.addField("non_conformremarks", teaBuyerImporterExporterDetails.getNonConformingProductRemarks());
        data.addField("ispalletheated", teaBuyerImporterExporterDetails.getIsPalletsAreHeatTreated());
        data.addField("palletheatedmarks", teaBuyerImporterExporterDetails.getPalletsAreHeatTreatedMarks());
        data.addField("palletheatedremarks", teaBuyerImporterExporterDetails.getPalletsAreHeatTreatedRemarks());
        data.addField("isdispatchrecord", teaBuyerImporterExporterDetails.getIsTeaDispatchRecordsMaintained());
        data.addField("dispatchrecordmarks", teaBuyerImporterExporterDetails.getTeaDispatchRecordsMaintainedMarks());
        data.addField("dispatchrecordremarks", teaBuyerImporterExporterDetails.getTeaDispatchRecordsMaintainedRemarks());
        data.addField("isequipmentidentity", teaBuyerImporterExporterDetails.getIsEquipmentIdentification());
        data.addField("equipmentidentitymarks", teaBuyerImporterExporterDetails.getEquipmentIdentificationMarks());
        data.addField("equipmentidentityremark", teaBuyerImporterExporterDetails.getEquipmentIdentificationRemarks());
        data.addField("istracesystem", teaBuyerImporterExporterDetails.getIsTraceabilitySystem());
        data.addField("tracesystemmarks", teaBuyerImporterExporterDetails.getTraceabilitySystemMarks());
        data.addField("tracesystemremarks", teaBuyerImporterExporterDetails.getTraceabilitySystemRemarks());
        data.addField("isfoodsafety", teaBuyerImporterExporterDetails.getIsFoodSafetyHazardsIdentified());
        data.addField("foodsafetymarks", teaBuyerImporterExporterDetails.getFoodSafetyHazardsIdentifiedMarks());
        data.addField("foodsafetyremarks", teaBuyerImporterExporterDetails.getFoodSafetyHazardsIdentifiedRemarks());
        data.addField("iscustomerfeedback", teaBuyerImporterExporterDetails.getIsCustomerFeedbackRecords());
        data.addField("customerfeedbackmarks", teaBuyerImporterExporterDetails.getCustomerFeedbackRecordsMarks());
        data.addField("customerfeedbackremarks", teaBuyerImporterExporterDetails.getCustomerFeedbackRecordsRemarks());
        data.addField("isprocessdocuments", teaBuyerImporterExporterDetails.getIsProcessDocumentsAndRecords());
        data.addField("processdocmarks", teaBuyerImporterExporterDetails.getProcessDocumentsAndRecordsMarks());
        data.addField("processdocremarks", teaBuyerImporterExporterDetails.getProcessDocumentsAndRecordsRemarks());
        data.addField("ishygieneprocedure", teaBuyerImporterExporterDetails.getIsDocumentedPersonalHygiene());
        data.addField("hygieneproceduremarks", teaBuyerImporterExporterDetails.getDocumentedPersonalHygieneMarks());
        data.addField("hygieneprocedureremarks", teaBuyerImporterExporterDetails.getDocumentedPersonalHygieneRemarks());
        data.addField("isscreening", teaBuyerImporterExporterDetails.getIsMedicalScreening());
        data.addField("screeningmarks", teaBuyerImporterExporterDetails.getMedicalScreeningMarks());
        data.addField("screeningremarks", teaBuyerImporterExporterDetails.getMedicalScreeningRemarks());
        data.addField("ismedicalcert", teaBuyerImporterExporterDetails.getIsValidMedicalCertificate());
        data.addField("medicalcertmarks", teaBuyerImporterExporterDetails.getValidMedicalCertificateMarks());
        data.addField("medicalertremarks", teaBuyerImporterExporterDetails.getValidMedicalCertificateRemarks());
        data.addField("isprotectiveequips", teaBuyerImporterExporterDetails.getIsAdequateAndCleanPersonal());
        data.addField("protectiveequipmarks", teaBuyerImporterExporterDetails.getAdequateAndCleanPersonalMarks());
        data.addField("protectiveequipremarks", teaBuyerImporterExporterDetails.getAdequateAndCleanPersonalRemarks());
        data.addField("isworkplacecert", teaBuyerImporterExporterDetails.getIsValidCertificateOfRegistration());
        data.addField("workplacecertmarks", teaBuyerImporterExporterDetails.getValidCertificateOfRegistrationMarks());
        data.addField("workplacecertremarks", teaBuyerImporterExporterDetails.getValidCertificateOfRegistrationRemarks());
        data.addField("isaccidentreport", teaBuyerImporterExporterDetails.getIsIncidentAndAccidentReports());
        data.addField("accidentreportmarks", teaBuyerImporterExporterDetails.getIncidentAndAccidentReportsMarks());
        data.addField("accidentreportremarks", teaBuyerImporterExporterDetails.getIncidentAndAccidentReportsRemarks());
        data.addField("isfiredrills", teaBuyerImporterExporterDetails.getIsFireEquipmentInspection());
        data.addField("firedrillmarks", teaBuyerImporterExporterDetails.getFireEquipmentInspectionMarks());
        data.addField("firedrillremarks", teaBuyerImporterExporterDetails.getFireEquipmentInspectionRemarks());
        data.addField("ismarkedzone", teaBuyerImporterExporterDetails.getIsMarkedZonesFireExits());
        data.addField("markedzonemarks", teaBuyerImporterExporterDetails.getMarkedZonesFireExitsMarks());
        data.addField("markedzoneremarks", teaBuyerImporterExporterDetails.getMarkedZonesFireExitsRemarks());
        data.addField("islabour_rules", teaBuyerImporterExporterDetails.getIsCompliancewithLabourRules());
        data.addField("labour_rulesmarks", teaBuyerImporterExporterDetails.getCompliancewithLabourRulesMarks());
        data.addField("labour_rulesremarks", teaBuyerImporterExporterDetails.getCompliancewithLabourRulesRemarks());
        data.addField("isohs_act", teaBuyerImporterExporterDetails.getIsComplianceToOhsAct());
        data.addField("ohs_actmarks", teaBuyerImporterExporterDetails.getComplianceToOhsActMarks());
        data.addField("ohs_actremarks", teaBuyerImporterExporterDetails.getComplianceToOhsActRemarks());
        data.addField("isinspectiongaps", teaBuyerImporterExporterDetails.getIsCorrectionOfPreviousInspection());
        data.addField("inspectiongapmarks", teaBuyerImporterExporterDetails.getCorrectionOfPreviousInspectionMarks());
        data.addField("inspectiongapremarks", teaBuyerImporterExporterDetails.getCorrectionOfPreviousInspectionRemarks());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("IsApproved", "Y");
        data.addField("Processing", "Y");
        //data.addField("DocStatus", teaBuyerImporterExporterDetails.getDocumentStatus());

        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void postcoffeeCommercialAgentRecords(CoffeeCommercialAgent coffeeCommercialAgent) {

        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        updateData.setWebServiceType("UpdateCommercialMarketingAgents");
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());

        System.out.println("the local ID to be pushed " + coffeeCommercialAgent.getLocalID());
        System.out.println("getAfa_cd_Coffee_Commercial_mkt_Agent_id" + coffeeCommercialAgent.getAfa_cd_Coffee_Commercial_mkt_Agent_id());
        System.out.println("getdocumne no" + coffeeCommercialAgent.getDocument_number());
        System.out.println("getdocument date" + coffeeCommercialAgent.getDocument_date());
        System.out.println("getapplicant name" + coffeeCommercialAgent.getName_of_applicant());
        System.out.println("cert licence number" + coffeeCommercialAgent.getLicence_number());

        updateData.setRecordID(Integer.parseInt(coffeeCommercialAgent.getAfa_cd_Coffee_Commercial_mkt_Agent_id()));


        data.addField("isclearmarking", coffeeCommercialAgent.getIsmarkingClear());
        data.addField("remarks1", coffeeCommercialAgent.getMarkingClearRemarks());
        data.addField("isvalidlicense", coffeeCommercialAgent.getIscoffeeLicenceValid());
        data.addField("remarks3", coffeeCommercialAgent.getCoffeeLicenceValidRemarks());
        data.addField("ispermitissued", coffeeCommercialAgent.getIssingleBusinessPermit());
        data.addField("remarks4", coffeeCommercialAgent.getSingleBusinessPermitRemarks());
        data.addField("isinplace", coffeeCommercialAgent.getIswasteDisposalsystem());
        data.addField("remarks6", coffeeCommercialAgent.getWasteDisposalsystemRemarks());
        data.addField("isserviced", coffeeCommercialAgent.getIsfireFightingEquipments());
        data.addField("remarks8", coffeeCommercialAgent.getFireFightingEquipmentsRemarks());
        data.addField("issatisfactory", coffeeCommercialAgent.getIsgeneralhygienes());
        data.addField("remarks10", coffeeCommercialAgent.getGeneralhygienesRemarks());
        data.addField("isclean", coffeeCommercialAgent.getIswashingrRooms());
        data.addField("remarks11", coffeeCommercialAgent.getWashingrRoomsRemarks());
        data.addField("issupplied", coffeeCommercialAgent.getIscleanWaterSupplied());
        data.addField("remarks12", coffeeCommercialAgent.getCleanWaterSuppliedRemarks());
        data.addField("issupplied1", coffeeCommercialAgent.getIselectricity());
        data.addField("remarks13", coffeeCommercialAgent.getElectricityRemarks());
        data.addField("isremitted", coffeeCommercialAgent.getIsreturnsRemitted());
        data.addField("remarks24", coffeeCommercialAgent.getReturnsRemittedRemarks());
        data.addField("isplace10", coffeeCommercialAgent.getIstraceabilitySystem());
        data.addField("remarks26", coffeeCommercialAgent.getTraceabilitySystemRemarks());
        data.addField("ispalce12", coffeeCommercialAgent.getIscuppingFacilities());
        data.addField("remarks30", coffeeCommercialAgent.getCuppingFacilitiesRemarks());
        data.addField("isvalidcert", coffeeCommercialAgent.getIsoccupationalAndHealthAct());
        data.addField("remarks31", coffeeCommercialAgent.getOccupationalAndHealthActRemarks());
        data.addField("isdone", coffeeCommercialAgent.getIspaymentToGrowers());
        data.addField("remarks32", coffeeCommercialAgent.getPaymentToGrowersRemarks());
        data.addField("ispalce13", coffeeCommercialAgent.getIsstarndardOutTurnSales());
        data.addField("remarks33", coffeeCommercialAgent.getStarndardOutTurnSalesRemarks());
        data.addField("ispalce14", coffeeCommercialAgent.getIsstandardDirect());
        data.addField("remarks34", coffeeCommercialAgent.getStandardDirectRemarks());
        data.addField("recommendation", coffeeCommercialAgent.getOfficerrecommendation());
        data.addField("recommendation_remarks", coffeeCommercialAgent.getOfficerrecommendation_remark());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");


        updateData.setDataRow(data);


        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateCoffeeCommercialAgentSent(coffeeCommercialAgent.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void postPulpingStationLicenseApplicationRecords(PulpingStationLicenseApplicationDetails pulpingStationLicenseApplicationDetails) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdatePulpingStationLicenseApplication");

        System.out.println("the local ID to be pushed " + pulpingStationLicenseApplicationDetails.getLocalID());

        System.out.println("AFA_CD_Pulp_Ate_Checklist_ID" + pulpingStationLicenseApplicationDetails.getAFA_CD_Pulp_Ate_Checklist_ID());
        System.out.println("getLocalID" + pulpingStationLicenseApplicationDetails.getLocalID());
        System.out.println("getAuthorityToErectNumber" + pulpingStationLicenseApplicationDetails.getAuthorityToErectNumber());
        System.out.println("getDocumentNumber" + pulpingStationLicenseApplicationDetails.getDocumentNumber());
        System.out.println("getApplicantName" + pulpingStationLicenseApplicationDetails.getApplicantName());


        if (!TextUtils.isEmpty(pulpingStationLicenseApplicationDetails.getAFA_CD_Pulp_Ate_Checklist_ID()) && TextUtils.isDigitsOnly(pulpingStationLicenseApplicationDetails.getAFA_CD_Pulp_Ate_Checklist_ID())) {
            updateData.setRecordID(Integer.parseInt(pulpingStationLicenseApplicationDetails.getAFA_CD_Pulp_Ate_Checklist_ID()));
        }

        data.addField("totalandarea", pulpingStationLicenseApplicationDetails.getTotalLandArea());
        data.addField("totaltrees", pulpingStationLicenseApplicationDetails.getTotalNumberOfTrees());
        data.addField("areamaturecoffee", pulpingStationLicenseApplicationDetails.getAreaUnderMatureCoffee());
        data.addField("yearone", pulpingStationLicenseApplicationDetails.getFirstYear());
        data.addField("year1products", pulpingStationLicenseApplicationDetails.getFirstYearProduction());
        data.addField("yeartwo", pulpingStationLicenseApplicationDetails.getSecondYear());
        data.addField("year2products", pulpingStationLicenseApplicationDetails.getSecondYearProduction());
        data.addField("yearthree", pulpingStationLicenseApplicationDetails.getThirdYear());
        data.addField("year3products", pulpingStationLicenseApplicationDetails.getThirdYearProduction());
        data.addField("husbandaryserv", pulpingStationLicenseApplicationDetails.getCropHusbandryPractices());
        data.addField("isobjection", pulpingStationLicenseApplicationDetails.getIsObjectionLetter());
        data.addField("objectionremark", pulpingStationLicenseApplicationDetails.getIsObjectionLetterRemarks());
        data.addField("iswastedispose", pulpingStationLicenseApplicationDetails.getIsWasteDisposal());
        data.addField("wastedispose", pulpingStationLicenseApplicationDetails.getIsWasteDisposalRemarks());
        data.addField("ispollutionmgt", pulpingStationLicenseApplicationDetails.getIsPollutionManagement());
        data.addField("pollutionmgt", pulpingStationLicenseApplicationDetails.getIsPollutionManagementRemarks());
        data.addField("iswater", pulpingStationLicenseApplicationDetails.getIsWater());
        data.addField("waterremarks", pulpingStationLicenseApplicationDetails.getIsWaterRemarks());
        data.addField("isnemacertfct", pulpingStationLicenseApplicationDetails.getIsNemaCertificate());
        data.addField("nemacerfct", pulpingStationLicenseApplicationDetails.getIsNemaCertificateRemarks());
        data.addField("advisoryofficerrecom", pulpingStationLicenseApplicationDetails.getCoffeeAdvisory());
        data.addField("workgrouprecomm", pulpingStationLicenseApplicationDetails.getCoffeeWorking());
        data.addField("recommendation", pulpingStationLicenseApplicationDetails.getOfficerrecommendation());
        data.addField("recommendation_remarks", pulpingStationLicenseApplicationDetails.getOfficerrecommendation_remark());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");
        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updatePulpingStationLicenseApplicationSent(pulpingStationLicenseApplicationDetails.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void postTeaPackerRecords(TeaPackerChecklist teaPackerChecklist) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        int major = 0, minor = 0, observation = 0;


        updateData.setLogin(getLogin());

        updateData.setWebServiceType("UpdateTeaPacker");

        System.out.println("the local ID to be pushed " + teaPackerChecklist.getLocalID());
        System.out.println("aFA_PD_Inspect_Processor_ID" + teaPackerChecklist.getAFA_TD_Inspection_Checklist_ID());
        System.out.println("TeaPacker" + teaPackerChecklist.getLocalID());
        System.out.println("TeaPacker" + teaPackerChecklist.getFloorsMust3mks());
        System.out.println("TeaPacker" + teaPackerChecklist.getWallsMust3mks());
        System.out.println("TeaPacker" + teaPackerChecklist.getWindowsRecom1mk());
        System.out.println("teaPacker local ID to be pushed " + teaPackerChecklist.getLocalID());
        System.out.println("teaPacker aFA_PD_Inspect_Processor_ID" + teaPackerChecklist.getAFA_TD_Inspection_Checklist_ID());


        System.out.println("isidentitysegregation" + teaPackerChecklist.getIsIdentificationAndSegregation());
        System.out.println("identitysegregationmarks" + teaPackerChecklist.getIdentificationAndSegregationMust2mks());
        System.out.println("identitysegregationremarks" + teaPackerChecklist.getIdentificationAndSegregationRemarks());


        updateData.setRecordID(Integer.parseInt(teaPackerChecklist.getAFA_TD_Inspection_Checklist_ID()));
        try {
            if (null != teaPackerChecklist.getCompanyRegMandatory10mks() && Integer.parseInt(teaPackerChecklist.getCompanyRegMandatory10mks()) == 0) {
                major++;
            }

            if (null != teaPackerChecklist.getBusinessPermitMust3mks() && Integer.parseInt(teaPackerChecklist.getBusinessPermitMust3mks()) == 0) {
                minor++;
            }

            if (null != teaPackerChecklist.getHealthCertificateMandatory10mks() && Integer.parseInt(teaPackerChecklist.getHealthCertificateMandatory10mks()) == 0) {
                major++;
            }

            if (null != teaPackerChecklist.getExternalSiteStandardsMandatory10mks() && Integer.parseInt(teaPackerChecklist.getExternalSiteStandardsMandatory10mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getSecurityAccessReccomm() && Integer.parseInt(teaPackerChecklist.getSecurityAccessReccomm()) == 0) {
                observation++;
            }
            if (null != teaPackerChecklist.getLayoutCALIBRATIONMust2mks() && Integer.parseInt(teaPackerChecklist.getLayoutCALIBRATIONMust2mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getWallsMust3mks() && Integer.parseInt(teaPackerChecklist.getWallsMust3mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getFloorsMust3mks() && Integer.parseInt(teaPackerChecklist.getFloorsMust3mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getRoofCeilingMust3mks() && Integer.parseInt(teaPackerChecklist.getRoofCeilingMust3mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getWindowsRecom1mk() && Integer.parseInt(teaPackerChecklist.getWindowsRecom1mk()) == 0) {
                observation++;
            }
            if (null != teaPackerChecklist.getDoorsRecom1mk() && Integer.parseInt(teaPackerChecklist.getDoorsRecom1mk()) == 0) {
                observation++;
            }
            if (null != teaPackerChecklist.getAdequateLightingMust3mks() && Integer.parseInt(teaPackerChecklist.getAdequateLightingMust3mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getVentilationRecom1mks() && Integer.parseInt(teaPackerChecklist.getVentilationRecom1mks()) == 0) {
                observation++;
            }
            if (null != teaPackerChecklist.getEquipmentCleanlinessMust3mks() && Integer.parseInt(teaPackerChecklist.getEquipmentCleanlinessMust3mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getChangingroomsMust3mks() && Integer.parseInt(teaPackerChecklist.getChangingroomsMust3mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getRiskOfChemicalMust3mks() && Integer.parseInt(teaPackerChecklist.getRiskOfChemicalMust3mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getWasteTeaDisposalMust3mks() && Integer.parseInt(teaPackerChecklist.getWasteTeaDisposalMust3mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getPestControlProgramMust3mks() && Integer.parseInt(teaPackerChecklist.getPestControlProgramMust3mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getProperStorageRecom1mk() && Integer.parseInt(teaPackerChecklist.getProperStorageRecom1mk()) == 0) {
                observation++;
            }
            if (null != teaPackerChecklist.getPackagingMaterialConfirmityMust2mks() && Integer.parseInt(teaPackerChecklist.getPackagingMaterialConfirmityMust2mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getIdentificationAndSegregationMust2mks() && Integer.parseInt(teaPackerChecklist.getIdentificationAndSegregationMust2mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getEquipmentIdentificationAndCalibrationMust3mks() && Integer.parseInt(teaPackerChecklist.getEquipmentIdentificationAndCalibrationMust3mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getTraceabilitySystemMandatory10mks() && Integer.parseInt(teaPackerChecklist.getTraceabilitySystemMandatory10mks()) == 0) {
                major++;
            }
            if (null != teaPackerChecklist.getProcessDocumentsMust3mks() && Integer.parseInt(teaPackerChecklist.getProcessDocumentsMust3mks()) == 0) {
                minor++;
            }
            if (null != teaPackerChecklist.getValidMedicalCertMandatory10mks() && Integer.parseInt(teaPackerChecklist.getValidMedicalCertMandatory10mks()) == 0) {
                major++;
            }
            if (null != teaPackerChecklist.getCleanPersonalProtectiveMndatory10mks() && Integer.parseInt(teaPackerChecklist.getCleanPersonalProtectiveMndatory10mks()) == 0) {
                major++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        data.addField("iscertificateofcompanyreg", teaPackerChecklist.getIsCertCompanyReg());
        data.addField("certificateofcompanyregmarks", teaPackerChecklist.getCompanyRegMandatory10mks());
        data.addField("certificateofcompanyregremarks", teaPackerChecklist.getCompanyRegRemarks());
        data.addField("isbusinesspermit", teaPackerChecklist.getIsBusinessPermit());
        data.addField("businesspermitmarks", teaPackerChecklist.getBusinessPermitMust3mks());
        data.addField("businesspermitremaks", teaPackerChecklist.getBusinessPermitRemarks());
        data.addField("ishealthcertificate", teaPackerChecklist.getIsHealthCertificate());
        data.addField("healthcertificatemarks", teaPackerChecklist.getHealthCertificateMandatory10mks());
        data.addField("healthcertificateremarks", teaPackerChecklist.getHealthCertificateRemarks());
        data.addField("isexternalsitestds", teaPackerChecklist.getIsExternalSiteStandards());
        data.addField("externalsitestdsmarks", teaPackerChecklist.getExternalSiteStandardsMandatory10mks());
        data.addField("externalsitestdsremarks", teaPackerChecklist.getExternalSiteStandardsRemarks());
        data.addField("issecurityaccess", teaPackerChecklist.getIsSecurityAccess());
        data.addField("securityaccessmarks", teaPackerChecklist.getSecurityAccessReccomm());
        data.addField("securityaccessremarks", teaPackerChecklist.getSecurityAccessRemarks());
        data.addField("islayout_segregation", teaPackerChecklist.getIsLayoutCALIBRATION());
        data.addField("layout_segregationmarks", teaPackerChecklist.getLayoutCALIBRATIONMust2mks());
        data.addField("layout_segregationremarks", teaPackerChecklist.getLayoutCALIBRATIONRemarks());
        data.addField("iswalls", teaPackerChecklist.getIsWalls());
        data.addField("wallmarks", teaPackerChecklist.getWallsMust3mks());
        data.addField("wallremarks", teaPackerChecklist.getWallsRemarks());
        data.addField("isfloors", teaPackerChecklist.getIsFloors());
        data.addField("floormarks", teaPackerChecklist.getFloorsMust3mks());
        data.addField("floorremarks", teaPackerChecklist.getFloorsRemarks());
        data.addField("isroof_ceiling", teaPackerChecklist.getIsRoofCeiling());
        data.addField("roof_ceilingmarks", teaPackerChecklist.getRoofCeilingMust3mks());
        data.addField("roof_ceilingremarks", teaPackerChecklist.getRoofCeilingRemarks());
        data.addField("iswindows", teaPackerChecklist.getIsWindows());
        data.addField("windowmarks", teaPackerChecklist.getWindowsRecom1mk());
        data.addField("windowremarks", teaPackerChecklist.getWindowsRemarks());
        data.addField("isdoors", teaPackerChecklist.getIsDoors());
        data.addField("doormarks", teaPackerChecklist.getDoorsRecom1mk());
        data.addField("doorremarks", teaPackerChecklist.getDoorsRemarks());
        data.addField("isadequatelighting", teaPackerChecklist.getIsAdequatelighting());
        data.addField("adequatelightmarks", teaPackerChecklist.getAdequateLightingMust3mks());
        data.addField("adequatelightremarks", teaPackerChecklist.getAdequateLightingRemarks());
        data.addField("isventilation", teaPackerChecklist.getIsVentilation());
        data.addField("ventmarks", teaPackerChecklist.getVentilationRecom1mks());
        data.addField("ventremarks", teaPackerChecklist.getVentilationRemarks());
        data.addField("isequipmentcleaniness", teaPackerChecklist.getIsEquipmentCleanliness());
        data.addField("equipmentcleanmarks", teaPackerChecklist.getEquipmentCleanlinessMust3mks());
        data.addField("equipmentcleanremarks", teaPackerChecklist.getEquipmentCleanlinessRemarks());
        data.addField("ischangeroom", teaPackerChecklist.getIsChangingrooms());
        data.addField("changeroommarks", teaPackerChecklist.getChangingroomsMust3mks());
        data.addField("changeroomremarks", teaPackerChecklist.getChangingroomsRemarks());
        data.addField("isriskofchems", teaPackerChecklist.getIsRiskOfChemical());
        data.addField("riskofchemsmarks", teaPackerChecklist.getRiskOfChemicalMust3mks());
        data.addField("riskofchemsremarks", teaPackerChecklist.getRiskOfChemicalRemarks());
        data.addField("iswastedisposal", teaPackerChecklist.getIsWasteTeaDisposal());
        data.addField("wastediposalmarks", teaPackerChecklist.getWasteTeaDisposalMust3mks());
        data.addField("wastedisposalremarks", teaPackerChecklist.getWasteTeaDisposalRemarks());
        data.addField("ispestcontrol", teaPackerChecklist.getIsPestControlProgram());
        data.addField("pestcontrolmarks", teaPackerChecklist.getPestControlProgramMust3mks());
        data.addField("pestcontrolremaks", teaPackerChecklist.getPestControlProgramRemarks());
        data.addField("ispropersttorage", teaPackerChecklist.getIsProperStorage());
        data.addField("properstoragemarks", teaPackerChecklist.getProperStorageRecom1mk());
        data.addField("properstorageremarks", teaPackerChecklist.getProperStorageRemarks());
        data.addField("ispackconformity", teaPackerChecklist.getIsPackagingMaterialConfirmity());
        data.addField("packconformitymarks", teaPackerChecklist.getPackagingMaterialConfirmityMust2mks());
        data.addField("packconformityremarks", teaPackerChecklist.getPackagingMaterialConfirmityRemarks());
        data.addField("isidentitysegregation", teaPackerChecklist.getIsIdentificationAndSegregation());
        data.addField("identitysegregationmarks", teaPackerChecklist.getIdentificationAndSegregationMust2mks());
        data.addField("identitysegregationremarks", teaPackerChecklist.getIdentificationAndSegregationRemarks());
        data.addField("isequipmentidentity", teaPackerChecklist.getIsEquipmentIdentificationAndCalibration());
        data.addField("equipmentidentitymarks", teaPackerChecklist.getEquipmentIdentificationAndCalibrationMust3mks());
        data.addField("equipmentidentityremark", teaPackerChecklist.getEquipmentIdentificationAndCalibrationRemarks());
        data.addField("istracesystem", teaPackerChecklist.getIsTraceabilitySystem());
        data.addField("tracesystemmarks", teaPackerChecklist.getTraceabilitySystemMandatory10mks());
        data.addField("tracesystemremarks", teaPackerChecklist.getTraceabilitySystemRemarks());
        data.addField("isprocessdocuments", teaPackerChecklist.getIsProcessDocuments());
        data.addField("processdocmarks", teaPackerChecklist.getProcessDocumentsMust3mks());
        data.addField("processdocremarks", teaPackerChecklist.getProcessDocumentsRemarks());
        data.addField("ismedicalcert", teaPackerChecklist.getIsValidMedicalCert());
        data.addField("medicalcertmarks", teaPackerChecklist.getValidMedicalCertMandatory10mks());
        data.addField("medicalertremarks", teaPackerChecklist.getValidMedicalCertRemarks());
        data.addField("isprotectiveequips", teaPackerChecklist.getIsCleanPersonalProtective());
        data.addField("protectiveequipmarks", teaPackerChecklist.getCleanPersonalProtectiveMndatory10mks());
        data.addField("protectiveequipremarks", teaPackerChecklist.getCleanPersonalProtectiveRemarks());
        data.addField("major_marks", major);
        data.addField("minor_marks", minor);
        data.addField("observation_marks", observation);
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("IsApproved", "Y");
        data.addField("ismobile", "Y");
        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateTeapackerSent(teaPackerChecklist.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void postCoffeRecords(CoffeeNursercertInsp coffeeNursercertInspList) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateCoffeeNurseryInspectionRecords");


        System.out.println("the local ID to be pushed " + coffeeNursercertInspList.getLocalID());

        System.out.println("isokcounty" + coffeeNursercertInspList.getCountyIsCorrect());
        System.out.println("remarkcounty" + coffeeNursercertInspList.getCountyRemarks());

        System.out.println("isoksubcounty" + coffeeNursercertInspList.getSub_countyIsCorrect());
        System.out.println("remarksubcounty" + coffeeNursercertInspList.getSub_countyRemarks());

        System.out.println("isoklocation" + coffeeNursercertInspList.getLocationIsCorrect());
        System.out.println("remarklocation" + coffeeNursercertInspList.getLocationRemarks());

        System.out.println("isoksublocation" + coffeeNursercertInspList.getSub_locationIsCorrect());
        System.out.println("remarksublocation" + coffeeNursercertInspList.getSub_locationRemarks());

        System.out.println("sokvillage" + coffeeNursercertInspList.getVillageIsCorrect());
        System.out.println("remarkvillage" + coffeeNursercertInspList.getVillageRemarks());
        System.out.println("isoktitledeed" + coffeeNursercertInspList.getTitledeedIsTitledeed());
        System.out.println("remarktitledeed" + coffeeNursercertInspList.getTitledeedRemarks());
        System.out.println("coffeeacreage" + coffeeNursercertInspList.getCoffeeacreage());
        System.out.println("production" + coffeeNursercertInspList.getProduction());
        System.out.println("remarktitledeed" + coffeeNursercertInspList.getNurserycategory());
        System.out.println("isoknurserycategory" + coffeeNursercertInspList.getNaurseryCategoryIsNursery());
        System.out.println("remarknurserycategory" + coffeeNursercertInspList.getNurserycategoryRemarks());
        System.out.println("sitesuitability" + coffeeNursercertInspList.getSiteSuitability());
        System.out.println("siteaccessibility" + coffeeNursercertInspList.getSiteAccessibilty());
        System.out.println("wateravailability" + coffeeNursercertInspList.getWaterAvailability());
        System.out.println("techknowhow" + coffeeNursercertInspList.getTechnicalKnowHow());
        System.out.println("officerrecom" + coffeeNursercertInspList.getAdvisoryOfficers());
        System.out.println("grouprecom" + coffeeNursercertInspList.getGroupReccomendations());


        updateData.setRecordID(Integer.parseInt(coffeeNursercertInspList.getAfa_cd_inspection_id()));


        data.addField("isokcounty", coffeeNursercertInspList.getCountyIsCorrect());
        data.addField("remarkcounty", coffeeNursercertInspList.getCountyRemarks());
        data.addField("isoksubcounty", coffeeNursercertInspList.getSub_countyIsCorrect());
        data.addField("remarksubcounty", coffeeNursercertInspList.getSub_countyRemarks());
        data.addField("isoklocation", coffeeNursercertInspList.getLocationIsCorrect());
        data.addField("remarklocation", coffeeNursercertInspList.getLocationRemarks());
        data.addField("isoksublocation", coffeeNursercertInspList.getSub_locationIsCorrect());
        data.addField("remarksublocation", coffeeNursercertInspList.getSub_locationRemarks());
        data.addField("isokvillage", coffeeNursercertInspList.getVillageIsCorrect());
        data.addField("remarkvillage", coffeeNursercertInspList.getVillageRemarks());
        data.addField("isoktitledeed", coffeeNursercertInspList.getTitledeedIsTitledeed());
        data.addField("remarktitledeed", coffeeNursercertInspList.getTitledeedRemarks());
        data.addField("coffeeacreage", coffeeNursercertInspList.getCoffeeacreage());
        data.addField("production", coffeeNursercertInspList.getProduction());
//        data.addField("remarktitledeed", coffeeNursercertInspList.getNurserycategory());
        data.addField("isoknurserycategory", coffeeNursercertInspList.getNaurseryCategoryIsNursery());
        data.addField("remarknurserycategory", coffeeNursercertInspList.getNurserycategoryRemarks());
        data.addField("sitesuitability", coffeeNursercertInspList.getSiteSuitability());
        data.addField("siteaccessibility", coffeeNursercertInspList.getSiteAccessibilty());
        data.addField("wateravailability", coffeeNursercertInspList.getWaterAvailability());
        data.addField("techknowhow", coffeeNursercertInspList.getTechnicalKnowHow());
        data.addField("officerrecom", coffeeNursercertInspList.getAdvisoryOfficers());
        data.addField("grouprecom", coffeeNursercertInspList.getGroupReccomendations());
        data.addField("recommendation", coffeeNursercertInspList.getOfficerrecommendation());
        data.addField("recommendation_remarks", coffeeNursercertInspList.getOfficerrecommendation_remark());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateCoffeeNurseyInspectionSent(coffeeNursercertInspList.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void postcoffeePulpinglicenceApllPSLRecords(CoffeePulpinglicenceApllPSL coffeePulpinglicenceApllPSL) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("updateCoffeePSLLicenceAppPSL");

        System.out.println("the local ID to be pushed " + coffeePulpinglicenceApllPSL.getLocalID());

        System.out.println("getAfa_cd_inspection_id" + coffeePulpinglicenceApllPSL.getAfa_cd_PSL_id());
        System.out.println("getLocalID" + coffeePulpinglicenceApllPSL.getLocalID());
        System.out.println("getdocumne date" + coffeePulpinglicenceApllPSL.getDocument_number());
        System.out.println("getdocument number" + coffeePulpinglicenceApllPSL.getVisited_date());
        System.out.println("getapplicant name" + coffeePulpinglicenceApllPSL.getName_of_applicant());
        System.out.println("cert num" + coffeePulpinglicenceApllPSL.getLicence_number());


        if (!TextUtils.isEmpty(coffeePulpinglicenceApllPSL.getAfa_cd_PSL_id()) && TextUtils.isDigitsOnly(coffeePulpinglicenceApllPSL.getAfa_cd_PSL_id())) {
            updateData.setRecordID(Integer.parseInt(coffeePulpinglicenceApllPSL.getAfa_cd_PSL_id()));
        }

        data.addField("coffeearea", coffeePulpinglicenceApllPSL.getAreaUnderCoffee());
        data.addField("pulpmachinetype", coffeePulpinglicenceApllPSL.getPulpingMachine());
        data.addField("isskindryingtables", coffeePulpinglicenceApllPSL.getIsSkinDryingTable());
        data.addField("skindryingtables", coffeePulpinglicenceApllPSL.getSkinDryingTableremarks());
        data.addField("isdryingtables", coffeePulpinglicenceApllPSL.getIsDryingTable());
        data.addField("dryingtables", coffeePulpinglicenceApllPSL.getDryingTableremarks());
        data.addField("isferment_tanks", coffeePulpinglicenceApllPSL.getIsFarmentationTable());
        data.addField("ferment_tanks", coffeePulpinglicenceApllPSL.getFarmentationTableremarks());
        data.addField("issoak_tanks", coffeePulpinglicenceApllPSL.getIsSoaktanks());
        data.addField("soaktanks", coffeePulpinglicenceApllPSL.getSoakTanksremarks());
        data.addField("isparch_bunistore", coffeePulpinglicenceApllPSL.getIsParcmentBuniStore());
        data.addField("parch_bunistore", coffeePulpinglicenceApllPSL.getParcmentBuniStoreremarks());
        data.addField("wastemgtplan", coffeePulpinglicenceApllPSL.getWasteAndPollutionsremarks());
        data.addField("advisoryofficerrecom", coffeePulpinglicenceApllPSL.getCoffeeAdvisoryOfficers());
        data.addField("countyrecomm", coffeePulpinglicenceApllPSL.getReccommendationsFromCOWG());
        data.addField("otherremarks", coffeePulpinglicenceApllPSL.getOthersRemrks());
        data.addField("recommendation", coffeePulpinglicenceApllPSL.getOfficerrecommendation());
        data.addField("recommendation_remarks", coffeePulpinglicenceApllPSL.getOfficerrecommendation_remark());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");
        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println("psl " + response.getErrorMessage());
            } else {

                System.out.println("RecordID psl: " + response.getRecordID());

                db.updateCoffeePulpingPSLSent(coffeePulpinglicenceApllPSL.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("psl " + e.getMessage());

        }
    }


    public void postCoffeeMillerLicenceApplication(CoffeeMillerLicenceApplicationDetails coffeeMillerLicenceApplicationDetails) {

        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateCoffeeMillerLicenceApplication");

        System.out.println("the local ID to be pushed " + coffeeMillerLicenceApplicationDetails.getLocalID());

        System.out.println("AFA_CD_Millerrchecklist_ID" + coffeeMillerLicenceApplicationDetails.getAFA_CD_Millerrchecklist_ID());
        System.out.println("getLocalID" + coffeeMillerLicenceApplicationDetails.getLocalID());
        System.out.println("getdocumne date" + coffeeMillerLicenceApplicationDetails.getDocumentDate());
        System.out.println("getdocument number" + coffeeMillerLicenceApplicationDetails.getDocumentNumber());
        System.out.println("getapplicant name" + coffeeMillerLicenceApplicationDetails.getApplicantName());
        System.out.println("licence_number" + coffeeMillerLicenceApplicationDetails.getLicenceNumber());

        if (!TextUtils.isEmpty(coffeeMillerLicenceApplicationDetails.getAFA_CD_Millerrchecklist_ID()) && TextUtils.isDigitsOnly(coffeeMillerLicenceApplicationDetails.getAFA_CD_Millerrchecklist_ID())) {
            updateData.setRecordID(Integer.parseInt(coffeeMillerLicenceApplicationDetails.getAFA_CD_Millerrchecklist_ID()));
        }

        data.addField("office_condtn", coffeeMillerLicenceApplicationDetails.getOfficeCondition());
        data.addField("isnema_cert", coffeeMillerLicenceApplicationDetails.getNemaCertification());
        data.addField("nema_cert", coffeeMillerLicenceApplicationDetails.getNemaCertificationFindings());
        data.addField("ishealthcert", coffeeMillerLicenceApplicationDetails.getOccupationalSafety());
        data.addField("healthcert", coffeeMillerLicenceApplicationDetails.getOccupationalSafetyFindings());
        data.addField("ismachinerystatus", coffeeMillerLicenceApplicationDetails.getMillingMachinery());
        data.addField("machinerystatus", coffeeMillerLicenceApplicationDetails.getMillingMachineryFindings());
        data.addField("iswastedisposal", coffeeMillerLicenceApplicationDetails.getWasteTeas());
        data.addField("wastedisposal", coffeeMillerLicenceApplicationDetails.getWasteTeasFindings());
        data.addField("iscuppingfacilities", coffeeMillerLicenceApplicationDetails.getLiqouringCupping());
        data.addField("cuppingfacilities", coffeeMillerLicenceApplicationDetails.getLiqouringCuppingFindings());
        data.addField("isqualfdliquoer", coffeeMillerLicenceApplicationDetails.getEngagementQualified());
        data.addField("qualfdliquoer", coffeeMillerLicenceApplicationDetails.getEngagementQualifiedFindings());
        data.addField("isprotectivecloth", coffeeMillerLicenceApplicationDetails.getProtectiveClothing());
        data.addField("protectivecloth", coffeeMillerLicenceApplicationDetails.getProtectiveClothingFindings());
        data.addField("iscalibration", coffeeMillerLicenceApplicationDetails.getWeighingScale());
        data.addField("calibration", coffeeMillerLicenceApplicationDetails.getWeighingScaleFindings());
        data.addField("isvalidinsurance", coffeeMillerLicenceApplicationDetails.getValidInsurance());
        data.addField("validinsurance", coffeeMillerLicenceApplicationDetails.getValidInsuranceFindings());
        data.addField("issecurity", coffeeMillerLicenceApplicationDetails.getGeneralSecurity());
        data.addField("securityy", coffeeMillerLicenceApplicationDetails.getGeneralSecurityFindings());
        data.addField("ismillingagree", coffeeMillerLicenceApplicationDetails.getGrowersContracted());
        data.addField("millingagree", coffeeMillerLicenceApplicationDetails.getGrowersContractedFindings());
        data.addField("ismillingreturns", coffeeMillerLicenceApplicationDetails.getMillingReturns());
        data.addField("millingreturns", coffeeMillerLicenceApplicationDetails.getMillingReturnsFindings());
        data.addField("iswalls", coffeeMillerLicenceApplicationDetails.getWalls());
        data.addField("walls", coffeeMillerLicenceApplicationDetails.getWallsFindings());
        data.addField("isfloors", coffeeMillerLicenceApplicationDetails.getFloors());
        data.addField("floors", coffeeMillerLicenceApplicationDetails.getFloorsFindings());
        data.addField("isroofs", coffeeMillerLicenceApplicationDetails.getRoof());
        data.addField("roofs", coffeeMillerLicenceApplicationDetails.getRoofFindings());
        data.addField("isventilation", coffeeMillerLicenceApplicationDetails.getVentilation());
        data.addField("ventilation", coffeeMillerLicenceApplicationDetails.getVentilationFindings());
        data.addField("iswashrooms", coffeeMillerLicenceApplicationDetails.getWashroom());
        data.addField("washrooms", coffeeMillerLicenceApplicationDetails.getWashroomFindings());
        data.addField("isbaggingmaterials", coffeeMillerLicenceApplicationDetails.getCoffeePackaging());
        data.addField("baggingmaterials", coffeeMillerLicenceApplicationDetails.getCoffeePackagingFindings());
        data.addField("ishygiene", coffeeMillerLicenceApplicationDetails.getGeneralHygiene());
        data.addField("hygiene", coffeeMillerLicenceApplicationDetails.getGeneralHygieneFindings());
        data.addField("isfirefighting", coffeeMillerLicenceApplicationDetails.getFirefighting());
        data.addField("firefighting", coffeeMillerLicenceApplicationDetails.getFirefightingFindings());
        data.addField("recommendation", coffeeMillerLicenceApplicationDetails.getOfficerrecommendation());
        data.addField("recommendation_remarks", coffeeMillerLicenceApplicationDetails.getOfficerrecommendation_remark());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateCoffeeMillerLicenseSent(coffeeMillerLicenceApplicationDetails.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void postCoffeeGrowerMarketingAgent(CoffeeGrowerMarketingAgentDetails coffeeGrowerMarketingAgentDetails) {

        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateCoffeeGrowerMarketingAgent");

        System.out.println("the local ID to be pushed " + coffeeGrowerMarketingAgentDetails.getLocalID());

        System.out.println("getAFA_CD_Growermarkchecklist_ID" + coffeeGrowerMarketingAgentDetails.getAFA_CD_Growermarkchecklist_ID());
        System.out.println("getLocalID" + coffeeGrowerMarketingAgentDetails.getLocalID());
        System.out.println("getdocumne date" + coffeeGrowerMarketingAgentDetails.getDocumentDate());
        System.out.println("getdocument number" + coffeeGrowerMarketingAgentDetails.getDocumentNumber());
        System.out.println("getapplicant name" + coffeeGrowerMarketingAgentDetails.getApplicantName());
        System.out.println("licence_number" + coffeeGrowerMarketingAgentDetails.getLicenceNumber());


        if (!TextUtils.isEmpty(coffeeGrowerMarketingAgentDetails.getAFA_CD_Growermarkchecklist_ID()) && TextUtils.isDigitsOnly(coffeeGrowerMarketingAgentDetails.getAFA_CD_Growermarkchecklist_ID())) {
            updateData.setRecordID(Integer.parseInt(coffeeGrowerMarketingAgentDetails.getAFA_CD_Growermarkchecklist_ID()));
        }

        data.addField("isclearmarking1", coffeeGrowerMarketingAgentDetails.getIsMarkings());

        data.addField("isclearmarking1", coffeeGrowerMarketingAgentDetails.getIsMarkings());
        data.addField("remarks1", coffeeGrowerMarketingAgentDetails.getIsMarkingsRemarks());
        data.addField("isvalidlicense", coffeeGrowerMarketingAgentDetails.getIsCoffeeDirectorate());
        data.addField("remarks2", coffeeGrowerMarketingAgentDetails.getIsCoffeeDirectorateRemarks());
        data.addField("ispermitissued", coffeeGrowerMarketingAgentDetails.getIsSingleBusinessPermit());
        data.addField("remarks4", coffeeGrowerMarketingAgentDetails.getIsSingleBusinessPermitRemarks());
        data.addField("isinplace", coffeeGrowerMarketingAgentDetails.getIsWasteDisposalSystems());
        data.addField("remarks3", coffeeGrowerMarketingAgentDetails.getIsWasteDisposalSystemsRemarks());
        data.addField("isserviced", coffeeGrowerMarketingAgentDetails.getIsFireFightingEquipment());
        data.addField("remarks5", coffeeGrowerMarketingAgentDetails.getIsFireFightingEquipmentRemarks());
        data.addField("issatisfactory", coffeeGrowerMarketingAgentDetails.getIsGeneralHygieneSatisfactory());
        data.addField("remarks6", coffeeGrowerMarketingAgentDetails.getIsGeneralHygieneSatisfactoryRemarks());
        data.addField("isclean", coffeeGrowerMarketingAgentDetails.getIsWashingRoomsClean());
        data.addField("remarks7", coffeeGrowerMarketingAgentDetails.getIsWashingRoomsCleanRemarks());
        data.addField("issupplied", coffeeGrowerMarketingAgentDetails.getIsCleanWaterSupplied());
        data.addField("remarks8", coffeeGrowerMarketingAgentDetails.getIsCleanWaterSuppliedRemarks());
        data.addField("issupplied1", coffeeGrowerMarketingAgentDetails.getIsElectricitySupplied());
        data.addField("remarks9", coffeeGrowerMarketingAgentDetails.getIsElectricitySuppliedRemarks());
        data.addField("isremitted", coffeeGrowerMarketingAgentDetails.getIsReturnsToCoffeeDirectorate());
        data.addField("remarks10", coffeeGrowerMarketingAgentDetails.getIsReturnsToCoffeeDirectorateRemarks());
        data.addField("isplace10", coffeeGrowerMarketingAgentDetails.getIsTraceabilitySystem());
        data.addField("remarks11", coffeeGrowerMarketingAgentDetails.getIsTraceabilitySystemRemarks());
        data.addField("ispalce12", coffeeGrowerMarketingAgentDetails.getIsCuppingFacilities());
        data.addField("remarks12", coffeeGrowerMarketingAgentDetails.getIsCuppingFacilitiesRemarks());
        data.addField("isvalidcert", coffeeGrowerMarketingAgentDetails.getIsOccupationalHealth());
        data.addField("remarks13", coffeeGrowerMarketingAgentDetails.getIsOccupationalHealthRemarks());
        data.addField("isdone", coffeeGrowerMarketingAgentDetails.getIsPayementToGrowers());
        data.addField("remarks14", coffeeGrowerMarketingAgentDetails.getIsPayementToGrowersRemarks());
        data.addField("ispalce13", coffeeGrowerMarketingAgentDetails.getIsStandardOutTurn());
        data.addField("remarks15", coffeeGrowerMarketingAgentDetails.getIsStandardOutTurnRemarks());
        data.addField("ispalce14", coffeeGrowerMarketingAgentDetails.getIsStandardDirect());
        data.addField("remarks16", coffeeGrowerMarketingAgentDetails.getIsStandardDirectRemarks());
        data.addField("recommendation", coffeeGrowerMarketingAgentDetails.getOfficerrecommendation());
        data.addField("recommendation_remarks", coffeeGrowerMarketingAgentDetails.getOfficerrecommendation_remark());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateCoffeeGrowerMarketingAgentSent(coffeeGrowerMarketingAgentDetails.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void postCoffeeExporterDealerInspection(CoffeeExporterDealerInspectionDetails coffeeExporterDealerInspectionDetails) {

        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateExporterDealerInspection");

        System.out.println("the local ID to be pushed " + coffeeExporterDealerInspectionDetails.getLocalID());

        System.out.println("getAFA_CD_DealerChecklist_ID" + coffeeExporterDealerInspectionDetails.getAFA_CD_DealerChecklist_ID());
        System.out.println("getLocalID" + coffeeExporterDealerInspectionDetails.getLocalID());
        System.out.println("getdocumne date" + coffeeExporterDealerInspectionDetails.getDocumentDate());
        System.out.println("getdocument number" + coffeeExporterDealerInspectionDetails.getDocumentNumber());
        System.out.println("getapplicant name" + coffeeExporterDealerInspectionDetails.getApplicantName());
        System.out.println("licence_number" + coffeeExporterDealerInspectionDetails.getDealerLicenceNumber());


        if (!TextUtils.isEmpty(coffeeExporterDealerInspectionDetails.getAFA_CD_DealerChecklist_ID()) && TextUtils.isDigitsOnly(coffeeExporterDealerInspectionDetails.getAFA_CD_DealerChecklist_ID())) {
            updateData.setRecordID(Integer.parseInt(coffeeExporterDealerInspectionDetails.getAFA_CD_DealerChecklist_ID()));
        }

        data.addField("isclearmarking", coffeeExporterDealerInspectionDetails.getAreMarkingsClear());
        data.addField("remarks2", coffeeExporterDealerInspectionDetails.getAreMarkingsClearRemarks());
        data.addField("isidealoffice", coffeeExporterDealerInspectionDetails.getAreOfficesPremisesIdeal());
        data.addField("remarks1", coffeeExporterDealerInspectionDetails.getAreOfficesPremisesIdealRemarks());
        data.addField("isvalidlicense", coffeeExporterDealerInspectionDetails.getIsCoffeeDirectorateLicenceValid());
        data.addField("remarks3", coffeeExporterDealerInspectionDetails.getIsCoffeeDirectorateLicenceValidRemarks());
        data.addField("ispermitissued", coffeeExporterDealerInspectionDetails.getHasSingleBusinessPermit());
        data.addField("remarks4", coffeeExporterDealerInspectionDetails.getHasSingleBusinessPermitRemarks());
        data.addField("isclearmarking1", coffeeExporterDealerInspectionDetails.getAreMarkingsClear2());
        data.addField("remarks5", coffeeExporterDealerInspectionDetails.getAreMarkingsClear2Remarks());
        data.addField("isinplace", coffeeExporterDealerInspectionDetails.getAreWasteDisposalSystems());
        data.addField("remarks6", coffeeExporterDealerInspectionDetails.getAreWasteDisposalSystemsRemarks());
        data.addField("isinplace1", coffeeExporterDealerInspectionDetails.getAreFireFightingPlace());
        data.addField("remarks7", coffeeExporterDealerInspectionDetails.getAreFireFightingPlaceRemarks());
        data.addField("isserviced", coffeeExporterDealerInspectionDetails.getAreFireFightingServiced());
        data.addField("remarks8", coffeeExporterDealerInspectionDetails.getAreFireFightingServicedRemakrs());
        data.addField("IsAvailable", coffeeExporterDealerInspectionDetails.getIsCleanWaterAvailable());
        data.addField("remarks9", coffeeExporterDealerInspectionDetails.getIsCleanWaterAvailableRemarks());
        data.addField("issatisfactory", coffeeExporterDealerInspectionDetails.getIsGeneralHygieneSatisfactory());
        data.addField("remarks10", coffeeExporterDealerInspectionDetails.getIsGeneralHygieneSatisfactoryRemarks());
        data.addField("isclean", coffeeExporterDealerInspectionDetails.getAreWashingRoomsClean());
        data.addField("remarks11", coffeeExporterDealerInspectionDetails.getAreWashingRoomsCleanRemarks());
        data.addField("issupplied", coffeeExporterDealerInspectionDetails.getIsCleanWaterSupplied());
        data.addField("remarks12", coffeeExporterDealerInspectionDetails.getIsCleanWaterSuppliedRemarks());
        data.addField("issupplied1", coffeeExporterDealerInspectionDetails.getIsElectricitySupplied());
        data.addField("remarks13", coffeeExporterDealerInspectionDetails.getIsElectricitySuppliedRemarks());
        data.addField("isplace2", coffeeExporterDealerInspectionDetails.getIsSampleRoasterInPlace());
        data.addField("remarks14", coffeeExporterDealerInspectionDetails.getIsSampleRoasterInPlaceRemarks());
        data.addField("isplace3", coffeeExporterDealerInspectionDetails.getIsSampleGrinderInPlace());
        data.addField("remarks15", coffeeExporterDealerInspectionDetails.getIsSampleGrinderInPlaceRemarks());
        data.addField("isplace4", coffeeExporterDealerInspectionDetails.getAreSpittingDrumsInPlace());
        data.addField("remarks16", coffeeExporterDealerInspectionDetails.getAreSpittingDrumsInPlaceRemarks());
        data.addField("isplace5", coffeeExporterDealerInspectionDetails.getAreTestingCupsInPlace());
        data.addField("remarks17", coffeeExporterDealerInspectionDetails.getAreTestingCupsInPlaceRemarks());
        data.addField("isplace6", coffeeExporterDealerInspectionDetails.getIsSampleTraysInPlace());
        data.addField("remarks18", coffeeExporterDealerInspectionDetails.getIsSampleTraysInPlaceRemarks());
        data.addField("isplace7", coffeeExporterDealerInspectionDetails.getAreSpoonsInPlace());
        data.addField("remarks19", coffeeExporterDealerInspectionDetails.getAreSpoonsInPlaceRemarks());
        data.addField("isplace8", coffeeExporterDealerInspectionDetails.getIsWaterHeatingSystemInPlace());
        data.addField("remarks20", coffeeExporterDealerInspectionDetails.getIsWaterHeatingSystemInPlaceRemarks());
        data.addField("isplace9", coffeeExporterDealerInspectionDetails.getIsMoistureMeterInPlace());
        data.addField("remarks21", coffeeExporterDealerInspectionDetails.getIsMoistureMeterInPlaceRemarks());
        data.addField("issupplied2", coffeeExporterDealerInspectionDetails.getGetIsCleanWaterSupplied2());
        data.addField("remarks22", coffeeExporterDealerInspectionDetails.getGetIsCleanWaterSupplied2Remarks());
        data.addField("issatisfactory2", coffeeExporterDealerInspectionDetails.getAreWashingRoomsSatisfactory());
        data.addField("remarks23", coffeeExporterDealerInspectionDetails.getAreWashingRoomsSatisfactoryRemarks());
        data.addField("isremitted", coffeeExporterDealerInspectionDetails.getAreReturnsToCoffee());
        data.addField("remarks24", coffeeExporterDealerInspectionDetails.getAreReturnsToCoffeeRemarks());
        data.addField("ishired", coffeeExporterDealerInspectionDetails.getIsLicencedLiquorerHired());
        data.addField("remarks25", coffeeExporterDealerInspectionDetails.getIsLicencedLiquorerHiredRemarks());
        data.addField("isplace10", coffeeExporterDealerInspectionDetails.getIsTraceabilitySystem());
        data.addField("remarks26", coffeeExporterDealerInspectionDetails.getIsTraceabilitySystemRemarks());
        data.addField("isplace11", coffeeExporterDealerInspectionDetails.getAreEnvironmentalEfforts());
        data.addField("remarks27", coffeeExporterDealerInspectionDetails.getAreEnvironmentalEffortsRemarks());
        data.addField("isundertaken", coffeeExporterDealerInspectionDetails.getIsValueAddition());
        data.addField("remarks28", coffeeExporterDealerInspectionDetails.getIsValueAdditionRemarks());
        data.addField("isstandard", coffeeExporterDealerInspectionDetails.getIsPackagignQuality());
        data.addField("remarks29", coffeeExporterDealerInspectionDetails.getIsPackagignQualityRemarks());
        data.addField("recommendation", coffeeExporterDealerInspectionDetails.getOfficerrecommendation());
        data.addField("recommendation_remarks", coffeeExporterDealerInspectionDetails.getOfficerrecommendation_remark());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateCoffeeExporterDealerInspectionSent(coffeeExporterDealerInspectionDetails.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void postFoodProcessingInpection(FoodProcessingInpection foodProcessingInpection) {

        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateFoodProcessingInspection");

        System.out.println("the local ID to be pushed " + foodProcessingInpection.getLocalID());

        System.out.println("AFA_FCD_ManufacturerLic_ID" + foodProcessingInpection.getAFA_FD_FOOD_PROCESSING_Inspection_ID());
        System.out.println("getLocalID" + foodProcessingInpection.getLocalID());
        System.out.println("getdocumne date" + foodProcessingInpection.getDocumentDate());
        System.out.println("getdocument number" + foodProcessingInpection.getDocumentNumber());
        System.out.println("getapplicant name" + foodProcessingInpection.getNameOfApplicant());
        System.out.println("licence_number" + foodProcessingInpection.getFoodCropManufacturingPlanApproval());

        if (!TextUtils.isEmpty(foodProcessingInpection.getAFA_FD_FOOD_PROCESSING_Inspection_ID()) && TextUtils.isDigitsOnly(foodProcessingInpection.getAFA_FD_FOOD_PROCESSING_Inspection_ID())) {
            updateData.setRecordID(Integer.parseInt(foodProcessingInpection.getAFA_FD_FOOD_PROCESSING_Inspection_ID()));
        }

        data.addField("supplier_materials", foodProcessingInpection.getSuppliers_source_raw_materials());
        data.addField("installed_capacity", foodProcessingInpection.getInstalledCapacity());
        data.addField("is_locationdesign", foodProcessingInpection.getIsLocationDesignconstructionStandards());
        data.addField("location_rmks", foodProcessingInpection.getLocationDesignConstructionStandards_remarks());
        data.addField("is_lprpernygiene", foodProcessingInpection.getIsProceduresforensuringPersonalhygieneareinplace());
        data.addField("propernygiene_rmks", foodProcessingInpection.getProceduresforensuringpersonalhygieneareinplace_remarks());
        data.addField("is_hndlingrcv", foodProcessingInpection.getIsProceduresforReceivinghandlingandstorageareinplace());
        data.addField("hndlingrcv_rmks", foodProcessingInpection.getProceduresforreceivinghandlingandstorageareinplace_remarks());
        data.addField("is_monitoringproc", foodProcessingInpection.getIsMonitoringproceduresforPestcontroloftheareinplace());
        data.addField("monitoringproc_rmks", foodProcessingInpection.getMonitoringproceduresforpestcontroloftheareinplace_remarks());
        data.addField("is_sanityproc", foodProcessingInpection.getIsCleaningandsanitizingProceduresinplace());
        data.addField("sanityproc_rmks", foodProcessingInpection.getCleaningandsanitizingproceduresinplace_remarks());
        data.addField("is_calbmeasures", foodProcessingInpection.getIsProceduresdescribingPreventivemaintenanceandcalibration());
        data.addField("calbmeasures_rmks", foodProcessingInpection.getProceduresdescribingpreventivemaintenanceandcalibration_remarks());
        data.addField("is_treacebilityproc", foodProcessingInpection.getIsRecallandTraceabilityprocedures());
        data.addField("treacebilityproc_rmks", foodProcessingInpection.getRecallandtraceabilityprocedures_remarks());
        data.addField("is_watersafet", foodProcessingInpection.getIsWaterSafetymonitoringProcedures());
        data.addField("watersafet_rmks", foodProcessingInpection.getWaterSafetyMonitoringProcedures_remarks());
        data.addField("recommendation", foodProcessingInpection.getRecommendation());
        data.addField("recommendation_remarks", foodProcessingInpection.getRecommendationRemarks());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updatefoodProcessingInpectionSent(foodProcessingInpection.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //food warehouse
    public void postFoodWareHouseInspection(FoodWareHouseInspection foodWareHouseInspection) {

        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateFoodWareHouseInspection");

        System.out.println("the local ID to be pushed " + foodWareHouseInspection.getLocalID());

        System.out.println("AFA_FD_FOOD_WAREHOUSE_Inspection_ID" + foodWareHouseInspection.getAFA_FD_FOOD_WAREHOUSE_Inspection_ID());
        System.out.println("getLocalID" + foodWareHouseInspection.getLocalID());
        System.out.println("getdocumne date" + foodWareHouseInspection.getDocumentDate());
        System.out.println("getdocument number" + foodWareHouseInspection.getDocumentNumber());
        System.out.println("getapplicant name" + foodWareHouseInspection.getNameOfApplicant());
        System.out.println("licence_number" + foodWareHouseInspection.getFoodWarehouselicence());

        if (!TextUtils.isEmpty(foodWareHouseInspection.getAFA_FD_FOOD_WAREHOUSE_Inspection_ID()) && TextUtils.isDigitsOnly(foodWareHouseInspection.getAFA_FD_FOOD_WAREHOUSE_Inspection_ID())) {
            updateData.setRecordID(Integer.parseInt(foodWareHouseInspection.getAFA_FD_FOOD_WAREHOUSE_Inspection_ID()));
        }

        data.addField("lease_agreement", foodWareHouseInspection.getSsleaseagreement());
        data.addField("isgrain_cleaning", foodWareHouseInspection.getIsGraincleaningfacility());
        data.addField("grain_cleaning", foodWareHouseInspection.getGraincleaningfacility_Remarks());
        data.addField("isloadcapacity", foodWareHouseInspection.getIsLoadingCapacity());
        data.addField("loadcapacity", foodWareHouseInspection.getLoadingCapacity_Remarks());
        data.addField("isdrier", foodWareHouseInspection.getIsdrier());
        data.addField("drier", foodWareHouseInspection.getDrier_remarks());
        data.addField("islabroom", foodWareHouseInspection.getIslabroom());
        data.addField("labroom", foodWareHouseInspection.getLabroom_Remarks());
        data.addField("iswall_ventilattion", foodWareHouseInspection.getIsWallandVentilation());
        data.addField("wall_ventilattion", foodWareHouseInspection.getWallandVentilation_Remarks());
        data.addField("iswaterproof", foodWareHouseInspection.getIsWaterproofProvisions());
        data.addField("waterproof_prov", foodWareHouseInspection.getWaterproofProvisions_Remarks());
        data.addField("isinternalsupp", foodWareHouseInspection.getIsInternalSupport());
        data.addField("internalsupp", foodWareHouseInspection.getInternalSupport_Remarks());
        data.addField("isconcretefloor", foodWareHouseInspection.getIsContinuousConcretefloor());
        data.addField("concretefloor", foodWareHouseInspection.getContinuousconcretefloor_Remarks());
        data.addField("isgalvanizedroof", foodWareHouseInspection.getIsCorrugatedgalvanizedRoof());
        data.addField("galvanizedroof", foodWareHouseInspection.getCorrugatedgalvanizedroof_Remarks());
        data.addField("issteeldoors", foodWareHouseInspection.getIsTheNohighGaugesteeldoors());
        data.addField("steeldoors", foodWareHouseInspection.getTheNohighgaugesteeldoors_Remarks());
        data.addField("ishygiene_cleanliness", foodWareHouseInspection.getIsHygieneAndcleanliness());
        data.addField("hygiene_cleanliness", foodWareHouseInspection.getHygieneAndCleanliness_Remarks());
        data.addField("isperimeter_wall", foodWareHouseInspection.getIsPerimeterwallandtruckaccessPavement());
        data.addField("perimeter_wall", foodWareHouseInspection.getPerimeterwallandtruckaccesspavement_Remarks());
        data.addField("isoff_loadingshelter", foodWareHouseInspection.getIsLoadingandoffLoadingshelter());
        data.addField("off_loadingshelter", foodWareHouseInspection.getLoadingandoffloadingshelter_Remarks());
        data.addField("isguard_house", foodWareHouseInspection.getIsGuardHouse());
        data.addField("guard_house", foodWareHouseInspection.getGuardhouse_Remarks());
        data.addField("isfire_extinguisher", foodWareHouseInspection.getIsFireextinguishersmokedetectorsandAlarmsystem());
        data.addField("fire_extinguisher", foodWareHouseInspection.getFireextinguishersmokedetectorsandalarmsystem_remarks());
        data.addField("issecuritylights", foodWareHouseInspection.getIsGuardhouseandsecurityLights());
        data.addField("securitylights", foodWareHouseInspection.getGuardhouseandsecuritylights_remarks());
        data.addField("isweighbridges_scales", foodWareHouseInspection.getIsWeighbridgesandweighingScales());
        data.addField("weighbridges_scales", foodWareHouseInspection.getWeighbridgesandweighingscales_remarks());
        data.addField("isworkingtelephones", foodWareHouseInspection.getIsOfficesworkingtelephonesandinternetacces());
        data.addField("workingtelephones", foodWareHouseInspection.getOfficesworkingtelephonesandinternetaccess_remarks());
        data.addField("iswashfacilities", foodWareHouseInspection.getIsProvisionofWASHfacilitie());
        data.addField("washfacilities", foodWareHouseInspection.getProvisionofWASHfacilities_remarks());
        data.addField("isbooks_accounts", foodWareHouseInspection.getIsBooksofaccount());
        data.addField("books_accounts", foodWareHouseInspection.getBooksofaccounts_remarks());
        data.addField("istraceabilityproc", foodWareHouseInspection.getIsRecallandtraceabilityprocedure());
        data.addField("traceabilityproc", foodWareHouseInspection.getRecallandtraceabilityprocedures_remarks());
        data.addField("recommendation", foodWareHouseInspection.getSsRecomendation());
        data.addField("recommendation_remarks", foodWareHouseInspection.getReasonForThegiveReccomm());
        

        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);


            if (response.getStatus() == Enums.WebServiceResponseStatus.Error)
            {
                System.out.println(response.getErrorMessage());
            }
            else
                {

                System.out.println("RecordID: " + response.getRecordID());

            db.updateFoodWareHouseInspectionSent(foodWareHouseInspection.getLocalID(), response.getRecordID().toString());

                    try {
                        Thread.sleep(9000);
                        updateStatus(foodWareHouseInspection);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                System.out.println();
                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++)
                {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateStatus(FoodWareHouseInspection foodWareHouseInspection){
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        if (!TextUtils.isEmpty(foodWareHouseInspection.getAFA_FD_FOOD_WAREHOUSE_Inspection_ID()) && TextUtils.isDigitsOnly(foodWareHouseInspection.getAFA_FD_FOOD_WAREHOUSE_Inspection_ID())) {
            updateData.setRecordID(Integer.parseInt(foodWareHouseInspection.getAFA_FD_FOOD_WAREHOUSE_Inspection_ID()));
        }
        updateData.setWebServiceType("UpdateFoodWareHouseInspection");
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {


            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //food crop
    public void postFOodCropInspection(FOodCropInspection fOodCropInspection) {

        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateFoodCropInspection");

        System.out.println("the local ID to be pushed " + fOodCropInspection.getLocalID());

        System.out.println("AFA_FD_FOOD_CROP_Inspection_ID" + fOodCropInspection.getAFA_FD_FOOD_Crop_Inspection_ID());
        System.out.println("getLocalID" + fOodCropInspection.getLocalID());
        System.out.println("getdocumne date" + fOodCropInspection.getDocumentDate());
        System.out.println("getdocument number" + fOodCropInspection.getDocumentNumber());
        System.out.println("getapplicant name" + fOodCropInspection.getNameOfApplicant());
        System.out.println("licence_number" + fOodCropInspection.getFoodCropLicence());

        if (!TextUtils.isEmpty(fOodCropInspection.getAFA_FD_FOOD_Crop_Inspection_ID()) && TextUtils.isDigitsOnly(fOodCropInspection.getAFA_FD_FOOD_Crop_Inspection_ID())) {
            updateData.setRecordID(Integer.parseInt(fOodCropInspection.getAFA_FD_FOOD_Crop_Inspection_ID()));
        }

        data.addField("packaging_labelling", fOodCropInspection.getPackagingAndLabelling());
        data.addField("product_standards", fOodCropInspection.getConformityStandards());
        data.addField("source_of_produce", fOodCropInspection.getSourceOfProduce());
        data.addField("recommendation", fOodCropInspection.getRecommendation());
        data.addField("recommendation_remarks", fOodCropInspection.getRecommendationRemarks());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updatefoodCropInpectionSent(fOodCropInspection.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void postFlowersConsolidators(FlowersConsolidators flowersConsolidators) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateflowersConsolidatorsInspection");


        System.out.println("the local ID to be pushed " + flowersConsolidators.getLocalID());


        updateData.setRecordID(Integer.parseInt(flowersConsolidators.getAfa_flower_Consolidators_Checklist_id()));

        data.addField("iscertfdsourcers", flowersConsolidators.getIslistofcomapanycertificate());
        data.addField("certfdsourcersmrk", flowersConsolidators.getListofcomapanycertificateAward());
        data.addField("timeline_cd_measures1", flowersConsolidators.getListofcomapanycertificateTimeline());
        data.addField("certfdsourcersrmk", flowersConsolidators.getListofcomapanycertificateRemarks());
        data.addField("isvalidtysupplierslic", flowersConsolidators.getIsValididtyOfSupplliers());
        data.addField("validtysupplierslicmrk", flowersConsolidators.getValididtyOfSupplliersAward());
        data.addField("timeline_cd_measures2", flowersConsolidators.getValididtyOfSupplliersTimeline());
        data.addField("validtysupplierslicrmrk", flowersConsolidators.getValididtyOfSupplliersRemarks());
        data.addField("iscertification", flowersConsolidators.getIsCertificationToksh1758());
        data.addField("certificationmrk", flowersConsolidators.getCertificationToksh1758Award());
        data.addField("timeline_cd_measures3", flowersConsolidators.getCertificationToksh1758Timeline());
        data.addField("certificationrmk", flowersConsolidators.getCertificationToksh1758Remarks());
        data.addField("iscopyofhcdexptlic", flowersConsolidators.getIsCopyHcdExportlicence());
        data.addField("copyofhcdexptlicmrk", flowersConsolidators.getCopyHcdExportlicenceAward());
        data.addField("timeline_cd_measures4", flowersConsolidators.getCopyHcdExportlicenceTimeline());
        data.addField("copyofhcdexptlicrmk", flowersConsolidators.getCopyHcdExportlicenceRemarks());
        data.addField("isnhtsevidence", flowersConsolidators.getIsEvidenceRegistrationNationalTraceability());
        data.addField("nhtsevidencemrk", flowersConsolidators.getEvidenceRegistrationNationalTraceabilityAward());
        data.addField("timeline_cd_measures5", flowersConsolidators.getEvidenceRegistrationNationalTraceabilityTimeline());
        data.addField("nhtsevidencermk", flowersConsolidators.getEvidenceRegistrationNationalTraceabilityRemarks());
        data.addField("isregsinglewndwsytm", flowersConsolidators.getIsevidenceOfSingleWindow());
        data.addField("regsinglewndwsytmrmk", flowersConsolidators.getEvidenceOfSingleWindowAward());
        data.addField("timeline_cd_measures6", flowersConsolidators.getEvidenceOfSingleWindowTimeline());
        data.addField("regsinglewndwsytmrmrk", flowersConsolidators.getEvidenceOfSingleWindowRemarks());
        data.addField("isevdannualtraining", flowersConsolidators.getIsEvidenceOfAttendanceAnnualtraning());
        data.addField("evdannualtrainingmrk", flowersConsolidators.getEvidenceOfAttendanceAnnualtraningAward());
        data.addField("timeline_cd_measures7", flowersConsolidators.getEvidenceOfAttendanceAnnualtraningTimeline());
        data.addField("evdannualtrainingrmk", flowersConsolidators.getEvidenceOfAttendanceAnnualtraningRemarks());
        data.addField("isspplrvettingmrks", flowersConsolidators.getIsVettingMarksCert());
        data.addField("spplrvettingmrksmrk", flowersConsolidators.getVettingMarksCertAward());
        data.addField("timeline_cd_measures8", flowersConsolidators.getVettingMarksCertTimeline());
        data.addField("spplrvettingmrksrmk", flowersConsolidators.getVettingMarksCertRemarks());
        data.addField("isclearingagtnutil", flowersConsolidators.getIsUtilizationHcd());
        data.addField("clearingagtnutilmrk", flowersConsolidators.getUtilizationHcdAward());
        data.addField("timeline_cd_measures9", flowersConsolidators.getUtilizationHcdTimeline());
        data.addField("clearingagtnutilrmk", flowersConsolidators.getUtilizationHcdRemarks());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");


        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateHCDFlowersConsolidatorsSent(flowersConsolidators.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void postFruitsConsolidators(HCDFruitVegetableConsolidators fruitConsolidators) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdatefruitsConsolidatorsInspection");


        System.out.println("the local ID to be pushed " + fruitConsolidators.getLocalID());


        updateData.setRecordID(Integer.parseInt(fruitConsolidators.getAFA_HCD_Fruit_Vegetable_Consolidators_ID()));

        data.addField("iscertification", fruitConsolidators.getIsCertificationtoKsh1758());
        data.addField("certificationmrk", fruitConsolidators.getSsCertificationtoKsh1758Award());
        data.addField("timeline_cd_measures1", fruitConsolidators.getCertificationtoKsh1758Timeline());
        data.addField("certificationrmk", fruitConsolidators.getCertificationtoKsh1758Remarks());
        data.addField("isotherregstandards", fruitConsolidators.getIsOtherrecognizedStandards());
        data.addField("otherregstandardsmrk", fruitConsolidators.getSsOtherrecognizedStandardsAward());
        data.addField("timeline_cd_measures2", fruitConsolidators.getOtherrecognizedStandardstimeline());
        data.addField("otherregstandardsrmk", fruitConsolidators.getOtherrecognizedStandardsRemarks());
        data.addField("isnhtsevidence", fruitConsolidators.getIsEvidenceofRegonNaionalTraceability());
        data.addField("nhtsevidencemrk", fruitConsolidators.getSsEvidenceofRegonNaionalTraceabilityAward());
        data.addField("timeline_cd_measures3", fruitConsolidators.getEvidenceofRegonNaionalTraceabilityTimeline());
        data.addField("nhtsevidencermk", fruitConsolidators.getEvidenceofRegonNaionalTraceabilityRemarks());
        data.addField("isregsinglewndwsytm", fruitConsolidators.getIsEvidenceofRegSingleWindow());
        data.addField("regsinglewndwsytmrmk", fruitConsolidators.getSsEvidenceofRegSingleWindowAward());
        data.addField("timeline_cd_measures4", fruitConsolidators.getEvidenceofRegSingleWindowTimeline());
        data.addField("regsinglewndwsytmrmrk", fruitConsolidators.getEvidenceofRegSingleWindowRemarks());
        data.addField("iscopyofhcdexptlic", fruitConsolidators.getIsCopyofHcdExportLicence());
        data.addField("copyofhcdexptlicmrk", fruitConsolidators.getSsCopyofHcdExportLicenceAward());
        data.addField("timeline_cd_measures5", fruitConsolidators.getCopyofHcdExportLicenceTimeline());
        data.addField("copyofhcdexptlicrmk", fruitConsolidators.getCopyofHcdExportLicenceRemarks());
        data.addField("islstcontractedfarmers", fruitConsolidators.getIsTraceabilityListContractedfarmers());
        data.addField("lstcontractedfarmmrk", fruitConsolidators.getSsTraceabilityListContractedfarmersAward());
        data.addField("timeline_cd_measures6", fruitConsolidators.getTraceabilityListContractedfarmersTimeline());
        data.addField("lstcontractedfarmrmk", fruitConsolidators.getTraceabilityListContractedfarmersRemarks());
        data.addField("ismktagntdeclare", fruitConsolidators.getIsDeclaremarketingAgent());
        data.addField("mktagntdeclaremrk", fruitConsolidators.getSsDeclaremarketingAgentAward());
        data.addField("timeline_cd_measures7", fruitConsolidators.getDeclaremarketingAgentTimeline());
        data.addField("mktagntdeclarermk", fruitConsolidators.getDeclaremarketingAgentREmarks());
        data.addField("isclearingagtnutil", fruitConsolidators.getIsUtilizationofHCD());
        data.addField("clearingagtnutilmrk", fruitConsolidators.getSsUtilizationofHCDAward());
        data.addField("timeline_cd_measures8", fruitConsolidators.getUtilizationofHCDTimeline());
        data.addField("clearingagtnutilrmk", fruitConsolidators.getUtilizationofHCDRemarks());
        data.addField("isevdsystemplcy", fruitConsolidators.getIsSystemPoliceandProcedure());
        data.addField("evdsystemplcymrk", fruitConsolidators.getSsSystemPoliceandProcedureAward());
        data.addField("timeline_cd_measures9", fruitConsolidators.getSystemPoliceandProcedureTimeline());
        data.addField("evdsystemplcyrmk", fruitConsolidators.getSystemPoliceandProcedureRemarks());
        data.addField("isevdannualtraining", fruitConsolidators.getIsEvidenceOfatendanceOfAnnualTraining());
        data.addField("evdannualtrainingmrk", fruitConsolidators.getSsEvidenceOfatendanceOfAnnualTrainingAward());
        data.addField("timeline_cd_measures10", fruitConsolidators.getEvidenceOfatendanceOfAnnualTraininAwardTimeline());
        data.addField("evdannualtrainingrmk", fruitConsolidators.getEvidenceOfatendanceOfAnnualTrainingRemarks());
        data.addField("isevdannualtrnngmatrix", fruitConsolidators.getIsAnnualTrainingmatrixSchedule());
        data.addField("evdannualtrnngmatrixmrk", fruitConsolidators.getSsAnnualTrainingmatrixScheduleAward());
        data.addField("timeline_cd_measures11", fruitConsolidators.getAnnualTrainingmatrixScheduleTimeline());
        data.addField("evdannualtrnngmatrixrmk", fruitConsolidators.getAnnualTrainingmatrixScheduleRemarks());
        data.addField("isevdpestcontrol", fruitConsolidators.getIsPestDiseasecontrolProcedures());
        data.addField("evdpestcontrolmrk", fruitConsolidators.getSsPestDiseasecontrolProceduresAward());
        data.addField("timeline_cd_measures12", fruitConsolidators.getPestDiseasecontrolProceduresTimeline());
        data.addField("evdpestcontrolrmk", fruitConsolidators.getPestDiseasecontrolProceduresRemarks());
        data.addField("isnon_payment_claim", fruitConsolidators.getIsClaimsOnnonPayment());
        data.addField("non_payment_claimmrk", fruitConsolidators.getSsClaimsOnnonPaymentAward());
        data.addField("timeline_cd_measures13", fruitConsolidators.getClaimsOnnonPaymentTimeline());
        data.addField("non_payment_claimrmk", fruitConsolidators.getClaimsOnnonPaymentRemarks());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");



        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateHCDFruitVegetableConsolidatorsSent(fruitConsolidators.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void postFruitsAndVegetablesExporters(FruitsAndVegetablesExporters fruitsAndVegetablesExporters) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateFruitsAndVegetablesExporters");


        System.out.println("the local ID to be pushed " + fruitsAndVegetablesExporters.getLocalID());


        updateData.setRecordID(Integer.parseInt(fruitsAndVegetablesExporters.getaFA_HCD_Fruits_Vegetables_Exporterse_ID()));

        data.addField("iscertification", fruitsAndVegetablesExporters.getIsCertificationtoKsh1758());
        data.addField("certificationmrk", fruitsAndVegetablesExporters.getCertificationtoKsh1758Award());
        data.addField("timeline_cd_measures1", fruitsAndVegetablesExporters.getCertificationtoKsh1758Timeline());
        data.addField("certificationrmk", fruitsAndVegetablesExporters.getCertificationtoKsh1758Remarks());
        data.addField("isotherregstandards", fruitsAndVegetablesExporters.getIsOtherRecognizedstandards());
        data.addField("otherregstandardsmrk", fruitsAndVegetablesExporters.getOtherRecognizedstandardsAward());
        data.addField("timeline_cd_measures2", fruitsAndVegetablesExporters.getOtherRecognizedstandardsTimeline());
        data.addField("otherregstandardsrmrk", fruitsAndVegetablesExporters.getOtherRecognizedstandardsremarks());
        data.addField("isevidenceregnhts", fruitsAndVegetablesExporters.getIsEvidenceofRegonNaionalTraceability());
        data.addField("evidenceregnhtsmrk", fruitsAndVegetablesExporters.getEvidenceofRegonNaionalTraceabilityAward());
        data.addField("timeline_cd_measures3", fruitsAndVegetablesExporters.getEvidenceofRegonNaionalTraceabilityTimeline());
        data.addField("evidenceregnhtsrmk", fruitsAndVegetablesExporters.getEvidenceofRegonNaionalTraceabilityRemarks());
        data.addField("isregsinglewndwsytm", fruitsAndVegetablesExporters.getIsEvidenceofRegSingleWindow());
        data.addField("regsinglewndwsytmrmk", fruitsAndVegetablesExporters.getEvidenceofRegSingleWindowAward());
        data.addField("timeline_cd_measures4", fruitsAndVegetablesExporters.getEvidenceofRegSingleWindowTimeline());
        data.addField("regsinglewndwsytmrmrk", fruitsAndVegetablesExporters.getEvidenceofRegSingleWindowRemarks());
        data.addField("iscopyofhcdexptlic", fruitsAndVegetablesExporters.getIsCopyOfHcdexportLicence());
        data.addField("copyofhcdexptlicmrk", fruitsAndVegetablesExporters.getCopyOfHcdexportLicenceAward());
        data.addField("timeline_cd_measures5", fruitsAndVegetablesExporters.getCopyOfHcdexportLicenceTimeine());
        data.addField("copyofhcdexptlicrmk", fruitsAndVegetablesExporters.getCopyOfHcdexportLicenceRemarks());
        data.addField("islstcontcdfarmers", fruitsAndVegetablesExporters.getIsTraceablitylistOfTheCompany());
        data.addField("lstcontcdfarmersmrk", fruitsAndVegetablesExporters.getTraceablitylistOfTheCompanyAward());
        data.addField("timeline_cd_measures6", fruitsAndVegetablesExporters.getTraceablitylistOfTheCompanyTimeline());
        data.addField("lstcontcdfarmersrmk", fruitsAndVegetablesExporters.getTraceablitylistOfTheCompanyReamrks());
        data.addField("ismktagntdeclare", fruitsAndVegetablesExporters.getIsDeclareMarketingAgents());
        data.addField("mktagntdeclaremrk", fruitsAndVegetablesExporters.getDeclareMarketingAgentsAward());
        data.addField("timeline_cd_measures7", fruitsAndVegetablesExporters.getDeclareMarketingAgentsTimeline());
        data.addField("mktagntdeclarermk", fruitsAndVegetablesExporters.getDeclareMarketingAgentsRemarks());
        data.addField("isclearingagtnutil", fruitsAndVegetablesExporters.getIsEvidenceOfhcdRegistered());
        data.addField("clearingagtnutilmrk", fruitsAndVegetablesExporters.getEvidenceOfhcdRegisteredAward());
        data.addField("timeline_cd_measures8", fruitsAndVegetablesExporters.getEvidenceOfhcdRegisteredTimeline());
        data.addField("clearingagtnutilrmk", fruitsAndVegetablesExporters.getEvidenceOfhcdRegisteredRemarks());
        data.addField("istrcbltysystemplcy", fruitsAndVegetablesExporters.getIsSystempoliceAndProcedure());
        data.addField("trcbltysystemplcymrk", fruitsAndVegetablesExporters.getSystemPoliceAndProcedureAward());
        data.addField("timeline_cd_measures9", fruitsAndVegetablesExporters.getSystemPoliceAndProcedureTimeline());
        data.addField("trcbltysystemplcyrmk", fruitsAndVegetablesExporters.getSystemPoliceAndProcedureRemarks());
        data.addField("isevdannualtraining", fruitsAndVegetablesExporters.getIsEvidenceofAtendanceOfAnnualTraining());
        data.addField("evdannualtrainingmrk", fruitsAndVegetablesExporters.getEvidenceofAtendanceOfAnnualTrainingAward());
        data.addField("timeline_cd_measures10", fruitsAndVegetablesExporters.getEvidenceofAtendanceOfAnnualTrainingTimeline());
        data.addField("evdannualtrainingrmk", fruitsAndVegetablesExporters.getEvidenceofAtendanceOfAnnualTrainingRemarks());
        data.addField("isannualtrngmatrix", fruitsAndVegetablesExporters.getIsAnnualTrainingmatrixSchedule());
        data.addField("annualtrngmatrixmrk", fruitsAndVegetablesExporters.getAnnualTrainingmatrixScheduleAward());
        data.addField("timeline_cd_measures11", fruitsAndVegetablesExporters.getAnnualTrainingmatrixScheduleTimeline());
        data.addField("annualtrngmatrixrmk", fruitsAndVegetablesExporters.getAnnualTrainingmatrixScheduleRemarks());
        data.addField("isevdpestdiseasecntrl", fruitsAndVegetablesExporters.getIsPestDiseaseControlprocedures());
        data.addField("evdpestdiseasecntrlmrk", fruitsAndVegetablesExporters.getPestDiseaseControlproceduresAward());
        data.addField("timeline_cd_measures12", fruitsAndVegetablesExporters.getPestDiseaseControlproceduresTimeline());
        data.addField("evdpestdiseasecntrlrmk", fruitsAndVegetablesExporters.getPestDiseaseControlproceduresRemarks());
        data.addField("isnonpayment_claim", fruitsAndVegetablesExporters.getIsClaimsonNonPayment());
        data.addField("nonpayment_claimmrk", fruitsAndVegetablesExporters.getClaimsonNonPaymentAward());
        data.addField("timeline_cd_measures13", fruitsAndVegetablesExporters.getClaimsonNonPaymentTimeline());
        data.addField("nonpayment_claimrmk", fruitsAndVegetablesExporters.getClaimsonNonPaymentRemarks());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");


        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateFruitsAndVegetablesExportersSent(fruitsAndVegetablesExporters.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void postcoffeeManagementAgentRecords(CoffeeManagementAgentInsp coffeeManagementAgentInsp) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateCoffeeManagementAgent");

        System.out.println("the local ID to be pushed " + coffeeManagementAgentInsp.getLocalID());

        System.out.println("getAfa_cd_inspection_id" + coffeeManagementAgentInsp.getAFA_CD_Mgtagentchcklist_ID_Coffee());
        System.out.println("getdocumne no" + coffeeManagementAgentInsp.getDocumnet_number());
        System.out.println("getdocument date" + coffeeManagementAgentInsp.getDocument_date());
        System.out.println("getapplicant name" + coffeeManagementAgentInsp.getC_BPartner_ID());
        System.out.println("getLicence_no" + coffeeManagementAgentInsp.getLicence_no());


        if (!TextUtils.isEmpty(coffeeManagementAgentInsp.getAFA_CD_Mgtagentchcklist_ID_Coffee()) && TextUtils.isDigitsOnly(coffeeManagementAgentInsp.getAFA_CD_Mgtagentchcklist_ID_Coffee())) {
            updateData.setRecordID(Integer.parseInt(coffeeManagementAgentInsp.getAFA_CD_Mgtagentchcklist_ID_Coffee()));
        }
        data.addField("mgt_profile", coffeeManagementAgentInsp.getManagementPerformanceProf());
        data.addField("financial_pstn", coffeeManagementAgentInsp.getFinancialPosition());
        data.addField("relvnt_eqpment", coffeeManagementAgentInsp.getRelevantEquipments());
        data.addField("services", coffeeManagementAgentInsp.getServices());
        data.addField("recommendation", coffeeManagementAgentInsp.getOfficerrecommendation());
        data.addField("recommendation_remarks", coffeeManagementAgentInsp.getOfficerrecommendation_remark());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateCoffeeManagementAgentrecordsSent(coffeeManagementAgentInsp.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public void postNOCDMarketLocationDetails() {
//
//        StandardResponse response = null;
//        CreateDataRequest createData = new CreateDataRequest();
//        DataRow data = new DataRow();
//        List<NOCDMarketPriceSurveyDetails> nocdMarketPriceSurveyDetailsList = db.getUnsentNOCDMarketLocation();
//
//        System.out.println(" ------------------- table_nuts_and_oils_market_location ----------------------------------- " );
//        System.out.println(" the size of the  nocdMarketPriceSurveyDetailsList " + nocdMarketPriceSurveyDetailsList.size());
//
//        for (int k = 0; k < nocdMarketPriceSurveyDetailsList.size(); k++) {
//            NOCDMarketPriceSurveyDetails nocdMarketPriceSurveyDetails = new NOCDMarketPriceSurveyDetails();
//
//            nocdMarketPriceSurveyDetails = nocdMarketPriceSurveyDetailsList.get(k);
//
//            createData.setLogin(getLogin());
//            createData.setWebServiceType("CreateNOCDMarketPriceSurveyLocation");
//            if (db.getNOCDMarketPriceSurveyServerID(nocdMarketPriceSurveyDetails.getLocalID(), "table_nuts_and_oils_market_locations") == null) {
//
//
//                System.out.println("nocd: subCountyID " + nocdMarketPriceSurveyDetails.getSubCountyID());
//                System.out.println("nocd Longitude: " + nocdMarketPriceSurveyDetails.getLongitude());
//                System.out.println("nocd latitude: " + nocdMarketPriceSurveyDetails.getLatitude());
//                System.out.println("nocd: county " + nocdMarketPriceSurveyDetails.getCountyID());
//
//
//                data.addField("SPD_County_ID", nocdMarketPriceSurveyDetails.getCountyID());
//                data.addField("longitude", nocdMarketPriceSurveyDetails.getLongitude());
//                data.addField("latitude", nocdMarketPriceSurveyDetails.getLatitude());
//                data.addField("SPD_SubCounty_ID", nocdMarketPriceSurveyDetails.getSubCountyID());
//                data.addField("sub_location", nocdMarketPriceSurveyDetails.getSubLocation());
//                data.addField("DocStatus", "CL");
//                data.addField("DocAction", "CO");
//                data.addField("IsApproved", "N");
//                data.addField("Processing", "N");
//
//
//                createData.setDataRow(data);
//
//                WebServiceConnection client = getClient();
//
//                try {
//                    response = client.sendRequest(createData);
//
//                    if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
//                        System.out.println(response.getErrorMessage());
//                    } else {
//
//                        System.out.println("nocd RecordID: " + response.getRecordID());
//                        if (response.getRecordID() != null) {
//                            System.out.println("RecordID not null: " + response.getRecordID());
//
//                            boolean i1 = db.updateNOCDMarketPriceSurveySent("table_nuts_and_oils_market_locations", nocdMarketPriceSurveyDetails.getLocalID(), response.getRecordID().toString());
//
//                            System.out.println(" updated the sent Record: " + i1);
//                        }
//
//                        System.out.println();
//
//                        for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
//                            System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
//                        }
//                        System.out.println();
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//    }
//
//    public void postNOCDMarketPriceDetails() {
//        StandardResponse response = null;
//        CreateDataRequest createData = new CreateDataRequest();
//        DataRow data = new DataRow();
//        List<NOCDMarketPriceSurveyDetails> nocdMarketPriceSurveyDetailsList = db.getUnsentNOCDMarketPrice();
//
//        for (int k = 0; k < nocdMarketPriceSurveyDetailsList.size(); k++) {
//            NOCDMarketPriceSurveyDetails nocdMarketPriceSurveyDetails = new NOCDMarketPriceSurveyDetails();
//
//            nocdMarketPriceSurveyDetails = nocdMarketPriceSurveyDetailsList.get(k);
//
//
//            createData.setLogin(getLogin());
//            createData.setWebServiceType("CreateNOCDMarketPriceSurveyPrice");
//
//            String parentServerID = db.getNOCDMarketPriceSurveyServerID(nocdMarketPriceSurveyDetails.getParentID(), "table_nuts_and_oils_market_locations");
//            String adUserID = db.getADUserID(app.getAdUser().getAd_user_id());
//
//            System.out.println("---get AFA_ND_Marketprices_ID: " + parentServerID);
//
//            if (db.getNOCDMarketPriceSurveyServerID(nocdMarketPriceSurveyDetails.getLocalID(), "table_nuts_and_oils_market_prices") == null) {
//
//
//                System.out.println("getAFA_ND_Marketprices_ID: " + parentServerID);
//                System.out.println("setProduct: " + nocdMarketPriceSurveyDetails.getProduct());
//                System.out.println("getBrandName: " + nocdMarketPriceSurveyDetails.getBrandName());
//                System.out.println("getQuantity: " + nocdMarketPriceSurveyDetails.getQuantity());
//                System.out.println("getPrice: " + nocdMarketPriceSurveyDetails.getPrice());
//
//
//                data.addField("AFA_ND_Marketprices_ID", parentServerID);
//                data.addField("M_Product_ID", nocdMarketPriceSurveyDetails.getProduct());
//                data.addField("brandname", nocdMarketPriceSurveyDetails.getBrandName());
//                data.addField("quantity", nocdMarketPriceSurveyDetails.getQuantity());
//                data.addField("Price", nocdMarketPriceSurveyDetails.getPrice());
//                data.addField("market_outlets", nocdMarketPriceSurveyDetails.getMarketOutlet());
//                data.addField("DocStatus", "CL");
//                data.addField("DocAction", "CO");
//                data.addField("IsApproved", "N");
//                data.addField("Processing", "N");
//                createData.setDataRow(data);
//
//                WebServiceConnection client = getClient();
//
//                try {
//                    response = client.sendRequest(createData);
//
//                    if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
//                        System.out.println(response.getErrorMessage());
//                    } else {
//
//                        System.out.println("RecordID: " + response.getRecordID());
//                        System.out.println();
//
//                        db.updateNOCDMarketPriceSurveySent("table_nuts_and_oils_market_prices", nocdMarketPriceSurveyDetails.getLocalID(), response.getRecordID().toString());
//
//                        for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
//                            System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
//                        }
//                        System.out.println();
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//        }
//    }

    public void postHorticulturalFlowerExportersDeskVetting(HorticulturalFlowerExportersDeskVettingDetails horticulturalFlowerExportersDeskVettingDetails) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateFlowerExportersDeskVetting");

        System.out.println("the local ID to be pushed " + horticulturalFlowerExportersDeskVettingDetails.getLocalID());

        System.out.println("AFA_HC_flower_Exptchcklst_ID" + horticulturalFlowerExportersDeskVettingDetails.getAFA_HC_flower_Exptchcklst_ID());
        System.out.println("getLocalID" + horticulturalFlowerExportersDeskVettingDetails.getLocalID());
        System.out.println("getExport_licence" + horticulturalFlowerExportersDeskVettingDetails.getExport_licence());
        System.out.println("getDocumentNumber" + horticulturalFlowerExportersDeskVettingDetails.getDocument_number());
        System.out.println("getApplicantName" + horticulturalFlowerExportersDeskVettingDetails.getName_of_applicant());


        if (!TextUtils.isEmpty(horticulturalFlowerExportersDeskVettingDetails.getAFA_HC_flower_Exptchcklst_ID()) && TextUtils.isDigitsOnly(horticulturalFlowerExportersDeskVettingDetails.getAFA_HC_flower_Exptchcklst_ID())) {
            updateData.setRecordID(Integer.parseInt(horticulturalFlowerExportersDeskVettingDetails.getAFA_HC_flower_Exptchcklst_ID()));
        }

        data.addField("iscertification", horticulturalFlowerExportersDeskVettingDetails.getIsCertificationToKS());
        data.addField("certificationmrk", horticulturalFlowerExportersDeskVettingDetails.getCertificationToKSAward());
        data.addField("timeline_cd_measures1", horticulturalFlowerExportersDeskVettingDetails.getCertificationToKSTimeline());
        data.addField("certificationrmk", horticulturalFlowerExportersDeskVettingDetails.getCertificationToKSRemarks());
        data.addField("isotherregstandards", horticulturalFlowerExportersDeskVettingDetails.getIsRecognisedStandards());
        data.addField("otherregstandardsmrk", horticulturalFlowerExportersDeskVettingDetails.getRecognisedStandardsAward());
        data.addField("timeline_cd_measures2", horticulturalFlowerExportersDeskVettingDetails.getRecognisedStandardsTimeline());
        data.addField("otherregstandardsrmk", horticulturalFlowerExportersDeskVettingDetails.getRecognisedStandardsRemarks());
        data.addField("isnhtsevidence", horticulturalFlowerExportersDeskVettingDetails.getIsEvidenceOfRegistrationNational());
        data.addField("nhtsevidencemrk", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfRegistrationNationalAward());
        data.addField("timeline_cd_measures3", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfRegistrationNationalTimeline());
        data.addField("nhtsevidencermk", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfRegistrationNationalRemarks());
        data.addField("isregsinglewndwsytm", horticulturalFlowerExportersDeskVettingDetails.getIsEvidenceOfRegistrationSingle());
        data.addField("regsinglewndwsytmrmk", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfRegistrationSingleAward());
        data.addField("timeline_cd_measures4", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfRegistrationSingleTimeline());
        data.addField("regsinglewndwsytmrmrk", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfRegistrationSingleRemarks());
        data.addField("isevdsafedisposal", horticulturalFlowerExportersDeskVettingDetails.getIsEvidenceOfSafeDisposal());
        data.addField("evdsafedisposalmrk", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfSafeDisposalAward());
        data.addField("timeline_cd_measures5", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfSafeDisposalTimeline());
        data.addField("evdsafedisposalrmrk", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfSafeDisposalRemarks());
        data.addField("isprtctnwrkerswlfre", horticulturalFlowerExportersDeskVettingDetails.getIsEvidenceOfWorkerProtection());
        data.addField("prtctnwrkerswlfremrk", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfWorkerProtectionAward());
        data.addField("timeline_cd_measures6", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfWorkerProtectionTimeline());
        data.addField("prtctnwrkerswlfrermrk", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfWorkerProtectionRemarks());
        data.addField("iscopyofhcdexptlic", horticulturalFlowerExportersDeskVettingDetails.getIsCopyOfHCD());
        data.addField("copyofhcdexptlicmrk", horticulturalFlowerExportersDeskVettingDetails.getCopyOfHCDAward());
        data.addField("timeline_cd_measures7", horticulturalFlowerExportersDeskVettingDetails.getCopyOfHCDTimeline());
        data.addField("copyofhcdexptlicrmk", horticulturalFlowerExportersDeskVettingDetails.getCopyOfHCDRemarks());
        data.addField("islstcontractedfarmers", horticulturalFlowerExportersDeskVettingDetails.getIsTraceabilityList());
        data.addField("lstcontractedfarmmrk", horticulturalFlowerExportersDeskVettingDetails.getTraceabilityListAward());
        data.addField("timeline_cd_measures8", horticulturalFlowerExportersDeskVettingDetails.getTraceabilityListTimeline());
        data.addField("lstcontractedfarmrmk", horticulturalFlowerExportersDeskVettingDetails.getTraceabilityListRemarks());
        data.addField("ismktagntdeclare", horticulturalFlowerExportersDeskVettingDetails.getIsDeclareMarkettingAgents());
        data.addField("mktagntdeclaremrk", horticulturalFlowerExportersDeskVettingDetails.getDeclareMarkettingAgentsAward());
        data.addField("timeline_cd_measures9", horticulturalFlowerExportersDeskVettingDetails.getDeclareMarkettingAgentsTimeline());
        data.addField("mktagntdeclarermk", horticulturalFlowerExportersDeskVettingDetails.getDeclareMarkettingAgentsRemarks());
        data.addField("isevdsystemplcy", horticulturalFlowerExportersDeskVettingDetails.getIsEvidenceOfTraceabilitySystems());
        data.addField("evdsystemplcymrk", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfTraceabilitySystemsAward());
        data.addField("timeline_cd_measures10", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfTraceabilitySystemsTimeline());
        data.addField("evdsystemplcyrmk", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfTraceabilitySystemsRemarks());
        data.addField("isevdannualtraining", horticulturalFlowerExportersDeskVettingDetails.getIsEvidenceOfAttendance());
        data.addField("evdannualtrainingmrk", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfAttendanceAward());
        data.addField("timeline_cd_measures11", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfAttendanceTimeline());
        data.addField("evdannualtrainingrmk", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfAttendanceRemarks());
        data.addField("isevdannualtrnngmatrix", horticulturalFlowerExportersDeskVettingDetails.getIsAnnualTrainingMatrix());
        data.addField("evdannualtrnngmatrixmrk", horticulturalFlowerExportersDeskVettingDetails.getAnnualTrainingMatrixAward());
        data.addField("timeline_cd_measures12", horticulturalFlowerExportersDeskVettingDetails.getAnnualTrainingMatrixTimeline());
        data.addField("evdannualtrnngmatrixrmk", horticulturalFlowerExportersDeskVettingDetails.getAnnualTrainingMatrixRemarks());
        data.addField("isevdpestcontrol", horticulturalFlowerExportersDeskVettingDetails.getIsEvidenceOfPests());
        data.addField("evdpestcontrolmrk", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfPestsAward());
        data.addField("timeline_cd_measures13", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfPestsTimeline());
        data.addField("evdpestcontrolrmk", horticulturalFlowerExportersDeskVettingDetails.getEvidenceOfPestsRemarks());
        data.addField("isnon_payment_claim", horticulturalFlowerExportersDeskVettingDetails.getIsClaim());
        data.addField("non_payment_claimmrk", horticulturalFlowerExportersDeskVettingDetails.getClaimAward());
        data.addField("timeline_cd_measures14", horticulturalFlowerExportersDeskVettingDetails.getClaimTimeline());
        data.addField("non_payment_claimrmk", horticulturalFlowerExportersDeskVettingDetails.getClaimRemarks());
        data.addField("isclearingagtnutil", horticulturalFlowerExportersDeskVettingDetails.getIsUtilizationOfHCD());
        data.addField("clearingagtnutilmrk", horticulturalFlowerExportersDeskVettingDetails.getUtilizationOfHCDAward());
        data.addField("timeline_cd_measures15", horticulturalFlowerExportersDeskVettingDetails.getUtilizationOfHCDTimeline());
        data.addField("clearingagtnutilrmk", horticulturalFlowerExportersDeskVettingDetails.getUtilizationOfHCDRemarks());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");


        updateData.setDataRow(data);


        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateHorticulturalFlowerExportersDeskVettingSent(horticulturalFlowerExportersDeskVettingDetails.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void postHorticultureNurseryInspection(HorticultureNurseryInspectionDetails horticultureNurseryInspectionDetails) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateNurseryInspectionChecklist");

        System.out.println("the local ID to be pushed " + horticultureNurseryInspectionDetails.getLocalID());

        System.out.println("AFA_HC_Nursery_Insp_ID" + horticultureNurseryInspectionDetails.getAFA_HC_Nursery_Insp_ID());
        System.out.println("getLocalID" + horticultureNurseryInspectionDetails.getLocalID());
        System.out.println("getNurseryLicence" + horticultureNurseryInspectionDetails.getNurseryLicence());
        System.out.println("getDocumentNumber" + horticultureNurseryInspectionDetails.getDocumentNumber());
        System.out.println("getApplicantName" + horticultureNurseryInspectionDetails.getNameOfApplicant());


        if (!TextUtils.isEmpty(horticultureNurseryInspectionDetails.getAFA_HC_Nursery_Insp_ID()) && TextUtils.isDigitsOnly(horticultureNurseryInspectionDetails.getAFA_HC_Nursery_Insp_ID())) {
            updateData.setRecordID(Integer.parseInt(horticultureNurseryInspectionDetails.getAFA_HC_Nursery_Insp_ID()));
        }

        data.addField("hactarage", horticultureNurseryInspectionDetails.getHectarage());
        data.addField("nursery_type", horticultureNurseryInspectionDetails.getSsNurseryType());
        data.addField("isdiseasefreesdlng", horticultureNurseryInspectionDetails.getIsDiseasefreeSeedling());
        data.addField("remarks1", horticultureNurseryInspectionDetails.getDiseasefreeSeedlingRemarks());
        data.addField("isorgnclitterfree", horticultureNurseryInspectionDetails.getIsFreefromOrganicLitter());
        data.addField("remarks2", horticultureNurseryInspectionDetails.getFreefromOrganicLitterRemarks());
        data.addField("isclearoperation", horticultureNurseryInspectionDetails.getIsClearseparation());
        data.addField("remarks3", horticultureNurseryInspectionDetails.getClearSeparationRemarks());
        data.addField("isrndsourceofwater", horticultureNurseryInspectionDetails.getIsYearroundSourceOfWater());
        data.addField("remarks4", horticultureNurseryInspectionDetails.getYearroundSourceOfWaterRemarks());
        data.addField("issoilmediatrtd", horticultureNurseryInspectionDetails.getIsSoilmedia());
        data.addField("remarks5", horticultureNurseryInspectionDetails.getSoilMediaRemarks());
        data.addField("issecurednurserylay", horticultureNurseryInspectionDetails.getIsWellsecuredNurseryLayout());
        data.addField("remarks6", horticultureNurseryInspectionDetails.getWellsecuredNurseryLayoutRemarks());
        data.addField("isstructuresinplace", horticultureNurseryInspectionDetails.getIsArestructuresInPlace());
        data.addField("remarks7", horticultureNurseryInspectionDetails.getArestructuresInPlaceRemarks());
        data.addField("isscionsourcereg", horticultureNurseryInspectionDetails.getIsScionsource());
        data.addField("remarks8", horticultureNurseryInspectionDetails.getScionSourceRemarks());
        data.addField("isapprsourceofsd", horticultureNurseryInspectionDetails.getIsApprovedsource());
        data.addField("remarks9", horticultureNurseryInspectionDetails.getApprovedSourceRemarks());
        data.addField("islabelednurseryblock", horticultureNurseryInspectionDetails.getIsWellLabeledNurseryblock());
        data.addField("remarks10", horticultureNurseryInspectionDetails.getWellLabeledNurseryBlockRemarks());
        data.addField("istaggedsdlngs", horticultureNurseryInspectionDetails.getIsReadydispatchSeedlings());
        data.addField("remarks11", horticultureNurseryInspectionDetails.getReadydispatchSeedlingsRemarks());
        data.addField("isdistrrecords", horticultureNurseryInspectionDetails.getIsdistributionRecords());
        data.addField("remarks12", horticultureNurseryInspectionDetails.getDistributionRecordsRemarks());
        data.addField("isdispnurserycert", horticultureNurseryInspectionDetails.getIsNurserycertificateWell());
        data.addField("remarks13", horticultureNurseryInspectionDetails.getNurserycertificateWellRemarks());
        data.addField("general_remarks", horticultureNurseryInspectionDetails.getOtherRemarks());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");
        updateData.setDataRow(data);


        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateNurseyInspectionSent(horticultureNurseryInspectionDetails.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void postHorticultureProduceTransportation(HorticultureProduceTransportationDetails horticultureProduceTransportation) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateHorticulturalProduceTransportation");

        System.out.println("the local ID to be pushed " + horticultureProduceTransportation.getLocalID());

        System.out.println("AFA_HC_Produce_Trans_Insp_ID" + horticultureProduceTransportation.getAFA_HC_Produce_Trans_Insp_ID());
        System.out.println("LocalID" + horticultureProduceTransportation.getLocalID());
        System.out.println("ExportLicence" + horticultureProduceTransportation.getExportLicence());
        System.out.println("DocumentNumber" + horticultureProduceTransportation.getDocumentNumber());
        System.out.println("ApplicantName" + horticultureProduceTransportation.getNameOfApllicant());


        if (!TextUtils.isEmpty(horticultureProduceTransportation.getAFA_HC_Produce_Trans_Insp_ID()) && TextUtils.isDigitsOnly(horticultureProduceTransportation.getAFA_HC_Produce_Trans_Insp_ID())) {
            updateData.setRecordID(Integer.parseInt(horticultureProduceTransportation.getAFA_HC_Produce_Trans_Insp_ID()));
        }

        data.addField("isexporterfarm", horticultureProduceTransportation.getIsOwnFarm());
        data.addField("iscontractedfarm", horticultureProduceTransportation.getIsContractedSources());
        data.addField("isavmechanicaldamage", horticultureProduceTransportation.getIsProduceTransportation());
        data.addField("remarks1", horticultureProduceTransportation.getProduceTransportationRemarks());
        data.addField("istrnsprtvesselclnd", horticultureProduceTransportation.getIsTransportVessel());
        data.addField("remarks2", horticultureProduceTransportation.getTransportVesselRemarks());
        data.addField("iscleardcmentation", horticultureProduceTransportation.getIsClearedDocumentation());
        data.addField("remarks3", horticultureProduceTransportation.getClearedDocumentationRemarks());
        data.addField("isprdctintegrityconsg", horticultureProduceTransportation.getIsIntegrityOfProduct());
        data.addField("remarks4", horticultureProduceTransportation.getIntegrityOfProductRemarks());
        data.addField("ishndlngfcltyapproved", horticultureProduceTransportation.getIsProduceHandling());
        data.addField("remarks5", horticultureProduceTransportation.getProduceHandlingRemarks());
        data.addField("general_remarks", horticultureProduceTransportation.getComments());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);


        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateHorticulturalProduceTransportationSent(horticultureProduceTransportation.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void postHorticulturePackhouseWarehouse(HCDParkhouseWarehouseDetails hcdParkhouseWarehouseDetails) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateHorticulturalExportLicenseParkhous");

        System.out.println("the local ID to be pushed " + hcdParkhouseWarehouseDetails.getLocalID());

        System.out.println("AFA_HC_Packhouse_Insp_ID" + hcdParkhouseWarehouseDetails.getAFA_HC_Packhouse_Insp_ID());
        System.out.println("LocalID" + hcdParkhouseWarehouseDetails.getLocalID());
        System.out.println("ExportLicence" + hcdParkhouseWarehouseDetails.getExportLicence());
        System.out.println("DocumentNumber" + hcdParkhouseWarehouseDetails.getDocumentNumber());
        System.out.println("ApplicantName" + hcdParkhouseWarehouseDetails.getNameOfApplicant());


        if (!TextUtils.isEmpty(hcdParkhouseWarehouseDetails.getAFA_HC_Packhouse_Insp_ID()) && TextUtils.isDigitsOnly(hcdParkhouseWarehouseDetails.getAFA_HC_Packhouse_Insp_ID())) {
            updateData.setRecordID(Integer.parseInt(hcdParkhouseWarehouseDetails.getAFA_HC_Packhouse_Insp_ID()));
        }

        data.addField("isvalid_cert", hcdParkhouseWarehouseDetails.getIsCertificationtoSafetyStandards());
        data.addField("valid_certrmrk", hcdParkhouseWarehouseDetails.getCertificationToSafetyStandardsRemarks());
        data.addField("exptr_pckhse_cntrct", hcdParkhouseWarehouseDetails.getIsDulysignedExporter());
        data.addField("exprtrpckhsecontractrmrk", hcdParkhouseWarehouseDetails.getDulySignedExporterRemarks());
        data.addField("lstcodesfarms", hcdParkhouseWarehouseDetails.getIsListandCodes());
        data.addField("lstcdesfrms_rmrk", hcdParkhouseWarehouseDetails.getListAndCodesRemarks());
        data.addField("incmng_prdce", hcdParkhouseWarehouseDetails.getIsRegisterofIncomingProduce());
        data.addField("incmng_prdce_rmrk", hcdParkhouseWarehouseDetails.getRegisterOfIncomingProduceRemarks());
        data.addField("isprduce_dclrd", hcdParkhouseWarehouseDetails.getIsAreproduceAndSourcesDeclared());
        data.addField("prduce_dclrdrmrk", hcdParkhouseWarehouseDetails.getAreProduceAndSourcesDeclaredRemarks());
        data.addField("goodsrcvdnote", hcdParkhouseWarehouseDetails.getIsCopiesofProduceCollection());
        data.addField("goodsrcvdnote_rmrk", hcdParkhouseWarehouseDetails.getCopiesOfProduceCollectionRemarks());
        data.addField("qantity", hcdParkhouseWarehouseDetails.getIsHarvestdateAndQuantity());
        data.addField("hrvstdatequantityrmrk", hcdParkhouseWarehouseDetails.getHarvestDateAndQuantityRemarks());
        data.addField("treatment_chmcls", hcdParkhouseWarehouseDetails.getIsDatelastSprayed());
        data.addField("lst_spryed_rmrk", hcdParkhouseWarehouseDetails.getDateLastSprayedRemarks());
        data.addField("trcblty_prcdre", hcdParkhouseWarehouseDetails.getIsDocumentedtraceability());
        data.addField("trcbltyprcdrermrk", hcdParkhouseWarehouseDetails.getDocumentedTraceabilityRemarks());
        data.addField("pckd_prdcts_coded", hcdParkhouseWarehouseDetails.getIsArePackedproductsCoded());
        data.addField("pckd_prdcts_coded_rmrk", hcdParkhouseWarehouseDetails.getArePackedProductsCodedRemarks());
        data.addField("ordr_dispact_rflcts", hcdParkhouseWarehouseDetails.getIsOrderandDispatch());
        data.addField("order_dispact_rflcts_rmrk", hcdParkhouseWarehouseDetails.getOrderAndDispatchRemarks());
        data.addField("is_chmcllst_valid", hcdParkhouseWarehouseDetails.getIsChemicalListapproved());
        data.addField("is_chmcllst_valid_rmrk", hcdParkhouseWarehouseDetails.getHemicallistapprovedRemarks());
        data.addField("is_tradenm_valid", hcdParkhouseWarehouseDetails.getIsTradenameoftheProductRecorded());
        data.addField("is_tradenm_valid_rmrk", hcdParkhouseWarehouseDetails.getTradenameOftheProductRecordedRemarks());
        data.addField("chmclapld_rcrdd", hcdParkhouseWarehouseDetails.getIsAmountofChemicalAppliedRecorded());
        data.addField("chmclapld_rcrdd_rmark", hcdParkhouseWarehouseDetails.getAmountOfChemicalAppliedRecordedRemarks());
        data.addField("trainingschdlscerts", hcdParkhouseWarehouseDetails.getIsTrainingschedule());
        data.addField("trainingschdlscertsrmrk", hcdParkhouseWarehouseDetails.getTrainingScheduleRemarks());
        data.addField("prdchndlng_stff", hcdParkhouseWarehouseDetails.getIsListofProduceHandling());
        data.addField("prdchndlng_stff_rmrk", hcdParkhouseWarehouseDetails.getListofProduceHandlingRemarks());
        data.addField("prftrnng_fdsafety", hcdParkhouseWarehouseDetails.getIsproofOfTraining());
        data.addField("prftrnng_fdsafety_rmrk", hcdParkhouseWarehouseDetails.getProofOfTrainingRemarks());
        data.addField("wrkngareafreewstmtrls", hcdParkhouseWarehouseDetails.getIsWorkingAreaandPremisesKept());
        data.addField("wrkngareafreewstmtrls_rmrk", hcdParkhouseWarehouseDetails.getWorkingAreaAndPremisesKeptRemarks());
        data.addField("prtctveclothing", hcdParkhouseWarehouseDetails.getIsPersonalwearing());
        data.addField("prtctveclothing_rmrk", hcdParkhouseWarehouseDetails.getPersonalWearingRemarks());
        data.addField("medicalexmntn", hcdParkhouseWarehouseDetails.getIsFoodhandlingPersonel());
        data.addField("medicalexmntnrmrk", hcdParkhouseWarehouseDetails.getFoodhandlingPersonelRemarks());
        data.addField("fdhndlngmtrlstype", hcdParkhouseWarehouseDetails.getIsFoodhandlingequipment());
        data.addField("fdhndlngmtrlstypermrk", hcdParkhouseWarehouseDetails.getFoodhandlingEquipmentRemarks());
        data.addField("pckhseventlghtngtempcntrl", hcdParkhouseWarehouseDetails.getIsAdequateventillation());
        data.addField("pckhseventlghtngtempcntrlrmrk", hcdParkhouseWarehouseDetails.getAdequateVentillationRemarks());
        data.addField("occptnsftyheathlthyact", hcdParkhouseWarehouseDetails.getIsFacilityconformshealthAct());
        data.addField("occptnsftyheathlthyactrmrk", hcdParkhouseWarehouseDetails.getAcilityConformshealthActRemarks());
        data.addField("prvntdomstcanmls", hcdParkhouseWarehouseDetails.getIsFacilitydesigned());
        data.addField("prvntdomstcanmlsrmrk", hcdParkhouseWarehouseDetails.getFacilityDesignedRemarks());
        data.addField("prminnt_sgns", hcdParkhouseWarehouseDetails.getIsDisplayedprominentSigns());
        data.addField("prminnt_sgnsrmrk", hcdParkhouseWarehouseDetails.getIsplayedProminentSignsRemarks());
        data.addField("prmnnt_prdce_spcfctn", hcdParkhouseWarehouseDetails.getIsDisplayedProminentproduceSpecifications());
        data.addField("prmnnt_prdce_spcfctnrmrk", hcdParkhouseWarehouseDetails.getDisplayedProminentProduceSpecificationsRemarks());
        data.addField("storage_area", hcdParkhouseWarehouseDetails.getIsStorageareaOfPackaging());
        data.addField("storage_area_remarks", hcdParkhouseWarehouseDetails.getStorageAreaOfPackagingRemarks());
        data.addField("prdcts_graded", hcdParkhouseWarehouseDetails.getIsProductsgraded());
        data.addField("grdd_prdcts_rmrk", hcdParkhouseWarehouseDetails.getProductsGradedRemarks());
        data.addField("isprdce_firstin_firstout_plcy", hcdParkhouseWarehouseDetails.getIsProducefollowFIFO());
//        data.addField("prdce_firstin_firstout_plcyrmr", hcdParkhouseWarehouseDetails.getProduceFollowFIFORemarks());
        data.addField("produce_crates", hcdParkhouseWarehouseDetails.getIsAcquissitionofProduce());
        data.addField("produce_cratesrmrk", hcdParkhouseWarehouseDetails.getAcquissitionOfProduceRemarks());
        data.addField("iscontracts", hcdParkhouseWarehouseDetails.getIsStorageareaSafeHygiene());
        data.addField("contractsrmrk", hcdParkhouseWarehouseDetails.getStorageAreaSafeHygieneRemarks());
        data.addField("general_remarks", hcdParkhouseWarehouseDetails.getOtherComments());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);


        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateParkhouseWarehouseSent(hcdParkhouseWarehouseDetails.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void postHorticultureCropExportLicenceFarmInspectionDetails(HorticultureCropExportLicenceFarmInspectionDetails horticultureCropExportLicenceFarmInspectionDetails) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateHorticulturalCropsExportLicense");

        System.out.println("the local ID to be pushed " + horticultureCropExportLicenceFarmInspectionDetails.getLocalID());

        System.out.println("AFA_HC_Packhouse_Insp_ID" + horticultureCropExportLicenceFarmInspectionDetails.getAFA_HC_Export_Farm_Insp_ID());
        System.out.println("LocalID" + horticultureCropExportLicenceFarmInspectionDetails.getLocalID());
        System.out.println("CountyID" + horticultureCropExportLicenceFarmInspectionDetails.getCountyId());
        System.out.println("DocumentNumber" + horticultureCropExportLicenceFarmInspectionDetails.getDocumentNumber());
        System.out.println("ApplicantName" + horticultureCropExportLicenceFarmInspectionDetails.getNameOfApplicant());


        if (!TextUtils.isEmpty(horticultureCropExportLicenceFarmInspectionDetails.getAFA_HC_Export_Farm_Insp_ID()) && TextUtils.isDigitsOnly(horticultureCropExportLicenceFarmInspectionDetails.getAFA_HC_Export_Farm_Insp_ID())) {
            updateData.setRecordID(Integer.parseInt(horticultureCropExportLicenceFarmInspectionDetails.getAFA_HC_Export_Farm_Insp_ID()));
        }

        data.addField("isafa_cert", horticultureCropExportLicenceFarmInspectionDetails.getIsCcertificationToGap());
        data.addField("remarks1", horticultureCropExportLicenceFarmInspectionDetails.getCcertificationToGap());
        data.addField("iscontract", horticultureCropExportLicenceFarmInspectionDetails.getIsDulySigned());
        data.addField("remarks2", horticultureCropExportLicenceFarmInspectionDetails.getDulySigned());
        data.addField("isproductplan", horticultureCropExportLicenceFarmInspectionDetails.getIsProductionPlanPerCrop());
        data.addField("remarks3", horticultureCropExportLicenceFarmInspectionDetails.getProductionPlanPerCrop());
        data.addField("ismarkertrequirements", horticultureCropExportLicenceFarmInspectionDetails.getIsExporterAware());
        data.addField("remarks4", horticultureCropExportLicenceFarmInspectionDetails.getExporterAware());
        data.addField("istrainedpersonnel", horticultureCropExportLicenceFarmInspectionDetails.getIsExporterTrainedPersonnel());
        data.addField("remarks5", horticultureCropExportLicenceFarmInspectionDetails.getExporterTrainedPersonnel());
        data.addField("isapprovedproceedure", horticultureCropExportLicenceFarmInspectionDetails.getIsControlledAndApproved());
        data.addField("remarks6", horticultureCropExportLicenceFarmInspectionDetails.getControlledAndApproved());
        data.addField("ispesticidemrl", horticultureCropExportLicenceFarmInspectionDetails.getIsExporterHavePetcide());
        data.addField("remarks7", horticultureCropExportLicenceFarmInspectionDetails.getExporterHavePetcide());
        data.addField("isfieldcodes", horticultureCropExportLicenceFarmInspectionDetails.getIsFieldCodes());
        data.addField("remarks8", horticultureCropExportLicenceFarmInspectionDetails.getFieldCodes());
        data.addField("isplantingddate", horticultureCropExportLicenceFarmInspectionDetails.getIsPlantingDate());
        data.addField("remarks9", horticultureCropExportLicenceFarmInspectionDetails.getPlantingDate());
        data.addField("isvalidchemiacllist", horticultureCropExportLicenceFarmInspectionDetails.getIsChemicalListApproved());
        data.addField("remarks10", horticultureCropExportLicenceFarmInspectionDetails.getChemicalListApproved());
        data.addField("issprayprogramapprd", horticultureCropExportLicenceFarmInspectionDetails.getIsPresenceOfApprovedSpray());
        data.addField("remarks11", horticultureCropExportLicenceFarmInspectionDetails.getPresenceOfApprovedSpray());
        data.addField("isapprdproductinvoices", horticultureCropExportLicenceFarmInspectionDetails.getIsProductInvoices());
        data.addField("remarks12", horticultureCropExportLicenceFarmInspectionDetails.getProductInvoices());
        data.addField("issprayrecord", horticultureCropExportLicenceFarmInspectionDetails.getIsSprayRecords());
        data.addField("remarks13", horticultureCropExportLicenceFarmInspectionDetails.getSprayRecords());
        data.addField("istradenamerecorded", horticultureCropExportLicenceFarmInspectionDetails.getIsTradenameOfProduct());
        data.addField("remarks14", horticultureCropExportLicenceFarmInspectionDetails.getTradenameOfProduct());
        data.addField("isphirecorded", horticultureCropExportLicenceFarmInspectionDetails.getIsPhiRecorded());
        data.addField("remarks15", horticultureCropExportLicenceFarmInspectionDetails.getPhiRecorded());
        data.addField("issprayingdatesindicated", horticultureCropExportLicenceFarmInspectionDetails.getIsAllSprayingDates());
        data.addField("remarks16", horticultureCropExportLicenceFarmInspectionDetails.getAllSprayingDates());
        data.addField("ispesticideamountrec", horticultureCropExportLicenceFarmInspectionDetails.getIsAmountOfPesticide());
        data.addField("remarks17", horticultureCropExportLicenceFarmInspectionDetails.getAmountOfPesticide());
        data.addField("isphiobserved", horticultureCropExportLicenceFarmInspectionDetails.getIsPhiObserved());
        data.addField("remarks18", horticultureCropExportLicenceFarmInspectionDetails.getPhiObserved());
        data.addField("istrainingsched_certs", horticultureCropExportLicenceFarmInspectionDetails.getIsTrainingSchedules());
        data.addField("remarks19", horticultureCropExportLicenceFarmInspectionDetails.getTrainingSchedules());
        data.addField("ispestmanagement_protocol", horticultureCropExportLicenceFarmInspectionDetails.getIsPestManagementProtocol());
        data.addField("remarks20", horticultureCropExportLicenceFarmInspectionDetails.getPestManagementProtocol());
        data.addField("isscouting_evidence", horticultureCropExportLicenceFarmInspectionDetails.getIsEvidenceOnScouring());
        data.addField("remarks21", horticultureCropExportLicenceFarmInspectionDetails.getEvidenceOnScouring());
        data.addField("ispestcontrol_evidence", horticultureCropExportLicenceFarmInspectionDetails.getIsEvidenceOfPests());
        data.addField("remarks22", horticultureCropExportLicenceFarmInspectionDetails.getEvidenceOfPests());
        data.addField("isshedcoll_farmers", horticultureCropExportLicenceFarmInspectionDetails.getIsCollectionShedForFarmers());
        data.addField("remarks23", horticultureCropExportLicenceFarmInspectionDetails.getCollectionShedForFarmers());
        data.addField("isshed_secured", horticultureCropExportLicenceFarmInspectionDetails.getIsCollectionAndSortingShed());
        data.addField("remarks24", horticultureCropExportLicenceFarmInspectionDetails.getCollectionAndSortingShed());
        data.addField("ishygiene_instructions", horticultureCropExportLicenceFarmInspectionDetails.getIsAppropriateHygiene());
        data.addField("remarks25", horticultureCropExportLicenceFarmInspectionDetails.getAppropriateHygiene());
        data.addField("isfoodgradematerial", horticultureCropExportLicenceFarmInspectionDetails.getIsGradingtables());
        data.addField("remarks26", horticultureCropExportLicenceFarmInspectionDetails.getGradingtables());
        data.addField("isshed_running_water", horticultureCropExportLicenceFarmInspectionDetails.getIsShedHaveRunningWater());
        data.addField("remarks27", horticultureCropExportLicenceFarmInspectionDetails.getShedHaveRunningWater());
        data.addField("istoilet_at_facility", horticultureCropExportLicenceFarmInspectionDetails.getIsToiletAtFacility());
        data.addField("remarks28", horticultureCropExportLicenceFarmInspectionDetails.getToiletAtFacility());
        data.addField("isppe_at_shed", horticultureCropExportLicenceFarmInspectionDetails.getIsPpeGraders());
        data.addField("remarks29", horticultureCropExportLicenceFarmInspectionDetails.getPpeGraders());
        data.addField("isstorage_area", horticultureCropExportLicenceFarmInspectionDetails.getIsStorageAreaForGraded());
        data.addField("remarks30", horticultureCropExportLicenceFarmInspectionDetails.getStorageAreaForGraded());
        data.addField("isplastic_grd_pallets", horticultureCropExportLicenceFarmInspectionDetails.getIsPlasticCrates());
        data.addField("remarks31", horticultureCropExportLicenceFarmInspectionDetails.getPlasticCrates());
        data.addField("iscol_accessible", horticultureCropExportLicenceFarmInspectionDetails.getIsCollectionShedAccessible());
        data.addField("remarks32", horticultureCropExportLicenceFarmInspectionDetails.getCollectionShedAccessible());
        data.addField("isshed_office", horticultureCropExportLicenceFarmInspectionDetails.getIsCollectionAreaHaveOffice());
        data.addField("remarks33", horticultureCropExportLicenceFarmInspectionDetails.getCollectionAreaHaveOffice());
        data.addField("isshed_of_nontoxicmaterial", horticultureCropExportLicenceFarmInspectionDetails.getIsCollectionShedEasy());
        data.addField("remarks34", horticultureCropExportLicenceFarmInspectionDetails.getCollectionShedEasy());
        data.addField("isadeqlgt_ventilation", horticultureCropExportLicenceFarmInspectionDetails.getIsAdequateLightingAndVentilation());
        data.addField("remarks35", horticultureCropExportLicenceFarmInspectionDetails.getAdequateLightingAndVentilation());
        data.addField("iswastedisposal_fclty", horticultureCropExportLicenceFarmInspectionDetails.getIsWasteDisposalFacility());
        data.addField("remarks36", horticultureCropExportLicenceFarmInspectionDetails.getWasteDisposalFacility());
        data.addField("isreg_of_incommingprod", horticultureCropExportLicenceFarmInspectionDetails.getIsRegisterOfAllIncoming());
        data.addField("remarks37", horticultureCropExportLicenceFarmInspectionDetails.getRegisterOfAllIncoming());
        data.addField("isproce_prodhdling", horticultureCropExportLicenceFarmInspectionDetails.getIsProceduresForProduct());
        data.addField("remarks38", horticultureCropExportLicenceFarmInspectionDetails.getProceduresForProduct());
        data.addField("isfdsec_trnedpersonel", horticultureCropExportLicenceFarmInspectionDetails.getIsPersonnelHandlingProduce());
        data.addField("remarks39", horticultureCropExportLicenceFarmInspectionDetails.getPersonnelHandlingProduce());
        data.addField("isfarmer_registered", horticultureCropExportLicenceFarmInspectionDetails.getIsAllFarmersRegistered());
        data.addField("remarks40", horticultureCropExportLicenceFarmInspectionDetails.getAllFarmersRegistered());
        data.addField("istracebility_codes", horticultureCropExportLicenceFarmInspectionDetails.getIsPresenceOfTraceability());
        data.addField("remarks41", horticultureCropExportLicenceFarmInspectionDetails.getPresenceOfTraceability());
        data.addField("isreg_for_prodleaving", horticultureCropExportLicenceFarmInspectionDetails.getIsAvailabilityOfRegistered());
        data.addField("remarks42", horticultureCropExportLicenceFarmInspectionDetails.getAvailabilityOfRegistered());
        data.addField("istraining_certs", horticultureCropExportLicenceFarmInspectionDetails.getIsTrainingCertificates());
        data.addField("remarks43", horticultureCropExportLicenceFarmInspectionDetails.getTrainingCertificates());
        data.addField("istechsupport_evid", horticultureCropExportLicenceFarmInspectionDetails.getIsEvidenceOfTechnical());
        data.addField("remarks44", horticultureCropExportLicenceFarmInspectionDetails.getEvidenceOfTechnical());
        data.addField("general_remarks", horticultureCropExportLicenceFarmInspectionDetails.getComments());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);


        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateHorticultureCropExportLicenceFarmInspectionSent(horticultureCropExportLicenceFarmInspectionDetails.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void postMangoQualityInspection(MangoQualityInspection mangoQualityInspection) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateMangoQualityInspection");

        System.out.println("the local ID to be pushed " + mangoQualityInspection.getLocalID());

        System.out.println("AFA_HC_Packhouse_Insp_ID" + mangoQualityInspection.getAFA_Mango_Quality_Inspection_ID());
        System.out.println("LocalID" + mangoQualityInspection.getLocalID());
        System.out.println("ExportLicence" + mangoQualityInspection.getInspectionRequestNo());
        System.out.println("DocumentNumber" + mangoQualityInspection.getDocumentNumber());
        System.out.println("ApplicantName" + mangoQualityInspection.getExportersName());


        if (!TextUtils.isEmpty(mangoQualityInspection.getAFA_Mango_Quality_Inspection_ID()) && TextUtils.isDigitsOnly(mangoQualityInspection.getAFA_Mango_Quality_Inspection_ID())) {
            updateData.setRecordID(Integer.parseInt(mangoQualityInspection.getAFA_Mango_Quality_Inspection_ID()));
        }

        data.addField("islantexstains", mangoQualityInspection.getIsLatexstains());
        data.addField("remark1", mangoQualityInspection.getLatexStainsRemarks());
        data.addField("ismatskinyellow", mangoQualityInspection.getIsyellow());
        data.addField("ismatskingreen", mangoQualityInspection.getIsgreen());
        data.addField("ismatfleshyellow", mangoQualityInspection.getIsfleshYellow());
        data.addField("ismatfleshwhitish", mangoQualityInspection.getIsfleshWhitesh());
        data.addField("isfleshfirmness", mangoQualityInspection.getIsfleshFirmness());
        data.addField("remark4", mangoQualityInspection.getFleshColorRemarks());
        data.addField("iswoundsdamage", mangoQualityInspection.getIswoundDamage());
        data.addField("remark5", mangoQualityInspection.getWoundDamageRemarks());
        data.addField("isdiscolourisation", mangoQualityInspection.getIsdiscoloration());
        data.addField("remark6", mangoQualityInspection.getDiscolorationRemarks());
        data.addField("isstalkpresence5mm", mangoQualityInspection.getIsStalkpressure());
        data.addField("remark7", mangoQualityInspection.getStalkPressureRemarks());
        data.addField("fruitsizing", mangoQualityInspection.getFruitSizing());
        data.addField("isuniformvariety", mangoQualityInspection.getIsvariety());
        data.addField("remark9", mangoQualityInspection.getVarietyRemarks());
        data.addField("isuniformcolor", mangoQualityInspection.getIshassFleshColorCreamy());
        data.addField("remark10", mangoQualityInspection.getColorRemarks());
        data.addField("isuniforsize", mangoQualityInspection.getIssize());
        data.addField("remark11", mangoQualityInspection.getSizeRemarks());
        data.addField("isforeignmatter", mangoQualityInspection.getIsforeignMatterpresen());
        data.addField("remark12", mangoQualityInspection.getForeignMatterPresentRemarks());
        data.addField("ismoistureonfruit", mangoQualityInspection.getIsMoistureonFruits());
        data.addField("remark13", mangoQualityInspection.getMoistureonFruitsRemarks());
        data.addField("ispostharvesttreat", mangoQualityInspection.getIsLostHarvesttreatment());
        data.addField("remark14", mangoQualityInspection.getLostHarvesttreatmentRemarks());
        data.addField("Comments", mangoQualityInspection.getComments());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");


        updateData.setDataRow(data);


        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                db.updateMangoQualityInspectionrSent(mangoQualityInspection.getLocalID(), response.getRecordID().toString());
                System.out.println("RecordID: " + response.getRecordID());

                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void postSisalFactoryInspection(SisalFactoryInspection sisalFactoryInspection) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateSisalFactoryInspection");

        System.out.println("the local ID to be pushed " + sisalFactoryInspection.getLocalID());

        System.out.println("AFA_Sisal_Factory_Inspection_ID" + sisalFactoryInspection.getAFA_Sisal_Factory_Inspection_ID());
        System.out.println("LocalID" + sisalFactoryInspection.getLocalID());
        System.out.println("ExportLicence" + sisalFactoryInspection.getSisalSpinningExportNumber());
        System.out.println("DocumentNumber" + sisalFactoryInspection.getDocumentNumber());
        System.out.println("ApplicantName" + sisalFactoryInspection.getNameOfApplicant());

        if (!TextUtils.isEmpty(sisalFactoryInspection.getAFA_Sisal_Factory_Inspection_ID()) && TextUtils.isDigitsOnly(sisalFactoryInspection.getAFA_Sisal_Factory_Inspection_ID())) {
            updateData.setRecordID(Integer.parseInt(sisalFactoryInspection.getAFA_Sisal_Factory_Inspection_ID()));
        }


        data.addField("is_valid_trade_lic", sisalFactoryInspection.getIsValidTradinglicence());
        data.addField("is_valid_trade_lic_remarks", sisalFactoryInspection.getValidTradinglicenceRemarks());
        data.addField("is_nema_certified", sisalFactoryInspection.getIsValidNeMACerificaion());
        data.addField("nema_certificate_remarks", sisalFactoryInspection.getValidNeMACerificaionRemarks());
        data.addField("is_risk_assmnt_rprt", sisalFactoryInspection.getIsFireriskAssessment());
        data.addField("risk_assmnt_rprt_remarks", sisalFactoryInspection.getFireriskAssessmentRemarks());
        data.addField("is_health_safety_rprt", sisalFactoryInspection.getIsOccupationalhealthReport());
        data.addField("health_safety_rprt_remarks", sisalFactoryInspection.getOccupationalhealthReportRemarks());
        data.addField("is_fire_marshalls", sisalFactoryInspection.getIsFiremarshalls());
        data.addField("fire_marshalls_remarks", sisalFactoryInspection.getFiremarshallsRemarks());
        data.addField("is_accsbl_fire_exits", sisalFactoryInspection.getIsAccessiblefireemergencyexits());
        data.addField("accsbl_fire_exits_remarks", sisalFactoryInspection.getAccessibleFireemergencyexitsRemarks());
        data.addField("is_first_aid_kit", sisalFactoryInspection.getIsFirstAidkit());
        data.addField("first_aid_kit_remarks", sisalFactoryInspection.getFirstAidkitRemarks());
        data.addField("is_protective_gear", sisalFactoryInspection.getIsAppropriateprotectiveclothing());
        data.addField("protective_gear_remarks", sisalFactoryInspection.getAppropriateprotectiveclothing());
        data.addField("is_prtctd_mvng_parts", sisalFactoryInspection.getIsProtectedmovingParts());
        data.addField("prtctd_mvng_parts_remarks", sisalFactoryInspection.getProtectedmovingParts());
        data.addField("is_general_condition", sisalFactoryInspection.getIsGeneralcondition());
        data.addField("general_condition_remarks", sisalFactoryInspection.getGeneralconditionRemarks());
        data.addField("is_storage_conditions", sisalFactoryInspection.getIsStoragecondition());
        data.addField("storage_conditions_remarks", sisalFactoryInspection.getStorageconditionRemarks());
        data.addField("is_monthly_reports", sisalFactoryInspection.getIsProofofSubmission());
        data.addField("monthly_reports_remarks", sisalFactoryInspection.getProofofSubmission());
        data.addField("is_afa_certificate", sisalFactoryInspection.getIsCertificationbyAFA());
        data.addField("afa_certificate_remarks", sisalFactoryInspection.getCertificationbyAFARemarks());
        data.addField("is_fire_engines", sisalFactoryInspection.getIsFireengines());
        data.addField("is_water", sisalFactoryInspection.getIswater());
        data.addField("is_carbon_dioxide", sisalFactoryInspection.getIsCarbondioxide());
        data.addField("is_sand", sisalFactoryInspection.getIssand());
        data.addField("is_foam", sisalFactoryInspection.getIsfoam());
        data.addField("is_hydrant_system", sisalFactoryInspection.getIsHydrantsystem());
        data.addField("is_dry_powder", sisalFactoryInspection.getIsDrypowder());
        data.addField("fire_fighting_remarks", sisalFactoryInspection.getEtFirefightingRemarks());
        data.addField("general_remarks", sisalFactoryInspection.getComments());
        data.addField("recommendation", sisalFactoryInspection.getOfficerrecommendation());
        data.addField("recommendation_remarks", sisalFactoryInspection.getOfficerrecommendation_remark());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");
        updateData.setDataRow(data);


        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateFCDSisalFactoryInspectionSent(sisalFactoryInspection.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void postSisalSpinningFactoryInspection(SisalSpinningFactoryInspection sisalSpinningFactoryInspection) {

        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();


        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateSisalSpinningFactoryInspection");


        System.out.println("the local ID to be pushed " + sisalSpinningFactoryInspection.getLocalID());

        System.out.println("getAFA_Sisal_Spinning_Factory_Inspection_ID" + sisalSpinningFactoryInspection.getAFA_Sisal_Spinning_Factory_Inspection_ID());
        System.out.println("LocalID" + sisalSpinningFactoryInspection.getLocalID());
        System.out.println("ExportLicence" + sisalSpinningFactoryInspection.getSisalSpinningExportNumber());
        System.out.println("DocumentNumber" + sisalSpinningFactoryInspection.getDocumentNumber());
        System.out.println("ApplicantName" + sisalSpinningFactoryInspection.getNameOfApplicant());

        if (!TextUtils.isEmpty(sisalSpinningFactoryInspection.getAFA_Sisal_Spinning_Factory_Inspection_ID()) && TextUtils.isDigitsOnly(sisalSpinningFactoryInspection.getAFA_Sisal_Spinning_Factory_Inspection_ID())) {
            updateData.setRecordID(Integer.parseInt(sisalSpinningFactoryInspection.getAFA_Sisal_Spinning_Factory_Inspection_ID()));
        }



        data.addField("is_valid_trade_lic", sisalSpinningFactoryInspection.getIsValidTradinglicence());
        data.addField("is_valid_trade_lic_remarks", sisalSpinningFactoryInspection.getValidTradinglicenceRemarks());
        data.addField("is_nema_certified", sisalSpinningFactoryInspection.getIsValidNeMACerificaion());
        data.addField("nema_certificate_remarks", sisalSpinningFactoryInspection.getValidNeMACerificaionRemarks());
        data.addField("is_risk_assmnt_rprt", sisalSpinningFactoryInspection.getIsFireriskAssessment());
        data.addField("risk_assmnt_rprt_remarks", sisalSpinningFactoryInspection.getFireriskAssessmentRemarks());
        data.addField("is_health_safety_rprt", sisalSpinningFactoryInspection.getIsOccupationalhealthReport());
        data.addField("health_safety_rprt_remarks", sisalSpinningFactoryInspection.getOccupationalhealthReportRemarks());
        data.addField("is_fire_marshalls", sisalSpinningFactoryInspection.getIsFiremarshalls());
        data.addField("fire_marshalls_remarks", sisalSpinningFactoryInspection.getFiremarshallsRemarks());
        data.addField("is_accsbl_fire_exits", sisalSpinningFactoryInspection.getIsAccessiblefireemergencyexits());
        data.addField("accsbl_fire_exits_remarks", sisalSpinningFactoryInspection.getAccessibleFireemergencyexitsRemarks());
        data.addField("is_first_aid_kit", sisalSpinningFactoryInspection.getIsFirstAidkit());
        data.addField("first_aid_kit_remarks", sisalSpinningFactoryInspection.getFirstAidkitRemarks());
        data.addField("is_protective_gear", sisalSpinningFactoryInspection.getIsAppropriateprotectiveclothing());
        data.addField("protective_gear_remarks", sisalSpinningFactoryInspection.getAppropriateprotectiveclothing());
        data.addField("is_prtctd_mvng_parts", sisalSpinningFactoryInspection.getIsProtectedmovingParts());
        data.addField("prtctd_mvng_parts_remarks", sisalSpinningFactoryInspection.getProtectedmovingParts());
        data.addField("is_general_condition", sisalSpinningFactoryInspection.getIsGeneralcondition());
        data.addField("general_condition_remarks", sisalSpinningFactoryInspection.getGeneralconditionRemarks());
        data.addField("is_storage_conditions", sisalSpinningFactoryInspection.getIsStoragecondition());
        data.addField("storage_conditions_remarks", sisalSpinningFactoryInspection.getStorageconditionRemarks());
        data.addField("is_monthly_reports", sisalSpinningFactoryInspection.getIsProofofSubmission());
        data.addField("monthly_reports_remarks", sisalSpinningFactoryInspection.getProofofSubmission());
        data.addField("is_afa_certificate", sisalSpinningFactoryInspection.getIsCertificationbyAFA());
        data.addField("afa_certificate_remarks", sisalSpinningFactoryInspection.getCertificationbyAFARemarks());
        data.addField("is_fire_engines", sisalSpinningFactoryInspection.getIsFireengines());
        data.addField("is_water", sisalSpinningFactoryInspection.getIswater());
        data.addField("is_carbon_dioxide", sisalSpinningFactoryInspection.getIsCarbondioxide());
        data.addField("is_sand", sisalSpinningFactoryInspection.getIssand());
        data.addField("is_foam", sisalSpinningFactoryInspection.getIsfoam());
        data.addField("is_hydrant_system", sisalSpinningFactoryInspection.getIsHydrantsystem());
        data.addField("is_dry_powder", sisalSpinningFactoryInspection.getIsDrypowder());
        data.addField("fire_fighting_remarks", sisalSpinningFactoryInspection.getEtFirefightingRemarks());
        data.addField("general_remarks", sisalSpinningFactoryInspection.getComments());
        data.addField("recommendation", sisalSpinningFactoryInspection.getOfficerrecommendation());
        data.addField("recommendation_remarks", sisalSpinningFactoryInspection.getOfficerrecommendation_remark());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");
        updateData.setDataRow(data);


        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateFCDSisalSpinningFactoryInspectionSent(sisalSpinningFactoryInspection.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void postCottonBuyerInspection(CottonBuyingStoreInspection cottonBuyingStoreInspection) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateCottonBuyerInspection");

        System.out.println("the local ID to be pushed " + cottonBuyingStoreInspection.getLocalID());

        System.out.println("AFA_Cotton_Buying_Store_Inspection_ID" + cottonBuyingStoreInspection.getAFA_Cotton_Buying_Store_Inspection_ID());
        System.out.println("LocalID" + cottonBuyingStoreInspection.getLocalID());
        System.out.println("ExportLicence" + cottonBuyingStoreInspection.getCottonExportNumber());
        System.out.println("DocumentNumber" + cottonBuyingStoreInspection.getDocumentNumber());
        System.out.println("name_of_operator" + cottonBuyingStoreInspection.getNameOfOperator());


        if (!TextUtils.isEmpty(cottonBuyingStoreInspection.getAFA_Cotton_Buying_Store_Inspection_ID()) && TextUtils.isDigitsOnly(cottonBuyingStoreInspection.getAFA_Cotton_Buying_Store_Inspection_ID())) {
            updateData.setRecordID(Integer.parseInt(cottonBuyingStoreInspection.getAFA_Cotton_Buying_Store_Inspection_ID()));
        }

        data.addField("name_of_operator", cottonBuyingStoreInspection.getNameOfOperator());
        data.addField("is_sanitation", cottonBuyingStoreInspection.getIsSurroundingsofBuyingSanitaryCondition());
        data.addField("sanitation_remarks", cottonBuyingStoreInspection.getSurroundingsofBuyingSanitaryConditionRemarks());
        data.addField("is_floor_surfaced", cottonBuyingStoreInspection.getIsFloorWellsurfaced());
        data.addField("floorsurface_rmks", cottonBuyingStoreInspection.getFloorWellsurfacedRemarks());
        data.addField("is_standard_grade_box", cottonBuyingStoreInspection.getIsGradeBoxapproved());
        data.addField("gradebox_rmks", cottonBuyingStoreInspection.getGradeBoxapprovedRemarks());
        data.addField("is_weighing_scale", cottonBuyingStoreInspection.getIsCertifiedWeighingscale());
        data.addField("weighscale_rmks", cottonBuyingStoreInspection.getCertifiedWeighingScaleRemarks());
        data.addField("is_grader", cottonBuyingStoreInspection.getIsCottonBuyercenterQualified());
        data.addField("grader_rmks", cottonBuyingStoreInspection.getCottonBuyercenterQualifiedRemarks());
        data.addField("is_fire_precautions", cottonBuyingStoreInspection.getIsFirePrecauionarymeasure());
        data.addField("measure", cottonBuyingStoreInspection.getFirePrecauionarymeasureRemarks());
        data.addField("is_store_cleaned", cottonBuyingStoreInspection.getIsProperlyclean());
        data.addField("properclean_rmks", cottonBuyingStoreInspection.getProperlycleanRemarks());
        data.addField("is_store_intact", cottonBuyingStoreInspection.getIsintact());
        data.addField("store_intact_rmks", cottonBuyingStoreInspection.getIntactRemarks());
        data.addField("is_store_fumigated", cottonBuyingStoreInspection.getIsfumigated());
        data.addField("store_furmigated_rmks", cottonBuyingStoreInspection.getFumigatedRemarks());
        data.addField("seed_cotton_price_ar", cottonBuyingStoreInspection.getAr());
        data.addField("seed_cotton_price_br", cottonBuyingStoreInspection.getBr());
        data.addField("recommendation", cottonBuyingStoreInspection.getRecommendaion());
        data.addField("recommendation_remarks", cottonBuyingStoreInspection.getReasonForThegiveReccomm());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");
        updateData.setDataRow(data);


        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateCottonBuyingStoreInspectionSent(cottonBuyingStoreInspection.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void postCottonGinneryInspection(CottonGinneryInspection cottonGinneryInspection) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateCottonGinneryStoreInspection");

        System.out.println("the local ID to be pushed " + cottonGinneryInspection.getLocalId());

        System.out.println("AFA_Sisal_Factory_Inspection_ID" + cottonGinneryInspection.getAFA_Cotton_Ginnery_Inspection_ID());
        System.out.println("LocalID" + cottonGinneryInspection.getLocalId());
        System.out.println("ExportLicence" + cottonGinneryInspection.getGinningLicence());
        System.out.println("DocumentNumber" + cottonGinneryInspection.getDocumentNumber());
        System.out.println("ApplicantName" + cottonGinneryInspection.getNameOfApplicant());

        if (!TextUtils.isEmpty(cottonGinneryInspection.getAFA_Cotton_Ginnery_Inspection_ID()) && TextUtils.isDigitsOnly(cottonGinneryInspection.getAFA_Cotton_Ginnery_Inspection_ID())) {
            updateData.setRecordID(Integer.parseInt(cottonGinneryInspection.getAFA_Cotton_Ginnery_Inspection_ID()));
        }

        data.addField("seed_variety", cottonGinneryInspection.getSsSeedvariety());
        data.addField("seed_cotton_grade", cottonGinneryInspection.getSeedCottonGrade());
        data.addField("seed_cotton_weight_aftr", cottonGinneryInspection.getSeedCottonWeightOpener());
        data.addField("less_tare_weight_aftr", cottonGinneryInspection.getLessTareWeight());
        data.addField("net_weight_aftr", cottonGinneryInspection.getNettWeightOfUnCleanedSeedCotton());
        data.addField("seed_cotton_weight_bfr", cottonGinneryInspection.getCleanSeedCottonGrossKg());
        data.addField("less_tare_weight_bfr", cottonGinneryInspection.getLessTareWeightBeforeFeedingCleaned());
        data.addField("net_weight_bfr", cottonGinneryInspection.getNettWeightUncleanedSeedKg());
        data.addField("opener_waste_bfr", cottonGinneryInspection.getOpenerWasteOrDirectBefore());
        data.addField("is_protective_gear", cottonGinneryInspection.getIsAppropirateprotective());
        data.addField("is_firefightprectn", cottonGinneryInspection.getIsFireFightingprecautionary());
        data.addField("is_prtctd_mvng_parts", cottonGinneryInspection.getIsProtectedMovingparts());
        data.addField("is_fire_engines", cottonGinneryInspection.getIsFireengines());
        data.addField("is_water", cottonGinneryInspection.getIswater());
        data.addField("is_carbon_dioxide", cottonGinneryInspection.getIsCarbondioxide());
        data.addField("is_sand", cottonGinneryInspection.getIssand());
        data.addField("is_foam", cottonGinneryInspection.getIsfoam());
        data.addField("is_hydrant_system", cottonGinneryInspection.getIsHydrantsystem());
        data.addField("is_dry_powder", cottonGinneryInspection.getIsDrypowder());
        data.addField("number_of_seed_stores", cottonGinneryInspection.getHowManySeedStores());
        data.addField("seed_stores_capacity", cottonGinneryInspection.getSurroundingsOfBuyingSanitaryConditionRemarks());
        data.addField("is_bulk_storage", cottonGinneryInspection.getBulkStorage());
        data.addField("is_bags_storage", cottonGinneryInspection.getBags());
        data.addField("type_of_bags", cottonGinneryInspection.getTypeofBags());
        data.addField("seed_cotton_purchased_br", cottonGinneryInspection.getTotalseedCottonPurchaseinFielddBR());
        data.addField("seed_cotton_purchased_ar", cottonGinneryInspection.getTotalSeedPurchasedFieldARkg());
        data.addField("seed_cotton_brought_br", cottonGinneryInspection.getSeedCottonBroughtToGinnerryBR());
        data.addField("seed_cotton_brought_ar", cottonGinneryInspection.getSeedCottonBroughtToGinnerryAR());
        data.addField("seed_cotton_ginned_br", cottonGinneryInspection.getTotalCottonGinnedToDateBR());
        data.addField("seed_cotton_ginned_ar", cottonGinneryInspection.getTotalCottonGinnedToDateAR());
        data.addField("remainder_seed_cotton_br", cottonGinneryInspection.getTotalCottonRemainingInStoreBR());
        data.addField("remainder_seed_cotton_ar", cottonGinneryInspection.getTotalCottonRemainingInStoreAR());
        data.addField("remaining_store_space", cottonGinneryInspection.getRemainingStoreSpace());
        data.addField("is_roller", cottonGinneryInspection.getIsroller());
        data.addField("is_saw", cottonGinneryInspection.getIssaw());
        data.addField("single_or_double_roller", cottonGinneryInspection.getCategory());
        data.addField("total_ginning_machines", cottonGinneryInspection.getTotalNoOfGinningMachines());
        data.addField("working_ginning_units", cottonGinneryInspection.getNoOfWorkingGinningUnits());
        data.addField("current_bales_output", cottonGinneryInspection.getNoOfCurrentSalesOuput8hrs());
        data.addField("installed_bales_output", cottonGinneryInspection.getNoOfInstalledBalesOutput8hrs());
        data.addField("cumulative_bales_output", cottonGinneryInspection.getNoOfBalesProducedFromBegginingOfSession());
        data.addField("local_bale_sales", cottonGinneryInspection.getNoOfBaselsSoldLocal());
        data.addField("export_bale_sales", cottonGinneryInspection.getNoOfBalesSoldExport());
        data.addField("remainder_bales_ar", cottonGinneryInspection.getBalesRemainingInFactory());
        data.addField("remainder_bales_br", cottonGinneryInspection.getAlesRemainingInFactoryBRKg());
        data.addField("seeds_produced_br", cottonGinneryInspection.getSeedsProducedBRkg());
        data.addField("seeds_produced_ar", cottonGinneryInspection.getSeedsProduceArKg());
        data.addField("planting_seed_available", cottonGinneryInspection.getPlantingSeedAvailableKg());
        data.addField("last_year_carryover_seed", cottonGinneryInspection.getLastYearCarryOver());
        data.addField("seed_sold_out", cottonGinneryInspection.getSeedsSoldForPlanting());
        data.addField("seed_sold_to_millers", cottonGinneryInspection.getSeedsSoldToMillersKg());
        data.addField("seed_remaining", cottonGinneryInspection.getSeedRemaining());
        data.addField("buying_centre_store", cottonGinneryInspection.getBuyingCenterStore());
        data.addField("bought", cottonGinneryInspection.getBoughtKg());
        data.addField("received_at_ginnery", cottonGinneryInspection.getReceivedAtGinner());
        data.addField("remaining_in_field", cottonGinneryInspection.getRemainingInTheField());
        data.addField("recommendation", cottonGinneryInspection.getOfficerrecommendation());
        data.addField("recommendation_remarks", cottonGinneryInspection.getOfficerrecommendation_remark());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");
        updateData.setDataRow(data);


        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateCottonGinneryInspectionSent(cottonGinneryInspection.getLocalId(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void postCottonLintClassingReport(CottonLintClassingReport cottonLintClassingReport) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateCottonLintClassingReport");

        System.out.println("the local ID to be pushed " + cottonLintClassingReport.getLocalId());

        System.out.println("AFA_Cotton_Lint_Classing_Report_ID" + cottonLintClassingReport.getAFA_Cotton_Lint_Classing_Report_ID());
        System.out.println("LocalID" + cottonLintClassingReport.getLocalId());
        System.out.println("ExportLicence" + cottonLintClassingReport.getLintLicence());
        System.out.println("DocumentNumber" + cottonLintClassingReport.getDocumentNumber());
        System.out.println("ApplicantName" + cottonLintClassingReport.getNameOfApplicant());

        if (!TextUtils.isEmpty(cottonLintClassingReport.getAFA_Cotton_Lint_Classing_Report_ID()) && TextUtils.isDigitsOnly(cottonLintClassingReport.getAFA_Cotton_Lint_Classing_Report_ID())) {
            updateData.setRecordID(Integer.parseInt(cottonLintClassingReport.getAFA_Cotton_Lint_Classing_Report_ID()));
        }

        data.addField("sample_identity", cottonLintClassingReport.getSampleIdentification());
        data.addField("analysisdate", cottonLintClassingReport.getAnalysisDate());
        data.addField("origin", cottonLintClassingReport.getOrigin());
        data.addField("micronaire", cottonLintClassingReport.getMicronaire());
        data.addField("length_inch", cottonLintClassingReport.getLengthInches());
        data.addField("length_mm", cottonLintClassingReport.getLengthMillimeters());
        data.addField("uniformity_index", cottonLintClassingReport.getUniformityIndex());
        data.addField("strength", cottonLintClassingReport.getStrength());
        data.addField("color_rd", cottonLintClassingReport.getColorRd());
        data.addField("color_b", cottonLintClassingReport.getColorB());
        data.addField("color_grade", cottonLintClassingReport.getColorGrade());
        data.addField("remarks", cottonLintClassingReport.getRemarks());
        data.addField("DocStatus", "AP");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");
        updateData.setDataRow(data);


        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateCottonLintClassingReportSent(cottonLintClassingReport.getLocalId(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void postAvocadoQualityInspection(AvocadoQualityInspection avocadoQualityInspection) {
        StandardResponse response = null;
        UpdateDataRequest updateData = new UpdateDataRequest();
        DataRow data = new DataRow();

        updateData.setLogin(getLogin());
        updateData.setWebServiceType("UpdateAvocadoQualityInspection");

        System.out.println("the local ID to be pushed " + avocadoQualityInspection.getLocalID());

        System.out.println("AFA_HC_Packhouse_Insp_ID" + avocadoQualityInspection.getAFA_HCD_Avocado_Quality_Inspection_ID());
        System.out.println("LocalID" + avocadoQualityInspection.getLocalID());
        System.out.println("ExportLicence" + avocadoQualityInspection.getHorticultureExporterRequest());
        System.out.println("DocumentNumber" + avocadoQualityInspection.getDocumentNumber());
        System.out.println("ApplicantName" + avocadoQualityInspection.getNameOfApplicant());


        if (!TextUtils.isEmpty(avocadoQualityInspection.getAFA_HCD_Avocado_Quality_Inspection_ID()) && TextUtils.isDigitsOnly(avocadoQualityInspection.getAFA_HCD_Avocado_Quality_Inspection_ID())) {
            updateData.setRecordID(Integer.parseInt(avocadoQualityInspection.getAFA_HCD_Avocado_Quality_Inspection_ID()));
        }

        data.addField("isfskinglossyshine", avocadoQualityInspection.getIsFuarteSkinglossyShine());
        data.addField("remark1", avocadoQualityInspection.getFuarteSkinglossyShineRemarks());
        data.addField("isfcolourgreenyellow", avocadoQualityInspection.getIsFuartecolorGreeWithYelowFint());
        data.addField("remark2", avocadoQualityInspection.getFuarteColorGreeWithYelowFintRemarks());
        data.addField("isskinsmoothblossom", avocadoQualityInspection.getIsFuarteskinTextureSmooth());
        data.addField("remark3", avocadoQualityInspection.getFuarteSkinTextureSmoothRemarks());
        data.addField("isfleshcolcreamyyello", avocadoQualityInspection.getIsFuarteFleshcolorCreamyYellow());
        data.addField("remark4", avocadoQualityInspection.getFuarteFleshcolorCreamyYellowRemarks());
        data.addField("ishcolorgreenpurpl", avocadoQualityInspection.getIsHasscolorGreen());
        data.addField("remark5", avocadoQualityInspection.getHassColorGreenRemarks());
        data.addField("ishskintexrough", avocadoQualityInspection.getIsHassSkintextureRough());
        data.addField("remark6", avocadoQualityInspection.getHassSkinTextureRoughRemarks());
        data.addField("ishfleshcolorcreamyell", avocadoQualityInspection.getIsHassFleshcolorCreamy());
        data.addField("remark7", avocadoQualityInspection.getHassFleshColorCreamyRemarks());
        data.addField("isoskincologreenyell", avocadoQualityInspection.getIsSkinColorgreenToYellow());
        data.addField("remark8", avocadoQualityInspection.getSkinColorGreenToYellowRemarks());
        data.addField("isoskkinsmoothblossom", avocadoQualityInspection.getIsSkinsmoothAtBlossom());
        data.addField("remark9", avocadoQualityInspection.getSkinSmoothAtBlossomRemarks());
        data.addField("isofleshcolorcreamyell", avocadoQualityInspection.getIsFleshcolorCreamy());
        data.addField("remark10", avocadoQualityInspection.getFleshColorCreamyRemarks());
        data.addField("isoilcontent1", avocadoQualityInspection.getIsOilcontent1());
        data.addField("remark11", avocadoQualityInspection.getOilContent());
        data.addField("isstalkpresent5mm", avocadoQualityInspection.getIsStalkpressence());
        data.addField("remark12", avocadoQualityInspection.getStalkPressenceRemarks());
        data.addField("isskinwounddamage", avocadoQualityInspection.getIsWoundsdamage());
        data.addField("remark13", avocadoQualityInspection.getWoundsDamageRemarks());
        data.addField("isdiscolourration", avocadoQualityInspection.getIsDiscoloration());
        data.addField("remark14", avocadoQualityInspection.getDiscolourationRemarks());
        data.addField("fruitsizing", avocadoQualityInspection.getFruitSizing());
        data.addField("isunifirmityvariety", avocadoQualityInspection.getIsvariety());
        data.addField("remark15", avocadoQualityInspection.getVarietyRemarks());
        data.addField("isunifirmitycolor", avocadoQualityInspection.getIsHassFleshcolorCreamy());
        data.addField("remark16", avocadoQualityInspection.getColorRemarks());
        data.addField("isunifirmitysize", avocadoQualityInspection.getIssize());
        data.addField("remark17", avocadoQualityInspection.getSizeRemarks());
        data.addField("isfruitfirm", avocadoQualityInspection.getIsFruitfirm());
        data.addField("remark18", avocadoQualityInspection.getFruitFirmRemarks());
        data.addField("isforematterpres", avocadoQualityInspection.getIsForeignmatterPresent());
        data.addField("remark19", avocadoQualityInspection.getForeignMatterPresentRemarks());
        data.addField("ismoistureon", avocadoQualityInspection.getIsMoistureonFruits());
        data.addField("remark20", avocadoQualityInspection.getMoistureOnFruitsRemarks());
        data.addField("ispostharvesttreatment", avocadoQualityInspection.getIsPostharvestTreatment());
        data.addField("remark21", avocadoQualityInspection.getPostHarvestTreatmentRemarks());
        data.addField("Comments", avocadoQualityInspection.getComments());
        data.addField("DocStatus", "CO");
        data.addField("DocAction", "CL");
        data.addField("Processing", "Y");
        data.addField("ismobile", "Y");
        data.addField("IsApproved", "Y");

        updateData.setDataRow(data);


        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(updateData);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

                db.updateAvocadoQualityInspectionSent(avocadoQualityInspection.getLocalID(), response.getRecordID().toString());
                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void postAvocadoQualityInspectionOilContent(AvocadoQualityInspectionOilContent avocadoQualityInspectionOilContent) {
        StandardResponse response = null;
        CreateDataRequest createDataRequest = new CreateDataRequest();
        DataRow data = new DataRow();

        createDataRequest.setLogin(getLogin());
        createDataRequest.setWebServiceType("CreateAvocadoQualityInspectionOilContent");

        System.out.println("the local ID to be pushed " + avocadoQualityInspectionOilContent.getLocalID());

        System.out.println("AFA_HC_Avocadochecklist_ID" + avocadoQualityInspectionOilContent.getAFA_HCD_Avocado_Quality_Inspection_ID());
        System.out.println("LocalID" + avocadoQualityInspectionOilContent.getLocalID());
        System.out.println("Destination" + avocadoQualityInspectionOilContent.getDestination());
        System.out.println("FinalWt" + avocadoQualityInspectionOilContent.getFinalWt());
        System.out.println("InitialWt" + avocadoQualityInspectionOilContent.getInitialWT());
        System.out.println("oil_content" + avocadoQualityInspectionOilContent.getOilContent());
        System.out.println("C_BPartner_ID" + db.getAvocadoQualityInspectionCBPartnerID(avocadoQualityInspectionOilContent.getAFA_HCD_Avocado_Quality_Inspection_ID()));

        if (null != app.getAdUser()) {
            data.addField("AD_User_ID", app.getAdUser().getAd_user_id());
        }

        data.addField("C_BPartner_ID", db.getAvocadoQualityInspectionCBPartnerID(avocadoQualityInspectionOilContent.getAFA_HCD_Avocado_Quality_Inspection_ID()));
        data.addField("applicationdate", new Timestamp(System.currentTimeMillis()));
        data.addField("application_date", new Timestamp(System.currentTimeMillis()));
        data.addField("AFA_HC_Avocadochecklist_ID", Integer.parseInt(avocadoQualityInspectionOilContent.getAFA_HCD_Avocado_Quality_Inspection_ID()));
        data.addField("source", avocadoQualityInspectionOilContent.getSource());
        data.addField("destination", avocadoQualityInspectionOilContent.getDestination());
        data.addField("sample_variety", avocadoQualityInspectionOilContent.getSampleVariety());
        data.addField("s_fruitsize", avocadoQualityInspectionOilContent.getSampleFruitSize());
        data.addField("initialwt", avocadoQualityInspectionOilContent.getInitialWT());
        data.addField("finalwt", avocadoQualityInspectionOilContent.getFinalWt());
        data.addField("moisture_content_iwfw", avocadoQualityInspectionOilContent.getMoistureContentIWFW());
        data.addField("moistu_contentperc", avocadoQualityInspectionOilContent.getMoistureContentPercetage());
        data.addField("oil_content", avocadoQualityInspectionOilContent.getOilContent());
        data.addField("remarks", avocadoQualityInspectionOilContent.getRemarks());
        data.addField("DocStatus", "DR");
        data.addField("IsApproved", "N");
        data.addField("Processing", "N");
        createDataRequest.setDataRow(data);

        WebServiceConnection client = getClient();

        try {
            response = client.sendRequest(createDataRequest);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                System.out.println("RecordID: " + response.getRecordID());

//                db.deleteSingleAvocadoQualityInspectionList(avocadoQualityInspectionOilContent.getLocalID());
                db.updateHCDAvocadoQualityInspectionOilContentSent(avocadoQualityInspectionOilContent.getLocalID());

                System.out.println();

                for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                    System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void postPersonalHygiene() {
        StandardResponse response = null;
        CreateDataRequest createDataRequest = new CreateDataRequest();
        DataRow data = new DataRow();

        createDataRequest.setLogin(getLogin());
        createDataRequest.setWebServiceType("CreatePersonalHygiene");

        List<HCDPersonalHygene> personalHygienDetailsList = db.getPersonalHygiene();

        for (int k = 0; k < personalHygienDetailsList.size(); k++) {

            HCDPersonalHygene personalHygienDetails = personalHygienDetailsList.get(k);

            System.out.println("the local ID to be pushed " + personalHygienDetails.getLocalID());

            if (null != app.getAdUser()) {
                data.addField("AD_User_ID", app.getAdUser().getAd_user_id());

            }
            data.addField("C_BPartner_ID", personalHygienDetails.getSsnameOfApplicant());
            data.addField("applicationdate", new Timestamp(System.currentTimeMillis()));
            data.addField("DocStatus", "CO");
            data.addField("DocAction", "CL");
            data.addField("IsApproved", "Y");
            data.addField("Processing", "Y");
            createDataRequest.setDataRow(data);


            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createDataRequest);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());

//                db.deleteSingleAvocadoQualityInspectionList(personalHygienDetails.getLocalID());
                    db.updateColdRoomSent("personal_hygiene_inspection", personalHygienDetails.getLocalID(), response.getRecordID().toString());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void postPersonalHygieneRecord() {
        StandardResponse response = null;
        CreateDataRequest createDataRequest = new CreateDataRequest();
        DataRow data = new DataRow();

        createDataRequest.setLogin(getLogin());
        createDataRequest.setWebServiceType("CreatePersonalHygieneRecord");

        List<HCDPersonalHygene> personalHygienDetailsList = db.getPersonalHygienDetails();

        for (int k = 0; k < personalHygienDetailsList.size(); k++) {

            HCDPersonalHygene personalHygienDetails = personalHygienDetailsList.get(k);

            System.out.println("the local ID to be pushed " + personalHygienDetails.getLocalID());

            System.out.println("AFA_HCD_Persanl_Hygiene_ID" + personalHygienDetails.getAFA_HCD_Persanl_Hygiene_ID());
            System.out.println("LocalID" + personalHygienDetails.getLocalID());

            if (null != app.getAdUser()) {
                data.addField("AD_User_ID", app.getAdUser().getAd_user_id());
            }
            data.addField("AFA_HC_Peronalhygenechklst_ID", db.getSentPersonalHygieneID(personalHygienDetails.getLocalID()).getServerID());
            data.addField("namest", personalHygienDetails.getNames());
            data.addField("national_id", personalHygienDetails.getNationalId());
            data.addField("medcert_no", personalHygienDetails.getMedicalCertNo());
            data.addField("isdust_cots", personalHygienDetails.getIsdustCots());
            data.addField("ish_gear_caps", personalHygienDetails.getHgearCaps());
            data.addField("isjewels", personalHygienDetails.getIsjewels());
            data.addField("isnailscut", personalHygienDetails.getIsnailsCut());
            data.addField("isbody_clean", personalHygienDetails.getIsbodyClean());
            data.addField("isshoes", personalHygienDetails.getIsshoes());
            data.addField("DocStatus", "CO");
            data.addField("DocAction", "CL");
            data.addField("Processing", "Y");
            createDataRequest.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createDataRequest);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());

//                db.deleteSingleAvocadoQualityInspectionList(personalHygienDetails.getLocalID());
                    db.updateColdRoomSent("personal_hygiene_details", personalHygienDetails.getLocalID(), response.getRecordID().toString());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }

                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void postColdRoomDetails() {
        StandardResponse response = null;
        CreateDataRequest createDataRequest = new CreateDataRequest();
        DataRow data = new DataRow();

        createDataRequest.setLogin(getLogin());
        createDataRequest.setWebServiceType("CreateColdRoomTemperatureRecord");


        List<HCDColdRoomTemperatures> coldRoomList = db.getColdRoomTemparatureDetails();
        for (int k = 0; k < coldRoomList.size(); k++) {

            HCDColdRoomTemperatures hcdColdRoomTemperatures = coldRoomList.get(k);

            System.out.println("coldRoom Record ID to push " + hcdColdRoomTemperatures.getLocalID());

            System.out.println("LocalID" + hcdColdRoomTemperatures.getLocalID());
            System.out.println("AFA_HC_Coldrmtempsrec_ID" + db.getSentColdRoomID(hcdColdRoomTemperatures.getLocalID()).getServerID());

            data.addField("cold_room_no", hcdColdRoomTemperatures.getColdRoom());
            data.addField("time_t", new Timestamp(System.currentTimeMillis()));
            data.addField("indicator_temp_read", hcdColdRoomTemperatures.getIndicatorTempe());
            data.addField("therm_temp_read", hcdColdRoomTemperatures.getThermometerProbeTem());
            data.addField("AFA_HC_Coldrmtempsrec_ID", db.getSentColdRoomID(hcdColdRoomTemperatures.getLocalID()).getServerID());

            if (null != app.getAdUser()) {
                data.addField("AD_User_ID", app.getAdUser().getAd_user_id());
            }
            data.addField("DocStatus", "CO");
            data.addField("DocAction", "CL");
            data.addField("Processing", "Y");
            createDataRequest.setDataRow(data);


            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createDataRequest);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());

//                db.deleteSingleAvocadoQualityInspectionList(hcdColdRoomTemperatures.getLocalID());
                    db.updateColdRoomSent("cold_room_temperature_details", hcdColdRoomTemperatures.getLocalID(), response.getRecordID().toString());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void postColdRoomInspection() {
        StandardResponse response = null;
        CreateDataRequest createDataRequest = new CreateDataRequest();
        DataRow data = new DataRow();

        createDataRequest.setLogin(getLogin());
        createDataRequest.setWebServiceType("CreateColdRoomTemperatureInspection");


        List<HCDColdRoomTemperatures> coldRoomList = db.getColdRoomTemparatureInspection();
        for (int k = 0; k < coldRoomList.size(); k++) {

            HCDColdRoomTemperatures hcdColdRoomTemperatures = coldRoomList.get(k);

            System.out.println("coldRoom Record ID to push " + hcdColdRoomTemperatures.getLocalID());
            System.out.println("the local ID to be pushed " + hcdColdRoomTemperatures.getLocalID());

            System.out.println("LocalID" + hcdColdRoomTemperatures.getLocalID());
            if (null != app.getAdUser()) {
                data.addField("AD_User_ID", app.getAdUser().getAd_user_id());

            }
            data.addField("C_BPartner_ID", hcdColdRoomTemperatures.getNameOfApplicant());
            data.addField("applicationdate", new Timestamp(System.currentTimeMillis()));
//            data.addField("C_BPartner_ID", "1000057");
            data.addField("DocStatus", "CO");
            data.addField("DocAction", "CL");
            data.addField("IsApproved", "Y");
            data.addField("Processing", "Y");

            createDataRequest.setDataRow(data);


            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createDataRequest);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());

//                db.deleteSingleAvocadoQualityInspectionList(hcdColdRoomTemperatures.getLocalID());
                    db.updateColdRoomSent("cold_room_temperature_inspection", hcdColdRoomTemperatures.getLocalID(), response.getRecordID().toString());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public void postNOCDMarketPrice() {
        StandardResponse response = null;
        CreateDataRequest createDataRequest = new CreateDataRequest();
        DataRow data = new DataRow();

        createDataRequest.setLogin(getLogin());
        createDataRequest.setWebServiceType("CreateNOCDMarketPrice");


        List<NOCDMarketPriceSurveyDetails> unsentNOCDMarketPriceList = db.getUnsentNOCDMarketPrice();
        for (int k = 0; k < unsentNOCDMarketPriceList.size(); k++) {

            NOCDMarketPriceSurveyDetails nocdMarketPriceSurveyDetails = unsentNOCDMarketPriceList.get(k);

            System.out.println("coldRoom Record ID to push " + nocdMarketPriceSurveyDetails.getLocalID());

            System.out.println("LocalID" + nocdMarketPriceSurveyDetails.getLocalID());
            System.out.println("AFA_ND_Marketprices_ID" + db.getSentColdRoomID(nocdMarketPriceSurveyDetails.getLocalID()).getServerID());

            //todo
//            data.addField("c_bpartner_id", new Timestamp(System.currentTimeMillis()));
            data.addField("applicationdate", new Timestamp(System.currentTimeMillis()));
            data.addField("M_Product_ID", nocdMarketPriceSurveyDetails.getProduct());
            data.addField("brandname", nocdMarketPriceSurveyDetails.getBrandName());
            data.addField("quantity", nocdMarketPriceSurveyDetails.getQuantity());
            data.addField("Price", nocdMarketPriceSurveyDetails.getPrice());
            data.addField("market_outlets", nocdMarketPriceSurveyDetails.getMarketOutlet());
            data.addField("AFA_ND_Marketprices_ID", db.getNOCDMarketPriceSurveyServerID(nocdMarketPriceSurveyDetails.getParentID(), "table_nuts_and_oils_market_locations"));

            if (null != app.getAdUser()) {
                data.addField("AD_User_ID", app.getAdUser().getAd_user_id());
            }
            data.addField("DocStatus", "CO");
            data.addField("DocAction", "CL");
            data.addField("IsApproved", "Y");
            data.addField("Processing", "Y");
            createDataRequest.setDataRow(data);


            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createDataRequest);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());

//                db.deleteSingleAvocadoQualityInspectionList(nocdMarketPriceSurveyDetails.getLocalID());
                    db.updateNOCDMarketPriceSurveySent("table_nuts_and_oils_market_prices", nocdMarketPriceSurveyDetails.getLocalID(), response.getRecordID().toString());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void postNOCDLocation() {
        StandardResponse response = null;
        CreateDataRequest createDataRequest = new CreateDataRequest();
        DataRow data = new DataRow();

        createDataRequest.setLogin(getLogin());
        createDataRequest.setWebServiceType("CreateNOCDLocation");


        List<NOCDMarketPriceSurveyDetails> unsentNOCDMarketLocationList = db.getUnsentNOCDMarketLocation();
        for (int k = 0; k < unsentNOCDMarketLocationList.size(); k++) {

            NOCDMarketPriceSurveyDetails nocdMarketPriceSurveyDetails = unsentNOCDMarketLocationList.get(k);

            System.out.println("coldRoom Record ID to push " + nocdMarketPriceSurveyDetails.getLocalID());
            System.out.println("the local ID to be pushed " + nocdMarketPriceSurveyDetails.getLocalID());

            System.out.println("LocalID" + nocdMarketPriceSurveyDetails.getLocalID());
            if (null != app.getAdUser()) {
                data.addField("AD_User_ID", app.getAdUser().getAd_user_id());

            }
            data.addField("SPD_County_ID", nocdMarketPriceSurveyDetails.getCountyID());
            data.addField("SPD_SubCounty_ID", nocdMarketPriceSurveyDetails.getSubCountyID());
            data.addField("sub_location", nocdMarketPriceSurveyDetails.getSubLocation());
            data.addField("latitude", nocdMarketPriceSurveyDetails.getLatitude());
            data.addField("longitude", nocdMarketPriceSurveyDetails.getLongitude());
            data.addField("applicationdate", new Timestamp(System.currentTimeMillis()));
            data.addField("DocStatus", "CO");
            data.addField("DocAction", "CL");
            data.addField("IsApproved", "Y");
            data.addField("Processing", "Y");
            createDataRequest.setDataRow(data);


            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createDataRequest);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());

//                db.deleteSingleAvocadoQualityInspectionList(nocdMarketPriceSurveyDetails.getLocalID());
                    db.updateNOCDMarketPriceSurveySent("table_nuts_and_oils_market_locations", nocdMarketPriceSurveyDetails.getLocalID(), response.getRecordID().toString());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void postColdStorageRegister() {
        StandardResponse response = null;
        CreateDataRequest createDataRequest = new CreateDataRequest();
        DataRow data = new DataRow();

        createDataRequest.setLogin(getLogin());
        createDataRequest.setWebServiceType("CreateCropsColdStorageRegister");


        List<HorticulturalCropsColdStorageRegister> horticulturalCropsColdStorageRegisterList = db.getAllHorticulturalCropsColdStorageRegister();
        for (int k = 0; k < horticulturalCropsColdStorageRegisterList.size(); k++) {

            HorticulturalCropsColdStorageRegister horticulturalCropsColdStorageRegister = horticulturalCropsColdStorageRegisterList.get(k);

            System.out.println("coldRoom Record ID to push " + horticulturalCropsColdStorageRegister.getLocalID());
            System.out.println("the local ID to be pushed " + horticulturalCropsColdStorageRegister.getLocalID());

            System.out.println("LocalID" + horticulturalCropsColdStorageRegister.getLocalID());
            if (null != app.getAdUser()) {
                data.addField("AD_User_ID", app.getAdUser().getAd_user_id());

            }
            data.addField("C_BPartner_ID", horticulturalCropsColdStorageRegister.getNameOfApplicant());
            data.addField("iscontract", "Y");
            data.addField("AFA_HC_Coldroomlease_ID", "1000017");
//            data.addField("latitude", horticulturalCropsColdStorageRegister.getLatitude());
            if (null != app.getAdUser()) {
                data.addField("AD_User_ID", app.getAdUser().getAd_user_id());
            }
            data.addField("applicationdate", new Timestamp(System.currentTimeMillis()));
            data.addField("DocStatus", "CO");
            data.addField("DocAction", "CL");
            data.addField("IsApproved", "N");
            data.addField("Processing", "N");
            createDataRequest.setDataRow(data);


            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createDataRequest);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());

//                db.deleteSingleAvocadoQualityInspectionList(nocdMarketPriceSurveyDetails.getLocalID());
                    db.updateNOCDMarketPriceSurveySent("Horticultural_Crops_Cold_Storage_Register", horticulturalCropsColdStorageRegister.getLocalID(), response.getRecordID().toString());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void postColdStorageIn() {
        StandardResponse response = null;
        CreateDataRequest createDataRequest = new CreateDataRequest();
        DataRow data = new DataRow();

        createDataRequest.setLogin(getLogin());
        createDataRequest.setWebServiceType("CreateCropsColdStorageIn");

        List<HorticulturalCropsColdStorageIn> horticulturalCropsColdStorageInList = db.getAllHorticulturalCropsColdStorageIn();
        for (int k = 0; k < horticulturalCropsColdStorageInList.size(); k++) {

            HorticulturalCropsColdStorageIn horticulturalCropsColdStorageIn = horticulturalCropsColdStorageInList.get(k);

            System.out.println("coldstorage Record ID to push " + horticulturalCropsColdStorageIn.getLocalID());

            System.out.println("LocalID" + horticulturalCropsColdStorageIn.getLocalID());
            System.out.println("AFA_HC_Coldstrgroomreg_ID" + db.getSentCropColdStorageRegisterID(horticulturalCropsColdStorageIn.getParentID()).getServerRecordID());

//            data.addField("c_bpartner_id", new Timestamp(System.currentTimeMillis()));
            data.addField("applicationdate", new Timestamp(System.currentTimeMillis()));
            data.addField("date_in", Timestamp.valueOf(horticulturalCropsColdStorageIn.getDateBrought()));
            data.addField("M_Product_ID", horticulturalCropsColdStorageIn.getProduct());
            data.addField("cold_room_no", horticulturalCropsColdStorageIn.getColdRoomNo());
            data.addField("M_Product_Category_ID", horticulturalCropsColdStorageIn.getProductsCategory());
            data.addField("packaging_mater", horticulturalCropsColdStorageIn.getPackaginMaterial());
            data.addField("quality", horticulturalCropsColdStorageIn.getQuality());
            data.addField("weight_in", horticulturalCropsColdStorageIn.getWeightIn());
            data.addField("AFA_HC_Dailymonthpay_ID", horticulturalCropsColdStorageIn.getPayCategory());
            data.addField("AFA_HC_Coldstrgroomreg_ID", db.getSentCropColdStorageRegisterID(horticulturalCropsColdStorageIn.getParentID()).getServerRecordID());

            if (null != app.getAdUser()) {
                data.addField("AD_User_ID", app.getAdUser().getAd_user_id());
            }
//            data.addField("DocStatus", "CO");
            data.addField("DocAction", "CL");
            data.addField("IsApproved", "N");
            data.addField("Processing", "N");
            createDataRequest.setDataRow(data);

            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createDataRequest);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());

//                db.deleteSingleAvocadoQualityInspectionList(nocdMarketPriceSurveyDetails.getLocalID());
                    db.updateNOCDMarketPriceSurveySent("Horticulture_Cold_Storage_In", horticulturalCropsColdStorageIn.getLocalID(), response.getRecordID().toString());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void postColdStorageOut() {
        StandardResponse response = null;
        CreateDataRequest createDataRequest = new CreateDataRequest();
        DataRow data = new DataRow();

        createDataRequest.setLogin(getLogin());
        createDataRequest.setWebServiceType("CreateCropsColdStorageOut");

        List<HorticulturalCropsColdStorageOut> horticulturalCropsColdStorageInList = db.getAllHorticulturalCropsColdStorageOut();
        for (int k = 0; k < horticulturalCropsColdStorageInList.size(); k++) {

            HorticulturalCropsColdStorageOut horticulturalCropsColdStorageOut = horticulturalCropsColdStorageInList.get(k);

            System.out.println("coldstorage Record ID to push " + horticulturalCropsColdStorageOut.getLocalID());

            System.out.println("LocalID" + horticulturalCropsColdStorageOut.getLocalID());
            System.out.println("AFA_HC_Coldsin_ID" + db.getSentCropColdStorageInID(horticulturalCropsColdStorageOut.getParentID()).getServerRecordID());

            data.addField("applicationdate", new Timestamp(System.currentTimeMillis()));
            data.addField("date_out", Timestamp.valueOf(horticulturalCropsColdStorageOut.getDateOut()));
            data.addField("weight_out", horticulturalCropsColdStorageOut.getWeightOut());
            data.addField("AFA_HC_Coldsin_ID", db.getSentCropColdStorageInID(horticulturalCropsColdStorageOut.getParentID()).getServerRecordID());

            if (null != app.getAdUser()) {
                data.addField("AD_User_ID", app.getAdUser().getAd_user_id());
            }

            data.addField("DocAction", "CL");
            data.addField("IsApproved", "N");
            data.addField("Processing", "N");
            createDataRequest.setDataRow(data);


            WebServiceConnection client = getClient();

            try {
                response = client.sendRequest(createDataRequest);

                if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                    System.out.println(response.getErrorMessage());
                } else {

                    System.out.println("RecordID: " + response.getRecordID());

//                db.deleteSingleAvocadoQualityInspectionList(nocdMarketPriceSurveyDetails.getLocalID());
                    db.updateNOCDMarketPriceSurveySent("Horticulture_Cold_Storage_OUT", horticulturalCropsColdStorageOut.getLocalID(), response.getRecordID().toString());
                    System.out.println();

                    for (int i = 0; i < response.getOutputFields().getFieldsCount(); i++) {
                        System.out.println("Column" + (i + 1) + ": " + response.getOutputFields().getField(i).getColumn() + " = " + response.getOutputFields().getField(i).getValue());
                    }
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void deleteAllHeaderSent() {


        System.out.println("Deleting all header data RecordID");
        db.deleteSentCensusRecords("farmer");
        db.deleteSentCensusRecords("miller");
        db.deleteSentCensusRecords("shop");


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
        User user = db.getLogin();
        if ((user == null)) {
            user = new User();
            user.setUsername("brisk.afa.mobile@gmail.com");
            user.setPassword("abc123");
        }


        LoginRequest login = new LoginRequest();

        if (user != null) {
            login.setUser(user.getUsername());
            login.setPass(user.getPassword());
            login.setClientID(1000000);
            login.setRoleID(1000000);
            login.setOrgID(1000000);
            login.setWarehouseID(1000000);
        }

        return login;
    }

}
