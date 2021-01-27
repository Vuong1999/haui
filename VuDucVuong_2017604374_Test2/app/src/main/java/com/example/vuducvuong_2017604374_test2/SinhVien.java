package com.example.vuducvuong_2017604374_test2;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SinhVien {
    @PrimaryKey
    @NonNull
    private String MaSv;

    @ColumnInfo
    private String TenSv;

    @ColumnInfo
    private String DiemTB;

    public SinhVien(String MaSv, String TenSv, String DiemTB) {
        this.MaSv = MaSv;
        this.TenSv = TenSv;
        this.DiemTB = DiemTB;
    }
    @NonNull
    public String getMaSv() {
        return MaSv;
    }

    public void setMaSv(@NonNull String maSv) {
        MaSv = maSv;
    }

    public String getTenSv() {
        return TenSv;
    }

    public void setTenSv(String tenSv) {
        TenSv = tenSv;
    }

    public String getDiemTB() {
        return DiemTB;
    }

    public void setDiemTB(String diemTB) {
        DiemTB = diemTB;
    }

    @Override
    public String toString() {
        return this.MaSv+" "+ this.TenSv + " " + this.DiemTB;
    }

}