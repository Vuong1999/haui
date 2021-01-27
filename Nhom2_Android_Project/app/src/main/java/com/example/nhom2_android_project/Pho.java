package com.example.nhom2_android_project;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pho {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private int ban;

    @ColumnInfo
    private String mon;

    @ColumnInfo
    private int soluong;

    @ColumnInfo
    private String sothich;

    @ColumnInfo
    private String km;

    public Pho() {
    }

    public Pho(int ban, String mon, int soluong, String sothich, String km) {
        this.ban = ban;
        this.mon = mon;
        this.soluong = soluong;
        this.sothich = sothich;
        this.km = km;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBan() {
        return ban;
    }

    public void setBan(int ban) {
        this.ban = ban;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getSothich() {
        return sothich;
    }

    public void setSothich(String sothich) {
        this.sothich = sothich;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }


}
