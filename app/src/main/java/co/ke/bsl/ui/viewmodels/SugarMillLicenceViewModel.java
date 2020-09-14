package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.ClientInfo;
import co.ke.bsl.data.model.SugarMillLicence;
import co.ke.bsl.data.view.SugarMillLicenceStatus;
import co.ke.bsl.data.view.Total;

public class SugarMillLicenceViewModel extends AndroidViewModel {

    private Database database;

    public SugarMillLicenceViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addSugarMillRecord(final SugarMillLicence sugarMillLicence) {
        new SugarMillLicenceViewModel.addAsyncTask(database).execute(sugarMillLicence);
    }

    public Total countSugarMillLicence() {
        return database.sugarMillLicenceDao().getSugarMillLicenceCount();
    }


    public LiveData<List<SugarMillLicence>> getAllSugarMillLicence() {
        return database.sugarMillLicenceDao().getAllSugarMillLicence();
    }

    public void updateSugarMillLicenceRecord(final SugarMillLicenceStatus sugarMillLicenceStatus) {
        new SugarMillLicenceViewModel.updateSugarMillLicenceStatusAsyncTask(database).execute(sugarMillLicenceStatus);
    }



    static class addAsyncTask extends AsyncTask<SugarMillLicence, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final SugarMillLicence... params) {
            db.sugarMillLicenceDao().addSugarMilllLicence(params[0]);
            return null;
        }

    }

    private static class updateSugarMillLicenceStatusAsyncTask extends AsyncTask<SugarMillLicenceStatus, Void, Void> {

        private Database db;

        updateSugarMillLicenceStatusAsyncTask(Database database) {
            db = database;
        }


        @Override
        protected Void doInBackground(SugarMillLicenceStatus... params) {
            db.sugarMillLicenceDao().updateSugarMillLicenceSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getSugarMillLicenceStatus_id());
            return null;
        }
    }
}
