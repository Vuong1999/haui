package com.example.vuducvuong_2017604374_test2;

import androidx.room.*;

import java.util.List;

@Dao
public interface SinhVienDao {
    @Query("SELECT * FROM SinhVien")
    List<SinhVien> getAll();

    @Query("SELECT * FROM SinhVien WHERE MaSv LIKE :MaSv")
    SinhVien getUserByName(String MaSv);

    @Insert
    void insertSinhVien(SinhVien... sinhViens);

    @Delete
    void deleteSinhVien(SinhVien... sinhViens);

    @Update
    void updateSinhVien(SinhVien... sinhViens);
}

