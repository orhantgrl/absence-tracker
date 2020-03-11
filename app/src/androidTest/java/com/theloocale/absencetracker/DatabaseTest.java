package com.theloocale.absencetracker;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.theloocale.absencetracker.database.LessonRoomDatabase;
import com.theloocale.absencetracker.persistence.Lesson;
import com.theloocale.absencetracker.persistence.LessonDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author orhangrl
 * created on 3/11/2020.
 */

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    private LessonDao lessonDao;
    private LessonRoomDatabase lessonRoomDatabase;

    @Before
    public void createDatabase() {
        Context context = ApplicationProvider.getApplicationContext();
        lessonRoomDatabase = LessonRoomDatabase.getInstance(context);
        lessonDao = lessonRoomDatabase.lessonDao();
    }

    @After
    public void closeDatabase() throws IOException {
        lessonRoomDatabase.close();
    }

    @Test
    public void insertLesson() {
        Lesson lesson = new Lesson("A180", "Math", 4);
        lessonDao.insert(lesson);
        List<Lesson> lessons = lessonDao.fetchAllLessons();
        assertThat(lessons.get(0).getId(), equalTo(lesson.getId())); // Passed
    }
}
