package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.HCDParkhouseWarehouse;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface HorticulturalPackhouseWarehouseDao {
    @Insert(onConflict = REPLACE)
    void addHorticulturalPackhouseWarehouse(HCDParkhouseWarehouse teaPacker);

    @Query("SELECT COUNT(*) as total FROM HCDParkhouseWarehouse")
    Total getHorticulturalPackhouseWarehouseCount();

    @Query("SELECT * FROM HCDParkhouseWarehouse WHERE is_synced =:state")
    LiveData<List<HCDParkhouseWarehouse>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM HCDParkhouseWarehouse ORDER BY hcdParkhouseWarehouse_id DESC")
    LiveData<List<HCDParkhouseWarehouse>> getAllHorticulturalPackhouseWarehouse();

    @Query("UPDATE HCDParkhouseWarehouse SET is_synced =:state, remote_id =:remote_id WHERE hcdParkhouseWarehouse_id =:hCDParkhouseWarehouse_id")
    void updateHorticulturalPackhouseWarehouseSyncState(boolean state, String remote_id, String hCDParkhouseWarehouse_id);
}
