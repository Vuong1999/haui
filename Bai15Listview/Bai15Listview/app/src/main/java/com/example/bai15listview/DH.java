package com.example.bai15listview;

public class DH {
    private String ma;
    private String ten;
    private String gt;
    private String loai;
    private String km;

    public DH(String ma, String ten, String gt, String loai, String km) {
        this.ma = ma;
        this.ten = ten;
        this.gt = gt;
        this.loai = loai;
        this.km = km;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return ma + "-" + ten + "-" +gt + "-" +loai + "-" +km ;
    }
}
