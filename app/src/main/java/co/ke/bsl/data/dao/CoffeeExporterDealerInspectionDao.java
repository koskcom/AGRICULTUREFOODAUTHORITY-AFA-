package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.CoffeeExporterDealerInspection;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CoffeeExporterDealerInspectionDao {
    @Insert(onConflict = REPLACE)
    void addCoffeeExporterDealerInspection(CoffeeExporterDealerInspection coffeeExporterDealerInspection);

    @Query("SELECT COUNT(*) as total FROM CoffeeExporterDealerInspection")
    Total getCoffeeExporterDealerInspectionCount();

    @Query("SELECT * FROM CoffeeExporterDealerInspection WHERE is_synced =:state")
    LiveData<List<CoffeeExporterDealerInspection>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM CoffeeExporterDealerInspection ORDER BY coffee_exporter_dealer_importer_id DESC")
    LiveData<List<CoffeeExporterDealerInspection>> getAllCoffeeExporterDealerInspections();

    @Query("UPDATE CoffeeExporterDealerInspection SET is_synced =:state, remote_id =:remote_id WHERE coffee_exporter_dealer_importer_id =:coffee_exporter_dealer_importer_id")
    void updateCoffeeExporterDealerInspectionSyncState(boolean state, String remote_id, String coffee_exporter_dealer_importer_id);
}
