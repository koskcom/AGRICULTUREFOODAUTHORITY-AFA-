package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.FruitsVegetablesExportersDeskVetting;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface FruitsAndVegetablesExportersDeskVettingDao {
    @Insert(onConflict = REPLACE)
    void addFruitsVegetablesExporters(FruitsVegetablesExportersDeskVetting fruitsVegetablesExportersDeskVetting);

    @Query("SELECT COUNT(*) as total FROM FruitsVegetablesExportersDeskVetting")
    Total getFruitsVegetablesExportersCount();

    @Query("SELECT * FROM FruitsVegetablesExportersDeskVetting WHERE is_synced =:state")
    LiveData<List<FruitsVegetablesExportersDeskVetting>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM FruitsVegetablesExportersDeskVetting ORDER BY fruitsVegetablesExportersDeskVetting_id DESC")
    LiveData<List<FruitsVegetablesExportersDeskVetting>> getAllFruitsVegetablesExporters();

    @Query("UPDATE FruitsVegetablesExportersDeskVetting SET is_synced =:state, remote_id =:remote_id WHERE fruitsVegetablesExportersDeskVetting_id =:fruitsVegetablesExportersDeskVetting_id")
    void updateFruitsVegetablesExportersSyncState(boolean state, String remote_id, String fruitsVegetablesExportersDeskVetting_id);
}
