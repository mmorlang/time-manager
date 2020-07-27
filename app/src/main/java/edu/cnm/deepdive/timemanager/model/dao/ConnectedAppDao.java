package edu.cnm.deepdive.timemanager.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.timemanager.model.entity.ConnectedApp;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ConnectedAppDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(ConnectedApp connectedApp);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<ConnectedApp> connectedApps);

  @Update
  Single<Integer> update(ConnectedApp... connectedApps);

  @Delete
  Single<Integer> delete(ConnectedApp... connectedApps);

  @Query("SELECT * FROM ConnectedApp ORDER BY app_name")
  LiveData<List<ConnectedApp>> selectAll();

  @Query( "SELECT * FROM ConnectedApp WHERE connected_app_id = :connectedAppId")
  Single<ConnectedApp> selectById(long connectedAppId);
}