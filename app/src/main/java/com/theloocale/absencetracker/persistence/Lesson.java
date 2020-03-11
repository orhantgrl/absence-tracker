package com.theloocale.absencetracker.persistence;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * @author orhangrl
 * created on 3/11/2020.
 */

@Entity(tableName = "lesson_table")
public class Lesson {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "left_to_absence")
    private int leftToAbsence;

    public Lesson(@NonNull final String id, @NonNull final String name, final int leftToAbsence) {
        this.id = id;
        this.name = name;
        this.leftToAbsence = leftToAbsence;
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

    public int getLeftToAbsence() {
        return leftToAbsence;
    }

    public void setLeftToAbsence(int leftToAbsence) {
        this.leftToAbsence = leftToAbsence;
    }
}
