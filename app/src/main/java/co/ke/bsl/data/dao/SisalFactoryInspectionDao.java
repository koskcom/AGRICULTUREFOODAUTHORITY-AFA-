package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.FCDSisalFactoryInspection;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface SisalFactoryInspectionDao {
    @Insert(onConflict = REPLACE)
    void addSisalFactoryInspection(FCDSisalFactoryInspection fcdSisalFactoryInspection);

    @Query("SELECT COUNT(*) as total FROM FCDSisalFactoryInspection")
    Total getSisalFactoryInspectionCount();

    @Query("SELECT * FROM FCDSisalFactoryInspection WHERE is_synced =:state")
    LiveData<List<FCDSisalFactoryInspection>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM FCDSisalFactoryInspection ORDER BY hcd_Sisal_Factory_Inspection_id DESC")
    LiveData<List<FCDSisalFactoryInspection>> getAllSisalFactoryInspections();

    @Query("UPDATE FCDSisalFactoryInspection SET is_synced =:state, remote_id =:remote_id WHERE hcd_Sisal_Factory_Inspection_id =:hCD_Sisal_Factory_Inspection_id")
    void updateSisalFactoryInspectionSyncState(boolean state, String remote_id, String hCD_Sisal_Factory_Inspection_id);
}
