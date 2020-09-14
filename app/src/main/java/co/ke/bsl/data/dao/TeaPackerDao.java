package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface TeaPackerDao {
    @Insert(onConflict = REPLACE)
    void addTeaPacker(TeaPacker teaPacker);

    @Query("SELECT COUNT(*) as total FROM TeaPacker")
    Total getTeaPackerCount();

    @Query("SELECT * FROM TeaPacker WHERE is_synced =:state")
    LiveData<List<TeaPacker>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM TeaPacker ORDER BY teapcker_id DESC")
    LiveData<List<TeaPacker>> getAllTeaPacker();

    @Query("UPDATE TeaPacker SET is_synced =:state, remote_id =:remote_id WHERE teapcker_id =:teaPacker_id")
    void updateTeaPackerSyncState(boolean state, String remote_id, String teaPacker_id);
}
