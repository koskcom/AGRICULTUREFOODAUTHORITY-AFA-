package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.CaneCensus;
import co.ke.bsl.data.model.ClientInfo;
import co.ke.bsl.data.view.CaneCensusStatus;
import co.ke.bsl.data.view.ClientStatus;
import co.ke.bsl.data.view.Total;

public class CaneCensusRecordViewModel extends AndroidViewModel {

    private Database database;

    public CaneCensusRecordViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final CaneCensus caneCensus) {
        new CaneCensusRecordViewModel.addAsyncTask(database).execute(caneCensus);
    }

    public Total countCaneCensus() {
        return database.caneCensusDao().getCaneCensusCount();
    }

    public LiveData<List<ClientInfo>> getUnsyncedData(boolean state) {
        return database.clientDao().fetchUnsyncedData(state);
    }

    public LiveData<List<CaneCensus>> getAllCaneCensus() {
        return database.caneCensusDao().getAllCaneCensus();
    }

    public void updateCaneCensusRecord(final CaneCensusStatus caneCensusStatus) {
        new CaneCensusRecordViewModel.updateCaneCensusStatusAsyncTask(database).execute(caneCensusStatus);
    }



    static class addAsyncTask extends AsyncTask<CaneCensus, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CaneCensus... params) {
            db.caneCensusDao().addCaneCensus(params[0]);
            return null;
        }

    }

    private static class updateCaneCensusStatusAsyncTask extends AsyncTask<CaneCensusStatus, Void, Void> {

        private Database db;

        updateCaneCensusStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CaneCensusStatus... params) {
            db.clientDao().updateClientSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getCanecensus_id());
            return null;
        }
    }
}
