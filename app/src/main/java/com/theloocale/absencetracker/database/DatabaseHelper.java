package com.theloocale.absencetracker.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.theloocale.absencetracker.model.Lesson;

import java.util.Objects;

public final class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "absence_tracker";
    private static final String TABLE_NAME = "lessons";
    private static final String COLUMN_LESSON_ID = "id";
    private static final String COLUMN_LESSON_NAME = "name";
    private static final String COLUMN_LESSON_RIGHT_TO_ABSENCE = "right_to_absence";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_LESSONS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                COLUMN_LESSON_ID + " TEXT NOT NULL UNIQUE, " +
                COLUMN_LESSON_NAME + " TEXT NOT NULL, " +
                COLUMN_LESSON_RIGHT_TO_ABSENCE + " INTEGER NOT NULL)";
        try {
            db.execSQL(CREATE_LESSONS_TABLE);
        } catch (SQLException e) {
            Log.e("SQL exception", Objects.requireNonNull(e.getMessage()));
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String DROP_LESSONS_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        Log.w("SQL version changed",
                "Upgraded" + oldVersion + " to " + newVersion +
                        " which will destroy all old data!");

        try {
            db.execSQL(DROP_LESSONS_TABLE);
        } catch (SQLException e) {
            Log.e("SQL exception", Objects.requireNonNull(e.getMessage()));
        } finally {
            onCreate(db);
        }
    }

    public final boolean insertLesson(final Lesson lesson) {
        try (SQLiteDatabase database = this.getReadableDatabase()) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_LESSON_ID, lesson.getId());
            values.put(COLUMN_LESSON_NAME, lesson.getName());
            values.put(COLUMN_LESSON_RIGHT_TO_ABSENCE, lesson.getRightToAbsence());
            database.insertOrThrow(TABLE_NAME, null, values);
        } catch (SQLException e) {
            Log.e("SQL exception", Objects.requireNonNull(e.getMessage()));
            return false;
        }
        return true;
    }
}
