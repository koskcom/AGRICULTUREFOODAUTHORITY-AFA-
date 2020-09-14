package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.FCDCottonBuyingStoreInspection;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CottonBuyingStoreInspectionDao {
    @Insert(onConflict = REPLACE)
    void addCottonBuyingStoreInspection(FCDCottonBuyingStoreInspection fcdCottonBuyingStoreInspection);

    @Query("SELECT COUNT(*) as total FROM FCDCottonBuyingStoreInspection")
    Total getCottonBuyingStoreInspectionCount();

    @Query("SELECT * FROM FCDCottonBuyingStoreInspection WHERE is_synced =:state")
    LiveData<List<FCDCottonBuyingStoreInspection>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM FCDCottonBuyingStoreInspection ORDER BY fcd_Cotton_Buying_Store_Inspection_id DESC")
    LiveData<List<FCDCottonBuyingStoreInspection>> getAllCottonBuyingStoreInspections();

    @Query("UPDATE FCDCottonBuyingStoreInspection SET is_synced =:state, remote_id =:remote_id WHERE fcd_Cotton_Buying_Store_Inspection_id =:fcd_Cotton_Buying_Store_Inspection_id")
    void updateCottonBuyingStoreInspectionSyncState(boolean state, String remote_id, String fcd_Cotton_Buying_Store_Inspection_id);
}
