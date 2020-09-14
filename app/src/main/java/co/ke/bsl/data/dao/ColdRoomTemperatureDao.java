package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.HCDColdRoomTemperatures;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ColdRoomTemperatureDao {
    @Insert(onConflict = REPLACE)
    void addColdRoomTemperature(HCDColdRoomTemperatures hcdColdRoomTemperatures);

    @Query("SELECT COUNT(*) as total FROM HCDColdRoomTemperatures")
    Total getColdRoomTemperatureCount();

    @Query("SELECT * FROM HCDColdRoomTemperatures WHERE is_synced =:state")
    LiveData<List<HCDColdRoomTemperatures>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM HCDColdRoomTemperatures ORDER BY hcdColdRoomTemperatures_id DESC")
    LiveData<List<HCDColdRoomTemperatures>> getAllColdRoomTemperatures();

    @Query("UPDATE HCDColdRoomTemperatures SET is_synced =:state, remote_id =:remote_id WHERE hcdColdRoomTemperatures_id =:hCDColdRoomTemperatures_id")
    void updateColdRoomTemperatureSyncState(boolean state, String remote_id, String hCDColdRoomTemperatures_id);
}
