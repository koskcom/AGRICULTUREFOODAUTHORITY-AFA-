package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.CoffeeExporterDealerInspection;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.CoffeeExporterDealerStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class CoffeeExporterDealerInspectionViewModel extends AndroidViewModel {

    private Database database;

    public CoffeeExporterDealerInspectionViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final CoffeeExporterDealerInspection coffeeExporterDealerInspection) {
        new CoffeeExporterDealerInspectionViewModel.addAsyncTask(database).execute(coffeeExporterDealerInspection);
    }

    public Total countTeaPacker() {
        return database.coffeeExporterDealerInspectionDao().getCoffeeExporterDealerInspectionCount();
    }

    public LiveData<List<CoffeeExporterDealerInspection>> getUnsyncedData(boolean state) {
        return database.coffeeExporterDealerInspectionDao().fetchUnsyncedData(state);
    }

    public LiveData<List<CoffeeExporterDealerInspection>> getAllCoffeeExporterDealerInspections() {
        return database.coffeeExporterDealerInspectionDao().getAllCoffeeExporterDealerInspections();
    }

    public void updateCoffeeExporterDealerInspectionRecord(final CoffeeExporterDealerStatus teaPackerStatus) {
        new CoffeeExporterDealerInspectionViewModel.updateCoffeeExporterDealerInspectionStatusAsyncTask(database).execute(teaPackerStatus);
    }


    static class addAsyncTask extends AsyncTask<CoffeeExporterDealerInspection, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CoffeeExporterDealerInspection... params) {
            db.coffeeExporterDealerInspectionDao().addCoffeeExporterDealerInspection(params[0]);
            return null;
        }

    }

    private static class updateCoffeeExporterDealerInspectionStatusAsyncTask extends AsyncTask<CoffeeExporterDealerStatus, Void, Void> {

        private Database db;

        updateCoffeeExporterDealerInspectionStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CoffeeExporterDealerStatus... params) {
            db.coffeeExporterDealerInspectionDao().updateCoffeeExporterDealerInspectionSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getCoffeeExporterDealer_id());
            return null;
        }
    }
}