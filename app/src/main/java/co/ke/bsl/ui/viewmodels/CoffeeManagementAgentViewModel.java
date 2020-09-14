package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.CoffeeManagementAgent;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.CoffeeManagementAgentStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class CoffeeManagementAgentViewModel extends AndroidViewModel {

    private Database database;

    public CoffeeManagementAgentViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final CoffeeManagementAgent coffeeManagementAgent) {
        new CoffeeManagementAgentViewModel.addAsyncTask(database).execute(coffeeManagementAgent);
    }

    public Total countCoffeeManagementAgent() {
        return database.coffeeManagementAgentDao().getCoffeeManagementAgentCount();
    }

    public LiveData<List<CoffeeManagementAgent>> getUnsyncedData(boolean state) {
        return database.coffeeManagementAgentDao().fetchUnsyncedData(state);
    }

    public LiveData<List<CoffeeManagementAgent>> getAllCoffeeManagementAgents() {
        return database.coffeeManagementAgentDao().getAllCoffeeManagementAgents();
    }

    public void updateCoffeeManagementAgentRecord(final CoffeeManagementAgentStatus coffeeManagementAgentStatus) {
        new CoffeeManagementAgentViewModel.updateCoffeeManagementAgentStatusAsyncTask(database).execute(coffeeManagementAgentStatus);
    }


    static class addAsyncTask extends AsyncTask<CoffeeManagementAgent, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CoffeeManagementAgent... params) {
            db.coffeeManagementAgentDao().addCoffeeManagementAgent(params[0]);
            return null;
        }

    }

    private static class updateCoffeeManagementAgentStatusAsyncTask extends AsyncTask<CoffeeManagementAgentStatus, Void, Void> {

        private Database db;

        updateCoffeeManagementAgentStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CoffeeManagementAgentStatus... params) {
            db.coffeeManagementAgentDao().updateCoffeeManagementAgentSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getCoffeeManagementAgent_id());
            return null;
        }
    }
}