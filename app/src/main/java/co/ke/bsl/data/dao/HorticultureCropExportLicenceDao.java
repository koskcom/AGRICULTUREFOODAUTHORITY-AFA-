package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.HorticultureCropExportLicenceFarmInspection;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface HorticultureCropExportLicenceDao {
    @Insert(onConflict = REPLACE)
    void addHorticultureCropExportLicenceFarmInspection(HorticultureCropExportLicenceFarmInspection horticultureCropExportLicenceFarmInspection);

    @Query("SELECT COUNT(*) as total FROM HorticultureCropExportLicenceFarmInspection")
    Total getHorticultureCropExportLicenceFarmInspectionCount();

    @Query("SELECT * FROM HorticultureCropExportLicenceFarmInspection WHERE is_synced =:state")
    LiveData<List<HorticultureCropExportLicenceFarmInspection>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM HorticultureCropExportLicenceFarmInspection ORDER BY horticultureCropExportLicenceFarmInspectionID DESC")
    LiveData<List<HorticultureCropExportLicenceFarmInspection>> getAllHorticultureCropExportLicenceFarmInspection();

    @Query("UPDATE HorticultureCropExportLicenceFarmInspection SET is_synced =:state, remote_id =:remote_id WHERE horticultureCropExportLicenceFarmInspectionID =:horticultureCropExportLicenceFarmInspectionID")
    void updateHorticultureCropExportLicenceFarmInspectionSyncState(boolean state, String remote_id, String horticultureCropExportLicenceFarmInspectionID);
}
