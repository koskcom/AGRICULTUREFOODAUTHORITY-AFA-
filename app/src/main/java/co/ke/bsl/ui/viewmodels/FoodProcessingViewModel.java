package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.FCDCottonLintClassingReport;
import co.ke.bsl.data.model.FoodProcessing;
import co.ke.bsl.data.view.CottonLintStatus;
import co.ke.bsl.data.view.FoodProcessingStatus;
import co.ke.bsl.data.view.Total;

public class FoodProcessingViewModel extends AndroidViewModel {

    private Database database;

    public FoodProcessingViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final FoodProcessing foodProcessing) {
        new FoodProcessingViewModel.addAsyncTask(database).execute(foodProcessing);
    }

    public Total countFoodProcessing() {
        return database.foodProcessingDao().getFoodProcessingCount();
    }

    public LiveData<List<FoodProcessing>> getUnsyncedData(boolean state) {
        return database.foodProcessingDao().fetchUnsyncedData(state);
    }

    public LiveData<List<FoodProcessing>> getAllFoodProcessing() {
        return database.foodProcessingDao().getAllFoodProcessing();
    }

    public void updateFoodProcessingRecord(final FoodProcessingStatus foodProcessingStatus) {
        new FoodProcessingViewModel.updateFoodProcessingStatusAsyncTask(database).execute(foodProcessingStatus);
    }


    static class addAsyncTask extends AsyncTask<FoodProcessing, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FoodProcessing... params) {
            db.foodProcessingDao().addFoodProcessing(params[0]);
            return null;
        }

    }

    private static class updateFoodProcessingStatusAsyncTask extends AsyncTask<FoodProcessingStatus, Void, Void> {

        private Database db;

        updateFoodProcessingStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FoodProcessingStatus... params) {
            db.foodProcessingDao().updateFoodProcessingSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getFoodprocessing_id());
            return null;
        }
    }
}
