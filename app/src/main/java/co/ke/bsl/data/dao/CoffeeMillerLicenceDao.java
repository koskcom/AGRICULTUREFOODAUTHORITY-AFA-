package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.CoffeeMillerLicenceApplication;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CoffeeMillerLicenceDao {
    @Insert(onConflict = REPLACE)
    void addCoffeeMillerLicence(CoffeeMillerLicenceApplication coffeeMillerLicenceApplication);

    @Query("SELECT COUNT(*) as total FROM CoffeeMillerLicenceApplication")
    Total getCoffeeMillerLicenceCount();

    @Query("SELECT * FROM CoffeeMillerLicenceApplication WHERE is_synced =:state")
    LiveData<List<CoffeeMillerLicenceApplication>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM CoffeeMillerLicenceApplication ORDER BY coffee_miller_licence_application_id DESC")
    LiveData<List<CoffeeMillerLicenceApplication>> getAllCoffeeMillerLicences();

    @Query("UPDATE CoffeeMillerLicenceApplication SET is_synced =:state, remote_id =:remote_id WHERE coffee_miller_licence_application_id =:coffee_miller_licence_application_id")
    void updateCoffeeMillerLicenceSyncState(boolean state, String remote_id, String coffee_miller_licence_application_id);
}
