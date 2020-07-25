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

@Dao
public interface TimeframeDao {


  @Insert
  Single<Long> insert(Timeframe timeframe);

  @Insert
  Single<List<Long>> insert(Collection<Timeframe> timeframes);

  @Insert
  Single<List<Long>> insert(Timeframe... timeframes);

  @Update
  Single<Integer> update(Timeframe... timeframes);

  @Delete
  Single<Integer> delete(Timeframe... timeframes);

  @Query("SELECT * FROM Timeframe ORDER BY timeframe_id")
  LiveData<List<Timeframe>> selectAll();

  @Query( "SELECT * FROM Timeframe WHERE timeframe_id = :timeframeId")
  Single<Timeframe> selectById(long timeframeId);
}
