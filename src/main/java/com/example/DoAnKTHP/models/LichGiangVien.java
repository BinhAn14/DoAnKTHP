package com.example.DoAnKTHP.models;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "lich_giang_vien")
public class LichGiangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "giangvien_id")
    private GiangVien giangVien;

    private int ca;
    private int thu;
    @Column(name = "ngay", nullable = false)
    private LocalDate ngay;

    @ManyToOne
    @JoinColumn(name = "phong_id")
    private PhongHoc phong;

    @ManyToOne
    @JoinColumn(name = "hoc_phan_id")
    private HocPhan hocPhan;

    @ManyToOne
    @JoinColumn(name = "lop_hoc_id")
    private LopHoc lopHoc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public LocalDate getNgay() {
        return ngay;
    }

    public void setNgay(LocalDate ngay) {
        this.ngay = ngay;
    }
}   