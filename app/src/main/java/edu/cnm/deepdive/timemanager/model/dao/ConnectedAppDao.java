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
/**
 * This Dao contains Actions that are allowed for your app.
 * It also Queries that pull and sort your data.
 */
@Dao
public interface ConnectedAppDao {

  /**
   * this Insert method allows you to add a single app.
   * @param connectedApp
   * @return connectedApp
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(ConnectedApp connectedApp);

  /**
   * this Insert method allows you to add multiple apps
   * @param connectedApps
   * @return connectedApps
   */
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<ConnectedApp> connectedApps);

  /**
   * this Update allows you to update existing apps
   * @param connectedApps
   * @return connectedApps
   */
  @Update
  Single<Integer> update(ConnectedApp... connectedApps);

  /**
   * this Delete method allows you to deleted selected apps
   * @param connectedApps
   * @return connectedApps
   */
  @Delete
  Single<Integer> delete(ConnectedApp... connectedApps);

  /**
   * this Query returns all apps and sorts them by name
   * @return allAppsNames
   */
  @Query("SELECT * FROM ConnectedApp ORDER BY app_name")
  LiveData<List<ConnectedApp>> selectAll();

  /**
   * this Query returns all apps and sorts them by id.
   * @param connectedAppId
   * @return allAppsIds
   */
  @Query( "SELECT * FROM ConnectedApp WHERE connected_app_id = :connectedAppId")
  Single<ConnectedApp> selectById(long connectedAppId);
}
