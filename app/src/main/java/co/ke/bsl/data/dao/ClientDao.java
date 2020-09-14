package co.ke.bsl.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.ke.bsl.data.model.ClientInfo;
import co.ke.bsl.data.view.Total;

import static androidx.room.OnConflictStrategy.REPLACE;


@Dao
public interface ClientDao {

    @Insert(onConflict = REPLACE)
    void addClient(ClientInfo clientInfo);

    @Query("SELECT COUNT(*) as total FROM ClientInfo")
    Total getClientCount();

    @Query("SELECT * FROM ClientInfo WHERE is_synced =:state")
    LiveData<List<ClientInfo>> fetchUnsyncedData(boolean state);

    @Query("UPDATE ClientInfo SET is_synced =:state, remote_id =:remote_id WHERE client_id =:client_id")
    void updateClientSyncState(boolean state, String remote_id, String client_id);
}