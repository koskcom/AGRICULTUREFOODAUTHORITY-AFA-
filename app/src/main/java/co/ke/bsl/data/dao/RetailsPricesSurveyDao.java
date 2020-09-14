package co.ke.bsl.data.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.CaneCensus;
import co.ke.bsl.data.model.ClientInfo;
import co.ke.bsl.data.model.SugarRetailPricesSurvey;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface RetailsPricesSurveyDao {
    @Insert(onConflict = REPLACE)
    void addSugarRetailPricesSurvey(SugarRetailPricesSurvey sugarRetailPricesSurvey);

    @Query("SELECT COUNT(*) as total FROM SugarRetailPricesSurvey")
    Total getSugarRetailPricesSurveyCount();

    @Query("SELECT * FROM SugarRetailPricesSurvey WHERE is_synced =:state")
    LiveData<List<SugarRetailPricesSurvey>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM SugarRetailPricesSurvey ORDER BY sugarRetailPricesSurvey_id DESC")
    LiveData<List<SugarRetailPricesSurvey>> getAllSugarRetailPricesSurvey();

    @Query("UPDATE SugarRetailPricesSurvey SET is_synced =:state, remote_id =:remote_id WHERE sugarRetailPricesSurvey_id =:sugar_prices_survey_id")
    void updateSugarRetailPricesSurveySyncState(boolean state, String remote_id, String sugar_prices_survey_id);
}
