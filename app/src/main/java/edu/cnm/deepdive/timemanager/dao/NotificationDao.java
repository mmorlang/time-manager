package edu.cnm.deepdive.timemanager.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;
import edu.cnm.deepdive.timemanager.model.entity.Notification;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface NotificationDao {


  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Notification notification);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Notification> notifications);

  @Update
  Single<Integer> update(Notification... notifications);

  @Delete
  Single<Integer> delete(Notification... notifications);
}
