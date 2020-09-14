package co.ke.bsl.data.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.CaneCensus;
import co.ke.bsl.data.model.ClientInfo;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CaneCensusDao {
    @Insert(onConflict = REPLACE)
    void addCaneCensus(CaneCensus caneCensus);

    @Query("SELECT COUNT(*) as total FROM CaneCensus")
    Total getCaneCensusCount();

    @Query("SELECT * FROM CaneCensus WHERE is_synced =:state")
    LiveData<List<CaneCensus>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM CaneCensus ORDER BY canecensus_id DESC")
    LiveData<List<CaneCensus>> getAllCaneCensus();

    @Query("UPDATE CaneCensus SET is_synced =:state, remote_id =:remote_id WHERE canecensus_id =:canecensus_id")
    void updateCaneCensusSyncState(boolean state, String remote_id, String canecensus_id);
}