package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.HCDPersonalHygene;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.PersonalHygieneStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class PersonalHygieneViewModel extends AndroidViewModel {

    private Database database;

    public PersonalHygieneViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final HCDPersonalHygene hcdPersonalHygene) {
        new PersonalHygieneViewModel.addAsyncTask(database).execute(hcdPersonalHygene);
    }

    public Total countPersonalHygene() {
        return database.personalHygieneDao().getPersonalHygeneCount();
    }

    public LiveData<List<HCDPersonalHygene>> getUnsyncedData(boolean state) {
        return database.personalHygieneDao().fetchUnsyncedData(state);
    }

    public LiveData<List<HCDPersonalHygene>> getAllPersonalHygene() {
        return database.personalHygieneDao().getAllPersonalHygene();
    }

    public void updatePersonalHygeneRecord(final PersonalHygieneStatus personalHygieneStatus) {
        new PersonalHygieneViewModel.updatePersonalHygeneStatusAsyncTask(database).execute(personalHygieneStatus);
    }


    static class addAsyncTask extends AsyncTask<HCDPersonalHygene, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HCDPersonalHygene... params) {
            db.personalHygieneDao().addPersonalHygene(params[0]);
            return null;
        }

    }

    private static class updatePersonalHygeneStatusAsyncTask extends AsyncTask<PersonalHygieneStatus, Void, Void> {

        private Database db;

        updatePersonalHygeneStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final PersonalHygieneStatus... params) {
            db.personalHygieneDao().updatePersonalHygeneSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getPersonalHygiene_id());
            return null;
        }
    }
}