package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.CoffeeNurseryCert;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CoffeeNurseryCertificateInspectionDao {
    @Insert(onConflict = REPLACE)
    void addCoffeeNursery(CoffeeNurseryCert coffeeNurseryCert);

    @Query("SELECT COUNT(*) as total FROM CoffeeNurseryCert")
    Total getCoffeeNurseryCount();

    @Query("SELECT * FROM CoffeeNurseryCert WHERE is_synced =:state")
    LiveData<List<CoffeeNurseryCert>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM CoffeeNurseryCert ORDER BY coffeeeNursery_id DESC")
    LiveData<List<CoffeeNurseryCert>> getAllCoffeeNurseries();

    @Query("UPDATE CoffeeNurseryCert SET is_synced =:state, remote_id =:remote_id WHERE coffeeeNursery_id =:coffeeeNursery_id")
    void updateCoffeeNurserySyncState(boolean state, String remote_id, String coffeeeNursery_id);
}
