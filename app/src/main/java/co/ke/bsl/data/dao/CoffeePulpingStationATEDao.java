package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.PulpingStationLicenseApplication;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CoffeePulpingStationATEDao {
    @Insert(onConflict = REPLACE)
    void addCoffeePulpingStationATE(PulpingStationLicenseApplication pulpingStationLicenseApplication);

    @Query("SELECT COUNT(*) as total FROM PulpingStationLicenseApplication")
    Total getCoffeePulpingStationATECount();

    @Query("SELECT * FROM PulpingStationLicenseApplication WHERE is_synced =:state")
    LiveData<List<PulpingStationLicenseApplication>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM PulpingStationLicenseApplication ORDER BY pulping_station_inspection_id DESC")
    LiveData<List<PulpingStationLicenseApplication>> getAllCoffeePulpingStationATE();

    @Query("UPDATE PulpingStationLicenseApplication SET is_synced =:state, remote_id =:remote_id WHERE pulping_station_inspection_id =:pulping_station_inspection_id")
    void updateCoffeePulpingStationATESyncState(boolean state, String remote_id, String pulping_station_inspection_id);
}
