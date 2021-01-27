package com.example.vuducvuong_ktpm2;

public class KhaiBao {
    private String cmnd;
    private String vung;
    private String tiepxuc;
    private String dauhieu;

    public KhaiBao(String cmnd, String vung, String tiepxuc, String dauhieu) {
        this.cmnd = cmnd;
        this.vung = vung;
        this.tiepxuc = tiepxuc;
        this.dauhieu = dauhieu;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getVung() {
        return vung;
    }

    public void setVung(String vung) {
        this.vung = vung;
    }

    public String getTiepxuc() {
        return tiepxuc;
    }

    public void setTiepxuc(String tiepxuc) {
        this.tiepxuc = tiepxuc;
    }

    public String getDauhieu() {
        return dauhieu;
    }

    public void setDauhieu(String dauhieu) {
        this.dauhieu = dauhieu;
    }

    @Override
    public String toString(){
        return ("CMND: " + this.cmnd + " | Đi từ vùng COVID: " + this.vung + " | Tiếp xúc người mắc: " + this.tiepxuc + " | Dấu hiệu: " + this.dauhieu );
    }

}
