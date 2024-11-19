package com.example.DoAnKTHP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.DoAnKTHP.models.LichLop;

import java.util.List;

@Repository
public interface LichLopRepository extends JpaRepository<LichLop, Long> {
    List<LichLop> findByLop(String lop);
}