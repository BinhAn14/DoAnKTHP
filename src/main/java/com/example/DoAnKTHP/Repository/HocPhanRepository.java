package com.example.DoAnKTHP.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.DoAnKTHP.models.HocPhan;

@Repository
public interface HocPhanRepository extends JpaRepository<HocPhan, Long> {
    List<HocPhan> findByTenHocPhanContaining(String tenHocPhan);
}
