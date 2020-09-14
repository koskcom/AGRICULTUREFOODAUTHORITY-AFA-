package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.HCDMangoQualityInspection;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MangoQualityInspectionDao {
    @Insert(onConflict = REPLACE)
    void addMangoQualityInspection(HCDMangoQualityInspection hcdMangoQualityInspection);

    @Query("SELECT COUNT(*) as total FROM HCDMangoQualityInspection")
    Total getMangoQualityInspectionCount();

    @Query("SELECT * FROM HCDMangoQualityInspection WHERE is_synced =:state")
    LiveData<List<HCDMangoQualityInspection>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM HCDMangoQualityInspection ORDER BY hcdMangoQualityInspection_id DESC")
    LiveData<List<HCDMangoQualityInspection>> getAllMangoQualityInspections();

    @Query("UPDATE HCDMangoQualityInspection SET is_synced =:state, remote_id =:remote_id WHERE hcdMangoQualityInspection_id =:hCDMangoQualityInspection_id")
    void updateMangoQualityInspectionSyncState(boolean state, String remote_id, String hCDMangoQualityInspection_id);
}
