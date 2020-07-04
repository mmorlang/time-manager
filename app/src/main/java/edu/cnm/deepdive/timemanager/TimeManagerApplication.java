package edu.cnm.deepdive.timemanager;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.timemanager.service.TimeManagerDatabase;
import io.reactivex.schedulers.Schedulers;

public class TimeManagerApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    TimeManagerDatabase.setContext(this);
    TimeManagerDatabase database = TimeManagerDatabase.getInstance();
    database.getTimeframeDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
    Stetho.initializeWithDefaults(this);
  }

}

