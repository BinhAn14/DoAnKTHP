package com.example.DoAnKTHP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DoAnKTHP.models.LopHoc;

import java.util.Optional;

@Repository
public interface LopHocRepository extends JpaRepository<LopHoc, Long> {
    Optional<LopHoc> findByTenLop(String tenLop);
}
