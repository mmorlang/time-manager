package edu.cnm.deepdive.timemanager.service;

import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.timemanager.model.entity.ConnectedApp;
import edu.cnm.deepdive.timemanager.model.entity.Notification;
import edu.cnm.deepdive.timemanager.model.entity.Timeframe;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;

public class ConnectedAppRepository {


  public LiveData<List<ConnectedApp>> getAll() {
    return null;
  }

  public Single<ConnectedApp> get(String id) {
    return null;
  }

  public Completable save(Notification notification) {
    return null;
  }

  public Completable delete(Notification notification) {
    return null;
  }
}
