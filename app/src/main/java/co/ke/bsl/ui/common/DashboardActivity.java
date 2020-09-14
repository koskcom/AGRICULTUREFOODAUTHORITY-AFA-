package co.ke.bsl.ui.common;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.google.android.material.appbar.AppBarLayout;
import com.mikepenz.crossfadedrawerlayout.view.CrossfadeDrawerLayout;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.MiniDrawer;
import com.mikepenz.materialdrawer.interfaces.ICrossfader;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikepenz.materialize.util.UIUtils;
import com.tingyik90.snackprogressbar.SnackProgressBar;
import com.tingyik90.snackprogressbar.SnackProgressBarManager;

import org.idempiere.webservice.client.base.DataRow;
import org.idempiere.webservice.client.base.Enums;
import org.idempiere.webservice.client.base.Field;
import org.idempiere.webservice.client.base.LoginRequest;
import org.idempiere.webservice.client.net.WebServiceConnection;
import org.idempiere.webservice.client.request.QueryDataRequest;
import org.idempiere.webservice.client.response.WindowTabDataResponse;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import co.ke.bsl.AFA;
import co.ke.bsl.R;
import co.ke.bsl.adapter.AFADatabaseAdapter;
import co.ke.bsl.data.model.ClientInfo;
import co.ke.bsl.data.retrofit.ClientResponse;
import co.ke.bsl.data.view.ClientStatus;
import co.ke.bsl.data.view.Total;
import co.ke.bsl.network.APIClient;
import co.ke.bsl.network.RecordsInterface;
import co.ke.bsl.pojo.ADUser;
import co.ke.bsl.pojo.AvocadoQualityInspection;
import co.ke.bsl.pojo.CoffeeCommercialAgent;
import co.ke.bsl.pojo.CoffeeExporterDealerInspectionDetails;
import co.ke.bsl.pojo.CoffeeGrowerMarketingAgentDetails;
import co.ke.bsl.pojo.CoffeeManagementAgentInsp;
import co.ke.bsl.pojo.CoffeeMillerLicenceApplicationDetails;
import co.ke.bsl.pojo.CoffeeNursercertInsp;
import co.ke.bsl.pojo.CoffeePulpinglicenceApllPSL;
import co.ke.bsl.pojo.CottonBuyingStoreInspection;
import co.ke.bsl.pojo.CottonGinneryInspection;
import co.ke.bsl.pojo.CottonLintClassingReport;
import co.ke.bsl.pojo.FOodCropInspection;
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
import co.ke.bsl.pojo.PulpingStationLicenseApplicationDetails;
import co.ke.bsl.pojo.PyrethrumInspectionChecklist;
import co.ke.bsl.pojo.SisalFactoryInspection;
import co.ke.bsl.pojo.SisalSpinningFactoryInspection;
import co.ke.bsl.pojo.SugarMillDetails;
import co.ke.bsl.pojo.TeaPackerChecklist;
import co.ke.bsl.pojo.TeaWarehouseManInspectionDataCollection;
import co.ke.bsl.ui.activities.AboutUs;
import co.ke.bsl.ui.activities.LoginActivity;
import co.ke.bsl.ui.viewmodels.RecordViewModel;
import co.ke.bsl.ui.views.ProfileDialog;
import co.ke.bsl.ui.views.activities.AvocadoQualityInspectionList;
import co.ke.bsl.ui.views.activities.CaneCensusListActivity;
import co.ke.bsl.ui.views.activities.CoffeeCommercialMarketingAgentList;
import co.ke.bsl.ui.views.activities.CoffeeExporterDealerInspectionList;
import co.ke.bsl.ui.views.activities.CoffeeGrowerMarketingAgentList;
import co.ke.bsl.ui.views.activities.CoffeeManagementAgentList;
import co.ke.bsl.ui.views.activities.CoffeeMillerLicenceList;
import co.ke.bsl.ui.views.activities.CoffeeNurseryCertificateList;
import co.ke.bsl.ui.views.activities.CoffeePulpingStationATEList;
import co.ke.bsl.ui.views.activities.CoffeePulpingStationPSLList;
import co.ke.bsl.ui.views.activities.ColdRoomTemperatureList;
import co.ke.bsl.ui.views.activities.CottonBuyingStoreInspectionList;
import co.ke.bsl.ui.views.activities.CottonGinneryInspectionList;
import co.ke.bsl.ui.views.activities.CottonLintClassingReportList;
import co.ke.bsl.ui.views.activities.FoodCropRecylerListActivity;
import co.ke.bsl.ui.views.activities.FoodProcessingInspectionList;
import co.ke.bsl.ui.views.activities.FoodWareHouseActivityList;
import co.ke.bsl.ui.views.activities.FruitsAndVegetablesConsolidatorsList;
import co.ke.bsl.ui.views.activities.FruitsAndVegetablesExportersList;
import co.ke.bsl.ui.views.activities.HorticulturalCropsColdStorageList;
import co.ke.bsl.ui.views.activities.HorticulturalCropsExportLicenceList;
import co.ke.bsl.ui.views.activities.HorticulturalFlowerConsolidatorsList;
import co.ke.bsl.ui.views.activities.HorticulturalFlowerExportersList;
import co.ke.bsl.ui.views.activities.HorticulturalPackhouseWarehouseList;
import co.ke.bsl.ui.views.activities.HorticulturalProduceTransportationList;
import co.ke.bsl.ui.views.activities.HorticultureNurseryInspectionList;
import co.ke.bsl.ui.views.activities.MangoQualityInspectionList;
import co.ke.bsl.ui.views.activities.NutsAndOilsSurveyList;
import co.ke.bsl.ui.views.activities.PersonalHygieneList;
import co.ke.bsl.ui.views.activities.PyrethrumInspectionListActivity;
import co.ke.bsl.ui.views.activities.RetailPricesSurveyListActivity;
import co.ke.bsl.ui.views.activities.SisalFactoryInspectionList;
import co.ke.bsl.ui.views.activities.SisalSpinningInsList;
import co.ke.bsl.ui.views.activities.SugarMillLicenceComplianceListActivity;
import co.ke.bsl.ui.views.activities.TeaPackerList;
import co.ke.bsl.ui.views.activities.TeaWarehouseManList;
import co.ke.bsl.ui.views.activities.WholesalePricesSurveyListActivity;
import co.ke.bsl.ui.views.activities.components.CoffeeCommercialMarketingAgentActivity;
import co.ke.bsl.ui.views.activities.components.CoffeeExporterDealerInspectionActivity;
import co.ke.bsl.ui.views.activities.components.CoffeeGrowerMarketingAgentActivity;
import co.ke.bsl.ui.views.activities.components.CoffeeManagementAgentActivity;
import co.ke.bsl.ui.views.activities.components.CoffeeMillerLicenceApplicationActivity;
import co.ke.bsl.ui.views.activities.components.CoffeeNurseryCertificateActivity;
import co.ke.bsl.ui.views.activities.components.CoffeePulpingStationPSLActivity;
import co.ke.bsl.ui.views.activities.components.CreateCaneCensusActivity;
import co.ke.bsl.ui.views.activities.components.FCDCottonBuyingStoreInspectionActivity;
import co.ke.bsl.ui.views.activities.components.FCDCottonGinneryInspectionActivity;
import co.ke.bsl.ui.views.activities.components.FCDCottonLintClassingReportActivity;
import co.ke.bsl.ui.views.activities.components.FCDSisalFactoryInspectionConformityAssessmentActivity;
import co.ke.bsl.ui.views.activities.components.FCDSisalSpinningFactoryInspectionConformityAssessmentActivity;
import co.ke.bsl.ui.views.activities.components.FoodCropExportActivity;
import co.ke.bsl.ui.views.activities.components.FoodProcessingInspectionActivity;
import co.ke.bsl.ui.views.activities.components.FoodWareHouseActivity;
import co.ke.bsl.ui.views.activities.components.FruitVegetableConsolidatorsDeskvettingChecklistActivity;
import co.ke.bsl.ui.views.activities.components.FruitsVegetablesExportersDeskVettingChecklistActivity;
import co.ke.bsl.ui.views.activities.components.HCDAvocadoQualityInspectionChecklistActivity;
import co.ke.bsl.ui.views.activities.components.HCDColdRoomTemperaturesRecordsActivity;
import co.ke.bsl.ui.views.activities.components.HCDFlowersConsolidatorsActivity;
import co.ke.bsl.ui.views.activities.components.HCDHorticulturalCropsColdStorageActivity;
import co.ke.bsl.ui.views.activities.components.HCDMangoQualityInspectionChecklistActivity;
import co.ke.bsl.ui.views.activities.components.HCDNurseryInspectionActivity;
import co.ke.bsl.ui.views.activities.components.HCDParkhouseWarehouseActivity;
import co.ke.bsl.ui.views.activities.components.HorticultureFlowerExporterDeskVettingActivity;
import co.ke.bsl.ui.views.activities.components.HorticultureLicenceFarmInspectionActivity;
import co.ke.bsl.ui.views.activities.components.HorticultureProduceTransportationActivity;
import co.ke.bsl.ui.views.activities.components.NOCDMarketPriceSurveyActivity;
import co.ke.bsl.ui.views.activities.components.PersonalHygieneInspectionActivity;
import co.ke.bsl.ui.views.activities.components.PulpingStationLicenseApplicationActivity;
import co.ke.bsl.ui.views.activities.components.PyrethrumInspectionActivity;
import co.ke.bsl.ui.views.activities.components.RetailActivity;
import co.ke.bsl.ui.views.activities.components.SugarMillLicenceComplianceActivity;
import co.ke.bsl.ui.views.activities.components.TeaPackerAcivity;
import co.ke.bsl.ui.views.activities.components.TeaWarehouseManInspectionChecklistActivity;
import co.ke.bsl.ui.views.activities.components.WholesaleActivity;
import co.ke.bsl.worker.DataPostWorker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarMain)
    AppBarLayout appBarMain;
    @BindView(R.id.cardViewAddCaneCensus)
    CardView cardViewAddCaneCensus;
    @BindView(R.id.cardViewAddSugarRetailSugarPricesSurvey)
    CardView cardViewAddSugarRetailSugarPricesSurvey;
    @BindView(R.id.cardViewAddWholesaleSugarPricesSurvey)
    CardView cardViewAddWholesaleSugarPricesSurvey;
    @BindView(R.id.cardViewAddSugarMillLicence)
    CardView cardViewAddSugarMillLicence;
    @BindView(R.id.cardViewAddpyrethrumInspection)
    CardView cardViewAddpyrethrumInspection;
    @BindView(R.id.cardViewTeaWareHouseMan)
    CardView cardViewTeaWareHouseMan;
    @BindView(R.id.cardViewAddPulpingStationLicenceApplication)
    CardView cardViewPulpingStation;
    @BindView(R.id.cardViewAddTeaPacker)
    CardView cardViewAddTeaPacker;
    @BindView(R.id.cardViewCoffeeNurseryCertificate)
    CardView cardViewCoffeeNurseryCertificate;
    @BindView(R.id.cardViewCoffeeMillerLicenceApplication)
    CardView cardViewCoffeeMillerLicenceApplication;
    @BindView(R.id.cardViewAddCoffeePulpingLicApllPSL)
    CardView cardViewAddCoffeePulpingLicApllPSL;
    @BindView(R.id.cardViewCoffeeMnagementAgent)
    CardView cardViewCoffeeMnagementAgent;
    @BindView(R.id.cardViewCoffeeGrowerMarketingAgent)
    CardView cardViewCoffeeGrowerMarketingAgent;
    @BindView(R.id.cardViewCoffeeExporterDealerInspection)
    CardView cardViewCoffeeExporterDealerInspection;
    @BindView(R.id.cardViewHCDProduceTransportation)
    CardView cardViewHCDProduceTransportation;
    @BindView(R.id.cardViewHCDFlowerExporterDeskVetting)
    CardView cardViewHCDFlowerExporterDeskVetting;
    @BindView(R.id.cardViewHCDLicenceFarmInspection)
    CardView cardViewHCDLicenceFarmInspection;
    @BindView(R.id.cardViewHCDFlowerConsolidators)
    CardView cardViewHCDFlowerConsolidators;
    @BindView(R.id.cardViewNOCDMarketPriceSurvey)
    CardView cardViewNOCDMarketPriceSurvey;
    @BindView(R.id.cardViewHCDNurseryInspection)
    CardView cardViewHCDNurseryInspection;
    @BindView(R.id.cardViewHCDParkhouseWareHouseInspection)
    CardView cardViewHCDParkhouseWareHouseInspection;
    @BindView(R.id.cardViewCoffeeCommercialMarketingAgent)
    CardView cardViewCoffeeCommercialMarketingAgent;
    @BindView(R.id.cardViewFruitsVegetablesExportsDeskVettingChecklist)
    CardView cardViewFruitsVegetablesExportsDeskVettingChecklist;
    @BindView(R.id.cardViewHCDFruitsVegetablesConsolidatosDeskvetting)
    CardView cardViewHCDFruitsVegetablesConsolidatosDeskvetting;
    @BindView(R.id.cardViewAvocadoQualityInspectionChecklist)
    CardView cardViewAvocadoQualityInspectionChecklist;
    @BindView(R.id.cardViewHCDMangoQualityInspectionChecklistActivity)
    CardView cardViewHCDMangoQualityInspectionChecklistActivity;
    @BindView(R.id.cardViewHorticulturalCropsColdStorageRegister)
    CardView cardViewHorticulturalCropsColdStorageRegister;
    @BindView(R.id.cardViewHCDColdRoomTemperaturesRecordsActivity)
    CardView cardViewHCDColdRoomTemperaturesRecordsActivity;
    @BindView(R.id.cardViewHCDPersonalHygieneInspection)
    CardView cardViewHCDPersonalHygieneInspection;
    @BindView(R.id.cardViewCottonBuyingInspection)
    CardView cardViewCottonBuyingInspection;
    @BindView(R.id.cardViewSisalfactoryInspection)
    CardView cardViewSisalfactoryInspection;
    @BindView(R.id.cardViewSisalSpinningFactoryInspection)
    CardView cardViewSisalSpinningFactoryInspection;
    @BindView(R.id.cardViewCottonGinneryInspection)
    CardView cardViewCottonGinneryInspection;
    @BindView(R.id.cardViewCottonLintClassingReport)
    CardView cardViewCottonLintClassingReport;
    @BindView(R.id.cardViewFoodProcessing)
    CardView cardViewFoodProcessing;
    @BindView(R.id.cardViewFoodWarehouseInspection)
    CardView cardViewFoodWarehouseInspection;
    @BindView(R.id.cardViewFoodCrop)
    CardView cardViewFoodCrop;

    @BindView(R.id.logoutButton)
    Button logoutButton;
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;
    ProfileDialog profileDialog;

    static LoginRequest login;

    private SnackProgressBarManager snackProgressBarManager;
    private AFA app;
    private String imagePath;

    private RecordViewModel recordViewModel;
    private Total total;

    private RecordsInterface recordsInterface;
    private Drawer result;
    private CrossfadeDrawerLayout crossfadeDrawerLayout = null;
    private String name, email, photo, mobile;
    private AFADatabaseAdapter db;
    private String c_activity_id;

    static String uri;

    private static final String CHANNEL_ID = "1000000";

    private static final int INT_SUGAR_DIRECTORATE = 0;
    private static final int INT_TEA_DIRECTORATE = 1;
    private static final int INT_HORTICULTURE_DIRECTORATE = 2;
    private static final int INT_COFFEE_DIRECTORATE = 3;
    private static final int INT_NUTS_AND_OILS_DIRECTORATE = 4;
    private static final int INT_PYRETHRUM_DIRECTORATE = 5;
    private static final int INT_FIBRE_DIRECTORATE = 6;
    private static final int INT_NO_DIRECTORATE = 7;
    private static final int INT_FOOD_DIRECTORATE = 8;

    Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        //retrieve user settings
        db = new AFADatabaseAdapter(getApplicationContext());

        //Navigation Drawer with toolbar
        //Moved to onResume()
