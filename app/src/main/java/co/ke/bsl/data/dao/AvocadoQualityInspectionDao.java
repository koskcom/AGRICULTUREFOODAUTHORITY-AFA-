package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.HCDAvocadoQualityInspection;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface AvocadoQualityInspectionDao {
    @Insert(onConflict = REPLACE)
    void addAvocadoQualityInspection(HCDAvocadoQualityInspection hcdAvocadoQualityInspection);

    @Query("SELECT COUNT(*) as total FROM HCDAvocadoQualityInspection")
    Total getAvocadoQualityInspectionCount();

    @Query("SELECT * FROM HCDAvocadoQualityInspection WHERE is_synced =:state")
    LiveData<List<HCDAvocadoQualityInspection>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM HCDAvocadoQualityInspection ORDER BY hcdAvocado_QualityInspection_id DESC")
    LiveData<List<HCDAvocadoQualityInspection>> getAllAvocadoQualityInspection();

    @Query("UPDATE HCDAvocadoQualityInspection SET is_synced =:state, remote_id =:remote_id WHERE hcdAvocado_QualityInspection_id =:hcdAvocado_QualityInspection_id")
    void updateAvocadoQualityInspectionSyncState(boolean state, String remote_id, String hcdAvocado_QualityInspection_id);
}
