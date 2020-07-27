package edu.cnm.deepdive.timemanager.model.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
/**
 * This ConnectedApp Entity Class declares all of its own attributes along
 * with attributes that are being joined together as foreign keys.
 */
@Entity
public class ConnectedApp {

  /**
   * This Column declares the connectedAppId attribute and its conditions.
   */
  @PrimaryKey
  @ColumnInfo(name = "connected_app_id")
  private Long id;

  /**
   * This Column declares the appName attribute and its conditions.
   */
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
