package com.example.DoAnKTHP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DoAnKTHP.models.PhongHoc;

import java.util.Optional;

@Repository
public interface PhongHocRepository extends JpaRepository<PhongHoc, Long> {
    Optional<PhongHoc> findByTenPhong(String tenPhong);
}
