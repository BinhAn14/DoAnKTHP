package com.example.DoAnKTHP.models;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "lich_giang_vien")
public class LichGiangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ca;
    private int thu;

    @Column(name = "ngay", nullable = false)
    private LocalDate ngay;
    @ManyToOne(cascade = CascadeType.ALL) // Sử dụng CascadeType.ALL để xóa bản ghi cũ khi cập nhật
    @JoinColumn(name = "giangvien_id")
    private GiangVien giangVien;
    
    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "phong_id")
    private PhongHoc phong;
    
    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "hoc_phan_id")
    private HocPhan hocPhan;
    
    @ManyToOne(cascade = CascadeType.ALL) 
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

    public PhongHoc getPhong() {
        return phong;
    }

    public void setPhong(PhongHoc phong) {
        this.phong = phong;
    }

    public HocPhan getHocPhan() {
        return hocPhan;
    }

    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }

    public LopHoc getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(LopHoc lopHoc) {
        this.lopHoc = lopHoc;
    }
}
