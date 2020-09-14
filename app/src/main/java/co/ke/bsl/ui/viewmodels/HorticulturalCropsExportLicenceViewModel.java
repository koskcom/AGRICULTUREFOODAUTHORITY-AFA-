package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.HorticultureCropExportLicenceFarmInspection;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.HorticulturalCropsExportLicenceStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class HorticulturalCropsExportLicenceViewModel extends AndroidViewModel {

    private Database database;

    public HorticulturalCropsExportLicenceViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final HorticultureCropExportLicenceFarmInspection horticultureCropExportLicenceFarmInspection) {
        new HorticulturalCropsExportLicenceViewModel.addAsyncTask(database).execute(horticultureCropExportLicenceFarmInspection);
    }

    public Total countHorticultureCropExportLicence() {
        return database.horticultureCropExportLicenceDao().getHorticultureCropExportLicenceFarmInspectionCount();
    }

    public LiveData<List<HorticultureCropExportLicenceFarmInspection>> getUnsyncedData(boolean state) {
        return database.horticultureCropExportLicenceDao().fetchUnsyncedData(state);
    }

    public LiveData<List<HorticultureCropExportLicenceFarmInspection>> getAllHorticultureCropExportLicence() {
        return database.horticultureCropExportLicenceDao().getAllHorticultureCropExportLicenceFarmInspection();
    }

    public void updateHorticultureCropExportLicenceRecord(final HorticulturalCropsExportLicenceStatus horticulturalCropsExportLicenceStatus) {
        new HorticulturalCropsExportLicenceViewModel.updateHorticultureCropExportLicenceStatusAsyncTask(database).execute(horticulturalCropsExportLicenceStatus);
    }


    static class addAsyncTask extends AsyncTask<HorticultureCropExportLicenceFarmInspection, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HorticultureCropExportLicenceFarmInspection... params) {
            db.horticultureCropExportLicenceDao().addHorticultureCropExportLicenceFarmInspection(params[0]);
            return null;
        }

    }

    private static class updateHorticultureCropExportLicenceStatusAsyncTask extends AsyncTask<HorticulturalCropsExportLicenceStatus, Void, Void> {

        private Database db;

        updateHorticultureCropExportLicenceStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HorticulturalCropsExportLicenceStatus... params) {
            db.horticultureCropExportLicenceDao().updateHorticultureCropExportLicenceFarmInspectionSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getHorticulturalCropsExportLicence_id());
            return null;
        }
    }
}