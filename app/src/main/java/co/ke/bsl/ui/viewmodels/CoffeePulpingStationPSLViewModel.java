package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.CoffeePulpingStationPSL;
import co.ke.bsl.data.model.PulpingStationLicenseApplication;
import co.ke.bsl.data.view.PulpingStationATEStatus;
import co.ke.bsl.data.view.PulpingStationPSLStatus;
import co.ke.bsl.data.view.Total;

public class CoffeePulpingStationPSLViewModel extends AndroidViewModel {

    private Database database;

    public CoffeePulpingStationPSLViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final CoffeePulpingStationPSL coffeePulpingStationPSL) {
        new CoffeePulpingStationPSLViewModel.addAsyncTask(database).execute(coffeePulpingStationPSL);
    }

    public Total countCoffeePulpingStationPSL() {
        return database.coffeePulpingStationPSLDao().getCoffeePulpingStationPSLCount();
    }

    public LiveData<List<CoffeePulpingStationPSL>> getUnsyncedData(boolean state) {
        return database.coffeePulpingStationPSLDao().fetchUnsyncedData(state);
    }

    public LiveData<List<CoffeePulpingStationPSL>> getAllCoffeePulpingStationPSL() {
        return database.coffeePulpingStationPSLDao().getAllCoffeePulpingStationPSL();
    }

    public void updateCoffeePulpingStationPSLRecord(final PulpingStationPSLStatus pulpingStationPSLStatus) {
        new CoffeePulpingStationPSLViewModel.updateCoffeePulpingStationPSLStatusAsyncTask(database).execute(pulpingStationPSLStatus);
    }


    static class addAsyncTask extends AsyncTask<CoffeePulpingStationPSL, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CoffeePulpingStationPSL... params) {
            db.coffeePulpingStationPSLDao().addCoffeePulpingStationPSL(params[0]);
            return null;
        }

    }

    private static class updateCoffeePulpingStationPSLStatusAsyncTask extends AsyncTask<PulpingStationPSLStatus, Void, Void> {

        private Database db;

        updateCoffeePulpingStationPSLStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final PulpingStationPSLStatus... params) {
            db.coffeePulpingStationPSLDao().updateCoffeePulpingStationPSLSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getPulpingStationPsl_id());
            return null;
        }
    }
}