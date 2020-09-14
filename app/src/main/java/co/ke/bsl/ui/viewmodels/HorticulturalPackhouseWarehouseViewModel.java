package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.HCDParkhouseWarehouse;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.HorticulturalPackhouseWarehouseStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class HorticulturalPackhouseWarehouseViewModel extends AndroidViewModel {

    private Database database;

    public HorticulturalPackhouseWarehouseViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final HCDParkhouseWarehouse hcdParkhouseWarehouse) {
        new HorticulturalPackhouseWarehouseViewModel.addAsyncTask(database).execute(hcdParkhouseWarehouse);
    }

    public Total countHorticulturalPackhouseWarehouse() {
        return database.horticulturalPackhouseWarehouseDao().getHorticulturalPackhouseWarehouseCount();
    }

    public LiveData<List<HCDParkhouseWarehouse>> getUnsyncedData(boolean state) {
        return database.horticulturalPackhouseWarehouseDao().fetchUnsyncedData(state);
    }

    public LiveData<List<HCDParkhouseWarehouse>> getAllHorticulturalPackhouseWarehouse() {
        return database.horticulturalPackhouseWarehouseDao().getAllHorticulturalPackhouseWarehouse();
    }

    public void updateHorticulturalPackhouseWarehouseRecord(final HorticulturalPackhouseWarehouseStatus horticulturalPackhouseWarehouseStatus) {
        new HorticulturalPackhouseWarehouseViewModel.updateHorticulturalPackhouseWarehouseStatusAsyncTask(database).execute(horticulturalPackhouseWarehouseStatus);
    }


    static class addAsyncTask extends AsyncTask<HCDParkhouseWarehouse, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HCDParkhouseWarehouse... params) {
            db.horticulturalPackhouseWarehouseDao().addHorticulturalPackhouseWarehouse(params[0]);
            return null;
        }

    }

    private static class updateHorticulturalPackhouseWarehouseStatusAsyncTask extends AsyncTask<HorticulturalPackhouseWarehouseStatus, Void, Void> {

        private Database db;

        updateHorticulturalPackhouseWarehouseStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HorticulturalPackhouseWarehouseStatus... params) {
            db.horticulturalPackhouseWarehouseDao().updateHorticulturalPackhouseWarehouseSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getHortuculturalPackhouseWarehouse_id());
            return null;
        }
    }
}