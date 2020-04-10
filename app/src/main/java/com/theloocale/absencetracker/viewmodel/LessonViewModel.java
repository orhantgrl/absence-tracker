package com.theloocale.absencetracker.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.theloocale.absencetracker.persistence.Lesson;
import com.theloocale.absencetracker.persistence.LessonRepository;
import com.theloocale.absencetracker.persistence.LessonWithAbsences;

import java.util.List;

/**
 * @author orhangrl
 * created on 3/11/2020.
 */

public class LessonViewModel extends AndroidViewModel {
    private LessonRepository lessonRepository;
    private LiveData<List<LessonWithAbsences>> lessons;

    public LessonViewModel(@NonNull Application application) {
        super(application);
        lessonRepository = new LessonRepository(application);
        lessons = lessonRepository.getLessons();
    }

    public LiveData<List<LessonWithAbsences>> getLessons() {
        return lessons;
    }

    public void insertLessonWithAbsences(Lesson lesson) {
        lessonRepository.insertLessonWithAbsences(lesson);
    }

    public void insertLesson(Lesson lesson) {
        lessonRepository.insertLesson(lesson);
    }

    public void updateLesson(Lesson lesson) {
        lessonRepository.updateLesson(lesson);
    }

    public void deleteLesson(Lesson lesson) {
        lessonRepository.deleteLesson(lesson);
    }

    public void deleteAllLessons() {
        lessonRepository.deleteAllLessons();
    }
}
