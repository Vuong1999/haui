package com.example.vuducvuong_2017604374_test;

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

    @Query("DELETE FROM SinhVien")
    void deleteAll();

    @Insert
    void insertSpinner(SinhVien... sinhViens);

    @Delete
    void deleteSpinner(SinhVien... sinhViens);

    @Update
    void update(SinhVien sinhVien);
}
