package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.FruitsVegetablesExportersDeskVetting;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.FruitsAndVegetablesExportersStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class FruitsAndVegetablesExportersViewModel extends AndroidViewModel {

    private Database database;

    public FruitsAndVegetablesExportersViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final FruitsVegetablesExportersDeskVetting fruitsVegetablesExportersDeskVetting) {
        new FruitsAndVegetablesExportersViewModel.addAsyncTask(database).execute(fruitsVegetablesExportersDeskVetting);
    }

    public Total countFruitsVegetablesExporters() {
        return database.fruitsAndVegetablesExportersDeskVettingDao().getFruitsVegetablesExportersCount();
    }

    public LiveData<List<FruitsVegetablesExportersDeskVetting>> getUnsyncedData(boolean state) {
        return database.fruitsAndVegetablesExportersDeskVettingDao().fetchUnsyncedData(state);
    }

    public LiveData<List<FruitsVegetablesExportersDeskVetting>> getAllFruitsVegetablesExporters() {
        return database.fruitsAndVegetablesExportersDeskVettingDao().getAllFruitsVegetablesExporters();
    }

    public void updateFruitsVegetablesExportersRecord(final FruitsAndVegetablesExportersStatus fruitsAndVegetablesExportersStatus) {
        new FruitsAndVegetablesExportersViewModel.updateFruitsVegetablesExportersStatusAsyncTask(database).execute(fruitsAndVegetablesExportersStatus);
    }


    static class addAsyncTask extends AsyncTask<FruitsVegetablesExportersDeskVetting, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FruitsVegetablesExportersDeskVetting... params) {
            db.fruitsAndVegetablesExportersDeskVettingDao().addFruitsVegetablesExporters(params[0]);
            return null;
        }

    }

    private static class updateFruitsVegetablesExportersStatusAsyncTask extends AsyncTask<FruitsAndVegetablesExportersStatus, Void, Void> {

        private Database db;

        updateFruitsVegetablesExportersStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FruitsAndVegetablesExportersStatus... params) {
            db.fruitsAndVegetablesExportersDeskVettingDao().updateFruitsVegetablesExportersSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getFruitsAndVegetablesExporters_id());
            return null;
        }
    }
}