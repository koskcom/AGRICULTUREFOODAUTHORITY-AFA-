package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.FCDCottonBuyingStoreInspection;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.CottonBuyingStoreStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class CottonBuyingStoreViewModel extends AndroidViewModel {

    private Database database;

    public CottonBuyingStoreViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final FCDCottonBuyingStoreInspection fcdCottonBuyingStoreInspection) {
        new CottonBuyingStoreViewModel.addAsyncTask(database).execute(fcdCottonBuyingStoreInspection);
    }

    public Total countCottonBuyingStoreInspection() {
        return database.cottonBuyingStoreInspectionDao().getCottonBuyingStoreInspectionCount();
    }

    public LiveData<List<FCDCottonBuyingStoreInspection>> getUnsyncedData(boolean state) {
        return database.cottonBuyingStoreInspectionDao().fetchUnsyncedData(state);
    }

    public LiveData<List<FCDCottonBuyingStoreInspection>> getAllCottonBuyingStoreInspections() {
        return database.cottonBuyingStoreInspectionDao().getAllCottonBuyingStoreInspections();
    }

    public void updateCottonBuyingStoreInspectionRecord(final CottonBuyingStoreStatus cottonBuyingStoreStatus) {
        new CottonBuyingStoreViewModel.updateCottonBuyingStoreInspectionStatusAsyncTask(database).execute(cottonBuyingStoreStatus);
    }


    static class addAsyncTask extends AsyncTask<FCDCottonBuyingStoreInspection, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FCDCottonBuyingStoreInspection... params) {
            db.cottonBuyingStoreInspectionDao().addCottonBuyingStoreInspection(params[0]);
            return null;
        }

    }

    private static class updateCottonBuyingStoreInspectionStatusAsyncTask extends AsyncTask<CottonBuyingStoreStatus, Void, Void> {

        private Database db;

        updateCottonBuyingStoreInspectionStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CottonBuyingStoreStatus... params) {
            db.cottonBuyingStoreInspectionDao().updateCottonBuyingStoreInspectionSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getCottonBuyingStore_id());
            return null;
        }
    }
}