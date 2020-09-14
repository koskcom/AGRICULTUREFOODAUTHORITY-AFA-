package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.HorticultureProduceTransportation;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.HorticulturalProduceTransportationStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class HorticulturalProduceTransportationViewModel extends AndroidViewModel {

    private Database database;

    public HorticulturalProduceTransportationViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final HorticultureProduceTransportation horticultureProduceTransportation) {
        new HorticulturalProduceTransportationViewModel.addAsyncTask(database).execute(horticultureProduceTransportation);
    }

    public Total countHorticultureProduceTransportation() {
        return database.horticulturalProduceTransportationDao().getHorticultureProduceTransportationCount();
    }

    public LiveData<List<HorticultureProduceTransportation>> getUnsyncedData(boolean state) {
        return database.horticulturalProduceTransportationDao().fetchUnsyncedData(state);
    }

    public LiveData<List<HorticultureProduceTransportation>> getAllHorticultureProduceTransportation() {
        return database.horticulturalProduceTransportationDao().getAllHorticultureProduceTransportation();
    }

    public void updateHorticultureProduceTransportationRecord(final HorticulturalProduceTransportationStatus horticulturalProduceTransportationStatus) {
        new HorticulturalProduceTransportationViewModel.updateHorticulturalProduceTransportationStatusAsyncTask(database).execute(horticulturalProduceTransportationStatus);
    }


    static class addAsyncTask extends AsyncTask<HorticultureProduceTransportation, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HorticultureProduceTransportation... params) {
            db.horticulturalProduceTransportationDao().addHorticultureProduceTransportation(params[0]);
            return null;
        }

    }

    private static class updateHorticulturalProduceTransportationStatusAsyncTask extends AsyncTask<HorticulturalProduceTransportationStatus, Void, Void> {

        private Database db;

        updateHorticulturalProduceTransportationStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HorticulturalProduceTransportationStatus... params) {
            db.horticulturalProduceTransportationDao().updateHorticultureProduceTransportationSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getHorticulturalProduceTransportation_id());
            return null;
        }
    }
}