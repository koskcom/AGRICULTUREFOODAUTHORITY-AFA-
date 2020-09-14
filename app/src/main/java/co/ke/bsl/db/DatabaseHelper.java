package co.ke.bsl.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import co.ke.bsl.adapter.AFADatabaseAdapter;


public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Called when no database exists in disk and the helper class needs
    // to create a new one.
    @Override
    public void onCreate(SQLiteDatabase _db) {
        try {
            System.out.println("Database being created");
            //_db.execSQL(AFADatabaseAdapter.om);

            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_SHOP);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_COUNTRY);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_CITY);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_LOCAL_BRAND);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_LOCAL_BRAND_STOCKED);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_LOCAL_IMPORT_BRAND);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_LOCAL_IMPORT_BRAND_STOCKED);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_USER);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_SUGAR_COMPANY);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_COUNTY);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_CROPS_DETAILS);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_MILLING);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_FARMER);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_RETAIL_LOCAL_BRAND);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_RETAIL_LOCAL_BRAND_STOCKED);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_RETAIL_LOCAL_IMPORT_BRAND);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_RETAIL_LOCAL_IMPORT_BRAND_STOCKED);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_RETAIL_LOOSE_BRAND);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_SUB_COUNTY);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_PRODUCT);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_SUGAR_MILL);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_PYRETHRUM_INSPECTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_TEA_WAREHOUSEMAN_INSPECTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_TEA_BUYER_IMPORTER_EXPORTER);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_PULPING_STATION_LICENSE_APPLICATION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_AFA_TD_TEAPACKERINSPCKLST);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_COFFEE_NURSERY_CERTIFICATE_INSPECTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_COFFEE_PULPING_STATION_LICE_APPLICATION_PSL);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_COFFEE_MANGEMENT_AGENT_CHECKLIST);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_COFFEE_MILLER_LICENSE_APPLICATION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_COFFEE_GROWER_MARKETING_AGENT);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_COFFEE_EXPORTER_DEALER_INSPECTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_COFFEE_COMMERCIAL_MARKET_AGENT);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_FLOWER_CONSOLIDATORS_DESKVETTING_INSPECTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_NURSERY_INSPECTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_PARKHOUSE_WAREHOUSE_INSPECTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_FRUITS_AND_VEGETABLES_EXPORTERS_DESK_VETTING);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_FRUITS_AND_VEGETABLES_CONSOLIDATORS_DESK_VETTING);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_HORTICULTURAL_CROPS_COLD_STORAGE_REGISTER);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_HORTICULTURE_COLD_STORAGE_IN);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_HORTICULTURE_COLD_STORAGE_OUT);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_HORTICULTURE_COLD_STORAGE_CHARGES);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_HCD_MANGO_QUALITY_INSPECTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_HCD_AVOCADO_QUALITY_INSPECTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_HCD_AVOCADO_QUALITY_INSPECTION_OIL_CONTENT);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_HCD_PERSONAL_HYGIENE);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_HCD_PERSONAL_HYGIENE_DETAILS);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_FCD_SISAL_FACTORY_INSPECTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_FCD_SISAL_SPINNING_FACTORY_INSPECTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_FCD_COTTON_BUYING_STORE_INSPECTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_FCD_COTTON_GINNERY_INSPECTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_FCD_COTTON_LINT_CLASSING_REPORT);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_FOOD_PROCESSING_INSPECCTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_FOOD_WAREHOUSE_INSPECCTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_FOOD_CROP_INSPECCTION);
            _db.execSQL(AFADatabaseAdapter.CREATE_TABLE_MILLING_TARIFFS);


        } catch (Exception er) {

            Log.e("Error", "exceptioin");
        }

    }

    // Called when there is a database version mismatch meaning that the version
    // of the database on disk needs to be upgraded to the current version.
    @Override
    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) {
        System.out.println("Database being upgraded");
        // Log the version upgrade.
        Log.w("TaskDBAdapter", "Upgrading from version " + _oldVersion + " to " + _newVersion + ", which will destroy all old data");


        // Upgrade the existing database to conform to the new version. Multiple
        // previous versions can be handled by comparing _oldVersion and _newVersion
        // values.
        // The simplest case is to drop the old table and create a new one.
        //_db.execSQL("DROP TABLE IF EXISTS " + "LOGIN");
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_shop);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_country);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_city);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_LOCAL_IMPORT);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_LOCAL_IMPORT_STOCKED);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_LOCALBRAND_STOCKED);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_LOCALBRAND);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_login);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_COUNTY);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_SUGAR_COMPANY);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_C_BPARTNER);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_MILLING);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_CROP_DETAIL);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_FARMER);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_SUB_COUNTY);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_PRODUCT);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_SUGAR_MILL);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_PYRETHRUM_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_TEA_WAREHOUSE_MAN_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_TEA_BUYER_IMPORTER_EXPORTER);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_PULPING_STATION_LICENSE_APPLICATION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_AFA_TD_TEAPACKERINSPCKLST);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_COFFEE_NURSERY_CERTIFICATE_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_COFFEE_PULPING_STATION_LICE_APPLICATION_PSL);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_COFFEE_MANGEMENT_AGENT_CHECKLIST);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_COFFEE_COMMERCIAL_MARKET_AGENT);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_FLOWER_CONSOLIDATORS_DESKVETTING_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_NURSERY_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_PARKHOUSE_WAREHOUSE_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_FRUITS_AND_VEGETABLES_EXPORTERS_DESK_VETTING);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_FRUITS_AND_VEGETABLES_CONSOLIDATORS_DESK_VETTING);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_HORTICULTURAL_CROPS_COLD_STORAGE_REGISTER);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_HORTICULTURE_COLD_STORAGE_IN);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_HORTICULTURE_COLD_STORAGE_OUT);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_HORTICULTURE_COLD_STORAGE_CHARGES);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_HCD_MANGO_QUALITY_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_HCD_AVOCADO_QUALITY_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_HCD_AVOCADO_QUALITY_INSPECTION_OIL_CONTENT);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_HCD_PERSONAL_HYGIENE);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_HCD_PERSONAL_HYGIENE_DETAILS);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_FCD_SISAL_FACTORY_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_FCD_SISAL_SPINNING_FACTORY_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_FCD_COTTON_BUYING_STORE_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_FCD_COTTON_GINNERY_INSPECTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_FCD_COTTON_LINT_CLASSING_REPORT);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_FOOD_PROCESSING_INSPECCTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_FOOD_WAREHOUSE_INSPECCTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_FOOD_CROP_INSPECCTION);
        _db.execSQL("DROP TABLE IF EXISTS " + AFADatabaseAdapter.TABLE_MILLING_TARIFFS);

        // Create a new one.
        onCreate(_db);
    }


}