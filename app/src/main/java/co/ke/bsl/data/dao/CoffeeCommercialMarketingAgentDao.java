package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.CoffeeCommercialMarketingAgent;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CoffeeCommercialMarketingAgentDao {
    @Insert(onConflict = REPLACE)
    void addCoffeeCommercialMarketingAgent(CoffeeCommercialMarketingAgent coffeeCommercialMarketingAgent);

    @Query("SELECT COUNT(*) as total FROM CoffeeCommercialMarketingAgent")
    Total getCoffeeCommercialMarketingAgentCount();

    @Query("SELECT * FROM CoffeeCommercialMarketingAgent WHERE is_synced =:state")
    LiveData<List<CoffeeCommercialMarketingAgent>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM CoffeeCommercialMarketingAgent ORDER BY commercial_agent_id DESC")
    LiveData<List<CoffeeCommercialMarketingAgent>> getAllCoffeeCommercialMarketingAgents();

    @Query("UPDATE CoffeeCommercialMarketingAgent SET is_synced =:state, remote_id =:remote_id WHERE commercial_agent_id =:commercial_agent_id")
    void updateCoffeeCommercialMarketingAgentSyncState(boolean state, String remote_id, String commercial_agent_id);
}
