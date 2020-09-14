package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.FCDCottonGinneryInspection;
import co.ke.bsl.data.view.CottonGinneryStatus;
import co.ke.bsl.data.view.Total;

public class CottonGinneryViewModel extends AndroidViewModel {

    private Database database;

    public CottonGinneryViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final FCDCottonGinneryInspection fcdCottonGinneryInspection) {
        new CottonGinneryViewModel.addAsyncTask(database).execute(fcdCottonGinneryInspection);
    }

    public Total countCottonGinnery() {
        return database.cottonGinneryInspectionDao().getCottonGinneryInspectionCount();
    }

    public LiveData<List<FCDCottonGinneryInspection>> getUnsyncedData(boolean state) {
        return database.cottonGinneryInspectionDao().fetchUnsyncedData(state);
    }

    public LiveData<List<FCDCottonGinneryInspection>> getAllCottonGinneries() {
        return database.cottonGinneryInspectionDao().getAllCottonGinneryInspection();
    }

    public void updateCottonGinneryRecord(final CottonGinneryStatus cottonGinneryStatus) {
        new CottonGinneryViewModel.updateCottonGinneryStatusAsyncTask(database).execute(cottonGinneryStatus);
    }


    static class addAsyncTask extends AsyncTask<FCDCottonGinneryInspection, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FCDCottonGinneryInspection... params) {
            db.cottonGinneryInspectionDao().addCottonGinneryInspection(params[0]);
            return null;
        }

    }

    private static class updateCottonGinneryStatusAsyncTask extends AsyncTask<CottonGinneryStatus, Void, Void> {

        private Database db;

        updateCottonGinneryStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CottonGinneryStatus... params) {
            db.cottonGinneryInspectionDao().updateCottonGinneryInspectionSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getCottonGinnery_id());
            return null;
        }
    }
}