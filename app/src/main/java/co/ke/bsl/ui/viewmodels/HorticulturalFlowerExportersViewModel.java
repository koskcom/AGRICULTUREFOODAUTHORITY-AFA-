package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.HorticulturalFlowerExportersDeskVetting;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.HorticulturalFlowerExportersStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class HorticulturalFlowerExportersViewModel extends AndroidViewModel {

    private Database database;

    public HorticulturalFlowerExportersViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final HorticulturalFlowerExportersDeskVetting horticulturalFlowerExportersDeskVetting) {
        new HorticulturalFlowerExportersViewModel.addAsyncTask(database).execute(horticulturalFlowerExportersDeskVetting);
    }

    public Total countHorticulturalFlowerExporters() {
        return database.horticulturalFlowerExportersDeskVettingDao().getHorticulturalFlowerExportersDeskVettingCount();
    }

    public LiveData<List<HorticulturalFlowerExportersDeskVetting>> getUnsyncedData(boolean state) {
        return database.horticulturalFlowerExportersDeskVettingDao().fetchUnsyncedData(state);
    }

    public LiveData<List<HorticulturalFlowerExportersDeskVetting>> getAllHorticulturalFlowerExporters() {
        return database.horticulturalFlowerExportersDeskVettingDao().getAllHorticulturalFlowerExportersDeskVetting();
    }

    public void updateHorticulturalFlowerExportersRecord(final HorticulturalFlowerExportersStatus horticulturalFlowerExportersStatus) {
        new HorticulturalFlowerExportersViewModel.updateHorticulturalFlowerExportersStatusAsyncTask(database).execute(horticulturalFlowerExportersStatus);
    }


    static class addAsyncTask extends AsyncTask<HorticulturalFlowerExportersDeskVetting, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HorticulturalFlowerExportersDeskVetting... params) {
            db.horticulturalFlowerExportersDeskVettingDao().addHorticulturalFlowerExportersDeskVetting(params[0]);
            return null;
        }

    }

    private static class updateHorticulturalFlowerExportersStatusAsyncTask extends AsyncTask<HorticulturalFlowerExportersStatus, Void, Void> {

        private Database db;

        updateHorticulturalFlowerExportersStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HorticulturalFlowerExportersStatus... params) {
            db.horticulturalFlowerExportersDeskVettingDao().updateHorticulturalFlowerExportersDeskVettingSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getHorticulturalFlowerExporters_id());
            return null;
        }
    }
}