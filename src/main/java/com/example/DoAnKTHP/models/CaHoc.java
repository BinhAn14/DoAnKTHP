package com.example.DoAnKTHP.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CaHoc")
public class CaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "thoi_gian", nullable = false, length = 19)
    private String thoiGian;

    @Column(name = "ten_lop_hoac_ten_lop_ghep", nullable = false, length = 100)
    private String tenLopHoacTenLopGhep;

    @ManyToOne
    @JoinColumn(name = "lop_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_LopHoc"))
    private LopHoc lop;

    @ManyToOne
    @JoinColumn(name = "phong_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_PhongHoc"))
    private PhongHoc phong;

    @ManyToOne
    @JoinColumn(name = "giang_vien_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_GiangVien"))
    private GiangVien giangVien;

    @ManyToOne
    @JoinColumn(name = "hoc_phan_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_HocPhan"))
    private HocPhan hocPhan;

    @Column(name = "created_at", nullable = false, length = 19)
    private String createdAt;

    @Column(name = "updated_at", length = 19)
    private String updatedAt;

    @Column(name = "created_by_user_id", nullable = false)
    private Long createdByUserId;

    @Column(name = "updated_by_user_id")
    private Long updatedByUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getTenLopHoacTenLopGhep() {
        return tenLopHoacTenLopGhep;
    }

    public void setTenLopHoacTenLopGhep(String tenLopHoacTenLopGhep) {
        this.tenLopHoacTenLopGhep = tenLopHoacTenLopGhep;
    }

    public LopHoc getLop() {
        return lop;
    }

    public void setLop(LopHoc lop) {
        this.lop = lop;
    }

    public PhongHoc getPhong() {
        return phong;
    }

    public void setPhong(PhongHoc phong) {
        this.phong = phong;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public HocPhan getHocPhan() {
        return hocPhan;
    }

    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Long getUpdatedByUserId() {
        return updatedByUserId;
    }

    public void setUpdatedByUserId(Long updatedByUserId) {
        this.updatedByUserId = updatedByUserId;
    }

}
