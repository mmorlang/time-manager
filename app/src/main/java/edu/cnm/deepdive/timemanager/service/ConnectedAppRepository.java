package edu.cnm.deepdive.timemanager.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.timemanager.dao.ConnectedAppDao;
import edu.cnm.deepdive.timemanager.model.entity.ConnectedApp;
import edu.cnm.deepdive.timemanager.model.entity.Notification;
import edu.cnm.deepdive.timemanager.model.entity.Timeframe;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class ConnectedAppRepository {
  private final Context context;
  private final ConnectedAppDao connectedAppDao;
  private  final TimeManagerDatabase database;


  public ConnectedAppRepository(Context context) {
    this.context = context;
    database = TimeManagerDatabase.getInstance();
    connectedAppDao = database.getConnectedAppDao();
  }

  public LiveData<List<ConnectedApp>> getAll() { return connectedAppDao.selectAll
  }

  public Single<ConnectedApp> get(String id) {
    return connectedAppDao.selectId(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(Notification notification) {
    if (connectedApp.getId() == 0) {
      return Completable.fromSingle(connectedAppDao.insert(connectedApp))
    } else {
      return Completable.fromSingle(connectedAppDao.update(connectedApp))
          .subscribeOn(Schedulers.io());
    }
  }

  public Completable delete(Notification notification) {
    if (connectedApp.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(connectedAppDao.delete(connectedApp))
          .subscribeOn(Schedulers.io());
    }
  }
}
