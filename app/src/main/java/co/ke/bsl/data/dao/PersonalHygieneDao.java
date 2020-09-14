package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.HCDPersonalHygene;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface PersonalHygieneDao {
    @Insert(onConflict = REPLACE)
    void addPersonalHygene(HCDPersonalHygene hcdPersonalHygene);

    @Query("SELECT COUNT(*) as total FROM HCDPersonalHygene")
    Total getPersonalHygeneCount();

    @Query("SELECT * FROM HCDPersonalHygene WHERE is_synced =:state")
    LiveData<List<HCDPersonalHygene>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM HCDPersonalHygene ORDER BY hcd_Personal_Hygiene_id DESC")
    LiveData<List<HCDPersonalHygene>> getAllPersonalHygene();

    @Query("UPDATE HCDPersonalHygene SET is_synced =:state, remote_id =:remote_id WHERE hcd_Personal_Hygiene_id =:hCD_Personal_Hygiene_id")
    void updatePersonalHygeneSyncState(boolean state, String remote_id, String hCD_Personal_Hygiene_id);
}
