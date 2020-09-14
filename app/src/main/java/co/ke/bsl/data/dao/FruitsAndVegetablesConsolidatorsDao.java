package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.FruitVegetableConsolidators;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface FruitsAndVegetablesConsolidatorsDao {
    @Insert(onConflict = REPLACE)
    void addFruitVegetableConsolidators(FruitVegetableConsolidators fruitVegetableConsolidators);

    @Query("SELECT COUNT(*) as total FROM FruitVegetableConsolidators")
    Total getFruitVegetableConsolidatorsCount();

    @Query("SELECT * FROM FruitVegetableConsolidators WHERE is_synced =:state")
    LiveData<List<FruitVegetableConsolidators>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM FruitVegetableConsolidators ORDER BY fruitVegetableConsolidators_id DESC")
    LiveData<List<FruitVegetableConsolidators>> getAllFruitVegetableConsolidators();

    @Query("UPDATE FruitVegetableConsolidators SET is_synced =:state, remote_id =:remote_id WHERE fruitVegetableConsolidators_id =:fruitVegetableConsolidators_id")
    void updateFruitVegetableConsolidatorsSyncState(boolean state, String remote_id, String fruitVegetableConsolidators_id);
}
