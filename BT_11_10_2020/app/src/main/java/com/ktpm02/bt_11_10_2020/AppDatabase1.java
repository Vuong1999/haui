package com.ktpm02.bt_11_10_2020;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SinhVien.class}, version = 1,exportSchema = false)
public abstract class AppDatabase1 extends RoomDatabase {
    private static AppDatabase1 INSTANCE;

    public abstract SinhVienDao spinnerDao();


    public static AppDatabase1 getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            //Creates a RoomDatabase.Builder for an in memory database
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase1.class, "Sin4dVieddn6DeBf13")
                    .allowMainThreadQueries()// run in Main Thread
                    .build();
        }
        return INSTANCE;
    }
}
