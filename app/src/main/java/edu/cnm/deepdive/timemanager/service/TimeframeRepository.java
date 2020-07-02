package edu.cnm.deepdive.timemanager.service;


import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.timemanager.model.entity.Timeframe;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;

public class TimeframeRepository {


  public LiveData<List<Timeframe>> getAll() {
    return null;
  }

  public Single<Timeframe> get(long id) {
    return null;
  }

  public Completable save(Timeframe timeframe) {
    return null;
  }

  public Completable delete(Timeframe timeframe) {
    return null;
  }


}