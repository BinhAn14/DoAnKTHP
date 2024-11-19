package com.example.DoAnKTHP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.DoAnKTHP.models.GiangVien;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, Long> {
    GiangVien findByTenGiangVien(String tenGiangVien);
}