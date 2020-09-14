package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import co.ke.bsl.data.model.FCDSisalSpinningFactoryInspection;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface SisalSpinninginspectionDao {
    @Insert(onConflict = REPLACE)
    void addFCDSisalSpinningFactoryInspection(FCDSisalSpinningFactoryInspection fCDSisalSpinningFactoryInspection);

    @Query("SELECT COUNT(*) as total FROM FCDSisalSpinningFactoryInspection")
    Total getFCDSisalSpinningFactoryInspectionCount();

    @Query("SELECT * FROM FCDSisalSpinningFactoryInspection WHERE is_synced =:state")
    LiveData<List<FCDSisalSpinningFactoryInspection>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM FCDSisalSpinningFactoryInspection ORDER BY sisa_spinning_id DESC")
    LiveData<List<FCDSisalSpinningFactoryInspection>> getAllFCDSisalSpinningFactoryInspections();

    @Query("UPDATE FCDSisalSpinningFactoryInspection SET is_synced =:state, remote_id =:remote_id WHERE sisa_spinning_id =:sisa_spinning_id")
    void updateFCDSisalSpinningFactoryInspectionSyncState(boolean state, String remote_id, String sisa_spinning_id);
}
