package com.theloocale.absencetracker.persistence;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

/**
 * @author orhangrl
 * created on 3/11/2020.
 */

@Entity(tableName = "lesson_table")
public class Lesson {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "lessonId", index = true)
    private String id;

    @NonNull
    @ColumnInfo(name = "lessonName")
    private String name;

    @NonNull
    @ColumnInfo(name = "dateOfAdded")
    private String date;

    @NonNull
    @ColumnInfo(name = "lessonRightToAbsenteeism")
    private Integer rightToAbsenteeism;

    @Ignore
    private List<Absence> absences;

    public Lesson(@NonNull String id, @NonNull String name, @NonNull String date, @NonNull Integer rightToAbsenteeism) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.rightToAbsenteeism = rightToAbsenteeism;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }

    @NonNull
    public Integer getRightToAbsenteeism() {
        return rightToAbsenteeism;
    }

    public void setRightToAbsenteeism(@NonNull Integer rightToAbsenteeism) {
        this.rightToAbsenteeism = rightToAbsenteeism;
    }

    public List<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(List<Absence> absences) {
        this.absences = absences;
    }
}
