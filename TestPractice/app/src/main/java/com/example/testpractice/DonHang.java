package com.example.testpractice;

public class DonHang {
    private String MaDH;
    private String TenDH;
    private String LoaiDH;
    private String LoaiDay;
    private String KhuyenMai;

    public DonHang(String MaDH, String TenDH, String LoaiDH, String LoaiDay, String KhuyenMai) {
        this.MaDH = MaDH;
        this.TenDH = TenDH;
        this.LoaiDH = LoaiDH;
        this.LoaiDay = LoaiDay;
        this.KhuyenMai = KhuyenMai;
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String maDH) {
        MaDH = maDH;
    }

    public String getTenDH() {
        return TenDH;
    }

    public void setTenDH(String tenDH) {
        TenDH = tenDH;
    }

    public String getLoaiDH() {
        return LoaiDH;
    }

    public void setLoaiDH(String loaiDH) {
        LoaiDH = loaiDH;
    }

    public String getLoaiDay() {
        return LoaiDay;
    }

    public void setLoaiDay(String loaiDay) {
        LoaiDay = loaiDay;
    }

    public String getKhuyenMai() {
        return KhuyenMai;
    }
    public void setKhuyenMai(String KhuyenMai) {
        KhuyenMai = KhuyenMai;
    }

    @Override
    public String toString(){
        return (this.MaDH + " - " + this.TenDH + " - " + this.LoaiDH + " - " + this.LoaiDay + " - " + this.KhuyenMai);
    }
}
