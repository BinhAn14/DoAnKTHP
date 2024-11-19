package com.example.DoAnKTHP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.DoAnKTHP.models.LichPhongMay;

@Repository
public interface LichPhongMayRepository extends JpaRepository<LichPhongMay, Long> {
    @Query("SELECT p FROM LichPhongMay p WHERE p.trangthai = true")
    List<LichPhongMay> findPhongTrong();

}