package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.CoffeeManagementAgent;
import co.ke.bsl.data.model.TeaPacker;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CoffeeManagementAgentDao {
    @Insert(onConflict = REPLACE)
    void addCoffeeManagementAgent(CoffeeManagementAgent coffeeManagementAgent);

    @Query("SELECT COUNT(*) as total FROM CoffeeManagementAgent")
    Total getCoffeeManagementAgentCount();

    @Query("SELECT * FROM CoffeeManagementAgent WHERE is_synced =:state")
    LiveData<List<CoffeeManagementAgent>> fetchUnsyncedData(boolean state);

    @Query("SELECT * FROM CoffeeManagementAgent ORDER BY coffee_management_agent_id DESC")
    LiveData<List<CoffeeManagementAgent>> getAllCoffeeManagementAgents();

    @Query("UPDATE CoffeeManagementAgent SET is_synced =:state, remote_id =:remote_id WHERE coffee_management_agent_id =:coffee_management_agent_id")
    void updateCoffeeManagementAgentSyncState(boolean state, String remote_id, String coffee_management_agent_id);
}
