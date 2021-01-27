package com.ktpm02.bt_11_10_2020;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SinhVienDao {
    @Query("SELECT * FROM SinhVien")
    List<SinhVien> getAll();

    @Query("SELECT Count(*) FROM SinhVien")
    int getCountItem();

    @Query("DELETE FROM SinhVien")
    void deleteAll();

    @Insert
    void insertSpinner(SinhVien... sinhViens);

    @Delete
    void deleteSpinner(SinhVien... sinhViens);

    @Update
    void update(SinhVien sinhVien);
}
