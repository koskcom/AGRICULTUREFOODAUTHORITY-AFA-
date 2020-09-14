package co.ke.bsl.data;


import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import co.ke.bsl.data.dao.AvocadoQualityInspectionDao;
import co.ke.bsl.data.dao.CaneCensusDao;
import co.ke.bsl.data.dao.ClientDao;
import co.ke.bsl.data.dao.CoffeeCommercialMarketingAgentDao;
import co.ke.bsl.data.dao.CoffeeExporterDealerInspectionDao;
import co.ke.bsl.data.dao.CoffeeGrowerMarketingAgentDao;
import co.ke.bsl.data.dao.CoffeeManagementAgentDao;
import co.ke.bsl.data.dao.CoffeeMillerLicenceDao;
import co.ke.bsl.data.dao.CoffeeNurseryCertificateInspectionDao;
import co.ke.bsl.data.dao.CoffeePulpingStationATEDao;
import co.ke.bsl.data.dao.CoffeePulpingStationPSLDao;
import co.ke.bsl.data.dao.ColdRoomTemperatureDao;
import co.ke.bsl.data.dao.CottonBuyingStoreInspectionDao;
import co.ke.bsl.data.dao.CottonGinneryInspectionDao;
import co.ke.bsl.data.dao.CottonLintClassingReportDao;
import co.ke.bsl.data.dao.FoodCropExportDao;
import co.ke.bsl.data.dao.FoodProcessingDao;
import co.ke.bsl.data.dao.FoodWareHouseDao;
import co.ke.bsl.data.dao.FruitsAndVegetablesConsolidatorsDao;
import co.ke.bsl.data.dao.FruitsAndVegetablesExportersDeskVettingDao;
import co.ke.bsl.data.dao.HorticulturalCropsColdStorageDao;
import co.ke.bsl.data.dao.HorticulturalFlowerConsolidatorsDao;
import co.ke.bsl.data.dao.HorticulturalFlowerExportersDeskVettingDao;
import co.ke.bsl.data.dao.HorticulturalPackhouseWarehouseDao;
import co.ke.bsl.data.dao.HorticulturalProduceTransportationDao;
import co.ke.bsl.data.dao.HorticultureCropExportLicenceDao;
import co.ke.bsl.data.dao.HorticultureNurseryInspectionDao;
import co.ke.bsl.data.dao.MangoQualityInspectionDao;
import co.ke.bsl.data.dao.NutsAndOilsSurveyDao;
import co.ke.bsl.data.dao.PersonalHygieneDao;
import co.ke.bsl.data.dao.PyrethrumInspectionDao;
import co.ke.bsl.data.dao.RetailsPricesSurveyDao;
import co.ke.bsl.data.dao.SisalFactoryInspectionDao;
import co.ke.bsl.data.dao.SisalSpinninginspectionDao;
import co.ke.bsl.data.dao.SugarMillLicenceDao;
import co.ke.bsl.data.dao.TeaPackerDao;
import co.ke.bsl.data.dao.TeaWarehouseManDao;
import co.ke.bsl.data.dao.WholesalePricesSurveyDao;
import co.ke.bsl.data.dao.UserDao;
import co.ke.bsl.data.model.CaneCensus;
import co.ke.bsl.data.model.ClientInfo;
import co.ke.bsl.data.model.CoffeeCommercialMarketingAgent;
import co.ke.bsl.data.model.CoffeeExporterDealerInspection;
import co.ke.bsl.data.model.CoffeeGrowerMarketingAgent;
import co.ke.bsl.data.model.CoffeeManagementAgent;
import co.ke.bsl.data.model.CoffeeMillerLicenceApplication;
import co.ke.bsl.data.model.CoffeeNurseryCert;
import co.ke.bsl.data.model.CoffeePulpingStationPSL;
import co.ke.bsl.data.model.FCDCottonBuyingStoreInspection;
import co.ke.bsl.data.model.FCDCottonGinneryInspection;
import co.ke.bsl.data.model.FCDCottonLintClassingReport;
import co.ke.bsl.data.model.FCDSisalFactoryInspection;
import co.ke.bsl.data.model.FCDSisalSpinningFactoryInspection;
import co.ke.bsl.data.model.FoodCrop;
import co.ke.bsl.data.model.FoodProcessing;
import co.ke.bsl.data.model.FoodWarehouse;
import co.ke.bsl.data.model.FruitVegetableConsolidators;
import co.ke.bsl.data.model.FruitsVegetablesExportersDeskVetting;
import co.ke.bsl.data.model.HCDAvocadoQualityInspection;
import co.ke.bsl.data.model.HCDColdRoomTemperatures;
import co.ke.bsl.data.model.HCDFlowersConsolidators;
import co.ke.bsl.data.model.HCDHorticulturalCropsColdStorage;
import co.ke.bsl.data.model.HCDMangoQualityInspection;
import co.ke.bsl.data.model.HCDNurseryInspection;
import co.ke.bsl.data.model.HCDParkhouseWarehouse;
import co.ke.bsl.data.model.HCDPersonalHygene;
import co.ke.bsl.data.model.HorticulturalFlowerExportersDeskVetting;
import co.ke.bsl.data.model.HorticultureCropExportLicenceFarmInspection;
import co.ke.bsl.data.model.HorticultureProduceTransportation;
import co.ke.bsl.data.model.NOCDMarketPriceSurvey;
import co.ke.bsl.data.model.PulpingStationLicenseApplication;
import co.ke.bsl.data.model.PyrethrumInspection;
import co.ke.bsl.data.model.SugarMillLicence;
import co.ke.bsl.data.model.SugarRetailPricesSurvey;
import co.ke.bsl.data.model.SugarWholesalePricesSurvey;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.model.TeaWarehouseManInspection;
import co.ke.bsl.data.model.User;

