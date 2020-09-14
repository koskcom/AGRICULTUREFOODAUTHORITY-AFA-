package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.HCDNurseryInspection;
import co.ke.bsl.data.view.HorticultureNurseryInspectionStatus;
import co.ke.bsl.data.view.Total;

public class HorticultureNurseryViewModel extends AndroidViewModel {

    private Database database;

    public HorticultureNurseryViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final HCDNurseryInspection hcdNurseryInspection) {
        new HorticultureNurseryViewModel.addAsyncTask(database).execute(hcdNurseryInspection);
    }

    public Total countHorticultureNurseryInspection() {
        return database.horticultureNurseryInspectionDao().getHorticultureNurseryInspectionCount();
    }

    public LiveData<List<HCDNurseryInspection>> getUnsyncedData(boolean state) {
        return database.horticultureNurseryInspectionDao().fetchUnsyncedData(state);
    }

    public LiveData<List<HCDNurseryInspection>> getAllHorticultureNurseryInspection() {
        return database.horticultureNurseryInspectionDao().getAllHorticultureNurseryInspection();
    }

    public void updateHorticultureNurseryInspectionRecord(final HorticultureNurseryInspectionStatus hcdNurseryInspectionStatus) {
        new updateHorticultureNurseryInspectionStatusAsyncTask(database).execute(hcdNurseryInspectionStatus);
    }


    static class addAsyncTask extends AsyncTask<HCDNurseryInspection, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HCDNurseryInspection... params) {
            db.horticultureNurseryInspectionDao().addHorticultureNurseryInspection(params[0]);
            return null;
        }

    }

    private static class updateHorticultureNurseryInspectionStatusAsyncTask extends AsyncTask<HorticultureNurseryInspectionStatus, Void, Void> {

        private Database db;

        updateHorticultureNurseryInspectionStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HorticultureNurseryInspectionStatus... params) {
            db.horticultureNurseryInspectionDao().updateHorticultureNurseryInspectionSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getHorticultureNurseryInspection_id());
            return null;
        }
    }
}