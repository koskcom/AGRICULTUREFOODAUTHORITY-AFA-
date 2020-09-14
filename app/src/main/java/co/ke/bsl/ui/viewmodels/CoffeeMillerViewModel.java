package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.CoffeeMillerLicenceApplication;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.CoffeeMillerLicenceStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class CoffeeMillerViewModel extends AndroidViewModel {

    private Database database;

    public CoffeeMillerViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final CoffeeMillerLicenceApplication coffeeMillerLicenceApplication) {
        new CoffeeMillerViewModel.addAsyncTask(database).execute(coffeeMillerLicenceApplication);
    }

    public Total countCoffeeMiller() {
        return database.coffeeMillerLicenceDao().getCoffeeMillerLicenceCount();
    }

    public LiveData<List<CoffeeMillerLicenceApplication>> getUnsyncedData(boolean state) {
        return database.coffeeMillerLicenceDao().fetchUnsyncedData(state);
    }

    public LiveData<List<CoffeeMillerLicenceApplication>> getAllCoffeeMillers() {
        return database.coffeeMillerLicenceDao().getAllCoffeeMillerLicences();
    }

    public void updateCoffeeMillerRecord(final CoffeeMillerLicenceStatus coffeeMillerLicenceStatus) {
        new CoffeeMillerViewModel.updateCoffeeMillerStatusAsyncTask(database).execute(coffeeMillerLicenceStatus);
    }


    static class addAsyncTask extends AsyncTask<CoffeeMillerLicenceApplication, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CoffeeMillerLicenceApplication... params) {
            db.coffeeMillerLicenceDao().addCoffeeMillerLicence(params[0]);
            return null;
        }

    }

    private static class updateCoffeeMillerStatusAsyncTask extends AsyncTask<CoffeeMillerLicenceStatus, Void, Void> {

        private Database db;

        updateCoffeeMillerStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CoffeeMillerLicenceStatus... params) {
            db.coffeeMillerLicenceDao().updateCoffeeMillerLicenceSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getCoffeeMillerLicence_id());
            return null;
        }
    }
}