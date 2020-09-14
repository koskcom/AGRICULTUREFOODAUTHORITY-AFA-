package co.ke.bsl.ui.viewmodels;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import co.ke.bsl.data.Database;
import co.ke.bsl.data.model.FoodCrop;
import co.ke.bsl.data.view.FoodCropStatus;
import co.ke.bsl.data.view.Total;

public class FoodCropViewModel extends AndroidViewModel {

    private Database database;

    public FoodCropViewModel(Application application) {

        super(application);

        database = Database.getDatabase(this.getApplication());
    }

    public void addRecord(final FoodCrop foodCrop) {
        new FoodCropViewModel.addAsyncTask(database).execute(foodCrop);
    }

    public Total countFoodCrop() {
        return database.foodCropExportDao().getFoodCropCount();
    }

    public LiveData<List<FoodCrop>> getUnsyncedData(boolean state) {
        return database.foodCropExportDao().fetchUnsyncedData(state);
    }

    public LiveData<List<FoodCrop>> getAllFoodCrop() {
        return database.foodCropExportDao().getAllFoodCrop();
    }

    public void updateFoodCropRecord(final FoodCropStatus FoodCropStatus) {
        new FoodCropViewModel.updateFoodCropStatusAsyncTask(database).execute(FoodCropStatus);
    }


    static class addAsyncTask extends AsyncTask<FoodCrop, Void, Void> {

        private Database db;

        addAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FoodCrop... params) {
            db.foodCropExportDao().addFoodCrop(params[0]);
            return null;
        }

    }

    private static class updateFoodCropStatusAsyncTask extends AsyncTask<FoodCropStatus, Void, Void> {

        private Database db;

        updateFoodCropStatusAsyncTask(Database database) {
            db = database;
        }

        @Override
        protected Void doInBackground(final FoodCropStatus... params) {
            db.foodCropExportDao().updateFoodCropSyncState(params[0].isState(), params[0].getRemote_id(), params[0].getFood_crop_id());
            return null;
        }
    }
}
