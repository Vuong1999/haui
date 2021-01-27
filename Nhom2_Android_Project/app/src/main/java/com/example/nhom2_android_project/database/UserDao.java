package com.example.nhom2_android_project.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.nhom2_android_project.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User WHERE userName=:us AND passWord=:ps")
    List<User> getAllUs(String us, String ps);

    @Query("SELECT * FROM User")
    List<User> getAll();

    @Insert
    void insert(User... users);
}
