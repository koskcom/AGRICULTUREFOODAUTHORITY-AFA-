package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.FCDCottonGinneryInspection;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CottonGinneryInspectionDao {
    @Insert(onConflict = REPLACE)
    void addCottonGinneryInspection(FCDCottonGinneryInspection fcdCottonGinneryInspection);

    @Query("SELECT COUNT(*) as total FROM FCDCottonGinneryInspection")
    Total getCottonGinneryInspectionCount();

    @Query("SELECT * FROM FCDCottonGinneryInspection WHERE is_synced =:state")
    LiveData<List<FCDCottonGinneryInspection>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM FCDCottonGinneryInspection ORDER BY fcd_Cotton_Ginnery_Inspection_id DESC")
    LiveData<List<FCDCottonGinneryInspection>> getAllCottonGinneryInspection();

    @Query("UPDATE FCDCottonGinneryInspection SET is_synced =:state, remote_id =:remote_id WHERE fcd_Cotton_Ginnery_Inspection_id =:fcd_Cotton_Ginnery_Inspection_id")
    void updateCottonGinneryInspectionSyncState(boolean state, String remote_id, String fcd_Cotton_Ginnery_Inspection_id);
}