@androidx.room.Database(entities = {User.class, ClientInfo.class, CaneCensus.class, SugarWholesalePricesSurvey.class, SugarRetailPricesSurvey.class, SugarMillLicence.class,
        PyrethrumInspection.class, TeaPacker.class, TeaWarehouseManInspection.class, HCDNurseryInspection.class, HorticultureProduceTransportation.class, HCDParkhouseWarehouse.class,
        HorticultureCropExportLicenceFarmInspection.class, HCDFlowersConsolidators.class, FruitVegetableConsolidators.class, HorticulturalFlowerExportersDeskVetting.class,
        FruitsVegetablesExportersDeskVetting.class, HCDAvocadoQualityInspection.class, HCDMangoQualityInspection.class, HCDColdRoomTemperatures.class, HCDPersonalHygene.class,
        HCDHorticulturalCropsColdStorage.class, CoffeeNurseryCert.class, PulpingStationLicenseApplication.class, CoffeePulpingStationPSL.class, CoffeeMillerLicenceApplication.class,
        CoffeeManagementAgent.class, CoffeeGrowerMarketingAgent.class, CoffeeCommercialMarketingAgent.class, CoffeeExporterDealerInspection.class, NOCDMarketPriceSurvey.class,
        FCDCottonBuyingStoreInspection.class, FCDSisalFactoryInspection.class, FCDCottonGinneryInspection.class,
        FCDCottonLintClassingReport.class, FCDSisalSpinningFactoryInspection.class, FoodCrop.class, FoodProcessing.class, FoodWarehouse.class}, version = 1, exportSchema = false)

@TypeConverters(DateConverter.class)
public abstract class Database extends RoomDatabase {

    private static Database INSTANCE;

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), Database.class, "afa_db")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public abstract UserDao userDao();

    public abstract ClientDao clientDao();

    public abstract CaneCensusDao caneCensusDao();

    public abstract WholesalePricesSurveyDao wholesalePricesSurveyDao();

    public abstract RetailsPricesSurveyDao retailsPricesSurveyDao();

    public abstract SugarMillLicenceDao sugarMillLicenceDao();

    public abstract PyrethrumInspectionDao pyrethrumInspectionDao();

    public abstract TeaPackerDao teaPackerDao();

    public abstract TeaWarehouseManDao teaWarehouseManDao();

    public abstract HorticultureNurseryInspectionDao horticultureNurseryInspectionDao();

    public abstract HorticulturalProduceTransportationDao horticulturalProduceTransportationDao();

    public abstract HorticulturalPackhouseWarehouseDao horticulturalPackhouseWarehouseDao();

    public abstract HorticultureCropExportLicenceDao horticultureCropExportLicenceDao();

    public abstract HorticulturalFlowerConsolidatorsDao horticulturalFlowerConsolidatorsDao();

    public abstract FruitsAndVegetablesConsolidatorsDao fruitsAndVegetablesConsolidatorsDao();

    public abstract HorticulturalFlowerExportersDeskVettingDao horticulturalFlowerExportersDeskVettingDao();

    public abstract FruitsAndVegetablesExportersDeskVettingDao fruitsAndVegetablesExportersDeskVettingDao();

    public abstract AvocadoQualityInspectionDao avocadoQualityInspectionDao();

    public abstract MangoQualityInspectionDao mangoQualityInspectionDao();

    public abstract ColdRoomTemperatureDao coldRoomTemperatureDao();

    public abstract PersonalHygieneDao personalHygieneDao();

    public abstract HorticulturalCropsColdStorageDao horticulturalCropsColdStorageDao();

    public abstract CoffeeNurseryCertificateInspectionDao coffeeNurseryCertificateInspectionDao();

    public abstract CoffeePulpingStationATEDao coffeePulpingStationATEDao();

    public abstract CoffeePulpingStationPSLDao coffeePulpingStationPSLDao();

    public abstract CoffeeMillerLicenceDao coffeeMillerLicenceDao();

    public abstract CoffeeManagementAgentDao coffeeManagementAgentDao();

    public abstract CoffeeGrowerMarketingAgentDao coffeeGrowerMarketingAgentDao();

    public abstract CoffeeCommercialMarketingAgentDao coffeeCommercialMarketingAgentDao();

    public abstract CoffeeExporterDealerInspectionDao coffeeExporterDealerInspectionDao();

    public abstract NutsAndOilsSurveyDao nutsAndOilsSurveyDao();

    public abstract CottonBuyingStoreInspectionDao cottonBuyingStoreInspectionDao();

    public abstract SisalFactoryInspectionDao sisalFactoryInspectionDao();

    public abstract CottonGinneryInspectionDao cottonGinneryInspectionDao();

    public abstract CottonLintClassingReportDao cottonLintClassingReportDao();

    public abstract SisalSpinninginspectionDao sisalSpinninginspectionDao();

    public abstract FoodProcessingDao foodProcessingDao();

    public abstract FoodWareHouseDao foodWareHouseDao();

    public abstract FoodCropExportDao foodCropExportDao();


}


