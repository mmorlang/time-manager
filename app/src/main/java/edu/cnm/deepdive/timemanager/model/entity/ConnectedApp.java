package edu.cnm.deepdive.timemanager.model.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ConnectedApp {

  @PrimaryKey
  @ColumnInfo(name = "connected_app_id")
  private Long id;

  @ColumnInfo(name = "app_name")
  private String appName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAppName() {
    return appName;
  }

  public void setAppName(String appName) {
    this.appName = appName;
  }
}
