package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.HCDHorticulturalCropsColdStorage;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.HorticulturalCropsColdStorageStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class HorticulturalCropsColdStorageViewModel extends AndroidViewModel {

    private Database database;

    public HorticulturalCropsColdStorageViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final HCDHorticulturalCropsColdStorage hcdHorticulturalCropsColdStorage) {
        new HorticulturalCropsColdStorageViewModel.addAsyncTask(database).execute(hcdHorticulturalCropsColdStorage);
    }

    public Total countHorticulturalCropsColdStorage() {
        return database.horticulturalCropsColdStorageDao().getHorticulturalCropsColdStorageCount();
    }

    public LiveData<List<HCDHorticulturalCropsColdStorage>> getUnsyncedData(boolean state) {
        return database.horticulturalCropsColdStorageDao().fetchUnsyncedData(state);
    }

    public LiveData<List<HCDHorticulturalCropsColdStorage>> getAllHorticulturalCropsColdStorage() {
        return database.horticulturalCropsColdStorageDao().getAllHorticulturalCropsColdStorage();
    }

    public void updateHorticulturalCropsColdStorageRecord(final HorticulturalCropsColdStorageStatus horticulturalCropsColdStorageStatus) {
        new HorticulturalCropsColdStorageViewModel.updateHorticulturalCropsColdStorageStatusAsyncTask(database).execute(horticulturalCropsColdStorageStatus);
    }


    static class addAsyncTask extends AsyncTask<HCDHorticulturalCropsColdStorage, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HCDHorticulturalCropsColdStorage... params) {
            db.horticulturalCropsColdStorageDao().addHorticulturalCropsColdStorage(params[0]);
            return null;
        }

    }

    private static class updateHorticulturalCropsColdStorageStatusAsyncTask extends AsyncTask<HorticulturalCropsColdStorageStatus, Void, Void> {

        private Database db;

        updateHorticulturalCropsColdStorageStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HorticulturalCropsColdStorageStatus... params) {
            db.horticulturalCropsColdStorageDao().updateHorticulturalCropsColdStorageSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getHorticulturalCropsColdStorage_id());
            return null;
        }
    }
}