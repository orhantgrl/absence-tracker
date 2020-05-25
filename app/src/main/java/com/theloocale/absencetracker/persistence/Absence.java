package com.theloocale.absencetracker.persistence;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

/**
 * @author orhangrl
 * created on 3/17/2020.
 */

@Entity(tableName = "absence_table",
        indices = {@Index(value = {"absenceId"}, unique = true)},
        foreignKeys = {@ForeignKey(entity = Lesson.class, parentColumns = "lessonId",
                childColumns = "absenceLessonId", onDelete = CASCADE)}
)
public class Absence {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "absenceId")
    private String absenceId;

    @NonNull
    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "absenceLessonId", index = true)
    private String lessonId;

    public Absence(@NonNull String date) {
        this.date = date;
    }

    @NonNull
    public String getAbsenceId() {
        return absenceId;
    }

    public void setAbsenceId(@NonNull String absenceId) {
        this.absenceId = absenceId;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }
}
