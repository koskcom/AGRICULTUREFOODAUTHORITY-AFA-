package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.FCDCottonLintClassingReport;
import co.ke.bsl.data.model.FCDCottonLintClassingReport;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CottonLintClassingReportDao {
    @Insert(onConflict = REPLACE)
    void addCottonLintClassingReport(FCDCottonLintClassingReport fcdCottonLintClassingReport);

    @Query("SELECT COUNT(*) as total FROM FCDCottonLintClassingReport")
    Total getCottonLintClassingReportCount();

    @Query("SELECT * FROM FCDCottonLintClassingReport WHERE is_synced =:state")
    LiveData<List<FCDCottonLintClassingReport>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM FCDCottonLintClassingReport ORDER BY fcd_cotton_lint_classing_report_id DESC")
    LiveData<List<FCDCottonLintClassingReport>> getAllCottonLintClassingReport();

    @Query("UPDATE FCDCottonLintClassingReport SET is_synced =:state, remote_id =:remote_id WHERE fcd_cotton_lint_classing_report_id =:fcd_cotton_lint_classing_report_id")
    void updateCottonLintClassingReportSyncState(boolean state, String remote_id, String fcd_cotton_lint_classing_report_id);
}
