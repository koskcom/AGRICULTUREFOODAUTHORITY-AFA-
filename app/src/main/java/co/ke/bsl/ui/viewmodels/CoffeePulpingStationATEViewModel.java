package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.PulpingStationLicenseApplication;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.PulpingStationATEStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class CoffeePulpingStationATEViewModel extends AndroidViewModel {

    private Database database;

    public CoffeePulpingStationATEViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final PulpingStationLicenseApplication pulpingStationLicenseApplication) {
        new CoffeePulpingStationATEViewModel.addAsyncTask(database).execute(pulpingStationLicenseApplication);
    }

    public Total countCoffeePulpingStationATE() {
        return database.coffeePulpingStationATEDao().getCoffeePulpingStationATECount();
    }

    public LiveData<List<PulpingStationLicenseApplication>> getUnsyncedData(boolean state) {
        return database.coffeePulpingStationATEDao().fetchUnsyncedData(state);
    }

    public LiveData<List<PulpingStationLicenseApplication>> getAllCoffeePulpingStationATE() {
        return database.coffeePulpingStationATEDao().getAllCoffeePulpingStationATE();
    }

    public void updateCoffeePulpingStationATERecord(final PulpingStationATEStatus pulpingStationATEStatus) {
        new CoffeePulpingStationATEViewModel.updateCoffeePulpingStationATEStatusAsyncTask(database).execute(pulpingStationATEStatus);
    }


    static class addAsyncTask extends AsyncTask<PulpingStationLicenseApplication, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final PulpingStationLicenseApplication... params) {
            db.coffeePulpingStationATEDao().addCoffeePulpingStationATE(params[0]);
            return null;
        }

    }

    private static class updateCoffeePulpingStationATEStatusAsyncTask extends AsyncTask<PulpingStationATEStatus, Void, Void> {

        private Database db;

        updateCoffeePulpingStationATEStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final PulpingStationATEStatus... params) {
            db.coffeePulpingStationATEDao().updateCoffeePulpingStationATESyncState(params[0].isState(), params[0].getRemote_id(), params[0].getPulpingStationAte_id());
            return null;
        }
    }
}