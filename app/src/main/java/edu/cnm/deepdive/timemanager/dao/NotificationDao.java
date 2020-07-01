package edu.cnm.deepdive.timemanager.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.timemanager.model.entity.Notification;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface NotificationDao {


  @Insert
  Single<Long> insert(Notification notification);

  @Insert
  Single<List<Long>> insert(Collection<Notification> notifications);

  @Update
  Single<Integer> update(Notification... notifications);

  @Delete
  Single<Integer> delete(Notification... notifications);

@Query("SELECT * FROM Notification ORDER BY summary")
  LiveData<List<Notification>> selectAll();

@Query("SELECT * FROM Notification WHERE timeframe_id = :timeframeId")
  LiveData<List<Notification>> selectByTimeframe(long timeframeId);

// TODO Order by time stamp.
}
