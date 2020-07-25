package edu.cnm.deepdive.timemanager.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.time.LocalTime;

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


  private LocalTime start;

  private LocalTime end;

  @ColumnInfo(name = "connected_app_id", index = true)
  private long connectedAppId;


  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public LocalTime getStart() {
    return start;
  }

  public void setStart(LocalTime start) {
    this.start = start;
  }

  public LocalTime getEnd() {
    return end;
  }

  public void setEnd(LocalTime end) {
    this.end = end;
  }

  public long getConnectedAppId() {
    return connectedAppId;
  }

  public void setConnectedAppId(long connectedAppId) {
    this.connectedAppId = connectedAppId;
  }

}
