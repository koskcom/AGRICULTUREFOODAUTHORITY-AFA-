package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.FruitVegetableConsolidators;
import co.ke.bsl.data.view.FruitsAndVegetablesConsolidatorsStatus;
import co.ke.bsl.data.view.Total;

public class FruitsAndVegetablesConsolidatorsViewModel extends AndroidViewModel {

    private Database database;

    public FruitsAndVegetablesConsolidatorsViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final FruitVegetableConsolidators hcdFruitVegetableConsolidators) {
        new FruitsAndVegetablesConsolidatorsViewModel.addAsyncTask(database).execute(hcdFruitVegetableConsolidators);
    }

    public Total countFruitVegetableConsolidators() {
        return database.fruitsAndVegetablesConsolidatorsDao().getFruitVegetableConsolidatorsCount();
    }

    public LiveData<List<FruitVegetableConsolidators>> getUnsyncedData(boolean state) {
        return database.fruitsAndVegetablesConsolidatorsDao().fetchUnsyncedData(state);
    }

    public LiveData<List<FruitVegetableConsolidators>> getAllFruitVegetableConsolidators() {
        return database.fruitsAndVegetablesConsolidatorsDao().getAllFruitVegetableConsolidators();
    }

    public void updateFruitVegetableConsolidatorsRecord(final FruitsAndVegetablesConsolidatorsStatus fruitsAndVegetablesConsolidatorsStatus) {
        new FruitsAndVegetablesConsolidatorsViewModel.updateFruitVegetableConsolidatorsStatusAsyncTask(database).execute(fruitsAndVegetablesConsolidatorsStatus);
    }


    static class addAsyncTask extends AsyncTask<FruitVegetableConsolidators, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FruitVegetableConsolidators... params) {
            db.fruitsAndVegetablesConsolidatorsDao().addFruitVegetableConsolidators(params[0]);
            return null;
        }

    }

    private static class updateFruitVegetableConsolidatorsStatusAsyncTask extends AsyncTask<FruitsAndVegetablesConsolidatorsStatus, Void, Void> {

        private Database db;

        updateFruitVegetableConsolidatorsStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FruitsAndVegetablesConsolidatorsStatus... params) {
            db.fruitsAndVegetablesConsolidatorsDao().updateFruitVegetableConsolidatorsSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getFruitsAndVegetablesConsolidators_id());
            return null;
        }
    }
}