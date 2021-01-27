package com.example.vuducvuong_2017604374_test;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SinhVien {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo
    private String maSV;

    @ColumnInfo
    private String lop;

    @ColumnInfo
    private String tenSinhVien;

    @ColumnInfo
    private String  diemTB;

    public SinhVien(String maSV, String lop, String tenSinhVien, String diemTB) {
        this.maSV = maSV;
        this.lop = lop;
        this.tenSinhVien = tenSinhVien;
        this.diemTB = diemTB;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenNhanVien) {
        this.tenSinhVien = tenNhanVien;
    }

    public String getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(String diemTB) {
        this.diemTB = diemTB;
    }
}
