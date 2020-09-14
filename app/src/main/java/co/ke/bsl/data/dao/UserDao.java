package co.ke.bsl.data.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import co.ke.bsl.data.model.User;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {

    @Insert(onConflict = REPLACE)
    void addUser(User user);

    @Query("SELECT * FROM User WHERE user_id = :user_id")
    User getUserById(String user_id);
}
