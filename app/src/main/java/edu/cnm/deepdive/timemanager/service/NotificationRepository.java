package edu.cnm.deepdive.timemanager.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.timemanager.model.dao.NotificationDao;
import edu.cnm.deepdive.timemanager.model.entity.Notification;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * this class handles all the updates, insertions, deletions and pulls for the Notifications.
 */
public class NotificationRepository {
  private final Context context;
  private final NotificationDao notificationDao;
  private  final TimeManagerDatabase database;

  /**
   * gets the contect from the NotificationDao.
   * @param context
   */
  public NotificationRepository(Context context) {
    this.context = context;
    database = TimeManagerDatabase.getInstance();
    notificationDao = database.getNotificationDao();
  }

  /**
   * gets all notifications.
   * @return notifications
   */
  public LiveData<List<Notification>> getAll() { return notificationDao.selectAll();
  }

  /**
   * gets all notifications and returns them by their ids.
   * @param id
   * @return notification
   */
  public Single<Notification> get(long id) {
    return notificationDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  /**
   * saves an edited or new notification
   * @param notification
   * @return notification
   */
  public Completable save(Notification notification) {
    if (notification.getId() == 0) {
      return Completable.fromSingle(notificationDao.insert(notification)).
          subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(notificationDao.update(notification))
          .subscribeOn(Schedulers.io());
    }
  }

  /**
   * this deletes notifications.
   * @param notification
   * @return updated notifications
   */
  public Completable delete(Notification notification) {
    if (notification.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(notificationDao.delete(notification))
          .subscribeOn(Schedulers.io());
    }
  }
}