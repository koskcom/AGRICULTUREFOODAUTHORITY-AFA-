package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.FCDCottonLintClassingReport;
import co.ke.bsl.data.model.FCDCottonLintClassingReport;
import co.ke.bsl.data.view.CottonLintStatus;
import co.ke.bsl.data.view.Total;

public class CottonLintViewModel extends AndroidViewModel {

    private Database database;

    public CottonLintViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final FCDCottonLintClassingReport fcdCottonLintClassingReport) {
        new CottonLintViewModel.addAsyncTask(database).execute(fcdCottonLintClassingReport);
    }

    public Total countCottonLint() {
        return database.cottonLintClassingReportDao().getCottonLintClassingReportCount();
    }

    public LiveData<List<FCDCottonLintClassingReport>> getUnsyncedData(boolean state) {
        return database.cottonLintClassingReportDao().fetchUnsyncedData(state);
    }

    public LiveData<List<FCDCottonLintClassingReport>> getAllCottonLints() {
        return database.cottonLintClassingReportDao().getAllCottonLintClassingReport();
    }

    public void updateCottonLintRecord(final CottonLintStatus cottonLintStatus) {
        new CottonLintViewModel.updateCottonLintStatusAsyncTask(database).execute(cottonLintStatus);
    }


    static class addAsyncTask extends AsyncTask<FCDCottonLintClassingReport, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FCDCottonLintClassingReport... params) {
            db.cottonLintClassingReportDao().addCottonLintClassingReport(params[0]);
            return null;
        }

    }

    private static class updateCottonLintStatusAsyncTask extends AsyncTask<CottonLintStatus, Void, Void> {

        private Database db;

        updateCottonLintStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CottonLintStatus... params) {
            db.cottonLintClassingReportDao().updateCottonLintClassingReportSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getCottonLint_id());
            return null;
        }
    }
}