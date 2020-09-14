package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.FCDSisalFactoryInspection;
import co.ke.bsl.data.view.SisalFactoryStatus;
import co.ke.bsl.data.view.Total;

public class SisalFactoryViewModel extends AndroidViewModel {

    private Database database;

    public SisalFactoryViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final FCDSisalFactoryInspection fcdSisalFactoryInspection) {
        new SisalFactoryViewModel.addAsyncTask(database).execute(fcdSisalFactoryInspection);
    }

    public Total countSisalFactoryInspections() {
        return database.sisalFactoryInspectionDao().getSisalFactoryInspectionCount();
    }

    public LiveData<List<FCDSisalFactoryInspection>> getUnsyncedData(boolean state) {
        return database.sisalFactoryInspectionDao().fetchUnsyncedData(state);
    }

    public LiveData<List<FCDSisalFactoryInspection>> getAllSisalFactoryInspections() {
        return database.sisalFactoryInspectionDao().getAllSisalFactoryInspections();
    }

    public void updateSisalFactoryInspectionRecord(final SisalFactoryStatus sisalFactoryStatus) {
        new SisalFactoryViewModel.updateSisalFactoryInspectionStatusAsyncTask(database).execute(sisalFactoryStatus);
    }


    static class addAsyncTask extends AsyncTask<FCDSisalFactoryInspection, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FCDSisalFactoryInspection... params) {
            db.sisalFactoryInspectionDao().addSisalFactoryInspection(params[0]);
            return null;
        }

    }

    private static class updateSisalFactoryInspectionStatusAsyncTask extends AsyncTask<SisalFactoryStatus, Void, Void> {

        private Database db;

        updateSisalFactoryInspectionStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final SisalFactoryStatus... params) {
            db.sisalFactoryInspectionDao().updateSisalFactoryInspectionSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getSisalFactory_id());
            return null;
        }
    }
}