package edu.cnm.deepdive.timemanager.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.timemanager.dao.NotificationDao;
import edu.cnm.deepdive.timemanager.model.entity.Notification;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class NotificationRepository {
  private final Context context;
  private final NotificationDao notificationDao;
  private  final TimeManagerDatabase database;


  public NotificationRepository(Context context) {
    this.context = context;
    database = TimeManagerDatabase.getInstance();
    notificationDao = database.getNotificationDao();
  }

  public LiveData<List<Notification>> getAll() { return notificationDao.selectAll();
  }

  public Single<Notification> get(long id) {
    return notificationDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(Notification notification) {
    if (notification.getId() == 0) {
      return Completable.fromSingle(notificationDao.insert(notification)).
          subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(notificationDao.update(notification))
          .subscribeOn(Schedulers.io());
    }
  }

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