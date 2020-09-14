package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class TeaPackerViewModel extends AndroidViewModel {

    private Database database;

    public TeaPackerViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final TeaPacker teaPacker) {
        new TeaPackerViewModel.addAsyncTask(database).execute(teaPacker);
    }

    public Total countTeaPacker() {
        return database.teaPackerDao().getTeaPackerCount();
    }

    public LiveData<List<TeaPacker>> getUnsyncedData(boolean state) {
        return database.teaPackerDao().fetchUnsyncedData(state);
    }

    public LiveData<List<TeaPacker>> getAllTeaPacker() {
        return database.teaPackerDao().getAllTeaPacker();
    }

    public void updateTeaPackerRecord(final TeaPackerStatus teaPackerStatus) {
        new TeaPackerViewModel.updateTeaPackerStatusAsyncTask(database).execute(teaPackerStatus);
    }


    static class addAsyncTask extends AsyncTask<TeaPacker, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final TeaPacker... params) {
            db.teaPackerDao().addTeaPacker(params[0]);
            return null;
        }

    }

    private static class updateTeaPackerStatusAsyncTask extends AsyncTask<TeaPackerStatus, Void, Void> {

        private Database db;

        updateTeaPackerStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final TeaPackerStatus... params) {
            db.teaPackerDao().updateTeaPackerSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getTeaPacker_id());
            return null;
        }
    }
}