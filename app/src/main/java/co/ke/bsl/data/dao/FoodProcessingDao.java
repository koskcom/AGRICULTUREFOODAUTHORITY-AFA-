package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.CaneCensus;
import co.ke.bsl.data.model.FoodProcessing;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface FoodProcessingDao {
    @Insert(onConflict = REPLACE)
    void addFoodProcessing(FoodProcessing foodProcessing);

    @Query("SELECT COUNT(*) as total FROM FoodProcessing")
    Total getFoodProcessingCount();

    @Query("SELECT * FROM FoodProcessing WHERE is_synced =:state")
    LiveData<List<FoodProcessing>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM FoodProcessing ORDER BY food_processing_id DESC")
    LiveData<List<FoodProcessing>> getAllFoodProcessing();

    @Query("UPDATE FoodProcessing SET is_synced =:state, remote_id =:remote_id WHERE food_processing_id =:food_processing_id")
    void updateFoodProcessingSyncState(boolean state, String remote_id, String food_processing_id);
}
