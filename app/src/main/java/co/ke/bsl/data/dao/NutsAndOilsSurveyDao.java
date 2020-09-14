package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.NOCDMarketPriceSurvey;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface NutsAndOilsSurveyDao {
    @Insert(onConflict = REPLACE)
    void addNutsAndOilsSurvey(NOCDMarketPriceSurvey nocdMarketPriceSurvey);

    @Query("SELECT COUNT(*) as total FROM NOCDMarketPriceSurvey")
    Total getNutsAndOilsSurveyCount();

    @Query("SELECT * FROM NOCDMarketPriceSurvey WHERE is_synced =:state")
    LiveData<List<NOCDMarketPriceSurvey>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM NOCDMarketPriceSurvey ORDER BY nocdMarketPriceSurveyID DESC")
    LiveData<List<NOCDMarketPriceSurvey>> getAllNutsAndOilsSurvey();

    @Query("UPDATE NOCDMarketPriceSurvey SET is_synced =:state, remote_id =:remote_id WHERE nocdMarketPriceSurveyID =:nocdMarketPriceSurveyID")
    void updateNutsAndOilsSurveySyncState(boolean state, String remote_id, String nocdMarketPriceSurveyID);
}
