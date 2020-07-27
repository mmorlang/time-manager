package edu.cnm.deepdive.timemanager.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import javax.xml.transform.Source;

/**
 * This Notification Entity Class declares all of its own attributes along with attributes that are
 * being joined together as foreign keys.
 */

@Entity(
    foreignKeys = @ForeignKey(
        entity = Timeframe.class,
        parentColumns = "timeframe_id",
        childColumns = "timeframe_id"
    )
)

public class Notification {

  /**
   * This Column declares the notificationId attribute and its conditions.
   */
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "notification_id")
  private long id;

  /**
   * This Column declares the summary attribute and its conditions.
   */
  @NonNull
  @ColumnInfo(index = true)
  private String summary = "";

  /**
   * This Column declares the timframeId attribute and its conditions.
   */
  @ColumnInfo(name = "timeframe_id", index = true)
  private long timeframeId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getSummary() {
    return summary;
  }

  public void setSummary(@NonNull String summary) {
    this.summary = summary;
  }

  public long getTimeframeId() {
    return timeframeId;
  }

  public void setTimeframeId(long timeframeId) {
    this.timeframeId = timeframeId;
  }
}
