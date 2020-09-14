package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.CaneCensus;
import co.ke.bsl.data.model.ClientInfo;
import co.ke.bsl.data.model.SugarMillLicence;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface SugarMillLicenceDao
{
    @Insert(onConflict = REPLACE)
    void addSugarMilllLicence(SugarMillLicence sugarMillLicence);

    @Query("SELECT COUNT(*) as total FROM SugarMillLicence")
    Total getSugarMillLicenceCount();

    @Query("SELECT * FROM SugarMillLicence WHERE is_synced =:state")
    LiveData<List<SugarMillLicence>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM SugarMillLicence ORDER BY sugar_mill_license_id DESC")
    LiveData<List<SugarMillLicence>> getAllSugarMillLicence();

    @Query("UPDATE SugarMillLicence SET is_synced =:state, remote_id =:remote_id WHERE sugar_mill_license_id =:SugarMillLicence_id")
    void updateSugarMillLicenceSyncState(boolean state, String remote_id, String SugarMillLicence_id);
}
