package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


import co.ke.bsl.data.model.FoodCrop;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface FoodCropExportDao {
    @Insert(onConflict = REPLACE)
    void addFoodCrop(FoodCrop foodCrop);

    @Query("SELECT COUNT(*) as total FROM FoodCrop")
    Total getFoodCropCount();

    @Query("SELECT * FROM FoodCrop WHERE is_synced =:state")
    LiveData<List<FoodCrop>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM FoodCrop ORDER BY food_crop_id DESC")
    LiveData<List<FoodCrop>> getAllFoodCrop();

    @Query("UPDATE FoodCrop SET is_synced =:state, remote_id =:remote_id WHERE food_crop_id =:food_crop_id")
    void updateFoodCropSyncState(boolean state, String remote_id, String food_crop_id);
}
