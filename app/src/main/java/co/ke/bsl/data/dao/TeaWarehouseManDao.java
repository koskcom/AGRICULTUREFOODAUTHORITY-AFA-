package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.model.TeaWarehouseManInspection;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface TeaWarehouseManDao {
    @Insert(onConflict = REPLACE)
    void addTeaWarehouseMan(TeaWarehouseManInspection teaWarehouseManInspection);

    @Query("SELECT COUNT(*) as total FROM TeaWarehouseManInspection")
    Total getTeaWarehouseManCount();

    @Query("SELECT * FROM TeaWarehouseManInspection WHERE is_synced =:state")
    LiveData<List<TeaWarehouseManInspection>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM TeaWarehouseManInspection ORDER BY tea_warehouse_inspection_id DESC")
    LiveData<List<TeaWarehouseManInspection>> getAllTeaWarehouseMan();

    @Query("UPDATE TeaWarehouseManInspection SET is_synced =:state, remote_id =:remote_id WHERE tea_warehouse_inspection_id =:teaWarehouseManid")
    void updateTeaWarehouseManSyncState(boolean state, String remote_id, String teaWarehouseManid);
}
