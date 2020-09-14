package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.HCDHorticulturalCropsColdStorage;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface HorticulturalCropsColdStorageDao {
    @Insert(onConflict = REPLACE)
    void addHorticulturalCropsColdStorage(HCDHorticulturalCropsColdStorage hcdHorticulturalCropsColdStorage);

    @Query("SELECT COUNT(*) as total FROM HCDHorticulturalCropsColdStorage")
    Total getHorticulturalCropsColdStorageCount();

    @Query("SELECT * FROM HCDHorticulturalCropsColdStorage WHERE is_synced =:state")
    LiveData<List<HCDHorticulturalCropsColdStorage>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM HCDHorticulturalCropsColdStorage ORDER BY hcdHorticultural_Crops_Cold_Storage_id DESC")
    LiveData<List<HCDHorticulturalCropsColdStorage>> getAllHorticulturalCropsColdStorage();

    @Query("UPDATE HCDHorticulturalCropsColdStorage SET is_synced =:state, remote_id =:remote_id WHERE hcdHorticultural_Crops_Cold_Storage_id =:hcdHorticultural_Crops_Cold_Storage_id")
    void updateHorticulturalCropsColdStorageSyncState(boolean state, String remote_id, String hcdHorticultural_Crops_Cold_Storage_id);
}