//        inflateNavDrawer();

        app = (AFA) getApplication();

       /* recordViewModel = ViewModelProviders.of(this).get(RecordViewModel.class);
        total = recordViewModel.countRegisteredClients();
        total = recordViewModel.countSugarRetailPricesSurvey();
        recordViewModel.getUnsyncedData(false).observe(this, this::syncData);*/

        uri = getResources().getString(R.string.baseURI);

        hideKeyboard();

        //Moved to onResume()
//        refreshCouponOneTimeWork();
//        getUserValues();

        imagePath = "/afa/Images";

        recordsInterface = APIClient.getClient(app.settings.getBearerToken()).create(RecordsInterface.class);

        createDirectory();
//        createNotificationChannel();

        profileDialog = ProfileDialog.newInstance(((dialog, which) -> logout()));

        //Initialize Snackbar Manager -> Attach/pin to the bottom of the layout :)
        snackProgressBarManager = new SnackProgressBarManager(coordinatorLayout)
                .setProgressBarColor(R.color.colorAccent)
                .setOverlayLayoutAlpha(0.6f);


        logoutButton.setOnClickListener(v -> profileDialog.show(getSupportFragmentManager(), "profile"));

        cardViewAddCaneCensus.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CreateCaneCensusActivity.class);
            startActivity(intent);
        });


        cardViewAddSugarRetailSugarPricesSurvey.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RetailActivity.class);
            startActivity(intent);

            // Toast.makeText(this, "Retail Survey", Toast.LENGTH_SHORT).show();
        });


        cardViewAddWholesaleSugarPricesSurvey.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), WholesaleActivity.class);
            startActivity(intent);

            //Toast.makeText(this, "Wholesale Survey", Toast.LENGTH_SHORT).show();
        });

        cardViewAddSugarMillLicence.setOnClickListener(v -> {
            /*Intent intent = new Intent(getApplicationContext(), SugarMillLicenceComplianceActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewAddSugarMillLicence");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewAddpyrethrumInspection.setOnClickListener(v -> {
            /*Intent intent = new Intent(getApplicationContext(), PyrethrumInspectionActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewAddpyrethrumInspection");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewAddTeaPacker.setOnClickListener(v -> {
            /*Intent intent = new Intent(getApplicationContext(), TeaPackerAcivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewAddTeaPacker");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewTeaWareHouseMan.setOnClickListener(v -> {
            /*Intent intent = new Intent(getApplicationContext(), TeaWarehouseManInspectionChecklistActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewTeaWareHouseMan");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });


        cardViewCoffeeNurseryCertificate.setOnClickListener(v -> {
            /*Intent intent = new Intent(getApplicationContext(), CoffeeNurseryCertificateActivity.class);
            startActivity(intent);*/
            new FetchStats().execute("cardViewCoffeeNurseryCertificate");
        });

        cardViewPulpingStation.setOnClickListener(v -> {
            /*Intent intent = new Intent(getApplicationContext(), PulpingStationLicenseApplicationActivity.class);
            startActivity(intent);*/
            new FetchStats().execute("cardViewPulpingStation");
        });

        cardViewCoffeeMillerLicenceApplication.setOnClickListener(v -> {
/*            Intent intent = new Intent(getApplicationContext(), CoffeeMillerLicenceApplicationActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewCoffeeMillerLicenceApplication");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewAddCoffeePulpingLicApllPSL.setOnClickListener(v -> {
          /*  Intent intent = new Intent(getApplicationContext(), CoffeePulpingStationPSLActivity.class);
            startActivity(intent);*/


            new FetchStats().execute("cardViewAddCoffeePulpingLicApllPSL");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewCoffeeMnagementAgent.setOnClickListener(v -> {
            /*Intent intent = new Intent(getApplicationContext(), CoffeeManagementAgentActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewCoffeeMnagementAgent");
//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewCoffeeGrowerMarketingAgent.setOnClickListener(v -> {
           /* Intent intent = new Intent(getApplicationContext(), CoffeeGrowerMarketingAgentActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewCoffeeGrowerMarketingAgent");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewCoffeeExporterDealerInspection.setOnClickListener(v -> {
/*            Intent intent = new Intent(getApplicationContext(), CoffeeExporterDealerInspectionActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewCoffeeExporterDealerInspection");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewHCDFlowerConsolidators.setOnClickListener(v -> {
/*            Intent intent = new Intent(getApplicationContext(), HCDFlowersConsolidatorsActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewHCDFlowerConsolidators");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewHCDNurseryInspection.setOnClickListener(v -> {
/*            Intent intent = new Intent(getApplicationContext(), HCDNurseryInspectionActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewHCDNurseryInspection");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewHCDParkhouseWareHouseInspection.setOnClickListener(v -> {
/*            Intent intent = new Intent(getApplicationContext(), HCDParkhouseWarehouseActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewHCDParkhouseWareHouseInspection");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewCoffeeCommercialMarketingAgent.setOnClickListener(v -> {
           /* Intent intent = new Intent(getApplicationContext(), CoffeeCommercialMarketingAgentActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewCoffeeCommercialMarketingAgent");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewNOCDMarketPriceSurvey.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), NOCDMarketPriceSurveyActivity.class);
            startActivity(intent);

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewHCDProduceTransportation.setOnClickListener(v -> {
           /* Intent intent = new Intent(getApplicationContext(), HorticultureProduceTransportationActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewHCDProduceTransportation");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewFruitsVegetablesExportsDeskVettingChecklist.setOnClickListener(v -> {
            /*Intent intent = new Intent(getApplicationContext(), FruitsVegetablesExportersDeskVettingChecklistActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewFruitsVegetablesExportsDeskVettingChecklist");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewHCDFruitsVegetablesConsolidatosDeskvetting.setOnClickListener(v -> {
           /* Intent intent = new Intent(getApplicationContext(), FruitVegetableConsolidatorsDeskvettingChecklistActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewHCDFruitsVegetablesConsolidatosDeskvetting");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewAvocadoQualityInspectionChecklist.setOnClickListener(v -> {
            /*Intent intent = new Intent(getApplicationContext(), HCDAvocadoQualityInspectionChecklistActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewAvocadoQualityInspectionChecklist");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });
        cardViewHCDMangoQualityInspectionChecklistActivity.setOnClickListener(v -> {
           /* Intent intent = new Intent(getApplicationContext(), HCDMangoQualityInspectionChecklistActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewHCDMangoQualityInspectionChecklistActivity");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });
        cardViewHorticulturalCropsColdStorageRegister.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), HCDHorticulturalCropsColdStorageActivity.class);
            startActivity(intent);

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewHCDColdRoomTemperaturesRecordsActivity.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), HCDColdRoomTemperaturesRecordsActivity.class);
            startActivity(intent);

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewHCDPersonalHygieneInspection.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), PersonalHygieneInspectionActivity.class);
            startActivity(intent);

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewHCDFlowerExporterDeskVetting.setOnClickListener(v -> {
           /* Intent intent = new Intent(getApplicationContext(), HorticultureFlowerExporterDeskVettingActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewHCDFlowerExporterDeskVetting");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });
        cardViewCottonBuyingInspection.setOnClickListener(v -> {
            /*Intent intent = new Intent(getApplicationContext(), FCDCottonBuyingStoreInspectionActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewCottonBuyingInspection");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewHCDLicenceFarmInspection.setOnClickListener(v -> {
            /*Intent intent = new Intent(getApplicationContext(), HorticultureLicenceFarmInspectionActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewHCDLicenceFarmInspection");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewSisalfactoryInspection.setOnClickListener(v -> {
/*            Intent intent = new Intent(getApplicationContext(), FCDSisalFactoryInspectionConformityAssessmentActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewSisalfactoryInspection");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewCottonLintClassingReport.setOnClickListener(v -> {

            new FetchStats().execute("cardViewCottonLintClassingReport");

        });


        cardViewSisalSpinningFactoryInspection.setOnClickListener(v -> {
        /* Intent intent = new Intent(getApplicationContext(), FCDSisalSpinningFactoryInspectionConformityAssessmentActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewSisalSpinningFactoryInspection");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });
        cardViewFoodProcessing.setOnClickListener(v -> {
        /* Intent intent = new Intent(getApplicationContext(), FCDSisalSpinningFactoryInspectionConformityAssessmentActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewFoodProcessing");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });
        cardViewFoodWarehouseInspection.setOnClickListener(v -> {
        /* Intent intent = new Intent(getApplicationContext(), FCDSisalSpinningFactoryInspectionConformityAssessmentActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewFoodWarehouseInspection");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });
        cardViewFoodCrop.setOnClickListener(v -> {
        /* Intent intent = new Intent(getApplicationContext(), FCDSisalSpinningFactoryInspectionConformityAssessmentActivity.class);
            startActivity(intent);*/

            new FetchStats().execute("cardViewFoodCrop");

//            Toast.makeText(this, "Under Construction", Toast.LENGTH_SHORT).show();
        });

        cardViewCottonGinneryInspection.setOnClickListener(v -> {

            new FetchStats().execute("cardViewCottonGinneryInspection");
        });
    }

    @Override
    protected void onResume() {

        //Work done by DataSetupWorker
//        refreshCouponPeriodicWork();

        //Work done by DataPostWorker
        refreshCouponOneTimeWork();

//        inflateNavDrawer();

        ADUser adUser = db.getADUser();

        if (null != adUser && null != adUser.getC_activity_id()) {
            c_activity_id = adUser.getC_activity_id();
            if (c_activity_id.equals("1000001")) {
                inflateNavDrawer(INT_SUGAR_DIRECTORATE);
                setVisibility(INT_SUGAR_DIRECTORATE);
            } else if (c_activity_id.equals("1000002")) {
                inflateNavDrawer(INT_TEA_DIRECTORATE);
                setVisibility(INT_TEA_DIRECTORATE);
            } else if (c_activity_id.equals("1000004")) {
                inflateNavDrawer(INT_COFFEE_DIRECTORATE);
                setVisibility(INT_COFFEE_DIRECTORATE);
            } else if (c_activity_id.equals("1000007")) {
                inflateNavDrawer(INT_HORTICULTURE_DIRECTORATE);
                setVisibility(INT_HORTICULTURE_DIRECTORATE);
            } else if (c_activity_id.equals("1000003")) {
                inflateNavDrawer(INT_NUTS_AND_OILS_DIRECTORATE);
                setVisibility(INT_NUTS_AND_OILS_DIRECTORATE);
            } else if (c_activity_id.equals("1000010")) {
                inflateNavDrawer(INT_PYRETHRUM_DIRECTORATE);
                setVisibility(INT_PYRETHRUM_DIRECTORATE);
            } else if (c_activity_id.equals("1000011")) {
                inflateNavDrawer(INT_FIBRE_DIRECTORATE);
                setVisibility(INT_FIBRE_DIRECTORATE);
            } else if (c_activity_id.equals("1000006")) {
                inflateNavDrawer(INT_FOOD_DIRECTORATE);
                setVisibility(INT_FOOD_DIRECTORATE);
            } else {
                inflateNavDrawer(INT_NO_DIRECTORATE);
                setVisibility(INT_NO_DIRECTORATE);
            }
            System.out.println("c_activity_id found");
        } else {
            setVisibility(INT_NO_DIRECTORATE);

        }

        getUserValues();

        super.onResume();
    }

    public static void refreshCouponOneTimeWork() {
        //define constraints
        Constraints myConstraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
        //creating a data object
        //to pass the data with workrequest
        //we can put as many variables as we can
        Data source = new Data.Builder()
                .putString("workType", "DataPostWorker - OneTime")
                .build();

      final  OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(DataPostWorker.class)
                .setConstraints(myConstraints)
                .setInputData(source)
                //.setInitialDelay(1, TimeUnit.MILLISECONDS)
               // .setBackoffCriteria(BackoffPolicy.LINEAR, 0, TimeUnit.MILLISECONDS)
                .build();
       WorkManager.getInstance().enqueue(oneTimeWorkRequest);
      // WorkManager.getInstance().enqueueUniqueWork("DataPost",ExistingWorkPolicy.KEEP ,oneTimeWorkRequest);
        WorkManager.getInstance().beginUniqueWork("", ExistingWorkPolicy.APPEND, oneTimeWorkRequest).enqueue();

    }

    private void getUserValues() {
        ADUser adUser = app.getAdUser();

        if (null != adUser) {
            name = adUser.getAd_user_name();
            email = adUser.getAd_user_email();
            mobile = "0722000000";
            photo = "https://i.postimg.cc/fbyWb2KS/userimage.jpg";
        }

    }

    public void setVisibility(int directorate) {

        int sugarVisibility, teaVisibility, horticultureVisibility, nutsandOilssugarVisibility, pyrethrumVisibility, fibreVisibility, foodVisibility, coffeeVisibility;

        if (directorate == INT_SUGAR_DIRECTORATE) {
            sugarVisibility = View.VISIBLE;
            teaVisibility = View.GONE;
            horticultureVisibility = View.GONE;
            nutsandOilssugarVisibility = View.GONE;
            pyrethrumVisibility = View.GONE;
            fibreVisibility = View.GONE;
            coffeeVisibility = View.GONE;
            foodVisibility = View.GONE;
        } else if (directorate == INT_TEA_DIRECTORATE) {
            sugarVisibility = View.GONE;
            teaVisibility = View.VISIBLE;
            horticultureVisibility = View.GONE;
            nutsandOilssugarVisibility = View.GONE;
            pyrethrumVisibility = View.GONE;
            fibreVisibility = View.GONE;
            coffeeVisibility = View.GONE;
            foodVisibility = View.GONE;
        } else if (directorate == INT_HORTICULTURE_DIRECTORATE) {
            sugarVisibility = View.GONE;
            teaVisibility = View.GONE;
            horticultureVisibility = View.VISIBLE;
            nutsandOilssugarVisibility = View.GONE;
            pyrethrumVisibility = View.GONE;
            fibreVisibility = View.GONE;
            coffeeVisibility = View.GONE;
            foodVisibility = View.GONE;
        } else if (directorate == INT_COFFEE_DIRECTORATE) {
            sugarVisibility = View.GONE;
            teaVisibility = View.GONE;
            horticultureVisibility = View.GONE;
            nutsandOilssugarVisibility = View.GONE;
            pyrethrumVisibility = View.GONE;
            fibreVisibility = View.GONE;
            foodVisibility = View.GONE;
            coffeeVisibility = View.VISIBLE;
        } else if (directorate == INT_NUTS_AND_OILS_DIRECTORATE) {
            sugarVisibility = View.GONE;
            teaVisibility = View.GONE;
            horticultureVisibility = View.GONE;
            nutsandOilssugarVisibility = View.VISIBLE;
            pyrethrumVisibility = View.GONE;
            fibreVisibility = View.GONE;
            coffeeVisibility = View.GONE;
            foodVisibility = View.GONE;
        } else if (directorate == INT_PYRETHRUM_DIRECTORATE) {
            sugarVisibility = View.GONE;
            teaVisibility = View.GONE;
            horticultureVisibility = View.GONE;
            nutsandOilssugarVisibility = View.GONE;
            pyrethrumVisibility = View.VISIBLE;
            fibreVisibility = View.GONE;
            coffeeVisibility = View.GONE;
            foodVisibility = View.GONE;
        } else if (directorate == INT_FIBRE_DIRECTORATE) {
            sugarVisibility = View.GONE;
            teaVisibility = View.GONE;
            horticultureVisibility = View.GONE;
            nutsandOilssugarVisibility = View.GONE;
            pyrethrumVisibility = View.GONE;
            fibreVisibility = View.VISIBLE;
            coffeeVisibility = View.GONE;
            foodVisibility = View.GONE;
        } else if (directorate == INT_FOOD_DIRECTORATE) {
            sugarVisibility = View.GONE;
            teaVisibility = View.GONE;
            horticultureVisibility = View.GONE;
            nutsandOilssugarVisibility = View.GONE;
            pyrethrumVisibility = View.GONE;
            fibreVisibility = View.GONE;
            coffeeVisibility = View.GONE;
            foodVisibility = View.VISIBLE;
        } else {
            sugarVisibility = View.GONE;
            teaVisibility = View.GONE;
            horticultureVisibility = View.GONE;
            nutsandOilssugarVisibility = View.GONE;
            pyrethrumVisibility = View.GONE;
            fibreVisibility = View.GONE;
            coffeeVisibility = View.GONE;
            foodVisibility = View.GONE;
        }


        cardViewAddCaneCensus.setVisibility(sugarVisibility);
        cardViewAddSugarRetailSugarPricesSurvey.setVisibility(sugarVisibility);
        cardViewAddWholesaleSugarPricesSurvey.setVisibility(sugarVisibility);
        cardViewAddSugarMillLicence.setVisibility(sugarVisibility);

        cardViewAddpyrethrumInspection.setVisibility(pyrethrumVisibility);

        cardViewAddTeaPacker.setVisibility(teaVisibility);
        cardViewTeaWareHouseMan.setVisibility(teaVisibility);

        cardViewCoffeeNurseryCertificate.setVisibility(coffeeVisibility);
        cardViewPulpingStation.setVisibility(coffeeVisibility);
        cardViewCoffeeMillerLicenceApplication.setVisibility(coffeeVisibility);
        cardViewAddCoffeePulpingLicApllPSL.setVisibility(coffeeVisibility);
        cardViewCoffeeMnagementAgent.setVisibility(coffeeVisibility);
        cardViewCoffeeGrowerMarketingAgent.setVisibility(coffeeVisibility);
        cardViewCoffeeExporterDealerInspection.setVisibility(coffeeVisibility);
        cardViewCoffeeCommercialMarketingAgent.setVisibility(coffeeVisibility);

        cardViewHCDFlowerConsolidators.setVisibility(horticultureVisibility);
        cardViewHCDNurseryInspection.setVisibility(horticultureVisibility);
        cardViewHCDParkhouseWareHouseInspection.setVisibility(horticultureVisibility);
        cardViewHCDProduceTransportation.setVisibility(horticultureVisibility);
        cardViewFruitsVegetablesExportsDeskVettingChecklist.setVisibility(horticultureVisibility);
        cardViewHCDFruitsVegetablesConsolidatosDeskvetting.setVisibility(horticultureVisibility);
        cardViewAvocadoQualityInspectionChecklist.setVisibility(horticultureVisibility);
        cardViewHCDMangoQualityInspectionChecklistActivity.setVisibility(horticultureVisibility);
        cardViewHorticulturalCropsColdStorageRegister.setVisibility(horticultureVisibility);
        cardViewHCDColdRoomTemperaturesRecordsActivity.setVisibility(horticultureVisibility);
        cardViewHCDPersonalHygieneInspection.setVisibility(horticultureVisibility);
        cardViewHCDFlowerExporterDeskVetting.setVisibility(horticultureVisibility);
        cardViewHCDLicenceFarmInspection.setVisibility(horticultureVisibility);

        cardViewNOCDMarketPriceSurvey.setVisibility(nutsandOilssugarVisibility);

        cardViewCottonBuyingInspection.setVisibility(fibreVisibility);
        cardViewSisalfactoryInspection.setVisibility(fibreVisibility);
        cardViewSisalSpinningFactoryInspection.setVisibility(fibreVisibility);
        cardViewCottonGinneryInspection.setVisibility(fibreVisibility);
        cardViewCottonLintClassingReport.setVisibility(fibreVisibility);

        cardViewFoodProcessing.setVisibility(foodVisibility);
        cardViewFoodWarehouseInspection.setVisibility(foodVisibility);
        cardViewFoodCrop.setVisibility(foodVisibility);

    }

    private void inflateNavDrawer(int directorate) {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Typeface typeface = ResourcesCompat.getFont(this, R.font.sans_regular);

        //Profile Making
        IProfile profile = new ProfileDrawerItem()
                .withName(name)
                .withEmail(email)
                .withTypeface(typeface)
                .withIcon(R.drawable.logo_large);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.gradient_background)
                .addProfiles(profile)
                .withCompactStyle(true)
                .withTypeface(typeface)
                .withOnlyMainProfileImageVisible(true)
                .build();

        //Adding nav drawer items ------------------------------------------------------------------
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.home).withIcon(R.drawable.ic_home).withSelectable(false);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName(R.string.myprofile).withIcon(R.drawable.ic_avatar_dark).withSelectable(false);
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName(R.string.cane_census).withIcon(R.drawable.ic_tractor).withSelectable(false);
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName(R.string.retail_prices_survey).withIcon(R.drawable.ic_retail_bag).withSelectable(false);
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName(R.string.whole_sale_price_survey).withIcon(R.drawable.ic_bag_of_sugar).withSelectable(false);
        PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIdentifier(6).withName(R.string.sugar_mill_licence).withIcon(R.drawable.ic_wholesale_prices_survey).withSelectable(false);
        PrimaryDrawerItem item7 = new PrimaryDrawerItem().withIdentifier(7).withName(R.string.pyrethrum_inspection_list).withIcon(R.drawable.ic_pyrethrum).withSelectable(false);
        PrimaryDrawerItem item8 = new PrimaryDrawerItem().withIdentifier(8).withName(R.string.teapacker_list).withIcon(R.drawable.ic_green_tea).withSelectable(false);
        PrimaryDrawerItem item9 = new PrimaryDrawerItem().withIdentifier(9).withName(R.string.teawarehouseman_list).withIcon(R.drawable.ic_warehouse).withSelectable(false);
        PrimaryDrawerItem item10 = new PrimaryDrawerItem().withIdentifier(10).withName(R.string.horticulture_nursery_inspection_list).withIcon(R.drawable.ic_nursery_inspe).withSelectable(false);
        PrimaryDrawerItem item11 = new PrimaryDrawerItem().withIdentifier(11).withName(R.string.horticultural_produce_transportation_list).withIcon(R.drawable.ic_moving_truck).withSelectable(false);
        PrimaryDrawerItem item12 = new PrimaryDrawerItem().withIdentifier(12).withName(R.string.horticultural_packhouse_warehouse_list).withIcon(R.drawable.ic_warehouse).withSelectable(false);
        PrimaryDrawerItem item13 = new PrimaryDrawerItem().withIdentifier(13).withName(R.string.horticultural_crops_export_licence_list).withIcon(R.drawable.ic_travel).withSelectable(false);
        PrimaryDrawerItem item14 = new PrimaryDrawerItem().withIdentifier(14).withName(R.string.horticultural_flower_consolidators_list).withIcon(R.drawable.ic_flower_consolidators).withSelectable(false);
        PrimaryDrawerItem item15 = new PrimaryDrawerItem().withIdentifier(15).withName(R.string.fruits_and_vegetables_consolidators_list).withIcon(R.drawable.ic_fruits).withSelectable(false);
        PrimaryDrawerItem item16 = new PrimaryDrawerItem().withIdentifier(16).withName(R.string.horticultural_flower_exporters_list).withIcon(R.drawable.ic_workspace).withSelectable(false);
        PrimaryDrawerItem item17 = new PrimaryDrawerItem().withIdentifier(17).withName(R.string.fruits_and_vegetables_exporters_list).withIcon(R.drawable.ic_fruits_vegetables).withSelectable(false);
        PrimaryDrawerItem item18 = new PrimaryDrawerItem().withIdentifier(18).withName(R.string.avocado_quality_inspection_list).withIcon(R.drawable.ic_avocado).withSelectable(false);
        PrimaryDrawerItem item19 = new PrimaryDrawerItem().withIdentifier(19).withName(R.string.mango_quality_inspection_list).withIcon(R.drawable.ic_mango).withSelectable(false);
        PrimaryDrawerItem item20 = new PrimaryDrawerItem().withIdentifier(20).withName(R.string.cold_room_temperature_records_list).withIcon(R.drawable.ic_temperature).withSelectable(false);
        PrimaryDrawerItem item21 = new PrimaryDrawerItem().withIdentifier(21).withName(R.string.personal_hygiene_list).withIcon(R.drawable.ic_bathtub).withSelectable(false);
        PrimaryDrawerItem item22 = new PrimaryDrawerItem().withIdentifier(22).withName(R.string.horticultural_crops_cold_storage_list).withIcon(R.drawable.ic_planting).withSelectable(false);
        PrimaryDrawerItem item23 = new PrimaryDrawerItem().withIdentifier(23).withName(R.string.coffee_nursery_certificate_list).withIcon(R.drawable.ic_fields).withSelectable(false);
        PrimaryDrawerItem item24 = new PrimaryDrawerItem().withIdentifier(24).withName(R.string.pulping_station_licence_ate_list).withIcon(R.drawable.ic_statistical_form).withSelectable(false);
        PrimaryDrawerItem item25 = new PrimaryDrawerItem().withIdentifier(25).withName(R.string.pulping_station_licence_psl_list).withIcon(R.drawable.ic_leaf_).withSelectable(false);
        PrimaryDrawerItem item26 = new PrimaryDrawerItem().withIdentifier(26).withName(R.string.coffee_miller_licence_list).withIcon(R.drawable.ic_coffee).withSelectable(false);
        PrimaryDrawerItem item27 = new PrimaryDrawerItem().withIdentifier(27).withName(R.string.coffee_management_agent_list).withIcon(R.drawable.ic_marketing).withSelectable(false);
        PrimaryDrawerItem item28 = new PrimaryDrawerItem().withIdentifier(28).withName(R.string.coffee_grower_marketing_agent_list).withIcon(R.drawable.ic_growth).withSelectable(false);
        PrimaryDrawerItem item29 = new PrimaryDrawerItem().withIdentifier(29).withName(R.string.coffee_commercial_marketing_agent_list).withIcon(R.drawable.ic_cart).withSelectable(false);
        PrimaryDrawerItem item30 = new PrimaryDrawerItem().withIdentifier(30).withName(R.string.coffee_exporter_dealer_inspection_list).withIcon(R.drawable.ic_import_export).withSelectable(false);
        PrimaryDrawerItem item31 = new PrimaryDrawerItem().withIdentifier(31).withName(R.string.nuts_and_oils_market_survey_list).withIcon(R.drawable.ic_peanuts).withSelectable(false);
        PrimaryDrawerItem item32 = new PrimaryDrawerItem().withIdentifier(32).withName(R.string.cotton_buying_store_inspection_list).withIcon(R.drawable.ic_cotton_1).withSelectable(false);
        PrimaryDrawerItem item33 = new PrimaryDrawerItem().withIdentifier(33).withName(R.string.sisal_factory_inspection_list).withIcon(R.drawable.ic_factory_nspection).withSelectable(false);
        PrimaryDrawerItem item34 = new PrimaryDrawerItem().withIdentifier(34).withName(R.string.cotton_ginnery_inspection_list).withIcon(R.drawable.ic_cotton_ginnery).withSelectable(false);
        PrimaryDrawerItem item35 = new PrimaryDrawerItem().withIdentifier(35).withName(R.string.cotton_lint_classing_report_list).withIcon(R.drawable.ic_cotton).withSelectable(false);
        PrimaryDrawerItem item36 = new PrimaryDrawerItem().withIdentifier(36).withName(R.string.Sisal_Spinning_Inspection_List).withIcon(R.drawable.ic_sisal_inspection).withSelectable(false);
        PrimaryDrawerItem item38 = new PrimaryDrawerItem().withIdentifier(38).withName("Food Processing Inspection List").withIcon(R.drawable.ic_food_processing).withSelectable(false);
        PrimaryDrawerItem item39 = new PrimaryDrawerItem().withIdentifier(39).withName("Food Warehouse Inspection List").withIcon(R.drawable.ic_food_warehouses).withSelectable(false);
        PrimaryDrawerItem item40 = new PrimaryDrawerItem().withIdentifier(40).withName("Food Crop Export Inspection List").withIcon(R.drawable.ic_food_crop_export).withSelectable(false);

        SecondaryDrawerItem itemAbout = new SecondaryDrawerItem().withIdentifier(37).withName(R.string.nav_about_us).withIcon(R.drawable.ic_info).withSelectable(false);
        //SecondaryDrawerItem item8 = new SecondaryDrawerItem().withIdentifier(8).withName(R.string.feedback).withIcon(R.drawable.ic_feedback);
        // SecondaryDrawerItem itemAbout = new SecondaryDrawerItem().withIdentifier(9).withName(R.string.helpcentre).withIcon(R.drawable.ic_call_center);
        //SecondaryDrawerItem item10 = new SecondaryDrawerItem().withIdentifier(10).withName(R.string.daily_returns_insp).withIcon(R.drawable.ic_calendar);

        //creating navbar and adding to the toolbar ------------------------------------------------

        if (directorate == INT_SUGAR_DIRECTORATE) {
            result = new DrawerBuilder()
                    .withActivity(this)
                    .withToolbar(toolbar)
                    .withHasStableIds(true)
                    .withDrawerLayout(R.layout.crossfade_drawer)
                    .withAccountHeader(headerResult)
                    .withDrawerWidthDp(72)
                    .withGenerateMiniDrawer(true)
                    .withTranslucentStatusBar(true)
                    .withActionBarDrawerToggleAnimated(true)
                    .withDelayDrawerClickEvent(-1)
                    .addDrawerItems(
                            item3, item4, item5, item6, new DividerDrawerItem(), itemAbout
                    )
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                            switch (position) {

                                case 1:
                                    startActivity(new Intent(DashboardActivity.this, CaneCensusListActivity.class));
                                    break;

                                case 2:
                                    startActivity(new Intent(DashboardActivity.this, RetailPricesSurveyListActivity.class));
                                    break;

                                case 3:
                                    startActivity(new Intent(DashboardActivity.this, WholesalePricesSurveyListActivity.class));
                                    break;

                                case 4:
                                    startActivity(new Intent(getApplicationContext(), SugarMillLicenceComplianceListActivity.class));
                                    break;

                                case 6:
                                    startActivity(new Intent(getApplicationContext(), AboutUs.class));
                                    break;
                                default:
                                    //Toast.makeText(DashboardActivity.this, "Default", Toast.LENGTH_LONG).show();
                            }

                            return true;
                        }
                    })
                    .build();
        } else if (directorate == INT_TEA_DIRECTORATE) {
            result = new DrawerBuilder()
                    .withActivity(this)
                    .withToolbar(toolbar)
                    .withHasStableIds(true)
                    .withDrawerLayout(R.layout.crossfade_drawer)
                    .withAccountHeader(headerResult)
                    .withDrawerWidthDp(72)
                    .withGenerateMiniDrawer(true)
                    .withTranslucentStatusBar(true)
                    .withActionBarDrawerToggleAnimated(true)
                    .withDelayDrawerClickEvent(-1)
                    .addDrawerItems(
                            item8, item9, new DividerDrawerItem(), itemAbout

                    )
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                            switch (position) {

                                case 1:
                                    startActivity(new Intent(getApplicationContext(), TeaPackerList.class));
                                    break;
                                case 2:
                                    startActivity(new Intent(getApplicationContext(), TeaWarehouseManList.class));
                                    break;

                                case 4:
                                    startActivity(new Intent(getApplicationContext(), AboutUs.class));
                                    break;
                                default:
                                    //Toast.makeText(DashboardActivity.this, "Default", Toast.LENGTH_LONG).show();

                            }

                            return true;
                        }
                    })
                    .build();
        } else if (directorate == INT_HORTICULTURE_DIRECTORATE) {
            result = new DrawerBuilder()
                    .withActivity(this)
                    .withToolbar(toolbar)
                    .withHasStableIds(true)
                    .withDrawerLayout(R.layout.crossfade_drawer)
                    .withAccountHeader(headerResult)
                    .withDrawerWidthDp(72)
                    .withGenerateMiniDrawer(true)
                    .withTranslucentStatusBar(true)
                    .withActionBarDrawerToggleAnimated(true)
                    .withDelayDrawerClickEvent(-1)
                    .addDrawerItems(
                            item10, item11, item12, item13, item14,
                            item15, item16, item17, item18, item19, item20, item21, item22,
                            new DividerDrawerItem(), itemAbout

                    )
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {

                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                            switch (position) {

                                case 1:
                                    startActivity(new Intent(getApplicationContext(), HorticultureNurseryInspectionList.class));
                                    break;
                                case 2:
                                    startActivity(new Intent(getApplicationContext(), HorticulturalProduceTransportationList.class));
                                    break;
                                case 3:
                                    startActivity(new Intent(getApplicationContext(), HorticulturalPackhouseWarehouseList.class));
                                    break;
                                case 4:
                                    startActivity(new Intent(getApplicationContext(), HorticulturalCropsExportLicenceList.class));
                                    break;
                                case 5:
                                    startActivity(new Intent(getApplicationContext(), HorticulturalFlowerConsolidatorsList.class));
                                    break;
                                case 6:
                                    startActivity(new Intent(getApplicationContext(), FruitsAndVegetablesConsolidatorsList.class));
                                    break;
                                case 7:
                                    startActivity(new Intent(getApplicationContext(), HorticulturalFlowerExportersList.class));
                                    break;
                                case 8:
                                    startActivity(new Intent(getApplicationContext(), FruitsAndVegetablesExportersList.class));
                                    break;
                                case 9:
                                    startActivity(new Intent(getApplicationContext(), AvocadoQualityInspectionList.class));
                                    break;
                                case 10:
                                    startActivity(new Intent(getApplicationContext(), MangoQualityInspectionList.class));
                                    break;
                                case 11:
                                    startActivity(new Intent(getApplicationContext(), ColdRoomTemperatureList.class));
                                    break;
                                case 12:
                                    startActivity(new Intent(getApplicationContext(), PersonalHygieneList.class));
                                    break;
                                case 13:
                                    startActivity(new Intent(getApplicationContext(), HorticulturalCropsColdStorageList.class));
                                    break;
                                case 15:
                                    startActivity(new Intent(getApplicationContext(), AboutUs.class));
                                    break;
                                default:
                                    //Toast.makeText(DashboardActivity.this, "Default", Toast.LENGTH_LONG).show();
                            }
                            return true;
                        }
                    })
                    .build();

        } else if (directorate == INT_COFFEE_DIRECTORATE) {
            result = new DrawerBuilder()
                    .withActivity(this)
                    .withToolbar(toolbar)
                    .withHasStableIds(true)
                    .withDrawerLayout(R.layout.crossfade_drawer)
                    .withAccountHeader(headerResult)
                    .withDrawerWidthDp(72)
                    .withGenerateMiniDrawer(true)
                    .withTranslucentStatusBar(true)
                    .withActionBarDrawerToggleAnimated(true)
                    .withDelayDrawerClickEvent(-1)
                    .addDrawerItems(
                            item23, item24, item25, item26, item27,
                            item28, item29, item30, new DividerDrawerItem(), itemAbout
                    )
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                            switch (position) {

                                case 1:
                                    startActivity(new Intent(getApplicationContext(), CoffeeNurseryCertificateList.class));
                                    break;
                                case 2:
                                    startActivity(new Intent(getApplicationContext(), CoffeePulpingStationATEList.class));
                                    break;
                                case 3:
                                    startActivity(new Intent(getApplicationContext(), CoffeePulpingStationPSLList.class));
                                    break;
                                case 4:
                                    startActivity(new Intent(getApplicationContext(), CoffeeMillerLicenceList.class));
                                    break;
                                case 5:
                                    startActivity(new Intent(getApplicationContext(), CoffeeManagementAgentList.class));
                                    break;
                                case 6:
                                    startActivity(new Intent(getApplicationContext(), CoffeeGrowerMarketingAgentList.class));
                                    break;
                                case 7:
                                    startActivity(new Intent(getApplicationContext(), CoffeeCommercialMarketingAgentList.class));
                                    break;
                                case 8:
                                    startActivity(new Intent(getApplicationContext(), CoffeeExporterDealerInspectionList.class));
                                    break;
                                case 10:
                                    startActivity(new Intent(getApplicationContext(), AboutUs.class));
                                    break;
                                default:
                                    //Toast.makeText(DashboardActivity.this, "Default", Toast.LENGTH_LONG).show();
                            }
                            return true;
                        }
                    })
                    .build();
        } else if (directorate == INT_NUTS_AND_OILS_DIRECTORATE) {
            result = new DrawerBuilder()
                    .withActivity(this)
                    .withToolbar(toolbar)
                    .withHasStableIds(true)
                    .withDrawerLayout(R.layout.crossfade_drawer)
                    .withAccountHeader(headerResult)
                    .withDrawerWidthDp(72)
                    .withGenerateMiniDrawer(true)
                    .withTranslucentStatusBar(true)
                    .withActionBarDrawerToggleAnimated(true)
                    .withDelayDrawerClickEvent(-1)
                    .addDrawerItems(
                            item31, new DividerDrawerItem(), itemAbout

                    )
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                            switch (position) {

                                case 1:
                                    startActivity(new Intent(getApplicationContext(), NutsAndOilsSurveyList.class));
                                    break;

                                case 3:
                                    startActivity(new Intent(getApplicationContext(), AboutUs.class));
                                    break;
                                default:
                                    //Toast.makeText(DashboardActivity.this, "Default", Toast.LENGTH_LONG).show();

                            }

                            return true;
                        }
                    })
                    .build();
        } else if (directorate == INT_FOOD_DIRECTORATE) {
            result = new DrawerBuilder()
                    .withActivity(this)
                    .withToolbar(toolbar)
                    .withHasStableIds(true)
                    .withDrawerLayout(R.layout.crossfade_drawer)
                    .withAccountHeader(headerResult)
                    .withDrawerWidthDp(72)
                    .withGenerateMiniDrawer(true)
                    .withTranslucentStatusBar(true)
                    .withActionBarDrawerToggleAnimated(true)
                    .withDelayDrawerClickEvent(-1)
                    .addDrawerItems(
                            item38, item39, item40, new DividerDrawerItem(), itemAbout

                    )
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                            switch (position) {

                                case 1:
                                    startActivity(new Intent(getApplicationContext(), FoodProcessingInspectionList.class));
                                    break;

                                case 2:
                                    startActivity(new Intent(getApplicationContext(), FoodWareHouseActivityList.class));
                                    break;
                                case 3:
                                    startActivity(new Intent(getApplicationContext(), FoodCropRecylerListActivity.class));
                                    break;

                                case 5:
                                    startActivity(new Intent(getApplicationContext(), AboutUs.class));
                                    break;
                                default:
                                    //Toast.makeText(DashboardActivity.this, "Default", Toast.LENGTH_LONG).show();

                            }

                            return true;
                        }
                    })
                    .build();
        } else if (directorate == INT_PYRETHRUM_DIRECTORATE) {

            result = new DrawerBuilder()
                    .withActivity(this)
                    .withToolbar(toolbar)
                    .withHasStableIds(true)
                    .withDrawerLayout(R.layout.crossfade_drawer)
                    .withAccountHeader(headerResult)
                    .withDrawerWidthDp(72)
                    .withGenerateMiniDrawer(true)
                    .withTranslucentStatusBar(true)
                    .withActionBarDrawerToggleAnimated(true)
                    .withDelayDrawerClickEvent(-1)
                    .addDrawerItems(
                            item7, new DividerDrawerItem(), itemAbout
                    )
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                            switch (position) {

                                case 1:
                                    startActivity(new Intent(getApplicationContext(), PyrethrumInspectionListActivity.class));
                                    break;
                                case 3:
                                    startActivity(new Intent(getApplicationContext(), AboutUs.class));
                                    break;
                                default:
                                    //Toast.makeText(DashboardActivity.this, "Default", Toast.LENGTH_LONG).show();
                            }

                            return true;
                        }
                    })
                    .build();
        } else if (directorate == INT_FIBRE_DIRECTORATE) {
            result = new DrawerBuilder()
                    .withActivity(this)
                    .withToolbar(toolbar)
                    .withHasStableIds(true)
                    .withDrawerLayout(R.layout.crossfade_drawer)
                    .withAccountHeader(headerResult)
                    .withDrawerWidthDp(72)
                    .withGenerateMiniDrawer(true)
                    .withTranslucentStatusBar(true)
                    .withActionBarDrawerToggleAnimated(true)
                    .withDelayDrawerClickEvent(-1)
                    .addDrawerItems(
                            item32, item33, item34, item35, item36, new DividerDrawerItem(), itemAbout
                    )
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                            switch (position) {

                                case 1:
                                    startActivity(new Intent(getApplicationContext(), CottonBuyingStoreInspectionList.class));
                                    break;
                                case 2:
                                    startActivity(new Intent(getApplicationContext(), SisalFactoryInspectionList.class));
                                    break;
                                case 3:
                                    startActivity(new Intent(getApplicationContext(), CottonGinneryInspectionList.class));
                                    break;
                                case 4:
                                    startActivity(new Intent(getApplicationContext(), CottonLintClassingReportList.class));
                                    break;
                                case 5:
                                    startActivity(new Intent(getApplicationContext(), SisalSpinningInsList.class));
                                    break;
                                case 7:
                                    startActivity(new Intent(getApplicationContext(), AboutUs.class));
                                    break;
                                default:
                                    //Toast.makeText(DashboardActivity.this, "Default", Toast.LENGTH_LONG).show();
                            }

                            return true;
                        }
                    })
                    .build();
        } else {
            result = new DrawerBuilder()
                    .withActivity(this)
                    .withToolbar(toolbar)
                    .withHasStableIds(true)
                    .withDrawerLayout(R.layout.crossfade_drawer)
                    .withAccountHeader(headerResult)
                    .withDrawerWidthDp(72)
                    .withGenerateMiniDrawer(true)
                    .withTranslucentStatusBar(true)
                    .withActionBarDrawerToggleAnimated(true)
                    .withDelayDrawerClickEvent(-1)
                    .addDrawerItems(
                            itemAbout
                    )
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                            switch (position) {

                                case 1:
                                    startActivity(new Intent(getApplicationContext(), AboutUs.class));
                                    break;
                                default:
                                    //Toast.makeText(DashboardActivity.this, "Default", Toast.LENGTH_LONG).show();
                            }
                            return true;
                        }
                    })
                    .build();
        }

        /*result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withDrawerLayout(R.layout.crossfade_drawer)
                .withAccountHeader(headerResult)
                .withDrawerWidthDp(72)
                .withGenerateMiniDrawer(true)
                .withTranslucentStatusBar(true)
                .withActionBarDrawerToggleAnimated(true)
                    .withDelayDrawerClickEvent(-1)
                .addDrawerItems(
                        item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14,
                        item15, item16, item17, item18, item19, item20, item21, item22, item23, item24, item25, item26, item27,
                        item28, item29, item30, item31, item32, item33, item34, new DividerDrawerItem(), itemAbout

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        switch (position) {

                            case 1:
                                if (result != null && result.isDrawerOpen()) {
                                    result.closeDrawer();
                                }
                                break;

                            case 2:
                                // startActivity(new Intent(DashboardActivity.this, ProfileActivity.class));
                                break;

                            case 3:
                                startActivity(new Intent(DashboardActivity.this, CaneCensusListActivity.class));
                                break;

                            case 4:
                                startActivity(new Intent(DashboardActivity.this, RetailPricesSurveyListActivity.class));
                                break;

                            case 5:
                                startActivity(new Intent(DashboardActivity.this, WholesalePricesSurveyListActivity.class));
                                break;

                            case 6:
                                startActivity(new Intent(getApplicationContext(), SugarMillLicenceComplianceListActivity.class));
                                break;

                            case 7:
                                startActivity(new Intent(getApplicationContext(), PyrethrumInspectionListActivity.class));
                                break;

                            case 8:
                                startActivity(new Intent(getApplicationContext(), TeaPackerList.class));
                                break;
                            case 9:
                                startActivity(new Intent(getApplicationContext(), TeaWarehouseManList.class));
                                break;
                            case 10:
                                startActivity(new Intent(getApplicationContext(), HorticultureNurseryInspectionList.class));
                                break;
                            case 11:
                                startActivity(new Intent(getApplicationContext(), HorticulturalProduceTransportationList.class));
                                break;
                            case 12:
                                startActivity(new Intent(getApplicationContext(), HorticulturalPackhouseWarehouseList.class));
                                break;
                            case 13:
                                startActivity(new Intent(getApplicationContext(), HorticulturalCropsExportLicenceList.class));
                                break;
                            case 14:
                                startActivity(new Intent(getApplicationContext(), HorticulturalFlowerConsolidatorsList.class));
                                break;
                            case 15:
                                startActivity(new Intent(getApplicationContext(), FruitsAndVegetablesConsolidatorsList.class));
                                break;
                            case 16:
                                startActivity(new Intent(getApplicationContext(), HorticulturalFlowerExportersList.class));
                                break;
                            case 17:
                                startActivity(new Intent(getApplicationContext(), FruitsAndVegetablesExportersList.class));
                                break;
                            case 18:
                                startActivity(new Intent(getApplicationContext(), AvocadoQualityInspectionList.class));
                                break;
                            case 19:
                                startActivity(new Intent(getApplicationContext(), MangoQualityInspectionList.class));
                                break;
                            case 20:
                                startActivity(new Intent(getApplicationContext(), ColdRoomTemperatureList.class));
                                break;
                            case 21:
                                startActivity(new Intent(getApplicationContext(), PersonalHygieneList.class));
                                break;
                            case 22:
                                startActivity(new Intent(getApplicationContext(), HorticulturalCropsColdStorageList.class));
                                break;
                            case 23:
                                startActivity(new Intent(getApplicationContext(), CoffeeNurseryCertificateList.class));
                                break;
                            case 24:
                                startActivity(new Intent(getApplicationContext(), CoffeePulpingStationATEList.class));
                                break;
                            case 25:
                                startActivity(new Intent(getApplicationContext(), CoffeePulpingStationPSLList.class));
                                break;
                            case 26:
                                startActivity(new Intent(getApplicationContext(), CoffeeMillerLicenceList.class));
                                break;
                            case 27:
                                startActivity(new Intent(getApplicationContext(), CoffeeManagementAgentList.class));
                                break;
                            case 28:
                                startActivity(new Intent(getApplicationContext(), CoffeeGrowerMarketingAgentList.class));
                                break;
                            case 29:
                                startActivity(new Intent(getApplicationContext(), CoffeeCommercialMarketingAgentList.class));
                                break;
                            case 30:
                                startActivity(new Intent(getApplicationContext(), CoffeeExporterDealerInspectionList.class));
                                break;
                            case 31:
                                startActivity(new Intent(getApplicationContext(), NutsAndOilsSurveyList.class));
                                break;
                            case 32:
                                startActivity(new Intent(getApplicationContext(), CottonBuyingStoreInspectionList.class));
                                break;
                            case 33:
                                startActivity(new Intent(getApplicationContext(), SisalFactoryInspectionList.class));
                                break;
                            case 34:
                                startActivity(new Intent(getApplicationContext(), CottonGinneryInspectionList.class));
                                break;
                            case 36:
                                startActivity(new Intent(getApplicationContext(), AboutUs.class));
                                break;
                            default:
                                //Toast.makeText(DashboardActivity.this, "Default", Toast.LENGTH_LONG).show();

                        }

                        return true;
                    }
                })
                .build();
*/
        //Setting crossfader drawer------------------------------------------------------------

        crossfadeDrawerLayout = (CrossfadeDrawerLayout) result.getDrawerLayout();

        //define maxDrawerWidth
        crossfadeDrawerLayout.setMaxWidthPx(DrawerUIUtils.getOptimalDrawerWidth(this));

        //add second view (which is the miniDrawer)
        final MiniDrawer miniResult = result.getMiniDrawer()
                .withIncludeSecondaryDrawerItems(true);

        //build the view for the MiniDrawer
        View view = miniResult.build(this);

        //set the background of the MiniDrawer as this would be transparent
        view.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(this, com.mikepenz.materialdrawer.R.attr.material_drawer_background, com.mikepenz.materialdrawer.R.color.material_drawer_background));

        //we do not have the MiniDrawer view during CrossfadeDrawerLayout creation so we will add it here
        crossfadeDrawerLayout.getSmallView().addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        //define the crossfader to be used with the miniDrawer. This is required to be able to automatically toggle open / close
        miniResult.withCrossFader(new ICrossfader() {
            @Override
            public void crossfade() {
                boolean isFaded = isCrossfaded();
                crossfadeDrawerLayout.crossfade(400);

                //only close the drawer if we were already faded and want to close it now
                if (isFaded) {
                    result.getDrawerLayout().closeDrawer(GravityCompat.START);
                }
            }

            @Override
            public boolean isCrossfaded() {
                return crossfadeDrawerLayout.isCrossfaded();
            }
        });
    }

    private void syncData(List<ClientInfo> clientInfoList) {

        if (clientInfoList != null && !clientInfoList.isEmpty()) {

            for (ClientInfo clientInfo : clientInfoList) {

                Call<ClientResponse> call = recordsInterface.syncRecords(clientInfo);
                call.enqueue(new Callback<ClientResponse>() {
                    @Override
                    public void onResponse(@NotNull Call<ClientResponse> call, @NotNull Response<ClientResponse> response) {
                        if (response.isSuccessful()) {
                            ClientResponse clientResponse = response.body();
                            assert clientResponse != null;
                            recordViewModel.updateClientRecord(new ClientStatus(true, clientResponse.getClient_id(), clientResponse.getRecord_id()));
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<ClientResponse> call, @NotNull Throwable t) {

                    }
                });
            }
        }

    }

    private void createDirectory() {
        String root = Environment.getExternalStorageDirectory().toString();
        System.out.println(root + " Root value in saveImage Function");
        File myDir = new File(root + imagePath);

        if (!myDir.exists()) {
            myDir.mkdirs();
        }
    }


    private void logout() {

        if (!app.settings.IsloggedIn()) {
            return;
        }

        SnackProgressBar snackProgressBar = new SnackProgressBar(
                SnackProgressBar.TYPE_CIRCULAR,
                "Logging Out...")
                .setSwipeToDismiss(false);

        // Show snack progress during logout
        snackProgressBarManager.dismissAll();
        snackProgressBarManager.show(snackProgressBar, SnackProgressBarManager.LENGTH_INDEFINITE);

        //Clear Shared Pref File
        app.settings.SetIsloggedIn(false);
        app.settings.SetIsFirstTime(true);
        app.settings.setFullName("");
        app.settings.setEmail("");
        app.settings.setBearerToken("");
        app.setAdUser(null);
        db.deleteLogin();
        db.deleteADUser();

        /*Intent serviceIntent = new Intent(getApplicationContext(), DataSetupService.class);
        serviceIntent.putExtra("UserDirectorate", "");
        startService(serviceIntent);*/
        //Redirect User to Login Page
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();

        //Unreachable anyway
        snackProgressBarManager.dismiss();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);


        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_aboutus) {
            Intent intent = new Intent(DashboardActivity.this, AboutUs.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void hideKeyboard(/*Activity activity*/) {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private class FetchStats extends AsyncTask<String, String, String> {

        private ProgressDialog mprogress = new ProgressDialog(DashboardActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mprogress.show();
            mprogress.setTitle("Processing...");
            mprogress.setMessage("Please wait...");
            mprogress.setCancelable(true);
            mprogress.setIndeterminate(false);


        }

        @Override
        protected String doInBackground(String... params) {
            String cardView = params[0];

            if (cardView.equals("cardViewAddSugarMillLicence")) {
                try {
                    getSugarMillInspection();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewAddTeaPacker")) {
                try {
                    getteapackerchecklist();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewTeaWareHouseMan")) {
                try {
                    getTeaWarehouseManInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewCoffeeNurseryCertificate")) {
                try {
                    getCoffeeNurseryInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewPulpingStation")) {
                try {
                    getPulpingStationLicenseApplication();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewCoffeeMillerLicenceApplication")) {
                try {
                    getCoffeeMillerLicenseApplication();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewAddCoffeePulpingLicApllPSL")) {
                try {
                    getCoffeePulpingLicenceApllPSL();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewCoffeeMnagementAgent")) {
                try {
                    getCoffeemanagementAgent();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewCoffeeGrowerMarketingAgent")) {
                try {
                    getCoffeeGrowerMarketingAgent();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewCoffeeExporterDealerInspection")) {
                try {
                    getCoffeeExporterDealerInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewCoffeeCommercialMarketingAgent")) {
                try {
                    getCoffeeCommercialMarketingAgents();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewAddpyrethrumInspection")) {
                try {
                    getPyrethrumChecklistInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewHCDFlowerConsolidators")) {
                try {
                    getFlowersConsolidators();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewHCDNurseryInspection")) {
                try {
                    getHorticultureNurseryInspectionChecklist();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewHCDParkhouseWareHouseInspection")) {
                try {
                    getHorticultureParkhouseWarehouseInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewHCDProduceTransportation")) {
                try {
                    getHorticultureProduceTransportationChecklist();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewFruitsVegetablesExportsDeskVettingChecklist")) {
                try {
                    getHorticultureFruitsAndVegetablesExporters();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewHCDFruitsVegetablesConsolidatosDeskvetting")) {
                try {
                    getFruitsConsolidators();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewAvocadoQualityInspectionChecklist")) {
                try {
                    getAvocadoQualityInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewHCDMangoQualityInspectionChecklistActivity")) {
                try {
                    getMangoQualityInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewHCDFlowerExporterDeskVetting")) {
                try {
                    getHorticulturalFlowerExportersDeskVetting();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewHCDLicenceFarmInspection")) {
                try {
                    getHorticultureCropExportLicenceFarmInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewSisalfactoryInspection")) {
                try {
                    getSisalFactoryInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewCottonBuyingInspection")) {
                try {
                    getCottonBuyingStoreInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewSisalSpinningFactoryInspection")) {
                try {
                    getSisalSpinningFactoryInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewCottonGinneryInspection")) {
                try {
                    getCottonGinneryInspection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewFoodProcessing")) {
                try {
                    getFoodProcessing();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewFoodWarehouseInspection")) {
                try {
                    getFoodWareHouse();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewFoodCrop")) {
                try {
                    getFoodCrop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (cardView.equals("cardViewCottonLintClassingReport")) {
                try {
                    getCottonLintClassingReport();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            refreshCouponOneTimeWork();
            return cardView;
        }

        @Override
        protected void onPostExecute(String result) {

            if (result.equals("cardViewAddSugarMillLicence")) {

                startActivity(new Intent(getApplicationContext(), SugarMillLicenceComplianceActivity.class));

            } else if (result.equals("cardViewAddTeaPacker")) {

                startActivity(new Intent(getApplicationContext(), TeaPackerAcivity.class));

            } else if (result.equals("cardViewTeaWareHouseMan")) {

                startActivity(new Intent(getApplicationContext(), TeaWarehouseManInspectionChecklistActivity.class));

            } else if (result.equals("cardViewCoffeeNurseryCertificate")) {

                startActivity(new Intent(getApplicationContext(), CoffeeNurseryCertificateActivity.class));

            } else if (result.equals("cardViewPulpingStation")) {

                startActivity(new Intent(getApplicationContext(), PulpingStationLicenseApplicationActivity.class));

            } else if (result.equals("cardViewCoffeeMillerLicenceApplication")) {

                startActivity(new Intent(getApplicationContext(), CoffeeMillerLicenceApplicationActivity.class));

            } else if (result.equals("cardViewAddCoffeePulpingLicApllPSL")) {

                startActivity(new Intent(getApplicationContext(), CoffeePulpingStationPSLActivity.class));

            } else if (result.equals("cardViewCoffeeMnagementAgent")) {

                startActivity(new Intent(getApplicationContext(), CoffeeManagementAgentActivity.class));

            } else if (result.equals("cardViewCoffeeGrowerMarketingAgent")) {

                startActivity(new Intent(getApplicationContext(), CoffeeGrowerMarketingAgentActivity.class));

            } else if (result.equals("cardViewCoffeeExporterDealerInspection")) {

                startActivity(new Intent(getApplicationContext(), CoffeeExporterDealerInspectionActivity.class));

            } else if (result.equals("cardViewHCDFlowerConsolidators")) {

                startActivity(new Intent(getApplicationContext(), HCDFlowersConsolidatorsActivity.class));

            } else if (result.equals("cardViewHCDNurseryInspection")) {

                startActivity(new Intent(getApplicationContext(), HCDNurseryInspectionActivity.class));

            } else if (result.equals("cardViewHCDParkhouseWareHouseInspection")) {

                startActivity(new Intent(getApplicationContext(), HCDParkhouseWarehouseActivity.class));

            } else if (result.equals("cardViewCoffeeCommercialMarketingAgent")) {

                startActivity(new Intent(getApplicationContext(), CoffeeCommercialMarketingAgentActivity.class));

            } else if (result.equals("cardViewAddpyrethrumInspection")) {

                startActivity(new Intent(getApplicationContext(), PyrethrumInspectionActivity.class));

            } else if (result.equals("cardViewHCDProduceTransportation")) {

                startActivity(new Intent(getApplicationContext(), HorticultureProduceTransportationActivity.class));

            } else if (result.equals("cardViewFruitsVegetablesExportsDeskVettingChecklist")) {

                startActivity(new Intent(getApplicationContext(), FruitsVegetablesExportersDeskVettingChecklistActivity.class));

            } else if (result.equals("cardViewHCDFruitsVegetablesConsolidatosDeskvetting")) {

                startActivity(new Intent(getApplicationContext(), FruitVegetableConsolidatorsDeskvettingChecklistActivity.class));

            } else if (result.equals("cardViewAvocadoQualityInspectionChecklist")) {

                startActivity(new Intent(getApplicationContext(), HCDAvocadoQualityInspectionChecklistActivity.class));

            } else if (result.equals("cardViewHCDMangoQualityInspectionChecklistActivity")) {

                startActivity(new Intent(getApplicationContext(), HCDMangoQualityInspectionChecklistActivity.class));

            } else if (result.equals("cardViewHCDFlowerExporterDeskVetting")) {

                startActivity(new Intent(getApplicationContext(), HorticultureFlowerExporterDeskVettingActivity.class));

            } else if (result.equals("cardViewCottonBuyingInspection")) {

                startActivity(new Intent(getApplicationContext(), FCDCottonBuyingStoreInspectionActivity.class));

            } else if (result.equals("cardViewHCDLicenceFarmInspection")) {

                startActivity(new Intent(getApplicationContext(), HorticultureLicenceFarmInspectionActivity.class));

            } else if (result.equals("cardViewSisalfactoryInspection")) {

                startActivity(new Intent(getApplicationContext(), FCDSisalFactoryInspectionConformityAssessmentActivity.class));

            } else if (result.equals("cardViewSisalSpinningFactoryInspection")) {

                startActivity(new Intent(getApplicationContext(), FCDSisalSpinningFactoryInspectionConformityAssessmentActivity.class));

            } else if (result.equals("cardViewCottonGinneryInspection")) {

                startActivity(new Intent(getApplicationContext(), FCDCottonGinneryInspectionActivity.class));

            } else if (result.equals("cardViewCottonLintClassingReport")) {

                startActivity(new Intent(getApplicationContext(), FCDCottonLintClassingReportActivity.class));

            } else if (result.equals("cardViewFoodProcessing")) {

                startActivity(new Intent(getApplicationContext(), FoodProcessingInspectionActivity.class));

            } else if (result.equals("cardViewFoodWarehouseInspection")) {

                startActivity(new Intent(getApplicationContext(), FoodWareHouseActivity.class));

            }else if (result.equals("cardViewFoodCrop")) {

                startActivity(new Intent(getApplicationContext(), FoodCropExportActivity.class));

            }

            if (mprogress.isShowing()) {
                mprogress.dismiss();
            }

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
                //db.deleteSugarMillCompliance();
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
        data.addField("ispacker", "Y");
        ws.setDataRow(data);

        WebServiceConnection client = getClient();

        ArrayList<TeaPackerChecklist> TeaPackerChecklistArrayList = new ArrayList<>();

        TeaPackerChecklist teaPackerChecklist = null;
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                //db.deleteTeapackerInspection();
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


    private void getPyrethrumChecklistInspection() {
        db.open();
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
                //db.deletePyrethrum();
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
                            System.out.println("AFA_PD_Inspect_Processor_ID" + field.getColumn());

                        } else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            pyrethrumInspectionChecklist.setDocument_number(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            pyrethrumInspectionChecklist.setDocument_date(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            pyrethrumInspectionChecklist.setName_of_applicant(field.getStringValue());

                        else if ("AFA_PD_Pyrethrum_Nsry_Lic_ID".equalsIgnoreCase(field.getColumn()))
                            pyrethrumInspectionChecklist.setCertificate_number(getPyrethrumChecklistCertificateNumber(field.getStringValue()));

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

    private String getPyrethrumChecklistCertificateNumber(String itemID) {
        db.open();

        String certificateNumber = "";

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryPyrethrumCertificateNumber");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();
        data.addField("AFA_PD_Pyrethrum_Nsry_Lic_ID", itemID);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            certificateNumber = field.getStringValue();
                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return certificateNumber;
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

        WebServiceConnection client = getClient();

        ArrayList<TeaWarehouseManInspectionDataCollection> teaWarehouseManArrayList = new ArrayList<>();

        TeaWarehouseManInspectionDataCollection teaWarehouseManInspection = null;
        try {
            WindowTabDataResponse response = client.sendRequest(webs);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println("Response Message" + response.getErrorMessage());
            } else {
                //db.deleteTeaWarehouseManInspection();
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
                //db.deletePulpingStationLicenseApplication();
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
                            pulpingStationLicenseApplicationDetails.setAuthorityToErectNumber(getPulpingStationATELicenceNumber(field.getStringValue()));
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

    private String getPulpingStationATELicenceNumber(String itemID) {

        String licenceNumber = "";

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryPulpingStationATELicenceNumber");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();
        data.addField("AFA_CD_Pulpstation_Letter_ID", itemID);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            licenceNumber = field.getStringValue();
                        }


                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return licenceNumber;
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
               // //db.deleteCoffeeMillerLicenseApplication();
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
                            coffeeMillerLicenceApplicationDetails.setLicenceNumber(getCoffeeMillerLicenceNumber(field.getStringValue()));
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

    private String getCoffeeMillerLicenceNumber(String itemID) {

        String licenceNumber = "";

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCoffeeMillerLicenceNumber");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();
        data.addField("AFA_CD_Millerregistration_ID", itemID);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            licenceNumber = field.getStringValue();
                        }


                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return licenceNumber;
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
                //db.deletenurseryinspections();
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
                            coffeeNursercertInsp.setCertificateNumber(getCoffeeNurseryLicenceNumber(field.getStringValue()));

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

    private String getCoffeeNurseryLicenceNumber(String itemID) {

        String licenceNumber = "";

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCoffeeNurseryLicenceNumber");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();
        data.addField("AFA_CD_NurseryRegistration_ID", itemID);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            licenceNumber = field.getStringValue();
                        }


                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return licenceNumber;
    }

    protected void getCoffeePulpingLicenceApllPSL() {

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
              //  //db.deletecoffeePulpingPSLrecords();
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
                            coffeePulpinglicenceApllPSL.setLicence_number(getPulpingStationPSLLicenceNumber(field.getStringValue()));

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


    private String getPulpingStationPSLLicenceNumber(String itemID) {

        String licenceNumber = "";

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryPulpingStationPSLLicenceNumber");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();
        data.addField("AFA_CD_Pulpstation_Lic_ID", itemID);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            licenceNumber = field.getStringValue();
                        }


                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return licenceNumber;
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

                //db.deletecoffeeManagementAgentrecords();
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
                            coffeeManagementAgentInsp.setLicence_no(getCoffeeManagementAgentLicenceNumber(field.getStringValue()));

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

    private String getCoffeeManagementAgentLicenceNumber(String itemID) {

        String licenceNumber = "";

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCoffeeManagementAgentLicenceNumber");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();
        data.addField("AFA_CD_Mgt_Agent_Lic_ID", itemID);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            licenceNumber = field.getStringValue();
                        }


                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return licenceNumber;
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
                //db.deleteCoffeeGrowerMarketingAgent();
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
                            coffeeGrowerMarketingAgentDetails.setLicenceNumber(getCoffeeGrowerMarketingAgentLicenceNumber(field.getStringValue()));

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

    private String getCoffeeGrowerMarketingAgentLicenceNumber(String itemID) {

        String licenceNumber = "";

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCoffeeGrowerMarketingLicenceNumber");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();
        data.addField("AFA_CD_CommMarketReg_ID", itemID);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            licenceNumber = field.getStringValue();
                        }


                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return licenceNumber;
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
                //db.deleteCoffeeExporterDealerInspection();
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
                            coffeeExporterDealerInspectionDetails.setDealerLicenceNumber(getCoffeeExporterDealerLicenceNumber(field.getStringValue()));

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

    private String getCoffeeExporterDealerLicenceNumber(String itemID) {

        String licenceNumber = "";

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCoffeeExporterDealerLicenceNumber");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();
        data.addField("AFA_CD_ExporterDealerReg_ID", itemID);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            licenceNumber = field.getStringValue();
                        }


                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return licenceNumber;
    }

    protected void getCoffeeCommercialMarketingAgents() {

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

                //db.deletecommercialagentlistdata();
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
                            coffeeCommercialAgent.setLicence_number(getCoffeeCommercialMarketingAgentLicenceNumber(field.getStringValue()));


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

    private String getCoffeeCommercialMarketingAgentLicenceNumber(String itemID) {

        String licenceNumber = "";

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryCoffeeCommercialMarketLicenceNumber");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();
        data.addField("AFA_CD_CommMarketReg_ID", itemID);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            licenceNumber = field.getStringValue();
                        }


                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return licenceNumber;
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

                //db.deleteHorticulturalFlowerExportersDeskVetting();
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
                            horticulturalFlowerExportersDeskVettingDetails.setExport_licence(getHorticultureExportLicenceNumber(field.getStringValue()));

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

                //db.deleteHorticultureCropExportLicenceFarmInspection();
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
                            fruitsAndVegetablesExporters.setExportLicence(getHorticultureExportLicenceNumber(field.getStringValue()));

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

                //db.deleteHCDNurseryInspection();
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
                            horticultureNurseryInspectionDetails.setNurseryLicence(getHorticultureNurseryInspectionLicenceNumber(field.getStringValue()));

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


    private String getHorticultureNurseryInspectionLicenceNumber(String itemID) {

        String certificateNumber = "";

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryHorticultureNurseryLicenceNumber");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();
        data.addField("AFA_HC_NurseryRegistration_ID", itemID);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            certificateNumber = field.getStringValue();
                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return certificateNumber;
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

                //db.deleteHorticultureProduceTransportation();
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
                            horticultureProduceTransportationDetails.setExportLicence(getHorticultureExportLicenceNumber(field.getStringValue()));

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


    private String getHorticultureExportLicenceNumber(String itemID) {

        String certificateNumber = "";

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryHCExportLicenceNumber");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();
        data.addField("AFA_HC_Export_Lic_ID", itemID);
        ws.setDataRow(data);

        WebServiceConnection client = getClient();
        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        if ("DocumentNo".equalsIgnoreCase(field.getColumn())) {
                            certificateNumber = field.getStringValue();
                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return certificateNumber;
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

                //db.deleteparkhouseWarehouse();
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
                            horticultureProduceTransportationDetails.setLicenceNumber(getHorticultureExportLicenceNumber(field.getStringValue()));

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

                //db.deleteHCDFlowersConsolidatorsdata();
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
                            flowersConsolidators.setExport_licence(getHorticultureExportLicenceNumber(field.getStringValue()));

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

                //db.deleteHCDFruitVegetableConsolidatorsList();
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
                            fruitsConsolidators.setExportLicence(getHorticultureExportLicenceNumber(field.getStringValue()));

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

               //db.deleteAvocadoQualityInspection();
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

                //db.deleteMangoQualityInspection();
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

               //db.deleteSisalFactoryInspectionList();
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

                    db.insertFCDSisalFactoryInspection(sisalFactoryInspection);
                    sisalFactoryInspectionArrayList.add(sisalFactoryInspection);

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

                //db.deleteSisalSpinningFactoryInspectionList();
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

                    db.insertSisalSpinningFactoryInspection(sisalSpinningFactoryInspection);
                    sisalSpinningFactoryInspectionArrayList.add(sisalSpinningFactoryInspection);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void getFoodProcessing() {
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

                //db.deleteFoodProcessingInpectionList();
                System.out.println("Total food rows: " + response.getTotalRows());
                System.out.println("Num food rows: " + response.getNumRows());
                System.out.println("Start food row: " + response.getStartRow());
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

                   /*     else if ("AFA_FCD_ManufPlantReg_ID".equalsIgnoreCase(field.getColumn()))
                            foodProcessingInpection.setFoodCropManufacturingPlanApproval(getFoodProcessingLicence(field.getStringValue()));
*/
                    }
                    db.insertFoodProcessingInpection(foodProcessingInpection);
                    foodProcessingInpectionArrayList.add(foodProcessingInpection);

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

                //db.deletefoodWareHouseInspectionlist();
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

    private void getFoodCrop() {
        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QueryFoodCrop");
        ws.setLogin(getLogin());
        DataRow data = new DataRow();

        data.addField("IsApproved", "N");
        data.addField("Processing", "N");

        ws.setDataRow(data);

        WebServiceConnection client = getClient();


        ArrayList<FOodCropInspection> fOodCropInspectionArrayList = new ArrayList<>();

        FOodCropInspection fOodCropInspection = null;

        try {
            WindowTabDataResponse response = client.sendRequest(ws);

            if (response.getStatus() == Enums.WebServiceResponseStatus.Error) {
                System.out.println(response.getErrorMessage());
            } else {

                //db.deleteFOodCropInspectionList();
                System.out.println("Total food rows: " + response.getTotalRows());
                System.out.println("Num food rows: " + response.getNumRows());
                System.out.println("Start food row: " + response.getStartRow());
                System.out.println();
                for (int i = 0; i < response.getDataSet().getRowsCount(); i++) {
                    fOodCropInspection = new FOodCropInspection();
                    System.out.println("Row: " + (i + 1));
                    for (int j = 0; j < response.getDataSet().getRow(i).getFieldsCount(); j++) {
                        Field field = response.getDataSet().getRow(i).getFields().get(j);
                        System.out.println("Column: " + field.getColumn() + " = " + field.getStringValue());
                        if ("AFA_FCD_Consgnchecklist_ID".equalsIgnoreCase(field.getColumn()))
                            fOodCropInspection.setAFA_FD_FOOD_Crop_Inspection_ID(field.getStringValue());


                        else if ("DocumentNo".equalsIgnoreCase(field.getColumn()))
                            fOodCropInspection.setDocumentNumber(field.getStringValue());

                        else if ("applicationdate".equalsIgnoreCase(field.getColumn()))
                            fOodCropInspection.setDocumentDate(field.getStringValue());

                        else if ("C_BPartner_ID".equalsIgnoreCase(field.getColumn()))
                            fOodCropInspection.setNameOfApplicant(field.getStringValue());

                        else if ("AFA_FCD_HeaderExportPermit_ID".equalsIgnoreCase(field.getColumn()))
                            fOodCropInspection.setFoodCropLicence(field.getStringValue());

                    }
                    db.insertFOodCropInspection(fOodCropInspection);
                    fOodCropInspectionArrayList.add(fOodCropInspection);

                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
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

                //db.deleteCottonBuyingStoreInspectionList();
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

                //db.deleteCottonGinneryInspectionList();
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

                //db.deleteCottonLintClassingReportList();
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

    protected String getSisalFactoryInspectionLicence(String licenceNumber) {

        String licenceDocumentNumber = "";

        db.open();

        QueryDataRequest ws = new QueryDataRequest();
        ws.setWebServiceType("QuerySisalFactoryInspectionLicence");
        ws.setLogin(getLogin());

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

    public LoginRequest getLogin() {
        // SET LOGIN
        login = new LoginRequest();

        login.setUser(getString(R.string.baseUsername));
        login.setPass(getString(R.string.basePassword));
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
