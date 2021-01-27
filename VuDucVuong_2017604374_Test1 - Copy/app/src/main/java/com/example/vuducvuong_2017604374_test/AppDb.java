package com.example.vuducvuong_2017604374_test;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SinhVien.class}, version = 1,exportSchema = false)
public abstract class AppDb extends RoomDatabase {
    private static AppDb INSTANCE;

    public abstract SinhVienDao spinner();


    public static AppDb saveDb(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDb.class, "SinhvienDb")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
