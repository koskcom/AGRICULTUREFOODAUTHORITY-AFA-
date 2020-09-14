package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.CoffeePulpingStationPSL;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CoffeePulpingStationPSLDao {
    @Insert(onConflict = REPLACE)
    void addCoffeePulpingStationPSL(CoffeePulpingStationPSL coffeePulpingStationPSL);

    @Query("SELECT COUNT(*) as total FROM CoffeePulpingStationPSL")
    Total getCoffeePulpingStationPSLCount();

    @Query("SELECT * FROM CoffeePulpingStationPSL WHERE is_synced =:state")
    LiveData<List<CoffeePulpingStationPSL>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM CoffeePulpingStationPSL ORDER BY coffee_pulping_station_psl_id DESC")
    LiveData<List<CoffeePulpingStationPSL>> getAllCoffeePulpingStationPSL();

    @Query("UPDATE CoffeePulpingStationPSL SET is_synced =:state, remote_id =:remote_id WHERE coffee_pulping_station_psl_id =:coffee_pulping_station_psl_id")
    void updateCoffeePulpingStationPSLSyncState(boolean state, String remote_id, String coffee_pulping_station_psl_id);
}
