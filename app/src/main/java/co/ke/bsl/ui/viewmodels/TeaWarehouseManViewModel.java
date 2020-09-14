package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.model.TeaWarehouseManInspection;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.TeaWarehouseManStatus;
import co.ke.bsl.data.view.Total;

public class TeaWarehouseManViewModel extends AndroidViewModel {

    private Database database;

    public TeaWarehouseManViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final TeaWarehouseManInspection teaWarehouseManInspection) {
        new TeaWarehouseManViewModel.addAsyncTask(database).execute(teaWarehouseManInspection);
    }

    public Total countTeaWarehouseMan() {
        return database.teaWarehouseManDao().getTeaWarehouseManCount();
    }

    public LiveData<List<TeaWarehouseManInspection>> getUnsyncedData(boolean state) {
        return database.teaWarehouseManDao().fetchUnsyncedData(state);
    }

    public LiveData<List<TeaWarehouseManInspection>> getAllTeaWarehouseMan() {
        return database.teaWarehouseManDao().getAllTeaWarehouseMan();
    }

    public void updateTeaWarehouseManRecord(final TeaWarehouseManStatus teaWarehouseManStatus) {
        new TeaWarehouseManViewModel.updateTeaWarehouseManStatusAsyncTask(database).execute(teaWarehouseManStatus);
    }


    static class addAsyncTask extends AsyncTask<TeaWarehouseManInspection, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final TeaWarehouseManInspection... params) {
            db.teaWarehouseManDao().addTeaWarehouseMan(params[0]);
            return null;
        }

    }

    private static class updateTeaWarehouseManStatusAsyncTask extends AsyncTask<TeaWarehouseManStatus, Void, Void> {

        private Database db;

        updateTeaWarehouseManStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final TeaWarehouseManStatus... params) {
            db.teaWarehouseManDao().updateTeaWarehouseManSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getTeaWarehouseMan_id());
            return null;
        }
    }
}