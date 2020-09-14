package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.HCDFlowersConsolidators;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface HorticulturalFlowerConsolidatorsDao {
    @Insert(onConflict = REPLACE)
    void addHorticulturalFlowerConsolidator(HCDFlowersConsolidators hcdFlowersConsolidators);

    @Query("SELECT COUNT(*) as total FROM HCDFlowersConsolidators")
    Total getHorticulturalFlowerConsolidatorsCount();

    @Query("SELECT * FROM HCDFlowersConsolidators WHERE is_synced =:state")
    LiveData<List<HCDFlowersConsolidators>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM HCDFlowersConsolidators ORDER BY hcd_flowers_Consolidators_id DESC")
    LiveData<List<HCDFlowersConsolidators>> getAllHorticulturalFlowerConsolidators();

    @Query("UPDATE HCDFlowersConsolidators SET is_synced =:state, remote_id =:remote_id WHERE hcd_flowers_Consolidators_id =:hcd_flowers_Consolidators_id")
    void updateHorticulturalFlowerConsolidatorsSyncState(boolean state, String remote_id, String hcd_flowers_Consolidators_id);
}
