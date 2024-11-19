package com.example.DoAnKTHP.models;

public class LichDeXuat {
    private String phong;
    private int thu;
    private int ca;
    private String tenLop;
    private Long giangVienId;

    public LichDeXuat() {
    }

    public LichDeXuat(String phong, int thu, int ca, String tenLop, Long giangVienId) {
        this.phong = phong;
        this.thu = thu;
        this.ca = ca;
        this.tenLop = tenLop;
        this.giangVienId = giangVienId;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public Long getGiangVienId() {
        return giangVienId;
    }

    public void setGiangVienId(Long giangVienId) {
        this.giangVienId = giangVienId;
    }

}
