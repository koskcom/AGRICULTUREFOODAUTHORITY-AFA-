package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.CaneCensus;
import co.ke.bsl.data.model.ClientInfo;
import co.ke.bsl.data.model.SugarWholesalePricesSurvey;
import co.ke.bsl.data.view.CaneCensusStatus;
import co.ke.bsl.data.view.SugarWholesalePricesSurveyStatus;
import co.ke.bsl.data.view.Total;

public class SugarWholesalePricesSurveyViewModel extends AndroidViewModel
{
    private Database database;

    public SugarWholesalePricesSurveyViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final SugarWholesalePricesSurvey sugarWholesalePricesSurvey) {
        new SugarWholesalePricesSurveyViewModel.addAsyncTask(database).execute(sugarWholesalePricesSurvey);
    }

    public Total countSugarWholesalePricesSurvey() {
        return database.wholesalePricesSurveyDao().getSugarPricesSurveyCount();
    }

    public LiveData<List<ClientInfo>> getUnsyncedData(boolean state) {
        return database.clientDao().fetchUnsyncedData(state);
    }

    public LiveData<List<SugarWholesalePricesSurvey>> getAllSugarWholesalePricesSurvey() {
        return database.wholesalePricesSurveyDao().getAllSugarWholesalePricesSurvey();
    }

    public void updateSugarWholesalePricesSurveyRecord(final SugarWholesalePricesSurveyStatus sugarWholesalePricesSurveyStatus) {
        new SugarWholesalePricesSurveyViewModel.updateSugarWholesalePricesSurveyStatusAsyncTask(database).execute(sugarWholesalePricesSurveyStatus);
    }



    static class addAsyncTask extends AsyncTask<SugarWholesalePricesSurvey, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final SugarWholesalePricesSurvey... params) {
            db.wholesalePricesSurveyDao().addSugarPricesSurvey(params[0]);
            return null;
        }

    }

    private static class updateSugarWholesalePricesSurveyStatusAsyncTask extends AsyncTask<SugarWholesalePricesSurveyStatus, Void, Void> {

        private Database db;

        updateSugarWholesalePricesSurveyStatusAsyncTask(Database database) {
            db = database;
        }


        @Override
        protected Void doInBackground(SugarWholesalePricesSurveyStatus... params) {
            db.clientDao().updateClientSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getWholesale_prices_survey_id());
            return null;
        }
    }
}
