package com.example.vuducvuong_2017604374_test2;

import android.content.Context;
import androidx.room.*;
@Database(entities = {SinhVien.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract SinhVienDao SinhVienDao();

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