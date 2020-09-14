package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.FCDSisalFactoryInspection;
import co.ke.bsl.data.model.FCDSisalSpinningFactoryInspection;
import co.ke.bsl.data.view.SisalFactoryStatus;
import co.ke.bsl.data.view.SisalSpiningStatus;
import co.ke.bsl.data.view.Total;

public class SisalSpinningInspViewModel extends AndroidViewModel {

    private Database database;

    public SisalSpinningInspViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final FCDSisalSpinningFactoryInspection fCDSisalSpinningFactoryInspection) {
        new SisalSpinningInspViewModel.addAsyncTask(database).execute(fCDSisalSpinningFactoryInspection);
    }

    public Total countFCDSisalSpinningFactoryInspection() {
        return database.sisalSpinninginspectionDao().getFCDSisalSpinningFactoryInspectionCount();
    }

    public LiveData<List<FCDSisalSpinningFactoryInspection>> getUnsyncedData(boolean state) {
        return database.sisalSpinninginspectionDao().fetchUnsyncedData(state);
    }

    public LiveData<List<FCDSisalSpinningFactoryInspection>> getAllSisalSisalSpinningFactoryInspection() {
        return database.sisalSpinninginspectionDao().getAllFCDSisalSpinningFactoryInspections();
    }

    public void updategetAllFCDSisalSpinningFactoryInspectionRecord(final SisalSpiningStatus sisalSpiningStatus) {
        new SisalSpinningInspViewModel.updateSisalFactoryInspectionStatusAsyncTask(database).execute(sisalSpiningStatus);
    }


    static class addAsyncTask extends AsyncTask<FCDSisalSpinningFactoryInspection, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FCDSisalSpinningFactoryInspection... params) {
            db.sisalSpinninginspectionDao().addFCDSisalSpinningFactoryInspection(params[0]);
            return null;
        }

    }

    private static class updateSisalFactoryInspectionStatusAsyncTask extends AsyncTask<SisalSpiningStatus, Void, Void> {

        private Database db;

        updateSisalFactoryInspectionStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final SisalSpiningStatus... params) {
            db.sisalSpinninginspectionDao().updateFCDSisalSpinningFactoryInspectionSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getSisal_spining_id());
            return null;
        }
    }
}
