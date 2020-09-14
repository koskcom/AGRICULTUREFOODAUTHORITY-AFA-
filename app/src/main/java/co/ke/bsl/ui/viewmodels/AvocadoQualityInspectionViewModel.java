package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.HCDAvocadoQualityInspection;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.AvocadoQualityInspectionStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class AvocadoQualityInspectionViewModel extends AndroidViewModel {

    private Database database;

    public AvocadoQualityInspectionViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final HCDAvocadoQualityInspection hcdAvocadoQualityInspection) {
        new AvocadoQualityInspectionViewModel.addAsyncTask(database).execute(hcdAvocadoQualityInspection);
    }

    public Total countAvocadoQualityInspection() {
        return database.avocadoQualityInspectionDao().getAvocadoQualityInspectionCount();
    }

    public LiveData<List<HCDAvocadoQualityInspection>> getUnsyncedData(boolean state) {
        return database.avocadoQualityInspectionDao().fetchUnsyncedData(state);
    }

    public LiveData<List<HCDAvocadoQualityInspection>> getAllAvocadoQualityInspection() {
        return database.avocadoQualityInspectionDao().getAllAvocadoQualityInspection();
    }

    public void updateAvocadoQualityInspectionRecord(final AvocadoQualityInspectionStatus avocadoQualityInspectionStatus) {
        new AvocadoQualityInspectionViewModel.updateAvocadoQualityInspectionStatusAsyncTask(database).execute(avocadoQualityInspectionStatus);
    }


    static class addAsyncTask extends AsyncTask<HCDAvocadoQualityInspection, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HCDAvocadoQualityInspection... params) {
            db.avocadoQualityInspectionDao().addAvocadoQualityInspection(params[0]);
            return null;
        }

    }

    private static class updateAvocadoQualityInspectionStatusAsyncTask extends AsyncTask<AvocadoQualityInspectionStatus, Void, Void> {

        private Database db;

        updateAvocadoQualityInspectionStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final AvocadoQualityInspectionStatus... params) {
            db.avocadoQualityInspectionDao().updateAvocadoQualityInspectionSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getAvocadoQualityInspection_id());
            return null;
        }
    }
}