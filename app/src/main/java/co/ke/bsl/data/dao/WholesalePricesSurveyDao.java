package co.ke.bsl.data.dao;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.SugarWholesalePricesSurvey;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface WholesalePricesSurveyDao
 {
    @Insert(onConflict = REPLACE)
    void addSugarPricesSurvey(SugarWholesalePricesSurvey sugarWholesalePricesSurvey);

    @Query("SELECT COUNT(*) as total FROM SugarWholesalePricesSurvey")
    Total getSugarPricesSurveyCount();

    @Query("SELECT * FROM SugarWholesalePricesSurvey WHERE is_synced =:state")
    LiveData<List<SugarWholesalePricesSurvey>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM SugarWholesalePricesSurvey ORDER BY sugarWholesalePricesSurvey_id DESC")
    LiveData<List<SugarWholesalePricesSurvey>> getAllSugarWholesalePricesSurvey();

    @Query("UPDATE SugarWholesalePricesSurvey SET is_synced =:state, remote_id =:remote_id WHERE sugarWholesalePricesSurvey_id =:sugarwholesalepricessurvey_id")
    void updateSugarPricesSurveySyncState(boolean state, String remote_id, String sugarwholesalepricessurvey_id);
}