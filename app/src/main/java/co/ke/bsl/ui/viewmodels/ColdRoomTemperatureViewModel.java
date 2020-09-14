package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.HCDColdRoomTemperatures;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.ColdRoomTemperatureStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class ColdRoomTemperatureViewModel extends AndroidViewModel {

    private Database database;

    public ColdRoomTemperatureViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final HCDColdRoomTemperatures hcdColdRoomTemperatures) {
        new ColdRoomTemperatureViewModel.addAsyncTask(database).execute(hcdColdRoomTemperatures);
    }

    public Total countColdRoomTemperatures() {
        return database.coldRoomTemperatureDao().getColdRoomTemperatureCount();
    }

    public LiveData<List<HCDColdRoomTemperatures>> getUnsyncedData(boolean state) {
        return database.coldRoomTemperatureDao().fetchUnsyncedData(state);
    }

    public LiveData<List<HCDColdRoomTemperatures>> getAllColdRoomTemperatures() {
        return database.coldRoomTemperatureDao().getAllColdRoomTemperatures();
    }

    public void updateColdRoomTemperatureRecord(final ColdRoomTemperatureStatus coldRoomTemperatureStatus) {
        new ColdRoomTemperatureViewModel.updateColdRoomTemperatureStatusAsyncTask(database).execute(coldRoomTemperatureStatus);
    }


    static class addAsyncTask extends AsyncTask<HCDColdRoomTemperatures, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HCDColdRoomTemperatures... params) {
            db.coldRoomTemperatureDao().addColdRoomTemperature(params[0]);
            return null;
        }

    }

    private static class updateColdRoomTemperatureStatusAsyncTask extends AsyncTask<ColdRoomTemperatureStatus, Void, Void> {

        private Database db;

        updateColdRoomTemperatureStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final ColdRoomTemperatureStatus... params) {
            db.coldRoomTemperatureDao().updateColdRoomTemperatureSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getColdRoomTemperature_id());
            return null;
        }
    }
}