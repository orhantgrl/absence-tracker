package com.theloocale.absencetracker.persistence;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.theloocale.absencetracker.database.LessonDatabase;

import java.util.List;

/**
 * @author orhangrl
 * created on 3/11/2020.
 */
public class LessonRepository {
    private LessonDao lessonDao;
    private LiveData<List<Lesson>> lessons;

    public LessonRepository(Application application) {
        LessonDatabase lessonDatabase = LessonDatabase.getInstance(application);
        lessonDao = lessonDatabase.lessonDao();
        lessons = lessonDao.fetchAllLessons();
    }

    public LiveData<List<Lesson>> getLessons() {
        return lessons;
    }

    public void insert(Lesson lesson) {
        LessonDatabase.EXECUTOR_SERVICE.execute(() -> {
            lessonDao.insert(lesson);
        });
    }

    public void update(Lesson lesson) {
        LessonDatabase.EXECUTOR_SERVICE.execute(() -> {
            lessonDao.update(lesson);
        });
    }

    public void delete(Lesson lesson) {
        LessonDatabase.EXECUTOR_SERVICE.execute(() -> {
            lessonDao.delete(lesson);
        });
    }
}
