package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.FoodWarehouse;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface FoodWareHouseDao {
    @Insert(onConflict = REPLACE)
    void addFoodWarehouse(FoodWarehouse foodWarehouse);

    @Query("SELECT COUNT(*) as total FROM FoodWarehouse")
    Total getFoodWarehouseCount();

    @Query("SELECT * FROM FoodWarehouse WHERE is_synced =:state")
    LiveData<List<FoodWarehouse>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM FoodWarehouse ORDER BY food_warehouse_id DESC")
    LiveData<List<FoodWarehouse>> getAllFoodWarehouse();

    @Query("UPDATE FoodWarehouse SET is_synced =:state, remote_id =:remote_id WHERE food_warehouse_id =:food_warehouse_id")
    void updateFoodWarehouseSyncState(boolean state, String remote_id, String food_warehouse_id);
}
