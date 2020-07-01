package edu.cnm.deepdive.timemanager.service;


import android.app.Application;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import edu.cnm.deepdive.timemanager.dao.ConnectedAppDao;
import edu.cnm.deepdive.timemanager.dao.NotificationDao;
import edu.cnm.deepdive.timemanager.dao.TimeframeDao;
import edu.cnm.deepdive.timemanager.model.entity.ConnectedApp;
import edu.cnm.deepdive.timemanager.model.entity.Notification;
import edu.cnm.deepdive.timemanager.model.entity.Timeframe;

@androidx.room.Database(
    entities = {ConnectedApp.class, Timeframe.class, Notification.class},
    version = 1,
    exportSchema = true
)
public abstract class TimeManagerDatabase extends RoomDatabase {

  private static final String DB_NAME = "time_manager_database";


  private static Application context;

  public static void setContext(Application context) {
    TimeManagerDatabase.context = context;
  }

  public abstract NotificationDao getNotificationDao();

  public abstract TimeframeDao getTimeframeDao();

  public abstract ConnectedAppDao getConnectedAppDao();

  public static TimeManagerDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final TimeManagerDatabase INSTANCE =
        Room.databaseBuilder(context, TimeManagerDatabase.class, DB_NAME)
            .build();
  }
}
