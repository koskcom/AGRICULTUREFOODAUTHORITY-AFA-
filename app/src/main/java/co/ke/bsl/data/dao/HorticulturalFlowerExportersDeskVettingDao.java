package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.HorticulturalFlowerExportersDeskVetting;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface HorticulturalFlowerExportersDeskVettingDao {
    @Insert(onConflict = REPLACE)
    void addHorticulturalFlowerExportersDeskVetting(HorticulturalFlowerExportersDeskVetting horticulturalFlowerExportersDeskVetting);

    @Query("SELECT COUNT(*) as total FROM HorticulturalFlowerExportersDeskVetting")
    Total getHorticulturalFlowerExportersDeskVettingCount();

    @Query("SELECT * FROM HorticulturalFlowerExportersDeskVetting WHERE is_synced =:state")
    LiveData<List<HorticulturalFlowerExportersDeskVetting>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM HorticulturalFlowerExportersDeskVetting ORDER BY horticulturalFlowerExportersDeskVettingID DESC")
    LiveData<List<HorticulturalFlowerExportersDeskVetting>> getAllHorticulturalFlowerExportersDeskVetting();

    @Query("UPDATE HorticulturalFlowerExportersDeskVetting SET is_synced =:state, remote_id =:remote_id WHERE horticulturalFlowerExportersDeskVettingID =:horticulturalFlowerExportersDeskVettingID")
    void updateHorticulturalFlowerExportersDeskVettingSyncState(boolean state, String remote_id, String horticulturalFlowerExportersDeskVettingID);
}
