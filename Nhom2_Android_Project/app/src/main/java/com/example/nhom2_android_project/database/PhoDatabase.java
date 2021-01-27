package com.example.nhom2_android_project.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.nhom2_android_project.Pho;
import com.example.nhom2_android_project.User;

@Database(entities = {Pho.class, User.class}, version = 3)
public abstract class PhoDatabase extends RoomDatabase {
    private static final String DATABASE_NAME="quanpho.db";
    private static PhoDatabase instance;

    public static synchronized PhoDatabase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(), PhoDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract PhoDao phoDao();
    public abstract UserDao userDao();
}
