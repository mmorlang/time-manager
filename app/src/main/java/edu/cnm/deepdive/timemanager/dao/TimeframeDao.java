package edu.cnm.deepdive.timemanager.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;
import edu.cnm.deepdive.timemanager.model.entity.Timeframe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface TimeframeDao {


  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Timeframe timeframe);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Timeframe> timeframes);

  @Update
  Single<Integer> update(Timeframe... timeframes);

  @Delete
  Single<Integer> delete(Timeframe... timeframes);
}
