package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.PyrethrumInspection;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface PyrethrumInspectionDao {
    @Insert(onConflict = REPLACE)
    void addPyrethrumInspection(PyrethrumInspection pyrethrumInspection);

    @Query("SELECT COUNT(*) as total FROM PyrethrumInspection")
    Total getPyrethrumInspectionCount();

    @Query("SELECT * FROM PyrethrumInspection WHERE is_synced =:state")
    LiveData<List<PyrethrumInspection>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM PyrethrumInspection ORDER BY pyrethrum_inspection_id DESC")
    LiveData<List<PyrethrumInspection>> getAllPyrethrumInspections();

    @Query("UPDATE PyrethrumInspection SET is_synced =:state, remote_id =:remote_id WHERE pyrethrum_inspection_id =:PyrethrumInspection_id")
    void updatePyrethrumInspectionSyncState(boolean state, String remote_id, String PyrethrumInspection_id);
}
