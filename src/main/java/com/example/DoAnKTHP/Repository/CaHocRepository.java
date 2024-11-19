package com.example.DoAnKTHP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DoAnKTHP.models.CaHoc;

import java.util.List;

@Repository
public interface CaHocRepository extends JpaRepository<CaHoc, Long> {
    List<CaHoc> findByThoiGianContains(String ngay);

    List<CaHoc> findByGiangVienIdAndThoiGianContains(Long giangVienId, String ngay);

    List<CaHoc> findByLopIdAndThoiGianContains(Long lopId, String ngay);

    List<CaHoc> findByPhongIdAndThoiGianContains(Long phongId, String ngay);
}
