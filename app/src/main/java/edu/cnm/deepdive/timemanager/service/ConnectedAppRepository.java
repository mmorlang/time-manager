package edu.cnm.deepdive.timemanager.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.timemanager.model.dao.ConnectedAppDao;
import edu.cnm.deepdive.timemanager.model.entity.ConnectedApp;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;


/**
 * this class handles all the updates, insertions, deletions and pulls for the ConnectedApps.
 */
public class ConnectedAppRepository {

  private final Context context;
  private final ConnectedAppDao connectedAppDao;
  private  final TimeManagerDatabase database;

  /**
   * gets the contect from the ConnectedAppDao.
   * @param context
   */
  public ConnectedAppRepository(Context context) {
    this.context = context;
    database = TimeManagerDatabase.getInstance();
    connectedAppDao = database.getConnectedAppDao();
  }

  /**
   * gets all connected apps
   * @return connectedApps
   */
  public LiveData<List<ConnectedApp>> getAll() { return connectedAppDao.selectAll();
  }

  /**
   * gets a single connected app id
   * @param id
   * @return connected app id
   */
  public Single<ConnectedApp> get(long id) {
    return connectedAppDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  /**
   * saves connected apps
   * @param connectedApp
   * @return connectedApps
   */
  public Completable save(ConnectedApp connectedApp) {
    if (connectedApp.getId() == 0) {
      return Completable.fromSingle(connectedAppDao.insert(connectedApp)).
          subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(connectedAppDao.update(connectedApp))
          .subscribeOn(Schedulers.io());
    }
  }

  /**
   * deletes apps that have previously been connected.
   * @param connectedApp
   * @return connected apps
   */
  public Completable delete(ConnectedApp connectedApp) {
    if (connectedApp.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(connectedAppDao.delete(connectedApp))
          .subscribeOn(Schedulers.io());
    }
  }
}