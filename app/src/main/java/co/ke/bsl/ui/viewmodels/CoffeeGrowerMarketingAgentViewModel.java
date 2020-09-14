package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.CoffeeGrowerMarketingAgent;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.CoffeeGrowerMarketingStatus;
import co.ke.bsl.data.view.TeaPackerStatus;
import co.ke.bsl.data.view.Total;

public class CoffeeGrowerMarketingAgentViewModel extends AndroidViewModel {

    private Database database;

    public CoffeeGrowerMarketingAgentViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final CoffeeGrowerMarketingAgent coffeeGrowerMarketingAgent) {
        new CoffeeGrowerMarketingAgentViewModel.addAsyncTask(database).execute(coffeeGrowerMarketingAgent);
    }

    public Total countCoffeeGrowerMarketingAgent() {
        return database.coffeeGrowerMarketingAgentDao().getCoffeeGrowerMarketingAgentCount();
    }

    public LiveData<List<CoffeeGrowerMarketingAgent>> getUnsyncedData(boolean state) {
        return database.coffeeGrowerMarketingAgentDao().fetchUnsyncedData(state);
    }

    public LiveData<List<CoffeeGrowerMarketingAgent>> getAllCoffeeGrowerMarketingAgents() {
        return database.coffeeGrowerMarketingAgentDao().getAllCoffeeGrowerMarketingAgents();
    }

    public void updateCoffeeGrowerMarketingAgentRecord(final CoffeeGrowerMarketingStatus coffeeGrowerMarketingStatus) {
        new CoffeeGrowerMarketingAgentViewModel.updateCoffeeGrowerMarketingAgentStatusAsyncTask(database).execute(coffeeGrowerMarketingStatus);
    }


    static class addAsyncTask extends AsyncTask<CoffeeGrowerMarketingAgent, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CoffeeGrowerMarketingAgent... params) {
            db.coffeeGrowerMarketingAgentDao().addCoffeeGrowerMarketingAgent(params[0]);
            return null;
        }

    }

    private static class updateCoffeeGrowerMarketingAgentStatusAsyncTask extends AsyncTask<CoffeeGrowerMarketingStatus, Void, Void> {

        private Database db;

        updateCoffeeGrowerMarketingAgentStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CoffeeGrowerMarketingStatus... params) {
            db.coffeeGrowerMarketingAgentDao().updateCoffeeGrowerMarketingAgentSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getCoffeeGrowerMarketing_id());
            return null;
        }
    }
}