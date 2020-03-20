package com.theloocale.absencetracker.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.theloocale.absencetracker.persistence.Absence;
import com.theloocale.absencetracker.persistence.Lesson;
import com.theloocale.absencetracker.persistence.LessonDao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author orhangrl
 * created on 3/11/2020.
 */

@Database(entities = {Lesson.class, Absence.class}, version = 6, exportSchema = false)
public abstract class LessonDatabase extends RoomDatabase {

    public abstract LessonDao lessonDao();

    private static volatile LessonDatabase instance;
    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService EXECUTOR_SERVICE =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static LessonDatabase getInstance(final Context context) {
        if (instance == null) {
            synchronized (LessonDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            LessonDatabase.class, "lesson_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(lessonCallback)
                            .build();
                }
            }
        }
        return instance;
    }

    private static RoomDatabase.Callback lessonCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            EXECUTOR_SERVICE.execute(() -> {
                LessonDao lessonDao = instance.lessonDao();
                List<Absence> absences = new ArrayList<>();
                Lesson lesson = new Lesson("B10001", "Math", 5);
                absences.add(new Absence("23/03/2020"));
                absences.add(new Absence("23/03/2021"));
                absences.add(new Absence("23/03/2022"));
                absences.add(new Absence("23/03/2023"));
                lesson.setAbsences(absences);
                lessonDao.insertLessonWithAbsences(lesson);
            });
        }
    };
}
