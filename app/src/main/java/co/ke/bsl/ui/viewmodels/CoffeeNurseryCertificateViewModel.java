package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.CoffeeNurseryCert;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.CoffeeNurseryInspectionStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class CoffeeNurseryCertificateViewModel extends AndroidViewModel {

    private Database database;

    public CoffeeNurseryCertificateViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final CoffeeNurseryCert coffeeNurseryCert) {
        new CoffeeNurseryCertificateViewModel.addAsyncTask(database).execute(coffeeNurseryCert);
    }

    public Total countCoffeeNursery() {
        return database.coffeeNurseryCertificateInspectionDao().getCoffeeNurseryCount();
    }

    public LiveData<List<CoffeeNurseryCert>> getUnsyncedData(boolean state) {
        return database.coffeeNurseryCertificateInspectionDao().fetchUnsyncedData(state);
    }

    public LiveData<List<CoffeeNurseryCert>> getAllCoffeeNurseries() {
        return database.coffeeNurseryCertificateInspectionDao().getAllCoffeeNurseries();
    }

    public void updateCoffeeNurseryRecord(final CoffeeNurseryInspectionStatus coffeeNurseryInspectionStatus) {
        new CoffeeNurseryCertificateViewModel.updateCoffeeNurseryStatusAsyncTask(database).execute(coffeeNurseryInspectionStatus);
    }


    static class addAsyncTask extends AsyncTask<CoffeeNurseryCert, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CoffeeNurseryCert... params) {
            db.coffeeNurseryCertificateInspectionDao().addCoffeeNursery(params[0]);
            return null;
        }

    }

    private static class updateCoffeeNurseryStatusAsyncTask extends AsyncTask<CoffeeNurseryInspectionStatus, Void, Void> {

        private Database db;

        updateCoffeeNurseryStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CoffeeNurseryInspectionStatus... params) {
            db.coffeeNurseryCertificateInspectionDao().updateCoffeeNurserySyncState(params[0].isState(), params[0].getRemote_id(), params[0].getCoffeeNurseryInspection_id());
            return null;
        }
    }
}