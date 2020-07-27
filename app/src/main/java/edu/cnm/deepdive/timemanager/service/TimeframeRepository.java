package edu.cnm.deepdive.timemanager.service;


import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.timemanager.model.dao.TimeframeDao;
import edu.cnm.deepdive.timemanager.model.entity.Timeframe;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * this class handles all the updates, insertions, deletions and pulls for the Timeframes.
 */
public class TimeframeRepository {

  private final Context context;
  private final TimeframeDao timeframeDao;
  private final TimeManagerDatabase database;

  /**
   * gets the contect from the TimframeDao.
   * @param context
   */
  public TimeframeRepository(Context context) {
    this.context = context;
    database = TimeManagerDatabase.getInstance();
    timeframeDao = database.getTimeframeDao();
  }

  /**
   * gets a timeframe.
   * @return
   */
  public LiveData<List<Timeframe>> getAll() {
    return timeframeDao.selectAll();
  }

  /**
   * gets all timeframes by their id.
   * @param id
   * @return id
   */
  public Single<Timeframe> get(long id) {
    return timeframeDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  /**
   * this saves a new or edited timeframe.
   * @param timeframe
   * @return timeframe
   */
  public Completable save(Timeframe timeframe) {
    if (timeframe.getId() == 0) {
      return Completable.fromSingle(timeframeDao.insert(timeframe))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(timeframeDao.update(timeframe))
          .subscribeOn(Schedulers.io());
    }
  }

  /**
   * this deletes a timeframe.
   * @param timeframe
   * @return timeframe
   */
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