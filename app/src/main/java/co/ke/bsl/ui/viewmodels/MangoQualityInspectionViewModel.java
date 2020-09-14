package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.HCDMangoQualityInspection;
import co.ke.bsl.data.view.MangoQualityInspectionStatus;
import co.ke.bsl.data.view.Total;

public class MangoQualityInspectionViewModel extends AndroidViewModel {

    private Database database;

    public MangoQualityInspectionViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final HCDMangoQualityInspection hcdMangoQualityInspection) {
        new MangoQualityInspectionViewModel.addAsyncTask(database).execute(hcdMangoQualityInspection);
    }

    public Total countMangoQualityInspection() {
        return database.mangoQualityInspectionDao().getMangoQualityInspectionCount();
    }

    public LiveData<List<HCDMangoQualityInspection>> getUnsyncedData(boolean state) {
        return database.mangoQualityInspectionDao().fetchUnsyncedData(state);
    }

    public LiveData<List<HCDMangoQualityInspection>> getAllMangoQualityInspection() {
        return database.mangoQualityInspectionDao().getAllMangoQualityInspections();
    }

    public void updateMangoQualityInspectionRecord(final MangoQualityInspectionStatus mangoQualityInspectionStatus) {
        new MangoQualityInspectionViewModel.updateMangoQualityInspectionStatusAsyncTask(database).execute(mangoQualityInspectionStatus);
    }


    static class addAsyncTask extends AsyncTask<HCDMangoQualityInspection, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HCDMangoQualityInspection... params) {
            db.mangoQualityInspectionDao().addMangoQualityInspection(params[0]);
            return null;
        }

    }

    private static class updateMangoQualityInspectionStatusAsyncTask extends AsyncTask<MangoQualityInspectionStatus, Void, Void> {

        private Database db;

        updateMangoQualityInspectionStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final MangoQualityInspectionStatus... params) {
            db.mangoQualityInspectionDao().updateMangoQualityInspectionSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getMangoQualityInspection_id());
            return null;
        }
    }
}