package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.HorticultureProduceTransportation;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface HorticulturalProduceTransportationDao {
    @Insert(onConflict = REPLACE)
    void addHorticultureProduceTransportation(HorticultureProduceTransportation horticultureProduceTransportation);

    @Query("SELECT COUNT(*) as total FROM HorticultureProduceTransportation")
    Total getHorticultureProduceTransportationCount();

    @Query("SELECT * FROM HorticultureProduceTransportation WHERE is_synced =:state")
    LiveData<List<HorticultureProduceTransportation>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM HorticultureProduceTransportation ORDER BY horticultureProduceTransportationID DESC")
    LiveData<List<HorticultureProduceTransportation>> getAllHorticultureProduceTransportation();

    @Query("UPDATE HorticultureProduceTransportation SET is_synced =:state, remote_id =:remote_id WHERE horticultureProduceTransportationID =:horticultureProduceTransportationID")
    void updateHorticultureProduceTransportationSyncState(boolean state, String remote_id, String horticultureProduceTransportationID);
}
