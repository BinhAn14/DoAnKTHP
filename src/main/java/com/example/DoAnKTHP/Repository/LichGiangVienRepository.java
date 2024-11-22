package com.example.DoAnKTHP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DoAnKTHP.models.LichGiangVien;

import java.util.List;

@Repository
public interface LichGiangVienRepository extends JpaRepository<LichGiangVien, Long> {
    List<LichGiangVien> findByGiangVienId(Long giangVienId);
    
}
