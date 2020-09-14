package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.CoffeeGrowerMarketingAgent;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CoffeeGrowerMarketingAgentDao {
    @Insert(onConflict = REPLACE)
    void addCoffeeGrowerMarketingAgent(CoffeeGrowerMarketingAgent coffeeGrowerMarketingAgent);

    @Query("SELECT COUNT(*) as total FROM CoffeeGrowerMarketingAgent")
    Total getCoffeeGrowerMarketingAgentCount();

    @Query("SELECT * FROM CoffeeGrowerMarketingAgent WHERE is_synced =:state")
    LiveData<List<CoffeeGrowerMarketingAgent>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM CoffeeGrowerMarketingAgent ORDER BY coffee_grower_marketing_agent_id DESC")
    LiveData<List<CoffeeGrowerMarketingAgent>> getAllCoffeeGrowerMarketingAgents();

    @Query("UPDATE CoffeeGrowerMarketingAgent SET is_synced =:state, remote_id =:remote_id WHERE coffee_grower_marketing_agent_id =:coffee_grower_marketing_agent_id")
    void updateCoffeeGrowerMarketingAgentSyncState(boolean state, String remote_id, String coffee_grower_marketing_agent_id);
}
