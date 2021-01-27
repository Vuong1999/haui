package com.example.nhom2_android_project.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.nhom2_android_project.Pho;

import java.util.List;

@Dao
public interface PhoDao {
    @Query("SELECT * FROM Pho")
    List<Pho> getAll();

    @Query("DELETE FROM Pho")
    void deleteAll();

    @Insert
    void insert(Pho... pho);

    @Delete
    void delete(Pho... pho);

    @Update
    void update(Pho pho);
}
