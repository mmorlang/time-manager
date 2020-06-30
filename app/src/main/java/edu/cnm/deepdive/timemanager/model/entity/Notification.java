package edu.cnm.deepdive.timemanager.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import javax.xml.transform.Source;

@Entity(
    foreignKeys = @ForeignKey(
        entity = Source.class,
        parentColumns = "timeframe_id",
        childColumns = "timeframe_id",
        onDelete = ForeignKey.SET_NULL
    )
)

public class Notification {


  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "notification_id")
  private long id;


  @ColumnInfo(name = "summary")
  private String text = "";


  @ColumnInfo(name = "timeframe_id", index = true)
  private long timeframe_id;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public long getTimeframe_id() {
    return timeframe_id;
  }

  public void setTimeframe_id(long timeframe_id) {
    this.timeframe_id = timeframe_id;
  }
}
