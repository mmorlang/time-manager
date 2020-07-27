package edu.cnm.deepdive.timemanager.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.timemanager.model.entity.Notification;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * This Dao contains Actions that are allowed for your app. It also Queries that pull and sort your
 * data.
 */
@Dao
public interface NotificationDao {

  /**
   * this insert method allows a new notification to be inserted.
   *
   * @param notification
   * @return notification
   */
  @Insert
  Single<Long> insert(Notification notification);

  /**
   * this insert method allows new notifications to be inserted.
   *
   * @param notifications
   * @return notifications
   */
  @Insert
  Single<List<Long>> insert(Collection<Notification> notifications);

  /**
   * this insert method allows new/old notifications to be updated.
   *
   * @param notifications
   * @return notifications
   */
  @Update
  Single<Integer> update(Notification... notifications);

  /**
   * this insert method allows new/old notifications to be deleted.
   *
   * @param notifications
   * @return notifications
   */
  @Delete
  Single<Integer> delete(Notification... notifications);

  /**
   * this Query gathers and returns all notifications.
   *
   * @return notifications
   */
  @Query("SELECT * FROM Notification ORDER BY summary")
  LiveData<List<Notification>> selectAll();

  /**
   * this Query gathers and returns notifications that were blocked during specific timeframes.
   *
   * @param timeframeId
   * @return notificationsByTimeframe
   */
  @Query("SELECT * FROM Notification WHERE timeframe_id = :timeframeId")
  LiveData<List<Notification>> selectByTimeframe(long timeframeId);

  /**
   * this Query gathers and returns notifications by their id.
   *
   * @param notificationId
   * @return notificationById
   */

  @Query("SELECT * FROM Notification WHERE notification_id = :notificationId")
  Single<Notification> selectById(long notificationId);
}
