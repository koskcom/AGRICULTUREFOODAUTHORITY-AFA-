package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.CoffeeCommercialMarketingAgent;
import co.ke.bsl.data.model.CoffeeGrowerMarketingAgent;
import co.ke.bsl.data.view.CoffeeCommercialMarketingStatus;
import co.ke.bsl.data.view.CoffeeGrowerMarketingStatus;
import co.ke.bsl.data.view.Total;

public class CoffeeCommercialMarketingAgentViewModel extends AndroidViewModel {

    private Database database;

    public CoffeeCommercialMarketingAgentViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final CoffeeCommercialMarketingAgent coffeeCommercialMarketingAgent) {
        new CoffeeCommercialMarketingAgentViewModel.addAsyncTask(database).execute(coffeeCommercialMarketingAgent);
    }

    public Total countCoffeeCommercialMarketingAgent() {
        return database.coffeeCommercialMarketingAgentDao().getCoffeeCommercialMarketingAgentCount();
    }

    public LiveData<List<CoffeeCommercialMarketingAgent>> getUnsyncedData(boolean state) {
        return database.coffeeCommercialMarketingAgentDao().fetchUnsyncedData(state);
    }

    public LiveData<List<CoffeeCommercialMarketingAgent>> getAllCoffeeCommercialMarketingAgents() {
        return database.coffeeCommercialMarketingAgentDao().getAllCoffeeCommercialMarketingAgents();
    }

    public void updateCoffeeCommercialMarketingAgentRecord(final CoffeeCommercialMarketingStatus coffeeCommercialMarketingStatus) {
        new CoffeeCommercialMarketingAgentViewModel.updateCoffeeCommercialMarketingAgentStatusAsyncTask(database).execute(coffeeCommercialMarketingStatus);
    }


    static class addAsyncTask extends AsyncTask<CoffeeCommercialMarketingAgent, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CoffeeCommercialMarketingAgent... params) {
            db.coffeeCommercialMarketingAgentDao().addCoffeeCommercialMarketingAgent(params[0]);
            return null;
        }

    }

    private static class updateCoffeeCommercialMarketingAgentStatusAsyncTask extends AsyncTask<CoffeeCommercialMarketingStatus, Void, Void> {

        private Database db;

        updateCoffeeCommercialMarketingAgentStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final CoffeeCommercialMarketingStatus... params) {
            db.coffeeCommercialMarketingAgentDao().updateCoffeeCommercialMarketingAgentSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getCoffeeCommercialMarketing_id());
            return null;
        }
    }
}