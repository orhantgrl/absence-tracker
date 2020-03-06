package com.theloocale.absencetracker;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.theloocale.absencetracker.database.DatabaseHelper;
import com.theloocale.absencetracker.model.Lesson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class DatabaseHelperTest {
    private Context context;

    @Before
    public void setup() {
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @Test
    public void testDatabaseInsert() {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        boolean condition = databaseHelper.insertLesson(
                new Lesson("ABC1001", "Math", 3)
        );
        assertTrue("Data insert failed", condition); // Passed
    }
}
