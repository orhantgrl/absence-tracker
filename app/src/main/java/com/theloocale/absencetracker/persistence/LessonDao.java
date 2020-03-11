package com.theloocale.absencetracker.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @author orhangrl
 * created on 3/11/2020.
 */

@Dao
public interface LessonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Lesson lesson);

    @Update
    void update(Lesson lesson);

    @Delete
    void delete(Lesson lesson);

    @Query("SELECT * FROM lesson_table")
    LiveData<List<Lesson>> fetchAllLessons();
}
