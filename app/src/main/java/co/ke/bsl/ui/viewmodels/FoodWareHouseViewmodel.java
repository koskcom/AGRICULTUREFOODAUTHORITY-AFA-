package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.FoodProcessing;
import co.ke.bsl.data.model.FoodWarehouse;
import co.ke.bsl.data.view.FoodProcessingStatus;
import co.ke.bsl.data.view.FoodWarehouseStatus;
import co.ke.bsl.data.view.Total;

public class FoodWareHouseViewmodel extends AndroidViewModel {

    private Database database;

    public FoodWareHouseViewmodel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final FoodWarehouse foodWarehouse) {
        new FoodWareHouseViewmodel.addAsyncTask(database).execute(foodWarehouse);
    }

    public Total countFoodWarehouse() {
        return database.foodWareHouseDao().getFoodWarehouseCount();
    }

    public LiveData<List<FoodWarehouse>> getUnsyncedData(boolean state) {
        return database.foodWareHouseDao().fetchUnsyncedData(state);
    }

    public LiveData<List<FoodWarehouse>> getAllFoodProcessing() {
        return database.foodWareHouseDao().getAllFoodWarehouse();
    }

    public void updateFoodWarehouseRecord(final FoodWarehouseStatus foodWarehouseStatus) {
        new FoodWareHouseViewmodel.updateFoodWarehouseStatusAsyncTask(database).execute(foodWarehouseStatus);
    }


    static class addAsyncTask extends AsyncTask<FoodWarehouse, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FoodWarehouse... params) {
            db.foodWareHouseDao().addFoodWarehouse(params[0]);
            return null;
        }

    }

    private static class updateFoodWarehouseStatusAsyncTask extends AsyncTask<FoodWarehouseStatus, Void, Void> {

        private Database db;

        updateFoodWarehouseStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FoodWarehouseStatus... params) {
            db.foodWareHouseDao().updateFoodWarehouseSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getFood_warehouse_id());
            return null;
        }
    }
}
