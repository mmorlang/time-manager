package edu.cnm.deepdive.timemanager.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.timemanager.model.entity.Timeframe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;
/**
 * This Dao contains Actions that are allowed for your app. It also Queries that pull and sort your
 * data.
 */
@Dao
public interface TimeframeDao {


  /**
   * this insert method allows a new timeframe to be inserted.
   *
   * @param timeframe
   * @return timeframe
   */
  @Insert
  Single<Long> insert(Timeframe timeframe);

  /**
   * this insert method allows a new timeframes to be inserted.
   *
   * @param timeframes
   * @return timeframes
   */
  @Insert
  Single<List<Long>> insert(Collection<Timeframe> timeframes);

  /**
   * this insert method allows a new timeframes to be inserted.
   *
   * @param timeframes
   * @return timeframe
   */
  @Insert
  Single<List<Long>> insert(Timeframe... timeframes);

  /**
   * this insert method allows timeframes to be updated.
   *
   * @param timeframes
   * @return timeframe
   */
  @Update
  Single<Integer> update(Timeframe... timeframes);

  /**
   * this insert method allows timeframes to be deleted.
   *
   * @param timeframes
   * @return timeframe
   */
  @Delete
  Single<Integer> delete(Timeframe... timeframes);

  /**
   * this Query gathers all timeframes and orders the ny their ids.
   * @returnallTimframesById
   */
  @Query("SELECT * FROM Timeframe ORDER BY timeframe_id")
  LiveData<List<Timeframe>> selectAll();

  /**
   * this Query selets all timiframes and returns them by their id.
   * @param timeframeId
   * @return timeframeId
   */
  @Query( "SELECT * FROM Timeframe WHERE timeframe_id = :timeframeId")
  Single<Timeframe> selectById(long timeframeId);
}
