package edu.cnm.deepdive.timemanager.service;


import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.timemanager.dao.TimeframeDao;
import edu.cnm.deepdive.timemanager.model.entity.ConnectedApp;
import edu.cnm.deepdive.timemanager.model.entity.Notification;
import edu.cnm.deepdive.timemanager.model.entity.Timeframe;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class TimeframeRepository {

  private final Context context;
  private final TimeframeDao timeframeDao;
  private final TimeManagerDatabase database;


  public TimeframeRepository(Context context) {
    this.context = context;
    database = TimeManagerDatabase.getInstance();
    timeframeDao = database.getTimeframeDao();
  }

  public LiveData<List<Timeframe>> getAll() {
    return timeframeDao.selectAll();
  }

  public Single<Timeframe> get(long id) {
    return timeframeDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(Timeframe timeframe) {
    if (timeframe.getId() == 0) {
      return Completable.fromSingle(timeframeDao.insert(timeframe))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(timeframeDao.update(timeframe))
          .subscribeOn(Schedulers.io());
    }
  }

  public Completable delete(Timeframe timeframe) {
    if (timeframe.getId() == 0) {
      return Completable.fromAction(() -> {
      })
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(timeframeDao.delete(timeframe))
          .subscribeOn(Schedulers.io());
    }
  }
}