package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.HCDNurseryInspection;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface HorticultureNurseryInspectionDao {
    @Insert(onConflict = REPLACE)
    void addHorticultureNurseryInspection(HCDNurseryInspection hcdNurseryInspection);

    @Query("SELECT COUNT(*) as total FROM HCDNurseryInspection")
    Total getHorticultureNurseryInspectionCount();

    @Query("SELECT * FROM HCDNurseryInspection WHERE is_synced =:state")
    LiveData<List<HCDNurseryInspection>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM HCDNurseryInspection ORDER BY hcdNurseryInspection_id DESC")
    LiveData<List<HCDNurseryInspection>> getAllHorticultureNurseryInspection();

    @Query("UPDATE HCDNurseryInspection SET is_synced =:state, remote_id =:remote_id WHERE hcdNurseryInspection_id =:hCDNurseryInspection_id")
    void updateHorticultureNurseryInspectionSyncState(boolean state, String remote_id, String hCDNurseryInspection_id);
}
