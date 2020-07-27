package edu.cnm.deepdive.timemanager.service;


import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.timemanager.model.dao.ConnectedAppDao;
import edu.cnm.deepdive.timemanager.model.dao.NotificationDao;
import edu.cnm.deepdive.timemanager.model.dao.TimeframeDao;
import edu.cnm.deepdive.timemanager.model.entity.ConnectedApp;
import edu.cnm.deepdive.timemanager.model.entity.Notification;
import edu.cnm.deepdive.timemanager.model.entity.Timeframe;
import edu.cnm.deepdive.timemanager.service.TimeManagerDatabase.Converters;
import io.reactivex.schedulers.Schedulers;
import java.time.LocalTime;
import java.util.Date;

@androidx.room.Database(
    entities = {ConnectedApp.class, Timeframe.class, Notification.class},
    version = 1,
    exportSchema = true
)

/**
 * Converts a lot of needed data into usable data.
 */
@TypeConverters({Converters.class})
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
            .addCallback(new Callback(context))
            .build();
  }


  private static class Callback extends RoomDatabase.Callback {

    private final Context context;

    private Callback(Context context) {
      this.context = context;
    }

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      TimeManagerDatabase database = TimeManagerDatabase.getInstance();
      ConnectedAppDao appDao = database.getConnectedAppDao();
      TimeframeDao timeframeDao = database.getTimeframeDao();
      NotificationDao notificationDao = database.getNotificationDao();
      ConnectedApp app = new ConnectedApp();
      app.setAppName("Instagram");
      appDao.insert(app)
          .subscribeOn(Schedulers.io())
          .flatMap((id) -> {
            Timeframe timeframe = new Timeframe();
            timeframe.setConnectedAppId(id);
            timeframe.setStart(LocalTime.of(8,0));
            timeframe.setEnd(LocalTime.of(12,0));
            Timeframe timeframe2 = new Timeframe();
            timeframe2.setConnectedAppId(id);
            timeframe2.setStart(LocalTime.of(13,0));
            timeframe2.setEnd(LocalTime.of(17,0));
            return timeframeDao.insert(timeframe, timeframe2);
          })
          .subscribe();
    }
  }


  /**
   * converts data
   */
  public static class Converters {

    /**
     * converts date into a long
     * @param value
     * @return long
     */
    @TypeConverter
    public static Long dateToLong(Date value) {
      return  (value != null) ? value.getTime() : null;
    }

    /**
     * converts long to date
     * @param value
     * @return date
     */
    @TypeConverter
    public static  Date longToDate(Long value) {
      return  (value != null) ? new Date(value) : null;
    }

    /**
     * converts local time to an integer
     * @param value
     * @return integer
     */
    @TypeConverter
    public static Integer localTimeToInteger(LocalTime value) {
      return (value != null) ? value.toSecondOfDay() : null;
    }

    /**
     * converts integer to local time
     * @param value
     * @return local time
     */
    @TypeConverter
    public static LocalTime integerToLocalTime(Integer value) {
      return  (value != null) ? LocalTime.ofSecondOfDay(value) : null;
    }
  }
}
