package com.example.extend_exercise_1117;

import android.content.Context;
import androidx.room.*;

@Database(entities = {JobInWeek.class}, version = 1)
@TypeConverters({Converter.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract JobInWeekDao jobInWeekDao();

    public static final String DATABASE_NAME = "Room-database";

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            //Creates a RoomDatabase.Builder for an in memory database
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()// run in Main Thread
                    .build();
        }
        return INSTANCE;
    }
}
