package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.NOCDMarketPriceSurvey;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.NutsAndOilsStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class NutsAndOilsSurveyViewModel extends AndroidViewModel {

    private Database database;

    public NutsAndOilsSurveyViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final NOCDMarketPriceSurvey nocdMarketPriceSurvey) {
        new NutsAndOilsSurveyViewModel.addAsyncTask(database).execute(nocdMarketPriceSurvey);
    }

    public Total countNutsAndOilsSurvey() {
        return database.nutsAndOilsSurveyDao().getNutsAndOilsSurveyCount();
    }

    public LiveData<List<NOCDMarketPriceSurvey>> getUnsyncedData(boolean state) {
        return database.nutsAndOilsSurveyDao().fetchUnsyncedData(state);
    }

    public LiveData<List<NOCDMarketPriceSurvey>> getAllNutsAndOilsSurveys() {
        return database.nutsAndOilsSurveyDao().getAllNutsAndOilsSurvey();
    }

    public void updateNutsAndOilsSurveyRecord(final NutsAndOilsStatus nutsAndOilsStatus) {
        new NutsAndOilsSurveyViewModel.updateNutsAndOilsSurveyStatusAsyncTask(database).execute(nutsAndOilsStatus);
    }


    static class addAsyncTask extends AsyncTask<NOCDMarketPriceSurvey, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final NOCDMarketPriceSurvey... params) {
            db.nutsAndOilsSurveyDao().addNutsAndOilsSurvey(params[0]);
            return null;
        }

    }

    private static class updateNutsAndOilsSurveyStatusAsyncTask extends AsyncTask<NutsAndOilsStatus, Void, Void> {

        private Database db;

        updateNutsAndOilsSurveyStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final NutsAndOilsStatus... params) {
            db.nutsAndOilsSurveyDao().updateNutsAndOilsSurveySyncState(params[0].isState(), params[0].getRemote_id(), params[0].getNutsAndOils_id());
            return null;
        }
    }
}