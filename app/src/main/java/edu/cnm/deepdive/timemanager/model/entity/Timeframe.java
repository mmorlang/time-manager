package edu.cnm.deepdive.timemanager.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import javax.xml.transform.Source;

@Entity(
    foreignKeys = @ForeignKey(
        entity = ConnectedApp
            .class,
        parentColumns = "connected_app_id",
        childColumns = "connected_app_id"
    )
)


public class Timeframe {

  @PrimaryKey
  @ColumnInfo(name = "timeframe_id")
  private Long id;


  @ColumnInfo(name = "pre_set_time")
  private long preSetTime;

  @ColumnInfo(name = "connected_app_id", index = true)
  private long connected_app_id;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public long getPreSetTime() {
    return preSetTime;
  }

  public void setPreSetTime(long preSetTime) {
    this.preSetTime = preSetTime;
  }

  public long getConnected_app_id() {
    return connected_app_id;
  }

  public void setConnected_app_id(long connected_app_id) {
    this.connected_app_id = connected_app_id;
  }

}
