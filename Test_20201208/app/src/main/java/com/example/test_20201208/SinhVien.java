package com.example.test_20201208;

public class SinhVien {
    private String maSV;
    private String tenSV;
    private String diemTB;
    private  String lop;
    public SinhVien(){

    }

    public SinhVien(String maSV, String tenSV, String diemTB, String lop) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.diemTB = diemTB;
        this.lop = lop;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(String diemTB) {
        this.diemTB = diemTB;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    @Override
    public String toString() {
        return this.maSV+" "+this.tenSV+" "+this.lop;
    }
}
