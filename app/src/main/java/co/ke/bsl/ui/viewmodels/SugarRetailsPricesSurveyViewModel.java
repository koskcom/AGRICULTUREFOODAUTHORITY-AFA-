package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.ClientInfo;
import co.ke.bsl.data.model.SugarRetailPricesSurvey;
import co.ke.bsl.data.view.SugarRetailPricesSurveyStatus;
import co.ke.bsl.data.view.Total;

public class SugarRetailsPricesSurveyViewModel extends AndroidViewModel
{

    private Database database;

    public SugarRetailsPricesSurveyViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final SugarRetailPricesSurvey sugarRetailPricesSurvey)
    {
        new SugarRetailsPricesSurveyViewModel.addAsyncTask(database).execute(sugarRetailPricesSurvey);
    }

    public Total countSugarRetailPricesSurvey() {
        return database.retailsPricesSurveyDao().getSugarRetailPricesSurveyCount();
    }


    public LiveData<List<ClientInfo>> getUnsyncedData(boolean state) {
        return database.clientDao().fetchUnsyncedData(state);
    }

    public LiveData<List<SugarRetailPricesSurvey>> getAllSugarRetailPricesSurvey() {
        return database.retailsPricesSurveyDao().getAllSugarRetailPricesSurvey();
    }


    public void updateCaneCensusRecord(final SugarRetailPricesSurveyStatus sugarRetailPricesSurveyStatus) {
        new SugarRetailsPricesSurveyViewModel.updateSugarRetailPricesSurveyStatusAsyncTask(database).execute(sugarRetailPricesSurveyStatus);
    }



    static class addAsyncTask extends AsyncTask<SugarRetailPricesSurvey, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final SugarRetailPricesSurvey... params) {
            db.retailsPricesSurveyDao().addSugarRetailPricesSurvey(params[0]);
            return null;
        }

    }

    private static class updateSugarRetailPricesSurveyStatusAsyncTask extends AsyncTask<SugarRetailPricesSurveyStatus, Void, Void> {

        private Database db;

        updateSugarRetailPricesSurveyStatusAsyncTask(Database database) {
            db = database;
        }


        @Override
        protected Void doInBackground(SugarRetailPricesSurveyStatus... params) {
            db.retailsPricesSurveyDao().updateSugarRetailPricesSurveySyncState(params[0].isState(), params[0].getRemote_id(), params[0].getRetails_prices_survey_id());
            return null;
        }
    }
}
