package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.PyrethrumInspection;
import co.ke.bsl.data.view.PyrethrumInspectionStatus;
import co.ke.bsl.data.view.Total;

public class PyrethrumInspectionViewModel extends AndroidViewModel {

    private Database database;

    public PyrethrumInspectionViewModel( Application application) {
        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addPyrethrumInspectionRecord(final PyrethrumInspection pyrethrumInspection) {
        new PyrethrumInspectionViewModel.addAsyncTask(database).execute(pyrethrumInspection);
    }

    public Total countPyrethrumInspection() {
        return database.pyrethrumInspectionDao().getPyrethrumInspectionCount();
    }


    public LiveData<List<PyrethrumInspection>> getAllPyrethrumInspection() {
        return database.pyrethrumInspectionDao().getAllPyrethrumInspections();
    }

    public void updatePyrethrumInspectionRecord(final PyrethrumInspectionStatus pyrethrumInspectionStatus) {
        new PyrethrumInspectionViewModel.updatePyrethrumInspectionStatusAsyncTask(database).execute(pyrethrumInspectionStatus);
    }



    static class addAsyncTask extends AsyncTask<PyrethrumInspection, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final PyrethrumInspection... params) {
            db.pyrethrumInspectionDao().addPyrethrumInspection(params[0]);
            return null;
        }

    }

    private static class updatePyrethrumInspectionStatusAsyncTask extends AsyncTask<PyrethrumInspectionStatus, Void, Void> {

        private Database db;

        updatePyrethrumInspectionStatusAsyncTask(Database database) {
            db = database;
        }


        @Override
        protected Void doInBackground(PyrethrumInspectionStatus... params) {
            db.pyrethrumInspectionDao().updatePyrethrumInspectionSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getPyrethrumInspectionStatus_id());
            return null;
        }
    }
}
