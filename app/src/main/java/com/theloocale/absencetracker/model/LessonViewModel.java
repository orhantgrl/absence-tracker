package com.theloocale.absencetracker.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.theloocale.absencetracker.persistence.Lesson;
import com.theloocale.absencetracker.persistence.LessonRepository;

import java.util.List;

/**
 * @author orhangrl
 * created on 3/11/2020.
 */
public class LessonViewModel extends AndroidViewModel {
    private LessonRepository lessonRepository;
    private LiveData<List<Lesson>> lessons;

    public LessonViewModel(@NonNull Application application) {
        super(application);
        lessonRepository = new LessonRepository(application);
        lessons = lessonRepository.getLessons();
    }

    public LiveData<List<Lesson>> getLessons() {
        return lessons;
    }

    public void insert(Lesson lesson) {
        lessonRepository.insert(lesson);
    }

    public void update(Lesson lesson) {
        lessonRepository.update(lesson);
    }

    public void delete(Lesson lesson) {
        lessonRepository.delete(lesson);
    }
}
