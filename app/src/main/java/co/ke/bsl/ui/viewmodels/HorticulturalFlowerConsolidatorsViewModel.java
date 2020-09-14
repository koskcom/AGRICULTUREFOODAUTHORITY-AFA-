package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.HCDFlowersConsolidators;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.HorticulturalFlowerConsolidatorsStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class HorticulturalFlowerConsolidatorsViewModel extends AndroidViewModel {

    private Database database;

    public HorticulturalFlowerConsolidatorsViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final HCDFlowersConsolidators hcdFlowersConsolidators) {
        new HorticulturalFlowerConsolidatorsViewModel.addAsyncTask(database).execute(hcdFlowersConsolidators);
    }

    public Total countHorticulturalFlowerConsolidators() {
        return database.horticulturalFlowerConsolidatorsDao().getHorticulturalFlowerConsolidatorsCount();
    }

    public LiveData<List<HCDFlowersConsolidators>> getUnsyncedData(boolean state) {
        return database.horticulturalFlowerConsolidatorsDao().fetchUnsyncedData(state);
    }

    public LiveData<List<HCDFlowersConsolidators>> getAllHorticulturalFlowerConsolidators() {
        return database.horticulturalFlowerConsolidatorsDao().getAllHorticulturalFlowerConsolidators();
    }

    public void updateHorticulturalFlowerConsolidatorsRecord(final HorticulturalFlowerConsolidatorsStatus horticulturalFlowerConsolidatorsStatus) {
        new HorticulturalFlowerConsolidatorsViewModel.updateHorticulturalFlowerConsolidatorsStatusAsyncTask(database).execute(horticulturalFlowerConsolidatorsStatus);
    }


    static class addAsyncTask extends AsyncTask<HCDFlowersConsolidators, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HCDFlowersConsolidators... params) {
            db.horticulturalFlowerConsolidatorsDao().addHorticulturalFlowerConsolidator(params[0]);
            return null;
        }

    }

    private static class updateHorticulturalFlowerConsolidatorsStatusAsyncTask extends AsyncTask<HorticulturalFlowerConsolidatorsStatus, Void, Void> {

        private Database db;

        updateHorticulturalFlowerConsolidatorsStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final HorticulturalFlowerConsolidatorsStatus... params) {
            db.horticulturalFlowerConsolidatorsDao().updateHorticulturalFlowerConsolidatorsSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getHorticulturalFLowerConsolidators_id());
            return null;
        }
    }
}